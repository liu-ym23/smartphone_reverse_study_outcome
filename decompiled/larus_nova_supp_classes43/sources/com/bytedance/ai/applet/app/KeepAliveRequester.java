package com.bytedance.ai.applet.app;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/applet/app/KeepAliveRequester;", "", "<init>", "(Ljava/lang/String;I)V", "AUDIO_PLAYER", "NAVIGATION", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KeepAliveRequester extends Enum<KeepAliveRequester> {
    public static final KeepAliveRequester AUDIO_PLAYER = null;
    public static final KeepAliveRequester NAVIGATION = null;
    public static final /* synthetic */ KeepAliveRequester[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<KeepAliveRequester> getEntries() {
        return b;
    }

    static {
        KeepAliveRequester r0 = new KeepAliveRequester("AUDIO_PLAYER", 0);
        AUDIO_PLAYER = r0;
        KeepAliveRequester r1 = new KeepAliveRequester("NAVIGATION", 1);
        NAVIGATION = r1;
        KeepAliveRequester[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static KeepAliveRequester[] values() {
        return (KeepAliveRequester[]) a.clone();
    }

    public static KeepAliveRequester valueOf(String r1) {
        return (KeepAliveRequester) r27.a.a(KeepAliveRequester.class, r1);
    }

    public KeepAliveRequester(String r1, int r10) {
        super(r1, r10);
    }
}
