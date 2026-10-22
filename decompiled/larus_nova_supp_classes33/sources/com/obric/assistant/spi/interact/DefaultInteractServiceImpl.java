package com.obric.assistant.spi.interact;

import androidx.fragment.app.FragmentManager;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u001c\u0010\n\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\fH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u0011J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010 \u001a\u00020\u0007H\u0016J\u000f\u0010!\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u0011J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u0011J\u0018\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001aH\u0016J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)H\u0016¨\u0006+"}, d2 = {"Lcom/obric/assistant/spi/interact/DefaultInteractServiceImpl;", "Lcom/obric/assistant/spi/interact/IObricInteractService;", "<init>", "()V", "updateMuteStatus", "", "mute", "", "playDeactivate", "playWarning", "registerOnWindowChangeEventCallback", "callback", "Lkotlin/Function1;", "unregisterOnWindowChangeEventCallback", "notifyChangeWindowEvent", "isFull", "isNeedUpdatePageState", "()Ljava/lang/Boolean;", "notifyWakeupEvent", "isWakeup", "getWakeupSource", "notifyRelaunchEvent", "isFromRelaunch", "getRelaunchEvent", "notifyAiKeyEvent", "aiKeyPressEvent", "", "resetIsAiKeyLongPress", "setAlreadyShowAuthResult", "isAlreadyShowAuthResult", "isAiKeyLongPress", "isAiKeyShortPress", "isShowAuthResult", "isAiKeyPressing", "isNeedAutoUploadScreenshotWhenQuery", "shouldRecoverMainFragmentAfterRestore", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "containerId", "isContLockScreenQueryReply", "msg", "Lcom/larus/im/bean/message/Message;", "Companion", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultInteractServiceImpl implements IObricInteractService {

    public static final class a {
    }

    static {
    }

    public DefaultInteractServiceImpl() {
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final boolean isContLockScreenQueryReply(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return false;
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void notifyAiKeyEvent(int r1) {
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void notifyChangeWindowEvent(boolean r1) {
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void notifyRelaunchEvent(boolean r1) {
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void notifyWakeupEvent(boolean r1) {
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void resetIsAiKeyLongPress() {
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void setAlreadyShowAuthResult(boolean r1) {
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final boolean shouldRecoverMainFragmentAfterRestore(FragmentManager r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "fragmentManager");
        return false;
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void updateMuteStatus(boolean r1) {
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean getRelaunchEvent() {
        return Boolean.FALSE;
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean getWakeupSource() {
        return Boolean.FALSE;
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean isAiKeyLongPress() {
        return Boolean.FALSE;
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean isAiKeyPressing() {
        return Boolean.FALSE;
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean isAiKeyShortPress() {
        return Boolean.FALSE;
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean isNeedUpdatePageState() {
        return Boolean.FALSE;
    }
}
