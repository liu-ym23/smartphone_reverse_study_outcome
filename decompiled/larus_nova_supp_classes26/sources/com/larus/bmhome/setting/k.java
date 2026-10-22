package com.larus.bmhome.setting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k implements t1a.c {
    public final boolean a;

    public k() {
        this(false);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof k) == true) goto L9;
        return false;
    L9:
        if (this.a == ((k) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "SettingsData(isAppSettings=" + this.a + ')';
    }

    public k(boolean r1) {
        this.a = r1;
    }
}
