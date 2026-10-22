package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.XMethodType;
import androidx.room.compiler.processing.XSuspendMethodType;
import androidx.room.compiler.processing.XType;
import com.squareup.javapoet.a0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0003\u0015\u0016\u0017B#\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\rR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u0002\u0018\u0019¨\u0006\u001a"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspMethodType;", "Landroidx/room/compiler/processing/ksp/KspExecutableType;", "Landroidx/room/compiler/processing/XMethodType;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Landroidx/room/compiler/processing/ksp/KspMethodElement;", "origin", "Landroidx/room/compiler/processing/ksp/KspType;", "containing", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/KspMethodElement;Landroidx/room/compiler/processing/ksp/KspType;)V", "Landroidx/room/compiler/processing/ksp/KspMethodElement;", "getOrigin", "()Landroidx/room/compiler/processing/ksp/KspMethodElement;", "", "Lcom/squareup/javapoet/a0;", "typeVariableNames$delegate", "Lkotlin/Lazy;", "getTypeVariableNames", "()Ljava/util/List;", "typeVariableNames", "Companion", "KspNormalMethodType", "KspSuspendMethodType", "Landroidx/room/compiler/processing/ksp/KspMethodType$KspNormalMethodType;", "Landroidx/room/compiler/processing/ksp/KspMethodType$KspSuspendMethodType;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KspMethodType extends KspExecutableType implements XMethodType {
    public static final Companion Companion = null;
    private final KspMethodElement origin;
    private final Lazy typeVariableNames$delegate;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspMethodType$Companion;", "", "()V", "create", "Landroidx/room/compiler/processing/ksp/KspMethodType;", "env", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "origin", "Landroidx/room/compiler/processing/ksp/KspMethodElement;", "containing", "Landroidx/room/compiler/processing/ksp/KspType;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final KspMethodType create(KspProcessingEnv r5, KspMethodElement r10, KspType r11) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "origin");
            if (r10.isSuspendFunction() == false) goto L6;
            return new KspSuspendMethodType(r5, r10, r11);
        L6:
            return new KspNormalMethodType(r5, r10, r11);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001b\u0010\t\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspMethodType$KspNormalMethodType;", "Landroidx/room/compiler/processing/ksp/KspMethodType;", "env", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "origin", "Landroidx/room/compiler/processing/ksp/KspMethodElement;", "containing", "Landroidx/room/compiler/processing/ksp/KspType;", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/KspMethodElement;Landroidx/room/compiler/processing/ksp/KspType;)V", "returnType", "Landroidx/room/compiler/processing/XType;", "getReturnType", "()Landroidx/room/compiler/processing/XType;", "returnType$delegate", "Lkotlin/Lazy;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class KspNormalMethodType extends KspMethodType {
        private final Lazy returnType$delegate;

        public KspNormalMethodType(final KspProcessingEnv r5, final KspMethodElement r10, final KspType r11) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "origin");
            super(r5, r10, r11, null);
            this.returnType$delegate = LazyKt.lazy(new KspMethodType$KspNormalMethodType$returnType$2(r10, r5, r11));
        }

        @Override // androidx.room.compiler.processing.XMethodType
        public XType getReturnType() {
            return (XType) this.returnType$delegate.getValue();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspMethodType$KspSuspendMethodType;", "Landroidx/room/compiler/processing/ksp/KspMethodType;", "Landroidx/room/compiler/processing/XSuspendMethodType;", "env", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "origin", "Landroidx/room/compiler/processing/ksp/KspMethodElement;", "containing", "Landroidx/room/compiler/processing/ksp/KspType;", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/KspMethodElement;Landroidx/room/compiler/processing/ksp/KspType;)V", "returnType", "Landroidx/room/compiler/processing/XType;", "getReturnType", "()Landroidx/room/compiler/processing/XType;", "getSuspendFunctionReturnType", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class KspSuspendMethodType extends KspMethodType implements XSuspendMethodType {
        public KspSuspendMethodType(KspProcessingEnv r5, KspMethodElement r10, KspType r11) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "origin");
            super(r5, r10, r11, null);
        }

        @Override // androidx.room.compiler.processing.XMethodType
        public XType getReturnType() {
            return getOrigin().getReturnType();
        }

        @Override // androidx.room.compiler.processing.XSuspendMethodType
        public XType getSuspendFunctionReturnType() {
            KspProcessingEnv r5 = getEnv();
            getOrigin().getDeclaration();
            KspType r10 = getContaining();
            if (r10 == null) goto L5;
            r10.getKsType();
        L5:
            KSAsMemberOfKt.returnTypeAsMemberOf(null, null);
            return r5.wrap(null, false);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ KspMethodType(KspProcessingEnv r5, KspMethodElement r10, KspType r11, DefaultConstructorMarker r12) {
        this(r5, r10, r11);
    }

    @Override // androidx.room.compiler.processing.ksp.KspExecutableType
    public /* bridge */ /* synthetic */ KspExecutableElement getOrigin() {
        return getOrigin();
    }

    @Override // androidx.room.compiler.processing.XMethodType
    public List<a0> getTypeVariableNames() {
        return (List) this.typeVariableNames$delegate.getValue();
    }

    private KspMethodType(final KspProcessingEnv r5, KspMethodElement r10, KspType r11) {
        super(r5, r10, r11);
        this.origin = r10;
        this.typeVariableNames$delegate = LazyKt.lazy(new KspMethodType$typeVariableNames$2(this, r5));
    }

    @Override // androidx.room.compiler.processing.ksp.KspExecutableType
    public KspMethodElement getOrigin() {
        return this.origin;
    }
}
