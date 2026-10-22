package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001f\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u0004\"\u0004\b\u001d\u0010\u0006R\u001a\u0010\"\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\b\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "Lvh7/c;", "", "getId", "()J", "setId", "(J)V", "getId$annotations", "()V", "id", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "getSender", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getSender$annotations", "sender", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getContent$annotations", "content", "", "getProcessStatus", "()I", "getProcessStatus$annotations", "processStatus", "getGiftId", "setGiftId", "getGiftId$annotations", "giftId", "getMsgDisappearTime", "getMsgDisappearTime$annotations", "msgDisappearTime", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IMessageBoardInfo extends vh7.c<IMessageBoardInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "content")
    String getContent();

    @FieldName(name = "gift_id")
    long getGiftId();

    @FieldName(name = "id")
    long getId();

    @FieldName(name = "msg_disappear_time")
    long getMsgDisappearTime();

    @FieldName(name = "process_status")
    int getProcessStatus();

    @FieldName(name = "sender")
    IBaseUser getSender();

    @FieldName(name = "content#setter")
    void setContent(String r1);

    @FieldName(name = "gift_id#setter")
    void setGiftId(long r1);

    @FieldName(name = "id#setter")
    void setId(long r1);
}
