package com.ss.android.lark.conditional.access.display;

import com.bytedance.lark.pb.security.v1.CustomDisplayConfig;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionRequest;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionResponse;
import io.reactivex.Single;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface g {

    public static final class a {
        public static /* synthetic */ void a(g r1, List r2) {
            r1.S5(r2, false);
        }
    }

    Single<? extends CustomDisplayConfig> Ld(String r1, String r2);

    void S5(List<String> r1, boolean r2);

    Single<QueryPolicyCenterResourceBlockActionResponse> U(QueryPolicyCenterResourceBlockActionRequest.Builder r1);

    Single v5(String r1);

    Single<CustomDisplayModel> ye(String r1, String r2);
}
