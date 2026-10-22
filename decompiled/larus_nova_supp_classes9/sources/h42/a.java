package h42;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.interactivity.pin.business.im.api.ImHighlightRequest;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final String a;
    public final long b;
    public final long c;
    public final long d;
    public final Map<String, String> e;
    public final User f;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L18;
        a r7 = (a) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.c;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = this.d;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        Map<String, String> r9 = this.e;
        if (r9 == null) goto L9;
        int r10 = r9.hashCode();
    L10:
        int r11 = (r8 + r10) * 31;
        User r13 = this.f;
        if (r13 == null) goto L14;
        r1 = r13.hashCode();
    L14:
        return r11 + r1;
    L9:
        r10 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ImPinContent(scene=" + this.a + ", msgId=" + this.b + ", commenterId=" + this.c + ", showArea=" + this.d + ", buriedPoint=" + this.e + ", user=" + this.f + ")";
    }

    public a(long r3, long r5, long r7, Map r9, User r10) {
        Intrinsics.checkNotNullParameter(ImHighlightRequest.SCENE, "scene");
        this.a = ImHighlightRequest.SCENE;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r9;
        this.f = r10;
    }
}
