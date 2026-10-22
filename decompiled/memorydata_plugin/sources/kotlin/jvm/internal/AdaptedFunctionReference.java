package kotlin.jvm.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes6.dex */
public class AdaptedFunctionReference implements Serializable, FunctionBase {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    public AdaptedFunctionReference(int r8, Class r9, String r10, String r11, int r12) {
        this(r8, CallableReference.NO_RECEIVER, r9, r10, r11, r12);
    }

    public AdaptedFunctionReference(int r1, Object r2, Class r3, String r4, String r5, int r6) {
        this.receiver = r2;
        this.owner = r3;
        this.name = r4;
        this.signature = r5;
        if ((r6 & 1) != 1) goto L5;
        boolean r7 = true;
    L6:
        this.isTopLevel = r7;
        this.arity = r1;
        this.flags = r6 >> 1;
        return;
    L5:
        r7 = false;
        goto L6
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AdaptedFunctionReference.class) == true) goto L8;
        return false;
    L8:
        AdaptedFunctionReference r6 = (AdaptedFunctionReference) ZeusTransformUtils.preCheckCast(r5, AdaptedFunctionReference.class, "com.obric.memorydata.plugin");
        if (this.isTopLevel != r6.isTopLevel) goto L24;
        if (this.arity != r6.arity) goto L24;
        if (this.flags != r6.flags) goto L24;
        if (Intrinsics.areEqual(this.receiver, r6.receiver) == false) goto L24;
        if (Intrinsics.areEqual(this.owner, r6.owner) == false) goto L24;
        if (this.name.equals(r6.name) == false) goto L24;
        if (this.signature.equals(r6.signature) == false) goto L24;
        return true;
    L24:
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public KDeclarationContainer getOwner() {
        Class r0 = this.owner;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (this.isTopLevel == false) goto L9;
        return Reflection.getOrCreateKotlinPackage(r0);
    L9:
        return Reflection.getOrCreateKotlinClass(r0);
    }

    public int hashCode() {
        Object r0 = this.receiver;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Class r4 = this.owner;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (((((r3 + r1) * 31) + this.name.hashCode()) * 31) + this.signature.hashCode()) * 31;
        if (this.isTopLevel == false) goto L12;
        int r6 = 1231;
    L14:
        return ((((r5 + r6) * 31) + this.arity) * 31) + this.flags;
    L12:
        r6 = 1237;
        goto L14
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return Reflection.renderLambdaToString(this);
    }
}
