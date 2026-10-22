package com.obric.memorydata.sdk.entity.search.userprofile;

import android.content.Context;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/userprofile/UserProfileMemorySearch;", "", "<init>", "()V", "queryUserProfileMemory", "Lcom/obric/memorydata/sdk/entity/search/userprofile/UserProfileMemoryResult;", "context", "Landroid/content/Context;", "profileKey", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserProfileMemorySearch {
    public static final UserProfileMemorySearch INSTANCE = null;

    static {
        INSTANCE = new UserProfileMemorySearch();
    }

    private UserProfileMemorySearch() {
    }

    public final UserProfileMemoryResult queryUserProfileMemory(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "profileKey");
        MemoryResponse<UserProfileMemoryResult> r4 = b.f12829a.a(r1, r3);
        UserProfileMemoryResult r5 = (UserProfileMemoryResult) ZeusTransformUtils.preCheckCast(r4.getData(), UserProfileMemoryResult.class, "com.obric.memorydata.plugin");
        if (r4.getCode() != 0) goto L7;
        if (r5 == null) goto L7;
        return r5;
    L7:
        return new UserProfileMemoryResult(r4.getCode(), r4.getMessage(), null);
    }
}
