package l4;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006¨\u0006\b"}, d2 = {"Ll4/a;", "", "", "Ll4/d;", "a", "Ljava/util/List;", "()Ljava/util/List;", "block", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("expression")
    private final List<d> f19518a;

    public a() {
        this.f19518a = null;
    }

    public final List a() {
        return this.f19518a;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f19518a, ((a) r5).f19518a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<d> r5 = this.f19518a;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.hashCode();
    }

    public final String toString() {
        return androidx.constraintlayout.motion.widget.a.v(new StringBuilder("ConditionBlock(block="), this.f19518a, ')');
    }
}
