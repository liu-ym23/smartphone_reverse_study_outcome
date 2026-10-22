package com.bytedance.android.livesdk.interactivity.asr.widget;

import android.widget.HorizontalScrollView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.j2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.y;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.asr.api.AnchorAsrRetrofitApi;
import com.bytedance.android.livesdk.interactivity.api.asr.utils.AnchorAsrUtils;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.o;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r;
import com.bytedance.android.livesdk.interactivity.api.seek.EpisodeInteractivityTracer;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.i0;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/asr/widget/AnchorAsrHintWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Ll22/b;", "<init>", "()V", "a", "b", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorAsrHintWidget extends LiveRecyclableWidget implements l22.b {
    public static final /* synthetic */ int l = 0;
    public LottieAnimationView a;
    public HorizontalScrollView b;
    public TextView c;
    public String d;
    public String e;
    public boolean f;
    public int g;
    public final Lazy h;
    public Disposable i;
    public CompositeDisposable j;
    public final Map<String, a> k;

    public static final class a {
        public final String a;
        public final Text b;
        public final String c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Text r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "AudioCommentInfo(content=" + this.a + ", text=" + this.b + ", rtfContent=" + this.c + ")";
        }

        public a(String r1, Text r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AnchorAsrHintWidget a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ l22.f d;

        public c(AnchorAsrHintWidget r1, long r2, String r4, l22.f r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        public final void accept(Object r13) {
            Response r14 = (Response) r13;
            long r0 = System.currentTimeMillis() - this.b;
            com.bytedance.android.livesdk.interactivity.api.asr.model.a r2 = (com.bytedance.android.livesdk.interactivity.api.asr.model.a) ((BaseResponse) r14).data;
            if (r2 != null) goto L5;
        L18:
            AnchorAsrHintWidget r3 = this.a;
            int r1 = AnchorAsrHintWidget.l;
            r3.getClass();
            AnchorAsrHintWidget.Aq("match failed cost=" + r0);
            AnchorAsrHintWidget.wq(this.a, this.c, this.d);
        L19:
            String r15 = ((BaseResponse) r14).logId;
            long r4 = this.b;
            int r5 = w52.a.a;
            w52.a.f(InteractivityMonitor.Event.AnchorAsrMatch, r15, r4);
            return;
        L5:
            if (r2.textType == 0) goto L18;
            AnchorAsrHintWidget r6 = this.a;
            String r7 = "match success. textType=" + r2.textType + " isToAll=" + r2.isToAll + " cost=" + r0;
            int r8 = AnchorAsrHintWidget.l;
            r6.zq(r7);
            AnchorAsrHintWidget r9 = this.a;
            String r10 = this.c;
            l22.f r11 = this.d;
            long r16 = r11.f;
            String r17 = r2.content;
            Text r18 = r2.text;
            String r19 = r2.rtfContent;
            String r20 = r11.b;
            r9.getClass();
            int r21 = com.bytedance.android.livesdk.interactivity.api.asr.utils.d.a;
            ((HashMap) r9.k).put(r10, new a(r17, r18, r19));
            r9.Bq(r10, r16, r17, r18, r19, false);
            if (r9.g == 2) goto L9;
        L13:
            int r23 = com.bytedance.android.livesdk.interactivity.api.asr.utils.b.a;
            String r24 = this.d.i;
            int r25 = r2.textType;
            boolean r26 = r2.isToAll;
            Intrinsics.checkNotNullParameter(r24, "triggerType");
            HashMap r27 = new HashMap();
            r27.put("room_id", com.bytedance.android.livesdk.interactivity.api.asr.utils.b.a());
            r27.put("trigger_type", r24);
            r27.put("event_type", String.valueOf(r25));
            if (r26 == false) goto L16;
            String r28 = "1";
        L17:
            r27.put("is_to_all", r28);
            u.l().sendLog("livesdk_anchor_voice_recognition_success", r27, new Object[0]);
            goto L19
        L16:
            r28 = "0";
            goto L17
        L9:
            if (Intrinsics.areEqual(r9.e, r20) == false) goto L13;
            r9.g = 3;
            r9.d = null;
            LottieAnimationView r29 = r9.a;
            if (r29 == null) goto L13;
            r29.pauseAnimation();
            r29.loop(false);
            r29.setMinAndMaxFrame(50, 79);
            r29.addAnimatorListener(new com.bytedance.android.livesdk.interactivity.asr.widget.a(System.currentTimeMillis(), r9, r20));
            r29.resumeAnimation();
            ((q4.b) r9.h.getValue()).c();
            goto L13
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ AnchorAsrHintWidget a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ l22.f d;

        public d(AnchorAsrHintWidget r1, long r2, String r4, l22.f r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            com.bytedance.android.livesdk.interactivity.api.asr.utils.c.b("match failed cost=" + (System.currentTimeMillis() - this.b), r6);
            AnchorAsrHintWidget.wq(this.a, this.c, this.d);
            long r0 = this.b;
            int r2 = w52.a.a;
            w52.a.e(InteractivityMonitor.Event.AnchorAsrMatch, r6, r0);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ AnchorAsrHintWidget a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ String e;
        public final /* synthetic */ long f;

        public e(AnchorAsrHintWidget r1, long r2, String r4, boolean r5, String r6, long r7) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        public final void accept(Object r7) {
            Response r8 = (Response) r7;
            AnchorAsrHintWidget r0 = this.a;
            String r1 = "send anchor audio comment success. cost=" + (System.currentTimeMillis() - this.b);
            int r2 = AnchorAsrHintWidget.l;
            r0.zq(r1);
            com.bytedance.android.livesdk.interactivity.api.asr.model.c r3 = (com.bytedance.android.livesdk.interactivity.api.asr.model.c) ((BaseResponse) r8).data;
            User r4 = r3.user;
            kc2.a r5 = kc2.d.a(this.c);
            r5.isResend = this.d;
            r5.sendStatus = 0;
            r5.msgId = String.valueOf(r3.msgId);
            r5.content = this.e;
            r5.setRtfContent(r3.rtfContent);
            r5.updateField = 13;
            MessageIdentity r6 = new MessageIdentity();
            r6.setShowIdentity(r3.b());
            r6.setIdentityLabel(r3.a());
            r5.setMessageIdentity(r6);
            if (r4 != null) goto L5;
        L7:
            r5.userInfo = r3.user;
            r5.updateField |= 16;
            r5.audioDuration = this.f;
            r5.setHttpSendTime(this.b);
            r.d(r5, PSMessageAction.SYSTEM);
            AnchorAsrHintWidget.xq(r5, ((Widget) this.a).dataCenter);
            AnchorAsrHintWidget r9 = this.a;
            if (r9.f == false) goto L12;
            r9.f = false;
            if (((Boolean) com.bytedance.android.livesdk.interactivity.api.asr.utils.a.a.getValue()).booleanValue() == false) goto L12;
            xs2.b.a().post(new l22.g());
        L12:
            ((HashMap) this.a.k).remove(this.c);
            String r10 = ((BaseResponse) r8).logId;
            long r11 = this.b;
            int r13 = w52.a.a;
            w52.a.f(InteractivityMonitor.Event.AnchorAsrSendComment, r10, r11);
            return;
        L5:
            if (q0.a(r4.getIdStr()) == false) goto L7;
            ((HashMap) com.bytedance.android.livesdk.interactivity.api.comment.data.b.a).put(r4.getIdStr(), r6);
            goto L7
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ AnchorAsrHintWidget a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ long d;
        public final /* synthetic */ long e;

        public f(AnchorAsrHintWidget r1, String r2, boolean r3, long r4, long r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            com.bytedance.android.livesdk.interactivity.api.asr.utils.c.b("send audio comment failed", r5);
            kc2.a r0 = kc2.d.a(this.b);
            r0.isResend = this.c;
            r0.sendStatus = 1;
            r0.updateField = 1;
            r0.audioDuration = this.d;
            AnchorAsrHintWidget.xq(r0, ((Widget) this.a).dataCenter);
            long r1 = this.e;
            int r2 = w52.a.a;
            w52.a.e(InteractivityMonitor.Event.AnchorAsrSendComment, r5, r1);
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ AnchorAsrHintWidget a;

        public g(AnchorAsrHintWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HorizontalScrollView r0 = this.a.b;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.fullScroll(66);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565133;
    }

    public final void reset() {
        this.g = 0;
        this.e = BuildConfig.FLAVOR;
        q4.b r1 = null;
        this.d = null;
        LottieAnimationView r2 = this.a;
        if (r2 != null) goto L5;
    L10:
        q4.b r3 = (q4.b) this.h.getValue();
        if (r3.b() == false) goto L13;
        r1 = r3;
    L13:
        if (r1 == null) goto L15;
        r1.a();
    L15:
        TextView r4 = this.c;
        if (r4 == null) goto L18;
        r4.setText(BuildConfig.FLAVOR);
    L18:
        TextView r0 = this.c;
        if (r0 == null) goto L21;
        r0.setTextColor(ColorProtector.parseColor("#80FFFFFF"));
    L21:
        UtilityKotlinExtentionsKt.t(((Widget) this).contentView);
        return;
    L5:
        if (r2.isAnimating() == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L10;
        r2.cancelAnimation();
        goto L10
    }

    public final void onUnload() {
        zq("onUnload");
        reset();
        ((HashMap) this.k).clear();
        CompositeDisposable r0 = this.j;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        l22.c r1 = null;
        this.j = null;
        Disposable r2 = this.i;
        if (r2 == null) goto L8;
        r2.dispose();
    L8:
        this.i = null;
        int r3 = AnchorAsrUtils.a;
        com.bytedance.android.livesdk.interactivity.api.f r4 = o.b();
        if (r4 == null) goto L15;
        j<l22.a> r5 = r4.getAnchorAsrContext();
        if (r5 == null) goto L15;
        l22.a r6 = (l22.a) r5.getValue();
        if (r6 == null) goto L15;
        r1 = r6.getAnchorAsrManager();
    L15:
        if (r1 == null) goto L18;
        r1.c(this);
        return;
    }

    public AnchorAsrHintWidget() {
        this.e = BuildConfig.FLAVOR;
        this.f = true;
        this.h = LazyKt.lazy(new AnchorAsrHintWidget$textColorAnimator$2(this));
        this.k = new HashMap();
    }

    public static void Aq(String r2) {
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("HintWidget: " + r2);
    }

    public final void Cq(String r4) {
        int r0 = r4.length();
        String r1 = this.d;
        boolean r2 = false;
        if (r1 == null) goto L5;
        int r3 = r1.length();
    L6:
        if (r0 >= r3) goto L13;
        StringBuilder r5 = new StringBuilder("curResult is longer than result. curLength=");
        String r6 = this.d;
        if (r6 == null) goto L10;
        Integer r7 = Integer.valueOf(r6.length());
    L11:
        r5.append(r7);
        Aq(r5.toString());
        return;
    L10:
        r7 = null;
        goto L11
    L13:
        UtilityKotlinExtentionsKt.w(((Widget) this).contentView);
        this.d = r4;
        TextView r8 = this.c;
        if (r8 != null) goto L16;
    L21:
        HorizontalScrollView r9 = this.b;
        if (r9 == null) goto L25;
        r9.post(new g(this));
        return;
    L25:
        return;
    L16:
        if (r4.length() <= 0) goto L18;
        r2 = true;
    L18:
        if (r2 == false) goto L20;
        r4 = r4.concat("...");
    L20:
        r8.setText(r4);
        goto L21
    L5:
        r3 = 0;
        goto L6
    }

    @Override // l22.b
    public final void Vm(l22.f r13) {
        Intrinsics.checkNotNullParameter(r13, "info");
        if (this.g == 1) goto L5;
    L26:
        Aq("complete asr failed. state=" + this.g + " curId=" + this.e + " id=" + r13.b);
        return;
    L5:
        if (Intrinsics.areEqual(this.e, r13.b) == false) goto L26;
        zq("onAsrComplete id=" + r13.b);
        String r0 = r13.g;
        if (r0 != null) goto L11;
        reset();
        return;
    L11:
        if (r13.c.length() > r13.i.length()) goto L14;
        reset();
        return;
    L14:
        this.g = 2;
        long r7 = System.currentTimeMillis();
        int r1 = com.bytedance.android.livesdk.interactivity.api.asr.utils.a.b().n();
        String r2 = null;
        if (r1 <= 0) goto L19;
        l22.e r3 = AnchorAsrUtils.b();
        if (r3 == null) goto L22;
        List<com.bytedance.android.livesdk.interactivity.api.asr.model.b> r4 = r3.c(r13.d, r1);
    L23:
        if (r4 == null) goto L25;
        r2 = GsonProtectorUtils.toJson(GsonHelper.get(), r4);
    L25:
        ((AnchorAsrRetrofitApi) com.bytedance.android.live.network.c.b().e(AnchorAsrRetrofitApi.class)).match(r13.c, r13.i, r2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r7, r0, r13), new d(this, r7, r0, r13));
        return;
    L22:
        r4 = null;
        goto L23
    L19:
        l22.e r5 = AnchorAsrUtils.b();
        if (r5 == null) goto L22;
        long r6 = r13.d;
        r4 = r5.d(r6 - 5000, r6);
        goto L23
    }

    @Override // l22.b
    public final void Yp(String r3) {
        Intrinsics.checkNotNullParameter(r3, "id");
        if (this.g == 1) goto L5;
    L7:
        Aq("interrupt failed. state=" + this.g + " curId=" + this.e + " id=" + r3);
        return;
    L5:
        if (Intrinsics.areEqual(this.e, r3) == false) goto L7;
        reset();
        zq("onAsrInterrupted id=" + r3);
    }

    public final void onInit(Object[] r1) {
        this.a = findViewById(2131362943);
        this.b = (HorizontalScrollView) findViewById(2131385217);
        this.c = (TextView) findViewById(2131363255);
    }

    public final void onLoad(Object[] r4) {
        zq("onLoad");
        this.j = new CompositeDisposable();
        this.g = 0;
        UtilityKotlinExtentionsKt.t(((Widget) this).contentView);
        int r5 = y.a;
        y.a(((Widget) this).dataCenter, this.j, "AnchorAsrHintWidget#onLoad", new AnonymousClass1(this));
        Function1<u22.a, Unit> r0 = new AnonymousClass2(this);
        ((ObservableSubscribeProxy) xs2.b.a().b(u22.a.class).as(autoDispose())).subscribe(new com.bytedance.android.livesdk.interactivity.asr.widget.b(r0));
    }

    public final void zq(String r3) {
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("HintWidget: " + r3);
    }

    public static void xq(com.bytedance.android.live.base.model.message.r r4, DataCenter r5) {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, r5, 0, 2);
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.isVSFirstShow() == false) goto L19;
        yq(r4, r5);
        EpisodeInteractivityTracer.a("insert seek time message manager");
        IRoomContextService r2 = k.f(IRoomContextService.class);
        if (r2 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.o r6 = IRoomContextService.a.a(r2, r5, 0, 2);
        if (r6 == null) goto L27;
        j r7 = r6.K1();
        if (r7 == null) goto L23;
        vlc.d r8 = (vlc.d) r7.getValue();
        if (r8 == null) goto L24;
        r8.j(r4, true);
        return;
    L24:
        return;
    L23:
        return;
    L27:
        return;
    L22:
        return;
    L19:
        yq(r4, r5);
        return;
    }

    public static void yq(com.bytedance.android.live.base.model.message.r r4, DataCenter r5) {
        EpisodeInteractivityTracer.a("insert real time message manager");
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.o r6 = IRoomContextService.a.a(r0, r5, 0, 2);
        if (r6 == null) goto L16;
        j r7 = r6.getMessageManager();
        if (r7 == null) goto L14;
        vlc.d r8 = (vlc.d) r7.getValue();
        if (r8 == null) goto L15;
        r8.j(r4, true);
        return;
    L15:
        return;
    L14:
        return;
    L16:
        return;
    }

    @Override // l22.b
    public final void J0(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter(r4, "result");
        if (this.g == 1) goto L5;
    L7:
        Aq("show asr result failed. state=" + this.g + " curId=" + this.e + " id=" + r3);
        return;
    L5:
        if (Intrinsics.areEqual(this.e, r3) == false) goto L7;
        Cq(r4);
    }

    @Override // l22.b
    public final void Jh(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter(r4, "keyword");
        zq("onAsrStart id=" + r3);
        reset();
        this.g = 1;
        this.e = r3;
        Cq(r4);
        LottieAnimationView r5 = this.a;
        if (r5 == null) goto L6;
        r5.removeAllAnimatorListeners();
        r5.setMinAndMaxFrame(0, 50);
        r5.loop(true);
        r5.playAnimation();
        return;
    }

    public static final void wq(AnchorAsrHintWidget r4, String r5, l22.f r6) {
        r4.getClass();
        int r0 = com.bytedance.android.livesdk.interactivity.api.asr.utils.d.a;
        File r1 = new PolarisFileWrapper(r5);     // Catch: Exception -> L10
        if (r1.exists() == true) goto L7;
        r1 = null;
    L7:
        if (r1 == null) goto L13;
        r1.delete();     // Catch: Exception -> L10
    L13:
        if (r4.g == 2) goto L15;
    L17:
        int r7 = com.bytedance.android.livesdk.interactivity.api.asr.utils.b.a;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.b.b(r6.i);
        return;
    L15:
        if (Intrinsics.areEqual(r4.e, r6.b) == false) goto L17;
        r4.reset();
    L10:
        e = move-exception;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.b("delete " + r5 + " failed", e);
        SafetyGuard.a("AnchorAsr delete anchor audio failed", e, null);
        goto L13
    }

    public final void Bq(String r17, long r18, String r20, Text r21, String r23, boolean r24) {
        if (r20 != null) goto L6;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("send audio comment failed. content is null");
        return;
    L6:
        if (r21 != null) goto L9;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("send audio comment failed. text is null");
        return;
    L9:
        if (r23 != null) goto L13;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("send audio comment failed. rtfContent is null");
        return;
    L13:
        if (new PolarisFileWrapper(r17).exists() == true) goto L16;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("file " + r17 + " not exists");
        return;
    L16:
        IBaseUser r5 = null;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L44;
        m r2 = r1.getRoom();
        if (r2 == null) goto L45;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L46;
        long r4 = r3.getRoomId();
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L28;
        IBaseUser r7 = (IUser) r6.get("data_user_in_room");
        if (r7 == null) goto L28;
        r5 = r7;
    L34:
        if (r24 == false) goto L36;
        kc2.a r8 = kc2.d.a(r17);
        r8.updateField = 1;
    L37:
        r8.setSendStatus(2);
        r.d(r8, PSMessageAction.SYSTEM);
        if (r5 != null) goto L40;
    L42:
        xq(r8, ((Widget) this).dataCenter);
        long r13 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r17, "audioPath");
        AnchorAsrRetrofitApi r9 = (AnchorAsrRetrofitApi) com.bytedance.android.live.network.c.b().e(AnchorAsrRetrofitApi.class);
        HashMap<String, String> r10 = new HashMap();
        r10.put("room_id", String.valueOf(r4));
        r10.put("audio_duration", String.valueOf(r18));
        r10.put("content", r20);
        r10.put("rtf_content", r23);
        r9.sendAudioChat(r10, new TypedFile("application/octet-stream", new PolarisFileWrapper(r17))).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this, r13, r17, r24, r20, r18), new f(this, r17, r24, r18, r13));
        return;
    L40:
        if (q0.a(r5.getIdString()) == false) goto L42;
        r8.setMessageIdentity((MessageIdentity) ((HashMap) com.bytedance.android.livesdk.interactivity.api.comment.data.b.a).get(r5.getIdString()));
        goto L42
    L36:
        r8 = new i0();
        CommonMessageData r11 = new CommonMessageData();
        r11.roomId = r4;
        r11.showMsg = true;
        MessageType r14 = MessageType.AUDIO_CHAT;
        r11.method = r14.getWsMethod();
        r8.setBaseMessage(r11);
        r8.setAudioPath(r17);
        r8.setAudioDuration(r18);
        User.Companion.getClass();
        r8.setUserInfo(User.a.a(r5));
        r8.setMessageMethod(r14.getWsMethod());
        r8.setReadStatus(1);
        ((i0) r8).isAnchorAsrResult = true;
        ((o0) r8).isLocalInsertMsg2 = true;
    L28:
        int r15 = j2.a;
        IUserService r16 = k.f(IUserService.class);
        if (r16 == null) goto L34;
        com.bytedance.android.livesdk.user.f r19 = r16.user();
        if (r19 == null) goto L34;
        r5 = r19.b();
        goto L34
    L46:
        return;
    L45:
        return;
    }
}
