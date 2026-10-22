package i7a;

import android.graphics.Path;
import com.lynx.tasm.utils.LRUHashMap;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final LRUHashMap<Path, a> a = null;

    public static class a {
        public float a;
        public final List<Float> b;

        public a() {
            this.b = new ArrayList();
        }
    }

    static {
        a = new LRUHashMap(10);
    }
}
