package com.larus.profile.impl.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.profile.AvatarInfo;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.IFlowProfileThemeConfigProvider;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.e2;
import com.larus.profile.impl.databinding.LarusItemProfileInfoHeaderBinding;
import com.larus.settings.value.e10;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0014\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014J\u0014\u0010\u0015\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0014J\u0014\u0010\u0017\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0014J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001bH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/profile/impl/view/ProfileHeaderUserInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/profile/impl/databinding/LarusItemProfileInfoHeaderBinding;", "bindData", "", "userInfo", "Lcom/larus/account/base/model/profile/UserInfo;", "botsCount", "refreshTagsByUserType", "setAvatarClick", "avatarClick", "Lkotlin/Function0;", "setEditClick", "editClick", "setQrCodeClick", "qrCodeClick", "adaptForPad", "configuration", "Landroid/content/res/Configuration;", "onConfigurationChanged", "newConfig", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileHeaderUserInfoView extends ConstraintLayout {
    public static final /* synthetic */ int b = 0;
    public final LarusItemProfileInfoHeaderBinding a;

    public static final class a {
    }

    static {
    }

    public ProfileHeaderUserInfoView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileHeaderUserInfoView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void R5(Configuration r4) {
        if (e2.a.isPad() == false) goto L13;
        SimpleDraweeView r0 = this.a.d;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L12;
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) r1;
        if (r4.orientation != 2) goto L9;
        int r5 = i5.e();
    L10:
        ((ViewGroup.MarginLayoutParams) r2).width = r5;
        ((ViewGroup.MarginLayoutParams) r2).height = r5;
        r0.setLayoutParams(r2);
        return;
    L9:
        r5 = i5.r();
        goto L10
    L12:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onConfigurationChanged(Configuration r4) {
        Intrinsics.checkNotNullParameter(r4, "newConfig");
        super/*android.view.ViewGroup*/.onConfigurationChanged(r4);
        e2 r0 = e2.a;
        Context r1 = getContext();
        if ((r1 instanceof Activity) == false) goto L5;
        Activity r2 = (Activity) r1;
    L7:
        if (r0.a(r2, r4) == false) goto L10;
        R5(r4);
        return;
    L10:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void setAvatarClick(final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "avatarClick");
        e1.d(this.a.d, new j(r3));
    }

    public final void setEditClick(final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "editClick");
        e1.d(this.a.b, new k(r3));
    }

    public final void setQrCodeClick(final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "qrCodeClick");
        e1.d(this.a.c, new l(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v9, types: [com.larus.profile.impl.view.n] */
    /* JADX WARN: Type inference failed for: r7v15, types: [com.larus.profile.impl.view.o] */
    public final void S5(final r38.b r11, int r12) {
        final LarusItemProfileInfoHeaderBinding r0 = this.a;
        String r1 = null;
        if (r11 == null) goto L5;
        String r2 = r11.f();
    L6:
        boolean r3 = Intrinsics.areEqual(r2, ILoginService.a.getAccountInfo().c);
        AppCompatTextView r4 = r0.f;
        if (r11 == null) goto L9;
        String r5 = r11.d();
    L10:
        r4.setText(r5);
        e10 r6 = e10.a;
        int r7 = 8;
        if (e10.h0().a() == false) goto L14;
        if (r3 == false) goto L14;
        r0.g.setVisibility(0);
        e1.d(r0.h, new m(this));
    L15:
        ?? r8 = new n(r0, r11, this);
        if (r3 == false) goto L20;
        IFlowProfileThemeConfigProvider r9 = (IFlowProfileThemeConfigProvider) ServiceManager.get().getService(IFlowProfileThemeConfigProvider.class);
        if (r9 == 0) goto L21;
        r9.c(r8, new o(r0), AdaptThemeFeatureKey.PROFILE_DOUBAO_NAME);
    L21:
        LarusItemProfileInfoHeaderBinding r10 = this.a;
        boolean r13 = true;
        if (r10 == null) goto L44;
        if (r11 == null) goto L30;
        Integer r14 = r11.h();
        if (r14 == null) goto L30;
        if (r14.intValue() != 2) goto L30;
        boolean r15 = true;
    L31:
        if (r15 == true) goto L43;
        if (r11 == null) goto L39;
        Integer r16 = r11.h();
        if (r16 == null) goto L39;
        if (r16.intValue() != 3) goto L39;
        boolean r17 = true;
    L40:
        if (r17 == true) goto L43;
        r10.i.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        r10.i.setCompoundDrawablePadding(0);
    L39:
        r17 = false;
    L43:
        r10.i.setCompoundDrawablesWithIntrinsicBounds(null, null, AppCompatResources.getDrawable(getContext(), 2131241774), null);
        r10.i.setCompoundDrawablePadding(i5.z());
    L30:
        r15 = false;
    L44:
        SimpleDraweeView r18 = r0.d;
        if (r11 == null) goto L49;
        AvatarInfo r19 = r11.a();
        if (r19 == null) goto L49;
        r1 = r19.a();
    L49:
        ImageLoaderKt.y(r18, r1, "settings_itg.user", new p(), 4);
        if (r12 <= 0) goto L52;
        r0.e.setVisibility(8);
        AppCompatTextView r110 = r0.e;
        StringCompanionObject r20 = StringCompanionObject.INSTANCE;
        r110.setText(String.format(getContext().getString(2131908226), Arrays.copyOf(new Object[]{String.valueOf(r12)}, 1)));
    L53:
        TextView r111 = r0.b;
        if (r3 == false) goto L56;
        int r112 = 0;
    L57:
        r111.setVisibility(r112);
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.e() == false) goto L63;
        if (r3 == false) goto L63;
        if (AppHost.a.isOversea() == true) goto L63;
    L64:
        ImageView r113 = r0.c;
        if (r13 == false) goto L67;
        r7 = 0;
    L67:
        r113.setVisibility(r7);
        IFlowProfileThemeConfigProvider r114 = (IFlowProfileThemeConfigProvider) ServiceManager.get().getService(IFlowProfileThemeConfigProvider.class);
        if (r114 == null) goto L70;
        r114.b(r0.b, AdaptThemeFeatureKey.PROFILE_EDIT_INFO);
    L70:
        R5(getResources().getConfiguration());
        return;
    L63:
        r13 = false;
        goto L64
    L56:
        r112 = 8;
        goto L57
    L52:
        r0.e.setVisibility(8);
        goto L53
    L20:
        r8.invoke();
    L14:
        r0.g.setVisibility(8);
        r0.h.setClickable(false);
        goto L15
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProfileHeaderUserInfoView(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        LayoutInflater.from(r11).inflate(2131562621, this);
        int r14 = 2131371432;
        TextView r2 = (TextView) ViewBindings.findChildViewById(this, 2131371432);
        if (r2 == null) goto L23;
        r14 = 2131380572;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(this, 2131380572);
        if (r3 == null) goto L23;
        r14 = 2131383228;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(this, 2131383228);
        if (r4 == null) goto L23;
        r14 = 2131383229;
        AppCompatTextView r5 = ViewBindings.findChildViewById(this, 2131383229);
        if (r5 == null) goto L23;
        r14 = 2131383236;
        AppCompatTextView r6 = ViewBindings.findChildViewById(this, 2131383236);
        if (r6 == null) goto L23;
        r14 = 2131383237;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(this, 2131383237);
        if (r7 == null) goto L23;
        r14 = 2131383238;
        ConstraintLayout r8 = ViewBindings.findChildViewById(this, 2131383238);
        if (r8 == null) goto L23;
        r14 = 2131383248;
        AppCompatTextView r9 = ViewBindings.findChildViewById(this, 2131383248);
        if (r9 == null) goto L23;
        r14 = 2131383275;
        if (((LinearLayout) ViewBindings.findChildViewById(this, 2131383275)) == null) goto L23;
        this.a = new LarusItemProfileInfoHeaderBinding(this, r2, r3, r4, r5, r6, r7, r8, r9);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r14)));
    }

    public /* synthetic */ ProfileHeaderUserInfoView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
