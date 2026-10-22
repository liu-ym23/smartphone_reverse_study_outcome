package com.zte.miboard.cards.express.data;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class LimitedResultBean {
    private ArrayList<ExpressNode> data;
    private String message;
    private int result;
    public String sfSubscribeMessage;
    public int sfSubscribeResult;
    private HashMap<String, ArrayList<String>> statusMap;

    public LimitedResultBean() {
        this.result = 0;
        this.sfSubscribeResult = -1;
        this.data = null;
    }

    public ArrayList<ExpressNode> getData() {
        return this.data;
    }

    @Nullable
    public HashMap<String, ArrayList<String>> getStatusMap() {
        return this.statusMap;
    }

    public boolean isAvailable() {
        if (this.result == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.data == null) goto L7;
        return true;
    }

    public boolean isSFSubscribeResultOk() {
        if (this.sfSubscribeResult != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("BindLimitedResultBean{result=");
        r5.append(this.result);
        r5.append(", message=");
        r5.append(this.message);
        r5.append(" data=");
        ArrayList<ExpressNode> r10 = this.data;
        if (r10 == null) goto L5;
        Integer r11 = Integer.valueOf(r10.size());
    L6:
        r5.append(r11);
        r5.append("}");
        return r5.toString();
    L5:
        r11 = null;
        goto L6
    }
}
