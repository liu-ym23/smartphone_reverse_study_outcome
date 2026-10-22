package com.lynx.xelement.markdown;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.utils.h;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import p8a.a;
import p8a.c;
import p8a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIMarkdown extends UIGroup<c> {
    public d a;

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        c r0 = (c) this.mView;
        r0.b = null;
        r0.a.destroy();
    }

    public final boolean M(Callback r4) {
        if (this.a != null) goto L6;
        r4.invoke(new Object[]{6});
        return false;
    L6:
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r2) {
        return new c(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateExtraData(Object r2) {
        super.updateExtraData(r2);
        if ((r2 instanceof a) == false) goto L6;
        a r3 = (a) r2;
        this.a = r3.a;
        ((c) this.mView).setBundle(r3);
        return;
    }

    public LynxUIMarkdown(LynxContext r1, Object r2) {
        super(r1, r2);
    }

    public final JavaOnlyMap N(ArrayList<RectF> r5, RectF r6) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        if (r5.isEmpty() == false) goto L5;
        return r0;
    L5:
        RectF r1 = new RectF((RectF) ListProtector.get(r5, 0));
        int r2 = 1;
    L7:
        if (r2 >= r5.size()) goto L9;
        r1.union((RectF) ListProtector.get(r5, r2));
        r2 = r2 + 1;
        goto L7
    L9:
        r0.putMap("boundingRect", getMapFromRect(r6, r1));
        JavaOnlyArray r3 = new JavaOnlyArray();
        Iterator<RectF> r7 = r5.iterator();
    L11:
        if (r7.hasNext() == false) goto L13;
        r3.pushMap(getMapFromRect(r6, r7.next()));
        goto L11
    L13:
        r0.putArray("boxes", r3);
        return r0;
    }

    @LynxUIMethod
    public void clearStatus(ReadableMap r3, Callback r4) {
        if (M(r4) == true) goto L5;
        return;
    L5:
        r4.invoke(new Object[]{0});
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
    @LynxUIMethod
    public void getContent(ReadableMap r8, Callback r9) {
        if (M(r9) == true) goto L6;
        return;
    L6:
        if (r8 != null) goto L8;
    L12:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L20;
        int r3 = r8.getInt("start", 0);
        int r2 = r8.getInt("end", Integer.MAX_VALUE);
        if (r3 < r2) goto L19;
        r9.invoke(new Object[]{4, "start >= end"});
        return;
    L19:
        String r10 = this.a.getContent(r3, r2, "source".equals(r8.getString("indexType", NameKeys.UnloadStrategy_No_Strategy)) ? 1 : 0);
    L21:
        JavaOnlyMap r5 = new JavaOnlyMap();
        r5.put(LynxAccessibilityModule.MSG_CONTENT, r10);
        r9.invoke(new Object[]{0, r5});
        return;
    L20:
        r10 = this.a.getContent();
        goto L21
    L8:
        if (r8.hasKey("start") == false) goto L10;
    L11:
        r4 = true;
        goto L14
    L10:
        if (r8.hasKey("end") == false) goto L12;
        goto L11
    }

    @LynxUIMethod
    public void getImages(ReadableMap r6, Callback r7) {
        if (M(r7) == true) goto L5;
        return;
    L5:
        String[] r8 = this.a.getAllImageUrl();
        JavaOnlyArray r0 = new JavaOnlyArray();
        int r1 = r8.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L8;
        r0.pushString(r8[r3]);
        r3 = r3 + 1;
        goto L6
    L8:
        JavaOnlyMap r9 = new JavaOnlyMap();
        r9.put("images", r0);
        r7.invoke(new Object[]{0, r9});
    }

    public final JavaOnlyMap getMapFromRect(RectF r6, RectF r7) {
        if (r6 != null) goto L4;
        r6 = new RectF();
    L4:
        JavaOnlyMap r0 = new JavaOnlyMap();
        float r1 = getLynxContext().getScreenMetrics().density;
        r0.putDouble("left", (((r6.left + getPaddingLeft()) + getBorderLeftWidth()) + r7.left) / r1);
        r0.putDouble("top", (((r6.top + getPaddingTop()) + getBorderTopWidth()) + r7.top) / r1);
        r0.putDouble("right", (((r6.left + getPaddingLeft()) + getBorderLeftWidth()) + r7.right) / r1);
        r0.putDouble("bottom", (((r6.top + getPaddingTop()) + getBorderTopWidth()) + r7.bottom) / r1);
        r0.putDouble("width", r7.width() / r1);
        r0.putDouble("height", r7.height() / r1);
        return r0;
    }

    @LynxUIMethod
    public void getParseResult(ReadableMap r18, Callback r19) {
        if (M(r19) == true) goto L5;
        return;
    L5:
        ReadableArray r3 = null;
        if (r18 == null) goto L10;
        r3 = r18.getArray("tags", null);
    L10:
        if (r3 != null) goto L12;
    L32:
        r19.invoke(new Object[]{4, "param invalid: no tags"});
        return;
    L12:
        if (r3.size() == 0) goto L32;
        JavaOnlyMap r6 = new JavaOnlyMap();
        r6.put("id", this.a.getContentID());
        JavaOnlyMap r7 = new JavaOnlyMap();
        int r8 = 0;
    L16:
        if (r8 >= r3.size()) goto L30;
        String r9 = r3.getString(r8);
        if (r9 == null) goto L29;
        long[] r10 = this.a.getSyntaxSourceRanges(r9);
        if (r10 == null) goto L29;
        if (r10.length == 0) goto L29;
        JavaOnlyArray r11 = new JavaOnlyArray();
        int r12 = r10.length;
        int r13 = 0;
    L26:
        if (r13 >= r12) goto L28;
        long r14 = r10[r13];
        JavaOnlyMap r5 = new JavaOnlyMap();
        r5.put("start", Integer.valueOf((int) (r14 >>> 32)));
        r5.put("end", Integer.valueOf((int) (4294967295L & r14)));
        r11.pushMap(r5);
        r13 = r13 + 1;
        goto L26
    L28:
        r7.put(r9, r11);
    L29:
        r8 = r8 + 1;
        goto L16
    L30:
        r6.put("result", r7);
        r19.invoke(new Object[]{0, r6});
    }

    @LynxUIMethod
    public void getSelectedText(ReadableMap r4, Callback r5) {
        if (M(r5) == true) goto L5;
        return;
    L5:
        JavaOnlyMap r6 = new JavaOnlyMap();
        r6.put("selectedText", this.a.getSelectedText());
        r5.invoke(new Object[]{0, r6});
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
    @LynxUIMethod
    public void getTextBoundingRect(ReadableMap r9, Callback r10) {
        if (M(r10) == true) goto L6;
        return;
    L6:
        if (r9 != null) goto L9;
        r10.invoke(new Object[]{4, "parameter is invalid"});
        return;
    L9:
        int r5 = r9.getInt("start", -1);
        int r6 = r9.getInt("end", -1);
        if (r5 < 0) goto L20;
        if (r6 < 0) goto L20;
        if (r5 > r6) goto L20;
        ArrayList<RectF> r0 = this.a.getTextBoundingRect(r5, r6, "source".equals(r9.getString("indexType", NameKeys.UnloadStrategy_No_Strategy)) ? 1 : 0);
        if (r0.isEmpty() == false) goto L18;
        r10.invoke(new Object[]{1, "Can not find text bounding rect."});
        return;
    L18:
        r10.invoke(new Object[]{0, N(r0, h.g(this, r9))});
        return;
    L20:
        r10.invoke(new Object[]{4, "parameter is invalid"});
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void onInsertChild(LynxBaseUI r1, int r2) {
        super.onInsertChild(r1, r2);
        if ((r1 instanceof LynxUI) == false) goto L6;
        ((LynxUI) r1).setVisibilityForView(4);
        return;
    }

    @LynxUIMethod
    public void pauseAnimation(ReadableMap r4, Callback r5) {
        if (M(r5) == true) goto L5;
        return;
    L5:
        this.a.pauseAnimation();
        JavaOnlyMap r6 = new JavaOnlyMap();
        r6.put("animationStep", Integer.valueOf(this.a.getAnimationStep()));
        r5.invoke(new Object[]{0, r6});
    }

    @LynxUIMethod
    public void resumeAnimation(ReadableMap r3, Callback r4) {
        if (M(r4) == true) goto L5;
        return;
    L5:
        int r0 = -1;
        if (r3 == null) goto L9;
        r0 = r3.getInt("animationStep", -1);
    L9:
        if (r0 < 0) goto L11;
        this.a.resumeAnimation(r0);
    L12:
        r4.invoke(new Object[]{0});
        return;
    L11:
        this.a.resumeAnimation();
        goto L12
    }

    @LynxUIMethod
    public void setTextSelection(ReadableMap r18, Callback r19) {
        if (M(r19) == true) goto L6;
        return;
    L6:
        if (r18 != null) goto L9;
        r19.invoke(new Object[]{4, "parameter is invalid"});
        return;
    L9:
        double r6 = getLynxContext().getScreenMetrics().density;
        float r10 = (float) (((r18.getDouble("startX", 0.0d) * r6) - ((double) getPaddingLeft())) - ((double) getBorderLeftWidth()));
        float r11 = (float) (((r18.getDouble("startY", 0.0d) * r6) - ((double) getPaddingTop())) - ((double) getBorderTopWidth()));
        float r12 = (float) (((r18.getDouble("endX", 0.0d) * r6) - ((double) getPaddingLeft())) - ((double) getBorderLeftWidth()));
        float r7 = (float) (((r18.getDouble("endY", 0.0d) * r6) - ((double) getPaddingTop())) - ((double) getBorderTopWidth()));
        String r8 = r18.getString("selectionTextType", NameKeys.UnloadStrategy_No_Strategy);
        if ("word".equals(r8) == false) goto L13;
        int r9 = 1;
    L19:
        d r13 = this.a;
        if (r13 == null) goto L37;
        if (r9 != 0) goto L30;
        int r14 = r13.getCharIndexByPoint(r10, r11, 0);
        int r15 = this.a.getCharIndexByPoint(r12, r7, 0);
        if (r14 < 0) goto L37;
        if (r15 < 0) goto L37;
        if (r14 <= r15) goto L29;
        r14 = r15;
        r15 = r14;
    L29:
        int[] r16 = {r14, r15};
    L38:
        if (r16 != null) goto L41;
        r19.invoke(new Object[]{1, "Can not set text selection."});
        return;
    L41:
        this.a.setTextSelection(r16[0], r16[1]);
        ArrayList<RectF> r17 = this.a.getSelectedLineBoundingRect();
        if (r17.isEmpty() == false) goto L45;
        r19.invoke(new Object[]{0});
        return;
    L45:
        RectF r1 = h.g(this, r18);
        JavaOnlyMap r20 = N(r17, r1);
        long r21 = this.a.getSelectionHandlePosition();
        int r110 = (int) (r21 >>> 32);
        int r22 = (int) (r21 & 4294967295L);
        if (r110 < 0) goto L52;
        if (r22 < 0) goto L52;
        JavaOnlyArray r23 = new JavaOnlyArray();
        float r24 = r110;
        float r25 = r22;
        float r111 = this.a.getSelectionHandleRadius();
        if (r1 != null) goto L51;
        r1 = new RectF();
    L51:
        JavaOnlyMap r112 = new JavaOnlyMap();
        float r113 = getLynxContext().getScreenMetrics().density;
        r112.putDouble("x", (((r1.left + getPaddingLeft()) + getBorderLeftWidth()) + r24) / r113);
        r112.putDouble("y", (((r1.top + getPaddingTop()) + getBorderTopWidth()) + r25) / r113);
        r112.putDouble("radius", r111 / r113);
        r23.pushMap(r112);
        r20.putArray("handles", r23);
    L52:
        r19.invoke(new Object[]{0, r20});
        return;
    L30:
        int r26 = (int) (r13.getCharRangeByPoint(r10, r11, 0, r9) >>> 32);
        int r27 = (int) (this.a.getCharRangeByPoint(r12, r7, 0, r9) & 4294967295L);
        if (r26 < 0) goto L37;
        if (r27 < 0) goto L37;
        if (r26 <= r27) goto L36;
        r26 = r27;
        r27 = r26;
    L36:
        r16 = new int[]{r26, r27};
    L37:
        r16 = null;
        goto L38
    L13:
        if ("sentence".equals(r8) == false) goto L16;
        r9 = 2;
        goto L19
    L16:
        if ("paragraph".equals(r8) == false) goto L18;
        r9 = 3;
        goto L19
    L18:
        r9 = 0;
        goto L19
    }
}
