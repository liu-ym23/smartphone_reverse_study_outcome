package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.o;
import com.bytedance.android.live.liveinteract.utils.i1;
import com.bytedance.android.live.liveinteract.utils.q1;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010U\u001a\u00020T\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010V\u0012\b\b\u0002\u0010X\u001a\u00020\t¢\u0006\u0004\bY\u0010ZJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010)\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010/\u001a\u0004\u0018\u00010*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0019\u00104\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0019\u00107\u001a\u0004\u0018\u00010*8\u0006¢\u0006\f\n\u0004\b5\u0010,\u001a\u0004\b6\u0010.R$\u0010?\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0017\u0010E\u001a\u00020@8\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR*\u0010G\u001a\u00020\t2\u0006\u0010F\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR*\u0010N\u001a\u00020M2\u0006\u0010F\u001a\u00020M8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010S¨\u0006["}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/LinkMicQuickInteractView;", "Landroid/widget/FrameLayout;", "", "score", "", "setContentDescription", "Landroid/view/ViewGroup;", "getMainContainer", "getExtraContainer", "", "resId", "setBackground", "color", "setTextColor", "setAnimationBackground", "backgroundColor", "setGiftFlashBackground", "visibility", "setVisibility", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "getStaticBg", "()Landroid/widget/ImageView;", "staticBg", "Landroid/view/View;", "e", "Landroid/view/View;", "getAnimationBg", "()Landroid/view/View;", "animationBg", "Lcom/bytedance/android/live/core/widget/HSImageView;", "f", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getIcon", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "icon", "g", "Landroid/view/ViewGroup;", "getIconParent", "()Landroid/view/ViewGroup;", "iconParent", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "getThankView", "()Landroid/widget/TextView;", "thankView", "j", "Landroid/widget/FrameLayout;", "getSwitchContainer", "()Landroid/widget/FrameLayout;", "switchContainer", "k", "getScoreView", "scoreView", "Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/ProgressImageView;", "l", "Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/ProgressImageView;", "getStarWishProgressView", "()Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/ProgressImageView;", "setStarWishProgressView", "(Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/ProgressImageView;)V", "starWishProgressView", "Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/a;", "n", "Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/a;", "getAnimationHelper", "()Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/a;", "animationHelper", "value", "state", "I", "getState", "()I", "setState", "(I)V", "", "disableBgAnim", "Z", "getDisableBgAnim", "()Z", "setDisableBgAnim", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkMicQuickInteractView extends FrameLayout {
    public final ViewGroup a;
    public final ViewGroup b;
    public final View c;
    public final ImageView d;
    public final View e;
    public final HSImageView f;
    public final ViewGroup g;
    public final TextView h;
    public final TextView i;
    public final FrameLayout j;
    public final TextView k;
    public ProgressImageView l;
    public final TextSwitcher m;
    public final com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a n;
    public int o;
    public String p;
    public int q;
    public String r;
    public long s;
    public String t;
    public long u;
    public boolean v;
    public boolean w;
    public String x;
    public Function0<Unit> y;
    public Function0<Unit> z;

    public static final class a implements f.a {
        public final /* synthetic */ LinkMicQuickInteractView a;

        public a(LinkMicQuickInteractView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f.a
        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "score");
            LinkMicQuickInteractView r0 = this.a;
            if (TextUtils.equals(r3, r0.x) == true) goto L6;
            r0.e(r0.x);
            return;
        }
    }

    public LinkMicQuickInteractView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LinkMicQuickInteractView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean getDisableBgAnim() {
        return this.n.m;
    }

    public final int getState() {
        return this.n.j;
    }

    public static boolean d() {
        int r0 = je0.d.f();
        if (r0 != 8) goto L5;
    L8:
        return true;
    L5:
        if (r0 == 12) goto L8;
        return false;
    }

    public final View getAnimationBg() {
        return this.e;
    }

    public final com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a getAnimationHelper() {
        return this.n;
    }

    public final ViewGroup getExtraContainer() {
        return this.a;
    }

    public final HSImageView getIcon() {
        return this.f;
    }

    public final ViewGroup getIconParent() {
        return this.g;
    }

    public final ViewGroup getMainContainer() {
        return this.b;
    }

    public final TextView getScoreView() {
        return this.k;
    }

    public final ProgressImageView getStarWishProgressView() {
        return this.l;
    }

    public final ImageView getStaticBg() {
        return this.d;
    }

    public final FrameLayout getSwitchContainer() {
        return this.j;
    }

    public final TextView getThankView() {
        return this.i;
    }

    private final void setContentDescription(String r4) {
        r3.a(this, getContext().getString(2131914682) + r4);
    }

    public final void c(QuickInteractTask r11) {
        Intrinsics.checkNotNullParameter(r11, "task");
        gj0.i.a("LinkMicQuickInteractView", "consumeInteractTask " + r11.b);
        String r3 = null;
        boolean r4 = false;
        if (r11.i == false) goto L11;
        a(this, false, false, 3);
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r1 = this.n;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r11, "task");
        QuickInteractTask r0 = r1.k;
        if (r0 == null) goto L8;
        r3 = r0.d;
    L8:
        if (Intrinsics.areEqual(r3, r11.d) == false) goto L31;
        r1.b();
        return;
    L31:
        return;
    L11:
        String r2 = r11.b;
        if (r2 != null) goto L14;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
    L27:
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r6 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r6 == null) goto L32;
        r6.k7(r11);
        return;
    L32:
        return;
    L20:
        if (TextUtils.equals(this.x, r11.b) == true) goto L27;
        this.x = r11.b;
        gj0.i.a("LinkMicQuickInteractView", "consumeInteractTask update score currentScore : " + this.x);
        if (r11.d.length() <= 0) goto L25;
        r4 = true;
    L25:
        k(r4);
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = null;
        this.n.a(r11, new LinkMicQuickInteractView$consumeInteractTask$1(this, r7), new LinkMicQuickInteractView$consumeInteractTask$2(this, r7), new LinkMicQuickInteractView$consumeInteractTask$3(this), new LinkMicQuickInteractView$consumeInteractTask$4(this));
        return;
    L14:
        if (r2.length() == 0) goto L17;
        r5 = false;
        goto L18
    }

    public final void e(String r4) {
        a(this, false, false, 3);
        this.x = r4;
        gj0.i.a("LinkMicQuickInteractView", "doUpdateNormalScore " + r4);
        k(true);
        if (((Boolean) vm2.d.k4.getValue(null, vm2.d.a[268(0x10c, float:3.76E-43)])).booleanValue() == false) goto L7;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r0 = this.n;
        if (r0.j != 0) goto L8;
        r0.g(r4, new LinkMicQuickInteractView$doUpdateNormalScore$1(this));
    L8:
        setContentDescription(r4);
        return;
    L7:
        this.n.g(r4, AnimationHelper$updateScore$1.INSTANCE);
        goto L8
    }

    public final void f(ConstraintLayout r5) {
        ConstraintSet r0 = new ConstraintSet();
        r0.clone(r5);
        r0.connect(getId(), 6, 0, 6);
        r0.applyTo(r5);
        ViewGroup.LayoutParams r6 = getLayoutParams();
        if (r6 == null) goto L6;
        r6.width = -2;
        setLayoutParams(r6);
        return;
    }

    public final void g(String r3) {
    L7:
        e = move-exception;
        ALogger.e("LinkMicQuickInteractView", "updateDynamicBackgroundColor error!", e);
        return;
    L3:
        if (TextUtils.isEmpty(r3) == true) goto L5;
        GradientDrawable r0 = new GradientDrawable();     // Catch: Exception -> L7
        r0.setColor(Color.parseColor(r3));     // Catch: Exception -> L7
        r0.setCornerRadius(UtilityKotlinExtentionsKt.i(30));     // Catch: Exception -> L7
        this.d.setBackground(r0);     // Catch: Exception -> L7
    L10:
        return;
    L5:
        setBackground(this.o);     // Catch: Exception -> L7
        goto L10
    }

    public final void h(String r5) {
        if (TextUtils.isEmpty(r5) == true) goto L11;
        Integer r0 = je0.d.h();
        if (r0 != null) goto L8;
    L10:
        a1.o(this.f, qy.a.a(r5), ImageView.ScaleType.FIT_CENTER);
        return;
    L8:
        if (r0.intValue() != 24) goto L10;
        ImageUtil.loadImage(this.f, qy.a.a(r5), s1.f(20.0f), s1.f(20.0f), null);
        return;
    L11:
        int r6 = i1.a;
        i1.a(this.f);
    }

    public final void i(String r3) {
    L12:
        e = move-exception;
        ALogger.e("LinkMicQuickInteractView", "updateDynamicTextColor error!", e);
        return;
    L3:
        if (TextUtils.isEmpty(r3) == true) goto L10;
        TextView r0 = this.i;     // Catch: Exception -> L12
        if (r0 == null) goto L7;
        r0.setTextColor(Color.parseColor(r3));     // Catch: Exception -> L12
    L7:
        TextView r1 = this.k;     // Catch: Exception -> L12
        if (r1 == null) goto L16;
        r1.setTextColor(Color.parseColor(r3));     // Catch: Exception -> L12
        return;
    L16:
        return;
    L10:
        setTextColor(this.p);     // Catch: Exception -> L12
    }

    public final void j(String r3) {
        gj0.i.a("LinkMicQuickInteractView", "updateNormalScore " + r3);
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        return;
    L12:
        if (TextUtils.equals(this.x, r3) == true) goto L15;
        e(r3);
        return;
    L15:
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public final void k(boolean r14) {
        if (this.q == 2) goto L5;
        return;
    L5:
        long r4 = 0;
        if (this.s != 0) goto L8;
        return;
    L8:
        String r0 = this.x;
        Long r2 = null;
        if (r0 == null) goto L11;
        char[] r1 = r0.toCharArray();
    L13:
        if (r1 == null) goto L36;
        StringBuilder r5 = new StringBuilder();
        int r6 = r1.length;
        int r7 = 0;
    L17:
        if (r7 >= r6) goto L27;
        char r8 = r1[r7];
        if (r8 != 19975) goto L21;
    L25:
        r5.append(r8);
    L26:
        r7 = r7 + 1;
        goto L17
    L21:
        if ('0' > r8) goto L26;
        if ('9' < r8) goto L26;
    L27:
        String r3 = r5.toString();
        if (r3 != null) goto L30;
    L32:
        if (r3 == null) goto L34;
        r2 = Long.valueOf(CastLongProtector.parseLong(r3));
    L34:
        long r9 = r2.longValue();
    L35:
        r4 = r9;
        goto L36
    L30:
        if (StringsKt.contains$default(r3, 19975, false, 2, null) != true) goto L32;
        r9 = (long) (CastFloatProtector.parseFloat(StringsKt.replace$default(r3, 19975, '0', false, 4, null)) * 1000);
    L36:
        this.u = r4;
        gj0.i.a("LinkMicQuickInteractView", "curPlayerUid：" + this.r + "--this:" + hashCode() + "--updateStarProgress " + this.u + " / " + this.s + "--updateWithAnim:" + r14);
        if (this.s <= this.u) goto L44;
        ProgressImageView r10 = this.l;
        if (r10 == null) goto L41;
        r10.setVisibility(0);
    L41:
        ProgressImageView r11 = this.l;
        if (r11 == null) goto L52;
        r11.b(this.u / this.s, this.t, r14);
        return;
    L52:
        return;
    L44:
        ProgressImageView r12 = this.l;
        if (r12 == null) goto L54;
        r12.b(1.0f, this.t, r14);
        return;
    L54:
        return;
    L11:
        r1 = null;
        goto L13
    }

    public final void setAnimationBackground(String r3) {
        GradientDrawable r0 = new GradientDrawable();     // Catch: Exception -> L4
        r0.setColor(Color.parseColor(r3));     // Catch: Exception -> L4
        r0.setCornerRadius(UtilityKotlinExtentionsKt.i(30));     // Catch: Exception -> L4
        this.e.setBackground(r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        ALogger.e("LinkMicQuickInteractView", "setAnimationBackground error!", e);
    }

    public final void setBackground(int r3) {
        if (this.q != 2) goto L5;
        return;
    L5:
        this.d.setBackgroundResource(r3);
        this.o = r3;
    }

    public final void setDisableBgAnim(boolean r2) {
        this.n.m = r2;
    }

    public final void setGiftFlashBackground(int r2) {
        this.c.setBackgroundResource(r2);
    }

    public final void setStarWishProgressView(ProgressImageView r1) {
        this.l = r1;
    }

    public final void setState(int r2) {
        this.n.j = r2;
    }

    public final void setTextColor(String r3) {
        Intrinsics.checkNotNullParameter(r3, "color");
        TextView r0 = this.i;     // Catch: Exception -> L11
        if (r0 == null) goto L6;
        r0.setTextColor(Color.parseColor(r3));     // Catch: Exception -> L11
    L6:
        TextView r1 = this.k;     // Catch: Exception -> L11
        if (r1 == null) goto L9;
        r1.setTextColor(Color.parseColor(r3));     // Catch: Exception -> L11
    L9:
        this.p = r3;     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        ALogger.e("LinkMicQuickInteractView", "setTextColor error!", e);
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        if (r3 != 0) goto L5;
        Log.getStackTraceString(new Exception("LinkMicQuickInteractView#Visible"));
    L5:
        super.setVisibility(r3);
    }

    public final void setAnimationBackground(int r2) {
        this.e.setBackgroundResource(r2);
    }

    public final void b(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "score");
        Intrinsics.checkNotNullParameter(r5, "playerId");
        this.r = r5;
        this.x = r4;
        a(this, Intrinsics.areEqual(r4, "0"), false, 2);
        k(false);
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r6 = this.n;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r4, "score");
        r6.f();
        f r7 = r6.f;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r4, "score");
        r7.a.setCurrentText(r4);
        r7.d = r4;
    }

    public final void l(int r17, String r18) {
        gj0.i.a("LinkMicQuickInteractView", "updateStyleType " + r17);
        int r2 = this.q;
        if (r2 != 4) goto L5;
        return;
    L5:
        boolean r5 = true;
        if (r2 == 2) goto L9;
        if (r17 != r2) goto L9;
        this.v = getDisableBgAnim();
        setDisableBgAnim(true);
    L9:
        int r3 = this.q;
        if (r3 != 2) goto L13;
        if (r17 == r3) goto L13;
        setDisableBgAnim(this.v);
    L13:
        this.q = r17;
        a(this, false, false, 3);
        ViewGroup.LayoutParams r9 = null;
        float r13 = 3.0f;
        if (r17 == 0) goto L118;
        float r15 = 5.0f;
        if (r17 == 1) goto L93;
        if (r17 == 2) goto L37;
        if (r17 == 3) goto L36;
        if (r17 != 4) goto L156;
        this.a.setVisibility(0);
        if (this.g.getVisibility() != 8) goto L24;
        this.g.setVisibility(0);
    L24:
        com.bytedance.android.live.core.utils.a1.m(this.g, s1.f(0.0f));
        this.b.setPadding(s1.f(3.0f), 0, 0, 0);
        this.a.setPadding(0, 0, s1.f(3.0f), 0);
        this.f.setScaleX(0.8f);
        this.f.setScaleY(0.8f);
        FrameLayout r1 = this.j;
        if (r1 == null) goto L27;
        ViewGroup.LayoutParams r4 = r1.getLayoutParams();
    L29:
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L32;
        r9 = r4;
    L32:
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
        if (r10 == null) goto L35;
        r10.rightMargin = 0;
    L35:
        this.b.setMinimumWidth(0);
        return;
    L27:
        r4 = null;
        goto L29
    L156:
        return;
    L36:
        setDisableBgAnim(false);
        this.g.setVisibility(8);
        return;
    L37:
        gj0.i.a("LinkMicQuickInteractView", "starWishStyleType " + this.s + "  curScore：" + this.u);
        setDisableBgAnim(true);
        if (r18 != null) goto L40;
    L43:
        boolean r6 = true;
    L44:
        if (r6 == true) goto L46;
        this.f.setScaleX(2.0f);
        this.f.setScaleY(2.0f);
        com.bytedance.android.live.core.utils.a1.m(this, s1.f(5.0f));
    L51:
        if (d() == false) goto L66;
        if (r18 != null) goto L54;
    L57:
        if (r5 == false) goto L66;
        FrameLayout r7 = this.j;
        if (r7 == null) goto L61;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
    L62:
        if (r8 == null) goto L65;
        ViewGroup.LayoutParams r11 = (ConstraintLayout.LayoutParams) r8;
        ((ConstraintLayout.LayoutParams) r11).rightToRight = -1;
        ((ConstraintLayout.LayoutParams) r11).endToEnd = -1;
        this.j.setLayoutParams(r11);
    L72:
        ViewGroup.LayoutParams r12 = this.f.getLayoutParams();
        com.bytedance.android.live.core.utils.a1.m(this.f, s1.f(0.0f));
        com.bytedance.android.live.core.utils.a1.n(this.f, s1.f(5.0f));
        this.f.setLayoutParams(r12);
        if (this.s <= 0) goto L77;
        ProgressImageView r14 = this.l;
        if (r14 == null) goto L80;
        r14.setVisibility(0);
    L80:
        this.g.setVisibility(0);
        FrameLayout r16 = this.j;
        if (r16 == null) goto L83;
        ViewGroup.LayoutParams r19 = r16.getLayoutParams();
    L85:
        if ((r19 instanceof ViewGroup.MarginLayoutParams) == false) goto L88;
        r9 = r19;
    L88:
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r9;
        if (r20 == null) goto L151;
        r20.leftMargin = 0;
        return;
    L151:
        return;
    L83:
        r19 = null;
        goto L85
    L77:
        ProgressImageView r21 = this.l;
        if (r21 == null) goto L80;
        r21.setVisibility(8);
        goto L80
    L65:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L61:
        r8 = null;
        goto L62
    L54:
        if (r18.length() == 0) goto L57;
        r5 = false;
    L66:
        FrameLayout r22 = this.j;
        if (r22 == null) goto L69;
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
    L70:
        if (r23 == null) goto L92;
        ViewGroup.LayoutParams r24 = (ConstraintLayout.LayoutParams) r23;
        ((ConstraintLayout.LayoutParams) r24).rightToRight = 2131375537;
        ((ConstraintLayout.LayoutParams) r24).endToEnd = 2131375537;
        this.j.setLayoutParams(r24);
        goto L72
    L92:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L69:
        r23 = null;
        goto L70
    L46:
        this.f.setScaleX(1.0f);
        this.f.setScaleY(1.0f);
        if (je0.d.B() == false) goto L49;
        r13 = 0.0f;
    L49:
        com.bytedance.android.live.core.utils.a1.m(this, s1.f(r13));
        goto L51
    L40:
        if (r18.length() == 0) goto L43;
        r6 = false;
        goto L44
    L93:
        setDisableBgAnim(false);
        ViewGroup.LayoutParams r25 = this.f.getLayoutParams();
        this.f.setScaleX(1.83f);
        this.f.setScaleY(1.83f);
        com.bytedance.android.live.core.utils.a1.m(this.f, -s1.f(5.0f));
        com.bytedance.android.live.core.utils.a1.n(this.f, s1.f(5.0f));
        if (je0.d.B() == true) goto L97;
        r15 = 8.0f;
    L97:
        com.bytedance.android.live.core.utils.a1.m(this, s1.f(r15));
        if (d() == false) goto L107;
        FrameLayout r26 = this.j;
        if (r26 == null) goto L102;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
    L103:
        if (r27 == null) goto L106;
        ViewGroup.LayoutParams r28 = (ConstraintLayout.LayoutParams) r27;
        ((ConstraintLayout.LayoutParams) r28).rightToRight = 2131375537;
        ((ConstraintLayout.LayoutParams) r28).endToEnd = 2131375537;
        this.j.setLayoutParams(r28);
        goto L107
    L106:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L102:
        r27 = null;
    L107:
        this.f.setLayoutParams(r25);
        this.g.setVisibility(0);
        FrameLayout r29 = this.j;
        if (r29 == null) goto L110;
        ViewGroup.LayoutParams r30 = r29.getLayoutParams();
    L112:
        if ((r30 instanceof ViewGroup.MarginLayoutParams) == false) goto L115;
        r9 = r30;
    L115:
        ViewGroup.MarginLayoutParams r31 = (ViewGroup.MarginLayoutParams) r9;
        if (r31 == null) goto L153;
        r31.leftMargin = 0;
        return;
    L153:
        return;
    L110:
        r30 = null;
        goto L112
    L118:
        setDisableBgAnim(false);
        ViewGroup.LayoutParams r32 = this.f.getLayoutParams();
        this.f.setScaleX(1.0f);
        this.f.setScaleY(1.0f);
        com.bytedance.android.live.core.utils.a1.m(this.f, s1.f(0.0f));
        com.bytedance.android.live.core.utils.a1.n(this.f, s1.f(0.0f));
        if (je0.d.B() == false) goto L121;
        r13 = 0.0f;
    L121:
        com.bytedance.android.live.core.utils.a1.m(this, s1.f(r13));
        this.f.setLayoutParams(r32);
        if (d() == false) goto L131;
        FrameLayout r33 = this.j;
        if (r33 == null) goto L126;
        ViewGroup.LayoutParams r34 = r33.getLayoutParams();
    L127:
        if (r34 == null) goto L130;
        ViewGroup.LayoutParams r35 = (ConstraintLayout.LayoutParams) r34;
        ((ConstraintLayout.LayoutParams) r35).rightToRight = 2131375537;
        ((ConstraintLayout.LayoutParams) r35).endToEnd = 2131375537;
        this.j.setLayoutParams(r35);
        goto L131
    L130:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L126:
        r34 = null;
    L131:
        ProgressImageView r36 = this.l;
        if (r36 == null) goto L134;
        r36.c = 0.0f;
        r36.a = 0.0f;
        r36.invalidate();
    L134:
        ProgressImageView r37 = this.l;
        if (r37 == null) goto L137;
        r37.setVisibility(8);
    L137:
        this.t = null;
        this.g.setVisibility(0);
        FrameLayout r38 = this.j;
        if (r38 == null) goto L140;
        ViewGroup.LayoutParams r39 = r38.getLayoutParams();
    L142:
        if ((r39 instanceof ViewGroup.MarginLayoutParams) == false) goto L145;
        r9 = r39;
    L145:
        ViewGroup.MarginLayoutParams r40 = (ViewGroup.MarginLayoutParams) r9;
        if (r40 == null) goto L155;
        r40.leftMargin = 0;
        return;
    L155:
        return;
    L140:
        r39 = null;
        goto L142
    }

    public LinkMicQuickInteractView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        LayoutInflater.from(r3).inflate(2131566835, this, true);
        setClipChildren(false);
        this.a = (ViewGroup) findViewById(2131372014);
        this.b = (ViewGroup) findViewById(2131379435);
        this.c = findViewById(2131372905);
        this.d = (ImageView) findViewById(2131375537);
        this.e = findViewById(2131375501);
        HSImageView r6 = findViewById(2131375513);
        this.f = r6;
        this.g = (ViewGroup) findViewById(2131375515);
        HSImageView r7 = findViewById(2131375503);
        TextView r8 = (TextView) findViewById(2131375504);
        this.h = r8;
        this.i = (TextView) findViewById(2131388545);
        this.j = (FrameLayout) findViewById(2131375542);
        this.k = (TextView) findViewById(2131385178);
        this.l = (ProgressImageView) findViewById(2131387198);
        this.m = (TextSwitcher) findViewById(2131385176);
        this.n = new com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a(this, new a(this));
        this.o = 2131252702;
        this.p = "#FFFFFF";
        this.r = "";
        this.s = 1000;
        this.x = "0";
        r7.setOnClickListener(x0.a(new AnonymousClass1(this)));
        r8.setOnClickListener(x0.a(new AnonymousClass2(this)));
        r6.getHierarchy().setPlaceholderImage(null);
        i1.a(r6);
        setContentDescription(this.x);
    }

    public /* synthetic */ LinkMicQuickInteractView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static void a(LinkMicQuickInteractView r2, boolean r3, boolean r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if (r2.q != 4) goto L19;
        ViewGroup r6 = UtilityKotlinExtentionsKt.p(r2);
        if ((r6 instanceof ConstraintLayout) == true) goto L13;
        r6 = null;
    L13:
        ConstraintLayout r7 = (ConstraintLayout) r6;
        if (r7 == null) goto L20;
        if (r3 == false) goto L17;
        r2.f(r7);
        return;
    L17:
        r2.getViewTreeObserver().addOnGlobalLayoutListener(new e(r7, r2, r4));
        return;
    L20:
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.w == true) goto L9;
        int r6 = o.a(((Number) vm2.d.m4.getValue(null, vm2.d.a[270(0x10e, float:3.78E-43)])).intValue());
        if (r6 <= 0) goto L7;
        q1.a(this, new int[]{r6, r6, r6, r6});
    L7:
        this.w = true;
        return;
    }
}
