package com.ss.android.lark.contact.entity.mobile;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/contact/entity/mobile/LeaderType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "stringRes", "<init>", "(Ljava/lang/String;III)V", "getValue", "()I", "getStringRes", "MAINLEADER", "SUBLEADER", "ENTERPRISELEADER", "Companion", "contact-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LeaderType extends Enum<LeaderType> {
    public static final a Companion = null;
    public static final LeaderType ENTERPRISELEADER = null;
    public static final LeaderType MAINLEADER = null;
    public static final LeaderType SUBLEADER = null;
    public static final Lazy<LeaderType[]> a = null;
    public static final /* synthetic */ LeaderType[] b = null;
    public static final /* synthetic */ EnumEntries c = null;
    private final int stringRes;
    private final int value;

    public static EnumEntries<LeaderType> getEntries() {
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.contact.entity.mobile.LeaderType$a] */
    static {
        LeaderType r0 = new LeaderType("MAINLEADER", 0, 1, 2131892757);
        MAINLEADER = r0;
        LeaderType r1 = new LeaderType("SUBLEADER", 1, 2, 2131892758);
        SUBLEADER = r1;
        LeaderType r4 = new LeaderType("ENTERPRISELEADER", 2, 3, 2131892756);
        ENTERPRISELEADER = r4;
        LeaderType[] r6 = {r0, r1, r4};
        b = r6;
        c = EnumEntriesKt.enumEntries(r6);
        Companion = new a();
        a = LazyKt.lazy(LeaderType$Companion$values$2.INSTANCE);
    }

    public static LeaderType[] values() {
        return (LeaderType[]) b.clone();
    }

    public static final /* synthetic */ Lazy access$getValues$delegate$cp() {
        return a;
    }

    public final int getStringRes() {
        return this.stringRes;
    }

    public final int getValue() {
        return this.value;
    }

    public static LeaderType valueOf(String r1) {
        return (LeaderType) r27.a.a(LeaderType.class, r1);
    }

    public LeaderType(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.value = r3;
        this.stringRes = r4;
    }
}
