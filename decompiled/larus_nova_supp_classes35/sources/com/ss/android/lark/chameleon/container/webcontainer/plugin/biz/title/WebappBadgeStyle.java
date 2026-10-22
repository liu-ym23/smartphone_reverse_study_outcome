package com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.title;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/title/WebappBadgeStyle;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NOBADGE", "DOT", "NUM", "TEXT", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum WebappBadgeStyle extends Enum<WebappBadgeStyle> {
    private static final /* synthetic */ WebappBadgeStyle[] $VALUES = null;
    public static final WebappBadgeStyle DOT = null;
    public static final WebappBadgeStyle NOBADGE = null;
    public static final WebappBadgeStyle NUM = null;
    public static final WebappBadgeStyle TEXT = null;
    private final String value;

    private static final /* synthetic */ WebappBadgeStyle[] $values() {
        return new WebappBadgeStyle[]{NOBADGE, DOT, NUM, TEXT};
    }

    public static WebappBadgeStyle valueOf(String r1) {
        return (WebappBadgeStyle) r27.a.a(WebappBadgeStyle.class, r1);
    }

    public static WebappBadgeStyle[] values() {
        return (WebappBadgeStyle[]) $VALUES.clone();
    }

    static {
        NOBADGE = new WebappBadgeStyle("NOBADGE", 0, "none");
        DOT = new WebappBadgeStyle("DOT", 1, "dot");
        NUM = new WebappBadgeStyle("NUM", 2, "num");
        TEXT = new WebappBadgeStyle("TEXT", 3, "text");
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private WebappBadgeStyle(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
