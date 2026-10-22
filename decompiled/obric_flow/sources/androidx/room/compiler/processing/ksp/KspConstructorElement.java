package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.XConstructorElement;
import androidx.room.compiler.processing.XConstructorType;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XExecutableParameterElement;
import androidx.room.compiler.processing.XExecutableType;
import androidx.room.compiler.processing.XMemberContainer;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import il.g;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/room/compiler/processing/ksp/KspConstructorElement;", "Landroidx/room/compiler/processing/ksp/KspExecutableElement;", "Landroidx/room/compiler/processing/XConstructorElement;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/g;", "declaration", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/g;)V", "Landroidx/room/compiler/processing/XType;", "other", "Landroidx/room/compiler/processing/XConstructorType;", "asMemberOf", "(Landroidx/room/compiler/processing/XType;)Landroidx/room/compiler/processing/XConstructorType;", "Landroidx/room/compiler/processing/ksp/KspTypeElement;", "enclosingElement$delegate", "Lkotlin/Lazy;", "getEnclosingElement", "()Landroidx/room/compiler/processing/ksp/KspTypeElement;", "enclosingElement", "", "Landroidx/room/compiler/processing/XExecutableParameterElement;", "parameters$delegate", "getParameters", "()Ljava/util/List;", "parameters", "executableType$delegate", "getExecutableType", "()Landroidx/room/compiler/processing/XConstructorType;", "executableType", "", "getName", "()Ljava/lang/String;", "name", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspConstructorElement extends KspExecutableElement implements XConstructorElement {
    private final Lazy enclosingElement$delegate;
    private final Lazy executableType$delegate;
    private final Lazy parameters$delegate;

    public KspConstructorElement(final KspProcessingEnv r5, final g r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "declaration");
        super(r5, r10);
        this.enclosingElement$delegate = LazyKt.lazy(new KspConstructorElement$enclosingElement$2(r10, r5, this));
        this.parameters$delegate = LazyKt.lazy(new KspConstructorElement$parameters$2(r10, r5, this));
        this.executableType$delegate = LazyKt.lazy(new KspConstructorElement$executableType$2(r5, this));
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public /* bridge */ /* synthetic */ XExecutableType asMemberOf(XType r5) {
        return asMemberOf(r5);
    }

    @Override // androidx.room.compiler.processing.ksp.KspExecutableElement, androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XElement getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public /* bridge */ /* synthetic */ XExecutableType getExecutableType() {
        return getExecutableType();
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getName() {
        return "<init>";
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public List<XExecutableParameterElement> getParameters() {
        return (List) this.parameters$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public XConstructorType asMemberOf(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if ((r5 instanceof KspType) == false) goto L7;
        return new KspConstructorType(getEnv$room_compiler_processing(), this, (KspType) r5);
    L7:
        throw new IllegalStateException("Check failed.");
    }

    @Override // androidx.room.compiler.processing.ksp.KspExecutableElement, androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XMemberContainer getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public XConstructorType getExecutableType() {
        return (XConstructorType) this.executableType$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.ksp.KspExecutableElement, androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XTypeElement getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.ksp.KspExecutableElement, androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ KspMemberContainer getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.ksp.KspExecutableElement, androidx.room.compiler.processing.XElement
    public KspTypeElement getEnclosingElement() {
        return (KspTypeElement) this.enclosingElement$delegate.getValue();
    }
}
