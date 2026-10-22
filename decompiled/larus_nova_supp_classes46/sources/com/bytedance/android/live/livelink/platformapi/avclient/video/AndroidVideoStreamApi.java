package com.bytedance.android.live.livelink.platformapi.avclient.video;

import com.bytedance.android.live.pushstream.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import uf2.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AndroidVideoStreamApi {
    public final Lazy a;
    public final a b;
    public final d c;

    public static final class a {
        public final /* synthetic */ AndroidVideoStreamApi a;

        public final void a() {
            wv0.a r0 = (wv0.a) this.a.a.getValue();
            if (r0 == null) goto L6;
            r0.b(this.a.c);
            return;
        }

        public final void b() {
            wv0.a r0 = (wv0.a) this.a.a.getValue();
            if (r0 == null) goto L6;
            r0.release();
            return;
        }

        public a(AndroidVideoStreamApi r1) {
            this.a = r1;
        }
    }

    public final x b() {
        return this.c.b();
    }

    public AndroidVideoStreamApi(d r2) {
        Intrinsics.checkNotNullParameter(r2, "liveStream");
        this.c = r2;
        this.a = LazyKt.lazy(AndroidVideoStreamApi$mStreamSignHelper$2.INSTANCE);
        this.b = new a(this);
    }

    public final void c(String r2) {
        this.c.B(r2);
    }

    public final void a(int r2, int r3) {
        this.c.z0(r2, r3);
    }
}
