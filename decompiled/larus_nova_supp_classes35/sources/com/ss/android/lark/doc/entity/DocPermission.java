package com.ss.android.lark.doc.entity;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DocPermission implements Serializable {

    @JSONField(name = "set")
    private boolean isSet;
    private int permCode;
    private String permName;

    public DocPermission() {
    }

    public boolean canEdit() {
        if ((this.permCode & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean canRead() {
        if ((this.permCode & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean canShare() {
        if ((this.permCode & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getPermTypeNum() {
        int r0 = this.permCode;
        if ((r0 & 4) == 0) goto L7;
        return DocPermPair.PermType.EDIT.getNumber();
    L7:
        if ((r0 & 1) == 0) goto L11;
        return DocPermPair.PermType.READ.getNumber();
    L11:
        return DocPermPair.PermType.UNKNOWN.getNumber();
    }

    public int hashCode() {
        int r0 = this.permCode * 31;
        String r1 = this.permName;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return ((r0 + r2) * 31) + (this.isSet ? 1 : 0);
    L5:
        r2 = 0;
        goto L7
    }

    public int getPermCode() {
        return this.permCode;
    }

    public boolean isSet() {
        return this.isSet;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L18:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L18;
        DocPermission r5 = (DocPermission) r4;
        if (this.permCode == r5.permCode) goto L14;
        return false;
    L14:
        if (this.isSet == r5.isSet) goto L17;
        return false;
    L17:
        return TextUtils.equals(this.permName, r5.permName);
    }

    public void setEdit(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = this.permCode | 4;
    L5:
        this.permCode = r2;
        this.permCode = r2;
        return;
    L4:
        r2 = this.permCode & (-5);
        goto L5
    }

    public void setIsSet(boolean r1) {
        this.isSet = r1;
    }

    public void setPermCode(int r1) {
        this.permCode = r1;
    }

    public void setPermName(String r1) {
        this.permName = r1;
    }

    public void setRead(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = this.permCode | 1;
    L5:
        this.permCode = r2;
        this.permCode = r2;
        return;
    L4:
        r2 = this.permCode & (-2);
        goto L5
    }

    public void setShare(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = this.permCode | 8;
    L5:
        this.permCode = r2;
        this.permCode = r2;
        return;
    L4:
        r2 = this.permCode & (-9);
        goto L5
    }
}
