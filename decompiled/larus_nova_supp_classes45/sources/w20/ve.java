package w20;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lw20/ve;", "", "", "avatarUrl", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "anchorUserID", "b", "setAnchorUserID", "anchorNickname", "a", "setAnchorNickname", "columnTitle", "g", "setColumnTitle", "columnIntroduction", "f", "setColumnIntroduction", "columnBackgroundUrl", "e", "setColumnBackgroundUrl", "columnBackgroundColor", "d", "setColumnBackgroundColor", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ve {

    @SerializedName("anchorNickname")
    private String anchorNickname;

    @SerializedName("anchorUserID")
    private String anchorUserID;

    @SerializedName("avatarUrl")
    private String avatarUrl;

    @SerializedName("columnBackgroundColor")
    private String columnBackgroundColor;

    @SerializedName("columnBackgroundUrl")
    private String columnBackgroundUrl;

    @SerializedName("columnIntroduction")
    private String columnIntroduction;

    @SerializedName("columnTitle")
    private String columnTitle;

    public ve() {
    }

    public final String a() {
        return this.anchorNickname;
    }

    public final String b() {
        return this.anchorUserID;
    }

    public final String c() {
        return this.avatarUrl;
    }

    public final String d() {
        return this.columnBackgroundColor;
    }

    public final String e() {
        return this.columnBackgroundUrl;
    }

    public final String f() {
        return this.columnIntroduction;
    }

    public final String g() {
        return this.columnTitle;
    }
}
