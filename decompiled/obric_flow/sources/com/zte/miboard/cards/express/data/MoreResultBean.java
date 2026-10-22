package com.zte.miboard.cards.express.data;

import androidx.constraintlayout.motion.widget.a;
import com.bytedance.ai.event.MessageIndication;

/* JADX INFO: loaded from: classes3.dex */
public class MoreResultBean {
    private MoreResultData data;
    public String message;
    private int result;

    public MoreResultBean() {
        this.result = -1;
        this.message = MessageIndication.STATUS_FAILED;
        this.data = null;
    }

    public MoreResultData getMoreResultData() {
        return this.data;
    }

    public int getResult() {
        return this.result;
    }

    public void setData(MoreResultData r5) {
        this.data = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("BindResultBean{result=");
        r5.append(this.result);
        r5.append(", message='");
        r5.append(this.message);
        r5.append("', data=");
        if (this.data == null) goto L5;
        boolean r10 = true;
    L7:
        return a.w(r5, r10, '}');
    L5:
        r10 = false;
        goto L7
    }
}
