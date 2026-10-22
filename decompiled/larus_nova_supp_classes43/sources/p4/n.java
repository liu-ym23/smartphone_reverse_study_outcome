package p4;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/GetAwemeCommonLoginInfoResponse;", "Lcom/bytedance/ai/bridge/remote/model/BaseApiResponse;", "bizLoginDescription", "", "awemeLoginDescription", "awemeLoginCommonPrivacyUrl", "authLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBizLoginDescription", "()Ljava/lang/String;", "getAwemeLoginDescription", "getAwemeLoginCommonPrivacyUrl", "getAuthLink", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class n extends a {

    @SerializedName("auth_link")
    private final String authLink;

    @SerializedName("aweme_login_common_privacy_url")
    private final String awemeLoginCommonPrivacyUrl;

    @SerializedName("aweme_login_description")
    private final String awemeLoginDescription;

    @SerializedName("biz_login_description")
    private final String bizLoginDescription;

    public n() {
        super(0);
        this.bizLoginDescription = null;
        this.awemeLoginDescription = null;
        this.awemeLoginCommonPrivacyUrl = null;
        this.authLink = null;
    }

    @Override // p4.a
    public final String toString() {
        return "GetAwemeCommonLoginInfoResponse(" + super.toString() + ", bizLoginDescription=" + this.bizLoginDescription + ", awemeLoginDescription=" + this.awemeLoginDescription + ", awemeLoginCommonPrivacyUrl=" + this.awemeLoginCommonPrivacyUrl + ", authLink=" + this.authLink + ')';
    }

    public final String e() {
        return this.authLink;
    }

    public final String f() {
        return this.awemeLoginDescription;
    }
}
