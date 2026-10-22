package com.ss.android.lark.officesdk.api.plugin;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginStage;", "", "<init>", "(Ljava/lang/String;I)V", "QUERY", "INSTALL", "LOAD", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum OfficeSDKPluginStage extends Enum<OfficeSDKPluginStage> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OfficeSDKPluginStage[] $VALUES = null;
    public static final OfficeSDKPluginStage INSTALL = null;
    public static final OfficeSDKPluginStage LOAD = null;
    public static final OfficeSDKPluginStage QUERY = null;

    private static final /* synthetic */ OfficeSDKPluginStage[] $values() {
        return new OfficeSDKPluginStage[]{QUERY, INSTALL, LOAD};
    }

    public static EnumEntries<OfficeSDKPluginStage> getEntries() {
        return $ENTRIES;
    }

    static {
        QUERY = new OfficeSDKPluginStage("QUERY", 0);
        INSTALL = new OfficeSDKPluginStage("INSTALL", 1);
        LOAD = new OfficeSDKPluginStage("LOAD", 2);
        OfficeSDKPluginStage[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static OfficeSDKPluginStage[] values() {
        return (OfficeSDKPluginStage[]) $VALUES.clone();
    }

    public static OfficeSDKPluginStage valueOf(String r1) {
        return (OfficeSDKPluginStage) a.a(OfficeSDKPluginStage.class, r1);
    }

    private OfficeSDKPluginStage(String r1, int r2) {
        super(r1, r2);
    }
}
