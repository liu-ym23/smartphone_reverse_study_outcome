package l4;

import com.google.gson.annotations.SerializedName;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u0003\u0010\u000f¨\u0006\u0011"}, d2 = {"Ll4/c;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "method", "", "Ljava/util/Map;", "c", "()Ljava/util/Map;", LynxResourceModule.PARAMS_KEY, "Ll4/b;", "Ll4/b;", "()Ll4/b;", "highExec", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("method")
    private final String f19522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName(LynxResourceModule.PARAMS_KEY)
    private final Map<String, Object> f19523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("callback")
    private final b f19524c;

    public c() {
        this.f19522a = null;
        this.f19523b = null;
        this.f19524c = null;
    }

    public final b a() {
        return this.f19524c;
    }

    public final String b() {
        return this.f19522a;
    }

    public final Map c() {
        return this.f19523b;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        if (Intrinsics.areEqual(this.f19522a, r10.f19522a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19523b, r10.f19523b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19524c, r10.f19524c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r5 = this.f19522a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        Map<String, Object> r13 = this.f19523b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        b r16 = this.f19524c;
        if (r16 == null) goto L15;
        r10 = r16.hashCode();
    L15:
        return r15 + r10;
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        return "JSBAction(method=" + this.f19522a + ", params=" + this.f19523b + ", highExec=" + this.f19524c + ')';
    }
}
