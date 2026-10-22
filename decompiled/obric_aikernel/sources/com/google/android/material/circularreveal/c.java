package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface c extends com.google.android.material.circularreveal.b.a {

    static /* synthetic */ class a {
    }

    public static class b implements TypeEvaluator<e> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator<e> f3153b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f3154a;

        static {
            f3153b = new b();
        }

        public b() {
            this.f3154a = new e(null);
        }

        @NonNull
        public e a(float r10, @NonNull e r11, @NonNull e r12) {
            this.f3154a.b(y5.a.d(r11.f3157a, r12.f3157a, r10), y5.a.d(r11.f3158b, r12.f3158b, r10), y5.a.d(r11.f3159c, r12.f3159c, r10));
            return this.f3154a;
        }

        @Override // android.animation.TypeEvaluator
        @NonNull
        public /* bridge */ /* synthetic */ e evaluate(float r10, @NonNull e r11, @NonNull e r12) {
            return a(r10, r11, r12);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.circularreveal.c$c, reason: collision with other inner class name */
    public static class C0079c extends Property<c, e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<c, e> f3155a = null;

        static {
            f3155a = new C0079c("circularReveal");
        }

        private C0079c(String r10) {
            super(e.class, r10);
        }

        @Nullable
        public e a(@NonNull c r10) {
            return r10.getRevealInfo();
        }

        public void b(@NonNull c r10, @Nullable e r11) {
            r10.setRevealInfo(r11);
        }

        @Override // android.util.Property
        @Nullable
        public /* bridge */ /* synthetic */ e get(@NonNull c r10) {
            return a(r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(@NonNull c r10, @Nullable e r11) {
            b(r10, r11);
        }
    }

    public static class d extends Property<c, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<c, Integer> f3156a = null;

        static {
            f3156a = new d("circularRevealScrimColor");
        }

        private d(String r10) {
            super(Integer.class, r10);
        }

        @NonNull
        public Integer a(@NonNull c r10) {
            return Integer.valueOf(r10.getCircularRevealScrimColor());
        }

        public void b(@NonNull c r10, @NonNull Integer r11) {
            r10.setCircularRevealScrimColor(r11.intValue());
        }

        @Override // android.util.Property
        @NonNull
        public /* bridge */ /* synthetic */ Integer get(@NonNull c r10) {
            return a(r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(@NonNull c r10, @NonNull Integer r11) {
            b(r10, r11);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f3157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f3158b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f3159c;

        private e() {
        }

        public e(float r10, float r11, float r12) {
            this.f3157a = r10;
            this.f3158b = r11;
            this.f3159c = r12;
        }

        /* synthetic */ e(a r10) {
            this();
        }

        public e(@NonNull e r10) {
            this(r10.f3157a, r10.f3158b, r10.f3159c);
        }

        public boolean a() {
            if (this.f3159c != Float.MAX_VALUE) goto L5;
            return true;
        L5:
            return false;
        }

        public void b(float r10, float r11, float r12) {
            this.f3157a = r10;
            this.f3158b = r11;
            this.f3159c = r12;
        }

        public void c(@NonNull e r10) {
            b(r10.f3157a, r10.f3158b, r10.f3159c);
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    @ColorInt
    int getCircularRevealScrimColor();

    @Nullable
    e getRevealInfo();

    void setCircularRevealOverlayDrawable(@Nullable Drawable r10);

    void setCircularRevealScrimColor(@ColorInt int r10);

    void setRevealInfo(@Nullable e r10);
}
