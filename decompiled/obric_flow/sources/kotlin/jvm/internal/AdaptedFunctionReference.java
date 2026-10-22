package kotlin.jvm.internal;

import androidx.constraintlayout.motion.widget.a;
import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes3.dex */
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

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AdaptedFunctionReference) == true) goto L8;
        return false;
    L8:
        AdaptedFunctionReference r10 = (AdaptedFunctionReference) r5;
        if (this.isTopLevel != r10.isTopLevel) goto L24;
        if (this.arity != r10.arity) goto L24;
        if (this.flags != r10.flags) goto L24;
        if (Intrinsics.areEqual(this.receiver, r10.receiver) == false) goto L24;
        if (Intrinsics.areEqual(this.owner, r10.owner) == false) goto L24;
        if (this.name.equals(r10.name) == false) goto L24;
        if (this.signature.equals(r10.signature) == false) goto L24;
        return true;
    L24:
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public KDeclarationContainer getOwner() {
        Class r5 = this.owner;
        if (r5 != null) goto L6;
        return null;
    L6:
        if (this.isTopLevel == false) goto L9;
        return Reflection.getOrCreateKotlinPackage(r5);
    L9:
        return Reflection.getOrCreateKotlinClass(r5);
    }

    public int hashCode() {
        Object r5 = this.receiver;
        int r10 = 0;
        if (r5 == null) goto L5;
        int r11 = r5.hashCode();
    L6:
        int r12 = r11 * 31;
        Class r13 = this.owner;
        if (r13 == null) goto L9;
        r10 = r13.hashCode();
    L9:
        int r14 = a.c(a.c((r12 + r10) * 31, 31, this.name), 31, this.signature);
        if (this.isTopLevel == false) goto L12;
        int r15 = 1231;
    L14:
        return ((((r14 + r15) * 31) + this.arity) * 31) + this.flags;
    L12:
        r15 = 1237;
        goto L14
    L5:
        r11 = 0;
        goto L6
    }

    public String toString() {
        return Reflection.renderLambdaToString(this);
    }

    public AdaptedFunctionReference(int r5, Object r10, Class r11, String r12, String r13, int r14) {
        this.receiver = r10;
        this.owner = r11;
        this.name = r12;
        this.signature = r13;
        if ((r14 & 1) != 1) goto L5;
        boolean r15 = true;
    L6:
        this.isTopLevel = r15;
        this.arity = r5;
        this.flags = r14 >> 1;
        return;
    L5:
        r15 = false;
        goto L6
    }
}
