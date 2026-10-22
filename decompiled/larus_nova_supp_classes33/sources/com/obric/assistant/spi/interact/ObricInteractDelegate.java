package com.obric.assistant.spi.interact;

import androidx.fragment.app.FragmentManager;
import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010\u0006J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010\u0006J\t\u0010\u0010\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0012H\u0096\u0001J\u001d\u0010\u001d\u001a\u00020\u00122\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u001fH\u0096\u0001J\t\u0010 \u001a\u00020\u0012H\u0096\u0001J\u0011\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0014H\u0096\u0001J\t\u0010'\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0005H\u0096\u0001¨\u0006*"}, d2 = {"Lcom/obric/assistant/spi/interact/ObricInteractDelegate;", "Lcom/obric/assistant/spi/interact/IObricInteractService;", "<init>", "()V", "getRelaunchEvent", "", "()Ljava/lang/Boolean;", "getWakeupSource", "isAiKeyLongPress", "isAiKeyPressing", "isAiKeyShortPress", "isContLockScreenQueryReply", "msg", "Lcom/larus/im/bean/message/Message;", "isNeedAutoUploadScreenshotWhenQuery", "isNeedUpdatePageState", "isShowAuthResult", "notifyAiKeyEvent", "", "aiKeyPressEvent", "", "notifyChangeWindowEvent", "isFull", "notifyRelaunchEvent", "isFromRelaunch", "notifyWakeupEvent", "isWakeup", "playDeactivate", "playWarning", "registerOnWindowChangeEventCallback", "callback", "Lkotlin/Function1;", "resetIsAiKeyLongPress", "setAlreadyShowAuthResult", "isAlreadyShowAuthResult", "shouldRecoverMainFragmentAfterRestore", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "containerId", "unregisterOnWindowChangeEventCallback", "updateMuteStatus", "mute", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInteractDelegate implements IObricInteractService {
    public static final ObricInteractDelegate b = null;
    public final /* synthetic */ IObricInteractService a;

    static {
        b = new ObricInteractDelegate();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean getRelaunchEvent() {
        return this.a.getRelaunchEvent();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean getWakeupSource() {
        return this.a.getWakeupSource();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean isAiKeyLongPress() {
        return this.a.isAiKeyLongPress();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean isAiKeyPressing() {
        return this.a.isAiKeyPressing();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean isAiKeyShortPress() {
        return this.a.isAiKeyShortPress();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final boolean isContLockScreenQueryReply(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return this.a.isContLockScreenQueryReply(r2);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean isNeedUpdatePageState() {
        return this.a.isNeedUpdatePageState();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void notifyAiKeyEvent(int r2) {
        this.a.notifyAiKeyEvent(r2);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void notifyChangeWindowEvent(boolean r2) {
        this.a.notifyChangeWindowEvent(r2);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void notifyRelaunchEvent(boolean r2) {
        this.a.notifyRelaunchEvent(r2);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void notifyWakeupEvent(boolean r2) {
        this.a.notifyWakeupEvent(r2);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void resetIsAiKeyLongPress() {
        this.a.resetIsAiKeyLongPress();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void setAlreadyShowAuthResult(boolean r2) {
        this.a.setAlreadyShowAuthResult(false);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final boolean shouldRecoverMainFragmentAfterRestore(FragmentManager r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        return this.a.shouldRecoverMainFragmentAfterRestore(r2, 2131373275);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void updateMuteStatus(boolean r2) {
        this.a.updateMuteStatus(r2);
    }

    private ObricInteractDelegate() {
        IObricInteractService r0 = (IObricInteractService) ServiceManager.get().getService(IObricInteractService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultInteractServiceImpl();
    L5:
        this.a = r0;
    }
}
