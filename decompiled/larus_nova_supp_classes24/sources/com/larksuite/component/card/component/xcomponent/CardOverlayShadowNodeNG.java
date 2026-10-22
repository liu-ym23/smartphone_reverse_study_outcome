package com.larksuite.component.card.component.xcomponent;

import android.app.Activity;
import android.content.Context;
import android.util.Size;
import com.larksuite.component.card.utils.UniversalCardHostInfoManager;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxShadowNode;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import y6a.b;
import y6a.e;
import y6a.g;
import y6a.j;
import y6a.k;
import y6a.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@LynxShadowNode(tagName = "x-overlay-ng")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¨\u0006\u0012"}, d2 = {"Lcom/larksuite/component/card/component/xcomponent/CardOverlayShadowNodeNG;", "Lcom/lynx/tasm/behavior/shadow/ShadowNode;", "Lcom/lynx/tasm/behavior/shadow/CustomMeasureFunc;", "<init>", "()V", "measure", "Lcom/lynx/tasm/behavior/shadow/MeasureResult;", "param", "Lcom/lynx/tasm/behavior/shadow/MeasureParam;", "context", "Lcom/lynx/tasm/behavior/shadow/MeasureContext;", "align", "", "Lcom/lynx/tasm/behavior/shadow/AlignParam;", "Lcom/lynx/tasm/behavior/shadow/AlignContext;", "getActivity", "Landroid/app/Activity;", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardOverlayShadowNodeNG extends ShadowNode implements e {

    public static final class a {
    }

    static {
    }

    private final Activity getActivity() {
        StringBuilder r0 = new StringBuilder("baseContext is ");
        LynxContext r1 = ((ShadowNode) this).m;
        Activity r2 = null;
        if (r1 == null) goto L5;
        Context r3 = r1.getBaseContext();
    L6:
        r0.append(r3);
        Log.d("CardOverlayShadowNodeNG", r0.toString());
        LynxContext r4 = ((ShadowNode) this).m;
        if (r4 == null) goto L9;
        Context r5 = r4.getBaseContext();
    L11:
        if ((r5 instanceof Activity) == false) goto L13;
        r2 = (Activity) r5;
    L13:
        if (r2 == null) goto L15;
        return r2;
    L15:
        return AppLifecycle.a.a.f();
    L9:
        r5 = null;
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    public CardOverlayShadowNodeNG() {
        h(this);
    }

    public final k b(j r8, g r9) {
        Log.d("CardOverlayShadowNodeNG", "start measure");
        if (l() <= 0) goto L36;
        NativeLayoutNodeRef r1 = k(0);
        if ((r1 instanceof NativeLayoutNodeRef) == false) goto L36;
        Context r2 = getActivity();
        if (r2 != null) goto L9;
        LarkAppContext.Companion.getClass();
        r2 = LarkAppContext.access$getInstance$cp().getContext();
    L9:
        UniversalCardHostInfoManager.f.getClass();
        Size r3 = UniversalCardHostInfoManager.a.a(r2);
        j r4 = new j();
        float r5 = r3.getHeight();
        NativeLayoutNodeRef r6 = r1;
        o r7 = ((LayoutNode) r6).h;
        if (r7 == null) goto L14;
        int[] r10 = r7.b();
        if (r10 == null) goto L14;
        float r11 = r10[1];
    L15:
        float r12 = r5 - r11;
        o r13 = ((LayoutNode) r6).h;
        if (r13 == null) goto L20;
        int[] r14 = r13.b();
        if (r14 == null) goto L20;
        float r15 = r14[3];
    L21:
        r4.c = r12 - r15;
        float r16 = r3.getWidth();
        o r17 = ((LayoutNode) r6).h;
        if (r17 == null) goto L26;
        int[] r19 = r17.b();
        if (r19 == null) goto L26;
        float r20 = r19[0];
    L27:
        float r21 = r16 - r20;
        o r22 = ((LayoutNode) r6).h;
        if (r22 == null) goto L32;
        int[] r23 = r22.b();
        if (r23 == null) goto L32;
        float r24 = r23[2];
    L33:
        r4.a = r21 - r24;
        MeasureMode r25 = MeasureMode.EXACTLY;
        r4.b = r25;
        r4.d = r25;
        r6.D(r9, r4);
        return new k(0.0f, 0.0f);
    L32:
        r24 = 0.0f;
    L26:
        r20 = 0.0f;
    L20:
        r15 = 0.0f;
    L14:
        r11 = 0.0f;
    L36:
        return new k(0.0f, 0.0f);
    }

    public final void d(b r4, y6a.a r5) {
        if (l() <= 0) goto L19;
        NativeLayoutNodeRef r6 = k(0);
        if ((r6 instanceof NativeLayoutNodeRef) == false) goto L20;
        b r0 = new b();
        NativeLayoutNodeRef r7 = r6;
        o r1 = ((LayoutNode) r7).h;
        float r2 = 0.0f;
        if (r1 == null) goto L11;
        int[] r3 = r1.b();
        if (r3 == null) goto L11;
        float r8 = r3[0];
    L12:
        r0.a = r8;
        o r9 = ((LayoutNode) r7).h;
        if (r9 == null) goto L17;
        int[] r10 = r9.b();
        if (r10 == null) goto L17;
        r2 = r10[1];
    L17:
        r0.b = r2;
        r7.C(r0);
        return;
    L11:
        r8 = 0.0f;
        goto L12
    L20:
        return;
    }
}
