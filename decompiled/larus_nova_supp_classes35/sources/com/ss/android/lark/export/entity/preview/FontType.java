package com.ss.android.lark.export.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/FontType;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "TITLE", "HEADLINE", "BODY", "CAPTION", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FontType extends Enum<FontType> implements Serializable {
    public static final FontType BODY = null;
    public static final FontType CAPTION = null;
    public static final a Companion = null;
    public static final FontType HEADLINE = null;
    public static final FontType TITLE = null;
    public static final /* synthetic */ FontType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<FontType> getEntries() {
        return b;
    }

    static {
        FontType r0 = new FontType("TITLE", 0, 0);
        TITLE = r0;
        FontType r1 = new FontType("HEADLINE", 1, 1);
        HEADLINE = r1;
        FontType r3 = new FontType("BODY", 2, 2);
        BODY = r3;
        FontType r5 = new FontType("CAPTION", 3, 3);
        CAPTION = r5;
        FontType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static FontType[] values() {
        return (FontType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FontType valueOf(String r1) {
        return (FontType) r27.a.a(FontType.class, r1);
    }

    public final void setValue(int r1) {
        this.value = r1;
    }

    public FontType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
