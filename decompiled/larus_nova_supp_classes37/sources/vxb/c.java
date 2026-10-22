package vxb;

import com.bytedance.ee.lark.infra.sandbox.context.IAppContext;
import com.bytedance.ee.lark.infra.sandbox.context.IBaseService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class c implements IBaseService {
    public b a;

    public c() {
    }

    public final IAppContext getAppContext() {
        return this.a;
    }
}
