package com.lynx.tasm.behavior;

import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FutureTask f10315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f10317c;
    public final /* synthetic */ ReadableMap d;
    public final /* synthetic */ ReadableMapBuffer e;
    public final /* synthetic */ ReadableArray f;
    public final /* synthetic */ boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f10318h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ ReadableArray f10319i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ PaintingContext f10320j;

    public q0(PaintingContext r5, FutureTask r10, int r11, String r12, ReadableMap r13, ReadableMapBuffer r14, ReadableArray r15, boolean r16, int r17, ReadableArray r18) {
        this.f10320j = r5;
        this.f10315a = r10;
        this.f10316b = r11;
        this.f10317c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.f10318h = r17;
        this.f10319i = r18;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.lynx.tasm.behavior.n0] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.lynx.tasm.behavior.n0] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6 */
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
    @Override // java.lang.Runnable
    public final void run() {
        FutureTask r5 = this.f10315a;
        boolean r10 = r5.isDone();
        ?? r11 = 2;
        PaintingContext r12 = this.f10320j;
        String r15 = this.f10317c;
        Runnable r13 = null;
        if (r10 == true) goto L15;
        boolean r14 = !r5.cancel(true);
        LynxLog.b(2, "lynx_PaintingContext", "createViewAsync not done, will create on ui thread, tagName:" + r15);
        r11 = r14;
    L9:
        int r16 = this.f10316b;
        if (r13 == null) goto L12;
        r13.run();
        r12.f10169a.t(r15, r16, r11, true);
    L13:
        r12.f10169a.n(this.f10316b, this.f10317c, true);
        return;
    L12:
        r12.f10169a.l(r16, r15, this.d, this.e, this.f, this.g, this.f10318h, this.f10319i);
        r12.f10169a.t(r15, r16, r11, false);
        goto L13
    L15:
        r13 = (Runnable) r5.get();     // Catch: Throwable -> L7
    L7:
        e = move-exception;
        String r17 = "createViewAsync failed, tagName:" + r15 + ", error:" + e;
        LynxLog.b(4, "lynx_PaintingContext", r17);
        r12.f10169a.f10289c.o(new Exception(r17));
        r11 = 3;
        goto L9
    }
}
