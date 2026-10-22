package s98;

import android.os.Trace;
import com.larus.avlink.gallery.processor.m;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(int r2, m r3) {
        Intrinsics.checkNotNullParameter(r3, "block");
        Trace.beginSection(StringsKt.take("DoraAlbum#video_sdk_call_t" + r2, 120));
        Object r4 = r3.invoke();     // Catch: Throwable -> L6
        Trace.endSection();
        return r4;
    L6:
        th = move-exception;
        Trace.endSection();
        throw th;
    }
}
