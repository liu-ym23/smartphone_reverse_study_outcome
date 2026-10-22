package ih;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.core.apt.ActionType;
import com.bytedance.android.ec.core.monitor.attribution.UserActionCacheMap;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import lg.d;
import lg.i;
import lg.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements i {
    public static final a b = null;
    public static final AtomicBoolean c = null;
    public static final C0166a d = null;
    public final Map<String, b> a;

    /* JADX INFO: renamed from: ih.a$a, reason: collision with other inner class name */
    public static final class C0166a {
        public C0166a() {
        }
    }

    static {
        d = new C0166a();
        b = new a();
        c = new AtomicBoolean(false);
    }

    public static JSONObject b() {
        return BtmUtilsKt.f(BtmSDK.getBcmChainByToken$default(BtmSDK.INSTANCE, null, 0, false, 6, null));
    }

    public a() {
        this.a = new LinkedHashMap();
    }

    @Override // lg.i
    public final void a(lg.a r10) {
        Intrinsics.checkNotNullParameter(r10, "actionNode");
        if ((r10 instanceof d) == false) goto L31;
        Map<String, b> r0 = this.a;
        d r1 = (d) r10;
        String r11 = r1.a();
        String r12 = "";
        if (r11 != null) goto L7;
        r11 = "";
    L7:
        LinkedHashMap r13 = (LinkedHashMap) r0;
        Object r14 = r13.get(r11);
        if (r14 != null) goto L13;
        String r15 = r1.a();
        if (r15 != null) goto L12;
        r15 = "";
    L12:
        r14 = new b("ec_action_tracker_plugin__".concat(r15));
        r13.put(r11, r14);
    L13:
        b r16 = (b) r14;
        List<String> r17 = r16.a;
        String r18 = r1.b();
        if (r18 != null) goto L16;
        r18 = "";
    L16:
        ((ArrayList) r17).add(r18);
        if (((ArrayList) r16.a).size() <= 1000) goto L20;
        ListProtector.remove(r16.a, 0);
    L20:
        if ((r10 instanceof j) == false) goto L26;
        UserActionCacheMap<String> r19 = r16.c;
        String r20 = r1.b();
        if (r20 == null) goto L25;
        r12 = r20;
    L25:
        r19.put(r12, r10);
        return;
    L26:
        UserActionCacheMap<ActionType> r21 = r16.b;
        ActionType r22 = r1.getType();
        if (r22 != null) goto L29;
        r22 = ActionType.Empty;
    L29:
        r21.put(r22, r10);
        return;
    }
}
