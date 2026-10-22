package com.obric.assistant.interaction.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"WindowEffects", "Lcom/obric/assistant/interaction/api/IWindowEffects;", "getWindowEffects", "()Lcom/obric/assistant/interaction/api/IWindowEffects;", "WindowEffects$delegate", "Lkotlin/Lazy;", "api_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class IWindowEffectsKt {
    private static final Lazy WindowEffects$delegate = null;

    public static /* synthetic */ IWindowEffects a() {
        return WindowEffects_delegate$lambda$0();
    }

    static {
        WindowEffects$delegate = LazyKt.lazy(new f());
    }

    private static final IWindowEffects WindowEffects_delegate$lambda$0() {
        Object r0 = ServiceManager.get().getService(IWindowEffects.class);
        Intrinsics.checkNotNull(r0);
        return (IWindowEffects) r0;
    }

    public static final IWindowEffects getWindowEffects() {
        return (IWindowEffects) WindowEffects$delegate.getValue();
    }
}
