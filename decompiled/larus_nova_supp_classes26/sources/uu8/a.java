package uu8;

import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class a {
    public final Bundle a;

    public final String a() {
        String r0 = this.a.getString("click_from");
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.length() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L11;
        r0 = null;
    L11:
        return r0;
    L7:
        r2 = false;
        goto L8
    }

    public final String b() {
        String r0 = this.a.getString("create_way");
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.length() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L11;
        r0 = null;
    L11:
        return r0;
    L7:
        r2 = false;
        goto L8
    }

    public final String c() {
        String r0 = this.a.getString("creation_id");
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.length() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L11;
        r0 = null;
    L11:
        return r0;
    L7:
        r2 = false;
        goto L8
    }

    public a() {
        this.a = new Bundle();
    }
}
