package com.bytedance.android.ec.common.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/common/api/NewPromotionListItemModuleName;", "", "", "moduleName", "Ljava/lang/String;", "getModuleName", "()Ljava/lang/String;", "INFO_AREA", "BOTTOM_AREA", "EXPLAIN_PLAYBACK_OR_REQUEST_EXPLAIN_INFO", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum NewPromotionListItemModuleName extends Enum<NewPromotionListItemModuleName> {
    public static final NewPromotionListItemModuleName BOTTOM_AREA = null;
    public static final NewPromotionListItemModuleName EXPLAIN_PLAYBACK_OR_REQUEST_EXPLAIN_INFO = null;
    public static final NewPromotionListItemModuleName INFO_AREA = null;
    public static final /* synthetic */ NewPromotionListItemModuleName[] a = null;
    private final String moduleName;

    static {
        NewPromotionListItemModuleName r1 = new NewPromotionListItemModuleName("INFO_AREA", 0, "InfoArea");
        INFO_AREA = r1;
        NewPromotionListItemModuleName r10 = new NewPromotionListItemModuleName("BOTTOM_AREA", 1, "BottomArea");
        BOTTOM_AREA = r10;
        NewPromotionListItemModuleName r11 = new NewPromotionListItemModuleName("EXPLAIN_PLAYBACK_OR_REQUEST_EXPLAIN_INFO", 2, "ExplainPlaybackOrRequestExplainInfo");
        EXPLAIN_PLAYBACK_OR_REQUEST_EXPLAIN_INFO = r11;
        a = new NewPromotionListItemModuleName[]{r1, r10, r11};
    }

    public static NewPromotionListItemModuleName valueOf(String r1) {
        return (NewPromotionListItemModuleName) a.a(NewPromotionListItemModuleName.class, r1);
    }

    public static NewPromotionListItemModuleName[] values() {
        return (NewPromotionListItemModuleName[]) a.clone();
    }

    public final String getModuleName() {
        return this.moduleName;
    }

    public NewPromotionListItemModuleName(String r1, int r10, String r11) {
        super(r1, r10);
        this.moduleName = r11;
    }
}
