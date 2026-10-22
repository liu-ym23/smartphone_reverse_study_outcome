package androidx.room.compiler.processing.javac.kotlin;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.kotlinx.metadata.Flag;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\r\u0010\u001e\u001a\u00060\u0007j\u0002`\bHÂ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\nHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jk\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\f\b\u0002\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0007HÖ\u0001J\u0006\u0010)\u001a\u00020%J\u0006\u0010*\u001a\u00020%J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0006\u001a\u00060\u0007j\u0002`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016¨\u0006,"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/KmFunction;", "Landroidx/room/compiler/processing/javac/kotlin/KmExecutable;", "jvmName", "", "name", "descriptor", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "typeArguments", "", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "parameters", "Landroidx/room/compiler/processing/javac/kotlin/KmValueParameter;", "returnType", "receiverType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Landroidx/room/compiler/processing/javac/kotlin/KmType;Landroidx/room/compiler/processing/javac/kotlin/KmType;)V", "getDescriptor", "()Ljava/lang/String;", "getJvmName", "getName", "getParameters", "()Ljava/util/List;", "getReceiverType", "()Landroidx/room/compiler/processing/javac/kotlin/KmType;", "getReturnType", "getTypeArguments", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "isExtension", "isSuspend", "toString", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmFunction implements KmExecutable {
    private final String descriptor;
    private final int flags;
    private final String jvmName;
    private final String name;
    private final List<KmValueParameter> parameters;
    private final KmType receiverType;
    private final KmType returnType;
    private final List<KmType> typeArguments;

    public KmFunction(String r5, String r10, String r11, int r12, List<KmType> r13, List<KmValueParameter> r14, KmType r15, KmType r16) {
        Intrinsics.checkNotNullParameter(r5, "jvmName");
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        Intrinsics.checkNotNullParameter(r13, "typeArguments");
        Intrinsics.checkNotNullParameter(r14, "parameters");
        Intrinsics.checkNotNullParameter(r15, "returnType");
        this.jvmName = r5;
        this.name = r10;
        this.descriptor = r11;
        this.flags = r12;
        this.typeArguments = r13;
        this.parameters = r14;
        this.returnType = r15;
        this.receiverType = r16;
    }

    private final int component4() {
        return this.flags;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KmFunction copy$default(KmFunction r10, String r11, String r12, String r13, int r14, List r15, List r16, KmType r17, KmType r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        String r5 = r10.jvmName;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r20 = r10.name;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r21 = r10.descriptor;
    L15:
        if ((r19 & 8) == 0) goto L17;
        int r22 = r10.flags;
    L19:
        if ((r19 & 16) == 0) goto L21;
        List r23 = r10.typeArguments;
    L23:
        if ((r19 & 32) == 0) goto L25;
        List r24 = r10.getParameters();
    L27:
        if ((r19 & 64) == 0) goto L29;
        KmType r25 = r10.returnType;
    L31:
        if ((r19 & 128) == 0) goto L33;
        KmType r26 = r10.receiverType;
    L35:
        return r10.copy(r5, r20, r21, r22, r23, r24, r25, r26);
    L33:
        r26 = r18;
        goto L35
    L29:
        r25 = r17;
        goto L31
    L25:
        r24 = r16;
        goto L27
    L21:
        r23 = r15;
        goto L23
    L17:
        r22 = r14;
        goto L19
    L13:
        r21 = r13;
        goto L15
    L9:
        r20 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }

    public final String component1() {
        return this.jvmName;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.descriptor;
    }

    public final List<KmType> component5() {
        return this.typeArguments;
    }

    public final List<KmValueParameter> component6() {
        return getParameters();
    }

    public final KmType component7() {
        return this.returnType;
    }

    public final KmType component8() {
        return this.receiverType;
    }

    public final KmFunction copy(String r11, String r12, String r13, int r14, List<KmType> r15, List<KmValueParameter> r16, KmType r17, KmType r18) {
        Intrinsics.checkNotNullParameter(r11, "jvmName");
        Intrinsics.checkNotNullParameter(r12, "name");
        Intrinsics.checkNotNullParameter(r13, "descriptor");
        Intrinsics.checkNotNullParameter(r15, "typeArguments");
        Intrinsics.checkNotNullParameter(r16, "parameters");
        Intrinsics.checkNotNullParameter(r17, "returnType");
        return new KmFunction(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KmFunction) == true) goto L8;
        return false;
    L8:
        KmFunction r10 = (KmFunction) r5;
        if (Intrinsics.areEqual(this.jvmName, r10.jvmName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.descriptor, r10.descriptor) == true) goto L18;
        return false;
    L18:
        if (this.flags == r10.flags) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.typeArguments, r10.typeArguments) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(getParameters(), r10.getParameters()) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.returnType, r10.returnType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.receiverType, r10.receiverType) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getDescriptor() {
        return this.descriptor;
    }

    public final String getJvmName() {
        return this.jvmName;
    }

    public final String getName() {
        return this.name;
    }

    @Override // androidx.room.compiler.processing.javac.kotlin.KmExecutable
    public List<KmValueParameter> getParameters() {
        return this.parameters;
    }

    public final KmType getReceiverType() {
        return this.receiverType;
    }

    public final KmType getReturnType() {
        return this.returnType;
    }

    public final List<KmType> getTypeArguments() {
        return this.typeArguments;
    }

    public int hashCode() {
        int r5 = a.c(a.c(this.jvmName.hashCode() * 31, 31, this.name), 31, this.descriptor);
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.flags, r5, 31);
        int r11 = a.f(this.typeArguments, r10, 31);
        int r12 = (getParameters().hashCode() + r11) * 31;
        int r13 = (this.returnType.hashCode() + r12) * 31;
        KmType r14 = this.receiverType;
        if (r14 != null) goto L5;
        int r15 = 0;
    L7:
        return r13 + r15;
    L5:
        r15 = r14.hashCode();
        goto L7
    }

    public final boolean isExtension() {
        if (this.receiverType == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSuspend() {
        return Flag.Function.IS_SUSPEND.invoke(this.flags);
    }

    public String toString() {
        return "KmFunction(jvmName=" + this.jvmName + ", name=" + this.name + ", descriptor=" + this.descriptor + ", flags=" + this.flags + ", typeArguments=" + this.typeArguments + ", parameters=" + getParameters() + ", returnType=" + this.returnType + ", receiverType=" + this.receiverType + ')';
    }
}
