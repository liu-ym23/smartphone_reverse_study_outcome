package rc0;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j {
    public final boolean a;
    public final View b;
    public final LiveMode c;
    public final String d;
    public final q e;
    public final boolean f;
    public final int g;
    public final boolean h;
    public final int i;
    public final boolean j;
    public final String k;
    public final Context l;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L30;
        j r4 = (j) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (this.i == r4.i) goto L24;
        return false;
    L24:
        if (this.j == r4.j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        View r4 = this.b;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        int r7 = (r3 + r6) * 31;
        LiveMode r8 = this.c;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r11 = (r7 + r9) * 31;
        String r12 = this.d;
        if (r12 == null) goto L16;
        int r13 = r12.hashCode();
    L17:
        int r14 = (r11 + r13) * 31;
        q r15 = this.e;
        if (r15 == null) goto L20;
        int r16 = r15.hashCode();
    L21:
        int r17 = (r14 + r16) * 31;
        boolean r18 = this.f;
        ?? r19 = r18;
        if (r18 == false) goto L24;
        r19 = 1;
    L24:
        int r21 = (((r17 + r19) * 31) + this.g) * 31;
        boolean r22 = this.h;
        ?? r23 = r22;
        if (r22 == false) goto L27;
        r23 = 1;
    L27:
        int r24 = (((r21 + r23) * 31) + this.i) * 31;
        boolean r25 = this.j;
        if (r25 == true) goto L31;
        r1 = r25;
    L31:
        int r26 = (r24 + r1) * 31;
        String r27 = this.k;
        if (r27 == null) goto L34;
        int r28 = r27.hashCode();
    L35:
        int r29 = (r26 + r28) * 31;
        Context r31 = this.l;
        if (r31 == null) goto L39;
        r5 = r31.hashCode();
    L39:
        return r29 + r5;
    L34:
        r28 = 0;
        goto L35
    L20:
        r16 = 0;
        goto L21
    L16:
        r13 = 0;
        goto L17
    L12:
        r9 = 0;
        goto L13
    L8:
        r6 = 0;
        goto L9
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("InRoomStreamParam{source=");
        r0.append(this.k);
        r0.append(",liveMode=");
        r0.append(this.c);
        r0.append(",pkBarHeight=");
        r0.append(this.g);
        r0.append(",transForPkBar=");
        r0.append(this.f);
        r0.append(",allowRotateScreen=");
        r0.append(this.j);
        r0.append(",");
        q r1 = this.e;
        JSONObject r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.a;
    L6:
        if (r3 != null) goto L8;
        r0.append("appDataString=null,");
    L8:
        q r4 = this.e;
        if (r4 == null) goto L11;
        r2 = r4.b;
    L11:
        if (r2 != null) goto L13;
        r0.append("appDataJson=null,");
    L13:
        r0.append("seiRaw=");
        r0.append(this.d);
        r0.append(",playerView=");
        r0.append(this.b);
        r0.append("}");
        return r0.toString();
    L5:
        r3 = null;
        goto L6
    }

    public final Context getContext() {
        return this.l;
    }

    public j(boolean r2, AbsLivePlayerView r3, LiveMode r4, String r5, q r6, boolean r7, int r8, boolean r9, int r11, boolean r12, String r13, Context r14) {
        Intrinsics.checkNotNullParameter(r3, "playerView");
        Intrinsics.checkNotNullParameter(r4, "liveMode");
        Intrinsics.checkNotNullParameter(r5, "seiRaw");
        Intrinsics.checkNotNullParameter(r13, "source");
        Intrinsics.checkNotNullParameter(r14, "context");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }
}
