package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/pe1;", "", "", "Lcom/bytedance/android/livesdk/config/re1;", "list", "Ljava/util/List;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "", "level", "I", "getLevel", "()I", "setLevel", "(I)V", "<init>", "()V", "a", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class pe1 {

    @SerializedName("default_level")
    private int level;

    @SerializedName("list")
    private List<re1> list;

    public static final class a {
    }

    static {
    }

    @JvmStatic
    public static final pe1 a() {
        pe1 r0 = new pe1();
        r0.level = 2;
        r0.list = CollectionsKt.mutableListOf(new re1[]{new re1(1, 500, 1, 1, 3, 3, 4, 3), new re1(2, 500, 3, 2, 1, 1, 5, 3), new re1(3, 500, 4, 3, 1, 1, 2, 1)});
        return r0;
    }

    public pe1() {
        this.list = new ArrayList();
        this.level = 2;
    }
}
