package v98;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.larus.avlink.gallery.view.w0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k {
    public final Context a;
    public final Function1<String, Boolean> b;

    public final View a() {
        View r0 = LayoutInflater.from(this.a).inflate(2131562798, null);
        ((LinearLayout) r0.findViewById(2131364702)).setOnClickListener(new h(this));
        ((LinearLayout) r0.findViewById(2131364832)).setOnClickListener(new i(this));
        ((LinearLayout) r0.findViewById(2131364723)).setOnClickListener(new j(this));
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public k(FragmentActivity r2, w0 r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onItemClick");
        this.a = r2;
        this.b = r3;
    }
}
