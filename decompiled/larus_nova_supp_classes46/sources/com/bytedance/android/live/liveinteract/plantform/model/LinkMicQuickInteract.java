package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.LinkmicQuickInteract")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0017¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/LinkMicQuickInteract;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/l;", "", "toString", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getSendGiftUser", "", "getInteractCarouselDuration", "", "getInteractContent", "", "getInteractType", "Lcom/bytedance/android/livesdkapi/message/Text;", "getText", "getSchema", "getToUsedID", "Lcom/bytedance/android/live/base/model/user/User;", "sendGiftUser", "Lcom/bytedance/android/live/base/model/user/User;", "interactCarouselDuration", "J", "interactContent", "Ljava/lang/String;", "toUsedID", "toUsedOpenID", "interactType", "I", "text", "Lcom/bytedance/android/livesdkapi/message/Text;", "schema", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkMicQuickInteract extends FlexModelBase<l> implements l, vh7.h {

    @SerializedName("thanks_carousel_duration")
    public long interactCarouselDuration;

    @SerializedName("thanks_content")
    public String interactContent;

    @SerializedName("interact_type")
    public int interactType;

    @SerializedName("schema")
    public String schema;

    @SerializedName("send_gift_user")
    public User sendGiftUser;

    @SerializedName("text")
    public Text text;

    @SerializedName("receive_gift_user_id")
    public long toUsedID;

    @SerializedName("receive_gift_user_open_id")
    public String toUsedOpenID;

    public LinkMicQuickInteract() {
        super(l.class);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.l
    public String getToUsedID() {
        com.bytedance.android.live.base.model.user.o0.a r0 = com.bytedance.android.live.base.model.user.o0.a;
        Long r1 = Long.valueOf(this.toUsedID);
        String r2 = this.toUsedOpenID;
        r0.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r1, r2);
    }

    public String toString() {
        return "LinkMicQuickInteract{sendGiftUser=" + this.sendGiftUser + ", interactCarouselDuration=" + this.interactCarouselDuration + ", interactContent='" + this.interactContent + "', toUsedID=" + this.toUsedID + '}';
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.l
    public long getInteractCarouselDuration() {
        return this.interactCarouselDuration;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.l
    public CharSequence getInteractContent() {
        return this.interactContent;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.l
    public int getInteractType() {
        return this.interactType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.l
    public String getSchema() {
        return this.schema;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.l
    public IBaseUser getSendGiftUser() {
        return this.sendGiftUser;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.l
    public Text getText() {
        return this.text;
    }

    public LinkMicQuickInteract(am3.g r6) {
        super(l.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L17;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 5000) goto L7;
        this.toUsedOpenID = am3.h.c(r6);
        goto L3
    L7:
        switch(r2) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L8;
        };
    L9:
        this.schema = am3.h.c(r6);
        goto L3
    L10:
        this.text = _Text_ProtoDecoder.decodeStatic(r6);
        goto L3
    L11:
        this.interactType = r6.i();
        goto L3
    L12:
        this.toUsedID = r6.j();
        goto L3
    L13:
        this.interactContent = am3.h.c(r6);
        goto L3
    L14:
        this.interactCarouselDuration = r6.j();
        goto L3
    L15:
        this.sendGiftUser = new User(r6);
        goto L3
    L8:
        am3.h.d(r3, r6);
        goto L3
    L17:
        r6.d(r0);
        setThreadSafe(true);
    }
}
