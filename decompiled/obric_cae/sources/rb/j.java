package rb;

import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes2.dex */
public final enum j extends Enum<j> implements WireEnum {
    public static final j A = null;
    public static final j B = null;
    public static final j C = null;
    public static final /* synthetic */ j[] D = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f11637b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final j f11638m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final j f11639n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final j f11640o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final j f11641p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final j f11642q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final j f11643r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final j f11644s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final j f11645t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final j f11646u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final j f11647v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final j f11648w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final j f11649x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final j f11650y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final j f11651z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11652a;

    static {
        j r8 = new j("CMD_NOT_USED", 0, 0);
        f11637b = r8;
        j r10 = new j("CMD_BIZ_EXAMPLE", 1, 100000);
        f11638m = r10;
        j r11 = new j("CMD_SEND_WS_MESSAGE", 2, 101001);
        f11639n = r11;
        j r12 = new j("CMD_SUBSCRIBE_WS_MSG", 3, 101002);
        f11640o = r12;
        j r13 = new j("CMD_SUBSCRIBE_WS_STATUS", 4, 101003);
        f11641p = r13;
        j r14 = new j("CMD_SUBSCRIBE_WS_MSG_PROVIDER", 5, 101004);
        f11642q = r14;
        j r15 = new j("CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK", 6, 101005);
        f11643r = r15;
        j r16 = new j("CMD_SUBSCRIBE_WS_MSG_BY_BROADCAST", 7, 101006);
        f11644s = r16;
        j r17 = new j("CMD_GET_LOCATION", 8, 102001);
        f11645t = r17;
        j r18 = new j("CMD_REFRESH_LOCATION", 9, 102002);
        f11646u = r18;
        j r19 = new j("CMD_DECODE_LOCATION", 10, 102003);
        f11647v = r19;
        j r110 = new j("CMD_GET_INTERSECT_FENCES", 11, 102004);
        f11648w = r110;
        j r111 = new j("CMD_PRIVATE_START_PICO_LINKS", 12, 111001);
        f11649x = r111;
        j r20 = new j("CMD_PRIVATE_PICO_LINKS_CALLBACK", 13, 111002);
        f11650y = r20;
        j r21 = new j("CMD_PRIVATE_COMMON_NET_REQUEST", 14, 112001);
        f11651z = r21;
        j r22 = new j("CMD_PRIVATE_SEND_APPLOG_EVENT", 15, 112002);
        A = r22;
        j r23 = new j("CMD_SEND_NETWORK_REQUEST", 16, 112003);
        B = r23;
        j r24 = new j("CMD_GET_TTNET_PARAMETERS", 17, 112004);
        C = r24;
        D = new j[]{r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, r21, r22, r23, r24};
        new a();
    }

    public j(String r8, int r10, int r11) {
        super(r8, r10);
        this.f11652a = r11;
    }

    public static j valueOf(String r8) {
        return (j) Enum.valueOf(j.class, r8);
    }

    public static j[] values() {
        return (j[]) D.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.f11652a;
    }
}
