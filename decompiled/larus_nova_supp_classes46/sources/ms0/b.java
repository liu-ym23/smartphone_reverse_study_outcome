package ms0;

import com.bytedance.android.live.preinit.setting.LiveSettingManager;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        Function1<Boolean, Unit> r4 = LiveSettingManager.INSTANCE.getSETTING_CALLBACK();
        if (r4 == null) goto L6;
        Unit r5 = (Unit) r4.invoke(Boolean.TRUE);
        return;
    }
}
