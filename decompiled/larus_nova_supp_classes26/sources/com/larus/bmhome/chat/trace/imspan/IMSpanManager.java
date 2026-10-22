package com.larus.bmhome.chat.trace.imspan;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.trace.imspan.bean.SpanRecord;
import com.larus.trace.tracespan.span.b;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class IMSpanManager {
    public static final LruCache<String, String> a = null;
    public static final LruCache<String, SpanRecord> b = null;

    public IMSpanManager() {
    }

    static {
        a = new LruCache(10);
        b = new LruCache(10);
    }

    public static String a(String r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        String r1 = null;
        if (r0 == false) goto L11;
        return null;
    L11:
        String r2 = (String) a.get(r4);
        if (r2 == null) goto L15;
        r4 = r2;
    L15:
        SpanRecord r3 = (SpanRecord) b.get(r4);
        if (r3 == null) goto L18;
        r1 = r3.getTraceKey();
    L18:
        FLogger.a.i("IM_SPAN_TRACING", "getTraceKey, msg:" + r4 + ", traceKey:" + r1);
        return r1;
    L4:
        if (r4.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r15v1 ??, still in use, count: 1, list:
          (r15v1 ?? I:java.lang.Object) from 0x004d: INVOKE (r4v9 ?? I:androidx.collection.LruCache), (r0v1 ?? I:java.lang.Object), (r15v1 ?? I:java.lang.Object) VIRTUAL call: androidx.collection.LruCache.put(java.lang.Object, java.lang.Object):java.lang.Object (LINE:50331725)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public static void b(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r15v1 ??, still in use, count: 1, list:
          (r15v1 ?? I:java.lang.Object) from 0x004d: INVOKE (r4v9 ?? I:androidx.collection.LruCache), (r0v1 ?? I:java.lang.Object), (r15v1 ?? I:java.lang.Object) VIRTUAL call: androidx.collection.LruCache.put(java.lang.Object, java.lang.Object):java.lang.Object (LINE:50331725)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r16v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
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

    public static void c(String r13, Integer r14, String r15) {
        Intrinsics.checkNotNullParameter(r13, "localMessageId");
        if (r13.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        String r1 = (String) a.get(r13);
        if (r1 != null) goto L11;
        String r6 = r13;
    L12:
        SpanRecord r16 = (SpanRecord) b.get(r6);
        if (r16 != null) goto L15;
        return;
    L15:
        b r2 = r16.getRootSpan();
        JSONObject r3 = r16.getTrackParams();
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new IMSpanManager$reportRoot$1(r2, r3, r14, r15, r6, null), 2, null);
        return;
    L11:
        r6 = r1;
        goto L12
    L5:
        r0 = false;
        goto L6
    }
}
