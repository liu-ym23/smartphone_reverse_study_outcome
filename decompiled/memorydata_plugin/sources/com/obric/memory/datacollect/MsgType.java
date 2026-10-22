package com.obric.memory.datacollect;

import com.google.gson.annotations.SerializedName;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final enum MsgType extends Enum<MsgType> {
    private static final /* synthetic */ MsgType[] $VALUES = null;

    @SerializedName("16")
    public static final MsgType Applets = null;

    @SerializedName("5")
    public static final MsgType Audio = null;

    @SerializedName("8")
    public static final MsgType AudioCall = null;

    @SerializedName("13")
    public static final MsgType BusinessCard = null;

    @SerializedName("10")
    public static final MsgType Call = null;

    @SerializedName("18")
    public static final MsgType File = null;

    @SerializedName("19")
    public static final MsgType Forward = null;

    @SerializedName("17")
    public static final MsgType Hyperlink = null;

    @SerializedName("6")
    public static final MsgType Image = null;

    @SerializedName("0")
    public static final MsgType None = null;

    @SerializedName("14")
    public static final MsgType OfficialAccount = null;

    @SerializedName("15")
    public static final MsgType Position = null;

    @SerializedName("3")
    public static final MsgType Quote = null;

    @SerializedName("11")
    public static final MsgType RedEnvelope = null;

    @SerializedName("2")
    public static final MsgType Text = null;

    @SerializedName("1")
    public static final MsgType Time = null;

    @SerializedName("12")
    public static final MsgType Transfer = null;

    @SerializedName("7")
    public static final MsgType Video = null;

    @SerializedName("9")
    public static final MsgType VideoCall = null;

    @SerializedName("4")
    public static final MsgType Withdraw = null;
    private final int value;

    static {
        MsgType r0 = new MsgType("None", 0, 0);
        None = r0;
        MsgType r1 = new MsgType("Time", 1, 1);
        Time = r1;
        MsgType r3 = new MsgType("Text", 2, 2);
        Text = r3;
        MsgType r5 = new MsgType(i.G, 3, 3);
        Quote = r5;
        MsgType r7 = new MsgType("Withdraw", 4, 4);
        Withdraw = r7;
        MsgType r9 = new MsgType("Audio", 5, 5);
        Audio = r9;
        MsgType r11 = new MsgType("Image", 6, 6);
        Image = r11;
        MsgType r13 = new MsgType("Video", 7, 7);
        Video = r13;
        MsgType r15 = new MsgType("AudioCall", 8, 8);
        AudioCall = r15;
        MsgType r14 = new MsgType("VideoCall", 9, 9);
        VideoCall = r14;
        MsgType r12 = new MsgType("Call", 10, 10);
        Call = r12;
        MsgType r10 = new MsgType("RedEnvelope", 11, 11);
        RedEnvelope = r10;
        MsgType r8 = new MsgType("Transfer", 12, 12);
        Transfer = r8;
        MsgType r6 = new MsgType("BusinessCard", 13, 13);
        BusinessCard = r6;
        MsgType r4 = new MsgType("OfficialAccount", 14, 14);
        OfficialAccount = r4;
        MsgType r2 = new MsgType("Position", 15, 15);
        Position = r2;
        MsgType r16 = new MsgType("Applets", 16, 16);
        Applets = r16;
        MsgType r17 = new MsgType("Hyperlink", 17, 17);
        Hyperlink = r17;
        MsgType r18 = new MsgType("File", 18, 18);
        File = r18;
        MsgType r19 = new MsgType("Forward", 19, 19);
        Forward = r19;
        $VALUES = new MsgType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19};
    }

    private MsgType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static MsgType findByValue(int r0) {
        switch(r0) {
            case 0: goto L44;
            case 1: goto L42;
            case 2: goto L40;
            case 3: goto L38;
            case 4: goto L36;
            case 5: goto L34;
            case 6: goto L32;
            case 7: goto L30;
            case 8: goto L28;
            case 9: goto L26;
            case 10: goto L24;
            case 11: goto L22;
            case 12: goto L20;
            case 13: goto L18;
            case 14: goto L16;
            case 15: goto L14;
            case 16: goto L12;
            case 17: goto L10;
            case 18: goto L8;
            case 19: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return Forward;
    L8:
        return File;
    L10:
        return Hyperlink;
    L12:
        return Applets;
    L14:
        return Position;
    L16:
        return OfficialAccount;
    L18:
        return BusinessCard;
    L20:
        return Transfer;
    L22:
        return RedEnvelope;
    L24:
        return Call;
    L26:
        return VideoCall;
    L28:
        return AudioCall;
    L30:
        return Video;
    L32:
        return Image;
    L34:
        return Audio;
    L36:
        return Withdraw;
    L38:
        return Quote;
    L40:
        return Text;
    L42:
        return Time;
    L44:
        return None;
    }

    public static MsgType valueOf(String r2) {
        return (MsgType) ZeusTransformUtils.preCheckCast(Enum.valueOf(MsgType.class, r2), MsgType.class, "com.obric.memorydata.plugin");
    }

    public static MsgType[] values() {
        return (MsgType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MsgType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
