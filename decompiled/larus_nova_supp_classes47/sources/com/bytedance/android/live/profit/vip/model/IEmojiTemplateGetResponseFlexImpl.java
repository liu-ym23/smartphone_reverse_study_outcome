package com.bytedance.android.live.profit.vip.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.subscribe.EmojiTemplateGetResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR;\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/profit/vip/model/IEmojiTemplateGetResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/vip/model/f;", "", "", "<set-?>", "scriptList$delegate", "Ljava/lang/Object;", "getScriptList", "()Ljava/util/List;", "setScriptList", "(Ljava/util/List;)V", "scriptList", "Lcom/bytedance/android/live/profit/vip/model/e;", "bubbleList$delegate", "getBubbleList", "setBubbleList", "bubbleList", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IEmojiTemplateGetResponseFlexImpl extends FlexModelBase<f> implements f, vh7.h {

    @SerializedName("bubbles")
    protected List<? extends e> _$$bubbleList;

    @SerializedName("recommend_script")
    protected List<String> _$$scriptList;

    public IEmojiTemplateGetResponseFlexImpl() {
        super(f.class);
    }

    public IEmojiTemplateGetResponseFlexImpl(am3.g r6) {
        super(f.class);
        this._$$scriptList = new ArrayList();
        this._$$bubbleList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L13;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 == 1) goto L11;
        if (r2 != 2) goto L9;
        List r4 = this._$$bubbleList;
        Object r5 = vh7.f.a(r6, e.class);
    L12:
        r4.add(r5);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L11:
        r4 = this._$$scriptList;
        r5 = am3.h.c(r6);
        goto L12
    L13:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.vip.model.f
    public final List<e> getBubbleList() {
        return this._$$bubbleList;
    }

    @Override // com.bytedance.android.live.profit.vip.model.f
    public final List<String> getScriptList() {
        return this._$$scriptList;
    }

    @Override // com.bytedance.android.live.profit.vip.model.f
    public final void setBubbleList(List<? extends e> r1) {
        this._$$bubbleList = r1;
    }

    @Override // com.bytedance.android.live.profit.vip.model.f
    public final void setScriptList(List<String> r1) {
        this._$$scriptList = r1;
    }
}
