package com.bytedance.android.livesdk.interactivity.api;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeDialog;
import com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeLandscapeDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nz.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J6\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016J0\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/RoomNoticeService;", "Lcom/bytedance/android/livesdk/interactivity/api/IRoomNoticeService;", "Landroidx/fragment/app/FragmentActivity;", "activity", BuildConfig.FLAVOR, "userId", "enterType", "Lnz/z;", "iDialogDismissListener", BuildConfig.FLAVOR, "openRoomNoticeDialog", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "openLandscapeRoomNoticeDialog", BuildConfig.FLAVOR, "length", "getNoticeLengthTip", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoomNoticeService implements IRoomNoticeService {
    public RoomNoticeService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomNoticeService
    public String getNoticeLengthTip(int r2) {
        int r0 = ya2.d.a;
        StringBuilder r1 = new StringBuilder();
        r1.append(r2);
        r1.append('/');
        r1.append(ya2.d.a());
        return r1.toString();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomNoticeService
    public void openLandscapeRoomNoticeDialog(FragmentActivity r1, Room r2, String r3, String r4) {
        int r5 = RoomNoticeLandscapeDialog.h;
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r1, "activity");
        Intrinsics.checkNotNullParameter(r2, "room");
        RoomNoticeLandscapeDialog r6 = new RoomNoticeLandscapeDialog();
        r6.e = r2;
        FragmentManager r7 = r1.getSupportFragmentManager();
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, "RoomNoticeLandscapeDialog", r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r6, r8) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r6.show(r7, "RoomNoticeLandscapeDialog");
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomNoticeService
    public void openRoomNoticeDialog(FragmentActivity r3, String r4, String r5, z<String> r6) {
        RoomNoticeDialog.a r7 = RoomNoticeDialog.j;
        Intrinsics.checkNotNull(r3);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r3, "activity");
        RoomNoticeDialog r8 = new RoomNoticeDialog();
        FragmentManager r9 = r3.getSupportFragmentManager();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, "RoomNoticeDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r9, r8, r0) == true) goto L8;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L6:
        r8.show(r9, "RoomNoticeDialog");
    L8:
        if (r4 != null) goto L10;
        r4 = BuildConfig.FLAVOR;
    L10:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        RoomNoticeDialog.h = r4;
        if (r5 != null) goto L13;
        r5 = BuildConfig.FLAVOR;
    L13:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        RoomNoticeDialog.i = r5;
    }
}
