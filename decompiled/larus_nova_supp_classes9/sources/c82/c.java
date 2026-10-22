package c82;

import android.app.Activity;
import com.bytedance.android.livehostapi.platform.depend.im.ILiveIMCusSerMsgProxy;
import com.bytedance.android.livehostapi.platform.depend.im.ILiveIMDynamicView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements ILiveIMCusSerMsgProxy {
    public static final Map<String, WeakReference<b>> a = null;
    public static long b;
    public static final c c = null;

    public c() {
    }

    static {
        c = new c();
        a = new HashMap();
    }

    public static String a(b r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        String r0 = String.valueOf(b);
        ((HashMap) a).put(r0, new WeakReference(r5));
        b++;
        return r0;
    }

    public final ILiveIMDynamicView getIMDynamicView(Activity r2, Function2<? super Integer, ? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return new a(r2, r3);
    }

    public final void onUnreadCountChanged(long r3, int r5) {
        Iterator r0 = ((HashMap) a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        b r1 = (b) ((WeakReference) ((Map.Entry) r0.next()).getValue()).get();
        if (r1 == null) goto L4;
        r1.a(r3, r5);
        goto L4
    }
}
