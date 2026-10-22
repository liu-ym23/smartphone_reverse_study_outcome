package l0b;

import android.util.LruCache;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonWebViewClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final LruCache<String, String> a = null;

    static {
        a = new LruCache(ChameleonWebViewClient.DEFAULT_SAFE_TIME);
    }
}
