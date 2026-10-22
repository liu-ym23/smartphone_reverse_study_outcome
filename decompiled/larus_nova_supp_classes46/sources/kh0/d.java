package kh0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements c.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ WeakReference b;

    @Override // kh0.c.a
    public final void a(Sticker r3) {
        Intrinsics.checkNotNullParameter(r3, "sticker");
        Map<String, Sticker> r0 = c.a;
        c.a.put(this.a, r3);
        r3.setDownloading(false);
        r3.setDownloaded(true);
        WeakReference r1 = this.b;
        if (r1 == null) goto L7;
        c.a r2 = (c.a) r1.get();
        if (r2 == null) goto L7;
        r2.a(r3);
    L7:
        ALogger.i("CommonStickerManager", "#RevenueStickerDebug# download success for effectName: " + this.a);
    }

    @Override // kh0.c.a
    public final void onError(Exception r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        WeakReference r0 = this.b;
        if (r0 == null) goto L7;
        c.a r1 = (c.a) r0.get();
        if (r1 == null) goto L7;
        r1.onError(r2);
    L7:
        ALogger.w("CommonStickerManager", "#RevenueStickerDebug# download error for effectName: " + this.a);
    }

    public d(String r1, WeakReference r2) {
        this.a = r1;
        this.b = r2;
    }
}
