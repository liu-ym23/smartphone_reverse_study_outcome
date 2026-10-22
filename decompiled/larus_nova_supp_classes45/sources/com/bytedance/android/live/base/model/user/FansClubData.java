package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.User.FansClub.FansClubData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0012\b\u0007\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u000267B\u0007¢\u0006\u0004\b3\u00104J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00158\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R*\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u00158\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0017\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u0010\u001bR\"\u00100\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0007\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000b¨\u00068"}, d2 = {"Lcom/bytedance/android/live/base/model/user/FansClubData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lpy/h;", "", "getAnchorId", "", "_anchorId", "J", "get_anchorId", "()J", "set_anchorId", "(J)V", "_anchorOpenId", "Ljava/lang/String;", "get_anchorOpenId", "()Ljava/lang/String;", "set_anchorOpenId", "(Ljava/lang/String;)V", "clubName", "getClubName", "setClubName", "", "level", "I", "getLevel", "()I", "setLevel", "(I)V", "userFansClubStatus", "getUserFansClubStatus", "setUserFansClubStatus", "Lpy/u;", "badge", "Lpy/u;", "getBadge", "()Lpy/u;", "setBadge", "(Lpy/u;)V", "", "availableGiftIds", "Ljava/util/List;", "getAvailableGiftIds", "()Ljava/util/List;", "setAvailableGiftIds", "(Ljava/util/List;)V", "userGuardStatus", "getUserGuardStatus", "setUserGuardStatus", "guardExpiredTime", "getGuardExpiredTime", "setGuardExpiredTime", "<init>", "()V", "Companion", "a", "UserBadge", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FansClubData extends FlexModelBase<py.h> implements py.h, vh7.h {
    public static final int BADEGE_NINE_PATCH_SHOP_FANS_ICON = 1;
    public static final int BADEGE_NINE_PATCH_SHOP_FANS_SUBSCRIBE_ICON = 2;
    private static final int BADGE_ICON_NORMAL = 0;
    private static final int BADGE_ICON_SMALL = 0;
    public static final int BADGE_NINE_PATCH_DEFAULT = 4;
    public static final int BADGE_NINE_PATCH_SUBSCRIBE = 5;
    public static final int BADGE_NINE_PATCH_SUBSCRIBE_YEAR = 6;
    private static final int BADGE_SUBSCRIBE_ICON = 0;
    public static final a Companion = null;
    public static final int FANS_STATUS_ACTIVE = 1;
    public static final int FANS_STATUS_INACTIVE = 2;
    public static final int FANS_STATUS_UNKNOWN = 0;
    public static final int GUARD_STATUS_ACTIVE = 1;
    public static final int GUARD_STATUS_INACTIVE = 2;
    public static final int GUARD_STATUS_NOT_JOIN = 0;
    public static final int IMAGE_TYPE_FANS_CLUB_NINE_PATCH = 51;
    public static final int IMAGE_TYPE_SHOP_FANS_CLUB_SUBSCRIBE_NINE_PATCH = 57;
    public static final int IMAGE_TYPE_SUBSCRIBE_VIP_NINE_PATCH = 52;
    public static final int IMAGE_TYPE_SUBSCRIBE_YEAR_NINE_PATCH = 53;

    @SerializedName("anchor_id")
    protected long _anchorId;

    @IgnoreProtoFieldCheck
    @SerializedName("anchor_open_id")
    protected String _anchorOpenId;

    @SerializedName("available_gift_ids")
    protected List<Long> availableGiftIds;

    @IgnoreProtoFieldCheck
    @SerializedName("badge")
    protected py.u badge;

    @SerializedName("club_name")
    protected String clubName;

    @SerializedName("guard_expired_time")
    protected long guardExpiredTime;

    @SerializedName("level")
    protected int level;

    @SerializedName("user_fans_club_status")
    protected int userFansClubStatus;

    @SerializedName("user_guard_status")
    protected int userGuardStatus;

    @ProtoMessage("webcast.data.User.FansClub.FansClubData.UserBadge")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R2\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/base/model/user/FansClubData$UserBadge;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lpy/u;", "Lpy/k;", "getToShowIcon", "", "", "icons", "Ljava/util/Map;", "getIcons", "()Ljava/util/Map;", "setIcons", "(Ljava/util/Map;)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class UserBadge extends FlexModelBase<py.u> implements py.u, vh7.h {

        @SerializedName("icons")
        protected Map<Integer, ? extends py.k> icons;

        @SerializedName("title")
        protected String title;

        public UserBadge() {
            super(py.u.class);
        }

        @Override // py.u
        public py.k getToShowIcon() {
            py.k r1 = null;
            if (getIcons() != null) goto L5;
            return null;
        L5:
            Map<Integer, py.k> r0 = getIcons();
            Intrinsics.checkNotNull(r0);
            if (r0.get(6) == null) goto L8;
            Map<Integer, py.k> r2 = getIcons();
            Intrinsics.checkNotNull(r2);
            r1 = r2.get(6);
            int r3 = 53;
        L15:
            if (r1 == null) goto L17;
            r1.setImageType(Integer.valueOf(r3));
        L17:
            return r1;
        L8:
            Map<Integer, py.k> r4 = getIcons();
            Intrinsics.checkNotNull(r4);
            if (r4.get(5) == null) goto L11;
            Map<Integer, py.k> r5 = getIcons();
            Intrinsics.checkNotNull(r5);
            r1 = r5.get(5);
            r3 = 52;
            goto L15
        L11:
            Map<Integer, py.k> r6 = getIcons();
            Intrinsics.checkNotNull(r6);
            if (r6.get(4) == null) goto L14;
            Map<Integer, py.k> r7 = getIcons();
            Intrinsics.checkNotNull(r7);
            r1 = r7.get(4);
            r3 = 51;
            goto L15
        L14:
            r3 = 0;
            goto L15
        }

        @Override // py.u
        public Map<Integer, py.k> getIcons() {
            return this.icons;
        }

        @Override // py.u
        public String getTitle() {
            return this.title;
        }

        public UserBadge(am3.g r11) {
            super(py.u.class);
            this.icons = new HashMap();
            setThreadSafe(false);
            long r0 = r11.c();
        L3:
            int r2 = r11.f();
            if (r2 == (-1)) goto L26;
            am3.g.a r5 = decodeExtensionFields(r2, r11);
            if (r2 != 1) goto L7;
            long r7 = r11.c();
            Integer r3 = null;
            Object r6 = null;
        L11:
            int r9 = r11.f();
            if (r9 == (-1)) goto L18;
            if (r9 != 1) goto L14;
            r3 = Integer.valueOf(r11.i());
            goto L11
        L14:
            if (r9 != 2) goto L15;
            r6 = vh7.f.a(r11, py.k.class);
            goto L11
        L15:
            am3.h.e(r11);
            goto L11
        L18:
            r11.d(r7);
            Map<Integer, ? extends py.k> r4 = this.icons;
            if (r3 == null) goto L25;
            if (r6 == null) goto L23;
            r4.put(r3, r6);
            goto L3
        L23:
            throw new IllegalStateException("Value must not be null");
        L25:
            throw new IllegalStateException("Key must not be null");
        L7:
            if (r2 != 2) goto L8;
            this.title = am3.h.c(r11);
            goto L3
        L8:
            am3.h.d(r5, r11);
            goto L3
        L26:
            r11.d(r0);
            setThreadSafe(true);
        }

        @Override // py.u
        public void setIcons(Map<Integer, ? extends py.k> r1) {
            this.icons = r1;
        }

        @Override // py.u
        public void setTitle(String r1) {
            this.title = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public FansClubData() {
        super(py.h.class);
    }

    static {
        Companion = new a();
        BADGE_ICON_NORMAL = 1;
        BADGE_ICON_SMALL = 2;
        BADGE_SUBSCRIBE_ICON = 3;
    }

    @Override // py.h
    public String getAnchorId() {
        o0.a r0 = o0.a;
        Long r1 = Long.valueOf(this._anchorId);
        String r2 = this._anchorOpenId;
        r0.getClass();
        return o0.a.g(r1, r2);
    }

    public static final /* synthetic */ int access$getBADGE_ICON_NORMAL$cp() {
        return BADGE_ICON_NORMAL;
    }

    public static final /* synthetic */ int access$getBADGE_ICON_SMALL$cp() {
        return BADGE_ICON_SMALL;
    }

    public static final /* synthetic */ int access$getBADGE_SUBSCRIBE_ICON$cp() {
        return BADGE_SUBSCRIBE_ICON;
    }

    public final List<Long> getAvailableGiftIds() {
        return this.availableGiftIds;
    }

    @Override // py.h
    public py.u getBadge() {
        return this.badge;
    }

    @Override // py.h
    public String getClubName() {
        return this.clubName;
    }

    @Override // py.h
    public long getGuardExpiredTime() {
        return this.guardExpiredTime;
    }

    @Override // py.h
    public int getLevel() {
        return this.level;
    }

    @Override // py.h
    public int getUserFansClubStatus() {
        return this.userFansClubStatus;
    }

    @Override // py.h
    public int getUserGuardStatus() {
        return this.userGuardStatus;
    }

    public final long get_anchorId() {
        return this._anchorId;
    }

    public final String get_anchorOpenId() {
        return this._anchorOpenId;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.u] */
    public FansClubData(am3.g r6) {
        super(py.h.class);
        this.availableGiftIds = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L22;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 8) goto L8;
        this.userGuardStatus = r6.i();
        goto L3
    L8:
        if (r2 != 9) goto L10;
        this.guardExpiredTime = r6.j();
        goto L3
    L10:
        if (r2 != 5000) goto L11;
        this._anchorOpenId = am3.h.c(r6);
        goto L3
    L11:
        switch(r2) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L12;
        };
    L13:
        this._anchorId = r6.j();
        goto L3
    L14:
        this.availableGiftIds.add(Long.valueOf(r6.j()));
        goto L3
    L15:
        this.badge = vh7.f.a(r6, py.u.class);
        goto L3
    L16:
        this.userFansClubStatus = r6.i();
        goto L3
    L17:
        this.level = r6.i();
        goto L3
    L18:
        this.clubName = am3.h.c(r6);
        goto L3
    L12:
        am3.h.d(r3, r6);
        goto L3
    L22:
        r6.d(r0);
        setThreadSafe(true);
    }

    public final void setAvailableGiftIds(List<Long> r1) {
        this.availableGiftIds = r1;
    }

    @Override // py.h
    public void setBadge(py.u r1) {
        this.badge = r1;
    }

    @Override // py.h
    public void setClubName(String r1) {
        this.clubName = r1;
    }

    @Override // py.h
    public void setGuardExpiredTime(long r1) {
        this.guardExpiredTime = r1;
    }

    @Override // py.h
    public void setLevel(int r1) {
        this.level = r1;
    }

    @Override // py.h
    public void setUserFansClubStatus(int r1) {
        this.userFansClubStatus = r1;
    }

    @Override // py.h
    public void setUserGuardStatus(int r1) {
        this.userGuardStatus = r1;
    }

    public final void set_anchorId(long r1) {
        this._anchorId = r1;
    }

    public final void set_anchorOpenId(String r1) {
        this._anchorOpenId = r1;
    }
}
