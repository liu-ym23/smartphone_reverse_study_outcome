package com.bytedance.android.live.base.model.dynamic;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@IgnoreProtoFieldCheck
@ProtoMessage("webcast.api.moment.PreviewDetail")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\b¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/base/model/dynamic/e;", "Lcom/bytedance/android/live/base/model/dynamic/c;", "", "releaseTime", "J", "getReleaseTime", "()J", "setReleaseTime", "(J)V", "scheduledTime", "getScheduledTime", "setScheduledTime", "", "videoTitle", "Ljava/lang/String;", "getVideoTitle", "()Ljava/lang/String;", "setVideoTitle", "(Ljava/lang/String;)V", "", "coverUrls", "Ljava/util/List;", "getCoverUrls", "()Ljava/util/List;", "setCoverUrls", "(Ljava/util/List;)V", "playNumber", "getPlayNumber", "setPlayNumber", "itemId", "getItemId", "setItemId", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e extends c implements h {

    @SerializedName("cover_urls")
    protected List<String> coverUrls;

    @SerializedName("item_id")
    protected long itemId;

    @SerializedName("play_number")
    protected long playNumber;

    @SerializedName("release_time")
    protected long releaseTime;

    @SerializedName("scheduled_time")
    protected long scheduledTime;

    @SerializedName("video_title")
    protected String videoTitle;

    public e() {
    }

    public e(am3.g r5) {
        this.coverUrls = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L13;
        switch(r2) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.itemId = r5.j();
        goto L3
    L8:
        this.playNumber = r5.j();
        goto L3
    L9:
        this.coverUrls.add(am3.h.c(r5));
        goto L3
    L10:
        this.videoTitle = am3.h.c(r5);
        goto L3
    L11:
        this.scheduledTime = r5.j();
        goto L3
    L12:
        this.releaseTime = r5.j();
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L13:
        r5.d(r0);
    }
}
