package uj0;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface d {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static String a(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r2) {
            Intrinsics.checkNotNullParameter(r2, "struct");
            return "micseat_" + r2.f;
        }
    }

    static {
        a = a.a;
    }

    void a(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r1);

    void b(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r1, Bitmap r2);

    void init();

    void release();
}
