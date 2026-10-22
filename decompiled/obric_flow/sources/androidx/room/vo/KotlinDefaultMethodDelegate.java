package androidx.room.vo;

import androidx.room.compiler.processing.XMethodElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/room/vo/KotlinDefaultMethodDelegate;", "", "element", "Landroidx/room/compiler/processing/XMethodElement;", "(Landroidx/room/compiler/processing/XMethodElement;)V", "getElement", "()Landroidx/room/compiler/processing/XMethodElement;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KotlinDefaultMethodDelegate {
    private final XMethodElement element;

    public KotlinDefaultMethodDelegate(XMethodElement r5) {
        Intrinsics.checkNotNullParameter(r5, "element");
        this.element = r5;
    }

    public static /* synthetic */ KotlinDefaultMethodDelegate copy$default(KotlinDefaultMethodDelegate r5, XMethodElement r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r5.element;
    L6:
        return r5.copy(r10);
    }

    public final XMethodElement component1() {
        return this.element;
    }

    public final KotlinDefaultMethodDelegate copy(XMethodElement r5) {
        Intrinsics.checkNotNullParameter(r5, "element");
        return new KotlinDefaultMethodDelegate(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KotlinDefaultMethodDelegate) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.element, ((KotlinDefaultMethodDelegate) r5).element) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final XMethodElement getElement() {
        return this.element;
    }

    public int hashCode() {
        return this.element.hashCode();
    }

    public String toString() {
        return "KotlinDefaultMethodDelegate(element=" + this.element + ")";
    }
}
