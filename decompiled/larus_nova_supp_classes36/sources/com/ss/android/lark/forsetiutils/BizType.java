package com.ss.android.lark.forsetiutils;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/forsetiutils/BizType;", "", TabAppInfo.IMAGE_JSON_KEY, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "VC", "CCM", "MAIL", "OPEN_PLATFORM", "SECURITY", "CALENDAR", "PASSPORT", "BASE", "SEARCH", "IM", "MIN_APP", "MEEGO", "WORKPLACE", "forseti-utils_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum BizType extends Enum<BizType> {
    public static final BizType BASE = null;
    public static final BizType CALENDAR = null;
    public static final BizType CCM = null;
    public static final BizType IM = null;
    public static final BizType MAIL = null;
    public static final BizType MEEGO = null;
    public static final BizType MIN_APP = null;
    public static final BizType OPEN_PLATFORM = null;
    public static final BizType PASSPORT = null;
    public static final BizType SEARCH = null;
    public static final BizType SECURITY = null;
    public static final BizType VC = null;
    public static final BizType WORKPLACE = null;
    public static final /* synthetic */ BizType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String key;

    public static EnumEntries<BizType> getEntries() {
        return b;
    }

    static {
        BizType r0 = new BizType("VC", 0, "vc");
        VC = r0;
        BizType r1 = new BizType("CCM", 1, "ccm");
        CCM = r1;
        BizType r2 = new BizType("MAIL", 2, IOfflineExtraParser.ParserType.MAIL);
        MAIL = r2;
        BizType r4 = new BizType("OPEN_PLATFORM", 3, "open_platform");
        OPEN_PLATFORM = r4;
        BizType r6 = new BizType("SECURITY", 4, "security");
        SECURITY = r6;
        BizType r8 = new BizType("CALENDAR", 5, IOfflineExtraParser.ParserType.CALENDAR);
        CALENDAR = r8;
        BizType r10 = new BizType("PASSPORT", 6, "passport");
        PASSPORT = r10;
        BizType r12 = new BizType("BASE", 7, "base");
        BASE = r12;
        BizType r14 = new BizType("SEARCH", 8, LocationHitPoint$ResultType.SEARCH);
        SEARCH = r14;
        BizType r13 = new BizType("IM", 9, "im");
        IM = r13;
        BizType r11 = new BizType("MIN_APP", 10, "min_app");
        MIN_APP = r11;
        BizType r9 = new BizType("MEEGO", 11, "meego");
        MEEGO = r9;
        BizType r7 = new BizType("WORKPLACE", 12, "workplace");
        WORKPLACE = r7;
        BizType[] r5 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static BizType[] values() {
        return (BizType[]) a.clone();
    }

    public final String getKey() {
        return this.key;
    }

    public static BizType valueOf(String r1) {
        return (BizType) r27.a.a(BizType.class, r1);
    }

    public BizType(String r1, int r2, String r3) {
        super(r1, r2);
        this.key = r3;
    }
}
