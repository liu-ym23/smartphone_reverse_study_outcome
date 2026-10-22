package com.ss.android.lark.dynamicconfig.interfaces;

import com.ss.android.lark.manis.annotation.RemoteService;
import ee.android.framework.manis.interfaces.IHookInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@RemoteService
public interface IDynamicManisService extends IHookInterface {
    String getDynamicDomain(String r1);
}
