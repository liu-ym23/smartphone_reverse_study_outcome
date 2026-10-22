package com.bytedance.android.live.profit.privilege.model.danmu;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/danmu/SendPrivilegeBarrageArgs;", "", "content", "", "style", "", "rtfContent", "requiredDiamonds", "", "tagsExtra", "(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getRequiredDiamonds", "()J", "getRtfContent", "getStyle", "()I", "getTagsExtra", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SendPrivilegeBarrageArgs {
    private final String content;
    private final long requiredDiamonds;
    private final String rtfContent;
    private final int style;
    private final String tagsExtra;

    public final String getContent() {
        return this.content;
    }

    public final long getRequiredDiamonds() {
        return this.requiredDiamonds;
    }

    public final String getRtfContent() {
        return this.rtfContent;
    }

    public final int getStyle() {
        return this.style;
    }

    public final String getTagsExtra() {
        return this.tagsExtra;
    }

    public SendPrivilegeBarrageArgs(String r2, int r3, String r4, long r5, String r7) {
        Intrinsics.checkNotNullParameter(r2, "content");
        this.content = r2;
        this.style = r3;
        this.rtfContent = r4;
        this.requiredDiamonds = r5;
        this.tagsExtra = r7;
    }
}
