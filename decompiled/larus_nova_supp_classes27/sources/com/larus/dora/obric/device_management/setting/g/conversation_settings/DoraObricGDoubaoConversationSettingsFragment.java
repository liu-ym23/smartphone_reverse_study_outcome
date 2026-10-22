package com.larus.dora.obric.device_management.setting.g.conversation_settings;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.settingsconfig.DoraXLinkTransportMode;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.ailab.AiLabViewModel;
import com.larus.dora.impl.device.settings.lab.LabSettingsViewModel;
import com.larus.dora.impl.device.settings.lab.RTCTransportMode;
import com.larus.dora.obric.device_management.setting.common.auto_disconnect.DoraObricDoubaoAutoDisconnectViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 \u008e\u00012\u00020\u0001:\u0004\u008d\u0001\u008e\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u001a\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001a2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00109\u001a\u000207H\u0016J\b\u0010:\u001a\u000207H\u0016J\b\u0010;\u001a\u000207H\u0016J\u0010\u0010<\u001a\u0002072\u0006\u0010=\u001a\u00020$H\u0016J\b\u0010>\u001a\u00020?H\u0016J\n\u0010@\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010A\u001a\u00020\u001aH\u0002J\b\u0010B\u001a\u00020\u001aH\u0002J\b\u0010C\u001a\u00020\u001aH\u0002J\b\u0010D\u001a\u000207H\u0002J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001d0FH\u0002J\u0010\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020\u001dH\u0002J\u0014\u0010I\u001a\u000207*\u00020\u001e2\u0006\u0010J\u001a\u00020?H\u0002J\f\u0010K\u001a\u000207*\u00020\u001eH\u0002J\u0010\u0010L\u001a\u0002072\u0006\u0010M\u001a\u00020\u001eH\u0002J\u0010\u0010N\u001a\u0002072\u0006\u0010M\u001a\u00020\u001eH\u0002J\f\u0010O\u001a\u000207*\u00020\u001eH\u0002J\f\u0010P\u001a\u000207*\u00020\u001eH\u0002J\u0010\u0010Q\u001a\u00020\u001a2\u0006\u0010R\u001a\u00020?H\u0002J\b\u0010S\u001a\u00020?H\u0002J\f\u0010T\u001a\u00020?*\u00020?H\u0002J\b\u0010U\u001a\u000207H\u0002J\b\u0010V\u001a\u000207H\u0002J\b\u0010W\u001a\u000207H\u0002J\b\u0010X\u001a\u000207H\u0002J\u0010\u0010Y\u001a\u0002072\u0006\u0010Z\u001a\u00020 H\u0002J\u0010\u0010[\u001a\u0002072\u0006\u0010Z\u001a\u00020 H\u0002J\u0010\u0010\\\u001a\u0002072\u0006\u0010Z\u001a\u00020 H\u0002J\u0010\u0010]\u001a\u0002072\u0006\u0010Z\u001a\u00020^H\u0002J\u0010\u0010_\u001a\u0002072\u0006\u0010Z\u001a\u00020^H\u0002J\u0010\u0010`\u001a\u0002072\u0006\u0010Z\u001a\u00020^H\u0002J\u0010\u0010a\u001a\u0002072\u0006\u0010Z\u001a\u00020^H\u0002J\b\u0010a\u001a\u000207H\u0002J\u0010\u0010b\u001a\u0002072\u0006\u0010Z\u001a\u00020^H\u0002J\b\u0010b\u001a\u000207H\u0002J6\u0010c\u001a\u0002072\u0006\u0010d\u001a\u00020$2\u0006\u0010e\u001a\u00020$2\u0006\u0010f\u001a\u00020$2\u0006\u0010g\u001a\u00020$2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020i0FH\u0002J\b\u0010j\u001a\u00020$H\u0002J\u0010\u0010j\u001a\u00020$2\u0006\u0010Z\u001a\u00020^H\u0002J,\u0010k\u001a\u0002072\u0006\u0010H\u001a\u00020\u001d2\u0006\u0010l\u001a\u00020$2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u0002070nH\u0002J\u0010\u0010o\u001a\u0002072\u0006\u0010p\u001a\u00020$H\u0002J\u0010\u0010q\u001a\u0002072\u0006\u0010r\u001a\u00020\u001eH\u0002J&\u0010s\u001a\u0002072\u0006\u0010r\u001a\u00020\u001e2\u0006\u0010t\u001a\u00020i2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020i0FH\u0002J\u0010\u0010v\u001a\u00020?2\u0006\u0010w\u001a\u00020iH\u0002J\f\u0010x\u001a\u00020i*\u00020yH\u0002J\u0010\u0010z\u001a\u0002072\u0006\u0010{\u001a\u00020|H\u0002J\u0010\u0010}\u001a\u00020?2\u0006\u0010H\u001a\u00020\u001dH\u0002J\u0010\u0010~\u001a\u00020?2\u0006\u0010H\u001a\u00020\u001dH\u0002J\u0010\u0010\u007f\u001a\u00020?2\u0006\u0010{\u001a\u00020|H\u0002J\u0015\u0010\u0080\u0001\u001a\u0004\u0018\u00010$*\u00020 H\u0002¢\u0006\u0003\u0010\u0081\u0001J\t\u0010\u0082\u0001\u001a\u00020|H\u0002J\t\u0010\u0083\u0001\u001a\u00020|H\u0002J\t\u0010\u0084\u0001\u001a\u00020|H\u0002J\r\u0010\u0085\u0001\u001a\u000207*\u00020\u001eH\u0002J\u000e\u0010\u0086\u0001\u001a\u000207*\u00030\u0087\u0001H\u0002J\u000e\u0010\u0088\u0001\u001a\u000207*\u00030\u0089\u0001H\u0002J\r\u0010\u008a\u0001\u001a\u00020|*\u00020|H\u0002J\u000e\u0010\u008b\u0001\u001a\u00020|*\u00030\u008c\u0001H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\t\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\t\u001a\u0004\b-\u0010*¨\u0006\u008f\u0001"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/conversation_settings/DoraObricGDoubaoConversationSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/obric/device_management/setting/common/auto_disconnect/DoraObricDoubaoAutoDisconnectViewModel;", "getViewModel", "()Lcom/larus/dora/obric/device_management/setting/common/auto_disconnect/DoraObricDoubaoAutoDisconnectViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "aiLabViewModel", "Lcom/larus/dora/impl/device/ailab/AiLabViewModel;", "getAiLabViewModel", "()Lcom/larus/dora/impl/device/ailab/AiLabViewModel;", "aiLabViewModel$delegate", "labSettingsViewModel", "Lcom/larus/dora/impl/device/settings/lab/LabSettingsViewModel;", "getLabSettingsViewModel", "()Lcom/larus/dora/impl/device/settings/lab/LabSettingsViewModel;", "labSettingsViewModel$delegate", "contentContainer", "Landroid/widget/LinearLayout;", "autoStopTimePopover", "Lcom/obric/oui/popover/v2/OPopover;", "rtcTransportPopover", "pageMaskView", "Landroid/view/View;", "itemViews", "", "Lcom/larus/dora/obric/device_management/setting/g/conversation_settings/DoraObricGDoubaoConversationSettingsFragment$DoubaoConversationSettingItem;", "Lcom/obric/oui/lisitem/OCardListItem;", "latestAiLabState", "Lcom/larus/dora/impl/device/ailab/AiLabState;", "latestLabState", "Lcom/larus/dora/impl/device/settings/lab/LabEnvSettings;", "showConversationStartEndSoundRow", "", "showNaturalWakeupRow", "isVideoStreamSelectorEnabled", "isDataSavingVisible", "isRTCTransportVisible", "isCurrentGDeviceType", "()Z", "isCurrentGDeviceType$delegate", "showAutoStopTimeRow", "getShowAutoStopTimeRow", "showAutoStopTimeRow$delegate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onStop", "onDestroyView", "onDoraConnectStateChanged", "isConnected", "getCurrentPageName", "", "getPageMaskView", "buildContentView", "buildTitleBar", "buildScrollContent", "renderSettings", "conversationSettingItems", "", "buildSettingItem", "item", "bindNaturalWakeupTitle", "title", "expandTitleContainerWidth", "bindSwitchItem", "itemView", "bindAutoStopTimeItem", "bindVideoStreamEnd", "bindDataSavingEnd", "buildSupportiveText", "text", "getVideoStreamSupportiveText", "removeTrailingPeriod", "observeAiLabState", "observeLabState", "observeAutoStopTime", "bindCurrentState", "bindAiLabState", "state", "bindVoiceWake", "bindConversationStartEndSound", "bindLabState", "Lcom/larus/dora/impl/device/settings/lab/LabEnvSettings$Success;", "bindAllowDoubaoViewImages", "bindNaturalWakeup", "bindDataSaving", "bindRTCTransport", "updateRTCTransportMode", "bluetoothRTCEnable", "p2pRTCEnable", "isP2PRTCRuntimeSupported", "isUserSelectMode", "selectableModes", "Lcom/larus/dora/impl/device/settings/lab/RTCTransportMode;", "shouldShowRTCTransport", "bindSwitch", "checked", "onCheckedChange", "Lkotlin/Function1;", "updateVoiceWake", "isChecked", "showAutoStopTimeMenu", "anchor", "showRTCTransportMenu", "currentMode", "modes", "getRTCTransportModeText", "mode", "toRTCTransportMode", "Lcom/larus/dora/impl/core/settingsconfig/DoraXLinkTransportMode;", "updateAutoStopTimeText", "time", "", "titleFor", "descriptionFor", "autoStopTimeText", "voiceWakeEnabled", "(Lcom/larus/dora/impl/device/ailab/AiLabState;)Ljava/lang/Boolean;", "resolveBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "applyCardStyle", "applyValueTextStyle", "Lcom/obric/oui/text/OTextView;", "applySupportiveTextStyle", "Landroid/widget/TextView;", "dp", "sp", "", "DoubaoConversationSettingItem", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGDoubaoConversationSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int w = 0;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public LinearLayout i;
    public com.obric.oui.popover.v2.c j;
    public com.obric.oui.popover.v2.c k;
    public View l;
    public final Map<DoubaoConversationSettingItem, OCardListItem> m;
    public com.larus.dora.impl.device.ailab.u n;
    public com.larus.dora.impl.device.settings.lab.c o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public final Lazy u;
    public final Lazy v;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/conversation_settings/DoraObricGDoubaoConversationSettingsFragment$DoubaoConversationSettingItem;", "", "<init>", "(Ljava/lang/String;I)V", "VOICE_WAKE", "AUTO_STOP_TIME", "CONVERSATION_START_END_SOUND", "ALLOW_DOUBAO_VIEW_IMAGES", "NATURAL_WAKEUP", "VIDEO_STREAM", "DATA_SAVING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DoubaoConversationSettingItem extends Enum<DoubaoConversationSettingItem> {
        public static final DoubaoConversationSettingItem ALLOW_DOUBAO_VIEW_IMAGES = null;
        public static final DoubaoConversationSettingItem AUTO_STOP_TIME = null;
        public static final DoubaoConversationSettingItem CONVERSATION_START_END_SOUND = null;
        public static final DoubaoConversationSettingItem DATA_SAVING = null;
        public static final DoubaoConversationSettingItem NATURAL_WAKEUP = null;
        public static final DoubaoConversationSettingItem VIDEO_STREAM = null;
        public static final DoubaoConversationSettingItem VOICE_WAKE = null;
        public static final /* synthetic */ DoubaoConversationSettingItem[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<DoubaoConversationSettingItem> getEntries() {
            return b;
        }

        static {
            DoubaoConversationSettingItem r0 = new DoubaoConversationSettingItem("VOICE_WAKE", 0);
            VOICE_WAKE = r0;
            DoubaoConversationSettingItem r1 = new DoubaoConversationSettingItem("AUTO_STOP_TIME", 1);
            AUTO_STOP_TIME = r1;
            DoubaoConversationSettingItem r3 = new DoubaoConversationSettingItem("CONVERSATION_START_END_SOUND", 2);
            CONVERSATION_START_END_SOUND = r3;
            DoubaoConversationSettingItem r5 = new DoubaoConversationSettingItem("ALLOW_DOUBAO_VIEW_IMAGES", 3);
            ALLOW_DOUBAO_VIEW_IMAGES = r5;
            DoubaoConversationSettingItem r7 = new DoubaoConversationSettingItem("NATURAL_WAKEUP", 4);
            NATURAL_WAKEUP = r7;
            DoubaoConversationSettingItem r9 = new DoubaoConversationSettingItem("VIDEO_STREAM", 5);
            VIDEO_STREAM = r9;
            DoubaoConversationSettingItem r11 = new DoubaoConversationSettingItem("DATA_SAVING", 6);
            DATA_SAVING = r11;
            DoubaoConversationSettingItem[] r13 = {r0, r1, r3, r5, r7, r9, r11};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static DoubaoConversationSettingItem[] values() {
            return (DoubaoConversationSettingItem[]) a.clone();
        }

        public static DoubaoConversationSettingItem valueOf(String r1) {
            return (DoubaoConversationSettingItem) r27.a.a(DoubaoConversationSettingItem.class, r1);
        }

        public DoubaoConversationSettingItem(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[DoubaoConversationSettingItem.values().length];
            r0[DoubaoConversationSettingItem.VIDEO_STREAM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L43:
            r0[DoubaoConversationSettingItem.DATA_SAVING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L59:
            r0[DoubaoConversationSettingItem.AUTO_STOP_TIME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L45:
            r0[DoubaoConversationSettingItem.VOICE_WAKE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L47:
            r0[DoubaoConversationSettingItem.CONVERSATION_START_END_SOUND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L35:
            r0[DoubaoConversationSettingItem.ALLOW_DOUBAO_VIEW_IMAGES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L49:
            r0[DoubaoConversationSettingItem.NATURAL_WAKEUP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L12:
            a = r0;
            int[] r1 = new int[RTCTransportMode.values().length];
            r1[RTCTransportMode.OFF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L37:
            r1[RTCTransportMode.BLUETOOTH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L51:
            r1[RTCTransportMode.WIFI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L16:
            b = r1;
            int[] r2 = new int[DoraXLinkTransportMode.values().length];
            r2[DoraXLinkTransportMode.OFF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L55:
            r2[DoraXLinkTransportMode.BLUETOOTH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L39:
            r2[DoraXLinkTransportMode.WIFI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L20:
            c = r2;
        }
    }

    static {
    }

    public final String k() {
        return "ai_lab";
    }

    public final AiLabViewModel ea0() {
        return (AiLabViewModel) this.g.getValue();
    }

    public final LabSettingsViewModel fa0() {
        return (LabSettingsViewModel) this.h.getValue();
    }

    public final DoraObricDoubaoAutoDisconnectViewModel ha0() {
        return (DoraObricDoubaoAutoDisconnectViewModel) this.f.getValue();
    }

    public final void ja0() {
        LinearLayout r1 = this.i;
        if (r1 != null) goto L5;
        return;
    L5:
        this.t = ka0();
        this.s = fa0().isDataSavingEntranceVisible();
        List r3 = CollectionsKt.mutableListOf(new DoubaoConversationSettingItem[]{DoubaoConversationSettingItem.VOICE_WAKE});
        if (this.q == false) goto L9;
        r3.add(DoubaoConversationSettingItem.NATURAL_WAKEUP);
    L9:
        if (((Boolean) this.v.getValue()).booleanValue() == false) goto L12;
        r3.add(DoubaoConversationSettingItem.AUTO_STOP_TIME);
    L12:
        if (this.p == false) goto L14;
        r3.add(DoubaoConversationSettingItem.CONVERSATION_START_END_SOUND);
    L14:
        List r4 = r3;
        r4.add(DoubaoConversationSettingItem.ALLOW_DOUBAO_VIEW_IMAGES);
        if (this.t == false) goto L18;
        r4.add(DoubaoConversationSettingItem.VIDEO_STREAM);
    L18:
        if (this.s == false) goto L20;
        r4.add(DoubaoConversationSettingItem.DATA_SAVING);
    L20:
        ((LinkedHashMap) this.m).clear();
        r1.removeAllViews();
        Iterator r5 = r3.iterator();
        int r6 = 0;
    L22:
        if (r5.hasNext() == false) goto L131;
        Object r7 = r5.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();
    L26:
        DoubaoConversationSettingItem r9 = (DoubaoConversationSettingItem) r7;
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-1, -2);
        if (r6 <= 0) goto L29;
        r10.topMargin = da0(16);
    L29:
        final View r11 = new OCardListItem(requireContext(), null, 6, 0);
        this.m.put(r9, r11);
        r11.setCardType(0);
        OCardListItem.h(r11, 0);
        r11.setShowCardBg(true);
        r11.p(false);
        int[] r12 = b.a;
        switch(r12[r9.ordinal()]) {
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L37;
            case 4: goto L36;
            case 5: goto L35;
            case 6: goto L34;
            case 7: goto L33;
            default: goto L32;
        };
    L33:
        String r13 = getString(2131903380);
    L40:
        r11.setTitle(r13);
        r11.s(true);
        if (r9 != DoubaoConversationSettingItem.NATURAL_WAKEUP) goto L69;
        OCardListItem.j(r11, 0);
        LinearLayout r14 = r11.getTitleContainer();
        ConstraintLayout.LayoutParams r15 = r11.getTitleContainer().getLayoutParams();
        if ((r15 instanceof ConstraintLayout.LayoutParams) == false) goto L45;
        ConstraintLayout.LayoutParams r16 = r15;
    L46:
        if (r16 == null) goto L48;
        ((ViewGroup.MarginLayoutParams) r16).width = 0;
        r16.W = false;
        r16.L = 0;
        r14.setLayoutParams(r16);
    L48:
        View r17 = r11.c();
        if ((r17 instanceof ViewGroup) == false) goto L51;
        OTextView r18 = ((ViewGroup) r17).findViewById(2131368477);
    L52:
        if (r18 == null) goto L54;
        r18.setText(r13);
        r18.setMaxLines(1);
    L54:
        View r110 = r11.c();
        if ((r110 instanceof ViewGroup) == false) goto L57;
        ViewGroup r111 = (ViewGroup) r110;
    L58:
        if (r111 == null) goto L67;
        ImageView r112 = (ImageView) r111.findViewById(2131368474);
        if (r112 == null) goto L67;
        r112.setContentDescription(null);
        r112.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r112.setImageResource(2131240541);
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == false) goto L64;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
    L65:
        if (r114 == null) goto L67;
        r114.width = da0(34);
        r114.height = da0(20);
        r114.setMarginStart(da0(4));
        r112.setLayoutParams(r114);
        goto L67
    L64:
        r114 = null;
    L67:
        r11.s(false);
        goto L69
    L57:
        r111 = null;
        goto L58
    L51:
        r18 = null;
        goto L52
    L45:
        r16 = null;
    L69:
        switch(r12[r9.ordinal()]) {
            case 1: goto L78;
            case 2: goto L77;
            case 3: goto L76;
            case 4: goto L75;
            case 5: goto L74;
            case 6: goto L73;
            case 7: goto L72;
            default: goto L71;
        };
    L72:
        String r115 = getString(2131903480);
    L79:
        r11.setSubTitle(r115);
        r11.getSubTitleView().setMaxLines(5);
        int r116 = r12[r9.ordinal()];
        if (r116 == 1) goto L95;
        if (r116 == 2) goto L92;
        if (r116 == 3) goto L84;
        r11.q(true);
        r11.setDefaultCustomEndView(1);
        r11.m(true);
        r11.r(false);
    L99:
        ViewGroup.LayoutParams r117 = r11.getCardContainer().getLayoutParams();
        if ((r117 instanceof ViewGroup.MarginLayoutParams) == false) goto L102;
        ViewGroup.MarginLayoutParams r118 = (ViewGroup.MarginLayoutParams) r117;
    L103:
        if (r118 == null) goto L105;
        r118.setMarginStart(0);
        r118.setMarginEnd(0);
        r118.leftMargin = 0;
        r118.rightMargin = 0;
        r11.getCardContainer().setLayoutParams(r118);
    L105:
        r11.getCardContainer().setPadding(da0(8), da0(8), da0(8), da0(8));
        r11.getContentContainer().setPadding(0, 0, da0(4), 0);
        r11.getTitleContainer().setGravity(16);
        r11.getTitleContainer().setPadding(da0(12), da0(10), da0(8), da0(10));
        OTextView r20 = r11.getTitleView();
        r20.setGravity(8388627);
        r20.setMaxLines(1);
        r20.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r20, la0(22.0f));
        r20.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        OTextView r21 = r11.getSubTitleView();
        r21.setGravity(8388627);
        r21.setTextSize(2, 12.0f);
        TextViewCompat.setLineHeight(r21, la0(16.0f));
        ViewGroup.LayoutParams r119 = r21.getLayoutParams();
        if ((r119 instanceof ViewGroup.MarginLayoutParams) == false) goto L108;
        ViewGroup.MarginLayoutParams r120 = (ViewGroup.MarginLayoutParams) r119;
    L109:
        if (r120 == null) goto L111;
        r120.topMargin = da0(2);
        r21.setLayoutParams(r120);
    L111:
        r11.o(false);
        Drawable r22 = r11.getCardContainer().getBackground();
        if ((r22 instanceof GradientDrawable) == false) goto L114;
        GradientDrawable r23 = (GradientDrawable) r22;
    L115:
        if (r23 == null) goto L117;
        r23.setCornerRadius(da0(20));
    L117:
        Drawable r24 = r11.getContentContainer().getBackground();
        if ((r24 instanceof GradientDrawable) == false) goto L120;
        GradientDrawable r25 = (GradientDrawable) r24;
    L121:
        if (r25 == null) goto L123;
        r25.setCornerRadius(da0(12));
    L123:
        r1.addView(r11, r10);
        int r26 = r12[r9.ordinal()];
        if (r26 != 1) goto L126;
        r1.addView(ca0(ia0(getString(2131903335))));
    L130:
        r6 = r8;
        goto L22
    L126:
        if (r26 != 2) goto L130;
        r1.addView(ca0(ia0(getString(2131903339))));
        goto L130
    L120:
        r25 = null;
        goto L121
    L114:
        r23 = null;
        goto L115
    L108:
        r120 = null;
        goto L109
    L102:
        r118 = null;
        goto L103
    L84:
        r11.q(true);
        r11.setDefaultCustomEndView(3);
        r11.m(true);
        r11.k(Y90(((Number) ha0().getAutoStopTime().getValue()).intValue()), da0(80));
        OTextView r121 = r11.getEndDetail();
        if (r121 == null) goto L87;
        X90(r121);
    L87:
        r11.setTailIcon(2131245082);
        ImageView r122 = r11.getTailIconView();
        r122.setImageTintList(ContextCompat.getColorStateList(r122.getContext(), 2131104363));
        r122.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
        if (r123 == null) goto L90;
        r123.width = da0(20);
        r123.height = da0(20);
    L91:
        r122.setLayoutParams(r123);
        r11.r(true);
        r11.setOnContentClickListener(new j(this, r11));
        goto L99
    L90:
        r123 = null;
        goto L91
    L92:
        r11.q(false);
        r11.setDefaultCustomEndView(1);
        r11.m(true);
        r11.r(false);
        r11.setOnContentClickListener(null);
        OSwitch r124 = r11.getEndSwitch();
        if (r124 == null) goto L99;
        r124.setOnCheckedChangeListener(new m(this));
        goto L99
    L95:
        r11.q(false);
        r11.setDefaultCustomEndView(3);
        r11.m(true);
        r11.k("", da0(96));
        OTextView r125 = r11.getEndDetail();
        if (r125 == null) goto L98;
        X90(r125);
    L98:
        r11.setDefaultTailIcon(0);
        r11.r(false);
        r11.setOnContentClickListener(null);
        goto L99
    L73:
        r115 = getString(2131903482);
        goto L79
    L74:
        r115 = getString(2131903483);
        goto L79
    L75:
        r115 = getString(2131903484);
        goto L79
    L76:
        r115 = getString(2131903478);
        goto L79
    L77:
        r115 = ia0(getString(2131903339));
        goto L79
    L78:
        r115 = ia0(getString(2131903335));
        goto L79
    L71:
        throw new NoWhenBranchMatchedException();
    L34:
        r13 = getString(2131903328);
        goto L40
    L35:
        r13 = getString(2131902400);
        goto L40
    L36:
        r13 = getString(2131902059);
        goto L40
    L37:
        r13 = getString(2131902186);
        goto L40
    L38:
        r13 = getString(2131903338);
        goto L40
    L39:
        r13 = getString(2131903334);
        goto L40
    L32:
        throw new NoWhenBranchMatchedException();
    L131:
        com.larus.dora.impl.device.ailab.u r2 = this.n;
        ba0(r2);
        if ((r2 instanceof com.larus.dora.impl.device.ailab.u.b) == false) goto L134;
        com.larus.dora.impl.device.ailab.u.b r27 = (com.larus.dora.impl.device.ailab.u.b) r2;
    L135:
        if (r27 == null) goto L137;
        aa0(DoubaoConversationSettingItem.CONVERSATION_START_END_SOUND, r27.e, new l(this));
    L137:
        com.larus.dora.impl.device.settings.lab.c r28 = this.o;
        if ((r28 instanceof com.larus.dora.impl.device.settings.lab.c.b) == false) goto L140;
        com.larus.dora.impl.device.settings.lab.c.b r30 = (com.larus.dora.impl.device.settings.lab.c.b) r28;
    L141:
        if (r30 == null) goto L147;
        aa0(DoubaoConversationSettingItem.ALLOW_DOUBAO_VIEW_IMAGES, r30.j, new k(this));
        aa0(DoubaoConversationSettingItem.NATURAL_WAKEUP, r30.g, new p(this));
        Z90(r30);
        OCardListItem r31 = (OCardListItem) ((LinkedHashMap) this.m).get(DoubaoConversationSettingItem.DATA_SAVING);
        if (r31 == null) goto L147;
        OSwitch r32 = r31.getEndSwitch();
        if (r32 == null) goto L147;
        r32.setChecked(r30.v);
    L147:
        na0(((Number) ha0().getAutoStopTime().getValue()).intValue());
        Object r33 = fa0().getEnvStateFlow().getValue();
        if ((r33 instanceof com.larus.dora.impl.device.settings.lab.c.b) == false) goto L150;
        com.larus.dora.impl.device.settings.lab.c.b r34 = (com.larus.dora.impl.device.settings.lab.c.b) r33;
    L151:
        if (r34 == null) goto L154;
        Z90(r34);
    L154:
        Object r35 = fa0().getEnvStateFlow().getValue();
        if ((r35 instanceof com.larus.dora.impl.device.settings.lab.c.b) == false) goto L157;
        com.larus.dora.impl.device.settings.lab.c.b r36 = (com.larus.dora.impl.device.settings.lab.c.b) r35;
    L158:
        if (r36 == null) goto L174;
        OCardListItem r37 = (OCardListItem) ((LinkedHashMap) this.m).get(DoubaoConversationSettingItem.DATA_SAVING);
        if (r37 == null) goto L172;
        OSwitch r38 = r37.getEndSwitch();
        if (r38 == null) goto L173;
        r38.setChecked(r36.v);
        return;
    L173:
        return;
    L172:
        return;
    L174:
        return;
    L157:
        r36 = null;
        goto L158
    L150:
        r34 = null;
        goto L151
    L140:
        r30 = null;
        goto L141
    L134:
        r27 = null;
        goto L135
    }

    public final void onDestroyView() {
        com.obric.oui.popover.v2.c r0 = this.j;
        if (r0 == null) goto L5;
        W90(r0);
    L5:
        this.j = null;
        com.obric.oui.popover.v2.c r1 = this.k;
        if (r1 == null) goto L8;
        W90(r1);
    L8:
        this.k = null;
        this.i = null;
        this.l = null;
        ((LinkedHashMap) this.m).clear();
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public DoraObricGDoubaoConversationSettingsFragment() {
        final Function0<Fragment> r0 = new DoraObricGDoubaoConversationSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraObricDoubaoAutoDisconnectViewModel.class), new DoraObricGDoubaoConversationSettingsFragment$special$$inlined$viewModels$default$2(r0), new DoraObricGDoubaoConversationSettingsFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AiLabViewModel.class), new DoraObricGDoubaoConversationSettingsFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricGDoubaoConversationSettingsFragment$special$$inlined$activityViewModels$default$2(this));
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LabSettingsViewModel.class), new DoraObricGDoubaoConversationSettingsFragment$special$$inlined$activityViewModels$default$3(this), new DoraObricGDoubaoConversationSettingsFragment$special$$inlined$activityViewModels$default$4(this));
        this.m = new LinkedHashMap();
        this.n = com.larus.dora.impl.device.ailab.u.a.a;
        this.o = com.larus.dora.impl.device.settings.lab.c.a.a;
        this.r = true;
        this.u = LazyKt.lazy(new n());
        this.v = LazyKt.lazy(new o(this));
    }

    public final boolean ka0() {
        Object r0 = fa0().getEnvStateFlow().getValue();
        if ((r0 instanceof com.larus.dora.impl.device.settings.lab.c.b) == false) goto L5;
        com.larus.dora.impl.device.settings.lab.c.b r1 = (com.larus.dora.impl.device.settings.lab.c.b) r0;
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        com.larus.dora.impl.core.settingsconfig.c.a.getClass();
        if (com.larus.dora.impl.core.settingsconfig.c.j() == true) goto L12;
        return false;
    L12:
        if (r1.o == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public final void onResume() {
        super.onResume();
        ea0().load();
        fa0().forceUpdateEnable();
        ha0().refreshAutoStopTime();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStop() {
        super.onStop();
        com.larus.dora.impl.device.ailab.u r0 = this.n;
        if ((r0 instanceof com.larus.dora.impl.device.ailab.u.b) == false) goto L6;
        boolean r1 = ((com.larus.dora.impl.device.ailab.u.b) r0).a;
    L11:
        DoraBuryPointManager r2 = DoraBuryPointManager.a;
        Pair[] r3 = new Pair[2];
        String r4 = "on";
        if (r1 == false) goto L14;
        Object r5 = "on";
    L15:
        r3[0] = TuplesKt.to("voice_wakeup", r5);
        if (ea0().isMultiUserModeEnabled() == true) goto L19;
        r4 = "off";
    L19:
        r3[1] = TuplesKt.to("multi_user_mode", r4);
        r2.L("dora_ai_lab_settings", MapsKt.mapOf(r3));
        return;
    L14:
        r5 = "off";
        goto L15
    L6:
        if ((r0 instanceof com.larus.dora.impl.device.ailab.u.c) == false) goto L9;
        r1 = ((com.larus.dora.impl.device.ailab.u.c) r0).a;
        goto L11
    L9:
        if (Intrinsics.areEqual(r0, com.larus.dora.impl.device.ailab.u.a.a) == false) goto L22;
        r1 = false;
        goto L11
    L22:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.l;
    }

    public static void W90(com.obric.oui.popover.v2.c r0) {
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    }

    public static String ia0(String r3) {
        String r4 = StringsKt.trimEnd(r3).toString();
        Character r0 = StringsKt.lastOrNull(r4);
        if (r0 != null) goto L6;
    L7:
        if (r0 != null) goto L10;
    L11:
        if (r0 != null) goto L14;
        return r4;
    L14:
        if (r0.charValue() == '.') goto L16;
        return r4;
    L16:
        return StringsKt.trimEnd(StringsKt.dropLast(r4, 1)).toString();
    L10:
        if (r0.charValue() == 65294) goto L16;
    L6:
        if (r0.charValue() == 12290) goto L16;
        goto L7
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r1) {
        super.V90(r1);
        if (r1 == false) goto L6;
        ea0().load();
        fa0().forceUpdateEnable();
        ha0().refreshAutoStopTime();
        return;
    }

    public final void X90(OTextView r4) {
        r4.setTextColor(v19.c.a(2130972081, requireContext(), 2131103143));
        r4.setTextSize(2, 14.0f);
        TextViewCompat.setLineHeight(r4, la0(18.0f));
    }

    public final String Y90(int r7) {
        String r8 = String.valueOf(r7);
        return StringsKt.replace$default(StringsKt.replace$default(getString(2131903479), "{time}", r8, false, 4, null), "%s", r8, false, 4, null);
    }

    public final void Z90(com.larus.dora.impl.device.settings.lab.c.b r9) {
        com.larus.dora.impl.core.settingsconfig.c r0 = com.larus.dora.impl.core.settingsconfig.c.a;
        r0.getClass();
        boolean r2 = true;
        if (com.larus.dora.impl.core.settingsconfig.c.j() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L14;
        r0.getClass();
        if (com.larus.dora.impl.core.settingsconfig.c.b().b.contains("p2p") == false) goto L14;
        if (r9.q == false) goto L14;
        boolean r3 = true;
    L15:
        boolean r4 = r9.m;
        boolean r5 = r9.n;
        boolean r10 = r9.p;
        r0.getClass();
        boolean r6 = com.larus.dora.impl.core.settingsconfig.c.g();
        List r7 = com.larus.dora.impl.core.settingsconfig.c.i(r3);
        final ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r11 = r7.iterator();
    L17:
        if (r11.hasNext() == false) goto L19;
        r8.add(ma0((DoraXLinkTransportMode) r11.next()));
        goto L17
    L19:
        final OCardListItem r12 = (OCardListItem) ((LinkedHashMap) this.m).get(DoubaoConversationSettingItem.VIDEO_STREAM);
        if (r12 == null) goto L39;
        com.larus.dora.impl.core.settingsconfig.c.a.getClass();
        final RTCTransportMode r13 = ma0(com.larus.dora.impl.core.settingsconfig.c.d(r4, r5, r10));
        if (this.r == false) goto L28;
        if (r6 == false) goto L28;
        if ((!r8.isEmpty()) == false) goto L28;
    L29:
        r12.k(ga0(r13), da0(96));
        OTextView r14 = r12.getEndDetail();
        if (r14 == null) goto L32;
        X90(r14);
    L32:
        r12.r(r2);
        if (r2 == false) goto L35;
        View.OnClickListener r15 = new h(this, r12, r13, r8);
    L36:
        r12.setOnContentClickListener(r15);
        r12.setEnabled(this.r);
        return;
    L35:
        r15 = null;
    L28:
        r2 = false;
        goto L29
    L39:
        return;
    L14:
        r3 = false;
        goto L15
    L5:
        if (r9.o == false) goto L7;
        r1 = true;
        goto L8
    }

    public final void ba0(com.larus.dora.impl.device.ailab.u r3) {
        if ((r3 instanceof com.larus.dora.impl.device.ailab.u.b) == false) goto L6;
        Boolean r4 = Boolean.valueOf(((com.larus.dora.impl.device.ailab.u.b) r3).a);
    L11:
        if (r4 == null) goto L16;
        boolean r5 = r4.booleanValue();
        aa0(DoubaoConversationSettingItem.VOICE_WAKE, r5, new i(this));
        return;
    L16:
        return;
    L6:
        if ((r3 instanceof com.larus.dora.impl.device.ailab.u.c) == false) goto L9;
        r4 = Boolean.valueOf(((com.larus.dora.impl.device.ailab.u.c) r3).a);
        goto L11
    L9:
        if (Intrinsics.areEqual(r3, com.larus.dora.impl.device.ailab.u.a.a) == false) goto L15;
        r4 = null;
        goto L11
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public final View ca0(String r6) {
        OSectionSupportiveText r0 = new OSectionSupportiveText(requireContext(), null, 6, 0);
        r0.setPadding(da0(20), 0, da0(20), 0);
        r0.setSectionDes(r6);
        TextView r7 = (TextView) r0.findViewById(2131385718);
        if (r7 == null) goto L5;
        r7.setTextColor(v19.c.a(2130972081, requireContext(), 2131103143));
        r7.setTextSize(2, 12.0f);
        TextViewCompat.setLineHeight(r7, la0(16.0f));
        r7.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
    L5:
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return r0;
    }

    public final int da0(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final String ga0(RTCTransportMode r2) {
        int r3 = b.b[r2.ordinal()];
        if (r3 != 1) goto L5;
        int r4 = 2131902605;
    L14:
        return getString(r4);
    L5:
        if (r3 != 2) goto L7;
        r4 = 2131902607;
        goto L14
    L7:
        if (r3 != 3) goto L10;
        r4 = 2131902990;
        goto L14
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final int la0(float r3) {
        Resources r0 = getResources();
        return (int) TypedValue.applyDimension(2, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public final RTCTransportMode ma0(DoraXLinkTransportMode r2) {
        int r3 = b.c[r2.ordinal()];
        if (r3 == 1) goto L13;
        if (r3 == 2) goto L15;
        if (r3 != 3) goto L10;
        return RTCTransportMode.WIFI;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return RTCTransportMode.BLUETOOTH;
    L13:
        return RTCTransportMode.OFF;
    }

    public final void na0(int r4) {
        Map<DoubaoConversationSettingItem, OCardListItem> r0 = this.m;
        DoubaoConversationSettingItem r1 = DoubaoConversationSettingItem.AUTO_STOP_TIME;
        OCardListItem r2 = (OCardListItem) ((LinkedHashMap) r0).get(r1);
        if (r2 == null) goto L5;
        r2.k(Y90(r4), da0(80));
    L5:
        OCardListItem r5 = (OCardListItem) ((LinkedHashMap) this.m).get(r1);
        if (r5 == null) goto L11;
        OTextView r6 = r5.getEndDetail();
        if (r6 == null) goto L12;
        X90(r6);
        return;
    L12:
        return;
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        ja0();
        Lifecycle.State r13 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGDoubaoConversationSettingsFragment$observeAiLabState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGDoubaoConversationSettingsFragment$observeAiLabState$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGDoubaoConversationSettingsFragment$observeAiLabState$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGDoubaoConversationSettingsFragment$observeLabState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGDoubaoConversationSettingsFragment$observeLabState$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGDoubaoConversationSettingsFragment$observeLabState$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGDoubaoConversationSettingsFragment$observeAutoStopTime$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r13, null, this), 3, null);
    }

    public final void aa0(DoubaoConversationSettingItem r2, boolean r3, final Function1<? super Boolean, Unit> r4) {
        OCardListItem r5 = (OCardListItem) ((LinkedHashMap) this.m).get(r2);
        if (r5 == null) goto L8;
        OSwitch r6 = r5.getEndSwitch();
        if (r6 == null) goto L9;
        r6.setOnCheckedChangeListener(null);
        r6.setChecked(r3);
        r6.setOnCheckedChangeListener(new e(r4));
        return;
    L9:
        return;
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        Context r13 = requireContext();
        OFloatingTitleBar r14 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r14.setClipChildren(false);
        r14.setClipToPadding(false);
        r14.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r14.setCenterTitle(getString(2131903481));
        r14.R(false);
        OFloatingTitleBar.k(r14, null, 6).setOnClickListener(new com.larus.dora.obric.device_management.setting.g.conversation_settings.b(this));
        Context r15 = requireContext();
        LinearLayout r0 = new LinearLayout(r15);
        r0.setOrientation(1);
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        r0.setPadding(da0(12), da0(16), da0(12), da0(24));
        this.i = r0;
        NestedScrollView r1 = new NestedScrollView(r15);
        r1.setClipChildren(true);
        r1.setClipToPadding(false);
        r1.setOverScrollMode(2);
        r1.setFillViewport(true);
        r1.addView(this.i, new ViewGroup.LayoutParams(-1, -2));
        return com.larus.dora.obric.utils.c.c(r13, r14, r1, v19.c.a(2130970531, requireContext(), 2131102535), new com.larus.dora.obric.device_management.setting.g.conversation_settings.a(this));
    }
}
