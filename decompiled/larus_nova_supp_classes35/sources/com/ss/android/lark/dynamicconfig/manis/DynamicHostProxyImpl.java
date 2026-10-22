package com.ss.android.lark.dynamicconfig.manis;

import android.content.Context;
import com.ss.android.lark.manis.annotation.RemoteServiceImpl;
import java.util.List;
import jcb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@RemoteServiceImpl(service = DynamicHostProxy.class)
public class DynamicHostProxyImpl implements DynamicHostProxy {
    private Context mContext;

    @Override // com.ss.android.lark.dynamicconfig.manis.DynamicHostProxy
    public String getDocMainDomain() {
        return b.c().a("docs_main_domain");
    }

    @Override // com.ss.android.lark.dynamicconfig.manis.DynamicHostProxy
    public String getMainDomain() {
        return b.c().a("suite_main_domain");
    }

    @Override // com.ss.android.lark.dynamicconfig.manis.DynamicHostProxy
    public List<String> getMainDomains() {
        return b.c().b("suite_main_domain");
    }

    public DynamicHostProxyImpl(Context r1) {
        this.mContext = r1;
    }
}
