package com.bytedance.android.live.base.model.data.activityemoji;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.ActivityEmoji")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\"\u0010#R\u001c\u0010\t\u001a\u00020\u00048\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR+\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00048V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR/\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R/\u0010\u001a\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R/\u0010!\u001a\u0004\u0018\u00010\u001b2\b\u0010\n\u001a\u0004\u0018\u00010\u001b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/base/model/data/activityemoji/IActivityEmojiFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/data/activityemoji/b;", "", "", "getActivityEmojiGroupId", "()J", "setActivityEmojiGroupId", "(J)V", "activityEmojiGroupId", "<set-?>", "id$delegate", "Ljava/lang/Object;", "getId", "setId", "id", "", "idStr$delegate", "getIdStr", "()Ljava/lang/String;", "setIdStr", "(Ljava/lang/String;)V", "idStr", "name$delegate", "getName", "setName", "name", "Lpy/k;", "emoji$delegate", "getEmoji", "()Lpy/k;", "setEmoji", "(Lpy/k;)V", "emoji", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IActivityEmojiFlexImpl extends FlexModelBase<b> implements b, h {
    private final /* synthetic */ a $$delegate_0;

    @SerializedName("emoji")
    protected k _$$emoji;

    @SerializedName("id")
    protected long _$$id;

    @SerializedName("id_str")
    protected String _$$idStr;

    @SerializedName("name")
    protected String _$$name;

    public IActivityEmojiFlexImpl() {
        super(b.class);
        this.$$delegate_0 = new a();
    }

    @Override // com.bytedance.android.live.base.model.data.activityemoji.b
    public long getActivityEmojiGroupId() {
        return this.$$delegate_0.a;
    }

    @Override // com.bytedance.android.live.base.model.data.activityemoji.b
    public final k getEmoji() {
        return this._$$emoji;
    }

    @Override // com.bytedance.android.live.base.model.data.activityemoji.b
    public final long getId() {
        return this._$$id;
    }

    @Override // com.bytedance.android.live.base.model.data.activityemoji.b
    public final String getIdStr() {
        return this._$$idStr;
    }

    @Override // com.bytedance.android.live.base.model.data.activityemoji.b
    public final String getName() {
        return this._$$name;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public IActivityEmojiFlexImpl(g r6) {
        super(b.class);
        this.$$delegate_0 = new a();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$id = r6.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$idStr = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$name = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this._$$emoji = f.a(r6, k.class);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.data.activityemoji.b
    public void setActivityEmojiGroupId(long r2) {
        this.$$delegate_0.a = r2;
    }

    @Override // com.bytedance.android.live.base.model.data.activityemoji.b
    public final void setEmoji(k r1) {
        this._$$emoji = r1;
    }

    @Override // com.bytedance.android.live.base.model.data.activityemoji.b
    public final void setId(long r1) {
        this._$$id = r1;
    }

    @Override // com.bytedance.android.live.base.model.data.activityemoji.b
    public final void setIdStr(String r1) {
        this._$$idStr = r1;
    }

    @Override // com.bytedance.android.live.base.model.data.activityemoji.b
    public final void setName(String r1) {
        this._$$name = r1;
    }
}
