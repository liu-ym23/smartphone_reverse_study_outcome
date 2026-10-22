package com.bytedance.android.live.liveinteract.interactivesong.logger;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/logger/OpenSource;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CONVENIENT_PAGE", "INTERACTION_BUTTON", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum OpenSource extends Enum<OpenSource> {
    public static final OpenSource CONVENIENT_PAGE = null;
    public static final OpenSource INTERACTION_BUTTON = null;
    public static final /* synthetic */ OpenSource[] a = null;
    private final String value;

    static {
        OpenSource r1 = new OpenSource("CONVENIENT_PAGE", 0, "convenient_page");
        CONVENIENT_PAGE = r1;
        OpenSource r2 = new OpenSource("INTERACTION_BUTTON", 1, "interaction_button");
        INTERACTION_BUTTON = r2;
        a = new OpenSource[]{r1, r2};
    }

    public static OpenSource valueOf(String r1) {
        return (OpenSource) a.a(OpenSource.class, r1);
    }

    public static OpenSource[] values() {
        return (OpenSource[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public OpenSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
