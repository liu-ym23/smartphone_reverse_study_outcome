package op8;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k implements t1a.c {
    public final WeakReference<Fragment> a;
    public final WeakReference<View> b;
    public boolean c;

    public static final class a {
    }

    static {
    }

    public final Fragment a() {
        Fragment r0 = this.a.get();
        if (r0 == null) goto L15;
        if (r0.isAdded() == true) goto L7;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L15;
        return r0;
    L7:
        if (r0.getView() == null) goto L11;
        if (r0.getView() != this.b.get()) goto L11;
        r2 = true;
    L15:
        return null;
    }

    public k(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, MusicAppletPage.KEY_SOURCE);
        this.a = new WeakReference(r2);
        this.b = new WeakReference(r2.getView());
    }
}
