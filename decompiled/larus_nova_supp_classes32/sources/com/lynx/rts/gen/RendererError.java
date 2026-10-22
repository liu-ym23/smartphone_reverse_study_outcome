package com.lynx.rts.gen;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class RendererError {
    public String message;
    public String name;
    public Object[] stack;

    public RendererError(String r1, String r2, Object[] r3) {
        this.name = r1;
        this.message = r2;
        this.stack = r3;
    }
}
