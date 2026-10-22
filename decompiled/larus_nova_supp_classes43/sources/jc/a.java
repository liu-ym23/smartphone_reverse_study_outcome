package jc;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.d;
import com.bytedance.android.btm.api.model.l;
import java.util.List;
import java.util.Map;
import kc.b;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements b {
    public static final a a = null;

    public a() {
    }

    public final void appendPageParams(PageFinder r1, String r10, BcmParams r11) {
    }

    public final void appendUnitParams(PageFinder r1, String r10, BcmParams r11) {
    }

    public final void configBusiness(String r1, b r10) {
    }

    public final kc.a getBcmChainByBtmModel(d r1, List<String> r10, int r11, boolean r12) {
        return null;
    }

    public final kc.a getBcmChainByFinder(PageFinder r1, List<String> r10, int r11, boolean r12) {
        return null;
    }

    public final kc.a getBcmChainByToken(String r1, List<String> r10, int r11, boolean r12) {
        return null;
    }

    public final void init() {
    }

    public final void registerExtraChecker(kc.d r1) {
    }

    public final void setBcmPageParams(PageFinder r1, BcmParams r10, boolean r11) {
    }

    public final boolean setBcmParams(PageFinder r1, Map<String, ? extends Object> r10) {
        return false;
    }

    public final boolean setBcmParamsV2(PageFinder r1, Map<String, ? extends Object> r10) {
        return false;
    }

    public final void setPageEventParams(PageFinder r1, Map<String, ? extends Object> r10) {
    }

    public final void setPageParams(PageFinder r1, String r10, BcmParams r11) {
    }

    public final void setUnitParams(PageFinder r1, String r10, BcmParams r11) {
    }

    public final void setUnitParamsV2(PageFinder r1, Map<String, ? extends Object> r10) {
    }

    static {
        a = new a();
    }

    public final Map<String, Object> getBcmPassThroughMap(l r1) {
        return MapsKt.emptyMap();
    }
}
