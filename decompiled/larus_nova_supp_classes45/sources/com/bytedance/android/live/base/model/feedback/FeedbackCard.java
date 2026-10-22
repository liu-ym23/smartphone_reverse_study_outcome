package com.bytedance.android.live.base.model.feedback;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.FeedbackCard")
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u0001:\u0001GB\u0007¢\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u000fR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010$R\"\u0010&\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,8\u0006¢\u0006\f\n\u0004\b.\u0010\u0016\u001a\u0004\b/\u00100R$\u00101\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010$\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010\u0006\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00058\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0006\u00107\u001a\u0004\b8\u00109R\"\u0010:\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010'\u001a\u0004\b;\u0010)\"\u0004\b<\u0010+R\"\u0010=\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b=\u0010?\"\u0004\b@\u0010AR\"\u0010B\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010>\u001a\u0004\bC\u0010?\"\u0004\bD\u0010A¨\u0006H"}, d2 = {"Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "", "", "toString", "getLogInfo", "Lcom/bytedance/android/live/base/model/feedback/FeedbackCard$FeedbackStatus;", "status", "", "updateFeedbackStatus", "", "canShowDirectly", "isComplete", "isPsEmojiFeedback", "shouldRecordIgnoreAction", "title", "Ljava/lang/String;", "", "feedbackId", "Ljava/lang/Long;", "", "Lcom/bytedance/android/live/base/model/feedback/Question;", "question", "Ljava/util/List;", "Lcom/bytedance/android/live/base/model/feedback/Condition;", "condition", "Lcom/bytedance/android/live/base/model/feedback/Condition;", "roomId", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", NewBroadcastMonitor.PAGE.ROOM, "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "negativeText", "Lcom/bytedance/android/live/base/model/ImageModel;", "bgm", "Lcom/bytedance/android/live/base/model/ImageModel;", "", "feedbackType", "Ljava/lang/Integer;", "inflowFeedbackType", "scene", "I", "getScene", "()I", "setScene", "(I)V", "", "Lcom/bytedance/android/live/base/model/feedback/RoomCardStruct;", "likedRooms", "getLikedRooms", "()Ljava/util/List;", "index", "getIndex", "()Ljava/lang/Integer;", "setIndex", "(Ljava/lang/Integer;)V", "<set-?>", "Lcom/bytedance/android/live/base/model/feedback/FeedbackCard$FeedbackStatus;", "getStatus", "()Lcom/bytedance/android/live/base/model/feedback/FeedbackCard$FeedbackStatus;", "backToLeaveRoomAction", "getBackToLeaveRoomAction", "setBackToLeaveRoomAction", "isSlideUpToLeaveRoom", "Z", "()Z", "setSlideUpToLeaveRoom", "(Z)V", "fromPreview", "getFromPreview", "setFromPreview", "<init>", "()V", "FeedbackStatus", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedbackCard implements h {
    private int backToLeaveRoomAction;

    @SerializedName("bgm")
    public ImageModel bgm;

    @SerializedName("condition")
    public Condition condition;

    @SerializedName("feedback_id")
    public Long feedbackId;

    @IgnoreProtoFieldCheck
    @SerializedName("feedback_type")
    public Integer feedbackType;
    private boolean fromPreview;
    private Integer index;

    @IgnoreProtoFieldCheck
    @SerializedName("inflow_feedback_type")
    public Integer inflowFeedbackType;
    private boolean isSlideUpToLeaveRoom;
    private final List<RoomCardStruct> likedRooms;

    @SerializedName("negative_text")
    public String negativeText;

    @SerializedName("question")
    public List<Question> question;

    @SerializedName("room_data")
    public Room room;

    @SerializedName("room_id")
    public Long roomId;

    @SerializedName("scene")
    protected int scene;
    private FeedbackStatus status;

    @SerializedName("title")
    public String title;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/base/model/feedback/FeedbackCard$FeedbackStatus;", "", "DEFAULT", "SHOWING", "COMPLETE", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum FeedbackStatus extends Enum<FeedbackStatus> {
        public static final FeedbackStatus COMPLETE = null;
        public static final FeedbackStatus DEFAULT = null;
        public static final FeedbackStatus SHOWING = null;
        public static final /* synthetic */ FeedbackStatus[] a = null;

        static {
            FeedbackStatus r1 = new FeedbackStatus("DEFAULT", 0);
            DEFAULT = r1;
            FeedbackStatus r2 = new FeedbackStatus("SHOWING", 1);
            SHOWING = r2;
            FeedbackStatus r3 = new FeedbackStatus("COMPLETE", 2);
            COMPLETE = r3;
            a = new FeedbackStatus[]{r1, r2, r3};
        }

        public static FeedbackStatus valueOf(String r1) {
            return (FeedbackStatus) r27.a.a(FeedbackStatus.class, r1);
        }

        public static FeedbackStatus[] values() {
            return (FeedbackStatus[]) a.clone();
        }

        public FeedbackStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final boolean canShowDirectly() {
        if (FeedbackStatus.DEFAULT.compareTo(this.status) < 0) goto L5;
    L7:
        return false;
    L5:
        if (this.status.compareTo(FeedbackStatus.COMPLETE) >= 0) goto L7;
        return true;
    }

    public final String getLogInfo() {
        LinkedHashMap r0 = new LinkedHashMap();
        List<Question> r1 = this.question;
        if (r1 == null) goto L16;
        Iterator<T> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L16;
        Question r3 = (Question) r2.next();
        String r4 = r3.questionKey + '_' + r3.questionText;
        List<Option> r5 = r3.options;
        if (r5 == null) goto L13;
        List<Option> r6 = r5;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L11:
        if (r8.hasNext() == false) goto L14;
        Option r9 = (Option) r8.next();
        r7.add(r9.key + '_' + r9.text);
    L14:
        r0.put(r4, r7);
        goto L6
    L13:
        r7 = new ArrayList();
    L16:
        return r0.toString();
    }

    public final boolean isComplete() {
        if (this.status != FeedbackStatus.COMPLETE) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPsEmojiFeedback() {
        Integer r0 = this.feedbackType;
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 10) goto L8;
        return true;
    }

    public final boolean shouldRecordIgnoreAction() {
        Condition r0 = this.condition;
        if (r0 == null) goto L15;
        ClientImpression r1 = r0.clientImpression;
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.ignoreCounts != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 != true) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (r1.ignoreInterval == null) goto L11;
        r2 = true;
        goto L12
    L15:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("{roomId:");
        r0.append(this.roomId);
        r0.append(",condition:");
        Condition r1 = this.condition;
        if (r1 == null) goto L5;
        String r2 = r1.toString();
    L6:
        r0.append(r2);
        r0.append("}");
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public FeedbackCard() {
        this.likedRooms = new ArrayList();
        this.index = 0;
        this.status = FeedbackStatus.DEFAULT;
        this.backToLeaveRoomAction = -1;
        this.isSlideUpToLeaveRoom = true;
        this.feedbackType = 1;
        this.inflowFeedbackType = 1;
        this.scene = -1;
    }

    public final int getBackToLeaveRoomAction() {
        return this.backToLeaveRoomAction;
    }

    public final boolean getFromPreview() {
        return this.fromPreview;
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final List<RoomCardStruct> getLikedRooms() {
        return this.likedRooms;
    }

    public final int getScene() {
        return this.scene;
    }

    public final FeedbackStatus getStatus() {
        return this.status;
    }

    public final boolean isSlideUpToLeaveRoom() {
        return this.isSlideUpToLeaveRoom;
    }

    public FeedbackCard(g r9) {
        this.question = new ArrayList();
        this.likedRooms = new ArrayList();
        boolean r0 = false;
        this.index = 0;
        this.status = FeedbackStatus.DEFAULT;
        this.backToLeaveRoomAction = -1;
        this.isSlideUpToLeaveRoom = true;
        long r4 = r9.c();
    L3:
        int r6 = r9.f();
        if (r6 == (-1)) goto L18;
        switch(r6) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L6;
            case 12: goto L7;
            default: goto L6;
        };
    L7:
        this.scene = r9.i();
        r0 = r0 | true;
        goto L3
    L8:
        this.inflowFeedbackType = Integer.valueOf(r9.i());
        goto L3
    L9:
        this.feedbackType = Integer.valueOf(r9.i());
        goto L3
    L10:
        this.bgm = x.a(r9);
        goto L3
    L11:
        this.negativeText = am3.h.c(r9);
        goto L3
    L12:
        this.room = new Room(r9);
        goto L3
    L13:
        this.roomId = Long.valueOf(r9.j());
        goto L3
    L14:
        this.condition = new Condition(r9);
        goto L3
    L15:
        this.question.add(new Question(r9));
        goto L3
    L16:
        this.feedbackId = Long.valueOf(r9.j());
        goto L3
    L17:
        this.title = am3.h.c(r9);
        goto L3
    L6:
        am3.h.e(r9);
        goto L3
    L18:
        r9.d(r4);
        if (this.feedbackType != null) goto L22;
        this.feedbackType = 1;
    L22:
        if (this.inflowFeedbackType != null) goto L25;
        this.inflowFeedbackType = 1;
    L25:
        if ((r0 & true) == true) goto L54;
        this.scene = -1;
        return;
    }

    public final void setBackToLeaveRoomAction(int r1) {
        this.backToLeaveRoomAction = r1;
    }

    public final void setFromPreview(boolean r1) {
        this.fromPreview = r1;
    }

    public final void setIndex(Integer r1) {
        this.index = r1;
    }

    public final void setScene(int r1) {
        this.scene = r1;
    }

    public final void setSlideUpToLeaveRoom(boolean r1) {
        this.isSlideUpToLeaveRoom = r1;
    }

    public final void updateFeedbackStatus(FeedbackStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
        this.status = r2;
    }
}
