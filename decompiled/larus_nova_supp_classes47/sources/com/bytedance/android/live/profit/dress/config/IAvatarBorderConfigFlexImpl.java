package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.dress.AvatarBorderConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IAvatarBorderConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/b;", "Lpy/k;", "avatarBorder", "Lpy/k;", "getAvatarBorder", "()Lpy/k;", "setAvatarBorder", "(Lpy/k;)V", "thumbAvatarBorder", "getThumbAvatarBorder", "setThumbAvatarBorder", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAvatarBorderConfigFlexImpl extends FlexModelBase<b> implements b, vh7.h {

    @SerializedName("avatar_border")
    protected py.k avatarBorder;

    @SerializedName("thumb_avatar_border")
    protected py.k thumbAvatarBorder;

    public IAvatarBorderConfigFlexImpl() {
        super(b.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public IAvatarBorderConfigFlexImpl(am3.g r6) {
        super(b.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.avatarBorder = vh7.f.a(r6, py.k.class);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.thumbAvatarBorder = vh7.f.a(r6, py.k.class);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.dress.config.b
    public py.k getAvatarBorder() {
        return this.avatarBorder;
    }

    @Override // com.bytedance.android.live.profit.dress.config.b
    public py.k getThumbAvatarBorder() {
        return this.thumbAvatarBorder;
    }

    public void setAvatarBorder(py.k r1) {
        this.avatarBorder = r1;
    }

    public void setThumbAvatarBorder(py.k r1) {
        this.thumbAvatarBorder = r1;
    }
}
