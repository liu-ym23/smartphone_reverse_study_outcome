package com.ss.android.lark.ding.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/ding/entity/DingInaccessibleCode;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "DEFAULT", "EMPTY_NAME", "EMPTY_PHONE", "CROSS_PLATFORM", "NOT_FRIEND", "USER_SETTING_DISABLED", "getValue", "Companion", "ding-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DingInaccessibleCode extends Enum<DingInaccessibleCode> {
    public static final DingInaccessibleCode CROSS_PLATFORM = null;
    public static final a Companion = null;
    public static final DingInaccessibleCode DEFAULT = null;
    public static final DingInaccessibleCode EMPTY_NAME = null;
    public static final DingInaccessibleCode EMPTY_PHONE = null;
    public static final DingInaccessibleCode NOT_FRIEND = null;
    public static final DingInaccessibleCode USER_SETTING_DISABLED = null;
    public static final /* synthetic */ DingInaccessibleCode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DingInaccessibleCode> getEntries() {
        return b;
    }

    static {
        DingInaccessibleCode r0 = new DingInaccessibleCode("DEFAULT", 0, 0);
        DEFAULT = r0;
        DingInaccessibleCode r1 = new DingInaccessibleCode("EMPTY_NAME", 1, 1);
        EMPTY_NAME = r1;
        DingInaccessibleCode r3 = new DingInaccessibleCode("EMPTY_PHONE", 2, 2);
        EMPTY_PHONE = r3;
        DingInaccessibleCode r5 = new DingInaccessibleCode("CROSS_PLATFORM", 3, 3);
        CROSS_PLATFORM = r5;
        DingInaccessibleCode r7 = new DingInaccessibleCode("NOT_FRIEND", 4, 4);
        NOT_FRIEND = r7;
        DingInaccessibleCode r9 = new DingInaccessibleCode("USER_SETTING_DISABLED", 5, 5);
        USER_SETTING_DISABLED = r9;
        DingInaccessibleCode[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static DingInaccessibleCode[] values() {
        return (DingInaccessibleCode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DingInaccessibleCode valueOf(String r1) {
        return (DingInaccessibleCode) r27.a.a(DingInaccessibleCode.class, r1);
    }

    public DingInaccessibleCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
