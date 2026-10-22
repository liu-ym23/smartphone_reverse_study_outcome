package com.bytedance.android.bcm.impl.model;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.page.model.i;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import kc.c;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001-B\u0007¢\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0000H\u0016J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\nH\u0016J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0010\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R0\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R2\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00118F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006."}, d2 = {"Lcom/bytedance/android/bcm/impl/model/BcmPageInfo;", "Lcom/bytedance/android/btm/impl/page/model/PageInfo;", "Ljava/io/Serializable;", "copy", "", AIStateLogRequest.SOURCE_PAGE, "Lcom/bytedance/android/btm/impl/page/model/i;", "pausedInfo", "", "onPause", "", "save", "data", "parse", "Lkc/c;", "snapshot", "setPageParamsByProvider", "", "Lcom/bytedance/android/bcm/api/model/BcmParams;", "f", "Ljava/util/Map;", "getPageParams", "()Ljava/util/Map;", "setPageParams", "(Ljava/util/Map;)V", "pageParams", "g", "getUnitParams", "setUnitParams", "unitParams", "h", "getEventParams", "setEventParams", "eventParams", "Lcom/bytedance/android/bcm/api/provider/a;", "i", "Lcom/bytedance/android/bcm/api/provider/a;", "getPageParamsProvider", "()Lcom/bytedance/android/bcm/api/provider/a;", "setPageParamsProvider", "(Lcom/bytedance/android/bcm/api/provider/a;)V", "pageParamsProvider", "<init>", "()V", "Companion", "a", "bcm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class BcmPageInfo extends PageInfo {
    public static final a Companion = null;
    private static final long serialVersionUID = 20220211;
    public transient Map<String, BcmParams> f;
    public transient Map<String, BcmParams> g;
    public transient Map<String, Object> h;
    public transient com.bytedance.android.bcm.api.provider.a i;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.btm.impl.page.model.PageInfo
    public BcmPageInfo copy() {
        c r0 = c.a;
        BcmPageInfo r1 = new BcmPageInfo();
        super.copy(r1);
        r1.f = getPageParams();
        r1.g = getUnitParams();
        r1.h = getEventParams();
        return r1;
    }

    public final Map<String, Object> getEventParams() {
        if (this.h != null) goto L6;
        this.h = new LinkedHashMap();
    L6:
        return this.h;
    }

    public final Map<String, BcmParams> getPageParams() {
        if (this.f != null) goto L6;
        this.f = new LinkedHashMap();
    L6:
        return this.f;
    }

    public final Map<String, BcmParams> getUnitParams() {
        if (this.g != null) goto L6;
        this.g = new LinkedHashMap();
    L6:
        return this.g;
    }

    public final c snapshot() {
        c r0 = new c(getPageParams(), getUnitParams());
        getClassSimpleName();
        return r0;
    }

    @Override // com.bytedance.android.btm.impl.page.model.PageInfo
    public String save() {
        return super.save();
    }

    public BcmPageInfo() {
    }

    public final com.bytedance.android.bcm.api.provider.a getPageParamsProvider() {
        return this.i;
    }

    @Override // com.bytedance.android.btm.impl.page.model.PageInfo
    public /* bridge */ /* synthetic */ PageInfo copy() {
        return copy();
    }

    @Override // com.bytedance.android.btm.impl.page.model.PageInfo
    public PageInfo parse(String r1) {
        return super.parse(r1);
    }

    public final void setEventParams(Map<String, Object> r1) {
        this.h = r1;
    }

    public final void setPageParams(Map<String, BcmParams> r1) {
        this.f = r1;
    }

    public final void setPageParamsByProvider(Object r10) {
        com.bytedance.android.bcm.api.provider.a r0 = this.i;
        com.bytedance.android.bcm.api.provider.a r1 = r0;
        if (r0 == null) goto L6;
    L9:
        if (r1 == null) goto L27;
        getPageBtm();
        if (getPageParams() != null) goto L14;
        new LinkedHashMap();
    L14:
        Map r11 = r1.a();
        if (BtmSetting.d.c().b().F() == 1) goto L17;
        this.f = MapsKt.toMutableMap(r11);
    L25:
        ALogger.d.a("BcmPageInfo_setPageParamsByProvider", false, new BcmPageInfo$setPageParamsByProvider$$inlined$let$lambda$1(this));
        return;
    L17:
        if (r11 == getPageParams()) goto L25;
        Map<String, BcmParams> r12 = getPageParams();
        if (r12 == null) goto L21;
        r12.clear();
    L21:
        Map<String, BcmParams> r13 = getPageParams();
        if (r13 == null) goto L25;
        r13.putAll(r11);
        goto L25
    L27:
        return;
    L6:
        if ((r10 instanceof com.bytedance.android.bcm.api.provider.a) == true) goto L8;
        r10 = null;
    L8:
        r1 = (com.bytedance.android.bcm.api.provider.a) r10;
        goto L9
    }

    public final void setPageParamsProvider(com.bytedance.android.bcm.api.provider.a r1) {
        this.i = r1;
    }

    public final void setUnitParams(Map<String, BcmParams> r1) {
        this.g = r1;
    }

    @Override // com.bytedance.android.btm.impl.page.model.PageInfo
    /* JADX INFO: renamed from: parse, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo505parse(String r1) {
        return parse(r1);
    }

    @Override // com.bytedance.android.btm.impl.page.model.PageInfo
    public void onPause(Object r10, i r11) {
        if (BtmSetting.d.c().b().G() != 1) goto L5;
        setPageParamsByProvider(r10);
    L5:
        super.onPause(r10, r11);
    }
}
