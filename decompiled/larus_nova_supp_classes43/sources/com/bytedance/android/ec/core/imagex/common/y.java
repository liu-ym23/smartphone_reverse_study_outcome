package com.bytedance.android.ec.core.imagex.common;

import com.bytedance.android.ec.core.imagex.common.z;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/common/y;", "Lcom/bytedance/android/ec/core/imagex/common/z;", "T", "", "", "bizTag", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "", "bizTags", "Ljava/util/List;", "b", "()Ljava/util/List;", "content", "c", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y<T extends z> {

    @SerializedName("biz_tag")
    private final String bizTag;

    @SerializedName("biz_tags")
    private final List<String> bizTags;

    @SerializedName("content")
    private final List<T> content;

    public y() {
    }

    public final String a() {
        return this.bizTag;
    }

    public final List<String> b() {
        return this.bizTags;
    }

    public final List<T> c() {
        return this.content;
    }
}
