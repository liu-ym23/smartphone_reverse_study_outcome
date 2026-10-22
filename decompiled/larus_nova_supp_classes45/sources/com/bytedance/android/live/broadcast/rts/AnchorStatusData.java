package com.bytedance.android.live.broadcast.rts;

import com.bytedance.rts.foundation.RTSJSONObject;
import com.bytedance.rts.foundation.RTSSerializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016R.\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/broadcast/rts/AnchorStatusData;", "Lcom/bytedance/rts/foundation/RTSSerializable;", "JSONObject", "Lcom/bytedance/rts/foundation/RTSJSONObject;", "JSONString", "", "(Lcom/bytedance/rts/foundation/RTSJSONObject;Ljava/lang/String;)V", "suggestList", "Ljava/util/ArrayList;", "Lcom/bytedance/android/live/broadcast/rts/AnchorStatusRealtimeSuggest;", "Lcom/bytedance/rts/foundation/RTSArray;", "getSuggestList", "()Ljava/util/ArrayList;", "setSuggestList", "(Ljava/util/ArrayList;)V", "tabLists", "Lcom/bytedance/android/live/broadcast/rts/AnchorStatusTab;", "getTabLists", "setTabLists", "mapping", "", "map", "Lorg/json/JSONObject;", "Lcom/bytedance/rts/foundation/RTSJSONMap;", "unmapping", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorStatusData extends RTSSerializable {
    private ArrayList<AnchorStatusRealtimeSuggest> suggestList;
    private ArrayList<AnchorStatusTab> tabLists;

    public void unmapping() {
        super.unmapping();
        ArrayList<AnchorStatusTab> r0 = this.tabLists;
        if (r0 == null) goto L5;
        getEncodeData().put("tab_list", r0);
    L5:
        ArrayList<AnchorStatusRealtimeSuggest> r1 = this.suggestList;
        if (r1 == null) goto L9;
        getEncodeData().put("suggest_list", r1);
        return;
    }

    public final ArrayList<AnchorStatusRealtimeSuggest> getSuggestList() {
        return this.suggestList;
    }

    public final ArrayList<AnchorStatusTab> getTabLists() {
        return this.tabLists;
    }

    public void mapping(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        super.mapping(r5);
        Object r0 = optMapList(1, r5.opt("tab_list"), AnonymousClass1.INSTANCE);
        Object r3 = null;
        if ((r0 instanceof ArrayList) == true) goto L5;
        r0 = null;
    L5:
        ArrayList<AnchorStatusTab> r1 = (ArrayList) r0;
        if (r1 != null) goto L8;
        r1 = this.tabLists;
    L8:
        this.tabLists = r1;
        Object r6 = optMapList(1, r5.opt("suggest_list"), AnonymousClass2.INSTANCE);
        if ((r6 instanceof ArrayList) == false) goto L12;
        r3 = r6;
    L12:
        ArrayList<AnchorStatusRealtimeSuggest> r4 = (ArrayList) r3;
        if (r4 != null) goto L15;
        r4 = this.suggestList;
    L15:
        this.suggestList = r4;
    }

    public final void setSuggestList(ArrayList<AnchorStatusRealtimeSuggest> r1) {
        this.suggestList = r1;
    }

    public final void setTabLists(ArrayList<AnchorStatusTab> r1) {
        this.tabLists = r1;
    }

    public AnchorStatusData(RTSJSONObject r1, String r2) {
        super(r1, r2);
        if (r1 != null) goto L7;
        if (r2 != null) goto L7;
        doInit(false);
        return;
    L7:
        doInit(true);
    }

    public /* synthetic */ AnchorStatusData(RTSJSONObject r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
