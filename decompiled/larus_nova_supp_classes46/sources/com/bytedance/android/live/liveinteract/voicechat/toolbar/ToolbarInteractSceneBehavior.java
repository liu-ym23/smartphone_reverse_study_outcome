package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.setting.f4;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import pp1.i;
import zg1.b2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/toolbar/ToolbarInteractSceneBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ToolbarInteractSceneBehavior implements c0.b, Observer<KVData> {
    public static final /* synthetic */ int j = 0;
    public View a;
    public boolean b;
    public boolean c;
    public Context d;
    public yo2.e e;
    public final CompositeDisposable f;
    public View g;
    public IRoom h;
    public final LifecycleOwner i;

    public static final class a {
    }

    public static final class b implements js0.b {
        public b() {
        }

        @Override // js0.b
        public final void onSuccess(String r7) {
            Intrinsics.checkNotNullParameter(r7, "track");
            ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).justReportRoomEvent(9, 0, 19, "");
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ToolbarInteractSceneBehavior a;

        public c(ToolbarInteractSceneBehavior r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ToolbarInteractSceneBehavior r0 = this.a;     // Catch: Throwable -> L4
            String r1 = s1.B(2131915770);     // Catch: Throwable -> L4
            int r2 = ToolbarInteractSceneBehavior.j;     // Catch: Throwable -> L4
            r0.a(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ ToolbarInteractSceneBehavior a;

        public d(ToolbarInteractSceneBehavior r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ToolbarInteractSceneBehavior r0 = this.a;     // Catch: Throwable -> L4
            String r1 = s1.B(2131917517);     // Catch: Throwable -> L4
            int r2 = ToolbarInteractSceneBehavior.j;     // Catch: Throwable -> L4
            r0.a(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (((Boolean) f4.a.getValue()).booleanValue() == true) goto L5;
            return;
        L5:
            if (r3.booleanValue() == true) goto L9;
            InteractiveSongContext.Companion.getClass();
            InteractiveSongContext.access$getMicSeatTaskExecutors$cp().clear();
            return;
        }
    }

    public static final class f implements Runnable {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public static void a() {
            HashMap r0 = new HashMap();
            r0.put("action_type", "show");
            r0.put("function_type", ((IInteractService) k.n(IInteractService.class)).getAudioTalkService().getFunctionType());
            j0.l().sendLog("livesdk_anchor_function_icon", r0, new Object[]{IRoom.class});
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ ToolbarInteractSceneBehavior a;

        public g(ToolbarInteractSceneBehavior r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((b2) r2).getType() != 1) goto L8;
            ToolbarInteractSceneBehavior r3 = this.a;
            View r0 = r3.a;
            if (r0 == null) goto L9;
            r3.onClick(r0);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public ToolbarInteractSceneBehavior(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "mLifecycleOwner");
        this.i = r2;
        this.f = new CompositeDisposable();
    }

    public final void a(String r10) {
        yo2.e r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        View r1 = LayoutInflater.from(this.d).inflate(2131566214, null);
        TextView r2 = (TextView) r1.findViewById(2131390805);
        View r3 = r1.findViewById(2131376322);
        r2.setText(r10);
        yo2.e r4 = new yo2.e(this.d);
        ((yo2.d) r4).d = r1;
        ((yo2.d) r4).e = 0;
        ((yo2.d) r4).m = 5;
        ((yo2.d) r4).l = true;
        r4.a();
        this.e = r4;
        View r5 = this.a;
        if (r5 == null) goto L13;
        r4.i(r5, 1, 0, s1.f(1), s1.f(-4));
        if (this.b == false) goto L14;
        UIUtils.updateLayoutMargin(r3, (int) (r5.getX() + (r5.getWidth() / 2)), -3, -3, -3);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r0.h() == false) goto L7;
        r0.d();
        goto L7
    }

    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r9) {
        Intrinsics.checkNotNullParameter(r9, "command");
        if ((r9 instanceof i) == false) goto L9;
        a(s1.B(2131920496));
        View r10 = this.a;
        if (r10 == null) goto L10;
        AnimatorSet r0 = new AnimatorSet();
        r0.playSequentially(new Animator[]{com.bytedance.android.live.core.utils.h.c(r10, new float[]{0.1f}).setDuration(500), com.bytedance.android.live.core.utils.h.c(r10, new float[]{1.0f}).setDuration(500)});
        r0.start();
        return;
    L10:
        return;
    }

    public final void onChanged(Object r7) {
        KVData r8 = (KVData) r7;
        ViewGroup.LayoutParams r0 = null;
        if (r8 == null) goto L5;
        String r1 = r8.getKey();
    L7:
        if (Intrinsics.areEqual(r1, "data_video_talk_dot_with_number_show") == false) goto L52;
        String r9 = (String) r8.getData();
        if (r9 != null) goto L11;
        r9 = "";
    L11:
        View r2 = this.g;
        if ((r2 instanceof TextView) == true) goto L14;
        r2 = null;
    L14:
        TextView r3 = (TextView) r2;
        int r4 = 0;
        if (TextUtils.isEmpty(r9) == false) goto L27;
        if (r3 == null) goto L18;
        r3.setVisibility(8);
    L18:
        View r10 = this.a;
        if (r10 == null) goto L53;
        View r11 = r10.findViewById(2131392581);
        if (r11 != null) goto L23;
        return;
    L23:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.d.e0.getValue(null, com.bytedance.android.livesdk.sharedpref.d.a[55])).booleanValue() == true) goto L26;
        r4 = 8;
    L26:
        r11.setVisibility(r4);
        return;
    L53:
        return;
    L27:
        if (r3 == null) goto L29;
        r3.setText(r9);
    L29:
        if (r3 == null) goto L31;
        r3.setVisibility(0);
    L31:
        View r12 = this.a;
        if (r12 == null) goto L37;
        View r13 = r12.findViewById(2131392581);
        if (r13 == null) goto L37;
        r13.setVisibility(8);
    L37:
        if (this.b == false) goto L56;
        if (r3 == null) goto L40;
        r3.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    L40:
        if (r3 == null) goto L42;
        r0 = r3.getLayoutParams();
    L42:
        if (r0 == null) goto L47;
        if (r3 == null) goto L45;
        r4 = r3.getMeasuredWidth();
    L45:
        r0.width = r4;
    L47:
        if ((r0 instanceof FrameLayout.LayoutParams) == false) goto L49;
        ((FrameLayout.LayoutParams) r0).gravity = 48;
    L49:
        if (r3 == null) goto L57;
        r3.setLayoutParams(r0);
        return;
    L57:
        return;
    L56:
        return;
    L52:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void onClick(View r6) {
        Intrinsics.checkNotNullParameter(r6, "v");
        HashMap r7 = new HashMap();
        r7.put("action_type", "click");
        r7.put("function_type", ((IInteractService) k.n(IInteractService.class)).getAudioTalkService().getFunctionType());
        int r4 = 0;
        j0.l().sendLog("livesdk_anchor_function_icon", r7, new Object[]{IRoom.class});
        tc0.c.h().z = "live_room_show";
        View r8 = this.g;
        if (r8 == null) goto L5;
        r8.setVisibility(8);
    L5:
        com.bytedance.android.live.liveinteract.plantform.base.g r9 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r9 == null) goto L8;
        r4 = r9.getCurrentMode();
    L8:
        if (r4 != 8) goto L15;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r10 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r10 == null) goto L12;
        r10.Gn();
    L12:
        com.bytedance.android.live.liveinteract.plantform.base.g r11 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r11 == null) goto L18;
        r11.ye();
    L18:
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new b()).callbackOnMainThread().syncCallbackIfReady(true).requireByUser("ToolbarInteractSceneBehavior");
        return;
    L15:
        com.bytedance.android.live.liveinteract.plantform.base.g r12 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r12 == null) goto L18;
        r12.Ik(true);
        goto L18
    }

    public final void setAlpha(float r2) {
        View r0 = this.a;
        if (r0 == null) goto L6;
        r0.setAlpha(r2);
        return;
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        View r4 = this.a;
        if (r4 == null) goto L7;
        ViewGroup r5 = (ViewGroup) r4.findViewById(2131374744);
        if (r5 == null) goto L7;
        r5.removeView(this.g);
    L7:
        this.f.clear();
    }

    public final void p4(View r12, DataCenter r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        this.a = r12;
        this.d = r12.getContext();
        this.b = a0.m(r13).c;
        if (m.c() == true) goto L5;
    L58:
        IRoom r0 = (IRoom) r13.get("data_enter_room", null);
        this.h = r0;
        if (r0 != null) goto L61;
        this.h = (IRoom) r13.get("data_room", null);
    L61:
        com.bytedance.android.livesdk.sharedpref.e r1 = b6.d0;
        if (TextUtils.equals((CharSequence) r1.getValue(), "1") == false) goto L65;
        com.bytedance.android.livesdk.sharedpref.f.d(r1, "");
        this.c = true;
        r12.post(new c(this));
    L65:
        if (this.c == false) goto L67;
    L73:
        InteractiveSongContext r14 = InteractiveSongContext.Companion.getContext();
        if (r14 == null) goto L82;
        com.bytedance.live.datacontext.m<Boolean> r15 = r14.m130isOpenInteractiveSong();
        if (r15 == null) goto L82;
        Observable r16 = r15.a();
        if (r16 == null) goto L82;
        Disposable r17 = r16.subscribe(e.a);
        if (r17 == null) goto L82;
        RxUtilKt.c(r17, this.f);
    L82:
        View r18 = this.a;
        if (r18 == null) goto L85;
        r18.post(f.a);
    L85:
        Intrinsics.checkNotNullParameter(r13, "$this$getMiddlewareLiveMode");
        if (((LiveMode) r13.get("data_live_mode", LiveMode.UNDEFINED)) != LiveMode.AUDIO) goto L89;
        this.f.add(xs2.b.a().b(b2.class).subscribe(new g(this)));
        return;
    L89:
        return;
    L67:
        if (vm2.c.e() == false) goto L73;
        if (this.b == false) goto L73;
        com.bytedance.android.livesdk.sharedpref.e r2 = b6.C;
        if (((Boolean) r2.getValue()).booleanValue() == true) goto L73;
        com.bytedance.android.livesdk.sharedpref.f.d(r2, Boolean.TRUE);
        r12.post(new d(this));
        goto L73
    L5:
        if (je0.d.r() == false) goto L58;
        if (je0.d.f() == 0) goto L9;
    L11:
        View r3 = this.a;
        if (r3 == null) goto L20;
        View r4 = r3.findViewById(2131392581);
        if (r4 == null) goto L20;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.d.e0.getValue(null, com.bytedance.android.livesdk.sharedpref.d.a[55])).booleanValue() == false) goto L18;
        int r5 = 0;
    L19:
        r4.setVisibility(r5);
        goto L20
    L18:
        r5 = 8;
    L20:
        Context r6 = this.d;
        if (r6 == null) goto L23;
        FrameLayout r7 = new FrameLayout(r6);
    L24:
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(s1.f(28.0f), s1.f(14.0f));
        r8.leftMargin = s1.f(22.0f);
        r8.setMarginStart(s1.f(22.0f));
        r8.topMargin = s1.f(-6.0f);
        View r9 = this.a;
        if (r9 == null) goto L27;
        ViewGroup r10 = (ViewGroup) r9.findViewById(2131374744);
    L28:
        if (r10 == null) goto L30;
        UtilityKotlinExtentionsKt.w(r10);
    L30:
        if (r10 == null) goto L32;
        r10.addView(r7, r8);
    L32:
        if (r7 == null) goto L34;
        r7.setVisibility(0);
    L34:
        TextView r11 = new TextView(this.d);
        r11.setGravity(17);
        r11.setTextSize(9.0f);
        r11.setTypeface(r11.getTypeface(), 1);
        r11.setPadding(s1.f(5.0f), 0, s1.f(5.0f), 0);
        r11.setBackground(s1.m(2131252487));
        Unit r19 = Unit.INSTANCE;
        this.g = r11;
        FrameLayout.LayoutParams r20 = new FrameLayout.LayoutParams(-2, s1.f(14.0f));
        r20.gravity = 17;
        if ((r7 instanceof ViewGroup) == true) goto L37;
        r7 = null;
    L37:
        if (r7 == null) goto L39;
        r7.setClipChildren(false);
        r7.setClipToPadding(false);
        r7.addView(this.g, r20);
    L39:
        if (r10 == null) goto L41;
        r10.setClipChildren(false);
    L41:
        if (r10 == null) goto L43;
        r10.setClipToPadding(false);
    L43:
        View r21 = this.a;
        if ((r21 instanceof ViewGroup) == true) goto L46;
        r21 = null;
    L46:
        ViewGroup r22 = (ViewGroup) r21;
        if (r22 == null) goto L49;
        r22.setClipChildren(false);
    L49:
        View r23 = this.a;
        if ((r23 instanceof ViewGroup) == true) goto L52;
        r23 = null;
    L52:
        ViewGroup r24 = (ViewGroup) r23;
        if (r24 == null) goto L55;
        r24.setClipToPadding(false);
    L55:
        View r25 = this.g;
        if (r25 == null) goto L58;
        r25.setVisibility(8);
        goto L58
    L27:
        r10 = null;
        goto L28
    L23:
        r7 = null;
        goto L24
    L9:
        if (o.d() != 0) goto L11;
        r13.observe("data_video_talk_dot_with_number_show", this);
        goto L11
    }
}
