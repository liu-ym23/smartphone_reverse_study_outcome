package com.bytedance.android.live.effect.sticker.ui.aigc;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdk.r3;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010S\u001a\u00020R\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010T\u0012\b\b\u0002\u0010V\u001a\u00020-¢\u0006\u0004\bW\u0010XJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0016R\u001d\u0010\"\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011R\u001d\u0010%\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000f\u001a\u0004\b$\u0010\u0011R\u001d\u0010(\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000f\u001a\u0004\b'\u0010\u0016R\u001b\u0010,\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000f\u001a\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000f\u001a\u0004\b/\u00100R\u001b\u00104\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000f\u001a\u0004\b3\u0010+R\u001b\u00107\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u000f\u001a\u0004\b6\u00100R\u001b\u0010:\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u000f\u001a\u0004\b9\u0010+R\u001b\u0010=\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u000f\u001a\u0004\b<\u00100R\u001b\u0010@\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u000f\u001a\u0004\b?\u0010+R\u001b\u0010C\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u000f\u001a\u0004\bB\u00100R\u001b\u0010F\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u000f\u001a\u0004\bE\u00100R\u001b\u0010I\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u000f\u001a\u0004\bH\u00100R\"\u0010Q\u001a\u00020J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006Y"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/aigc/AigcTaskPanel;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "percent", "", "setProgressPercent", "", "", "list", "setKeywordList", "Lcom/bytedance/android/live/effect/sticker/ui/aigc/b;", "listener", "setListener", "Landroid/widget/TextView;", "a", "Lkotlin/Lazy;", "getKeywordTitleTextview", "()Landroid/widget/TextView;", "keywordTitleTextview", "Landroid/view/View;", "b", "getKeywordSelectorContainerView", "()Landroid/view/View;", "keywordSelectorContainerView", "Lcom/bytedance/android/live/effect/sticker/ui/aigc/HorizontalScrollItemSelector;", "c", "getKeywordSelectorContentView", "()Lcom/bytedance/android/live/effect/sticker/ui/aigc/HorizontalScrollItemSelector;", "keywordSelectorContentView", "d", "getButtonContainerView", "buttonContainerView", "e", "getWhiteButtonView", "whiteButtonView", "f", "getBlueButtonView", "blueButtonView", "g", "getProgressView", "progressView", "h", "getCommitTaskButtonText", "()Ljava/lang/String;", "commitTaskButtonText", "", "i", "getCommitTaskButtonWidth", "()I", "commitTaskButtonWidth", "j", "getReCommitTaskButtonText", "reCommitTaskButtonText", "k", "getReCommitTaskButtonWidth", "reCommitTaskButtonWidth", "l", "getApplyBackgroundButtonText", "applyBackgroundButtonText", "m", "getApplyBackgroundButtonWidth", "applyBackgroundButtonWidth", "n", "getReSelectKeywordButtonText", "reSelectKeywordButtonText", "o", "getReSelectKeywordButtonWidth", "reSelectKeywordButtonWidth", "p", "getRunningKeywordTitleTopMargin", "runningKeywordTitleTopMargin", "q", "getDoneKeywordTitleTopMargin", "doneKeywordTitleTopMargin", "", "v", "J", "getCurrentEffectID", "()J", "setCurrentEffectID", "(J)V", "currentEffectID", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AigcTaskPanel extends ConstraintLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public AigcTaskPanelStatus r;
    public final List<String> s;
    public com.bytedance.android.live.effect.sticker.ui.aigc.b t;
    public ValueAnimator u;
    public long v;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AigcTaskPanel a;
        public final /* synthetic */ String b;

        public b(AigcTaskPanel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            HorizontalScrollItemSelector r3 = AigcTaskPanel.R5(this.a);
            if (r3 == null) goto L5;
            r3.c();
        L5:
            this.a.U5(false);
            com.bytedance.android.live.effect.sticker.ui.aigc.b r4 = this.a.t;
            if (r4 == null) goto L9;
            r4.a(this.b);
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ AigcTaskPanel a;
        public final /* synthetic */ String b;

        public c(AigcTaskPanel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            com.bytedance.android.live.effect.sticker.ui.aigc.b r4 = this.a.t;
            if (r4 == null) goto L6;
            r4.c(this.b, AigcTaskPanelClickType.ReGenerate);
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ AigcTaskPanel a;

        public d(AigcTaskPanel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            com.bytedance.android.live.effect.sticker.ui.aigc.b r2 = this.a.t;
            if (r2 == null) goto L6;
            r2.b();
            return;
        }
    }

    public static final class e implements com.bytedance.android.live.effect.sticker.ui.aigc.c {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ AigcTaskPanel b;

        @Override // com.bytedance.android.live.effect.sticker.ui.aigc.c
        public final void a() {
            TextView r0 = this.a;
            HorizontalScrollItemSelector r1 = AigcTaskPanel.R5(this.b);
            if (r1 == null) goto L5;
            int r2 = r1.getCurrentSelectItemIndex();
        L6:
            if (r2 < 0) goto L8;
            boolean r3 = true;
        L9:
            r0.setActivated(r3);
            TextView r4 = this.a;
            r4.setEnabled(r4.isActivated());
            return;
        L8:
            r3 = false;
            goto L9
        L5:
            r2 = -1;
            goto L6
        }

        public e(TextView r1, AigcTaskPanel r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ AigcTaskPanel a;

        public f(AigcTaskPanel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            HorizontalScrollItemSelector r4 = AigcTaskPanel.R5(this.a);
            if (r4 == null) goto L6;
            String r5 = r4.getCurrentSelectKeyword();
            if (r5 == null) goto L6;
        L8:
            if (r5.length() <= 0) goto L10;
            boolean r0 = true;
        L11:
            if (r0 == false) goto L16;
            com.bytedance.android.live.effect.sticker.ui.aigc.b r1 = this.a.t;
            if (r1 == null) goto L17;
            r1.c(r5, AigcTaskPanelClickType.Generate);
            return;
        L17:
            return;
        L16:
            return;
        L10:
            r0 = false;
        L6:
            r5 = "";
            goto L8
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ AigcTaskPanel a;

        public g(AigcTaskPanel r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AigcTaskPanel.S5(this.a, 0.9f);     // Catch: Throwable -> L4
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

    public AigcTaskPanel(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AigcTaskPanel(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final String getApplyBackgroundButtonText() {
        return (String) this.l.getValue();
    }

    private final int getApplyBackgroundButtonWidth() {
        return ((Number) this.m.getValue()).intValue();
    }

    private final TextView getBlueButtonView() {
        return (TextView) this.f.getValue();
    }

    private final View getButtonContainerView() {
        return (View) this.d.getValue();
    }

    private final String getCommitTaskButtonText() {
        return (String) this.h.getValue();
    }

    private final int getCommitTaskButtonWidth() {
        return ((Number) this.i.getValue()).intValue();
    }

    private final int getDoneKeywordTitleTopMargin() {
        return ((Number) this.q.getValue()).intValue();
    }

    private final View getKeywordSelectorContainerView() {
        return (View) this.b.getValue();
    }

    private final HorizontalScrollItemSelector getKeywordSelectorContentView() {
        return (HorizontalScrollItemSelector) this.c.getValue();
    }

    private final TextView getKeywordTitleTextview() {
        return (TextView) this.a.getValue();
    }

    private final View getProgressView() {
        return (View) this.g.getValue();
    }

    private final String getReCommitTaskButtonText() {
        return (String) this.j.getValue();
    }

    private final int getReCommitTaskButtonWidth() {
        return ((Number) this.k.getValue()).intValue();
    }

    private final String getReSelectKeywordButtonText() {
        return (String) this.n.getValue();
    }

    private final int getReSelectKeywordButtonWidth() {
        return ((Number) this.o.getValue()).intValue();
    }

    private final int getRunningKeywordTitleTopMargin() {
        return ((Number) this.p.getValue()).intValue();
    }

    private final TextView getWhiteButtonView() {
        return (TextView) this.e.getValue();
    }

    public final void reset() {
        this.r = AigcTaskPanelStatus.Default;
        ((ArrayList) this.s).clear();
        this.v = 0;
        HorizontalScrollItemSelector r0 = getKeywordSelectorContentView();
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public final long getCurrentEffectID() {
        return this.v;
    }

    public static final /* synthetic */ HorizontalScrollItemSelector R5(AigcTaskPanel r0) {
        return r0.getKeywordSelectorContentView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setProgressPercent(float r4) {
        View r0 = getProgressView();
        if (r0 == null) goto L12;
        View r1 = getProgressView();
        if (r1 == null) goto L9;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L9;
        r2.width = (int) (getWidth() * r4);
        Unit r5 = Unit.INSTANCE;
    L10:
        r0.setLayoutParams(r2);
        return;
    L9:
        r2 = null;
        goto L10
    }

    public final void T5(String r5) {
        Intrinsics.checkNotNullParameter(r5, "keyword");
        AigcTaskPanelStatus r0 = this.r;
        if (r0 != AigcTaskPanelStatus.Running) goto L5;
    L8:
        this.r = AigcTaskPanelStatus.Done;
        TextView r1 = getKeywordTitleTextview();
        if (r1 == null) goto L11;
        r1.setText(r5);
        r1.setVisibility(0);
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        a1.o(r1, getDoneKeywordTitleTopMargin());
        Unit r3 = Unit.INSTANCE;
        r1.setLayoutParams(r2);
    L11:
        View r4 = getKeywordSelectorContainerView();
        if (r4 == null) goto L14;
        r4.setVisibility(8);
    L14:
        ValueAnimator r6 = this.u;
        if (r6 == null) goto L17;
        r6.cancel();
    L17:
        View r7 = getProgressView();
        if (r7 == null) goto L20;
        r7.setVisibility(8);
    L20:
        View r8 = getButtonContainerView();
        if (r8 == null) goto L23;
        r8.setVisibility(0);
    L23:
        TextView r9 = getWhiteButtonView();
        if (r9 == null) goto L26;
        r9.setVisibility(0);
        r9.setText(getReSelectKeywordButtonText());
        r9.setWidth(getReSelectKeywordButtonWidth());
        r9.setOnClickListener(new b(this, r5));
    L26:
        TextView r11 = getBlueButtonView();
        if (r11 == null) goto L29;
        r11.setVisibility(0);
        r11.setActivated(true);
        r11.setText(getReCommitTaskButtonText());
        r11.setWidth(getReCommitTaskButtonWidth());
        r11.setOnClickListener(new c(this, r5));
    L29:
        com.bytedance.android.live.effect.sticker.ui.aigc.b r12 = this.t;
        if (r12 == null) goto L34;
        r12.d(this.r);
        return;
    L34:
        return;
    L5:
        if (r0 == AigcTaskPanelStatus.Default) goto L8;
        ALogger.e("ttlive_anchor_effect_AigcTaskPanekl", this.r.name() + " cannot convert to done");
    }

    public final void U5(boolean r5) {
        AigcTaskPanelStatus r0 = this.r;
        if (r0 != AigcTaskPanelStatus.Done) goto L5;
    L10:
        this.r = AigcTaskPanelStatus.Ready;
        TextView r1 = getKeywordTitleTextview();
        int r2 = 8;
        if (r1 == null) goto L13;
        r1.setVisibility(8);
    L13:
        View r3 = getKeywordSelectorContainerView();
        boolean r4 = false;
        if (r3 == null) goto L16;
        r3.setVisibility(0);
    L16:
        ValueAnimator r6 = this.u;
        if (r6 == null) goto L19;
        r6.cancel();
    L19:
        View r7 = getProgressView();
        if (r7 == null) goto L22;
        r7.setVisibility(8);
    L22:
        View r8 = getButtonContainerView();
        if (r8 == null) goto L25;
        r8.setVisibility(0);
    L25:
        TextView r9 = getWhiteButtonView();
        if (r9 == null) goto L31;
        r9.setText(getApplyBackgroundButtonText());
        r9.setWidth(getApplyBackgroundButtonWidth());
        if (r5 == false) goto L30;
        r2 = 0;
    L30:
        r9.setVisibility(r2);
        r9.setOnClickListener(new d(this));
    L31:
        TextView r11 = getBlueButtonView();
        if (r11 == null) goto L43;
        r11.setVisibility(0);
        r11.setText(getCommitTaskButtonText());
        r11.setWidth(getCommitTaskButtonWidth());
        HorizontalScrollItemSelector r12 = getKeywordSelectorContentView();
        if (r12 == null) goto L36;
        int r13 = r12.getCurrentSelectItemIndex();
    L37:
        if (r13 < 0) goto L39;
        r4 = true;
    L39:
        r11.setActivated(r4);
        r11.setEnabled(r11.isActivated());
        r3.e(r11, new AigcTaskPanel$onStatusReady$2$1());
        HorizontalScrollItemSelector r14 = getKeywordSelectorContentView();
        if (r14 == null) goto L42;
        r14.setItemSelectListener(new e(r11, this));
    L42:
        r11.setOnClickListener(new f(this));
        goto L43
    L36:
        r13 = -1;
    L43:
        com.bytedance.android.live.effect.sticker.ui.aigc.b r15 = this.t;
        if (r15 == null) goto L48;
        r15.d(this.r);
        return;
    L48:
        return;
    L5:
        if (r0 == AigcTaskPanelStatus.Default) goto L10;
        if (r0 == AigcTaskPanelStatus.Running) goto L10;
        ALogger.e("ttlive_anchor_effect_AigcTaskPanekl", this.r.name() + " cannot convert to ready");
    }

    public final void setCurrentEffectID(long r1) {
        this.v = r1;
    }

    public final void setKeywordList(List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "list");
        ((ArrayList) this.s).clear();
        ArrayList r0 = (ArrayList) this.s;
        r0.addAll(r3);
        HorizontalScrollItemSelector r1 = getKeywordSelectorContentView();
        if (r1 == null) goto L6;
        r1.setKeywordList(r3);
        return;
    }

    public final void setListener(com.bytedance.android.live.effect.sticker.ui.aigc.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.t = r2;
    }

    public static final /* synthetic */ void S5(AigcTaskPanel r0, float r1) {
        r0.setProgressPercent(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "keyword");
        AigcTaskPanelStatus r0 = this.r;
        AigcTaskPanelStatus r1 = AigcTaskPanelStatus.Running;
        if (r0 == r1) goto L30;
        this.r = r1;
        TextView r2 = getKeywordTitleTextview();
        if (r2 == null) goto L7;
        r2.setText(r5);
        r2.setVisibility(0);
        ViewGroup.LayoutParams r7 = r2.getLayoutParams();
        a1.o(r2, getRunningKeywordTitleTopMargin());
        Unit r3 = Unit.INSTANCE;
        r2.setLayoutParams(r7);
    L7:
        View r8 = getKeywordSelectorContainerView();
        if (r8 == null) goto L10;
        r8.setVisibility(8);
    L10:
        if (r6 == false) goto L20;
        setProgressPercent(0.0f);
        ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{0.0f, 0.9f}).setDuration(3000);
        this.u = r9;
        if (r9 == null) goto L14;
        r9.setInterpolator(new LinearInterpolator());
    L14:
        ValueAnimator r11 = this.u;
        if (r11 == null) goto L17;
        r11.addUpdateListener(new com.bytedance.android.live.effect.sticker.ui.aigc.a(this));
    L17:
        ValueAnimator r12 = this.u;
        if (r12 == null) goto L21;
        r12.start();
    L21:
        View r13 = getProgressView();
        if (r13 == null) goto L24;
        r13.setVisibility(0);
    L24:
        View r14 = getButtonContainerView();
        if (r14 == null) goto L27;
        r14.setVisibility(8);
    L27:
        com.bytedance.android.live.effect.sticker.ui.aigc.b r15 = this.t;
        if (r15 == null) goto L32;
        r15.d(this.r);
        return;
    L32:
        return;
    L20:
        post(new g(this));
        goto L21
    L30:
        ALogger.e("ttlive_anchor_effect_AigcTaskPanekl", this.r.name() + " cannot convert to running");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AigcTaskPanel(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new AigcTaskPanel$keywordTitleTextview$2(this));
        this.b = LazyKt.lazy(new AigcTaskPanel$keywordSelectorContainerView$2(this));
        this.c = LazyKt.lazy(new AigcTaskPanel$keywordSelectorContentView$2(this));
        this.d = LazyKt.lazy(new AigcTaskPanel$buttonContainerView$2(this));
        this.e = LazyKt.lazy(new AigcTaskPanel$whiteButtonView$2(this));
        this.f = LazyKt.lazy(new AigcTaskPanel$blueButtonView$2(this));
        this.g = LazyKt.lazy(new AigcTaskPanel$progressView$2(this));
        this.h = LazyKt.lazy(AigcTaskPanel$commitTaskButtonText$2.INSTANCE);
        this.i = LazyKt.lazy(AigcTaskPanel$commitTaskButtonWidth$2.INSTANCE);
        this.j = LazyKt.lazy(AigcTaskPanel$reCommitTaskButtonText$2.INSTANCE);
        this.k = LazyKt.lazy(AigcTaskPanel$reCommitTaskButtonWidth$2.INSTANCE);
        this.l = LazyKt.lazy(AigcTaskPanel$applyBackgroundButtonText$2.INSTANCE);
        this.m = LazyKt.lazy(AigcTaskPanel$applyBackgroundButtonWidth$2.INSTANCE);
        this.n = LazyKt.lazy(AigcTaskPanel$reSelectKeywordButtonText$2.INSTANCE);
        this.o = LazyKt.lazy(AigcTaskPanel$reSelectKeywordButtonWidth$2.INSTANCE);
        this.p = LazyKt.lazy(AigcTaskPanel$runningKeywordTitleTopMargin$2.INSTANCE);
        this.q = LazyKt.lazy(AigcTaskPanel$doneKeywordTitleTopMargin$2.INSTANCE);
        this.r = AigcTaskPanelStatus.Default;
        this.s = new ArrayList();
        ViewGroup.inflate(r2, 2131565837, this);
    }

    public /* synthetic */ AigcTaskPanel(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
