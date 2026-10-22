package com.zte.miboard.cards.express.data;

import androidx.constraintlayout.motion.widget.a;
import com.bytedance.ai.event.MessageIndication;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GuessResultBean {
    private List<ExpressCp> data;
    private String message;
    private int result;

    public static class ExpressCp {
        String expressCode;
        String expressName;
        int platform;

        public ExpressCp(String r5, String r10) {
            this.platform = 0;
            this.expressName = r5;
            this.expressCode = r10;
        }

        public String getExpressCode() {
            return this.expressCode;
        }

        public String getExpressName() {
            return this.expressName;
        }

        public int getPlatform() {
            return this.platform;
        }

        public void setExpressCode(String r5) {
            this.expressCode = r5;
        }

        public void setExpressName(String r5) {
            this.expressName = r5;
        }

        public void setPlatform(int r5) {
            this.platform = r5;
        }
    }

    public GuessResultBean() {
        this.result = -1;
        this.message = MessageIndication.STATUS_FAILED;
        this.data = new ArrayList();
    }

    public List<ExpressCp> getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public int getResult() {
        return this.result;
    }

    public void setData(List<ExpressCp> r5) {
        this.data = r5;
    }

    public void setMessage(String r5) {
        this.message = r5;
    }

    public void setResult(int r5) {
        this.result = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("GuessResultBean{result=");
        r5.append(this.result);
        r5.append(", message='");
        r5.append(this.message);
        r5.append("', data=");
        return a.v(r5, this.data, '}');
    }
}
