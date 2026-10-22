package com.obric.assistant.spi.interact;

import androidx.fragment.app.FragmentManager;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 (2\u00020\u0001:\u0001(J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u001c\u0010\b\u001a\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0012\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0005H&J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0005H&J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0005H&J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0005H&J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u000fJ\b\u0010\u001e\u001a\u00020\u0005H&J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u000fJ\u000f\u0010 \u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u000fJ\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0018H&J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'H&¨\u0006)"}, d2 = {"Lcom/obric/assistant/spi/interact/IObricInteractService;", "", "updateMuteStatus", "", "mute", "", "playDeactivate", "playWarning", "registerOnWindowChangeEventCallback", "callback", "Lkotlin/Function1;", "unregisterOnWindowChangeEventCallback", "notifyChangeWindowEvent", "isFull", "isNeedUpdatePageState", "()Ljava/lang/Boolean;", "notifyWakeupEvent", "isWakeup", "getWakeupSource", "notifyRelaunchEvent", "isFromRelaunch", "getRelaunchEvent", "notifyAiKeyEvent", "aiKeyPressEvent", "", "resetIsAiKeyLongPress", "setAlreadyShowAuthResult", "isAlreadyShowAuthResult", "isAiKeyLongPress", "isAiKeyShortPress", "isShowAuthResult", "isAiKeyPressing", "isNeedAutoUploadScreenshotWhenQuery", "shouldRecoverMainFragmentAfterRestore", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "containerId", "isContLockScreenQueryReply", "msg", "Lcom/larus/im/bean/message/Message;", "Companion", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricInteractService {
    Boolean getRelaunchEvent();

    Boolean getWakeupSource();

    Boolean isAiKeyLongPress();

    Boolean isAiKeyPressing();

    Boolean isAiKeyShortPress();

    boolean isContLockScreenQueryReply(Message r1);

    Boolean isNeedUpdatePageState();

    void notifyAiKeyEvent(int r1);

    void notifyChangeWindowEvent(boolean r1);

    void notifyRelaunchEvent(boolean r1);

    void notifyWakeupEvent(boolean r1);

    void resetIsAiKeyLongPress();

    void setAlreadyShowAuthResult(boolean r1);

    boolean shouldRecoverMainFragmentAfterRestore(FragmentManager r1, int r2);

    void updateMuteStatus(boolean r1);
}
