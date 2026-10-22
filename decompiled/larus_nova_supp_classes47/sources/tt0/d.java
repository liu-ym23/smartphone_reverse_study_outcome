package tt0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public final View a;
    public final TextView b;
    public final TextView c;
    public final ViewGroup d;

    public d(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        this.d = r4;
        LayoutInflater.from(r4.getContext()).inflate(2131567790, r4, true);
        this.a = r4.findViewById(2131383261);
        this.b = (TextView) r4.findViewById(2131383260);
        this.c = (TextView) r4.findViewById(2131383262);
    }
}
