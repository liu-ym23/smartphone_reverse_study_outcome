package com.bytedance.map.api;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class MapInitConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6867c;
    public final float d;
    public final boolean e;
    public final boolean f;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f6868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6869b;

        public Builder(Context r5) {
            this.f6869b = 0;
            this.f6868a = r5;
        }
    }

    public MapInitConfig(Builder r5) {
        this.f6865a = r5.f6868a;
        this.f6866b = 1;
        this.f6867c = r5.f6869b;
        this.d = 10.0f;
        this.e = true;
        this.f = true;
    }
}
