package com.ss.android.lark.officesdk.api.plugin;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "NOT_INSTALLED", "INSTALLED", "LOADED", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum OfficeSDKPluginState extends Enum<OfficeSDKPluginState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OfficeSDKPluginState[] $VALUES = null;
    public static final OfficeSDKPluginState INSTALLED = null;
    public static final OfficeSDKPluginState LOADED = null;
    public static final OfficeSDKPluginState NOT_INSTALLED = null;
    public static final OfficeSDKPluginState UNKNOWN = null;

    private static final /* synthetic */ OfficeSDKPluginState[] $values() {
        return new OfficeSDKPluginState[]{UNKNOWN, NOT_INSTALLED, INSTALLED, LOADED};
    }

    public static EnumEntries<OfficeSDKPluginState> getEntries() {
        return $ENTRIES;
    }

    static {
        UNKNOWN = new OfficeSDKPluginState("UNKNOWN", 0);
        NOT_INSTALLED = new OfficeSDKPluginState("NOT_INSTALLED", 1);
        INSTALLED = new OfficeSDKPluginState("INSTALLED", 2);
        LOADED = new OfficeSDKPluginState("LOADED", 3);
        OfficeSDKPluginState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static OfficeSDKPluginState[] values() {
        return (OfficeSDKPluginState[]) $VALUES.clone();
    }

    public static OfficeSDKPluginState valueOf(String r1) {
        return (OfficeSDKPluginState) a.a(OfficeSDKPluginState.class, r1);
    }

    private OfficeSDKPluginState(String r1, int r2) {
        super(r1, r2);
    }
}
