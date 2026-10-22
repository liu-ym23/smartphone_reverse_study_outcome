package com.bytedance.android.livesdk.interactivity.impl.exitroom;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.room.l;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.qi1;
import com.bytedance.android.livesdk.coupon.util.UgCouponNewDialogFrequencyController;
import com.bytedance.android.livesdk.interactivity.api.exitroom.ICloseInterceptorService;
import com.bytedance.android.livesdk.interactivity.impl.exitroom.controller.QuitRoomGuideController;
import com.bytedance.android.livesdk.quitroom.NewRoomQuitDialog;
import com.bytedance.android.livesdk.quitroom.b;
import com.bytedance.android.livesdk.quitroom.interceptors.NewQuitDialogShowInterceptorImpl;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomIntentBuilder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.eventbus.LogEvent;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016JF\u0010\u0018\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\bH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/impl/exitroom/CloseInterceptorService;", "Lcom/bytedance/android/livesdk/interactivity/api/exitroom/ICloseInterceptorService;", "Landroid/content/Context;", "ctx", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Landroid/os/Bundle;", "extra", BuildConfig.FLAVOR, "Lkf1/a;", "provideCloseRoomInterceptors", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Ljava/lang/Runnable;", "afterInterceptRunnable", "Lm32/a;", "interceptor", "Lcom/bytedance/android/live/room/l;", "roomLogger", "Lkotlin/Function0;", BuildConfig.FLAVOR, "openDrawerAction", BuildConfig.FLAVOR, "showNewVerRoomQuitDialog", "createNewQuitRoomShowInterceptor", BuildConfig.FLAVOR, "cleanUgCouponInfo", "Lm32/b;", "createQuitRoomGuideController", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class CloseInterceptorService implements ICloseInterceptorService {

    public static final class a implements NewRoomQuitDialog.b {
        public final /* synthetic */ Context a;
        public final /* synthetic */ m32.a b;
        public final /* synthetic */ Function0 c;
        public final /* synthetic */ Runnable d;

        public final void a() {
            ALogger.i(ICloseInterceptorService.TAG_QUIT_DIALOG, "NewRoomQuitDialog#onClickQuitButtonWhenNoData() >>>");
            this.d.run();
            b.a("exit", "fail");
        }

        public final void b() {
            ALogger.i(ICloseInterceptorService.TAG_QUIT_DIALOG, "NewRoomQuitDialog#onClickCloseButton() >>>");
        }

        public final void c() {
            ALogger.i(ICloseInterceptorService.TAG_QUIT_DIALOG, "NewRoomQuitDialog#onClickMoreLive() >>>");
            xs2.b.a().post(new LogEvent("toast"));
            Function0 r0 = this.c;
            if (r0 == null) goto L5;
            Unit r1 = (Unit) r0.invoke();
        L5:
            this.b.b(false);
            b.a("explore", "success");
        }

        public final void e() {
            ALogger.i(ICloseInterceptorService.TAG_QUIT_DIALOG, "NewRoomQuitDialog#onClickQuitButton() >>>");
            this.d.run();
            this.b.b(true);
            b.a("exit", "success");
        }

        public final void onLoadFail() {
            ALogger.i(ICloseInterceptorService.TAG_QUIT_DIALOG, "NewRoomQuitDialog#onLoadFail() >>>");
            b.c("fail");
        }

        public final void onLoadSuccess() {
            ALogger.i(ICloseInterceptorService.TAG_QUIT_DIALOG, "NewRoomQuitDialog#onLoadSuccess() >>>");
            b.c("success");
        }

        public final void d(FeedItem r8, FeedExtra r9) {
            Intrinsics.checkNotNullParameter(r8, "feedItem");
            Intrinsics.checkNotNullParameter(r9, "extra");
            Context r2 = this.a;
            int r3 = com.bytedance.android.livesdk.quitroom.a.a;
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r8, "feedItem");
            Intrinsics.checkNotNullParameter(r9, "extra");
            Room r0 = r8.getRoom();
            if (r0 != null) goto L5;
            ALogger.w(ICloseInterceptorService.TAG_QUIT_DIALOG, "tryEnterRoom() >>> invalid room");
        L43:
            this.b.b(false);
            b.a("cover", "success");
            return;
        L5:
            Bundle r4 = new Bundle();
            r4.putString("log_pb", r8.logPb);
            r4.putString("request_id", r8.resId);
            r4.putString("enter_from", "live");
            r4.putString("enter_from_merge", "exit_room_pop");
            r4.putString("enter_method", "live_cover");
            String r5 = r8.logPb;
            if (r5 != null) goto L8;
            r5 = BuildConfig.FLAVOR;
        L8:
            r0.setLog_pb(r5);
            String r10 = r8.resId;
            if (r10 != null) goto L11;
            r10 = BuildConfig.FLAVOR;
        L11:
            r0.setRequestId(r10);
            if (NetworkUtils.isNetworkAvailable(r2) == true) goto L14;
            IESUIUtils.displayToast(r2, 2131919565);
            goto L43
        L14:
            r4.putString("anchor_id", r0.getAnchorId());
            JsonObject r11 = r9.getLogPb();
            if (r11 == null) goto L19;
            JsonElement r13 = r11.get("impr_id");
            if (r13 == null) goto L19;
            String r14 = r13.toString();
        L20:
            r4.putString("live.intent.extra.REQUEST_ID", r14);
            Bundle r15 = LiveRoomIntentBuilder.buildBundle(r2, r0, BuildConfig.FLAVOR, r4);
            if (r15 == null) goto L43;
            if (TTLiveSDK.hostService() == null) goto L43;
            if (TTLiveSDK.hostService().action() == null) goto L43;
            r15.putAll(ArgumentsBuilder.buildRoomArgs(r0));
            if (r15.get("live.intent.extra.USER_ID") != null) goto L29;
            r15.putString("live.intent.extra.USER_ID", r0.getAnchorId());
        L29:
            r15.putString("enter_from_user_id", r0.getAnchorId());
            r15.putBoolean("is_from_match_room", r4.getBoolean("is_from_match_room"));
            r15.putString("extra_live_room_enter_source", "square_drawer");
            RoomContext r16 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r16 != null) goto L32;
        L42:
            TTLiveSDK.hostService().action().startLive(r2, r0.id, r15);
            goto L43
        L32:
            if (r16.isVSSpecialDrawer() == false) goto L42;
            StreamUrl r6 = r0.getStreamUrl();
            if (((Boolean) r16.isPortraitInteraction().getValue()).booleanValue() == true) goto L40;
            if (r6 == null) goto L40;
            if (r6.getStreamOrientation() != 2) goto L40;
            int r17 = 0;
        L41:
            r15.putInt("live.intent.extra.SCREEN_ORIENTATION", r17);
        L40:
            r17 = 1;
        L19:
            r14 = null;
            goto L20
        }

        public a(Context r1, m32.a r2, Function0 r3, Runnable r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.exitroom.ICloseInterceptorService
    public List<Long> cleanUgCouponInfo() {
        SettingKey r1 = LiveConfigSettingKeys.LIVE_UG_COUPON_NEW_DIALOG_CONFIG;
        UgCouponNewDialogFrequencyController r0 = new UgCouponNewDialogFrequencyController(((qi1) r1.getValue()).a(), ((qi1) r1.getValue()).b());
        e r2 = (e) r0.a.getValue();
        List r3 = CollectionsKt.emptyList();
        r2.getClass();
        f.d(r2, r3);
        return (List) ((e) r0.a.getValue()).getValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.exitroom.ICloseInterceptorService
    public m32.a createNewQuitRoomShowInterceptor() {
        return new NewQuitDialogShowInterceptorImpl();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.exitroom.ICloseInterceptorService
    public m32.b createQuitRoomGuideController() {
        return new QuitRoomGuideController();
    }

    public CloseInterceptorService() {
        k.l(ICloseInterceptorService.class, this);
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_interactivity_impl_exitroom_CloseInterceptorService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(NewRoomQuitDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.exitroom.ICloseInterceptorService
    public List<kf1.a> provideCloseRoomInterceptors(Context r2, Room r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "room");
        ArrayList r5 = new ArrayList();
        r5.add(new g82.a(r2, r4));
        return r5;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.exitroom.ICloseInterceptorService
    public boolean showNewVerRoomQuitDialog(Context r3, DataCenter r4, Runnable r5, m32.a r6, l r7, Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r5, "afterInterceptRunnable");
        Intrinsics.checkNotNullParameter(r6, "interceptor");
        if (r3 != null) goto L7;
        ALogger.i(ICloseInterceptorService.TAG_QUIT_DIALOG, "showNewVerRoomQuitDialog() >>> context == null");
        return false;
    L7:
        if (r6.c(r3, r7) == true) goto L10;
        ALogger.i(ICloseInterceptorService.TAG_QUIT_DIALOG, "showNewVerRoomQuitDialog() >>> can not show");
        return false;
    L10:
        r6.a();
        ALogger.i(ICloseInterceptorService.TAG_QUIT_DIALOG, "showNewVerRoomQuitDialog() >>> ready to show");
        INVOKEVIRTUAL_com_bytedance_android_livesdk_interactivity_impl_exitroom_CloseInterceptorService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(new NewRoomQuitDialog(r3, r4, new a(r3, r6, r8, r5)));
        return true;
    }
}
