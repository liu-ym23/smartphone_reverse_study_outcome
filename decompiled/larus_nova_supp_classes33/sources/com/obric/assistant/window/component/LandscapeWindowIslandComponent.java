package com.obric.assistant.window.component;

import android.content.res.Configuration;
import android.content.res.Resources;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.spi.window.WindowOpenSource;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.island.IslandApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001 B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0002R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000f¨\u0006!"}, d2 = {"Lcom/obric/assistant/window/component/LandscapeWindowIslandComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/window/ability/ILandscapeWindowIslandAbility;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "Lcom/obric/assistant/spi/window/WindowLifecycleListener;", "<init>", "()V", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "Lkotlin/Lazy;", "isDialogueMode", "", "()Z", "isLandscape", "onCreate", "", "onDestroy", "onWindowPreOpened", "source", "Lcom/obric/assistant/spi/window/WindowOpenSource;", "onWindowOpened", "onWindowStashed", "onWindowDismissed", "onChatStyleChanged", "isChatWindow", "onPageStateChanged", "pageState", "Lcom/obric/assistant/data/ObricFloatChatPageState;", "isCollapseDialogue", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandscapeWindowIslandComponent extends ComponentFeature implements xha.a, hca.b, wga.b {
    public final Lazy h;

    public static final class a {
    }

    public static final class b implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.d.class));
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

    public final void onWindowStashed() {
    }

    public final void r2(boolean r1) {
    }

    public final void onCreate() {
        IAssistantChatWindow r0 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r0 == null) goto L5;
        r0.addWindowLifecycleListener(this);
    L5:
        laa.d r1 = (laa.d) this.h.getValue();
        if (r1 == null) goto L9;
        r1.HU(this);
        return;
    }

    public final void onDestroy() {
        IAssistantChatWindow r0 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r0 == null) goto L5;
        r0.removeWindowLifecycleListener(this);
    L5:
        laa.d r1 = (laa.d) this.h.getValue();
        if (r1 == null) goto L9;
        r1.AN(this);
        return;
    }

    public LandscapeWindowIslandComponent() {
        this.h = LazyKt.lazy(new b(this));
    }

    public final boolean F2() {
        Resources r0 = getContext().getResources();
        if (r0 == null) goto L9;
        Configuration r1 = r0.getConfiguration();
        if (r1 == null) goto L9;
        if (r1.orientation != 2) goto L9;
        boolean r2 = true;
    L10:
        FLogger r3 = FLogger.a;
        r3.i("LandscapeWindowIslandComponent", "isLandscape: " + r2);
        if (r2 == false) goto L15;
        boolean r4 = com.obric.assistant.live.api.j.a.e();
        r3.i("LandscapeWindowIslandComponent", "isDialogueMode: " + r4);
        if (r4 == false) goto L15;
        return true;
    L15:
        return false;
    L9:
        r2 = false;
        goto L10
    }

    public final void onWindowPreOpened(WindowOpenSource r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        FLogger.a.i("LandscapeWindowIslandComponent", "onWindowPreOpened: " + hashCode());
        if (F2() == false) goto L5;
        com.obric.assistant.live.api.j.a.j();
        return;
    L5:
        IslandApi r4 = ILiveCard.Companion.getInst().getIslandService();
        if (r4 == null) goto L10;
        r4.collapseIsland();
        return;
    }

    public final void x1(ObricFloatChatPageState r4) {
        Intrinsics.checkNotNullParameter(r4, "pageState");
        FLogger.a.i("LandscapeWindowIslandComponent", "onPageStateChanged: " + r4);
        if (F2() == false) goto L6;
        com.obric.assistant.live.api.j.a.j();
        return;
    }
}
