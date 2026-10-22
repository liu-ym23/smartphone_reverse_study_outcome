package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/custom/CustomDisplayPageUiMode;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "LARK", "DOUBAO", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CustomDisplayPageUiMode extends Enum<CustomDisplayPageUiMode> {
    public static final CustomDisplayPageUiMode DOUBAO = null;
    public static final CustomDisplayPageUiMode LARK = null;
    public static final /* synthetic */ CustomDisplayPageUiMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CustomDisplayPageUiMode> getEntries() {
        return b;
    }

    static {
        CustomDisplayPageUiMode r0 = new CustomDisplayPageUiMode("LARK", 0);
        LARK = r0;
        CustomDisplayPageUiMode r1 = new CustomDisplayPageUiMode("DOUBAO", 1);
        DOUBAO = r1;
        CustomDisplayPageUiMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static CustomDisplayPageUiMode[] values() {
        return (CustomDisplayPageUiMode[]) a.clone();
    }

    public static CustomDisplayPageUiMode valueOf(String r1) {
        return (CustomDisplayPageUiMode) r27.a.a(CustomDisplayPageUiMode.class, r1);
    }

    public CustomDisplayPageUiMode(String r1, int r2) {
        super(r1, r2);
    }
}
