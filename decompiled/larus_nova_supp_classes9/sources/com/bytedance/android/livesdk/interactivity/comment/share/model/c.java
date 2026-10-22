package com.bytedance.android.livesdk.interactivity.comment.share.model;

import am3.g;
import com.bytedance.android.live.base.model.data.m;
import com.bytedance.android.live.base.model.data.q;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/share/model/c;", BuildConfig.FLAVOR, "Lcom/bytedance/android/live/base/model/message/a5;", "displayText", "Lcom/bytedance/android/live/base/model/message/a5;", "a", "()Lcom/bytedance/android/live/base/model/message/a5;", "setDisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "Lcom/bytedance/android/live/base/model/data/m;", "itemStyle", "Lcom/bytedance/android/live/base/model/data/m;", "b", "()Lcom/bytedance/android/live/base/model/data/m;", "setItemStyle", "(Lcom/bytedance/android/live/base/model/data/m;)V", "Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "publicAreaCommon", "Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "d", "()Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "setPublicAreaCommon", "(Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;)V", BuildConfig.FLAVOR, "msgId", "J", "c", "()J", "setMsgId", "(J)V", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName("display_text")
    protected a5 displayText;

    @SerializedName("item_style")
    protected m itemStyle;

    @SerializedName("msg_id")
    protected long msgId;

    @SerializedName("public_area_common")
    protected IPublicAreaCommon publicAreaCommon;

    public c() {
    }

    public final a5 a() {
        return this.displayText;
    }

    public final m b() {
        return this.itemStyle;
    }

    public final long c() {
        return this.msgId;
    }

    public final IPublicAreaCommon d() {
        return this.publicAreaCommon;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.livesdkapi.message.IPublicAreaCommon, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public c(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.displayText = f.a(r5, a5.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.itemStyle = q.a(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.publicAreaCommon = f.a(r5, IPublicAreaCommon.class);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.msgId = r5.j();
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
    }
}
