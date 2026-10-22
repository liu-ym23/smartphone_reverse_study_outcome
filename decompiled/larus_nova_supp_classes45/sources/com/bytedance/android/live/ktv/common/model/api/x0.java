package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdkapi.depend.message.TagDressPageItem;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/x0;", "", "", "Lcom/bytedance/android/livesdkapi/depend/message/TagDressPageItem;", "tags", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lpy/k;", "avatar", "Lpy/k;", "a", "()Lpy/k;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class x0 implements vh7.h {

    @SerializedName("avatar")
    protected py.k avatar;

    @SerializedName("tags")
    protected List<TagDressPageItem> tags;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof x0) == false) goto L10;
        x0 r4 = (x0) r3;
        if (Intrinsics.areEqual(this.tags, r4.tags) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.avatar, r4.avatar) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<TagDressPageItem> r0 = this.tags;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        py.k r4 = this.avatar;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "TagList(tags=" + this.tags + ", avatar=" + this.avatar + ")";
    }

    public x0() {
        this.tags = null;
        this.avatar = null;
    }

    public final py.k a() {
        return this.avatar;
    }

    public final List<TagDressPageItem> b() {
        return this.tags;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public x0(am3.g r5) {
        this.tags = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.tags.add(new TagDressPageItem(r5));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.avatar = vh7.f.a(r5, py.k.class);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
        if (this.tags.isEmpty() == false) goto L16;
        this.tags = null;
    L16:
        if (this.avatar != null) goto L28;
        this.avatar = null;
        return;
    }
}
