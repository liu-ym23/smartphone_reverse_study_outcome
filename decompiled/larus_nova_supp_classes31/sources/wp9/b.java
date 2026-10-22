package wp9;

import android.net.Uri;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final SimpleDraweeView r7, final Uri r8, String r9, final int r10, final int r11) {
        Intrinsics.checkNotNullParameter(r9, "bizTag");
        if (r7 == null) goto L8;
        if (r8 == null) goto L9;
        ImageLoaderKt.x(r7, r8, r9, null, new a(r8, r7, r10, r11), 4);
        return;
    L9:
        return;
    }
}
