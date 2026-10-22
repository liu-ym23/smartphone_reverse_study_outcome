package com.ss.android.lark.message.universalcard;

import com.larksuite.component.card.monitor.UniversalCardMonitorData;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/message/universalcard/MessageCardCardMonitorData;", "Lcom/larksuite/component/card/monitor/UniversalCardMonitorData;", "businessType", "", "scene", "botId", "appId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBotId", "()Ljava/lang/String;", "getAppId", "getMonitorCategoryMap", "", "", "getBusinessMonitorMap", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MessageCardCardMonitorData extends UniversalCardMonitorData {
    private final String appId;
    private final String botId;

    public Map<String, Object> getBusinessMonitorMap() {
        Map<String, Object> r0 = MapsKt.toMutableMap(super.getBusinessMonitorMap());
        String r1 = this.appId;
        if (r1 == null) goto L5;
        r0.put("application_id", r1);
    L5:
        return r0;
    }

    public Map<String, Object> getMonitorCategoryMap() {
        Map<String, Object> r0 = MapsKt.toMutableMap(super.getMonitorCategoryMap());
        String r1 = this.botId;
        if (r1 == null) goto L5;
        r0.put("bot_id", r1);
    L5:
        String r2 = this.appId;
        if (r2 == null) goto L8;
        r0.put("app_id", r2);
    L8:
        return r0;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getBotId() {
        return this.botId;
    }

    public MessageCardCardMonitorData(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "businessType");
        Intrinsics.checkNotNullParameter(r3, "scene");
        super(r2, r3);
        this.botId = r4;
        this.appId = r5;
    }
}
