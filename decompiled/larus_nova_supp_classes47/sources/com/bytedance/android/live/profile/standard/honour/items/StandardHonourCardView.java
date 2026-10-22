package com.bytedance.android.live.profile.standard.honour.items;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import bt0.b;
import bt0.e;
import com.bytedance.android.live.base.model.user.HonorWallBg;
import com.bytedance.android.live.base.model.user.HonorWallContent;
import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileText;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.android.livesdk.common.LiveViewStub;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\rB'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/profile/standard/honour/items/StandardHonourCardView;", "Lbt0/e;", "Landroid/widget/FrameLayout;", "Lbt0/a;", "item", "Lcom/bytedance/android/live/base/model/user/HonorWallElement;", "elementInfo", "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "profileUser", "Lcom/bytedance/android/live/profile/ui/base/h;", "profileContext", "", "update", "a", "Lcom/bytedance/android/live/profile/ui/base/h;", "getProfileContext", "()Lcom/bytedance/android/live/profile/ui/base/h;", "setProfileContext", "(Lcom/bytedance/android/live/profile/ui/base/h;)V", "Lbt0/b;", "g", "Lbt0/b;", "getTitleViewHolder", "()Lbt0/b;", "setTitleViewHolder", "(Lbt0/b;)V", "titleViewHolder", "h", "getBusinessViewHolder", "setBusinessViewHolder", "businessViewHolder", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StandardHonourCardView extends FrameLayout implements e {
    public h a;
    public ViewGroup b;
    public HSImageView c;
    public LiveViewStub d;
    public LiveViewStub e;
    public View f;
    public b g;
    public b h;

    public static final class a {
    }

    static {
    }

    public StandardHonourCardView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StandardHonourCardView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // bt0.c
    public final void f() {
        this.g.f();
        this.h.f();
    }

    @Override // bt0.c
    public final void g() {
        this.g.g();
        this.h.g();
    }

    @Override // bt0.c
    public final void onViewShow() {
        this.g.onViewShow();
        this.h.onViewShow();
    }

    @Override // bt0.c
    public final void c() {
        LayoutInflater.from(getContext()).inflate(2131567189, this, true);
        this.b = (ViewGroup) findViewById(2131380851);
        this.c = findViewById(2131380818);
        this.d = findViewById(2131387184);
        this.e = findViewById(2131387182);
        this.f = findViewById(2131387183);
        LiveViewStub r0 = this.d;
        if (r0 == null) goto L5;
        this.g.p(r0);
    L5:
        LiveViewStub r1 = this.e;
        if (r1 == null) goto L9;
        this.h.p(r1);
        return;
    }

    public final b getBusinessViewHolder() {
        return this.h;
    }

    public h getProfileContext() {
        return this.a;
    }

    public final b getTitleViewHolder() {
        return this.g;
    }

    public final void r(HonorWallElement r6) {
        HonorWallContent r7 = r6.getHonorWallContent();
        if (r7 == null) goto L35;
        HonorWallBg r8 = r7.getHonorWallBg();
        if (r8 == null) goto L36;
        GradientDrawable r0 = new GradientDrawable();
        int r1 = 0;
        r0.setShape(0);
        r0.setGradientType(1);
        r0.setCornerRadius(UtilityKotlinExtentionsKt.h(4));
        r0.setGradientRadius(UtilityKotlinExtentionsKt.h(80));
        r0.setGradientCenter(0.0f, 0.0f);
    L16:
        e = move-exception;
        ALogger.e("StandardHonourCardView", "parse background error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
    L18:
        HSImageView r2 = this.c;
        if (r2 == null) goto L25;
        k r3 = r8.getIcon();
        if (r3 == null) goto L23;
        int r4 = UtilityKotlinExtentionsKt.i(r3.getWidth());
    L24:
        a1.p(r2, r4);
        goto L25
    L23:
        r4 = 0;
    L25:
        HSImageView r5 = this.c;
        if (r5 == null) goto L31;
        k r9 = r8.getIcon();
        if (r9 == null) goto L30;
        r1 = UtilityKotlinExtentionsKt.i(r9.getHeight());
    L30:
        a1.k(r5, r1);
    L31:
        ImageLoader.bindImage(this.c, r8.getIcon());
        return;
    L9:
        if (TextUtils.isEmpty(r8.getColorStart()) == true) goto L18;
        if (TextUtils.isEmpty(r8.getColorEnd()) == true) goto L18;
        r0.setColors(new int[]{Color.parseColor(r8.getColorStart()), Color.parseColor(r8.getColorEnd())});     // Catch: Exception -> L16
        ViewGroup r10 = this.b;     // Catch: Exception -> L16
        if (r10 == null) goto L18;
        r10.setBackground(r0);     // Catch: Exception -> L16
        goto L18
    L36:
        return;
    }

    public final void setBusinessViewHolder(b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    @Override // com.bytedance.android.live.profile.profilecontext.c
    public void setProfileContext(h r1) {
        this.a = r1;
    }

    public final void setTitleViewHolder(b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    @Override // bt0.e
    public final void q(b r1, b r2) {
        if (r1 == null) goto L4;
        this.g = r1;
    L4:
        if (r2 == null) goto L7;
        this.h = r2;
        return;
    }

    public StandardHonourCardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.g = new ct0.b();
        this.h = new ct0.b();
    }

    public /* synthetic */ StandardHonourCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // bt0.c
    public final void l(bt0.a r3, HonorWallElement r4, NewProfileUser r5, h r6) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "elementInfo");
        Intrinsics.checkNotNullParameter(r5, "profileUser");
        Intrinsics.checkNotNullParameter(r6, "profileContext");
        if (r3.n(r4, r5, r6) == false) goto L7;
        View r7 = this.f;
        if (r7 == null) goto L10;
        r7.setVisibility(0);
    L10:
        r(r4);
        b r8 = this.g;
        HonorWallContent r0 = r4.getHonorWallContent();
        ProfileText r1 = null;
        if (r0 == null) goto L13;
        ProfileText r2 = r0.getHonorWallTopDisplay();
    L14:
        r8.h(r2, r4, r5, r6);
        b r9 = this.h;
        HonorWallContent r10 = r4.getHonorWallContent();
        if (r10 == null) goto L17;
        r1 = r10.getHonorWallBottomDisplay();
    L17:
        r9.h(r1, r4, r5, r6);
        return;
    L13:
        r2 = null;
        goto L14
    L7:
        View r12 = this.f;
        if (r12 == null) goto L10;
        r12.setVisibility(8);
        goto L10
    }

    @Override // bt0.e, bt0.c
    public void update(bt0.a r3, HonorWallElement r4, NewProfileUser r5, h r6) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "elementInfo");
        Intrinsics.checkNotNullParameter(r5, "profileUser");
        Intrinsics.checkNotNullParameter(r6, "profileContext");
        if (r3.n(r4, r5, r6) == false) goto L7;
        View r7 = this.f;
        if (r7 == null) goto L10;
        r7.setVisibility(0);
    L10:
        ViewGroup r8 = this.b;
        if (r8 == null) goto L13;
        r8.setBackgroundResource(2131252678);
    L13:
        HSImageView r9 = this.c;
        if (r9 == null) goto L16;
        a1.p(r9, -2);
    L16:
        HSImageView r10 = this.c;
        if (r10 == null) goto L19;
        a1.k(r10, -2);
    L19:
        HSImageView r12 = this.c;
        if (r12 == null) goto L22;
        m.b(r12);
    L22:
        r(r4);
        b r13 = this.g;
        HonorWallContent r0 = r4.getHonorWallContent();
        ProfileText r1 = null;
        if (r0 == null) goto L25;
        ProfileText r2 = r0.getHonorWallTopDisplay();
    L26:
        r13.update(r2, r4, r5, r6);
        b r14 = this.h;
        HonorWallContent r15 = r4.getHonorWallContent();
        if (r15 == null) goto L29;
        r1 = r15.getHonorWallBottomDisplay();
    L29:
        r14.update(r1, r4, r5, r6);
        return;
    L25:
        r2 = null;
        goto L26
    L7:
        View r16 = this.f;
        if (r16 == null) goto L10;
        r16.setVisibility(8);
        goto L10
    }
}
