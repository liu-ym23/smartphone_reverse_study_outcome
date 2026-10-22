package sp8;

import com.bytedance.keva.Keva;
import com.larus.bmhome.input.api.EnterKeyAction;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final EnterKeyAction a = null;
    public static final Lazy b = null;
    public static final StateFlowImpl c = null;
    public static final b1 d = null;

    static {
        a = EnterKeyAction.NEWLINE;
        Lazy r0 = LazyKt.lazy(new a());
        b = r0;
        StateFlowImpl r1 = j1.a(a(((Keva) r0.getValue()).getInt("user_enter_key_behavior_".concat(o.a.getDeviceId()), -1)));
        c = r1;
        d = e.b(r1);
    }

    public static EnterKeyAction a(int r3) {
        if (z2.a.enableEnterKeyBehaviorSetting() == false) goto L5;
        Iterator r0 = EnterKeyAction.getEntries().iterator();
    L8:
        if (r0.hasNext() == false) goto L15;
        Object r1 = r0.next();
        if (((EnterKeyAction) r1).getValue() != r3) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L8;
    L16:
        EnterKeyAction r4 = (EnterKeyAction) r1;
        if (r4 == null) goto L19;
        return r4;
    L19:
        return a;
    L12:
        r2 = false;
        goto L13
    L15:
        r1 = null;
        goto L16
    L5:
        return a;
    }
}
