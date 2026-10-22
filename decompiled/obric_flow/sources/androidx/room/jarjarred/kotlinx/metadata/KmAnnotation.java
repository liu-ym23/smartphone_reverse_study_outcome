package androidx.room.jarjarred.kotlinx.metadata;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\r\u0010\r\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;", "", "className", "", "Landroidx/room/jarjarred/kotlinx/metadata/ClassName;", "arguments", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument;", "(Ljava/lang/String;Ljava/util/Map;)V", "getArguments", "()Ljava/util/Map;", "getClassName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmAnnotation {
    private final Map<String, KmAnnotationArgument> arguments;
    private final String className;

    /* JADX WARN: Multi-variable type inference failed */
    public KmAnnotation(String r5, Map<String, ? extends KmAnnotationArgument> r10) {
        Intrinsics.checkNotNullParameter(r5, "className");
        Intrinsics.checkNotNullParameter(r10, "arguments");
        this.className = r5;
        this.arguments = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KmAnnotation copy$default(KmAnnotation r5, String r10, Map r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.className;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.arguments;
    L9:
        return r5.copy(r10, r11);
    }

    public final String component1() {
        return this.className;
    }

    public final Map<String, KmAnnotationArgument> component2() {
        return this.arguments;
    }

    public final KmAnnotation copy(String r5, Map<String, ? extends KmAnnotationArgument> r10) {
        Intrinsics.checkNotNullParameter(r5, "className");
        Intrinsics.checkNotNullParameter(r10, "arguments");
        return new KmAnnotation(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KmAnnotation) == true) goto L8;
        return false;
    L8:
        KmAnnotation r10 = (KmAnnotation) r5;
        if (Intrinsics.areEqual(this.className, r10.className) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.arguments, r10.arguments) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final Map<String, KmAnnotationArgument> getArguments() {
        return this.arguments;
    }

    public final String getClassName() {
        return this.className;
    }

    public int hashCode() {
        int r5 = this.className.hashCode() * 31;
        return this.arguments.hashCode() + r5;
    }

    public String toString() {
        return "KmAnnotation(className=" + this.className + ", arguments=" + this.arguments + ')';
    }
}
