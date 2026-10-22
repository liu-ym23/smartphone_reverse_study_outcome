package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.livesdkapi.model.DisplayRatio;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n1 implements c {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public float g;
    public float h;
    public float i;
    public float j;
    public int k;
    public int l;
    public DisplayRatio m;

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final boolean e() {
        return false;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void requestLayout(String r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int d() {
        return this.k;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getBottom() {
        return this.e;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final DisplayRatio getDisplayRatio() {
        return this.m;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getHeight() {
        return this.b;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getLeft() {
        return this.d;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getRight() {
        return this.f;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getScaleType() {
        return this.l;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final float getScaleX() {
        return this.i;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final float getScaleY() {
        return this.j;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getTop() {
        return this.c;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final float getTranslationX() {
        return this.g;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final float getTranslationY() {
        return this.h;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getWidth() {
        return this.a;
    }

    public n1(JsonObject r2) {
        this.a = r2.get("width").getAsInt();
        this.b = r2.get("height").getAsInt();
        this.c = r2.get("top").getAsInt();
        this.d = r2.get("left").getAsInt();
        this.e = r2.get("bottom").getAsInt();
        this.f = r2.get("right").getAsInt();
        this.g = r2.get("translationX").getAsFloat();
        this.h = r2.get("translationY").getAsFloat();
        this.i = r2.get("scaleX").getAsFloat();
        this.j = r2.get("scaleY").getAsFloat();
        this.k = r2.get("gravity").getAsInt();
        this.l = r2.get("scaleType").getAsInt();
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void a(int r1) {
        this.f = r1;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void b(int r1) {
        this.d = r1;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void c(int r1) {
        this.e = r1;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void f(int r1) {
        this.c = r1;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setDisplayRatio(DisplayRatio r1) {
        this.m = r1;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setGravity(int r1) {
        this.k = r1;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setHeight(int r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setScaleType(int r1) {
        this.l = r1;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setScaleX(float r1) {
        this.i = r1;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setScaleY(float r1) {
        this.j = r1;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setTranslationX(float r1) {
        this.g = r1;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setTranslationY(float r1) {
        this.h = r1;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setWidth(int r1) {
        this.a = r1;
    }
}
