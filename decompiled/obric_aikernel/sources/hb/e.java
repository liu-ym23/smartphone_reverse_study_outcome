package hb;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import jb.u;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class e extends hb.c.a implements u {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static volatile SQLiteDatabase f9205m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f9206n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile HashMap<String, Integer> f9207o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f9208p = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private hb.g f9209c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private hb.g f9210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f9211h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9212i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f9213j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f9214k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    hb.b f9215l;

    class a implements s<List<DownloadInfo>> {
        a(e r10) {
        }

        public List<DownloadInfo> a() {
            return new ArrayList();
        }

        @Override // hb.e.s
        public /* bridge */ /* synthetic */ List<DownloadInfo> getDefaultValue() {
            return a();
        }
    }

    class b implements Callable<List<DownloadInfo>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f9216c;

        b(e r10) {
            this.f9216c = r10;
        }

        public List<DownloadInfo> a() {
            return e.D2(this.f9216c);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<DownloadInfo> call() {
            return a();
        }
    }

    class c implements s<List<DownloadInfo>> {
        c(e r10) {
        }

        public List<DownloadInfo> a() {
            return new ArrayList();
        }

        @Override // hb.e.s
        public /* bridge */ /* synthetic */ List<DownloadInfo> getDefaultValue() {
            return a();
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DownloadInfo f9217c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f9218g;

        d(e r10, DownloadInfo r11) {
            this.f9218g = r10;
            this.f9217c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.r2(this.f9218g);
            if (e.s2() != null) goto L5;
            return;
        L5:
            if (e.F2(this.f9218g) == null) goto L15;
            e r10 = this.f9218g;     // Catch: Throwable -> L9
            e.G2(r10, this.f9217c, e.F2(r10).c());     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            th.printStackTrace();
            lb.a.h("SqlDownloadCache", this.f9217c.getId(), "addDownloadInfo", "Error:" + th);
            return;
        }
    }

    /* JADX INFO: renamed from: hb.e$e, reason: collision with other inner class name */
    class RunnableC0180e implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DownloadInfo f9219c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f9220g;

        RunnableC0180e(e r10, DownloadInfo r11) {
            this.f9220g = r10;
            this.f9219c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.r2(this.f9220g);
            if (e.s2() != null) goto L5;
            return;
        L5:
            e.H2(this.f9220g, this.f9219c);
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f9221c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f9222g;

        f(e r10, int r11) {
            this.f9222g = r10;
            this.f9221c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.r2(this.f9222g);
            if (e.s2() != null) goto L5;
            return;
        L5:
            if (e.F2(this.f9222g) == null) goto L15;
            e r10 = this.f9222g;     // Catch: Throwable -> L9
            e.I2(r10, this.f9221c, e.F2(r10).a());     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            th.printStackTrace();
            lb.a.h("SqlDownloadCache", this.f9221c, "removeDownloadInfo", "Error:" + th);
            return;
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f9223c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f9224g;

        g(e r10, int r11) {
            this.f9224g = r10;
            this.f9223c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9224g.h(this.f9223c);
            this.f9224g.f2(this.f9223c);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f9225c;

        h(e r10) {
            this.f9225c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.r2(this.f9225c);
            if (e.s2() != null) goto L5;
            return;
        L5:
            e.J2(this.f9225c);
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f9226c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ContentValues f9227g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ e f9228h;

        i(e r10, int r11, ContentValues r12) {
            this.f9228h = r10;
            this.f9226c = r11;
            this.f9227g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.r2(this.f9228h);
            if (e.s2() != null) goto L5;
            return;
        L5:
            e.K2(this.f9228h, this.f9226c, this.f9227g);
        }
    }

    class j implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SparseArray f9229c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ hb.d f9230g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ HashMap f9231h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f9232i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ List f9233j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ e f9234k;

        j(e r10, SparseArray r11, hb.d r12, HashMap r13, List r14, List r15) {
            this.f9234k = r10;
            this.f9229c = r11;
            this.f9230g = r12;
            this.f9231h = r13;
            this.f9232i = r14;
            this.f9233j = r15;
        }

        /*  JADX ERROR: Type inference failed
            jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 15571. Try increasing type updates limit count.
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
            */
        @Override // java.lang.Runnable
        public void run() {
            /*  JADX ERROR: Simple mode code generation failed
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002e: INVOKE (r3v43 ?? I:rb.a) =  STATIC call: rb.a.j():rb.a A[DECLARE_VAR, MD:():rb.a (m)] in method: hb.e.j.run():void, file: classes2.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
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
                Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
                	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
                	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
                	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
                	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
                	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
                	... 48 more
                */
            /*
                Method dump skipped, instruction units count: 1557
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: hb.e.j.run():void");
        }
    }

    class k implements Callable<DownloadInfo> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f9235c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f9236g;

        k(e r10, int r11) {
            this.f9236g = r10;
            this.f9235c = r11;
        }

        public DownloadInfo a() {
            return e.y2(this.f9236g, this.f9235c);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ DownloadInfo call() {
            return a();
        }
    }

    class l implements Callable<List<DownloadInfo>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f9237c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f9238g;

        l(e r10, String r11) {
            this.f9238g = r10;
            this.f9237c = r11;
        }

        public List<DownloadInfo> a() {
            return e.z2(this.f9238g, this.f9237c);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<DownloadInfo> call() {
            return a();
        }
    }

    class m implements s<List<DownloadInfo>> {
        m(e r10) {
        }

        public List<DownloadInfo> a() {
            return new ArrayList();
        }

        @Override // hb.e.s
        public /* bridge */ /* synthetic */ List<DownloadInfo> getDefaultValue() {
            return a();
        }
    }

    class n implements Callable<List<DownloadInfo>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f9239c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f9240g;

        n(e r10, String r11) {
            this.f9240g = r10;
            this.f9239c = r11;
        }

        public List<DownloadInfo> a() {
            return e.A2(this.f9240g, this.f9239c);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<DownloadInfo> call() {
            return a();
        }
    }

    class o implements s<List<DownloadInfo>> {
        o(e r10) {
        }

        public List<DownloadInfo> a() {
            return new ArrayList();
        }

        @Override // hb.e.s
        public /* bridge */ /* synthetic */ List<DownloadInfo> getDefaultValue() {
            return a();
        }
    }

    class p implements Callable<List<DownloadInfo>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f9241c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f9242g;

        p(e r10, String r11) {
            this.f9242g = r10;
            this.f9241c = r11;
        }

        public List<DownloadInfo> a() {
            return e.B2(this.f9242g, this.f9241c);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<DownloadInfo> call() {
            return a();
        }
    }

    class q implements s<List<DownloadInfo>> {
        q(e r10) {
        }

        public List<DownloadInfo> a() {
            return new ArrayList();
        }

        @Override // hb.e.s
        public /* bridge */ /* synthetic */ List<DownloadInfo> getDefaultValue() {
            return a();
        }
    }

    class r implements Callable<List<DownloadInfo>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f9243c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f9244g;

        r(e r10, String r11) {
            this.f9244g = r10;
            this.f9243c = r11;
        }

        public List<DownloadInfo> a() {
            return e.C2(this.f9244g, this.f9243c);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<DownloadInfo> call() {
            return a();
        }
    }

    private interface s<T> {
        T getDefaultValue();
    }

    static {
        f9206n = i3();
        f9207o = null;
        f9208p = j3();
    }

    public e() {
        this(false);
    }

    public e(boolean r10) {
        this.f9214k = false;
        this.f9215l = null;
        if (r10 == true) goto L5;
        return;
    L5:
        this.f9211h = false;
        A(false);
    }

    static /* synthetic */ List A2(e r10, String r11) {
        return r10.m3(r11);
    }

    private void A3(DownloadInfo r10, SQLiteStatement r11) {
        if (r10 == null) goto L19;
        if (r11 == null) goto L21;
        monitor-enter(r11);     // Catch: Throwable -> L12
        r10.bindValue(r11);     // Catch: Throwable -> L9
        r11.bindLong(r10.getBindValueCount() + 1, r10.getId());     // Catch: Throwable -> L9
        r11.execute();     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
    L20:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        lb.a.h("SqlDownloadCache", r10.getId(), "updateDownloadInfoInner", "Error:" + th);
        return;
    L21:
        return;
    }

    static /* synthetic */ List B2(e r10, String r11) {
        return r10.n3(r11);
    }

    private void B3(int r10, ContentValues r11) {
        int r12 = 10;
    L17:
    L14:
        th = move-exception;
        th.printStackTrace();
        lb.a.h("SqlDownloadCache", r10, "updateInner", "Error2:" + th);
        return;
    L4:
        if (f9205m.isDbLockedByCurrentThread() == false) goto L12;
        r12 = r12 - 1;
        if (r12 < 0) goto L12;
        Thread.sleep(5);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        lb.a.h("SqlDownloadCache", r10, "updateInner", "Error:" + th);     // Catch: Throwable -> L14
    L12:
        f9205m.update("downloader", r11, "_id = ? ", new String[]{String.valueOf(r10)});     // Catch: Throwable -> L14
    }

    static /* synthetic */ List C2(e r10, String r11) {
        return r10.g3(r11);
    }

    static /* synthetic */ List D2(e r10) {
        return r10.d3();
    }

    static /* synthetic */ boolean E2(e r10, boolean r11) {
        r10.f9211h = r11;
        return r11;
    }

    static /* synthetic */ hb.g F2(e r10) {
        return r10.f9209c;
    }

    static /* synthetic */ void G2(e r10, DownloadInfo r11, SQLiteStatement r12) {
        r10.p3(r11, r12);
    }

    static /* synthetic */ void H2(e r10, DownloadInfo r11) {
        r10.z3(r11);
    }

    static /* synthetic */ void I2(e r10, int r11, SQLiteStatement r12) {
        r10.b3(r11, r12);
    }

    static /* synthetic */ void J2(e r10) {
        r10.Z2();
    }

    static /* synthetic */ void K2(e r10, int r11, ContentValues r12) {
        r10.B3(r11, r12);
    }

    static /* synthetic */ int L2(e r10) {
        return r10.f9212i;
    }

    static /* synthetic */ int M2(e r10, int r11) {
        r10.f9212i = r11;
        return r11;
    }

    static /* synthetic */ long N2(e r10) {
        return r10.f9213j;
    }

    static /* synthetic */ long O2(e r10, long r11) {
        r10.f9213j = r11;
        return r11;
    }

    static /* synthetic */ boolean P2(e r10, boolean r11) {
        r10.f9214k = r11;
        return r11;
    }

    static /* synthetic */ void Q2(e r10, com.ss.android.socialbase.downloader.model.c r11, SparseArray r12, HashMap r13, List r14, List r15, hb.d r16, com.ss.android.socialbase.downloader.cleaner.a r17) {
        r10.s3(r11, r12, r13, r14, r15, r16, r17);
    }

    static /* synthetic */ void R2() {
        h3();
    }

    static /* synthetic */ boolean S2(e r10, DownloadInfo r11, boolean r12, long r13) {
        return r10.W2(r11, r12, r13);
    }

    static /* synthetic */ boolean T2(e r10, DownloadInfo r11, boolean r12, boolean r13) {
        return r10.o3(r11, r12, r13);
    }

    private void U2(DownloadInfo r10) {
        com.ss.android.socialbase.downloader.downloader.a.I0(new d(this, r10));
    }

    private void V2(boolean r10, List<DownloadInfo> r11, SparseArray<DownloadInfo> r12, SparseArray<DownloadInfo> r13, HashMap<Integer, Integer> r14, List<DownloadInfo> r15, hb.d r16) {
        if (lb.a.a() == false) goto L5;
        lb.a.b("SqlDownloadCache", "callbackDownloadInfo", "Run");
    L5:
        Y2(r11);
        r3(r11, r12);
        if (lb.a.a() == false) goto L8;
        lb.a.b("SqlDownloadCache", "callbackDownloadInfo", "Run Callback:" + r16);
    L8:
        if (r16 == null) goto L10;
        r16.a(r10);
    L10:
        t3(r13, r14, r15, r10);
        r12.clear();
        r11.clear();
        r13.clear();
        if (r10 == false) goto L21;
        return;
    L21:
    L18:
        th = move-exception;
        th.printStackTrace();
        lb.a.c("SqlDownloadCache", "newInit", "Sleep:" + th);
        return;
    L14:
        if (lb.a.a() == false) goto L16;
        lb.a.b("SqlDownloadCache", "newInit", "Sleep:" + this.f9213j);     // Catch: Throwable -> L18
    L16:
        Thread.sleep(this.f9213j);     // Catch: Throwable -> L18
    }

    private boolean W2(DownloadInfo r10, boolean r11, long r12) {
        if (this.f9214k == true) goto L5;
    L12:
        if (r11 == false) goto L21;
        if (kb.b.n() == false) goto L21;
        if (kb.b.p(r10.getSavePath()) == true) goto L21;
        if (kb.b.o(r10.getSavePath()) == false) goto L21;
        return true;
    L21:
        if (r12 > 0) goto L23;
    L28:
        return false;
    L23:
        if (r10.getStatus() == (-3)) goto L28;
        if ((r10.getLastDownloadTime() + (r12 * 1000)) >= System.currentTimeMillis()) goto L28;
        com.ss.android.socialbase.downloader.utils.g.j(r10, false);
        return true;
    L5:
        if (r10.getCacheLifeTimeMax() <= 0) goto L12;
        if (r10.getDownloadStartTimeStamp() <= 0) goto L12;
        if ((r10.getDownloadStartTimeStamp() + (r10.getCacheLifeTimeMax() * 1000)) >= System.currentTimeMillis()) goto L12;
        com.ss.android.socialbase.downloader.utils.g.j(r10, true);
        return true;
    }

    private void X2(DownloadInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = r10.getStatusAtDbInit();
        if (r11 >= 1) goto L7;
        return;
    L7:
        if (r11 > 11) goto L11;
        mb.a.m(com.ss.android.socialbase.downloader.downloader.a.y(), null, r10, null, -5);
        return;
    }

    private void Y2(List<DownloadInfo> r10) {
        if (r10 != null) goto L16;
        return;
    L16:
        Iterator<DownloadInfo> r11 = r10.iterator();     // Catch: Throwable -> L13
    L6:
        if (r11.hasNext() == false) goto L25;
        DownloadInfo r12 = r11.next();     // Catch: Throwable -> L13
        if (r12 == null) goto L6;
        if (r12.isSavePathRedirected() == false) goto L6;
        com.ss.android.socialbase.downloader.utils.g.g(r12);     // Catch: Throwable -> L13
        goto L6
    L25:
        return;
    L13:
        th = move-exception;
        lb.a.c("SqlDownloadCache", "clearAntiHijackDirIfNeeded", "Error:" + th);
    }

    private synchronized void Z2() {
        monitor-enter(this);
        w3();     // Catch: Throwable -> L6
        f9205m.delete("downloader", null, null);     // Catch: Throwable -> L6
        f9205m.setTransactionSuccessful();     // Catch: Throwable -> L6
    L4:
        x3();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L11
        lb.a.c("SqlDownloadCache", "clearDataInSubThread", "Error:" + th);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        x3();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private void a3() {
        if (f9205m != null) goto L10;
        return;
    L10:
        f9205m.execSQL("DROP TABLE IF EXISTS downloadChunk");     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        lb.a.c("SqlDownloadCache", "deleteChunkTable", "Error:" + th);
    }

    private void b3(int r10, SQLiteStatement r11) {
        if (r11 != null) goto L15;
        return;
    L15:
        monitor-enter(r11);     // Catch: Throwable -> L12
        r11.bindLong(1, r10);     // Catch: Throwable -> L9
        r11.execute();     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
    L18:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        lb.a.h("SqlDownloadCache", r10, "deleteInner", "Error:" + th);
    }

    private void c3() {
        if (f9205m == null) goto L5;
        return;
    L5:
        monitor-enter(e.class);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (f9205m == null) goto L24;
    L17:
        monitor-exit(e.class);     // Catch: Throwable -> L19
        return;
    L24:
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L19
        lb.a.c("SqlDownloadCache", "ensureDataBaseInit", "Error:" + th);     // Catch: Throwable -> L19
        goto L17
    L9:
        if (com.ss.android.socialbase.downloader.downloader.a.h() != null) goto L13;
        lb.a.c("SqlDownloadCache", "ensureDataBaseInit", "Context is null");     // Catch: Throwable -> L15
        monitor-exit(e.class);     // Catch: Throwable -> L19
        return;
    L13:
        f9205m = hb.a.f().getWritableDatabase();     // Catch: Throwable -> L15
        this.f9209c = new hb.g(f9205m, "downloader", ab.a.f124a, ab.a.f125b);     // Catch: Throwable -> L15
        this.f9210g = new hb.g(f9205m, "segments", ab.a.f126c, ab.a.f127d);     // Catch: Throwable -> L15
        goto L17
    }

    private List<DownloadInfo> d3() {
        c3();
        ArrayList r10 = new ArrayList();
        if (f9205m == null) goto L17;
        Cursor r11 = null;
        r11 = f9205m.rawQuery(String.format("SELECT * FROM %s", new Object[]{"downloader"}), null);     // Catch: Throwable -> L11
    L7:
        if (r11.moveToNext() == false) goto L10;
        r10.add(com.ss.android.socialbase.downloader.utils.c.S(r11));     // Catch: Throwable -> L11
        goto L7
    L10:
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r11});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        lb.a.c("SqlDownloadCache", "getAllDownloadInfoImpl", "Error:" + th);     // Catch: Throwable -> L14
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r11});
    L14:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r11});
        throw th;
    L17:
        return r10;
    }

    private DownloadInfo e3(int r10) {
        c3();
        if (f9205m != null) goto L24;
    L21:
        return null;
    L24:
        Cursor r11 = f9205m.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[]{"downloader", "_id"}), new String[]{Integer.toString(r10)});     // Catch: Throwable -> L14
    L12:
        th = th;
    L26:
        th.printStackTrace();     // Catch: Throwable -> L18
        lb.a.h("SqlDownloadCache", r10, "getDownloadInfoImpl", "Error:" + th);     // Catch: Throwable -> L18
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r11});
    L18:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r11});
        throw th;
    L7:
        if (r11.moveToNext() == false) goto L11;
        DownloadInfo r12 = com.ss.android.socialbase.downloader.utils.c.S(r11);     // Catch: Throwable -> L12
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r11});
        return r12;
    L11:
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r11});
    L14:
        th = th;
        r11 = null;
        goto L26
    }

    private List<DownloadInfo> f3(String r10) {
        c3();
        ArrayList r11 = new ArrayList();
        if (f9205m == null) goto L17;
        Cursor r12 = null;
        r12 = f9205m.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[]{"downloader", "url"}), new String[]{r10});     // Catch: Throwable -> L11
    L7:
        if (r12.moveToNext() == false) goto L10;
        r11.add(com.ss.android.socialbase.downloader.utils.c.S(r12));     // Catch: Throwable -> L11
        goto L7
    L10:
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r12});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        lb.a.c("SqlDownloadCache", "getDownloadInfoListImpl", "Error:" + th);     // Catch: Throwable -> L14
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r12});
    L14:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r12});
        throw th;
    L17:
        return r11;
    }

    private List<DownloadInfo> g3(String r10) {
        c3();
        ArrayList r11 = new ArrayList();
        if (f9205m == null) goto L17;
        Cursor r12 = null;
        r12 = f9205m.rawQuery(String.format("SELECT * FROM %s WHERE %s LIKE ?", new Object[]{"downloader", ActivityLifecycle.NAME}), new String[]{"%" + r10});     // Catch: Throwable -> L11
    L7:
        if (r12.moveToNext() == false) goto L10;
        r11.add(com.ss.android.socialbase.downloader.utils.c.S(r12));     // Catch: Throwable -> L11
        goto L7
    L10:
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r12});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        lb.a.c("SqlDownloadCache", "getDownloadInfosByFileExtensionImpl", "Error:" + th);     // Catch: Throwable -> L14
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r12});
    L14:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r12});
        throw th;
    L17:
        return r11;
    }

    private static void h3() {
        if (f9207o == null) goto L5;
        return;
    L5:
        f9207o = com.ss.android.socialbase.downloader.utils.c.M(rb.a.d().optJSONObject("lru_preload_hot_cache_keys"));
    }

    private static int i3() {
        int r10 = rb.a.d().optInt("lru_download_info_capacity_max", 300);
        if (r10 >= 100) goto L5;
        return 300;
    L5:
        return r10;
    }

    private static int j3() {
        int r10 = rb.a.j().n("main_thread_db_op_max_time_ms");
        if (r10 >= 0) goto L6;
        return r10;
    L6:
        if (com.ss.android.socialbase.downloader.downloader.a.Y() == false) goto L9;
        return 4000;
    L9:
        return r10;
    }

    private List<String> k3() {
        jb.k r10 = com.ss.android.socialbase.downloader.downloader.a.w();
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.b();
    }

    private List<DownloadInfo> m3(String r10) {
        c3();
        ArrayList r11 = new ArrayList();
        if (f9205m == null) goto L17;
        Cursor r12 = null;
        r12 = f9205m.rawQuery(String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?", new Object[]{"downloader", "mimeType", "status"}), new String[]{r10, String.valueOf(-3)});     // Catch: Throwable -> L11
    L7:
        if (r12.moveToNext() == false) goto L10;
        r11.add(com.ss.android.socialbase.downloader.utils.c.S(r12));     // Catch: Throwable -> L11
        goto L7
    L10:
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r12});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        lb.a.c("SqlDownloadCache", "getSuccessedDownloadInfosWithMimeTypeImpl", "Error:" + th);     // Catch: Throwable -> L14
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r12});
    L14:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r12});
        throw th;
    L17:
        return r11;
    }

    private List<DownloadInfo> n3(String r10) {
        c3();
        ArrayList r11 = new ArrayList();
        if (f9205m == null) goto L17;
        Cursor r12 = null;
        r12 = f9205m.rawQuery(String.format("SELECT * FROM %s WHERE %s = ? AND %s IN (?,?,?,?,?)", new Object[]{"downloader", "mimeType", "status"}), new String[]{r10, String.valueOf(-1), String.valueOf(-2), String.valueOf(-7), String.valueOf(-4), String.valueOf(-5)});     // Catch: Throwable -> L11
    L7:
        if (r12.moveToNext() == false) goto L10;
        r11.add(com.ss.android.socialbase.downloader.utils.c.S(r12));     // Catch: Throwable -> L11
        goto L7
    L10:
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r12});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        lb.a.c("SqlDownloadCache", "getUnCompletedDownloadInfosWithMimeTypeImpl", "Error:" + th);     // Catch: Throwable -> L14
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r12});
    L14:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r12});
        throw th;
    L17:
        return r11;
    }

    private boolean o3(DownloadInfo r10, boolean r11, boolean r12) {
        if (r10.getStatus() == (-3)) goto L5;
        return r12;
    L5:
        boolean r13 = com.ss.android.socialbase.downloader.utils.g.M(r10.getSavePath(), r10.getName());
        if (r10.getInstalledTimeStamp() > 0) goto L8;
    L10:
        boolean r14 = false;
    L12:
        if (r13 == false) goto L19;
        if (r14 == false) goto L17;
        com.ss.android.socialbase.downloader.utils.g.i(r10);
        if (lb.a.a() == false) goto L17;
        lb.a.g("SqlDownloadCache", r10.getId(), "checkSuccess", "Run Delete");
    L17:
        return r12;
    L19:
        if (lb.a.a() == false) goto L21;
        lb.a.g("SqlDownloadCache", r10.getId(), "checkSuccess", "Download success and file not exist name:" + r10.getName() + " monitorScene:" + r10.getMonitorScene() + " life:" + r10.getCacheLifeTimeMax());
    L21:
        if (r11 == false) goto L23;
        return true;
    L23:
        if (r14 == true) goto L25;
        r10.erase();
    L25:
        return r12;
    L8:
        if (com.ss.android.socialbase.downloader.utils.a.p(r10.getSavePath()) == false) goto L10;
        r14 = true;
        goto L12
    }

    private void p3(DownloadInfo r10, SQLiteStatement r11) {
        if (r10 == null) goto L18;
        if (r11 == null) goto L20;
        monitor-enter(r11);     // Catch: Throwable -> L12
        r10.bindValue(r11);     // Catch: Throwable -> L9
        r11.executeInsert();     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
    L19:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        lb.a.h("SqlDownloadCache", r10.getId(), "insertDownloadInfoInner", "Error:" + th);
        return;
    L20:
        return;
    }

    private static boolean q3(String r10) {
        if (f9207o != null) goto L5;
    L17:
        return false;
    L5:
        if (f9207o.isEmpty() == true) goto L17;
        if (r10 == null) goto L17;
        Iterator<Map.Entry<String, Integer>> r11 = f9207o.entrySet().iterator();
    L10:
        if (r11.hasNext() == false) goto L17;
        String r12 = r11.next().getKey();
        if (r12 == null) goto L10;
        if (r10.indexOf(r12) == (-1)) goto L10;
        return true;
    }

    static /* synthetic */ void r2(e r10) {
        r10.c3();
    }

    private void r3(List<DownloadInfo> r11, SparseArray<DownloadInfo> r12) {
        int r10 = r12.size();
        if (r10 >= 0) goto L5;
        return;
    L5:
        if (f9205m == null) goto L40;
        SQLiteDatabase r13 = f9205m;
        monitor-enter(r13);
        w3();     // Catch: Throwable -> L22
        if (r11.isEmpty() == true) goto L16;
        String[] r14 = new String[r11.size()];     // Catch: Throwable -> L22
        int r15 = 0;
    L13:
        if (r15 >= r11.size()) goto L15;
        r14[r15] = String.valueOf(r11.get(r15).getId());     // Catch: Throwable -> L22
        r15 = r15 + 1;     // Catch: Throwable -> L22
        goto L13
    L15:
        f9205m.delete("downloader", "CAST(_id AS TEXT) IN (" + new String(new char[r11.size() - 1]).replace("\u0000", "?,") + "?)", r14);     // Catch: Throwable -> L22
    L16:
        int r16 = 0;
    L17:
        if (r16 >= r10) goto L19;
        int r17 = r12.keyAt(r16);     // Catch: Throwable -> L22
        DownloadInfo r18 = r12.get(r17);     // Catch: Throwable -> L22
        f9205m.delete("downloader", "_id = ?", new String[]{String.valueOf(r17)});     // Catch: Throwable -> L22
        f9205m.insert("downloader", null, com.ss.android.socialbase.downloader.utils.c.c0(r18));     // Catch: Throwable -> L22
        r16 = r16 + 1;     // Catch: Throwable -> L22
        goto L17
    L19:
        f9205m.setTransactionSuccessful();     // Catch: Throwable -> L22
    L20:
        x3();     // Catch: Throwable -> L30
        monitor-exit(r13);     // Catch: Throwable -> L30
        return;
    L22:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L27
        lb.a.c("SqlDownloadCache", "loadCacheFromDB", "Error:" + th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        x3();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ SQLiteDatabase s2() {
        return f9205m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v7 */
    private void s3(com.ss.android.socialbase.downloader.model.c r33, SparseArray<DownloadInfo> r34, HashMap<Integer, Integer> r35, List<DownloadInfo> r36, List<String> r37, hb.d r38, com.ss.android.socialbase.downloader.cleaner.a r39) {
        SparseArray<DownloadInfo> r14 = new SparseArray();
        ArrayList r15 = new ArrayList();
        if (rb.a.j().n("sql_download_cache_time_opt") <= 0) goto L5;
        boolean r16 = true;
    L7:
        if (rb.a.j().n("remove_download_success_and_not_exists") <= 0) goto L9;
        boolean r10 = true;
    L11:
        if (rb.a.j().n("remove_external_public_dir_task_for_q") <= 0) goto L13;
        boolean r11 = true;
    L15:
        if (rb.a.d().optInt("remove_useless_monitor_report", 0) <= 0) goto L17;
        boolean r17 = true;
    L19:
        if (rb.a.j().n("clean_installed_apk") <= 0) goto L21;
        boolean r18 = true;
    L22:
        long r12 = rb.a.j().r("incomplete_file_expired_time");
        Set<String> r13 = com.ss.android.socialbase.downloader.utils.c.s();
        Set<String> r19 = com.ss.android.socialbase.downloader.utils.c.r();
        Set<String> r20 = com.ss.android.socialbase.downloader.utils.c.o();
        ArrayList r22 = r15;
        qb.n r110 = null;
        Cursor r21 = f9205m.rawQuery("SELECT * FROM downloader", null);     // Catch: Throwable -> L211
        if (r36 == null) goto L31;
        if (r35 == null) goto L31;
        h3();     // Catch: Throwable -> L37
        int r23 = r21.getCount();     // Catch: Throwable -> L37
        int r24 = f9206n;     // Catch: Throwable -> L37
        if (r23 <= r24) goto L31;
        int r25 = r21.getCount() - r24;     // Catch: Throwable -> L37
    L32:
        if (r16 == true) goto L34;
    L41:
        boolean r26 = true;
    L239:
        r33.f8146b = r21.getCount();     // Catch: Throwable -> L209
        if (lb.a.a() == false) goto L47;
        lb.a.b("SqlDownloadCache", "newBatchInit", "DownloadInfo Count:" + r33.f8146b);     // Catch: Throwable -> L37
    L47:
        int r27 = r25;
        int r28 = 0;
    L48:
        if (r21.moveToNext() == false) goto L202;
        DownloadInfo r111 = com.ss.android.socialbase.downloader.utils.c.S(r21);     // Catch: Throwable -> L198
        if (W2(r111, r11, r12) == true) goto L52;
        long r29 = r12;
        if (com.ss.android.socialbase.downloader.utils.c.v(r13, r19, r20, r111.getMimeType(), r111.getMonitorScene()) == true) goto L58;
        if (r17 == true) goto L65;
        r111.setStatusAtDbInit(r111.getRealStatus());     // Catch: Throwable -> L37
    L65:
        if (r111.isCanResumeFromBreakPointStatus() == false) goto L70;
        r111.setStatus(-5);     // Catch: Throwable -> L37
        if (r16 == false) goto L70;
        if (r17 == true) goto L70;
        r14.put(r111.getId(), r111);     // Catch: Throwable -> L37
    L70:
        long r210 = r111.getCurBytes();     // Catch: Throwable -> L198
        if (r210 <= 0) goto L77;
        r33.f8148d += r210;     // Catch: Throwable -> L37
    L77:
        if (TextUtils.isEmpty(r111.getSavePath()) == false) goto L80;
    L115:
        r19 = r19;
        Set<String> r211 = r13;
    L116:
        boolean r30 = true;
    L117:
        if (r30 == true) goto L118;
        ArrayList r112 = r22;
        if (r16 == false) goto L130;
        if (r26 == true) goto L243;
        int r31 = r111.getId();     // Catch: Throwable -> L120
        int r32 = r110.c(r111);     // Catch: Throwable -> L120
        if (r32 == r31) goto L243;
        r111.setId(r32);     // Catch: Throwable -> L120
    L128:
        r14.put(r31, r111);     // Catch: Throwable -> L120
    L243:
        if (r111.getCacheLifeTimeMax() != 0) goto L141;
        r39.g(r111);     // Catch: Throwable -> L120
    L141:
        if (r36 == null) goto L187;
        if (r35 == null) goto L187;
        if (r17 == true) goto L146;
        X2(r111);     // Catch: Throwable -> L120
    L146:
        if (r37 != null) goto L148;
    L159:
        if (r27 <= 0) goto L187;
        int r212 = r27 - 1;
        if (r27 <= 0) goto L186;
        if (q3(r111.getUrl()) == true) goto L186;
        monitor-enter(r35);     // Catch: Throwable -> L196
        r35.put(Integer.valueOf(r111.getId()), 0);     // Catch: Throwable -> L178
        monitor-exit(r35);     // Catch: Throwable -> L178
        r28 = r28 + 1;
        if (r28 >= this.f9212i) goto L172;
        r13 = r211;
        r27 = r212;
        r12 = r29;
        r19 = r19;
        r22 = r112;
        r11 = r11;
        goto L48
    L172:
        Set<String> r113 = r19;
        Set<String> r213 = r211;
        boolean r214 = r11;
        boolean r215 = r10;
        Set<String> r310 = r20;
        V2(false, r112, r14, r34, r35, r36, r38);     // Catch: Throwable -> L194
        r19 = r113;
        r13 = r213;
        r27 = r212;
        r11 = r214;
        r12 = r29;
        r10 = r215;
        r28 = 0;
        r20 = r310;
        r22 = r112;
    L176:
        th = th;
        r112 = r112;
        int r216 = 0;
    L201:
        Object r40 = r21;
        int r114 = 1;
    L233:
        th.printStackTrace();     // Catch: Throwable -> L224
        lb.a.c("SqlDownloadCache", "newBatchInit", "Error:" + th);     // Catch: Throwable -> L224
        Cursor[] r41 = new Cursor[r114];
        r41[r216] = r40;
        com.ss.android.socialbase.downloader.utils.g.a0(r41);
        a3();
        if (lb.a.a() == false) goto L220;
        lb.a.b("SqlDownloadCache", "newBatchInit", "Run End");
    L220:
        V2(true, r112, r14, r34, r35, r36, r38);
        this.f9211h = r114;
        r33.f8145a = System.currentTimeMillis() - r33.f8145a;
        r33.f8147c = r34.size();
        mb.a.f(r33);
        ib.n r42 = com.ss.android.socialbase.downloader.downloader.a.q();
        if (r42 != null) goto L207;
    L208:
        r39.f();
        return;
    L207:
        r42.a(r33);
    L224:
        th = move-exception;
        Cursor[] r43 = new Cursor[r114];
        r43[r216] = r40;
        com.ss.android.socialbase.downloader.utils.g.a0(r43);
        a3();
        if (lb.a.a() == false) goto L228;
        lb.a.b("SqlDownloadCache", "newBatchInit", "Run End");
    L228:
        V2(true, r112, r14, r34, r35, r36, r38);
        this.f9211h = r114;
        r33.f8145a = System.currentTimeMillis() - r33.f8145a;
        r33.f8147c = r34.size();
        mb.a.f(r33);
        ib.n r44 = com.ss.android.socialbase.downloader.downloader.a.q();
        if (r44 == null) goto L231;
        r44.a(r33);
    L231:
        r39.f();
        throw th;
    L178:
        th = th;
        r216 = 0;
    L257:
        monitor-exit(r35);     // Catch: Throwable -> L184
        throw th;     // Catch: Throwable -> L194
    L194:
        th = th;
    L184:
        th = th;
    L180:
        th = th;
        r216 = 0;
    L186:
        r216 = 0;
        r27 = r212;
    L188:
        r34.put(r111.getId(), r111);     // Catch: Throwable -> L194
    L241:
        r28 = r28 + 1;     // Catch: Throwable -> L194
        if (r28 < this.f9212i) goto L193;
        V2(false, r112, r14, r34, r35, r36, r38);     // Catch: Throwable -> L194
        r28 = r216;
    L193:
        r22 = r112;
        r19 = r19;
        r13 = r211;
        r11 = r11;
        r12 = r29;
        r10 = r10;
        r20 = r20;
        goto L48
    L148:
        if (r37.isEmpty() == true) goto L159;
        if (r37.contains(r111.getMimeType()) == false) goto L159;
        int r45 = r111.getRealStatus();     // Catch: Throwable -> L120
        if (rb.a.i(r111).n("enable_notification_ui") < 2) goto L154;
    L158:
        r36.add(r111);     // Catch: Throwable -> L120
        goto L159
    L154:
        if (r45 != (-2)) goto L158;
        if (r111.isPauseReserveOnWifi() == true) goto L158;
    L187:
        r216 = 0;
    L196:
        th = th;
        r112 = r112;
    L200:
        r216 = 0;
        goto L201
    L130:
        r31 = r111.getId();     // Catch: Throwable -> L196
        int r46 = ((qb.n) qb.k.a(qb.n.class)).c(r111);     // Catch: Throwable -> L196
        if (r46 == r31) goto L243;
        r111.setId(r46);     // Catch: Throwable -> L120
        goto L128
    L118:
        ArrayList r47 = r22;
        r47.add(r111);     // Catch: Throwable -> L120
        r20 = r20;
        r211 = r211;
        r19 = r19;
        r216 = 0;
        r10 = r10;
        r11 = r11;
        r112 = r47;
    L120:
        th = th;
        r112 = r47;
    L39:
        boolean r115 = true;
        Cursor r48 = r21;
    L40:
        r216 = 0;
        r40 = r48;
        r114 = r115;
        goto L233
    L80:
        if (TextUtils.isEmpty(r111.getName()) == true) goto L115;
        r211 = r13;
        r30 = true;
        if (r111.getStatus() != 1) goto L90;
        if (r111.getCurBytes() > 0) goto L90;
    L98:
        if (r111.getStatus() != 11) goto L100;
        r111.setStatus(-5);     // Catch: Throwable -> L37
    L100:
        if (r18 == false) goto L104;
        r30 = o3(r111, r10, r30);     // Catch: Throwable -> L37
    L102:
        r19 = r19;
        goto L117
    L104:
        if (com.ss.android.socialbase.downloader.utils.g.J(r111.getStatus(), r111.getSavePath(), r111.getName()) == false) goto L102;
        if (lb.a.a() == false) goto L109;
        lb.a.g("SqlDownloadCache", r111.getId(), "run", "Download success and file not exist");     // Catch: Throwable -> L37
    L109:
        if (r10 == true) goto L116;
        r111.erase();     // Catch: Throwable -> L37
    L113:
        th = th;
        r115 = true;
        r48 = r21;
        r112 = r22;
    L90:
        if (r111.getStatus() != (-3)) goto L92;
    L96:
        r30 = false;
        goto L98
    L92:
        if (r111.getStatus() == 11) goto L96;
        if (r111.isFileDataValid() == true) goto L96;
        r111.reset();     // Catch: Throwable -> L37
        goto L96
    L58:
        if (r27 <= 0) goto L60;
        r27 = r27 - 1;
    L60:
        r12 = r29;
        goto L48
    L52:
        j(r111.getId());     // Catch: Throwable -> L37
        if (r27 > 0) goto L54;
        r29 = r12;
        goto L60
    L54:
        r27 = r27 - 1;
    L198:
        th = th;
        r112 = r22;
        goto L200
    L202:
        ArrayList r116 = r22;
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r21});
        a3();
        if (lb.a.a() == false) goto L205;
        lb.a.b("SqlDownloadCache", "newBatchInit", "Run End");
    L205:
        V2(true, r116, r14, r34, r35, r36, r38);
        this.f9211h = true;
        r33.f8145a = System.currentTimeMillis() - r33.f8145a;
        r33.f8147c = r34.size();
        mb.a.f(r33);
        r42 = com.ss.android.socialbase.downloader.downloader.a.q();
        if (r42 == null) goto L208;
    L209:
        th = th;
        r112 = r22;
        r114 = 1;
        r216 = 0;
        r40 = r21;
        goto L233
    L34:
        if (r21.getCount() <= 0) goto L41;
        qb.n r49 = (qb.n) qb.k.a(qb.n.class);     // Catch: Throwable -> L37
        r26 = r49.d();     // Catch: Throwable -> L37
        r110 = r49;
    L37:
        th = th;
        r112 = r22;
    L31:
        r25 = 0;
    L211:
        th = th;
        r112 = r22;
        boolean r117 = true;
    L215:
        r216 = 0;
        r40 = r110;
        r114 = r117;
    L213:
        th = th;
        r112 = r15;
        r117 = true;
        r110 = null;
        goto L215
    L21:
        r18 = false;
        goto L22
    L17:
        r17 = false;
        goto L19
    L13:
        r11 = false;
        goto L15
    L9:
        r10 = false;
        goto L11
    L5:
        r16 = false;
        goto L7
    }

    static /* synthetic */ void t2(e r10, DownloadInfo r11) {
        r10.X2(r11);
    }

    static /* synthetic */ boolean u2(String r10) {
        return q3(r10);
    }

    static /* synthetic */ void v2(e r10, List r11) {
        r10.Y2(r11);
    }

    private <T> T v3(Callable<T> r10, s<T> r11) {
        int r12 = f9208p;
        if (r12 > 0) goto L5;
    L22:
        return r10.call();
    L14:
        th = th;
        th.printStackTrace();
        StringBuilder r13 = new StringBuilder();
        String r14 = "Call Error: ";
    L16:
        r13.append(r14);
        r13.append(th);
        lb.a.c("SqlDownloadCache", "runImpl", r13.toString());
        if (r11 != null) goto L19;
        return null;
    L19:
        return r11.getDefaultValue();
    L5:
        if (com.ss.android.socialbase.downloader.utils.g.O() == false) goto L22;
        return com.ss.android.socialbase.downloader.downloader.a.l().submit(r10).get(r12, TimeUnit.MILLISECONDS);
    L10:
        th = th;
        th.printStackTrace();
        r13 = new StringBuilder();
        r14 = "Get Error: ";
        goto L16
    }

    static /* synthetic */ void w2(e r10) {
        r10.a3();
    }

    private void w3() {
        f9205m.beginTransaction();
    }

    static /* synthetic */ void x2(e r10, List r11, SparseArray r12) {
        r10.r3(r11, r12);
    }

    private void x3() {
    L8:
        th = move-exception;
        th.printStackTrace();
        lb.a.c("SqlDownloadCache", "safeEndTransaction", "Error:" + th);
        return;
    L3:
        if (f9205m != null) goto L5;
        return;
    L5:
        if (f9205m.inTransaction() == false) goto L14;
        f9205m.endTransaction();     // Catch: Throwable -> L8
        return;
    }

    static /* synthetic */ DownloadInfo y2(e r10, int r11) {
        return r10.e3(r11);
    }

    private void y3(int r10, ContentValues r11) {
        com.ss.android.socialbase.downloader.downloader.a.I0(new i(this, r10, r11));
    }

    static /* synthetic */ List z2(e r10, String r11) {
        return r10.f3(r11);
    }

    private synchronized void z3(DownloadInfo r10) {
        monitor-enter(this);
        if (r10 != null) goto L23;
        monitor-exit(this);
        return;
    L23:
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L19
        lb.a.h("SqlDownloadCache", r10.getId(), "updateDownloadInfoForCurrentThread", "Error:" + th);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    L7:
        if (Q0(r10.getId()) == true) goto L9;
        U2(r10);     // Catch: Throwable -> L15
    L22:
        goto L17
    L9:
        hb.g r11 = this.f9209c;     // Catch: Throwable -> L15
        if (r11 != null) goto L13;
        monitor-exit(this);
        return;
    L13:
        A3(r10, r11.d());     // Catch: Throwable -> L15
        goto L22
    }

    @Override // hb.c
    public void A(boolean r13) {
        if (r13 == false) goto L4;
        k2(new SparseArray(), new HashMap(), new ArrayList(), k3(), null);
        return;
    L4:
        k2(new SparseArray(), null, null, null, null);
    }

    @Override // hb.c
    public boolean A0() {
        return false;
    }

    @Override // hb.c
    public DownloadInfo B0(int r10) {
        ContentValues r11 = new ContentValues();
        r11.put("status", -7);
        y3(r10, r11);
        return null;
    }

    @Override // hb.c
    public DownloadInfo E(int r10) {
        ContentValues r11 = new ContentValues();
        r11.put("status", 5);
        r11.put("isFirstDownload", 0);
        y3(r10, r11);
        return null;
    }

    @Override // hb.c
    public DownloadInfo I0(int r10) {
        ContentValues r11 = new ContentValues();
        r11.put("status", 1);
        y3(r10, r11);
        return null;
    }

    @Override // hb.c
    public boolean Q0(int r10) {
        if (a(r10) == null) goto L12;
        return true;
    L12:
        return false;
    L7:
        th = move-exception;
        th.printStackTrace();
        lb.a.h("SqlDownloadCache", r10, "cacheExist", "Error:" + th);
        return false;
    }

    @Override // hb.c
    public DownloadInfo R0(int r10, long r11) {
        ContentValues r12 = new ContentValues();
        r12.put("status", -4);
        r12.put("curBytes", Long.valueOf(r11));
        y3(r10, r12);
        return null;
    }

    @Override // jb.i
    public boolean U0(int r10, Map<Long, com.ss.android.socialbase.downloader.segment.i> r11) {
        c3();
        if (f9205m != null) goto L5;
        return false;
    L5:
        JSONArray r12 = new JSONArray();
        Iterator<Map.Entry<Long, com.ss.android.socialbase.downloader.segment.i>> r13 = r11.entrySet().iterator();     // Catch: Throwable -> L13
    L8:
        if (r13.hasNext() == false) goto L15;
        Map.Entry<Long, com.ss.android.socialbase.downloader.segment.i> r14 = r13.next();     // Catch: Throwable -> L13
        if (r14.getValue() == null) goto L8;
        r12.put(r14.getValue().q());     // Catch: Throwable -> L13
    L15:
        SQLiteStatement r15 = this.f9210g.b();
        if (r15 != null) goto L19;
        lb.a.h("SqlDownloadCache", r10, "updateSegments", "UpdateSegments statement is null");
        return false;
    L19:
        monitor-enter(r15);
        r15.clearBindings();     // Catch: Throwable -> L23
        r15.bindLong(1, r10);     // Catch: Throwable -> L23
        r15.bindString(2, r12.toString());     // Catch: Throwable -> L23
        r15.execute();     // Catch: Throwable -> L23
        monitor-exit(r15);     // Catch: Throwable -> L23
        return false;
    L23:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        th.printStackTrace();
        lb.a.h("SqlDownloadCache", r10, "updateSegments", "Error:" + th);
        goto L15
    }

    @Override // hb.c
    public DownloadInfo V(int r10, long r11) {
        ContentValues r12 = new ContentValues();
        r12.put("status", -1);
        r12.put("curBytes", Long.valueOf(r11));
        if (r11 <= 0) goto L5;
        r12.put("isFirstDownload", 0);
    L5:
        y3(r10, r12);
        return null;
    }

    @Override // hb.c
    public DownloadInfo a(int r10) {
        return (DownloadInfo) v3(new k(this, r10), null);
    }

    @Override // hb.c
    public boolean b(DownloadInfo r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        com.ss.android.socialbase.downloader.downloader.a.I0(new RunnableC0180e(this, r10));
        return true;
    }

    @Override // hb.c
    public void c() {
        com.ss.android.socialbase.downloader.downloader.a.I0(new h(this));
    }

    @Override // hb.c
    public boolean d() {
        return this.f9211h;
    }

    @Override // hb.c
    public DownloadInfo d0(int r10, long r11) {
        ContentValues r12 = new ContentValues();
        r12.put("status", -3);
        r12.put("curBytes", Long.valueOf(r11));
        r12.put("isFirstDownload", 0);
        r12.put("isFirstSuccess", 0);
        y3(r10, r12);
        return null;
    }

    @Override // hb.c
    public List<DownloadInfo> e(String r10) {
        return (List) v3(new n(this, r10), new o(this));
    }

    @Override // hb.c
    public List<DownloadInfo> f(String r10) {
        return (List) v3(new r(this, r10), new a(this));
    }

    @Override // jb.i
    public void f2(int r10) {
        c3();
        if (f9205m != null) goto L10;
        return;
    L10:
        b3(r10, this.f9210g.a());     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        lb.a.h("SqlDownloadCache", r10, "removeSegments", "Error:" + th);
    }

    @Override // hb.c
    public List<DownloadInfo> g(String r10) {
        return (List) v3(new p(this, r10), new q(this));
    }

    @Override // hb.c
    public boolean h(int r10) {
        com.ss.android.socialbase.downloader.downloader.a.I0(new f(this, r10));
        return true;
    }

    @Override // hb.c
    public void i(int r10) {
    }

    @Override // hb.c
    public boolean j(int r10) {
        com.ss.android.socialbase.downloader.downloader.a.I0(new g(this, r10));
        return true;
    }

    @Override // hb.c
    public List<DownloadInfo> k() {
        return (List) v3(new b(this), new c(this));
    }

    @Override // jb.i
    public /* bridge */ /* synthetic */ List k1(int r10) {
        return l3(r10);
    }

    @Override // jb.u
    public void k2(SparseArray<DownloadInfo> r10, HashMap<Integer, Integer> r11, List<DownloadInfo> r12, List<String> r13, hb.d r14) {
        j r15 = new j(this, r10, r14, r11, r12, r13);     // Catch: Throwable -> L6
        ExecutorService r16 = com.ss.android.socialbase.downloader.downloader.a.l();     // Catch: Throwable -> L6
        if (r16 == null) goto L11;
        r16.execute(r15);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        lb.a.c("SqlDownloadCache", CommonConsts.APM_INNER_EVENT_COST_INIT, "Error2:" + th);
    }

    @Override // hb.c
    public List<DownloadInfo> l(String r10) {
        return (List) v3(new l(this, r10), new m(this));
    }

    @Override // jb.i
    public Map<Long, com.ss.android.socialbase.downloader.segment.i> l2(int r11) {
        c3();
        if (f9205m != null) goto L32;
    L29:
        return null;
    L32:
        Cursor r10 = f9205m.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[]{"segments", "_id"}), new String[]{Integer.toString(r11)});     // Catch: Throwable -> L22
    L20:
        th = th;
    L34:
        th.printStackTrace();     // Catch: Throwable -> L26
        lb.a.h("SqlDownloadCache", r11, "getSegmentMap", "Error:" + th);     // Catch: Throwable -> L26
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r10});
    L26:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r10});
        throw th;
    L7:
        if (r10.moveToNext() == false) goto L19;
        int r12 = r10.getColumnIndex("info");     // Catch: Throwable -> L20
        if (r12 < 0) goto L11;
        String r13 = r10.getString(r12);     // Catch: Throwable -> L20
    L12:
        HashMap r14 = new HashMap();     // Catch: Throwable -> L20
        JSONArray r15 = new JSONArray(r13);     // Catch: Throwable -> L20
        int r16 = 0;
    L13:
        if (r16 >= r15.length()) goto L17;
        com.ss.android.socialbase.downloader.segment.i r17 = new com.ss.android.socialbase.downloader.segment.i(r15.getJSONObject(r16));     // Catch: Throwable -> L20
        r14.put(Long.valueOf(r17.i()), r17);     // Catch: Throwable -> L20
        r16 = r16 + 1;
        goto L13
    L17:
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r10});
        return r14;
    L11:
        r13 = null;
        goto L12
    L19:
        com.ss.android.socialbase.downloader.utils.g.a0(new Cursor[]{r10});
    L22:
        th = th;
        r10 = null;
        goto L34
    }

    public ArrayList<com.ss.android.socialbase.downloader.segment.i> l3(int r10) {
        Map<Long, com.ss.android.socialbase.downloader.segment.i> r11 = l2(r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.isEmpty() == false) goto L8;
        return null;
    L8:
        return new ArrayList(r11.values());
    }

    @Override // hb.c
    public List<DownloadInfo> m(String r10, String r11) {
        return null;
    }

    @Override // hb.c
    public DownloadInfo n0(int r10, long r11) {
        ContentValues r12 = new ContentValues();
        r12.put("status", 4);
        r12.put("curBytes", Long.valueOf(r11));
        y3(r10, r12);
        return null;
    }

    @Override // hb.c
    public void s1(hb.b r10) {
        this.f9215l = r10;
    }

    @Override // hb.c
    public DownloadInfo t0(int r10, long r11, String r12, String r13) {
        ContentValues r14 = new ContentValues();
        r14.put("status", 3);
        r14.put("totalBytes", Long.valueOf(r11));
        r14.put("eTag", r12);
        if (TextUtils.isEmpty(r13) == true) goto L5;
        r14.put(ActivityLifecycle.NAME, r13);
    L5:
        y3(r10, r14);
        return null;
    }

    public void t3(SparseArray<DownloadInfo> r10, HashMap<Integer, Integer> r11, List<DownloadInfo> r12, boolean r13) {
        if (lb.a.a() == false) goto L14;
        lb.a.b("SqlDownloadCache", "onInitFinish", "Run onInitFinish:" + this.f9215l);
    L14:
        HashMap r14 = com.ss.android.socialbase.downloader.utils.c.b0(r10);     // Catch: Throwable -> L9
        Map<Integer, DownloadInfo> r15 = com.ss.android.socialbase.downloader.utils.c.N(r12);     // Catch: Throwable -> L9
        hb.b r16 = this.f9215l;     // Catch: Throwable -> L9
        if (r16 == null) goto L16;
        r16.c1(r14, r11, r15, r13);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L9:
        th = move-exception;
        if (lb.a.a() == false) goto L17;
        lb.a.b("SqlDownloadCache", "onInitFinish", "Error:" + th);
        return;
    }

    public void u3() {
        this.f9212i = Integer.MAX_VALUE;
    }

    @Override // hb.c
    public void v(DownloadInfo r10) {
    }

    @Override // hb.c
    public DownloadInfo w0(int r10) {
        return null;
    }

    @Override // hb.c
    public DownloadInfo y(int r10, long r11) {
        ContentValues r12 = new ContentValues();
        r12.put("status", -2);
        r12.put("curBytes", Long.valueOf(r11));
        y3(r10, r12);
        return null;
    }
}
