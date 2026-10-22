package com.larus.business.markdown.api.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/business/markdown/api/model/TitleStyle;", "", "style", "", "(Ljava/lang/String;ILjava/lang/String;)V", "NORMAL", "LARGE", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum TitleStyle extends Enum<TitleStyle> {
    private static final /* synthetic */ TitleStyle[] $VALUES = null;
    public static final TitleStyle LARGE = null;
    public static final TitleStyle NORMAL = null;
    private final String style;

    private static final /* synthetic */ TitleStyle[] $values() {
        return new TitleStyle[]{NORMAL, LARGE};
    }

    public static TitleStyle valueOf(String r1) {
        return (TitleStyle) a.a(TitleStyle.class, r1);
    }

    public static TitleStyle[] values() {
        return (TitleStyle[]) $VALUES.clone();
    }

    static {
        NORMAL = new TitleStyle("NORMAL", 0, "style");
        LARGE = new TitleStyle("LARGE", 1, "large");
        $VALUES = $values();
    }

    private TitleStyle(String r1, int r2, String r3) {
        super(r1, r2);
        this.style = r3;
    }
}
