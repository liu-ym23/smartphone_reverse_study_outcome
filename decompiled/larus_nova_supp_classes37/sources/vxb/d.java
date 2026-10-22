package vxb;

import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.ee.lark.infra.sandbox.context.IBaseService;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final Map<Class, IBaseService> a;

    public final void a() {
        if (((ConcurrentHashMap) this.a).isEmpty() == false) goto L6;
        AppBrandLogger.i("ServiceManagerImpl", new Object[]{"Services is empty!"});
        return;
    L6:
        AppBrandLogger.i("ServiceManagerImpl", new Object[]{"destroy"});
        Iterator r0 = ((ConcurrentHashMap) this.a).values().iterator();
    L8:
        if (r0.hasNext() == false) goto L12;
        IBaseService r1 = (IBaseService) r0.next();
        if (r1 == null) goto L8;
        r1.release();
        goto L8
    L12:
        ((ConcurrentHashMap) this.a).clear();
    }

    public d() {
        this.a = new ConcurrentHashMap();
    }
}
