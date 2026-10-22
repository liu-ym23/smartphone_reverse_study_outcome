package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/ReplayDetailSettingDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "a", "b", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayDetailSettingDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int P = 0;
    public Function2<? super LiveSwitchButton, ? super Context, Unit> B;
    public Function3<? super Boolean, ? super Boolean, ? super Context, Unit> C;
    public Function3<? super Boolean, ? super Boolean, ? super Context, Unit> D;
    public Function3<? super Boolean, ? super Boolean, ? super Context, Unit> E;
    public Function3<? super Boolean, ? super Boolean, ? super Context, Unit> F;
    public final boolean G;
    public final Lazy H;
    public final Lazy I;
    public final Lazy J;
    public final Lazy K;
    public final Lazy L;
    public final Lazy M;
    public final boolean N;
    public final View.OnClickListener O;

    public static final class a {
    }

    public static final class b {
        public final ViewGroup a;
        public final LiveSwitchButton b;

        public final void a(boolean r2) {
            ViewGroup r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getVisibility() != 0) goto L18;
            LiveSwitchButton r1 = this.b;
            if (r1 != null) goto L10;
        L11:
            LiveSwitchButton r3 = this.b;
            if (r3 == null) goto L17;
            r3.f(false, false);
            return;
        L17:
            return;
        L10:
            if (r1.isChecked() != r2) goto L11;
            return;
        }

        public final void b(boolean r2) {
            if (r2 == false) goto L6;
            ViewGroup r3 = this.a;
            if (r3 == null) goto L10;
            r3.setVisibility(0);
            return;
        L10:
            return;
        L6:
            ViewGroup r4 = this.a;
            if (r4 == null) goto L12;
            r4.setVisibility(8);
            return;
        }

        public b(ConstraintLayout r1, LiveSwitchButton r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ReplayDetailSettingDialog a;

        public c(ReplayDetailSettingDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonStandardBottomDialog r5 = this.a;
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

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ReplayDetailSettingDialog a;

        public d(ReplayDetailSettingDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.app.Dialog, com.bytedance.android.livesdk.chatroom.ui.ReplayDetailSettingDialog] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            ReplayDetailSettingDialog r0 = this.a;
            int r1 = ReplayDetailSettingDialog.P;
            b r2 = r0.Z0();
            if (r2 == null) goto L20;
            LiveSwitchButton r4 = r2.b;
            if (r4 == null) goto L20;
            if (r4.isChecked() != true) goto L20;
            if (((Boolean) j40.f4.j.getValue()).booleanValue() == true) goto L15;
            c9 r5 = (c9) this.a.H.getValue();
            if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L29;
            DialogLancet.handleBlockedDialogShow(r5);
            return;
        L29:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
        L14:
            DialogLancet.beforeDialogShow(r5);
            r5.show();
            DialogLancet.afterDialogShow(r5);
            return;
        L15:
            c9 r6 = (c9) this.a.M.getValue();
            if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L31;
            DialogLancet.handleBlockedDialogShow(r6);
            return;
        L31:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
        L19:
            DialogLancet.beforeDialogShow(r6);
            r6.show();
            DialogLancet.afterDialogShow(r6);
            return;
        L20:
            ?? r7 = this.a;
            Function2<? super LiveSwitchButton, ? super Context, Unit> r8 = r7.B;
            if (r8 == null) goto L36;
            if (r3 == null) goto L25;
            Unit r9 = (Unit) r8.invoke((LiveSwitchButton) r3, r7.getContext());
            return;
        L25:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton");
        }
    }

    public static final class e implements LiveSwitchButton.e {
        public final /* synthetic */ ReplayDetailSettingDialog a;

        public e(ReplayDetailSettingDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.e
        public final void d0(LiveSwitchButton r3, boolean r4) {
            this.a.C.invoke(Boolean.valueOf(r4), Boolean.valueOf(this.a.G), this.a.getContext());
        }
    }

    public static final class f implements LiveSwitchButton.f {
        public final /* synthetic */ ReplayDetailSettingDialog a;

        public f(ReplayDetailSettingDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.f
        public final Boolean a(boolean r4) {
            if (r4 == false) goto L8;
            if (this.a.Y0() == true) goto L8;
            String r5 = rm3.c.a;
            rm3.c.g(this.a.getContext(), this.a.getContext().getString(2131922828), 0, false, 28);
            return Boolean.TRUE;
        L8:
            return Boolean.FALSE;
        }
    }

    public static final class g implements LiveSwitchButton.e {
        public final /* synthetic */ ReplayDetailSettingDialog a;

        public g(ReplayDetailSettingDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.e
        public final void d0(LiveSwitchButton r3, boolean r4) {
            this.a.D.invoke(Boolean.valueOf(r4), Boolean.valueOf(this.a.G), this.a.getContext());
        }
    }

    public static final class h implements LiveSwitchButton.f {
        public final /* synthetic */ ReplayDetailSettingDialog a;

        public h(ReplayDetailSettingDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.f
        public final Boolean a(boolean r4) {
            if (r4 == false) goto L8;
            if (this.a.Y0() == true) goto L8;
            String r5 = rm3.c.a;
            rm3.c.g(this.a.getContext(), this.a.getContext().getString(2131922828), 0, false, 28);
            return Boolean.TRUE;
        L8:
            return Boolean.FALSE;
        }
    }

    public static final class i implements LiveSwitchButton.e {
        public final /* synthetic */ ReplayDetailSettingDialog a;

        public i(ReplayDetailSettingDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.e
        public final void d0(LiveSwitchButton r3, boolean r4) {
            this.a.E.invoke(Boolean.valueOf(r4), Boolean.valueOf(this.a.G), this.a.getContext());
        }
    }

    public static final class j implements LiveSwitchButton.e {
        public final /* synthetic */ ReplayDetailSettingDialog a;

        public j(ReplayDetailSettingDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.e
        public final void d0(LiveSwitchButton r3, boolean r4) {
            this.a.F.invoke(Boolean.valueOf(r4), Boolean.valueOf(this.a.G), this.a.getContext());
        }
    }

    public static final class k implements LiveSwitchButton.f {
        public final /* synthetic */ ReplayDetailSettingDialog a;

        public k(ReplayDetailSettingDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.app.Dialog, com.bytedance.android.livesdk.chatroom.ui.ReplayDetailSettingDialog] */
        @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.f
        public final Boolean a(boolean r5) {
            ?? r0 = this.a;
            if (r0.G == false) goto L9;
            if (r5 == true) goto L6;
            String r6 = rm3.c.a;
            rm3.c.g(r0.getContext(), com.bytedance.android.live.core.utils.s1.B(2131914894), 0, false, 28);
        L8:
            return Boolean.TRUE;
        L6:
            String r7 = rm3.c.a;
            rm3.c.g(r0.getContext(), com.bytedance.android.live.core.utils.s1.B(2131914850), 0, false, 28);
            goto L8
        L9:
            if (r5 == false) goto L15;
            if (r0.Y0() == true) goto L15;
            String r8 = rm3.c.a;
            rm3.c.g(this.a.getContext(), this.a.getContext().getString(2131922828), 0, false, 28);
            return Boolean.TRUE;
        L15:
            return Boolean.FALSE;
        }
    }

    static {
    }

    public final b W0() {
        return (b) this.K.getValue();
    }

    public final b X0() {
        return (b) this.L.getValue();
    }

    public final b Z0() {
        return (b) this.I.getValue();
    }

    public final b a1() {
        return (b) this.J.getValue();
    }

    public final int getLayoutId() {
        return 2131565378;
    }

    public final boolean Y0() {
        b r0 = Z0();
        if (r0 == null) goto L9;
        LiveSwitchButton r1 = r0.b;
        if (r1 == null) goto L9;
        if (r1.isChecked() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void b1(boolean r2) {
        b r0 = Z0();
        if (r0 == null) goto L8;
        LiveSwitchButton r1 = r0.b;
        if (r1 == null) goto L8;
        if (r2 != r1.isChecked()) goto L8;
        return;
    L8:
        b r3 = Z0();
        if (r3 == null) goto L15;
        LiveSwitchButton r4 = r3.b;
        if (r4 == null) goto L16;
        r4.f(false, false);
        return;
    L16:
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        b r4 = Z0();
        if (r4 == null) goto L5;
        r4.b(((Boolean) j40.f4.g.getValue()).booleanValue());
    L5:
        b r5 = a1();
        if (r5 == null) goto L8;
        r5.b(((Boolean) j40.f4.l.getValue()).booleanValue());
    L8:
        b r6 = W0();
        if (r6 == null) goto L11;
        r6.b(((Boolean) j40.f4.h.getValue()).booleanValue());
    L11:
        b r7 = Z0();
        if (r7 == null) goto L14;
        r7.a(((Boolean) j40.f4.i.getValue()).booleanValue());
    L14:
        b r8 = a1();
        if (r8 == null) goto L17;
        r8.a(((Boolean) j40.f4.m.getValue()).booleanValue());
    L17:
        b r9 = W0();
        if (r9 == null) goto L21;
        r9.a(((Boolean) j40.f4.k.getValue()).booleanValue());
    L21:
        if (this.N == false) goto L28;
        b r10 = X0();
        if (r10 == null) goto L25;
        r10.b(true);
    L25:
        b r11 = X0();
        if (r11 == null) goto L31;
        r11.a(((Boolean) j40.f4.j.getValue()).booleanValue());
    L31:
        com.bytedance.android.livesdk.r3.e(findViewById(2131384026), new ReplayDetailSettingDialog$initViews$1(this));
        com.bytedance.android.livesdk.r3.e(findViewById(2131387744), new ReplayDetailSettingDialog$initViews$2(this));
        com.bytedance.android.livesdk.r3.e(findViewById(2131384333), new ReplayDetailSettingDialog$initViews$3(this));
        ((ImageView) findViewById(2131378452)).setOnClickListener(new c(this));
        if (this.G == false) goto L38;
        b r12 = Z0();
        if (r12 == null) goto L43;
        LiveSwitchButton r13 = r12.b;
        if (r13 == null) goto L43;
        r13.setOnClickListener(new d(this));
    L43:
        View r14 = findViewById(2131383782);
        if (r14 == null) goto L46;
        r14.setOnClickListener(this.O);
    L46:
        b r15 = a1();
        if (r15 == null) goto L51;
        LiveSwitchButton r16 = r15.b;
        if (r16 == null) goto L51;
        r16.setToggleEventInterceptor(new f(this));
    L51:
        b r17 = a1();
        if (r17 == null) goto L56;
        LiveSwitchButton r18 = r17.b;
        if (r18 == null) goto L56;
        r18.setOnCheckedChangeListener(new g(this));
    L56:
        b r19 = W0();
        if (r19 == null) goto L61;
        LiveSwitchButton r20 = r19.b;
        if (r20 == null) goto L61;
        r20.setToggleEventInterceptor(new h(this));
    L61:
        b r21 = W0();
        if (r21 == null) goto L66;
        LiveSwitchButton r22 = r21.b;
        if (r22 == null) goto L66;
        r22.setOnCheckedChangeListener(new i(this));
    L66:
        b r23 = X0();
        if (r23 == null) goto L71;
        LiveSwitchButton r24 = r23.b;
        if (r24 == null) goto L71;
        r24.setOnCheckedChangeListener(new j(this));
    L71:
        b r25 = X0();
        if (r25 == null) goto L76;
        LiveSwitchButton r26 = r25.b;
        if (r26 == null) goto L76;
        r26.setToggleEventInterceptor(new k(this));
    L76:
        TextView r27 = (TextView) findViewById(2131387746);
        if (r27 == null) goto L80;
        r27.setSelected(true);
        return;
    L80:
        return;
    L38:
        b r28 = Z0();
        if (r28 == null) goto L43;
        LiveSwitchButton r29 = r28.b;
        if (r29 == null) goto L43;
        r29.setOnCheckedChangeListener(new e(this));
        goto L43
    L28:
        b r30 = X0();
        if (r30 == null) goto L31;
        r30.b(false);
        goto L31
    }

    public ReplayDetailSettingDialog(final Context r2, boolean r3, com.bytedance.android.livesdk.chatroom.ui.setting.i r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "realtimePlayBackClickListener");
        super(r2, false);
        this.N = r3;
        this.O = r4;
        this.C = ReplayDetailSettingDialog$replayActionEC$1.INSTANCE;
        this.D = ReplayDetailSettingDialog$supportActionEC$1.INSTANCE;
        this.E = ReplayDetailSettingDialog$publishActionEC$1.INSTANCE;
        this.F = ReplayDetailSettingDialog$realTimePlaybackSwitch$1.INSTANCE;
        this.G = true;
        LazyThreadSafetyMode r5 = LazyThreadSafetyMode.NONE;
        this.H = LazyKt.lazy(r5, new ReplayDetailSettingDialog$mConfirmDialog$2(this, r2));
        this.I = LazyKt.lazy(r5, new ReplayDetailSettingDialog$replaySwitchItem$2(this));
        this.J = LazyKt.lazy(r5, new ReplayDetailSettingDialog$supportSwitchItem$2(this));
        this.K = LazyKt.lazy(r5, new ReplayDetailSettingDialog$publishSwitchItem$2(this));
        this.L = LazyKt.lazy(r5, new ReplayDetailSettingDialog$realTimePlaybackSwitchItem$2(this));
        this.M = LazyKt.lazy(r5, new ReplayDetailSettingDialog$forbidCloseRealTimePlaybackDialog$2(r2));
    }
}
