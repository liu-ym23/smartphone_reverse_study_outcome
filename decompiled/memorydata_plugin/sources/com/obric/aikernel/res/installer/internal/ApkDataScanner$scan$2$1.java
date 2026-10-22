package com.obric.aikernel.res.installer.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.metadata.data.b;
import com.obric.aikernel.res.metadata.data.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.res.installer.internal.ApkDataScanner$scan$2$1", f = "ApkDataScanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ApkDataScanner$scan$2$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<String, String, String, d> $builder;
    final /* synthetic */ PrmContext $context;
    final /* synthetic */ com.obric.aikernel.res.a.a.C0256a $debugPackage;
    final /* synthetic */ String $name;
    final /* synthetic */ File $pkgRootDir;
    final /* synthetic */ d $type;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ com.obric.aikernel.res.installer.internal.a this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            String r2 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
            b.a r5 = b.e;
            Intrinsics.checkNotNullExpressionValue(r2, "it");
            Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5.a(r2)), Comparable.class, "com.obric.memorydata.plugin");
            String r7 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
            b.a r8 = b.e;
            Intrinsics.checkNotNullExpressionValue(r7, "it");
            return ComparisonsKt.compareValues(r6, (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r8.a(r7)), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    ApkDataScanner$scan$2$1(File r3, PrmContext r4, String r5, com.obric.aikernel.res.a.a.C0256a r6, d r7, com.obric.aikernel.res.installer.internal.a r8, Function3<? super String, ? super String, ? super String, ? extends d> r9, Continuation<? super ApkDataScanner$scan$2$1> r10) {
        Function3<String, String, String, d> r11 = (Function3) ZeusTransformUtils.wrapperContextForParams(r9, Function3.class, "com.obric.memorydata.plugin");
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        this.$pkgRootDir = r3;
        this.$context = r4;
        this.$name = r5;
        this.$debugPackage = r6;
        this.$type = r7;
        this.this$0 = r8;
        this.$builder = r11;
        super(2, r12);
    }

    private static final boolean invokeSuspend$lambda$0(File r0, String r1) {
        return r0.isDirectory();
    }

    /* JADX INFO: renamed from: lambda$hBZs1DXFYgx23_k-qUiwvLZcfN0, reason: not valid java name */
    public static /* synthetic */ boolean m202lambda$hBZs1DXFYgx23_kqUiwvLZcfN0(File r0, String r1) {
        return invokeSuspend$lambda$0(r0, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        ApkDataScanner$scan$2$1 r14 = new ApkDataScanner$scan$2$1(this.$pkgRootDir, this.$context, this.$name, this.$debugPackage, this.$type, this.this$0, this.$builder, r10);
        r14.L$0 = r12;
        return (Continuation) ZeusTransformUtils.preCheckCast(r14, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ApkDataScanner$scan$2$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ApkDataScanner$scan$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r23) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r23);
        al r1 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        String[] r2 = this.$pkgRootDir.list($$Lambda$ApkDataScanner$scan$2$1$hBZs1DXFYgx23_kqUiwvLZcfN0.INSTANCE);
        if (r2 == null) goto L44;
        List r3 = ArraysKt.sortedWith(r2, (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.memorydata.plugin"));
        if (r3 == null) goto L45;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        PrmContext r14 = this.$context;
        final String r15 = this.$name;
        com.obric.aikernel.res.a.a.C0256a r13 = this.$debugPackage;
        d r12 = this.$type;
        File r11 = this.$pkgRootDir;
        com.obric.aikernel.res.installer.internal.a r10 = this.this$0;
        final Function3<String, String, String, d> r9 = this.$builder;
        Iterator r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L36;
        final String r7 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r7, "1") == true) goto L34;
        if (Intrinsics.areEqual(r7, "0") == true) goto L34;
        if (Intrinsics.areEqual(r7, "debug") == true) goto L19;
    L33:
        String r6 = r12.getType();
        Intrinsics.checkNotNullExpressionValue(r15, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullExpressionValue(r7, "version");
        PrmContext.install$default(r14, r6, r15, r7, null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new ApkDataScanner$scan$2$1$3$3(r9, r15, r7), Function1.class, "com.obric.memorydata.plugin"), 40, null);
        goto L34
    L19:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14.getConfig().getAppConfig().getAutoDeleteDebugPackage().invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L33;
        if (r13 == null) goto L22;
        String r0 = r13.a();
    L24:
        if (Intrinsics.areEqual(r15, r0) == true) goto L33;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L27
        Object r16 = Result.m1421constructorimpl(Boxing.boxBoolean(FilesKt.deleteRecursively(new File(r11, r7))));     // Catch: Throwable -> L27
    L29:
        Throwable r17 = Result.m1424exceptionOrNullimpl(r16);
        if (r17 == null) goto L34;
        com.obric.aikernel.runtime.utils.d.f6216a.f(r10.a(), "delete " + r15 + " debug package failed " + r17);
    L27:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L29
    L22:
        r0 = null;
    L34:
        r11 = r11;
        r12 = r12;
        r13 = r13;
        r9 = r9;
        r10 = r10;
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
