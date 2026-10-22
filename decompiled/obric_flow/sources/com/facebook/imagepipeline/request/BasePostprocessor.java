package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasePostprocessor implements Postprocessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bitmap.Config f8412a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f8413b;

    static {
        f8412a = Bitmap.Config.ARGB_8888;
    }

    public BasePostprocessor() {
    }

    public static void a(Bitmap r5, Bitmap r10) {
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
            java.lang.String r0 = "Wrong Native code setup, reflection failed."
            android.graphics.Bitmap$Config r1 = r5.getConfig()
            android.graphics.Bitmap$Config r2 = r6.getConfig()
            r3 = 0
            if (r1 != r2) goto L50
            java.lang.reflect.Method r1 = com.facebook.imagepipeline.request.BasePostprocessor.f8413b     // Catch: java.lang.reflect.InvocationTargetException -> L26 java.lang.NoSuchMethodException -> L28 java.lang.IllegalAccessException -> L2a java.lang.ClassNotFoundException -> L2c
            if (r1 != 0) goto L2e
            java.lang.String r1 = "com.facebook.imagepipeline.nativecode.Bitmaps"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L26 java.lang.NoSuchMethodException -> L28 java.lang.IllegalAccessException -> L2a java.lang.ClassNotFoundException -> L2c
            java.lang.String r2 = "copyBitmap"
            java.lang.Class<android.graphics.Bitmap> r4 = android.graphics.Bitmap.class
            java.lang.Class[] r4 = new java.lang.Class[]{r4, r4}     // Catch: java.lang.reflect.InvocationTargetException -> L26 java.lang.NoSuchMethodException -> L28 java.lang.IllegalAccessException -> L2a java.lang.ClassNotFoundException -> L2c
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r4)     // Catch: java.lang.reflect.InvocationTargetException -> L26 java.lang.NoSuchMethodException -> L28 java.lang.IllegalAccessException -> L2a java.lang.ClassNotFoundException -> L2c
            com.facebook.imagepipeline.request.BasePostprocessor.f8413b = r1     // Catch: java.lang.reflect.InvocationTargetException -> L26 java.lang.NoSuchMethodException -> L28 java.lang.IllegalAccessException -> L2a java.lang.ClassNotFoundException -> L2c
            goto L2e
        L26:
            r5 = move-exception
            goto L38
        L28:
            r5 = move-exception
            goto L3e
        L2a:
            r5 = move-exception
            goto L44
        L2c:
            r5 = move-exception
            goto L4a
        L2e:
            java.lang.reflect.Method r1 = com.facebook.imagepipeline.request.BasePostprocessor.f8413b     // Catch: java.lang.reflect.InvocationTargetException -> L26 java.lang.NoSuchMethodException -> L28 java.lang.IllegalAccessException -> L2a java.lang.ClassNotFoundException -> L2c
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r6}     // Catch: java.lang.reflect.InvocationTargetException -> L26 java.lang.NoSuchMethodException -> L28 java.lang.IllegalAccessException -> L2a java.lang.ClassNotFoundException -> L2c
            r1.invoke(r3, r5)     // Catch: java.lang.reflect.InvocationTargetException -> L26 java.lang.NoSuchMethodException -> L28 java.lang.IllegalAccessException -> L2a java.lang.ClassNotFoundException -> L2c
            return
        L38:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            r6.<init>(r0, r5)
            throw r6
        L3e:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            r6.<init>(r0, r5)
            throw r6
        L44:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            r6.<init>(r0, r5)
            throw r6
        L4a:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            r6.<init>(r0, r5)
            throw r6
        L50:
            android.graphics.Canvas r0 = new android.graphics.Canvas
            r0.<init>(r5)
            r5 = 0
            r0.drawBitmap(r6, r5, r5, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.request.BasePostprocessor.a(android.graphics.Bitmap, android.graphics.Bitmap):void");
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public String getName() {
        return "Unknown postprocessor";
    }
}
