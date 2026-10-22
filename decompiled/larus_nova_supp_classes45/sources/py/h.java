package py;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\bg\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001)R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0011\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\t\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010 \u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\t\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\"\u0010'\u001a\u00020!8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\t\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lpy/h;", "Lvh7/c;", "", "", "getClubName", "()Ljava/lang/String;", "setClubName", "(Ljava/lang/String;)V", "getClubName$annotations", "()V", "clubName", "", "getLevel", "()I", "setLevel", "(I)V", "getLevel$annotations", "level", "getUserFansClubStatus", "setUserFansClubStatus", "getUserFansClubStatus$annotations", "userFansClubStatus", "Lpy/u;", "getBadge", "()Lpy/u;", "setBadge", "(Lpy/u;)V", "getBadge$annotations", "badge", "getUserGuardStatus", "setUserGuardStatus", "getUserGuardStatus$annotations", "userGuardStatus", "", "getGuardExpiredTime", "()J", "setGuardExpiredTime", "(J)V", "getGuardExpiredTime$annotations", "guardExpiredTime", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface h extends vh7.c<h> {
    public static final int BADEGE_NINE_PATCH_SHOP_FANS_ICON = 1;
    public static final int BADEGE_NINE_PATCH_SHOP_FANS_SUBSCRIBE_ICON = 2;
    public static final int BADGE_NINE_PATCH_DEFAULT = 4;
    public static final int BADGE_NINE_PATCH_SUBSCRIBE = 5;
    public static final int BADGE_NINE_PATCH_SUBSCRIBE_YEAR = 6;
    public static final a Companion = null;
    public static final int FANS_STATUS_ACTIVE = 1;
    public static final int FANS_STATUS_INACTIVE = 2;
    public static final int FANS_STATUS_UNKNOWN = 0;
    public static final int IMAGE_TYPE_FANS_CLUB_NINE_PATCH = 51;
    public static final int IMAGE_TYPE_SHOP_FANS_CLUB_SUBSCRIBE_NINE_PATCH = 57;
    public static final int IMAGE_TYPE_SUBSCRIBE_VIP_NINE_PATCH = 52;
    public static final int IMAGE_TYPE_SUBSCRIBE_YEAR_NINE_PATCH = 53;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ String getAnchorId();

    @FieldName(name = "badge")
    u getBadge();

    @FieldName(name = "club_name")
    String getClubName();

    @FieldName(name = "guard_expired_time")
    long getGuardExpiredTime();

    @FieldName(name = "level")
    int getLevel();

    @FieldName(name = "user_fans_club_status")
    int getUserFansClubStatus();

    @FieldName(name = "user_guard_status")
    int getUserGuardStatus();

    @FieldName(name = "badge#setter")
    void setBadge(u r1);

    @FieldName(name = "club_name#setter")
    void setClubName(String r1);

    @FieldName(name = "guard_expired_time#setter")
    void setGuardExpiredTime(long r1);

    @FieldName(name = "level#setter")
    void setLevel(int r1);

    @FieldName(name = "user_fans_club_status#setter")
    void setUserFansClubStatus(int r1);

    @FieldName(name = "user_guard_status#setter")
    void setUserGuardStatus(int r1);
}
