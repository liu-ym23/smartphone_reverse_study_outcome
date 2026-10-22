package or1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.schema.interfaces.IRoomActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b, com.bytedance.android.scope.o {
    public c() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final xu1.a getColorWeakModelEffectInfo() {
        IHostAction r0 = jc1.k.f(IHostAction.class);
        if (r0 == null) goto L7;
        r0.getColorWeakModelEffectInfo();
        return null;
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final boolean h() {
        if (TTLiveSDKContext.getHostService() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final boolean isNeedProtectUnderage() {
        return TTLiveSDKContext.getHostService().b().isNeedProtectUnderage();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final boolean isNetworkStateChanged() {
        return TTLiveSDKContext.getHostService().d().appConfig().isNetworkStateChanged();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void g(Activity r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r4, "bindPhoneListener");
        if (((Boolean) r52.a.a.getValue()).booleanValue() == false) goto L6;
        TTLiveSDKContext.getHostService().e().startBindPhoneDialogFragment(r3, "live_detail", "live_detail", new b(r4));
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void handleSchema(Context r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        com.bytedance.android.livesdk.service.l.d().a().handle(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void handleSchema(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "uriString");
        com.bytedance.android.livesdk.service.l.d().a().handle(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void a(String r3, Map<String, String> r4, Context r5) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "params");
        com.bytedance.android.livesdk.service.l.d().a().showUserProfileExt(r5, r3, null, r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void c(Context r10, Uri r11, Bundle r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r10 != null) goto L6;
        return;
    L6:
        String r1 = UriProtector.getQueryParameter(r11, "room_id");
        long r2 = 0;
        if (r1 == null) goto L9;
        long r4 = CastLongProtector.parseLong(r1);
    L11:
        if (r4 != 0) goto L13;
        return;
    L13:
        String r3 = UriProtector.getQueryParameter(r11, "user_from");
        if (r3 == null) goto L16;
        r2 = CastLongProtector.parseLong(r3);
    L16:
        String r5 = UriProtector.getQueryParameter(r11, "orientation");
        if (r5 == null) goto L19;
        int r6 = CastIntegerProtector.parseInt(r5);
    L20:
        IBaseLiveActionHandler.DefaultImpls.openRoom$default(com.bytedance.android.livesdk.service.l.d().a(), r10, new IRoomActionHandler.Params().setRoomId(r4).setRequestId(UriProtector.getQueryParameter(r11, "requestId")).setEnterFrom("live_end").setEnterMethod("live_cover").setLogPb(UriProtector.getQueryParameter(r11, "log_pb")).setUserFrom(r2).setOrientation(r6).setEnterFromMerge("live_end").setEnterLiveExtra(r12), null, 4, null);
        return;
    L19:
        r6 = 0;
        goto L20
    L9:
        r4 = 0;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void d(FragmentActivity r7, Fragment r8, boolean r9) {
        String r0 = null;
        if (r7 == null) goto L9;
        Intent r1 = r7.getIntent();
        if (r1 == null) goto L9;
        Bundle r2 = r1.getExtras();
        if (r2 == null) goto L9;
        Bundle r3 = r2.getBundle("live_play_params");
    L10:
        Bundle r4 = yt2.a.b(r3, "live.intent.extra.ENTER_LIVE_EXTRA");
        if (r4 == null) goto L13;
        r0 = r4.getString("previous_page", "");
    L13:
        boolean r5 = false;
        if (r4 == null) goto L19;
        if (r4.getBoolean("pay_success_guide_showed", false) != true) goto L19;
        r5 = true;
    L19:
        if (TextUtils.equals(r0, "bill_detail_page") == false) goto L27;
        if (r5 == true) goto L28;
        IHostBusiness r6 = jc1.k.f(IHostBusiness.class);
        if (r6 == null) goto L24;
        r6.showPaySuccessGuide(r7, r8, r9);
    L24:
        if (r4 == null) goto L29;
        r4.putBoolean("pay_success_guide_showed", true);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void f(Context r8, IRoom r9, Bundle r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        ILiveActionHandler r1 = com.bytedance.android.livesdk.service.l.d().a();
        IRoomActionHandler.Params r0 = new IRoomActionHandler.Params().setRoomId(r9.getId()).setRequestId(r9.getRequestId()).setEnterFrom("live_end").setEnterMethod("live_cover").setLogPb(r9.getLog_pb());
        boolean r3 = r9 instanceof Room;
        IRoom r4 = null;
        if (r3 == true) goto L7;
        IRoom r5 = null;
    L8:
        Room r6 = (Room) r5;
        if (r6 == null) goto L11;
        long r7 = r6.getUserFrom();
    L12:
        IRoomActionHandler.Params r2 = r0.setUserFrom(r7);
        if (r3 == false) goto L16;
        r4 = r9;
    L16:
        Room r11 = (Room) r4;
        if (r11 == null) goto L19;
        int r12 = r11.orientation;
    L20:
        IBaseLiveActionHandler.DefaultImpls.openRoom$default(r1, r8, r2.setOrientation(r12).setEnterFromMerge("live_end").setAnchorId(r9.getAnchorId()).setEnterLiveExtra(r10).setRoom(jm2.a.e((vh7.c) r9)), null, 4, null);
        return;
    L19:
        r12 = 0;
        goto L20
    L11:
        r7 = 0;
        goto L12
    L7:
        r5 = r9;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void startLive(Context r2, long r3, Bundle r5) {
        TTLiveSDKContext.getHostService().a().startLive(r2, r3, r5);
    }
}
