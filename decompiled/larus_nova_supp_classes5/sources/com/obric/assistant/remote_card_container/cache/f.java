package com.obric.assistant.remote_card_container.cache;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class f implements Function0 {
    public /* synthetic */ f() {
    }

    public final Object invoke() {
        return new PolarisFileWrapper(new PolarisFileWrapper(AppHost.a.getApplication().getFilesDir(), "obric"), "remote_card");
    }
}
