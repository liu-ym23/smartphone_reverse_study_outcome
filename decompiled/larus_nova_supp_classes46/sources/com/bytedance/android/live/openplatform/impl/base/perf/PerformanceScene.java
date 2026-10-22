package com.bytedance.android.live.openplatform.impl.base.perf;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/perf/PerformanceScene;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "UNKNOWN", "CHOOSE_PAGE", "CHOOSE_PAGE_LIST", "CHOOSE_PAGE_LYNX", "SHELF_MANAGEMENT_PAGE", "SHELF_DIALOG", "EXPLAIN_CARD_SETTING_DIALOG", "MINI_APP_CONTEXT", "SHELF_REQUEST", "SNOW_FLAKE", "EXPLAIN_CARD", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PerformanceScene extends Enum<PerformanceScene> {
    public static final PerformanceScene CHOOSE_PAGE = null;
    public static final PerformanceScene CHOOSE_PAGE_LIST = null;
    public static final PerformanceScene CHOOSE_PAGE_LYNX = null;
    public static final PerformanceScene EXPLAIN_CARD = null;
    public static final PerformanceScene EXPLAIN_CARD_SETTING_DIALOG = null;
    public static final PerformanceScene MINI_APP_CONTEXT = null;
    public static final PerformanceScene SHELF_DIALOG = null;
    public static final PerformanceScene SHELF_MANAGEMENT_PAGE = null;
    public static final PerformanceScene SHELF_REQUEST = null;
    public static final PerformanceScene SNOW_FLAKE = null;
    public static final PerformanceScene UNKNOWN = null;
    public static final /* synthetic */ PerformanceScene[] a = null;
    private final String value;

    public static PerformanceScene valueOf(String r1) {
        return (PerformanceScene) a.a(PerformanceScene.class, r1);
    }

    public static PerformanceScene[] values() {
        return (PerformanceScene[]) a.clone();
    }

    static {
        PerformanceScene r1 = new PerformanceScene("UNKNOWN", 0, "unknown");
        UNKNOWN = r1;
        PerformanceScene r2 = new PerformanceScene("CHOOSE_PAGE", 1, "open_choose_page");
        CHOOSE_PAGE = r2;
        PerformanceScene r3 = new PerformanceScene("CHOOSE_PAGE_LIST", 2, "open_choose_page_list");
        CHOOSE_PAGE_LIST = r3;
        PerformanceScene r4 = new PerformanceScene("CHOOSE_PAGE_LYNX", 3, "open_choose_page_lynx");
        CHOOSE_PAGE_LYNX = r4;
        PerformanceScene r5 = new PerformanceScene("SHELF_MANAGEMENT_PAGE", 4, "open_shelf_management_page");
        SHELF_MANAGEMENT_PAGE = r5;
        PerformanceScene r6 = new PerformanceScene("SHELF_DIALOG", 5, "shelf_dialog");
        SHELF_DIALOG = r6;
        PerformanceScene r7 = new PerformanceScene("EXPLAIN_CARD_SETTING_DIALOG", 6, "explain_card_setting_dialog");
        EXPLAIN_CARD_SETTING_DIALOG = r7;
        PerformanceScene r8 = new PerformanceScene("MINI_APP_CONTEXT", 7, "mini_app_context");
        MINI_APP_CONTEXT = r8;
        PerformanceScene r9 = new PerformanceScene("SHELF_REQUEST", 8, "shelf_request");
        SHELF_REQUEST = r9;
        PerformanceScene r10 = new PerformanceScene("SNOW_FLAKE", 9, "snow_icon");
        SNOW_FLAKE = r10;
        PerformanceScene r11 = new PerformanceScene("EXPLAIN_CARD", 10, "explain_card");
        EXPLAIN_CARD = r11;
        a = new PerformanceScene[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
    }

    public final String getValue() {
        return this.value;
    }

    public PerformanceScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
