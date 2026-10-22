package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.stamp.InteractEntranceResponse.Data")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0005R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0005R\u0016\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/p;", "", "", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell;", "entranceList", "Ljava/util/List;", "", "", "Lcom/bytedance/android/live/broadcastgame/api/model/j;", "groupProperty", "Ljava/util/Map;", "groupOrder", "tabOrder", "", "noUpdate", "Z", "", "hash", "Ljava/lang/String;", "selectedGroup", "J", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p implements vh7.h {

    @SerializedName("entrance_list")
    public List<InteractEntranceCell> entranceList;

    @SerializedName("group_order")
    public List<Long> groupOrder;

    @SerializedName("group_properties")
    public Map<Long, j> groupProperty;

    @SerializedName("hash")
    public String hash;

    @SerializedName("no_update")
    public boolean noUpdate;

    @SerializedName("selected_group")
    public long selectedGroup;

    @SerializedName("tab_order")
    public List<Long> tabOrder;

    public p() {
        this.entranceList = new ArrayList();
        this.groupProperty = new LinkedHashMap();
        this.groupOrder = new ArrayList();
        this.tabOrder = new ArrayList();
        this.noUpdate = false;
        this.hash = "";
        this.selectedGroup = 0;
    }

    public p(am3.g r13) {
        this.entranceList = new ArrayList();
        this.groupProperty = new HashMap();
        this.groupOrder = new ArrayList();
        this.tabOrder = new ArrayList();
        long r0 = r13.c();
        int r3 = 0;
    L3:
        int r4 = r13.f();
        if (r4 == (-1)) goto L32;
        switch(r4) {
            case 1: goto L30;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L6;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.selectedGroup = r13.j();
        r3 = r3 | 2;
        goto L3
    L8:
        this.hash = am3.h.c(r13);
        goto L3
    L9:
        this.noUpdate = am3.h.a(r13);
        r3 = r3 | 1;
        goto L3
    L10:
        List r5 = this.tabOrder;
    L12:
        vh7.h r6 = Long.valueOf(r13.j());
    L31:
        r5.add(r6);
        goto L3
    L11:
        r5 = this.groupOrder;
        goto L12
    L13:
        long r7 = r13.c();
        Long r8 = null;
        j r9 = null;
    L14:
        int r11 = r13.f();
        if (r11 == (-1)) goto L22;
        if (r11 != 1) goto L18;
        r8 = Long.valueOf(r13.j());
        goto L14
    L18:
        if (r11 != 2) goto L19;
        r9 = new j(r13);
        goto L14
    L19:
        am3.h.e(r13);
        goto L14
    L22:
        r13.d(r7);
        Map<Long, j> r12 = this.groupProperty;
        if (r8 == null) goto L29;
        if (r9 == null) goto L27;
        r12.put(r8, r9);
        goto L3
    L27:
        throw new IllegalStateException("Value must not be null");
    L29:
        throw new IllegalStateException("Key must not be null");
    L30:
        r5 = this.entranceList;
        r6 = new InteractEntranceCell(r13);
        goto L31
    L6:
        am3.h.e(r13);
        goto L3
    L32:
        r13.d(r0);
        if (this.entranceList.isEmpty() == false) goto L36;
        this.entranceList = new ArrayList();
    L36:
        if (this.groupProperty != null) goto L39;
        this.groupProperty = new LinkedHashMap();
    L39:
        if (this.groupOrder.isEmpty() == false) goto L42;
        this.groupOrder = new ArrayList();
    L42:
        if (this.tabOrder.isEmpty() == false) goto L45;
        this.tabOrder = new ArrayList();
    L45:
        if ((r3 & 1) != 0) goto L48;
        this.noUpdate = false;
    L48:
        if (this.hash != null) goto L51;
        this.hash = "";
    L51:
        if ((r3 & 2) != 0) goto L81;
        this.selectedGroup = 0;
        return;
    }
}
