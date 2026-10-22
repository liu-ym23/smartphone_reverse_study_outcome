package com.larus.drive.sdk.api.meta;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/drive/sdk/api/meta/PreviewFromPage;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RECENT", "MINE", "PICKER", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreviewFromPage extends Enum<PreviewFromPage> {
    public static final PreviewFromPage MINE = null;
    public static final PreviewFromPage PICKER = null;
    public static final PreviewFromPage RECENT = null;
    public static final PreviewFromPage UNKNOWN = null;
    public static final /* synthetic */ PreviewFromPage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<PreviewFromPage> getEntries() {
        return b;
    }

    static {
        PreviewFromPage r0 = new PreviewFromPage("RECENT", 0, "recent");
        RECENT = r0;
        PreviewFromPage r1 = new PreviewFromPage("MINE", 1, "mine");
        MINE = r1;
        PreviewFromPage r2 = new PreviewFromPage("PICKER", 2, "picker");
        PICKER = r2;
        PreviewFromPage r4 = new PreviewFromPage("UNKNOWN", 3, "unknown");
        UNKNOWN = r4;
        PreviewFromPage[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static PreviewFromPage[] values() {
        return (PreviewFromPage[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static PreviewFromPage valueOf(String r1) {
        return (PreviewFromPage) a.a(PreviewFromPage.class, r1);
    }

    public PreviewFromPage(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
