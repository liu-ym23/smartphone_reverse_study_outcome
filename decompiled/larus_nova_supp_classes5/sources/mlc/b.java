package mlc;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static a a(String r1, Object r2) {
        if ((r2 instanceof Context) == false) goto L7;
        return new a((Context) r2, r1);
    L7:
        throw new IllegalArgumentException("must parse context arguement in Settings!");
    }
}
