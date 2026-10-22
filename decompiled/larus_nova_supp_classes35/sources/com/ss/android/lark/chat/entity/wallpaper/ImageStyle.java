package com.ss.android.lark.chat.entity.wallpaper;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ImageStyle;", BuildConfig.FLAVOR, "number", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "LIGHT", "DARK", "toString", BuildConfig.FLAVOR, "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ImageStyle extends Enum<ImageStyle> {
    public static final a Companion = null;
    public static final ImageStyle DARK = null;
    public static final ImageStyle LIGHT = null;
    public static final /* synthetic */ ImageStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int number;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ImageStyle> getEntries() {
        return b;
    }

    static {
        ImageStyle r0 = new ImageStyle("LIGHT", 0, 1);
        LIGHT = r0;
        ImageStyle r1 = new ImageStyle("DARK", 1, 2);
        DARK = r1;
        ImageStyle[] r4 = {r0, r1};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
        Companion = new a();
    }

    public static ImageStyle[] values() {
        return (ImageStyle[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return name();
    }

    public final int getNumber() {
        return this.number;
    }

    @JvmStatic
    public static final ImageStyle fromValue(int r1) {
        Companion.getClass();
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L11;
        return null;
    L11:
        return DARK;
    L9:
        return LIGHT;
    }

    public static ImageStyle valueOf(String r1) {
        return (ImageStyle) r27.a.a(ImageStyle.class, r1);
    }

    public ImageStyle(String r1, int r2, int r3) {
        super(r1, r2);
        this.number = r3;
    }
}
