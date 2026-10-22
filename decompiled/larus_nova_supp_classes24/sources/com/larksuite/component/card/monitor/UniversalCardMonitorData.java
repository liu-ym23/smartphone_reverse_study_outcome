package com.larksuite.component.card.monitor;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/larksuite/component/card/monitor/UniversalCardMonitorData;", "Ljava/io/Serializable;", "businessType", "", "scene", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBusinessType", "()Ljava/lang/String;", "getScene", "getMonitorCategoryMap", "", "", "getBusinessMonitorMap", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UniversalCardMonitorData implements Serializable {
    private final String businessType;
    private final String scene;

    public Map<String, Object> getBusinessMonitorMap() {
        HashMap r0 = new HashMap();
        String r1 = this.businessType;
        if (r1 == null) goto L5;
        r0.put("scene", r1);
    L5:
        return r0;
    }

    public Map<String, Object> getMonitorCategoryMap() {
        HashMap r0 = new HashMap();
        String r1 = this.businessType;
        if (r1 == null) goto L5;
        r0.put("render_business_type", r1);
    L5:
        String r2 = this.scene;
        if (r2 == null) goto L8;
        r0.put("scene", r2);
    L8:
        return r0;
    }

    public final String getBusinessType() {
        return this.businessType;
    }

    public final String getScene() {
        return this.scene;
    }

    public UniversalCardMonitorData(String r1, String r2) {
        this.businessType = r1;
        this.scene = r2;
    }
}
