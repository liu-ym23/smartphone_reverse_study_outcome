package uj0;

import android.graphics.Bitmap;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements SingleOnSubscribe {
    public final /* synthetic */ b a;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.avatarmix.d b;
    public final /* synthetic */ Bitmap c;

    public c(b r1, com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r2, Bitmap r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(SingleEmitter<b.a> r4) {
        Intrinsics.checkNotNullParameter(r4, "emitter");
        d.a r0 = d.a;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r1 = this.b;
        r0.getClass();
        String r2 = d.a.a(r1);
        Map<String, b.a> r3 = this.a.c;
        int r5 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.b;
        LinkedHashMap r6 = (LinkedHashMap) r3;
        b.a r7 = (b.a) r6.get(com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.C0097a.a(this.b));
        if (r7 == null) goto L6;
        r7.getClass();
    L6:
        if (this.c != null) goto L9;
        r4.onError(new Throwable("bitmap is null"));
        return;
    L9:
        Disposable r8 = (Disposable) ((LinkedHashMap) this.a.b).get(r2);
        if (r8 == null) goto L12;
        r8.dispose();
    L12:
        this.a.getClass();
    }
}
