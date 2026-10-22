package com.zte.miboard.cards.express.data;

import com.bytedance.ai.event.MessageIndication;

/* JADX INFO: loaded from: classes3.dex */
public class ExpressDetailBean {
    private ExpressDetail data;
    private String message;
    private int result;

    public ExpressDetailBean() {
        this.result = -1;
        this.message = MessageIndication.STATUS_FAILED;
        this.data = null;
    }

    public ExpressDetail getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public int getResult() {
        return this.result;
    }

    public void setData(ExpressDetail r5) {
        this.data = r5;
    }

    public void setMessage(String r5) {
        this.message = r5;
    }

    public void setResult(int r5) {
        this.result = r5;
    }

    public String toString() {
        return "ExpressDetailBean{result=" + this.result + ", message='" + this.message + "', data=" + this.data + '}';
    }
}
