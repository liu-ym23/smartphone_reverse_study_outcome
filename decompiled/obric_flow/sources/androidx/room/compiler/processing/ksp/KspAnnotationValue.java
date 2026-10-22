package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.InternalXAnnotationValue;
import androidx.room.compiler.processing.XType;
import il.t;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0019R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspAnnotationValue;", "Landroidx/room/compiler/processing/InternalXAnnotationValue;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Landroidx/room/compiler/processing/ksp/KspAnnotation;", "owner", "Landroidx/room/compiler/processing/XType;", "valueType", "Lil/t;", "valueArgument", "Lkotlin/Function0;", "", "valueProvider", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/KspAnnotation;Landroidx/room/compiler/processing/XType;Lil/t;Lkotlin/jvm/functions/Function0;)V", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "getEnv", "()Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "Landroidx/room/compiler/processing/ksp/KspAnnotation;", "Landroidx/room/compiler/processing/XType;", "getValueType", "()Landroidx/room/compiler/processing/XType;", "Lil/t;", "getValueArgument", "()Lil/t;", "Lkotlin/jvm/functions/Function0;", "value$delegate", "Lkotlin/Lazy;", "getValue", "()Ljava/lang/Object;", "value", "", "getName", "()Ljava/lang/String;", "name", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspAnnotationValue extends InternalXAnnotationValue {
    private final KspProcessingEnv env;
    private final KspAnnotation owner;
    private final Lazy value$delegate;
    private final t valueArgument;
    private final Function0<Object> valueProvider;
    private final XType valueType;

    public /* synthetic */ KspAnnotationValue(KspProcessingEnv r10, final KspAnnotation r11, final XType r12, final t r13, Function0 r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 16) == 0) goto L5;
        r14 = new AnonymousClass1(r11, r12, r13);
    L5:
        this(r10, r11, r12, r13, r14);
    }

    public static final /* synthetic */ Function0 access$getValueProvider$p(KspAnnotationValue r5) {
        return r5.valueProvider;
    }

    public final KspProcessingEnv getEnv() {
        return this.env;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public String getName() {
        throw null;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public Object getValue() {
        return this.value$delegate.getValue();
    }

    public final t getValueArgument() {
        return null;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public XType getValueType() {
        return this.valueType;
    }

    public KspAnnotationValue(KspProcessingEnv r5, KspAnnotation r10, XType r11, t r12, Function0<? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "owner");
        Intrinsics.checkNotNullParameter(r11, "valueType");
        Intrinsics.checkNotNullParameter(r12, "valueArgument");
        Intrinsics.checkNotNullParameter(r13, "valueProvider");
        this.env = r5;
        this.owner = r10;
        this.valueType = r11;
        this.valueProvider = r13;
        this.value$delegate = LazyKt.lazy(new KspAnnotationValue$value$2(this));
    }
}
