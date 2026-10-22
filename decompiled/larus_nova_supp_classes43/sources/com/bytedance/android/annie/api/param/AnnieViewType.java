package com.bytedance.android.annie.api.param;

import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/annie/api/param/AnnieViewType;", "", "", a.KEY_LUBAN_TAG, "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "CARD", "POPUP", "FULLSCREEN", "annie-api_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieViewType extends Enum<AnnieViewType> {
    public static final AnnieViewType CARD = null;
    public static final AnnieViewType FULLSCREEN = null;
    public static final AnnieViewType POPUP = null;
    public static final /* synthetic */ AnnieViewType[] a = null;
    private final String tag;

    public static AnnieViewType valueOf(String r1) {
        return (AnnieViewType) r27.a.a(AnnieViewType.class, r1);
    }

    public static AnnieViewType[] values() {
        return (AnnieViewType[]) a.clone();
    }

    static {
        AnnieViewType r0 = new AnnieViewType("CARD", 0, "card");
        CARD = r0;
        AnnieViewType r1 = new AnnieViewType("POPUP", 1, a.VALUE_SHOW_POPUP);
        POPUP = r1;
        AnnieViewType r10 = new AnnieViewType("FULLSCREEN", 2, AIStateLogRequest.SOURCE_PAGE);
        FULLSCREEN = r10;
        a = new AnnieViewType[]{r0, r1, r10};
    }

    public final String getTag() {
        return this.tag;
    }

    public AnnieViewType(String r1, int r10, String r11) {
        super(r1, r10);
        this.tag = r11;
    }
}
