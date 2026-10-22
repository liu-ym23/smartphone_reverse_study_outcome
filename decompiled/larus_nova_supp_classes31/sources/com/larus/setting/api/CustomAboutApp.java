package com.larus.setting.api;

import com.larus.trace.tracknode.TraceFragment;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/larus/setting/api/CustomAboutApp;", "Lcom/larus/setting/api/ICustomAboutApp;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/setting/api/ICustomAboutApp;", "impl$delegate", "Lkotlin/Lazy;", "getCustomAboutAppFragment", "Lcom/larus/trace/tracknode/TraceFragment;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CustomAboutApp implements ICustomAboutApp {
    public static final CustomAboutApp a = null;
    public static final Lazy b = null;

    private CustomAboutApp() {
    }

    static {
        a = new CustomAboutApp();
        b = LazyKt.lazy(new b());
    }

    @Override // com.larus.setting.api.ICustomAboutApp
    public final TraceFragment a() {
        ICustomAboutApp r0 = (ICustomAboutApp) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }
}
