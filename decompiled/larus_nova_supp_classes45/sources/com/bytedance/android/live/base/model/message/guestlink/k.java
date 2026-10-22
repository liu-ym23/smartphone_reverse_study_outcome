package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0014\bg\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001,R*\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0011\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00198VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\t\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\u00020\u00198VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\t\u001a\u0004\b\u001e\u0010\u001bR\u001a\u0010#\u001a\u00020\u00198VX\u0097\u0004¢\u0006\f\u0012\u0004\b\"\u0010\t\u001a\u0004\b!\u0010\u001bR\"\u0010$\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\t\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR$\u0010*\u001a\u0004\u0018\u00010\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\t\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016¨\u0006-"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/k;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "getUser$annotations", "()V", "user", "", "getScore", "()J", "setScore", "(J)V", "getScore$annotations", "score", "", "getScoreStr", "()Ljava/lang/String;", "setScoreStr", "(Ljava/lang/String;)V", "getScoreStr$annotations", "scoreStr", "", "getUserRole", "()I", "getUserRole$annotations", "userRole", "getUserRoleBefore", "getUserRoleBefore$annotations", "userRoleBefore", "getLinkType", "getLinkType$annotations", "linkType", "isBackground", "setBackground", "isBackground$annotations", "getLinkmicIdStr", "setLinkmicIdStr", "getLinkmicIdStr$annotations", "linkmicIdStr", "Companion", "a", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface k extends vh7.c<k> {
    public static final long APP_STATUS_BACK_GROUND = 1;
    public static final long APP_STATUS_FORE_GROUND = 0;
    public static final a Companion = null;

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

    @FieldName(name = "link_type")
    int getLinkType();

    @FieldName(name = "linkmic_id_str")
    String getLinkmicIdStr();

    @FieldName(name = "score")
    long getScore();

    @FieldName(name = "score_str")
    String getScoreStr();

    @FieldName(name = "user")
    IBaseUser getUser();

    @FieldName(name = "user_role")
    int getUserRole();

    @FieldName(name = "audience_linkmic_role")
    int getUserRoleBefore();

    @FieldName(name = "is_background")
    long isBackground();

    @FieldName(name = "is_background#setter")
    void setBackground(long r1);

    @FieldName(name = "linkmic_id_str#setter")
    void setLinkmicIdStr(String r1);

    @FieldName(name = "score#setter")
    void setScore(long r1);

    @FieldName(name = "score_str#setter")
    void setScoreStr(String r1);

    @FieldName(name = "user#setter")
    void setUser(IBaseUser r1);
}
