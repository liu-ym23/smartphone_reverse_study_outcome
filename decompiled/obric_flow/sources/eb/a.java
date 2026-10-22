package eb;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f16813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f16814c;
    public int d;
    public String e;

    public a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        this.f16812a = r5;
        this.d = 3;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f16812a, ((a) r5).f16812a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f16812a.hashCode();
    }

    public final String toString() {
        return j0.p(new StringBuilder("SecureReportInfo(eventName="), this.f16812a, ')');
    }
}
