package com.obric.assistant.wakeup.bluetooth_headset.api;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueProductIdEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_UNKNOWN", "GLASS_DORA_G", "HEADSET_OLA_FRIEND", "HEADSET_HW_FREEBUDS_PRO5_1", "HEADSET_HW_FREEBUDS_PRO5_2", "HEADSET_HW_FREECLIP2", "GLASS_DORA_G2", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BlueProductIdEnum extends Enum<BlueProductIdEnum> {
    public static final a Companion = null;
    public static final BlueProductIdEnum GLASS_DORA_G = null;
    public static final BlueProductIdEnum GLASS_DORA_G2 = null;
    public static final BlueProductIdEnum HEADSET_HW_FREEBUDS_PRO5_1 = null;
    public static final BlueProductIdEnum HEADSET_HW_FREEBUDS_PRO5_2 = null;
    public static final BlueProductIdEnum HEADSET_HW_FREECLIP2 = null;
    public static final BlueProductIdEnum HEADSET_OLA_FRIEND = null;
    public static final BlueProductIdEnum TYPE_UNKNOWN = null;
    public static final /* synthetic */ BlueProductIdEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static BlueProductIdEnum a(int r3) {
            Iterator r0 = BlueProductIdEnum.getEntries().iterator();
        L4:
            if (r0.hasNext() == false) goto L11;
            Object r1 = r0.next();
            if (((BlueProductIdEnum) r1).getValue() != r3) goto L8;
            boolean r2 = true;
        L9:
            if (r2 == false) goto L4;
        L12:
            BlueProductIdEnum r4 = (BlueProductIdEnum) r1;
            if (r4 == null) goto L15;
            return r4;
        L15:
            return BlueProductIdEnum.TYPE_UNKNOWN;
        L8:
            r2 = false;
            goto L9
        L11:
            r1 = null;
            goto L12
        }
    }

    public static EnumEntries<BlueProductIdEnum> getEntries() {
        return b;
    }

    static {
        BlueProductIdEnum r0 = new BlueProductIdEnum("TYPE_UNKNOWN", 0, 0);
        TYPE_UNKNOWN = r0;
        BlueProductIdEnum r1 = new BlueProductIdEnum("GLASS_DORA_G", 1, 4096);
        GLASS_DORA_G = r1;
        BlueProductIdEnum r3 = new BlueProductIdEnum("HEADSET_OLA_FRIEND", 2, 1);
        HEADSET_OLA_FRIEND = r3;
        BlueProductIdEnum r5 = new BlueProductIdEnum("HEADSET_HW_FREEBUDS_PRO5_1", 3, 365);
        HEADSET_HW_FREEBUDS_PRO5_1 = r5;
        BlueProductIdEnum r7 = new BlueProductIdEnum("HEADSET_HW_FREEBUDS_PRO5_2", 4, 363);
        HEADSET_HW_FREEBUDS_PRO5_2 = r7;
        BlueProductIdEnum r9 = new BlueProductIdEnum("HEADSET_HW_FREECLIP2", 5, 359);
        HEADSET_HW_FREECLIP2 = r9;
        BlueProductIdEnum r11 = new BlueProductIdEnum("GLASS_DORA_G2", 6, 17);
        GLASS_DORA_G2 = r11;
        BlueProductIdEnum[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
        Companion = new a();
    }

    public static BlueProductIdEnum[] values() {
        return (BlueProductIdEnum[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BlueProductIdEnum valueOf(String r1) {
        return (BlueProductIdEnum) r27.a.a(BlueProductIdEnum.class, r1);
    }

    public BlueProductIdEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
