package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepreview;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.data.n;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.EasterEggAnimationDialog;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.LikeEggHelper;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vh7.f;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepreview/LikeEggTemplatePreviewDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LikeEggTemplatePreviewDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int W = 0;
    public View B;
    public View C;
    public HSImageView D;
    public TextView E;
    public TextView F;
    public RecyclerView G;
    public View H;
    public TextView I;
    public TextView J;
    public final List<n.a> K;
    public Function2<? super k, ? super Integer, Unit> L;
    public Function2<? super Integer, ? super Function0<Unit>, Unit> M;
    public k N;
    public String O;
    public DataCenter P;
    public int Q;
    public int R;
    public final CompositeDisposable S;
    public boolean T;
    public boolean U;
    public final Lazy V;

    public static final class a {
        public static void a(Context r2, com.bytedance.android.livesdk.chatroom.likeegg.a r3, Function2 r4, Function2 r5, int r6, DataCenter r7) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "msg");
            Intrinsics.checkNotNullParameter(r4, "saveAction");
            Intrinsics.checkNotNullParameter(r5, "pickAction");
            ALogger.d("LikeEggTemplatePreviewDialog", "start launch");
            LikeEggTemplatePreviewDialog r0 = new LikeEggTemplatePreviewDialog(r2);
            List<n.a> r8 = r0.K;
            com.bytedance.android.livesdk.chatroom.likeegg.a.b r1 = r3.jumpDetail;
            if (r1 == null) goto L9;
            n r9 = r1.templatePhotoJumpDetail;
            if (r9 == null) goto L9;
            List r10 = r9.a();
            if (r10 == null) goto L9;
        L10:
            ((ArrayList) r8).addAll(r10);
            r0.L = r4;
            r0.M = r5;
            com.bytedance.android.livesdk.chatroom.likeegg.a.b r11 = r3.jumpDetail;
            String r13 = null;
            if (r11 == null) goto L15;
            n r14 = r11.templatePhotoJumpDetail;
            if (r14 == null) goto L15;
            k r15 = r14.bgPhoto;
        L16:
            r0.N = r15;
            if (r11 == null) goto L21;
            n r16 = r11.templatePhotoJumpDetail;
            if (r16 == null) goto L21;
            r13 = r16.templatePanelTitle;
        L21:
            r0.O = r13;
            r0.Q = r6;
            r0.P = r7;
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L28;
            DialogLancet.handleBlockedDialogShow(r0);
            return;
        L28:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
        L25:
            DialogLancet.beforeDialogShow(r0);
            r0.show();
            DialogLancet.afterDialogShow(r0);
            return;
        L15:
            r15 = null;
        L9:
            r10 = CollectionsKt.emptyList();
            goto L10
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LikeEggTemplatePreviewDialog a;

        public b(LikeEggTemplatePreviewDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            LikeEggTemplatePreviewDialog r4 = this.a;
            int r0 = LikeEggTemplatePreviewDialog.W;
            r4.X0();
        }
    }

    static {
    }

    public final boolean V0() {
        return true;
    }

    public final LikeEggTemplatePreviewDialog$mLayoutManager$2.AnonymousClass1 W0() {
        return (LikeEggTemplatePreviewDialog$mLayoutManager$2.AnonymousClass1) this.V.getValue();
    }

    public final void X0() {
        TokenCert r0 = LikeEggHelper.a;
        int r1 = LikeEggHelper.a(this.P);
        View r2 = this.B;
        if (r2 == null) goto L5;
        a1.k(r2, r1);
    L5:
        int r3 = r1 - UtilityKotlinExtentionsKt.i(180);
        this.R = ((int) (((double) r3) * 0.66d)) + UtilityKotlinExtentionsKt.i(14);
        RecyclerView r4 = this.G;
        if (r4 != null) goto L8;
        return;
    L8:
        if ((r3 * 3) >= r4.getMeasuredWidth()) goto L12;
        a1.o(r4, UtilityKotlinExtentionsKt.i(38));
        a1.l(r4, UtilityKotlinExtentionsKt.i(93));
        this.R = ((int) (((double) ((r1 - UtilityKotlinExtentionsKt.i(38)) - UtilityKotlinExtentionsKt.i(93))) * 0.66d)) + UtilityKotlinExtentionsKt.i(14);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        if (this.U == true) goto L5;
        this.U = true;
        StringBuilder r0 = new StringBuilder("likeEggDialogCount decrement: ");
        EasterEggAnimationDialog.i.getClass();
        r0.append(EasterEggAnimationDialog.h.decrementAndGet());
        ALogger.d("LikeEggTemplatePreviewDialog", r0.toString());
    L5:
        this.S.dispose();
        Handler r1 = DialogLancet.resolveDialogHandler(this);
        if (r1 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r2 == null) goto L19;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L8:
        if (Looper.myLooper() == r1.getLooper()) goto L10;
        r1.post(DialogLancet.createDismissRunnable(this));
    }

    public final void show() {
        ALogger.d("LikeEggTemplatePreviewDialog", "start show");
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.show();
        DialogLancet.afterDialogShow(this);
    }

    public final int getLayoutId() {
        if (PadConfigUtils.c() == false) goto L5;
        return 2131566828;
    L5:
        return 2131566827;
    }

    public LikeEggTemplatePreviewDialog(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, false);
        this.K = new ArrayList();
        this.S = new CompositeDisposable();
        this.V = LazyKt.lazy(new LikeEggTemplatePreviewDialog$mLayoutManager$2(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        Window r9 = getWindow();
        if (r9 == null) goto L5;
        r9.setDimAmount(0.0f);
        r9.setLayout(-1, -1);
    L5:
        boolean r10 = false;
        setCanceledOnTouchOutside(false);
        View r1 = findViewById(2131389519);
        if (r1 == null) goto L8;
        a1.k(r1, -1);
    L8:
        this.B = findViewById(2131368976);
        this.C = findViewById(2131366962);
        this.E = (TextView) findViewById(2131375055);
        this.D = findViewById(2131368936);
        this.F = (TextView) findViewById(2131375043);
        this.G = findViewById(2131375044);
        this.H = findViewById(2131364679);
        this.I = (TextView) findViewById(2131388321);
        this.J = (TextView) findViewById(2131388772);
        k r0 = this.N;
        if (r0 != null) goto L11;
    L13:
        String r2 = this.O;
        if (r2 != null) goto L16;
    L23:
        n.a r3 = (n.a) CollectionsKt.getOrNull(this.K, this.Q);
        if (r3 == null) goto L26;
        String r4 = r3.authorName;
    L27:
        if (r4 != null) goto L29;
    L35:
        TextView r11 = this.I;
        if (r11 == null) goto L38;
        r11.setText(null);
    L38:
        TextView r13 = this.E;
        if (r13 == null) goto L41;
        r13.setOnClickListener(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepreview.b(this));
    L41:
        TextView r14 = this.F;
        if (r14 == null) goto L44;
        r14.setOnClickListener(new LikeEggTemplatePreviewDialog$initViews$2(this));
    L44:
        View r15 = this.H;
        if (r15 == null) goto L47;
        r15.setOnClickListener(new c(this));
    L47:
        RecyclerView r16 = this.G;
        if (r16 == null) goto L57;
        PreviewItemAdapter r5 = new PreviewItemAdapter();
        List<k> r6 = r5.a;
        List<n.a> r7 = this.K;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r18 = ((ArrayList) r7).iterator();
    L51:
        if (r18.hasNext() == false) goto L56;
        k r19 = ((n.a) r18.next()).templatePhoto;
        if (r19 != null) goto L55;
        r19 = (k) f.c(k.class);
    L55:
        r17.add(r19);
        goto L51
    L56:
        ((ArrayList) r6).addAll(r17);
        Function2<Integer, k, Unit> r20 = new LikeEggTemplatePreviewDialog$initRecyclerView$$inlined$apply$lambda$1(this);
        Intrinsics.checkNotNullParameter(r20, "action");
        r5.b = r20;
        Unit r21 = Unit.INSTANCE;
        r16.setAdapter(r5);
        r16.setLayoutManager(W0());
        new PagerSnapHelper().attachToRecyclerView(r16);
        r16.addItemDecoration(new CenterItemDecoration(new LikeEggTemplatePreviewDialog$initRecyclerView$$inlined$apply$lambda$2(this)));
        r16.getViewTreeObserver().addOnGlobalLayoutListener(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepreview.a(r16, this));
        r16.addOnScrollListener(new LikeEggTemplatePreviewDialog$initRecyclerView$$inlined$apply$lambda$4(this));
    L57:
        W0().smoothScrollToPosition(this.G, new RecyclerView.State(), this.Q);
        X0();
        if (PadConfigUtils.c() == false) goto L69;
        u r23 = r.u(this.P, null, 2);
        if (r23 == null) goto L69;
        com.bytedance.live.datacontext.n r24 = r23.w();
        if (r24 == null) goto L69;
        Observable r25 = r24.a();
        if (r25 == null) goto L69;
        Disposable r26 = r25.subscribe(new b(this));
        if (r26 == null) goto L69;
        RxUtilKt.c(r26, this.S);
    L69:
        if (this.T == true) goto L75;
        this.T = true;
        StringBuilder r27 = new StringBuilder("likeEggDialogCount increment: ");
        EasterEggAnimationDialog.i.getClass();
        r27.append(EasterEggAnimationDialog.h.incrementAndGet());
        ALogger.d("LikeEggTemplatePreviewDialog", r27.toString());
        return;
    L75:
        return;
    L29:
        if (r4.length() <= 0) goto L31;
        r10 = true;
    L31:
        if (r10 != true) goto L35;
        TextView r28 = this.I;
        if (r28 == null) goto L38;
        r28.setText("作者：".concat(r4));
        goto L38
    L26:
        r4 = null;
        goto L27
    L16:
        if (r2.length() != 0) goto L18;
        boolean r29 = true;
    L19:
        if (r29 == true) goto L23;
        TextView r30 = this.J;
        if (r30 == null) goto L23;
        r30.setText(this.O);
        goto L23
    L18:
        r29 = false;
        goto L19
    L11:
        if (r0.isValid() != true) goto L13;
        ImageLoader.bindImage(this.D, this.N);
        goto L13
    }
}
