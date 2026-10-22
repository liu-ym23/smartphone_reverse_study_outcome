package com.obric.assistant.interaction.impl;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeService;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.interaction.api.IAssistantInteractionService;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.service.IInteractionStateApi;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import com.obric.assistant.interaction.base.model.InteractionEvent;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.spi.interact.IObricInteractService;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003*\u0002\u001b\u001e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u000fH\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u001c\u0010$\u001a\u00020\u00102\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0016J\b\u0010&\u001a\u00020\u0010H\u0016J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u000fH\u0016J\u000f\u0010)\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u000fH\u0002J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u000fH\u0016J\u000f\u0010.\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010*J\u0010\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u000fH\u0016J\u000f\u00101\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010*J\u0010\u00102\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u00103\u001a\u00020\u0010H\u0016J\u0010\u00104\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010*J\u000f\u00105\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010*J\b\u00106\u001a\u00020\u000fH\u0016J\u000f\u00107\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010*J\u000f\u00108\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010*J\u0018\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0016H\u0016J\u0010\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020?H\u0016J\f\u0010@\u001a\u00020\u000f*\u00020AH\u0002J\u0016\u0010B\u001a\u00020\u00052\f\u0010C\u001a\b\u0012\u0004\u0012\u00020A0DH\u0002J\u0012\u0010E\u001a\u00020\u00052\b\u0010F\u001a\u0004\u0018\u00010AH\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006G"}, d2 = {"Lcom/obric/assistant/interaction/impl/ObricInteractServiceImpl;", "Lcom/obric/assistant/spi/interact/IObricInteractService;", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "delegate", "Lcom/obric/assistant/interaction/api/IAssistantInteractionService;", "getDelegate", "()Lcom/obric/assistant/interaction/api/IAssistantInteractionService;", "delegate$delegate", "Lkotlin/Lazy;", "changeChatWindowCallback", "Lkotlin/Function1;", "", "", "isFromWakeupSource", "isFromRelaunchSource", "isEnterBackgroundFromSystemPage", "needUpdatePager", "aiKeyPressEvent", "", "isAiKeyLongPress", "isAlreadyShowAuthResult", "enterSystemPage", "appBackGroundListener", "com/obric/assistant/interaction/impl/ObricInteractServiceImpl$appBackGroundListener$1", "Lcom/obric/assistant/interaction/impl/ObricInteractServiceImpl$appBackGroundListener$1;", "gotoSystemPageCallback", "com/obric/assistant/interaction/impl/ObricInteractServiceImpl$gotoSystemPageCallback$1", "Lcom/obric/assistant/interaction/impl/ObricInteractServiceImpl$gotoSystemPageCallback$1;", "updateMuteStatus", "mute", "playDeactivate", "playWarning", "registerOnWindowChangeEventCallback", "callback", "unregisterOnWindowChangeEventCallback", "notifyChangeWindowEvent", "isFull", "isNeedUpdatePageState", "()Ljava/lang/Boolean;", "setFromWakeupSource", "isWakeup", "notifyWakeupEvent", "getWakeupSource", "notifyRelaunchEvent", "isFromRelaunch", "getRelaunchEvent", "notifyAiKeyEvent", "resetIsAiKeyLongPress", "setAlreadyShowAuthResult", "isAiKeyShortPress", "isShowAuthResult", "isAiKeyPressing", "isNeedAutoUploadScreenshotWhenQuery", "shouldRecoverMainFragmentAfterRestore", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "containerId", "isContLockScreenQueryReply", "msg", "Lcom/larus/im/bean/message/Message;", "isValidRestoredFragment", "Landroidx/fragment/app/Fragment;", "describeFragmentsForLog", "fragments", "", "describeFragmentForLog", "fragment", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInteractServiceImpl implements IObricInteractService {
    private final String TAG;
    private int aiKeyPressEvent;
    private final ObricInteractServiceImpl$appBackGroundListener$1 appBackGroundListener;
    private Function1<? super Boolean, Unit> changeChatWindowCallback;
    private final Lazy delegate$delegate;
    private boolean enterSystemPage;
    private final ObricInteractServiceImpl$gotoSystemPageCallback$1 gotoSystemPageCallback;
    private boolean isAiKeyLongPress;
    private boolean isAlreadyShowAuthResult;
    private boolean isEnterBackgroundFromSystemPage;
    private boolean isFromRelaunchSource;
    private boolean isFromWakeupSource;
    private boolean needUpdatePager;

    public static /* synthetic */ CharSequence a(ObricInteractServiceImpl r0, Fragment r1) {
        return describeFragmentsForLog$lambda$3(r0, r1);
    }

    public static /* synthetic */ IAssistantInteractionService b() {
        return delegate_delegate$lambda$0();
    }

    public void unregisterOnWindowChangeEventCallback() {
        this.changeChatWindowCallback = null;
    }

    private static final IAssistantInteractionService delegate_delegate$lambda$0() {
        return (IAssistantInteractionService) ServiceManager.get().getService(IAssistantInteractionService.class);
    }

    private final IAssistantInteractionService getDelegate() {
        return (IAssistantInteractionService) this.delegate$delegate.getValue();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public Boolean getRelaunchEvent() {
        return Boolean.valueOf(this.isFromRelaunchSource);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public Boolean getWakeupSource() {
        return Boolean.valueOf(this.isFromWakeupSource);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public Boolean isAiKeyLongPress() {
        if (this.aiKeyPressEvent != 3) goto L5;
        boolean r0 = true;
    L6:
        FLogger.a.i(this.TAG, "isLongPressStart, " + r0);
        return Boolean.valueOf(r0);
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public Boolean isAiKeyPressing() {
        FLogger r0 = FLogger.a;
        String r1 = this.TAG;
        StringBuilder r2 = new StringBuilder("isAiKeyPressing, ");
        boolean r4 = false;
        if (this.aiKeyPressEvent != 1) goto L5;
        boolean r3 = true;
    L6:
        r2.append(r3);
        r0.i(r1, r2.toString());
        if (this.aiKeyPressEvent != 1) goto L10;
        r4 = true;
    L10:
        return Boolean.valueOf(r4);
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public Boolean isAiKeyShortPress() {
        FLogger r0 = FLogger.a;
        String r1 = this.TAG;
        StringBuilder r2 = new StringBuilder("isShortPressStart, ");
        boolean r4 = true;
        if (this.aiKeyPressEvent != 2) goto L5;
        boolean r3 = true;
    L6:
        r2.append(r3);
        r0.i(r1, r2.toString());
        if (this.aiKeyPressEvent == 2) goto L11;
        r4 = false;
    L11:
        return Boolean.valueOf(r4);
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public Boolean isNeedUpdatePageState() {
        return Boolean.valueOf(this.needUpdatePager);
    }

    public boolean isShowAuthResult() {
        FLogger r0 = FLogger.a;
        r0.i(this.TAG, "isShowAuthResult: " + this.isAiKeyLongPress);
        String r1 = this.TAG;
        StringBuilder r2 = new StringBuilder("isShowAuthResult, ");
        r2.append(this.isAiKeyLongPress);
        r2.append(" && ");
        r2.append(!this.isAlreadyShowAuthResult);
        r2.append(" && ");
        r2.append(IKeyguardStateKt.getKeyguardState().isKeyguardLocked());
        r2.append(" && ");
        r2.append(!IKeyguardStateKt.getKeyguardState().isDeviceLocked());
        r2.append(" && ");
        r2.append(IKeyguardStateKt.getKeyguardState().isDeviceSecure());
        r0.i(r1, r2.toString());
        if (this.isAiKeyLongPress == true) goto L5;
    L13:
        return false;
    L5:
        if (this.isAlreadyShowAuthResult == true) goto L13;
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L13;
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == true) goto L13;
        if (IKeyguardStateKt.getKeyguardState().isDeviceSecure() == false) goto L13;
        return true;
    }

    public void playDeactivate() {
        SoundEffectHelper.INSTANCE.playDeactivate();
    }

    public void playWarning() {
        SoundEffectHelper.INSTANCE.playWarning();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public void resetIsAiKeyLongPress() {
        FLogger.a.i(this.TAG, "resetShowAuthResult");
        this.isAiKeyLongPress = false;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.assistant.interaction.impl.ObricInteractServiceImpl$appBackGroundListener$1, f09.a$b] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.assistant.interaction.impl.ObricInteractServiceImpl$gotoSystemPageCallback$1, v19.q5] */
    public ObricInteractServiceImpl() {
        this.TAG = "ObricInteractServiceImpl";
        this.delegate$delegate = LazyKt.lazy(new p());
        ?? r0 = new ObricInteractServiceImpl$appBackGroundListener$1(this);
        this.appBackGroundListener = r0;
        ?? r1 = new ObricInteractServiceImpl$gotoSystemPageCallback$1(this);
        this.gotoSystemPageCallback = r1;
        AppHost.a.a().j(r0);
        v19.a.a(r1);
    }

    public Boolean isNeedAutoUploadScreenshotWhenQuery() {
        IAssistantInteractionService r0 = getDelegate();
        if (r0 == null) goto L8;
        IInteractionStateService r1 = r0.get_interactionStateService();
        if (r1 == null) goto L8;
        AssistantActivityExpandState r2 = r1.getInteractionActivityExpandState();
        if (r2 == null) goto L8;
    L9:
        boolean r3 = t1.a.q();
        if (r3 == true) goto L12;
    L14:
        boolean r4 = false;
    L15:
        FLogger.a.i(this.TAG, "isNeedAutoUploadScreenShotWhenQuery,  ret: " + r4 + ", currentWindowState: " + r2 + ", isSemanticScreenShotEnable: " + r3);
        return Boolean.valueOf(r4);
    L12:
        if (r2 != AssistantActivityExpandState.CHAT_WINDOW) goto L14;
        r4 = true;
    L8:
        r2 = AssistantActivityExpandState.NA;
        goto L9
    }

    public static final /* synthetic */ boolean access$getEnterSystemPage$p(ObricInteractServiceImpl r0) {
        return r0.enterSystemPage;
    }

    public static final /* synthetic */ String access$getTAG$p(ObricInteractServiceImpl r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ boolean access$isEnterBackgroundFromSystemPage$p(ObricInteractServiceImpl r0) {
        return r0.isEnterBackgroundFromSystemPage;
    }

    private final String describeFragmentForLog(Fragment r3) {
        if (r3 != null) goto L5;
        return "fragment=null";
    L5:
        return "class=" + r3.getClass().getSimpleName() + ", tag=" + r3.getTag() + ", id=" + r3.getId() + ", isAdded=" + r3.isAdded() + ", isRemoving=" + r3.isRemoving() + ", isDialog=" + (r3 instanceof DialogFragment);
    }

    private final String describeFragmentsForLog(List<? extends Fragment> r10) {
        return CollectionsKt.joinToString$default(r10, null, "[", "]", 0, null, new q(this), 25, null);
    }

    private final boolean isValidRestoredFragment(Fragment r2) {
        if (r2.isAdded() == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.isRemoving() == true) goto L7;
        return true;
    }

    private final void setFromWakeupSource(boolean r2) {
        this.isFromWakeupSource = r2;
        HomeService.a.C(!r2);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public boolean isContLockScreenQueryReply(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        IObricChatService r0 = (IObricChatService) ServiceManager.get().getService(IObricChatService.class);
        if (r0 == null) goto L7;
        r0.isContLockScreenQueryReply(r3);
        return false;
    L7:
        return false;
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public void notifyAiKeyEvent(int r5) {
        FLogger.a.i(this.TAG, "notifyAiKeyEvent, " + r5);
        this.aiKeyPressEvent = r5;
        if (r5 != 3) goto L6;
        this.isAiKeyLongPress = true;
        return;
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public void notifyChangeWindowEvent(boolean r2) {
        Function1<? super Boolean, Unit> r0 = this.changeChatWindowCallback;
        if (r0 == null) goto L6;
        r0.invoke(Boolean.valueOf(r2));
        return;
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public void notifyRelaunchEvent(boolean r1) {
        this.isFromRelaunchSource = r1;
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public void notifyWakeupEvent(boolean r1) {
        setFromWakeupSource(r1);
    }

    public void registerOnWindowChangeEventCallback(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.changeChatWindowCallback = r2;
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public void setAlreadyShowAuthResult(boolean r5) {
        FLogger.a.i(this.TAG, "setAlreadyShowAuthResult, " + r5);
        this.isAlreadyShowAuthResult = r5;
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public void updateMuteStatus(boolean r2) {
        if (r2 == false) goto L8;
        IAssistantInteractionService r3 = getDelegate();
        if (r3 == null) goto L14;
        IInteractionStateApi r4 = r3.get_interactionStateApi();
        if (r4 == null) goto L15;
        r4.onMicMuteStateEvent(InteractionEvent.MicMuteEvent.MuteEvent.INSTANCE);
        return;
    L15:
        return;
    L14:
        return;
    L8:
        IAssistantInteractionService r5 = getDelegate();
        if (r5 == null) goto L17;
        IInteractionStateApi r6 = r5.get_interactionStateApi();
        if (r6 == null) goto L18;
        r6.onMicMuteStateEvent(InteractionEvent.MicMuteEvent.UnmuteEvent.INSTANCE);
        return;
    L18:
        return;
    }

    public static final /* synthetic */ void access$setEnterBackgroundFromSystemPage$p(ObricInteractServiceImpl r0, boolean r1) {
        r0.isEnterBackgroundFromSystemPage = r1;
    }

    public static final /* synthetic */ void access$setEnterSystemPage$p(ObricInteractServiceImpl r0, boolean r1) {
        r0.enterSystemPage = r1;
    }

    public static final /* synthetic */ void access$setFromRelaunchSource$p(ObricInteractServiceImpl r0, boolean r1) {
        r0.isFromRelaunchSource = r1;
    }

    public static final /* synthetic */ void access$setFromWakeupSource(ObricInteractServiceImpl r0, boolean r1) {
        r0.setFromWakeupSource(r1);
    }

    public static final /* synthetic */ void access$setNeedUpdatePager$p(ObricInteractServiceImpl r0, boolean r1) {
        r0.needUpdatePager = r1;
    }

    private static final CharSequence describeFragmentsForLog$lambda$3(ObricInteractServiceImpl r1, Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r1.describeFragmentForLog(r2);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public boolean shouldRecoverMainFragmentAfterRestore(FragmentManager r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "fragmentManager");
        List r0 = r7.getFragments();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L3:
        boolean r3 = true;
        if (r2.hasNext() == false) goto L12;
        Object r4 = r2.next();
        if (((Fragment) r4).getId() == r8) goto L9;
        r3 = false;
    L9:
        if (r3 == false) goto L3;
        r1.add(r4);
        goto L3
    L12:
        if (r1.isEmpty() == false) goto L14;
    L13:
        boolean r9 = false;
    L25:
        if (r9 == false) goto L27;
        return false;
    L27:
        FLogger.a.w(this.TAG, "main_fragment_restore_recover isStateSaved=" + r7.isStateSaved() + ", containerFragments=" + describeFragmentsForLog(r1) + ", allFragments=" + describeFragmentsForLog(r7.getFragments()));
        return true;
    L14:
        Iterator r10 = r1.iterator();
    L16:
        if (r10.hasNext() == false) goto L13;
        Fragment r5 = (Fragment) r10.next();
        Intrinsics.checkNotNull(r5);
        if (isValidRestoredFragment(r5) == true) goto L20;
    L22:
        boolean r6 = false;
    L23:
        if (r6 == false) goto L16;
        r9 = true;
        goto L25
    L20:
        if ((r5 instanceof DialogFragment) == true) goto L22;
        r6 = true;
        goto L23
    }
}
