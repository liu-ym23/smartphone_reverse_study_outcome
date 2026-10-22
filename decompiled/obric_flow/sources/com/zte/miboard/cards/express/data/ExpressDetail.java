package com.zte.miboard.cards.express.data;

import androidx.constraintlayout.motion.widget.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ExpressDetail {
    List<Detail> detail;
    String expressLogo;
    String expressName;
    String mailNo;

    public static class Detail {
        String desc;
        String time;

        public Detail(String r5, String r10) {
            this.time = r5;
            this.desc = r10;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getTime() {
            return this.time;
        }

        public void setDesc(String r5) {
            this.desc = r5;
        }

        public void setTime(String r5) {
            this.time = r5;
        }
    }

    public ExpressDetail() {
        this.detail = new ArrayList();
    }

    public List<Detail> getDetail() {
        return this.detail;
    }

    public String getExpressLogo() {
        return this.expressLogo;
    }

    public String getExpressName() {
        return this.expressName;
    }

    public String getMailNo() {
        return this.mailNo;
    }

    public void setDetail(List<Detail> r5) {
        this.detail = r5;
    }

    public void setExpressLogo(String r5) {
        this.expressLogo = r5;
    }

    public void setExpressName(String r5) {
        this.expressName = r5;
    }

    public void setMailNo(String r5) {
        this.mailNo = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("ExpressDetail{expressName='");
        r5.append(this.expressName);
        r5.append("', expressLogo='");
        r5.append(this.expressLogo);
        r5.append("', mailNo='mailNo', detail=");
        return a.v(r5, this.detail, '}');
    }
}
