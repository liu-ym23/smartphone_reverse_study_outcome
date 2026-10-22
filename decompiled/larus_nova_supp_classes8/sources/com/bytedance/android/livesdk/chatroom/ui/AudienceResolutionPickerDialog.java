package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.livesdk.config.ke1;
import com.bytedance.android.livesdk.config.le1;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.SwitchResolutionDialogConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/AudienceResolutionPickerDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "a", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceResolutionPickerDialog extends CommonStandardBottomDialog {
    public h8 B;
    public i8 C;
    public String D;
    public Function0<String> E;
    public Function1<? super String, String> F;
    public String G;
    public String H;
    public Function1<? super String, Unit> I;
    public Function0<String> J;
    public final boolean K;
    public final LiveMode L;
    public final SwitchResolutionDialogConfig M;
    public Function1<? super String, Unit> N;
    public final Lazy O;
    public i8 P;
    public List<l5> Q;
    public final Function1<String, Unit> R;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.AudienceResolutionPickerDialog$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        public final void invoke(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((String) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.AudienceResolutionPickerDialog$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1);
        }

        public final void invoke(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((String) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.AudienceResolutionPickerDialog$3, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass3 extends Lambda implements Function1<String, Unit> {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(1);
        }

        public final void invoke(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((String) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a extends RecyclerView.ViewHolder {
        public final ResolutionItemView a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(ResolutionItemView r2) {
            Intrinsics.checkNotNullParameter(r2, "resolutionView");
            super(r2);
            this.a = r2;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AudienceResolutionPickerDialog a;

        public b(AudienceResolutionPickerDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [android.app.Dialog, com.bytedance.android.livesdk.chatroom.ui.AudienceResolutionPickerDialog, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            ?? r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
        L17:
            this.a.Y0("取消", true);
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
            goto L17
        }
    }

    public final int getLayoutId() {
        if (this.M.verticalDialogUseNewStyle() == false) goto L5;
        return 2131565392;
    L5:
        return 2131565391;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        h8 r1 = this.B;
        if (r1 == null) goto L26;
        r1.b.clearAnimation();
        return;
    L26:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r2 == null) goto L16;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public final void X0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (((Boolean) this.O.getValue()).booleanValue() == false) goto L6;
        ALogger.e("VideoBWProbe", r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r18) {
        super.onCreate(r18);
        findViewById(2131379343).setLayoutManager(new LinearLayoutManager(getContext()));
        findViewById(2131379343).setAdapter(new AudienceResolutionPickerDialog$createAdapter$1(this));
        if (this.M.verticalDialogUseNewStyle() == true) goto L5;
        ((TextView) findViewById(2131379342)).getPaint().setFakeBoldText(true);
    L5:
        TextView r1 = (TextView) findViewById(2131379342);
        if (r1 == null) goto L8;
        r1.setOnClickListener(new b(this));
    L8:
        Window r2 = getWindow();
        if (r2 == null) goto L12;
        r2.setDimAmount(0.0f);
    L12:
        if (this.K == false) goto L30;
        j40.u3 r3 = j40.u3.a;
        if (((le1) r3.getValue()).a() == false) goto L30;
        if (((le1) r3.getValue()).a() == false) goto L40;
        X0("渲染自动测速结果 probeResult " + this.C + ", getResolutionNameFunc " + this.F + ", lastProbeResolutionFunc " + this.E);
        if (this.C == null) goto L40;
        if (this.F == null) goto L40;
        if (this.E == null) goto L40;
        ConstraintLayout r8 = findViewById(2131383089);
        ImageView r9 = (ImageView) findViewById(2131383090);
        TextView r10 = (TextView) findViewById(2131383091);
        i8 r11 = this.C;
        Intrinsics.checkNotNull(r11);
        Function0<String> r12 = this.E;
        Intrinsics.checkNotNull(r12);
        Function1<? super String, String> r13 = this.F;
        Intrinsics.checkNotNull(r13);
        h8 r4 = new h8(r8, r9, r10, r11, r12, r13, new AudienceResolutionPickerDialog$showProbeItemViewIfNeedInVideo$1(this), this.L, new AudienceResolutionPickerDialog$showProbeItemViewIfNeedInVideo$2(this));
        this.B = r4;
        r4.a.setVisibility(0);
        r4.c.getClass();
        int r5 = g8.a;
        throw null;
    L40:
        int r6 = com.bytedance.android.livesdk.utils.b1.a;
        Function0<Unit> r7 = new AudienceResolutionPickerDialog$initDialogUI$1(this);
        Intrinsics.checkNotNullParameter(this, "dialog");
        Intrinsics.checkNotNullParameter(r7, "keepCurSetting");
        ((Boolean) SettingUtil.getValue("key_ttlive_sdk_setting", "live_panel_standardized", Boolean.TYPE, Boolean.FALSE)).booleanValue();
        r7.invoke();
        com.bytedance.android.livesdk.utils.b1.b(false, new AudienceResolutionPickerDialog$initDialogUI$2(this));
        return;
    L30:
        if (((ke1) j40.l.a.getValue()).a() == false) goto L40;
        int r14 = com.bytedance.android.livesdk.chatroom.utils.m0.a;
        com.bytedance.android.livesdk.chatroom.utils.m0.a("show probe item probeResult " + this.C);
        if (this.C == null) goto L40;
        if (this.F == null) goto L40;
        if (this.E == null) goto L40;
        ConstraintLayout r15 = findViewById(2131383089);
        ImageView r16 = (ImageView) findViewById(2131383090);
        TextView r17 = (TextView) findViewById(2131383091);
        i8 r19 = this.C;
        Intrinsics.checkNotNull(r19);
        Function0<String> r110 = this.E;
        Intrinsics.checkNotNull(r110);
        Function1<? super String, String> r111 = this.F;
        Intrinsics.checkNotNull(r111);
        h8 r20 = new h8(r15, r16, r17, r19, r110, r111, AudienceResolutionPickerDialog$showProbeItemViewIfNeed$1.INSTANCE, LiveMode.UNDEFINED, new AudienceResolutionPickerDialog$showProbeItemViewIfNeed$2(this));
        this.B = r20;
        r20.a.setVisibility(0);
        r20.c.getClass();
        int r21 = g8.a;
        throw null;
    }

    public static final boolean W0(AudienceResolutionPickerDialog r4, String r5) {
        r4.getClass();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L23;
        Iterator<T> r6 = r4.Q.iterator();
    L11:
        if (r6.hasNext() == false) goto L15;
        Object r2 = r6.next();
        if (Intrinsics.areEqual(((l5) r2).j, r5) == false) goto L11;
    L16:
        if (r2 == null) goto L24;
        return true;
    L24:
        return false;
    L15:
        r2 = null;
        goto L16
    L23:
        return false;
    L7:
        r1 = false;
        goto L8
    }

    public final void Y0(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "clickOption");
        if (r11 == true) goto L16;
        Iterator<T> r12 = this.Q.iterator();
        String r2 = "default";
    L6:
        if (r12.hasNext() == false) goto L11;
        l5 r3 = (l5) r12.next();
        if (Intrinsics.areEqual(r3.b, r10) == false) goto L6;
        r2 = r3.j;
        goto L6
    L11:
        if (this.P == null) goto L14;
        String r13 = com.bytedance.android.livesdk.chatroom.utils.g5.a.get(null);
        if (r13 == null) goto L14;
    L15:
        boolean r14 = r2.equals(r13);
    L17:
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.b.m2;
        Boolean r5 = (Boolean) r4.getValue();
        boolean r0 = com.bytedance.android.livesdk.utils.r2.a(null);
        com.bytedance.android.livesdk.log.j0 r6 = com.bytedance.android.livesdk.log.j0.l();
        Pair[] r7 = new Pair[4];
        String r8 = "1";
        if (r5.booleanValue() == false) goto L20;
        Object r9 = "1";
    L21:
        r7[0] = TuplesKt.to("is_manual_selected", r9);
        if (r0 == false) goto L24;
        Object r1 = "1";
    L25:
        r7[1] = TuplesKt.to("is_generate_recommend", r1);
        r7[2] = TuplesKt.to("click_option", r10);
        if (r14 == true) goto L29;
        r8 = "0";
    L29:
        r7[3] = TuplesKt.to("click_option_is_recommend", r8);
        r6.sendLog("livesdk_livetake_definition_panel_click", MapsKt.mapOf(r7), new Object[0]);
        com.bytedance.android.livesdk.sharedpref.f.d(r4, Boolean.TRUE);
        return;
    L24:
        r1 = "0";
        goto L25
    L20:
        r9 = "0";
    L14:
        r13 = null;
        goto L15
    L16:
        r14 = false;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AudienceResolutionPickerDialog(Context r2, List<l5> r3, Function1<? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataList");
        Intrinsics.checkNotNullParameter(r4, "selectedCallback");
        super(r2, false);
        this.Q = r3;
        this.R = r4;
        this.D = "";
        this.L = LiveMode.UNDEFINED;
        this.M = (SwitchResolutionDialogConfig) com.bytedance.android.livesdk.f3.a.getValue();
        this.O = LazyKt.lazy(AudienceResolutionPickerDialog$isDebug$2.INSTANCE);
    }

    public AudienceResolutionPickerDialog(Context r2, List<l5> r3, LiveMode r4, Function1<? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataList");
        Intrinsics.checkNotNullParameter(r4, "liveMode");
        Intrinsics.checkNotNullParameter(r5, "selectedCallback");
        this(r2, r3, r5);
        this.L = r4;
        if (r4 != LiveMode.VIDEO) goto L5;
        this.K = true;
        return;
    L5:
        this.K = false;
    }

    public final void Z0(i8 r2, String r3, Function0<String> r4, Function1<? super String, Unit> r5, Function1<? super String, String> r6, Function0<String> r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "defaultKey");
        Intrinsics.checkNotNullParameter(r6, "getNameFunc");
        this.C = r2;
        this.F = r6;
        this.E = r4;
        this.I = r5;
        this.D = r3;
        this.J = r7;
        this.G = r8;
        this.H = r9;
    }
}
