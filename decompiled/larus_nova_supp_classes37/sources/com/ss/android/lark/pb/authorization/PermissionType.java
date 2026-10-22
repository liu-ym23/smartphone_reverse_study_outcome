package com.ss.android.lark.pb.authorization;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum PermissionType extends Enum<PermissionType> implements WireEnum {
    private static final /* synthetic */ PermissionType[] $VALUES = null;
    public static final ProtoAdapter<PermissionType> ADAPTER = null;
    public static final PermissionType BAIKE_REPO_VIEW = null;
    public static final PermissionType DOC_DOWNLOAD = null;
    public static final PermissionType DOC_EXPORT = null;
    public static final PermissionType DOC_PREVIEW_AND_OPEN = null;
    public static final PermissionType DOC_PRINT = null;
    public static final PermissionType FILE_ACCESS_FOLDER = null;
    public static final PermissionType FILE_APP_OPEN = null;
    public static final PermissionType FILE_COMMENT = null;
    public static final PermissionType FILE_COPY = null;
    public static final PermissionType FILE_DELETE = null;
    public static final PermissionType FILE_DOWNLOAD = null;
    public static final PermissionType FILE_EDIT = null;
    public static final PermissionType FILE_EXPORT = null;
    public static final PermissionType FILE_IMPORT = null;
    public static final PermissionType FILE_PRINT = null;
    public static final PermissionType FILE_READ = null;
    public static final PermissionType FILE_SHARE = null;
    public static final PermissionType FILE_UPLOAD = null;
    public static final PermissionType LOCAL_FILE_PREVIEW = null;
    public static final PermissionType LOCAL_FILE_SHARE = null;
    public static final PermissionType MOBILE_PASTE_PROTECTION = null;
    public static final PermissionType MOBILE_SCREEN_PROTECT = null;
    public static final PermissionType PC_PASTE_PROTECTION = null;
    public static final PermissionType PC_SCREEN_PROTECT = null;
    public static final PermissionType PERMISSION_TYPE_UNKNOWN = null;
    public static final PermissionType PRIVACY_GPS_LOCATION = null;
    public static final PermissionType SDK_SWITCH = null;
    public static final PermissionType SEARCH = null;
    public static final PermissionType WEB_PASTE_PROTECTION = null;
    private final int value;

    static {
        PermissionType r0 = new PermissionType("PERMISSION_TYPE_UNKNOWN", 0, 0);
        PERMISSION_TYPE_UNKNOWN = r0;
        PermissionType r1 = new PermissionType("FILE_UPLOAD", 1, 1);
        FILE_UPLOAD = r1;
        PermissionType r3 = new PermissionType("FILE_IMPORT", 2, 2);
        FILE_IMPORT = r3;
        PermissionType r5 = new PermissionType("FILE_DOWNLOAD", 3, 3);
        FILE_DOWNLOAD = r5;
        PermissionType r7 = new PermissionType("FILE_EXPORT", 4, 4);
        FILE_EXPORT = r7;
        PermissionType r9 = new PermissionType("FILE_PRINT", 5, 5);
        FILE_PRINT = r9;
        PermissionType r11 = new PermissionType("FILE_APP_OPEN", 6, 6);
        FILE_APP_OPEN = r11;
        PermissionType r13 = new PermissionType("FILE_ACCESS_FOLDER", 7, 7);
        FILE_ACCESS_FOLDER = r13;
        PermissionType r15 = new PermissionType("FILE_READ", 8, 8);
        FILE_READ = r15;
        PermissionType r14 = new PermissionType("FILE_EDIT", 9, 9);
        FILE_EDIT = r14;
        PermissionType r12 = new PermissionType("FILE_COMMENT", 10, 10);
        FILE_COMMENT = r12;
        PermissionType r10 = new PermissionType("FILE_COPY", 11, 11);
        FILE_COPY = r10;
        PermissionType r8 = new PermissionType("FILE_DELETE", 12, 12);
        FILE_DELETE = r8;
        PermissionType r6 = new PermissionType("FILE_SHARE", 13, 13);
        FILE_SHARE = r6;
        PermissionType r4 = new PermissionType("SEARCH", 14, 14);
        SEARCH = r4;
        PermissionType r2 = new PermissionType("LOCAL_FILE_SHARE", 15, 15);
        LOCAL_FILE_SHARE = r2;
        PermissionType r16 = new PermissionType("LOCAL_FILE_PREVIEW", 16, 16);
        LOCAL_FILE_PREVIEW = r16;
        PermissionType r17 = new PermissionType("DOC_PREVIEW_AND_OPEN", 17, 17);
        DOC_PREVIEW_AND_OPEN = r17;
        PermissionType r18 = new PermissionType("PRIVACY_GPS_LOCATION", 18, 18);
        PRIVACY_GPS_LOCATION = r18;
        PermissionType r19 = new PermissionType("PC_PASTE_PROTECTION", 19, 19);
        PC_PASTE_PROTECTION = r19;
        PermissionType r20 = new PermissionType("WEB_PASTE_PROTECTION", 20, 20);
        WEB_PASTE_PROTECTION = r20;
        PermissionType r21 = new PermissionType("MOBILE_PASTE_PROTECTION", 21, 21);
        MOBILE_PASTE_PROTECTION = r21;
        PermissionType r22 = new PermissionType("MOBILE_SCREEN_PROTECT", 22, 22);
        MOBILE_SCREEN_PROTECT = r22;
        PermissionType r23 = new PermissionType("PC_SCREEN_PROTECT", 23, 23);
        PC_SCREEN_PROTECT = r23;
        PermissionType r24 = new PermissionType("DOC_DOWNLOAD", 24, 24);
        DOC_DOWNLOAD = r24;
        PermissionType r25 = new PermissionType("DOC_EXPORT", 25, 25);
        DOC_EXPORT = r25;
        PermissionType r26 = new PermissionType("DOC_PRINT", 26, 26);
        DOC_PRINT = r26;
        PermissionType r27 = new PermissionType("BAIKE_REPO_VIEW", 27, 27);
        BAIKE_REPO_VIEW = r27;
        PermissionType r28 = new PermissionType("SDK_SWITCH", 28, 28);
        SDK_SWITCH = r28;
        $VALUES = new PermissionType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28};
        ADAPTER = ProtoAdapter.newEnumAdapter(PermissionType.class);
    }

    public static PermissionType[] values() {
        return (PermissionType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PermissionType fromValue(int r0) {
        switch(r0) {
            case 0: goto L62;
            case 1: goto L60;
            case 2: goto L58;
            case 3: goto L56;
            case 4: goto L54;
            case 5: goto L52;
            case 6: goto L50;
            case 7: goto L48;
            case 8: goto L46;
            case 9: goto L44;
            case 10: goto L42;
            case 11: goto L40;
            case 12: goto L38;
            case 13: goto L36;
            case 14: goto L34;
            case 15: goto L32;
            case 16: goto L30;
            case 17: goto L28;
            case 18: goto L26;
            case 19: goto L24;
            case 20: goto L22;
            case 21: goto L20;
            case 22: goto L18;
            case 23: goto L16;
            case 24: goto L14;
            case 25: goto L12;
            case 26: goto L10;
            case 27: goto L8;
            case 28: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return SDK_SWITCH;
    L8:
        return BAIKE_REPO_VIEW;
    L10:
        return DOC_PRINT;
    L12:
        return DOC_EXPORT;
    L14:
        return DOC_DOWNLOAD;
    L16:
        return PC_SCREEN_PROTECT;
    L18:
        return MOBILE_SCREEN_PROTECT;
    L20:
        return MOBILE_PASTE_PROTECTION;
    L22:
        return WEB_PASTE_PROTECTION;
    L24:
        return PC_PASTE_PROTECTION;
    L26:
        return PRIVACY_GPS_LOCATION;
    L28:
        return DOC_PREVIEW_AND_OPEN;
    L30:
        return LOCAL_FILE_PREVIEW;
    L32:
        return LOCAL_FILE_SHARE;
    L34:
        return SEARCH;
    L36:
        return FILE_SHARE;
    L38:
        return FILE_DELETE;
    L40:
        return FILE_COPY;
    L42:
        return FILE_COMMENT;
    L44:
        return FILE_EDIT;
    L46:
        return FILE_READ;
    L48:
        return FILE_ACCESS_FOLDER;
    L50:
        return FILE_APP_OPEN;
    L52:
        return FILE_PRINT;
    L54:
        return FILE_EXPORT;
    L56:
        return FILE_DOWNLOAD;
    L58:
        return FILE_IMPORT;
    L60:
        return FILE_UPLOAD;
    L62:
        return PERMISSION_TYPE_UNKNOWN;
    }

    public static PermissionType valueOf(String r1) {
        return (PermissionType) a.a(PermissionType.class, r1);
    }

    private PermissionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
