package com.larus.voice_setting.voice;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/voice_setting/voice/Page;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "MULTI_TAB", "UGC_RECOMMEND_TAB", "VOICE_RECOMMEND_TAB", "NON", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Page extends Enum<Page> {
    public static final Page MULTI_TAB = null;
    public static final Page NON = null;
    public static final Page UGC_RECOMMEND_TAB = null;
    public static final Page VOICE_RECOMMEND_TAB = null;
    public static final /* synthetic */ Page[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<Page> getEntries() {
        return b;
    }

    static {
        Page r0 = new Page("MULTI_TAB", 0);
        MULTI_TAB = r0;
        Page r1 = new Page("UGC_RECOMMEND_TAB", 1);
        UGC_RECOMMEND_TAB = r1;
        Page r3 = new Page("VOICE_RECOMMEND_TAB", 2);
        VOICE_RECOMMEND_TAB = r3;
        Page r5 = new Page("NON", 3);
        NON = r5;
        Page[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static Page[] values() {
        return (Page[]) a.clone();
    }

    public static Page valueOf(String r1) {
        return (Page) r27.a.a(Page.class, r1);
    }

    public Page(String r1, int r2) {
        super(r1, r2);
    }
}
