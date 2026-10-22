package com.lynx.tasm.behavior;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.xelement.input.LynxUIBaseInput;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxContext f10302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f10303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f10304c;
    public boolean d;
    public p e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f10305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f10306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10307j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final WeakHashMap f10308k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final WeakHashMap f10309l;

    public o(LynxContext r5) {
        this.f10303b = null;
        this.d = false;
        this.f = 0;
        this.g = 0;
        this.f10306i = 0;
        this.f10307j = 0;
        this.f10308k = new WeakHashMap();
        this.f10309l = new WeakHashMap();
        LynxLog.b(1, LynxMonitorService.DEFAULT_PID, "KeyboardEvent initialized.");
        this.f10302a = r5;
        this.f10304c = r5.f10152u.density;
        this.f10305h = new Rect();
    }

    public final void a() {
        LynxContext r5 = this.f10302a;
        Rect r10 = this.f10305h;
        Activity r11 = kk.a.c(r5);     // Catch: Exception -> L7
        if (r11 != null) goto L9;
        LynxLog.b(4, LynxMonitorService.DEFAULT_PID, "KeyboardEvent's context must be Activity.");     // Catch: Exception -> L7
        return;
    L9:
        View r12 = r11.getWindow().getDecorView();     // Catch: Exception -> L7
        com.lynx.tasm.u0 r13 = r5.K;     // Catch: Exception -> L7
        int r14 = 0;
        if (r13 == null) goto L12;
        boolean r15 = r13.f10984w;     // Catch: Exception -> L7
    L14:
        if (r5.f10145m == null) goto L63;
        WeakReference r16 = new WeakReference(r5.f10145m.f10385a);     // Catch: Exception -> L7
        this.e.getWindow().getDecorView().getWindowVisibleDisplayFrame(r10);     // Catch: Exception -> L7
        int r17 = this.e.getWindow().getDecorView().getHeight() + r10.top;     // Catch: Exception -> L7
        int r18 = this.e.getWindow().getDecorView().getHeight();     // Catch: Exception -> L7
        if (this.g != 0) goto L19;
        this.g = r12.getHeight();     // Catch: Exception -> L7
    L19:
        this.f = this.e.a() - r10.top;     // Catch: Exception -> L7
        int r19 = r11.getWindow().getWindowManager().getDefaultDisplay().getRotation();     // Catch: Exception -> L7
        int r20 = this.g;     // Catch: Exception -> L7
        int r21 = this.f;     // Catch: Exception -> L7
        double r110 = ((double) r18) / ((double) r21);     // Catch: Exception -> L7
        if (r19 == 0) goto L23;
        if (r19 == 2) goto L23;
    L27:
        if (r110 >= 0.9d) goto L29;
        boolean r22 = true;
    L30:
        UIBody.UIBodyView r111 = (UIBody.UIBodyView) r16.get();     // Catch: Exception -> L7
        float r112 = this.f10304c;
        if (r22 == false) goto L34;
        int r23 = (int) ((r20 - r18) / r112);
    L35:
        if (r15 == false) goto L39;
        if (r111 == null) goto L39;
        int[] r24 = new int[2];     // Catch: Exception -> L7
        r111.getLocationOnScreen(r24);     // Catch: Exception -> L7
        int r25 = (r24[1] + r111.getHeight()) - r17;     // Catch: Exception -> L7
    L41:
        r14 = (int) (r25 / r112);     // Catch: Exception -> L7
    L42:
        LynxLog.b(1, LynxMonitorService.DEFAULT_PID, "KeyboardEvent visible = " + r22 + ", height = " + r23 + ", compatHeight = " + r14);     // Catch: Exception -> L7
        if (r23 != this.f10306i) goto L47;
        if (r15 == true) goto L46;
    L48:
        Iterator r26 = this.f10308k.entrySet().iterator();     // Catch: Exception -> L7
    L50:
        if (r26.hasNext() == false) goto L64;
        Map.Entry r27 = (Map.Entry) r26.next();     // Catch: Exception -> L7
        if (r27.getKey() == null) goto L50;
        ((ViewTreeObserver.OnGlobalLayoutListener) r27.getValue()).onGlobalLayout();     // Catch: Exception -> L7
        goto L50
    L64:
        return;
    L46:
        if (r14 == this.f10307j) goto L48;
    L47:
        b(r22, r14);     // Catch: Exception -> L7
        this.f10306i = r23;     // Catch: Exception -> L7
        this.f10307j = r14;     // Catch: Exception -> L7
    L39:
        if (r22 == false) goto L42;
        r25 = r21 - r18;     // Catch: Exception -> L7
        goto L41
    L34:
        r23 = 0;
        goto L35
    L29:
        r22 = false;
    L23:
        if (r110 >= 0.4d) goto L27;
        com.lynx.tasm.utils.j.a().post(new l(this, 1));     // Catch: Exception -> L7
        return;
    L63:
        return;
    L12:
        r15 = false;
    L7:
        e = move-exception;
        LynxLog.b(4, LynxMonitorService.DEFAULT_PID, e.getMessage());
    }

    public final void b(boolean r10, int r11) {
        LynxContext r5 = this.f10302a;
        if (r5.g == null) goto L9;
        JavaOnlyArray r12 = new JavaOnlyArray();
        if (r10 == false) goto L7;
        String r13 = "on";
    L8:
        r12.pushString(r13);
        r12.pushInt(r11);
        r12.pushInt(r11);
        r5.e("keyboardstatuschanged", r12);
        goto L9
    L7:
        r13 = "off";
    L9:
        Iterator r14 = this.f10309l.entrySet().iterator();
    L11:
        if (r14.hasNext() == false) goto L18;
        n r15 = (n) ((Map.Entry) r14.next()).getValue();
        if (r10 == true) goto L14;
        LynxUIBaseInput r16 = (LynxUIBaseInput) r15;
        if (r16.f11209p == false) goto L11;
        r16.f11210q = r16.i(false);
        com.lynx.tasm.r r17 = r16.getLynxContext().g;
        com.lynx.animax.i r18 = new com.lynx.animax.i(r16.getSign(), "keyboardheightchange");
        r18.a("height", 0);
        r17.b(r18);
        goto L11
    L14:
        ((LynxUIBaseInput) r15).j((int) (r11 * this.f10304c));
        goto L11
    }

    public final synchronized void c() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.d == false) goto L11;
        LynxLog.b(1, LynxMonitorService.DEFAULT_PID, "KeyboardEvent already started");     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        if (com.lynx.tasm.utils.j.j() == true) goto L15;
        l r5 = new l(this, 0);     // Catch: Throwable -> L8
        com.lynx.tasm.utils.j.a().post(r5);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L15:
        d();     // Catch: Throwable -> L8
        monitor-exit(this);
    }

    public final void d() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.String r0 = "KeyboardMonitor"
            java.lang.String r1 = "KeyboardEvent starting"
            r2 = 1
            java.lang.String r3 = "Lynx"
            com.lynx.base.log.LynxLog.b(r2, r3, r1)
            com.lynx.tasm.behavior.LynxContext r1 = r5.f10302a
            android.app.Activity r1 = kk.a.c(r1)
            if (r1 != 0) goto L19
            java.lang.String r5 = "KeyboardEvent's context must be Activity"
            r0 = 4
            com.lynx.base.log.LynxLog.b(r0, r3, r5)
            return
        L19:
            com.lynx.tasm.behavior.p r3 = r5.e
            if (r3 != 0) goto L24
            com.lynx.tasm.behavior.p r3 = new com.lynx.tasm.behavior.p
            r3.<init>(r1)
            r5.e = r3
        L24:
            com.lynx.tasm.behavior.m r1 = new com.lynx.tasm.behavior.m
            r3 = 0
            r1.<init>(r5, r3)
            r5.f10303b = r1
            com.lynx.tasm.behavior.p r3 = r5.e
            android.view.Window r3 = r3.getWindow()
            android.view.View r3 = r3.getDecorView()
            android.view.ViewTreeObserver r3 = r3.getViewTreeObserver()
            r3.addOnGlobalLayoutListener(r1)
            com.lynx.tasm.behavior.p r1 = r5.e
            boolean r3 = r1.isShowing()
            if (r3 != 0) goto L6b
            r3 = 3
            android.content.Context r4 = r1.getContext()     // Catch: java.lang.RuntimeException -> L58 android.view.WindowManager.BadTokenException -> L5a
            android.app.Activity r4 = com.lynx.tasm.behavior.p.b(r4)     // Catch: java.lang.RuntimeException -> L58 android.view.WindowManager.BadTokenException -> L5a
            boolean r4 = r4.isFinishing()     // Catch: java.lang.RuntimeException -> L58 android.view.WindowManager.BadTokenException -> L5a
            if (r4 != 0) goto L6b
            r1.show()     // Catch: java.lang.RuntimeException -> L58 android.view.WindowManager.BadTokenException -> L5a
            goto L6b
        L58:
            r1 = move-exception
            goto L5c
        L5a:
            r1 = move-exception
            goto L64
        L5c:
            java.lang.String r1 = r1.toString()
            com.lynx.base.log.LynxLog.b(r3, r0, r1)
            goto L6b
        L64:
            java.lang.String r1 = r1.toString()
            com.lynx.base.log.LynxLog.b(r3, r0, r1)
        L6b:
            r5.d = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lynx.tasm.behavior.o.d():void");
    }

    public final void e() {
        LynxLog.b(1, LynxMonitorService.DEFAULT_PID, "KeyboardEvent stopping");
        m r5 = this.f10303b;     // Catch: Exception -> L11
        if (r5 == null) goto L21;
        p r10 = this.e;     // Catch: Exception -> L11
        if (r10 == null) goto L21;
        r10.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(r5);     // Catch: Exception -> L11
        p r11 = this.e;     // Catch: Exception -> L11
        if (r11.isShowing() == false) goto L21;
        r11.dismiss();     // Catch: Exception -> L11 RuntimeException -> L13 WindowManager.BadTokenException -> L15
    L15:
        e = move-exception;
        LynxLog.b(3, "KeyboardMonitor", e.toString());     // Catch: Exception -> L11
    L13:
        e = move-exception;
        LynxLog.b(3, "KeyboardMonitor", e.toString());     // Catch: Exception -> L11
    L21:
    L19:
        this.d = false;
        return;
    L11:
        e = move-exception;
        LynxLog.b(3, LynxMonitorService.DEFAULT_PID, "stop KeyboardEvent failed for " + e.toString());
        goto L19
    }
}
