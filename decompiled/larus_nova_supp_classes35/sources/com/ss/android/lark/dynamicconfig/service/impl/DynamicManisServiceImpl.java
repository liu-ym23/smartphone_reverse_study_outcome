package com.ss.android.lark.dynamicconfig.service.impl;

import android.content.Context;
import com.ss.android.lark.dynamicconfig.interfaces.IDynamicManisService;
import com.ss.android.lark.manis.annotation.RemoteServiceImpl;
import jcb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@RemoteServiceImpl(service = IDynamicManisService.class)
public class DynamicManisServiceImpl implements IDynamicManisService {
    private Context mContext;

    public DynamicManisServiceImpl(Context r1) {
        this.mContext = r1;
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDynamicManisService
    public String getDynamicDomain(String r2) {
        return b.c().a(r2);
    }
}
