package com.bytedance.android.livesdk.interactivity.pin.business.qa.api;

import am3.g;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.room.AnswerHighlightRequest")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0016\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0016\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0016\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0016\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\rR$\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/qa/api/AnswerHighlightRequest;", BuildConfig.FLAVOR, "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "toRequestFieldMap", "scene", "Ljava/lang/String;", BuildConfig.FLAVOR, "actionType", "I", BuildConfig.FLAVOR, "roomId", "J", "question", "answer", "nickName", "_commenterId", "_commenterOpenId", "answerId", "questionMsgId", "answerMsgId", "value", "getCommenterId", "()Ljava/lang/String;", "setCommenterId", "(Ljava/lang/String;)V", "commenterId", "<init>", "()V", "Companion", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnswerHighlightRequest implements h {
    public static final int ACTION_TYPE_EDIT = 3;
    public static final int ACTION_TYPE_NOT_SUPPORT = 0;
    public static final int ACTION_TYPE_SET = 1;
    public static final int ACTION_TYPE_UNSET = 2;
    public static final a Companion = null;

    @SerializedName("commenter_id")
    public long _commenterId;

    @SerializedName("commenter_open_id")
    public String _commenterOpenId;

    @SerializedName("action_type")
    public int actionType;

    @SerializedName("answer")
    public String answer;

    @SerializedName("answer_id")
    public long answerId;

    @SerializedName("answer_msg_id")
    public long answerMsgId;

    @SerializedName("nick_name")
    public String nickName;

    @SerializedName("question")
    public String question;

    @SerializedName("question_msg_id")
    public long questionMsgId;

    @SerializedName("room_id")
    public long roomId;

    @SerializedName("scene")
    public String scene;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getCommenterId() {
        o0.a r0 = o0.a;
        Long r1 = Long.valueOf(this._commenterId);
        String r2 = this._commenterOpenId;
        r0.getClass();
        return o0.a.g(r1, r2);
    }

    public final HashMap<String, String> toRequestFieldMap() {
        HashMap<String, String> r0 = new HashMap();
        String r1 = this.scene;
        if (r1 == null) goto L5;
        String r2 = r0.put("scene", r1);
    L5:
        r0.put("action_type", String.valueOf(this.actionType));
        r0.put("room_id", String.valueOf(this.roomId));
        String r3 = this.question;
        if (r3 == null) goto L8;
        String r4 = r0.put("question", r3);
    L8:
        String r5 = this.answer;
        if (r5 == null) goto L11;
        String r6 = r0.put("answer", r5);
    L11:
        String r7 = this.nickName;
        if (r7 == null) goto L14;
        String r8 = r0.put("nick_name", r7);
    L14:
        r0.put("commenter_id", getCommenterId());
        r0.put("answer_id", String.valueOf(this.answerId));
        r0.put("question_msg_id", String.valueOf(this.questionMsgId));
        r0.put("answer_msg_id", String.valueOf(this.answerMsgId));
        return r0;
    }

    public AnswerHighlightRequest() {
        this._commenterOpenId = "0";
    }

    public AnswerHighlightRequest(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L20;
        if (r2 != 5000) goto L7;
        this._commenterOpenId = am3.h.c(r5);
        goto L3
    L7:
        switch(r2) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            default: goto L8;
        };
    L9:
        this.answerMsgId = r5.j();
        goto L3
    L10:
        this.questionMsgId = r5.j();
        goto L3
    L11:
        this.answerId = r5.j();
        goto L3
    L12:
        this._commenterId = r5.j();
        goto L3
    L13:
        this.nickName = am3.h.c(r5);
        goto L3
    L14:
        this.answer = am3.h.c(r5);
        goto L3
    L15:
        this.question = am3.h.c(r5);
        goto L3
    L16:
        this.roomId = r5.j();
        goto L3
    L17:
        this.actionType = r5.i();
        goto L3
    L18:
        this.scene = am3.h.c(r5);
        goto L3
    L8:
        am3.h.e(r5);
        goto L3
    L20:
        r5.d(r0);
        if (this._commenterOpenId != null) goto L51;
        this._commenterOpenId = "0";
        return;
    }

    public final void setCommenterId(String r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        o0.a.getClass();
        this._commenterId = 0;
        this._commenterOpenId = r3;
    }
}
