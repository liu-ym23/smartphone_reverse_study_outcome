package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001R2\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/config/i8;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "supportScenes", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "setSupportScenes", "(Ljava/util/ArrayList;)V", "", "throttle", "J", "b", "()J", "setThrottle", "(J)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i8 {

    @SerializedName("support_scenes")
    private ArrayList<Integer> supportScenes;

    @SerializedName("throttle")
    private long throttle;

    public i8() {
        this(null);
    }

    public final ArrayList<Integer> a() {
        return this.supportScenes;
    }

    public final long b() {
        return this.throttle;
    }

    public i8(Object r3) {
        ArrayList<Integer> r4 = new ArrayList();
        r4.add(8);
        r4.add(12);
        r4.add(5);
        r4.add(16);
        r4.add(9);
        Intrinsics.checkNotNullParameter(r4, "supportScenes");
        this.supportScenes = r4;
        this.throttle = 200;
    }
}
