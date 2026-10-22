package x00;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface c extends x00.a {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        a = a.a;
    }

    @Override // x00.a
    IVoiceLiveTheme a(int r1);

    void b();

    void r(FragmentActivity r1, long r2, String r4, IThemeShowArea r5, int r6, ThemeUpLoadListener r7);
}
