package com.ss.android.lark.docs.icon.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/docs/icon/entity/IconShape;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "CIRCLE", "SQUARE", "SQUARE_OUTLINE", "docs-icon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IconShape extends Enum<IconShape> {
    public static final IconShape CIRCLE = null;
    public static final IconShape SQUARE = null;
    public static final IconShape SQUARE_OUTLINE = null;
    public static final /* synthetic */ IconShape[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<IconShape> getEntries() {
        return b;
    }

    static {
        IconShape r0 = new IconShape("CIRCLE", 0);
        CIRCLE = r0;
        IconShape r1 = new IconShape("SQUARE", 1);
        SQUARE = r1;
        IconShape r3 = new IconShape("SQUARE_OUTLINE", 2);
        SQUARE_OUTLINE = r3;
        IconShape[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static IconShape[] values() {
        return (IconShape[]) a.clone();
    }

    public static IconShape valueOf(String r1) {
        return (IconShape) a.a(IconShape.class, r1);
    }

    public IconShape(String r1, int r2) {
        super(r1, r2);
    }
}
