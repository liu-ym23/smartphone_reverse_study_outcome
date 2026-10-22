package com.zte.miboard.cards.travel.data;

import ai.j0;
import androidx.annotation.NonNull;
import com.zte.miboard.cards.travel.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class IntelligentAgentData {
    public Object changeFromObj;
    public String dataKey;
    public String eventType;
    public ArrayList<Object> forceObjList;
    public Object travelDataObj;

    public IntelligentAgentData() {
    }

    public boolean isAvailable() {
        if (b.b(this.dataKey) == true) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == true) goto L10;
    L15:
        if (r5 == true) goto L17;
    L22:
        if (r5 == false) goto L29;
        if (b.e(this.eventType) == false) goto L29;
        if (this.forceObjList != null) goto L31;
        return false;
    L31:
        return true;
    L29:
        return r5;
    L17:
        if (b.d(this.eventType) == false) goto L22;
        if (this.changeFromObj == null) goto L21;
        r5 = true;
        goto L22
    L21:
        r5 = false;
        goto L22
    L10:
        if (b.e(this.eventType) == true) goto L15;
        if (this.travelDataObj == null) goto L14;
        r5 = true;
        goto L15
    L14:
        r5 = false;
        goto L15
    L5:
        if (b.c(this.eventType) == false) goto L7;
        r5 = true;
        goto L8
    }

    @NonNull
    public String toString() {
        StringBuilder r5 = new StringBuilder("IntelligentAgentData{dataKey=");
        r5.append(this.dataKey);
        r5.append(", eventType=");
        r5.append(this.eventType);
        r5.append(", travelDataObj=");
        r5.append(this.travelDataObj);
        String r10 = "";
        if (this.changeFromObj == null) goto L5;
        String r11 = ", changeFromObj=" + this.changeFromObj;
    L6:
        r5.append(r11);
        if (this.forceObjList == null) goto L10;
        r10 = ", forceObjList=" + this.forceObjList.size();
    L10:
        return j0.q(r5, r10, "}");
    L5:
        r11 = "";
        goto L6
    }
}
