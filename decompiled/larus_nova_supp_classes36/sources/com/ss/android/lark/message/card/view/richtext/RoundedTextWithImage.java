package com.ss.android.lark.message.card.view.richtext;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaNode;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class RoundedTextWithImage extends MsgCardRoundedYogaLayout {
    public MsgCardLinkEmojiTextView s;
    public YogaNode t;
    public MsgCardRoundedImageView u;
    public Drawable v;
    public YogaNode w;
    public int x;

    @Override // com.ss.android.lark.message.card.view.richtext.MsgCardRoundedYogaLayout
    public final void c() {
        this.u.setImageDrawable(this.v);
        RotateAnimation r0 = new RotateAnimation(0.0f, 360.0f, 0, this.w.getWidth().value / 2.0f, 0, this.w.getHeight().value / 2.0f);
        r0.setDuration(1000);
        r0.setFillAfter(true);
        r0.setInterpolator(new LinearInterpolator());
        r0.setRepeatMode(1);
        r0.setRepeatCount(-1);
        this.u.setAnimation(r0);
    }

    public String getText() {
        return this.s.getText().toString();
    }

    public RoundedTextWithImage(Context r2) {
        this(r2, null);
    }

    public void setImageDrawable(Drawable r2) {
        this.u.setImageDrawable(r2);
    }

    public void setImgHeight(int r2) {
        this.w.setHeight(r2);
    }

    public void setImgWidth(int r2) {
        this.w.setWidth(r2);
    }

    public void setTextHeight(int r2) {
        this.t.setHeight(r2);
    }

    public void setTextWidth(int r2) {
        this.t.setWidth(r2);
    }

    public void setZoomRule(x0 r10) {
        if (r10 == null) goto L12;
        LinkEmojiTextView r11 = this.s;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Context r0 = r11.getContext();
        ZoomLevel6 r1 = zz7.b.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        LarkFont[] r2 = LarkFont.values();
        int r3 = r2.length;
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L10;
        LarkFont r7 = r2[r5];
        if (r7.getNormal() == 14) goto L8;
        r5 = r5 + 1;
        goto L5
    L8:
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r7, "larkFont");
        float r4 = zz7.b.a(r0, zz7.b.c(r7));
    L11:
        r11.setTextSize(0, r4);
        return;
    L10:
        r4 = zz7.b.a(r0, zz7.b.e().getMultiplier() * 14);
        goto L11
    L12:
        this.s.setTextSize(2, 14.0f);
    }

    public RoundedTextWithImage(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    public final void d(String r3, Boolean r4) {
        this.s.setText(r3);
        int r5 = y9c.d.c(getContext(), 2131106610);
        int r0 = y9c.d.c(getContext(), 2131106620);
        if (r4.booleanValue() == false) goto L8;
        if (this.x == r5) goto L11;
        this.x = r5;
        this.s.setTextColor(r5);
        return;
    L11:
        return;
    L8:
        if (this.x == r0) goto L13;
        this.x = r0;
        this.s.setTextColor(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    public final void e(String r3, Boolean r4) {
        this.s.setText(r3);
        int r5 = y9c.d.c(getContext(), 2131106610);
        int r0 = y9c.d.c(getContext(), 2131106622);
        if (r4.booleanValue() == false) goto L8;
        if (this.x == r5) goto L11;
        this.x = r5;
        this.s.setTextColor(r5);
        return;
    L11:
        return;
    L8:
        if (this.x == r0) goto L13;
        this.x = r0;
        this.s.setTextColor(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, com.ss.android.lark.message.card.view.richtext.MsgCardLinkEmojiTextView] */
    /* JADX WARN: Type inference failed for: r3v11, types: [android.view.View, com.ss.android.lark.message.card.view.richtext.MsgCardRoundedImageView] */
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
    public RoundedTextWithImage(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        ?? r5 = new MsgCardLinkEmojiTextView(r2);
        this.s = r5;
        addView(r5);
        YogaNode r6 = getYogaNodeForView(this.s);
        this.t = r6;
        r6.setWidth(0.0f);
        this.t.setFlexGrow(1.0f);
        this.t.setMargin(YogaEdge.RIGHT, UIUtils.dp2px(r2, 12.0f));
        int r7 = y9c.d.c(r2, 2131106620);
        this.x = r7;
        this.s.setTextColor(r7);
        this.s.setEllipsize(TextUtils.TruncateAt.END);
        this.s.setSingleLine();
        this.s.setTextSize(2, 14.0f);
        ?? r8 = new MsgCardRoundedImageView(r2);
        this.u = r8;
        addView(r8);
        YogaNode r9 = getYogaNodeForView(this.u);
        this.w = r9;
        r9.setWidth(this.r);
        this.w.setHeight(this.r);
        this.v = UDIconUtils.getIconDrawable(r2, 2131255040, UDColorUtils.getColor(r2, 2131105548));
        YogaNode r10 = getYogaNode();
        r10.setFlexDirection(YogaFlexDirection.ROW);
        r10.setAlignItems(YogaAlign.CENTER);
        r10.setJustifyContent(YogaJustify.CENTER);
    }
}
