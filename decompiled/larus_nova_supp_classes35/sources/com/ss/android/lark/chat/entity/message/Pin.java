package com.ss.android.lark.chat.entity.message;

import java.io.Serializable;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Pin implements Serializable, b<Pin> {
    public transient boolean a;
    private String id;
    private String operatorDefaultName;
    private volatile String operatorDisplayName;
    private String operatorId;
    private long timeStamp;

    public String toString() {
        return "[timestamp = " + this.timeStamp + " , id = " + this.id + " ]";
    }

    public String getId() {
        return this.id;
    }

    public String getOperatorDefaultName() {
        return this.operatorDefaultName;
    }

    public String getOperatorDisplayName() {
        return this.operatorDisplayName;
    }

    public String getOperatorId() {
        return this.operatorId;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public boolean isHasRead() {
        return this.a;
    }

    public boolean isContentSame(Pin r7) {
        if (this.timeStamp == r7.getTimeStamp()) goto L6;
        return false;
    L6:
        if (this.operatorId.equals(r7.getOperatorId()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public boolean isItemSame(Pin r2) {
        return this.id.equals(r2.getId());
    }

    public void setHasRead(boolean r1) {
        this.a = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setOperatorDefaultName(String r1) {
        this.operatorDefaultName = r1;
    }

    public void setOperatorDisplayName(String r1) {
        this.operatorDisplayName = r1;
    }

    public void setTimeStamp(int r3) {
        this.timeStamp = r3;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((Pin) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((Pin) r1);
    }

    public Pin(String r2, String r3, String r4, String r5, long r6) {
        this.a = false;
        this.id = r2;
        this.operatorId = r3;
        this.operatorDisplayName = r4;
        this.operatorDefaultName = r5;
        this.timeStamp = r6;
    }
}
