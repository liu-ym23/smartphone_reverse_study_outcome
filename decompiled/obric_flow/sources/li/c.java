package li;

import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthErrorCode;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthMode;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthSuccessCode;
import com.bytedance.sdk.xbridge.cn.auth.bean.FeAuthConfigSource;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f19641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f19642c;
    public AuthErrorCode d;
    public AuthSuccessCode e;
    public int f;
    public AuthBridgeAccess g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FeAuthConfigSource f19643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AuthBridgeAccess f19644i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f19645j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f19646k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AuthMode f19647l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public JSONObject f19648m;

    public c(boolean r5, String r10, AuthErrorCode r11, AuthSuccessCode r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        boolean r14 = false;
    L7:
        if ((r13 & 4) == 0) goto L10;
        r10 = null;
    L10:
        if ((r13 & 8) == 0) goto L13;
        r11 = null;
    L13:
        if ((r13 & 16) == 0) goto L15;
        r12 = null;
    L15:
        this.f19640a = r5;
        this.f19641b = r14;
        this.f19642c = r10;
        this.d = r11;
        this.e = r12;
        this.f = -1;
        this.f19643h = FeAuthConfigSource.d;
        return;
    L5:
        r14 = true;
        goto L7
    }

    public final String a() {
        String r5 = this.f19642c;
        AuthErrorCode r10 = this.d;
        AuthSuccessCode r11 = this.e;
        if (r5 != null) goto L16;
        String r12 = null;
        if (r10 == null) goto L7;
        String r13 = r10.f7316b;
    L8:
        if (r13 != null) goto L15;
        if (r11 == null) goto L11;
        r12 = r11.f7326b;
    L11:
        if (r12 != null) goto L14;
        return "";
    L14:
        return r12;
    L15:
        return r13;
    L7:
        r13 = null;
        goto L8
    L16:
        return r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        if (this.f19640a == r10.f19640a) goto L12;
        return false;
    L12:
        if (this.f19641b == r10.f19641b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19642c, r10.f19642c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = kn.e.a(Boolean.hashCode(this.f19640a) * 31, 31, this.f19641b);
        String r10 = this.f19642c;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        AuthErrorCode r14 = this.d;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        AuthSuccessCode r17 = this.e;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return Boolean.hashCode(true) + ((r16 + r11) * 31);
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        return "AuthResult(passed=" + this.f19640a + ", interrupt=" + this.f19641b + ", status=" + this.f19642c + ", errorCode=" + this.d + ", successCode=" + this.e + ", needReport=true)";
    }
}
