package com.larus.drive.biz.impl.view.space;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
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
import com.bytedance.ee.bear.office.export.space.OfficeSpaceUploadSelectionRequest;
import com.larus.bmhome.a0;
import com.larus.bmhome.b0;
import com.larus.drive.biz.impl.activity.DriveOfficeFolderActivity;
import com.larus.drive.biz.impl.activity.DriveSearchActivity;
import com.larus.drive.biz.impl.file.DriveOfficeUploadGuard;
import com.larus.drive.biz.impl.utils.DriveOfficeSpaceHelper;
import com.larus.drive.sdk.api.IDriveSdkServiceV2;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q implements com.bytedance.ee.bear.office.export.space.h, com.bytedance.ee.bear.office.export.space.c, com.bytedance.ee.bear.office.export.space.k, com.bytedance.ee.bear.office.export.space.e, com.bytedance.ee.bear.office.export.space.j, com.bytedance.ee.bear.office.export.space.o {
    public final /* synthetic */ DriveOfficeSpaceHostFragment a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeSpaceHeaderAction.values().length];
            r0[OfficeSpaceHeaderAction.OPEN_MENU.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[OfficeSpaceHeaderAction.SEARCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[OfficeSpaceHeaderAction.CREATE_DOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[OfficeSpaceHeaderAction.CREATE_PPT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[OfficeSpaceHeaderAction.CREATE_BITABLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[OfficeSpaceHeaderAction.CREATE_SHEET.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[OfficeSpaceHeaderAction.CREATE_FOLDER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[OfficeSpaceHeaderAction.SELECT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[OfficeSpaceHeaderAction.UPLOAD_IMAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[OfficeSpaceHeaderAction.UPLOAD_FILE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            a = r0;
        }
    }

    public final /* synthetic */ OfficeSpaceActionResult.NotHandled XS(OfficeSpaceItem r1, OfficeSpaceEventSource r2) {
        return com.bytedance.ee.bear.office.export.space.g.a(r1, r2);
    }

    public final void oI(OfficeSpaceTab r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
    }

    public q(DriveOfficeSpaceHostFragment r1) {
        this.a = r1;
    }

    public final boolean Jk(OfficeSpaceItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Set<Integer> r0 = DriveOfficeSpaceHelper.a;
        return DriveOfficeSpaceHelper.c(com.bytedance.ee.bear.office.export.space.d.a(r2));
    }

    public final void YJ(OfficeSpaceSelectionState r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        a0 r0 = b0.a(this.a);
        if (r0 == null) goto L6;
        r0.ED(!r3.isInSelectionMode(), "drive select mode");
        return;
    }

    public final OfficeFolderActionResult j1(OfficeFolderPageRequest r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Context r0 = this.a.getContext();
        if (r0 != null) goto L6;
        FLogger.a.i("DriveOfficeSpaceHost", "skip open office folder because context is null");
        return OfficeFolderActionResult.NotHandled;
    L6:
        int r1 = DriveOfficeFolderActivity.g;
        this.a.getClass();
        DriveOfficeFolderActivity.a.a(r0, r3);
        return OfficeFolderActionResult.Handled;
    }

    public final OfficeSpaceActionResult NF(OfficeSpaceUploadSelectionRequest r4, OfficeUploadPickerFragment.buildCallback.1 r5) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "callback");
        final DriveOfficeSpaceHostFragment r0 = this.a;
        WeakReference<DriveOfficeSpaceHostFragment> r1 = DriveOfficeSpaceHostFragment.w;
        r0.getClass();
        final OfficeSpaceHeaderAction r2 = r4.getAction();
        final String r6 = r4.getRequestId();
        if (StringsKt.isBlank(r6) == false) goto L6;
        FLogger.a.i("DriveOfficeSpaceHost", "open upload selector ignored because requestId is blank");
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L6:
        if (r2 == OfficeSpaceHeaderAction.UPLOAD_IMAGE) goto L11;
        if (r2 == OfficeSpaceHeaderAction.UPLOAD_FILE) goto L11;
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L11:
        if (r0.q == null) goto L13;
        r5.onError(r6, "upload picker already pending");
        return OfficeSpaceActionResult.Handled.INSTANCE;
    L13:
        r0.q = r6;
        r0.r = r2;
        r0.s = r5;
        int r7 = DriveOfficeUploadGuard.a;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        DriveOfficeUploadGuard.a(r0, new i(r0, r6, r2), new j(r0, r6));
        return OfficeSpaceActionResult.Handled.INSTANCE;
    }

    public final OfficeSpaceActionResult Zj(final OfficeSpaceHeaderAction r18, final OfficeSpaceHeaderEventSource r110) {
        Intrinsics.checkNotNullParameter(r18, "action");
        Intrinsics.checkNotNullParameter(r110, "source");
        switch(a.a[r18.ordinal()]) {
            case 1: goto L26;
            case 2: goto L21;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L37;
            case 8: goto L37;
            case 9: goto L36;
            case 10: goto L36;
            default: goto L35;
        };
    L7:
        final DriveOfficeSpaceHostFragment r10 = this.a;
        WeakReference<DriveOfficeSpaceHostFragment> r1 = DriveOfficeSpaceHostFragment.w;
        r10.getClass();
        final long r11 = System.currentTimeMillis();
        int r2 = DriveOfficeSpaceHostFragment.c.a[r18.ordinal()];
        if (r2 != 3) goto L10;
        int r13 = 22;
    L20:
        FLogger r14 = FLogger.a;
        r14.i("DriveOfficeSpaceHost", "[OfficeCreatePerf] stage=flow_handle_start action=" + r18 + " type=" + r13 + " tab=" + r110.getCurrentTab().name() + " ts=" + r11);
        Set<Integer> r3 = DriveOfficeSpaceHelper.a;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        final int r4 = r13;
        OfficeSpaceActionResult r5 = DriveOfficeSpaceHelper.b(r10, null, r13, r110, new n(r18, r4, r110, r11, r10));
        r14.i("DriveOfficeSpaceHost", "[OfficeCreatePerf] stage=flow_handle_dispatch_result action=" + r18 + " type=" + r13 + " result=" + r5 + " elapsed=" + (System.currentTimeMillis() - r11));
        return r5;
    L10:
        if (r2 != 4) goto L12;
        r13 = 30;
        goto L20
    L12:
        if (r2 != 5) goto L14;
        r13 = 8;
        goto L20
    L14:
        if (r2 != 6) goto L38;
        r13 = 3;
        goto L20
    L38:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L21:
        FragmentActivity r6 = this.a.getActivity();
        if (r6 == null) goto L24;
        int r7 = DriveSearchActivity.i;
        DriveSearchActivity.a.a(r6);
        return OfficeSpaceActionResult.Handled.INSTANCE;
    L24:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L26:
        DriveOfficeSpaceHostFragment r8 = this.a;
        WeakReference<DriveOfficeSpaceHostFragment> r9 = DriveOfficeSpaceHostFragment.w;
        if (r8.aa0() == false) goto L41;
        a0 r12 = b0.a(this.a);
        if (r12 == null) goto L32;
        r12.cs();
        return OfficeSpaceActionResult.Handled.INSTANCE;
    L32:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L41:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L35:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L36:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L37:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    }

    public final OfficeSpaceActionResult ne(OfficeSpaceItem r3, OfficeSpaceEventSource r4) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "source");
        if (r3.isFolder() == false) goto L7;
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L7:
        if (IDriveSdkServiceV2.a.c(this.a.requireContext(), r3, r4) == false) goto L10;
        return OfficeSpaceActionResult.Handled.INSTANCE;
    L10:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
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

    public final OfficeSpaceActionResult xR(OfficeSpaceLongPressAction r2, OfficeSpaceItem r3, OfficeSpaceEventSource r4) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "source");
        if (r2 != OfficeSpaceLongPressAction.ASK_DOUBAO) goto L10;
        if (r3.isFolder() == true) goto L10;
        Set<Integer> r5 = DriveOfficeSpaceHelper.a;
        DriveOfficeSpaceHostFragment r6 = this.a;
        WeakReference<DriveOfficeSpaceHostFragment> r0 = DriveOfficeSpaceHostFragment.w;
        r6.getClass();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        return DriveOfficeSpaceHelper.a(r6, com.bytedance.ee.bear.office.export.space.d.b(r3, r4));
    L10:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    }
}
