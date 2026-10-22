package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.setting.CoreSettingUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.dispatch.utils.DispatchLogUtil;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.utils.b3;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/LongPressPanelFollowWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LongPressPanelFollowWidget extends MiddlewareRoomWidget {
    public static final List<String> b = null;
    public final CompositeDisposable a;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.livesdk.user.h<FollowPair> {
        public final /* synthetic */ LongPressPanelFollowWidget a;
        public final /* synthetic */ Room b;

        public final void onComplete() {
            LongPressPanelFollowWidget.xq(this.a);
        }

        public final void onError(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            LongPressPanelFollowWidget.yq(this.a, r2);
        }

        public final void onNext(Object r8) {
            FollowPair r9 = (FollowPair) r8;
            Intrinsics.checkNotNullParameter(r9, "followPair");
            if (this.b.getOwner() != null) goto L5;
            return;
        L5:
            if (((Widget) this.a).dataCenter == null) goto L54;
            User r0 = this.b.getOwner();
            if (r0 == null) goto L10;
            r0.setFollowStatus(r9.getFollowStatus());
        L10:
            DataCenter r1 = ((Widget) this.a).dataCenter;
            if (r9.getFollowStatus() == 0) goto L13;
            boolean r2 = true;
        L14:
            r1.put("data_is_followed", Boolean.valueOf(r2));
            if (r9.getFollowStatus() == 0) goto L50;
            JSONObject r3 = new JSONObject();
            User r4 = this.b.getOwner();     // Catch: JSONException -> L23
            if (r4 == null) goto L20;
            String r5 = r4.getIdStr();     // Catch: JSONException -> L23
        L21:
            r3.put("anchor_id", r5);     // Catch: JSONException -> L23
            r3.put("room_id", String.valueOf(this.b.id));     // Catch: JSONException -> L23
            r3.put("follow_status", r9.getFollowStatus());     // Catch: JSONException -> L23
        L25:
            g4.h(r3);
            if (com.bytedance.android.livesdk.utils.c1.b(((Widget) this.a).dataCenter) == false) goto L37;
            ILiveDouPlusService r10 = jc1.k.f(ILiveDouPlusService.class);
            if (r10 == null) goto L51;
            HashMap r6 = new HashMap();
            r6.put("ad_extra_data", r3.toString());
            Map r7 = com.bytedance.android.livesdk.utils.c1.e(((Widget) this.a).dataCenter);
            if (r7 != null) goto L32;
        L35:
            r10.logEvent(true, "live_ad", "follow_success", r6);
            return;
        L32:
            if (r7.isEmpty() == true) goto L35;
            r6.putAll(r7);
            goto L35
        L51:
            return;
        L37:
            if (com.bytedance.android.livesdk.utils.c1.c(((Widget) this.a).dataCenter) == false) goto L53;
            ILiveDouPlusService r11 = jc1.k.f(ILiveDouPlusService.class);
            if (r11 == null) goto L45;
            HashMap r12 = new HashMap();
            r12.put("ad_extra_data", r3.toString());
            Map r13 = com.bytedance.android.livesdk.utils.c1.f(((Widget) this.a).dataCenter);
            if (r13.isEmpty() == true) goto L44;
            r12.putAll(r13);
        L44:
            r11.logEvent(true, "live_ad", "follow_success", r12);
        L45:
            b3.a(((Widget) this.a).dataCenter, r3);
            return;
        L53:
            return;
        L20:
            r5 = null;
        L23:
            e = move-exception;
            e.printStackTrace();
            goto L25
        L50:
            return;
        L13:
            r2 = false;
            goto L14
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
            this.a.a.add(r2);
        }

        public b(LongPressPanelFollowWidget r1, Room r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c extends com.bytedance.android.livesdk.user.h<FollowPair> {
        public final /* synthetic */ LongPressPanelFollowWidget a;
        public final /* synthetic */ Room b;
        public final /* synthetic */ mt1.a c;

        public final void onNext(Object r6) {
            FollowPair r7 = (FollowPair) r6;
            Intrinsics.checkNotNullParameter(r7, "followPair");
            boolean r1 = true;
            if (com.bytedance.android.livesdk.utils.c1.c(((Widget) this.a).dataCenter) == false) goto L21;
            JSONObject r0 = new JSONObject();
            User r3 = this.b.getOwner();     // Catch: JSONException -> L11
            if (r3 == null) goto L8;
            String r4 = r3.getIdStr();     // Catch: JSONException -> L11
        L9:
            r0.put("anchor_id", r4);     // Catch: JSONException -> L11
            r0.put("room_id", String.valueOf(this.b.getId()));     // Catch: JSONException -> L11
        L13:
            ILiveDouPlusService r2 = jc1.k.f(ILiveDouPlusService.class);
            if (r2 == null) goto L21;
            HashMap r5 = new HashMap();
            r5.put("ad_extra_data", r0.toString());
            Map r8 = com.bytedance.android.livesdk.utils.c1.f(((Widget) this.a).dataCenter);
            if (r8.isEmpty() == true) goto L19;
            r5.putAll(r8);
        L19:
            r2.logEvent(true, "live_ad", "follow_cancel", r5);
            goto L21
        L8:
            r4 = null;
        L11:
            e = move-exception;
            e.printStackTrace();
        L21:
            if (CollectionsKt.contains(LongPressPanelFollowWidget.b, this.c.d) == false) goto L24;
            xs2.b.a().post(new zg1.h1(38, this.c.c));
        L24:
            if (this.b.getOwner() != null) goto L26;
            return;
        L26:
            if (((Widget) this.a).dataCenter == null) goto L40;
            User r9 = this.b.getOwner();
            if (r9 == null) goto L31;
            r9.setFollowStatus(r7.getFollowStatus());
        L31:
            DataCenter r10 = ((Widget) this.a).dataCenter;
            if (r7.getFollowStatus() != 0) goto L35;
            r1 = false;
        L35:
            r10.put("data_is_followed", Boolean.valueOf(r1));
            return;
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
            this.a.a.add(r2);
        }

        public c(LongPressPanelFollowWidget r1, Room r2, mt1.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public final class d implements Consumer {
        public final /* synthetic */ Function1 a;

        public d(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.LongPressPanelFollowWidget$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lmt1/a;", "p1", "", "invoke", "(Lmt1/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<mt1.a, Unit> {
        public AnonymousClass1(LongPressPanelFollowWidget r8) {
            super(1, r8, LongPressPanelFollowWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/dislike/event/DislikeMenuEvent;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((mt1.a) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(mt1.a r2) {
            LongPressPanelFollowWidget.wq((LongPressPanelFollowWidget) ((CallableReference) this).receiver, r2);
        }
    }

    static {
        b = CollectionsKt.mutableListOf(new String[]{"homepage_follow", "homepage_follow_ecom", "homepage_ecom_follow"});
    }

    public final Room getRoom() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L7;
        return null;
    L7:
        return com.bytedance.android.live.core.utils.z.o(r0);
    }

    public LongPressPanelFollowWidget() {
        this.a = new CompositeDisposable();
    }

    private final FragmentActivity getActivity() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(getComponentContext());
        if (r0 == null) goto L7;
        Fragment r1 = r0.getFragment();
        if (r1 == null) goto L7;
        return r1.getActivity();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        d r2 = new d(new AnonymousClass1(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(mt1.a.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r2);
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.a.dispose();
    }

    public static final void xq(LongPressPanelFollowWidget r9) {
        r9.getClass();
        JSONObject r0 = new JSONObject();
        Room r2 = r9.getRoom();     // Catch: JSONException -> L16
        if (r2 == null) goto L9;
        User r3 = r2.getOwner();     // Catch: JSONException -> L16
        if (r3 == null) goto L9;
        String r4 = r3.getIdStr();     // Catch: JSONException -> L16
        if (r4 == null) goto L9;
    L10:
        r0.put("anchor_id", r4);     // Catch: JSONException -> L16
        Room r5 = r9.getRoom();     // Catch: JSONException -> L16
        if (r5 == null) goto L13;
        long r6 = r5.id;     // Catch: JSONException -> L16
    L14:
        r0.put("room_id", String.valueOf(r6));     // Catch: JSONException -> L16
    L18:
        g4.h(r0);
        if (com.bytedance.android.livesdk.utils.c1.c(((Widget) r9).dataCenter) == false) goto L29;
        ILiveDouPlusService r1 = jc1.k.f(ILiveDouPlusService.class);
        if (r1 == null) goto L27;
        HashMap r7 = new HashMap();
        r7.put("ad_extra_data", r0.toString());
        Map r8 = com.bytedance.android.livesdk.utils.c1.f(((Widget) r9).dataCenter);
        if (r8.isEmpty() == true) goto L26;
        r7.putAll(r8);
    L26:
        r1.logEvent(true, "live_ad", "follow", r7);
    L27:
        b3.a(((Widget) r9).dataCenter, r0);
    L29:
        if (com.bytedance.android.livesdk.utils.c1.b(((Widget) r9).dataCenter) == false) goto L39;
        ILiveDouPlusService r10 = jc1.k.f(ILiveDouPlusService.class);
        if (r10 == null) goto L39;
        HashMap r11 = new HashMap();
        r11.put("ad_extra_data", r0.toString());
        Map r12 = com.bytedance.android.livesdk.utils.c1.e(((Widget) r9).dataCenter);
        if (r12 != null) goto L35;
    L38:
        r10.logEvent(true, "live_ad", "follow", r11);
        goto L39
    L35:
        if (r12.isEmpty() == true) goto L38;
        r11.putAll(r12);
    L39:
        f2.b(2131919118, 0);
        return;
    L13:
        r6 = 0;
    L9:
        r4 = "";
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public static final void wq(LongPressPanelFollowWidget r6, mt1.a r7) {
        r6.getClass();
        if (r7 == null) goto L5;
        Room r0 = r7.c;
    L6:
        if (r0 == null) goto L38;
        int r1 = r7.getType();
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L13;
        return;
    L13:
        if (r7.getType() != 0) goto L15;
        boolean r2 = true;
    L17:
        if (TTLiveSDKContext.getHostService().h().isLogin() == true) goto L20;
        com.bytedance.android.livesdk.user.f0 r3 = TTLiveSDKContext.getHostService().h();
        Context r4 = r6.getContext();
        com.bytedance.android.livesdk.user.l.a r5 = new com.bytedance.android.livesdk.user.l.a();
        r5.a = CoreSettingUtil.getLoginPromptForFollow();
        r5.b = CoreSettingUtil.getLoginImageForFollow();
        r5.c = 0;
        com.bytedance.android.livesdk.user.f0 r8 = r3;
        Disposable r9 = r8.login(r4, new com.bytedance.android.livesdk.user.l(r5)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e0(r6, r7, r2), f0.a);
        r6.a.add(r9);
        return;
    L20:
        if (r7.f == true) goto L22;
    L32:
        r6.zq(r7, r2);
        return;
    L22:
        if (com.bytedance.android.livesdk.dispatch.utils.a.a() == false) goto L32;
        if (r7.getType() != 0) goto L27;
        Lazy r10 = DispatchLogUtil.a;
        DispatchLogUtil.d(1, DispatchLogUtil.InstanceType.FOLLOW);
        int r11 = tt1.e.a;
        tt1.e.a(r6.getContext(), new c0(r6));
        return;
    L27:
        if (r7.getType() != 1) goto L36;
        FragmentActivity r12 = r6.getActivity();
        if (r12 == null) goto L40;
        com.bytedance.android.livesdk.dispatch.utils.d.a("LiveActivity", r12);
        Lazy r13 = DispatchLogUtil.a;
        DispatchLogUtil.d(1, DispatchLogUtil.InstanceType.UNFOLLOW);
        int r14 = tt1.e.a;
        tt1.e.b(r6.getContext(), new d0(r6, r7));
        return;
    L40:
        return;
    L36:
        return;
    L15:
        r2 = false;
        goto L17
    L38:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static final void yq(LongPressPanelFollowWidget r0, Throwable r1) {
        r0.getClass();
        if ((r1 instanceof ApiServerException) == true) goto L5;
    L7:
        f2.b(2131919116, 0);
        return;
    L5:
        if (s1.getContext() == null) goto L7;
        IESUIUtils.displayToast(s1.getContext(), ((ApiServerException) r1).getPrompt());
    }

    public final void zq(mt1.a r11, boolean r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        Room r0 = r11.c;
        if (r0 != null) goto L7;
        return;
    L7:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = ho1.a.d(getComponentContext());
        if (r1 == null) goto L10;
        r1.p0();
    L10:
        if (r12 == false) goto L16;
        com.bytedance.android.livesdk.user.f0 r13 = TTLiveSDKContext.getHostService().h();
        com.bytedance.android.livesdk.user.b.a r14 = new com.bytedance.android.livesdk.user.d.c().c(r0.getOwnerUserIdString());
        r0.getRequestId();
        com.bytedance.android.livesdk.user.d.c r15 = r14.e();
        r15.getClass();
        com.bytedance.android.livesdk.user.d.c r16 = r15.g("live").h(r0.id);
        r0.getLabels();
        r16.getClass();
        com.bytedance.android.livesdk.user.d.c r17 = r16.f(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.LONG_PRESS));
        r17.getClass();
        String r3 = ((com.bytedance.android.livesdk.user.a.a) r17).a;
        String r6 = ((com.bytedance.android.livesdk.user.a.a) r17).b;
        long r4 = ((com.bytedance.android.livesdk.user.b.a) r17).e;
        HashMap r7 = ((com.bytedance.android.livesdk.user.b.a) r17).f;
        boolean r8 = ((com.bytedance.android.livesdk.user.b.a) r17).g;
        com.bytedance.android.livesdk.user.f0 r2 = r13;
        r2.getClass();
        r2.Q(1, r3, r4, r6, r7, r8).subscribe(new b(this, r0));
        com.bytedance.android.livesdk.log.d.b(((Widget) this).dataCenter, "live_ad", "follow", r0.getAnchorId(), String.valueOf(r0.id));
        com.bytedance.android.live.core.feed.a.a r18 = com.bytedance.android.live.core.feed.a.d;
        if (r18.a().c(Long.valueOf(r0.id)) == false) goto L14;
    L15:
        com.bytedance.android.livesdk.log.d.b(((Widget) this).dataCenter, "draw_ad", "click", r0.getAnchorId(), String.valueOf(r0.id));
        return;
    L14:
        if (r18.a().b(Long.valueOf(r0.id)) == true) goto L15;
        return;
    L16:
        com.bytedance.android.livesdk.user.f0 r19 = TTLiveSDKContext.getHostService().h();
        com.bytedance.android.livesdk.user.n.c r5 = new com.bytedance.android.livesdk.user.n.c().c(r0.getOwnerUserIdString());
        r5.getClass();
        User r9 = r0.getOwner();
        if (r9 == null) goto L21;
        FollowInfo r10 = r9.getFollowInfo();
        if (r10 == null) goto L21;
        r10.getFollowStatus();
    L21:
        com.bytedance.android.livesdk.user.n.c r20 = r5.f(r0.id);
        r20.getClass();
        com.bytedance.android.livesdk.user.n.c r21 = r20.e(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.LONG_PRESS));
        r21.getClass();
        String r22 = ((com.bytedance.android.livesdk.user.a.a) r21).a;
        String r23 = ((com.bytedance.android.livesdk.user.a.a) r21).b;
        HashMap r24 = ((com.bytedance.android.livesdk.user.a.a) r21).c;
        long r25 = ((com.bytedance.android.livesdk.user.m.a) r21).d;
        boolean r26 = ((com.bytedance.android.livesdk.user.m.a) r21).e;
        com.bytedance.android.livesdk.user.f0 r27 = r19;
        r27.getClass();
        r27.Q(0, r22, r25, r23, r24, r26).subscribe(new c(this, r0, r11));
    }
}
