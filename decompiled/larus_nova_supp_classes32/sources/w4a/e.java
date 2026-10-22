package w4a;

import com.lynx.xelement.webview.LynxUIWebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static final e b = null;
    public final String a;

    static {
        b = new e(LynxUIWebView.DEFAULT);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }

    public e(String r1) {
        this.a = r1.toLowerCase();
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof e) == true) goto L10;
        return false;
    L10:
        return this.a.equals(((e) r2).a);
    }
}
