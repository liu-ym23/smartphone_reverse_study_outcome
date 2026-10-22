package qcb;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final Activity a;
    public int b;

    /* JADX INFO: renamed from: qcb.a$a, reason: collision with other inner class name */
    public static final class C0284a {
    }

    static {
    }

    public final Activity getActivity() {
        return this.a;
    }

    public a(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
        this.b = 300;
    }
}
