package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XRoundEnv;
import java.lang.annotation.Annotation;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspRoundEnv;", "Landroidx/room/compiler/processing/XRoundEnv;", "env", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "isProcessingOver", "", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Z)V", "()Z", "rootElements", "", "Landroidx/room/compiler/processing/XElement;", "getRootElements", "()Ljava/util/Set;", "getElementsAnnotatedWith", "annotationQualifiedName", "", "klass", "Lkotlin/reflect/KClass;", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspRoundEnv implements XRoundEnv {
    private final KspProcessingEnv env;
    private final boolean isProcessingOver;

    /* JADX INFO: renamed from: androidx.room.compiler.processing.ksp.KspRoundEnv$getElementsAnnotatedWith$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lil/a;", "symbol", "Landroidx/room/compiler/processing/XElement;", "invoke", "(Lil/a;)Landroidx/room/compiler/processing/XElement;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class AnonymousClass1 extends Lambda implements Function1<il.a, XElement> {
        final /* synthetic */ String $annotationQualifiedName;
        final /* synthetic */ KspRoundEnv this$0;

        public AnonymousClass1(KspRoundEnv r5, String r10) {
            this.this$0 = r5;
            this.$annotationQualifiedName = r10;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ XElement invoke(il.a r5) {
            return invoke2(r5);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final XElement invoke2(il.a r5) {
            Intrinsics.checkNotNullParameter(r5, "symbol");
            throw new IllegalStateException(("Unsupported " + r5 + " with annotation " + this.$annotationQualifiedName).toString());
        }
    }

    public KspRoundEnv(KspProcessingEnv r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        this.env = r5;
        this.isProcessingOver = r10;
    }

    public static final /* synthetic */ KspProcessingEnv access$getEnv$p(KspRoundEnv r5) {
        return r5.env;
    }

    @Override // androidx.room.compiler.processing.XRoundEnv
    public Set<XElement> getElementsAnnotatedWith(KClass<? extends Annotation> r5) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        String r10 = r5.getQualifiedName();
        if (r10 == null) goto L7;
        return getElementsAnnotatedWith(r10);
    L7:
        throw new IllegalStateException(("No qualified name for " + r5).toString());
    }

    @Override // androidx.room.compiler.processing.XRoundEnv
    public Set<XElement> getRootElements() {
        throw new NotImplementedError("An operation is not implemented: not supported");
    }

    @Override // androidx.room.compiler.processing.XRoundEnv
    public boolean isProcessingOver() {
        return this.isProcessingOver;
    }

    @Override // androidx.room.compiler.processing.XRoundEnv
    public Set<XElement> getElementsAnnotatedWith(String r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationQualifiedName");
        this.env.getResolver();
        throw null;
    }
}
