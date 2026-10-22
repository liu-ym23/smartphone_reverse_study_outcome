package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import com.bytedance.android.live.base.model.data.n;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.LikeEggHelper;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.pannel.view.RadiusLayout;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/CompositeImagePreviewDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", BuildConfig.FLAVOR, "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CompositeImagePreviewDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int L0 = 0;
    public Function1<? super String, Unit> B;
    public Function0<Unit> C;
    public Function0<Unit> D;
    public k E;
    public String F;
    public DataCenter G;
    public View H;
    public boolean H0;
    public HSImageView I;
    public TextView J;
    public TextView K;
    public HSImageView L;
    public View M;
    public View N;
    public View O;
    public TextView P;
    public TextView Q;
    public View R;
    public View S;
    public RadiusLayout T;
    public View U;
    public TextView V;
    public Animator W;
    public Animator X;
    public boolean Y;
    public final CompositeDisposable Z;
    public String k0;
    public boolean p0;

    public static final class a {
        public static CompositeImagePreviewDialog a(Context r2, com.bytedance.android.livesdk.chatroom.likeegg.a r3, DataCenter r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "msg");
            CompositeImagePreviewDialog r0 = new CompositeImagePreviewDialog(r2);
            com.bytedance.android.livesdk.chatroom.likeegg.a.b r5 = r3.jumpDetail;
            String r6 = null;
            if (r5 == null) goto L7;
            n r1 = r5.templatePhotoJumpDetail;
            if (r1 == null) goto L7;
            k r7 = r1.bgPhoto;
        L8:
            r0.E = r7;
            if (r5 == null) goto L13;
            n r8 = r5.templatePhotoJumpDetail;
            if (r8 == null) goto L13;
            r6 = r8.photoPanelTitle;
        L13:
            r0.F = r6;
            r0.G = r4;
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L20;
            DialogLancet.handleBlockedDialogShow(r0);
        L18:
            return r0;
        L20:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
        L17:
            DialogLancet.beforeDialogShow(r0);
            r0.show();
            DialogLancet.afterDialogShow(r0);
        L7:
            r7 = null;
            goto L8
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ CompositeImagePreviewDialog a;

        public b(CompositeImagePreviewDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            sh6.b r5 = (sh6.b) r4;
            CompositeImagePreviewDialog r6 = this.a;
            int r0 = CompositeImagePreviewDialog.L0;
            r6.W0();
            CompositeImagePreviewDialog r7 = this.a;
            Animator r1 = r7.W;
            if (r1 == null) goto L5;
            r1.cancel();
        L5:
            r7.W = null;
            r7.Y = false;
            View r2 = r7.M;
            if (r2 == null) goto L8;
            UtilityKotlinExtentionsKt.A(r2, false);
        L8:
            View r3 = r7.O;
            if (r3 == null) goto L11;
            UtilityKotlinExtentionsKt.A(r3, true);
        L11:
            View r8 = r7.N;
            if (r8 == null) goto L14;
            UtilityKotlinExtentionsKt.A(r8, false);
        L14:
            TextView r9 = r7.J;
            if (r9 == null) goto L17;
            UtilityKotlinExtentionsKt.A(r9, true);
        L17:
            TextView r10 = r7.K;
            if (r10 == null) goto L20;
            UtilityKotlinExtentionsKt.A(r10, true);
        L20:
            HSImageView r11 = r7.I;
            if (r11 == null) goto L23;
            r11.setTranslationX(0.0f);
            r11.setTranslationY(0.0f);
            r11.setScaleX(1.0f);
            r11.setScaleY(1.0f);
        L23:
            View r13 = r7.M;
            if (r13 == null) goto L26;
            r13.setAlpha(0.0f);
        L26:
            TextView r14 = r7.J;
            if (r14 == null) goto L29;
            r14.setAlpha(1.0f);
        L29:
            TextView r15 = r7.K;
            if (r15 == null) goto L33;
            r15.setAlpha(1.0f);
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ CompositeImagePreviewDialog a;

        public c(CompositeImagePreviewDialog r1) {
            this.a = r1;
        }

        public final void a() {
            TextView r0 = this.a.P;
            if (r0 == null) goto L5;
            UtilityKotlinExtentionsKt.A(r0, false);
        L5:
            HSImageView r1 = this.a.I;
            if (r1 == null) goto L8;
            UtilityKotlinExtentionsKt.A(r1, false);
        L8:
            TextView r2 = this.a.J;
            if (r2 == null) goto L11;
            UtilityKotlinExtentionsKt.A(r2, false);
        L11:
            TextView r3 = this.a.K;
            if (r3 == null) goto L14;
            UtilityKotlinExtentionsKt.A(r3, false);
        L14:
            View r4 = this.a.U;
            if (r4 == null) goto L17;
            UtilityKotlinExtentionsKt.A(r4, false);
        L17:
            TextView r5 = this.a.V;
            if (r5 == null) goto L20;
            UtilityKotlinExtentionsKt.A(r5, false);
        L20:
            View r6 = this.a.R;
            if (r6 == null) goto L24;
            UtilityKotlinExtentionsKt.A(r6, true);
            return;
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

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ CompositeImagePreviewDialog a;

        public d(CompositeImagePreviewDialog r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            View r3 = this.a.U;
            if (r3 == null) goto L6;
            r3.setAlpha(1.0f);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            View r3 = this.a.U;
            if (r3 == null) goto L6;
            r3.setAlpha(1.0f);
            return;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ CompositeImagePreviewDialog a;
        public final /* synthetic */ String b;

        public e(CompositeImagePreviewDialog r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            CompositeImagePreviewDialog r0 = this.a;
            String r1 = this.b;
            r0.k0 = r1;
            if (r1.length() <= 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L8;
            ImageLoader.loadSdcardImage(r0.I, r0.k0);
        L8:
            CompositeImagePreviewDialog r3 = this.a;
            r3.getClass();
            ALogger.d("CompositeImagePreviewDialog", "onLoadSuccess");
            TextView r4 = r3.P;
            if (r4 == null) goto L11;
            UtilityKotlinExtentionsKt.A(r4, true);
        L11:
            HSImageView r5 = r3.I;
            if (r5 == null) goto L14;
            UtilityKotlinExtentionsKt.A(r5, true);
        L14:
            TextView r6 = r3.J;
            if (r6 == null) goto L17;
            UtilityKotlinExtentionsKt.A(r6, true);
        L17:
            TextView r7 = r3.K;
            if (r7 == null) goto L20;
            UtilityKotlinExtentionsKt.A(r7, true);
        L20:
            View r8 = r3.U;
            if (r8 == null) goto L23;
            UtilityKotlinExtentionsKt.A(r8, false);
        L23:
            TextView r9 = r3.V;
            if (r9 == null) goto L26;
            UtilityKotlinExtentionsKt.A(r9, false);
        L26:
            View r10 = r3.R;
            if (r10 == null) goto L30;
            UtilityKotlinExtentionsKt.A(r10, false);
            return;
        L30:
            return;
        L5:
            r2 = false;
            goto L6
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

    static {
    }

    public final boolean V0() {
        return true;
    }

    public final void W0() {
        RadiusLayout r0 = this.T;
        if (r0 == null) goto L7;
        int r1 = a1.h(r0);
        HSImageView r2 = this.L;
        if (r2 == null) goto L7;
        a1.o(r2, r1);
    L7:
        RadiusLayout r3 = this.T;
        if (r3 == null) goto L12;
        int r4 = a1.g(r3);
        HSImageView r5 = this.L;
        if (r5 == null) goto L12;
        a1.n(r5, r4);
    L12:
        RadiusLayout r6 = this.T;
        if (r6 == null) goto L17;
        int r7 = a1.e(r6);
        HSImageView r8 = this.L;
        if (r8 == null) goto L17;
        a1.l(r8, r7);
    L17:
        RadiusLayout r9 = this.T;
        if (r9 == null) goto L20;
        a1.m(r9, 0);
    L20:
        RadiusLayout r10 = this.T;
        if (r10 == null) goto L23;
        a1.o(r10, 0);
    L23:
        RadiusLayout r11 = this.T;
        if (r11 == null) goto L26;
        a1.n(r11, 0);
    L26:
        RadiusLayout r13 = this.T;
        if (r13 == null) goto L29;
        a1.l(r13, 0);
    L29:
        RadiusLayout r14 = this.T;
        if (r14 == null) goto L32;
        int r15 = a1.i(r14);
    L33:
        HSImageView r16 = this.L;
        if (r16 == null) goto L36;
        a1.p(r16, r15);
    L36:
        RadiusLayout r17 = this.T;
        if (r17 == null) goto L39;
        a1.p(r17, -1);
    L39:
        TokenCert r18 = LikeEggHelper.a;
        int r19 = LikeEggHelper.a(this.G);
        int r20 = r19 - UtilityKotlinExtentionsKt.i(180);
        int r21 = (int) (((double) r20) * 0.66d);
        HSImageView r23 = this.L;
        if (r23 == null) goto L42;
        a1.k(r23, r19);
    L42:
        HSImageView r24 = this.I;
        if (r24 == null) goto L45;
        a1.k(r24, r20);
    L45:
        HSImageView r25 = this.I;
        if (r25 == null) goto L48;
        a1.p(r25, r21);
    L48:
        RadiusLayout r26 = this.T;
        if (r26 == null) goto L51;
        a1.k(r26, -1);
    L51:
        RadiusLayout r27 = this.T;
        if (r27 == null) goto L55;
        r27.setMaxHeight(0);
        return;
    L55:
        return;
    L32:
        r15 = -1;
        goto L33
    }

    public final void X0() {
        ALogger.d("CompositeImagePreviewDialog", "onLoadFailed");
        MainThreadPostUtils.e(new c(this));
    }

    public final void Y0() {
        ALogger.d("CompositeImagePreviewDialog", "onStateLoading");
        TextView r0 = this.P;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.A(r0, true);
    L5:
        HSImageView r1 = this.I;
        if (r1 == null) goto L8;
        UtilityKotlinExtentionsKt.A(r1, false);
    L8:
        TextView r2 = this.J;
        if (r2 == null) goto L11;
        UtilityKotlinExtentionsKt.A(r2, false);
    L11:
        TextView r3 = this.K;
        if (r3 == null) goto L14;
        UtilityKotlinExtentionsKt.A(r3, false);
    L14:
        View r4 = this.U;
        if (r4 == null) goto L17;
        UtilityKotlinExtentionsKt.A(r4, true);
    L17:
        TextView r5 = this.V;
        if (r5 == null) goto L20;
        UtilityKotlinExtentionsKt.A(r5, true);
    L20:
        View r6 = this.R;
        if (r6 == null) goto L24;
        UtilityKotlinExtentionsKt.A(r6, false);
        return;
    }

    public final void Z0() {
        if (this.U != null) goto L5;
        return;
    L5:
        Animator r0 = this.X;
        if (r0 == null) goto L8;
        r0.cancel();
    L8:
        AnimatorSet r1 = new AnimatorSet();
        r1.play(ObjectAnimator.ofFloat(this.U, View.ALPHA, new float[]{0.0f, 1.0f}));
        r1.setDuration(400);
        r1.setInterpolator(new AccelerateInterpolator());
        r1.addListener(new d(this));
        r1.start();
        Unit r2 = Unit.INSTANCE;
        this.X = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        int r0 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.a;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.b("livesdk_vs_photo_defined_cancel", new LinkedHashMap());
        if (this.H0 == true) goto L5;
        this.H0 = true;
        StringBuilder r1 = new StringBuilder("likeEggDialogCount decrement: ");
        EasterEggAnimationDialog.i.getClass();
        r1.append(EasterEggAnimationDialog.h.decrementAndGet());
        ALogger.d("CompositeImagePreviewDialog", r1.toString());
    L5:
        this.Z.dispose();
        Handler r2 = DialogLancet.resolveDialogHandler(this);
        if (r2 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r3 == null) goto L19;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r2.getLooper()) goto L10;
        r2.post(DialogLancet.createDismissRunnable(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismissDialog() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
    }

    public final int getLayoutId() {
        if (PadConfigUtils.c() == false) goto L5;
        return 2131566823;
    L5:
        return 2131566822;
    }

    public final void onStart() {
        super/*com.bytedance.android.livesdk.pannel.SheetBaseDialog*/.onStart();
        if (this.k0.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        ImageLoader.loadSdcardImage(this.I, this.k0);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public CompositeImagePreviewDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, false);
        this.Z = new CompositeDisposable();
        this.k0 = BuildConfig.FLAVOR;
    }

    public final void a1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "imagePath");
        if (r2.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        MainThreadPostUtils.e(new e(this, r2));
        return;
    L8:
        X0();
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Window r6 = getWindow();
        if (r6 == null) goto L5;
        r6.setDimAmount(0.0f);
        r6.setLayout(-1, -1);
        r6.setType(1);
    L5:
        boolean r7 = false;
        setCanceledOnTouchOutside(false);
        View r3 = findViewById(2131389519);
        if (r3 == null) goto L8;
        a1.k(r3, -1);
    L8:
        this.T = findViewById(2131389519);
        this.H = findViewById(2131367617);
        this.I = findViewById(2131382921);
        this.J = (TextView) findViewById(2131364689);
        this.K = (TextView) findViewById(2131364673);
        this.L = findViewById(2131368976);
        this.M = findViewById(2131386044);
        this.N = findViewById(2131382910);
        this.O = findViewById(2131366962);
        this.P = (TextView) findViewById(2131368982);
        this.Q = (TextView) findViewById(2131380672);
        this.R = findViewById(2131379023);
        this.S = findViewById(2131364679);
        this.U = findViewById(2131378998);
        this.V = (TextView) findViewById(2131379085);
        HSImageView r0 = this.I;
        if (r0 == null) goto L11;
        r0.setOnClickListener(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.a(this));
    L11:
        View r1 = this.N;
        if (r1 == null) goto L14;
        r1.setOnClickListener(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.b(this));
    L14:
        TextView r2 = this.J;
        if (r2 == null) goto L17;
        r2.setOnClickListener(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.c(this));
    L17:
        TextView r4 = this.K;
        if (r4 == null) goto L20;
        r4.setOnClickListener(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.d(this));
    L20:
        View r8 = this.O;
        if (r8 == null) goto L23;
        r8.setOnClickListener(com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.e.a);
    L23:
        View r9 = this.S;
        if (r9 == null) goto L26;
        r9.setOnClickListener(new f(this));
    L26:
        TextView r10 = this.Q;
        if (r10 == null) goto L29;
        r10.setOnClickListener(new g(this));
    L29:
        k r11 = this.E;
        if (r11 != null) goto L32;
    L34:
        TextView r13 = this.P;
        if (r13 == null) goto L45;
        String r14 = this.F;
        if (r14 != null) goto L39;
    L43:
        String r15 = getContext().getString(2131918668);
    L44:
        r13.setText(r15);
        goto L45
    L39:
        if (r14.length() <= 0) goto L41;
        r7 = true;
    L41:
        if (r7 != true) goto L43;
        r15 = this.F;
    L45:
        Y0();
        W0();
        if (PadConfigUtils.c() == false) goto L56;
        u r16 = r.u(this.G, null, 2);
        if (r16 == null) goto L56;
        com.bytedance.live.datacontext.n r17 = r16.w();
        if (r17 == null) goto L56;
        Observable r18 = r17.a();
        if (r18 == null) goto L56;
        Disposable r19 = r18.subscribe(new b(this));
        if (r19 == null) goto L56;
        RxUtilKt.c(r19, this.Z);
    L56:
        int r20 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.a;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.b("livesdk_vs_photo_defined_show", new LinkedHashMap());
        if (this.p0 == true) goto L60;
        this.p0 = true;
        StringBuilder r21 = new StringBuilder("likeEggDialogCount increment: ");
        EasterEggAnimationDialog.i.getClass();
        r21.append(EasterEggAnimationDialog.h.incrementAndGet());
        ALogger.d("CompositeImagePreviewDialog", r21.toString());
        return;
    L60:
        return;
    L32:
        if (r11.isValid() != true) goto L34;
        ImageLoader.bindImage(this.L, this.E);
        goto L34
    }
}
