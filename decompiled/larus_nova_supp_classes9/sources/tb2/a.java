package tb2;

import android.text.Spannable;
import android.text.SpannableString;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public Spannable a;
    public final List<C0284a> b;

    /* JADX INFO: renamed from: tb2.a$a, reason: collision with other inner class name */
    public static class C0284a {
        public final k a;

        public C0284a(k r1) {
            this.a = r1;
        }
    }

    public a() {
        this.a = new SpannableString(BuildConfig.FLAVOR);
        this.b = new ArrayList();
    }
}
