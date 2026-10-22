package com.ss.android.lark.chat.core.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum ChannelDataFetcherStrategy extends Enum<ChannelDataFetcherStrategy> {
    public static final ChannelDataFetcherStrategy IGNORE_LOCAL_DATA = null;
    public static final ChannelDataFetcherStrategy RETURN_LOCAL_DATA = null;
    public static final ChannelDataFetcherStrategy SYNC_SERVER_DATA = null;
    public static final /* synthetic */ ChannelDataFetcherStrategy[] a = null;
    private int value;

    static {
        ChannelDataFetcherStrategy r0 = new ChannelDataFetcherStrategy("IGNORE_LOCAL_DATA", 0, 1);
        IGNORE_LOCAL_DATA = r0;
        ChannelDataFetcherStrategy r1 = new ChannelDataFetcherStrategy("RETURN_LOCAL_DATA", 1, 2);
        RETURN_LOCAL_DATA = r1;
        ChannelDataFetcherStrategy r4 = new ChannelDataFetcherStrategy("SYNC_SERVER_DATA", 2, 3);
        SYNC_SERVER_DATA = r4;
        a = new ChannelDataFetcherStrategy[]{r0, r1, r4};
    }

    public static ChannelDataFetcherStrategy[] values() {
        return (ChannelDataFetcherStrategy[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static ChannelDataFetcherStrategy fromValue(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return SYNC_SERVER_DATA;
    L11:
        return SYNC_SERVER_DATA;
    L13:
        return RETURN_LOCAL_DATA;
    L15:
        return IGNORE_LOCAL_DATA;
    }

    public static ChannelDataFetcherStrategy valueOf(String r1) {
        return (ChannelDataFetcherStrategy) r27.a.a(ChannelDataFetcherStrategy.class, r1);
    }

    public ChannelDataFetcherStrategy(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
