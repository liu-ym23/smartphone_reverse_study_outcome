package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.crash.SourceType;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/config/o5;", "", "", "", "roles", "Ljava/util/List;", "getRoles", "()Ljava/util/List;", "setRoles", "(Ljava/util/List;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class o5 {

    @SerializedName("roles")
    private List<String> roles;

    public o5() {
        this.roles = CollectionsKt.listOf(new String[]{SourceType.DEFAULT, "guest", SourceType.ANCHOR});
    }
}
