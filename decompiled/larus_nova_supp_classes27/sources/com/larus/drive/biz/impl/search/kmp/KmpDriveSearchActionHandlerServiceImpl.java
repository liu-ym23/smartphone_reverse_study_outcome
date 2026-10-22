package com.larus.drive.biz.impl.search.kmp;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.payload.DrivePayload;
import com.bytedance.flow.search.kmp.api.model.payload.RecentDrivePayload;
import com.bytedance.flow.search.kmp.api.spi.SearchActionHandlerService;
import com.bytedance.flow.search.kmp.api.spi.SearchDriveItem;
import com.larus.common.apphost.AppHost;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.activity.DriveFolderActivity;
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.drive.sdk.api.IDriveSdkServiceV2;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.meta.PreviewFromPage;
import com.larus.platform.exp.i;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0017\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\r\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u0013*\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\n\u0010 \u001a\u0004\u0018\u00010!H\u0002R#\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006#"}, d2 = {"Lcom/larus/drive/biz/impl/search/kmp/KmpDriveSearchActionHandlerServiceImpl;", "Lcom/bytedance/flow/search/kmp/api/spi/SearchActionHandlerService;", "<init>", "()V", "fileCanNotSupportPreview", "", "", "getFileCanNotSupportPreview", "()Ljava/util/List;", "fileCanNotSupportPreview$delegate", "Lkotlin/Lazy;", "onSearchItemClick", "", "data", "Lcom/bytedance/flow/search/kmp/api/model/FlowSearchData;", "handleDriveClick", "handleRecentDriveClick", "openDriveFile", "file", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "fromPage", "Lcom/larus/drive/sdk/api/meta/PreviewFromPage;", "createSearchMoveCallback", "com/larus/drive/biz/impl/search/kmp/KmpDriveSearchActionHandlerServiceImpl$createSearchMoveCallback$1", "()Lcom/larus/drive/biz/impl/search/kmp/KmpDriveSearchActionHandlerServiceImpl$createSearchMoveCallback$1;", "toDriveFileItem", "Lcom/bytedance/flow/search/kmp/api/spi/SearchDriveItem;", "fileTypeOverride", "Lcom/larus/drive/biz/api/model/DriveFileType;", "getDriveFileTypeByObjType", "objType", "", "getActivity", "Landroid/app/Activity;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpDriveSearchActionHandlerServiceImpl implements SearchActionHandlerService {
    public static final /* synthetic */ int c = 0;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    private final Activity getActivity() {
        return AppHost.a.a().getCurrentActivity();
    }

    public KmpDriveSearchActionHandlerServiceImpl() {
        this.b = LazyKt.lazy(new n79.a());
    }

    public final boolean V(FlowSearchData r13) {
        Intrinsics.checkNotNullParameter(r13, "data");
        if (Intrinsics.areEqual(r13.a, "drive") == false) goto L16;
        RecentDrivePayload r0 = r13.c;
        boolean r3 = r0 instanceof RecentDrivePayload;
        if (r3 == false) goto L16;
        if (r3 == false) goto L8;
        RecentDrivePayload r1 = r0;
    L9:
        if (r1 == null) goto L59;
        SearchDriveItem r14 = r1.o;
        if (r14 == null) goto L59;
        return u(k0(r14, null), PreviewFromPage.RECENT);
    L59:
        return false;
    L8:
        r1 = null;
    L16:
        if (Intrinsics.areEqual(r13.a, "drive") == false) goto L59;
        DrivePayload r15 = r13.c;
        if ((r15 instanceof DrivePayload) == false) goto L20;
        DrivePayload r16 = r15;
    L21:
        if (r16 == null) goto L59;
        DriveFileType.a r2 = DriveFileType.Companion;
        String r4 = r16.i;
        r2.getClass();
        String r5 = DriveFileType.a.b(r4).getValue();
        SearchDriveItem r6 = r16.w;
        if (r6 != null) goto L27;
        String r7 = r16.i;
        String r8 = r16.o;
        String r9 = r16.p;
        r6 = new SearchDriveItem(r7, r8, r16.r, r9, r16.v, r5, r16.u, 1636);
    L27:
        if (TextUtils.isEmpty(r5) == true) goto L31;
        if (TextUtils.equals(r5, DriveFileType.UNKNOWN.getValue()) == true) goto L31;
    L67:
        return u(k0(r6, null), PreviewFromPage.UNKNOWN);
    L31:
        if (Intrinsics.areEqual(r16.q, "DOC") == false) goto L67;
        String r17 = r16.s;
        switch(r17.hashCode()) {
            case -1846317854: goto L55;
            case -581022908: goto L51;
            case 67864: goto L47;
            case 2103872: goto L44;
            case 78865727: goto L40;
            case 615206855: goto L36;
            default: goto L67;
        };
    L36:
        if (r17.equals("BITABLE") == false) goto L67;
        return u(k0(r6, DriveFileType.BITABLE), PreviewFromPage.UNKNOWN);
    L40:
        if (r17.equals("SHEET") == false) goto L67;
        return u(k0(r6, DriveFileType.AI_SHEET), PreviewFromPage.UNKNOWN);
    L44:
        if (r17.equals("DOCX") == false) goto L67;
    L64:
        return u(k0(r6, DriveFileType.AI_DOC), PreviewFromPage.UNKNOWN);
    L47:
        if (r17.equals("DOC") == true) goto L64;
    L51:
        if (r17.equals("MINDNOTE") == false) goto L67;
        return u(k0(r6, DriveFileType.MINDNOTE), PreviewFromPage.UNKNOWN);
    L55:
        if (r17.equals("SLIDES") == false) goto L67;
        return u(k0(r6, DriveFileType.AI_SLIDES), PreviewFromPage.UNKNOWN);
    L20:
        r16 = null;
        goto L21
    }

    public static DriveFileItem k0(SearchDriveItem r16, DriveFileType r17) {
        String r1 = r16.a;
        String r2 = r16.b;
        String r3 = r16.c;
        int r4 = r16.d;
        String r5 = r16.e;
        long r6 = r16.f;
        long r8 = r16.g;
        String r11 = r16.h;
        if (r17 != null) goto L24;
        DriveFileType.a r12 = DriveFileType.Companion;
        String r13 = r16.i;
        r12.getClass();
        DriveFileType r14 = DriveFileType.a.a(r13);
        if (r14 != null) goto L26;
        int r15 = r16.d;
        if (r15 != 3) goto L9;
        r14 = DriveFileType.AI_SHEET;
    L22:
        if (r14 != null) goto L26;
        r14 = DriveFileType.UNKNOWN;
        goto L26
    L9:
        if (r15 != 8) goto L11;
        r14 = DriveFileType.BITABLE;
        goto L22
    L11:
        if (r15 != 11) goto L13;
        r14 = DriveFileType.MINDNOTE;
        goto L22
    L13:
        if (r15 != 22) goto L15;
        r14 = DriveFileType.AI_DOC;
        goto L22
    L15:
        if (r15 == 30) goto L17;
        r14 = null;
        goto L22
    L17:
        r14 = DriveFileType.AI_SLIDES;
    L26:
        return new DriveFileItem(r1, r2, r3, r4, r5, r6, r8, 0, r11, r14, r16.j, r16.k);
    L24:
        r14 = r17;
        goto L26
    }

    public final boolean u(DriveFileItem r11, PreviewFromPage r12) {
        Context r1 = getActivity();
        if (r1 != null) goto L5;
        return false;
    L5:
        FLogger r2 = FLogger.a;
        r2.i("KmpDriveSearchActionHandler", "openDriveFile: " + r11.a + " (type: " + r11.j + ')');
        if (r11.j != DriveFileType.FOLDER) goto L8;
        int r13 = DriveFolderActivity.g;
        DriveFolderActivity.a.a(r1, r11.b, r11.c, r11.a, null);
        return true;
    L8:
        r2.d("KmpDriveSearchActionHandler", "openDriveFile: url=" + r11.e + ", objType=" + r11.d);
        if (i.a.a() == false) goto L14;
        if (IDriveSdkServiceV2.a.b(r1, r11, r12.getValue()) == true) goto L26;
        r2.i("KmpDriveSearchActionHandler", "open drive file preview failed, token=" + r11.b + ", type=" + r11.d);
        s.a.getClass();
        s.b(r1, 2131899914, false);
        return true;
    L26:
        return true;
    L14:
        if ((r1 instanceof LifecycleOwner) == false) goto L16;
        LifecycleOwner r3 = (LifecycleOwner) r1;
    L17:
        if (r3 == null) goto L24;
        LifecycleCoroutineScope r4 = LifecycleOwnerKt.getLifecycleScope(r3);
        if (r4 == null) goto L24;
        DriveSdkService.a.m(new z79.b(r1, r11, r4, r12, new n79.b(), 64), null);
        return true;
    L24:
        return false;
    L16:
        r3 = null;
        goto L17
    }
}
