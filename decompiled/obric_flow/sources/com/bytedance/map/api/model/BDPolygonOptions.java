package com.bytedance.map.api.model;

import android.graphics.Color;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BDPolygonOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f6927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6928c;
    public int d;
    public float e;

    public BDPolygonOptions() {
        this.f6928c = Color.argb(0, 255, 255, 255);
        this.d = Color.argb(255, 0, 0, 0);
        this.e = 10.0f;
    }
}
