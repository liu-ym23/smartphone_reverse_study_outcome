package com.ss.android.lark.custom.repeat;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/custom/repeat/CustomRepeatParams$DayOfWeek;", BuildConfig.FLAVOR, "number", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "Companion", "custom-repeat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CustomRepeatParams$DayOfWeek extends Enum<CustomRepeatParams$DayOfWeek> {
    public static final a Companion = null;
    public static final CustomRepeatParams$DayOfWeek FRIDAY = null;
    public static final CustomRepeatParams$DayOfWeek MONDAY = null;
    public static final CustomRepeatParams$DayOfWeek SATURDAY = null;
    public static final CustomRepeatParams$DayOfWeek SUNDAY = null;
    public static final CustomRepeatParams$DayOfWeek THURSDAY = null;
    public static final CustomRepeatParams$DayOfWeek TUESDAY = null;
    public static final CustomRepeatParams$DayOfWeek WEDNESDAY = null;
    public static final /* synthetic */ CustomRepeatParams$DayOfWeek[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int number;

    public static EnumEntries<CustomRepeatParams$DayOfWeek> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.custom.repeat.CustomRepeatParams$DayOfWeek$a] */
    static {
        CustomRepeatParams$DayOfWeek r0 = new CustomRepeatParams$DayOfWeek("SUNDAY", 0, 0);
        SUNDAY = r0;
        CustomRepeatParams$DayOfWeek r1 = new CustomRepeatParams$DayOfWeek("MONDAY", 1, 1);
        MONDAY = r1;
        CustomRepeatParams$DayOfWeek r3 = new CustomRepeatParams$DayOfWeek("TUESDAY", 2, 2);
        TUESDAY = r3;
        CustomRepeatParams$DayOfWeek r5 = new CustomRepeatParams$DayOfWeek("WEDNESDAY", 3, 3);
        WEDNESDAY = r5;
        CustomRepeatParams$DayOfWeek r7 = new CustomRepeatParams$DayOfWeek("THURSDAY", 4, 4);
        THURSDAY = r7;
        CustomRepeatParams$DayOfWeek r9 = new CustomRepeatParams$DayOfWeek("FRIDAY", 5, 5);
        FRIDAY = r9;
        CustomRepeatParams$DayOfWeek r11 = new CustomRepeatParams$DayOfWeek("SATURDAY", 6, 6);
        SATURDAY = r11;
        CustomRepeatParams$DayOfWeek[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
        Companion = new a();
    }

    public static CustomRepeatParams$DayOfWeek[] values() {
        return (CustomRepeatParams$DayOfWeek[]) a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    public static CustomRepeatParams$DayOfWeek valueOf(String r1) {
        return (CustomRepeatParams$DayOfWeek) r27.a.a(CustomRepeatParams$DayOfWeek.class, r1);
    }

    public CustomRepeatParams$DayOfWeek(String r1, int r2, int r3) {
        super(r1, r2);
        this.number = r3;
    }
}
