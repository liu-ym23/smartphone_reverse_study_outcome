package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.XExecutableParameterElement;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.ksp.synthetic.KspSyntheticPropertyMethodElement;
import com.google.devtools.ksp.symbol.Origin;
import il.d;
import il.j;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u001b\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\b*\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u001b\u0010\u0014\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\u0082\u0001\u0002\u001a\u001b¨\u0006\u001c"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope;", "", "Lil/a;", "annotated", "Lil/d;", "container", "<init>", "(Lil/a;Lil/d;)V", "", "isInKotlinCode", "(Lil/a;)Z", "Landroidx/room/compiler/processing/XType;", "findDeclarationType", "()Landroidx/room/compiler/processing/XType;", "Lil/a;", "Lil/d;", "needsWildcardResolution$delegate", "Lkotlin/Lazy;", "getNeedsWildcardResolution", "()Z", "needsWildcardResolution", "suppressesWildcards$delegate", "getSuppressesWildcards", "suppressesWildcards", "MethodParameter", "PropertySetterParameter", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope$MethodParameter;", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope$PropertySetterParameter;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KspJvmTypeResolutionScope {
    private final il.a annotated;
    private final d container;
    private final Lazy needsWildcardResolution$delegate;
    private final Lazy suppressesWildcards$delegate;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope$MethodParameter;", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope;", "Landroidx/room/compiler/processing/ksp/KspExecutableElement;", "kspExecutableElement", "", "parameterIndex", "Lil/a;", "annotated", "Lil/d;", "container", "<init>", "(Landroidx/room/compiler/processing/ksp/KspExecutableElement;ILil/a;Lil/d;)V", "Landroidx/room/compiler/processing/XType;", "findDeclarationType", "()Landroidx/room/compiler/processing/XType;", "Landroidx/room/compiler/processing/ksp/KspExecutableElement;", "I", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MethodParameter extends KspJvmTypeResolutionScope {
        private final KspExecutableElement kspExecutableElement;
        private final int parameterIndex;

        public MethodParameter(KspExecutableElement r5, int r10, il.a r11, d r12) {
            Intrinsics.checkNotNullParameter(r5, "kspExecutableElement");
            Intrinsics.checkNotNullParameter(r11, "annotated");
            super(r11, r12, null);
            this.kspExecutableElement = r5;
            this.parameterIndex = r10;
        }

        @Override // androidx.room.compiler.processing.ksp.KspJvmTypeResolutionScope
        public XType findDeclarationType() {
            KspExecutableElement r5 = this.kspExecutableElement;
            if ((r5 instanceof KspMethodElement) == true) goto L7;
            return null;
        L7:
            return (XType) CollectionsKt.getOrNull(((KspMethodElement) r5).getExecutableType().getParameterTypes(), this.parameterIndex);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope$PropertySetterParameter;", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope;", "declaration", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;", "(Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;)V", "getDeclaration", "()Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;", "findDeclarationType", "Landroidx/room/compiler/processing/XType;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PropertySetterParameter extends KspJvmTypeResolutionScope {
        private final KspSyntheticPropertyMethodElement declaration;

        /* JADX WARN: Multi-variable type inference failed */
        public PropertySetterParameter(KspSyntheticPropertyMethodElement r5) {
            Intrinsics.checkNotNullParameter(r5, "declaration");
            r5.getAccessor();
            r5.getField().getEnclosingElement().getDeclaration();
            super(null, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
            this.declaration = r5;
        }

        @Override // androidx.room.compiler.processing.ksp.KspJvmTypeResolutionScope
        public XType findDeclarationType() {
            KspSyntheticPropertyMethodElement r5 = this.declaration.getField().getSyntheticSetter();
            if (r5 == null) goto L9;
            List<XExecutableParameterElement> r10 = r5.getParameters();
            if (r10 == null) goto L9;
            XExecutableParameterElement r11 = (XExecutableParameterElement) CollectionsKt.firstOrNull(r10);
            if (r11 == null) goto L9;
            return r11.getType();
        L9:
            return null;
        }

        public final KspSyntheticPropertyMethodElement getDeclaration() {
            return this.declaration;
        }
    }

    public /* synthetic */ KspJvmTypeResolutionScope(il.a r5, d r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    public static final /* synthetic */ il.a access$getAnnotated$p(KspJvmTypeResolutionScope r5) {
        return r5.annotated;
    }

    public static final /* synthetic */ d access$getContainer$p(KspJvmTypeResolutionScope r5) {
        r5.getClass();
        return null;
    }

    public static final /* synthetic */ boolean access$isInKotlinCode(KspJvmTypeResolutionScope r5, il.a r10) {
        return r5.isInKotlinCode(r10);
    }

    private final boolean isInKotlinCode(il.a r5) {
    L3:
        if (r3 == null) goto L13;
        Origin r10 = r3.getOrigin();
        if (r10 != Origin.SYNTHETIC) goto L7;
        j r11 = r11.getParent();
        goto L3
    L7:
        if (r10 != Origin.KOTLIN) goto L9;
    L10:
        return true;
    L9:
        if (r10 == Origin.KOTLIN_LIB) goto L10;
        return false;
    L13:
        return false;
    }

    public abstract XType findDeclarationType();

    public final boolean getNeedsWildcardResolution() {
        return ((Boolean) this.needsWildcardResolution$delegate.getValue()).booleanValue();
    }

    public final boolean getSuppressesWildcards() {
        return ((Boolean) this.suppressesWildcards$delegate.getValue()).booleanValue();
    }

    private KspJvmTypeResolutionScope(il.a r5, d r10) {
        this.annotated = r5;
        this.needsWildcardResolution$delegate = LazyKt.lazy(new KspJvmTypeResolutionScope$needsWildcardResolution$2(this));
        this.suppressesWildcards$delegate = LazyKt.lazy(new KspJvmTypeResolutionScope$suppressesWildcards$2(this));
    }
}
