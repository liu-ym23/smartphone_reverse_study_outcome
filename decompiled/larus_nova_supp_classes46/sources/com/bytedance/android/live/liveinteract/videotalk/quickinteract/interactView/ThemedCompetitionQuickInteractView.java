package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.o;
import com.bytedance.android.live.liveinteract.utils.i1;
import com.bytedance.android.live.liveinteract.utils.q1;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.livesdk.chatroom.model.interact.SelectionType;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001;B'\b\u0007\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u00108\u001a\u00020\u0002¢\u0006\u0004\b9\u0010:J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0017\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010&\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R\u0017\u0010,\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R*\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006<"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/ThemedCompetitionQuickInteractView;", "Landroid/widget/FrameLayout;", "", "resId", "", "setBackground", "", "visible", "setIconVisibility", "Landroid/view/View;", "b", "Landroid/view/View;", "getStaticBg", "()Landroid/view/View;", "staticBg", "c", "getAnimationBg", "animationBg", "Lcom/bytedance/android/live/core/widget/HSImageView;", "d", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getIcon", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "icon", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "getIconContainer", "()Landroid/view/ViewGroup;", "iconContainer", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "getThankView", "()Landroid/widget/TextView;", "thankView", "g", "getScoreView", "scoreView", "Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/a;", "i", "Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/a;", "getAnimationHelper", "()Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/a;", "animationHelper", "value", "state", "I", "getState", "()I", "setState", "(I)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ThemedCompetitionQuickInteractView extends FrameLayout {
    public final String a;
    public final View b;
    public final View c;
    public final HSImageView d;
    public final ViewGroup e;
    public final TextView f;
    public final TextView g;
    public final FrameLayout h;
    public final com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a i;
    public String j;
    public boolean k;

    public static final class a {
    }

    public static final class b implements f.a {
        public final /* synthetic */ ThemedCompetitionQuickInteractView a;

        public b(ThemedCompetitionQuickInteractView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f.a
        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "score");
            ThemedCompetitionQuickInteractView r0 = this.a;
            if (TextUtils.equals(r3, r0.j) == true) goto L6;
            r0.b(r0.j);
            return;
        }
    }

    static {
    }

    public ThemedCompetitionQuickInteractView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ThemedCompetitionQuickInteractView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void c() {
        this.d.setScaleX(1.0f);
        this.d.setScaleY(1.0f);
        a1.m(this.d, s1.f(0.0f));
        a1.n(this.d, s1.f(0.0f));
        if (ThemedCompetitionContext.Companion.b() != SelectionType.SCORING.getValue()) goto L6;
        setIconVisibility(false);
        return;
    }

    public final int getState() {
        return this.i.j;
    }

    public final View getAnimationBg() {
        return this.c;
    }

    public final com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a getAnimationHelper() {
        return this.i;
    }

    public final HSImageView getIcon() {
        return this.d;
    }

    public final ViewGroup getIconContainer() {
        return this.e;
    }

    public final TextView getScoreView() {
        return this.g;
    }

    public final View getStaticBg() {
        return this.b;
    }

    public final TextView getThankView() {
        return this.f;
    }

    public final void a(QuickInteractTask r8) {
        Intrinsics.checkNotNullParameter(r8, "task");
        if (r8.i == false) goto L12;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r1 = this.i;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "task");
        QuickInteractTask r0 = r1.k;
        if (r0 == null) goto L7;
        String r2 = r0.d;
    L9:
        if (Intrinsics.areEqual(r2, r8.d) == false) goto L29;
        r1.b();
        return;
    L29:
        return;
    L7:
        r2 = null;
        goto L9
    L12:
        String r3 = r8.b;
        if (r3 != null) goto L15;
    L18:
        boolean r4 = true;
    L19:
        if (r4 == false) goto L21;
    L25:
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r5 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r5 == null) goto L30;
        r5.k7(r8);
        return;
    L30:
        return;
    L21:
        if (TextUtils.equals(this.j, r8.b) == true) goto L25;
        this.j = r8.b;
        this.i.a(r8, new ThemedCompetitionQuickInteractView$consumeInteractTask$1(this), new ThemedCompetitionQuickInteractView$consumeInteractTask$2(this), null, null);
        return;
    L15:
        if (r3.length() == 0) goto L18;
        r4 = false;
        goto L19
    }

    public final void b(String r4) {
        this.j = r4;
        if (((Boolean) vm2.d.k4.getValue(null, vm2.d.a[268(0x10c, float:3.76E-43)])).booleanValue() == false) goto L7;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r0 = this.i;
        if (r0.j != 0) goto L9;
        r0.g(r4, new ThemedCompetitionQuickInteractView$doUpdateNormalScore$1(this));
        return;
    L9:
        return;
    L7:
        this.i.g(r4, AnimationHelper$updateScore$1.INSTANCE);
    }

    public final void setBackground(int r2) {
        this.b.setBackgroundResource(r2);
    }

    public final void setIconVisibility(boolean r3) {
        if (r3 == false) goto L9;
        this.e.setVisibility(0);
        ConstraintLayout.LayoutParams r4 = this.h.getLayoutParams();
        if (r4 == null) goto L8;
        ConstraintLayout.LayoutParams r5 = r4;
        ((ViewGroup.MarginLayoutParams) r5).leftMargin = UtilityKotlinExtentionsKt.i(0);
        this.h.setLayoutParams(r5);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L9:
        this.e.setVisibility(8);
        ConstraintLayout.LayoutParams r6 = this.h.getLayoutParams();
        if (r6 == null) goto L14;
        ConstraintLayout.LayoutParams r7 = r6;
        ((ViewGroup.MarginLayoutParams) r7).leftMargin = UtilityKotlinExtentionsKt.i(4);
        this.h.setLayoutParams(r7);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setState(int r2) {
        this.i.j = r2;
    }

    public ThemedCompetitionQuickInteractView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = "ThemedCompetitionQuickInteractView";
        LayoutInflater.from(r4).inflate(2131566835, this, true);
        setClipChildren(false);
        this.b = findViewById(2131375537);
        this.c = findViewById(2131375501);
        HSImageView r7 = findViewById(2131375513);
        this.d = r7;
        this.e = (ViewGroup) findViewById(2131375514);
        HSImageView r8 = findViewById(2131375503);
        TextView r0 = (TextView) findViewById(2131375504);
        this.f = (TextView) findViewById(2131388545);
        this.g = (TextView) findViewById(2131385178);
        this.h = (FrameLayout) findViewById(2131375542);
        this.i = new com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a(this, new b(this));
        this.j = "0";
        r8.setOnClickListener(x0.a(new AnonymousClass1(this)));
        r0.setOnClickListener(x0.a(new AnonymousClass2(this)));
        i1.a(r7);
        d(null, null, null, 0);
    }

    public /* synthetic */ ThemedCompetitionQuickInteractView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void d(String r3, String r4, String r5, int r6) {
        if (r3 != null) goto L41;
    L14:
        int r7 = i1.a;     // Catch: Exception -> L38
        i1.a(this.d);     // Catch: Exception -> L38
    L16:
        if (TextUtils.isEmpty(r4) == true) goto L18;
        GradientDrawable r8 = new GradientDrawable();     // Catch: Exception -> L38
        r8.setColor(Color.parseColor(r4));     // Catch: Exception -> L38
        r8.setCornerRadius(UtilityKotlinExtentionsKt.i(30));     // Catch: Exception -> L38
        this.b.setBackground(r8);     // Catch: Exception -> L38
    L20:
        if (TextUtils.isEmpty(r5) == true) goto L27;
        TextView r9 = this.f;     // Catch: Exception -> L38
        if (r9 == null) goto L24;
        r9.setTextColor(Color.parseColor(r5));     // Catch: Exception -> L38
    L24:
        TextView r10 = this.g;     // Catch: Exception -> L38
        if (r10 == null) goto L34;
        r10.setTextColor(Color.parseColor(r5));     // Catch: Exception -> L38
    L34:
        if (r6 != 1) goto L36;
        this.d.setScaleX(1.83f);     // Catch: Exception -> L38
        this.d.setScaleY(1.83f);     // Catch: Exception -> L38
        a1.m(this.d, -s1.f(4.0f));     // Catch: Exception -> L38
        a1.n(this.d, s1.f(4.0f));     // Catch: Exception -> L38
        setIconVisibility(true);     // Catch: Exception -> L38
        return;
    L36:
        c();     // Catch: Exception -> L38
        return;
    L27:
        TextView r11 = this.f;     // Catch: Exception -> L38
        if (r11 == null) goto L31;
        r11.setTextColor(Color.parseColor("#FFFFFF"));     // Catch: Exception -> L38
    L31:
        TextView r12 = this.g;     // Catch: Exception -> L38
        if (r12 == null) goto L34;
        r12.setTextColor(Color.parseColor("#FFFFFF"));     // Catch: Exception -> L38
        goto L34
    L18:
        this.b.setBackgroundResource(2131250756);     // Catch: Exception -> L38
        goto L20
    L41:
    L38:
        e = move-exception;
        ALogger.e(this.a, "updateIconByCommonWidget error!", e);
        return;
    L5:
        if (r3.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L14;
        HSImageView r2 = this.d;     // Catch: Exception -> L38
        Uri r13 = UriProtector.parse(r3);     // Catch: Exception -> L38
        if (r2 == null) goto L16;
        if (r13 == null) goto L16;
        r2.setImageURI(r13);     // Catch: Exception -> L38
        goto L16
    L7:
        r1 = false;
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.k == true) goto L9;
        int r6 = o.a(((Number) vm2.d.m4.getValue(null, vm2.d.a[270(0x10e, float:3.78E-43)])).intValue());
        if (r6 <= 0) goto L7;
        q1.a(this, new int[]{r6, r6, r6, r6});
    L7:
        this.k = true;
        return;
    }
}
