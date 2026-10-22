package com.larus.drive.sdk.impl;

import com.bytedance.flow.search.kmp.api.spi.SearchDriveService;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.api.model.DriveListLoadType;
import com.larus.drive.sdk.api.IDriveSdkService;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/larus/drive/sdk/impl/KmpSearchDriveServiceImpl;", "Lcom/bytedance/flow/search/kmp/api/spi/SearchDriveService;", "<init>", "()V", "driveSdkService", "Lcom/larus/drive/sdk/api/IDriveSdkService;", "getDriveSdkService", "()Lcom/larus/drive/sdk/api/IDriveSdkService;", "driveSdkService$delegate", "Lkotlin/Lazy;", "requestRecentDriveFileList", "Lcom/bytedance/flow/search/kmp/api/spi/SearchDriveResult;", "length", "", "loadMoreLabel", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toKmpSearchDriveItem", "Lcom/bytedance/flow/search/kmp/api/spi/SearchDriveItem;", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "resolveFileTypeIconResId", "entityType", "fileType", "fileName", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpSearchDriveServiceImpl implements SearchDriveService {
    public final Lazy b;

    public KmpSearchDriveServiceImpl() {
        this.b = LazyKt.lazy(new v());
    }

    public final Object G2(String r12, Continuation r13) {
        IDriveSdkService r0 = (IDriveSdkService) this.b.getValue();
        if (r0 == null) goto L5;
        kotlinx.coroutines.j r8 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r13), 1);
        r8.C();
        IDriveSdkService.a.c(r0, DriveListLoadType.RECENT, null, false, 30, r12, new w(r8, this), 38);
        Object r14 = r8.B();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r13);
    L9:
        return r14;
    L5:
        return new zv5.i(null, null, false, false, 15);
    }

    public final int x0(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "entityType");
        Intrinsics.checkNotNullParameter(r3, "fileType");
        Intrinsics.checkNotNullParameter(r4, "fileName");
        String r5 = StringsKt.trim(r2).toString().toLowerCase(Locale.ROOT);
        switch(r5.hashCode()) {
            case -1363649724: goto L53;
            case -1268966290: goto L49;
            case -899647262: goto L45;
            case -102775833: goto L41;
            case 48: goto L38;
            case 50: goto L34;
            case 51: goto L30;
            case 56: goto L27;
            case 1568: goto L24;
            case 1600: goto L21;
            case 1629: goto L18;
            case 99640: goto L15;
            case 3088960: goto L12;
            case 109403487: goto L9;
            case 109526449: goto L6;
            default: goto L56;
        };
    L56:
        DriveFileType r6 = null;
    L57:
        if (r6 != null) goto L62;
        DriveFileType.Companion.getClass();
        r6 = DriveFileType.a.a(r3);
        if (r6 != null) goto L62;
        r6 = DriveFileType.a.b(r4);
    L62:
        return r6.getIconResId();
    L6:
        if (r5.equals("slide") == false) goto L56;
    L47:
        r6 = DriveFileType.AI_SLIDES;
        goto L57
    L9:
        if (r5.equals("sheet") == false) goto L56;
    L32:
        r6 = DriveFileType.AI_SHEET;
        goto L57
    L12:
        if (r5.equals("docx") == false) goto L56;
    L36:
        r6 = DriveFileType.AI_DOC;
        goto L57
    L15:
        if (r5.equals("doc") == true) goto L36;
    L18:
        if (r5.equals("30") == true) goto L47;
    L21:
        if (r5.equals("22") == true) goto L36;
    L24:
        if (r5.equals("11") == false) goto L56;
    L55:
        r6 = DriveFileType.MINDNOTE;
        goto L57
    L27:
        if (r5.equals("8") == false) goto L56;
    L43:
        r6 = DriveFileType.BITABLE;
        goto L57
    L30:
        if (r5.equals("3") == true) goto L32;
    L34:
        if (r5.equals("2") == true) goto L36;
    L38:
        if (r5.equals("0") == false) goto L56;
    L51:
        r6 = DriveFileType.FOLDER;
        goto L57
    L41:
        if (r5.equals("bitable") == true) goto L43;
    L45:
        if (r5.equals("slides") == true) goto L47;
    L49:
        if (r5.equals("folder") == true) goto L51;
    L53:
        if (r5.equals("mindnote") == true) goto L55;
        goto L55
    }
}
