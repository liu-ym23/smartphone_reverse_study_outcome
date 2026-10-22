package com.obric.assistant;

import com.larus.setting.api.ICustomAboutApp;
import com.larus.trace.tracknode.TraceFragment;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/ObricAboutAppImpl;", "Lcom/larus/setting/api/ICustomAboutApp;", "<init>", "()V", "getCustomAboutAppFragment", "Lcom/larus/trace/tracknode/TraceFragment;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAboutAppImpl implements ICustomAboutApp {
    public ObricAboutAppImpl() {
    }

    public final TraceFragment a() {
        if (ObricFeatureServiceDelegate.b.c() == true) goto L7;
        return null;
    L7:
        return new ObricAboutAppFragment();
    }
}
