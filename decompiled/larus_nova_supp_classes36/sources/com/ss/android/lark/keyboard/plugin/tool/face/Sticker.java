package com.ss.android.lark.keyboard.plugin.tool.face;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class Sticker implements Serializable {
    public final String filePath;
    public final String key;

    public Sticker() {
        this.key = "";
        this.filePath = "";
    }

    public Sticker(String r1, String r2) {
        this.key = r1;
        this.filePath = r2;
    }
}
