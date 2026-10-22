package k1b;

import com.bytedance.apm.ApmAgent;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.slardar.ISlardar$Internal$EventItem;
import com.ss.android.lark.chameleonv2.lkapi.slardar.ISlardar$Internal$Events;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends z0b.a {

    /* JADX INFO: renamed from: k1b.a$a, reason: collision with other inner class name */
    public static final class C0244a {
    }

    public final class b extends AbsChameleonHandler<ISlardar$Internal$Events> {
        public final String a;

        public b() {
            this.a = LKAPIModules.Internal.Slardar.SendEvents.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(ISlardar$Internal$Events r6, Callback r7) {
            ISlardar$Internal$Events r8 = r6;
            Intrinsics.checkNotNullParameter(r8, "req");
            Intrinsics.checkNotNullParameter(r7, "callback");
            Iterator<T> r9 = r8.getValue().iterator();
        L4:
            if (r9.hasNext() == false) goto L14;
            ISlardar$Internal$EventItem r0 = (ISlardar$Internal$EventItem) r9.next();
            String r1 = r0.getEventName();
            HashMap<String, String> r2 = r0.getPayload().getCategory();
            if (r2 == null) goto L8;
            JSONObject r3 = new JSONObject(r2);
        L9:
            JSONObject r4 = r3;
            JSONObject r5 = new JSONObject(r0.getPayload().getMetric());
            HashMap<String, String> r10 = r0.getPayload().getExtra();
            if (r10 == null) goto L12;
            JSONObject r11 = new JSONObject(r10);
        L13:
            ApmAgent.monitorEvent(r1, r4, r5, r11);
            goto L4
        L12:
            r11 = new com.alibaba.fastjson.JSONObject();
            goto L13
        L8:
            r3 = new com.alibaba.fastjson.JSONObject();
            goto L9
        L14:
            r7.success(BuildConfig.FLAVOR);
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        return CollectionsKt.arrayListOf(new b[]{new b()});
    }

    public a() {
    }
}
