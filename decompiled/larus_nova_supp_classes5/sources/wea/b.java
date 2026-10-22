package wea;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static final List<WeakReference<a>> a = null;

    static {
        a = Collections.synchronizedList(new ArrayList());
    }
}
