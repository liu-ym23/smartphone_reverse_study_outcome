package com.bytedance.android.live.base.model.live;

import am3.g;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomStats;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.RoomStats")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b(\b\u0007\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002RSB\u0007¢\u0006\u0004\bO\u0010PJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R\"\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010\"\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR$\u0010&\u001a\u0004\u0018\u00010%8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b3\u0010\u001a\u001a\u0004\b4\u0010\u001c\"\u0004\b5\u0010\u001eR$\u00106\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b6\u0010.\u001a\u0004\b7\u00100\"\u0004\b8\u00102R$\u00109\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b9\u0010.\u001a\u0004\b:\u00100\"\u0004\b;\u00102R$\u0010<\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b<\u0010.\u001a\u0004\b=\u00100\"\u0004\b>\u00102R$\u0010?\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b?\u0010.\u001a\u0004\b@\u00100\"\u0004\bA\u00102R\"\u0010B\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bB\u0010\u001a\u001a\u0004\bC\u0010\u001c\"\u0004\bD\u0010\u001eR$\u0010E\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bE\u0010.\u001a\u0004\bF\u00100\"\u0004\bG\u00102R$\u0010H\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bH\u0010.\u001a\u0004\bI\u00100\"\u0004\bJ\u00102R\u001a\u0010K\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\bK\u0010\u001a\u001a\u0004\bL\u0010\u001cR\u001a\u0010M\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\bM\u0010\u001a\u001a\u0004\bN\u0010\u001c¨\u0006T"}, d2 = {"Lcom/bytedance/android/live/base/model/live/RoomStats;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats;", "other", "", "initWith", "", "o", "", "equals", "", "hashCode", "", "id", "J", "getId", "()J", "setId", "(J)V", "ticket", "getTicket", "setTicket", "money", "getMoney", "setMoney", "totalUser", "I", "getTotalUser", "()I", "setTotalUser", "(I)V", "followCount", "getFollowCount", "setFollowCount", "giftUVCount", "getGiftUVCount", "setGiftUVCount", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats$IUserComposition;", "userComposition", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats$IUserComposition;", "getUserComposition", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats$IUserComposition;", "setUserComposition", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats$IUserComposition;)V", "", "idStr", "Ljava/lang/String;", "getIdStr", "()Ljava/lang/String;", "setIdStr", "(Ljava/lang/String;)V", "enterCount", "getEnterCount", "setEnterCount", "totalUserDesp", "getTotalUserDesp", "setTotalUserDesp", "douPlusPromotion", "getDouPlusPromotion", "setDouPlusPromotion", "totalUserStr", "getTotalUserStr", "setTotalUserStr", "userCountStr", "getUserCountStr", "setUserCountStr", "commentCount", "getCommentCount", "setCommentCount", "topRightStr", "getTopRightStr", "setTopRightStr", "topRightStrComplete", "getTopRightStrComplete", "setTopRightStrComplete", "INT_32", "getINT_32", "INT_31", "getINT_31", "<init>", "()V", "Companion", "a", "UserComposition", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomStats extends FlexModelBase<IRoomStats> implements IRoomStats, h {
    public static final a Companion = null;
    private final int INT_31;
    private final int INT_32;

    @SerializedName("comment_count")
    protected int commentCount;

    @SerializedName("dou_plus_promotion")
    protected String douPlusPromotion;

    @SerializedName("enter_count")
    protected int enterCount;

    @SerializedName("follow_count")
    protected int followCount;

    @SerializedName("gift_uv_count")
    protected int giftUVCount;

    @SerializedName("id")
    protected long id;

    @SerializedName("id_str")
    protected String idStr;

    @SerializedName("money")
    protected long money;

    @SerializedName("fan_ticket")
    protected long ticket;

    @SerializedName("up_right_stats_str")
    protected String topRightStr;

    @SerializedName("up_right_stats_str_complete")
    protected String topRightStrComplete;

    @SerializedName("total_user")
    protected int totalUser;

    @SerializedName("total_user_desp")
    protected String totalUserDesp;

    @SerializedName("total_user_str")
    protected String totalUserStr;

    @SerializedName("user_count_composition")
    protected IRoomStats.IUserComposition userComposition;

    @SerializedName("user_count_str")
    protected String userCountStr;

    @ProtoMessage("webcast.data.RoomStats.UserCountComposition")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/base/model/live/RoomStats$UserComposition;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats$IUserComposition;", "()V", "city", "", "getCity", "()D", "setCity", "(D)V", "follow", "getFollow", "setFollow", "other", "getOther", "setOther", FileUtils.VIDEO, "getVideo", "setVideo", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class UserComposition extends FlexModelBase<IRoomStats.IUserComposition> implements IRoomStats.IUserComposition, h {

        @SerializedName("city")
        protected double city;

        @SerializedName("my_follow")
        protected double follow;

        @SerializedName("other")
        protected double other;

        @SerializedName("video_detail")
        protected double video;

        public UserComposition() {
            super(IRoomStats.IUserComposition.class);
        }

        public double getCity() {
            return this.city;
        }

        public double getFollow() {
            return this.follow;
        }

        public double getOther() {
            return this.other;
        }

        public double getVideo() {
            return this.video;
        }

        public UserComposition(g r6) {
            super(IRoomStats.IUserComposition.class);
            setThreadSafe(false);
            long r0 = r6.c();
        L3:
            int r2 = r6.f();
            if (r2 == (-1)) goto L18;
            g.a r3 = decodeExtensionFields(r2, r6);
            if (r2 != 1) goto L8;
            this.city = Double.longBitsToDouble(r6.h());
            goto L3
        L8:
            if (r2 != 2) goto L10;
            this.video = Double.longBitsToDouble(r6.h());
            goto L3
        L10:
            if (r2 != 3) goto L12;
            this.follow = Double.longBitsToDouble(r6.h());
            goto L3
        L12:
            if (r2 != 4) goto L13;
            this.other = Double.longBitsToDouble(r6.h());
            goto L3
        L13:
            am3.h.d(r3, r6);
            goto L3
        L18:
            r6.d(r0);
            setThreadSafe(true);
        }

        public void setCity(double r1) {
            this.city = r1;
        }

        public void setFollow(double r1) {
            this.follow = r1;
        }

        public void setOther(double r1) {
            this.other = r1;
        }

        public void setVideo(double r1) {
            this.video = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public RoomStats() {
        super(IRoomStats.class);
        this.INT_32 = 32;
        this.INT_31 = 31;
    }

    public int hashCode() {
        int r1 = (int) (getId() ^ (getId() >>> this.INT_32));
        int r0 = (this.INT_31 * r1) + ((int) (getTicket() ^ (getTicket() >>> this.INT_32)));
        int r2 = (this.INT_31 * r0) + ((int) (getMoney() ^ (getMoney() >>> this.INT_32)));
        int r3 = (this.INT_31 * r2) + getTotalUser();
        int r4 = (this.INT_31 * r3) + getFollowCount();
        int r5 = (this.INT_31 * r4) + getGiftUVCount();
        int r6 = this.INT_31 * r5;
        int r7 = 0;
        if (getIdStr() == null) goto L8;
        String r8 = getIdStr();
        if (r8 == null) goto L8;
        r7 = r8.hashCode();
    L8:
        return r6 + r7;
    }

    public int getCommentCount() {
        return this.commentCount;
    }

    public String getDouPlusPromotion() {
        return this.douPlusPromotion;
    }

    public int getEnterCount() {
        return this.enterCount;
    }

    public int getFollowCount() {
        return this.followCount;
    }

    public int getGiftUVCount() {
        return this.giftUVCount;
    }

    public final int getINT_31() {
        return this.INT_31;
    }

    public final int getINT_32() {
        return this.INT_32;
    }

    public long getId() {
        return this.id;
    }

    public String getIdStr() {
        return this.idStr;
    }

    public long getMoney() {
        return this.money;
    }

    public long getTicket() {
        return this.ticket;
    }

    public String getTopRightStr() {
        return this.topRightStr;
    }

    public String getTopRightStrComplete() {
        return this.topRightStrComplete;
    }

    public int getTotalUser() {
        return this.totalUser;
    }

    public String getTotalUserDesp() {
        return this.totalUserDesp;
    }

    public String getTotalUserStr() {
        return this.totalUserStr;
    }

    public IRoomStats.IUserComposition getUserComposition() {
        return this.userComposition;
    }

    public String getUserCountStr() {
        return this.userCountStr;
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.android.livesdkapi.depend.model.live.IRoomStats$IUserComposition, java.lang.Object] */
    public RoomStats(g r5) {
        super(IRoomStats.class);
        this.INT_32 = 32;
        this.INT_31 = 31;
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L24;
        g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L15;
            case 12: goto L14;
            case 13: goto L13;
            case 14: goto L7;
            case 15: goto L12;
            case 16: goto L11;
            case 17: goto L10;
            case 18: goto L7;
            case 19: goto L9;
            case 20: goto L8;
            default: goto L7;
        };
    L8:
        this.topRightStrComplete = am3.h.c(r5);
        goto L3
    L9:
        this.topRightStr = am3.h.c(r5);
        goto L3
    L10:
        this.commentCount = (int) r5.j();
        goto L3
    L11:
        this.userCountStr = am3.h.c(r5);
        goto L3
    L12:
        this.totalUserStr = am3.h.c(r5);
        goto L3
    L13:
        this.totalUserDesp = am3.h.c(r5);
        goto L3
    L14:
        this.douPlusPromotion = am3.h.c(r5);
        goto L3
    L15:
        this.enterCount = (int) r5.j();
        goto L3
    L16:
        this.userComposition = f.a(r5, IRoomStats.IUserComposition.class);
        goto L3
    L17:
        this.followCount = (int) r5.j();
        goto L3
    L18:
        this.giftUVCount = (int) r5.j();
        goto L3
    L19:
        this.totalUser = (int) r5.j();
        goto L3
    L20:
        this.money = r5.j();
        goto L3
    L21:
        this.ticket = r5.j();
        goto L3
    L22:
        this.idStr = am3.h.c(r5);
        goto L3
    L23:
        this.id = r5.j();
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L24:
        r5.d(r0);
        setThreadSafe(true);
    }

    private final void initWith(IRoomStats r3) {
        setId(r3.getId());
        setTicket(r3.getTicket());
        setMoney(r3.getMoney());
        setTotalUser(r3.getTotalUser());
        setFollowCount(r3.getFollowCount());
        setGiftUVCount(r3.getGiftUVCount());
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L37:
        return false;
    L8:
        if ((!Intrinsics.areEqual(RoomStats.class, r8.getClass())) == true) goto L37;
        RoomStats r9 = (RoomStats) r8;
        if (getId() == r9.getId()) goto L14;
        return false;
    L14:
        if (getTicket() == r9.getTicket()) goto L17;
        return false;
    L17:
        if (getMoney() == r9.getMoney()) goto L20;
        return false;
    L20:
        if (getFollowCount() == r9.getFollowCount()) goto L23;
        return false;
    L23:
        if (getGiftUVCount() == r9.getGiftUVCount()) goto L26;
        return false;
    L26:
        if (getIdStr() == null) goto L29;
        boolean r2 = !Intrinsics.areEqual(getIdStr(), r9.getIdStr());
    L32:
        if (r2 == false) goto L35;
    L33:
        return false;
    L35:
        if (getTotalUser() != r9.getTotalUser()) goto L33;
        return true;
    L29:
        if (r9.getIdStr() == null) goto L31;
        r2 = true;
        goto L32
    L31:
        r2 = false;
        goto L32
    }

    public void setCommentCount(int r1) {
        this.commentCount = r1;
    }

    public void setDouPlusPromotion(String r1) {
        this.douPlusPromotion = r1;
    }

    public void setEnterCount(int r1) {
        this.enterCount = r1;
    }

    public void setFollowCount(int r1) {
        this.followCount = r1;
    }

    public void setGiftUVCount(int r1) {
        this.giftUVCount = r1;
    }

    public void setId(long r1) {
        this.id = r1;
    }

    public void setIdStr(String r1) {
        this.idStr = r1;
    }

    public void setMoney(long r1) {
        this.money = r1;
    }

    public void setTicket(long r1) {
        this.ticket = r1;
    }

    public void setTopRightStr(String r1) {
        this.topRightStr = r1;
    }

    public void setTopRightStrComplete(String r1) {
        this.topRightStrComplete = r1;
    }

    public void setTotalUser(int r1) {
        this.totalUser = r1;
    }

    public void setTotalUserDesp(String r1) {
        this.totalUserDesp = r1;
    }

    public void setTotalUserStr(String r1) {
        this.totalUserStr = r1;
    }

    public void setUserComposition(IRoomStats.IUserComposition r1) {
        this.userComposition = r1;
    }

    public void setUserCountStr(String r1) {
        this.userCountStr = r1;
    }
}
