package kwb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmSearchInputView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.titlebar.MmTitleBarView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final /* synthetic */ int h = 0;
    public final View a;
    public final MmTitleBarView b;
    public final MmSearchInputView c;
    public final ImageView d;
    public final TextView e;
    public final TextView f;
    public final RecyclerView g;

    public static final class a {
    }

    static {
    }

    public c(View r3) {
        Intrinsics.checkNotNullParameter(r3, "root");
        this.a = r3;
        Object r0 = r3.findViewById(2131388775);
        if (r0 == null) goto L27;
        this.b = (MmTitleBarView) r0;
        Object r1 = r3.findViewById(2131385295);
        if (r1 == null) goto L25;
        this.c = (MmSearchInputView) r1;
        View r2 = r3.findViewById(2131378988);
        if (r2 == null) goto L23;
        this.d = (ImageView) r2;
        View r4 = r3.findViewById(2131371567);
        if (r4 == null) goto L21;
        this.e = (TextView) r4;
        View r5 = r3.findViewById(2131371746);
        if (r5 == null) goto L19;
        this.f = (TextView) r5;
        RecyclerView r6 = r3.findViewById(2131365137);
        if (r6 == null) goto L17;
        this.g = r6;
        return;
    L17:
        throw new IllegalStateException("Required view not found, id=2131365137, type=RecyclerView");
    L19:
        throw new IllegalStateException("Required view not found, id=2131371746, type=".concat(TextView.class.getSimpleName()));
    L21:
        throw new IllegalStateException("Required view not found, id=2131371567, type=".concat(TextView.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131378988, type=".concat(ImageView.class.getSimpleName()));
    L25:
        throw new IllegalStateException("Required view not found, id=2131385295, type=MmSearchInputView");
    L27:
        throw new IllegalStateException("Required view not found, id=2131388775, type=MmTitleBarView");
    }
}
