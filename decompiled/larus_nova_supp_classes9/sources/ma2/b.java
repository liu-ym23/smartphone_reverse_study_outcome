package ma2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import d52.c;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class b {
    public InterfaceC0249b a;
    public final Map<Class<?>, a52.a<?, ?>> b;

    public static final class a {
    }

    /* JADX INFO: renamed from: ma2.b$b, reason: collision with other inner class name */
    public interface InterfaceC0249b {
        void Cn(Class r1, d52.b r2, la2.a r3);
    }

    static {
    }

    public abstract float c(float r1);

    public abstract int d(float r1);

    public abstract String e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract <T extends c> void i(Class<T> r1, int r2);

    public abstract void j(DataCenter r1);

    public b() {
        this.b = new LinkedHashMap();
    }

    public final <T extends c> T a(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "styleType");
        a52.a r0 = (a52.a) ((LinkedHashMap) this.b).get(r3);
        if (r0 != null) goto L5;
        ALogger.i("IPSStyleSettingPresenter", r3.getSimpleName() + " has no related strategy in " + getClass().getSimpleName() + ", make sure you register it");
        r0 = null;
    L5:
        if (r0 == null) goto L10;
        BaseStyleSettingModel<T> r4 = r0.a();
        if (r4 != null) goto L9;
        return null;
    L9:
        return (T) r4.b();
    L10:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends c, V> V b(Class<T> r2, Class<V> r3) {
        Intrinsics.checkNotNullParameter(r2, "styleType");
        Intrinsics.checkNotNullParameter(r3, "valueType");
        a52.a r4 = (a52.a) ((LinkedHashMap) this.b).get(r2);
        a52.a r5 = r4;
        if (r4 != null) goto L5;
        ALogger.i("IPSStyleSettingPresenter", r2.getSimpleName() + " has no related strategy in " + e() + ", make sure you register it");
        r5 = 0;
    L5:
        if (r5 != 0) goto L7;
        return null;
    L7:
        return (V) r5.b(r5.a().b());
    }
}
