package com.ss.android.lark.chat.entity.theme;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class TitleTheme {
    public final ThemeType a;
    public final Integer b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/entity/theme/TitleTheme$ThemeType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "DARK", "LIGHT", "SECRET", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ThemeType extends Enum<ThemeType> {
        public static final ThemeType DARK = null;
        public static final ThemeType LIGHT = null;
        public static final ThemeType SECRET = null;
        public static final /* synthetic */ ThemeType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ThemeType> getEntries() {
            return b;
        }

        static {
            ThemeType r0 = new ThemeType("DARK", 0);
            DARK = r0;
            ThemeType r1 = new ThemeType("LIGHT", 1);
            LIGHT = r1;
            ThemeType r3 = new ThemeType("SECRET", 2);
            SECRET = r3;
            ThemeType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ThemeType[] values() {
            return (ThemeType[]) a.clone();
        }

        public static ThemeType valueOf(String r1) {
            return (ThemeType) a.a(ThemeType.class, r1);
        }

        public ThemeType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final String toString() {
        return "TitleTheme(type=" + this.a + ", titleBgColor=" + this.b + ')';
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Integer r1 = this.b;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final ThemeType getType() {
        return this.a;
    }

    public TitleTheme(ThemeType r2) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        this.a = r2;
        this.b = null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(TitleTheme.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.theme.TitleTheme");
        TitleTheme r6 = (TitleTheme) r5;
        if (this.a == r6.a) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r2 = null;
        goto L10
    }
}
