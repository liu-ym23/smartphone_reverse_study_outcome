package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.ListUserTag")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0015\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001f\u0010 R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR/\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR/\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTagFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;", "", "<set-?>", "content$delegate", "Ljava/lang/Object;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "content", "", "textSize$delegate", "getTextSize", "()Ljava/lang/Long;", "setTextSize", "(Ljava/lang/Long;)V", "textSize", "textColor$delegate", "getTextColor", "setTextColor", "textColor", "bgColor$delegate", "getBgColor", "setBgColor", "bgColor", "bgRadius$delegate", "getBgRadius", "setBgRadius", "bgRadius", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ListUserTagFlexImpl extends FlexModelBase<ListUserTag> implements ListUserTag, vh7.h {

    @SerializedName("bg_color")
    protected String _$$bgColor;

    @SerializedName("bg_radius")
    protected Long _$$bgRadius;

    @SerializedName("content")
    protected String _$$content;

    @SerializedName("text_color")
    protected String _$$textColor;

    @SerializedName("text_size")
    protected Long _$$textSize;

    public ListUserTagFlexImpl() {
        super(ListUserTag.class);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ListUserTag
    public final String getBgColor() {
        return this._$$bgColor;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ListUserTag
    public final Long getBgRadius() {
        return this._$$bgRadius;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ListUserTag
    public final String getContent() {
        return this._$$content;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ListUserTag
    public final String getTextColor() {
        return this._$$textColor;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ListUserTag
    public final Long getTextSize() {
        return this._$$textSize;
    }

    public ListUserTagFlexImpl(am3.g r6) {
        super(ListUserTag.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L21;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$content = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$textSize = Long.valueOf(r6.j());
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$textColor = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this._$$bgColor = am3.h.c(r6);
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this._$$bgRadius = Long.valueOf(r6.j());
        goto L3
    L15:
        am3.h.d(r3, r6);
        goto L3
    L21:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ListUserTag
    public final void setBgColor(String r1) {
        this._$$bgColor = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ListUserTag
    public final void setBgRadius(Long r1) {
        this._$$bgRadius = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ListUserTag
    public final void setContent(String r1) {
        this._$$content = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ListUserTag
    public final void setTextColor(String r1) {
        this._$$textColor = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ListUserTag
    public final void setTextSize(Long r1) {
        this._$$textSize = r1;
    }
}
