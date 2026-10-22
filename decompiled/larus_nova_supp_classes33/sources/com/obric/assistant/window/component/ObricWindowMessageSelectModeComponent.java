package com.obric.assistant.window.component;

import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.spi.window.WindowOpenSource;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/window/component/ObricWindowMessageSelectModeComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/spi/window/WindowLifecycleListener;", "<init>", "()V", "chatMessageShareAbility", "Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "getChatMessageShareAbility", "()Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "chatMessageShareAbility$delegate", "Lkotlin/Lazy;", "isWindowLifecycleListenerRegistered", "", "onCreate", "", "onDestroy", "onWindowOpened", "source", "Lcom/obric/assistant/spi/window/WindowOpenSource;", "onWindowStashed", "registerWindowLifecycleListener", "unregisterWindowLifecycleListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWindowMessageSelectModeComponent extends ComponentFeature implements wga.b {
    public final Lazy h;
    public boolean i;

    public static final class a {
    }

    public static final class b implements Function0<IChatMessageShareAbility> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(IChatMessageShareAbility.class));
        }
    }

    static {
    }

    public final void onScreenRotationChanged(int r1, int r2) {
    }

    public final void onWindowDismissed() {
    }

    public final void onWindowOpened(WindowOpenSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    public final void onWindowPreDismissed() {
    }

    public final void onWindowPreOpenClear() {
    }

    public final void onWindowPreStashed() {
    }

    public final void onCreate() {
        if (this.i == true) goto L11;
        IAssistantChatWindow r0 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r0 == null) goto L8;
        r0.addWindowLifecycleListener(this);
        this.i = true;
        FLogger.a.i("ObricWindowMessageSelectModeComponent", "registerWindowLifecycleListener");
        return;
    L8:
        FLogger.a.w("ObricWindowMessageSelectModeComponent", "registerWindowLifecycleListener ignored, IAssistantChatWindow is null");
        return;
    }

    public final void onDestroy() {
        if (this.i == false) goto L10;
        IAssistantChatWindow r0 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r0 == null) goto L8;
        r0.removeWindowLifecycleListener(this);
    L8:
        this.i = false;
        FLogger.a.i("ObricWindowMessageSelectModeComponent", "unregisterWindowLifecycleListener");
        return;
    }

    public final void onWindowStashed() {
        IChatMessageShareAbility r0 = (IChatMessageShareAbility) this.h.getValue();
        boolean r1 = false;
        if (r0 == null) goto L8;
        if (r0.H1() != true) goto L8;
        r1 = true;
    L8:
        if (r1 == true) goto L11;
        FLogger.a.i("ObricWindowMessageSelectModeComponent", "onWindowStashed: skip exit select mode, isSelectMode=false");
        return;
    L11:
        FLogger.a.i("ObricWindowMessageSelectModeComponent", "onWindowStashed: exit message select mode");
        r0.j();
    }

    public ObricWindowMessageSelectModeComponent() {
        this.h = LazyKt.lazy(new b(this));
    }

    public final void onWindowPreOpened(WindowOpenSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }
}
