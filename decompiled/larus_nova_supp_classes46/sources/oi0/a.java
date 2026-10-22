package oi0;

import com.bytedance.android.livesdkapi.model.SeiAppData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a {
    public static final C0247a a = null;

    /* JADX INFO: renamed from: oi0.a$a, reason: collision with other inner class name */
    public static final class C0247a {
        public static final /* synthetic */ C0247a a = null;

        public C0247a() {
        }

        static {
            a = new C0247a();
        }
    }

    static {
        a = C0247a.a;
    }

    void onCreate();

    void onDestroy();

    void onSeiUpdated(SeiAppData r1);

    void w0(boolean r1);
}
