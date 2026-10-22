package com.zte.miboard.cards.express.data;

import androidx.constraintlayout.motion.widget.a;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleResultBean {
    String data;
    String message;
    int result;
    public String sfSubscribeMessage;
    public int sfSubscribeResult;

    public SimpleResultBean() {
        this.sfSubscribeResult = -1;
    }

    public String getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public int getResult() {
        return this.result;
    }

    public boolean isSFSubscribeResultOk() {
        if (this.sfSubscribeResult != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setData(String r5) {
        this.data = r5;
    }

    public void setMessage(String r5) {
        this.message = r5;
    }

    public void setResult(int r5) {
        this.result = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("ResBean{data='");
        r5.append(this.data);
        r5.append("', message='");
        r5.append(this.message);
        r5.append("', result='");
        return a.s(r5, this.result, "'}");
    }
}
