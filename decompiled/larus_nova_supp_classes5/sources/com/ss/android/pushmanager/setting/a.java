package com.ss.android.pushmanager.setting;

import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.push.utils.f;
import com.ss.android.common.applog.AppLog;
import com.ss.android.message.AppProvider;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static a b;
    public static final Map<String, Boolean> c = null;
    public final PushMultiProcessSharedProvider.b a;

    static {
        c = new HashMap();
    }

    public static synchronized a b() {
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
            java.lang.Class<com.ss.android.pushmanager.setting.a> r0 = com.ss.android.pushmanager.setting.a.class
            monitor-enter(r0)
            com.ss.android.pushmanager.setting.a r1 = com.ss.android.pushmanager.setting.a.b     // Catch: java.lang.Throwable -> L1e
            if (r1 != 0) goto L1a
            java.lang.Class<com.ss.android.pushmanager.setting.a> r1 = com.ss.android.pushmanager.setting.a.class
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L1e
            com.ss.android.pushmanager.setting.a r2 = com.ss.android.pushmanager.setting.a.b     // Catch: java.lang.Throwable -> L17
            if (r2 != 0) goto L15
            com.ss.android.pushmanager.setting.a r2 = new com.ss.android.pushmanager.setting.a     // Catch: java.lang.Throwable -> L17
            r2.<init>()     // Catch: java.lang.Throwable -> L17
            com.ss.android.pushmanager.setting.a.b = r2     // Catch: java.lang.Throwable -> L17
        L15:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            goto L1a
        L17:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            throw r2     // Catch: java.lang.Throwable -> L1e
        L1a:
            com.ss.android.pushmanager.setting.a r1 = com.ss.android.pushmanager.setting.a.b     // Catch: java.lang.Throwable -> L1e
            monitor-exit(r0)
            return r1
        L1e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.pushmanager.setting.a.b():com.ss.android.pushmanager.setting.a");
    }

    public final String a() {
        HashMap r0 = new HashMap();
        c(r0);
        return (String) r0.get(EffectConfiguration.KEY_DEVICE_ID);
    }

    public final boolean d() {
        PushMultiProcessSharedProvider.b r0 = this.a;
        r0.getClass();
        if (PushMultiProcessSharedProvider.h == true) goto L9;
        if (PushMultiProcessSharedProvider.a(r0.a) == false) goto L9;
        return r0.c("current_app_foreground", false);
    L9:
        return !ActivityLifecycleObserver.getIns().isBackGround();
    }

    public a() {
        this.a = PushMultiProcessSharedProvider.e(AppProvider.getApp());
    }

    public final void c(Map<String, String> r5) {
        if (f.a == false) goto L15;
        f.b("PushService", "getSSIDs start");
    L15:
        String r1 = this.a.e("ssids");     // Catch: Exception -> L12
        f.b("PushService", "getSSIDs result is " + r1);     // Catch: Exception -> L12
        if (StringUtils.isEmpty(r1) == true) goto L13;
        StringUtils.stringToMap(r1, r5);     // Catch: Exception -> L12
        return;
    L13:
        f.b("PushService", "backup getSSIDs by TeaAgent");     // Catch: Throwable -> L11
        AppLog.g0.g(r5);     // Catch: Throwable -> L11
        return;
    L17:
        return;
    }
}
