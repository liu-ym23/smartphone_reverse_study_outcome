package com.bytedance.android.live.profit.vip.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.subscribe.EmojiTabInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b'\u0010(R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR/\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR/\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR/\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\nR/\u0010&\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0006\u001a\u0004\b$\u0010\b\"\u0004\b%\u0010\n¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/profit/vip/model/IEmojiTabInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/vip/model/d;", "", "<set-?>", "describe$delegate", "Ljava/lang/Object;", "getDescribe", "()Ljava/lang/String;", "setDescribe", "(Ljava/lang/String;)V", "describe", "", "btnShow$delegate", "getBtnShow", "()Z", "setBtnShow", "(Z)V", "btnShow", "btnText$delegate", "getBtnText", "setBtnText", "btnText", "btnSchema$delegate", "getBtnSchema", "setBtnSchema", "btnSchema", "emojiIconSelectUrl$delegate", "getEmojiIconSelectUrl", "setEmojiIconSelectUrl", "emojiIconSelectUrl", "emojiIconUnselectUrl$delegate", "getEmojiIconUnselectUrl", "setEmojiIconUnselectUrl", "emojiIconUnselectUrl", "emojiTabName$delegate", "getEmojiTabName", "setEmojiTabName", "emojiTabName", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IEmojiTabInfoFlexImpl extends FlexModelBase<d> implements d, vh7.h {

    @SerializedName("btn_schema")
    protected String _$$btnSchema;

    @SerializedName("btn_show")
    protected boolean _$$btnShow;

    @SerializedName("btn_text")
    protected String _$$btnText;

    @SerializedName("describe")
    protected String _$$describe;

    @SerializedName("emoji_icon_select_url")
    protected String _$$emojiIconSelectUrl;

    @SerializedName("emoji_icon_unselect_url")
    protected String _$$emojiIconUnselectUrl;

    @SerializedName("emoji_tab_name")
    protected String _$$emojiTabName;

    public IEmojiTabInfoFlexImpl() {
        super(d.class);
        this._$$btnShow = false;
    }

    public IEmojiTabInfoFlexImpl(am3.g r7) {
        super(d.class);
        setThreadSafe(false);
        long r1 = r7.c();
        boolean r3 = false;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L15;
        am3.g.a r5 = decodeExtensionFields(r4, r7);
        switch(r4) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        this._$$emojiTabName = am3.h.c(r7);
        goto L3
    L9:
        this._$$emojiIconUnselectUrl = am3.h.c(r7);
        goto L3
    L10:
        this._$$emojiIconSelectUrl = am3.h.c(r7);
        goto L3
    L11:
        this._$$btnSchema = am3.h.c(r7);
        goto L3
    L12:
        this._$$btnText = am3.h.c(r7);
        goto L3
    L13:
        this._$$btnShow = am3.h.a(r7);
        r3 = r3 | true;
        goto L3
    L14:
        this._$$describe = am3.h.c(r7);
        goto L3
    L7:
        am3.h.d(r5, r7);
        goto L3
    L15:
        r7.d(r1);
        setThreadSafe(true);
        if ((true & r3) == true) goto L37;
        this._$$btnShow = false;
        return;
    }

    @Override // com.bytedance.android.live.profit.vip.model.d
    public final String getBtnSchema() {
        return this._$$btnSchema;
    }

    @Override // com.bytedance.android.live.profit.vip.model.d
    public final boolean getBtnShow() {
        return this._$$btnShow;
    }

    @Override // com.bytedance.android.live.profit.vip.model.d
    public final String getBtnText() {
        return this._$$btnText;
    }

    @Override // com.bytedance.android.live.profit.vip.model.d
    public final String getDescribe() {
        return this._$$describe;
    }

    @Override // com.bytedance.android.live.profit.vip.model.d
    public final String getEmojiIconSelectUrl() {
        return this._$$emojiIconSelectUrl;
    }

    @Override // com.bytedance.android.live.profit.vip.model.d
    public final String getEmojiIconUnselectUrl() {
        return this._$$emojiIconUnselectUrl;
    }

    @Override // com.bytedance.android.live.profit.vip.model.d
    public final String getEmojiTabName() {
        return this._$$emojiTabName;
    }

    @Override // com.bytedance.android.live.profit.vip.model.d
    public final void setBtnSchema(String r1) {
        this._$$btnSchema = r1;
    }

    @Override // com.bytedance.android.live.profit.vip.model.d
    public final void setBtnShow(boolean r1) {
        this._$$btnShow = r1;
    }

    @Override // com.bytedance.android.live.profit.vip.model.d
    public final void setBtnText(String r1) {
        this._$$btnText = r1;
    }

    @Override // com.bytedance.android.live.profit.vip.model.d
    public final void setDescribe(String r1) {
        this._$$describe = r1;
    }

    @Override // com.bytedance.android.live.profit.vip.model.d
    public final void setEmojiIconSelectUrl(String r1) {
        this._$$emojiIconSelectUrl = r1;
    }

    @Override // com.bytedance.android.live.profit.vip.model.d
    public final void setEmojiIconUnselectUrl(String r1) {
        this._$$emojiIconUnselectUrl = r1;
    }

    @Override // com.bytedance.android.live.profit.vip.model.d
    public final void setEmojiTabName(String r1) {
        this._$$emojiTabName = r1;
    }
}
