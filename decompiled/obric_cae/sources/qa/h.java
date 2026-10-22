package qa;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10486b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10487c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10488d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10489e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10490f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f10491g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10492a;

    static {
        f10486b = t4.n("SRFZHZUVZT3BOa0ZiemZRQQ");
        f10487c = t4.n("FbGJzX3Nkaw");
        f10488d = t4.n("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
        f10489e = t4.n("FQU5EU0RLMTA");
        f10490f = t4.n("FMTAw");
        f10491g = false;
    }

    public h() {
        this.f10492a = "";
    }

    public final String a() {
        if (TextUtils.isEmpty(this.f10492a) == false) goto L5;
        String r8 = t4.c(l4.e("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA"));
        StringBuffer r10 = new StringBuffer();
        int r11 = 0;
        int r12 = 0;
    L8:
        if (r12 >= r8.length()) goto L10;
        r10.append((char) (r8.charAt(r12) - (r12 % 48)));
        r12 = r12 + 1;
        goto L8
    L10:
        String r13 = r10.toString();
        StringBuffer r14 = new StringBuffer();
    L12:
        if (r11 >= (r13.length() / 2)) goto L14;
        r14.append((char) ((r13.charAt((r13.length() - 1) - r11) + r13.charAt(r11)) / 2));
        r11 = r11 + 1;
        goto L12
    L14:
        String r15 = r14.toString();
        this.f10492a = r15;
        return r15;
    L5:
        return this.f10492a;
    }
}
