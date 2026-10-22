package tt0;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.ProfileFansClub;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.c1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.ui.util.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final View a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final View e;
    public final TextView f;
    public final TextView g;
    public final ViewGroup h;

    public b(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        this.h = r4;
        LayoutInflater.from(r4.getContext()).inflate(2131567791, r4, true);
        View r0 = r4.findViewById(2131383264);
        this.a = r0;
        this.c = (TextView) r4.findViewById(2131383267);
        this.d = (TextView) r4.findViewById(2131383268);
        if (r0 == null) goto L5;
        TextView r1 = (TextView) r0.findViewById(2131383265);
    L6:
        this.b = r1;
        this.e = r4.findViewById(2131383210);
        this.f = (TextView) r4.findViewById(2131383209);
        this.g = (TextView) r4.findViewById(2131383211);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void a(ProfileFansClub r4) {
        View r0 = this.e;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r0);
    L5:
        int r1 = m.a;
        m.a(this.f);
        if (r4 != null) goto L8;
        Pair r5 = c1.b(0);
    L13:
        TextView r2 = this.f;
        if (r2 == null) goto L16;
        r2.setText(((String) r5.first).toString());
    L16:
        TextView r3 = this.g;
        if (r3 == null) goto L34;
        Object[] r6 = new Object[1];
        String r7 = (String) r5.second;
        if (r7 != null) goto L22;
        r7 = "";
    L22:
        r6[0] = r7;
        r3.setText(s1.C(2131920685, r6));
        return;
    L34:
        return;
    L8:
        String r8 = r4.fansCountStr;
        if (r8 == null) goto L11;
    L24:
        if (r8 == null) goto L28;
        TextView r9 = this.f;
        if (r9 == null) goto L28;
        r9.setText(r8);
    L28:
        String r10 = r4.fansCountSubStr;
        if (r10 == null) goto L35;
        TextView r12 = this.g;
        if (r12 == null) goto L36;
        r12.setText(r10);
        return;
    L36:
        return;
    L35:
        return;
    L11:
        if (r4.fansCountSubStr != null) goto L24;
        r5 = c1.b(r4.totalFansCount);
        goto L13
    }
}
