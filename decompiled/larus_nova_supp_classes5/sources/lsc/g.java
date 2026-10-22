package lsc;

import android.content.Context;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g {
    public final Context a;
    public final List<j> b;
    public final TextView.BufferType c;
    public ysc.a d;

    public g(Context r3) {
        this.b = new ArrayList(3);
        this.c = TextView.BufferType.SPANNABLE;
        this.a = r3;
    }

    public final g a(a r2) {
        ((ArrayList) this.b).add(r2);
        return this;
    }
}
