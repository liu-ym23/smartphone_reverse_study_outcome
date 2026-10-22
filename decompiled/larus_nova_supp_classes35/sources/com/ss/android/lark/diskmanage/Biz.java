package com.ss.android.lark.diskmanage;

import com.ss.android.lark.chat.constant.ChatFromType;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/diskmanage/Biz;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEFAULT", "RUST", "MESSENGER", "PASSPORT", "CALENDAR", "DOCS", "VC", "MIN_APP", "MAIL", "SECURITY_AND_COMPLIANCE", "WEB_CONTAINER_DOWNLOAD", "VC_MINUTES", "WORKPLACE", "disk-manage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Biz extends Enum<Biz> {
    public static final Biz CALENDAR = null;
    public static final Biz DEFAULT = null;
    public static final Biz DOCS = null;
    public static final Biz MAIL = null;
    public static final Biz MESSENGER = null;
    public static final Biz MIN_APP = null;
    public static final Biz PASSPORT = null;
    public static final Biz RUST = null;
    public static final Biz SECURITY_AND_COMPLIANCE = null;
    public static final Biz VC = null;
    public static final Biz VC_MINUTES = null;
    public static final Biz WEB_CONTAINER_DOWNLOAD = null;
    public static final Biz WORKPLACE = null;
    public static final /* synthetic */ Biz[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<Biz> getEntries() {
        return b;
    }

    static {
        Biz r0 = new Biz("DEFAULT", 0, "default");
        DEFAULT = r0;
        Biz r1 = new Biz("RUST", 1, "rust");
        RUST = r1;
        Biz r2 = new Biz("MESSENGER", 2, "messenger");
        MESSENGER = r2;
        Biz r4 = new Biz("PASSPORT", 3, "passport");
        PASSPORT = r4;
        Biz r6 = new Biz("CALENDAR", 4, ChatFromType.CALENDAR);
        CALENDAR = r6;
        Biz r8 = new Biz("DOCS", 5, "docs");
        DOCS = r8;
        Biz r10 = new Biz("VC", 6, "vc");
        VC = r10;
        Biz r12 = new Biz("MIN_APP", 7, "min_app");
        MIN_APP = r12;
        Biz r14 = new Biz("MAIL", 8, "mail");
        MAIL = r14;
        Biz r13 = new Biz("SECURITY_AND_COMPLIANCE", 9, "security_and_compliance");
        SECURITY_AND_COMPLIANCE = r13;
        Biz r11 = new Biz("WEB_CONTAINER_DOWNLOAD", 10, "web_container_download");
        WEB_CONTAINER_DOWNLOAD = r11;
        Biz r9 = new Biz("VC_MINUTES", 11, "vc_minutes");
        VC_MINUTES = r9;
        Biz r7 = new Biz("WORKPLACE", 12, "workplace");
        WORKPLACE = r7;
        Biz[] r5 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static Biz[] values() {
        return (Biz[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static Biz valueOf(String r1) {
        return (Biz) a.a(Biz.class, r1);
    }

    public Biz(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
