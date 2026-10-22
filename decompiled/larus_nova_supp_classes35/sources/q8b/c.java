package q8b;

import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.traffic.handler.MatchRegulate;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface c extends b {

    public static final class a {
        public static boolean a(c r11, DecisionData.Action r12) {
            Intrinsics.checkNotNullParameter(r12, Keys.API_PARAM_KEY_ACTION);
            Intrinsics.checkNotNullParameter(r12, Keys.API_PARAM_KEY_ACTION);
            String r0 = r12.getName();
            String r1 = r12.getParams().get("policyType");
            m8b.c r13 = com.ss.android.lark.conditional.access.network.model.response.a.b(r12);
            Iterator<T> r14 = r11.getRules().iterator();
        L3:
            boolean r3 = false;
            if (r14.hasNext() == false) goto L54;
            i r2 = (i) r14.next();
            MatchRegulate r4 = r2.a.b;
            int[] r5 = b.a.a;
            int r6 = r5[r4.ordinal()];
            if (r6 == 1) goto L15;
            if (r6 == 2) goto L14;
            if (r6 != 3) goto L13;
            if (r0 == null) goto L14;
            boolean r7 = false;
        L16:
            int r9 = r5[r2.b.b.ordinal()];
            if (r9 == 1) goto L26;
            if (r9 == 2) goto L25;
            if (r9 != 3) goto L24;
            if (r1 == null) goto L25;
            boolean r10 = false;
        L27:
            int r8 = r5[r2.c.b.ordinal()];
            if (r8 == 1) goto L37;
            if (r8 == 2) goto L36;
            if (r8 != 3) goto L35;
            if (r13.a == null) goto L36;
        L38:
            if (r7 == false) goto L3;
            if (r10 == false) goto L3;
            if (r3 == false) goto L3;
            return true;
        L35:
            throw new NoWhenBranchMatchedException();
        L36:
            r3 = true;
            goto L38
        L37:
            r3 = Intrinsics.areEqual(r2.c.a, r13.a);
            goto L38
        L24:
            throw new NoWhenBranchMatchedException();
        L25:
            r10 = true;
            goto L27
        L26:
            r10 = Intrinsics.areEqual(r2.b.a, r1);
            goto L27
        L13:
            throw new NoWhenBranchMatchedException();
        L14:
            r7 = true;
            goto L16
        L15:
            r7 = Intrinsics.areEqual(r2.a.a, r0);
            goto L16
        L54:
            return false;
        }
    }

    void a(InternalSecurityAction r1);

    String c();
}
