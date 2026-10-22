package x6;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final Uri.Builder a(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        return UriProtector.parse("sslocal://webcast_webview?hybrid_type=h5").buildUpon().appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_URL, r10);
    }

    @JvmStatic
    public static final Uri b(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        return UriProtector.parse("sslocal://webcast_webview?hybrid_type=h5").buildUpon().appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_URL, r10).build();
    }

    @JvmStatic
    public static final Uri.Builder c(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        return UriProtector.parse("sslocal://webcast_lynxview?hybrid_type=lynx").buildUpon().appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_URL, r10);
    }

    @JvmStatic
    public static final Uri d(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        return UriProtector.parse("sslocal://webcast_lynxview?hybrid_type=lynx").buildUpon().appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_URL, r10).build();
    }
}
