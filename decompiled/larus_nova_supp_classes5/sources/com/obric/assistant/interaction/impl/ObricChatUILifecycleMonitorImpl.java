package com.obric.assistant.interaction.impl;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IObricChatUILifecycleMonitor;
import java.util.concurrent.CopyOnWriteArrayList;
import ji8.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0007\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/impl/ObricChatUILifecycleMonitorImpl;", "Lcom/obric/assistant/interaction/api/IObricChatUILifecycleMonitor;", "<init>", "()V", "init", "", "chatUILifecycleObserver", "com/obric/assistant/interaction/impl/ObricChatUILifecycleMonitorImpl$chatUILifecycleObserver$2$1", "getChatUILifecycleObserver", "()Lcom/obric/assistant/interaction/impl/ObricChatUILifecycleMonitorImpl$chatUILifecycleObserver$2$1;", "chatUILifecycleObserver$delegate", "Lkotlin/Lazy;", "stopComplexTaskOfConv", "convId", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatUILifecycleMonitorImpl implements IObricChatUILifecycleMonitor {
    public static final Companion Companion = null;
    private static final String TAG = "ObricChatUILifecycleMonitorImpl";
    private final Lazy chatUILifecycleObserver$delegate;

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ ObricChatUILifecycleMonitorImpl$chatUILifecycleObserver$2$1 a(ObricChatUILifecycleMonitorImpl r0) {
        return chatUILifecycleObserver_delegate$lambda$0(r0);
    }

    private final ObricChatUILifecycleMonitorImpl$chatUILifecycleObserver$2$1 getChatUILifecycleObserver() {
        return (ObricChatUILifecycleMonitorImpl$chatUILifecycleObserver$2$1) this.chatUILifecycleObserver$delegate.getValue();
    }

    public void init() {
        FLogger.a.d(TAG, "init");
        CopyOnWriteArrayList r0 = a.a;
        ObricChatUILifecycleMonitorImpl$chatUILifecycleObserver$2$1 r1 = getChatUILifecycleObserver();
        Intrinsics.checkNotNullParameter(r1, "observer");
        a.a.add(r1);
    }

    public ObricChatUILifecycleMonitorImpl() {
        this.chatUILifecycleObserver$delegate = LazyKt.lazy(new o(this));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.assistant.interaction.impl.ObricChatUILifecycleMonitorImpl$chatUILifecycleObserver$2$1] */
    private static final ObricChatUILifecycleMonitorImpl$chatUILifecycleObserver$2$1 chatUILifecycleObserver_delegate$lambda$0(final ObricChatUILifecycleMonitorImpl r1) {
        return new ObricChatUILifecycleMonitorImpl$chatUILifecycleObserver$2$1(r1);
    }

    public void stopComplexTaskOfConv(String r8) {
        if (r8 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        FLogger.a.d(TAG, "stopComplexTaskOfConv: convId null or empty");
        return;
    L12:
        FLogger.a.d(TAG, "stopComplexTaskOfConv: convId = " + r8);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new stopComplexTaskOfConv.1(r8, null), 3, null);
        return;
    L4:
        if (r8.length() == 0) goto L7;
        r0 = false;
        goto L9
    }
}
