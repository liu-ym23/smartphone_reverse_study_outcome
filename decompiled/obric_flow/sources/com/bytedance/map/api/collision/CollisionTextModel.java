package com.bytedance.map.api.collision;

import ai.j0;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.IMarker;

/* JADX INFO: loaded from: classes2.dex */
public class CollisionTextModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IMarker f6880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6882c;
    public int d;
    public BDLatLng e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f6883h;

    public CollisionTextModel(IMarker r5) {
        this.f6880a = r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("CollisionTextModel{marker=");
        r5.append(this.f6880a);
        r5.append(", mWidth=");
        r5.append(this.f6881b);
        r5.append(", mHeight=");
        r5.append(this.f6882c);
        r5.append(", mContentPadding=");
        r5.append(this.d);
        r5.append(", mLatLng=");
        r5.append(this.e);
        r5.append(", mZIndex=");
        r5.append(this.f);
        r5.append(", mAlignmentType=");
        return j0.n(r5, this.g, '}');
    }
}
