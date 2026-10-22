package com.ss.android.lark.chameleon;

import com.ss.android.lark.chameleon.pluginsystem.BaseWebService;
import com.ss.android.lark.chameleon.pluginsystem.Web;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleon/AbsWebService;", "Lcom/ss/android/lark/chameleon/pluginsystem/BaseWebService;", "()V", "bindBridgeHandlerAutoUnbind", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "handlerName", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "handler", "Lcom/ss/android/lark/chameleon/api/AbsChameleonHandler;", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class AbsWebService extends BaseWebService {
    public AbsWebService() {
    }

    public final void bindBridgeHandlerAutoUnbind(String r2, com.ss.android.lark.chameleon.api.AbsChameleonHandler<?> r3) {
        super.bindBridgeHandlerAutoUnbind(r2, r3);
        if (r3 == null) goto L11;
        Web r4 = getWeb();
        if ((r4 instanceof com.ss.android.lark.chameleon.api.IChameleonHandlerContext) == false) goto L8;
        com.ss.android.lark.chameleon.api.IChameleonHandlerContext r5 = (com.ss.android.lark.chameleon.api.IChameleonHandlerContext) r4;
    L9:
        r3.setContext(r5);
        return;
    L8:
        r5 = null;
        goto L9
    }
}
