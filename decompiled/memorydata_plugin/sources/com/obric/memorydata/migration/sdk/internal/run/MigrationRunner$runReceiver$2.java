package com.obric.memorydata.migration.sdk.internal.run;

import android.content.Context;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.MigrationSecurityProtocol;
import com.obric.memorydata.migration.sdk.MigrationStep;
import com.obric.memorydata.migration.sdk.ae;
import com.obric.memorydata.migration.sdk.b;
import com.obric.memorydata.migration.sdk.d;
import com.obric.memorydata.migration.sdk.e;
import com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.p;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.w;
import com.obric.memorydata.migration.sdk.z;
import com.ss.bduploader.UploadKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.net.Socket;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.run.MigrationRunner$runReceiver$2", f = "MigrationRunner.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 5, 5, 6}, l = {336, 363, 371, 387, 396, 420, UploadKeys.KeyIsSkipMeta}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "conn", "$this$withContext", "conn", "workDir", "$this$withContext", "conn", "workDir", "pkg", "$this$withContext", "$this$withContext", "restoreDir", "$this$withContext"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$0", "L$1", "L$0"})
final class MigrationRunner$runReceiver$2 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends Unit>>, Object> {
    final /* synthetic */ m $callback;
    final /* synthetic */ ae $config;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ a this$0;

