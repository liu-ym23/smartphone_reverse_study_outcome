package k;

import android.app.Activity;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.BatteryAgent;
import com.bytedance.apm.battery.BatteryExceptionListener;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.util.p;
import com.bytedance.apm.util.v;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import q.i;
import q.j;
import q.k;
import q.l;

/* JADX INFO: loaded from: classes.dex */
public class a extends i0.a implements s.a.b {
    private static final Object H = null;
    private HashMap<Integer, v> A;
    private long B;
    private HashMap<String, Integer> C;
    private boolean D;
    private volatile BatteryExceptionListener E;
    private final z3.d F;
    private final z3.d G;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Map<String, l> f9937l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile long f9938m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile boolean f9939n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile boolean f9940o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private volatile long f9941p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile long f9942q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private volatile long f9943r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List<String> f9944s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f9945t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private volatile boolean f9946u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f9947v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f9948w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String[] f9949x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f9950y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private HashMap<Integer, v> f9951z;

    /* JADX INFO: renamed from: k.a$a, reason: collision with other inner class name */
    class RunnableC0210a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f9952c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f9953g;

        RunnableC0210a(a r10, boolean r11) {
            this.f9953g = r10;
            this.f9952c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
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
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
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
                java.lang.Object r0 = k.a.v()
                monitor-enter(r0)
                boolean r1 = com.bytedance.apm.d.D()     // Catch: java.lang.Throwable -> L4f
                if (r1 == 0) goto L29
                java.lang.String r1 = e0.b.f8548b     // Catch: java.lang.Throwable -> L4f
                r2 = 1
                java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L4f
                r3 = 0
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
                r4.<init>()     // Catch: java.lang.Throwable -> L4f
                java.lang.String r5 = "ChargingStatusChange:"
                r4.append(r5)     // Catch: java.lang.Throwable -> L4f
                boolean r5 = r6.f9952c     // Catch: java.lang.Throwable -> L4f
                r4.append(r5)     // Catch: java.lang.Throwable -> L4f
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L4f
                r2[r3] = r4     // Catch: java.lang.Throwable -> L4f
                e0.e.d(r1, r2)     // Catch: java.lang.Throwable -> L4f
            L29:
                k.a r1 = r6.f9953g     // Catch: java.lang.Throwable -> L4f
                boolean r1 = k.a.w(r1)     // Catch: java.lang.Throwable -> L4f
                k.a r2 = r6.f9953g     // Catch: java.lang.Throwable -> L4f
                java.util.Map r2 = k.a.x(r2)     // Catch: java.lang.Throwable -> L4f
                java.util.Collection r2 = r2.values()     // Catch: java.lang.Throwable -> L4f
                java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L4f
            L3d:
                boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L4f
                if (r3 == 0) goto L55
                java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L4f
                q.l r3 = (q.l) r3     // Catch: java.lang.Throwable -> L4f
                boolean r4 = r6.f9952c     // Catch: java.lang.Throwable -> L4f
                r3.d(r4, r1)     // Catch: java.lang.Throwable -> L4f
                goto L3d
            L4f:
                r1 = move-exception
                java.lang.String r2 = "ChargingStatusChange"
                t4.a.d(r1, r2)     // Catch: java.lang.Throwable -> L5e
            L55:
                k.a r1 = r6.f9953g     // Catch: java.lang.Throwable -> L5e
                boolean r6 = r6.f9952c     // Catch: java.lang.Throwable -> L5e
                k.a.y(r1, r6)     // Catch: java.lang.Throwable -> L5e
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L5e
                return
            L5e:
                r6 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L5e
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: k.a.RunnableC0210a.run():void");
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f9954c;

        b(a r10) {
            this.f9954c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
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
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
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
                java.lang.Object r0 = k.a.v()
                monitor-enter(r0)
                r1 = 1
                boolean r2 = com.bytedance.apm.d.D()     // Catch: java.lang.Throwable -> L42
                if (r2 == 0) goto L17
                java.lang.String r2 = e0.b.f8548b     // Catch: java.lang.Throwable -> L42
                java.lang.String r3 = "onChangeToFront, record data"
                java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L42
                e0.e.d(r2, r3)     // Catch: java.lang.Throwable -> L42
            L17:
                java.lang.String r2 = "APM-Battery"
                java.lang.String r3 = "ToFrontIn"
                e0.a.d(r2, r3)     // Catch: java.lang.Throwable -> L42
                k.a r2 = r5.f9954c     // Catch: java.lang.Throwable -> L42
                boolean r2 = k.a.z(r2, r1)     // Catch: java.lang.Throwable -> L42
                k.a r3 = r5.f9954c     // Catch: java.lang.Throwable -> L42
                java.util.Map r3 = k.a.x(r3)     // Catch: java.lang.Throwable -> L42
                java.util.Collection r3 = r3.values()     // Catch: java.lang.Throwable -> L42
                java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L42
            L32:
                boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L42
                if (r4 == 0) goto L48
                java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L42
                q.l r4 = (q.l) r4     // Catch: java.lang.Throwable -> L42
                r4.f(r2)     // Catch: java.lang.Throwable -> L42
                goto L32
            L42:
                r2 = move-exception
                java.lang.String r3 = "recordFrontData"
                t4.a.d(r2, r3)     // Catch: java.lang.Throwable -> L5e
            L48:
                p.a r2 = p.a.h()     // Catch: java.lang.Throwable -> L5e
                com.bytedance.apm.core.ActivityLifeObserver r3 = com.bytedance.apm.core.ActivityLifeObserver.getInstance()     // Catch: java.lang.Throwable -> L5e
                java.lang.String r3 = r3.getTopActivityClassName()     // Catch: java.lang.Throwable -> L5e
                r2.p(r3)     // Catch: java.lang.Throwable -> L5e
                k.a r5 = r5.f9954c     // Catch: java.lang.Throwable -> L5e
                k.a.B(r5, r1)     // Catch: java.lang.Throwable -> L5e
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L5e
                return
            L5e:
                r5 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L5e
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: k.a.b.run():void");
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f9955c;

        c(a r10) {
            this.f9955c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
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
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
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
                java.lang.Object r0 = k.a.v()
                monitor-enter(r0)
                boolean r1 = com.bytedance.apm.d.D()     // Catch: java.lang.Throwable -> L42
                if (r1 == 0) goto L16
                java.lang.String r1 = e0.b.f8548b     // Catch: java.lang.Throwable -> L42
                java.lang.String r2 = "onChangeToBack, record data"
                java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L42
                e0.e.d(r1, r2)     // Catch: java.lang.Throwable -> L42
            L16:
                java.lang.String r1 = "APM-Battery"
                java.lang.String r2 = "ToBackIn"
                e0.a.d(r1, r2)     // Catch: java.lang.Throwable -> L42
                k.a r1 = r4.f9955c     // Catch: java.lang.Throwable -> L42
                r2 = 1
                boolean r1 = k.a.z(r1, r2)     // Catch: java.lang.Throwable -> L42
                k.a r2 = r4.f9955c     // Catch: java.lang.Throwable -> L42
                java.util.Map r2 = k.a.x(r2)     // Catch: java.lang.Throwable -> L42
                java.util.Collection r2 = r2.values()     // Catch: java.lang.Throwable -> L42
                java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L42
            L32:
                boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L42
                if (r3 == 0) goto L48
                java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L42
                q.l r3 = (q.l) r3     // Catch: java.lang.Throwable -> L42
                r3.b(r1)     // Catch: java.lang.Throwable -> L42
                goto L32
            L42:
                r1 = move-exception
                java.lang.String r2 = "recordBackgroundData"
                t4.a.d(r1, r2)     // Catch: java.lang.Throwable -> L50
            L48:
                k.a r4 = r4.f9955c     // Catch: java.lang.Throwable -> L50
                r1 = 0
                k.a.B(r4, r1)     // Catch: java.lang.Throwable -> L50
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L50
                return
            L50:
                r4 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L50
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: k.a.c.run():void");
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f9956c;

        d(a r10) {
            this.f9956c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r10 = a.v();
            monitor-enter(r10);
            boolean r11 = true;
            if (com.bytedance.apm.d.D() == false) goto L7;
            e0.e.d(e0.b.f8548b, new String[]{"onTimer record, current is background? : " + ActivityLifeObserver.getInstance().isForeground()});     // Catch: Throwable -> L22
        L7:
            e0.a.d("APM-Battery", "OnTimerIn");     // Catch: Throwable -> L22
            boolean r12 = a.z(this.f9956c, true);     // Catch: Throwable -> L22
            Iterator r13 = a.x(this.f9956c).values().iterator();     // Catch: Throwable -> L22
        L9:
            if (r13.hasNext() == false) goto L11;
            ((l) r13.next()).a(r12);     // Catch: Throwable -> L22
            goto L9
        L11:
            long r14 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L22
            if (a.o(this.f9956c) == true) goto L14;
        L24:
            monitor-exit(r10);     // Catch: Throwable -> L26
            return;
        L14:
            if ((r14 - a.p(this.f9956c)) > (a.r(this.f9956c) * VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER)) goto L18;
            r11 = false;
        L18:
            if (com.bytedance.apm.d.I() == false) goto L24;
            if (r11 == false) goto L24;
            p.a.h().k(false);     // Catch: Throwable -> L22
            a.q(this.f9956c, r14);     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            t4.a.d(th, "onStart");     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            throw th;
        }
    }

    class e implements z3.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f9957c;

        e(a r10) {
            this.f9957c = r10;
        }

        @Override // z3.d
        public AsyncTaskType J() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        @Override // z3.d
        public String P() {
            return "BatteryCollector-mTimerRunnable";
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9957c.i();
        }
    }

    class f implements Comparator<v> {
        f(a r10) {
        }

        public int a(v r10, v r11) {
            return (int) (r11.f1151c - r10.f1151c);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(v r10, v r11) {
            return a(r10, r11);
        }
    }

    class g implements z3.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f9958c;

        g(a r10) {
            this.f9958c = r10;
        }

        @Override // z3.d
        public AsyncTaskType J() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        @Override // z3.d
        public String P() {
            return "BatteryCollector-UpdateThreadRecord";
        }

        @Override // java.lang.Runnable
        public void run() {
            a.s(this.f9958c);     // Catch: Throwable -> L15
            if (a.A(this.f9958c) == false) goto L10;
            if (a.t(this.f9958c).containsKey("cpu_monitor_thread_front_capture_period") == false) goto L8;
            Integer r10 = (Integer) a.t(this.f9958c).get("cpu_monitor_thread_front_capture_period");     // Catch: Throwable -> L15
        L7:
            int r11 = r10.intValue();     // Catch: Throwable -> L15
        L13:
            q0.b.f().e(a.u(this.f9958c), r11 * 1000);     // Catch: Throwable -> L15
            return;
        L8:
            r11 = 5;
            goto L13
        L10:
            if (a.t(this.f9958c).containsKey("cpu_monitor_thread_background_capture_period") == false) goto L12;
            r10 = (Integer) a.t(this.f9958c).get("cpu_monitor_thread_background_capture_period");     // Catch: Throwable -> L15
            goto L7
        L12:
            r11 = 20;
        L15:
            th = move-exception;
            t4.a.d(th, "mUpdateThreadRecordRunnable");
        }
    }

    private static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f9959a = null;

        static {
            f9959a = new a(null);
        }

        static /* synthetic */ a a() {
            return f9959a;
        }
    }

