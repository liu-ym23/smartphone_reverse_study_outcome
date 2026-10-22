package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum EntityType extends Enum<EntityType> implements WireEnum {
    private static final /* synthetic */ EntityType[] $VALUES = null;
    public static final ProtoAdapter<EntityType> ADAPTER = null;
    public static final EntityType EntityBitableID = null;
    public static final EntityType EntityBotID = null;
    public static final EntityType EntityCCMSpace = null;
    public static final EntityType EntityChatID = null;
    public static final EntityType EntityChatPinId = null;
    public static final EntityType EntityChatter = null;
    public static final EntityType EntityDepartmentID = null;
    public static final EntityType EntityDevice = null;
    public static final EntityType EntityDocID = null;
    public static final EntityType EntityDocxID = null;
    public static final EntityType EntityDoubaoChatID = null;
    public static final EntityType EntityDriverSDKFileID = null;
    public static final EntityType EntityEmailAttachment = null;
    public static final EntityType EntityEmailContent = null;
    public static final EntityType EntityEmailGroup = null;
    public static final EntityType EntityEmailSubject = null;
    public static final EntityType EntityFileID = null;
    public static final EntityType EntityFileIM = null;
    public static final EntityType EntityFolderID = null;
    public static final EntityType EntityIMContent = null;
    public static final EntityType EntityImage = null;
    public static final EntityType EntityLink = null;
    public static final EntityType EntityLocalFile = null;
    public static final EntityType EntityMiaodaApplication = null;
    public static final EntityType EntityMiaodaProduct = null;
    public static final EntityType EntityMindNoteID = null;
    public static final EntityType EntityMiniProgramsAndH5 = null;
    public static final EntityType EntityMomentsComment = null;
    public static final EntityType EntityMomentsImage = null;
    public static final EntityType EntityMomentsPost = null;
    public static final EntityType EntityMomentsPostDetail = null;
    public static final EntityType EntityMomentsVideo = null;
    public static final EntityType EntityOKRType = null;
    public static final EntityType EntityPublicEmail = null;
    public static final EntityType EntitySheetID = null;
    public static final EntityType EntitySlideID = null;
    public static final EntityType EntitySlidesDocs = null;
    public static final EntityType EntityTenantID = null;
    public static final EntityType EntityTypeUnknown = null;
    public static final EntityType EntityUserEmail = null;
    public static final EntityType EntityUserID = null;
    public static final EntityType EntityUserMobile = null;
    public static final EntityType EntityVideoID = null;
    public static final EntityType EntityVideoIM = null;
    public static final EntityType EntityWikiToken = null;
    private final int value;

    static {
        EntityType r0 = new EntityType("EntityTypeUnknown", 0, 0);
        EntityTypeUnknown = r0;
        EntityType r1 = new EntityType("EntityUserID", 1, 1);
        EntityUserID = r1;
        EntityType r3 = new EntityType("EntityDepartmentID", 2, 2);
        EntityDepartmentID = r3;
        EntityType r5 = new EntityType("EntityTenantID", 3, 3);
        EntityTenantID = r5;
        EntityType r7 = new EntityType("EntityChatID", 4, 4);
        EntityChatID = r7;
        EntityType r9 = new EntityType("EntityDocID", 5, 5);
        EntityDocID = r9;
        EntityType r11 = new EntityType("EntitySheetID", 6, 6);
        EntitySheetID = r11;
        EntityType r13 = new EntityType("EntityFileID", 7, 7);
        EntityFileID = r13;
        EntityType r15 = new EntityType("EntityFolderID", 8, 8);
        EntityFolderID = r15;
        EntityType r14 = new EntityType("EntityMindNoteID", 9, 9);
        EntityMindNoteID = r14;
        EntityType r12 = new EntityType("EntityBitableID", 10, 10);
        EntityBitableID = r12;
        EntityType r10 = new EntityType("EntitySlideID", 11, 11);
        EntitySlideID = r10;
        EntityType r8 = new EntityType("EntityBotID", 12, 12);
        EntityBotID = r8;
        EntityType r6 = new EntityType("EntityVideoID", 13, 13);
        EntityVideoID = r6;
        EntityType r4 = new EntityType("EntityDriverSDKFileID", 14, 14);
        EntityDriverSDKFileID = r4;
        EntityType r2 = new EntityType("EntityLink", 15, 15);
        EntityLink = r2;
        EntityType r16 = new EntityType("EntityChatter", 16, 16);
        EntityChatter = r16;
        EntityType r17 = new EntityType("EntityImage", 17, 17);
        EntityImage = r17;
        EntityType r18 = new EntityType("EntityVideoIM", 18, 18);
        EntityVideoIM = r18;
        EntityType r19 = new EntityType("EntityFileIM", 19, 19);
        EntityFileIM = r19;
        EntityType r20 = new EntityType("EntityMiniProgramsAndH5", 20, 20);
        EntityMiniProgramsAndH5 = r20;
        EntityType r21 = new EntityType("EntityLocalFile", 21, 21);
        EntityLocalFile = r21;
        EntityType r22 = new EntityType("EntityUserEmail", 22, 22);
        EntityUserEmail = r22;
        EntityType r23 = new EntityType("EntityPublicEmail", 23, 23);
        EntityPublicEmail = r23;
        EntityType r24 = new EntityType("EntityEmailGroup", 24, 24);
        EntityEmailGroup = r24;
        EntityType r25 = new EntityType("EntityUserMobile", 25, 25);
        EntityUserMobile = r25;
        EntityType r26 = new EntityType("EntityEmailContent", 26, 26);
        EntityEmailContent = r26;
        EntityType r27 = new EntityType("EntityEmailSubject", 27, 27);
        EntityEmailSubject = r27;
        EntityType r28 = new EntityType("EntityEmailAttachment", 28, 28);
        EntityEmailAttachment = r28;
        EntityType r29 = new EntityType("EntityOKRType", 29, 29);
        EntityOKRType = r29;
        EntityType r30 = new EntityType("EntityIMContent", 30, 30);
        EntityIMContent = r30;
        EntityType r31 = new EntityType("EntityDocxID", 31, 31);
        EntityDocxID = r31;
        EntityType r32 = new EntityType("EntityDevice", 32, 45);
        EntityDevice = r32;
        EntityType r33 = new EntityType("EntityMomentsPost", 33, 75);
        EntityMomentsPost = r33;
        EntityType r34 = new EntityType("EntityMomentsComment", 34, 76);
        EntityMomentsComment = r34;
        EntityType r35 = new EntityType("EntityMomentsImage", 35, 77);
        EntityMomentsImage = r35;
        EntityType r36 = new EntityType("EntityMomentsVideo", 36, 78);
        EntityMomentsVideo = r36;
        EntityType r37 = new EntityType("EntitySlidesDocs", 37, 106);
        EntitySlidesDocs = r37;
        EntityType r38 = new EntityType("EntityCCMSpace", 38, 107);
        EntityCCMSpace = r38;
        EntityType r39 = new EntityType("EntityWikiToken", 39, 144);
        EntityWikiToken = r39;
        EntityType r40 = new EntityType("EntityMomentsPostDetail", 40, 2001);
        EntityMomentsPostDetail = r40;
        EntityType r41 = new EntityType("EntityChatPinId", 41, 499);
        EntityChatPinId = r41;
        EntityType r42 = new EntityType("EntityDoubaoChatID", 42, 60001);
        EntityDoubaoChatID = r42;
        EntityType r43 = new EntityType("EntityMiaodaProduct", 43, 70007);
        EntityMiaodaProduct = r43;
        EntityType r44 = new EntityType("EntityMiaodaApplication", 44, 70008);
        EntityMiaodaApplication = r44;
        $VALUES = new EntityType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44};
        ADAPTER = ProtoAdapter.newEnumAdapter(EntityType.class);
    }

    public static EntityType[] values() {
        return (EntityType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static EntityType fromValue(int r1) {
        if (r1 == 45) goto L110;
        if (r1 == 144) goto L108;
        if (r1 == 499) goto L106;
        if (r1 == 2001) goto L104;
        if (r1 == 60001) goto L102;
        if (r1 == 106) goto L100;
        if (r1 == 107) goto L98;
        switch(r1) {
            case 0: goto L96;
            case 1: goto L94;
            case 2: goto L92;
            case 3: goto L90;
            case 4: goto L88;
            case 5: goto L86;
            case 6: goto L84;
            case 7: goto L82;
            case 8: goto L80;
            case 9: goto L78;
            case 10: goto L76;
            case 11: goto L74;
            case 12: goto L72;
            case 13: goto L70;
            case 14: goto L68;
            case 15: goto L66;
            case 16: goto L64;
            case 17: goto L62;
            case 18: goto L60;
            case 19: goto L58;
            case 20: goto L56;
            case 21: goto L54;
            case 22: goto L52;
            case 23: goto L50;
            case 24: goto L48;
            case 25: goto L46;
            case 26: goto L44;
            case 27: goto L42;
            case 28: goto L40;
            case 29: goto L38;
            case 30: goto L36;
            case 31: goto L34;
            default: goto L17;
        };
    L17:
        switch(r1) {
            case 75: goto L32;
            case 76: goto L30;
            case 77: goto L28;
            case 78: goto L26;
            default: goto L18;
        };
    L18:
        switch(r1) {
            case 70007: goto L24;
            case 70008: goto L22;
            default: goto L19;
        };
    L19:
        return null;
    L22:
        return EntityMiaodaApplication;
    L24:
        return EntityMiaodaProduct;
    L26:
        return EntityMomentsVideo;
    L28:
        return EntityMomentsImage;
    L30:
        return EntityMomentsComment;
    L32:
        return EntityMomentsPost;
    L34:
        return EntityDocxID;
    L36:
        return EntityIMContent;
    L38:
        return EntityOKRType;
    L40:
        return EntityEmailAttachment;
    L42:
        return EntityEmailSubject;
    L44:
        return EntityEmailContent;
    L46:
        return EntityUserMobile;
    L48:
        return EntityEmailGroup;
    L50:
        return EntityPublicEmail;
    L52:
        return EntityUserEmail;
    L54:
        return EntityLocalFile;
    L56:
        return EntityMiniProgramsAndH5;
    L58:
        return EntityFileIM;
    L60:
        return EntityVideoIM;
    L62:
        return EntityImage;
    L64:
        return EntityChatter;
    L66:
        return EntityLink;
    L68:
        return EntityDriverSDKFileID;
    L70:
        return EntityVideoID;
    L72:
        return EntityBotID;
    L74:
        return EntitySlideID;
    L76:
        return EntityBitableID;
    L78:
        return EntityMindNoteID;
    L80:
        return EntityFolderID;
    L82:
        return EntityFileID;
    L84:
        return EntitySheetID;
    L86:
        return EntityDocID;
    L88:
        return EntityChatID;
    L90:
        return EntityTenantID;
    L92:
        return EntityDepartmentID;
    L94:
        return EntityUserID;
    L96:
        return EntityTypeUnknown;
    L98:
        return EntityCCMSpace;
    L100:
        return EntitySlidesDocs;
    L102:
        return EntityDoubaoChatID;
    L104:
        return EntityMomentsPostDetail;
    L106:
        return EntityChatPinId;
    L108:
        return EntityWikiToken;
    L110:
        return EntityDevice;
    }

    public static EntityType valueOf(String r1) {
        return (EntityType) a.a(EntityType.class, r1);
    }

    private EntityType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
