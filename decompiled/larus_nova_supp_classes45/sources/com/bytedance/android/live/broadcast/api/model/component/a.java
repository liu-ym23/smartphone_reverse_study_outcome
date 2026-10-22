package com.bytedance.android.live.broadcast.api.model.component;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.AIAgentEntranceInfo")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/component/a;", "", "", "agentSchema", "Ljava/lang/String;", "agentHighlightSchema", "agentEntranceContent", "agentTipContent", "", "agentTipRemoveInterval", "Ljava/lang/Integer;", "", "fillPoint", "Ljava/util/Map;", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("agent_entrance_content")
    public String agentEntranceContent;

    @SerializedName("agent_highlight_schema")
    public String agentHighlightSchema;

    @SerializedName("agent_schema")
    public String agentSchema;

    @SerializedName("agent_tip_content")
    public String agentTipContent;

    @SerializedName("agent_tip_remove_interval")
    public Integer agentTipRemoveInterval;

    @SerializedName("fill_point")
    public Map<String, String> fillPoint;

    public a() {
    }

    public a(g r11) {
        this.fillPoint = new HashMap();
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L30;
        switch(r2) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        long r4 = r11.c();
        String r3 = null;
        String r6 = null;
    L8:
        int r7 = r11.f();
        if (r7 == (-1)) goto L17;
        if (r7 != 1) goto L13;
        r3 = am3.h.c(r11);
        goto L8
    L13:
        if (r7 != 2) goto L14;
        r6 = am3.h.c(r11);
        goto L8
    L14:
        am3.h.e(r11);
        goto L8
    L17:
        r11.d(r4);
        Map<String, String> r5 = this.fillPoint;
        if (r3 == null) goto L24;
        if (r6 == null) goto L22;
        r5.put(r3, r6);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this.agentTipRemoveInterval = Integer.valueOf(r11.i());
        goto L3
    L26:
        this.agentTipContent = am3.h.c(r11);
        goto L3
    L27:
        this.agentEntranceContent = am3.h.c(r11);
        goto L3
    L28:
        this.agentHighlightSchema = am3.h.c(r11);
        goto L3
    L29:
        this.agentSchema = am3.h.c(r11);
        goto L3
    L6:
        am3.h.e(r11);
        goto L3
    L30:
        r11.d(r0);
    }
}
