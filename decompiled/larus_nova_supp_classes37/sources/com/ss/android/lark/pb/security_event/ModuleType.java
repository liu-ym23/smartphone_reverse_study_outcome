package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ModuleType extends Enum<ModuleType> implements WireEnum {
    private static final /* synthetic */ ModuleType[] $VALUES = null;
    public static final ProtoAdapter<ModuleType> ADAPTER = null;
    public static final ModuleType ModuleAPP = null;
    public static final ModuleType ModuleAddressBook = null;
    public static final ModuleType ModuleBitable = null;
    public static final ModuleType ModuleCalendar = null;
    public static final ModuleType ModuleChat = null;
    public static final ModuleType ModuleCommunication = null;
    public static final ModuleType ModuleDevice = null;
    public static final ModuleType ModuleDocs = null;
    public static final ModuleType ModuleDocx = null;
    public static final ModuleType ModuleDoubao = null;
    public static final ModuleType ModuleEmail = null;
    public static final ModuleType ModuleFiles = null;
    public static final ModuleType ModuleFolders = null;
    public static final ModuleType ModuleIM = null;
    public static final ModuleType ModuleIMFile = null;
    public static final ModuleType ModuleIMImageAndVideo = null;
    public static final ModuleType ModuleMindNote = null;
    public static final ModuleType ModuleMoments = null;
    public static final ModuleType ModuleOpenPlatform = null;
    public static final ModuleType ModulePassport = null;
    public static final ModuleType ModulePeople = null;
    public static final ModuleType ModuleSheets = null;
    public static final ModuleType ModuleSlide = null;
    public static final ModuleType ModuleUnknown = null;
    public static final ModuleType ModuleVideo = null;
    private final int value;

    static {
        ModuleType r0 = new ModuleType("ModuleUnknown", 0, 0);
        ModuleUnknown = r0;
        ModuleType r1 = new ModuleType("ModuleDocs", 1, 1);
        ModuleDocs = r1;
        ModuleType r3 = new ModuleType("ModuleSheets", 2, 2);
        ModuleSheets = r3;
        ModuleType r5 = new ModuleType("ModuleFiles", 3, 3);
        ModuleFiles = r5;
        ModuleType r7 = new ModuleType("ModuleFolders", 4, 4);
        ModuleFolders = r7;
        ModuleType r9 = new ModuleType("ModulePassport", 5, 5);
        ModulePassport = r9;
        ModuleType r11 = new ModuleType("ModuleMindNote", 6, 6);
        ModuleMindNote = r11;
        ModuleType r13 = new ModuleType("ModuleBitable", 7, 7);
        ModuleBitable = r13;
        ModuleType r15 = new ModuleType("ModuleSlide", 8, 8);
        ModuleSlide = r15;
        ModuleType r14 = new ModuleType("ModuleChat", 9, 9);
        ModuleChat = r14;
        ModuleType r12 = new ModuleType("ModuleIMImageAndVideo", 10, 10);
        ModuleIMImageAndVideo = r12;
        ModuleType r10 = new ModuleType("ModuleVideo", 11, 11);
        ModuleVideo = r10;
        ModuleType r8 = new ModuleType("ModuleIMFile", 12, 12);
        ModuleIMFile = r8;
        ModuleType r6 = new ModuleType("ModuleCommunication", 13, 13);
        ModuleCommunication = r6;
        ModuleType r4 = new ModuleType("ModuleCalendar", 14, 14);
        ModuleCalendar = r4;
        ModuleType r2 = new ModuleType("ModuleAddressBook", 15, 15);
        ModuleAddressBook = r2;
        ModuleType r16 = new ModuleType("ModuleAPP", 16, 16);
        ModuleAPP = r16;
        ModuleType r17 = new ModuleType("ModuleEmail", 17, 17);
        ModuleEmail = r17;
        ModuleType r18 = new ModuleType("ModuleIM", 18, 18);
        ModuleIM = r18;
        ModuleType r19 = new ModuleType("ModuleDocx", 19, 19);
        ModuleDocx = r19;
        ModuleType r20 = new ModuleType("ModulePeople", 20, 20);
        ModulePeople = r20;
        ModuleType r21 = new ModuleType("ModuleDevice", 21, 21);
        ModuleDevice = r21;
        ModuleType r22 = new ModuleType("ModuleMoments", 22, 22);
        ModuleMoments = r22;
        ModuleType r23 = new ModuleType("ModuleOpenPlatform", 23, 23);
        ModuleOpenPlatform = r23;
        ModuleType r24 = new ModuleType("ModuleDoubao", 24, 24);
        ModuleDoubao = r24;
        $VALUES = new ModuleType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24};
        ADAPTER = ProtoAdapter.newEnumAdapter(ModuleType.class);
    }

    public static ModuleType[] values() {
        return (ModuleType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ModuleType fromValue(int r0) {
        switch(r0) {
            case 0: goto L54;
            case 1: goto L52;
            case 2: goto L50;
            case 3: goto L48;
            case 4: goto L46;
            case 5: goto L44;
            case 6: goto L42;
            case 7: goto L40;
            case 8: goto L38;
            case 9: goto L36;
            case 10: goto L34;
            case 11: goto L32;
            case 12: goto L30;
            case 13: goto L28;
            case 14: goto L26;
            case 15: goto L24;
            case 16: goto L22;
            case 17: goto L20;
            case 18: goto L18;
            case 19: goto L16;
            case 20: goto L14;
            case 21: goto L12;
            case 22: goto L10;
            case 23: goto L8;
            case 24: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return ModuleDoubao;
    L8:
        return ModuleOpenPlatform;
    L10:
        return ModuleMoments;
    L12:
        return ModuleDevice;
    L14:
        return ModulePeople;
    L16:
        return ModuleDocx;
    L18:
        return ModuleIM;
    L20:
        return ModuleEmail;
    L22:
        return ModuleAPP;
    L24:
        return ModuleAddressBook;
    L26:
        return ModuleCalendar;
    L28:
        return ModuleCommunication;
    L30:
        return ModuleIMFile;
    L32:
        return ModuleVideo;
    L34:
        return ModuleIMImageAndVideo;
    L36:
        return ModuleChat;
    L38:
        return ModuleSlide;
    L40:
        return ModuleBitable;
    L42:
        return ModuleMindNote;
    L44:
        return ModulePassport;
    L46:
        return ModuleFolders;
    L48:
        return ModuleFiles;
    L50:
        return ModuleSheets;
    L52:
        return ModuleDocs;
    L54:
        return ModuleUnknown;
    }

    public static ModuleType valueOf(String r1) {
        return (ModuleType) a.a(ModuleType.class, r1);
    }

    private ModuleType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
