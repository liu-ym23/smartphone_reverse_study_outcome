package n4a;

import android.text.TextUtils;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public static final String b = null;
    public static final String c = null;
    public static final String d = null;
    public static final String e = null;
    public static final String f = null;
    public static boolean g;
    public String a;

    static {
        b = f5.o("SRFZHZUVZT3BOa0ZiemZRQQ");
        c = f5.o("FbGJzX3Nkaw");
        d = f5.o("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
        e = f5.o("FQU5EU0RLMTA");
        f = f5.o("FMTAw");
        g = false;
    }

    public i() {
        this.a = NameKeys.UnloadStrategy_No_Strategy;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.a) == false) goto L5;
        String r0 = f5.d(y4.e("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA"));
        StringBuffer r1 = new StringBuffer();
        int r2 = 0;
        int r3 = 0;
    L8:
        if (r3 >= r0.length()) goto L10;
        r1.append((char) (r0.charAt(r3) - (r3 % 48)));
        r3 = r3 + 1;
        goto L8
    L10:
        String r4 = r1.toString();
        StringBuffer r5 = new StringBuffer();
    L12:
        if (r2 >= (r4.length() / 2)) goto L14;
        r5.append((char) ((r4.charAt(r2) + r4.charAt((r4.length() - 1) - r2)) / 2));
        r2 = r2 + 1;
        goto L12
    L14:
        String r6 = r5.toString();
        this.a = r6;
        return r6;
    L5:
        return this.a;
    }
}
