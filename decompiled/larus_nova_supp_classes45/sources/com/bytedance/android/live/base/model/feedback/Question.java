package com.bytedance.android.live.base.model.feedback;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.FeedbackCard.Question")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\bR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/base/model/feedback/Question;", "", "", "questionKey", "Ljava/lang/String;", "questionText", "", "type", "Ljava/lang/Long;", "", "Lcom/bytedance/android/live/base/model/feedback/Option;", "options", "Ljava/util/List;", "questionId", "", "Lcom/bytedance/android/live/base/model/feedback/RoomCardStruct;", "rooms", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Question implements h {

    @SerializedName("options")
    public List<Option> options;

    @SerializedName("question_id")
    public Long questionId;

    @SerializedName("question_key")
    public String questionKey;

    @SerializedName("question_text")
    public String questionText;

    @SerializedName("room_cards")
    public List<RoomCardStruct> rooms;

    @SerializedName("type")
    public Long type;

    public Question() {
    }

    public Question(g r5) {
        this.options = new ArrayList();
        this.rooms = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L14;
        switch(r2) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        List r3 = this.rooms;
        h r4 = new RoomCardStruct(r5);
    L10:
        r3.add(r4);
        goto L3
    L8:
        this.questionId = Long.valueOf(r5.j());
        goto L3
    L9:
        r3 = this.options;
        r4 = new Option(r5);
        goto L10
    L11:
        this.type = Long.valueOf(r5.j());
        goto L3
    L12:
        this.questionText = am3.h.c(r5);
        goto L3
    L13:
        this.questionKey = am3.h.c(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L14:
        r5.d(r0);
    }
}
