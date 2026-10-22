package com.bytedance.apm6.frequency;

/* JADX INFO: loaded from: classes.dex */
class RecordItem {
    private String category;
    private String command;
    private long duration;
    private volatile boolean isUsing;
    private String key;

    public RecordItem() {
        this.isUsing = false;
    }

    public RecordItem(String r2, long r3) {
        this.isUsing = false;
        this.command = r2;
        this.duration = r3;
    }

    public RecordItem(String r2, String r3) {
        this.isUsing = false;
        this.category = r2;
        this.key = r3;
    }

    public String getCategory() {
        return this.category;
    }

    public String getCommand() {
        return this.command;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getKey() {
        return this.key;
    }

    public boolean isUsing() {
        return this.isUsing;
    }

    public void setCategory(String r1) {
        this.category = r1;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setUsing(boolean r1) {
        this.isUsing = r1;
    }
}
