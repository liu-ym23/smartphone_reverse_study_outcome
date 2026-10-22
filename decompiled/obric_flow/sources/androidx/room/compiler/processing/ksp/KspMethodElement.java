package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.XExecutableParameterElement;
import androidx.room.compiler.processing.XExecutableType;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XMethodType;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.ksp.synthetic.KspSyntheticContinuationParameterElement;
import com.google.devtools.ksp.symbol.Modifier;
import il.g;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0003+,-B\u0019\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ\u001f\u0010\u0015\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R!\u0010\u001e\u001a\u00020\u00178VX\u0096\u0084\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR!\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010#R\u001b\u0010(\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001b\u0082\u0001\u0002./¨\u00060"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspMethodElement;", "Landroidx/room/compiler/processing/ksp/KspExecutableElement;", "Landroidx/room/compiler/processing/XMethodElement;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/g;", "declaration", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/g;)V", "", "isJavaDefault", "()Z", "Landroidx/room/compiler/processing/XType;", "other", "Landroidx/room/compiler/processing/XMethodType;", "asMemberOf", "(Landroidx/room/compiler/processing/XType;)Landroidx/room/compiler/processing/XMethodType;", "hasKotlinDefaultImpl", "isExtensionFunction", "Landroidx/room/compiler/processing/XTypeElement;", "owner", "overrides", "(Landroidx/room/compiler/processing/XMethodElement;Landroidx/room/compiler/processing/XTypeElement;)Z", "", "jvmName$delegate", "Lkotlin/Lazy;", "getJvmName", "()Ljava/lang/String;", "getJvmName$annotations", "()V", "jvmName", "", "Landroidx/room/compiler/processing/XExecutableParameterElement;", "parameters$delegate", "getParameters", "()Ljava/util/List;", "parameters", "executableType$delegate", "getExecutableType", "()Landroidx/room/compiler/processing/XMethodType;", "executableType", "getName", "name", "Companion", "KspNormalMethodElement", "KspSuspendMethodElement", "Landroidx/room/compiler/processing/ksp/KspMethodElement$KspNormalMethodElement;", "Landroidx/room/compiler/processing/ksp/KspMethodElement$KspSuspendMethodElement;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KspMethodElement extends KspExecutableElement implements XMethodElement {
    public static final Companion Companion = null;
    private final Lazy executableType$delegate;
    private final Lazy jvmName$delegate;
    private final Lazy parameters$delegate;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspMethodElement$Companion;", "", "<init>", "()V", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/g;", "declaration", "Landroidx/room/compiler/processing/ksp/KspMethodElement;", "create", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/g;)Landroidx/room/compiler/processing/ksp/KspMethodElement;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final KspMethodElement create(KspProcessingEnv r5, g r10) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "declaration");
            if (r10.getModifiers().contains(Modifier.SUSPEND) == false) goto L6;
            return new KspSuspendMethodElement(r5, r10);
        L6:
            return new KspNormalMethodElement(r5, r10);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspMethodElement$KspNormalMethodElement;", "Landroidx/room/compiler/processing/ksp/KspMethodElement;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/g;", "declaration", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/g;)V", "", "isSuspendFunction", "()Z", "Landroidx/room/compiler/processing/XType;", "returnType$delegate", "Lkotlin/Lazy;", "getReturnType", "()Landroidx/room/compiler/processing/XType;", "returnType", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class KspNormalMethodElement extends KspMethodElement {
        private final Lazy returnType$delegate;

        public KspNormalMethodElement(final KspProcessingEnv r5, final g r10) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "declaration");
            super(r5, r10, null);
            this.returnType$delegate = LazyKt.lazy(new KspMethodElement$KspNormalMethodElement$returnType$2(r10, r5, this));
        }

        @Override // androidx.room.compiler.processing.XMethodElement
        public XType getReturnType() {
            return (XType) this.returnType$delegate.getValue();
        }

        @Override // androidx.room.compiler.processing.XMethodElement
        public boolean isSuspendFunction() {
            return false;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspMethodElement$KspSuspendMethodElement;", "Landroidx/room/compiler/processing/ksp/KspMethodElement;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/g;", "declaration", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/g;)V", "", "isSuspendFunction", "()Z", "Landroidx/room/compiler/processing/XType;", "returnType$delegate", "Lkotlin/Lazy;", "getReturnType", "()Landroidx/room/compiler/processing/XType;", "returnType", "", "Landroidx/room/compiler/processing/XExecutableParameterElement;", "getParameters", "()Ljava/util/List;", "parameters", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class KspSuspendMethodElement extends KspMethodElement {
        private final Lazy returnType$delegate;

        public KspSuspendMethodElement(final KspProcessingEnv r5, g r10) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "declaration");
            super(r5, r10, null);
            this.returnType$delegate = LazyKt.lazy(new KspMethodElement$KspSuspendMethodElement$returnType$2(r5));
        }

        @Override // androidx.room.compiler.processing.ksp.KspMethodElement, androidx.room.compiler.processing.XExecutableElement
        public List<XExecutableParameterElement> getParameters() {
            return CollectionsKt.plus(super.getParameters(), new KspSyntheticContinuationParameterElement(getEnv$room_compiler_processing(), this));
        }

        @Override // androidx.room.compiler.processing.XMethodElement
        public XType getReturnType() {
            return (XType) this.returnType$delegate.getValue();
        }

        @Override // androidx.room.compiler.processing.XMethodElement
        public boolean isSuspendFunction() {
            return true;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ KspMethodElement(KspProcessingEnv r5, g r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    public static /* synthetic */ void getJvmName$annotations() {
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public /* bridge */ /* synthetic */ XExecutableType asMemberOf(XType r5) {
        return asMemberOf(r5);
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public /* bridge */ /* synthetic */ XExecutableType getExecutableType() {
        return getExecutableType();
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public String getJvmName() {
        return (String) this.jvmName$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getName() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public List<XExecutableParameterElement> getParameters() {
        return (List) this.parameters$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public boolean hasKotlinDefaultImpl() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public boolean isExtensionFunction() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public boolean isJavaDefault() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public boolean overrides(XMethodElement r5, XTypeElement r10) {
        Intrinsics.checkNotNullParameter(r5, "other");
        Intrinsics.checkNotNullParameter(r10, "owner");
        getEnv$room_compiler_processing().getResolver();
        return ResolverExtKt.overrides(null, this, r5);
    }

    private KspMethodElement(final KspProcessingEnv r5, final g r10) {
        super(r5, r10);
        this.jvmName$delegate = LazyKt.lazy(new KspMethodElement$jvmName$2(this, r10, r5));
        this.parameters$delegate = LazyKt.lazy(new KspMethodElement$parameters$2(r10, r5, this));
        this.executableType$delegate = LazyKt.lazy(new KspMethodElement$executableType$2(r5, this));
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public XMethodType asMemberOf(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if ((r5 instanceof KspType) == false) goto L7;
        return KspMethodType.Companion.create(getEnv$room_compiler_processing(), this, (KspType) r5);
    L7:
        throw new IllegalStateException("Check failed.");
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public XMethodType getExecutableType() {
        return (XMethodType) this.executableType$delegate.getValue();
    }
}
