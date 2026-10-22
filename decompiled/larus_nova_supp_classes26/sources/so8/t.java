package so8;

import com.larus.bmhome.chat.zoom.IZoomInAnimationProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t {
    public static final t a = null;
    public static final Map<String, List<IZoomInAnimationProvider>> b = null;

    public t() {
    }

    static {
        a = new t();
        b = new LinkedHashMap();
        Iterator r0 = ServiceManager.get().getServices(IZoomInAnimationProvider.class, true).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        IZoomInAnimationProvider r1 = (IZoomInAnimationProvider) r0.next();
        t r2 = a;
        Intrinsics.checkNotNull(r1);
        r2.getClass();
        r1.h();
        Map<String, List<IZoomInAnimationProvider>> r3 = b;
        List<IZoomInAnimationProvider> r4 = r3.get(r1.h());
        if (r4 != null) goto L8;
        r4 = new ArrayList();
    L8:
        r4.add(r1);
        r3.put(r1.h(), r4);
        goto L4
    }
}
