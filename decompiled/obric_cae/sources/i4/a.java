package i4;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;

/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {
    public static final a A = null;
    public static final a B = null;
    public static final a C = null;
    public static final a D = null;
    public static final a E = null;
    public static final a F = null;
    public static final a G = null;
    public static final a H = null;
    public static final a I = null;
    public static final a J = null;
    public static final /* synthetic */ a[] K = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8136b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f8137m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f8138n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f8139o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f8140p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f8141q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f8142r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f8143s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f8144t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f8145u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f8146v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f8147w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f8148x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f8149y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a f8150z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8151a;

    static {
        a r8 = new a(BdimCategoryConstants.VALUE_UNKNOWN, 0, "-1");
        f8136b = r8;
        a r10 = new a("COLLECTED", 1, "00");
        f8137m = r10;
        a r11 = new a("PARAMS_INVALID_DROP", 2, "01");
        f8138n = r11;
        a r12 = new a("NOT_INIT_DROP", 3, "02");
        a r13 = new a("PRE_PROCESS_START", 4, "03");
        f8139o = r13;
        a r14 = new a("CACHED_BEFORE_HANDLE", 5, "04");
        f8140p = r14;
        a r15 = new a("CACHE_DROP_BEFORE_HANDLE", 6, "05");
        f8141q = r15;
        a r16 = new a("DATA_LIST_ADDED", 7, "06");
        f8142r = r16;
        a r17 = new a("PRE_QUEUE_OVERFLOW", 8, "07");
        a r18 = new a("PRE_EVENT_BLOCKED", 9, "08");
        a r19 = new a("PRE_PROCESS_END", 10, "0F");
        f8143s = r19;
        a r110 = new a("PROCESS_START", 11, "10");
        f8144t = r110;
        a r111 = new a("TOURIST_BREAK", 12, "11");
        a r20 = new a("FILTER_EVENT_BLOCKED", 13, "12");
        a r21 = new a("FILTER_SERVER_BLOCKED", 14, "13");
        f8145u = r21;
        a r22 = new a("FILTER_CUSTOM_BLOCKED", 15, "14");
        f8146v = r22;
        a r23 = new a("FILTER_SAMPLING_DROPPED", 16, "15");
        f8147w = r23;
        a r24 = new a("NO_SESSION_DROP", 17, "16");
        a r25 = new a("PROCESS_END", 18, "1F");
        f8148x = r25;
        a r26 = new a("DB_SAVE_START", 19, "20");
        f8149y = r26;
        a r27 = new a("HANDLE_REALTIME_START", 20, "21");
        f8150z = r27;
        a r28 = new a("REALTIME_SEND_START", 21, BDLocationException.ERROR_AMAP_FAIL);
        A = r28;
        a r29 = new a("REALTIME_SEND_FAILED", 22, "23");
        B = r29;
        a r30 = new a("REALTIME_CRASH_DROP", 23, BDLocationException.ERROR_UNKNOWN);
        a r31 = new a("PRIORITY_HANDLE", 24, BDLocationException.ERROR_SDK_START_FAIL);
        a r32 = new a("PRIORITY_ACCEPT", 25, "29");
        a r33 = new a("DB_INSERT_START", 26, "2A");
        C = r33;
        a r34 = new a("DB_SAVE_FAILED", 27, "2B");
        D = r34;
        a r35 = new a("DB_SAVE_END", 28, "2F");
        E = r35;
        a r36 = new a("REPORT_START", 29, BDLocationException.ERROR_SDK_NO_PERMISSION);
        a r37 = new a("PACK_END", 30, "31");
        a r38 = new a("PACK_INSERT_START", 31, BDLocationException.ERROR_ABNORMAL_NETWORK);
        F = r38;
        a r39 = new a("PACK_INSERT_FAILED", 32, "35");
        a r40 = new a("PACK_INSERT_END", 33, BDLocationException.ERROR_BACKGROUND_LOCATE);
        G = r40;
        a r41 = new a("POST_START", 34, "3A");
        H = r41;
        a r42 = new a("POST_FAILED", 35, "3B");
        I = r42;
        a r43 = new a("REPORT_END", 36, "3F");
        J = r43;
        K = new a[]{r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43};
    }

    public a(String r8, int r10, String r11) {
        super(r8, r10);
        this.f8151a = r11;
    }

    public static a valueOf(String r8) {
        return (a) Enum.valueOf(a.class, r8);
    }

    public static a[] values() {
        return (a[]) K.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f8151a;
    }
}
