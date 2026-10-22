package com.obric.memory.datacollect.kotlin;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.annotations.SerializedName;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0087\u0001\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001c"}, d2 = {"Lcom/obric/memory/datacollect/kotlin/MsgType;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "None", "Time", "Text", i.G, "Withdraw", "Audio", "Image", "Video", "AudioCall", "VideoCall", "Call", "RedEnvelope", "Transfer", "BusinessCard", "OfficialAccount", "Position", "Applets", "Hyperlink", "File", "Forward", "Companion", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
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
    public static final a Companion = null;

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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/obric/memory/datacollect/kotlin/MsgType$Companion;", "", "()V", "findByValue", "Lcom/obric/memory/datacollect/kotlin/MsgType;", "i", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final MsgType a(int r1) {
            switch(r1) {
                case 0: goto L24;
                case 1: goto L44;
                case 2: goto L43;
                case 3: goto L42;
                case 4: goto L41;
                case 5: goto L40;
                case 6: goto L39;
                case 7: goto L38;
                case 8: goto L37;
                case 9: goto L36;
                case 10: goto L35;
                case 11: goto L34;
                case 12: goto L33;
                case 13: goto L32;
                case 14: goto L31;
                case 15: goto L30;
                case 16: goto L29;
                case 17: goto L28;
                case 18: goto L27;
                case 19: goto L26;
                default: goto L3;
            };
        L3:
            return null;
        L26:
            return MsgType.Forward;
        L27:
            return MsgType.File;
        L28:
            return MsgType.Hyperlink;
        L29:
            return MsgType.Applets;
        L30:
            return MsgType.Position;
        L31:
            return MsgType.OfficialAccount;
        L32:
            return MsgType.BusinessCard;
        L33:
            return MsgType.Transfer;
        L34:
            return MsgType.RedEnvelope;
        L35:
            return MsgType.Call;
        L36:
            return MsgType.VideoCall;
        L37:
            return MsgType.AudioCall;
        L38:
            return MsgType.Video;
        L39:
            return MsgType.Image;
        L40:
            return MsgType.Audio;
        L41:
            return MsgType.Withdraw;
        L42:
            return MsgType.Quote;
        L43:
            return MsgType.Text;
        L44:
            return MsgType.Time;
        L24:
            return MsgType.None;
        }
    }

    static {
        MsgType r1 = new MsgType("None", 0, 0);
        None = r1;
        MsgType r2 = new MsgType("Time", 1, 1);
        Time = r2;
        MsgType r3 = new MsgType("Text", 2, 2);
        Text = r3;
        MsgType r4 = new MsgType(i.G, 3, 3);
        Quote = r4;
        MsgType r5 = new MsgType("Withdraw", 4, 4);
        Withdraw = r5;
        MsgType r6 = new MsgType("Audio", 5, 5);
        Audio = r6;
        MsgType r7 = new MsgType("Image", 6, 6);
        Image = r7;
        MsgType r8 = new MsgType("Video", 7, 7);
        Video = r8;
        MsgType r9 = new MsgType("AudioCall", 8, 8);
        AudioCall = r9;
        MsgType r10 = new MsgType("VideoCall", 9, 9);
        VideoCall = r10;
        MsgType r11 = new MsgType("Call", 10, 10);
        Call = r11;
        MsgType r12 = new MsgType("RedEnvelope", 11, 11);
        RedEnvelope = r12;
        MsgType r13 = new MsgType("Transfer", 12, 12);
        Transfer = r13;
        MsgType r14 = new MsgType("BusinessCard", 13, 13);
        BusinessCard = r14;
        MsgType r15 = new MsgType("OfficialAccount", 14, 14);
        OfficialAccount = r15;
        MsgType r16 = new MsgType("Position", 15, 15);
        Position = r16;
        MsgType r17 = new MsgType("Applets", 16, 16);
        Applets = r17;
        MsgType r18 = new MsgType("Hyperlink", 17, 17);
        Hyperlink = r18;
        MsgType r19 = new MsgType("File", 18, 18);
        File = r19;
        MsgType r20 = new MsgType("Forward", 19, 19);
        Forward = r20;
        $VALUES = new MsgType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20};
        Companion = new a(null);
    }

    private MsgType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    @JvmStatic
    public static final MsgType findByValue(int r1) {
        return Companion.a(r1);
    }

    public static MsgType valueOf(String r2) {
        return (MsgType) ZeusTransformUtils.preCheckCast(Enum.valueOf(MsgType.class, r2), MsgType.class, "com.obric.memorydata.plugin");
    }

    public static MsgType[] values() {
        return (MsgType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MsgType[].class, "com.obric.memorydata.plugin");
    }

    public final int getValue() {
        return this.value;
    }
}
