package com.larus.video.impl.douyin;

import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/video/impl/douyin/GetRecommendVideosResponse;", "Ljava/io/Serializable;", LynxResourceModule.CODE_KEY, NameKeys.UnloadStrategy_No_Strategy, "msg", NameKeys.UnloadStrategy_No_Strategy, LynxResourceModule.DATA_KEY, "Lcom/larus/video/impl/douyin/RecommendVideos;", "<init>", "(ILjava/lang/String;Lcom/larus/video/impl/douyin/RecommendVideos;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/larus/video/impl/douyin/RecommendVideos;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetRecommendVideosResponse implements Serializable {
    private final int code;
    private final RecommendVideos data;
    private final String msg;

    public GetRecommendVideosResponse() {
        this(0, null, null, 7, null);
    }

    public final int getCode() {
        return this.code;
    }

    public final RecommendVideos getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public GetRecommendVideosResponse(int r1, String r2, RecommendVideos r3) {
        this.code = r1;
        this.msg = r2;
        this.data = r3;
    }

    public /* synthetic */ GetRecommendVideosResponse(int r2, String r3, RecommendVideos r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
