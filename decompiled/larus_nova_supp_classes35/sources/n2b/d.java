package n2b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public final n2b.a a;
    public View b;
    public View c;
    public LKUILightTextView d;
    public LKUILightTextView e;
    public TextView f;
    public ImageView g;

    public static final class a {
    }

    static {
    }

    public d(n2b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        this.a = r2;
    }

    public final void a(View r2) {
        this.d = ViewCompat.requireViewById(r2, 2131389339);
        this.e = r2.findViewById(2131389341);
        if ((r2 instanceof ConstraintLayout) == false) goto L5;
        ConstraintLayout r0 = (ConstraintLayout) r2;
    L5:
        this.f = (TextView) ViewCompat.requireViewById(r2, 2131389354);
        this.g = (ImageView) ViewCompat.requireViewById(r2, 2131389346);
    }
}
