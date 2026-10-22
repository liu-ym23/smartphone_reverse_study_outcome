package com.ss.android.lark.chat.preview.entity.component;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/Theme;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "LIGHT", "DARK", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Theme extends Enum<Theme> implements Serializable {
    public static final a Companion = null;
    public static final Theme DARK = null;
    public static final Theme LIGHT = null;
    public static final /* synthetic */ Theme[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private int value;

    public static final class a {
        public a() {
        }

        public static Theme a(int r1) {
            if (r1 == 0) goto L8;
            if (r1 == 1) goto L10;
            return Theme.LIGHT;
        L10:
            return Theme.DARK;
        L8:
            return Theme.LIGHT;
        }
    }

    public static EnumEntries<Theme> getEntries() {
        return b;
    }

    static {
        Theme r0 = new Theme("LIGHT", 0, 0);
        LIGHT = r0;
        Theme r1 = new Theme("DARK", 1, 1);
        DARK = r1;
        Theme[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static Theme[] values() {
        return (Theme[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Theme valueOf(String r1) {
        return (Theme) r27.a.a(Theme.class, r1);
    }

    public final void setValue(int r1) {
        this.value = r1;
    }

    public Theme(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
