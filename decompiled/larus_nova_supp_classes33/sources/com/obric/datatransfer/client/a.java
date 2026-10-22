package com.obric.datatransfer.client;

import com.obric.assistant.interaction.impl.essentialtask.task.migration.DataMigrationTask$internalExecute$2$1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ b.InterfaceC0039b b;

    public /* synthetic */ a(b r1, DataMigrationTask$internalExecute$2$1 r2) {
        this.a = r1;
        this.b = r2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r7v0 ??, still in use, count: 10, list:
          (r7v0 ?? I:??[OBJECT, ARRAY]) from 0x0228: MOVE (r2v21 ?? I:??[OBJECT, ARRAY]) = (r7v0 ?? I:??[OBJECT, ARRAY]) (LINE:552)
          (r7v0 ?? I:com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor) from 0x0248: PHI (r2v14 ??) = (r2v0 ??), (r7v0 ?? I:com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor), (r2v26 ??) binds: [B:133:0x02a2, B:110:0x0239, B:93:0x0216] A[DONT_GENERATE, DONT_INLINE]
          (r7v0 ?? I:com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor) from 0x0251: PHI (r2v4 ??) = (r7v0 ?? I:com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor), (r2v22 ??), (r2v27 ??) binds: [B:113:0x023f, B:106:0x0234, B:95:0x021c] A[DONT_GENERATE, DONT_INLINE]
          (r7v0 ?? I:java.util.concurrent.ThreadPoolExecutor) from 0x018e: INVOKE 
          (r0v31 ?? I:com.obric.datatransfer.client.DataTransferClient$startMigration$1$2$1)
          (r7v0 ?? I:java.util.concurrent.ThreadPoolExecutor)
          (r8v0 ?? I:com.obric.datatransfer.client.b)
          (r14v0 ?? I:java.util.concurrent.atomic.AtomicInteger)
          (r15v0 ?? I:java.util.concurrent.atomic.AtomicInteger)
          (r9v0 ?? I:com.obric.datatransfer.client.b$b)
         DIRECT call: com.obric.datatransfer.client.DataTransferClient$startMigration$1$2$1.<init>(java.util.concurrent.ThreadPoolExecutor, com.obric.datatransfer.client.b, java.util.concurrent.atomic.AtomicInteger, java.util.concurrent.atomic.AtomicInteger, com.obric.datatransfer.client.b$b):void A[Catch: all -> 0x0221, MD:(java.util.concurrent.ThreadPoolExecutor, com.obric.datatransfer.client.b, java.util.concurrent.atomic.AtomicInteger, java.util.concurrent.atomic.AtomicInteger, com.obric.datatransfer.client.b$b):void (m), TRY_ENTER] (LINE:398)
          (r7v0 ?? I:??[OBJECT, ARRAY]) from 0x0222: MOVE (r2v24 ?? I:??[OBJECT, ARRAY]) = (r7v0 ?? I:??[OBJECT, ARRAY]) (LINE:546)
          (r7v0 ?? I:??[OBJECT, ARRAY]) from 0x0216: MOVE (r2v26 ?? I:??[OBJECT, ARRAY]) = (r7v0 ?? I:??[OBJECT, ARRAY]) (LINE:534)
          (r7v0 ?? I:??[OBJECT, ARRAY]) from 0x021c: MOVE (r2v27 ?? I:??[OBJECT, ARRAY]) = (r7v0 ?? I:??[OBJECT, ARRAY]) (LINE:540)
          (r7v0 ?? I:??[OBJECT, ARRAY]) from 0x01db: MOVE (r2v28 ?? I:??[OBJECT, ARRAY]) = (r7v0 ?? I:??[OBJECT, ARRAY]) (LINE:475)
          (r7v0 ?? I:java.util.concurrent.ThreadPoolExecutor) from 0x01e1: INVOKE (r7v0 ?? I:java.util.concurrent.ThreadPoolExecutor) VIRTUAL call: java.util.concurrent.ThreadPoolExecutor.shutdown():void A[MD:():void (c)] (LINE:481)
          (r7v0 ?? I:java.util.concurrent.ThreadPoolExecutor) from 0x01e8: INVOKE (r7v0 ?? I:java.util.concurrent.ThreadPoolExecutor), (r10v8 ?? I:long), (r0v47 ?? I:java.util.concurrent.TimeUnit) VIRTUAL call: java.util.concurrent.ThreadPoolExecutor.awaitTermination(long, java.util.concurrent.TimeUnit):boolean A[Catch: InterruptedException -> 0x01ec, MD:(long, java.util.concurrent.TimeUnit):boolean throws java.lang.InterruptedException (c), TRY_LEAVE] (LINE:488)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    @Override // java.lang.Runnable
    public final void run() {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r8v0 ??
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
            Method dump skipped, instruction units count: 742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.datatransfer.client.a.run():void");
    }
}
