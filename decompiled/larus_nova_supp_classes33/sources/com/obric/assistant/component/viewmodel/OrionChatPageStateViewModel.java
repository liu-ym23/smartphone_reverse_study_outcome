package com.obric.assistant.component.viewmodel;

import android.os.Bundle;
import com.bytedance.keva.Keva;
import com.larus.platform.service.o2;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.SessionAuthenticationServiceDelegate;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.ISystemKeySettings;
import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import laa.d;
import uda.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J*\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\u0012\u0010\u001e\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u001f\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010 \u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010!\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\"\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0006\u0010#\u001a\u00020\u0018J\u0006\u0010$\u001a\u00020\u0018R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006&"}, d2 = {"Lcom/obric/assistant/component/viewmodel/OrionChatPageStateViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/obric/assistant/data/ObricFloatChatPageData;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "systemKeySettings", "Lcom/obric/assistant/interaction/api/ISystemKeySettings;", "getSystemKeySettings", "()Lcom/obric/assistant/interaction/api/ISystemKeySettings;", "systemKeySettings$delegate", "Lkotlin/Lazy;", "changePageStatus", "", "pageState", "Lcom/obric/assistant/data/ObricFloatChatPageState;", "initPageState", "extras", "Landroid/os/Bundle;", "ability", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "isReCreated", "", "isBeforeWindowShow", "isOpenFromAgent", "launchToChatWindow", "bundle", "isKeyguardStateSatisfy", "isOpenFromAllSearch", "isOpenFromSingleClick", "isResponding", "isFirstOpenAfterResponded", "isOpenAfterDismissFromHalfScreen", "isInKeyguardAndWithoutSendingMessage", "isInKeyguardAndWithSendingMessage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OrionChatPageStateViewModel extends ComponentViewModel<ObricFloatChatPageData> {
    public static final a Companion = null;
    private static final String TAG = "OrionChatPageStateViewModel";
    private final Keva keva;
    private final Lazy systemKeySettings$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ObricFloatChatPageData No(ObricFloatChatPageState r0, ObricFloatChatPageData r1) {
        return changePageStatus$lambda$1(r0, r1);
    }

    public static /* synthetic */ ISystemKeySettings Oo() {
        return systemKeySettings_delegate$lambda$0();
    }

    private final ISystemKeySettings getSystemKeySettings() {
        return (ISystemKeySettings) this.systemKeySettings$delegate.getValue();
    }

    private final boolean isKeyguardStateSatisfy() {
        boolean r0 = this.keva.getBoolean("obric_first_open_in_keyguard_locked", true);
        long r6 = this.keva.getLong("last_message_send_time_ms", 0);
        long r3 = this.keva.getLong("obric_real_keyguard_locked_time", 0);
        boolean r1 = ((Boolean) SessionAuthenticationServiceDelegate.b.o().getValue()).booleanValue();
        FLogger.a.i(TAG, "shouldConsiderKeyguardState, isFirstOpenInKeyguard:" + r0 + ", lastMessageTime:" + r6 + ", keyguardLockedTime:" + r3 + ", isBiometricAuthenticated:" + r1);
        if (r0 == false) goto L5;
    L6:
        if (r1 == true) goto L8;
    L10:
        return false;
    L8:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L10;
        return true;
    L5:
        if (r6 > r3) goto L8;
        goto L6
    }

    private static final ISystemKeySettings systemKeySettings_delegate$lambda$0() {
        return (ISystemKeySettings) ServiceManager.get().getService(ISystemKeySettings.class);
    }

    public final boolean isInKeyguardAndWithSendingMessage() {
        long r0 = this.keva.getLong("last_message_send_time_in_device_locked", 0);
        long r2 = this.keva.getLong("obric_real_keyguard_locked_time", 0);
        FLogger.a.i(TAG, "isInKeyguardAndWithoutSendingMessage, lastMessageTime:" + r0 + ", keyguardLockedTime:" + r2 + ", isKeyguardLocked:" + IKeyguardStateKt.getKeyguardState().isKeyguardLocked());
        if (r0 > r2) goto L5;
    L7:
        return false;
    L5:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L7;
        return true;
    }

    public final boolean isInKeyguardAndWithoutSendingMessage() {
        long r0 = this.keva.getLong("last_message_send_time_in_device_locked", 0);
        long r2 = this.keva.getLong("obric_real_keyguard_locked_time", 0);
        FLogger.a.i(TAG, "isInKeyguardAndWithoutSendingMessage, lastMessageTime:" + r0 + ", keyguardLockedTime:" + r2 + ", isKeyguardLocked:" + IKeyguardStateKt.getKeyguardState().isKeyguardLocked());
        if (r0 <= r2) goto L5;
    L7:
        return false;
    L5:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L7;
        return true;
    }

    public OrionChatPageStateViewModel() {
        this.keva = Keva.getRepo(o2.a.e(), 0);
        this.systemKeySettings$delegate = LazyKt.lazy(new b());
    }

    private final boolean isFirstOpenAfterResponded(Bundle r15) {
        long r0 = this.keva.getLong("last_dismiss_time", 0);
        long r4 = this.keva.getLong("last_message_send_time_ms", 0);
        long r2 = this.keva.getLong("response_end_time", 0);
        long r6 = System.currentTimeMillis();
        boolean r8 = this.keva.getBoolean("is_shown_after_responded", true);
        boolean r9 = this.keva.getBoolean("is_shown_sub_message_received", true);
        boolean r16 = isOpenFromSingleClick(r15);
        FLogger.a.i(TAG, "isFirstOpenAfterResponseCompleted, lastDismiss:" + r0 + ", lastMsgSendTime:" + r4 + ", responseEnd:" + r2 + ", currentTime:" + r6 + ", isShownAfterResponded:" + r8 + ", isShownSubMessageReceived:" + r9 + ", isSingleClick:" + r16);
        if (r0 < r2) goto L5;
    L21:
        return false;
    L5:
        if ((r6 - r2) > 300000) goto L21;
        if (r8 == false) goto L8;
        if (r9 == true) goto L21;
    L8:
        if (r16 == false) goto L21;
        if (isKeyguardStateSatisfy() == false) goto L12;
    L13:
        ISystemKeySettings r17 = getSystemKeySettings();
        if (r17 != null) goto L16;
    L18:
        boolean r18 = false;
    L19:
        if (r18 == false) goto L21;
        return true;
    L16:
        if (r17.getSingleClickAction() != 0) goto L18;
        r18 = true;
        goto L19
    L12:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L21;
        goto L13
    }

    private final boolean isOpenAfterDismissFromHalfScreen(Bundle r10) {
        long r0 = this.keva.getLong("last_dismiss_time_from_half_screen", Long.MAX_VALUE);
        long r2 = System.currentTimeMillis();
        boolean r4 = this.keva.getBoolean("is_dismiss_from_half_screen", false);
        boolean r11 = isOpenFromSingleClick(r10);
        FLogger.a.i(TAG, "isOpenAfterDismissFromHalfScreen, lastDismissTime:" + r0 + ", currentTime:" + r2 + ", dismissFromHalfScreen:" + r4 + ", isSingleClick:" + r11);
        if (r4 == false) goto L20;
        ISystemKeySettings r5 = getSystemKeySettings();
        if (r5 != null) goto L7;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == false) goto L21;
        if (r11 == true) goto L13;
        return false;
    L13:
        if ((r2 - r0) <= 5000) goto L15;
        return false;
    L15:
        if (isKeyguardStateSatisfy() == false) goto L17;
    L18:
        return true;
    L17:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L18;
        return false;
    L21:
        return false;
    L7:
        if (r5.getSingleClickAction() != 0) goto L9;
        r6 = true;
        goto L10
    L20:
        return false;
    }

    private final boolean isOpenFromAgent(Bundle r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        return r2.containsKey("launch_from_agent");
    }

    private final boolean isOpenFromAllSearch(Bundle r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        return r2.containsKey("all_search");
    }

    private final boolean isOpenFromSingleClick(Bundle r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.getBoolean("arg_launch_floating_window", false) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(r4.getString("auto_open_plus_camera", ""), "1") == false) goto L9;
        return false;
    L9:
        if (r4.getBoolean("arg_long_press_ai", true) == true) goto L15;
        return true;
    L15:
        return false;
    }

    private final boolean isResponding(Bundle r13) {
        boolean r0 = this.keva.getBoolean("is_shown_in_response", false);
        boolean r14 = isOpenFromSingleClick(r13);
        long r6 = this.keva.getLong("last_message_send_time_ms", 0);
        long r8 = System.currentTimeMillis();
        long r10 = r8 - r6;
        if (r6 > 0) goto L5;
    L12:
        boolean r3 = false;
    L13:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("isResponding, isShownInResponse:");
        r5.append(r0);
        r5.append(", isSingleClick:");
        r5.append(r14);
        r5.append(", isRecentResponse:");
        r5.append(r3);
        r5.append(", lastMessageTime:");
        r5.append(r6);
        r5.append(", currentTime:");
        r5.append(r8);
        r5.append(", isKeyguardStateSatisfy:");
        r5.append(isKeyguardStateSatisfy());
        r5.append(", systemKeySettings:");
        ISystemKeySettings r7 = getSystemKeySettings();
        if (r7 == null) goto L16;
        Integer r9 = Integer.valueOf(r7.getSingleClickAction());
    L17:
        r5.append(r9);
        r4.i(TAG, r5.toString());
        if (r0 == false) goto L34;
        if (r3 == false) goto L35;
        if (r14 == true) goto L22;
        return false;
    L22:
        if (isKeyguardStateSatisfy() == false) goto L24;
    L25:
        ISystemKeySettings r15 = getSystemKeySettings();
        if (r15 != null) goto L28;
    L30:
        boolean r16 = false;
    L31:
        if (r16 == false) goto L38;
        return true;
    L38:
        return false;
    L28:
        if (r15.getSingleClickAction() != 0) goto L30;
        r16 = true;
        goto L31
    L24:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L25;
        return false;
    L35:
        return false;
    L34:
        return false;
    L16:
        r9 = null;
        goto L17
    L5:
        if (0 <= r10) goto L7;
    L9:
        boolean r11 = false;
    L10:
        if (r11 == false) goto L12;
        r3 = true;
        goto L13
    L7:
        if (r10 >= 300001) goto L9;
        r11 = true;
        goto L10
    }

    private final boolean launchToChatWindow(Bundle r7) {
        if (r7 == null) goto L4;
        String r0 = r7.getString("argPreviousPage");
    L5:
        boolean r2 = false;
        if (Intrinsics.areEqual("verify_code", r0) == false) goto L8;
    L11:
        boolean r1 = true;
    L12:
        FLogger r3 = FLogger.a;
        r3.e(TAG, "fromPage: " + r0 + ", fromLogin: " + r1);
        if (r1 == false) goto L15;
        return false;
    L15:
        if (r7 == null) goto L17;
        r2 = r7.getBoolean("arg_launch_floating_window", false);
    L17:
        r3.e(TAG, "wakeUp: " + r2);
        return r2;
    L8:
        if (Intrinsics.areEqual("login_home", r0) == true) goto L11;
        r1 = false;
        goto L12
    L4:
        r0 = null;
        goto L5
    }

    public final void changePageStatus(final ObricFloatChatPageState r4) {
        Intrinsics.checkNotNullParameter(r4, "pageState");
        FLogger.a.i(TAG, "changePageStatus, pageState = " + r4);
        waa.a.a(r4);
        setState(new uda.a(r4));
    }

    private static final ObricFloatChatPageData changePageStatus$lambda$1(ObricFloatChatPageState r1, ObricFloatChatPageData r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setState");
        return r2.copy(r1);
    }

    public final void initPageState(Bundle r9, d r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "ability");
        boolean r0 = false;
        if (r9 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L11;
        if (r11 == true) goto L11;
        boolean r3 = true;
    L12:
        FLogger r4 = FLogger.a;
        r4.i(TAG, "updatePageState: isOpenSpecialInput = " + r2 + ", isMustUseChatWindow = " + r3 + ", isReCreated = " + r11 + ", extras=" + r9);
        if (r11 == false) goto L22;
        if (r9 != null) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == false) goto L22;
        ObricFloatChatPageData.Companion.getClass();
        r10.xw(ObricFloatChatPageData.access$getFULL_SCREEN_SIMPLE_NAME$cp(), true);
        return;
    L16:
        if (r9.getBoolean("argument_restore_full_screen_on_recreate", false) != true) goto L18;
        r5 = true;
    L22:
        ObricFloatChatPageState r6 = (ObricFloatChatPageState) waa.a.b.getValue();
        if (r11 == false) goto L31;
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L31;
        ObricFloatChatPageData.Companion.getClass();
        if ((r6 instanceof vda.d) == false) goto L31;
        r10.xw(ObricFloatChatPageData.access$getFULL_SCREEN_SIMPLE_NAME$cp(), true);
        return;
    L31:
        if (isOpenFromAllSearch(r9) == false) goto L34;
        r4.i(TAG, "updatePageState, HALF_WINDOW_SIMPLE_NAME -> all search");
        ObricFloatChatPageData.Companion.getClass();
        r10.xw(ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp(), r12);
        this.keva.storeInt("launch_to_half_screen_mode", 1);
        return;
    L34:
        if (isOpenFromAgent(r9) == false) goto L45;
        if (r9 == null) goto L37;
        Integer r13 = Integer.valueOf(r9.getInt("agent_window_state"));
    L38:
        r4.i(TAG, "updatePageState for agent windowState " + r13);
        if (Intrinsics.areEqual(r13, Integer.valueOf(AssistantActivityExpandState.HALF_WINDOW.ordinal())) == false) goto L42;
        ObricFloatChatPageData.Companion.getClass();
        r10.xw(ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp(), r12);
        this.keva.storeInt("launch_to_half_screen_mode", 3);
        return;
    L42:
        if (Intrinsics.areEqual(r13, Integer.valueOf(AssistantActivityExpandState.CHAT_WINDOW.ordinal())) == false) goto L44;
        ObricFloatChatPageData.Companion.getClass();
        r10.xw(ObricFloatChatPageData.access$getCHAT_WINDOW_SIMPLE_NAME$cp(), r12);
        return;
    L44:
        ObricFloatChatPageData.Companion.getClass();
        r10.xw(ObricFloatChatPageData.access$getFULL_SCREEN_SIMPLE_NAME$cp(), r12);
        return;
    L37:
        r13 = AssistantActivityExpandState.FULL_SCREEN;
        goto L38
    L45:
        if (r3 == false) goto L47;
    L49:
        if (r3 == false) goto L51;
    L53:
        if (r3 == false) goto L55;
    L57:
        if (r9 != null) goto L59;
    L61:
        if (r0 == false) goto L63;
        ObricFloatChatPageData.Companion.getClass();
        r10.xw(ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp(), r12);
        return;
    L63:
        if (r3 == false) goto L65;
    L72:
        ObricFloatChatPageData.Companion.getClass();
        r10.xw(ObricFloatChatPageData.access$getCHAT_WINDOW_SIMPLE_NAME$cp(), r12);
        return;
    L65:
        if (launchToChatWindow(r9) == true) goto L72;
        if (r11 == true) goto L69;
    L71:
        ObricFloatChatPageData.Companion.getClass();
        r10.xw(ObricFloatChatPageData.access$getFULL_SCREEN_SIMPLE_NAME$cp(), r12);
        return;
    L69:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L71;
        ObricFloatChatPageData.Companion.getClass();
        r10.xw(ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp(), r12);
        return;
    L59:
        if (r9.getBoolean("arg_launch_half_screen") != true) goto L61;
        r0 = true;
        goto L61
    L55:
        if (isFirstOpenAfterResponded(r9) == false) goto L57;
        r4.i(TAG, "updatePageState, HALF_WINDOW_SIMPLE_NAME -> first open after responded");
        ObricFloatChatPageData.Companion.getClass();
        r10.xw(ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp(), r12);
        this.keva.storeBoolean("is_shown_after_responded", true);
        this.keva.storeBoolean("is_shown_sub_message_received", true);
        this.keva.storeInt("launch_to_half_screen_mode", 3);
        return;
    L51:
        if (isResponding(r9) == false) goto L53;
        r4.i(TAG, "updatePageState, HALF_WINDOW_SIMPLE_NAME -> responding");
        ObricFloatChatPageData.Companion.getClass();
        r10.xw(ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp(), r12);
        this.keva.storeInt("launch_to_half_screen_mode", 3);
        return;
    L47:
        if (isOpenAfterDismissFromHalfScreen(r9) == false) goto L49;
        r4.i(TAG, "updatePageState, HALF_WINDOW_SIMPLE_NAME -> dismiss from half screen");
        ObricFloatChatPageData.Companion.getClass();
        r10.xw(ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp(), r12);
        this.keva.storeInt("launch_to_half_screen_mode", 2);
        return;
    L11:
        r3 = false;
        goto L12
    L5:
        if (r9.getBoolean("obric_open_special_input", false) != true) goto L7;
        r2 = true;
        goto L8
    }

    public static /* synthetic */ void initPageState$default(OrionChatPageStateViewModel r0, Bundle r1, d r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        r0.initPageState(r1, r2, r3, r4);
    }
}
