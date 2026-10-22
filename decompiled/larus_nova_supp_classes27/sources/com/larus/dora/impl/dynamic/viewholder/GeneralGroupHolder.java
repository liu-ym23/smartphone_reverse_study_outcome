package com.larus.dora.impl.dynamic.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.annotation.ProtocolAbility;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoGeneraGroupLayoutBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.dora.impl.dynamic.dsl.DslActionType;
import com.larus.dora.impl.dynamic.dsl.DslRedDotAdapter;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.settings.x;
import com.larus.dora.impl.util.PacificInterfaceManager;
import com.larus.dora.impl.util.b0;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.larus.utils.l0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
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
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006JN\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eJL\u0010 \u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010#\u001a\u00020$H\u0016J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0&H\u0002J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001fH\u0002J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0017J\"\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000b\u0010\r¨\u00062"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/GeneralGroupHolder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoGeneraGroupLayoutBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoGeneraGroupLayoutBinding;)V", "dynamicItems", "Lcom/larus/dora/impl/device_v2/widget/DynamicItemViews;", "getDynamicItems", "()Lcom/larus/dora/impl/device_v2/widget/DynamicItemViews;", "isThirdPartyDeviceSharedEnabled", "", "()Z", "isThirdPartyDeviceSharedEnabled$delegate", "Lkotlin/Lazy;", "generateViews", "", "context", "Landroid/content/Context;", "doraDevice", "Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "parentViewGroup", "Landroid/view/ViewGroup;", "items", "", "Lcom/larus/dora/impl/dynamic/viewholder/GeneralGroupHolder$Companion$DslGeneralItem;", "desc", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "startling", "", "", "createChildView", "itemCount", "", "itemGroup", "Lcom/larus/bmhome/view/item/ItemGroup;", "getMultiUserModeStateFlow", "Lkotlinx/coroutines/flow/Flow;", "createDescView", "Landroid/widget/TextView;", "appendItemGroup", "container", "bind", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class GeneralGroupHolder extends BaseViewHolder<c59.i> {
    public static final /* synthetic */ int e = 0;
    public final LarusDoraDeviceInfoGeneraGroupLayoutBinding b;
    public final a59.a c;
    public final Lazy d;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/GeneralGroupHolder$Companion$DslGeneralItemType;", "", "<init>", "(Ljava/lang/String;I)V", "ITEM_TEXT_ARROW", "ITEM_TEXT_TOGGLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum DslGeneralItemType extends Enum<DslGeneralItemType> {

            @SerializedName("item_text_arrow")
            public static final DslGeneralItemType ITEM_TEXT_ARROW = null;

            @SerializedName("item_text_toggle")
            public static final DslGeneralItemType ITEM_TEXT_TOGGLE = null;
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
                DslGeneralItemType[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
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

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/GeneralGroupHolder$Companion$DslRightTextType;", "", "<init>", "(Ljava/lang/String;I)V", "DEVICE_NAME", "FIRMWARE_VERSION", "DEVICE_SN", "GO_SMART_AUDIO", "AUTO_STOP_TIME", "VOICE_PRINT", "CASE_VERSION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/GeneralGroupHolder$Companion$DslGeneralGroup;", "", "items", "", "Lcom/larus/dora/impl/dynamic/viewholder/GeneralGroupHolder$Companion$DslGeneralItem;", "desc", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "<init>", "(Ljava/util/List;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;)V", "getItems", "()Ljava/util/List;", "getDesc", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a {

            @SerializedName("desc")
            private final c59.t desc;

            @SerializedName("items")
            private final List<b> items;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof a) == true) goto L8;
                return false;
            L8:
                a r6 = (a) r5;
                if (Intrinsics.areEqual(this.items, r6.items) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.desc, r6.desc) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                List<b> r0 = this.items;
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

            public a() {
                this.items = null;
                this.desc = null;
            }

            public final c59.t a() {
                return this.desc;
            }

            public final List<b> b() {
                return this.items;
            }
        }

        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0013\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000fHÆ\u0003Je\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000fHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\tHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006."}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/GeneralGroupHolder$Companion$DslGeneralItem;", "", "itemType", "Lcom/larus/dora/impl/dynamic/viewholder/GeneralGroupHolder$Companion$DslGeneralItemType;", "title", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "rightText", "Lcom/larus/dora/impl/dynamic/viewholder/GeneralGroupHolder$Companion$DslRightTextType;", "rightIcon", "", "action", "Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "condition", "Lcom/larus/dora/impl/dynamic/dsl/DslCondition;", "redDot", "", "<init>", "(Lcom/larus/dora/impl/dynamic/viewholder/GeneralGroupHolder$Companion$DslGeneralItemType;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/viewholder/GeneralGroupHolder$Companion$DslRightTextType;Ljava/lang/String;Lcom/larus/dora/impl/dynamic/dsl/DslAction;Lcom/larus/dora/impl/dynamic/dsl/DslCondition;Ljava/util/List;)V", "getItemType", "()Lcom/larus/dora/impl/dynamic/viewholder/GeneralGroupHolder$Companion$DslGeneralItemType;", "getTitle", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "getRightText", "()Lcom/larus/dora/impl/dynamic/viewholder/GeneralGroupHolder$Companion$DslRightTextType;", "getRightIcon", "()Ljava/lang/String;", "getAction", "()Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "getCondition", "()Lcom/larus/dora/impl/dynamic/dsl/DslCondition;", "getRedDot", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class b {

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
                if ((r5 instanceof b) == true) goto L8;
                return false;
            L8:
                b r6 = (b) r5;
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

            public b() {
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
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Companion.DslRightTextType.values().length];
            r0[Companion.DslRightTextType.FIRMWARE_VERSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[Companion.DslRightTextType.DEVICE_SN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[Companion.DslRightTextType.DEVICE_NAME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[Companion.DslRightTextType.AUTO_STOP_TIME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[Companion.DslRightTextType.VOICE_PRINT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[Companion.DslRightTextType.CASE_VERSION.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
    }

    public GeneralGroupHolder(LarusDoraDeviceInfoGeneraGroupLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2.a);
        this.b = r2;
        this.c = new a59.a();
        this.d = LazyKt.lazy(new r());
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(c59.i r25, e59.b r26, d59.b r27) {
        GeneralGroupHolder r0 = this;
        c59.i r2 = r25;
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r26, "connectionState");
        LarusDoraDeviceInfoGeneraGroupLayoutBinding r3 = r0.b;
        if (r3 == null) goto L167;
        Lazy r4 = c59.s.a;
        Companion.a r5 = (Companion.a) c59.s.c(r2.b, Companion.a.class);
        if (r5 == null) goto L9;
        List<Companion.b> r6 = r5.b();
        if (r6 == null) goto L9;
        List r7 = CollectionsKt.filterNotNull(r6);
    L10:
        List r8 = r7;
        boolean r9 = false;
        if (r8 != null) goto L13;
    L16:
        boolean r10 = true;
    L17:
        if (r10 == true) goto L168;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r7.iterator();
    L20:
        if (r12.hasNext() == false) goto L47;
        Object r13 = r12.next();
        c59.j r14 = ((Companion.b) r13).b();
        if (r27 == null) goto L26;
        z49.b r15 = r27.a;
        if (r15 == null) goto L26;
        String r16 = r15.h();
    L27:
        if (r27 == null) goto L31;
        z49.b r17 = r27.a;
        if (r17 == null) goto L31;
        Integer r18 = r17.f();
    L32:
        if (r27 == null) goto L36;
        z49.b r110 = r27.a;
        if (r110 == null) goto L36;
        String r111 = r110.c();
    L37:
        if (r27 == null) goto L43;
        z49.b r112 = r27.a;
        if (r112 == null) goto L43;
        DoraDevice r113 = r112.a;
        if (r113 == null) goto L43;
        String r114 = r113.caseSoftVersion;
    L45:
        if (c59.p.c(r14, r16, r18, r111, r114) == false) goto L20;
        r11.add(r13);
    L43:
        r114 = null;
    L36:
        r111 = null;
    L31:
        r18 = null;
    L26:
        r16 = null;
        goto L27
    L47:
        if (r27 == null) goto L169;
        final z49.b r1 = r27.a;
        if (r1 == null) goto L170;
        final Context r20 = ((RecyclerView.ViewHolder) r0).itemView.getContext();
        if (r20 != null) goto L53;
        r20 = AppHost.a.getApplication();
    L53:
        LinearLayout r21 = r3.b;
        if (r5 == null) goto L56;
        c59.t r22 = r5.a();
    L57:
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r1, "doraDevice");
        Intrinsics.checkNotNullParameter(r21, "parentViewGroup");
        if (r11.isEmpty() == false) goto L60;
        r21.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        e1.o(r21);
        return;
    L60:
        e1.x(r21);
        int r115 = -1;
        int r116 = -2;
        r21.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r21.removeAllViews();
        int r117 = r11.size();
        r0.c.getClass();
        ItemGroup r118 = a59.a.a(r21);
        Intrinsics.checkNotNullParameter(r1, "doraDevice");
        Intrinsics.checkNotNullParameter(r11, "items");
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r118, "itemGroup");
        final DoraDevice r23 = z49.a.a(r1);
        int r119 = 0;
    L61:
        if (r119 >= r117) goto L153;
        final Companion.b r120 = (Companion.b) ListProtector.get(r11, r119);
        if (r120.c() != Companion.DslGeneralItemType.ITEM_TEXT_TOGGLE) goto L77;
        c59.b r24 = r120.a();
        if (r24 == null) goto L67;
        String r28 = r24.e();
    L69:
        if (Intrinsics.areEqual(r28, "toggle://multi_user_mode") == false) goto L152;
        if (((Boolean) r0.d.getValue()).booleanValue() == false) goto L152;
        a59.a r30 = r0.c;
        c59.t r31 = r120.f();
        if (r31 == null) goto L75;
        String r32 = c59.p.b(r31);
    L76:
        String r33 = String.valueOf(r32);
        r30.getClass();
        Intrinsics.checkNotNullParameter(r118, "group");
        Intrinsics.checkNotNullParameter(r33, "text");
        ItemTextToggle r34 = new ItemTextToggle(r118.getContext());
        r34.setText(r33);
        r34.setTextFontWeight(500);
        r34.setBackgroundResource(2131239210);
        r118.addView(r34);
        ViewGroup.LayoutParams r35 = r34.getLayoutParams();
        Intrinsics.checkNotNull(r35, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r36 = (LinearLayout.LayoutParams) r35;
        r36.width = r115;
        r36.height = r116;
        r34.getToggleView().setChecked(r9);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new GeneralGroupHolder$createChildView$1(r0, r34, null), 3, null);
        r34.getToggleView().setOnCheckedChangeListener(new s());
        goto L152
    L75:
        r32 = null;
    L152:
        r119 = r119 + 1;
        r0 = this;
        r9 = false;
        r115 = -1;
        r116 = -2;
        goto L61
    L67:
        r28 = null;
        goto L69
    L77:
        a59.a r37 = r0.c;
        c59.t r38 = r120.f();
        if (r38 == null) goto L80;
        String r40 = c59.p.b(r38);
    L81:
        String r41 = String.valueOf(r40);
        r37.getClass();
        final ItemTextArrow r42 = a59.a.b(r118, r41);
        c59.b r43 = r120.a();
        if (r43 == null) goto L84;
        DslActionType r44 = r43.getType();
    L86:
        if (r44 == DslActionType.EXTERNAL_JUMP) goto L88;
    L90:
        Companion.DslRightTextType r45 = r120.e();
        if (r45 != null) goto L93;
        int r46 = -1;
    L94:
        String r47 = "";
        switch(r46) {
            case 1: goto L131;
            case 2: goto L127;
            case 3: goto L126;
            case 4: goto L124;
            case 5: goto L101;
            case 6: goto L97;
            default: goto L125;
        };
    L97:
        e1.o(r42.getArrowView());
        String r48 = r1.b();
        if (r48 != null) goto L100;
        r48 = "";
    L100:
        r42.Z5(r48, null);
        goto L125
    L101:
        IDoraService r50 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r50 == null) goto L108;
        DeviceService r51 = r50.device();
        if (r51 == null) goto L108;
        if (r51.n0(ProtocolAbility.FEATURE_OTA3P5) == true) goto L108;
        boolean r52 = true;
    L109:
        if (r52 == true) goto L114;
        DoraSetting.a.getClass();
        int r53 = l0.a;
        if (((Boolean) l0.a(Boolean.TRUE, new x())).booleanValue() == false) goto L114;
        e1.x(r42.getArrowView());
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new GeneralGroupHolder$createChildView$4(r1, r42, null), 3, null);
    L114:
        Function1<? super Boolean, Unit> r54 = PacificInterfaceManager.a;
        String r55 = r1.c();
        if (r55 == null) goto L118;
        r47 = r55;
    L118:
        Intrinsics.checkNotNullParameter(r47, "mac");
        String r56 = PacificInterfaceManager.f(r47);
        if (r56 == null) goto L122;
        r47 = r56;
    L122:
        PacificInterfaceManager.a(r47);
        e1.o(r42);
    L108:
        r52 = false;
        goto L109
    L124:
        e1.x(r42.getArrowView());
        StringBuilder r57 = new StringBuilder();
        b0.a.getClass();
        r57.append(b0.c());
        r57.append('s');
        r42.Z5(r57.toString(), null);
        goto L125
    L126:
        e1.o(r42.getArrowView());
        int r58 = com.larus.dora.impl.util.o.a;
        r42.Z5(com.larus.dora.impl.util.o.b(r1.c(), r1.e()), null);
        List r121 = null;
    L135:
        List<String> r60 = r120.d();
        if (r60 == null) goto L138;
        List r61 = CollectionsKt.filterNotNull(r60);
    L139:
        if (r61 != null) goto L141;
        r61 = CollectionsKt.emptyList();
    L141:
        Iterator r62 = r61.iterator();
    L143:
        if (r62.hasNext() == false) goto L147;
        if (DslRedDotAdapter.a((String) r62.next(), r23) == false) goto L143;
        boolean r63 = true;
    L148:
        if (r63 == false) goto L150;
        r42.i6("");
    L151:
        e1.d(r42, new u(r120, r20, r1, r23));
        goto L152
    L150:
        r42.U5();
        goto L151
    L147:
        r63 = false;
        goto L148
    L138:
        r61 = r121;
        goto L139
    L127:
        e1.o(r42.getArrowView());
        String r64 = r1.h();
        if (r64 != null) goto L130;
        r64 = "";
    L130:
        r42.Z5(r64, null);
        r42.getSubTextView().post(new t(r42));
        goto L125
    L131:
        e1.o(r42.getArrowView());
        String r65 = r1.i();
        if (r65 != null) goto L134;
        r65 = "";
    L134:
        r121 = null;
        r42.Z5(r65, null);
    L125:
        r121 = null;
        goto L135
    L93:
        r46 = a.a[r45.ordinal()];
        goto L94
    L88:
        if (r120.e() != Companion.DslRightTextType.GO_SMART_AUDIO) goto L90;
        e1.o(r42.getArrowView());
        int r122 = j0.a;
        SpannableString r66 = new SpannableString(j0.d(2131903840));
        r66.setSpan(new ForegroundColorSpan(r20.getResources().getColor(2131105539)), 0, r66.length(), 18);
        r42.Z5(r66, null);
        goto L90
    L84:
        r44 = null;
        goto L86
    L80:
        r40 = null;
        goto L81
    L153:
        if (r22 == null) goto L172;
        String r67 = String.valueOf(c59.p.b(r22));
        AppCompatTextView r68 = new AppCompatTextView(r20);
        LinearLayout.LayoutParams r70 = new LinearLayout.LayoutParams(-1, -2);
        Resources r71 = r20.getResources();
        int r72 = r71.getDimensionPixelSize(2131165925);
        r70.setMargins(r72, r71.getDimensionPixelSize(2131166264), r72, 0);
        r68.setLayoutParams(r70);
        r68.setText(r67);
        r68.setTextAlignment(5);
        r68.setTextColor(ContextCompat.getColor(r20, 2131103683));
        r68.setTextSize(r71.getDimension(2131168243) / WindowDisplayMetricsOverride.apply(r71, r71.getDisplayMetrics()).scaledDensity);
        r21.addView(r68);
        return;
    L172:
        return;
    L56:
        r22 = null;
        goto L57
    L170:
        return;
    L169:
        return;
    L168:
        return;
    L13:
        if (r8.isEmpty() == true) goto L16;
        r10 = false;
    L9:
        r7 = null;
        goto L10
    }
}
