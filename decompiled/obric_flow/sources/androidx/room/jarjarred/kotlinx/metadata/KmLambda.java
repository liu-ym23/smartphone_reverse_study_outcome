package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\t2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmLambda;", "Landroidx/room/jarjarred/kotlinx/metadata/KmLambdaVisitor;", "<init>", "()V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "", "name", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "visitFunction", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "visitor", "", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmLambdaVisitor;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunction;", "function", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunction;", "getFunction", "()Ljava/lang/Object;", "setFunction", "(Ljava/lang/Object;)V", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmLambda extends KmLambdaVisitor {
    public KmFunction function;

    public KmLambda() {
        super(null, 1, null);
    }

    public final void accept(KmLambdaVisitor r5) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        KmFunctionVisitor r10 = r5.visitFunction(getFunction().getFlags(), getFunction().getName());
        if (r10 == null) goto L5;
        getFunction().accept(r10);
    L5:
        r5.visitEnd();
    }

    public final KmFunction getFunction() {
        KmFunction r5 = this.function;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("function");
        return null;
    }

    public final void setFunction(KmFunction r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.function = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmLambdaVisitor
    public KmFunctionVisitor visitFunction(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        KmFunction r11 = new KmFunction(r5, r10);
        setFunction(r11);
        return r11;
    }
}
