package pp1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e {
    public final int a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof f) == true) goto L6;
        return false;
    L6:
        if (this.a == ((f) r2).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "LandscapeVisibilityCommand(visibility=" + this.a + ")";
    }

    public f(int r1) {
        this.a = r1;
    }
}
