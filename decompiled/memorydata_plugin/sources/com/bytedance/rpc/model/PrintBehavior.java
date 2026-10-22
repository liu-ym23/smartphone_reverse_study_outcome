package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.tom_roush.pdfbox.pdmodel.a.d.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum PrintBehavior extends Enum<PrintBehavior> {
    private static final /* synthetic */ PrintBehavior[] $VALUES = null;

    @SerializedName("0")
    public static final PrintBehavior Block = null;

    @SerializedName("2")
    public static final PrintBehavior Full = null;

    @SerializedName("1")
    public static final PrintBehavior Streaming = null;
    private final int value;

    static {
        PrintBehavior r0 = new PrintBehavior(d.i, 0, 0);
        Block = r0;
        PrintBehavior r1 = new PrintBehavior("Streaming", 1, 1);
        Streaming = r1;
        PrintBehavior r3 = new PrintBehavior("Full", 2, 2);
        Full = r3;
        $VALUES = new PrintBehavior[]{r0, r1, r3};
    }

    private PrintBehavior(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static PrintBehavior findByValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return Full;
    L12:
        return Streaming;
    L14:
        return Block;
    }

    public static PrintBehavior valueOf(String r2) {
        return (PrintBehavior) ZeusTransformUtils.preCheckCast(Enum.valueOf(PrintBehavior.class, r2), PrintBehavior.class, "com.obric.memorydata.plugin");
    }

    public static PrintBehavior[] values() {
        return (PrintBehavior[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PrintBehavior[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
