package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.text.TextUtils;
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends BaseDispatchAction {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f1838p;

    static {
    }

    public g() {
        this.f1838p = false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.BaseDispatchAction
    public boolean e(JSONObject r10, String r11, long r12) {
        ArrayList r13 = new ArrayList();
        r13.add(0, Boolean.FALSE);
        boolean r14 = u(r10, r13, r11, r12);
        this.f1838p = r13.get(0).booleanValue();
        return r14;
    }

    public abstract BaseDispatchAction.DispatchResultEnum r(y2.c r10, String r11, List<String> r12);

    public abstract int s();

    public int t() {
        return NetError.ERR_TTNET_TRAFFIC_CONTROL_DROP;
    }

    protected abstract boolean u(JSONObject r10, List<Boolean> r11, String r12, long r13);

    public boolean v() {
        return this.f1838p;
    }

    public BaseDispatchAction.DispatchResultEnum w(y2.c r10, String r11, List<String> r12, List<y2.a> r13) {
        if (f(r10) == true) goto L5;
    L15:
        r12.set(0, r11);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L15;
        BaseDispatchAction.DispatchResultEnum r14 = r(r10, r11, r12);
        y2.a r15 = new y2.a();
        if (r14 == BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE) goto L13;
        r15.f13662d = true;
        r15.f13660b = c();
        r15.f13661c = b();
        r15.f13663e = s();
        r15.f13659a = d();
        if (r14 != BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT) goto L12;
        r15.f13665g = r12.get(0);
        r15.f13664f = v();
    L12:
        r10.e(this.f1813m);
    L13:
        r13.add(r15);
        return r14;
    }
}
