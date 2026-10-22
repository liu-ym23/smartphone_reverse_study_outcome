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

    public RecordItem(String r10, long r11) {
        this.isUsing = false;
        this.command = r10;
        this.duration = r11;
    }

    public RecordItem(String r10, String r11) {
        this.isUsing = false;
        this.category = r10;
        this.key = r11;
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

    public void setCategory(String r10) {
        this.category = r10;
    }

    public void setKey(String r10) {
        this.key = r10;
    }

    public void setUsing(boolean r10) {
        this.isUsing = r10;
    }
}
