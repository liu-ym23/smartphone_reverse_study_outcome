package com.lynx.tasm.behavior.render;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.c;
import com.lynx.tasm.behavior.l;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.service.ILynxTextService;
import java.util.Iterator;
import x6a.e;
import x6a.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class NativePaintingContext implements l {
    public long a;
    public final PlatformRendererContext b;
    public boolean c;
    public long d;
    public LynxContext e;

    private native long nativeCreatePaintingContext(NativePaintingContext r1, long r2, Object r4, long r5);

    public native void nativeDestroy(long r1);

    public native boolean nativeDispatchPlatformInputEvent(long r1, int[] r3, float[] r4);

    public native void nativeDispatchPlatformLongPress(long r1);

    public native void nativeDispatchPlatformTap(long r1);

    public native int[] nativeGetMeaningfulPaintingAreaRecords(long r1);

    public native int[] nativeGetPlatformFocusInfo(long r1);

    public native boolean nativeIsPlatformEventTargetEventThrough(long r1, int r3, float r4, float r5);

    public native void nativeSetLynxEngineActorForPlatformContextRef(long r1, long r3);

    public native void nativeSetPlatformEventRootActive(long r1, int r3, boolean r4);

    public native void nativeSetPlatformEventRootOffset(long r1, int r3, float r4, float r5);

    @Override // com.lynx.tasm.behavior.l
    public final void destroy() {
        if (this.c == false) goto L5;
        return;
    L5:
        this.c = true;
        long r1 = this.a;
        if (r1 == 0) goto L8;
        nativeDestroy(r1);
        this.a = 0;
    L8:
        PlatformRendererContext r2 = this.b;
        if (r2.h == true) goto L23;
        r2.h = true;
        long r6 = r2.f;
        if (r6 == 0) goto L14;
        r2.nativeDestroy(r6);
    L14:
        r2.f = 0;
        r2.c = null;
        r2.b.clear();
        Iterator<Object> r0 = r2.i.values().iterator();
    L16:
        if (r0.hasNext() == false) goto L20;
        Object r3 = r0.next();
        if ((r3 instanceof ILynxTextService.a) == false) goto L16;
        ((ILynxTextService.a) r3).destroy();
        goto L16
    L20:
        r2.i.clear();
        r2.j = null;
        r2.g = null;
        UIBody.UIBodyView r4 = r2.a.get();
        if (r4 == null) goto L23;
        r4.clearNodeIndexImageMap();
    L23:
        this.d = 0;
        this.e = null;
    }

    @Override // com.lynx.tasm.behavior.l
    public final void e() {
        long r0 = this.a;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (this.c == true) goto L10;
        nativeDispatchPlatformLongPress(r0);
        return;
    }

    @Override // com.lynx.tasm.behavior.l
    public final void f() {
        long r0 = this.a;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (this.c == true) goto L10;
        nativeDispatchPlatformTap(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v3, types: [x6a.e] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v9 */
    @Override // com.lynx.tasm.behavior.l
    public final void i() {
        long r0 = this.a;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (this.c == true) goto L71;
        int[] r1 = nativeGetPlatformFocusInfo(r0);
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.length >= 4) goto L12;
        return;
    L12:
        if (r1[2] == 0) goto L14;
        return;
    L14:
        if (r1[3] == 0) goto L72;
        PlatformRendererContext r2 = this.b;
        int r3 = r1[0];
        int r4 = r1[1];
        LynxContext r5 = r2.d;
        LynxBaseUI r6 = null;
        if (r5 == null) goto L19;
        LynxUIOwner r7 = r5.getLynxUIOwner();
    L20:
        if (r7 == null) goto L22;
        LynxBaseUI r8 = r7.getNode(r3);
    L23:
        e r9 = r2.b.get(Integer.valueOf(r3));
        ?? r10 = r9;
        if (r9 != null) goto L26;
        r10 = r2.b.get(Integer.valueOf(r4));
    L26:
        if (r8 != null) goto L32;
        if (r10 == 0) goto L32;
        i r11 = r10.getRenderer();
        if (r11 == null) goto L31;
        r6 = r11.h;
    L31:
        r8 = r6;
    L32:
        PlatformRendererContext.c r12 = new PlatformRendererContext.c(r3, r4, r8, r10);
        PlatformRendererContext.c r13 = r2.c;
        if (r13 == null) goto L53;
        Object r14 = r13.c;
        if (r14 != null) goto L38;
        r14 = r13.d;
    L38:
        if (r8 == null) goto L40;
        r10 = r8;
    L40:
        if (r14 != null) goto L48;
        if (r10 != 0) goto L48;
        if (r13.a == r3) goto L46;
    L50:
        boolean r15 = false;
    L51:
        if (r15 == false) goto L53;
        r2.c = r12;
        return;
    L46:
        if (r13.b != r4) goto L50;
    L49:
        r15 = true;
    L48:
        if (r14 != r10) goto L50;
    L53:
        boolean r16 = r12.a();
        if (r13 != null) goto L56;
    L58:
        boolean r17 = false;
    L59:
        r2.c = r12;
        if (r16 == false) goto L62;
        r12.b(true, r17);
    L62:
        if (r17 == false) goto L70;
        r13.b(false, r16);
        return;
    L70:
        return;
    L56:
        if (r13.a() == false) goto L58;
        r17 = true;
        goto L59
    L22:
        r8 = null;
        goto L23
    L19:
        r7 = null;
        goto L20
    L72:
        return;
    }

    @Override // com.lynx.tasm.behavior.l
    public final long a() {
        return this.a;
    }

    @Override // com.lynx.tasm.behavior.l
    public final int b(int r2) {
        e r3 = this.b.b.get(Integer.valueOf(r2));
        if (r3 != null) goto L6;
        LLog.e("PlatformRendererContext", "getTargetWidth failed since can not find target view.");
        return 0;
    L6:
        return r3.getRendererHostWidth();
    }

    @Override // com.lynx.tasm.behavior.l
    public final void d(long r6) {
        long r0 = this.a;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (this.c == true) goto L10;
        nativeSetLynxEngineActorForPlatformContextRef(r0, r6);
        return;
    }

    @Override // com.lynx.tasm.behavior.l
    public final int h(int r2) {
        e r3 = this.b.b.get(Integer.valueOf(r2));
        if (r3 != null) goto L6;
        LLog.e("PlatformRendererContext", "getTargetHeight failed since can not find target view.");
        return 0;
    L6:
        return r3.getRendererHostHeight();
    }

    @Override // com.lynx.tasm.behavior.l
    public final boolean c(MotionEvent r10, int r11) {
        int r4 = 0;
        if (this.a != 0) goto L5;
    L29:
        return false;
    L5:
        if (this.c == true) goto L29;
        int r0 = r10.getActionMasked();
        if (r0 != 5) goto L10;
        int r5 = 0;
    L13:
        if (r0 == 5) goto L17;
        if (r0 == 6) goto L17;
        boolean r1 = false;
    L18:
        if (r1 == false) goto L20;
        int r2 = 1;
    L21:
        int[] r3 = {0, r5, r10.getSource(), r2, r11};
        float[] r12 = new float[r2 * 3];
    L22:
        if (r4 >= r2) goto L28;
        if (r1 == false) goto L25;
        int r6 = r10.getActionIndex();
    L26:
        int r7 = r4 * 3;
        r12[r7] = r10.getPointerId(r6);
        r12[r7 + 1] = r10.getX(r6);
        r12[r7 + 2] = r10.getY(r6);
        r4 = r4 + 1;
        goto L22
    L25:
        r6 = r4;
        goto L26
    L28:
        return nativeDispatchPlatformInputEvent(this.a, r3, r12);
    L20:
        r2 = r10.getPointerCount();
    L17:
        r1 = true;
        goto L18
    L10:
        if (r0 != 6) goto L12;
        r5 = 1;
        goto L13
    L12:
        r5 = r0;
        goto L13
    }

    @Override // com.lynx.tasm.behavior.l
    public final PointF g(int r2, PointF r3) {
        e r4 = this.b.b.get(Integer.valueOf(r2));
        if (r4 != null) goto L6;
        LLog.e("PlatformRendererContext", "convertPointInViewToScreen failed since can not find target host.");
        return r3;
    L6:
        return r4.convertPointInRendererHostToScreen(r3);
    }

    public NativePaintingContext(UIBody.UIBodyView r9, LynxContext r10, c r11) {
        this.a = 0;
        this.c = false;
        this.d = 0;
        PlatformRendererContext r0 = new PlatformRendererContext(r9, r10, r11);
        this.b = r0;
        this.e = r10;
        if (r10.isTextServiceModeOn() == true) goto L5;
    L7:
        this.a = nativeCreatePaintingContext(this, r0.f, r0.g, this.d);
        return;
    L5:
        if (r10.getTextService() == null) goto L7;
        this.d = r10.getTextService().createTextLayoutAPI(r10);
        goto L7
    }
}
