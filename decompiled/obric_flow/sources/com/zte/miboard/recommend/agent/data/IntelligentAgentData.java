package com.zte.miboard.recommend.agent.data;

import ai.j0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class IntelligentAgentData {
    public Object changeFromObj;
    public String dataKey;
    public String eventType;
    public ArrayList<Object> forceObjList;
    public Object travelDataObj;

    public IntelligentAgentData(String r5, String r10, Object r11) {
        this.dataKey = r5;
        this.eventType = r10;
        this.travelDataObj = r11;
    }

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

    public IntelligentAgentData(String r5, String r10, Object r11, Object r12) {
        this.dataKey = r5;
        this.eventType = r10;
        this.travelDataObj = r11;
        this.changeFromObj = r12;
    }

    public IntelligentAgentData(String r5, String r10, Object r11, Object r12, ArrayList<Object> r13) {
        this.dataKey = r5;
        this.eventType = r10;
        this.travelDataObj = r11;
        this.changeFromObj = r12;
        this.forceObjList = r13;
    }
}
