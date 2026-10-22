package com.obric.memorydata.migration.sdk.internal.run;

import androidx.core.app.NotificationCompat;
import com.bytedance.crash.constants.Constants;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.MigrationStep;
import com.obric.memorydata.migration.sdk.ah;
import com.obric.memorydata.migration.sdk.d;
import com.obric.memorydata.migration.sdk.e;
import com.obric.memorydata.migration.sdk.f;
import com.obric.memorydata.migration.sdk.g;
import com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.p;
import com.obric.memorydata.migration.sdk.q;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.w;
import com.obric.memorydata.migration.sdk.y;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.run.MigrationRunner$runSender$2", f = "MigrationRunner.kt", i = {0, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 6, 7, 7, 7, 8, 8, 8, 9, 10, 10, 10, 10, 11, 12, 12, 12, 13, 14, 14, 14, 15, 16, 17, 17, 17, 17, 18, 18, 18, 18, 19, 19, 19, 20, 21, 21, 22, 23}, l = {93, 138, 142, 146, 154, 157, 290, Constants.UPLOAD_DISASTER_DROP, 227, 290, 237, 290, 247, 290, 253, 290, 290, 267, 271, 276, 290, 284, 290, 290}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "$this$withContext", Ext.KEY_REQUEST, "qrUpdateJob", "$this$withContext", "r", "$this$withContext", Ext.KEY_REQUEST, "socket", "$this$withContext", Ext.KEY_REQUEST, "socket", "$this$withContext", "$this$withContext", "conn", "senderHeartbeatJob", "$this$withContext", "senderHeartbeatJob", NotificationCompat.CATEGORY_ERROR, "$this$withContext", "$this$withContext", "conn", "senderHeartbeatJob", "backupDir", "$this$withContext", "$this$withContext", "conn", "senderHeartbeatJob", "$this$withContext", "$this$withContext", "senderHeartbeatJob", "r", "$this$withContext", "$this$withContext", "$this$withContext", "conn", "senderHeartbeatJob", "pkg", "$this$withContext", "conn", "senderHeartbeatJob", "pkg", "$this$withContext", "senderHeartbeatJob", "pkg", "$this$withContext", "$this$withContext", "senderHeartbeatJob", "$this$withContext", "$this$withContext"}, s = {"L$0", "L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$0", "L$1", "L$2", "L$0", "L$0", "L$1", "L$2", "L$0", "L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$0", "L$1", "L$0", "L$0"})
final class MigrationRunner$runSender$2 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends Unit>>, Object> {
    final /* synthetic */ m $callback;
    final /* synthetic */ ah $config;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ a this$0;

    MigrationRunner$runSender$2(a r3, ah r4, m r5, Continuation<? super MigrationRunner$runSender$2> r6) {
        m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$config = r4;
        this.$callback = r7;
        super(2, r8);
    }

