package com.obric.memorydata.migration.sdk.internal.db;

import android.content.Context;
import android.os.Bundle;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.MigrationStep;
import com.obric.memorydata.migration.sdk.ab;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.p;
import com.obric.memorydata.migration.sdk.q;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.z;
import com.obric.security.secretdata.SecretDataManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.db.DbImporter$restore$3", f = "DbImporter.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
final class DbImporter$restore$3 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends Unit>>, Object> {
    final /* synthetic */ com.obric.memorydata.migration.sdk.b $backupConfigOverride;
    final /* synthetic */ m $callback;
    final /* synthetic */ boolean $clearNonRestoredTables;
    final /* synthetic */ File $publicResourceRestoreDir;
    final /* synthetic */ File $restoreDir;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ b this$0;

    DbImporter$restore$3(com.obric.memorydata.migration.sdk.b r3, b r4, File r5, boolean r6, File r7, m r8, Continuation<? super DbImporter$restore$3> r9) {
        m r10 = (m) ZeusTransformUtils.wrapperContextForParams(r8, m.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$backupConfigOverride = r3;
        this.this$0 = r4;
        this.$restoreDir = r5;
        this.$clearNonRestoredTables = r6;
        this.$publicResourceRestoreDir = r7;
        this.$callback = r10;
        super(2, r11);
    }

    private static final CharSequence invokeSuspend$lambda$8$lambda$0(com.obric.memorydata.migration.sdk.g r2) {
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a() + '(' + r2.b() + ",tables=" + r2.c().size() + ')', CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence invokeSuspend$lambda$8$lambda$5(com.obric.memorydata.migration.sdk.g r2) {
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ CharSequence lambda$B34t5SXx9qc_cjMbgD63FJSeTrA(com.obric.memorydata.migration.sdk.g r0) {
        return invokeSuspend$lambda$8$lambda$0(r0);
    }

    public static /* synthetic */ CharSequence lambda$HeflI4X9IlVPnxS5eNhlXB8EHo0(com.obric.memorydata.migration.sdk.g r0) {
        return invokeSuspend$lambda$8$lambda$5(r0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        DbImporter$restore$3 r13 = new DbImporter$restore$3(this.$backupConfigOverride, this.this$0, this.$restoreDir, this.$clearNonRestoredTables, this.$publicResourceRestoreDir, this.$callback, r9);
        r13.L$0 = r11;
        return (Continuation) ZeusTransformUtils.preCheckCast(r13, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends Unit>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<Unit>> r4) {
        return ((DbImporter$restore$3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DbImporter$restore$3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r29) {
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r4 = true;
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L8;
        ResultKt.throwOnFailure(r29);     // Catch: Throwable -> L77
        Object r1 = r29;
    L57:
        z r2 = (z) ZeusTransformUtils.preCheckCast(r1, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L77
        if (r2 != null) goto L60;
    L62:
        t.f11981a.a("restore: end");     // Catch: Throwable -> L77
        Object r5 = Result.m1421constructorimpl(new z.b(Unit.INSTANCE));     // Catch: Throwable -> L77
    L79:
        m r6 = this.$callback;
        Throwable r7 = Result.m1424exceptionOrNullimpl(r5);
        if (r7 == null) goto L114;
        t.f11981a.a("restore: failed", r7);
        if (q.a(r7) == false) goto L85;
        MigrationErrorCode r8 = MigrationErrorCode.NO_SPACE_LEFT;
    L87:
        if (r8 != MigrationErrorCode.NO_SPACE_LEFT) goto L89;
        StringBuilder r9 = new StringBuilder();
        String r10 = "存储空间不足，恢复失败: ";
    L90:
        o r11 = new o(r8, r9.append(r10).append(r7.getMessage()).toString(), r7);
        r6.onEvent((p) ZeusTransformUtils.preCheckCast(new p.b(MigrationStep.TRANSFERRING, r11), p.class, "com.obric.memorydata.plugin"));
        return (z) ZeusTransformUtils.preCheckCast(new z.a(r11), z.class, "com.obric.memorydata.plugin");
    L89:
        r9 = new StringBuilder();
        r10 = "导入导出错误: ";
        goto L90
    L85:
        r8 = MigrationErrorCode.OTHER;
        goto L87
    L114:
        return r5;
    L60:
        if (ZeusTransformUtils.instanceOf(r2, z.a.class) == false) goto L62;
        return r2;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r29);
        al r12 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.migration.sdk.b r13 = this.$backupConfigOverride;
        b r14 = this.this$0;
        File r15 = this.$restoreDir;
        boolean r16 = this.$clearNonRestoredTables;
        File r17 = this.$publicResourceRestoreDir;
        m r18 = this.$callback;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L77
        if (r13 != null) goto L13;
        com.obric.memorydata.migration.sdk.b r110 = b.b(r14);     // Catch: Throwable -> L77
    L14:
        t r111 = t.f11981a;     // Catch: Throwable -> L77
        StringBuilder r112 = new StringBuilder().append("restore: start, restoreDir=").append(r15.getAbsolutePath()).append(", useOverride=");     // Catch: Throwable -> L77
        if (r13 == null) goto L17;
        boolean r20 = true;
    L18:
        StringBuilder r21 = r112.append(r20).append(", clearNonRestoredTables=");     // Catch: Throwable -> L77
        if (r16 == false) goto L21;
        boolean r113 = true;
    L22:
        r111.a(r21.append(r113).append(", dbCount=").append(r110.a().size()).append(", dbs=").append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r110.a(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$DbImporter$restore$3$B34t5SXx9qc_cjMbgD63FJSeTrA.INSTANCE, 30, null)).toString());     // Catch: Throwable -> L77
        b.a(r14, r15);     // Catch: Throwable -> L77
        LinkedHashSet r114 = new LinkedHashSet();     // Catch: Throwable -> L77
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(r110.a(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L63
        Collection r115 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L63
        Iterator r23 = r22.iterator();     // Catch: Throwable -> L63
    L25:
        if (r23.hasNext() == false) goto L34;
        Object r116 = r23.next();     // Catch: Throwable -> L63
        com.obric.memorydata.migration.sdk.g r117 = (com.obric.memorydata.migration.sdk.g) ZeusTransformUtils.preCheckCast(r116, com.obric.memorydata.migration.sdk.g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L63
        Iterator r118 = r23;
        if (r16 == true) goto L31;
        r4 = false;
    L31:
        if (b.a(r14, r15, r117, r4, (Set) ZeusTransformUtils.preCheckCast(r114, Set.class, "com.obric.memorydata.plugin")) == false) goto L33;
        r115.add(r116);     // Catch: Throwable -> L63
    L33:
        r23 = r118;
        r4 = true;
        goto L25
    L34:
        List r24 = (List) ZeusTransformUtils.preCheckCast(r115, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L63
        Iterator r25 = ((Iterable) ZeusTransformUtils.preCheckCast(r114, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L77
    L37:
        if (r25.hasNext() == false) goto L47;
        String r119 = (String) ZeusTransformUtils.preCheckCast(r25.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L77
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L41
        a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.a(r14), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r119);     // Catch: Throwable -> L41
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L96:
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L45
        Result.m1421constructorimpl(Boxing.boxInt(SecretDataManager.getInstance().deleteData((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.a(r14), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r119, new Bundle())));     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L77
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L77
    L41:
        th = move-exception;
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L77
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L77
        goto L96
    L47:
        com.obric.memorydata.migration.sdk.b r28 = com.obric.memorydata.migration.sdk.b.a(r110, r24, null, null, 6, null);     // Catch: Throwable -> L77
        t.f11981a.a("restore: dbs restored=" + r24.size() + '/' + r110.a().size() + ", restoredDbs=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$DbImporter$restore$3$HeflI4X9IlVPnxS5eNhlXB8EHo0.INSTANCE, 30, null));     // Catch: Throwable -> L77
        a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.a(r14), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r15, b.c(r14));     // Catch: Throwable -> L77
        b.b(r14, r15);     // Catch: Throwable -> L77
        z r30 = b.a(r14, r15, r28, r17);     // Catch: Throwable -> L77
        if (ZeusTransformUtils.instanceOf(r30, z.a.class) == false) goto L51;
        return r30;
    L51:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r28.a(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L62;
        ab r31 = b.d(r14);     // Catch: Throwable -> L77
        if (r31 == null) goto L62;
        Context r32 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.a(r14), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L77
        this.label = 1;     // Catch: Throwable -> L77
        r1 = r31.a(r32, r28, r18, this);     // Catch: Throwable -> L77
        if (r1 != r3) goto L57;
        return r3;
    L63:
        th = move-exception;
        Iterator r33 = ((Iterable) ZeusTransformUtils.preCheckCast(r114, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L77
    L66:
        if (r33.hasNext() == false) goto L76;
        String r34 = (String) ZeusTransformUtils.preCheckCast(r33.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L77
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L70
        a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.a(r14), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r34);     // Catch: Throwable -> L70
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L70
    L101:
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L74
        Result.m1421constructorimpl(Boxing.boxInt(SecretDataManager.getInstance().deleteData((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.a(r14), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r34, new Bundle())));     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L77
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L77
    L70:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L77
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L77
        goto L101
    L76:
        throw th;     // Catch: Throwable -> L77
    L21:
        r113 = false;
        goto L22
    L17:
        r20 = false;
        goto L18
    L13:
        r110 = r13;
    L77:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L79
    }
}
