package cn.nubia.neopush.protocol.model.message;

/* JADX INFO: loaded from: classes.dex */
public class Flag {
    public static final int QOS_ONE_AT_LEAST = 1;
    public static final int QOS_ONE_AT_MOST = 0;
    public static final int QOS_ONE_ONLY = 2;
    public static final int QOS_OTHER = 3;
    public int Dup;
    public int Qos;
    public int cleanSession;
    public int nubiaPublish;

    public Flag(byte r5) {
        this.Dup = (r5 >> 7) & 255;
        this.Qos = (r5 >> 5) & 3;
        this.cleanSession = (r5 >> 1) & 1;
        this.nubiaPublish = r5 & 1;
    }

    public byte enCode(Flag r5) {
        return (byte) ((((((r5.Dup & 255) << 7) + ((r5.Qos & 255) << 5)) + ((r5.cleanSession & 255) << 1)) + r5.nubiaPublish) & 255);
    }

    public Flag(int r5, int r10, int r11, int r12) {
        this.Dup = r5;
        this.Qos = r5;
        this.cleanSession = r11;
        this.nubiaPublish = r12;
    }
}
