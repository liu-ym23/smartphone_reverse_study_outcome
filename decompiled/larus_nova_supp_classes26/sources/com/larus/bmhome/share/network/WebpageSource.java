package com.larus.bmhome.share.network;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/share/network/WebpageSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DEEP_RESEARCH", "CODE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WebpageSource extends Enum<WebpageSource> {
    public static final WebpageSource CODE = null;
    public static final WebpageSource DEEP_RESEARCH = null;
    public static final WebpageSource UNKNOWN = null;
    public static final /* synthetic */ WebpageSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<WebpageSource> getEntries() {
        return b;
    }

    static {
        WebpageSource r0 = new WebpageSource("UNKNOWN", 0, 1);
        UNKNOWN = r0;
        WebpageSource r1 = new WebpageSource("DEEP_RESEARCH", 1, 1);
        DEEP_RESEARCH = r1;
        WebpageSource r4 = new WebpageSource("CODE", 2, 2);
        CODE = r4;
        WebpageSource[] r5 = {r0, r1, r4};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static WebpageSource[] values() {
        return (WebpageSource[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static WebpageSource valueOf(String r1) {
        return (WebpageSource) r27.a.a(WebpageSource.class, r1);
    }

    public WebpageSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
