package com.lynx.tasm.core;

import android.text.TextUtils;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.miui.easygo.constant.EasyGoConstant;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ResourceLoader {
    public ResourceLoader() {
    }

    private native void nativeConfigLynxResourceSetting();

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00f2: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:16777458), block:B:46:0x00f2 */
    public static byte[] a(String r10) {
        String r3 = r10.substring(14);
        InputStream r4 = null;
        if (LynxEnv.inst().isDevtoolEnabled() == true) goto L64;
    L11:
        InputStream r5 = null;
    L12:
        if (r5 == null) goto L62;
    L14:
        if (r5 == null) goto L27;
        ByteArrayOutputStream r6 = new ByteArrayOutputStream();     // Catch: IOException -> L19 Throwable -> L45
        byte[] r7 = new byte[4096];     // Catch: IOException -> L19 Throwable -> L45
    L16:
        int r8 = r5.read(r7);     // Catch: IOException -> L19 Throwable -> L45
        if (r8 == (-1)) goto L21;
        r6.write(r7, 0, r8);     // Catch: IOException -> L19 Throwable -> L45
        goto L16
    L21:
        byte[] r11 = r6.toByteArray();     // Catch: IOException -> L19 Throwable -> L45
        r5.close();     // Catch: IOException -> L24
    L26:
        return r11;
    L24:
        e = move-exception;
        LLog.e("ResourceLoader", "loadLynxJSAsset inputStream close error: " + e.getMessage());
    L19:
        e = e;
    L36:
        LLog.e("ResourceLoader", "loadLynxJSAsset " + r10 + "with error message " + e.getMessage());     // Catch: Throwable -> L45
        if (r5 != null) goto L60;
    L43:
        LLog.e("ResourceLoader", "loadLynxJSAsset failed, can not load ".concat(r10));
        return null;
    L60:
        r5.close();     // Catch: IOException -> L40
    L40:
        IOException e = e;
        StringBuilder r9 = new StringBuilder("loadLynxJSAsset inputStream close error: ");
    L42:
        r9.append(e.getMessage());
        LLog.e("ResourceLoader", r9.toString());
        goto L43
    L27:
        if (r5 == null) goto L43;
        r5.close();     // Catch: IOException -> L30
    L30:
        e = e;
        r9 = new StringBuilder("loadLynxJSAsset inputStream close error: ");
        goto L42
    L62:
        r5 = LynxEnv.inst().getAppContext().getResources().getAssets().open(r3);     // Catch: IOException -> L19 Throwable -> L45
        goto L14
    L64:
        String[] r12 = r3.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: IOException -> L10 Throwable -> L32
        if (r12.length != 2) goto L11;
        r5 = LynxEnv.inst().getAppContext().getResources().getAssets().open(r12[0] + "_dev." + r12[1]);     // Catch: IOException -> L10 Throwable -> L32
    L45:
        th = th;
        r4 = r5;
    L47:
        if (r4 != null) goto L53;
    L52:
        throw th;
    L53:
        r4.close();     // Catch: IOException -> L50
    L50:
        e = move-exception;
        LLog.e("ResourceLoader", "loadLynxJSAsset inputStream close error: " + e.getMessage());
    L32:
        th = th;
    L34:
        e = e;
        r5 = null;
        goto L36
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private byte[] loadJSSource(String r9) {
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
            Method dump skipped, instruction units count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lynx.tasm.core.ResourceLoader.loadJSSource(java.lang.String):byte[]");
    }
}
