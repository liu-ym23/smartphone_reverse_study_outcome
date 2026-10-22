package h0;

import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f7891a = 0;

    public static class a {
        public static int a(Locale r8) {
            return TextUtils.getLayoutDirectionFromLocale(r8);
        }
    }

    static {
        new Locale("", "");
    }
}
