package com.ss.android.lark.ding.entity;

import com.larksuite.framework.utils.CollectionUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DingStatus implements Serializable, b<DingStatus> {
    private Map<String, String> chatterNameMap;
    private List<String> confirmedChatterIds;
    private List<String> invisibleChatterIds;
    private String messageId;
    private List<String> unconfirmedChatterIds;

    public String toString() {
        return "DingStatus{confirmedChatterIds=" + this.confirmedChatterIds + ", unconfirmedChatterIds=" + this.unconfirmedChatterIds + '}';
    }

    public DingStatus() {
        this.confirmedChatterIds = new ArrayList();
        this.unconfirmedChatterIds = new ArrayList();
        this.chatterNameMap = new HashMap();
        this.invisibleChatterIds = new ArrayList();
    }

    public Map<String, String> getChatterNameMap() {
        return this.chatterNameMap;
    }

    public List<String> getConfirmedChatterIds() {
        return this.confirmedChatterIds;
    }

    public List<String> getInvisibleChatterIds() {
        return this.invisibleChatterIds;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public List<String> getUnconfirmedChatterIds() {
        return this.unconfirmedChatterIds;
    }

    public boolean isContentSame(DingStatus r5) {
        List<String> r0 = r5.getConfirmedChatterIds();
        if (this.confirmedChatterIds.size() == r0.size()) goto L5;
    L21:
        return false;
    L5:
        if (this.confirmedChatterIds.containsAll(r0) == false) goto L21;
        List<String> r1 = r5.getUnconfirmedChatterIds();
        if (this.unconfirmedChatterIds.size() != r1.size()) goto L21;
        if (this.unconfirmedChatterIds.containsAll(r1) == false) goto L21;
        Map<String, String> r6 = r5.chatterNameMap;
        if (this.chatterNameMap.size() != r6.size()) goto L21;
        if (this.chatterNameMap.keySet().containsAll(r6.keySet()) == false) goto L21;
        if (this.chatterNameMap.values().containsAll(r6.values()) == false) goto L21;
        return true;
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((DingStatus) r1);
    }

    public void setChatterNameMap(Map<String, String> r1) {
        this.chatterNameMap = r1;
    }

    public void setConfirmedChatterIds(List<String> r2) {
        this.confirmedChatterIds.clear();
        if (r2 == null) goto L6;
        this.confirmedChatterIds.addAll(r2);
        return;
    }

    public void setInvisibleChatterIds(List<String> r2) {
        if (CollectionUtils.isNotEmpty(r2) == false) goto L6;
        this.invisibleChatterIds.addAll(r2);
        return;
    }

    public void setMessageId(String r1) {
        this.messageId = r1;
    }

    public void setUnconfirmedChatterIds(List<String> r2) {
        this.unconfirmedChatterIds.clear();
        if (r2 == null) goto L6;
        this.unconfirmedChatterIds.addAll(r2);
        return;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((DingStatus) r1);
    }

    public boolean isItemSame(DingStatus r1) {
        return equals(r1);
    }
}
