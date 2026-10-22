package com.larus.community.impl.detail.bottomtools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.community.impl.databinding.LarusCommunityCreationDetailBottomToolsLayoutV2Binding;
import com.larus.utils.j0;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import v19.r5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007JN\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u000b0\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rJ\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0003\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\"\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020%H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsViewV2;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationDetailBottomToolsLayoutV2Binding;", "bindAction", "", "likeAction", "Lkotlin/Function0;", "makeSameAction", "Lkotlin/Function1;", "", "shareAction", "commentAction", "setShareActionVisible", "visible", "", "iconRes", "", "setMakeSameActionVisible", "setMakeSameContent", "isCustomContent", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "ignoreDynamicInfo", "bindCreationLikeState", "likeState", "Lcom/larus/community/impl/detail/bottomtools/CreationLikeState;", "updateCommentCount", "commentCount", "", "createAnimatorSet", "Landroid/view/animation/AnimationSet;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailBottomToolsViewV2 extends ConstraintLayout {
    public static final /* synthetic */ int b = 0;
    public final LarusCommunityCreationDetailBottomToolsLayoutV2Binding a;

    public CreationDetailBottomToolsViewV2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(long r6) {
        TextView r0 = this.a.i;
        if (r6 > 0) goto L5;
        String r1 = getResources().getString(2131900336);
    L6:
        r0.setText(r1);
        ConstraintLayout r2 = this.a.b;
        if (r6 > 0) goto L9;
        int r7 = j0.a;
        String r8 = j0.d(2131898796);
    L10:
        r2.setContentDescription(r8);
        return;
    L9:
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        int r4 = j0.a;
        r8 = String.format(j0.d(2131898792), Arrays.copyOf(new Object[]{Long.valueOf(r6)}, 1));
        goto L10
    L5:
        int r5 = r5.a;
        r1 = r5.a(getContext(), r6);
        goto L6
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
    public CreationDetailBottomToolsViewV2(Context r13, AttributeSet r14) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14);
        LayoutInflater.from(r13).inflate(2131561927, this);
        int r15 = 2131367328;
        ConstraintLayout r2 = ViewBindings.findChildViewById(this, 2131367328);
        if (r2 == null) goto L27;
        r15 = 2131368262;
        RoundConstraintLayout r3 = (RoundConstraintLayout) ViewBindings.findChildViewById(this, 2131368262);
        if (r3 == null) goto L27;
        r15 = 2131374668;
        if (ViewBindings.findChildViewById(this, 2131374668) == null) goto L27;
        r15 = 2131374698;
        AppCompatImageView r4 = ViewBindings.findChildViewById(this, 2131374698);
        if (r4 == null) goto L27;
        r15 = 2131374699;
        AppCompatImageView r5 = ViewBindings.findChildViewById(this, 2131374699);
        if (r5 == null) goto L27;
        r15 = 2131374712;
        AppCompatImageView r6 = ViewBindings.findChildViewById(this, 2131374712);
        if (r6 == null) goto L27;
        r15 = 2131377869;
        ConstraintLayout r7 = ViewBindings.findChildViewById(this, 2131377869);
        if (r7 == null) goto L27;
        r15 = 2131386070;
        RoundConstraintLayout r8 = (RoundConstraintLayout) ViewBindings.findChildViewById(this, 2131386070);
        if (r8 == null) goto L27;
        r15 = 2131390345;
        TextView r9 = (TextView) ViewBindings.findChildViewById(this, 2131390345);
        if (r9 == null) goto L27;
        r15 = 2131390863;
        TextView r10 = (TextView) ViewBindings.findChildViewById(this, 2131390863);
        if (r10 == null) goto L27;
        r15 = 2131390918;
        TextView r11 = (TextView) ViewBindings.findChildViewById(this, 2131390918);
        if (r11 == null) goto L27;
        this.a = new LarusCommunityCreationDetailBottomToolsLayoutV2Binding(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        setClickable(true);
        return;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r15)));
    }
}
