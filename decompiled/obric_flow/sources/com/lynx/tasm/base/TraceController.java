package com.lynx.tasm.base;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;
import androidx.room.writer.DaoWriter;
import com.lynx.tasm.p;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class TraceController {
    public static boolean g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f10108h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f10109i = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f10110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f10111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f10112c;
    public final long d;
    public int e;
    public String f;

    public static class TraceIntentFilter extends IntentFilter {
    }

    public TraceController() {
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
            java.lang.String r0 = "failed to create NativeTraceController"
            java.lang.String r1 = "Lynx startup trace"
            r6.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r6.f10111b = r2
            r2 = 0
            r6.d = r2
            r4 = -1
            r6.e = r4
            boolean r4 = c()     // Catch: java.lang.Exception -> L22 java.lang.UnsatisfiedLinkError -> L24
            if (r4 == 0) goto L2d
            long r4 = r6.nativeCreateTraceController()     // Catch: java.lang.Exception -> L22 java.lang.UnsatisfiedLinkError -> L24
            r6.d = r4     // Catch: java.lang.Exception -> L22 java.lang.UnsatisfiedLinkError -> L24
            goto L2d
        L22:
            r4 = move-exception
            goto L26
        L24:
            r4 = move-exception
            goto L2a
        L26:
            android.util.Log.w(r1, r0, r4)
            goto L2d
        L2a:
            android.util.Log.w(r1, r0, r4)
        L2d:
            long r4 = r6.d
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L36
            android.util.Log.w(r1, r0)
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lynx.tasm.base.TraceController.<init>():void");
    }

    public static TraceController b() {
        return j.f10134a;
    }

    public static boolean c() {
        boolean r5 = f10109i;
        if (r5 == false) goto L5;
        return r5;
    L5:
        f r10 = f.a();
        if (r10.f10127a == false) goto L9;
        boolean r11 = r10.f10127a;
    L15:
        f10109i = r11;
        return r11;
    L9:
        if (r10.f10127a == false) goto L17;
        boolean r12 = r10.f10127a;
    L14:
        r10.f10127a = r12;
        TraceEvent.f10114b = r10.f10127a;
        r11 = r10.f10127a;
        goto L15
    L17:
        System.loadLibrary("lynxtrace");     // Catch: Exception -> L13
        r12 = true;
    L13:
        Log.e("trace env init", "failed to load liblynxtrace.so");
        r12 = false;
        goto L14
    }

    private native long nativeCreateTraceController();

    private native void nativeStartStartupTracingIfNeeded(long r5);

    private native int nativeStartTracing(long r5, int r10, String[] r11, String[] r12, String r13, boolean r14);

    private native void nativeStopTracing(long r5, int r10);

    public final File a() {
        int r5 = Process.myPid();
        SimpleDateFormat r10 = new SimpleDateFormat("yyyy-MM-dd-HHmmss", Locale.US);
        r10.setTimeZone(TimeZone.getTimeZone("UTC"));
        File r11 = this.f10110a.getExternalFilesDir(null);
        StringBuilder r12 = p.d(r5, "lynx-profile-trace-", DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r12.append(r10.format(new Date()));
        return new File(r11, r12.toString());
    }

    public final void d() {
        long r5 = this.d;
        if (r5 == 0) goto L6;
        nativeStartStartupTracingIfNeeded(r5);
        return;
    }

    public final void e() {
        long r5 = this.d;
        if (r5 != 0) goto L5;
        return;
    L5:
        if (g == false) goto L17;
        g = false;
        nativeStopTracing(r5, this.e);
        if (this.f.isEmpty() == true) goto L16;
        Iterator r10 = this.f10111b.iterator();
        if (r10.hasNext() == true) goto L14;
        this.f10111b.clear();
        this.f = "";
        return;
    L14:
        throw mn.h.c(r10);
    L16:
        return;
    }

    public final void a(int r10, String[] r11, String r12) {
        if (g == false) goto L7;
        Toast.makeText(this.f10110a, "Trace already started, please stop it first", 0).show();
        return;
    L7:
        if (this.d != 0) goto L10;
        Log.w("Lynx startup trace", "tracing not enabled");
        return;
    L10:
        g = true;
        if (r12.isEmpty() == false) goto L13;
        r12 = a().getPath();
    L13:
        String r13 = r12;
        this.f = r13;
        this.e = nativeStartTracing(this.d, r10, r11, null, r13, false);
        HashMap r14 = new HashMap();
        r14.put("Version", "3.5.23-rc.34");
        TraceEvent.h(1, "Version", r14);
    }

    public final void a(Context r5) {
        this.f10110a = r5;
        if (TraceEvent.f10115c == false) goto L12;
        this.f10112c = new i(this);
        Context r10 = this.f10110a;
        TraceIntentFilter r11 = new TraceIntentFilter();
        r11.addAction(r10.getPackageName() + ".LYNX_TRACE_START");
        r11.addAction(r10.getPackageName() + ".LYNX_TRACE_STOP");
        if (Build.VERSION.SDK_INT >= 34) goto L7;
    L10:
        this.f10110a.registerReceiver(this.f10112c, r11);
        return;
    L7:
        if (r5.getApplicationInfo().targetSdkVersion < 34) goto L10;
        this.f10110a.registerReceiver(this.f10112c, r11, 2);
        return;
    }
}
