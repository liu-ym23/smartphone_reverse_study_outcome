package cq1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.utils.ntp.e;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public final List<BusinessConfigure> a;
    public final LinkedList<BusinessConfigure> b;
    public final LinkedList<BusinessConfigure> c;

    /* JADX INFO: renamed from: cq1.a$a, reason: collision with other inner class name */
    public static final class C0376a<T> implements Comparator<T> {
        public C0376a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((BusinessConfigure) r3).delayMills), Long.valueOf(((BusinessConfigure) r4).delayMills));
        }
    }

    public static final class b {
    }

    static {
    }

    public a(List<? extends BusinessConfigure> r10) {
        this.a = new ArrayList();
        this.b = new LinkedList();
        this.c = new LinkedList();
        if (r10 == null) goto L25;
        Iterator<T> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L25;
        BusinessConfigure r0 = (BusinessConfigure) r11.next();
        if (r0.resourceConfig == null) goto L6;
        if (r0.displaySecond != 0) goto L12;
        r0.displaySecond = 5;
    L12:
        long r1 = r0.deliveryType;
        if (r1 == BusinessConfigure.DeliveryType.ENTER) goto L15;
        if (r1 != BusinessConfigure.DeliveryType.TIMING) goto L6;
        long r2 = r0.preciseTime;
        if (r2 <= 0) goto L6;
        long r5 = BubbleId.PadCast;
        if (((r2 * r5) - e.a()) <= 0) goto L6;
        long r3 = (r0.preciseTime * r5) - e.a();
        r0.remainDelayMills = r3;
        r0.delayMills = r3;
        ((ArrayList) this.a).add(r0);
        goto L6
    L15:
        if (r0.delaySecond != 0) goto L17;
        r0.delaySecond = 2;
    L17:
        long r4 = ((long) r0.delaySecond) * 1000;
        r0.remainDelayMills = r4;
        r0.delayMills = r4;
        ((ArrayList) this.a).add(r0);
    L25:
        ArrayList r12 = (ArrayList) this.a;
        if (r12.size() <= 1) goto L28;
        CollectionsKt.sortWith(r12, new C0376a());
    L28:
        ALogger.i("BusinessConfigure", "business waiting list " + this.a);
    }
}
