package of;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final Context a;
    public final String b;
    public final boolean c;
    public final DialogFragment d;
    public final JSONObject e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof b) == false) goto L16;
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r11.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public final int hashCode() {
        Context r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.b;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        boolean r15 = this.c;
        ?? r16 = r15;
        if (r15 == false) goto L13;
        r16 = 1;
    L13:
        int r17 = (r14 + r16) * 31;
        DialogFragment r18 = this.d;
        if (r18 == null) goto L16;
        int r19 = r18.hashCode();
    L17:
        int r20 = (r17 + r19) * 31;
        JSONObject r21 = this.e;
        if (r21 == null) goto L21;
        r1 = r21.hashCode();
    L21:
        return r20 + r1;
    L16:
        r19 = 0;
        goto L17
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "UserTrackerContext(context=" + this.a + ", pageId=" + this.b + ", canShowPendant=" + this.c + ", pendantDialogFragment=" + this.d + ", pendantMargin=" + this.e + ")";
    }

    public final Context getContext() {
        return this.a;
    }

    public b(Context r10, String r11, boolean r12, DialogFragment r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "pageId");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
    }

    public /* synthetic */ b(Context r10, String r11, boolean r12, DialogFragment r13, int r14) {
        if ((r14 & 4) == 0) goto L5;
        boolean r15 = false;
    L7:
        if ((r14 & 8) == 0) goto L9;
        r13 = null;
    L9:
        this(r10, r11, r15, r13, null);
        return;
    L5:
        r15 = r12;
        goto L7
    }
}
