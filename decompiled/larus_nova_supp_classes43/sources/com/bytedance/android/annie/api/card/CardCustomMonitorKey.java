package com.bytedance.android.annie.api.card;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/api/card/CardCustomMonitorKey;", "", "IsPrerender", "IsContainerPreload", "IsUserOpen", "RealOpenTime", "HasReload", "HintSecLink", "UserOpenTime", "LoadScene", "DidAppear", "annie-api_release"}, k = 1, mv = {1, 4, 3})
public final enum CardCustomMonitorKey extends Enum<CardCustomMonitorKey> {
    public static final CardCustomMonitorKey DidAppear = null;
    public static final CardCustomMonitorKey HasReload = null;
    public static final CardCustomMonitorKey HintSecLink = null;
    public static final CardCustomMonitorKey IsContainerPreload = null;
    public static final CardCustomMonitorKey IsPrerender = null;
    public static final CardCustomMonitorKey IsUserOpen = null;
    public static final CardCustomMonitorKey LoadScene = null;
    public static final CardCustomMonitorKey RealOpenTime = null;
    public static final CardCustomMonitorKey UserOpenTime = null;
    public static final /* synthetic */ CardCustomMonitorKey[] a = null;

    public static CardCustomMonitorKey valueOf(String r1) {
        return (CardCustomMonitorKey) a.a(CardCustomMonitorKey.class, r1);
    }

    public static CardCustomMonitorKey[] values() {
        return (CardCustomMonitorKey[]) a.clone();
    }

    static {
        CardCustomMonitorKey r0 = new CardCustomMonitorKey("IsPrerender", 0);
        IsPrerender = r0;
        CardCustomMonitorKey r1 = new CardCustomMonitorKey("IsContainerPreload", 1);
        IsContainerPreload = r1;
        CardCustomMonitorKey r10 = new CardCustomMonitorKey("IsUserOpen", 2);
        IsUserOpen = r10;
        CardCustomMonitorKey r11 = new CardCustomMonitorKey("RealOpenTime", 3);
        RealOpenTime = r11;
        CardCustomMonitorKey r12 = new CardCustomMonitorKey("HasReload", 4);
        HasReload = r12;
        CardCustomMonitorKey r13 = new CardCustomMonitorKey("HintSecLink", 5);
        HintSecLink = r13;
        CardCustomMonitorKey r14 = new CardCustomMonitorKey("UserOpenTime", 6);
        UserOpenTime = r14;
        CardCustomMonitorKey r15 = new CardCustomMonitorKey("LoadScene", 7);
        LoadScene = r15;
        CardCustomMonitorKey r16 = new CardCustomMonitorKey("DidAppear", 8);
        DidAppear = r16;
        a = new CardCustomMonitorKey[]{r0, r1, r10, r11, r12, r13, r14, r15, r16};
    }

    public CardCustomMonitorKey(String r1, int r10) {
        super(r1, r10);
    }
}
