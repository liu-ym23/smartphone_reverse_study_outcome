package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.internal.m1;
import kotlinx.serialization.internal.z0;
import kotlinx.serialization.json.internal.JsonDecodingException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f19441a = 0;

    static {
        du.a.b(StringCompanionObject.INSTANCE);
        z0.a("kotlinx.serialization.json.JsonUnquotedLiteral", m1.f19311a);
    }

    public static final void a(l r5, String r10) {
        throw new IllegalArgumentException("Element " + Reflection.getOrCreateKotlinClass(r5.getClass()) + " is not a " + r10);
    }

    public static final int b(b0 r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        long r10 = new bi.e(r5.b(), 3).l();     // Catch: JsonDecodingException -> L12
        if ((-2147483648L) > r10) goto L11;
        if (r10 > 2147483647L) goto L11;
        return (int) r10;
    L11:
        throw new NumberFormatException(r5.b() + " is not an Int");
    L12:
        e = move-exception;
        throw new NumberFormatException(e.getMessage());
    }
}
