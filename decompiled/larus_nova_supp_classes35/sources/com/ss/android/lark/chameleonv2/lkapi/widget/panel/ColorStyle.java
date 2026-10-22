package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/ColorStyle;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Normal", "Desc", "Select", "Warning", "Disable", "TRANSLATE", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ColorStyle extends Enum<ColorStyle> {
    public static final ColorStyle Desc = null;
    public static final ColorStyle Disable = null;
    public static final ColorStyle Normal = null;
    public static final ColorStyle Select = null;
    public static final ColorStyle TRANSLATE = null;
    public static final ColorStyle Warning = null;
    public static final /* synthetic */ ColorStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ColorStyle> getEntries() {
        return b;
    }

    static {
        ColorStyle r0 = new ColorStyle("Normal", 0, 1);
        Normal = r0;
        ColorStyle r1 = new ColorStyle("Desc", 1, 2);
        Desc = r1;
        ColorStyle r4 = new ColorStyle("Select", 2, 3);
        Select = r4;
        ColorStyle r6 = new ColorStyle("Warning", 3, 4);
        Warning = r6;
        ColorStyle r8 = new ColorStyle("Disable", 4, 5);
        Disable = r8;
        ColorStyle r10 = new ColorStyle("TRANSLATE", 5, 6);
        TRANSLATE = r10;
        ColorStyle[] r12 = {r0, r1, r4, r6, r8, r10};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static ColorStyle[] values() {
        return (ColorStyle[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ColorStyle valueOf(String r1) {
        return (ColorStyle) r27.a.a(ColorStyle.class, r1);
    }

    public ColorStyle(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
