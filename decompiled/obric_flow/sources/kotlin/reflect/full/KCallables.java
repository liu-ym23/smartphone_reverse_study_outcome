package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u001a9\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00022\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00130\u0012\"\u0004\u0018\u00010\u0013H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a7\u0010\u0015\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0016H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\"$\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"$\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"extensionReceiverParameter", "Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KCallable;", "getExtensionReceiverParameter$annotations", "(Lkotlin/reflect/KCallable;)V", "getExtensionReceiverParameter", "(Lkotlin/reflect/KCallable;)Lkotlin/reflect/KParameter;", "instanceParameter", "getInstanceParameter$annotations", "getInstanceParameter", "valueParameters", "", "getValueParameters$annotations", "getValueParameters", "(Lkotlin/reflect/KCallable;)Ljava/util/List;", "callSuspend", "R", "args", "", "", "(Lkotlin/reflect/KCallable;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callSuspendBy", "", "(Lkotlin/reflect/KCallable;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findParameterByName", "name", "", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
@JvmName(name = "KCallables")
@SourceDebugExtension({"SMAP\nKCallables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KCallables.kt\nkotlin/reflect/full/KCallables\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,82:1\n661#2,11:83\n661#2,11:94\n766#2:105\n857#2,2:106\n661#2,11:108\n1#3:119\n*S KotlinDebug\n*F\n+ 1 KCallables.kt\nkotlin/reflect/full/KCallables\n*L\n23#1:83,11\n31#1:94,11\n38#1:105\n38#1:106,2\n45#1:108,11\n*E\n"})
public final class KCallables {

    /* JADX INFO: renamed from: kotlin.reflect.full.KCallables$callSuspend$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.reflect.full.KCallables", f = "KCallables.kt", i = {0, 0}, l = {56}, m = "callSuspend", n = {"$this$callSuspend", "args"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r5) {
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return KCallables.callSuspend(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.full.KCallables$callSuspendBy$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.reflect.full.KCallables", f = "KCallables.kt", i = {0, 0, 0}, l = {74}, m = "callSuspendBy", n = {"$this$callSuspendBy", "args", "kCallable"}, s = {"L$0", "L$1", "L$2"})
    public static final class C02211<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02211(Continuation<? super C02211> r5) {
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return KCallables.callSuspendBy(null, null, this);
        }
    }

    @SinceKotlin(version = "1.3")
    public static final <R> Object callSuspend(KCallable<? extends R> r5, Object[] r10, Continuation<? super R> r11) {
        if ((r11 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r12 = (AnonymousClass1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        Object[] r17 = (Object[]) r12.L$1;
        r5 = (KCallable) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L26:
        if (Intrinsics.areEqual(r5.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class)) == true) goto L28;
    L31:
        return r14;
    L28:
        if (r5.getReturnType().isMarkedNullable() == true) goto L31;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        if (r5.isSuspend() == true) goto L19;
        return r5.call(Arrays.copyOf(r10, r10.length));
    L19:
        if ((r5 instanceof KFunction) == false) goto L33;
        r12.L$0 = r5;
        r12.L$1 = r10;
        r12.label = 1;
        SpreadBuilder r18 = new SpreadBuilder(2);
        r18.addSpread(r10);
        r18.add(r12);
        r14 = r5.call(r18.toArray(new Object[r18.size()]));
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L23:
        if (r14 != r15) goto L26;
        return r15;
    L33:
        throw new IllegalArgumentException("Cannot callSuspend on a property " + r5 + ": suspend properties are not supported yet");
    L7:
        r12 = new AnonymousClass1(r11);
        goto L8
    }

    @SinceKotlin(version = "1.3")
    public static final <R> Object callSuspendBy(KCallable<? extends R> r5, Map<KParameter, ? extends Object> r10, Continuation<? super R> r11) {
        if ((r11 instanceof C02211) == false) goto L7;
        C02211 r12 = (C02211) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        KCallableImpl r17 = (KCallableImpl) r12.L$2;
        Map r18 = (Map) r12.L$1;
        r5 = (KCallable) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L28:
        if (Intrinsics.areEqual(r5.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class)) == true) goto L30;
    L33:
        return r14;
    L30:
        if (r5.getReturnType().isMarkedNullable() == true) goto L33;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        if (r5.isSuspend() == true) goto L19;
        return r5.callBy(r10);
    L19:
        if ((r5 instanceof KFunction) == false) goto L37;
        KCallableImpl<?> r19 = UtilKt.asKCallableImpl(r5);
        if (r19 == null) goto L35;
        r12.L$0 = r5;
        r12.L$1 = r10;
        r12.L$2 = r19;
        r12.label = 1;
        r14 = r19.callDefaultMethod$kotlin_reflection(r10, r12);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L25:
        if (r14 != r15) goto L28;
        return r15;
    L35:
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + r5);
    L37:
        throw new IllegalArgumentException("Cannot callSuspendBy on a property " + r5 + ": suspend properties are not supported yet");
    L7:
        r12 = new C02211(r11);
        goto L8
    }

    @SinceKotlin(version = "1.1")
    public static final KParameter findParameterByName(KCallable<?> r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "name");
        Iterator<T> r11 = r5.getParameters().iterator();
        Object r12 = null;
        boolean r13 = false;
        Object r14 = null;
    L4:
        if (r11.hasNext() == false) goto L10;
        Object r15 = r11.next();
        if (Intrinsics.areEqual(((KParameter) r15).getName(), r10) == false) goto L4;
        if (r13 == true) goto L14;
        r13 = true;
        r14 = r15;
    L14:
        return (KParameter) r12;
    L10:
        if (r13 == false) goto L14;
        r12 = r14;
        goto L14
    }

    public static final KParameter getExtensionReceiverParameter(KCallable<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<T> r11 = r10.getParameters().iterator();
        Object r5 = null;
        boolean r12 = false;
        Object r13 = null;
    L4:
        if (r11.hasNext() == false) goto L10;
        Object r14 = r11.next();
        if (((KParameter) r14).getKind() != KParameter.Kind.EXTENSION_RECEIVER) goto L4;
        if (r12 == true) goto L14;
        r12 = true;
        r13 = r14;
    L14:
        return (KParameter) r5;
    L10:
        if (r12 == false) goto L14;
        r5 = r13;
        goto L14
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getExtensionReceiverParameter$annotations(KCallable r5) {
    }

    public static final KParameter getInstanceParameter(KCallable<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<T> r11 = r10.getParameters().iterator();
        Object r5 = null;
        boolean r12 = false;
        Object r13 = null;
    L4:
        if (r11.hasNext() == false) goto L10;
        Object r14 = r11.next();
        if (((KParameter) r14).getKind() != KParameter.Kind.INSTANCE) goto L4;
        if (r12 == true) goto L14;
        r12 = true;
        r13 = r14;
    L14:
        return (KParameter) r5;
    L10:
        if (r12 == false) goto L14;
        r5 = r13;
        goto L14
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getInstanceParameter$annotations(KCallable r5) {
    }

    public static final List<KParameter> getValueParameters(KCallable<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        List<KParameter> r10 = r5.getParameters();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (((KParameter) r13).getKind() != KParameter.Kind.VALUE) goto L4;
        r11.add(r13);
        goto L4
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getValueParameters$annotations(KCallable r5) {
    }
}
