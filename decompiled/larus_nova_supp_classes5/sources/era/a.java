package era;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b4\u00105R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR.\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010 \u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001cR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b,\u0010.\"\u0004\b/\u00100R$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\b¨\u00066"}, d2 = {"Lera/a;", "", "", "secUserId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "userName", "getUserName", "h", "userAvatar", "getUserAvatar", "g", "userAvatarUri", "getUserAvatarUri", "setUserAvatarUri", "value", "userSession", "getUserSession", "setUserSession", "", "accountType", "I", "getAccountType", "()I", "setAccountType", "(I)V", "appid", "getAppid", "d", "isLogin", "e", "fromInstallId", "getFromInstallId", "setFromInstallId", "accountExtra", "a", "setAccountExtra", "errMsg", "getErrMsg", "setErrMsg", "", "isKidMode", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setKidMode", "(Ljava/lang/Boolean;)V", "dTicket", "b", "setDTicket", "<init>", "()V", "sec_share_data_release"}, k = 1, mv = {1, 4, 0})
public class a {

    @SerializedName("account_extra")
    private String accountExtra;

    @SerializedName("account_type")
    private int accountType;

    @SerializedName("app_id")
    private int appid;

    @SerializedName("d_ticket")
    private String dTicket;

    @SerializedName("error_msg")
    private String errMsg;

    @SerializedName("from_install_id")
    private String fromInstallId;

    @SerializedName("is_key_mode")
    private Boolean isKidMode;

    @SerializedName("account_online")
    private int isLogin;

    @SerializedName("sec_user_id")
    private String secUserId;

    @SerializedName("user_avatar")
    private String userAvatar;

    @SerializedName("user_avatar_uri")
    private String userAvatarUri;

    @SerializedName("user_name")
    private String userName;

    @SerializedName("user_session")
    private String userSession;

    public a() {
    }

    public final String a() {
        return this.accountExtra;
    }

    public final String b() {
        return this.dTicket;
    }

    public final String c() {
        return this.secUserId;
    }

    public final void d(int r1) {
        this.appid = r1;
    }

    public final void e(int r1) {
        this.isLogin = r1;
    }

    public final void f(String r1) {
        this.secUserId = r1;
    }

    public final void g(String r1) {
        this.userAvatar = r1;
    }

    public final void h(String r1) {
        this.userName = r1;
    }
}
