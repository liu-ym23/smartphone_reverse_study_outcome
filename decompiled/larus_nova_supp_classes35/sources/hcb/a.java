package hcb;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a {
    Context getContext();

    int getEnv2Type();

    InitSDKRequest.EnvType getEnvType();

    String getTenantBrand();

    String getUserId();

    String getUserUnit();

    boolean isPrivateKA();
}
