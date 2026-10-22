package com.bytedance.android.live.profile.standard.honour.items.standardv3;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.livesdk.common.LiveViewStub;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\rB'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/profile/standard/honour/items/standardv3/StandardHonourCardViewV3;", "Lbt0/e;", "Landroid/widget/FrameLayout;", "Lbt0/a;", "item", "Lcom/bytedance/android/live/base/model/user/HonorWallElement;", "elementInfo", "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "profileUser", "Lcom/bytedance/android/live/profile/ui/base/h;", "profileContext", "", "update", "a", "Lcom/bytedance/android/live/profile/ui/base/h;", "getProfileContext", "()Lcom/bytedance/android/live/profile/ui/base/h;", "setProfileContext", "(Lcom/bytedance/android/live/profile/ui/base/h;)V", "Lbt0/b;", "f", "Lbt0/b;", "getTitleViewHolder", "()Lbt0/b;", "setTitleViewHolder", "(Lbt0/b;)V", "titleViewHolder", "g", "getBusinessViewHolder", "setBusinessViewHolder", "businessViewHolder", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StandardHonourCardViewV3 extends FrameLayout implements e {
    public h a;
    public ViewGroup b;
    public HSImageView c;
    public LiveViewStub d;
    public LiveViewStub e;
    public b f;
    public b g;

    public static final class a {
    }

    static {
    }

    public StandardHonourCardViewV3(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StandardHonourCardViewV3(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // bt0.c
    public final void f() {
        this.f.f();
        this.g.f();
    }

    @Override // bt0.c
    public final void g() {
        this.f.g();
        this.g.g();
    }

    @Override // bt0.c
    public final void onViewShow() {
        this.f.onViewShow();
        this.g.onViewShow();
    }

    @Override // bt0.c
    public final void c() {
        if (ProfilePreInflateUtil.a() == false) goto L5;
        ProfilePreInflateUtil.c(ProfilePreInflateViewInfo.TTLIVE_PROFILE_HONOUR_CARD_NEW, getContext(), LayoutInflater.from(getContext()), this, true);
    L6:
        this.b = (ViewGroup) findViewById(2131380851);
        this.c = findViewById(2131380818);
        this.d = findViewById(2131387184);
        this.e = findViewById(2131387182);
        LiveViewStub r0 = this.d;
        if (r0 == null) goto L9;
        this.f.p(r0);
    L9:
        LiveViewStub r1 = this.e;
        if (r1 == null) goto L13;
        this.g.p(r1);
        return;
    L13:
        return;
    L5:
        LayoutInflater.from(getContext()).inflate(2131567190, this, true);
        goto L6
    }

    public final b getBusinessViewHolder() {
        return this.g;
    }

    public h getProfileContext() {
        return this.a;
    }

    public final b getTitleViewHolder() {
        return this.f;
    }

    public final void r(HonorWallElement r9) {
        HonorWallContent r10 = r9.getHonorWallContent();
        if (r10 == null) goto L71;
        HonorWallBg r12 = r10.getHonorWallBg();
        if (r12 == null) goto L72;
        GradientDrawable r0 = new GradientDrawable();
        int r1 = 0;
        r0.setShape(0);
        boolean r2 = true;
        r0.setGradientType(1);
        r0.setCornerRadius(UtilityKotlinExtentionsKt.h(8));
        r0.setGradientRadius(UtilityKotlinExtentionsKt.h(80));
        r0.setGradientCenter(0.0f, 0.0f);
        String r3 = r12.getColorStart();
        if (r3 != null) goto L10;
    L13:
        boolean r4 = true;
    L15:
        if (r4 == true) goto L29;
        String r5 = r12.getColorEnd();
        if (r5 != null) goto L19;
    L22:
        boolean r6 = true;
    L23:
        if (r6 == true) goto L29;
        r0.setColors(new int[]{Color.parseColor(r12.getColorStart()), Color.parseColor(r12.getColorEnd())});     // Catch: Exception -> L27
    L27:
        e = move-exception;
        ALogger.e("StandardHonourCardViewV3", "parse background color error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
        goto L29
    L19:
        if (r5.length() == 0) goto L22;
        r6 = false;
    L29:
        String r7 = r12.getBorderColor();
        if (r7 != null) goto L32;
    L35:
        if (r2 == false) goto L69;
    L41:
        ViewGroup r8 = this.b;
        if (r8 == null) goto L44;
        r8.setBackground(r0);
    L44:
        HSImageView r13 = this.c;
        if (r13 == null) goto L51;
        k r14 = r12.getIcon();
        if (r14 == null) goto L49;
        int r15 = UtilityKotlinExtentionsKt.i(r14.getWidth());
    L50:
        a1.p(r13, r15);
        goto L51
    L49:
        r15 = 0;
    L51:
        HSImageView r16 = this.c;
        if (r16 == null) goto L58;
        k r17 = r12.getIcon();
        if (r17 == null) goto L56;
        int r18 = UtilityKotlinExtentionsKt.i(r17.getHeight());
    L57:
        a1.k(r16, r18);
        goto L58
    L56:
        r18 = 0;
    L58:
        HSImageView r19 = this.c;
        k r20 = r12.getIcon();
        k r22 = r12.getIcon();
        if (r22 == null) goto L61;
        int r23 = UtilityKotlinExtentionsKt.i(r22.getWidth());
    L62:
        k r24 = r12.getIcon();
        if (r24 == null) goto L65;
        r1 = UtilityKotlinExtentionsKt.i(r24.getHeight());
    L65:
        ImageLoader.bindImage(r19, r20, r23, r1);
        return;
    L61:
        r23 = 0;
        goto L62
    L69:
        r0.setStroke((int) UtilityKotlinExtentionsKt.h(0.5f), Color.parseColor(r12.getBorderColor()));     // Catch: Exception -> L39
    L39:
        e = move-exception;
        ALogger.e("StandardHonourCardViewV3", "parse background border error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
        goto L41
    L32:
        if (r7.length() == 0) goto L35;
        r2 = false;
        goto L35
    L10:
        if (r3.length() == 0) goto L13;
        r4 = false;
        goto L15
    L72:
        return;
    }

    public final void setBusinessViewHolder(b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    @Override // com.bytedance.android.live.profile.profilecontext.c
    public void setProfileContext(h r1) {
        this.a = r1;
    }

    public final void setTitleViewHolder(b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    @Override // bt0.e
    public final void q(b r1, b r2) {
        if (r1 == null) goto L4;
        this.f = r1;
    L4:
        if (r2 == null) goto L7;
        this.g = r2;
        return;
    }

    public StandardHonourCardViewV3(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.f = new ct0.b();
        this.g = new ct0.b();
    }

    public /* synthetic */ StandardHonourCardViewV3(Context r1, AttributeSet r2, int r3, int r4) {
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
        r(r4);
        b r7 = this.f;
        HonorWallContent r0 = r4.getHonorWallContent();
        ProfileText r1 = null;
        if (r0 == null) goto L5;
        ProfileText r2 = r0.getHonorWallTopDisplay();
    L6:
        r7.h(r2, r4, r5, r6);
        b r8 = this.g;
        HonorWallContent r9 = r4.getHonorWallContent();
        if (r9 == null) goto L9;
        r1 = r9.getHonorWallBottomDisplay();
    L9:
        r8.h(r1, r4, r5, r6);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // bt0.e, bt0.c
    public void update(bt0.a r3, HonorWallElement r4, NewProfileUser r5, h r6) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "elementInfo");
        Intrinsics.checkNotNullParameter(r5, "profileUser");
        Intrinsics.checkNotNullParameter(r6, "profileContext");
        ViewGroup r7 = this.b;
        if (r7 == null) goto L5;
        r7.setBackgroundResource(2131252679);
    L5:
        HSImageView r8 = this.c;
        if (r8 == null) goto L8;
        a1.p(r8, -2);
    L8:
        HSImageView r9 = this.c;
        if (r9 == null) goto L11;
        a1.k(r9, -2);
    L11:
        HSImageView r10 = this.c;
        if (r10 == null) goto L14;
        m.b(r10);
    L14:
        r(r4);
        b r12 = this.f;
        HonorWallContent r0 = r4.getHonorWallContent();
        ProfileText r1 = null;
        if (r0 == null) goto L17;
        ProfileText r2 = r0.getHonorWallTopDisplay();
    L18:
        r12.update(r2, r4, r5, r6);
        b r13 = this.g;
        HonorWallContent r14 = r4.getHonorWallContent();
        if (r14 == null) goto L21;
        r1 = r14.getHonorWallBottomDisplay();
    L21:
        r13.update(r1, r4, r5, r6);
        return;
    L17:
        r2 = null;
        goto L18
    }
}
