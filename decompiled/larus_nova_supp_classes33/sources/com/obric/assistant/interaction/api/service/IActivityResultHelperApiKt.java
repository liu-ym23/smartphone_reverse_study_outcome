package com.obric.assistant.interaction.api.service;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"ActivityResultHelper", "Lcom/obric/assistant/interaction/api/service/IActivityResultHelperApi;", "getActivityResultHelper", "()Lcom/obric/assistant/interaction/api/service/IActivityResultHelperApi;", "ActivityResultHelper$delegate", "Lkotlin/Lazy;", "api_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class IActivityResultHelperApiKt {
    private static final Lazy ActivityResultHelper$delegate = null;

    public static /* synthetic */ IActivityResultHelperApi a() {
        return ActivityResultHelper_delegate$lambda$0();
    }

    static {
        ActivityResultHelper$delegate = LazyKt.lazy(new a());
    }

    private static final IActivityResultHelperApi ActivityResultHelper_delegate$lambda$0() {
        return (IActivityResultHelperApi) ServiceManager.get().getService(IActivityResultHelperApi.class);
    }

    public static final IActivityResultHelperApi getActivityResultHelper() {
        return (IActivityResultHelperApi) ActivityResultHelper$delegate.getValue();
    }
}
