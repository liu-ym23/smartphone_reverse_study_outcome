package com.ss.android.lark.reaction.widget.flowlayout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.ee.bear.middleground.comment.extension.addins.i;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.reaction.widget.flowlayout.reaction.ReactionTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ReactionFlowLayout extends FrameLayout {
    public Drawable a;
    public final c b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public ReactionTextView g;
    public int h;
    public boolean i;
    public f j;
    public a k;
    public b l;
    public int m;
    public int n;
    public int o;
    public int[] p;
    public int q;
    public Align r;

    public static final enum Align extends Enum<Align> {
        public static final Align LEFT = null;
        public static final Align RIGHT = null;
        public static final /* synthetic */ Align[] a = null;

        static {
            Align r0 = new Align("LEFT", 0);
            LEFT = r0;
            Align r1 = new Align("RIGHT", 1);
            RIGHT = r1;
            a = new Align[]{r0, r1};
        }

        public static Align[] values() {
            return (Align[]) a.clone();
        }

        public static Align valueOf(String r1) {
            return (Align) r27.a.a(Align.class, r1);
        }

        public Align(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void a(String r1);
    }

    public interface b {
        void a(String r1);
    }

    public static class c {
        public float a;
        public int b;

        public c() {
            this.a = 12.0f;
            this.b = 2131106607;
            TextUtils.TruncateAt r0 = TextUtils.TruncateAt.END;
        }
    }

    public class d {
        public long a;
        public final /* synthetic */ ReactionFlowLayout b;

        public d(ReactionFlowLayout r1) {
            this.b = r1;
        }
    }

    public interface e {
        void a();
    }

    public interface f {
        void a(String r1);
    }

    public void setNewReactionEnable(boolean r1) {
    }

    public void setReactionTopMargin(int r1) {
    }

    public f getReactionClickListener() {
        return this.j;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public ReactionFlowLayout(Context r2) {
        super(r2);
        this.b = new c();
        this.c = false;
        this.h = Integer.MAX_VALUE;
        this.i = true;
        this.m = Integer.MIN_VALUE;
        this.n = -1;
        this.o = -1;
        this.q = -1;
        this.r = Align.LEFT;
        this.a = v2c.a.c(getContext(), 2131232425);
    }

    public void setAlign(Align r1) {
        this.r = r1;
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
    public void setChildXOffset(int r3) {
        AppCompatTextView r0 = this.g;
        if (r0 == null) goto L5;
        r0.setTranslationX(r3);
    L5:
        this.d = r3;
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
    public void setChildYOffset(int r3) {
        AppCompatTextView r0 = this.g;
        if (r0 == null) goto L5;
        r0.setTranslationY(r3);
    L5:
        this.e = r3;
    }

    public void setDisplayChangeEnable(boolean r1) {
        this.c = r1;
    }

    public void setDivideLineColor(int r1) {
        this.m = r1;
    }

    public void setExtendIconTint(int r2) {
        ReactionTextView r0 = this.g;
        if (r0 == null) goto L6;
        r0.setExtendIconTint(r2);
        return;
    }

    public void setExtraLineHeight(int r1) {
        this.o = r1;
    }

    public void setMaxNameCount(int r1) {
        this.h = r1;
    }

    public void setOnReactionMoreTrigger(b r1) {
        this.l = r1;
    }

    public void setOnReactionNameTrigger(a r1) {
        this.k = r1;
    }

    public void setReactionClickListener(f r1) {
        this.j = r1;
    }

    public void setReactionLeftMargin(int r1) {
        this.q = r1;
    }

    public void setReactionMaxWidth(int r1) {
        this.f = r1;
    }

    public void setReactionPaddings(int[] r1) {
        this.p = r1;
    }

    public void setReactionResourceLoader(com.ss.android.lark.reaction.widget.flowlayout.reaction.e r2) {
        ReactionTextView r0 = this.g;
        if (r0 == null) goto L6;
        r0.setReactionResourceLoader(r2);
        return;
    }

    public void setReactionTextSize(int r2) {
        this.b.a = r2;
    }

    public void setSeparatorWidth(int r1) {
        this.n = r1;
    }

    public void setTagBackground(Drawable r1) {
        this.a = r1;
    }

    public void setTagBackgroundColor(int r4) {
        Context r0 = getContext();
        Drawable r1 = v2c.a.c(r0, 2131232425);
        if (r4 != 0) goto L6;
    L8:
        int r5 = 2131109078;
    L9:
        ((GradientDrawable) r1).setColor(UDColorUtils.getColor(r0, r5));
        this.a = r1;
        return;
    L6:
        if (r4 != 1) goto L8;
        r5 = 2131109079;
        goto L9
    }

    public void setTapAnimationEnabled(boolean r1) {
        this.i = r1;
    }

    public void setTextColor(int r2) {
        this.b.b = r2;
    }

    public void setup(List<q2c.c> r2) {
        a(r2, false);
    }

    public ReactionFlowLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.b = new c();
        this.c = false;
        this.h = Integer.MAX_VALUE;
        this.i = true;
        this.m = Integer.MIN_VALUE;
        this.n = -1;
        this.o = -1;
        this.q = -1;
        this.r = Align.LEFT;
        this.a = v2c.a.c(getContext(), 2131232425);
    }

    public final void a(List<q2c.c> r3, boolean r4) {
        b(r3, r4, -1, null);
    }

    public ReactionFlowLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = new c();
        this.c = false;
        this.h = Integer.MAX_VALUE;
        this.i = true;
        this.m = Integer.MIN_VALUE;
        this.n = -1;
        this.o = -1;
        this.q = -1;
        this.r = Align.LEFT;
        this.a = v2c.a.c(getContext(), 2131232425);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [android.view.View, com.ss.android.lark.reaction.widget.flowlayout.reaction.ReactionTextView] */
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
    public final void b(List r11, boolean r12, int r13, i r14) {
        if (r11 == null) goto L10;
        ArrayList r1 = new ArrayList(r11.size());
        Iterator r15 = r11.iterator();
    L6:
        if (r15.hasNext() == false) goto L12;
        q2c.c r2 = (q2c.c) r15.next();
        if (qsb.b.a().i7(r2.a) == true) goto L6;
        r1.add(r2);
    L12:
        if (r1 != null) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == true) goto L26;
        AppCompatTextView r16 = this.g;
        if (r16 != null) goto L22;
        return;
    L22:
        if (r16.getParent() == null) goto L24;
        ((ViewGroup) this.g.getParent()).removeView(this.g);
    L24:
        this.g = null;
        return;
    L26:
        AppCompatTextView r0 = this.g;
        if (r0 != null) goto L29;
        ?? r4 = new ReactionTextView(getContext());
        this.g = r4;
        addView(r4);
    L30:
        int[] r5 = this.p;
        if (r5 == null) goto L40;
        int r6 = r5.length;
        int r7 = 0;
    L34:
        if (r7 >= r6) goto L40;
        int r8 = r5[r7];
        if (r8 == 0) goto L39;
        if (r8 == (-1)) goto L39;
        boolean r9 = true;
    L42:
        if (r9 == false) goto L44;
        AppCompatTextView r10 = this.g;
        int[] r17 = this.p;
        r10.setPadding(r17[0], r17[1], r17[2], r17[3]);
    L44:
        ReactionTextView r18 = this.g;
        int r19 = this.f;
        if (r19 != 0) goto L47;
        r19 = v2c.a.a(getContext(), 315.0f);
    L47:
        r18.setMaxWidth(r19);
        if (this.c == false) goto L50;
        this.g.setTextSize(2, zz7.b.d().getMultiplier() * this.b.a);
    L51:
        this.g.setTextColor(v2c.a.b(getContext(), this.b.b));
        if (this.r != Align.RIGHT) goto L54;
        int r20 = 8388613;
    L55:
        this.g.setGravity(r20);
        FrameLayout.LayoutParams r21 = new FrameLayout.LayoutParams(-2, -2);
        int r22 = this.q;
        if (r22 == (-1)) goto L58;
        r21.leftMargin = r22;
    L58:
        int r23 = this.m;
        if (r23 == Integer.MIN_VALUE) goto L61;
        this.g.setDividerColor(r23);
    L61:
        int r24 = this.n;
        if (r24 <= 0) goto L64;
        this.g.setSeparatorWidth(r24);
    L64:
        int r25 = this.o;
        if (r25 <= 0) goto L67;
        this.g.setExtraLineHeight(r25);
    L67:
        this.g.setLineBackground(this.a);
        this.g.setTranslationX(this.d);
        this.g.setTranslationY(this.e);
        this.g.setReactionClickListener(new p2c.a(this));
        this.g.setOnContributorClickNew(new d(this));
        this.g.setLayoutParams(r21);
        this.g.setShownNamesNumberLimit(this.h);
        this.g.setEnableLongClick(r12);
        this.g.setOnlyShowCount(false);
        this.g.setTapAnimationEnabled(this.i);
        if (r13 == 0) goto L77;
        if (r14 == null) goto L77;
        Drawable r110 = v2c.a.c(getContext(), r13);
        if (r110 == null) goto L77;
        if (r110.getIntrinsicWidth() <= 0) goto L77;
        if (r110.getIntrinsicHeight() <= 0) goto L77;
        ReactionTextView r111 = this.g;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r110, "extendIconDrawable");
        Intrinsics.checkNotNullParameter(r14, "extendIconClickListener");
        r111.e = r110;
        r111.h = r14;
        r111.f = true;
    L77:
        this.g.setReactionData(r1);
        return;
    L54:
        r20 = 8388611;
        goto L55
    L50:
        this.g.setTextSize(2, this.b.a);
    L39:
        r7 = r7 + 1;
    L40:
        r9 = false;
        goto L42
    L29:
        r0.setVisibility(0);
        goto L30
    L14:
        if (r1.size() == 0) goto L16;
        r3 = true;
        goto L17
    L10:
        r1 = null;
        goto L12
    }
}
