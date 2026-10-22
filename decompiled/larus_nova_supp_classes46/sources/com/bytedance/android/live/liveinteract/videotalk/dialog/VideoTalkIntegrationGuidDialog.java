package com.bytedance.android.live.liveinteract.videotalk.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/dialog/VideoTalkIntegrationGuidDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoTalkIntegrationGuidDialog extends CommonBottomDialog {
    public static final /* synthetic */ int k = 0;
    public final CompositeDisposable a;
    public final Animation b;
    public final Animation c;
    public final Animation d;
    public final Animation e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final DataCenter j;

    public static final class a {
    }

    public static final class b implements Animation.AnimationListener {
        public final /* synthetic */ VideoTalkIntegrationGuidDialog a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public b(VideoTalkIntegrationGuidDialog r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r4) {
            CommonBottomDialog r5 = this.a;
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

    public static final class c implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ VideoTalkIntegrationGuidDialog a;

        public c(VideoTalkIntegrationGuidDialog r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r2, boolean r3) {
            VideoTalkIntegrationGuidDialog r4 = this.a;
            if (vm2.d.h0().a() == false) goto L7;
            if (r3 == true) goto L6;
            r3 = true;
            goto L7
        L6:
            r3 = false;
        L7:
            r4.i = r3;
            this.a.N0();
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ VideoTalkIntegrationGuidDialog a;

        public d(VideoTalkIntegrationGuidDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ((ImageView) this.a.findViewById(2131376719)).setBackgroundResource(2131253276);
            ((ImageView) this.a.findViewById(2131376219)).setBackgroundColor(0);
            VideoTalkIntegrationGuidDialog r3 = this.a;
            r3.h = false;
            r3.N0();
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ VideoTalkIntegrationGuidDialog a;

        public e(VideoTalkIntegrationGuidDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ((ImageView) this.a.findViewById(2131376219)).setBackgroundResource(2131253276);
            ((ImageView) this.a.findViewById(2131376719)).setBackgroundColor(0);
            VideoTalkIntegrationGuidDialog r3 = this.a;
            r3.h = true;
            r3.N0();
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ VideoTalkIntegrationGuidDialog a;

        public f(VideoTalkIntegrationGuidDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r12) {
            VideoTalkIntegrationGuidDialog r13 = this.a;
            boolean r0 = r13.f;
            boolean r1 = r13.h;
            if (r0 != r1) goto L11;
            boolean r2 = r13.g;
            boolean r4 = r13.i;
            if (r2 == r4) goto L11;
            rj0.k.m2.getClass();
            rj0.k r3 = rj0.k.a.a();
            if (r3 == null) goto L9;
            r3.j6(r4, null);
        L9:
            r13.M0();
        L49:
            this.a.M0();
            rj0.k.m2.getClass();
            rj0.k r14 = rj0.k.a.a();
            if (r14 == null) goto L53;
            r14.v0(0, "integration", -1, null);
            return;
        L53:
            return;
        L11:
            if (r1 == false) goto L13;
            int r5 = 12;
        L14:
            boolean r6 = r13.i;
            HashMap r7 = new HashMap();
            r7.put("live_type", "video_live");
            com.bytedance.live.datacontext.j r8 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
            if (r8 == null) goto L21;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r9 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r8.getValue();
            if (r9 == null) goto L21;
            com.bytedance.android.livesdk.chatroom.viewmodel.j r10 = r9.t();
            if (r10 == null) goto L21;
            TalkRoomLogUtils.B0(r7, Integer.valueOf(r10.a), null, 4);
        L21:
            TalkRoomLogUtils.Q0(r7);
            if (r5 != 12) goto L24;
            String r11 = "party";
        L25:
            r7.put("selection", r11);
            int r15 = 1;
            j0.l().sendLog("livesdk_anchor_audience_connection_layout_change", r7, new Object[]{IRoom.class});
            com.bytedance.live.datacontext.j r16 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
            if (r16 == null) goto L36;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r17 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r16.getValue();
            if (r17 == null) goto L36;
            com.bytedance.android.livesdk.chatroom.viewmodel.j r18 = r17.t();
            if (r18 == null) goto L36;
            ALogger.d("VideoTalkIntegrationGuidDialog", "switchScene current " + r18 + " toScene:" + r5 + " dynamicSeat:" + r6);
            if (r18.a != r5) goto L36;
            if (d0.e(r18.b) == r6) goto L49;
        L36:
            r13.j.put("data_room_video_talk_log_open_success_for_enter_from", "new_user_link_panel");
            r13.j.put("data_room_video_talk_log_over_for_over_path", "switch_link_type");
            if (r5 != 12) goto L41;
            if (r6 == false) goto L40;
            r15 = 2;
        L45:
            rj0.k.m2.getClass();
            rj0.k r19 = rj0.k.a.a();
            if (r19 == null) goto L48;
            r19.T1(r5, Integer.valueOf(r15), "VideoTalkIntegrationGuidDialog");
        L48:
            r13.M0();
            goto L49
        L40:
            r15 = 5;
            goto L45
        L41:
            if (r5 != 8) goto L44;
            if (r6 == false) goto L45;
            r15 = 7;
            goto L45
        L44:
            r15 = 0;
            goto L45
        L24:
            r11 = "radio";
            goto L25
        L13:
            r5 = 8;
            goto L14
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565548;
    }

    public final void M0() {
        this.e.setDuration(250);
        Animation r0 = this.e;
        if (r0 == null) goto L5;
        ((LinearLayout) findViewById(2131385978)).startAnimation(r0);
    L5:
        this.e.setAnimationListener(new b(this));
        Animation r1 = this.c;
        if (r1 == null) goto L9;
        findViewById(2131381758).startAnimation(r1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N0() {
        if (this.h == false) goto L9;
        if (this.i == false) goto L7;
        String r0 = vm2.d.g0().a();
    L12:
        FrescoLoader.with(getContext()).load(r0).into((ImageView) findViewById(2131376285));
        return;
    L7:
        r0 = vm2.d.g0().b();
        goto L12
    L9:
        if (this.i == false) goto L11;
        r0 = vm2.d.g0().c();
        goto L12
    L11:
        r0 = vm2.d.g0().d();
        goto L12
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.dispose();
    }

    public final void onBackPressed() {
        M0();
    }

    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        i0 r10 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.o1("new_user_link_panel");
        this.d.setDuration(250);
        Animation r11 = this.d;
        if (r11 == null) goto L5;
        ((LinearLayout) findViewById(2131385978)).startAnimation(r11);
    L5:
        Animation r12 = this.b;
        if (r12 == null) goto L8;
        findViewById(2131381758).startAnimation(r12);
    L8:
        this.b.setFillAfter(true);
        findViewById(2131381758).setOnClickListener(x0.a(new AnonymousClass1(this)));
        com.bytedance.live.datacontext.j r13 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r13 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r14 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r13.getValue();
        if (r14 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r15 = r14.t();
        if (r15 == null) goto L19;
        if (r15.a != 8) goto L17;
        this.f = false;
        this.h = false;
        ((ImageView) findViewById(2131376719)).setBackgroundResource(2131253276);
        ((ImageView) findViewById(2131376219)).setBackgroundColor(0);
        goto L19
    L17:
        this.f = true;
        this.h = true;
        ((ImageView) findViewById(2131376219)).setBackgroundResource(2131253276);
        ((ImageView) findViewById(2131376719)).setBackgroundColor(0);
    L19:
        if (vm2.d.h0().a() == false) goto L21;
        ((TextView) findViewById(2131390544)).setText(s1.B(2131917606));
    L22:
        com.bytedance.live.datacontext.j r16 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r16 == null) goto L38;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r17 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r16.getValue();
        if (r17 == null) goto L38;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r18 = r17.t();
        if (r18 == null) goto L38;
        List r19 = r18.b;
        if (r19 == null) goto L38;
        Switch r5 = (Switch) findViewById(2131387900);
        if (vm2.d.h0().a() == true) goto L33;
        boolean r6 = r19.contains(4);
    L37:
        r5.setChecked(r6);
        boolean r20 = r19.contains(4);
        this.g = r20;
        this.i = r20;
        goto L38
    L33:
        if (r19.contains(4) == true) goto L35;
        r6 = true;
        goto L37
    L35:
        r6 = false;
    L38:
        N0();
        ((Switch) findViewById(2131387900)).setOnCheckedChangeListener(new c(this));
        ((ImageView) findViewById(2131376719)).setOnClickListener(new d(this));
        ((ImageView) findViewById(2131376219)).setOnClickListener(new e(this));
        ((Button) findViewById(2131364774)).setOnClickListener(new f(this));
        LinkedHashMap r21 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r21);
        TalkRoomLogUtils.B0(r21, null, null, 6);
        TalkRoomLogUtils.V0(r21);
        j0.l().sendLog("livesdk_anchor_new_connection_panel_show", r21, new Object[]{IRoom.class});
        return;
    L21:
        ((TextView) findViewById(2131390544)).setText(s1.B(2131917605));
        goto L22
    }

    public VideoTalkIntegrationGuidDialog(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2);
        this.j = r3;
        this.a = new CompositeDisposable();
        this.b = AnimationUtils.loadAnimation(r2, 2130772762);
        this.c = AnimationUtils.loadAnimation(r2, 2130772763);
        this.d = AnimationUtils.loadAnimation(r2, 2130772764);
        this.e = AnimationUtils.loadAnimation(r2, 2130772765);
    }
}
