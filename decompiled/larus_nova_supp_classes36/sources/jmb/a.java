package jmb;

import android.app.Application;
import com.bytedance.ee.bear.basesdk.apisupport.l;
import com.bytedance.ee.bear.basesdk.apisupport.p;
import com.bytedance.ee.bear.contract.config.DocDynamicConfig;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements l {
    public final Application a;

    public final p dependency() {
        return new f();
    }

    public final on4.a docBaseConfig() {
        return new c();
    }

    public a() {
        this.a = LarkContext.getApplication();
    }

    public final DocDynamicConfig docDynamicConfig() {
        return d.a();
    }

    public final Application application() {
        return this.a;
    }
}
