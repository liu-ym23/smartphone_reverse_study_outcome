package f8;

import android.os.Bundle;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f8873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8875e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private JSONObject f8876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Bundle f8877g;

    public a(int r10, String r11, T r12, boolean r13, boolean r14, JSONObject r15, Bundle r16) {
        Intrinsics.checkNotNullParameter(r15, WsConstants.KEY_EXTRA);
        this.f8871a = r10;
        this.f8872b = r11;
        this.f8873c = r12;
        this.f8874d = r13;
        this.f8875e = r14;
        this.f8876f = r15;
        this.f8877g = r16;
    }

    public /* synthetic */ a(int r10, String r11, Object r12, boolean r13, boolean r14, JSONObject r15, Bundle r16, int r17, DefaultConstructorMarker r18) {
        Bundle r19 = null;
        if ((r17 & 2) == 0) goto L5;
        String r20 = null;
    L7:
        if ((r17 & 4) == 0) goto L9;
        Object r21 = null;
    L10:
        boolean r22 = false;
        if ((r17 & 8) == 0) goto L13;
        boolean r23 = false;
    L15:
        if ((r17 & 16) != 0) goto L19;
        r22 = r14;
    L19:
        if ((r17 & 32) == 0) goto L21;
        JSONObject r24 = new JSONObject();
    L23:
        if ((r17 & 64) != 0) goto L26;
        r19 = r16;
    L26:
        this(r10, r20, r21, r23, r22, r24, r19);
        return;
    L21:
        r24 = r15;
        goto L23
    L13:
        r23 = r13;
        goto L15
    L9:
        r21 = r12;
        goto L10
    L5:
        r20 = r11;
        goto L7
    }

    public final T a() {
        return this.f8873c;
    }

    public final int b() {
        return this.f8871a;
    }

    public final String c() {
        return this.f8872b;
    }

    public final JSONObject d() {
        return this.f8876f;
    }

    public final boolean e() {
        return this.f8874d;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (this.f8871a == r11.f8871a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8872b, r11.f8872b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f8873c, r11.f8873c) == true) goto L18;
        return false;
    L18:
        if (this.f8874d == r11.f8874d) goto L21;
        return false;
    L21:
        if (this.f8875e == r11.f8875e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f8876f, r11.f8876f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f8877g, r11.f8877g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int r10 = Integer.hashCode(this.f8871a) * 31;
        String r11 = this.f8872b;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        T r15 = this.f8873c;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (r14 + r16) * 31;
        boolean r18 = this.f8874d;
        ?? r19 = 1;
        ?? r20 = r18;
        if (r18 == false) goto L13;
        r20 = 1;
    L13:
        int r21 = (r17 + r20) * 31;
        boolean r22 = this.f8875e;
        if (r22 == true) goto L17;
        r19 = r22;
    L17:
        int r23 = (((r21 + r19) * 31) + this.f8876f.hashCode()) * 31;
        Bundle r24 = this.f8877g;
        if (r24 == null) goto L22;
        r12 = r24.hashCode();
    L22:
        return r23 + r12;
    L9:
        r16 = r15.hashCode();
        goto L10
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public String toString() {
        return "Response(errorCode=" + this.f8871a + ", errorInfo=" + this.f8872b + ", data=" + this.f8873c + ", isFinish=" + this.f8874d + ", isTaskId=" + this.f8875e + ", extra=" + this.f8876f + ", src=" + this.f8877g + ')';
    }
}
