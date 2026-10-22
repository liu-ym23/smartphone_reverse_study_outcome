package n1b;

import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.tea.ITea$Internal$EventItem;
import com.ss.android.lark.chameleonv2.lkapi.tea.ITea$Internal$Events;
import com.ss.android.lark.statistics.Statistics;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends z0b.a {

    /* JADX INFO: renamed from: n1b.a$a, reason: collision with other inner class name */
    public static final class C0260a {
    }

    public final class b extends AbsChameleonHandler<ITea$Internal$Events> {
        public final String a;

        public b() {
            this.a = LKAPIModules.Internal.Tea.TrackNoReturn.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(ITea$Internal$Events r3, Callback r4) {
            ITea$Internal$Events r5 = r3;
            Intrinsics.checkNotNullParameter(r5, "req");
            Intrinsics.checkNotNullParameter(r4, "callback");
            Iterator<T> r6 = r5.getValue().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            ITea$Internal$EventItem r7 = (ITea$Internal$EventItem) r6.next();
            Statistics.sendEvent(r7.getEventName(), new JSONObject(r7.getParams()));
            goto L4
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
