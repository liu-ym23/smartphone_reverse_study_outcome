package com.tom_roush.pdfbox.pdmodel.interactive.action;

/* JADX INFO: loaded from: classes6.dex */
public final class c {
    public static a a(com.tom_roush.pdfbox.a.d r2) {
        if (r2 == null) goto L45;
        String r0 = r2.g(com.tom_roush.pdfbox.a.i.he);
        if ("JavaScript".equals(r0) == false) goto L7;
        return new g(r2);
    L7:
        if ("GoTo".equals(r0) == false) goto L10;
        return new d(r2);
    L10:
        if ("Launch".equals(r0) == false) goto L13;
        return new h(r2);
    L13:
        if ("GoToR".equals(r0) == false) goto L16;
        return new k(r2);
    L16:
        if ("URI".equals(r0) == false) goto L19;
        return new p(r2);
    L19:
        if ("Named".equals(r0) == false) goto L22;
        return new j(r2);
    L22:
        if ("Sound".equals(r0) == false) goto L25;
        return new m(r2);
    L25:
        if ("Movie".equals(r0) == false) goto L28;
        return new i(r2);
    L28:
        if ("ImportData".equals(r0) == false) goto L31;
        return new f(r2);
    L31:
        if ("ResetForm".equals(r0) == false) goto L34;
        return new l(r2);
    L34:
        if ("Hide".equals(r0) == false) goto L37;
        return new e(r2);
    L37:
        if ("SubmitForm".equals(r0) == false) goto L40;
        return new n(r2);
    L40:
        if ("Thread".equals(r0) == false) goto L43;
        return new o(r2);
    L43:
        if ("GoToE".equals(r0) == false) goto L45;
        return new b(r2);
    L45:
        return null;
    }
}
