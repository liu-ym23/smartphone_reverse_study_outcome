package com.zte.miboard.cards.express.data;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class MoreResultData {
    public static final HashMap<String, Integer> STATUS_MAP_KEY_WORDING_MAP = null;
    private ArrayList<ExpressNode> recentSign;
    private ArrayList<ExpressNode> sign;
    private ArrayList<ExpressNode> toTake;
    private ArrayList<ExpressNode> unsign;

    static {
        STATUS_MAP_KEY_WORDING_MAP = new AnonymousClass1();
    }

    public MoreResultData() {
        this.toTake = new ArrayList();
        this.unsign = new ArrayList();
        this.recentSign = new ArrayList();
        this.sign = new ArrayList();
    }

    public ArrayList<ExpressNode> getRecentSign() {
        return this.recentSign;
    }

    public ArrayList<ExpressNode> getSign() {
        return this.sign;
    }

    public ArrayList<ExpressNode> getToTake() {
        return this.toTake;
    }

    public ArrayList<ExpressNode> getUnsign() {
        return this.unsign;
    }

    public void removeExpressNode(ExpressNode r5) {
        ArrayList<ExpressNode> r10 = this.toTake;
        if (r10 == null) goto L5;
        r10.remove(r5);
    L5:
        ArrayList<ExpressNode> r11 = this.unsign;
        if (r11 == null) goto L8;
        r11.remove(r5);
    L8:
        ArrayList<ExpressNode> r12 = this.recentSign;
        if (r12 == null) goto L11;
        r12.remove(r5);
    L11:
        ArrayList<ExpressNode> r13 = this.sign;
        if (r13 == null) goto L15;
        r13.remove(r5);
        return;
    }

    public String toString() {
        return "ExpressGroup [toTake=" + this.toTake + ", unsign=" + this.unsign + ", sign=" + this.sign + "]";
    }
}
