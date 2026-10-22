package r29;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class g implements Function0 {
    public final /* synthetic */ Context a;

    public /* synthetic */ g(Context r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ConstraintLayout r0 = LayoutInflater.from(this.a).inflate(2131561956, null, false);
        int r1 = 2131376208;
        if (ViewBindings.findChildViewById(r0, 2131376208) == null) goto L9;
        r1 = 2131390556;
        if (((TextView) ViewBindings.findChildViewById(r0, 2131390556)) == null) goto L9;
        return r0;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
