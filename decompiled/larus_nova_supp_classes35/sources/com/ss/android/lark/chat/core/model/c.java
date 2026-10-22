package com.ss.android.lark.chat.core.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends PageLoader.b {
    public final MessageFetchScene c;
    public final ChannelDataFetcherStrategy d;

    public c(PageLoader.c r1, int r2) {
        super(r1, r2);
        this.d = ChannelDataFetcherStrategy.SYNC_SERVER_DATA;
    }

    public c(int r1, int r2, MessageFetchScene r3, ChannelDataFetcherStrategy r4) {
        super(r1, r2);
        this.d = ChannelDataFetcherStrategy.SYNC_SERVER_DATA;
        this.c = r3;
        this.d = r4;
    }
}
