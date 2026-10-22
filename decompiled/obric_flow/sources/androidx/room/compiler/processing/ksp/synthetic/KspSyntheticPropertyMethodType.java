package androidx.room.compiler.processing.ksp.synthetic;

import androidx.room.compiler.processing.XExecutableType;
import androidx.room.compiler.processing.XMethodType;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.ksp.KspProcessingEnv;
import com.squareup.javapoet.a0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 #2\u00020\u0001:\u0003#$%B#\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001cR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001c\u0082\u0001\u0002&'¨\u0006("}, d2 = {"Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodType;", "Landroidx/room/compiler/processing/XMethodType;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;", "origin", "Landroidx/room/compiler/processing/XType;", "containing", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;Landroidx/room/compiler/processing/XType;)V", "Landroidx/room/compiler/processing/XExecutableType;", "other", "", "isSameType", "(Landroidx/room/compiler/processing/XExecutableType;)Z", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "getEnv", "()Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;", "getOrigin", "()Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;", "Landroidx/room/compiler/processing/XType;", "getContaining", "()Landroidx/room/compiler/processing/XType;", "", "parameterTypes$delegate", "Lkotlin/Lazy;", "getParameterTypes", "()Ljava/util/List;", "parameterTypes", "Lcom/squareup/javapoet/a0;", "getTypeVariableNames", "typeVariableNames", "getThrownTypes", "thrownTypes", "Companion", "Getter", "Setter", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodType$Getter;", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodType$Setter;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KspSyntheticPropertyMethodType implements XMethodType {
    public static final Companion Companion = null;
    private final XType containing;
    private final KspProcessingEnv env;
    private final KspSyntheticPropertyMethodElement origin;
    private final Lazy parameterTypes$delegate;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodType$Companion;", "", "()V", "create", "Landroidx/room/compiler/processing/XMethodType;", "env", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "element", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;", "container", "Landroidx/room/compiler/processing/XType;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final XMethodType create(KspProcessingEnv r5, KspSyntheticPropertyMethodElement r10, XType r11) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "element");
            r10.getAccessor();
            r10.getAccessor();
            throw new IllegalStateException(("Unexpected accessor type for " + r10 + " (null)").toString());
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001b\u0010\t\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodType$Getter;", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodType;", "env", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "origin", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;", "containingType", "Landroidx/room/compiler/processing/XType;", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;Landroidx/room/compiler/processing/XType;)V", "returnType", "getReturnType", "()Landroidx/room/compiler/processing/XType;", "returnType$delegate", "Lkotlin/Lazy;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Getter extends KspSyntheticPropertyMethodType {
        private final Lazy returnType$delegate;

        public Getter(KspProcessingEnv r5, final KspSyntheticPropertyMethodElement r10, final XType r11) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "origin");
            super(r5, r10, r11, null);
            this.returnType$delegate = LazyKt.lazy(new KspSyntheticPropertyMethodType$Getter$returnType$2(r11, r10));
        }

        @Override // androidx.room.compiler.processing.XMethodType
        public XType getReturnType() {
            return (XType) this.returnType$delegate.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\t\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodType$Setter;", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodType;", "env", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "origin", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;", "containingType", "Landroidx/room/compiler/processing/XType;", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;Landroidx/room/compiler/processing/XType;)V", "returnType", "getReturnType", "()Landroidx/room/compiler/processing/XType;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Setter extends KspSyntheticPropertyMethodType {
        public Setter(KspProcessingEnv r5, KspSyntheticPropertyMethodElement r10, XType r11) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "origin");
            super(r5, r10, r11, null);
        }

        @Override // androidx.room.compiler.processing.XMethodType
        public XType getReturnType() {
            return getOrigin().getReturnType();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ KspSyntheticPropertyMethodType(KspProcessingEnv r5, KspSyntheticPropertyMethodElement r10, XType r11, DefaultConstructorMarker r12) {
        this(r5, r10, r11);
    }

    public final XType getContaining() {
        return this.containing;
    }

    public final KspProcessingEnv getEnv() {
        return this.env;
    }

    public final KspSyntheticPropertyMethodElement getOrigin() {
        return this.origin;
    }

    @Override // androidx.room.compiler.processing.XExecutableType
    public List<XType> getParameterTypes() {
        return (List) this.parameterTypes$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XExecutableType
    public List<XType> getThrownTypes() {
        return this.origin.getThrownTypes();
    }

    @Override // androidx.room.compiler.processing.XMethodType
    public List<a0> getTypeVariableNames() {
        return CollectionsKt.emptyList();
    }

    @Override // androidx.room.compiler.processing.XExecutableType
    public boolean isSameType(XExecutableType r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        return this.env.isSameType$room_compiler_processing(this, r5);
    }

    private KspSyntheticPropertyMethodType(KspProcessingEnv r5, KspSyntheticPropertyMethodElement r10, XType r11) {
        this.env = r5;
        this.origin = r10;
        this.containing = r11;
        this.parameterTypes$delegate = LazyKt.lazy(new KspSyntheticPropertyMethodType$parameterTypes$2(this));
    }
}
