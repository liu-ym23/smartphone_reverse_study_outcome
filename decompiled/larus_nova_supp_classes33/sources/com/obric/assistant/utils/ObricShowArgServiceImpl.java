package com.obric.assistant.utils;

import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.guide.IObricUserGuide;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0016R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/utils/ObricShowArgServiceImpl;", "Lcom/obric/assistant/utils/IObricShowArgService;", "<init>", "()V", "wakeupSource", "Ljava/util/concurrent/atomic/AtomicReference;", "", "kotlin.jvm.PlatformType", "isAssistantRequestFromAIKey", "", "setWakeupSource", "", "source", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricShowArgServiceImpl implements IObricShowArgService {
    public final AtomicReference<String> a;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.utils.IObricShowArgService
    public final boolean isAssistantRequestFromAIKey() {
        FLogger.a.i("ObricShowArgServiceImpl", "isAssistantRequestFromAIKey, wakeupSource: " + this.a.get());
        if (Intrinsics.areEqual(this.a.get(), "WAKEUP_SOURCE_AI_KEY_DOWN") == true) goto L7;
        if (Intrinsics.areEqual(this.a.get(), "WAKEUP_SOURCE_AI_KEY_UP") == true) goto L7;
        return false;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        IObricUserGuide r0 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        if (r0 != null) goto L11;
    L13:
        boolean r1 = false;
    L15:
        if (r1 == false) goto L19;
        return true;
    L19:
        return false;
    L11:
        if (r0.b() != true) goto L13;
    L14:
        r1 = true;
        goto L15
    }

    public ObricShowArgServiceImpl() {
        this.a = new AtomicReference(IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER);
    }

    @Override // com.obric.assistant.utils.IObricShowArgService
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        FLogger r0 = FLogger.a;
        r0.i("ObricShowArgServiceImpl", "source: " + r5);
        if (Intrinsics.areEqual(r5, IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER) == false) goto L7;
        this.a.set(r5);
        return;
    L7:
        if (AppHost.a.a().isAppBackground() == true) goto L10;
        r0.i("ObricShowArgServiceImpl", "setWakeupSource, app is not background, source: " + r5);
        return;
    L10:
        this.a.set(r5);
    }
}
