package com.bytedance.android.annie.scheme.vo.refactor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/annie/scheme/vo/refactor/PageType;", "", "", "pageType", "Ljava/lang/String;", "getPageType", "()Ljava/lang/String;", "CARD", "FULLSCREEN", "POPUP", "annie_release"}, k = 1, mv = {1, 4, 3})
public final enum PageType extends Enum<PageType> {
    public static final PageType CARD = null;
    public static final PageType FULLSCREEN = null;
    public static final PageType POPUP = null;
    public static final /* synthetic */ PageType[] a = null;
    private final String pageType;

    public static PageType valueOf(String r1) {
        return (PageType) a.a(PageType.class, r1);
    }

    public static PageType[] values() {
        return (PageType[]) a.clone();
    }

    static {
        PageType r0 = new PageType("CARD", 0, "card");
        CARD = r0;
        PageType r1 = new PageType("FULLSCREEN", 1, "fullscreen");
        FULLSCREEN = r1;
        PageType r10 = new PageType("POPUP", 2, com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP);
        POPUP = r10;
        a = new PageType[]{r0, r1, r10};
    }

    public final String getPageType() {
        return this.pageType;
    }

    public PageType(String r1, int r10, String r11) {
        super(r1, r10);
        this.pageType = r11;
    }
}
