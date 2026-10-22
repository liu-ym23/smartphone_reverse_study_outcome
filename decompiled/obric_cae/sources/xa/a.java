package xa;

import android.os.Bundle;
import com.bytedance.common.wschannel.WsConstants;
import he.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f13766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f13767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f13768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONObject f13769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f13770g;

    public /* synthetic */ a() {
        this(102, null, null, false, false, new JSONObject(), null);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r8;
        int r11 = r10.f13764a;
        if (this.f13764a == r11) goto L12;
        return false;
    L12:
        if (i.a(this.f13765b, r10.f13765b) == true) goto L15;
        return false;
    L15:
        if (i.a(this.f13766c, r10.f13766c) == true) goto L18;
        return false;
    L18:
        if (this.f13767d == r10.f13767d) goto L21;
        return false;
    L21:
        if (this.f13768e == r10.f13768e) goto L24;
        return false;
    L24:
        if (i.a(this.f13769f, r10.f13769f) == true) goto L27;
        return false;
    L27:
        if (i.a(this.f13770g, r10.f13770g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final int hashCode() {
        int r8 = Integer.hashCode(this.f13764a) * 31;
        int r10 = 0;
        String r11 = this.f13765b;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r8 + r12) * 31;
        T r14 = this.f13766c;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        ?? r17 = 1;
        boolean r18 = this.f13767d;
        ?? r19 = r18;
        if (r18 == false) goto L13;
        r19 = 1;
    L13:
        int r20 = (r16 + r19) * 31;
        boolean r21 = this.f13768e;
        if (r21 == true) goto L17;
        r17 = r21;
    L17:
        int r22 = (this.f13769f.hashCode() + ((r20 + r17) * 31)) * 31;
        Bundle r23 = this.f13770g;
        if (r23 == null) goto L22;
        r10 = r23.hashCode();
    L22:
        return r22 + r10;
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        return "Response(errorCode=" + this.f13764a + ", errorInfo=" + this.f13765b + ", data=" + this.f13766c + ", isFinish=" + this.f13767d + ", isTaskId=" + this.f13768e + ", extra=" + this.f13769f + ", src=" + this.f13770g + ')';
    }

    public a(int r8, String r10, T r11, boolean r12, boolean r13, JSONObject r14, Bundle r15) {
        i.f(r14, WsConstants.KEY_EXTRA);
        this.f13764a = r8;
        this.f13765b = r10;
        this.f13766c = r11;
        this.f13767d = r12;
        this.f13768e = r13;
        this.f13769f = r14;
        this.f13770g = r15;
    }
}
