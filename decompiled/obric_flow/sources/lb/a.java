package lb;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.launcher.widget.R$id;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends FrameLayout {
    public a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null, 0);
        FrameLayout r10 = new FrameLayout(getContext());
        r10.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r10.setId(R$id.bullet_container);
        addView(r10);
    }
}
