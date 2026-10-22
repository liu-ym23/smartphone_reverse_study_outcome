package hf;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.n;
import com.bytedance.iesgurd.meta.PrepareMeta;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f17317a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f17318b;

    static {
        f17317a = new AtomicInteger(1);
        f17318b = "";
    }

    public static void a(List r5, n r10) {
        GeckoLogger.a("UpdateQueue add: " + r5.size() + '-' + r10.f4763j.ordinal());
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        PrepareMeta r12 = (PrepareMeta) r11.next();
        if (r12.getTimeAddQueue() != 0) goto L8;
        r12.setTimeAddQueue(System.currentTimeMillis());
    L8:
        int r13 = f17317a.getAndIncrement() + ((3 - r10.f4763j.ordinal()) * 10000000);
        r12.getReqType();
        r12.getAccessKey();
        r12.getGroupName();
        r12.getChannel();
        xa.a r14 = (xa.a) com.bytedance.geckox.utils.c.f4793c.getValue();
        r14.f23001a.execute(new e(r12, r13, r10, r13));
        goto L4
    }
}
