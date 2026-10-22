package com.larus.dora.obric.device_management.setting.earbuds;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.annotation.ProtocolAbility;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoGeneraGroupLayoutBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.dora.impl.dynamic.dsl.DslRedDotAdapter;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.util.PacificInterfaceManager;
import com.larus.dora.impl.util.b0;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.larus.utils.l0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.oui.badge.OBadgeView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0000\u0018\u0000 [2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005WXYZ[B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010\u0015\u001a\u00020\u000f*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0002J\f\u0010\"\u001a\u00020\u000f*\u00020\u001fH\u0002J\f\u0010#\u001a\u00020\u000f*\u00020\u001fH\u0002J\u0014\u0010$\u001a\u00020\u000f*\u00020%2\u0006\u0010&\u001a\u00020\nH\u0002J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0(H\u0002J\u001c\u0010)\u001a\u00020\u000f*\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J%\u0010*\u001a\u00020\u000f*\u00020\u001f2\u0006\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0002\u0010.J\f\u0010/\u001a\u00020\u000f*\u00020\u001fH\u0002J\u0014\u00100\u001a\u00020\u000f*\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u001fH\u0002J\b\u00103\u001a\u00020\u000fH\u0016J\b\u00104\u001a\u00020\u000fH\u0016J\b\u00105\u001a\u00020\u000fH\u0002J\u0010\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020!H\u0002J\u0014\u0010;\u001a\u00020\u000f*\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0014\u0010<\u001a\u00020\u000f*\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\f\u0010=\u001a\u00020\u000f*\u00020>H\u0002J\u001c\u0010?\u001a\u00020\u000f*\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\u0018\u0010@\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\u001c\u0010A\u001a\u0004\u0018\u00010,2\u0006\u0010B\u001a\u00020,2\b\u0010C\u001a\u0004\u0018\u00010DH\u0002J\u0018\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020,H\u0002J\f\u0010J\u001a\u00020\u000f*\u00020\u001fH\u0002J\f\u0010K\u001a\u00020\u000f*\u00020FH\u0002J\f\u0010L\u001a\u00020\u000f*\u00020FH\u0002J\f\u0010M\u001a\u00020\u000f*\u00020\u001fH\u0002J\u0018\u0010N\u001a\u00020!2\u0006\u0010O\u001a\u00020!2\u0006\u0010P\u001a\u00020!H\u0002J\u0010\u0010Q\u001a\u00020,2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010R\u001a\u00020!2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010S\u001a\u00020!2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010T\u001a\u00020!2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010U\u001a\u00020!2\u0006\u0010G\u001a\u00020HH\u0002J\f\u0010V\u001a\u00020!*\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\t\u0010\u000b¨\u0006\\"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsSettingsGeneralGroupHolder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoGeneraGroupLayoutBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoGeneraGroupLayoutBinding;)V", "autoStopTimePopover", "Lcom/obric/oui/popover/v2/OPopover;", "isThirdPartyDeviceSharedEnabled", "", "()Z", "isThirdPartyDeviceSharedEnabled$delegate", "Lkotlin/Lazy;", "bind", "", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "renderItems", "Landroid/widget/LinearLayout;", "device", "Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "items", "", "Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsSettingsGeneralGroupHolder$DslGeneralItem;", "shouldRenderItem", "item", "buildItemCard", "Lcom/obric/oui/lisitem/OCardListItem;", "position", "", "bindToggleContent", "bindMultiUserModeAction", "setCheckedSilently", "Lcom/obric/oui/oswitch/OSwitch;", "checked", "getMultiUserModeStateFlow", "Lkotlinx/coroutines/flow/Flow;", "bindEndContent", "showEndText", "text", "", "maxWidthDp", "(Lcom/obric/oui/lisitem/OCardListItem;Ljava/lang/String;Ljava/lang/Integer;)V", "showGoSmartAudioText", "showDropEndText", "showAutoStopTimeMenu", "anchor", "onViewDetached", "onViewRecycled", "dismissAutoStopTimePopover", "updateAutoStopTime", "option", "Lcom/larus/dora/impl/device/ailab/config/AutoStopTimeConfig;", "autoStopTimeText", "time", "bindVoicePrintStatus", "bindTailIcon", "applyDropIconStyle", "Landroid/widget/ImageView;", "bindRedDot", "openAction", "resolveEarbudsRoute", "url", "itemType", "Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsSettingsGeneralGroupHolder$DslGeneralItemType;", "buildDescView", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "desc", "applyCardStyle", "applyTitleTextStyle", "applyValueTextStyle", "resetCardContainerMargins", "resolveCardPosition", "index", "size", "resolveLatestDeviceName", "resolvePrimaryTextColor", "resolveValueTextColor", "resolveSecondaryTextColor", "resolveHighlightTextColor", "dp", "DslGeneralGroup", "DslGeneralItem", "DslRightTextType", "DslGeneralItemType", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsSettingsGeneralGroupHolder extends BaseViewHolder<c59.i> {
    public static final /* synthetic */ int e = 0;
    public final LarusDoraDeviceInfoGeneraGroupLayoutBinding b;
    public com.obric.oui.popover.v2.c c;
    public final Lazy d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsSettingsGeneralGroupHolder$DslGeneralItemType;", "", "<init>", "(Ljava/lang/String;I)V", "ITEM_TEXT_ARROW", "ITEM_TEXT_TOGGLE", "PROACTIVE_SETTINGS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DslGeneralItemType extends Enum<DslGeneralItemType> {

        @SerializedName("item_text_arrow")
        public static final DslGeneralItemType ITEM_TEXT_ARROW = null;

        @SerializedName("item_text_toggle")
        public static final DslGeneralItemType ITEM_TEXT_TOGGLE = null;

        @SerializedName("proactive_settings")
        public static final DslGeneralItemType PROACTIVE_SETTINGS = null;
        public static final /* synthetic */ DslGeneralItemType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<DslGeneralItemType> getEntries() {
            return b;
        }

        static {
            DslGeneralItemType r0 = new DslGeneralItemType("ITEM_TEXT_ARROW", 0);
            ITEM_TEXT_ARROW = r0;
            DslGeneralItemType r1 = new DslGeneralItemType("ITEM_TEXT_TOGGLE", 1);
            ITEM_TEXT_TOGGLE = r1;
            DslGeneralItemType r3 = new DslGeneralItemType("PROACTIVE_SETTINGS", 2);
            PROACTIVE_SETTINGS = r3;
            DslGeneralItemType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static DslGeneralItemType[] values() {
            return (DslGeneralItemType[]) a.clone();
        }

        public static DslGeneralItemType valueOf(String r1) {
            return (DslGeneralItemType) r27.a.a(DslGeneralItemType.class, r1);
        }

        public DslGeneralItemType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsSettingsGeneralGroupHolder$DslRightTextType;", "", "<init>", "(Ljava/lang/String;I)V", "DEVICE_NAME", "FIRMWARE_VERSION", "DEVICE_SN", "GO_SMART_AUDIO", "AUTO_STOP_TIME", "VOICE_PRINT", "CASE_VERSION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DslRightTextType extends Enum<DslRightTextType> {

        @SerializedName("auto_stop_time")
        public static final DslRightTextType AUTO_STOP_TIME = null;

        @SerializedName("case_version")
        public static final DslRightTextType CASE_VERSION = null;

        @SerializedName("device_name")
        public static final DslRightTextType DEVICE_NAME = null;

        @SerializedName("device_sn")
        public static final DslRightTextType DEVICE_SN = null;

        @SerializedName("firmware_version")
        public static final DslRightTextType FIRMWARE_VERSION = null;

        @SerializedName("go_smart_audio")
        public static final DslRightTextType GO_SMART_AUDIO = null;

        @SerializedName("voice_print")
        public static final DslRightTextType VOICE_PRINT = null;
        public static final /* synthetic */ DslRightTextType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<DslRightTextType> getEntries() {
            return b;
        }

        static {
            DslRightTextType r0 = new DslRightTextType("DEVICE_NAME", 0);
            DEVICE_NAME = r0;
            DslRightTextType r1 = new DslRightTextType("FIRMWARE_VERSION", 1);
            FIRMWARE_VERSION = r1;
            DslRightTextType r3 = new DslRightTextType("DEVICE_SN", 2);
            DEVICE_SN = r3;
            DslRightTextType r5 = new DslRightTextType("GO_SMART_AUDIO", 3);
            GO_SMART_AUDIO = r5;
            DslRightTextType r7 = new DslRightTextType("AUTO_STOP_TIME", 4);
            AUTO_STOP_TIME = r7;
            DslRightTextType r9 = new DslRightTextType("VOICE_PRINT", 5);
            VOICE_PRINT = r9;
            DslRightTextType r11 = new DslRightTextType("CASE_VERSION", 6);
            CASE_VERSION = r11;
            DslRightTextType[] r13 = {r0, r1, r3, r5, r7, r9, r11};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static DslRightTextType[] values() {
            return (DslRightTextType[]) a.clone();
        }

        public static DslRightTextType valueOf(String r1) {
            return (DslRightTextType) r27.a.a(DslRightTextType.class, r1);
        }

        public DslRightTextType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsSettingsGeneralGroupHolder$DslGeneralGroup;", "", "items", "", "Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsSettingsGeneralGroupHolder$DslGeneralItem;", "desc", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "<init>", "(Ljava/util/List;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;)V", "getItems", "()Ljava/util/List;", "getDesc", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("desc")
        private final c59.t desc;

        @SerializedName("items")
        private final List<c> items;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.items, r6.items) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.desc, r6.desc) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            List<c> r0 = this.items;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            c59.t r4 = this.desc;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "DslGeneralGroup(items=" + this.items + ", desc=" + this.desc + ')';
        }

        public b() {
            this.items = null;
            this.desc = null;
        }

        public final c59.t a() {
            return this.desc;
        }

        public final List<c> b() {
            return this.items;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0013\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000fHÆ\u0003Je\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000fHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\tHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006."}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsSettingsGeneralGroupHolder$DslGeneralItem;", "", "itemType", "Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsSettingsGeneralGroupHolder$DslGeneralItemType;", "title", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "rightText", "Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsSettingsGeneralGroupHolder$DslRightTextType;", "rightIcon", "", "action", "Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "condition", "Lcom/larus/dora/impl/dynamic/dsl/DslCondition;", "redDot", "", "<init>", "(Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsSettingsGeneralGroupHolder$DslGeneralItemType;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsSettingsGeneralGroupHolder$DslRightTextType;Ljava/lang/String;Lcom/larus/dora/impl/dynamic/dsl/DslAction;Lcom/larus/dora/impl/dynamic/dsl/DslCondition;Ljava/util/List;)V", "getItemType", "()Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsSettingsGeneralGroupHolder$DslGeneralItemType;", "getTitle", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "getRightText", "()Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsSettingsGeneralGroupHolder$DslRightTextType;", "getRightIcon", "()Ljava/lang/String;", "getAction", "()Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "getCondition", "()Lcom/larus/dora/impl/dynamic/dsl/DslCondition;", "getRedDot", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c {

        @SerializedName("action")
        private final c59.b action;

        @SerializedName("condition")
        private final c59.j condition;

        @SerializedName("item_type")
        private final DslGeneralItemType itemType;

        @SerializedName("red_dot")
        private final List<String> redDot;

        @SerializedName("right_icon")
        private final String rightIcon;

        @SerializedName("right_text")
        private final DslRightTextType rightText;

        @SerializedName("title")
        private final c59.t title;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.itemType == r6.itemType) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
            return false;
        L15:
            if (this.rightText == r6.rightText) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.rightIcon, r6.rightIcon) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.action, r6.action) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.condition, r6.condition) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.redDot, r6.redDot) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            DslGeneralItemType r0 = this.itemType;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            c59.t r4 = this.title;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            DslRightTextType r7 = this.rightText;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.rightIcon;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            c59.b r13 = this.action;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            c59.j r16 = this.condition;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            List<String> r20 = this.redDot;
            if (r20 == null) goto L31;
            r1 = r20.hashCode();
        L31:
            return r18 + r1;
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "DslGeneralItem(itemType=" + this.itemType + ", title=" + this.title + ", rightText=" + this.rightText + ", rightIcon=" + this.rightIcon + ", action=" + this.action + ", condition=" + this.condition + ", redDot=" + this.redDot + ')';
        }

        public c() {
            this.itemType = null;
            this.title = null;
            this.rightText = null;
            this.rightIcon = null;
            this.action = null;
            this.condition = null;
            this.redDot = null;
        }

        public final c59.b a() {
            return this.action;
        }

        public final c59.j b() {
            return this.condition;
        }

        public final DslGeneralItemType c() {
            return this.itemType;
        }

        public final List<String> d() {
            return this.redDot;
        }

        public final DslRightTextType e() {
            return this.rightText;
        }

        public final c59.t f() {
            return this.title;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DslRightTextType.values().length];
            r0[DslRightTextType.DEVICE_NAME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[DslRightTextType.FIRMWARE_VERSION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[DslRightTextType.DEVICE_SN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[DslRightTextType.GO_SMART_AUDIO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[DslRightTextType.AUTO_STOP_TIME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[DslRightTextType.CASE_VERSION.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[DslRightTextType.VOICE_PRINT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    static {
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void V3() {
        com.obric.oui.popover.v2.c r0 = this.c;
        if (r0 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        this.c = null;
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void onViewRecycled() {
        com.obric.oui.popover.v2.c r0 = this.c;
        if (r0 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        this.c = null;
    }

    public DoraObricEarbudsSettingsGeneralGroupHolder(LarusDoraDeviceInfoGeneraGroupLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2.a);
        this.b = r2;
        this.d = LazyKt.lazy(new v());
    }

    public final void X3(TextView r4) {
        r4.setGravity(8388611);
        r4.setMaxLines(1);
        r4.setTextColor(v19.c.a(2130972079, r4.getContext(), 2131103136));
        r4.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r4, Y3(22));
        r4.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
    }

    public final int Y3(int r3) {
        Resources r0 = this.b.a.getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void Z3(final OSwitch r2, boolean r3) {
        r2.setOnCheckedChangeListener(null);
        r2.setChecked(r3);
        r2.setOnCheckedChangeListener(new s(r2, this));
    }

    public final void a4(OCardListItem r4, String r5) {
        b4(r4, r5, 80);
        r4.setTailIcon(2131245082);
        ImageView r6 = r4.getTailIconView();
        r6.setImageTintList(ContextCompat.getColorStateList(r6.getContext(), 2131104363));
        r6.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if (r0 == null) goto L5;
        r0.width = Y3(20);
        r0.height = Y3(20);
    L6:
        r6.setLayoutParams(r0);
        r4.r(true);
        return;
    L5:
        r0 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r24v0, types: [com.larus.dora.obric.device_management.setting.earbuds.DoraObricEarbudsSettingsGeneralGroupHolder] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v34 */
    /* JADX WARN: Type inference failed for: r8v35, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r8v48 */
    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(c59.i r25, e59.b r26, d59.b r27) {
        c59.i r2 = r25;
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r26, "connectionState");
        com.obric.oui.popover.v2.c r3 = this.c;
        if (r3 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r3);
        r3.dismiss();
    L5:
        DoraDevice r4 = null;
        this.c = null;
        Lazy r5 = c59.s.a;
        b r6 = (b) c59.s.c(r2.b, b.class);
        if (r6 == null) goto L40;
        List<c> r7 = r6.b();
        if (r7 == null) goto L40;
        List r8 = CollectionsKt.filterNotNull(r7);
        if (r8 == null) goto L40;
        ?? r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L13:
        if (r10.hasNext() == false) goto L41;
        Object r11 = r10.next();
        c59.j r12 = ((c) r11).b();
        if (r27 == null) goto L19;
        z49.b r13 = r27.a;
        if (r13 == null) goto L19;
        String r14 = r13.h();
    L20:
        if (r27 == null) goto L24;
        z49.b r15 = r27.a;
        if (r15 == null) goto L24;
        Integer r16 = r15.f();
    L25:
        if (r27 == null) goto L29;
        z49.b r17 = r27.a;
        if (r17 == null) goto L29;
        String r18 = r17.c();
    L30:
        if (r27 == null) goto L36;
        z49.b r110 = r27.a;
        if (r110 == null) goto L36;
        DoraDevice r111 = r110.a;
        if (r111 == null) goto L36;
        String r112 = r111.caseSoftVersion;
    L38:
        if (c59.p.c(r12, r14, r16, r18, r112) == false) goto L13;
        r9.add(r11);
    L36:
        r112 = null;
    L29:
        r18 = null;
    L24:
        r16 = null;
    L19:
        r14 = null;
    L41:
        if (r9 != 0) goto L43;
        r9 = CollectionsKt.emptyList();
    L43:
        if (r27 == null) goto L45;
        final z49.b r1 = r27.a;
    L46:
        if (r1 != null) goto L48;
    L239:
        this.b.b.removeAllViews();
        e1.o(this.b.a);
        return;
    L48:
        if (r9.isEmpty() == true) goto L239;
        e1.x(this.b.a);
        this.b.a.setPadding(Y3(12), Y3(8), Y3(12), Y3(8));
        LinearLayout r20 = this.b.b;
        Intrinsics.checkNotNull(r20);
        e1.x(r20);
        r20.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r20.removeAllViews();
        ArrayList r21 = new ArrayList();
        Iterator r22 = ((Iterable) r9).iterator();
    L51:
        ?? r113 = 1;
        boolean r114 = true;
        r114 = true;
        r114 = true;
        String r115 = "";
        if (r22.hasNext() == false) goto L94;
        Object r116 = r22.next();
        c r117 = (c) r116;
        if (r117.c() != DslGeneralItemType.ITEM_TEXT_TOGGLE) goto L66;
        c59.b r23 = r117.a();
        if (r23 == null) goto L58;
        String r24 = r23.e();
    L60:
        if (Intrinsics.areEqual(r24, "toggle://multi_user_mode") == true) goto L62;
    L64:
        r114 = false;
    L91:
        if (r114 == false) goto L51;
        r21.add(r116);
        goto L51
    L62:
        if (((Boolean) this.d.getValue()).booleanValue() == false) goto L64;
    L58:
        r24 = null;
        goto L60
    L66:
        if (r117.e() != DslRightTextType.VOICE_PRINT) goto L91;
        IDoraService r28 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r28 == null) goto L75;
        DeviceService r30 = r28.device();
        if (r30 == null) goto L75;
        if (r30.n0(ProtocolAbility.FEATURE_OTA3P5) == true) goto L75;
        boolean r31 = true;
    L76:
        if (r31 == true) goto L80;
        DoraSetting.a.getClass();
        int r32 = l0.a;
        if (((Boolean) l0.a(Boolean.TRUE, new com.larus.dora.impl.settings.x())).booleanValue() == false) goto L80;
    L81:
        if (r114 == true) goto L91;
        Function1<? super Boolean, Unit> r33 = PacificInterfaceManager.a;
        String r34 = r1.c();
        if (r34 == null) goto L86;
        r115 = r34;
    L86:
        Intrinsics.checkNotNullParameter(r115, "mac");
        String r35 = PacificInterfaceManager.f(r115);
        if (r35 == null) goto L90;
        r115 = r35;
    L90:
        PacificInterfaceManager.a(r115);
    L80:
        r114 = false;
    L75:
        r31 = false;
        goto L76
    L94:
        int r36 = r21.size();
        Iterator r37 = r21.iterator();
        int r38 = 0;
    L96:
        if (r37.hasNext() == false) goto L233;
        Object r118 = r37.next();
        int r119 = r38 + 1;
        if (r38 >= 0) goto L100;
        CollectionsKt.throwIndexOverflow();
    L100:
        final c r120 = (c) r118;
        if (r36 > r113) goto L103;
        int r40 = 0;
    L109:
        final OCardListItem r41 = new OCardListItem(this.b.a.getContext(), r4, 6, 0);
        r41.setVisibility(0);
        r41.setCardType(0);
        OCardListItem.h(r41, r40);
        r41.setShowCardBg(r113);
        r41.p(false);
        c59.t r42 = r120.f();
        if (r42 == null) goto L112;
        DoraDevice r43 = c59.p.b(r42);
    L113:
        if (r43 != null) goto L115;
        r43 = "";
    L115:
        r41.setTitle(r43);
        r41.s(r113);
        r41.q(false);
        if (r120.c() != DslGeneralItemType.ITEM_TEXT_TOGGLE) goto L120;
        r41.setDefaultCustomEndView(r113);
        r41.m(r113);
        r41.r(false);
        OSwitch r44 = r41.getEndSwitch();
        if (r44 == null) goto L174;
        Z3(r44, false);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new DoraObricEarbudsSettingsGeneralGroupHolder$bindToggleContent$1$1(this, r44, r4), 3, null);
    L174:
        DoraDevice r45 = z49.a.a(r1);
        List<String> r46 = r120.d();
        if (r46 == null) goto L177;
        DoraDevice r47 = CollectionsKt.filterNotNull(r46);
    L178:
        if (r47 != null) goto L180;
        r47 = CollectionsKt.emptyList();
    L180:
        Iterable r48 = (Iterable) r47;
        if ((r48 instanceof Collection) == true) goto L183;
    L185:
        Iterator r50 = r48.iterator();
    L187:
        if (r50.hasNext() == false) goto L191;
        if (DslRedDotAdapter.a((String) r50.next(), r45) == false) goto L187;
        boolean r51 = true;
    L192:
        if (r51 == false) goto L216;
        r41.i(2131562234, false);
        View r52 = r41.c();
        if ((r52 instanceof ViewGroup) == false) goto L197;
        DoraDevice r53 = (ViewGroup) r52;
    L198:
        if (r53 == null) goto L200;
        ?? r54 = (TextView) r53.findViewById(2131369829);
    L201:
        if (r53 == null) goto L203;
        DoraDevice r121 = (OBadgeView) r53.findViewById(2131369830);
    L204:
        if (r54 == 0) goto L214;
        if (r121 == null) goto L214;
        c59.t r55 = r120.f();
        if (r55 == null) goto L210;
        DoraDevice r56 = c59.p.b(r55);
    L211:
        if (r56 != null) goto L213;
        r56 = "";
    L213:
        r54.setText(r56);
        X3(r54);
        r121.setVisibility(0);
        r41.s(false);
        goto L216
    L210:
        r56 = r4;
    L214:
        if (r53 == null) goto L216;
        r41.getTitleContainer().removeView(r53);
        goto L216
    L203:
        r121 = r4;
        goto L204
    L200:
        r54 = r4;
        goto L201
    L197:
        r53 = r4;
    L216:
        ViewGroup.LayoutParams r57 = r41.getCardContainer().getLayoutParams();
        if ((r57 instanceof ViewGroup.MarginLayoutParams) == false) goto L219;
        DoraDevice r58 = (ViewGroup.MarginLayoutParams) r57;
    L220:
        if (r58 == null) goto L222;
        r58.setMarginStart(0);
        r58.setMarginEnd(0);
        ((ViewGroup.MarginLayoutParams) r58).leftMargin = 0;
        ((ViewGroup.MarginLayoutParams) r58).rightMargin = 0;
        r41.getCardContainer().setLayoutParams(r58);
    L222:
        r41.getContentContainer().setPadding(0, 0, Y3(4), 0);
        r41.getTitleContainer().setGravity(16);
        r41.getTitleContainer().setPadding(Y3(12), Y3(4), Y3(4), Y3(4));
        X3(r41.getTitleView());
        r41.o(false);
        if (r120.c() != DslGeneralItemType.ITEM_TEXT_TOGGLE) goto L229;
        final OSwitch r60 = r41.getEndSwitch();
        if (r60 == null) goto L232;
        r41.setOnContentClickListener(new z(r41, r60));
        r60.setOnCheckedChangeListener(new a0(r60, this));
    L232:
        r20.addView(r41);
        r38 = r119;
        r4 = null;
        r113 = 1;
        goto L96
    L229:
        if (r120.e() != DslRightTextType.AUTO_STOP_TIME) goto L231;
        r41.setOnContentClickListener(new t(r41, this));
        goto L232
    L231:
        r41.setOnContentClickListener(new u(r41, this, r1, r120));
        goto L232
    L219:
        r58 = r4;
    L191:
        r51 = false;
        goto L192
    L183:
        if (((Collection) r48).isEmpty() == false) goto L185;
    L177:
        r47 = r4;
        goto L178
    L120:
        DslRightTextType r61 = r120.e();
        if (r61 != null) goto L123;
        int r62 = -1;
    L124:
        switch(r62) {
            case 1: goto L143;
            case 2: goto L139;
            case 3: goto L135;
            case 4: goto L132;
            case 5: goto L131;
            case 6: goto L127;
            case 7: goto L126;
            default: goto L125;
        };
    L125:
        r41.m(false);
    L159:
        if (r120.e() == DslRightTextType.AUTO_STOP_TIME) goto L174;
        DslRightTextType r63 = r120.e();
        if (r63 != null) goto L164;
        int r64 = -1;
    L166:
        if (r64 != 2) goto L168;
    L172:
        boolean r65 = false;
    L173:
        r41.setDefaultTailIcon(0);
        r41.r(r65);
        goto L174
    L168:
        if (r64 == 3) goto L172;
        if (r64 == 6) goto L172;
        r65 = true;
        goto L173
    L164:
        r64 = d.a[r63.ordinal()];
        goto L166
    L126:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new DoraObricEarbudsSettingsGeneralGroupHolder$bindVoicePrintStatus$1(r1, this, r41, r4), 3, null);
        goto L159
    L127:
        String r66 = r1.b();
        if (r66 != null) goto L130;
        r66 = "";
    L130:
        b4(r41, r66, r4);
        goto L159
    L131:
        StringBuilder r67 = new StringBuilder();
        b0.a.getClass();
        r67.append(b0.c());
        r67.append('s');
        a4(r41, r67.toString());
        goto L159
    L132:
        int r68 = j0.a;
        b4(r41, j0.d(2131903840), r4);
        OTextView r70 = r41.getEndDetail();
        if (r70 == null) goto L159;
        r70.setTextColor(v19.c.a(2130972123, r41.getContext(), 2131103203));
        goto L159
    L135:
        String r71 = r1.h();
        if (r71 != null) goto L138;
        r71 = "";
    L138:
        b4(r41, r71, 184);
        goto L159
    L139:
        String r72 = r1.i();
        if (r72 != null) goto L142;
        r72 = "";
    L142:
        b4(r41, r72, r4);
        goto L159
    L143:
        DoraDevice r73 = DoraAdapterExtKt.h(kj4.a.g());
        if (r73 != null) goto L146;
    L153:
        String r74 = r1.e();
    L154:
        int r75 = com.larus.dora.impl.util.o.a;
        String r76 = r1.c();
        if (r74 != null) goto L157;
        r74 = "";
    L157:
        b4(r41, com.larus.dora.impl.util.o.b(r76, r74), r4);
        goto L159
    L146:
        if (Intrinsics.areEqual(r73.mac, r1.c()) == true) goto L149;
        r73 = r4;
    L149:
        if (r73 == null) goto L153;
        r74 = r73.name;
        if (r74 == null) goto L153;
    L123:
        r62 = d.a[r61.ordinal()];
        goto L124
    L112:
        r43 = r4;
        goto L113
    L103:
        if (r38 != 0) goto L106;
        r40 = 1;
        goto L109
    L106:
        if (r38 != (r36 - 1)) goto L108;
        r40 = 3;
        goto L109
    L108:
        r40 = 2;
        goto L109
    L233:
        if (r6 == null) goto L257;
        c59.t r77 = r6.a();
        if (r77 == null) goto L258;
        String r78 = c59.p.b(r77);
        if (r78 == null) goto L259;
        Context r80 = r20.getContext();
        OTextView r81 = new OTextView(r80, null, 0, 14);
        r81.setText(r78);
        r81.setTextAlignment(5);
        r81.setTextColor(v19.c.a(2130972081, r80, 2131103143));
        r81.setTextSize(2, 12.0f);
        TextViewCompat.setLineHeight(r81, Y3(18));
        r81.setPadding(Y3(20), Y3(8), Y3(20), Y3(8));
        r81.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r20.addView(r81);
        return;
    L259:
        return;
    L258:
        return;
    L257:
        return;
    L45:
        r1 = null;
    L40:
        r9 = 0;
        goto L41
    }

    public final void b4(OCardListItem r2, String r3, Integer r4) {
        r2.setDefaultCustomEndView(3);
        if (r4 == null) goto L5;
        r2.k(r3, Y3(r4.intValue()));
    L6:
        r2.m(true);
        OTextView r5 = r2.getEndDetail();
        if (r5 == null) goto L10;
        r5.getContext();
        r5.setTextColor(ColorProtector.parseColor("#999999"));
        r5.setTextSize(2, 14.0f);
        TextViewCompat.setLineHeight(r5, Y3(20));
        r5.setMaxLines(1);
        return;
    L10:
        return;
    L5:
        r2.k(r3, -1);
        goto L6
    }
}
