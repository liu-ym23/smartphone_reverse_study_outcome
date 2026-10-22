package com.bytedance.android.live.base.model.message;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/base/model/message/y5;", "", "", "Lpy/k;", "images", "Ljava/util/List;", "b", "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "", "displayStyle", "I", "a", "()I", "setDisplayStyle", "(I)V", "Lcom/bytedance/android/live/base/model/message/z5;", "tag", "Lcom/bytedance/android/live/base/model/message/z5;", "c", "()Lcom/bytedance/android/live/base/model/message/z5;", "setTag", "(Lcom/bytedance/android/live/base/model/message/z5;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class y5 implements vh7.h {

    @SerializedName("display_style")
    protected int displayStyle;

    @SerializedName("images")
    protected List<py.k> images;

    @SerializedName("tag")
    protected z5 tag;

    public y5() {
    }

    public final int a() {
        return this.displayStyle;
    }

    public final List<py.k> b() {
        return this.images;
    }

    public final z5 c() {
        return this.tag;
    }

    public y5(am3.g r5) {
        this.images = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.images.add((py.k) vh7.f.a(r5, py.k.class));
        goto L3
    L8:
        if (r2 != 19) goto L10;
        this.tag = new z5(r5);
        goto L3
    L10:
        if (r2 != 20) goto L11;
        this.displayStyle = r5.i();
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }
}
