package com.bytedance.android.live.liveinteract.plantform.widgt.videolink;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.component.MultiComponentManager;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.spatial.SpatialAudioStrategyManager;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget;
import com.bytedance.android.live.liveinteract.spatial.SpatialAudioContext;
import com.bytedance.android.live.liveinteract.videotalk.utils.b0;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.db0;
import com.bytedance.android.livesdk.config.ib1;
import com.bytedance.android.livesdk.config.ph;
import com.bytedance.android.livesdk.config.ps;
import com.bytedance.android.livesdk.config.v11;
import com.bytedance.android.livesdk.utils.g0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.live.bizlink.api.business.anchor2guest.base.BizLinkServiceType;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import hg6.g;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tf0.o;
import ti6.f;
import yb6.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/widgt/videolink/MultiLinkVideoBaseAnchorLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/widgt/MultiLinkBaseAnchorLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "", "Lhe0/c$a;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MultiLinkVideoBaseAnchorLinkWidget extends MultiLinkBaseAnchorLinkWidget<ILinkPlayerInfoBridge> implements he0.c.a {
    public x0 p;
    public he0.c q;
    public int r;
    public uf0.d s;
    public uf0.c t;
    public final v0 u;
    public final com.bytedance.android.live.pushstream.d v;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Ref.ObjectRef a;

        public b(Ref.ObjectRef r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            c9 r5 = (c9) this.a.element;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Ref.ObjectRef a;

        public c(Ref.ObjectRef r1) {
            this.a = r1;
        }

        public final void a() {
            c9 r0 = (c9) this.a.element;
            Handler r1 = DialogLancet.resolveDialogHandler(r0);
            if (r1 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r0);
            r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r0);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r0);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r2 == null) goto L16;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r1.getLooper()) goto L7;
            r1.post(DialogLancet.createDismissRunnable(r0));
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

    public static final class d extends vb6.a {
        public final /* synthetic */ MultiLinkVideoBaseAnchorLinkWidget a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ d a;

            public a(d r1) {
                this.a = r1;
            }

            public final void accept(Object r1) {
                Boolean r2 = (Boolean) r1;
                g r3 = this.a.a.R1();
                if (r3 == null) goto L6;
                r3.f();
                return;
            }
        }

        public static final class b<T> implements Consumer {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Throwable r2 = (Throwable) r1;
            }
        }

        public static final class c<T> implements Consumer {
            public final /* synthetic */ d a;

            public c(d r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                int r4 = ((Number) r3).intValue();
                jy0.b.a("SpatialAudio_audio_talk_context", "CurrentStrategyId onValueChanged " + r4 + "isEnable : " + com.bytedance.android.live.liveinteract.spatial.a.e(r4));
                g r0 = this.a.a.R1();
                if (r0 == null) goto L6;
                r0.i(com.bytedance.android.live.liveinteract.spatial.a.e(r4));
            L6:
                if (com.bytedance.android.live.liveinteract.spatial.a.e(r4) == false) goto L11;
                o r5 = b0.c();
                if (r5 == null) goto L12;
                r5.u(Boolean.TRUE);
                return;
            L12:
                return;
            }
        }

        public d(MultiLinkVideoBaseAnchorLinkWidget r1) {
            this.a = r1;
        }

        public final void Zk(long r1, ei6.a r3) {
            Intrinsics.checkNotNullParameter(r3, "client");
            g r2 = this.a.R1();
            if (r2 == null) goto L5;
            r2.i(com.bytedance.android.live.liveinteract.spatial.a.e(this.a.C0()));
        L5:
            SpatialAudioStrategyManager.c.a();
            SpatialAudioContext r4 = SpatialAudioContext.Companion.getContext();
            Intrinsics.checkNotNull(r4);
            Disposable r5 = r4.getCurrentStrategyId().a().subscribe(new c(this));
            this.a.m.add(r5);
            m r6 = com.bytedance.android.live.liveinteract.api.utils.m.e(this.a).I1();
            if (r6 == null) goto L15;
            Observable r7 = r6.a();
            if (r7 == null) goto L16;
            Observable r8 = r7.observeOn(AndroidSchedulers.mainThread());
            if (r8 == null) goto L17;
            ObservableSubscribeProxy r9 = (ObservableSubscribeProxy) r8.as(this.a.autoDispose());
            if (r9 == null) goto L18;
            r9.subscribe(new a(this), b.a);
            return;
        L18:
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final int Aq() {
        return 16;
    }

    @Override // he0.c.a
    public int C0() {
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public void H1() {
    }

    @Override // he0.c.a
    public List<Integer> R4() {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return 8;
    }

    @Override // he0.c.a
    public int getUILayout() {
        return 0;
    }

    @Override // he0.c.a
    public int i1() {
        return 0;
    }

    @Override // he0.c.a
    public int q0(List<f> r2, Map<String, Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Intrinsics.checkNotNullParameter(r3, "posMap");
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onCreate() {
        Lazy r0 = MultiComponentManager.e;
        MultiComponentManager.a.a().a(this, ((Widget) this).context, ((Widget) this).dataCenter);
        zq().init(((Widget) this).context);
        sg6.b r1 = wq();
        if (r1 == null) goto L5;
        r1.b(BizLinkServiceType.VideoAnchor, ((Widget) this).context);
    L5:
        super.onCreate();
        vb6.g r2 = zq().O5();
        if (r2 == null) goto L8;
        e r3 = r2.j();
    L9:
        if (r3 == null) goto L11;
        r3.s0(gc6.b.c(this.u, null), "MultiLinkVideoBaseAnchorLinkWidget create with live stream live client");
    L11:
        g r4 = R1();
        if (r4 == null) goto L14;
        r4.p(this);
    L14:
        g r5 = R1();
        if (r5 == null) goto L20;
        xi0.b r6 = r5.O();
        if (r6 == null) goto L21;
        r6.p(this);
        return;
    L21:
        return;
    L20:
        return;
    L8:
        r3 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public void yi() {
        he0.c r0 = this.q;
        if (r0 == null) goto L6;
        r0.c("MultiLinkVideoBaseAnchorLinkWidget onEngineEndSuccess");
        return;
    }

    public static boolean Iq() {
        Integer r0 = je0.d.h();
        if (r0 != null) goto L6;
    L7:
        Integer r1 = je0.d.h();
        if (r1 != null) goto L11;
    L21:
        return false;
    L11:
        if (r1.intValue() != 58) goto L21;
    L13:
        if (je0.d.D() == false) goto L21;
        DigitAvatarContext r2 = DigitAvatarContext.Companion.getContext();
        if (r2 == null) goto L17;
        VideoShowMode r3 = r2.getCurrentVideoShowMode();
    L19:
        if (r3 != VideoShowMode.AUDIO) goto L21;
        return true;
    L17:
        r3 = null;
        goto L19
    L6:
        if (r0.intValue() == 56) goto L13;
        goto L7
    }

    public final xf6.a Gq() {
        rf6.a r0 = wq();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onDestroy() {
        super.onDestroy();
        sg6.b r0 = wq();
        if (r0 == null) goto L5;
        r0.j(null);
    L5:
        he0.c r1 = this.q;
        if (r1 == null) goto L9;
        r1.c("MultiLinkVideoBaseAnchorLinkWidget onDestroy");
    L9:
        if (vm2.d.j0() == false) goto L21;
        he0.c r2 = this.q;
        if (r2 == null) goto L21;
        fi6.a r3 = r2.d;
        if (r3 == null) goto L15;
        r3.f = null;
    L15:
        j1 r4 = r2.c;
        if (r4 == null) goto L21;
        dn0.c r5 = (dn0.c) r4.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r5 == null) goto L20;
        r5.H4("videoTalkRoomStreamMixer onDestory");
    L20:
        r2.c = null;
    L21:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.e.c.getClass();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.e.a.c("mixer destroy", null, this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final void u0() {
        if (Iq() == false) goto L8;
        com.bytedance.android.live.liveinteract.plantform.camera.b.o0.getClass();
        com.bytedance.android.live.liveinteract.plantform.camera.b r0 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
        if (r0 == null) goto L9;
        r0.g();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final y xq() {
        return yq();
    }

    public final void Jq(boolean r4) {
        if (r4 == true) goto L4;
        x0 r5 = this.p;
        if (r5 != null) goto L18;
        return;
    L18:
        if (r5.isShowing() == false) goto L47;
        Handler r0 = DialogLancet.resolveDialogHandler(r5);
        if (r0 != null) goto L22;
    L24:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L27 Exception -> L29
    L33:
        DialogLancet.afterDialogDismiss(r5);
        return;
    L27:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L29:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L27
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L27
        if (r1 == null) goto L33;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L27
        goto L33
    L22:
        if (Looper.myLooper() == r0.getLooper()) goto L24;
        r0.post(DialogLancet.createDismissRunnable(r5));
        return;
    L47:
        return;
    L4:
        if (this.p != null) goto L6;
        Context r6 = getContext();
        x0.d r2 = new x0.d();
        r2.b = r6;
        r2.a = 2;
        r2.d = r6.getText(2131919231);
        this.p = new x0(r2.b, r2);
    L6:
        x0 r7 = this.p;
        if (r7 != null) goto L9;
        return;
    L9:
        if (r7.isShowing() == false) goto L11;
        return;
    L11:
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L41;
        DialogLancet.handleBlockedDialogShow(r7);
        return;
    L41:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L37
    L14:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
    }

    public final void Kq(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.put("data_video_talk_dot_with_number_show", "");
    L5:
        HashMap r1 = g0.a;
        g0.c r2 = g0.b.a("on_end_video_talk_click", null);
        if (r2 == null) goto L8;
        r2.b();
    L8:
        xf6.a r3 = Gq();
        if (r3 == null) goto L11;
        r3.finish(r4);
    L11:
        DataCenter r5 = ((Widget) this).dataCenter;
        Boolean r6 = Boolean.FALSE;
        if (((Boolean) r5.get("data_talk_room_admin_allowed_flag", r6)).booleanValue() == false) goto L15;
        TalkRoomLogUtils.q1("live_chat", ((Boolean) com.bytedance.android.livesdk.sharedpref.c.v1.getValue()).booleanValue());
        ((Widget) this).dataCenter.put("data_talk_room_admin_allowed_flag", r6);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final void be(ExtraResponse<? extends IJoinChannelResult, Extra> r6) {
        Intrinsics.checkNotNullParameter(r6, "response");
        if (k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getChannelId() == 0) goto L6;
        f2.b(2131917544, 0);
        Kq("");
        return;
    L6:
        cg6.a r0 = zq();
        if (r0 == null) goto L11;
        vb6.g r1 = r0.O5();
        if (r1 == null) goto L11;
        r1.X0(new d(this), false);
    L11:
        Jq(false);
        Map r7 = getMRoom().getAnchorABMap();
        if (r7 == null) goto L14;
        String r8 = (String) r7.get("audience_linkmic_continue");
    L16:
        if (Intrinsics.areEqual("2", r8) == false) goto L21;
        y r9 = yq();
        if (r9 == null) goto L22;
        r9.r0();
        return;
    L22:
        return;
    L21:
        return;
    L14:
        r8 = null;
        goto L16
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final void m0(Throwable r2) {
        if (this.r != 12) goto L6;
        Kq("stop_normally");
        this.r = 0;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public void G9(long r1, Exception r3) {
        he0.c r2 = this.q;
        if (r2 == null) goto L6;
        r2.c("MultiLinkVideoBaseAnchorLinkWidget onEndFailed");
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f0(long r4, Exception r6) {
        db0 r5 = db0.a;
        boolean r7 = false;
        if (((ib1) r5.getValue()).a() != true) goto L11;
        DigitAvatarContext r8 = DigitAvatarContext.Companion.getContext();
        if (r8 == null) goto L7;
        VideoShowMode r9 = r8.getCurrentVideoShowMode();
    L9:
        if (r9 != VideoShowMode.DIGIT_AVATAR) goto L11;
        boolean r10 = true;
    L13:
        if (((Boolean) ps.a.getValue()).booleanValue() == true) goto L15;
    L17:
        if (r10 == true) goto L19;
        if (r7 == true) goto L19;
        return;
    L19:
        zg1.m r11 = new zg1.m();
        r11.a = 1;
        ((Widget) this).dataCenter.put("data_broadcast_pause_state", r11);
        if (((ib1) r5.getValue()).b() != true) goto L34;
        if (r10 == false) goto L23;
        String r12 = s1.B(2131918052);
    L24:
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        c9 r0 = new c9(((Widget) this).context);
        r13.element = r0;
        r0.c(r12);
        c9 r14 = (c9) r13.element;
        r14.h.setText(s1.B(2131918051));
        c9 r15 = (c9) r13.element;
        r15.h.setOnClickListener(new b(r13));
        ((c9) r13.element).e.postDelayed(new c(r13), (((v11) ph.a.getValue()).pauseDuration * 60) * 1000);
        c9 r16 = (c9) r13.element;
        if (DialogLancet.shouldBlockDialogShow(r16) == false) goto L31;
        DialogLancet.handleBlockedDialogShow(r16);
        return;
    L31:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L30
    L28:
        DialogLancet.beforeDialogShow(r16);
        r16.show();
        DialogLancet.afterDialogShow(r16);
        return;
    L23:
        r12 = s1.B(2131918054);
        goto L24
    L34:
        return;
    L15:
        if (Iq() == false) goto L17;
        r7 = true;
        goto L17
    L7:
        r9 = null;
    L11:
        r10 = false;
        goto L13
    }

    public MultiLinkVideoBaseAnchorLinkWidget(v0 r2, com.bytedance.android.live.pushstream.d r3, tc0.c r4) {
        Intrinsics.checkNotNullParameter(r2, "videoClientFactory");
        Intrinsics.checkNotNullParameter(r3, "mLiveStream");
        Intrinsics.checkNotNullParameter(r4, "dataHolder");
        super(r4);
        this.u = r2;
        this.v = r3;
    }
}
