package tt0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final ImageView d;
    public final ViewGroup e;

    public c(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        this.e = r4;
        LayoutInflater.from(r4.getContext()).inflate(2131567789, r4, true);
        this.a = (TextView) r4.findViewById(2131383217);
        this.b = (TextView) r4.findViewById(2131383218);
        this.c = (TextView) r4.findViewById(2131383219);
        this.d = (ImageView) r4.findViewById(2131383216);
    }
}
