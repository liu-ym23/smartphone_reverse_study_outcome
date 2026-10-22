package oh8;

import android.util.LruCache;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.layout.item.LynxBox;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final LruCache<String, List<LynxBox>> a = null;
    public static final Keva b = null;

    static {
        a = new LruCache(5);
        b = Keva.getRepo("MARKDOWN_LYNX_HEIGHT");
    }
}
