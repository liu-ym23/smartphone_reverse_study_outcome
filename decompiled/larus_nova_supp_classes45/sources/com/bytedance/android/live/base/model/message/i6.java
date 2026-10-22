package com.bytedance.android.live.base.model.message;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.LowPcuGuideChatData")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/base/model/message/i6;", "", "", "status", "I", "b", "()I", "d", "(I)V", "", "Lcom/bytedance/android/live/base/model/message/h;", "guideChatConfigGroup", "Ljava/util/List;", "a", "()Ljava/util/List;", "c", "(Ljava/util/List;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class i6 implements vh7.h {

    @SerializedName("guide_chat_config")
    protected List<h> guideChatConfigGroup;

    @SerializedName("status")
    protected int status;

    public i6() {
    }

    public final List<h> a() {
        return this.guideChatConfigGroup;
    }

    public final int b() {
        return this.status;
    }

    public i6(am3.g r5) {
        this.guideChatConfigGroup = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.status = (int) r5.j();
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.guideChatConfigGroup.add(new h(r5));
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
    }

    public final void c(List<h> r1) {
        this.guideChatConfigGroup = r1;
    }

    public final void d(int r1) {
        this.status = 2;
    }
}
