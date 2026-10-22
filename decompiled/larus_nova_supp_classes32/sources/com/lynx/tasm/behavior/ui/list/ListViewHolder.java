package com.lynx.tasm.behavior.ui.list;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ListViewHolder extends RecyclerView.ViewHolder {
    public final b a;
    public long b;

    public interface a {
    }

    public static class b extends FrameLayout {
        public int a;
        public UIComponent b;
        public int c;
        public int d;
        public int e;
        public boolean f;
        public int g;
        public a h;
        public int i;

        public b(Context r2) {
            super(r2);
            this.a = 0;
            this.d = 400;
            this.e = -1;
            this.f = false;
            this.g = 0;
            this.i = 0;
        }

        @Override // android.view.View
        public final void setLayoutDirection(int r1) {
            this.i = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.FrameLayout, android.view.View
        public final void onMeasure(int r7, int r8) {
            if (this.a != 0) goto L17;
            int r9 = this.e;
            if (r9 > 0) goto L8;
            r9 = View.MeasureSpec.getSize(r7);
        L8:
            int r10 = this.d;
            if (this.f == false) goto L41;
            UIComponent r0 = this.b;
            if (r0 == null) goto L41;
            if (r0.getView() == 0) goto L41;
            if (((com.lynx.tasm.behavior.ui.view.a) this.b.getView()).isLayoutRequested() == false) goto L41;
            this.b.measureChildren();
        L41:
            setMeasuredDimension(r9, r10);
            int r11 = UIList.L0;
            return;
        L17:
            UIComponent r12 = this.b;
            if (r12 == null) goto L40;
            r12.measure();
            if (2 != this.a) goto L22;
            this.a = 3;
        L22:
            int r13 = this.b.getWidth() + this.b.getMarginLeft();
            r9 = this.b.getMarginRight() + r13;
            r10 = ((this.b.getHeight() + this.b.getMarginTop()) + this.b.getMarginBottom()) + this.g;
            a r1 = this.h;
            if (r1 == null) goto L41;
            String r2 = this.b.b;
            c r3 = (c) r1;
            r3.getClass();
            if (TextUtils.isEmpty(r2) == true) goto L41;
            HashMap<String, Integer> r4 = r3.a.u;
            if (r4 == null) goto L41;
            if (r4.containsKey(r2) == false) goto L41;
            int r5 = 0;
        L33:
            if (r5 >= r3.a.B.size()) goto L41;
            int r6 = r3.a.u.get(r2).intValue();
            if (ListProtector.get(r3.a.B, r5) == null) goto L39;
            if (((HashMap) ListProtector.get(r3.a.B, r5)).containsKey(Integer.valueOf(r6)) == false) goto L39;
            ((HashMap) ListProtector.get(r3.a.B, r5)).put(Integer.valueOf(r6), Integer.valueOf(r10));
        L39:
            r5 = r5 + 1;
            goto L33
        L40:
            r9 = getMeasuredWidth();
            r10 = getMeasuredHeight();
            goto L41
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v12, types: [android.view.View] */
        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
            int r13 = UIList.L0;
            UIComponent r14 = this.b;
            if (r14 == null) goto L17;
            r14.setTop(0);
            this.b.setLeft(0);
            this.b.layout();
            int r15 = this.b.getMarginLeft();
            int r1 = this.b.getMarginTop();
            int r2 = this.b.getWidth();
            int r3 = this.b.getHeight();
            if (this.i != 1) goto L7;
            int r4 = (r11 - r9) - r2;
        L8:
            ((com.lynx.tasm.behavior.ui.view.a) this.b.getView()).layout(r15 + r4, r1, (r15 + r2) + r4, r3 + r1);
            if (this.b.getOverflow() != 0) goto L11;
        L13:
            Rect r16 = ViewCompat.getClipBounds(this.b.getView());
            if (r16 == null) goto L18;
            r16.set(Math.min(r16.left, r9), Math.min(r16.top, r10), Math.max(r16.right, r11), Math.max(r16.bottom, r12));
            ViewCompat.setClipBounds(this, r16);
            return;
        L18:
            return;
        L11:
            if (getParent() == null) goto L13;
            ((ViewGroup) getParent()).setClipChildren(false);
            goto L13
        L7:
            r4 = 0;
            goto L8
        }
    }

    public final void T3() {
        b r0 = this.a;
        UIComponent r1 = r0.b;
        if (r1 == null) goto L13;
        String r2 = r1.b;
        r0.removeAllViews();     // Catch: NullPointerException -> L7
    L9:
        this.a.b = null;
        return;
    L7:
        e = move-exception;
        LLog.e("UIList", "ListViewHolder removeUIComponent.the itemKey is " + r2 + " errorMessage:" + e.getMessage());
        goto L9
    }

    public ListViewHolder(b r3) {
        super(r3);
        this.b = 0;
        this.a = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void U3(UIComponent r4) {
        this.a.b = r4;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
        this.a.addView(r4.getView(), r0);
        b r5 = this.a;
        r5.c = getAdapterPosition();
    }
}
