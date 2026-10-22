package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ModelFamily extends Enum<ModelFamily> {
    private static final /* synthetic */ ModelFamily[] $VALUES = null;

    @SerializedName("7")
    public static final ModelFamily ByteArtist = null;

    @SerializedName("3")
    public static final ModelFamily Claude = null;

    @SerializedName("8")
    public static final ModelFamily Edu = null;

    @SerializedName("1")
    public static final ModelFamily GPT = null;

    @SerializedName("11")
    public static final ModelFamily Gemini = null;

    @SerializedName("9")
    public static final ModelFamily Maas = null;

    @SerializedName("4")
    public static final ModelFamily MiniMax = null;

    @SerializedName("12")
    public static final ModelFamily Moonshot = null;

    @SerializedName("5")
    public static final ModelFamily Plugin = null;

    @SerializedName("10")
    public static final ModelFamily QianFan = null;

    @SerializedName("2")
    public static final ModelFamily Seed = null;

    @SerializedName("6")
    public static final ModelFamily StableDiffusion = null;
    private final int value;

    static {
        ModelFamily r0 = new ModelFamily("GPT", 0, 1);
        GPT = r0;
        ModelFamily r1 = new ModelFamily("Seed", 1, 2);
        Seed = r1;
        ModelFamily r4 = new ModelFamily("Claude", 2, 3);
        Claude = r4;
        ModelFamily r6 = new ModelFamily("MiniMax", 3, 4);
        MiniMax = r6;
        ModelFamily r8 = new ModelFamily("Plugin", 4, 5);
        Plugin = r8;
        ModelFamily r10 = new ModelFamily("StableDiffusion", 5, 6);
        StableDiffusion = r10;
        ModelFamily r12 = new ModelFamily("ByteArtist", 6, 7);
        ByteArtist = r12;
        ModelFamily r14 = new ModelFamily("Edu", 7, 8);
        Edu = r14;
        ModelFamily r13 = new ModelFamily("Maas", 8, 9);
        Maas = r13;
        ModelFamily r15 = new ModelFamily("QianFan", 9, 10);
        QianFan = r15;
        ModelFamily r11 = new ModelFamily("Gemini", 10, 11);
        Gemini = r11;
        ModelFamily r9 = new ModelFamily("Moonshot", 11, 12);
        Moonshot = r9;
        $VALUES = new ModelFamily[]{r0, r1, r4, r6, r8, r10, r12, r14, r13, r15, r11, r9};
    }

    private ModelFamily(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ModelFamily findByValue(int r0) {
        switch(r0) {
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            case 4: goto L22;
            case 5: goto L20;
            case 6: goto L18;
            case 7: goto L16;
            case 8: goto L14;
            case 9: goto L12;
            case 10: goto L10;
            case 11: goto L8;
            case 12: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return Moonshot;
    L8:
        return Gemini;
    L10:
        return QianFan;
    L12:
        return Maas;
    L14:
        return Edu;
    L16:
        return ByteArtist;
    L18:
        return StableDiffusion;
    L20:
        return Plugin;
    L22:
        return MiniMax;
    L24:
        return Claude;
    L26:
        return Seed;
    L28:
        return GPT;
    }

    public static ModelFamily valueOf(String r2) {
        return (ModelFamily) ZeusTransformUtils.preCheckCast(Enum.valueOf(ModelFamily.class, r2), ModelFamily.class, "com.obric.memorydata.plugin");
    }

    public static ModelFamily[] values() {
        return (ModelFamily[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ModelFamily[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
