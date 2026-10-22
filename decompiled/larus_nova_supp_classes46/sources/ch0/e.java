package ch0;

import android.view.View;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.network.annotation.PbRequest;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public final ILinkPlayerInfoBridge a;
    public final h b;
    public final j c;
    public final Map<String, Object> d;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "LinkUserMergeData(linkPlayerInfo=" + this.a + ", rtcUserInfo=" + this.b + ", seiLinkerInfo=" + this.c + ", extInfos=" + this.d + ")";
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public /* synthetic */ e(ILinkPlayerInfoBridge r3) {
        this(r3, null, null, new HashMap());
    }

    public final boolean b(ILinkPlayerInfoBridge r2) {
        Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.OTHER);
        return this.a.isEqual(r2);
    }

    public final boolean c(h r7) {
        h r0 = this.b;
        if (r0 != r7) goto L6;
        return true;
    L6:
        if (r0 == null) goto L40;
        if (r7 == null) goto L40;
        View r3 = null;
        if (r0 == null) goto L11;
        String r1 = r0.a;
    L13:
        if ((!Intrinsics.areEqual(r1, r7.a)) == false) goto L15;
        return false;
    L15:
        h r2 = this.b;
        if (r2 != null) goto L18;
    L39:
        return false;
    L18:
        if (r2.e != r7.e) goto L39;
        if (r2 == null) goto L39;
        if (r2.d != r7.d) goto L39;
        if (r2 == null) goto L39;
        if (r2.c != r7.c) goto L39;
        if (r2 == null) goto L31;
        r3 = r2.b;
    L31:
        if ((!Intrinsics.areEqual(r3, r7.b)) == false) goto L33;
        return false;
    L33:
        h r4 = this.b;
        if (r4 == null) goto L39;
        if (r4.g != r7.g) goto L39;
        return true;
    L11:
        r1 = null;
    L40:
        if (r0 != null) goto L43;
        if (r7 != null) goto L43;
        return true;
    L43:
        return false;
    }

    public final boolean d(j r6) {
        j r0 = this.c;
        if (r0 != r6) goto L6;
        return true;
    L6:
        if (r0 == null) goto L33;
        if (r6 == null) goto L33;
        if (r0 == null) goto L10;
        String r1 = r0.a;
    L12:
        if ((!Intrinsics.areEqual(r1, r6.a)) == false) goto L14;
        return false;
    L14:
        j r2 = this.c;
        if (r2 != null) goto L17;
    L32:
        return false;
    L17:
        if (r2.b != r6.b) goto L32;
        if (r2 == null) goto L32;
        if (r2.c != r6.c) goto L32;
        if (r2 == null) goto L32;
        if (r2.d != r6.d) goto L32;
        if (r2 == null) goto L32;
        if (r2.e != r6.e) goto L32;
        return true;
    L10:
        r1 = null;
    L33:
        if (r0 != null) goto L36;
        if (r6 != null) goto L36;
        return true;
    L36:
        return false;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 == null) goto L8;
        Class<?> r2 = r4.getClass();
    L10:
        if ((!Intrinsics.areEqual(e.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r4 == null) goto L24;
        e r5 = (e) r4;
        if (b(r5.a) == true) goto L17;
        return false;
    L17:
        if (c(r5.b) == true) goto L20;
        return false;
    L20:
        if (d(r5.c) == true) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.datamerge.entity.LinkUserMergeData");
    L8:
        r2 = null;
        goto L10
    }

    public e(ILinkPlayerInfoBridge r2, h r3, j r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "linkPlayerInfo");
        Intrinsics.checkNotNullParameter(r5, "extInfos");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public static e a(e r1, ILinkPlayerInfoBridge r2, h r3, j r4, Map r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.b;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.c;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = r1.d;
    L14:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "linkPlayerInfo");
        Intrinsics.checkNotNullParameter(r5, "extInfos");
        return new e(r2, r3, r4, r5);
    }
}
