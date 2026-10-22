package com.obric.assistant.interaction.api.service;

import com.obric.assistant.interaction.api.lifecycle.ILifecycleService;
import com.obric.assistant.interaction.base.interact.CustomBarAction;
import com.obric.assistant.interaction.base.interact.IObserveToken;
import com.obric.assistant.interaction.base.interact.KeyguardLockedState;
import com.obric.assistant.interaction.base.mode.MicMuteState;
import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import com.obric.assistant.interaction.base.model.AssistantActivityVisibleState;
import com.obric.assistant.interaction.base.model.SessionLifecycleState;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 I2\u00020\u0001:\u0001IJ\b\u0010\u0002\u001a\u00020\u0003H&J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\tH&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\fH&J$\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\tH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0010H&J$\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\tH&J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u0013\u001a\u00020\u0014H&J$\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\tH&J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u001bj\b\u0012\u0004\u0012\u00020\u0019`\u001cH&J\u0012\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001fH&J\u0016\u0010 \u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H&J4\u0010$\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\"\u0010\b\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00190\u001bj\b\u0012\u0004\u0012\u00020\u0019`\u001c\u0012\u0004\u0012\u00020\u00050\tH&J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010&\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00050\tH&J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010)\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00050\tH&J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020#H&J\n\u0010/\u001a\u0004\u0018\u00010#H&J\u0010\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020#H&J\b\u00102\u001a\u00020#H&J%\u00103\u001a\u00020\u0005\"\u0004\b\u0000\u001042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001H4H&¢\u0006\u0002\u00108J\u001d\u00109\u001a\u0004\u0018\u0001H4\"\u0004\b\u0000\u001042\u0006\u00105\u001a\u000206H&¢\u0006\u0002\u0010:J\b\u0010;\u001a\u00020\u0005H&J\b\u0010<\u001a\u00020\u001fH&J\b\u0010=\u001a\u00020\u0005H&J\u0010\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001fH&J\b\u0010@\u001a\u00020\u0005H&J\b\u0010A\u001a\u00020\u0005H&J\b\u0010B\u001a\u00020\u0005H&J\b\u0010C\u001a\u00020\u0005H&R$\u0010D\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020#0F0EX¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006J"}, d2 = {"Lcom/obric/assistant/interaction/api/service/IInteractionStateService;", "Lcom/obric/assistant/interaction/api/lifecycle/ILifecycleService;", "getInteractionSessionLifecycleState", "Lcom/obric/assistant/interaction/base/model/SessionLifecycleState;", "observeInteractionSessionLifecycleState", "", "token", "Lcom/obric/assistant/interaction/base/interact/IObserveToken;", "callback", "Lkotlin/Function1;", "unObserveInteractionSessionLifecycleState", "getInteractionActivityVisibleState", "Lcom/obric/assistant/interaction/base/model/AssistantActivityVisibleState;", "observeInteractionActivityVisibleState", "unObserveInteractionActivityVisibleState", "getInteractionActivityExpandState", "Lcom/obric/assistant/interaction/base/model/AssistantActivityExpandState;", "observeInteractionActivityExpandState", "unObserveInteractionActivityExpandState", "getInteractionKeyguardLockedState", "Lcom/obric/assistant/interaction/base/interact/KeyguardLockedState;", "observeInteractionKeyguardLockedState", "unObserveInteractionKeyguardLockedState", "addCustomBarAction", "action", "Lcom/obric/assistant/interaction/base/interact/CustomBarAction;", "getCustomBarActions", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "clearCustomBarActions", "showOnLauncher", "", "removeCustomBarActions", "keys", "", "", "observeCustomBarActionsState", "unObserveCustomBarActionsState", "setAutoIncreaseWindowObserver", "observer", "removeAutoIncreaseWindowObserver", "observeMicMuteState", "Lcom/obric/assistant/interaction/base/mode/MicMuteState;", "unObserveMicMuteState", "setWakeUpAppPkg", "pkg", "reason", "getWakeUpAppPkg", "setWakeUpSource", "source", "getWakeUpSource", "setWakeUpData", "T", "key", "", "data", "(ILjava/lang/Object;)V", "getWakeUpData", "(I)Ljava/lang/Object;", "resetWakeupData", "isDefiniteWakeUpSource", "resetWakeupSource", "setAutoIncreaseWindow", "increase", "stopTtsPlay", "endCall", "muteMic", "unMuteMic", "preSoundEffectState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/Pair;", "getPreSoundEffectState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IInteractionStateService extends ILifecycleService {
    public static final Companion Companion = null;
    public static final String WAKEUP_SOURCE_AUTO_MIC = "WAKEUP_SOURCE_AUTO_MIC";
    public static final String WAKEUP_SOURCE_VOICE = "WAKEUP_SOURCE_VOICE_ASSIST";
    public static final String WAKE_UP_SOURCE_BLUETOOTH = "WAKEUP_SOURCE_BLUETOOTH";
    public static final String WAKE_UP_SOURCE_DORA_KEY_UP = "WAKEUP_SOURCE_DORA_KEY_UP";
    public static final String WAKE_UP_SOURCE_DORA_VOICE_WAKEUP = "WAKEUP_SOURCE_DORA_VOICE_WAKEUP";
    public static final String WAKE_UP_SOURCE_OTHER = "other";
    public static final String WAKE_UP_SOURCE_UNKNOWN = "WAKEUP_SOURCE_UNKNOWN";

    static {
        Companion = Companion.$$INSTANCE;
    }

    void addCustomBarAction(CustomBarAction r1);

    void clearCustomBarActions(boolean r1);

    void endCall();

    ArrayList<CustomBarAction> getCustomBarActions();

    AssistantActivityExpandState getInteractionActivityExpandState();

    AssistantActivityVisibleState getInteractionActivityVisibleState();

    KeyguardLockedState getInteractionKeyguardLockedState();

    SessionLifecycleState getInteractionSessionLifecycleState();

    z0<Pair<Boolean, String>> getPreSoundEffectState();

    String getWakeUpAppPkg();

    <T> T getWakeUpData(int r1);

    String getWakeUpSource();

    boolean isDefiniteWakeUpSource();

    void muteMic();

    void observeCustomBarActionsState(IObserveToken r1, Function1<? super ArrayList<CustomBarAction>, Unit> r2);

    void observeInteractionActivityExpandState(IObserveToken r1, Function1<? super AssistantActivityExpandState, Unit> r2);

    void observeInteractionActivityVisibleState(IObserveToken r1, Function1<? super AssistantActivityVisibleState, Unit> r2);

    void observeInteractionKeyguardLockedState(IObserveToken r1, Function1<? super KeyguardLockedState, Unit> r2);

    void observeInteractionSessionLifecycleState(IObserveToken r1, Function1<? super SessionLifecycleState, Unit> r2);

    void observeMicMuteState(IObserveToken r1, Function1<? super MicMuteState, Unit> r2);

    void removeAutoIncreaseWindowObserver(IObserveToken r1);

    void removeCustomBarActions(Collection<String> r1);

    void resetWakeupData();

    void resetWakeupSource();

    void setAutoIncreaseWindow(boolean r1);

    void setAutoIncreaseWindowObserver(IObserveToken r1, Function1<? super Boolean, Unit> r2);

    void setWakeUpAppPkg(String r1, String r2);

    <T> void setWakeUpData(int r1, T r2);

    void setWakeUpSource(String r1);

    void stopTtsPlay();

    void unMuteMic();

    void unObserveCustomBarActionsState(IObserveToken r1);

    void unObserveInteractionActivityExpandState(IObserveToken r1);

    void unObserveInteractionActivityVisibleState(IObserveToken r1);

    void unObserveInteractionKeyguardLockedState(IObserveToken r1);

    void unObserveInteractionSessionLifecycleState(IObserveToken r1);

    void unObserveMicMuteState(IObserveToken r1);
}
