package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.mime.AbsTypedOutput;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends com.bytedance.frameworks.baselib.network.http.impl.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static volatile boolean f2408b = true;
    protected static volatile boolean c = false;
    static final /* synthetic */ boolean d = true;
    private static volatile boolean k = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile int f2409a;
    private volatile long e;

    static {
    }

    a(Request r3) {
        super(r3);
        this.f2409a = 0;
        this.e = 0;
        this.g.G = 0;     // Catch: Exception -> L5
        this.g.K.put("hc", "SsCronetHttpClient");     // Catch: Exception -> L5
        this.g.K.put("hcv", h.c());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private static String a(TypedOutput r2) {
        TypedOutput r3 = (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r2, TypedOutput.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AbsTypedOutput.class) == false) goto L5;
        AbsTypedOutput r0 = (AbsTypedOutput) ZeusTransformUtils.preCheckCast(r3, AbsTypedOutput.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r0.bodyCompressType()) == true) goto L9;
        String r4 = r0.getBodyMd5Stub();
        if (TextUtils.isEmpty(r4) == false) goto L13;
        Logger.e("BaseCronetSsCall", "Request compress body md5 shouldn't be null.");
    L13:
        return r4;
    L9:
        return r3.md5Stub();
    L5:
        return r3.md5Stub();
    }

    private static String a(TypedOutput r12, Request r13) {
        TypedOutput r14 = (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r12, TypedOutput.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, AbsTypedOutput.class) == false) goto L37;
        if (r13 == null) goto L37;
        AbsTypedOutput r0 = (AbsTypedOutput) ZeusTransformUtils.preCheckCast(r14, AbsTypedOutput.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r0.bodyCompressType()) == false) goto L9;
        long r3 = r14.length();
        if ("POST".equalsIgnoreCase(r13.getMethod()) == true) goto L16;
        long r5 = 0;
        TTRequestCompressManager.DisableCompress r15 = TTRequestCompressManager.DisableCompress.NON_POST_METHOD;
    L13:
        int r7 = r15.getReason();
        long r8 = 0;
    L14:
        a(r3, r5, r7, r8, r13, null);
        return null;
    L16:
        Header r1 = r13.getFirstHeader("x-metasec-bp-body-compress");
        if (r1 != null) goto L19;
    L21:
        Header r2 = r13.getFirstHeader("content-encoding");
        if (r2 != null) goto L24;
    L26:
        r8 = System.currentTimeMillis();
        if (r0.isBodyEncrypted() == true) goto L29;
    L32:
        TTRequestCompressManager.CompressData r10 = r0.compressRequestBody(r13.getHost(), r13.getPath(), b(r13));
        if (r10 != null) goto L35;
        r5 = 0;
        TTRequestCompressManager.DisableCompress r16 = TTRequestCompressManager.DisableCompress.DATA_NULL;
    L31:
        r7 = r16.getReason();
        goto L14
    L35:
        a(r3, r14.length(), 0, r8, r13, r10);
        return r10.contentEncoding;
    L29:
        if (TTRequestCompressManager.isBodyOptEnabled() == false) goto L32;
        r5 = 0;
        r16 = TTRequestCompressManager.DisableCompress.BODY_ENCRYPTED;
        goto L31
    L24:
        if (TextUtils.isEmpty(r2.getValue()) == true) goto L26;
        r5 = 0;
        r15 = TTRequestCompressManager.DisableCompress.BODY_ENCODED;
        goto L13
    L19:
        if ("1".equals(r1.getValue()) == false) goto L21;
        r5 = 0;
        r15 = TTRequestCompressManager.DisableCompress.USER_DISABLE;
        goto L13
    L9:
        return r0.bodyCompressType();
    L37:
        return null;
    }

    public static void a() {
        k = true;
    }

    private static void a(long r3, long r5, int r7, long r8, Request r10, TTRequestCompressManager.CompressData r11) {
        if (r10.getMetrics() != null) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        r1.put("beforeSize", r3);     // Catch: JSONException -> L10
        if (r7 == 0) goto L12;
        r1.put("disableReason", r7);     // Catch: JSONException -> L10
    L12:
        if (r11 != null) goto L31;
    L13:
        r10.getMetrics().requestCompressInfo = r1;
        return;
    L31:
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L16:
        if (TextUtils.isEmpty(r11.contentEncoding) == true) goto L19;
        r1.put("type", r11.contentEncoding);     // Catch: JSONException -> L29
        r1.put("afterSize", r5);     // Catch: JSONException -> L29
    L19:
        if (r11.failedCode == 0) goto L27;
        r1.put("disableReason", r11.failedCode);     // Catch: JSONException -> L29
        if (r11.failedCode == TTRequestCompressManager.DisableCompress.GZIP_PREFIX_MISMATCH.getReason()) goto L25;
        if (r11.failedCode != TTRequestCompressManager.DisableCompress.ZSTD_PREFIX_MISMATCH.getReason()) goto L27;
    L25:
        if (TextUtils.isEmpty(r11.failedPrefixData) == true) goto L27;
        r1.put("prefix", r11.failedPrefixData);     // Catch: JSONException -> L29
    L27:
        r1.put("duration", System.currentTimeMillis() - r8);     // Catch: JSONException -> L29
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private static void a(Request r2) {
        if (r2.getMetrics() != null) goto L5;
        return;
    L5:
        Header r0 = r2.getFirstHeader("x-bd-content-encoding");
        if (r0 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r0.getValue()) == true) goto L19;
        JSONObject r3 = r2.getMetrics().requestCompressInfo;
        if (r3 != null) goto L16;
        return;
    L16:
        r3.put("encode", r0.getValue());     // Catch: JSONException -> L15
        r3.put("disableReason", TTRequestCompressManager.DisableCompress.REMOVE_ENCODING.getReason());     // Catch: JSONException -> L15
        return;
    L20:
        return;
    }

    private static /* synthetic */ void a(String r0, String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        h.a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void a(boolean r0) {
        f2408b = r0;
    }

    public static void b(boolean r0) {
        c = r0;
    }

    private static boolean b(Request r1) {
        Header r2 = r1.getFirstHeader("x-metasec-content-encoding");
        if (r2 != null) goto L7;
        return false;
    L7:
        return "1".equals(r2.getValue());
    }

    private int c(Request r1) {
        return h.a(r1.getPath(), this.g);
    }

    /* JADX INFO: renamed from: lambda$bY3ztSUEOpDMw-TxaOVWw0Ko2dI, reason: not valid java name */
    public static /* synthetic */ void m89lambda$bY3ztSUEOpDMwTxaOVWw0Ko2dI(String r0, String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public String a(String r3) {
        if (b() != null) goto L6;
        return null;
    L6:
        String r0 = b().getHeaderField(r3);
        if (TextUtils.isEmpty(r0) == true) goto L9;
        return r0;
    L9:
        return b().getHeaderField(r3.toLowerCase());
    }

    public HttpURLConnection a(String r3, com.bytedance.frameworks.baselib.network.http.b r4) {
        long r0 = -1;
        r0 = r4.d.constructConnectionStart();     // Catch: Throwable -> L6
        HttpURLConnection r2 = h.b(r3, r4);     // Catch: Throwable -> L6
        r4.d.constructConnectionEnd(r0);
        return r2;
    L6:
        th = move-exception;
        r4.d.constructConnectionEnd(r0);
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public void a(RetrofitMetrics r4) {
        long r0 = r4.executeConnectionStart();
        this.f2409a = b(b());     // Catch: Throwable -> L6
        r4.executeConnectionEnd(r0);
        return;
    L6:
        th = move-exception;
        r4.executeConnectionEnd(r0);
        throw th;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:179:0x042e -> B:347:0x043c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 21011. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:99)
        */
    public void a(com.bytedance.retrofit2.client.Request r25, com.bytedance.frameworks.baselib.network.http.b r26, java.net.HttpURLConnection r27, java.util.Map<java.lang.String, java.lang.String> r28) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0024: IGET (r8v0 ?? I:T extends com.bytedance.frameworks.baselib.network.http.c) = (r26v0 com.bytedance.frameworks.baselib.network.http.b) A[Catch: all -> 0x082c, DECLARE_VAR, TRY_LEAVE] com.bytedance.frameworks.baselib.network.http.b.c com.bytedance.frameworks.baselib.network.http.c in method: com.bytedance.frameworks.baselib.network.http.cronet.impl.a.a(com.bytedance.retrofit2.client.Request, com.bytedance.frameworks.baselib.network.http.b, java.net.HttpURLConnection, java.util.Map<java.lang.String, java.lang.String>):void, file: classes2.dex
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
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 2101
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.frameworks.baselib.network.http.cronet.impl.a.a(com.bytedance.retrofit2.client.Request, com.bytedance.frameworks.baselib.network.http.b, java.net.HttpURLConnection, java.util.Map):void");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public void a(Request r7, Exception r8) {
        String r9 = r8.getMessage();
        if (h.b() == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r9) == false) goto L7;
        return;
    L7:
        if (r9.contains("net::ERR_INTERNET_DISCONNECTED") == false) goto L12;
        new NetworkNotAvailabeException("network not available for " + this.f.getPath() + ", message:" + r9).setInfo(false, true, this.f.getUrl(), "", this.g);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public void a(TypedInput r5) {
        TypedInput r6 = (TypedInput) ZeusTransformUtils.wrapperContextForParams(r5, TypedInput.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (this.f.isResponseStreaming() == false) goto L7;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r6, TypedByteArray.class) == false) goto L17;
        this.g.d.postProcessBodyStart();
        com.bytedance.frameworks.baselib.network.http.d.b.a().a(b(), ((TypedByteArray) ZeusTransformUtils.preCheckCast(r6, TypedByteArray.class, "com.obric.memorydata.plugin")).getBytes(), $$Lambda$a$bY3ztSUEOpDMwTxaOVWw0Ko2dI.INSTANCE);     // Catch: Throwable -> L12
    L10:
        this.g.d.postProcessBodyEnd();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public void a(String r4, Request r5, com.bytedance.frameworks.baselib.network.http.b r6, Map<String, String> r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        r6.d.prepareConnectionStart();     // Catch: Throwable -> L21 Exception -> L23
        r6.f2363b = c(r5);     // Catch: Throwable -> L21 Exception -> L23
        if (f2408b == true) goto L6;
    L14:
        boolean r0 = false;
    L15:
        r6.f2362a = r0;     // Catch: Throwable -> L21 Exception -> L23
        if (Logger.debug() == false) goto L18;
        Logger.e("BaseCronetSsCall", "url is " + r4 + " useCronetInputStreamWithTTBuffer: " + r6.f2362a);     // Catch: Throwable -> L21 Exception -> L23
    L18:
        HttpURLConnection r1 = a(r4, r6);     // Catch: Throwable -> L21 Exception -> L23
        a(r5, r6, r1, r8);     // Catch: Throwable -> L21 Exception -> L23
        a(r1);     // Catch: Throwable -> L21 Exception -> L23
        r6.d.prepareConnectionEnd();
        return;
    L6:
        if (c == false) goto L14;
        if (r6.f2363b > 0) goto L14;
        if (r5.isResponseStreaming() == true) goto L14;
        if (r5.getMaxLength() > 0) goto L14;
        r0 = true;
    L23:
        e = move-exception;
        throw TTNetExceptionStorage.wrapIfNeeded(e, r4, r6.P, r6);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r6.d.prepareConnectionEnd();
        throw th;
    }

    void a(HttpURLConnection r1) {
    }

    public int b(HttpURLConnection r2) {
        TypedOutput r1 = this.f.getBody();
        if (r1 == null) goto L6;
        r1.writeTo(r2.getOutputStream());
    L6:
        return r2.getResponseCode();
    }

    abstract HttpURLConnection b();

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public int c() {
        return this.f2409a;
    }

    public void c(HttpURLConnection r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (this.i == true) goto L12;
        r9.disconnect();
        this.i = true;
        if (this.f.isResponseStreaming() == false) goto L11;
        i.a().a(this.f.getUrl(), this.g.x, this.g.y, this.g.O, this.g.f2361J);
        return;
    L11:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public long d() {
        if (b() != null) goto L7;
        return 0;
    L7:
        return b().getContentLength();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public String e() {
        return a(NetConst.KEY_CONTENT_TYPE);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public Map<String, List<String>> f() {
        if (b() != null) goto L7;
        return null;
    L7:
        return b().getHeaderFields();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public InputStream g() {
        if (b() != null) goto L7;
        return null;
    L7:
        return b().getInputStream();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(h.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public InputStream h() {
        if (b() != null) goto L7;
        return null;
    L7:
        return b().getErrorStream();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public String i() {
        if (b() != null) goto L7;
        return "";
    L7:
        return b().getResponseMessage();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public boolean j() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public void k() {
        if (b() == null) goto L6;
        b().disconnect();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public boolean l() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public boolean m() {
        if (this.h == false) goto L5;
    L8:
        return true;
    L5:
        if (h.b() == true) goto L8;
        return false;
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public boolean setThrottleNetSpeed(long r1) {
        this.e = r1;
        return true;
    }
}
