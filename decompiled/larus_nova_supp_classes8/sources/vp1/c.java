package vp1;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.LandscapeCameraLinkRoomDialog;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.MultiCameraLinkedRoomContext;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.PortraitVerticalMultiCameraLinkRoomDialog;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.VSCameraApi;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements nm1.a, o {
    public c() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final MultiCameraLinkedRoomContext d(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        return new MultiCameraLinkedRoomContext(r2);
    }

    public final void a(Context r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        boolean r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r5, true);
        if (PadConfigUtils.c() == true) goto L16;
        if (r1 == true) goto L16;
        int r2 = LandscapeCameraLinkRoomDialog.h;
        Intrinsics.checkNotNullParameter(r4, "context");
        if ((r4 instanceof FragmentActivity) == false) goto L27;
        FragmentManager r0 = ((FragmentActivity) r4).getSupportFragmentManager();
        if ((r0.findFragmentByTag("MatchRoomMultiCameraDialog") instanceof LandscapeCameraLinkRoomDialog) == false) goto L15;
        LandscapeCameraLinkRoomDialog r3 = r0.findFragmentByTag("MatchRoomMultiCameraDialog");
        if (r3 == null) goto L14;
        LandscapeCameraLinkRoomDialog r6 = r3;
        r6.f = r4;
        r6.g = r5;
        LandscapeCameraLinkRoomDialog.a.a(r6, r0);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.LandscapeCameraLinkRoomDialog");
    L15:
        LandscapeCameraLinkRoomDialog r7 = new LandscapeCameraLinkRoomDialog();
        r7.f = r4;
        r7.g = r5;
        LandscapeCameraLinkRoomDialog.a.a(r7, r0);
        return;
    L27:
        return;
    L16:
        int r8 = PortraitVerticalMultiCameraLinkRoomDialog.h;
        Intrinsics.checkNotNullParameter(r4, "context");
        if ((r4 instanceof FragmentActivity) == false) goto L30;
        FragmentManager r9 = ((FragmentActivity) r4).getSupportFragmentManager();
        if ((r9.findFragmentByTag("PadMatchRoomMultiCameraDialog") instanceof PortraitVerticalMultiCameraLinkRoomDialog) == false) goto L25;
        PortraitVerticalMultiCameraLinkRoomDialog r10 = r9.findFragmentByTag("PadMatchRoomMultiCameraDialog");
        if (r10 == null) goto L24;
        PortraitVerticalMultiCameraLinkRoomDialog r11 = r10;
        r11.f = r4;
        r11.g = r5;
        PortraitVerticalMultiCameraLinkRoomDialog.a.a(r11, r9);
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.PortraitVerticalMultiCameraLinkRoomDialog");
    L25:
        PortraitVerticalMultiCameraLinkRoomDialog r12 = new PortraitVerticalMultiCameraLinkRoomDialog();
        r12.f = r4;
        r12.g = r5;
        PortraitVerticalMultiCameraLinkRoomDialog.a.a(r12, r9);
        return;
    }

    public final Observable<Response<com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.f>> c(long r3, long r5) {
        return ((VSCameraApi) r.n().getService(VSCameraApi.class)).getCameraInfo(r3, r5);
    }
}
