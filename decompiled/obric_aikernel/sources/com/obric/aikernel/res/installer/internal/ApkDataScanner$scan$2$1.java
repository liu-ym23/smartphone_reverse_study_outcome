package com.obric.aikernel.res.installer.internal;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.metadata.data.AIPackage;
import com.obric.aikernel.runtime.utils.d;
import java.io.File;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.installer.internal.ApkDataScanner$scan$2$1", f = "ApkDataScanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ApkDataScanner$scan$2$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<String, String, String, com.obric.aikernel.res.metadata.data.b> $builder;
    final /* synthetic */ PrmContext $context;
    final /* synthetic */ a8.a.C0003a $debugPackage;
    final /* synthetic */ String $name;
    final /* synthetic */ File $pkgRootDir;
    final /* synthetic */ com.obric.aikernel.res.metadata.data.b $type;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ApkDataScanner this$0;

    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1\n*L\n1#1,328:1\n*E\n"})
    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r10, T r11) {
            String r12 = (String) r11;
            AIPackage.a r13 = AIPackage.f5062u;
            Intrinsics.checkNotNullExpressionValue(r12, "it");
            Integer r14 = Integer.valueOf(r13.b(r12));
            String r15 = (String) r10;
            Intrinsics.checkNotNullExpressionValue(r15, "it");
            return ComparisonsKt.compareValues(r14, Integer.valueOf(r13.b(r15)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    ApkDataScanner$scan$2$1(File r10, PrmContext r11, String r12, a8.a.C0003a r13, com.obric.aikernel.res.metadata.data.b r14, ApkDataScanner r15, Function3<? super String, ? super String, ? super String, ? extends com.obric.aikernel.res.metadata.data.b> r16, Continuation<? super ApkDataScanner$scan$2$1> r17) {
        this.$pkgRootDir = r10;
        this.$context = r11;
        this.$name = r12;
        this.$debugPackage = r13;
        this.$type = r14;
        this.this$0 = r15;
        this.$builder = r16;
        super(2, r17);
    }

    public static /* synthetic */ boolean e(File r10, String r11) {
        return invokeSuspend$lambda$0(r10, r11);
    }

    private static final boolean invokeSuspend$lambda$0(File r10, String r11) {
        return r10.isDirectory();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        ApkDataScanner$scan$2$1 r10 = new ApkDataScanner$scan$2$1(this.$pkgRootDir, this.$context, this.$name, this.$debugPackage, this.$type, this.this$0, this.$builder, r12);
        r10.L$0 = r11;
        return r10;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((ApkDataScanner$scan$2$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r22) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r22);
        l0 r10 = (l0) this.L$0;
        String[] r11 = this.$pkgRootDir.list(b.f5008a);
        if (r11 == null) goto L44;
        List r12 = ArraysKt.sortedWith(r11, new a());
        if (r12 == null) goto L45;
        PrmContext r13 = this.$context;
        final String r14 = this.$name;
        a8.a.C0003a r15 = this.$debugPackage;
        com.obric.aikernel.res.metadata.data.b r16 = this.$type;
        File r17 = this.$pkgRootDir;
        ApkDataScanner r18 = this.this$0;
        final Function3<String, String, String, com.obric.aikernel.res.metadata.data.b> r19 = this.$builder;
        Iterator r20 = r12.iterator();
    L10:
        if (r20.hasNext() == false) goto L36;
        final String r21 = (String) r20.next();
        if (Intrinsics.areEqual(r21, NetConst.ENCRYPT_VERISON_CODE) == true) goto L34;
        if (Intrinsics.areEqual(r21, NetConst.NOT_ENCRYPT_VERISON_CODE) == true) goto L34;
        if (Intrinsics.areEqual(r21, "debug") == true) goto L19;
    L33:
        String r23 = r16.A();
        Intrinsics.checkNotNullExpressionValue(r14, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullExpressionValue(r21, "version");
        PrmContext.install$default(r13, r23, r14, r21, null, false, false, new ApkDataScanner$scan$2$1$3$3(r19, r14, r21), 40, null);
        goto L34
    L19:
        if (r13.getConfig().getAppConfig().getAutoDeleteDebugPackage().invoke().booleanValue() == false) goto L33;
        if (r15 == null) goto L22;
        String r24 = r15.a();
    L24:
        if (Intrinsics.areEqual(r14, r24) == true) goto L33;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L27
        Object r26 = Result.m32constructorimpl(Boxing.boxBoolean(FilesKt.deleteRecursively(new File(r17, r21))));     // Catch: Throwable -> L27
    L29:
        Throwable r27 = Result.m35exceptionOrNullimpl(r26);
        if (r27 == null) goto L34;
        d.f5417a.l(r18.tag(), "delete " + r14 + " debug package failed " + r27);
    L27:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r26 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L29
    L22:
        r24 = null;
    L34:
        r16 = r16;
        r17 = r17;
        r19 = r19;
        r18 = r18;
        goto L10
    L36:
        return Unit.INSTANCE;
    L45:
        return null;
    L44:
        return null;
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
