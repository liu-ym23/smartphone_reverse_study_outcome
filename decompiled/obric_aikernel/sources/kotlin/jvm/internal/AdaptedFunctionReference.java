package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.4")
public class AdaptedFunctionReference implements FunctionBase, Serializable {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    public AdaptedFunctionReference(int r10, Class r11, String r12, String r13, int r14) {
        this(r10, CallableReference.NO_RECEIVER, r11, r12, r13, r14);
    }

    public AdaptedFunctionReference(int r10, Object r11, Class r12, String r13, String r14, int r15) {
        this.receiver = r11;
        this.owner = r12;
        this.name = r13;
        this.signature = r14;
        if ((r15 & 1) != 1) goto L5;
        boolean r16 = true;
    L6:
        this.isTopLevel = r16;
        this.arity = r10;
        this.flags = r15 >> 1;
        return;
    L5:
        r16 = false;
        goto L6
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AdaptedFunctionReference) == true) goto L8;
        return false;
    L8:
        AdaptedFunctionReference r11 = (AdaptedFunctionReference) r10;
        if (this.isTopLevel != r11.isTopLevel) goto L24;
        if (this.arity != r11.arity) goto L24;
        if (this.flags != r11.flags) goto L24;
        if (Intrinsics.areEqual(this.receiver, r11.receiver) == false) goto L24;
        if (Intrinsics.areEqual(this.owner, r11.owner) == false) goto L24;
        if (this.name.equals(r11.name) == false) goto L24;
        if (this.signature.equals(r11.signature) == false) goto L24;
        return true;
    L24:
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public KDeclarationContainer getOwner() {
        Class r10 = this.owner;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (this.isTopLevel == false) goto L9;
        return Reflection.getOrCreateKotlinPackage(r10);
    L9:
        return Reflection.getOrCreateKotlinClass(r10);
    }

    public int hashCode() {
        Object r10 = this.receiver;
        int r11 = 0;
        if (r10 == null) goto L5;
        int r12 = r10.hashCode();
    L6:
        int r13 = r12 * 31;
        Class r14 = this.owner;
        if (r14 == null) goto L9;
        r11 = r14.hashCode();
    L9:
        int r15 = (((((r13 + r11) * 31) + this.name.hashCode()) * 31) + this.signature.hashCode()) * 31;
        if (this.isTopLevel == false) goto L12;
        int r16 = 1231;
    L14:
        return ((((r15 + r16) * 31) + this.arity) * 31) + this.flags;
    L12:
        r16 = 1237;
        goto L14
    L5:
        r12 = 0;
        goto L6
    }

    public String toString() {
        return Reflection.renderLambdaToString(this);
    }
}
