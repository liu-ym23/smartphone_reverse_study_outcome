package com.bytedance.android.live.ktv.common.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/ktv/common/util/RemoveSongSource;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "DownloadSongFail", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RemoveSongSource extends Enum<RemoveSongSource> {
    public static final RemoveSongSource DownloadSongFail = null;
    public static final RemoveSongSource UNKNOWN = null;
    public static final /* synthetic */ RemoveSongSource[] a = null;
    private final int value;

    static {
        RemoveSongSource r1 = new RemoveSongSource("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        RemoveSongSource r2 = new RemoveSongSource("DownloadSongFail", 1, 1);
        DownloadSongFail = r2;
        a = new RemoveSongSource[]{r1, r2};
    }

    public static RemoveSongSource valueOf(String r1) {
        return (RemoveSongSource) r27.a.a(RemoveSongSource.class, r1);
    }

    public static RemoveSongSource[] values() {
        return (RemoveSongSource[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public RemoveSongSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
