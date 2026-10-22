package ugb;

import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class a implements e {
    public final View a;
    public final ViewGroup b;
    public View c;

    /* JADX INFO: renamed from: ugb.a$a, reason: collision with other inner class name */
    public static final class C0331a {
    }

    static {
    }

    public a(CoreNavigationBar r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        this.a = r2;
        this.b = (ViewGroup) r2.findViewById(2131373027);
    }
}
