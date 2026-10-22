package com.bytedance.android.alog;

/* JADX INFO: loaded from: classes.dex */
public class MsgInfo {
    public int level;
    public String msg;
    public String tag;

    public MsgInfo(int r10, String r11, String r12) {
        this.level = r10;
        this.tag = r11;
        this.msg = r12;
    }

    public int getLevel() {
        return this.level;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getTag() {
        return this.tag;
    }

    public void setLevel(int r10) {
        this.level = r10;
    }

    public void setMsg(String r10) {
        this.msg = r10;
    }

    public void setTag(String r10) {
        this.tag = r10;
    }
}
