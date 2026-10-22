package com.bytedance.android.livesdk.interactivity.api.message.model;

import am3.g;
import com.bytedance.android.livesdk.interactivity.api.message.InteractivityMessageType;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.im.AnswerReviewMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0018\b\u0007\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/message/model/a;", "Ly32/a;", BuildConfig.FLAVOR, "reviewMsgTypeEnum", "I", "Q", "()I", "setReviewMsgTypeEnum", "(I)V", BuildConfig.FLAVOR, "answerId", "J", "G", "()J", "setAnswerId", "(J)V", "chatId", "getChatId", "setChatId", "reviewResTypeEnum", "T", "setReviewResTypeEnum", "videoPinId", "getVideoPinId", "setVideoPinId", "originalMsgId", "H", "setOriginalMsgId", "pinId", "P", "<init>", "()V", "a", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a extends y32.a implements h {

    @SerializedName("answer_id")
    protected long answerId;

    @SerializedName("chat_id")
    protected long chatId;

    @SerializedName("original_msg_id")
    protected long originalMsgId;

    @SerializedName("pin_id")
    protected long pinId;

    @SerializedName("answerReviewMsgTypeEnum")
    protected int reviewMsgTypeEnum;

    @SerializedName("answerReviewResTypeEnum")
    protected int reviewResTypeEnum;

    @SerializedName("video_pin_id")
    protected long videoPinId;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.api.message.model.a$a, reason: collision with other inner class name */
    public static final class C0092a {
    }

    static {
    }

    public a() {
    }

    @Override // y32.a
    public final InteractivityMessageType E() {
        return InteractivityMessageType.AnswerReview;
    }

    public final long G() {
        return this.answerId;
    }

    public final long H() {
        return this.originalMsgId;
    }

    public final long P() {
        return this.pinId;
    }

    public final int Q() {
        return this.reviewMsgTypeEnum;
    }

    public final int T() {
        return this.reviewResTypeEnum;
    }

    public a(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        switch(r2) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.pinId = r5.j();
        goto L3
    L8:
        this.originalMsgId = r5.j();
        goto L3
    L9:
        this.videoPinId = r5.j();
        goto L3
    L10:
        this.reviewResTypeEnum = r5.i();
        goto L3
    L11:
        this.chatId = r5.j();
        goto L3
    L12:
        this.answerId = r5.j();
        goto L3
    L13:
        this.reviewMsgTypeEnum = r5.i();
        goto L3
    L14:
        ((BaseMessage) this).baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }
}
