package kotlinx.serialization.json;

import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0017J\b\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000b¨\u0006\u0011"}, d2 = {"Lkotlinx/serialization/json/JsonLiteral;", "Lkotlinx/serialization/json/JsonPrimitive;", "body", "", "isString", "", "(Ljava/lang/Object;Z)V", Params.CONTENT, "", "getContent", "()Ljava/lang/String;", "()Z", "equals", "other", "hashCode", "", "toString", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class k extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f17855a;
    private final String d;

    public k(Object r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "body");
        super(null);
        this.f17855a = r3;
        this.d = r2.toString();
    }

    public boolean a() {
        return this.f17855a;
    }

    @Override // kotlinx.serialization.json.r
    public String b() {
        return this.d;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L17:
        return false;
    L8:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(getClass()), Reflection.getOrCreateKotlinClass(r7.getClass())) == false) goto L17;
        k r4 = (k) ZeusTransformUtils.preCheckCast(r7, k.class, "com.obric.memorydata.plugin");
        if (a() == ((k) ZeusTransformUtils.preCheckCast(r7, k.class, "com.obric.memorydata.plugin")).a()) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(b(), ((k) ZeusTransformUtils.preCheckCast(r7, k.class, "com.obric.memorydata.plugin")).b()) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public int hashCode() {
        return (Boolean.hashCode(a()) * 31) + b().hashCode();
    }

    @Override // kotlinx.serialization.json.r
    public String toString() {
        if (a() == false) goto L6;
        StringBuilder r0 = new StringBuilder();
        kotlinx.serialization.json.internal.t.a(r0, b());
        String r1 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r1, "StringBuilder().apply(builderAction).toString()");
        return r1;
    L6:
        return b();
    }
}