    MigrationRunner$runReceiver$2(a r3, ae r4, m r5, Continuation<? super MigrationRunner$runReceiver$2> r6) {
        m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$config = r4;
        this.$callback = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        MigrationRunner$runReceiver$2 r0 = new MigrationRunner$runReceiver$2(this.this$0, this.$config, this.$callback, r7);
        r0.L$0 = r5;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends Unit>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<Unit>> r4) {
        return ((MigrationRunner$runReceiver$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MigrationRunner$runReceiver$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.memorydata.migration.sdk.internal.run.MigrationRunner$runReceiver$2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.obric.memorydata.migration.sdk.internal.run.MigrationRunner$runReceiver$2] */
    /* JADX WARN: Type inference failed for: r1v14, types: [com.obric.memorydata.migration.sdk.t] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.obric.memorydata.migration.sdk.t] */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.obric.memorydata.migration.sdk.t] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.obric.memorydata.migration.sdk.t] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v72 */
    /* JADX WARN: Type inference failed for: r2v73 */
    /* JADX WARN: Type inference failed for: r2v74 */
    /* JADX WARN: Type inference failed for: r2v75 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r29) {
        ?? r1 = this;
        ?? r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r9 = "receiver: cleanup begin";
        String r13 = "com.obric.memorydata.plugin";
        switch(r1.label) {
            case 0: goto L31;
            case 1: goto L24;
            case 2: goto L21;
            case 3: goto L18;
            case 4: goto L15;
            case 5: goto L12;
            case 6: goto L9;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        al r3 = (al) ZeusTransformUtils.preCheckCast(r1.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r29);     // Catch: Throwable -> L27 CancellationException -> L29
        Object r4 = r29;
        String r17 = ", message=";
        String r16 = "导入失败";
        Object r18 = "receiver: cleanup end";
    L154:
        z r7 = (z) ZeusTransformUtils.preCheckCast(r4, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L207 CancellationException -> L209
        if (ZeusTransformUtils.instanceOf(r7, z.a.class) == false) goto L158;
        t.a(t.f11981a, "receiver: restore addons failed, " + ((z.a) ZeusTransformUtils.preCheckCast(r7, z.a.class, "com.obric.memorydata.plugin")).a().b(), null, 2, null);     // Catch: Throwable -> L129 CancellationException -> L131
        a.b(r1.$callback, (p) ZeusTransformUtils.preCheckCast(new p.b(MigrationStep.RESTORING, ((z.a) ZeusTransformUtils.preCheckCast(r7, z.a.class, "com.obric.memorydata.plugin")).a()), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L129 CancellationException -> L131
    L159:
        m r5 = r1.$callback;     // Catch: Throwable -> L207 CancellationException -> L209
        if (ZeusTransformUtils.instanceOf(r7, z.b.class) == false) goto L163;
        MigrationStep r6 = MigrationStep.SUCCESS;     // Catch: Throwable -> L129 CancellationException -> L131
    L165:
        if (ZeusTransformUtils.instanceOf(r7, z.b.class) == false) goto L168;
        String r8 = "导入成功";
    L169:
        a.b(r5, (p) ZeusTransformUtils.preCheckCast(new p.e(r6, r8), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L207 CancellationException -> L209
        if (ZeusTransformUtils.instanceOf(r7, z.b.class) == false) goto L174;
        t.f11981a.a("receiver: run success");     // Catch: Throwable -> L129 CancellationException -> L131
    L176:
        t.f11981a.a("receiver: cleanup begin");
        a r10 = r1.this$0;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L188
        e r12 = a.g(r10);     // Catch: Throwable -> L188
        if (ZeusTransformUtils.instanceOf(r12, e.a.class) == false) goto L180;
        e.a r14 = (e.a) ZeusTransformUtils.preCheckCast(r12, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L188
    L181:
        if (r14 == null) goto L185;
        byte[] r15 = r14.f();     // Catch: Throwable -> L188
        if (r15 == null) goto L185;
        ArraysKt.fill$default(r15, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L188
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L188
    L186:
        Result.m1421constructorimpl(r19);     // Catch: Throwable -> L188
    L190:
        a r20 = r1.this$0;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L197
        e r22 = a.g(r20);     // Catch: Throwable -> L197
        if (r22 == null) goto L194;
        r22.d();     // Catch: Throwable -> L197
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L197
    L195:
        Result.m1421constructorimpl(r23);     // Catch: Throwable -> L197
    L199:
        a.a(r1.this$0, null);
        a.a(r1.this$0, false, 1, null);
        r1 = t.f11981a;
        r2 = r18;
    L338:
        r1.a(r2);
        return r7;
    L194:
        r23 = null;
    L197:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L185:
        r19 = null;
        goto L186
    L180:
        r14 = null;
    L188:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L190
    L174:
        if (ZeusTransformUtils.instanceOf(r7, z.a.class) == false) goto L202;
        t.f11981a.a("receiver: run failed, code=" + ((z.a) ZeusTransformUtils.preCheckCast(r7, z.a.class, "com.obric.memorydata.plugin")).a().a() + r17 + ((z.a) ZeusTransformUtils.preCheckCast(r7, z.a.class, "com.obric.memorydata.plugin")).a().b(), ((z.a) ZeusTransformUtils.preCheckCast(r7, z.a.class, "com.obric.memorydata.plugin")).a().c());     // Catch: Throwable -> L207 CancellationException -> L209
    L209:
        e = e;
        r2 = r18;
    L311:
        CancellationException r26 = e;
        ?? r27 = r2;
    L312:
        t.f11981a.a("receiver: cancelled", (Throwable) ZeusTransformUtils.preCheckCast(r26, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L340
        r7 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.OTHER, "已取消", (Throwable) ZeusTransformUtils.preCheckCast(r26, Throwable.class, "com.obric.memorydata.plugin"))), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L340
        t.f11981a.a("receiver: cleanup begin");
        a r28 = r1.this$0;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L325
        e r31 = a.g(r28);     // Catch: Throwable -> L325
        if (ZeusTransformUtils.instanceOf(r31, e.a.class) == false) goto L317;
        e.a r32 = (e.a) ZeusTransformUtils.preCheckCast(r31, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L325
    L318:
        if (r32 == null) goto L322;
        byte[] r33 = r32.f();     // Catch: Throwable -> L325
        if (r33 == null) goto L322;
        r9 = null;
        r13 = null;
        ArraysKt.fill$default(r33, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L325
        Unit r34 = Unit.INSTANCE;     // Catch: Throwable -> L325
    L323:
        Result.m1421constructorimpl(r34);     // Catch: Throwable -> L325
    L327:
        a r35 = r1.this$0;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L334
        e r37 = a.g(r35);     // Catch: Throwable -> L334
        if (r37 == null) goto L331;
        r37.d();     // Catch: Throwable -> L334
        Unit r38 = Unit.INSTANCE;     // Catch: Throwable -> L334
    L332:
        Result.m1421constructorimpl(r38);     // Catch: Throwable -> L334
        r2 = r27;
    L337:
        a.a(r1.this$0, null);
        a.a(r1.this$0, false, 1, null);
        r1 = t.f11981a;
        goto L338
    L331:
        r38 = null;
    L334:
        th = move-exception;
        Throwable r39 = th;
        ?? r40 = r27;
    L336:
        Result.Companion r41 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(r39));
        r2 = r40;
    L322:
        r34 = null;
        goto L323
    L317:
        r32 = null;
    L325:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L207:
        th = th;
        r2 = r18;
    L284:
        Throwable r43 = th;
        ?? r44 = r2;
    L285:
        t.f11981a.a("receiver: failed", r43);     // Catch: Throwable -> L340
        a.b(r1.$callback, (p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.FAILED, r16), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L340
        r7 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.OTHER, "接收端失败: " + r43.getMessage(), r43)), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L340
        t.f11981a.a("receiver: cleanup begin");
        a r45 = r1.this$0;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L298
        e r47 = a.g(r45);     // Catch: Throwable -> L298
        if (ZeusTransformUtils.instanceOf(r47, e.a.class) == false) goto L290;
        e.a r48 = (e.a) ZeusTransformUtils.preCheckCast(r47, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L298
    L291:
        if (r48 == null) goto L295;
        byte[] r49 = r48.f();     // Catch: Throwable -> L298
        if (r49 == null) goto L295;
        r9 = null;
        r13 = null;
        ArraysKt.fill$default(r49, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L298
        Unit r50 = Unit.INSTANCE;     // Catch: Throwable -> L298
    L296:
        Result.m1421constructorimpl(r50);     // Catch: Throwable -> L298
    L300:
        a r51 = r1.this$0;
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L307
        e r53 = a.g(r51);     // Catch: Throwable -> L307
        if (r53 == null) goto L304;
        r53.d();     // Catch: Throwable -> L307
        Unit r54 = Unit.INSTANCE;     // Catch: Throwable -> L307
    L305:
        Result.m1421constructorimpl(r54);     // Catch: Throwable -> L307
        r2 = r44;
        goto L337
    L304:
        r54 = null;
    L307:
        th = move-exception;
        r39 = th;
        r40 = r44;
    L295:
        r50 = null;
        goto L296
    L290:
        r48 = null;
    L298:
        th = move-exception;
        Result.Companion r55 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L300
    L202:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L277 CancellationException -> L279
    L168:
        r8 = r16;
        goto L169
    L163:
        r6 = MigrationStep.FAILED;     // Catch: Throwable -> L207 CancellationException -> L209
        goto L165
    L158:
        t.f11981a.a("receiver: restore addons end");     // Catch: Throwable -> L207 CancellationException -> L209
        goto L159
    L9:
        File r56 = (File) ZeusTransformUtils.preCheckCast(r1.L$1, File.class, "com.obric.memorydata.plugin");
        al r57 = (al) ZeusTransformUtils.preCheckCast(r1.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r29);     // Catch: Throwable -> L27 CancellationException -> L29
        r17 = ", message=";
        r16 = "导入失败";
        r18 = "receiver: cleanup end";
        Object r58 = r29;
    L145:
        r7 = (z) ZeusTransformUtils.preCheckCast(r58, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L207 CancellationException -> L209
        if (ZeusTransformUtils.instanceOf(r7, z.a.class) == false) goto L150;
        t r59 = t.f11981a;     // Catch: Throwable -> L129 CancellationException -> L131
        String r60 = "receiver: db restore failed, " + ((z.a) ZeusTransformUtils.preCheckCast(r7, z.a.class, "com.obric.memorydata.plugin")).a().b();     // Catch: Throwable -> L129 CancellationException -> L131
        int r61 = 2;
        Throwable r62 = null;
    L127:
        t.a(r59, r60, r62, r61, r62);     // Catch: Throwable -> L129 CancellationException -> L131
        goto L159
    L150:
        if (ZeusTransformUtils.instanceOf(r7, z.b.class) == false) goto L204;
        t.f11981a.a("receiver: db restore end, restore addons begin count=" + a.a(r1.this$0).size());     // Catch: Throwable -> L207 CancellationException -> L209
        a r63 = r1.this$0;     // Catch: Throwable -> L207 CancellationException -> L209
        m r64 = r1.$callback;     // Catch: Throwable -> L207 CancellationException -> L209
        Continuation r65 = (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L207 CancellationException -> L209
        r1.L$0 = r57;     // Catch: Throwable -> L207 CancellationException -> L209
        r1.L$1 = null;     // Catch: Throwable -> L207 CancellationException -> L209
        r1.label = 7;     // Catch: Throwable -> L207 CancellationException -> L209
        r4 = a.b(r63, r56, r64, r65);     // Catch: Throwable -> L207 CancellationException -> L209
        if (r4 != r2) goto L154;
        return r2;
    L204:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L277 CancellationException -> L279
    L12:
        al r66 = (al) ZeusTransformUtils.preCheckCast(r1.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r29);     // Catch: Throwable -> L27 CancellationException -> L29
        r57 = r66;
        r17 = ", message=";
        r16 = "导入失败";
        r18 = "receiver: cleanup end";
        Object r67 = r29;
    L124:
        r7 = (z) ZeusTransformUtils.preCheckCast(r67, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L207 CancellationException -> L209
        if (ZeusTransformUtils.instanceOf(r7, z.a.class) == false) goto L134;
        r59 = t.f11981a;     // Catch: Throwable -> L129 CancellationException -> L131
        r60 = "receiver: zip unpack failed, " + ((z.a) ZeusTransformUtils.preCheckCast(r7, z.a.class, "com.obric.memorydata.plugin")).a().b();     // Catch: Throwable -> L129 CancellationException -> L131
        r61 = 2;
        r62 = null;
        goto L127
    L134:
        if (ZeusTransformUtils.instanceOf(r7, z.b.class) == false) goto L206;
        if (a.c(r1.this$0) == false) goto L139;
        a r68 = r1.this$0;     // Catch: Throwable -> L129 CancellationException -> L131
    L113:
        r7 = a.d(r68);     // Catch: Throwable -> L129 CancellationException -> L131
        goto L159
    L139:
        r56 = (File) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r7, z.b.class, "com.obric.memorydata.plugin")).a(), File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L207 CancellationException -> L209
        t.f11981a.a("receiver: zip unpack end, dir=" + r56.getAbsolutePath());     // Catch: Throwable -> L207 CancellationException -> L209
        t.f11981a.a("receiver: db restore begin");     // Catch: Throwable -> L207 CancellationException -> L209
        b r69 = r1.$config.f();     // Catch: Throwable -> L207 CancellationException -> L209
        if (r69 != null) goto L142;
        r69 = a.j(r1.this$0);     // Catch: Throwable -> L129 CancellationException -> L131
    L142:
        com.obric.memorydata.migration.sdk.internal.a.a.f11904a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.i(r1.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r69.c(), r56);     // Catch: Throwable -> L207 CancellationException -> L209
        com.obric.memorydata.migration.sdk.internal.db.b r110 = a.k(r1.this$0);     // Catch: Throwable -> L207 CancellationException -> L209
        File r210 = r1.$config.d();     // Catch: Throwable -> L207 CancellationException -> L209
        b r211 = r1.$config.f();     // Catch: Throwable -> L207 CancellationException -> L209
        boolean r212 = r1.$config.g();     // Catch: Throwable -> L207 CancellationException -> L209
        m r70 = r1.$callback;     // Catch: Throwable -> L207 CancellationException -> L209
        Continuation<? super z<Unit>> r213 = (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L207 CancellationException -> L209
        r1.L$0 = r57;     // Catch: Throwable -> L207 CancellationException -> L209
        r1.L$1 = r56;     // Catch: Throwable -> L207 CancellationException -> L209
        r1.label = 6;     // Catch: Throwable -> L207 CancellationException -> L209
        r58 = r110.a(r56, r210, r211, r212, r70, r213);     // Catch: Throwable -> L207 CancellationException -> L209
        if (r58 != r2) goto L145;
        return r2;
    L206:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L277 CancellationException -> L279
    L15:
        w r71 = (w) ZeusTransformUtils.preCheckCast(r1.L$3, w.class, "com.obric.memorydata.plugin");
        File r111 = (File) ZeusTransformUtils.preCheckCast(r1.L$2, File.class, "com.obric.memorydata.plugin");
        e r72 = (e) ZeusTransformUtils.preCheckCast(r1.L$1, e.class, "com.obric.memorydata.plugin");
        al r112 = (al) ZeusTransformUtils.preCheckCast(r1.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r29);     // Catch: Throwable -> L27 CancellationException -> L29
        r17 = ", message=";
        r16 = "导入失败";
        r18 = "receiver: cleanup end";
    L120:
        a.b(r1.$callback, (p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.RESTORING, "恢复中"), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L207 CancellationException -> L209
        File r73 = new File(r111, "migration_unpack_" + System.currentTimeMillis());     // Catch: Throwable -> L207 CancellationException -> L209
        a.d(r1.this$0, r73);     // Catch: Throwable -> L207 CancellationException -> L209
        m r74 = r1.$callback;     // Catch: Throwable -> L207 CancellationException -> L209
        String r75 = r73.getAbsolutePath();     // Catch: Throwable -> L207 CancellationException -> L209
        Intrinsics.checkNotNullExpressionValue(r75, "getAbsolutePath(...)");     // Catch: Throwable -> L207 CancellationException -> L209
        a.b(r74, (p) ZeusTransformUtils.preCheckCast(new p.a("unpack_dir", r75, 0, 4, null), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L207 CancellationException -> L209
        t.f11981a.a("receiver: zip unpack begin, dir=" + r73.getAbsolutePath());     // Catch: Throwable -> L207 CancellationException -> L209
        com.obric.memorydata.migration.sdk.internal.archive.a r214 = a.f(r1.this$0);     // Catch: Throwable -> L207 CancellationException -> L209
        File r215 = r71.a();     // Catch: Throwable -> L207 CancellationException -> L209
        m r76 = r1.$callback;     // Catch: Throwable -> L207 CancellationException -> L209
        byte[] r216 = r72.c();     // Catch: Throwable -> L207 CancellationException -> L209
        Continuation<? super z<? extends File>> r217 = (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L207 CancellationException -> L209
        r1.L$0 = r112;     // Catch: Throwable -> L207 CancellationException -> L209
        r1.L$1 = null;     // Catch: Throwable -> L207 CancellationException -> L209
        r1.L$2 = null;     // Catch: Throwable -> L207 CancellationException -> L209
        r1.L$3 = null;     // Catch: Throwable -> L207 CancellationException -> L209
        r1.label = 5;     // Catch: Throwable -> L207 CancellationException -> L209
        r67 = r214.a(r215, r73, r76, r216, r217);     // Catch: Throwable -> L207 CancellationException -> L209
        if (r67 != r2) goto L123;
        return r2;
    L123:
        r57 = r112;
        goto L124
    L18:
        File r77 = (File) ZeusTransformUtils.preCheckCast(r1.L$2, File.class, "com.obric.memorydata.plugin");
        e r78 = (e) ZeusTransformUtils.preCheckCast(r1.L$1, e.class, "com.obric.memorydata.plugin");
        r112 = (al) ZeusTransformUtils.preCheckCast(r1.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r29);     // Catch: Throwable -> L27 CancellationException -> L29
        r111 = r77;
        e r79 = r78;
        Object r80 = r29;
    L100:
        r7 = (z) ZeusTransformUtils.preCheckCast(r80, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L281 CancellationException -> L309
        if (ZeusTransformUtils.instanceOf(r7, z.a.class) == false) goto L105;
        t.a(t.f11981a, "receiver: transfer receive failed, " + ((z.a) ZeusTransformUtils.preCheckCast(r7, z.a.class, "com.obric.memorydata.plugin")).a().b(), null, 2, null);     // Catch: Throwable -> L27 CancellationException -> L29
        r17 = ", message=";
        r16 = "导入失败";
        r18 = "receiver: cleanup end";
        goto L159
    L105:
        if (ZeusTransformUtils.instanceOf(r7, z.b.class) == false) goto L214;
        Object r81 = ((z.b) ZeusTransformUtils.preCheckCast(r7, z.b.class, "com.obric.memorydata.plugin")).a();     // Catch: Throwable -> L281 CancellationException -> L309
        m r113 = r1.$callback;     // Catch: Throwable -> L281 CancellationException -> L309
        w r114 = (w) ZeusTransformUtils.preCheckCast(r81, w.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L281 CancellationException -> L309
        r16 = "导入失败";
        r18 = "receiver: cleanup end";
        String r82 = r114.a().getAbsolutePath();     // Catch: Throwable -> L207 CancellationException -> L209
        Intrinsics.checkNotNullExpressionValue(r82, "getAbsolutePath(...)");     // Catch: Throwable -> L207 CancellationException -> L209
        r17 = ", message=";
        a.b(r113, (p) ZeusTransformUtils.preCheckCast(new p.a("receiver_zip", r82, r114.b()), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L207 CancellationException -> L209
        w r83 = (w) ZeusTransformUtils.preCheckCast(r81, w.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L207 CancellationException -> L209
        t.f11981a.a("receiver: transfer receive end, size=" + r83.b() + 'B');     // Catch: Throwable -> L207 CancellationException -> L209
        if (a.c(r1.this$0) == false) goto L116;
        r68 = r1.this$0;     // Catch: Throwable -> L129 CancellationException -> L131
        goto L113
    L116:
        Continuation r84 = (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L207 CancellationException -> L209
        r1.L$0 = r112;     // Catch: Throwable -> L207 CancellationException -> L209
        r1.L$1 = r79;     // Catch: Throwable -> L207 CancellationException -> L209
        r1.L$2 = r111;     // Catch: Throwable -> L207 CancellationException -> L209
        r1.L$3 = r83;     // Catch: Throwable -> L207 CancellationException -> L209
        r1.label = 4;     // Catch: Throwable -> L207 CancellationException -> L209
        if (au.a(100, r84) != r2) goto L119;
        return r2;
    L119:
        r72 = r79;
        r71 = r83;
        goto L120
    L309:
        e = e;
        r2 = "receiver: cleanup end";
    L211:
        th = th;
    L283:
        r2 = "receiver: cleanup end";
    L281:
        th = th;
        r16 = "导入失败";
        goto L283
    L214:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L277 CancellationException -> L279
    L21:
        r79 = (e) ZeusTransformUtils.preCheckCast(r1.L$1, e.class, "com.obric.memorydata.plugin");
        al r85 = (al) ZeusTransformUtils.preCheckCast(r1.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r29);     // Catch: Throwable -> L27 CancellationException -> L29
    L96:
        a.b(r1.$callback, (p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.BACKING_UP, "备份中"), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L281 CancellationException -> L309
        File r115 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.i(r1.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir().getParentFile(), "migration_work");     // Catch: Throwable -> L281 CancellationException -> L309
        r115.mkdirs();     // Catch: Throwable -> L281 CancellationException -> L309
        File r116 = new File(r115, "migration_recv_" + System.currentTimeMillis() + ".zip");     // Catch: Throwable -> L281 CancellationException -> L309
        a.c(r1.this$0, r116);     // Catch: Throwable -> L281 CancellationException -> L309
        t.f11981a.a("receiver: transfer receive begin, dest=" + r116.getAbsolutePath());     // Catch: Throwable -> L281 CancellationException -> L309
        EncryptedTcpTransfer r117 = a.e(r1.this$0);     // Catch: Throwable -> L281 CancellationException -> L309
        m r118 = r1.$callback;     // Catch: Throwable -> L281 CancellationException -> L309
        Continuation<? super z<w>> r119 = (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L281 CancellationException -> L309
        r1.L$0 = r85;     // Catch: Throwable -> L281 CancellationException -> L309
        r1.L$1 = r79;     // Catch: Throwable -> L281 CancellationException -> L309
        r1.L$2 = r115;     // Catch: Throwable -> L281 CancellationException -> L309
        al r120 = r85;
        r1.label = 3;     // Catch: Throwable -> L281 CancellationException -> L309
        r80 = r117.a(r79, r116, r118, r119);     // Catch: Throwable -> L281 CancellationException -> L309
        if (r80 != r2) goto L99;
        return r2;
    L99:
        r111 = r115;
        r112 = r120;
        goto L100
    L24:
        al r86 = (al) ZeusTransformUtils.preCheckCast(r1.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r29);     // Catch: Throwable -> L27 CancellationException -> L29
        Object r87 = r29;
    L39:
        z r88 = (z) ZeusTransformUtils.preCheckCast(r87, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L281 CancellationException -> L309
        String r121 = "";
        if (ZeusTransformUtils.instanceOf(r88, z.b.class) == false) goto L216;
        e r89 = (e) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r88, z.b.class, "com.obric.memorydata.plugin")).a(), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L281 CancellationException -> L309
        t r122 = t.f11981a;     // Catch: Throwable -> L281 CancellationException -> L309
        StringBuilder r123 = new StringBuilder().append("receiver: connected to sender, protocol=");     // Catch: Throwable -> L281 CancellationException -> L309
        if (ZeusTransformUtils.instanceOf(r89, e.a.class) == false) goto L45;
        e.a r124 = (e.a) ZeusTransformUtils.preCheckCast(r89, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27 CancellationException -> L29
    L46:
        if (r124 == null) goto L51;
        MigrationSecurityProtocol r125 = r124.g();     // Catch: Throwable -> L27 CancellationException -> L29
        if (r125 == null) goto L51;
        String r126 = r125.getWireVersion();     // Catch: Throwable -> L27 CancellationException -> L29
    L52:
        if (r126 == null) goto L55;
        r121 = r126;
    L55:
        r122.a(r123.append(r121).toString());     // Catch: Throwable -> L281 CancellationException -> L309
        if (ZeusTransformUtils.instanceOf(r89, e.a.class) == false) goto L58;
        e.a r127 = (e.a) ZeusTransformUtils.preCheckCast(r89, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27 CancellationException -> L29
    L59:
        if (r127 == null) goto L63;
        Socket r128 = r127.e();     // Catch: Throwable -> L27 CancellationException -> L29
        if (r128 == null) goto L63;
        r128.setKeepAlive(true);     // Catch: Throwable -> L27 CancellationException -> L29
        Unit r129 = Unit.INSTANCE;     // Catch: Throwable -> L27 CancellationException -> L29
    L63:
        a.a(r1.this$0, r89);     // Catch: Throwable -> L281 CancellationException -> L309
        if (a.c(r1.this$0) == false) goto L92;
        z r90 = a.d(r1.this$0);     // Catch: Throwable -> L27 CancellationException -> L29
        t.f11981a.a("receiver: cleanup begin");
        a r91 = r1.this$0;
        Result.Companion r92 = Result.Companion;     // Catch: Throwable -> L78
        e r93 = a.g(r91);     // Catch: Throwable -> L78
        if (ZeusTransformUtils.instanceOf(r93, e.a.class) == false) goto L70;
        e.a r94 = (e.a) ZeusTransformUtils.preCheckCast(r93, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L78
    L71:
        if (r94 == null) goto L75;
        byte[] r130 = r94.f();     // Catch: Throwable -> L78
        if (r130 == null) goto L75;
        ArraysKt.fill$default(r130, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L78
        Unit r95 = Unit.INSTANCE;     // Catch: Throwable -> L78
    L76:
        Result.m1421constructorimpl(r95);     // Catch: Throwable -> L78
    L80:
        a r96 = r1.this$0;
        Result.Companion r97 = Result.Companion;     // Catch: Throwable -> L87
        e r98 = a.g(r96);     // Catch: Throwable -> L87
        if (r98 == null) goto L84;
        r98.d();     // Catch: Throwable -> L87
        Unit r99 = Unit.INSTANCE;     // Catch: Throwable -> L87
    L85:
        Result.m1421constructorimpl(r99);     // Catch: Throwable -> L87
    L89:
        a.a(r1.this$0, null);
        a.a(r1.this$0, false, 1, null);
        t.f11981a.a("receiver: cleanup end");
        return r90;
    L84:
        r99 = null;
    L87:
        th = move-exception;
        Result.Companion r100 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L75:
        r95 = null;
        goto L76
    L70:
        r94 = null;
    L78:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L80
    L92:
        Continuation r131 = (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L281 CancellationException -> L309
        r1.L$0 = r86;     // Catch: Throwable -> L281 CancellationException -> L309
        r1.L$1 = r89;     // Catch: Throwable -> L281 CancellationException -> L309
        r1.label = 2;     // Catch: Throwable -> L281 CancellationException -> L309
        if (au.a(1000, r131) != r2) goto L95;
        return r2;
    L95:
        r85 = r86;
        r79 = r89;
        goto L96
    L58:
        r127 = null;
    L51:
        r126 = null;
        goto L52
    L45:
        r124 = null;
        goto L46
    L216:
        if (ZeusTransformUtils.instanceOf(r88, z.a.class) == false) goto L276;
        t r102 = t.f11981a;     // Catch: Throwable -> L277 CancellationException -> L279
        StringBuilder r103 = new StringBuilder().append("receiver: connect failed, protocol=");     // Catch: Throwable -> L277 CancellationException -> L279
        String r104 = r1.$config.c().a().getProtocolVersion();     // Catch: Throwable -> L277 CancellationException -> L279
        if (r104 == null) goto L221;
        r121 = r104;
    L221:
        r102.a(r103.append(r121).append(", code=").append(((z.a) ZeusTransformUtils.preCheckCast(r88, z.a.class, "com.obric.memorydata.plugin")).a().a()).append(", message=").append(((z.a) ZeusTransformUtils.preCheckCast(r88, z.a.class, "com.obric.memorydata.plugin")).a().b()).toString(), ((z.a) ZeusTransformUtils.preCheckCast(r88, z.a.class, "com.obric.memorydata.plugin")).a().c());     // Catch: Throwable -> L277 CancellationException -> L279
        if (a.c(r1.this$0) == false) goto L249;
        z r105 = a.d(r1.this$0);     // Catch: Throwable -> L277 CancellationException -> L279
        t.f11981a.a("receiver: cleanup begin");
        a r106 = r1.this$0;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L236
        e r108 = a.g(r106);     // Catch: Throwable -> L236
        if (ZeusTransformUtils.instanceOf(r108, e.a.class) == false) goto L228;
        e.a r109 = (e.a) ZeusTransformUtils.preCheckCast(r108, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L236
    L229:
        if (r109 == null) goto L233;
        byte[] r132 = r109.f();     // Catch: Throwable -> L236
        if (r132 == null) goto L233;
        ArraysKt.fill$default(r132, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L236
        Unit r133 = Unit.INSTANCE;     // Catch: Throwable -> L236
    L234:
        Result.m1421constructorimpl(r133);     // Catch: Throwable -> L236
    L238:
        a r134 = r1.this$0;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L245
        e r136 = a.g(r134);     // Catch: Throwable -> L245
        if (r136 == null) goto L242;
        r136.d();     // Catch: Throwable -> L245
        Unit r137 = Unit.INSTANCE;     // Catch: Throwable -> L245
    L243:
        Result.m1421constructorimpl(r137);     // Catch: Throwable -> L245
    L247:
        a.a(r1.this$0, null);
        a.a(r1.this$0, false, 1, null);
        t.f11981a.a("receiver: cleanup end");
        return r105;
    L242:
        r137 = null;
    L245:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L233:
        r133 = null;
        goto L234
    L228:
        r109 = null;
    L236:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L238
    L249:
        a.b(r1.$callback, (p) ZeusTransformUtils.preCheckCast(new p.b(MigrationStep.CONNECTING, ((z.a) ZeusTransformUtils.preCheckCast(r88, z.a.class, "com.obric.memorydata.plugin")).a()), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L277 CancellationException -> L279
        t.f11981a.a("receiver: cleanup begin");
        a r140 = r1.this$0;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L262
        e r142 = a.g(r140);     // Catch: Throwable -> L262
        if (ZeusTransformUtils.instanceOf(r142, e.a.class) == false) goto L254;
        e.a r143 = (e.a) ZeusTransformUtils.preCheckCast(r142, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L262
    L255:
        if (r143 == null) goto L259;
        byte[] r144 = r143.f();     // Catch: Throwable -> L262
        if (r144 == null) goto L259;
        ArraysKt.fill$default(r144, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L262
        Unit r145 = Unit.INSTANCE;     // Catch: Throwable -> L262
    L260:
        Result.m1421constructorimpl(r145);     // Catch: Throwable -> L262
    L264:
        a r146 = r1.this$0;
        Result.Companion r147 = Result.Companion;     // Catch: Throwable -> L271
        e r148 = a.g(r146);     // Catch: Throwable -> L271
        if (r148 == null) goto L268;
        r148.d();     // Catch: Throwable -> L271
        Unit r149 = Unit.INSTANCE;     // Catch: Throwable -> L271
    L269:
        Result.m1421constructorimpl(r149);     // Catch: Throwable -> L271
    L273:
        a.a(r1.this$0, null);
        a.a(r1.this$0, false, 1, null);
        t.f11981a.a("receiver: cleanup end");
        return r88;
    L268:
        r149 = null;
    L271:
        th = move-exception;
        Result.Companion r150 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L259:
        r145 = null;
        goto L260
    L254:
        r143 = null;
    L262:
        th = move-exception;
        Result.Companion r151 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L264
    L276:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L277 CancellationException -> L279
    L31:
        ResultKt.throwOnFailure(r29);
        r86 = (al) ZeusTransformUtils.preCheckCast(r1.L$0, al.class, "com.obric.memorydata.plugin");
        a.a(r1.this$0, false);     // Catch: Throwable -> L281 CancellationException -> L309
        a.b(r1.this$0, true);     // Catch: Throwable -> L281 CancellationException -> L309
        t r152 = t.f11981a;     // Catch: Throwable -> L281 CancellationException -> L309
        StringBuilder r153 = new StringBuilder().append("receiver: run begin, appVersionCode=").append(r1.$config.b()).append(", hasBackupConfigOverride=");     // Catch: Throwable -> L281 CancellationException -> L309
        if (r1.$config.f() == null) goto L35;
        boolean r154 = true;
    L36:
        r152.a(r153.append(r154).append(", clearNonRestoredTables=").append(r1.$config.g()).append(", addons=").append(a.a(r1.this$0).size()).toString());     // Catch: Throwable -> L281 CancellationException -> L309
        a.b(r1.$callback, (p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.CONNECTING, "连接中"), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L281 CancellationException -> L309
        com.obric.memorydata.migration.sdk.internal.net.a r155 = a.b(r1.this$0);     // Catch: Throwable -> L281 CancellationException -> L309
        d r156 = r1.$config.c();     // Catch: Throwable -> L281 CancellationException -> L309
        String r157 = r1.$config.a();     // Catch: Throwable -> L281 CancellationException -> L309
        Continuation<? super z<? extends e>> r158 = (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L281 CancellationException -> L309
        r1.L$0 = r86;     // Catch: Throwable -> L281 CancellationException -> L309
        r1.label = 1;     // Catch: Throwable -> L281 CancellationException -> L309
        r87 = r155.a(r156, r157, r158);     // Catch: Throwable -> L281 CancellationException -> L309
        if (r87 != r2) goto L39;
        return r2;
    L35:
        r154 = false;
        goto L36
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L340:
        th = move-exception;
        t.f11981a.a(r9);
        a r159 = r1.this$0;
        Result.Companion r160 = Result.Companion;     // Catch: Throwable -> L353
        e r161 = a.g(r159);     // Catch: Throwable -> L353
        if (ZeusTransformUtils.instanceOf(r161, e.a.class) == false) goto L345;
        e.a r162 = (e.a) ZeusTransformUtils.preCheckCast(r161, e.a.class, r13);     // Catch: Throwable -> L353
    L346:
        if (r162 == null) goto L350;
        byte[] r163 = r162.f();     // Catch: Throwable -> L353
        if (r163 == null) goto L350;
        ArraysKt.fill$default(r163, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L353
        Unit r164 = Unit.INSTANCE;     // Catch: Throwable -> L353
    L351:
        Result.m1421constructorimpl(r164);     // Catch: Throwable -> L353
    L355:
        a r165 = r1.this$0;
        Result.Companion r166 = Result.Companion;     // Catch: Throwable -> L362
        e r167 = a.g(r165);     // Catch: Throwable -> L362
        if (r167 == null) goto L359;
        r167.d();     // Catch: Throwable -> L362
        Unit r168 = Unit.INSTANCE;     // Catch: Throwable -> L362
    L360:
        Result.m1421constructorimpl(r168);     // Catch: Throwable -> L362
    L364:
        a.a(r1.this$0, null);
        a.a(r1.this$0, false, 1, null);
        t.f11981a.a(r2);
        throw th;
    L359:
        r168 = null;
    L362:
        th = move-exception;
        Result.Companion r169 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L350:
        r164 = null;
        goto L351
    L345:
        r162 = null;
    L353:
        th = move-exception;
        Result.Companion r170 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L131:
        e = move-exception;
        r26 = e;
        r27 = r18;
    L129:
        th = move-exception;
        r43 = th;
        r44 = r18;
    L29:
        e = move-exception;
        r26 = e;
        r27 = "receiver: cleanup end";
    L27:
        th = move-exception;
        r43 = th;
        r16 = "导入失败";
        r44 = "receiver: cleanup end";
    L279:
        e = e;
    L277:
        th = th;
        goto L284
    }
}
