package j8b;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/conditional/access/auth/v2/dlp/DLPPolicyStatusModel;", BuildConfig.FLAVOR, "<init>", "()V", "policy", "Lcom/ss/android/lark/conditional/access/auth/v2/dlp/DLPPolicyStatusModel$Policy;", "getPolicy", "()Lcom/ss/android/lark/conditional/access/auth/v2/dlp/DLPPolicyStatusModel$Policy;", "setPolicy", "(Lcom/ss/android/lark/conditional/access/auth/v2/dlp/DLPPolicyStatusModel$Policy;)V", "Policy", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i {

    @SerializedName("policy")
    private a policy;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/conditional/access/auth/v2/dlp/DLPPolicyStatusModel$Policy;", BuildConfig.FLAVOR, "<init>", "()V", SRStrategy.MEDIAINFO_KEY_RESOLUTION, BuildConfig.FLAVOR, "getRes", "()Z", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName(SRStrategy.MEDIAINFO_KEY_RESOLUTION)
        private final boolean res;

        public a() {
            this.res = true;
        }

        public final boolean a() {
            return this.res;
        }
    }

    public i() {
        this.policy = new a();
    }

    public final a a() {
        return this.policy;
    }
}
