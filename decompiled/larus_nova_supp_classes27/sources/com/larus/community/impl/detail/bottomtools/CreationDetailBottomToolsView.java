package com.larus.community.impl.detail.bottomtools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.community.impl.databinding.LarusCommunityCreationDetailBottomToolsLayoutBinding;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.utils.e1;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.r5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J<\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u000b0\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rJ\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0003\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0014J\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationDetailBottomToolsLayoutBinding;", "bindAction", "", "likeAction", "Lkotlin/Function0;", "makeSameAction", "Lkotlin/Function1;", "", "shareAction", "setShareActionVisible", "visible", "", "iconRes", "", "setMakeSameActionVisible", "setMakeSameContent", "isCustomContent", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "ignoreDynamicInfo", "bindCreationLikeState", "likeState", "Lcom/larus/community/impl/detail/bottomtools/CreationLikeState;", "createAnimatorSet", "Landroid/view/animation/AnimationSet;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailBottomToolsView extends ConstraintLayout {
    public static final /* synthetic */ int b = 0;
    public final LarusCommunityCreationDetailBottomToolsLayoutBinding a;

    public CreationDetailBottomToolsView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(CreationLikeState r18) {
        Intrinsics.checkNotNullParameter(r18, "likeState");
        Animation r1 = this.a.e.getAnimation();
        if (r1 == null) goto L5;
        r1.cancel();
    L5:
        this.a.e.setAnimation(null);
        TextView r2 = this.a.h;
        if (((int) r18.getLikeCount()) != 0) goto L8;
        String r3 = getContext().getString(2131901208);
    L9:
        r2.setText(r3);
        AppCompatImageView r4 = this.a.e;
        if (r18.getLiked() == false) goto L12;
        int r5 = 2131240151;
    L13:
        r4.setImageResource(r5);
        if (r18.getLiked() == true) goto L16;
        return;
    L16:
        if (Intrinsics.areEqual(r18.getShowAnimation(), Boolean.TRUE) == false) goto L20;
        AppCompatImageView r6 = this.a.e;
        AnimationSet r7 = new AnimationSet(false);
        ScaleAnimation r8 = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        r8.setDuration(250);
        r8.setStartOffset(0);
        r8.setInterpolator(new DecelerateInterpolator());
        r8.setFillAfter(true);
        ScaleAnimation r15 = new ScaleAnimation(1.0f, 0.8333f, 1.0f, 0.8333f, 1, 0.5f, 1, 0.5f);
        r15.setDuration(100);
        r15.setStartOffset(250);
        r15.setInterpolator(new DecelerateInterpolator());
        r15.setFillAfter(true);
        r7.setFillAfter(true);
        r7.addAnimation(r8);
        r7.addAnimation(r15);
        r7.setAnimationListener(new s());
        r6.startAnimation(r7);
        return;
    L20:
        return;
    L12:
        r5 = 2131241490;
        goto L13
    L8:
        int r9 = r5.a;
        r3 = r5.a(getContext(), r18.getLikeCount());
        goto L9
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void setMakeSameActionVisible(boolean r2) {
        ConstraintLayout r0 = this.a.c;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationDetailBottomToolsView(Context r11, AttributeSet r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12);
        LayoutInflater.from(r11).inflate(2131561926, this);
        int r13 = 2131368260;
        RoundConstraintLayout r2 = (RoundConstraintLayout) ViewBindings.findChildViewById(this, 2131368260);
        if (r2 == null) goto L21;
        r13 = 2131368262;
        RoundConstraintLayout r3 = (RoundConstraintLayout) ViewBindings.findChildViewById(this, 2131368262);
        if (r3 == null) goto L21;
        r13 = 2131368270;
        RoundConstraintLayout r4 = (RoundConstraintLayout) ViewBindings.findChildViewById(this, 2131368270);
        if (r4 == null) goto L21;
        r13 = 2131374698;
        AppCompatImageView r5 = ViewBindings.findChildViewById(this, 2131374698);
        if (r5 == null) goto L21;
        r13 = 2131374699;
        AppCompatImageView r6 = ViewBindings.findChildViewById(this, 2131374699);
        if (r6 == null) goto L21;
        r13 = 2131374712;
        AppCompatImageView r7 = ViewBindings.findChildViewById(this, 2131374712);
        if (r7 == null) goto L21;
        r13 = 2131390863;
        TextView r8 = (TextView) ViewBindings.findChildViewById(this, 2131390863);
        if (r8 == null) goto L21;
        r13 = 2131390918;
        TextView r9 = (TextView) ViewBindings.findChildViewById(this, 2131390918);
        if (r9 == null) goto L21;
        this.a = new LarusCommunityCreationDetailBottomToolsLayoutBinding(this, r2, r3, r4, r5, r6, r7, r8, r9);
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r13)));
    }

    public final void R5(final Function0<Unit> r3, final Function1<? super String, Unit> r4, final Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "likeAction");
        Intrinsics.checkNotNullParameter(r4, "makeSameAction");
        e1.d(this.a.b, new p(r3));
        e1.d(this.a.d, new q(r5));
        e1.d(this.a.c, new r(r4));
    }

    public final void T5(boolean r2, UserCreation r3, boolean r4) {
        if (r2 == false) goto L4;
        this.a.i.setText(2131901253);
        this.a.f.setImageResource(2131243413);
        return;
    L4:
        String r5 = null;
        if (r4 == true) goto L20;
        if (r3 == null) goto L10;
        CreationDynamicInfo r6 = r3.h;
        if (r6 == null) goto L10;
        String r7 = r6.c;
    L12:
        if (o0.d(r7) == false) goto L20;
        TextView r8 = this.a.i;
        if (r3 == null) goto L18;
        CreationDynamicInfo r0 = r3.h;
        if (r0 == null) goto L18;
        String r1 = r0.c;
    L19:
        r8.setText(r1);
    L21:
        if (r3 == null) goto L28;
        CreationDynamicInfo r9 = r3.h;
        if (r9 == null) goto L28;
        TplInfo r10 = r9.e;
        if (r10 == null) goto L28;
        r5 = r10.a;
    L28:
        if (Intrinsics.areEqual(r5, "ai_replica") == false) goto L30;
        int r11 = 2131242259;
    L31:
        this.a.f.setImageResource(r11);
        return;
    L30:
        r11 = 2131240155;
    L18:
        r1 = null;
    L10:
        r7 = null;
    L20:
        this.a.i.setText(2131901659);
        goto L21
    }
}