    public static final /* synthetic */ Object access$invokeSuspend$notifyReceiverNoSpace(a r2, al r3, bx r4, e r5, Continuation r6) {
        return invokeSuspend$notifyReceiverNoSpace(r2, (al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (bx) ZeusTransformUtils.wrapperContextForParams(r4, bx.class, "com.obric.memorydata.plugin"), r5, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private static final CharSequence invokeSuspend$lambda$0(g r2) {
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a() + '(' + r2.b() + ')', CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final Object invokeSuspend$notifyReceiverNoSpace(a r7, al r8, bx r9, e r10, Continuation<? super Unit> r11) {
        al r12 = (al) ZeusTransformUtils.wrapperContextForParams(r8, al.class, "com.obric.memorydata.plugin");
        bx r13 = (bx) ZeusTransformUtils.wrapperContextForParams(r9, bx.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, MigrationRunner$runSender$2$notifyReceiverNoSpace$1.class) == false) goto L7;
        MigrationRunner$runSender$2$notifyReceiverNoSpace$1 r0 = (MigrationRunner$runSender$2$notifyReceiverNoSpace$1) ZeusTransformUtils.preCheckCast(r14, MigrationRunner$runSender$2$notifyReceiverNoSpace$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L23;
        if (r3 == 1) goto L18;
        if (r3 != 2) goto L17;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
    L36:
        Result.m1421constructorimpl((z) ZeusTransformUtils.preCheckCast(r15, z.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
    L40:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r10 = (e) ZeusTransformUtils.preCheckCast(r0.L$2, e.class, "com.obric.memorydata.plugin");
        al r16 = (al) ZeusTransformUtils.preCheckCast(r0.L$1, al.class, "com.obric.memorydata.plugin");
        r7 = (a) ZeusTransformUtils.preCheckCast(r0.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L21
    L30:
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L33:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L14
        EncryptedTcpTransfer r18 = a.e(r7);     // Catch: Throwable -> L14
        r0.L$0 = null;     // Catch: Throwable -> L14
        r0.L$1 = null;     // Catch: Throwable -> L14
        r0.L$2 = null;     // Catch: Throwable -> L14
        r0.label = 2;     // Catch: Throwable -> L14
        r15 = r18.a(r10, "旧机存储空间不足，导出失败", r0);     // Catch: Throwable -> L14
        if (r15 != r2) goto L36;
        return r2;
    L23:
        ResultKt.throwOnFailure(r15);
        if (a.c(r7) == true) goto L26;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L21
        bx.a.a(r13, null, 1, null);     // Catch: Throwable -> L21
        r0.L$0 = r7;     // Catch: Throwable -> L21
        r0.L$1 = r12;     // Catch: Throwable -> L21
        r0.L$2 = r10;     // Catch: Throwable -> L21
        r0.label = 1;     // Catch: Throwable -> L21
        if (r13.a_(r0) != r2) goto L30;
        return r2;
    L26:
        return Unit.INSTANCE;
    L21:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L14:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        r0 = new MigrationRunner$runSender$2$notifyReceiverNoSpace$1(r14);
        goto L8
    }

    public static /* synthetic */ CharSequence lambda$132qHZN82QIm7fXDl1x0qiH461k(g r0) {
        return invokeSuspend$lambda$0(r0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        MigrationRunner$runSender$2 r0 = new MigrationRunner$runSender$2(this.this$0, this.$config, this.$callback, r7);
        r0.L$0 = r5;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends Unit>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<Unit>> r4) {
        return ((MigrationRunner$runSender$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MigrationRunner$runSender$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0129: MOVE (r6 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:30:0x0127 */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x01ce: MOVE (r6 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:47:0x01cd */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v30 */
    /* JADX WARN: Type inference failed for: r13v31, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v60 */
    /* JADX WARN: Type inference failed for: r13v67, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v68 */
    /* JADX WARN: Type inference failed for: r13v69 */
    /* JADX WARN: Type inference failed for: r13v70 */
    /* JADX WARN: Type inference failed for: r13v71 */
    /* JADX WARN: Type inference failed for: r13v72 */
    /* JADX WARN: Type inference failed for: r13v73 */
    /* JADX WARN: Type inference failed for: r13v74 */
    /* JADX WARN: Type inference failed for: r13v75, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v76 */
    /* JADX WARN: Type inference failed for: r13v77 */
    /* JADX WARN: Type inference failed for: r13v78 */
    /* JADX WARN: Type inference failed for: r13v79 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v80 */
    /* JADX WARN: Type inference failed for: r13v81 */
    /* JADX WARN: Type inference failed for: r13v82 */
    /* JADX WARN: Type inference failed for: r13v83 */
    /* JADX WARN: Type inference failed for: r13v84 */
    /* JADX WARN: Type inference failed for: r13v85 */
    /* JADX WARN: Type inference failed for: r13v86 */
    /* JADX WARN: Type inference failed for: r13v87 */
    /* JADX WARN: Type inference failed for: r13v88 */
    /* JADX WARN: Type inference failed for: r13v89 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r13v90 */
    /* JADX WARN: Type inference failed for: r13v91 */
    /* JADX WARN: Type inference failed for: r13v92 */
    /* JADX WARN: Type inference failed for: r13v93 */
    /* JADX WARN: Type inference failed for: r13v94 */
    /* JADX WARN: Type inference failed for: r13v95 */
    /* JADX WARN: Type inference failed for: r13v96 */
    /* JADX WARN: Type inference failed for: r16v0, types: [java.lang.Object, kotlinx.coroutines.bx] */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.obric.memorydata.migration.sdk.t] */
    /* JADX WARN: Type inference failed for: r1v18, types: [com.obric.memorydata.migration.sdk.t] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.memorydata.migration.sdk.t] */
    /* JADX WARN: Type inference failed for: r1v30, types: [com.obric.memorydata.migration.sdk.t] */
    /* JADX WARN: Type inference failed for: r1v32, types: [com.obric.memorydata.migration.sdk.t] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.obric.memorydata.migration.sdk.t] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.obric.memorydata.migration.sdk.t] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v269, types: [com.obric.memorydata.migration.sdk.t] */
    /* JADX WARN: Type inference failed for: r3v28, types: [com.obric.memorydata.migration.sdk.t] */
    /* JADX WARN: Type inference failed for: r3v298, types: [com.obric.memorydata.migration.sdk.t] */
    /* JADX WARN: Type inference failed for: r3v381, types: [java.lang.Object, kotlinx.coroutines.bx] */
    /* JADX WARN: Type inference failed for: r3v489 */
    /* JADX WARN: Type inference failed for: r3v55, types: [com.obric.memorydata.migration.sdk.t] */
    /* JADX WARN: Type inference failed for: r3v599, types: [java.lang.Object, kotlinx.coroutines.bx] */
    /* JADX WARN: Type inference failed for: r3v604 */
    /* JADX WARN: Type inference failed for: r3v617 */
    /* JADX WARN: Type inference failed for: r3v662, types: [kotlinx.coroutines.bx] */
    /* JADX WARN: Type inference failed for: r3v700 */
    /* JADX WARN: Type inference failed for: r3v701 */
    /* JADX WARN: Type inference failed for: r3v702 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v107 */
    /* JADX WARN: Type inference failed for: r4v108 */
    /* JADX WARN: Type inference failed for: r4v109, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v198 */
    /* JADX WARN: Type inference failed for: r4v199 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v306 */
    /* JADX WARN: Type inference failed for: r4v307 */
    /* JADX WARN: Type inference failed for: r4v308 */
    /* JADX WARN: Type inference failed for: r4v309 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v103 */
    /* JADX WARN: Type inference failed for: r5v106, types: [kotlinx.coroutines.bx] */
    /* JADX WARN: Type inference failed for: r5v112 */
    /* JADX WARN: Type inference failed for: r5v118 */
    /* JADX WARN: Type inference failed for: r5v124, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v129 */
    /* JADX WARN: Type inference failed for: r5v130, types: [java.lang.Object, kotlinx.coroutines.bx] */
    /* JADX WARN: Type inference failed for: r5v136 */
    /* JADX WARN: Type inference failed for: r5v150 */
    /* JADX WARN: Type inference failed for: r5v151 */
    /* JADX WARN: Type inference failed for: r5v152 */
    /* JADX WARN: Type inference failed for: r5v153 */
    /* JADX WARN: Type inference failed for: r5v154 */
    /* JADX WARN: Type inference failed for: r5v155 */
    /* JADX WARN: Type inference failed for: r5v156 */
    /* JADX WARN: Type inference failed for: r5v157 */
    /* JADX WARN: Type inference failed for: r5v160 */
    /* JADX WARN: Type inference failed for: r5v19, types: [kotlinx.coroutines.bx] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v59 */
    /* JADX WARN: Type inference failed for: r5v68 */
    /* JADX WARN: Type inference failed for: r5v69 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v74 */
    /* JADX WARN: Type inference failed for: r5v75, types: [kotlinx.coroutines.bx] */
    /* JADX WARN: Type inference failed for: r5v80 */
    /* JADX WARN: Type inference failed for: r5v83, types: [java.lang.Object, kotlinx.coroutines.bx] */
    /* JADX WARN: Type inference failed for: r5v90 */
    /* JADX WARN: Type inference failed for: r5v91, types: [java.lang.Object, kotlinx.coroutines.bx] */
    /* JADX WARN: Type inference failed for: r5v93 */
    /* JADX WARN: Type inference failed for: r7v61, types: [java.lang.StringBuilder] */
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
    public final Object invokeSuspend(Object r33) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r3 = this.label;
        ?? r4 = "getAbsolutePath(...)";
        ?? r5 = "";
        String r10 = "sender: cleanup end";
        String r11 = "sender: cleanup begin";
        ?? r13 = 1;
        ?? r14 = 1;
        r14 = 1;
        switch(r3) {
            case 0: goto L98;
            case 1: goto L91;
            case 2: goto L88;
            case 3: goto L85;
            case 4: goto L82;
            case 5: goto L79;
            case 6: goto L76;
            case 7: goto L73;
            case 8: goto L66;
            case 9: goto L60;
            case 10: goto L57;
            case 11: goto L51;
            case 12: goto L48;
            case 13: goto L43;
            case 14: goto L40;
            case 15: goto L37;
            case 16: goto L34;
            case 17: goto L31;
            case 18: goto L26;
            case 19: goto L23;
            case 20: goto L20;
            case 21: goto L17;
            case 22: goto L12;
            case 23: goto L9;
            case 24: goto L6;
            default: goto L5;
        };
    L6:
        Throwable r6 = (Throwable) ZeusTransformUtils.preCheckCast(this.L$1, Throwable.class, "com.obric.memorydata.plugin");
        al r7 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L94 CancellationException -> L96
        throw r6;     // Catch: Throwable -> L770 CancellationException -> L772
    L9:
        z r8 = (z) ZeusTransformUtils.preCheckCast(this.L$1, z.class, "com.obric.memorydata.plugin");
        al r9 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L94 CancellationException -> L96
        r13 = "sender: cleanup end";
        String r12 = "sender: cleanup begin";
    L362:
        t.f11981a.a(r12);
        a r15 = this.this$0;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L374
        e r17 = a.g(r15);     // Catch: Throwable -> L374
        if (ZeusTransformUtils.instanceOf(r17, e.a.class) == false) goto L366;
        e.a r18 = (e.a) ZeusTransformUtils.preCheckCast(r17, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L374
    L367:
        if (r18 == null) goto L371;
        byte[] r19 = r18.f();     // Catch: Throwable -> L374
        if (r19 == null) goto L371;
        ArraysKt.fill$default(r19, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L374
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L374
    L372:
        Result.m1421constructorimpl(r20);     // Catch: Throwable -> L374
    L376:
        a r21 = this.this$0;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L383
        e r23 = a.g(r21);     // Catch: Throwable -> L383
        if (r23 == null) goto L380;
        r23.d();     // Catch: Throwable -> L383
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L383
    L381:
        Result.m1421constructorimpl(r24);     // Catch: Throwable -> L383
    L385:
        a r25 = this.this$0;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L392
        ServerSocket r27 = a.h(r25);     // Catch: Throwable -> L392
        if (r27 == null) goto L389;
        r27.close();     // Catch: Throwable -> L392
        Unit r28 = Unit.INSTANCE;     // Catch: Throwable -> L392
    L390:
        Result.m1421constructorimpl(r28);     // Catch: Throwable -> L392
    L395:
        a.a(this.this$0, null);
        a.a(this.this$0, null);
        a.a(this.this$0, false, 1, null);
        t.f11981a.a(r13);
        return r8;
    L389:
        r28 = null;
    L392:
        th = move-exception;
        Throwable r29 = th;
        r13 = r13;
    L394:
        Result.Companion r30 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(r29));
        goto L395
    L380:
        r24 = null;
    L383:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L371:
        r20 = null;
        goto L372
    L366:
        r18 = null;
    L374:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L376
    L12:
        bx r34 = (bx) ZeusTransformUtils.preCheckCast(this.L$1, bx.class, "com.obric.memorydata.plugin");
        al r35 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L15
        al r36 = r35;
        ?? r110 = "sender: cleanup end";
        r12 = "sender: cleanup begin";
        ?? r37 = r34;
    L353:
        a.a(this.$callback, (p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.SUCCESS, "导出成功"), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L396
        t.f11981a.a("sender: run success");     // Catch: Throwable -> L396
        if (a.c(this.this$0) == false) goto L356;
        z r38 = a.d(this.this$0);     // Catch: Throwable -> L396
    L358:
        bx.a.a(r37, null, 1, null);     // Catch: Throwable -> L770 CancellationException -> L772
        Continuation r39 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$0 = r36;     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$1 = r38;     // Catch: Throwable -> L770 CancellationException -> L772
        this.label = 23;     // Catch: Throwable -> L770 CancellationException -> L772
        if (r37.a_(r39) != r2) goto L361;
        return r2;
    L361:
        r8 = r38;
        r13 = r110;
        goto L362
    L356:
        r38 = (z) ZeusTransformUtils.preCheckCast(new z.b(Unit.INSTANCE), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L396
    L15:
        th = th;
        r5 = r34;
        al r40 = r35;
    L72:
        Throwable r41 = th;
        ?? r42 = r5;
        Object r43 = r40;
    L601:
        bx.a.a(r42, null, 1, null);     // Catch: Throwable -> L770 CancellationException -> L772
        Continuation r44 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$0 = r43;     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$1 = r41;     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$2 = null;     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$3 = null;     // Catch: Throwable -> L770 CancellationException -> L772
        this.label = 24;     // Catch: Throwable -> L770 CancellationException -> L772
        if (r42.a_(r44) != r2) goto L605;
        return r2;
    L605:
        throw r41;     // Catch: Throwable -> L770 CancellationException -> L772
    L17:
        z r45 = (z) ZeusTransformUtils.preCheckCast(this.L$1, z.class, "com.obric.memorydata.plugin");
        al r46 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L94 CancellationException -> L96
        ?? r111 = "sender: cleanup end";
        r12 = "sender: cleanup begin";
    L315:
        t.f11981a.a(r12);
        a r47 = this.this$0;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L327
        e r49 = a.g(r47);     // Catch: Throwable -> L327
        if (ZeusTransformUtils.instanceOf(r49, e.a.class) == false) goto L319;
        e.a r50 = (e.a) ZeusTransformUtils.preCheckCast(r49, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L327
    L320:
        if (r50 == null) goto L324;
        byte[] r51 = r50.f();     // Catch: Throwable -> L327
        if (r51 == null) goto L324;
        ArraysKt.fill$default(r51, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L327
        Unit r52 = Unit.INSTANCE;     // Catch: Throwable -> L327
    L325:
        Result.m1421constructorimpl(r52);     // Catch: Throwable -> L327
    L329:
        a r53 = this.this$0;
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L336
        e r55 = a.g(r53);     // Catch: Throwable -> L336
        if (r55 == null) goto L333;
        r55.d();     // Catch: Throwable -> L336
        Unit r56 = Unit.INSTANCE;     // Catch: Throwable -> L336
    L334:
        Result.m1421constructorimpl(r56);     // Catch: Throwable -> L336
    L338:
        a r57 = this.this$0;
        Result.Companion r58 = Result.Companion;     // Catch: Throwable -> L345
        ServerSocket r59 = a.h(r57);     // Catch: Throwable -> L345
        if (r59 == null) goto L342;
        r59.close();     // Catch: Throwable -> L345
        Unit r60 = Unit.INSTANCE;     // Catch: Throwable -> L345
    L343:
        Result.m1421constructorimpl(r60);     // Catch: Throwable -> L345
    L347:
        a.a(this.this$0, null);
        a.a(this.this$0, null);
        a.a(this.this$0, false, 1, null);
        t.f11981a.a(r111);
        return r45;
    L342:
        r60 = null;
    L345:
        th = move-exception;
        Result.Companion r61 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L347
    L333:
        r56 = null;
    L336:
        th = move-exception;
        Result.Companion r62 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L324:
        r52 = null;
        goto L325
    L319:
        r50 = null;
    L327:
        th = move-exception;
        Result.Companion r63 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L329
    L20:
        w r64 = (w) ZeusTransformUtils.preCheckCast(this.L$2, w.class, "com.obric.memorydata.plugin");
        bx r65 = (bx) ZeusTransformUtils.preCheckCast(this.L$1, bx.class, "com.obric.memorydata.plugin");
        al r66 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L63
        Object r67 = r33;
        al r68 = r66;
        ?? r112 = "sender: cleanup end";
        ?? r69 = r65;
        r12 = "sender: cleanup begin";
    L303:
        z r70 = (z) ZeusTransformUtils.preCheckCast(r67, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L592
        if (ZeusTransformUtils.instanceOf(r70, z.a.class) == false) goto L349;
        t.a(t.f11981a, "sender: transfer send failed, " + ((z.a) ZeusTransformUtils.preCheckCast(r70, z.a.class, "com.obric.memorydata.plugin")).a().b(), null, 2, null);     // Catch: Throwable -> L592
        a.a(this.$callback, (p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.FAILED, "导出失败"), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L592
        if (a.c(this.this$0) == false) goto L309;
        z r71 = a.d(this.this$0);     // Catch: Throwable -> L592
    L311:
        bx.a.a(r69, null, 1, null);     // Catch: Throwable -> L770 CancellationException -> L772
        Continuation r72 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$0 = r68;     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$1 = r71;     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$2 = null;     // Catch: Throwable -> L770 CancellationException -> L772
        this.label = 21;     // Catch: Throwable -> L770 CancellationException -> L772
        if (r69.a_(r72) != r2) goto L314;
        return r2;
    L314:
        r45 = r71;
        r111 = r112;
        goto L315
    L309:
        r71 = r70;
        goto L311
    L349:
        t.f11981a.a("sender: transfer send end, size=" + r64.b() + 'B');     // Catch: Throwable -> L592
        Continuation r73 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L592
        this.L$0 = r68;     // Catch: Throwable -> L592
        this.L$1 = r69;     // Catch: Throwable -> L592
        this.L$2 = null;     // Catch: Throwable -> L592
        this.label = 22;     // Catch: Throwable -> L592
        if (au.a(100, r73) != r2) goto L352;
        return r2;
    L352:
        r37 = r69;
        r36 = r68;
        r110 = r112;
        goto L353
    L23:
        r64 = (w) ZeusTransformUtils.preCheckCast(this.L$3, w.class, "com.obric.memorydata.plugin");
        bx r74 = (bx) ZeusTransformUtils.preCheckCast(this.L$2, bx.class, "com.obric.memorydata.plugin");
        e r75 = (e) ZeusTransformUtils.preCheckCast(this.L$1, e.class, "com.obric.memorydata.plugin");
        al r76 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L29
        al r77 = r76;
        ?? r113 = "sender: cleanup end";
        e r78 = r75;
        ?? r79 = r74;
        r12 = "sender: cleanup begin";
    L300:
        a.a(this.$callback, (p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.TRANSFERRING, "传输中"), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L592
        t.f11981a.a("sender: transfer send begin, size=" + r64.b() + 'B');     // Catch: Throwable -> L592
        EncryptedTcpTransfer r80 = a.e(this.this$0);     // Catch: Throwable -> L592
        m r114 = this.$callback;     // Catch: Throwable -> L592
        Continuation<? super z<Unit>> r115 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L592
        this.L$0 = r77;     // Catch: Throwable -> L592
        this.L$1 = r79;     // Catch: Throwable -> L592
        this.L$2 = r64;     // Catch: Throwable -> L592
        this.L$3 = null;     // Catch: Throwable -> L592
        this.label = 20;     // Catch: Throwable -> L592
        r67 = r80.a(r78, r64, r114, r115);     // Catch: Throwable -> L592
        r69 = r79;
        r68 = r77;
        r112 = r113;
        if (r67 != r2) goto L303;
        return r2;
    L26:
        w r81 = (w) ZeusTransformUtils.preCheckCast(this.L$3, w.class, "com.obric.memorydata.plugin");
        bx r82 = (bx) ZeusTransformUtils.preCheckCast(this.L$2, bx.class, "com.obric.memorydata.plugin");
        e r83 = (e) ZeusTransformUtils.preCheckCast(this.L$1, e.class, "com.obric.memorydata.plugin");
        al r84 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L29
        al r85 = r84;
        int r86 = 1;
        r78 = r83;
        ?? r116 = "sender: cleanup end";
        CancellationException r117 = null;
        w r87 = r81;
        ?? r88 = r82;
        r12 = "sender: cleanup begin";
    L296:
        bx.a.a(r88, r117, r86, r117);     // Catch: Throwable -> L396
        Continuation r89 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L396
        this.L$0 = r85;     // Catch: Throwable -> L396
        this.L$1 = r78;     // Catch: Throwable -> L396
        this.L$2 = r88;     // Catch: Throwable -> L396
        this.L$3 = r87;     // Catch: Throwable -> L396
        this.label = 19;     // Catch: Throwable -> L396
        if (r88.a_(r89) != r2) goto L299;
        return r2;
    L299:
        w r310 = r87;
        r79 = r88;
        r64 = r310;
        r77 = r85;
        r113 = r116;
        goto L300
    L31:
        z r90 = (z) ZeusTransformUtils.preCheckCast(this.L$1, z.class, "com.obric.memorydata.plugin");
        al r91 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L94 CancellationException -> L96
        ?? r118 = "sender: cleanup end";
        String r119 = "sender: cleanup begin";
    L253:
        t.f11981a.a(r119);
        a r92 = this.this$0;
        Result.Companion r93 = Result.Companion;     // Catch: Throwable -> L265
        e r94 = a.g(r92);     // Catch: Throwable -> L265
        if (ZeusTransformUtils.instanceOf(r94, e.a.class) == false) goto L257;
        e.a r95 = (e.a) ZeusTransformUtils.preCheckCast(r94, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L265
    L258:
        if (r95 == null) goto L262;
        byte[] r96 = r95.f();     // Catch: Throwable -> L265
        if (r96 == null) goto L262;
        ArraysKt.fill$default(r96, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L265
        Unit r97 = Unit.INSTANCE;     // Catch: Throwable -> L265
    L263:
        Result.m1421constructorimpl(r97);     // Catch: Throwable -> L265
    L267:
        a r98 = this.this$0;
        Result.Companion r99 = Result.Companion;     // Catch: Throwable -> L274
        e r100 = a.g(r98);     // Catch: Throwable -> L274
        if (r100 == null) goto L271;
        r100.d();     // Catch: Throwable -> L274
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L274
    L272:
        Result.m1421constructorimpl(r101);     // Catch: Throwable -> L274
    L276:
        a r102 = this.this$0;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L283
        ServerSocket r104 = a.h(r102);     // Catch: Throwable -> L283
        if (r104 == null) goto L280;
        r104.close();     // Catch: Throwable -> L283
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L283
    L281:
        Result.m1421constructorimpl(r105);     // Catch: Throwable -> L283
    L285:
        a.a(this.this$0, null);
        a.a(this.this$0, null);
        a.a(this.this$0, false, 1, null);
        t.f11981a.a(r118);
        return r90;
    L280:
        r105 = null;
    L283:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L285
    L271:
        r101 = null;
    L274:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L262:
        r97 = null;
        goto L263
    L257:
        r95 = null;
    L265:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L267
    L34:
        z r109 = (z) ZeusTransformUtils.preCheckCast(this.L$1, z.class, "com.obric.memorydata.plugin");
        al r120 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L94 CancellationException -> L96
        String r121 = "sender: cleanup end";
        String r122 = "sender: cleanup begin";
    L457:
        t.f11981a.a(r122);
        a r123 = this.this$0;
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L469
        e r125 = a.g(r123);     // Catch: Throwable -> L469
        if (ZeusTransformUtils.instanceOf(r125, e.a.class) == false) goto L461;
        e.a r126 = (e.a) ZeusTransformUtils.preCheckCast(r125, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L469
    L462:
        if (r126 == null) goto L466;
        byte[] r127 = r126.f();     // Catch: Throwable -> L469
        if (r127 == null) goto L466;
        ArraysKt.fill$default(r127, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L469
        Unit r128 = Unit.INSTANCE;     // Catch: Throwable -> L469
    L467:
        Result.m1421constructorimpl(r128);     // Catch: Throwable -> L469
    L471:
        a r129 = this.this$0;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L478
        e r131 = a.g(r129);     // Catch: Throwable -> L478
        if (r131 == null) goto L475;
        r131.d();     // Catch: Throwable -> L478
        Unit r132 = Unit.INSTANCE;     // Catch: Throwable -> L478
    L476:
        Result.m1421constructorimpl(r132);     // Catch: Throwable -> L478
    L480:
        a r133 = this.this$0;
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L487
        ServerSocket r135 = a.h(r133);     // Catch: Throwable -> L487
        if (r135 == null) goto L484;
        r135.close();     // Catch: Throwable -> L487
        Unit r136 = Unit.INSTANCE;     // Catch: Throwable -> L487
    L485:
        Result.m1421constructorimpl(r136);     // Catch: Throwable -> L487
    L489:
        a.a(this.this$0, null);
        a.a(this.this$0, null);
        a.a(this.this$0, false, 1, null);
        t.f11981a.a(r121);
        return r109;
    L484:
        r136 = null;
    L487:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L489
    L475:
        r132 = null;
    L478:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L466:
        r128 = null;
        goto L467
    L461:
        r126 = null;
    L469:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L471
    L37:
        z r140 = (z) ZeusTransformUtils.preCheckCast(this.L$2, z.class, "com.obric.memorydata.plugin");
        bx r141 = (bx) ZeusTransformUtils.preCheckCast(this.L$1, bx.class, "com.obric.memorydata.plugin");
        al r142 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L63
        al r143 = r142;
        r121 = "sender: cleanup end";
        ?? r144 = r141;
        r122 = "sender: cleanup begin";
    L453:
        bx.a.a(r144, null, 1, null);     // Catch: Throwable -> L770 CancellationException -> L772
        Continuation r145 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$0 = r143;     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$1 = r140;     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$2 = null;     // Catch: Throwable -> L770 CancellationException -> L772
        this.label = 16;     // Catch: Throwable -> L770 CancellationException -> L772
        if (r144.a_(r145) != r2) goto L456;
        return r2;
    L456:
        r109 = r140;
        goto L457
    L40:
        z r146 = (z) ZeusTransformUtils.preCheckCast(this.L$1, z.class, "com.obric.memorydata.plugin");
        al r147 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L94 CancellationException -> L96
        r121 = "sender: cleanup end";
        r122 = "sender: cleanup begin";
    L413:
        t.f11981a.a(r122);
        a r148 = this.this$0;
        Result.Companion r149 = Result.Companion;     // Catch: Throwable -> L425
        e r150 = a.g(r148);     // Catch: Throwable -> L425
        if (ZeusTransformUtils.instanceOf(r150, e.a.class) == false) goto L417;
        e.a r151 = (e.a) ZeusTransformUtils.preCheckCast(r150, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L425
    L418:
        if (r151 == null) goto L422;
        byte[] r152 = r151.f();     // Catch: Throwable -> L425
        if (r152 == null) goto L422;
        ArraysKt.fill$default(r152, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L425
        Unit r153 = Unit.INSTANCE;     // Catch: Throwable -> L425
    L423:
        Result.m1421constructorimpl(r153);     // Catch: Throwable -> L425
    L427:
        a r154 = this.this$0;
        Result.Companion r155 = Result.Companion;     // Catch: Throwable -> L434
        e r156 = a.g(r154);     // Catch: Throwable -> L434
        if (r156 == null) goto L431;
        r156.d();     // Catch: Throwable -> L434
        Unit r157 = Unit.INSTANCE;     // Catch: Throwable -> L434
    L432:
        Result.m1421constructorimpl(r157);     // Catch: Throwable -> L434
    L436:
        a r158 = this.this$0;
        Result.Companion r159 = Result.Companion;     // Catch: Throwable -> L443
        ServerSocket r160 = a.h(r158);     // Catch: Throwable -> L443
        if (r160 == null) goto L440;
        r160.close();     // Catch: Throwable -> L443
        Unit r161 = Unit.INSTANCE;     // Catch: Throwable -> L443
    L441:
        Result.m1421constructorimpl(r161);     // Catch: Throwable -> L443
    L445:
        a.a(this.this$0, null);
        a.a(this.this$0, null);
        a.a(this.this$0, false, 1, null);
        t.f11981a.a(r121);
        return r146;
    L440:
        r161 = null;
    L443:
        th = move-exception;
        Result.Companion r162 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L445
    L431:
        r157 = null;
    L434:
        th = move-exception;
        Result.Companion r163 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L422:
        r153 = null;
        goto L423
    L417:
        r151 = null;
    L425:
        th = move-exception;
        Result.Companion r164 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L427
    L43:
        bx r165 = (bx) ZeusTransformUtils.preCheckCast(this.L$2, bx.class, "com.obric.memorydata.plugin");
        e r166 = (e) ZeusTransformUtils.preCheckCast(this.L$1, e.class, "com.obric.memorydata.plugin");
        al r167 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L46
        r40 = r167;
        r78 = r166;
        r5 = r165;
        Object r168 = r33;
    L233:
        r140 = (z) ZeusTransformUtils.preCheckCast(r168, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L542
        if (ZeusTransformUtils.instanceOf(r140, z.b.class) == false) goto L402;
        w r169 = (w) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r140, z.b.class, "com.obric.memorydata.plugin")).a(), w.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L542
        r14 = "sender: cleanup end";
        r119 = "sender: cleanup begin";
        t.f11981a.a(new StringBuilder().append("sender: zip pack end, file=").append(r169.a().getAbsolutePath()).append(", size=").append(r169.b()).append('B').toString());     // Catch: Throwable -> L400
        a.a(this.this$0, r169.a());     // Catch: Throwable -> L400
        m r170 = this.$callback;     // Catch: Throwable -> L400
        String r171 = r169.a().getAbsolutePath();     // Catch: Throwable -> L400
        Intrinsics.checkNotNullExpressionValue(r171, "getAbsolutePath(...)");     // Catch: Throwable -> L400
        ?? r172 = r5;
        a.a(r170, (p) ZeusTransformUtils.preCheckCast(new p.a("sender_zip", r171, r169.b()), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L398
        Result.Companion r173 = Result.Companion;     // Catch: Throwable -> L242
        ArraysKt.fill$default(((e.a) ZeusTransformUtils.preCheckCast(r78, e.a.class, "com.obric.memorydata.plugin")).f(), (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L242
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L242
    L245:
        t.f11981a.a("sender: archive key wiped after package encryption");     // Catch: Throwable -> L398
        if (a.c(this.this$0) == false) goto L291;
        z r174 = a.d(this.this$0);     // Catch: Throwable -> L398
        bx.a.a(r172, null, 1, null);     // Catch: Throwable -> L287 CancellationException -> L289
        Continuation r175 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L287 CancellationException -> L289
        this.L$0 = r40;     // Catch: Throwable -> L287 CancellationException -> L289
        this.L$1 = r174;     // Catch: Throwable -> L287 CancellationException -> L289
        this.L$2 = null;     // Catch: Throwable -> L287 CancellationException -> L289
        this.label = 17;     // Catch: Throwable -> L287 CancellationException -> L289
        if (r172.a_(r175) != r2) goto L252;
        return r2;
    L252:
        r90 = r174;
        r118 = r14;
        goto L253
    L289:
        e = e;
        r4 = r119;
    L890:
        CancellationException r176 = e;
        ?? r177 = r4;
        ?? r178 = r14;
    L891:
        t.f11981a.a("sender: cancelled", (Throwable) ZeusTransformUtils.preCheckCast(r176, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L925
        r8 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.OTHER, "已取消", (Throwable) ZeusTransformUtils.preCheckCast(r176, Throwable.class, "com.obric.memorydata.plugin"))), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L925
        t.f11981a.a(r177);
        a r179 = this.this$0;
        Result.Companion r180 = Result.Companion;     // Catch: Throwable -> L904
        e r181 = a.g(r179);     // Catch: Throwable -> L904
        if (ZeusTransformUtils.instanceOf(r181, e.a.class) == false) goto L896;
        e.a r182 = (e.a) ZeusTransformUtils.preCheckCast(r181, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L904
    L897:
        if (r182 == null) goto L901;
        byte[] r183 = r182.f();     // Catch: Throwable -> L904
        if (r183 == null) goto L901;
        ArraysKt.fill$default(r183, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L904
        Unit r184 = Unit.INSTANCE;     // Catch: Throwable -> L904
    L902:
        Result.m1421constructorimpl(r184);     // Catch: Throwable -> L904
    L906:
        a r185 = this.this$0;
        Result.Companion r186 = Result.Companion;     // Catch: Throwable -> L913
        e r187 = a.g(r185);     // Catch: Throwable -> L913
        if (r187 == null) goto L910;
        r187.d();     // Catch: Throwable -> L913
        Unit r188 = Unit.INSTANCE;     // Catch: Throwable -> L913
    L911:
        Result.m1421constructorimpl(r188);     // Catch: Throwable -> L913
    L915:
        a r189 = this.this$0;
        Result.Companion r190 = Result.Companion;     // Catch: Throwable -> L922
        ServerSocket r191 = a.h(r189);     // Catch: Throwable -> L922
        if (r191 == null) goto L919;
        r191.close();     // Catch: Throwable -> L922
        Unit r192 = Unit.INSTANCE;     // Catch: Throwable -> L922
    L920:
        Result.m1421constructorimpl(r192);     // Catch: Throwable -> L922
        r4 = r190;
        r13 = r178;
    L969:
        goto L395
    L919:
        r192 = null;
    L922:
        th = move-exception;
        r29 = th;
        r13 = r178;
        goto L394
    L910:
        r188 = null;
    L913:
        th = move-exception;
        Result.Companion r193 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L901:
        r184 = null;
        goto L902
    L896:
        r182 = null;
    L904:
        th = move-exception;
        Result.Companion r194 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L287:
        th = th;
        r4 = r119;
    L854:
        Throwable r195 = th;
        ?? r196 = r4;
        ?? r197 = r14;
    L855:
        t.f11981a.a("sender: failed", r195);     // Catch: Throwable -> L925
        a.a(this.$callback, (p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.FAILED, "导出失败"), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L925
        r8 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.OTHER, "发送端失败: " + r195.getMessage(), r195)), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L925
        t.f11981a.a(r196);
        a r198 = this.this$0;
        Result.Companion r199 = Result.Companion;     // Catch: Throwable -> L868
        e r200 = a.g(r198);     // Catch: Throwable -> L868
        if (ZeusTransformUtils.instanceOf(r200, e.a.class) == false) goto L860;
        e.a r201 = (e.a) ZeusTransformUtils.preCheckCast(r200, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L868
    L861:
        if (r201 == null) goto L865;
        byte[] r202 = r201.f();     // Catch: Throwable -> L868
        if (r202 == null) goto L865;
        ArraysKt.fill$default(r202, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L868
        Unit r203 = Unit.INSTANCE;     // Catch: Throwable -> L868
    L866:
        Result.m1421constructorimpl(r203);     // Catch: Throwable -> L868
    L870:
        a r204 = this.this$0;
        Result.Companion r205 = Result.Companion;     // Catch: Throwable -> L877
        e r206 = a.g(r204);     // Catch: Throwable -> L877
        if (r206 == null) goto L874;
        r206.d();     // Catch: Throwable -> L877
        Unit r207 = Unit.INSTANCE;     // Catch: Throwable -> L877
    L875:
        Result.m1421constructorimpl(r207);     // Catch: Throwable -> L877
    L879:
        a r208 = this.this$0;
        Result.Companion r209 = Result.Companion;     // Catch: Throwable -> L886
        ServerSocket r210 = a.h(r208);     // Catch: Throwable -> L886
        if (r210 == null) goto L883;
        r210.close();     // Catch: Throwable -> L886
        Unit r211 = Unit.INSTANCE;     // Catch: Throwable -> L886
    L884:
        Result.m1421constructorimpl(r211);     // Catch: Throwable -> L886
        r4 = r209;
        r13 = r197;
        goto L969
    L883:
        r211 = null;
    L886:
        th = move-exception;
        r29 = th;
        r13 = r197;
        goto L394
    L874:
        r207 = null;
    L877:
        th = move-exception;
        Result.Companion r212 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L865:
        r203 = null;
        goto L866
    L860:
        r201 = null;
    L868:
        th = move-exception;
        Result.Companion r213 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L870
    L291:
        r12 = r119;
        Continuation r1100 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L592
        this.L$0 = r40;     // Catch: Throwable -> L592
        this.L$1 = r78;     // Catch: Throwable -> L592
        this.L$2 = r172;     // Catch: Throwable -> L592
        this.L$3 = r169;     // Catch: Throwable -> L592
        this.label = 18;     // Catch: Throwable -> L592
        if (au.a(1000, r1100) != r2) goto L295;
        return r2;
    L295:
        r86 = 1;
        r117 = null;
        r87 = r169;
        r88 = r172;
        r85 = r40;
        r116 = r14;
        goto L296
    L242:
        th = move-exception;
        Result.Companion r214 = Result.Companion;     // Catch: Throwable -> L398
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L398
    L398:
        th = th;
        r5 = r172;
    L400:
        th = th;
    L542:
        th = th;
        goto L72
    L402:
        r121 = "sender: cleanup end";
        r122 = "sender: cleanup begin";
        if (ZeusTransformUtils.instanceOf(r140, z.a.class) == false) goto L492;
        if (a.c(this.this$0) == false) goto L447;
        z r215 = a.d(this.this$0);     // Catch: Throwable -> L592
        bx.a.a(r5, null, 1, null);     // Catch: Throwable -> L770 CancellationException -> L772
        Continuation r216 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$0 = r40;     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$1 = r215;     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$2 = null;     // Catch: Throwable -> L770 CancellationException -> L772
        this.label = 14;     // Catch: Throwable -> L770 CancellationException -> L772
        if (r5.a_(r216) != r2) goto L412;
        return r2;
    L412:
        r146 = r215;
        goto L413
    L447:
        a.a(this.$callback, (p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.FAILED, "导出失败"), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L592
        r144 = r5;
        r143 = r40;
        if (((z.a) ZeusTransformUtils.preCheckCast(r140, z.a.class, "com.obric.memorydata.plugin")).a().a() != MigrationErrorCode.NO_SPACE_LEFT) goto L453;
        a r217 = this.this$0;     // Catch: Throwable -> L592
        Continuation r1101 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L592
        this.L$0 = r40;     // Catch: Throwable -> L592
        this.L$1 = r5;     // Catch: Throwable -> L592
        this.L$2 = r140;     // Catch: Throwable -> L592
        this.label = 15;     // Catch: Throwable -> L592
        Object r218 = invokeSuspend$notifyReceiverNoSpace(r217, r40, r5, r78, r1101);     // Catch: Throwable -> L592
        r144 = r5;
        r143 = r40;
        if (r218 != r2) goto L453;
        return r2;
    L492:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L592
    L48:
        z r219 = (z) ZeusTransformUtils.preCheckCast(this.L$1, z.class, "com.obric.memorydata.plugin");
        al r220 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L94 CancellationException -> L96
    L506:
        t.f11981a.a("sender: cleanup begin");
        a r221 = this.this$0;
        Result.Companion r222 = Result.Companion;     // Catch: Throwable -> L518
        e r223 = a.g(r221);     // Catch: Throwable -> L518
        if (ZeusTransformUtils.instanceOf(r223, e.a.class) == false) goto L510;
        e.a r224 = (e.a) ZeusTransformUtils.preCheckCast(r223, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L518
    L511:
        if (r224 == null) goto L515;
        byte[] r225 = r224.f();     // Catch: Throwable -> L518
        if (r225 == null) goto L515;
        ArraysKt.fill$default(r225, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L518
        Unit r226 = Unit.INSTANCE;     // Catch: Throwable -> L518
    L516:
        Result.m1421constructorimpl(r226);     // Catch: Throwable -> L518
    L520:
        a r227 = this.this$0;
        Result.Companion r228 = Result.Companion;     // Catch: Throwable -> L527
        e r229 = a.g(r227);     // Catch: Throwable -> L527
        if (r229 == null) goto L524;
        r229.d();     // Catch: Throwable -> L527
        Unit r230 = Unit.INSTANCE;     // Catch: Throwable -> L527
    L525:
        Result.m1421constructorimpl(r230);     // Catch: Throwable -> L527
    L529:
        a r231 = this.this$0;
        Result.Companion r232 = Result.Companion;     // Catch: Throwable -> L536
        ServerSocket r233 = a.h(r231);     // Catch: Throwable -> L536
        if (r233 == null) goto L533;
        r233.close();     // Catch: Throwable -> L536
        Unit r234 = Unit.INSTANCE;     // Catch: Throwable -> L536
    L534:
        Result.m1421constructorimpl(r234);     // Catch: Throwable -> L536
    L538:
        a.a(this.this$0, null);
        a.a(this.this$0, null);
        a.a(this.this$0, false, 1, null);
        t.f11981a.a("sender: cleanup end");
        return r219;
    L533:
        r234 = null;
    L536:
        th = move-exception;
        Result.Companion r235 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L538
    L524:
        r230 = null;
    L527:
        th = move-exception;
        Result.Companion r236 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L515:
        r226 = null;
        goto L516
    L510:
        r224 = null;
    L518:
        th = move-exception;
        Result.Companion r237 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L520
    L51:
        File r238 = (File) ZeusTransformUtils.preCheckCast(this.L$3, File.class, "com.obric.memorydata.plugin");
        bx r239 = (bx) ZeusTransformUtils.preCheckCast(this.L$2, bx.class, "com.obric.memorydata.plugin");
        e r240 = (e) ZeusTransformUtils.preCheckCast(this.L$1, e.class, "com.obric.memorydata.plugin");
        al r241 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L54
        Object r242 = r33;
        r5 = r239;
        r40 = r241;
    L1077:
        z r243 = (z) ZeusTransformUtils.preCheckCast(r242, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L542
        if (ZeusTransformUtils.instanceOf(r243, z.b.class) == false) goto L494;
        t.f11981a.a("sender: export addons end");     // Catch: Throwable -> L542
        t.f11981a.a("sender: zip pack begin");     // Catch: Throwable -> L542
        com.obric.memorydata.migration.sdk.internal.archive.a r244 = a.f(this.this$0);     // Catch: Throwable -> L542
        m r1102 = this.$callback;     // Catch: Throwable -> L542
        byte[] r1103 = r240.c();     // Catch: Throwable -> L542
        Continuation<? super z<w>> r1104 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L542
        this.L$0 = r40;     // Catch: Throwable -> L542
        this.L$1 = r240;     // Catch: Throwable -> L542
        this.L$2 = r5;     // Catch: Throwable -> L542
        e r311 = r240;
        this.L$3 = null;     // Catch: Throwable -> L542
        this.label = 13;     // Catch: Throwable -> L542
        r168 = r244.a(r238, r1102, r1103, r1104);     // Catch: Throwable -> L542
        if (r168 != r2) goto L232;
        return r2;
    L232:
        r78 = r311;
        r5 = r5;
        r40 = r40;
        goto L233
    L494:
        if (ZeusTransformUtils.instanceOf(r243, z.a.class) == false) goto L541;
        t.a(t.f11981a, "sender: export addons failed, " + ((z.a) ZeusTransformUtils.preCheckCast(r243, z.a.class, "com.obric.memorydata.plugin")).a().b(), null, 2, null);     // Catch: Throwable -> L592
        Result.Companion r245 = Result.Companion;     // Catch: Throwable -> L498
        Result.m1421constructorimpl(Boxing.boxBoolean(FilesKt.deleteRecursively(r238)));     // Catch: Throwable -> L498
    L502:
        bx.a.a(r5, null, 1, null);     // Catch: Throwable -> L770 CancellationException -> L772
        Continuation r246 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$0 = r40;     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$1 = r243;     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$2 = null;     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$3 = null;     // Catch: Throwable -> L770 CancellationException -> L772
        this.label = 12;     // Catch: Throwable -> L770 CancellationException -> L772
        if (r5.a_(r246) != r2) goto L505;
        return r2;
    L505:
        r219 = r243;
    L498:
        th = move-exception;
        Result.Companion r247 = Result.Companion;     // Catch: Throwable -> L592
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L592
        goto L502
    L541:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L592
    L54:
        th = move-exception;
        r41 = th;
        Object r248 = r239;
        al r249 = r241;
    L56:
        Object r250 = r248;
        Object r251 = r249;
    L65:
        r42 = r250;
        r43 = r251;
        goto L601
    L57:
        z.a r252 = (z.a) ZeusTransformUtils.preCheckCast(this.L$1, z.a.class, "com.obric.memorydata.plugin");
        al r253 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L94 CancellationException -> L96
        r10 = "sender: cleanup end";
        r11 = "sender: cleanup begin";
    L558:
        t.f11981a.a(r11);
        a r254 = this.this$0;
        Result.Companion r255 = Result.Companion;     // Catch: Throwable -> L570
        e r256 = a.g(r254);     // Catch: Throwable -> L570
        if (ZeusTransformUtils.instanceOf(r256, e.a.class) == false) goto L562;
        e.a r257 = (e.a) ZeusTransformUtils.preCheckCast(r256, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L570
    L563:
        if (r257 == null) goto L567;
        byte[] r258 = r257.f();     // Catch: Throwable -> L570
        if (r258 == null) goto L567;
        ArraysKt.fill$default(r258, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L570
        Unit r259 = Unit.INSTANCE;     // Catch: Throwable -> L570
    L568:
        Result.m1421constructorimpl(r259);     // Catch: Throwable -> L570
    L572:
        a r260 = this.this$0;
        Result.Companion r261 = Result.Companion;     // Catch: Throwable -> L579
        e r262 = a.g(r260);     // Catch: Throwable -> L579
        if (r262 == null) goto L576;
        r262.d();     // Catch: Throwable -> L579
        Unit r263 = Unit.INSTANCE;     // Catch: Throwable -> L579
    L577:
        Result.m1421constructorimpl(r263);     // Catch: Throwable -> L579
    L581:
        a r264 = this.this$0;
        Result.Companion r265 = Result.Companion;     // Catch: Throwable -> L588
        ServerSocket r266 = a.h(r264);     // Catch: Throwable -> L588
        if (r266 == null) goto L585;
        r266.close();     // Catch: Throwable -> L588
        Unit r267 = Unit.INSTANCE;     // Catch: Throwable -> L588
    L586:
        Result.m1421constructorimpl(r267);     // Catch: Throwable -> L588
    L590:
        a.a(this.this$0, null);
        a.a(this.this$0, null);
        a.a(this.this$0, false, 1, null);
        t.f11981a.a(r10);
        return r252;
    L585:
        r267 = null;
    L588:
        th = move-exception;
        Result.Companion r268 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L590
    L576:
        r263 = null;
    L579:
        th = move-exception;
        Result.Companion r269 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L567:
        r259 = null;
        goto L568
    L562:
        r257 = null;
    L570:
        th = move-exception;
        Result.Companion r270 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L572
    L60:
        o r271 = (o) ZeusTransformUtils.preCheckCast(this.L$2, o.class, "com.obric.memorydata.plugin");
        bx r272 = (bx) ZeusTransformUtils.preCheckCast(this.L$1, bx.class, "com.obric.memorydata.plugin");
        al r273 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L63
        al r274 = r273;
        ?? r275 = r272;
    L552:
        z.a r276 = new z.a(r271);     // Catch: Throwable -> L592
        bx.a.a(r275, null, 1, null);     // Catch: Throwable -> L770 CancellationException -> L772
        Continuation r277 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$0 = r274;     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$1 = r276;     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$2 = null;     // Catch: Throwable -> L770 CancellationException -> L772
        this.label = 10;     // Catch: Throwable -> L770 CancellationException -> L772
        if (r275.a_(r277) != r2) goto L557;
        return r2;
    L557:
        r252 = r276;
        goto L558
    L66:
        bx r278 = (bx) ZeusTransformUtils.preCheckCast(this.L$2, bx.class, "com.obric.memorydata.plugin");
        e r279 = (e) ZeusTransformUtils.preCheckCast(this.L$1, e.class, "com.obric.memorydata.plugin");
        r40 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L69
        r3 = r278;
        r40 = r40;
    L983:
        a.a(this.$callback, (p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.BACKING_UP, "备份中"), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L595
        t.f11981a.a("sender: build backup dir begin");     // Catch: Throwable -> L595
        File r280 = a.a(this.this$0, this.$config.c());     // Catch: Throwable -> L544
        a.b(this.this$0, r280);     // Catch: Throwable -> L544
        m r281 = this.$callback;     // Catch: Throwable -> L595
        String r1105 = r280.getAbsolutePath();     // Catch: Throwable -> L595
        Intrinsics.checkNotNullExpressionValue(r1105, "getAbsolutePath(...)");     // Catch: Throwable -> L595
        a.a(r281, (p) ZeusTransformUtils.preCheckCast(new p.a("backup_dir", r1105, 0, 4, null), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L595
        t.f11981a.a("sender: build backup dir end, dir=" + r280.getAbsolutePath());     // Catch: Throwable -> L595
        t.f11981a.a("sender: export addons begin, count=" + a.a(this.this$0).size());     // Catch: Throwable -> L595
        a r282 = this.this$0;     // Catch: Throwable -> L595
        m r1106 = this.$callback;     // Catch: Throwable -> L595
        Continuation r1107 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L595
        this.L$0 = r40;     // Catch: Throwable -> L595
        this.L$1 = r279;     // Catch: Throwable -> L595
        this.L$2 = r3;     // Catch: Throwable -> L595
        this.L$3 = r280;     // Catch: Throwable -> L595
        this.label = 11;     // Catch: Throwable -> L595
        r242 = a.a(r282, r280, r1106, r1107);     // Catch: Throwable -> L595
        if (r242 != r2) goto L226;
        return r2;
    L226:
        e r312 = r279;
        r5 = r3;
        r238 = r280;
        r240 = r312;
        r40 = r40;
        goto L1077
    L544:
        th = move-exception;
        if (q.a(th) == false) goto L594;
        o r283 = new o(MigrationErrorCode.NO_SPACE_LEFT, "存储空间不足，无法导出备份: " + th.getMessage(), th);     // Catch: Throwable -> L396
        a.a(this.$callback, (p) ZeusTransformUtils.preCheckCast(new p.b(MigrationStep.BACKING_UP, r283), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L396
        a r284 = this.this$0;     // Catch: Throwable -> L396
        Continuation r1108 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L396
        this.L$0 = r40;     // Catch: Throwable -> L396
        this.L$1 = r3;     // Catch: Throwable -> L396
        this.L$2 = r283;     // Catch: Throwable -> L396
        this.label = 9;     // Catch: Throwable -> L396
        if (invokeSuspend$notifyReceiverNoSpace(r284, r40, r3, r279, r1108) != r2) goto L551;
        return r2;
    L551:
        r275 = r3;
        r271 = r283;
        r274 = r40;
        goto L552
    L594:
        throw th;     // Catch: Throwable -> L396
    L595:
        th = th;
    L597:
        r5 = r3;
    L69:
        th = th;
        r5 = r278;
        goto L72
    L73:
        z r285 = (z) ZeusTransformUtils.preCheckCast(this.L$1, z.class, "com.obric.memorydata.plugin");
        al r286 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L94 CancellationException -> L96
    L182:
        t.f11981a.a("sender: cleanup begin");
        a r287 = this.this$0;
        Result.Companion r288 = Result.Companion;     // Catch: Throwable -> L194
        e r289 = a.g(r287);     // Catch: Throwable -> L194
        if (ZeusTransformUtils.instanceOf(r289, e.a.class) == false) goto L186;
        e.a r290 = (e.a) ZeusTransformUtils.preCheckCast(r289, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L194
    L187:
        if (r290 == null) goto L191;
        byte[] r291 = r290.f();     // Catch: Throwable -> L194
        if (r291 == null) goto L191;
        ArraysKt.fill$default(r291, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L194
        Unit r292 = Unit.INSTANCE;     // Catch: Throwable -> L194
    L192:
        Result.m1421constructorimpl(r292);     // Catch: Throwable -> L194
    L196:
        a r293 = this.this$0;
        Result.Companion r294 = Result.Companion;     // Catch: Throwable -> L203
        e r295 = a.g(r293);     // Catch: Throwable -> L203
        if (r295 == null) goto L200;
        r295.d();     // Catch: Throwable -> L203
        Unit r296 = Unit.INSTANCE;     // Catch: Throwable -> L203
    L201:
        Result.m1421constructorimpl(r296);     // Catch: Throwable -> L203
    L205:
        a r297 = this.this$0;
        Result.Companion r298 = Result.Companion;     // Catch: Throwable -> L212
        ServerSocket r299 = a.h(r297);     // Catch: Throwable -> L212
        if (r299 == null) goto L209;
        r299.close();     // Catch: Throwable -> L212
        Unit r300 = Unit.INSTANCE;     // Catch: Throwable -> L212
    L210:
        Result.m1421constructorimpl(r300);     // Catch: Throwable -> L212
    L214:
        a.a(this.this$0, null);
        a.a(this.this$0, null);
        a.a(this.this$0, false, 1, null);
        t.f11981a.a("sender: cleanup end");
        return r285;
    L209:
        r300 = null;
    L212:
        th = move-exception;
        Result.Companion r301 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L214
    L200:
        r296 = null;
    L203:
        th = move-exception;
        Result.Companion r302 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L191:
        r292 = null;
        goto L192
    L186:
        r290 = null;
    L194:
        th = move-exception;
        Result.Companion r303 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L196
    L76:
        Socket r304 = (Socket) ZeusTransformUtils.preCheckCast(this.L$2, Socket.class, "com.obric.memorydata.plugin");
        d r305 = (d) ZeusTransformUtils.preCheckCast(this.L$1, d.class, "com.obric.memorydata.plugin");
        al r306 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L94 CancellationException -> L96
        Object r307 = r33;
    L171:
        z r308 = (z) ZeusTransformUtils.preCheckCast(r307, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L852 CancellationException -> L888
        if (ZeusTransformUtils.instanceOf(r308, z.b.class) == false) goto L606;
        r279 = (e) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r308, z.b.class, "com.obric.memorydata.plugin")).a(), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L852 CancellationException -> L888
        Intrinsics.checkNotNull(r279, "null cannot be cast to non-null type com.obric.memorydata.migration.sdk.Connection.Tcp");     // Catch: Throwable -> L852 CancellationException -> L888
        ((e.a) ZeusTransformUtils.preCheckCast(r279, e.a.class, "com.obric.memorydata.plugin")).e().setKeepAlive(true);     // Catch: Throwable -> L852 CancellationException -> L888
        t.f11981a.a("sender: handshake done, protocol=" + ((e.a) ZeusTransformUtils.preCheckCast(r279, e.a.class, "com.obric.memorydata.plugin")).g().getWireVersion() + ", connection established");     // Catch: Throwable -> L852 CancellationException -> L888
        a.a(this.this$0, r279);     // Catch: Throwable -> L852 CancellationException -> L888
        bx r309 = i.a(r306, (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new MigrationRunner$runSender$2$senderHeartbeatJob$1(this.this$0, r279, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);     // Catch: Throwable -> L852 CancellationException -> L888
    L598:
        th = th;
        r5 = r309;
        r40 = r306;
        goto L72
    L175:
        if (a.c(this.this$0) == false) goto L217;
        z r313 = a.d(this.this$0);     // Catch: Throwable -> L46
        bx.a.a(r309, null, 1, null);     // Catch: Throwable -> L94 CancellationException -> L96
        Continuation<? super Unit> r314 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L94 CancellationException -> L96
        this.L$0 = r306;     // Catch: Throwable -> L94 CancellationException -> L96
        this.L$1 = r313;     // Catch: Throwable -> L94 CancellationException -> L96
        this.L$2 = null;     // Catch: Throwable -> L94 CancellationException -> L96
        this.label = 7;     // Catch: Throwable -> L94 CancellationException -> L96
        if (r309.a_(r314) != r2) goto L181;
        return r2;
    L181:
        r285 = r313;
        goto L182
    L217:
        Continuation r315 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L598
        this.L$0 = r306;     // Catch: Throwable -> L598
        this.L$1 = r279;     // Catch: Throwable -> L598
        this.L$2 = r309;     // Catch: Throwable -> L598
        this.label = 8;     // Catch: Throwable -> L598
        if (au.a(500, r315) != r2) goto L220;
        return r2;
    L220:
        r40 = r306;
        r3 = r309;
        goto L983
    L888:
        e = e;
        r14 = "sender: cleanup end";
        r4 = "sender: cleanup begin";
    L852:
        th = th;
        r14 = "sender: cleanup end";
        r4 = "sender: cleanup begin";
        goto L854
    L606:
        r14 = "sender: cleanup end";
        r4 = "sender: cleanup begin";
        if (ZeusTransformUtils.instanceOf(r308, z.a.class) == false) goto L691;
        t r316 = t.f11981a;     // Catch: Throwable -> L770 CancellationException -> L772
        ?? r317 = new StringBuilder().append("sender: handshake failed, protocol=");     // Catch: Throwable -> L770 CancellationException -> L772
        String r318 = r305.a().getProtocolVersion();     // Catch: Throwable -> L770 CancellationException -> L772
        if (r318 != null) goto L611;
        ?? r319 = r5;
    L612:
        r316.a(r317.append(r319).append(", code=").append(((z.a) ZeusTransformUtils.preCheckCast(r308, z.a.class, "com.obric.memorydata.plugin")).a().a()).append(", message=").append(((z.a) ZeusTransformUtils.preCheckCast(r308, z.a.class, "com.obric.memorydata.plugin")).a().b()).toString(), ((z.a) ZeusTransformUtils.preCheckCast(r308, z.a.class, "com.obric.memorydata.plugin")).a().c());     // Catch: Throwable -> L770 CancellationException -> L772
        Result.Companion r320 = Result.Companion;     // Catch: Throwable -> L615
        r304.close();     // Catch: Throwable -> L615
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L615
    L619:
        if (a.c(this.this$0) == false) goto L655;
        z r321 = a.d(this.this$0);     // Catch: Throwable -> L770 CancellationException -> L772
        t.f11981a.a(r4);
        a r322 = this.this$0;
        Result.Companion r323 = Result.Companion;     // Catch: Throwable -> L633
        e r324 = a.g(r322);     // Catch: Throwable -> L633
        if (ZeusTransformUtils.instanceOf(r324, e.a.class) == false) goto L625;
        e.a r325 = (e.a) ZeusTransformUtils.preCheckCast(r324, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L633
    L626:
        if (r325 == null) goto L630;
        byte[] r326 = r325.f();     // Catch: Throwable -> L633
        if (r326 == null) goto L630;
        ArraysKt.fill$default(r326, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L633
        Unit r327 = Unit.INSTANCE;     // Catch: Throwable -> L633
    L631:
        Result.m1421constructorimpl(r327);     // Catch: Throwable -> L633
    L635:
        a r328 = this.this$0;
        Result.Companion r329 = Result.Companion;     // Catch: Throwable -> L642
        e r330 = a.g(r328);     // Catch: Throwable -> L642
        if (r330 == null) goto L639;
        r330.d();     // Catch: Throwable -> L642
        Unit r331 = Unit.INSTANCE;     // Catch: Throwable -> L642
    L640:
        Result.m1421constructorimpl(r331);     // Catch: Throwable -> L642
    L644:
        a r332 = this.this$0;
        Result.Companion r333 = Result.Companion;     // Catch: Throwable -> L651
        ServerSocket r334 = a.h(r332);     // Catch: Throwable -> L651
        if (r334 == null) goto L648;
        r334.close();     // Catch: Throwable -> L651
        Unit r335 = Unit.INSTANCE;     // Catch: Throwable -> L651
    L649:
        Result.m1421constructorimpl(r335);     // Catch: Throwable -> L651
    L653:
        a.a(this.this$0, null);
        a.a(this.this$0, null);
        a.a(this.this$0, false, 1, null);
        t.f11981a.a(r14);
        return r321;
    L648:
        r335 = null;
    L651:
        th = move-exception;
        Result.Companion r336 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L653
    L639:
        r331 = null;
    L642:
        th = move-exception;
        Result.Companion r337 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L630:
        r327 = null;
        goto L631
    L625:
        r325 = null;
    L633:
        th = move-exception;
        Result.Companion r338 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L635
    L655:
        z r339 = a.a(this.$callback, (z.a) ZeusTransformUtils.preCheckCast(r308, z.a.class, "com.obric.memorydata.plugin"), null, 4, null);     // Catch: Throwable -> L770 CancellationException -> L772
        t.f11981a.a(r4);
        a r340 = this.this$0;
        Result.Companion r341 = Result.Companion;     // Catch: Throwable -> L668
        e r342 = a.g(r340);     // Catch: Throwable -> L668
        if (ZeusTransformUtils.instanceOf(r342, e.a.class) == false) goto L660;
        e.a r343 = (e.a) ZeusTransformUtils.preCheckCast(r342, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L668
    L661:
        if (r343 == null) goto L665;
        byte[] r344 = r343.f();     // Catch: Throwable -> L668
        if (r344 == null) goto L665;
        ArraysKt.fill$default(r344, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L668
        Unit r345 = Unit.INSTANCE;     // Catch: Throwable -> L668
    L666:
        Result.m1421constructorimpl(r345);     // Catch: Throwable -> L668
    L670:
        a r346 = this.this$0;
        Result.Companion r347 = Result.Companion;     // Catch: Throwable -> L677
        e r348 = a.g(r346);     // Catch: Throwable -> L677
        if (r348 == null) goto L674;
        r348.d();     // Catch: Throwable -> L677
        Unit r349 = Unit.INSTANCE;     // Catch: Throwable -> L677
    L675:
        Result.m1421constructorimpl(r349);     // Catch: Throwable -> L677
    L679:
        a r350 = this.this$0;
        Result.Companion r351 = Result.Companion;     // Catch: Throwable -> L686
        ServerSocket r352 = a.h(r350);     // Catch: Throwable -> L686
        if (r352 == null) goto L683;
        r352.close();     // Catch: Throwable -> L686
        Unit r353 = Unit.INSTANCE;     // Catch: Throwable -> L686
    L684:
        Result.m1421constructorimpl(r353);     // Catch: Throwable -> L686
    L688:
        a.a(this.this$0, null);
        a.a(this.this$0, null);
        a.a(this.this$0, false, 1, null);
        t.f11981a.a(r14);
        return r339;
    L683:
        r353 = null;
    L686:
        th = move-exception;
        Result.Companion r354 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L688
    L674:
        r349 = null;
    L677:
        th = move-exception;
        Result.Companion r355 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L665:
        r345 = null;
        goto L666
    L660:
        r343 = null;
    L668:
        th = move-exception;
        Result.Companion r356 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L615:
        th = move-exception;
        Result.Companion r357 = Result.Companion;     // Catch: Throwable -> L770 CancellationException -> L772
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L770 CancellationException -> L772
        goto L619
    L611:
        r319 = r318;
        goto L612
    L691:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L770 CancellationException -> L772
    L79:
        r304 = (Socket) ZeusTransformUtils.preCheckCast(this.L$2, Socket.class, "com.obric.memorydata.plugin");
        r305 = (d) ZeusTransformUtils.preCheckCast(this.L$1, d.class, "com.obric.memorydata.plugin");
        r306 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L94 CancellationException -> L96
    L168:
        com.obric.memorydata.migration.sdk.internal.net.a r358 = a.b(this.this$0);     // Catch: Throwable -> L852 CancellationException -> L888
        String r1109 = this.$config.a();     // Catch: Throwable -> L852 CancellationException -> L888
        Continuation<? super z<? extends e>> r1110 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L852 CancellationException -> L888
        this.L$0 = r306;     // Catch: Throwable -> L852 CancellationException -> L888
        this.L$1 = r305;     // Catch: Throwable -> L852 CancellationException -> L888
        this.L$2 = r304;     // Catch: Throwable -> L852 CancellationException -> L888
        this.label = 6;     // Catch: Throwable -> L852 CancellationException -> L888
        r307 = r358.a(r304, r305, r1109, r1110);     // Catch: Throwable -> L852 CancellationException -> L888
        if (r307 != r2) goto L171;
        return r2;
    L82:
        z r359 = (z) ZeusTransformUtils.preCheckCast(this.L$1, z.class, "com.obric.memorydata.plugin");
        al r360 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L94 CancellationException -> L96
    L699:
        if (a.c(this.this$0) == false) goto L735;
        z r361 = a.d(this.this$0);     // Catch: Throwable -> L770 CancellationException -> L772
        t.f11981a.a("sender: cleanup begin");
        a r362 = this.this$0;
        Result.Companion r363 = Result.Companion;     // Catch: Throwable -> L713
        e r364 = a.g(r362);     // Catch: Throwable -> L713
        if (ZeusTransformUtils.instanceOf(r364, e.a.class) == false) goto L705;
        e.a r365 = (e.a) ZeusTransformUtils.preCheckCast(r364, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L713
    L706:
        if (r365 == null) goto L710;
        byte[] r366 = r365.f();     // Catch: Throwable -> L713
        if (r366 == null) goto L710;
        ArraysKt.fill$default(r366, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L713
        Unit r367 = Unit.INSTANCE;     // Catch: Throwable -> L713
    L711:
        Result.m1421constructorimpl(r367);     // Catch: Throwable -> L713
    L715:
        a r368 = this.this$0;
        Result.Companion r369 = Result.Companion;     // Catch: Throwable -> L722
        e r370 = a.g(r368);     // Catch: Throwable -> L722
        if (r370 == null) goto L719;
        r370.d();     // Catch: Throwable -> L722
        Unit r371 = Unit.INSTANCE;     // Catch: Throwable -> L722
    L720:
        Result.m1421constructorimpl(r371);     // Catch: Throwable -> L722
    L724:
        a r372 = this.this$0;
        Result.Companion r373 = Result.Companion;     // Catch: Throwable -> L731
        ServerSocket r374 = a.h(r372);     // Catch: Throwable -> L731
        if (r374 == null) goto L728;
        r374.close();     // Catch: Throwable -> L731
        Unit r375 = Unit.INSTANCE;     // Catch: Throwable -> L731
    L729:
        Result.m1421constructorimpl(r375);     // Catch: Throwable -> L731
    L733:
        a.a(this.this$0, null);
        a.a(this.this$0, null);
        a.a(this.this$0, false, 1, null);
        t.f11981a.a("sender: cleanup end");
        return r361;
    L728:
        r375 = null;
    L731:
        th = move-exception;
        Result.Companion r376 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L733
    L719:
        r371 = null;
    L722:
        th = move-exception;
        Result.Companion r377 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L710:
        r367 = null;
        goto L711
    L705:
        r365 = null;
    L713:
        th = move-exception;
        Result.Companion r378 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L715
    L735:
        z r379 = a.a(this.$callback, (z.a) ZeusTransformUtils.preCheckCast(r359, z.a.class, "com.obric.memorydata.plugin"), null, 4, null);     // Catch: Throwable -> L770 CancellationException -> L772
        t.f11981a.a(r11);
        a r380 = this.this$0;
        Result.Companion r381 = Result.Companion;     // Catch: Throwable -> L748
        e r382 = a.g(r380);     // Catch: Throwable -> L748
        if (ZeusTransformUtils.instanceOf(r382, e.a.class) == false) goto L740;
        e.a r383 = (e.a) ZeusTransformUtils.preCheckCast(r382, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L748
    L741:
        if (r383 == null) goto L745;
        byte[] r384 = r383.f();     // Catch: Throwable -> L748
        if (r384 == null) goto L745;
        ArraysKt.fill$default(r384, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L748
        Unit r385 = Unit.INSTANCE;     // Catch: Throwable -> L748
    L746:
        Result.m1421constructorimpl(r385);     // Catch: Throwable -> L748
    L750:
        a r386 = this.this$0;
        Result.Companion r387 = Result.Companion;     // Catch: Throwable -> L757
        e r388 = a.g(r386);     // Catch: Throwable -> L757
        if (r388 == null) goto L754;
        r388.d();     // Catch: Throwable -> L757
        Unit r389 = Unit.INSTANCE;     // Catch: Throwable -> L757
    L755:
        Result.m1421constructorimpl(r389);     // Catch: Throwable -> L757
    L759:
        a r390 = this.this$0;
        Result.Companion r391 = Result.Companion;     // Catch: Throwable -> L766
        ServerSocket r392 = a.h(r390);     // Catch: Throwable -> L766
        if (r392 == null) goto L763;
        r392.close();     // Catch: Throwable -> L766
        Unit r393 = Unit.INSTANCE;     // Catch: Throwable -> L766
    L764:
        Result.m1421constructorimpl(r393);     // Catch: Throwable -> L766
    L768:
        a.a(this.this$0, null);
        a.a(this.this$0, null);
        a.a(this.this$0, false, 1, null);
        t.f11981a.a(r10);
        return r379;
    L763:
        r393 = null;
    L766:
        th = move-exception;
        Result.Companion r394 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L768
    L754:
        r389 = null;
    L757:
        th = move-exception;
        Result.Companion r395 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L745:
        r385 = null;
        goto L746
    L740:
        r383 = null;
    L748:
        th = move-exception;
        Result.Companion r396 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L750
    L85:
        bx r397 = (bx) ZeusTransformUtils.preCheckCast(this.L$2, bx.class, "com.obric.memorydata.plugin");
        r305 = (d) ZeusTransformUtils.preCheckCast(this.L$1, d.class, "com.obric.memorydata.plugin");
        r306 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L94 CancellationException -> L96
        Object r398 = r33;
    L162:
        z r399 = (z) ZeusTransformUtils.preCheckCast(r398, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L852 CancellationException -> L888
        if (ZeusTransformUtils.instanceOf(r399, z.b.class) == false) goto L693;
        Socket r400 = (Socket) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r399, z.b.class, "com.obric.memorydata.plugin")).a(), Socket.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L852 CancellationException -> L888
        t.f11981a.a("sender: tcp accepted, start handshake");     // Catch: Throwable -> L852 CancellationException -> L888
        bx.a.a(r397, null, 1, null);     // Catch: Throwable -> L852 CancellationException -> L888
        Continuation<? super Unit> r1111 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L852 CancellationException -> L888
        this.L$0 = r306;     // Catch: Throwable -> L852 CancellationException -> L888
        this.L$1 = r305;     // Catch: Throwable -> L852 CancellationException -> L888
        this.L$2 = r400;     // Catch: Throwable -> L852 CancellationException -> L888
        this.label = 5;     // Catch: Throwable -> L852 CancellationException -> L888
        if (r397.a_(r1111) != r2) goto L167;
        return r2;
    L167:
        r304 = r400;
        goto L168
    L693:
        if (ZeusTransformUtils.instanceOf(r399, z.a.class) == false) goto L775;
        bx.a.a(r397, null, 1, null);     // Catch: Throwable -> L770 CancellationException -> L772
        Continuation<? super Unit> r401 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$0 = r306;     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$1 = r399;     // Catch: Throwable -> L770 CancellationException -> L772
        this.L$2 = null;     // Catch: Throwable -> L770 CancellationException -> L772
        this.label = 4;     // Catch: Throwable -> L770 CancellationException -> L772
        if (r397.a_(r401) != r2) goto L697;
        return r2;
    L697:
        r359 = r399;
        goto L699
    L775:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L770 CancellationException -> L772
    L88:
        al r402 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L94 CancellationException -> L96
    L123:
        z r403 = a.d(this.this$0);     // Catch: Throwable -> L94 CancellationException -> L96
        t.f11981a.a("sender: cleanup begin");
        a r404 = this.this$0;
        Result.Companion r405 = Result.Companion;     // Catch: Throwable -> L136
        e r406 = a.g(r404);     // Catch: Throwable -> L136
        if (ZeusTransformUtils.instanceOf(r406, e.a.class) == false) goto L128;
        e.a r407 = (e.a) ZeusTransformUtils.preCheckCast(r406, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L136
    L129:
        if (r407 == null) goto L133;
        byte[] r408 = r407.f();     // Catch: Throwable -> L136
        if (r408 == null) goto L133;
        ArraysKt.fill$default(r408, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L136
        Unit r409 = Unit.INSTANCE;     // Catch: Throwable -> L136
    L134:
        Result.m1421constructorimpl(r409);     // Catch: Throwable -> L136
    L138:
        a r410 = this.this$0;
        Result.Companion r411 = Result.Companion;     // Catch: Throwable -> L145
        e r412 = a.g(r410);     // Catch: Throwable -> L145
        if (r412 == null) goto L142;
        r412.d();     // Catch: Throwable -> L145
        Unit r413 = Unit.INSTANCE;     // Catch: Throwable -> L145
    L143:
        Result.m1421constructorimpl(r413);     // Catch: Throwable -> L145
    L147:
        a r414 = this.this$0;
        Result.Companion r415 = Result.Companion;     // Catch: Throwable -> L154
        ServerSocket r416 = a.h(r414);     // Catch: Throwable -> L154
        if (r416 == null) goto L151;
        r416.close();     // Catch: Throwable -> L154
        Unit r417 = Unit.INSTANCE;     // Catch: Throwable -> L154
    L152:
        Result.m1421constructorimpl(r417);     // Catch: Throwable -> L154
    L156:
        a.a(this.this$0, null);
        a.a(this.this$0, null);
        a.a(this.this$0, false, 1, null);
        t.f11981a.a("sender: cleanup end");
        return r403;
    L151:
        r417 = null;
    L154:
        th = move-exception;
        Result.Companion r418 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L156
    L142:
        r413 = null;
    L145:
        th = move-exception;
        Result.Companion r419 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L133:
        r409 = null;
        goto L134
    L128:
        r407 = null;
    L136:
        th = move-exception;
        Result.Companion r420 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L138
    L91:
        al r421 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);     // Catch: Throwable -> L94 CancellationException -> L96
        Object r422 = r33;
    L102:
        z r423 = (z) ZeusTransformUtils.preCheckCast(r422, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L852 CancellationException -> L888
        if (ZeusTransformUtils.instanceOf(r423, z.b.class) == false) goto L777;
        r305 = (d) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r423, z.b.class, "com.obric.memorydata.plugin")).a(), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L852 CancellationException -> L888
        t r424 = t.f11981a;     // Catch: Throwable -> L852 CancellationException -> L888
        StringBuilder r425 = new StringBuilder().append("sender: request ready, protocol=");     // Catch: Throwable -> L852 CancellationException -> L888
        String r1112 = r305.a().getProtocolVersion();     // Catch: Throwable -> L852 CancellationException -> L888
        if (r1112 != null) goto L107;
        r1112 = "";
    L107:
        StringBuilder r426 = r425.append(r1112).append(", endpointCount=");     // Catch: Throwable -> L852 CancellationException -> L888
        List<String> r1113 = r305.a().getEndpoints();     // Catch: Throwable -> L852 CancellationException -> L888
        if (r1113 != null) goto L110;
        r1113 = CollectionsKt.emptyList();     // Catch: Throwable -> L94 CancellationException -> L96
    L110:
        r424.a(r426.append(r1113.size()).append(", port=").append(r305.a().getServerPort()).toString());     // Catch: Throwable -> L852 CancellationException -> L888
        a.a(this.$callback, (p) ZeusTransformUtils.preCheckCast(new p.d(y.f11988a.a(r305.a()), r305.a()), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L852 CancellationException -> L888
        Ref.BooleanRef r427 = new Ref.BooleanRef();     // Catch: Throwable -> L852 CancellationException -> L888
        List<String> r428 = r305.a().getEndpoints();     // Catch: Throwable -> L852 CancellationException -> L888
        if (r428 != null) goto L114;
        r428 = CollectionsKt.emptyList();     // Catch: Throwable -> L94 CancellationException -> L96
    L114:
        if (((Collection) ZeusTransformUtils.preCheckCast(r428, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L116;
        boolean r429 = true;
    L117:
        r427.element = r429;     // Catch: Throwable -> L852 CancellationException -> L888
        bx r430 = i.a(r421, (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new MigrationRunner$runSender$2$qrUpdateJob$1(this.this$0, r427, r305, this.$callback, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);     // Catch: Throwable -> L852 CancellationException -> L888
        a.a(this.this$0, r305.b());     // Catch: Throwable -> L852 CancellationException -> L888
        if (a.c(this.this$0) == true) goto L120;
        com.obric.memorydata.migration.sdk.internal.net.a r431 = a.b(this.this$0);     // Catch: Throwable -> L852 CancellationException -> L888
        Continuation<? super z<? extends Socket>> r1114 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L852 CancellationException -> L888
        this.L$0 = r421;     // Catch: Throwable -> L852 CancellationException -> L888
        this.L$1 = r305;     // Catch: Throwable -> L852 CancellationException -> L888
        this.L$2 = r430;     // Catch: Throwable -> L852 CancellationException -> L888
        this.label = 3;     // Catch: Throwable -> L852 CancellationException -> L888
        r398 = r431.a(r305, r1114);     // Catch: Throwable -> L852 CancellationException -> L888
        if (r398 != r2) goto L161;
        return r2;
    L161:
        r306 = r421;
        r397 = r430;
        goto L162
    L120:
        bx.a.a(r430, null, 1, null);     // Catch: Throwable -> L94 CancellationException -> L96
        Continuation<? super Unit> r432 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L94 CancellationException -> L96
        this.L$0 = r421;     // Catch: Throwable -> L94 CancellationException -> L96
        this.label = 2;     // Catch: Throwable -> L94 CancellationException -> L96
        if (r430.a_(r432) != r2) goto L123;
        return r2;
    L116:
        r429 = false;
        goto L117
    L777:
        if (ZeusTransformUtils.instanceOf(r423, z.a.class) == false) goto L851;
        if (a.c(this.this$0) == false) goto L815;
        z r433 = a.d(this.this$0);     // Catch: Throwable -> L770 CancellationException -> L772
        t.f11981a.a("sender: cleanup begin");
        a r434 = this.this$0;
        Result.Companion r435 = Result.Companion;     // Catch: Throwable -> L793
        e r436 = a.g(r434);     // Catch: Throwable -> L793
        if (ZeusTransformUtils.instanceOf(r436, e.a.class) == false) goto L785;
        e.a r437 = (e.a) ZeusTransformUtils.preCheckCast(r436, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L793
    L786:
        if (r437 == null) goto L790;
        byte[] r438 = r437.f();     // Catch: Throwable -> L793
        if (r438 == null) goto L790;
        ArraysKt.fill$default(r438, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L793
        Unit r439 = Unit.INSTANCE;     // Catch: Throwable -> L793
    L791:
        Result.m1421constructorimpl(r439);     // Catch: Throwable -> L793
    L795:
        a r440 = this.this$0;
        Result.Companion r441 = Result.Companion;     // Catch: Throwable -> L802
        e r442 = a.g(r440);     // Catch: Throwable -> L802
        if (r442 == null) goto L799;
        r442.d();     // Catch: Throwable -> L802
        Unit r443 = Unit.INSTANCE;     // Catch: Throwable -> L802
    L800:
        Result.m1421constructorimpl(r443);     // Catch: Throwable -> L802
    L804:
        a r444 = this.this$0;
        Result.Companion r445 = Result.Companion;     // Catch: Throwable -> L811
        ServerSocket r446 = a.h(r444);     // Catch: Throwable -> L811
        if (r446 == null) goto L808;
        r446.close();     // Catch: Throwable -> L811
        Unit r447 = Unit.INSTANCE;     // Catch: Throwable -> L811
    L809:
        Result.m1421constructorimpl(r447);     // Catch: Throwable -> L811
    L813:
        a.a(this.this$0, null);
        a.a(this.this$0, null);
        a.a(this.this$0, false, 1, null);
        t.f11981a.a("sender: cleanup end");
        return r433;
    L808:
        r447 = null;
    L811:
        th = move-exception;
        Result.Companion r448 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L813
    L799:
        r443 = null;
    L802:
        th = move-exception;
        Result.Companion r449 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L790:
        r439 = null;
        goto L791
    L785:
        r437 = null;
    L793:
        th = move-exception;
        Result.Companion r450 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L795
    L815:
        z r451 = a.a(this.$callback, (z.a) ZeusTransformUtils.preCheckCast(r423, z.a.class, "com.obric.memorydata.plugin"), null, 4, null);     // Catch: Throwable -> L770 CancellationException -> L772
        t.f11981a.a("sender: cleanup begin");
        a r452 = this.this$0;
        Result.Companion r453 = Result.Companion;     // Catch: Throwable -> L828
        e r454 = a.g(r452);     // Catch: Throwable -> L828
        if (ZeusTransformUtils.instanceOf(r454, e.a.class) == false) goto L820;
        e.a r455 = (e.a) ZeusTransformUtils.preCheckCast(r454, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L828
    L821:
        if (r455 == null) goto L825;
        byte[] r456 = r455.f();     // Catch: Throwable -> L828
        if (r456 == null) goto L825;
        ArraysKt.fill$default(r456, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L828
        Unit r457 = Unit.INSTANCE;     // Catch: Throwable -> L828
    L826:
        Result.m1421constructorimpl(r457);     // Catch: Throwable -> L828
    L830:
        a r458 = this.this$0;
        Result.Companion r459 = Result.Companion;     // Catch: Throwable -> L837
        e r460 = a.g(r458);     // Catch: Throwable -> L837
        if (r460 == null) goto L834;
        r460.d();     // Catch: Throwable -> L837
        Unit r461 = Unit.INSTANCE;     // Catch: Throwable -> L837
    L835:
        Result.m1421constructorimpl(r461);     // Catch: Throwable -> L837
    L839:
        a r462 = this.this$0;
        Result.Companion r463 = Result.Companion;     // Catch: Throwable -> L846
        ServerSocket r464 = a.h(r462);     // Catch: Throwable -> L846
        if (r464 == null) goto L843;
        r464.close();     // Catch: Throwable -> L846
        Unit r465 = Unit.INSTANCE;     // Catch: Throwable -> L846
    L844:
        Result.m1421constructorimpl(r465);     // Catch: Throwable -> L846
    L848:
        a.a(this.this$0, null);
        a.a(this.this$0, null);
        a.a(this.this$0, false, 1, null);
        t.f11981a.a("sender: cleanup end");
        return r451;
    L843:
        r465 = null;
    L846:
        th = move-exception;
        Result.Companion r466 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L848
    L834:
        r461 = null;
    L837:
        th = move-exception;
        Result.Companion r467 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L825:
        r457 = null;
        goto L826
    L820:
        r455 = null;
    L828:
        th = move-exception;
        Result.Companion r468 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L830
    L851:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L770 CancellationException -> L772
    L98:
        ResultKt.throwOnFailure(r33);
        r421 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        a.a(this.this$0, false);     // Catch: Throwable -> L852 CancellationException -> L888
        a.b(this.this$0, true);     // Catch: Throwable -> L852 CancellationException -> L888
        t.f11981a.a("sender: run begin, appVersionCode=" + this.$config.b() + ", exportScope=" + this.$config.e() + ", dbCount=" + this.$config.c().a().size() + ", dbs=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(this.$config.c().a(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$MigrationRunner$runSender$2$132qHZN82QIm7fXDl1x0qiH461k.INSTANCE, 30, null) + ", addons=" + a.a(this.this$0).size());     // Catch: Throwable -> L852 CancellationException -> L888
        com.obric.memorydata.migration.sdk.internal.net.a r469 = a.b(this.this$0);     // Catch: Throwable -> L852 CancellationException -> L888
        f r470 = new f(this.$config.a(), this.$config.b(), null, this.$config.e(), 4, null);     // Catch: Throwable -> L852 CancellationException -> L888
        Continuation<? super z<d>> r471 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L852 CancellationException -> L888
        this.L$0 = r421;     // Catch: Throwable -> L852 CancellationException -> L888
        this.label = 1;     // Catch: Throwable -> L852 CancellationException -> L888
        r422 = r469.a(r470, r471);     // Catch: Throwable -> L852 CancellationException -> L888
        if (r422 != r2) goto L102;
        return r2;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L396:
        th = th;
    L29:
        th = move-exception;
        r41 = th;
        r248 = "getAbsolutePath(...)";
        r249 = r7;
    L925:
        th = move-exception;
        t.f11981a.a(r4);
        a r472 = this.this$0;
        Result.Companion r473 = Result.Companion;     // Catch: Throwable -> L938
        e r474 = a.g(r472);     // Catch: Throwable -> L938
        if (ZeusTransformUtils.instanceOf(r474, e.a.class) == false) goto L930;
        e.a r1115 = (e.a) ZeusTransformUtils.preCheckCast(r474, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L938
    L931:
        if (r1115 == null) goto L935;
        byte[] r475 = r1115.f();     // Catch: Throwable -> L938
        if (r475 == null) goto L935;
        ArraysKt.fill$default(r475, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L938
        Unit r1116 = Unit.INSTANCE;     // Catch: Throwable -> L938
    L936:
        Result.m1421constructorimpl(r1116);     // Catch: Throwable -> L938
    L940:
        a r476 = this.this$0;
        Result.Companion r477 = Result.Companion;     // Catch: Throwable -> L947
        e r478 = a.g(r476);     // Catch: Throwable -> L947
        if (r478 == null) goto L944;
        r478.d();     // Catch: Throwable -> L947
        Unit r1117 = Unit.INSTANCE;     // Catch: Throwable -> L947
    L945:
        Result.m1421constructorimpl(r1117);     // Catch: Throwable -> L947
    L949:
        a r479 = this.this$0;
        Result.Companion r480 = Result.Companion;     // Catch: Throwable -> L956
        ServerSocket r481 = a.h(r479);     // Catch: Throwable -> L956
        if (r481 == null) goto L953;
        r481.close();     // Catch: Throwable -> L956
        Unit r1118 = Unit.INSTANCE;     // Catch: Throwable -> L956
    L954:
        Result.m1421constructorimpl(r1118);     // Catch: Throwable -> L956
    L958:
        a.a(this.this$0, null);
        a.a(this.this$0, null);
        a.a(this.this$0, false, 1, null);
        t.f11981a.a(r13);
        throw th;
    L953:
        r1118 = null;
    L956:
        th = move-exception;
        Result.Companion r482 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L958
    L944:
        r1117 = null;
    L947:
        th = move-exception;
        Result.Companion r483 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L935:
        r1116 = null;
        goto L936
    L930:
        r1115 = null;
    L938:
        th = move-exception;
        Result.Companion r484 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L592:
        th = th;
    L46:
        th = th;
        r5 = r3;
        r40 = r7;
    L63:
        th = move-exception;
        r41 = th;
        r251 = "";
        r250 = "getAbsolutePath(...)";
    L96:
        e = move-exception;
        r176 = e;
        r178 = "sender: cleanup end";
        r177 = "sender: cleanup begin";
    L94:
        th = move-exception;
        r195 = th;
        r197 = "sender: cleanup end";
        r196 = "sender: cleanup begin";
    L772:
        e = e;
    L770:
        th = th;
        goto L854
    }
}
