package com.larus.drive.biz.impl.view.space;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.office.common.upload.OfficeUploadPickerFragment;
import com.bytedance.ee.bear.office.export.space.OfficeFolderActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeFolderPageRequest;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceAskDoubaoRequest;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceLongPressAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceSelectionState;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceUploadSelection;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceUploadSelectionRequest;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.drive.biz.impl.activity.DriveOfficeFolderActivity;
import com.larus.drive.biz.impl.activity.DriveSearchActivity;
import com.larus.drive.biz.impl.databinding.LarusFragmentDriveOfficeFolderBinding;
import com.larus.drive.biz.impl.file.DriveOfficeUploadGuard;
import com.larus.drive.biz.impl.utils.DriveOfficeSpaceHelper;
import com.larus.drive.sdk.api.IDriveSdkServiceV2;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 f2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002fgB\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\rH\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010'\u001a\u00020\rH\u0016J\u0010\u0010)\u001a\u00020&2\u0006\u0010'\u001a\u00020\rH\u0016J\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020+2\u0006\u0010'\u001a\u0002002\u0006\u00101\u001a\u00020\u0014H\u0016J\u0018\u00102\u001a\u00020+2\u0006\u00103\u001a\u0002042\u0006\u0010-\u001a\u000205H\u0016J \u00106\u001a\u00020+2\u0006\u0010,\u001a\u0002072\u0006\u00103\u001a\u0002042\u0006\u0010-\u001a\u000205H\u0016J\u0010\u00108\u001a\u0002092\u0006\u00103\u001a\u000204H\u0016J \u0010:\u001a\u0002092\u0006\u0010,\u001a\u0002072\u0006\u00103\u001a\u0002042\u0006\u0010-\u001a\u000205H\u0016J\u0018\u0010;\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020.H\u0002J\u0012\u0010<\u001a\u00020\"2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\n\u0010?\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010@\u001a\u00020\"2\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010A\u001a\u00020+2\u0006\u0010'\u001a\u0002002\u0006\u00101\u001a\u00020\u0014H\u0002J\u0018\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u0012H\u0002J\b\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020\u0017H\u0002J\u001a\u0010G\u001a\u00020\"2\u0006\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u0017H\u0002J\u0018\u0010K\u001a\b\u0012\u0004\u0012\u00020M0L2\b\u0010J\u001a\u0004\u0018\u00010\u0017H\u0002J\u0018\u0010N\u001a\b\u0012\u0004\u0012\u00020M0L2\b\u0010J\u001a\u0004\u0018\u00010\u0017H\u0002J3\u0010O\u001a\u00020M2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u000f2\b\u0010S\u001a\u0004\u0018\u00010\u000f2\b\u0010T\u001a\u0004\u0018\u00010UH\u0002¢\u0006\u0002\u0010VJ\u0010\u0010W\u001a\u00020X2\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010Y\u001a\u00020\"2\u0006\u0010P\u001a\u00020QH\u0002J\u001e\u0010Z\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u000f2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020M0LH\u0002J\u0010\u0010\\\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u000fH\u0002J\u0018\u0010]\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020\u000fH\u0002J\u0012\u0010_\u001a\u0004\u0018\u00010\u00142\u0006\u0010C\u001a\u00020\u000fH\u0002J\b\u0010`\u001a\u00020\"H\u0002J\u0006\u0010a\u001a\u000209J\b\u0010b\u001a\u00020\"H\u0002J\b\u0010c\u001a\u00020\"H\u0002J\u0016\u0010d\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010eR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/larus/drive/biz/impl/view/space/DriveOfficeFolderFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPageDelegate;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventListener;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceLongPressEventListener;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceAskDoubaoVisibilityProvider;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceLongPressActionAvailabilityListener;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelectionProvider;", "<init>", "()V", "binding", "Lcom/larus/drive/biz/impl/databinding/LarusFragmentDriveOfficeFolderBinding;", "folderPageRequest", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPageRequest;", "previousPage", "", "pendingUploadRequestId", "pendingUploadAction", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderAction;", "pendingUploadCallback", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelectionCallback;", "officeSpacePickerLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "onOpenChildFolder", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderActionResult;", "request", "onSearch", "onBack", "onHeaderActionClick", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceActionResult;", "action", "source", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderEventSource;", "onRequestUploadSelection", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelectionRequest;", "callback", "onItemClick", "item", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceItem;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventSource;", "onLongPressActionClick", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceLongPressAction;", "shouldShowAskDoubao", "", "canHandleLongPressAction", "handleCreateOfficeDocument", "reportAiDocCreateIfNeeded", "createdFile", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "getPreviousPage", "notifyOfficeDocumentCreated", "handleOpenUploadSelector", "openUploadSelectorAfterGuard", "requestId", "buildOfficeSpaceAlbumConfig", "Lcom/larus/platform/model/album/AlbumSettingConfig;", "buildOfficeSpaceFileSelectIntent", "handleUploadPickerResult", "resultCode", "", "data", "parseAlbumSelections", "", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelection;", "parseFileSelections", "buildUploadSelection", "uri", "Landroid/net/Uri;", "displayName", "mimeType", "size", "", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelection;", "queryUploadMeta", "Lcom/larus/drive/biz/impl/view/space/DriveOfficeFolderFragment$UploadMeta;", "persistReadPermission", "notifyUploadSelected", "selections", "notifyUploadCancel", "notifyUploadError", "message", "uploadCallbackFor", "clearPendingUpload", "handleBack", "initConfig", "attachFolderIfNeeded", "resolveFolderFragment", "(Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "UploadMeta", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveOfficeFolderFragment extends Fragment implements com.bytedance.ee.bear.office.export.space.b, com.bytedance.ee.bear.office.export.space.h, com.bytedance.ee.bear.office.export.space.k, com.bytedance.ee.bear.office.export.space.e, com.bytedance.ee.bear.office.export.space.j, com.bytedance.ee.bear.office.export.space.o {
    public static final /* synthetic */ int k = 0;
    public LarusFragmentDriveOfficeFolderBinding d;
    public OfficeFolderPageRequest e;
    public String f;
    public String g;
    public OfficeSpaceHeaderAction h;
    public com.bytedance.ee.bear.office.export.space.n i;
    public final ActivityResultLauncher<Intent> j;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final Long c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Long r7 = this.c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "UploadMeta(displayName=" + this.a + ", mimeType=" + this.b + ", size=" + this.c + ')';
        }

        public b(String r1, String r2, Long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeSpaceHeaderAction.values().length];
            r0[OfficeSpaceHeaderAction.CREATE_DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[OfficeSpaceHeaderAction.CREATE_PPT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[OfficeSpaceHeaderAction.CREATE_BITABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[OfficeSpaceHeaderAction.CREATE_SHEET.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[OfficeSpaceHeaderAction.UPLOAD_IMAGE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[OfficeSpaceHeaderAction.UPLOAD_FILE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
    }

    public final /* synthetic */ OfficeSpaceActionResult.NotHandled XS(OfficeSpaceItem r1, OfficeSpaceEventSource r2) {
        return com.bytedance.ee.bear.office.export.space.g.a(r1, r2);
    }

    public final void YJ(OfficeSpaceSelectionState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void oI(OfficeSpaceTab r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
    }

    public final void onDestroyView() {
        String r0 = this.g;
        if (r0 == null) goto L5;
        V90(r0);
    L5:
        this.d = null;
        super.onDestroyView();
    }

    public DriveOfficeFolderFragment() {
        this.j = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new d(this));
    }

    public final OfficeFolderActionResult E00(OfficeFolderPageRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        int r3 = DriveSearchActivity.i;
        DriveSearchActivity.a.a(getContext());
        return OfficeFolderActionResult.Handled;
    }

    public final boolean Jk(OfficeSpaceItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Set<Integer> r0 = DriveOfficeSpaceHelper.a;
        return DriveOfficeSpaceHelper.c(com.bytedance.ee.bear.office.export.space.d.a(r2));
    }

    public final void V90(String r2) {
        com.bytedance.ee.bear.office.export.space.n r0 = Y90(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.onCancel(r2);
        this.g = null;
        this.h = null;
        this.i = null;
    }

    public final b X90(Uri r8) {
        Context r2 = getContext();
        Unit r3 = null;
        if (r2 == null) goto L55;
        ContentResolver r4 = r2.getContentResolver();
        if (r4 == null) goto L55;
        String r5 = r4.getType(r8);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L46
        Cursor r9 = U90(r4, r8, new String[]{"_display_name", "_size"});     // Catch: Throwable -> L46
        if (r9 == null) goto L41;
        Cursor r10 = r9;     // Catch: Throwable -> L46
        Cursor r7 = r10;     // Catch: Throwable -> L32
        if (r7.moveToFirst() == false) goto L26;
        int r1 = r7.getColumnIndex("_display_name");     // Catch: Throwable -> L32
        int r0 = r7.getColumnIndex("_size");     // Catch: Throwable -> L32
        if (r1 < 0) goto L17;
        Unit r11 = r7.getString(r1);     // Catch: Throwable -> L32
    L18:
        if (r0 >= 0) goto L68;
    L25:
        Unit r12 = null;
    L66:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L30
        CloseableKt.closeFinally(r10, null);     // Catch: Throwable -> L44
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L44
    L42:
        Object r14 = Result.constructor-impl(r3);     // Catch: Throwable -> L44
    L49:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L53;
        FLogger.a.e("DriveOfficeFolder", "query office folder upload uri meta failed", r15);
    L53:
        return new b(r11, r5, r12);
    L44:
        th = th;
    L40:
        r3 = r11;
    L48:
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        r11 = r3;
    L30:
        th = move-exception;
        r3 = r12;
        th = th;
    L58:
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L38:
        th = th;
        r12 = r3;
        goto L40
    L68:
    L23:
        th = th;
        goto L58
    L20:
        if (r7.isNull(r0) == true) goto L25;
        r12 = Long.valueOf(r7.getLong(r0));     // Catch: Throwable -> L23
        goto L66
    L17:
        r11 = null;
        goto L18
    L26:
        r12 = null;
        r11 = null;
    L32:
        th = th;
        r11 = null;
        goto L58
    L41:
        r12 = null;
        r11 = null;
    L46:
        th = th;
        r12 = null;
    L55:
        return new b(null, null, null);
    }

    public final com.bytedance.ee.bear.office.export.space.n Y90(String r4) {
        if (Intrinsics.areEqual(this.g, r4) == true) goto L7;
        FLogger.a.i("DriveOfficeFolder", "ignore stale folder upload callback, requestId=" + r4 + ", pending=" + this.g);
        return null;
    L7:
        return this.i;
    }

    public final OfficeFolderActionResult pH(OfficeFolderPageRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        int r0 = DriveOfficeFolderActivity.g;
        DriveOfficeFolderActivity.a.a(getContext(), r2);
        return OfficeFolderActionResult.Handled;
    }

    public final OfficeFolderActionResult r50(OfficeFolderPageRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L6;
        r3.finish();
    L6:
        return OfficeFolderActionResult.Handled;
    }

    public final OfficeSpaceActionResult NF(OfficeSpaceUploadSelectionRequest r3, OfficeUploadPickerFragment.buildCallback.1 r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "callback");
        final OfficeSpaceHeaderAction r0 = r3.getAction();
        final String r5 = r3.getRequestId();
        if (StringsKt.isBlank(r5) == false) goto L6;
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L6:
        if (r0 == OfficeSpaceHeaderAction.UPLOAD_IMAGE) goto L11;
        if (r0 == OfficeSpaceHeaderAction.UPLOAD_FILE) goto L11;
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L11:
        if (this.g == null) goto L13;
        r4.onError(r5, "upload picker already pending");
        return OfficeSpaceActionResult.Handled.INSTANCE;
    L13:
        this.g = r5;
        this.h = r0;
        this.i = r4;
        DriveOfficeUploadGuard.a(this, new com.larus.drive.biz.impl.view.space.b(this, r5, r0), new com.larus.drive.biz.impl.view.space.c(this, r5));
        return OfficeSpaceActionResult.Handled.INSTANCE;
    }

    public final void W90(String r2, String r3) {
        com.bytedance.ee.bear.office.export.space.n r0 = Y90(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.onError(r2, r3);
        this.g = null;
        this.h = null;
        this.i = null;
    }

    public final OfficeSpaceActionResult Zj(final OfficeSpaceHeaderAction r12, final OfficeSpaceHeaderEventSource r13) {
        Intrinsics.checkNotNullParameter(r12, "action");
        Intrinsics.checkNotNullParameter(r13, "source");
        int[] r0 = c.a;
        int r1 = r0[r12.ordinal()];
        if (r1 == 1) goto L8;
        if (r1 == 2) goto L8;
        if (r1 == 3) goto L8;
        if (r1 == 4) goto L8;
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L8:
        final long r6 = System.currentTimeMillis();
        int r2 = r0[r12.ordinal()];
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L16;
        if (r2 == 3) goto L15;
        if (r2 != 4) goto L25;
        int r8 = 3;
    L18:
        Set<Integer> r3 = DriveOfficeSpaceHelper.a;
        OfficeFolderPageRequest r4 = this.e;
        if (r4 == null) goto L21;
        String r5 = r4.getFolderToken();
    L22:
        final int r7 = r8;
        return DriveOfficeSpaceHelper.b(this, r5, r8, r13, new com.larus.drive.biz.impl.view.space.a(r12, r7, r13, r6, this));
    L21:
        r5 = null;
        goto L22
    L25:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L15:
        r8 = 8;
        goto L18
    L16:
        r8 = 30;
        goto L18
    L17:
        r8 = 22;
        goto L18
    }

    public final OfficeSpaceActionResult ne(OfficeSpaceItem r3, OfficeSpaceEventSource r4) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "source");
        if (r3.isFolder() == true) goto L5;
        Context r0 = getContext();
        if (r0 != null) goto L11;
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L11:
        if (IDriveSdkServiceV2.a.c(r0, r3, r4) == false) goto L14;
        return OfficeSpaceActionResult.Handled.INSTANCE;
    L14:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L5:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        Bundle r10 = getArguments();
        if (r10 == null) goto L5;
        Serializable r11 = r10.getSerializable("drive_office_folder_request");
    L7:
        if ((r11 instanceof OfficeFolderPageRequest) == false) goto L9;
        OfficeFolderPageRequest r12 = (OfficeFolderPageRequest) r11;
    L10:
        this.e = r12;
        Bundle r13 = getArguments();
        if (r13 == null) goto L13;
        String r14 = r13.getString("drive_office_folder_previous_page");
    L14:
        this.f = r14;
        Fragment r15 = getChildFragmentManager().findFragmentByTag("drive_office_folder_content");
        if (r15 == null) goto L17;
        FLogger.a.i("DriveOfficeFolder", "remove restored office folder child before reattach");
        getChildFragmentManager().beginTransaction().remove(r15).commitNowAllowingStateLoss();
    L17:
        OfficeFolderPageRequest r16 = this.e;
        if (r16 != null) goto L20;
        FLogger.a.e("DriveOfficeFolder", "office folder request is empty");
        return;
    L20:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DriveOfficeFolderFragment$attachFolderIfNeeded$2(this, r16, null), 3, null);
        return;
    L13:
        r14 = null;
        goto L14
    L9:
        r12 = null;
        goto L10
    L5:
        r11 = null;
        goto L7
    }

    public static final Object S90(DriveOfficeFolderFragment r7, OfficeFolderPageRequest r8, Continuation r9) {
        r7.getClass();
        if ((r9 instanceof DriveOfficeFolderFragment$resolveFolderFragment$1) == false) goto L7;
        DriveOfficeFolderFragment$resolveFolderFragment$1 r0 = (DriveOfficeFolderFragment$resolveFolderFragment$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        IOfficeSdkServiceV2 r11 = (IOfficeSdkServiceV2) r0.L$1;
        OfficeFolderPageRequest r4 = (OfficeFolderPageRequest) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L20:
        ik5.a r12 = (ik5.a) r10;
        if (r12 == null) goto L31;
        FLogger.a.i("DriveOfficeFolder", "Office docs sdk ready: " + r12);
        gk5.e r13 = r11.q0();
        if (r13 == null) goto L29;
        com.bytedance.ee.bear.office.export.space.a r14 = r13.e7();
        if (r14 == null) goto L29;
        return r14.e(r4, r7);
    L29:
        throw new IllegalStateException("office space sdk unavailable".toString());
    L31:
        throw new IllegalStateException("office docs sdk not ready".toString());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        IOfficeSdkServiceV2 r15 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r15 == null) goto L33;
        IOfficeSdkServiceV2.a.b(r15, false, null, 7);
        r0.L$0 = r8;
        r0.L$1 = r15;
        r0.label = 1;
        Object r5 = r15.o0(DoraObricDeviceHomeViewModel.SCAN_TIMEOUT_MS, r0);
        if (r5 == r2) goto L34;
        r4 = r8;
        r11 = r15;
        r10 = r5;
        goto L20
    L34:
        return r2;
    L33:
        throw new IllegalStateException("office sdk service unavailable".toString());
    L7:
        r0 = new DriveOfficeFolderFragment$resolveFolderFragment$1(r7, r9);
        goto L8
    }

    public static Cursor U90(ContentResolver r12, Uri r13, String[] r14) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, r14, null, null, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r15 = r12.query(r13, r14, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r15, r10, true);
        return r15;
    }

    public final boolean Sp(OfficeSpaceLongPressAction r2, OfficeSpaceItem r3, OfficeSpaceEventSource r4) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "source");
        if (r2 == OfficeSpaceLongPressAction.ASK_DOUBAO) goto L5;
        return false;
    L5:
        if (r3.isFolder() == true) goto L11;
        Set<Integer> r5 = DriveOfficeSpaceHelper.a;
        OfficeSpaceAskDoubaoRequest r6 = com.bytedance.ee.bear.office.export.space.d.b(r3, r4);
        Intrinsics.checkNotNullParameter(r6, "request");
        return DriveOfficeSpaceHelper.c(r6.getCurrent());
    L11:
        return false;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131562383, r3, false);
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r5, 2131370285);
        if (r6 == null) goto L7;
        FrameLayout r7 = (FrameLayout) r5;
        this.d = new LarusFragmentDriveOfficeFolderBinding(r7, r6);
        return r7;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131370285)));
    }

    public final OfficeSpaceActionResult xR(OfficeSpaceLongPressAction r2, OfficeSpaceItem r3, OfficeSpaceEventSource r4) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "source");
        if (r2 != OfficeSpaceLongPressAction.ASK_DOUBAO) goto L10;
        if (r3.isFolder() == true) goto L10;
        Set<Integer> r5 = DriveOfficeSpaceHelper.a;
        return DriveOfficeSpaceHelper.a(this, com.bytedance.ee.bear.office.export.space.d.b(r3, r4));
    L10:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    }

    public final OfficeSpaceUploadSelection T90(Uri r7, String r8, String r9, Long r10) {
        String r0 = null;
        if (r8 != null) goto L5;
    L9:
        String r11 = r7.getLastPathSegment();
        if (r11 != null) goto L12;
    L14:
        if (r0 != null) goto L17;
        r8 = "未命名文件";
    L16:
        String r3 = r8;
    L19:
        return new OfficeSpaceUploadSelection(r7.toString(), true, r3, r9, r10);
    L17:
        r3 = r0;
        goto L19
    L12:
        if ((!StringsKt.isBlank(r11)) == false) goto L14;
        r0 = r11;
        goto L14
    L5:
        if ((!StringsKt.isBlank(r8)) == true) goto L8;
        r8 = null;
    L8:
        if (r8 != null) goto L16;
        goto L9
    }
}
