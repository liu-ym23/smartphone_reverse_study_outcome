package com.obric.memorydata.sdk.entity.search.userprofile;

import android.content.Context;
import android.os.Bundle;
import com.obric.memorydata.sdk.MemoryResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pka.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/userprofile/UserProfileMemorySearch;", "", "<init>", "()V", "queryUserProfileMemory", "Lcom/obric/memorydata/sdk/entity/search/userprofile/UserProfileMemoryResult;", "context", "Landroid/content/Context;", "profileKey", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserProfileMemorySearch {
    public static final UserProfileMemorySearch INSTANCE = null;

    static {
        INSTANCE = new UserProfileMemorySearch();
    }

    private UserProfileMemorySearch() {
    }

    public final UserProfileMemoryResult queryUserProfileMemory(Context r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "profileKey");
        a.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "profileKey");
        Bundle r0 = new Bundle();
        r0.putString("profileKey", r5);
        MemoryResponse r6 = a.c(r4, "queryUserProfileMemory", r0);
        UserProfileMemoryResult r7 = (UserProfileMemoryResult) r6.c;
        if (r6.a != 0) goto L7;
        if (r7 == null) goto L7;
        return r7;
    L7:
        return new UserProfileMemoryResult(r6.a, r6.b, null);
    }
}
