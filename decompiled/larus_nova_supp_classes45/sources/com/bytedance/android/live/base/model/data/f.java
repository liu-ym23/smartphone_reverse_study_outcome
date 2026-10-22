package com.bytedance.android.live.base.model.data;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/base/model/data/f;", "", "Lpy/k;", "groupPhoto", "Lpy/k;", "", "Lcom/bytedance/android/live/base/model/data/f$a;", "locationList", "Ljava/util/List;", "", "width", "I", "height", "", "shareContent", "Ljava/lang/String;", "<init>", "()V", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class f implements vh7.h {

    @SerializedName("group_photo")
    public py.k groupPhoto;

    @SerializedName("height")
    public int height;

    @SerializedName("location_list")
    public List<a> locationList;

    @SerializedName("share_content")
    public String shareContent;

    @SerializedName("width")
    public int width;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/base/model/data/f$a;", "", "", "locationX", "I", "locationY", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a implements vh7.h {

        @SerializedName("location_x")
        public int locationX;

        @SerializedName("location_y")
        public int locationY;

        public a() {
        }

        public final String toString() {
            return "locationX: " + this.locationX + "; locationY: " + this.locationY;
        }

        public a(am3.g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            this.locationX = r5.i();
            goto L3
        L8:
            if (r2 != 2) goto L9;
            this.locationY = r5.i();
            goto L3
        L9:
            am3.h.e(r5);
            goto L3
        L12:
            r5.d(r0);
        }
    }

    public f() {
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("group: ");
        py.k r1 = this.groupPhoto;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.toString();
    L6:
        r0.append(r3);
        r0.append("; locationList: ");
        List<a> r4 = this.locationList;
        if (r4 == null) goto L9;
        r2 = r4.toString();
    L9:
        r0.append(r2);
        r0.append("; width: ");
        r0.append(this.width);
        r0.append("; height: ");
        r0.append(this.height);
        return r0.toString();
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public f(am3.g r5) {
        this.locationList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.groupPhoto = vh7.f.a(r5, py.k.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.locationList.add(new a(r5));
        goto L3
    L10:
        if (r2 != 4) goto L12;
        this.width = r5.i();
        goto L3
    L12:
        if (r2 != 5) goto L14;
        this.height = r5.i();
        goto L3
    L14:
        if (r2 != 6) goto L15;
        this.shareContent = am3.h.c(r5);
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
    }
}
