package com.zte.miboard.cards.express.data;

import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ExpressNode {
    private static final int EXPRESS_OUTDATE_STATE = 1;
    String arriveTime;
    String caiNaoOpenUrl;
    String createdTime;
    String description;
    String expressCode;
    String expressName;
    String h5OpenUrl;
    int headType;
    String invalidTime;
    int itemType;
    String logo;
    String mailNo;
    int mark;
    String orderNo;
    int outdate;
    String phone;
    int platform;
    List<String> products;
    String secretKey;
    String sfAppOpenUrlCanShu;
    String sfAppOpenUrlPrefix;
    String sfFastAppOpenUrl;
    String status;
    int statusGroup;
    String taoBaoOpenUrlCanShu;
    String taoBaoOpenUrlH5Url;
    String taoBaoOpenUrlPrefix;
    String type;
    String zhiFuBaoOpenUrlCanCanShu;
    String zhiFuBaoOpenUrlPrefix;

    public ExpressNode() {
        this.products = new ArrayList();
    }

    public String getCaiNaoOpenUrl() {
        return this.caiNaoOpenUrl;
    }

    public String getExpressCode() {
        return this.expressCode;
    }

    public String getExpressName() {
        return this.expressName;
    }

    public String getH5OpenUrl() {
        return this.h5OpenUrl;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getMailNo() {
        return this.mailNo;
    }

    public int getMark() {
        return this.mark;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public String getPhone() {
        return this.phone;
    }

    public int getPlatform() {
        return this.platform;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public String getSfAppOpenUrlCanShu() {
        return this.sfAppOpenUrlCanShu;
    }

    public String getSfAppOpenUrlPrefix() {
        return this.sfAppOpenUrlPrefix;
    }

    public String getSfFastAppOpenUrl() {
        return this.sfFastAppOpenUrl;
    }

    public String getStatus() {
        return this.status;
    }

    public int getStatusGroup() {
        return this.statusGroup;
    }

    public String getTaoBaoOpenUrlCanShu() {
        return this.taoBaoOpenUrlCanShu;
    }

    public String getTaoBaoOpenUrlH5Url() {
        return this.taoBaoOpenUrlH5Url;
    }

    public String getTaoBaoOpenUrlPrefix() {
        return this.taoBaoOpenUrlPrefix;
    }

    public String getZhiFuBaoOpenUrlCanCanShu() {
        return this.zhiFuBaoOpenUrlCanCanShu;
    }

    public String getZhiFuBaoOpenUrlPrefix() {
        return this.zhiFuBaoOpenUrlPrefix;
    }

    public boolean isAvailable() {
        return !TextUtils.isEmpty(getMailNo());
    }

    public boolean isOutDate() {
        if (this.outdate == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isSend() {
        if (TextUtils.isEmpty(this.type) == false) goto L5;
    L7:
        return false;
    L5:
        if ("send".equalsIgnoreCase(this.type) == false) goto L7;
        return true;
    }

    public void setPhone(String r5) {
        this.phone = r5;
    }

    public void setStatus(String r5) {
        this.status = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("ExpressNode{itemType=");
        r5.append(this.itemType);
        r5.append(", headType=");
        r5.append(this.headType);
        r5.append(", outdate=");
        r5.append(this.outdate);
        r5.append(", platform=");
        r5.append(this.platform);
        r5.append(", statusGroup=");
        r5.append(this.statusGroup);
        r5.append(", mark=");
        r5.append(this.mark);
        r5.append(", description='");
        r5.append(this.description);
        r5.append("', status='");
        r5.append(this.status);
        r5.append("', invalidTime='");
        r5.append(this.invalidTime);
        r5.append("', createdTime='");
        r5.append(this.createdTime);
        r5.append("', mailNo='mailNo', expressName='");
        r5.append(this.expressName);
        r5.append("', phone='phone', arriveTime='");
        r5.append(this.arriveTime);
        r5.append("', expressCode='");
        r5.append(this.expressCode);
        r5.append("', products=");
        return a.v(r5, this.products, '}');
    }
}
