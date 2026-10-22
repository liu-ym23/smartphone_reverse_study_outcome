package ws0;

import android.content.Context;
import com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import n56.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements IJsMethodsProvideService.IFactory {
    public b() {
    }

    public final Map<String, c> buildMethods(WeakReference<Context> r1, n56.a r2) {
        return MapsKt.mapOf(TuplesKt.to("crossplatformOpenLiveProfile", new a(r1)));
    }
}
