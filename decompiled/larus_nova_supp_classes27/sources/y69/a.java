package y69;

import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import g49.d;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tabName");
        d.d("DoraObricDeviceManagementTracker", "reportPageClick: tabName=".concat(r2));
        DoraBuryPointManager.a.L("dora_page_click", MapsKt.mapOf(TuplesKt.to("tab_name", r2)));
    }

    public static void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "cardContentType");
        d.d("DoraObricDeviceManagementTracker", "reportQuickAccessClick: cardContentType=".concat(r4));
        DoraBuryPointManager.a.L("dora_card_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("card_type", "quick_access"), TuplesKt.to("card_content_type", r4)}));
    }

    public static void a(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "currentPage");
        if (r4 != null) goto L5;
        r4 = DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON;
    L22:
        d.d("DoraObricDeviceManagementTracker", "reportEnterPage: currentPage=" + r2 + ", previousPage=" + r3 + ", enterMethod=" + r4);
        boolean r1 = false;
        Map r5 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("current_page", r2), TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, r4)});
        if (r3 != null) goto L25;
    L32:
        DoraBuryPointManager.a.L("enter_page", r5);
        return;
    L25:
        if (r3.length() <= 0) goto L27;
        r1 = true;
    L27:
        if (r1 == true) goto L30;
        r3 = null;
    L30:
        if (r3 == null) goto L32;
        r5.put(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r3);
        goto L32
    L5:
        switch(r4.hashCode()) {
            case -1964724130: goto L20;
            case -777231152: goto L17;
            case 107944136: goto L14;
            case 221550025: goto L11;
            case 1661180868: goto L8;
            default: goto L36;
        };
    L36:
        r4 = DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON;
        goto L22
    L8:
        if (r4.equals("auto_play") == true) goto L22;
        r4 = DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON;
        goto L22
    L11:
        if (r4.equals(DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON) == true) goto L22;
        r4 = DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON;
        goto L22
    L14:
        if (r4.equals("query") == true) goto L22;
        r4 = DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON;
        goto L22
    L17:
        if (r4.equals("click_icon") == true) goto L22;
        r4 = DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON;
        goto L22
    L20:
        if (r4.equals("click_tab") == true) goto L22;
        r4 = DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON;
        goto L22
    }
}
