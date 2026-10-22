package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum OperationType extends Enum<OperationType> implements WireEnum {
    private static final /* synthetic */ OperationType[] $VALUES = null;
    public static final ProtoAdapter<OperationType> ADAPTER = null;
    public static final OperationType OperationAddExternalFriend = null;
    public static final OperationType OperationAddPhoneNumberToContacts = null;
    public static final OperationType OperationCallPhoneNumber = null;
    public static final OperationType OperationChatPinBackToChat = null;
    public static final OperationType OperationChatPinCopyUrl = null;
    public static final OperationType OperationChatPinHoverShow = null;
    public static final OperationType OperationChatPinOpenBrowser = null;
    public static final OperationType OperationChatPinOpenUrl = null;
    public static final OperationType OperationChatPinShowInChat = null;
    public static final OperationType OperationChatPinShowPinList = null;
    public static final OperationType OperationChatPinSideBarAddLink = null;
    public static final OperationType OperationChatPinSideBarAnnounce = null;
    public static final OperationType OperationChatPinSideBarFile = null;
    public static final OperationType OperationChatPinSideBarSearch = null;
    public static final OperationType OperationComment = null;
    public static final OperationType OperationCopyContent = null;
    public static final OperationType OperationCopyPhoneNumber = null;
    public static final OperationType OperationCreate = null;
    public static final OperationType OperationCreateCopy = null;
    public static final OperationType OperationCreateSpaceCopy = null;
    public static final OperationType OperationDelete = null;
    public static final OperationType OperationDoubaoCopy = null;
    public static final OperationType OperationDoubaoDownload = null;
    public static final OperationType OperationDoubaoShare = null;
    public static final OperationType OperationDownload = null;
    public static final OperationType OperationEmailBatchExport = null;
    public static final OperationType OperationEmailCopy = null;
    public static final OperationType OperationEmailCopyAttachment = null;
    public static final OperationType OperationEmailDelBigFile = null;
    public static final OperationType OperationEmailDelete = null;
    public static final OperationType OperationEmailDownloadFile = null;
    public static final OperationType OperationEmailDownloadMail = null;
    public static final OperationType OperationEmailEditForward = null;
    public static final OperationType OperationEmailEmlAsAttachment = null;
    public static final OperationType OperationEmailLocalOpen = null;
    public static final OperationType OperationEmailLogin = null;
    public static final OperationType OperationEmailLoginThird = null;
    public static final OperationType OperationEmailMove = null;
    public static final OperationType OperationEmailPrint = null;
    public static final OperationType OperationEmailRead = null;
    public static final OperationType OperationEmailReplay = null;
    public static final OperationType OperationEmailSend = null;
    public static final OperationType OperationEmailShareFile = null;
    public static final OperationType OperationEmailShareMail = null;
    public static final OperationType OperationEmailURLClick = null;
    public static final OperationType OperationExport = null;
    public static final OperationType OperationForward = null;
    public static final OperationType OperationFrontExport = null;
    public static final OperationType OperationIMChatEditImage = null;
    public static final OperationType OperationIMChatPreviewFile = null;
    public static final OperationType OperationIMOCR = null;
    public static final OperationType OperationIMOnlineEdit = null;
    public static final OperationType OperationIMSaveToSpace = null;
    public static final OperationType OperationIMScreenCap = null;
    public static final OperationType OperationIMSnaphot = null;
    public static final OperationType OperationImport = null;
    public static final OperationType OperationJoin = null;
    public static final OperationType OperationLoadToLocal = null;
    public static final OperationType OperationLogin = null;
    public static final OperationType OperationLookDeptStruct = null;
    public static final OperationType OperationLookProfile = null;
    public static final OperationType OperationObtainMobile = null;
    public static final OperationType OperationOpenWith3rdApp = null;
    public static final OperationType OperationPassportChangeAccount = null;
    public static final OperationType OperationPrint = null;
    public static final OperationType OperationQuit = null;
    public static final OperationType OperationRead = null;
    public static final OperationType OperationSaveAs = null;
    public static final OperationType OperationSaveModule = null;
    public static final OperationType OperationScreenRecording = null;
    public static final OperationType OperationScreenShot = null;
    public static final OperationType OperationShareTo3rdApp = null;
    public static final OperationType OperationSpaceDeleteComment = null;
    public static final OperationType OperationSpaceDemoSlides = null;
    public static final OperationType OperationSpaceDocClickDocPlugin = null;
    public static final OperationType OperationSpaceDownLoadHistory = null;
    public static final OperationType OperationSpaceDownloadAttachment = null;
    public static final OperationType OperationSpaceMove = null;
    public static final OperationType OperationSpaceMoveOwner = null;
    public static final OperationType OperationSpaceRecoverHistory = null;
    public static final OperationType OperationSpaceShare = null;
    public static final OperationType OperationSpaceShareContent = null;
    public static final OperationType OperationSpaceUpdateCollaboratorAuth = null;
    public static final OperationType OperationSpaceViewHistory = null;
    public static final OperationType OperationStartExternalChat = null;
    public static final OperationType OperationTypeUnknown = null;
    public static final OperationType OperationUpdate = null;
    public static final OperationType OperationUpdateCollaborator = null;
    public static final OperationType OperationUpdateShareSetting = null;
    public static final OperationType OperationUploadCalendarAppendix = null;
    private final int value;

    static {
        OperationType r0 = new OperationType("OperationTypeUnknown", 0, 0);
        OperationTypeUnknown = r0;
        OperationType r1 = new OperationType("OperationCreate", 1, 1);
        OperationCreate = r1;
        OperationType r3 = new OperationType("OperationRead", 2, 2);
        OperationRead = r3;
        OperationType r5 = new OperationType("OperationUpdate", 3, 3);
        OperationUpdate = r5;
        OperationType r7 = new OperationType("OperationDelete", 4, 4);
        OperationDelete = r7;
        OperationType r9 = new OperationType("OperationComment", 5, 5);
        OperationComment = r9;
        OperationType r11 = new OperationType("OperationExport", 6, 6);
        OperationExport = r11;
        OperationType r13 = new OperationType("OperationDownload", 7, 7);
        OperationDownload = r13;
        OperationType r15 = new OperationType("OperationPrint", 8, 8);
        OperationPrint = r15;
        OperationType r14 = new OperationType("OperationUpdateCollaborator", 9, 9);
        OperationUpdateCollaborator = r14;
        OperationType r12 = new OperationType("OperationShareTo3rdApp", 10, 10);
        OperationShareTo3rdApp = r12;
        OperationType r10 = new OperationType("OperationUpdateShareSetting", 11, 11);
        OperationUpdateShareSetting = r10;
        OperationType r8 = new OperationType("OperationFrontExport", 12, 12);
        OperationFrontExport = r8;
        OperationType r6 = new OperationType("OperationOpenWith3rdApp", 13, 13);
        OperationOpenWith3rdApp = r6;
        OperationType r4 = new OperationType("OperationImport", 14, 14);
        OperationImport = r4;
        OperationType r2 = new OperationType("OperationLogin", 15, 15);
        OperationLogin = r2;
        OperationType r16 = new OperationType("OperationJoin", 16, 16);
        OperationJoin = r16;
        OperationType r17 = new OperationType("OperationQuit", 17, 17);
        OperationQuit = r17;
        OperationType r18 = new OperationType("OperationSaveAs", 18, 18);
        OperationSaveAs = r18;
        OperationType r19 = new OperationType("OperationCopyContent", 19, 19);
        OperationCopyContent = r19;
        OperationType r20 = new OperationType("OperationForward", 20, 20);
        OperationForward = r20;
        OperationType r21 = new OperationType("OperationLoadToLocal", 21, 21);
        OperationLoadToLocal = r21;
        OperationType r22 = new OperationType("OperationAddExternalFriend", 22, 22);
        OperationAddExternalFriend = r22;
        OperationType r23 = new OperationType("OperationStartExternalChat", 23, 23);
        OperationStartExternalChat = r23;
        OperationType r24 = new OperationType("OperationUploadCalendarAppendix", 24, 24);
        OperationUploadCalendarAppendix = r24;
        OperationType r25 = new OperationType("OperationLookDeptStruct", 25, 25);
        OperationLookDeptStruct = r25;
        OperationType r26 = new OperationType("OperationObtainMobile", 26, 26);
        OperationObtainMobile = r26;
        OperationType r27 = new OperationType("OperationLookProfile", 27, 27);
        OperationLookProfile = r27;
        OperationType r28 = new OperationType("OperationScreenShot", 28, 63);
        OperationScreenShot = r28;
        OperationType r29 = new OperationType("OperationScreenRecording", 29, 90);
        OperationScreenRecording = r29;
        OperationType r30 = new OperationType("OperationCreateSpaceCopy", 30, 100000001);
        OperationCreateSpaceCopy = r30;
        OperationType r31 = new OperationType("OperationSpaceShare", 31, 100000002);
        OperationSpaceShare = r31;
        OperationType r32 = new OperationType("OperationSpaceShareContent", 32, 100000003);
        OperationSpaceShareContent = r32;
        OperationType r33 = new OperationType("OperationSpaceMove", 33, 100000004);
        OperationSpaceMove = r33;
        OperationType r34 = new OperationType("OperationCreateCopy", 34, 100000005);
        OperationCreateCopy = r34;
        OperationType r35 = new OperationType("OperationSaveModule", 35, 100000006);
        OperationSaveModule = r35;
        OperationType r36 = new OperationType("OperationSpaceUpdateCollaboratorAuth", 36, 100000007);
        OperationSpaceUpdateCollaboratorAuth = r36;
        OperationType r37 = new OperationType("OperationSpaceMoveOwner", 37, 100000008);
        OperationSpaceMoveOwner = r37;
        OperationType r38 = new OperationType("OperationSpaceViewHistory", 38, 100000009);
        OperationSpaceViewHistory = r38;
        OperationType r39 = new OperationType("OperationSpaceDownLoadHistory", 39, 100000010);
        OperationSpaceDownLoadHistory = r39;
        OperationType r40 = new OperationType("OperationSpaceRecoverHistory", 40, 100000011);
        OperationSpaceRecoverHistory = r40;
        OperationType r41 = new OperationType("OperationSpaceDeleteComment", 41, 100000012);
        OperationSpaceDeleteComment = r41;
        OperationType r42 = new OperationType("OperationSpaceDemoSlides", 42, 100000026);
        OperationSpaceDemoSlides = r42;
        OperationType r43 = new OperationType("OperationSpaceDocClickDocPlugin", 43, 100000028);
        OperationSpaceDocClickDocPlugin = r43;
        OperationType r44 = new OperationType("OperationSpaceDownloadAttachment", 44, 100000031);
        OperationSpaceDownloadAttachment = r44;
        OperationType r45 = new OperationType("OperationIMChatPreviewFile", 45, 200000006);
        OperationIMChatPreviewFile = r45;
        OperationType r46 = new OperationType("OperationIMChatEditImage", 46, 200000008);
        OperationIMChatEditImage = r46;
        OperationType r47 = new OperationType("OperationIMSaveToSpace", 47, 200000010);
        OperationIMSaveToSpace = r47;
        OperationType r48 = new OperationType("OperationIMSnaphot", 48, 200000017);
        OperationIMSnaphot = r48;
        OperationType r49 = new OperationType("OperationIMScreenCap", 49, 200000018);
        OperationIMScreenCap = r49;
        OperationType r50 = new OperationType("OperationIMOCR", 50, 200000019);
        OperationIMOCR = r50;
        OperationType r51 = new OperationType("OperationIMOnlineEdit", 51, 200000020);
        OperationIMOnlineEdit = r51;
        OperationType r52 = new OperationType("OperationCopyPhoneNumber", 52, 300000001);
        OperationCopyPhoneNumber = r52;
        OperationType r53 = new OperationType("OperationCallPhoneNumber", 53, 300000002);
        OperationCallPhoneNumber = r53;
        OperationType r54 = new OperationType("OperationAddPhoneNumberToContacts", 54, 300000003);
        OperationAddPhoneNumberToContacts = r54;
        OperationType r55 = new OperationType("OperationEmailLogin", 55, 1600000017);
        OperationEmailLogin = r55;
        OperationType r56 = new OperationType("OperationEmailDownloadMail", 56, 1600000018);
        OperationEmailDownloadMail = r56;
        OperationType r57 = new OperationType("OperationEmailDownloadFile", 57, 1600000019);
        OperationEmailDownloadFile = r57;
        OperationType r58 = new OperationType("OperationEmailLocalOpen", 58, 1600000020);
        OperationEmailLocalOpen = r58;
        OperationType r59 = new OperationType("OperationEmailShareFile", 59, 1600000021);
        OperationEmailShareFile = r59;
        OperationType r60 = new OperationType("OperationEmailPrint", 60, 1600000022);
        OperationEmailPrint = r60;
        OperationType r61 = new OperationType("OperationEmailCopy", 61, 1600000023);
        OperationEmailCopy = r61;
        OperationType r62 = new OperationType("OperationEmailURLClick", 62, 1600000024);
        OperationEmailURLClick = r62;
        OperationType r63 = new OperationType("OperationEmailLoginThird", 63, 1600000025);
        OperationEmailLoginThird = r63;
        OperationType r64 = new OperationType("OperationEmailEditForward", 64, 1600000026);
        OperationEmailEditForward = r64;
        OperationType r65 = new OperationType("OperationEmailShareMail", 65, 1600000027);
        OperationEmailShareMail = r65;
        OperationType r66 = new OperationType("OperationEmailReplay", 66, 1600000028);
        OperationEmailReplay = r66;
        OperationType r67 = new OperationType("OperationEmailSend", 67, 1600000029);
        OperationEmailSend = r67;
        OperationType r68 = new OperationType("OperationEmailDelete", 68, 1600000030);
        OperationEmailDelete = r68;
        OperationType r69 = new OperationType("OperationEmailRead", 69, 1600000031);
        OperationEmailRead = r69;
        OperationType r70 = new OperationType("OperationEmailMove", 70, 1600000032);
        OperationEmailMove = r70;
        OperationType r71 = new OperationType("OperationEmailEmlAsAttachment", 71, 1600000033);
        OperationEmailEmlAsAttachment = r71;
        OperationType r72 = new OperationType("OperationEmailBatchExport", 72, 1600000034);
        OperationEmailBatchExport = r72;
        OperationType r73 = new OperationType("OperationEmailDelBigFile", 73, 1600000035);
        OperationEmailDelBigFile = r73;
        OperationType r74 = new OperationType("OperationEmailCopyAttachment", 74, 1600000036);
        OperationEmailCopyAttachment = r74;
        OperationType r75 = new OperationType("OperationChatPinBackToChat", 75, 200000201);
        OperationChatPinBackToChat = r75;
        OperationType r76 = new OperationType("OperationChatPinOpenUrl", 76, 200000202);
        OperationChatPinOpenUrl = r76;
        OperationType r77 = new OperationType("OperationChatPinOpenBrowser", 77, 200000203);
        OperationChatPinOpenBrowser = r77;
        OperationType r78 = new OperationType("OperationChatPinCopyUrl", 78, 200000204);
        OperationChatPinCopyUrl = r78;
        OperationType r79 = new OperationType("OperationChatPinShowInChat", 79, 200000205);
        OperationChatPinShowInChat = r79;
        OperationType r80 = new OperationType("OperationChatPinShowPinList", 80, 200000206);
        OperationChatPinShowPinList = r80;
        OperationType r81 = new OperationType("OperationChatPinHoverShow", 81, 200000207);
        OperationChatPinHoverShow = r81;
        OperationType r82 = new OperationType("OperationChatPinSideBarSearch", 82, 200000208);
        OperationChatPinSideBarSearch = r82;
        OperationType r83 = new OperationType("OperationChatPinSideBarFile", 83, 200000209);
        OperationChatPinSideBarFile = r83;
        OperationType r84 = new OperationType("OperationChatPinSideBarAddLink", 84, 200000210);
        OperationChatPinSideBarAddLink = r84;
        OperationType r85 = new OperationType("OperationChatPinSideBarAnnounce", 85, 200000211);
        OperationChatPinSideBarAnnounce = r85;
        OperationType r86 = new OperationType("OperationPassportChangeAccount", 86, 600000003);
        OperationPassportChangeAccount = r86;
        OperationType r87 = new OperationType("OperationDoubaoDownload", 87, 240000001);
        OperationDoubaoDownload = r87;
        OperationType r88 = new OperationType("OperationDoubaoCopy", 88, 240000002);
        OperationDoubaoCopy = r88;
        OperationType r89 = new OperationType("OperationDoubaoShare", 89, 240000003);
        OperationDoubaoShare = r89;
        $VALUES = new OperationType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89};
        ADAPTER = ProtoAdapter.newEnumAdapter(OperationType.class);
    }

    public static OperationType[] values() {
        return (OperationType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static OperationType fromValue(int r0) {
        switch(r0) {
            case 0: goto L191;
            case 1: goto L189;
            case 2: goto L187;
            case 3: goto L185;
            case 4: goto L183;
            case 5: goto L181;
            case 6: goto L179;
            case 7: goto L177;
            case 8: goto L175;
            case 9: goto L173;
            case 10: goto L171;
            case 11: goto L169;
            case 12: goto L167;
            case 13: goto L165;
            case 14: goto L163;
            case 15: goto L161;
            case 16: goto L159;
            case 17: goto L157;
            case 18: goto L155;
            case 19: goto L153;
            case 20: goto L151;
            case 21: goto L149;
            case 22: goto L147;
            case 23: goto L145;
            case 24: goto L143;
            case 25: goto L141;
            case 26: goto L139;
            case 27: goto L137;
            default: goto L3;
        };
    L3:
        switch(r0) {
            case 63: goto L135;
            case 90: goto L133;
            case 100000026: goto L131;
            case 100000028: goto L129;
            case 100000031: goto L127;
            case 200000006: goto L125;
            case 200000008: goto L123;
            case 200000010: goto L121;
            case 600000003: goto L119;
            default: goto L4;
        };
    L4:
        switch(r0) {
            case 100000001: goto L117;
            case 100000002: goto L115;
            case 100000003: goto L113;
            case 100000004: goto L111;
            case 100000005: goto L109;
            case 100000006: goto L107;
            case 100000007: goto L105;
            case 100000008: goto L103;
            case 100000009: goto L101;
            case 100000010: goto L99;
            case 100000011: goto L97;
            case 100000012: goto L95;
            default: goto L5;
        };
    L5:
        switch(r0) {
            case 200000017: goto L93;
            case 200000018: goto L91;
            case 200000019: goto L89;
            case 200000020: goto L87;
            default: goto L6;
        };
    L6:
        switch(r0) {
            case 200000201: goto L85;
            case 200000202: goto L83;
            case 200000203: goto L81;
            case 200000204: goto L79;
            case 200000205: goto L77;
            case 200000206: goto L75;
            case 200000207: goto L73;
            case 200000208: goto L71;
            case 200000209: goto L69;
            case 200000210: goto L67;
            case 200000211: goto L65;
            default: goto L7;
        };
    L7:
        switch(r0) {
            case 240000001: goto L63;
            case 240000002: goto L61;
            case 240000003: goto L59;
            default: goto L8;
        };
    L8:
        switch(r0) {
            case 300000001: goto L57;
            case 300000002: goto L55;
            case 300000003: goto L53;
            default: goto L9;
        };
    L9:
        switch(r0) {
            case 1600000017: goto L51;
            case 1600000018: goto L49;
            case 1600000019: goto L47;
            case 1600000020: goto L45;
            case 1600000021: goto L43;
            case 1600000022: goto L41;
            case 1600000023: goto L39;
            case 1600000024: goto L37;
            case 1600000025: goto L35;
            case 1600000026: goto L33;
            case 1600000027: goto L31;
            case 1600000028: goto L29;
            case 1600000029: goto L27;
            case 1600000030: goto L25;
            case 1600000031: goto L23;
            case 1600000032: goto L21;
            case 1600000033: goto L19;
            case 1600000034: goto L17;
            case 1600000035: goto L15;
            case 1600000036: goto L13;
            default: goto L10;
        };
    L10:
        return null;
    L13:
        return OperationEmailCopyAttachment;
    L15:
        return OperationEmailDelBigFile;
    L17:
        return OperationEmailBatchExport;
    L19:
        return OperationEmailEmlAsAttachment;
    L21:
        return OperationEmailMove;
    L23:
        return OperationEmailRead;
    L25:
        return OperationEmailDelete;
    L27:
        return OperationEmailSend;
    L29:
        return OperationEmailReplay;
    L31:
        return OperationEmailShareMail;
    L33:
        return OperationEmailEditForward;
    L35:
        return OperationEmailLoginThird;
    L37:
        return OperationEmailURLClick;
    L39:
        return OperationEmailCopy;
    L41:
        return OperationEmailPrint;
    L43:
        return OperationEmailShareFile;
    L45:
        return OperationEmailLocalOpen;
    L47:
        return OperationEmailDownloadFile;
    L49:
        return OperationEmailDownloadMail;
    L51:
        return OperationEmailLogin;
    L53:
        return OperationAddPhoneNumberToContacts;
    L55:
        return OperationCallPhoneNumber;
    L57:
        return OperationCopyPhoneNumber;
    L59:
        return OperationDoubaoShare;
    L61:
        return OperationDoubaoCopy;
    L63:
        return OperationDoubaoDownload;
    L65:
        return OperationChatPinSideBarAnnounce;
    L67:
        return OperationChatPinSideBarAddLink;
    L69:
        return OperationChatPinSideBarFile;
    L71:
        return OperationChatPinSideBarSearch;
    L73:
        return OperationChatPinHoverShow;
    L75:
        return OperationChatPinShowPinList;
    L77:
        return OperationChatPinShowInChat;
    L79:
        return OperationChatPinCopyUrl;
    L81:
        return OperationChatPinOpenBrowser;
    L83:
        return OperationChatPinOpenUrl;
    L85:
        return OperationChatPinBackToChat;
    L87:
        return OperationIMOnlineEdit;
    L89:
        return OperationIMOCR;
    L91:
        return OperationIMScreenCap;
    L93:
        return OperationIMSnaphot;
    L95:
        return OperationSpaceDeleteComment;
    L97:
        return OperationSpaceRecoverHistory;
    L99:
        return OperationSpaceDownLoadHistory;
    L101:
        return OperationSpaceViewHistory;
    L103:
        return OperationSpaceMoveOwner;
    L105:
        return OperationSpaceUpdateCollaboratorAuth;
    L107:
        return OperationSaveModule;
    L109:
        return OperationCreateCopy;
    L111:
        return OperationSpaceMove;
    L113:
        return OperationSpaceShareContent;
    L115:
        return OperationSpaceShare;
    L117:
        return OperationCreateSpaceCopy;
    L119:
        return OperationPassportChangeAccount;
    L121:
        return OperationIMSaveToSpace;
    L123:
        return OperationIMChatEditImage;
    L125:
        return OperationIMChatPreviewFile;
    L127:
        return OperationSpaceDownloadAttachment;
    L129:
        return OperationSpaceDocClickDocPlugin;
    L131:
        return OperationSpaceDemoSlides;
    L133:
        return OperationScreenRecording;
    L135:
        return OperationScreenShot;
    L137:
        return OperationLookProfile;
    L139:
        return OperationObtainMobile;
    L141:
        return OperationLookDeptStruct;
    L143:
        return OperationUploadCalendarAppendix;
    L145:
        return OperationStartExternalChat;
    L147:
        return OperationAddExternalFriend;
    L149:
        return OperationLoadToLocal;
    L151:
        return OperationForward;
    L153:
        return OperationCopyContent;
    L155:
        return OperationSaveAs;
    L157:
        return OperationQuit;
    L159:
        return OperationJoin;
    L161:
        return OperationLogin;
    L163:
        return OperationImport;
    L165:
        return OperationOpenWith3rdApp;
    L167:
        return OperationFrontExport;
    L169:
        return OperationUpdateShareSetting;
    L171:
        return OperationShareTo3rdApp;
    L173:
        return OperationUpdateCollaborator;
    L175:
        return OperationPrint;
    L177:
        return OperationDownload;
    L179:
        return OperationExport;
    L181:
        return OperationComment;
    L183:
        return OperationDelete;
    L185:
        return OperationUpdate;
    L187:
        return OperationRead;
    L189:
        return OperationCreate;
    L191:
        return OperationTypeUnknown;
    }

    public static OperationType valueOf(String r1) {
        return (OperationType) a.a(OperationType.class, r1);
    }

    private OperationType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
