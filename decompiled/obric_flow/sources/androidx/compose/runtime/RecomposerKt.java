package androidx.compose.runtime;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0006\u001aU\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062<\u0010\u0007\u001a8\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\u0002\b\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a?\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0014*\u0014\u0012\u0004\u0012\u0002H\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00160\u00152\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u0002H\u0014H\u0000¢\u0006\u0002\u0010\u0019\u001a9\u0010\u001a\u001a\u0004\u0018\u0001H\u0014\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0014*\u0014\u0012\u0004\u0012\u0002H\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00160\u00152\u0006\u0010\u0017\u001a\u0002H\u0013H\u0000¢\u0006\u0002\u0010\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"FramePending", "", "ProduceAnotherFrame", "RecomposerCompoundHashKey", "", "withRunningRecomposer", "R", "block", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/Recomposer;", "Lkotlin/ParameterName;", "name", "recomposer", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addMultiValue", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", STGroup.DICT_KEY, "value", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Z", "removeLastMultiValue", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRecomposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/RecomposerKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,1502:1\n361#2,7:1503\n*S KotlinDebug\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/RecomposerKt\n*L\n1494#1:1503,7\n*E\n"})
public final class RecomposerKt {
    private static final Object FramePending = null;
    private static final Object ProduceAnotherFrame = null;
    private static final int RecomposerCompoundHashKey = 1000;

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2", f = "Recomposer.kt", i = {0}, l = {68, 70}, m = "invokeSuspend", n = {"recomposer"}, s = {"L$0"})
    public static final class AnonymousClass2<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function3<CoroutineScope, Recomposer, Continuation<? super R>, Object> $block;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2$1", f = "Recomposer.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Recomposer $recomposer;
            int label;

            public AnonymousClass1(Recomposer r5, Continuation<? super AnonymousClass1> r10) {
                this.$recomposer = r5;
                super(2, r10);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
                return new AnonymousClass1(this.$recomposer, r10);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
                return invoke2(r5, r10);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r11 = this.label;
                if (r11 == 0) goto L8;
                if (r11 != 1) goto L7;
                ResultKt.throwOnFailure(r5);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                Recomposer r12 = this.$recomposer;
                this.label = 1;
                if (r12.runRecomposeAndApplyChanges(this) != r10) goto L12;
                return r10;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
                return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function3<? super CoroutineScope, ? super Recomposer, ? super Continuation<? super R>, ? extends Object> r5, Continuation<? super AnonymousClass2> r10) {
            this.$block = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            AnonymousClass2 r11 = new AnonymousClass2(this.$block, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Object r10) {
            return invoke(r5, (Continuation) r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            if (r10 == 0) goto L10;
            if (r10 == 1) goto L9;
            if (r10 != 2) goto L8;
            Object r12 = this.L$0;
            ResultKt.throwOnFailure(r11);
            return r12;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Recomposer r13 = (Recomposer) this.L$0;
            ResultKt.throwOnFailure(r11);
        L13:
            r13.close();
            this.L$0 = r11;
            this.label = 2;
            if (r13.join(this) != r5) goto L17;
            return r5;
        L17:
            return r11;
        L10:
            ResultKt.throwOnFailure(r11);
            CoroutineScope r14 = (CoroutineScope) this.L$0;
            r13 = new Recomposer(r14.getCoroutineContext());
            BuildersKt.launch$default(r14, null, null, new AnonymousClass1(r13, null), 3, null);
            Function3<CoroutineScope, Recomposer, Continuation<? super R>, Object> r15 = this.$block;
            this.L$0 = r13;
            this.label = 1;
            r11 = r15.invoke(r14, r13, this);
            if (r11 != r5) goto L13;
            return r5;
        }

        public final Object invoke(CoroutineScope r5, Continuation<? super R> r10) {
            return ((AnonymousClass2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        ProduceAnotherFrame = new Object();
        FramePending = new Object();
    }

    public static final /* synthetic */ Object access$getFramePending$p() {
        return FramePending;
    }

    public static final /* synthetic */ Object access$getProduceAnotherFrame$p() {
        return ProduceAnotherFrame;
    }

    public static final <K, V> boolean addMultiValue(Map<K, List<V>> r5, K r10, V r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        List<V> r12 = r5.get(r10);
        if (r12 != null) goto L6;
        r12 = j0.y(r5, r10);
    L6:
        return r12.add(r11);
    }

    public static final <K, V> V removeLastMultiValue(Map<K, List<V>> r5, K r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        List<V> r11 = r5.get(r10);
        if (r11 == null) goto L7;
        V r12 = (V) CollectionsKt.removeFirst(r11);
        if (r11.isEmpty() == false) goto L9;
        r5.remove(r10);
        return r12;
    L9:
        return r12;
    L7:
        return null;
    }

    public static final <R> Object withRunningRecomposer(Function3<? super CoroutineScope, ? super Recomposer, ? super Continuation<? super R>, ? extends Object> r5, Continuation<? super R> r10) {
        return h0.d(new AnonymousClass2(r5, null), r10);
    }
}
