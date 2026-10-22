package com.ss.android.lark.chat.entity.reaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Reaction implements Serializable, b<Reaction> {
    private List<String> chatterIds;
    private int count;
    private String messageId;
    private String type;

    public boolean isItemSame(Reaction r1) {
        return true;
    }

    public String toString() {
        return "Reaction{type='" + this.type + "', count=" + this.count + ", chatterIds=" + this.chatterIds + '}';
    }

    public Reaction() {
    }

    public List<String> getChatterIds() {
        return this.chatterIds;
    }

    public int getCount() {
        return this.count;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getType() {
        return this.type;
    }

    public boolean isContentSame(Reaction r4) {
        if (this.type.equals(r4.getType()) == true) goto L6;
        return false;
    L6:
        if (this.count == r4.getCount()) goto L8;
        return false;
    L8:
        List<String> r5 = r4.getChatterIds();
        if (this.chatterIds.size() != r5.size()) goto L16;
        if (this.chatterIds.containsAll(r5) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((Reaction) r1);
    }

    public void setChatterIds(List<String> r1) {
        this.chatterIds = r1;
    }

    public void setCount(int r1) {
        this.count = r1;
    }

    public void setMessageId(String r1) {
        this.messageId = r1;
    }

    public void setType(String r1) {
        this.type = r1;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((Reaction) r1);
    }

    public Reaction(String r2, int r3, String r4) {
        this.type = r2;
        this.count = r3;
        this.chatterIds = new ArrayList(Arrays.asList(new String[]{r4}));
    }

    public Reaction(String r1, int r2, List<String> r3) {
        this.type = r1;
        this.count = r2;
        this.chatterIds = r3;
    }
}
