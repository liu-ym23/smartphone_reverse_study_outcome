package com.obric.assistant.wakeup.bluetooth_headset.api;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\u0081\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006\""}, d2 = {"Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueDeviceTypeEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_UNKNOWN", "TYPE_HEADSET", "TYPE_CARKIT", "TYPE_LOUDSPEAKER", "TYPE_WATCH", "TYPE_BAND", "TYPE_COMPUTER", "TYPE_SMART_PHONE", "TYPE_KEYBOARD", "TYPE_MOUSE", "TYPE_PERIPHERAL", "TYPE_EBIKE", "TYPE_GLASS", "TYPE_PAD", "TYPE_LAPTOP", "TYPE_MICROPHONE", "TYPE_TV", "TYPE_HEADPHONES", "TYPE_GAMEPAD", "TYPE_VR", "TYPE_CAMERA", "TYPE_PRINTER", "TYPE_SELFIESTICK", "TYPE_EVEHICLE", "TYPE_GIMBAL", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BlueDeviceTypeEnum extends Enum<BlueDeviceTypeEnum> {
    public static final a Companion = null;
    public static final BlueDeviceTypeEnum TYPE_BAND = null;
    public static final BlueDeviceTypeEnum TYPE_CAMERA = null;
    public static final BlueDeviceTypeEnum TYPE_CARKIT = null;
    public static final BlueDeviceTypeEnum TYPE_COMPUTER = null;
    public static final BlueDeviceTypeEnum TYPE_EBIKE = null;
    public static final BlueDeviceTypeEnum TYPE_EVEHICLE = null;
    public static final BlueDeviceTypeEnum TYPE_GAMEPAD = null;
    public static final BlueDeviceTypeEnum TYPE_GIMBAL = null;
    public static final BlueDeviceTypeEnum TYPE_GLASS = null;
    public static final BlueDeviceTypeEnum TYPE_HEADPHONES = null;
    public static final BlueDeviceTypeEnum TYPE_HEADSET = null;
    public static final BlueDeviceTypeEnum TYPE_KEYBOARD = null;
    public static final BlueDeviceTypeEnum TYPE_LAPTOP = null;
    public static final BlueDeviceTypeEnum TYPE_LOUDSPEAKER = null;
    public static final BlueDeviceTypeEnum TYPE_MICROPHONE = null;
    public static final BlueDeviceTypeEnum TYPE_MOUSE = null;
    public static final BlueDeviceTypeEnum TYPE_PAD = null;
    public static final BlueDeviceTypeEnum TYPE_PERIPHERAL = null;
    public static final BlueDeviceTypeEnum TYPE_PRINTER = null;
    public static final BlueDeviceTypeEnum TYPE_SELFIESTICK = null;
    public static final BlueDeviceTypeEnum TYPE_SMART_PHONE = null;
    public static final BlueDeviceTypeEnum TYPE_TV = null;
    public static final BlueDeviceTypeEnum TYPE_UNKNOWN = null;
    public static final BlueDeviceTypeEnum TYPE_VR = null;
    public static final BlueDeviceTypeEnum TYPE_WATCH = null;
    public static final /* synthetic */ BlueDeviceTypeEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static BlueDeviceTypeEnum a(int r3) {
            Iterator r0 = BlueDeviceTypeEnum.getEntries().iterator();
        L4:
            if (r0.hasNext() == false) goto L11;
            Object r1 = r0.next();
            if (((BlueDeviceTypeEnum) r1).getValue() != r3) goto L8;
            boolean r2 = true;
        L9:
            if (r2 == false) goto L4;
        L12:
            BlueDeviceTypeEnum r4 = (BlueDeviceTypeEnum) r1;
            if (r4 == null) goto L15;
            return r4;
        L15:
            return BlueDeviceTypeEnum.TYPE_UNKNOWN;
        L8:
            r2 = false;
            goto L9
        L11:
            r1 = null;
            goto L12
        }
    }

    public static EnumEntries<BlueDeviceTypeEnum> getEntries() {
        return b;
    }

    static {
        BlueDeviceTypeEnum r0 = new BlueDeviceTypeEnum("TYPE_UNKNOWN", 0, 0);
        TYPE_UNKNOWN = r0;
        BlueDeviceTypeEnum r1 = new BlueDeviceTypeEnum("TYPE_HEADSET", 1, 1);
        TYPE_HEADSET = r1;
        BlueDeviceTypeEnum r3 = new BlueDeviceTypeEnum("TYPE_CARKIT", 2, 2);
        TYPE_CARKIT = r3;
        BlueDeviceTypeEnum r5 = new BlueDeviceTypeEnum("TYPE_LOUDSPEAKER", 3, 3);
        TYPE_LOUDSPEAKER = r5;
        BlueDeviceTypeEnum r7 = new BlueDeviceTypeEnum("TYPE_WATCH", 4, 4);
        TYPE_WATCH = r7;
        BlueDeviceTypeEnum r9 = new BlueDeviceTypeEnum("TYPE_BAND", 5, 5);
        TYPE_BAND = r9;
        BlueDeviceTypeEnum r11 = new BlueDeviceTypeEnum("TYPE_COMPUTER", 6, 6);
        TYPE_COMPUTER = r11;
        BlueDeviceTypeEnum r13 = new BlueDeviceTypeEnum("TYPE_SMART_PHONE", 7, 7);
        TYPE_SMART_PHONE = r13;
        BlueDeviceTypeEnum r15 = new BlueDeviceTypeEnum("TYPE_KEYBOARD", 8, 8);
        TYPE_KEYBOARD = r15;
        BlueDeviceTypeEnum r14 = new BlueDeviceTypeEnum("TYPE_MOUSE", 9, 9);
        TYPE_MOUSE = r14;
        BlueDeviceTypeEnum r12 = new BlueDeviceTypeEnum("TYPE_PERIPHERAL", 10, 10);
        TYPE_PERIPHERAL = r12;
        BlueDeviceTypeEnum r10 = new BlueDeviceTypeEnum("TYPE_EBIKE", 11, 11);
        TYPE_EBIKE = r10;
        BlueDeviceTypeEnum r8 = new BlueDeviceTypeEnum("TYPE_GLASS", 12, 12);
        TYPE_GLASS = r8;
        BlueDeviceTypeEnum r6 = new BlueDeviceTypeEnum("TYPE_PAD", 13, 13);
        TYPE_PAD = r6;
        BlueDeviceTypeEnum r4 = new BlueDeviceTypeEnum("TYPE_LAPTOP", 14, 14);
        TYPE_LAPTOP = r4;
        BlueDeviceTypeEnum r2 = new BlueDeviceTypeEnum("TYPE_MICROPHONE", 15, 15);
        TYPE_MICROPHONE = r2;
        BlueDeviceTypeEnum r16 = new BlueDeviceTypeEnum("TYPE_TV", 16, 16);
        TYPE_TV = r16;
        BlueDeviceTypeEnum r17 = new BlueDeviceTypeEnum("TYPE_HEADPHONES", 17, 17);
        TYPE_HEADPHONES = r17;
        BlueDeviceTypeEnum r18 = new BlueDeviceTypeEnum("TYPE_GAMEPAD", 18, 18);
        TYPE_GAMEPAD = r18;
        BlueDeviceTypeEnum r19 = new BlueDeviceTypeEnum("TYPE_VR", 19, 19);
        TYPE_VR = r19;
        BlueDeviceTypeEnum r20 = new BlueDeviceTypeEnum("TYPE_CAMERA", 20, 20);
        TYPE_CAMERA = r20;
        BlueDeviceTypeEnum r21 = new BlueDeviceTypeEnum("TYPE_PRINTER", 21, 21);
        TYPE_PRINTER = r21;
        BlueDeviceTypeEnum r22 = new BlueDeviceTypeEnum("TYPE_SELFIESTICK", 22, 22);
        TYPE_SELFIESTICK = r22;
        BlueDeviceTypeEnum r23 = new BlueDeviceTypeEnum("TYPE_EVEHICLE", 23, 23);
        TYPE_EVEHICLE = r23;
        BlueDeviceTypeEnum r24 = new BlueDeviceTypeEnum("TYPE_GIMBAL", 24, 24);
        TYPE_GIMBAL = r24;
        BlueDeviceTypeEnum[] r25 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24};
        a = r25;
        b = EnumEntriesKt.enumEntries(r25);
        Companion = new a();
    }

    public static BlueDeviceTypeEnum[] values() {
        return (BlueDeviceTypeEnum[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BlueDeviceTypeEnum valueOf(String r1) {
        return (BlueDeviceTypeEnum) r27.a.a(BlueDeviceTypeEnum.class, r1);
    }

    public BlueDeviceTypeEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
