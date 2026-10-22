package com.bytedance.iesgurd.core;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/iesgurd/core/EventSubType;", "", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum EventSubType extends Enum<EventSubType> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EventSubType f6599b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EventSubType f6600c = null;
    public static final EventSubType d = null;
    public static final EventSubType e = null;
    public static final EventSubType f = null;
    public static final EventSubType g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final EventSubType f6601h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final EventSubType f6602i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final EventSubType f6603j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final EventSubType f6604k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final EventSubType f6605l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final EventSubType f6606m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final EventSubType f6607n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final EventSubType f6608o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final EventSubType f6609p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final EventSubType f6610q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final EventSubType f6611r = null;
    public static final EventSubType s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final EventSubType f6612t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final EventSubType f6613u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ EventSubType[] f6614v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6615a;

    static {
        EventSubType r5 = new EventSubType("RIGISTER_CLASS", 0, IDLXBridgeMethod.NETWORK_UNREACHABLE);
        f6599b = r5;
        EventSubType r10 = new EventSubType("CHECK_UPDATE_BEFORE_INIT", 1, 1);
        f6600c = r10;
        EventSubType r11 = new EventSubType("EXTERNAL_DIR", 2, 9);
        d = r11;
        EventSubType r12 = new EventSubType("OVERRIDE_PATH", 3, 10);
        EventSubType r13 = new EventSubType("DIFFERENT_PATH_FOR_AK", 4, 11);
        e = r13;
        EventSubType r14 = new EventSubType("SERVICE_MANAGER", 5, 12);
        EventSubType r15 = new EventSubType("BLOCK_IO_ERROR", 6, 49);
        EventSubType r16 = new EventSubType("BLOCK_DOWNLOAD_ERROR", 7, 50);
        EventSubType r17 = new EventSubType("META_DATA_MOVE", 8, 51);
        EventSubType r18 = new EventSubType("FILE_BROKEN", 9, 1101);
        f = r18;
        EventSubType r19 = new EventSubType("META_PARSE_KEY_ERROR", 10, 3010);
        g = r19;
        EventSubType r110 = new EventSubType("META_PARSE_VALUE_ERROR", 11, 3011);
        f6601h = r110;
        EventSubType r111 = new EventSubType("META_PARSE_ERROR", 12, 3012);
        f6602i = r111;
        EventSubType r20 = new EventSubType("META_PRE_DOWNLOAD_ERROR", 13, 3020);
        f6603j = r20;
        EventSubType r21 = new EventSubType("META_CHECK_DIR_ERROR", 14, 3021);
        f6604k = r21;
        EventSubType r22 = new EventSubType("META_CHANNEL_FILE_NOT_EXIST", 15, 3022);
        f6605l = r22;
        EventSubType r23 = new EventSubType("META_VERSION_FILE_NOT_EXIST", 16, 3023);
        f6606m = r23;
        EventSubType r24 = new EventSubType("WRITE_BROKEN_CHUNK", 17, 4001);
        EventSubType r25 = new EventSubType("CHUNK_CONTENT_BROKEN", 18, 4002);
        f6607n = r25;
        EventSubType r26 = new EventSubType("BLOCK_FILE_NOT_EXIST", 19, 4003);
        f6608o = r26;
        EventSubType r27 = new EventSubType("BLOCK_INDEXING_NOT_EXIST", 20, 4004);
        f6609p = r27;
        EventSubType r28 = new EventSubType("MULTI_VERSION", 21, 20250301);
        f6610q = r28;
        EventSubType r29 = new EventSubType("FILE_LOCK", 22, 20250401);
        f6611r = r29;
        EventSubType r30 = new EventSubType("FILE_UNLOCK", 23, 20250402);
        s = r30;
        EventSubType r31 = new EventSubType("WRITE_AFTER_FINISH", 24, 20250403);
        f6612t = r31;
        EventSubType r32 = new EventSubType("WRITE_AFTER_RELEASE", 25, 20250404);
        f6613u = r32;
        f6614v = new EventSubType[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32};
    }

    public EventSubType(String r5, int r10, int r11) {
        super(r5, r10);
        this.f6615a = r11;
    }

    public static EventSubType valueOf(String r5) {
        return (EventSubType) Enum.valueOf(EventSubType.class, r5);
    }

    public static EventSubType[] values() {
        return (EventSubType[]) f6614v.clone();
    }
}
