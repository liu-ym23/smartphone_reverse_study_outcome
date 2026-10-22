package org.ehcache.sizeof.impl;

import java.lang.instrument.Instrumentation;

/* JADX INFO: loaded from: memorydata_plugin.apk:org/ehcache/sizeof/impl/sizeof-agent.jar:org/ehcache/sizeof/impl/SizeOfAgent.class */
public class SizeOfAgent {
    private static volatile Instrumentation instrumentation;
    private static final String NO_INSTRUMENTATION_SYSTEM_PROPERTY_NAME = "org.ehcache.sizeof.agent.instrumentationSystemProperty";

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0000: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r3 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('inst' java.lang.instrument.Instrumentation)]) (LINE:29), block:B:2:0x0000 */
    /*  JADX ERROR: StackOverflowError in pass: ConstructorVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1420)
        	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1468)
        	at jadx.core.dex.visitors.ConstructorVisitor.removeAssignChain(ConstructorVisitor.java:243)
        	at jadx.core.dex.visitors.ConstructorVisitor.removeAssignChain(ConstructorVisitor.java:247)
        */
    public static boolean isSetClip() {
        org.ehcache.sizeof.impl.SizeOfAgent.instrumentation = r3;
        defpackage.$$Lambda$a$KbEEVDUVkHlQaKrdSTwQSlmSb8.<init>(r3);
        return;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0000: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r3 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('inst' java.lang.instrument.Instrumentation)]) (LINE:34), block:B:2:0x0000 */
    /*  JADX ERROR: StackOverflowError in pass: ConstructorVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1420)
        	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1468)
        	at jadx.core.dex.visitors.ConstructorVisitor.removeAssignChain(ConstructorVisitor.java:243)
        	at jadx.core.dex.visitors.ConstructorVisitor.removeAssignChain(ConstructorVisitor.java:247)
        */
    public static boolean isSetCliptowrap() {
        org.ehcache.sizeof.impl.SizeOfAgent.instrumentation = r3;
        defpackage.$$Lambda$a$KbEEVDUVkHlQaKrdSTwQSlmSb8.<init>(r3);
        return;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 ??, still in use, count: 2, list:
          (r0v1 ?? I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) from 0x0005: IF  (r0v1 ?? I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:6:?
          (r0v1 ?? I:android.widget.TextView) from CONSTRUCTOR (r0v1 ?? I:android.widget.TextView) (LINE:40) call: -$$Lambda$g$4vTpCR6frM2_TZWZP67rBcxxYGw.<init>(kotlin.jvm.internal.Ref$BooleanRef, android.widget.TextView):void type: CONSTRUCTOR
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1413)
        	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1424)
        	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1468)
        	at jadx.core.dex.visitors.ConstructorVisitor.removeAssignChain(ConstructorVisitor.java:243)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:93)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    private static boolean isSetConnectortype() {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
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
            java.lang.String r0 = "org.ehcache.sizeof.agent.instrumentationSystemProperty"
            void r0 = defpackage.$$Lambda$a$WdT3Hv4bY2DpXDNORxh5iUIPYIc.run()
            if (r0 == 0) goto L14
            void r0 = defpackage.$$Lambda$g$4vTpCR6frM2_TZWZP67rBcxxYGw.<init>(r0, r0)
            java.lang.String r1 = "org.ehcache.sizeof.agent.instrumentation"
            java.lang.instrument.Instrumentation r2 = org.ehcache.sizeof.impl.SizeOfAgent.instrumentation
            java.lang.Object r0 = r0.invoke()
        L14:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ehcache.sizeof.impl.SizeOfAgent.isSetConnectortype():boolean");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, java.lang.instrument.Instrumentation] */
    public static boolean isSetCoordorigin() {
        return instrumentation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SizeOfAgent() {
        super(this, this, this, this, this, this, this, this);
        return;
    }
}
