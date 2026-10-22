package androidx.room.compiler.processing;

import ai.j0;
import androidx.room.compiler.processing.util.NamingUtilsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rH&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H&J\b\u0010\u0016\u001a\u00020\u0013H&J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H&J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XMethodElement;", "Landroidx/room/compiler/processing/XExecutableElement;", "executableType", "Landroidx/room/compiler/processing/XMethodType;", "getExecutableType", "()Landroidx/room/compiler/processing/XMethodType;", "fallbackLocationText", "", "getFallbackLocationText", "()Ljava/lang/String;", "jvmName", "getJvmName", "returnType", "Landroidx/room/compiler/processing/XType;", "getReturnType", "()Landroidx/room/compiler/processing/XType;", "asMemberOf", "other", "hasKotlinDefaultImpl", "", "hasValidJvmSourceName", "isExtensionFunction", "isJavaDefault", "isOverrideableIgnoringContainer", "isSuspendFunction", "overrides", "owner", "Landroidx/room/compiler/processing/XTypeElement;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XMethodElement extends XExecutableElement {
    @Override // androidx.room.compiler.processing.XExecutableElement
    XMethodType asMemberOf(XType r5);

    @Override // androidx.room.compiler.processing.XExecutableElement
    XMethodType getExecutableType();

    @Override // androidx.room.compiler.processing.XElement
    default String getFallbackLocationText() {
        StringBuilder r5 = new StringBuilder();
        r5.append(getEnclosingElement().getFallbackLocationText());
        r5.append(".");
        r5.append(getJvmName());
        r5.append("(");
        return j0.q(r5, CollectionsKt.q(CollectionsKt.dropLast(getParameters(), isSuspendFunction() ? 1 : 0), ", ", null, null, 0, null, XMethodElement$fallbackLocationText$1$1.INSTANCE, 30), ")");
    }

    String getJvmName();

    XType getReturnType();

    boolean hasKotlinDefaultImpl();

    default boolean hasValidJvmSourceName() {
        return NamingUtilsKt.isValidJavaSourceName(getJvmName());
    }

    boolean isExtensionFunction();

    boolean isJavaDefault();

    default boolean isOverrideableIgnoringContainer() {
        if (isFinal() == false) goto L5;
    L9:
        return false;
    L5:
        if (isPrivate() == true) goto L9;
        if (isStatic() == true) goto L9;
        return true;
    }

    boolean isSuspendFunction();

    boolean overrides(XMethodElement r5, XTypeElement r10);
}
