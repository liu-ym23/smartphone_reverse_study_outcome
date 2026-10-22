package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001R2\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/j8;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "scenes", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "setScenes", "(Ljava/util/ArrayList;)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j8 {

    @SerializedName("scenes")
    private ArrayList<Integer> scenes;

    public j8() {
        this(null);
    }

    public final ArrayList<Integer> a() {
        return this.scenes;
    }

    public j8(Object r2) {
        ArrayList<Integer> r3 = new ArrayList();
        r3.add(8);
        r3.add(12);
        r3.add(5);
        r3.add(16);
        r3.add(9);
        Intrinsics.checkNotNullParameter(r3, "scenes");
        this.scenes = r3;
    }
}