    static {
        H = new Object();
    }

    private a() {
        this.f9937l = new ConcurrentHashMap();
        this.f9938m = -1;
        this.f9940o = false;
        this.f9942q = 30;
        this.f9943r = -1;
        this.f9947v = 32;
        this.f9949x = new String[2];
        new ArrayList();
        this.f9951z = new HashMap();
        this.A = new HashMap();
        this.C = new HashMap();
        this.F = new e(this);
        this.G = new g(this);
        this.f9290j = Scraps.BATTERY;
    }

    /* synthetic */ a(RunnableC0210a r10) {
        this();
    }

    static /* synthetic */ boolean A(a r10) {
        return r10.f9939n;
    }

    static /* synthetic */ boolean B(a r10, boolean r11) {
        r10.f9939n = r11;
        return r11;
    }

    private boolean C() {
        if (BatteryAgent.hasHook() == false) goto L5;
        return true;
    L5:
        if (this.C.containsKey("monitor_enable") == true) goto L7;
    L9:
        return false;
    L7:
        if (this.C.get("monitor_enable").intValue() != 1) goto L9;
        return true;
    }

    public static a G() {
        return h.a();
    }

    private boolean I() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 >= 21) goto L5;
    L8:
        return true;
    L5:
        if (r10 > this.f9947v) goto L8;
        return false;
    }

    private boolean K(long r10) {
        if (this.f9939n == false) goto L12;
        int r11 = 20;
        if (this.C.containsKey("cpu_monitor_front_valid_duration") == false) goto L8;
        r11 = this.C.get("cpu_monitor_front_valid_duration").intValue();
    L8:
        if (r10 <= (r11 * 1000)) goto L11;
        return true;
    L11:
        return false;
    L12:
        int r12 = 60;
        if (this.C.containsKey("cpu_monitor_background_duration") == false) goto L16;
        r12 = this.C.get("cpu_monitor_background_duration").intValue();
    L16:
        if (r10 <= (r12 * 1000)) goto L19;
        return true;
    L19:
        return false;
    }

    private void L(long r13) {
        if (this.f9939n == false) goto L5;
    L11:
        String r10 = "cpu_monitor_function_front_threshold";
        if (this.C.containsKey("cpu_monitor_function_front_threshold") == false) goto L14;
    L13:
        int r11 = this.C.get(r10).intValue();
    L15:
        Map<String, BatteryAgent.a> r12 = BatteryAgent.filterResultAndClear((((long) r11) * r13) / 100);
        if (K(r13) == false) goto L45;
        JSONObject r14 = new JSONObject();
        int r15 = 0;
        boolean r16 = true;
        if (r12 != null) goto L20;
    L26:
        boolean r17 = false;
    L28:
        if (this.A.isEmpty() == true) goto L38;
        ArrayList r18 = new ArrayList(this.A.values());
        Collections.sort(r18, new f(this));
        JSONArray r19 = new JSONArray();
        int r20 = 100;
        if (this.C.containsKey("cpu_monitor_thread_count") == false) goto L33;
        r20 = this.C.get("cpu_monitor_thread_count").intValue();
    L33:
        if (r15 >= Math.min(r18.size(), r20)) goto L37;
        v r21 = (v) r18.get(r15);
        if (r21.f1151c <= 0) goto L37;
        JSONObject r22 = new JSONObject();
        r15 = r15 + 1;
        r22.putOpt("rank", Integer.valueOf(r15));
        r22.putOpt("thread_name", r21.f1150b);
        r22.putOpt("cpu_cost", Long.valueOf(r21.f1151c));
        r19.put(r22);
    L37:
        r14.putOpt("threads", r19);
    L39:
        if (r16 == false) goto L45;
        if (this.f9939n == false) goto L43;
        String r23 = p.a.h().g();
    L44:
        JSONObject r24 = new JSONObject();
        r24.putOpt("scene", r23);
        JSONObject r25 = new JSONObject();
        r25.putOpt("stay_duration", Long.valueOf(r13));
        e0.a.d("APM-BatteryLocal", "scene:" + r23 + " stayDuration:" + r13 + " data:" + r14);
        com.bytedance.apm.c.h("monitor_expend_function", r24, r25, r14);
        goto L45
    L43:
        r23 = "background";
        goto L44
    L38:
        r16 = r17;
        goto L39
    L20:
        if (r12.isEmpty() == true) goto L26;
        JSONArray r26 = new JSONArray();
        Iterator<Map.Entry<String, BatteryAgent.a>> r27 = r12.entrySet().iterator();
    L23:
        if (r27.hasNext() == false) goto L25;
        Map.Entry<String, BatteryAgent.a> r28 = r27.next();
        JSONObject r29 = new JSONObject();
        r29.putOpt(EnsureReportData.METHOD, r28.getKey());
        r29.putOpt("exe_count", Integer.valueOf(r28.getValue().d()));
        r29.putOpt("cpu_cost", Integer.valueOf(r28.getValue().c()));
        r26.put(r29);
        goto L23
    L25:
        r14.putOpt("functions", r26);
        r17 = true;
    L45:
        Q();
        return;
    L14:
        r11 = 5;
        goto L15
    L5:
        if (TextUtils.isEmpty(this.f9950y) == false) goto L11;
        r10 = "cpu_monitor_function_background_threshold";
        if (this.C.containsKey("cpu_monitor_function_background_threshold") == true) goto L13;
        r11 = 2;
        goto L15
    }

    private void M() {
        if (I() == false) goto L5;
        return;
    L5:
        e0.a.d("APM-Battery", "ToBack");
        p.a.h().p(ActivityLifeObserver.getInstance().getTopActivityClassName());
        q0.b.f().d(new c(this));
    }

    private void N(String r10) {
        if (I() == false) goto L5;
        return;
    L5:
        e0.a.d("APM-Battery", "ToFront:" + r10);
        p.a.h().p(r10);
        q0.b.f().d(new b(this));
    }

    private boolean O() {
        return P(false);
    }

    private boolean P(boolean r19) {
        long r10 = SystemClock.elapsedRealtime();
        long r11 = r10 - this.f9938m;
        if (r11 <= 2000) goto L5;
        boolean r12 = true;
    L6:
        boolean r14 = r12;
        if (this.f9938m == (-1)) goto L14;
        if (r14 == false) goto L14;
        boolean r17 = r14;
        p.a.h().l(new b0.a(this.f9939n, System.currentTimeMillis(), "ground_record", this.D, r11, this.f9950y));
        if (this.f9939n == false) goto L16;
        if (r11 <= 7200000) goto L16;
        HashMap r13 = new HashMap();
        r13.put("duration", String.valueOf(r11));
        t4.a.b("BatterErrorDuration", r13);
    L16:
        if (this.f9938m == (-1)) goto L21;
        if (r19 == false) goto L21;
        if (C() == false) goto L21;
        L(r11);
    L21:
        this.f9938m = r10;
        return r17;
    L14:
        r17 = r14;
        goto L16
    L5:
        r12 = false;
        goto L6
    }

    private void Q() {
        this.f9951z.clear();
        this.A.clear();
        LinkedList<v> r10 = com.bytedance.apm.util.b.l(Process.myPid());
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L13;
        Iterator<v> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L14;
        v r12 = r11.next();
        this.f9951z.put(Integer.valueOf(r12.f1149a), r12);
        goto L9
    L14:
        return;
    }

    private void R() {
        if (this.f9951z.isEmpty() == false) goto L5;
        return;
    L5:
        LinkedList<v> r10 = com.bytedance.apm.util.b.l(Process.myPid());
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.isEmpty() == true) goto L32;
        Iterator<v> r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L33;
        v r12 = r11.next();
        if (this.f9951z.containsKey(Integer.valueOf(r12.f1149a)) == false) goto L16;
        long r13 = r12.f1151c - this.f9951z.get(Integer.valueOf(r12.f1149a)).f1151c;
    L18:
        if (r13 <= 0) goto L12;
        long r14 = (long) ((r13 / this.B) * 1000.0d);
        if (this.A.containsKey(Integer.valueOf(r12.f1149a)) == true) goto L21;
        this.A.put(Integer.valueOf(r12.f1149a), new v(r12.f1149a, r12.f1150b, r14));
        goto L12
    L21:
        this.A.get(Integer.valueOf(r12.f1149a)).a(r14);
        goto L12
    L16:
        r13 = r12.f1151c;
        goto L18
    L33:
        return;
    }

    static /* synthetic */ boolean o(a r10) {
        return r10.f9940o;
    }

    static /* synthetic */ long p(a r10) {
        return r10.f9943r;
    }

    static /* synthetic */ long q(a r10, long r11) {
        r10.f9943r = r11;
        return r11;
    }

    static /* synthetic */ long r(a r10) {
        return r10.f9942q;
    }

    static /* synthetic */ void s(a r10) {
        r10.R();
    }

    static /* synthetic */ HashMap t(a r10) {
        return r10.C;
    }

    static /* synthetic */ z3.d u(a r10) {
        return r10.G;
    }

    static /* synthetic */ Object v() {
        return H;
    }

    static /* synthetic */ boolean w(a r10) {
        return r10.O();
    }

    static /* synthetic */ Map x(a r10) {
        return r10.f9937l;
    }

    static /* synthetic */ boolean y(a r10, boolean r11) {
        r10.D = r11;
        return r11;
    }

    static /* synthetic */ boolean z(a r10, boolean r11) {
        return r10.P(r11);
    }

    public Map<String, l> D() {
        return this.f9937l;
    }

    public String E() {
        return this.f9950y;
    }

    public BatteryExceptionListener F() {
        return this.E;
    }

    public void H(boolean r10) {
        this.f9945t = r10;
        d();
    }

    public boolean J() {
        return this.f9946u;
    }

    @Override // s.a.b
    public void a(boolean r10) {
        if (this.f9937l.isEmpty() == false) goto L5;
        return;
    L5:
        p.a.h().p(ActivityLifeObserver.getInstance().getTopActivityClassName());
        q0.b.f().d(new RunnableC0210a(this, r10));
    }

    @Override // i0.a
    protected void c(JSONObject r13) {
        this.f9941p = r13.optLong("battery_record_interval", 10);
        this.f9942q = r13.optLong("battery_report_interval", 30);
        int r10 = r13.optInt(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD, 0);
        boolean r11 = true;
        if (r10 == 1) goto L5;
    L7:
        boolean r12 = false;
    L8:
        this.f9940o = r12;
        this.f9947v = r13.optInt("support_max_api_level", this.f9947v);
        if (com.bytedance.apm.d.D() == false) goto L12;
        e0.e.c(e0.b.f8548b, new String[]{"mRecordInterval:" + this.f9941p + ",mBatteryCollectEnabled" + r10});
    L12:
        if (this.f9940o == true) goto L17;
        if (this.f9945t == true) goto L17;
        this.f9937l.clear();
        ActivityLifeObserver.getInstance().unregister(this);
        s.a.g(com.bytedance.apm.d.g(), this);
    L20:
        if (r13.optInt("trace_enable", 0) == 1) goto L23;
        r11 = false;
    L23:
        this.f9946u = r11;
        if (this.f9946u == false) goto L26;
        l.a.k(r13.optLong("max_single_wake_lock_hold_time_second", 120) * 1000);
        l.a.n(r13.optInt("max_total_wake_lock_acquire_count", 5));
        l.a.o(r13.optLong("max_total_wake_lock_hold_time_second", 240) * 1000);
        l.a.p(r13.optInt("max_wake_up_alarm_invoke_count", 5));
        l.a.i(r13.optInt("max_normal_alarm_invoke_count", 10));
        l.a.j(r13.optLong("max_single_loc_request_time_second", 120) * 1000);
        l.a.l(r13.optInt("max_total_loc_request_count", 5));
        l.a.m(r13.optLong("max_total_loc_request_time_second", 240) * 1000);
    L26:
        JSONObject r14 = r13.optJSONObject("cpu_monitor_config");
        if (r14 == null) goto L37;
        Iterator<String> r15 = r14.keys();
    L30:
        if (r15.hasNext() == false) goto L37;
        String r16 = r15.next();
        if ("monitor_enable".equals(r16) == true) goto L33;
        int r17 = r14.optInt(r16, 0);
        if (r17 <= 0) goto L30;
        this.C.put(r16, Integer.valueOf(r17));
        goto L30
    L33:
        this.C.put(r16, Integer.valueOf(r14.optInt(r16, 0)));
    L37:
        this.f9944s = p.d(r13, "scene_black_list");
        if (C() == false) goto L49;
        q0.b.f().d(this.G);
        Q();
        return;
    L49:
        return;
    L17:
        if (r13.optInt("battery_net_for_all_interface_enable", 0) != 1) goto L20;
        this.f9937l.put("traffic_all_interface", new i());
        goto L20
    L5:
        if (this.f9941p <= 0) goto L7;
        r12 = true;
        goto L8
    }

    @Override // i0.a
    protected boolean f() {
        return false;
    }

    @Override // i0.a
    public void h() {
        if (I() == false) goto L5;
        return;
    L5:
        e0.a.d("APM-Battery", "Battery init process" + com.bytedance.apm.d.h());
        this.f9939n = ActivityLifeObserver.getInstance().isForeground();
        this.f9949x[1] = ActivityLifeObserver.getInstance().getTopActivityClassName();
        this.B = com.bytedance.apm.util.b.k(100);
        this.D = s.a.d(com.bytedance.apm.d.g(), this);
        q.d r10 = new q.d();
        q.g r11 = new q.g();
        k r12 = new k();
        o.a r13 = new o.a();     // Catch: Throwable -> L8
        r13.a(NotificationCompat.CATEGORY_ALARM, r10);     // Catch: Throwable -> L8
        r13.a("location", r11);     // Catch: Throwable -> L8
        r13.a("power", r12);     // Catch: Throwable -> L8
        r13.b();     // Catch: Throwable -> L8
        this.f9937l.put(NotificationCompat.CATEGORY_ALARM, r10);     // Catch: Throwable -> L8
        this.f9937l.put("location", r11);     // Catch: Throwable -> L8
        this.f9937l.put("power", r12);     // Catch: Throwable -> L8
    L10:
        q.f r14 = new q.f();
        j r15 = new j();
        q.h r16 = new q.h();
        q.e r17 = new q.e();
        this.f9937l.put("cpu_active_time", r14);
        this.f9937l.put("traffic", r15);
        this.f9937l.put("traffic_packets", r16);
        this.f9937l.put("battery_consume", r17);
        this.f9943r = SystemClock.elapsedRealtime();
        return;
    L8:
        th = move-exception;
        e0.a.a("APM-Battery", "SYSTEM_SERVICE_FETCHERS hook failed: " + th.getMessage());
        goto L10
    }

    @Override // i0.a
    public void i() {
        if (I() == false) goto L5;
        return;
    L5:
        if (this.f9937l.isEmpty() == true) goto L13;
        e0.a.d("APM-Battery", "OnTimer");
        long r10 = n();
        if (r10 <= 0) goto L10;
        q0.b.f().e(this.F, r10);
    L10:
        p.a.h().p(ActivityLifeObserver.getInstance().getTopActivityClassName());
        q0.b.f().d(new d(this));
        return;
    }

    @Override // i0.a
    protected long n() {
        return this.f9941p * VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
    }

    @Override // i0.a, t4.d
    public void onActivityResume(Activity r10) {
        super.onActivityResume(r10);
        String[] r11 = this.f9949x;
        r11[0] = r11[1];
        r11[1] = r10.getClass().getName();
        if (TextUtils.equals(r10.getClass().getName(), this.f9948w) == false) goto L5;
    L7:
        this.f9948w = null;
        return;
    L5:
        if (TextUtils.isEmpty(this.f9949x[0]) == true) goto L7;
        N(this.f9949x[0]);
        goto L7
    }

    @Override // i0.a, t4.d
    public void onBackground(Activity r10) {
        super.onBackground(r10);
        M();
    }

    @Override // i0.a, t4.d
    public void onFront(Activity r10) {
        super.onFront(r10);
        this.f9948w = r10.getClass().getName();
        N(ActivityLifeObserver.getInstance().getTopActivityClassName());
    }

    @Override // i0.a, u4.a
    public void onReady() {
        super.onReady();
        if (com.bytedance.apm.d.I() == true) goto L5;
        return;
    L5:
        if (this.f9940o == false) goto L9;
        p.a.h().k(true);
        this.f9943r = SystemClock.elapsedRealtime();
        return;
    }
}
