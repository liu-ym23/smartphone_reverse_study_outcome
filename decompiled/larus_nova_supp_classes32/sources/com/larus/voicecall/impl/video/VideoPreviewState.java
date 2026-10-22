package com.larus.voicecall.impl.video;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/voicecall/impl/video/VideoPreviewState;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "close", "full", "pip", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VideoPreviewState extends Enum<VideoPreviewState> {
    public static final /* synthetic */ VideoPreviewState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    public static final VideoPreviewState close = null;
    public static final VideoPreviewState full = null;
    public static final VideoPreviewState pip = null;

    public static EnumEntries<VideoPreviewState> getEntries() {
        return b;
    }

    static {
        VideoPreviewState r0 = new VideoPreviewState("close", 0);
        close = r0;
        VideoPreviewState r1 = new VideoPreviewState("full", 1);
        full = r1;
        VideoPreviewState r3 = new VideoPreviewState("pip", 2);
        pip = r3;
        VideoPreviewState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static VideoPreviewState[] values() {
        return (VideoPreviewState[]) a.clone();
    }

    public static VideoPreviewState valueOf(String r1) {
        return (VideoPreviewState) r27.a.a(VideoPreviewState.class, r1);
    }

    public VideoPreviewState(String r1, int r2) {
        super(r1, r2);
    }
}
