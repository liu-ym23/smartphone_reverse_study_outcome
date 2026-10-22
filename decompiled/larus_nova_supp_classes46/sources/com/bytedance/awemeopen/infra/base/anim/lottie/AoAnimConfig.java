package com.bytedance.awemeopen.infra.base.anim.lottie;

import android.animation.Animator;
import com.bytedance.awemeopen.servicesapi.ui.AoAnimationServiceConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AoAnimConfig {
    public static final AoAnimConfig g = null;
    public final ResMode a;
    public final Object b;
    public final Object c;
    public final boolean d;
    public final b e;
    public final Function1<Throwable, Unit> f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/anim/lottie/AoAnimConfig$ResMode;", "", "Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationServiceConfig$ResMode;", "toServiceMode", "URL", "ASSET", "RAW_RES", "JSON_STREAM", "JSON_STRING", "ZIP_STREAM", "EMPTY", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
    public static final enum ResMode extends Enum<ResMode> {
        public static final ResMode ASSET = null;
        public static final ResMode EMPTY = null;
        public static final ResMode JSON_STREAM = null;
        public static final ResMode JSON_STRING = null;
        public static final ResMode RAW_RES = null;
        public static final ResMode URL = null;
        public static final ResMode ZIP_STREAM = null;
        public static final /* synthetic */ ResMode[] a = null;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ResMode.values().length];
                r0[ResMode.URL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L21:
                r0[ResMode.ASSET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L31:
                r0[ResMode.RAW_RES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[ResMode.JSON_STREAM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L25:
                r0[ResMode.JSON_STRING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
            L19:
                r0[ResMode.ZIP_STREAM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
            L27:
                r0[ResMode.EMPTY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
            L10:
                a = r0;
            }
        }

        public static ResMode valueOf(String r1) {
            return (ResMode) r27.a.a(ResMode.class, r1);
        }

        public static ResMode[] values() {
            return (ResMode[]) a.clone();
        }

        static {
            ResMode r0 = new ResMode("URL", 0);
            URL = r0;
            ResMode r1 = new ResMode("ASSET", 1);
            ASSET = r1;
            ResMode r3 = new ResMode("RAW_RES", 2);
            RAW_RES = r3;
            ResMode r5 = new ResMode("JSON_STREAM", 3);
            JSON_STREAM = r5;
            ResMode r7 = new ResMode("JSON_STRING", 4);
            JSON_STRING = r7;
            ResMode r9 = new ResMode("ZIP_STREAM", 5);
            ZIP_STREAM = r9;
            ResMode r11 = new ResMode("EMPTY", 6);
            EMPTY = r11;
            a = new ResMode[]{r0, r1, r3, r5, r7, r9, r11};
        }

        public final AoAnimationServiceConfig.ResMode toServiceMode() {
            switch(a.a[ordinal()]) {
                case 1: goto L13;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                default: goto L5;
            };
        L5:
            throw new NoWhenBranchMatchedException();
        L14:
            return AoAnimationServiceConfig.ResMode.EMPTY;
        L15:
            return AoAnimationServiceConfig.ResMode.ZIP_STREAM;
        L16:
            return AoAnimationServiceConfig.ResMode.JSON_STRING;
        L17:
            return AoAnimationServiceConfig.ResMode.JSON_STREAM;
        L18:
            return AoAnimationServiceConfig.ResMode.RAW_RES;
        L19:
            return AoAnimationServiceConfig.ResMode.ASSET;
        L13:
            return AoAnimationServiceConfig.ResMode.URL;
        }

        public ResMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public interface b extends Animator.AnimatorListener, Animator.AnimatorPauseListener {
        public static final a n1 = null;

        public static final class a implements b {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public final void onAnimationPause(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public final void onAnimationResume(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
            }
        }

        static {
            n1 = a.a;
        }
    }

    public AoAnimConfig() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AoAnimConfig) == true) goto L8;
        return false;
    L8:
        AoAnimConfig r6 = (AoAnimConfig) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Object r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        boolean r4 = this.d;
        ?? r5 = r4;
        if (r4 == false) goto L10;
        r5 = 1;
    L10:
        return ((((r3 + r5) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "AoAnimConfig(resMode=" + this.a + ", res=" + this.b + ", fallbackRes=" + this.c + ", isSync=" + this.d + ", lifecycleListener=" + this.e + ", onError=" + this.f + ')';
    }

    static {
        g = new AoAnimConfig(ResMode.EMPTY, new Object(), null, null, 60);
    }

    public AoAnimConfig(ResMode r2, Object r3, e r4, Function1 r5, int r6) {
        b r7 = r4;
        if ((r6 & 16) == 0) goto L6;
        r7 = b.n1;
    L6:
        if ((r6 & 32) == 0) goto L8;
        r5 = AnonymousClass1.INSTANCE;
    L8:
        Intrinsics.checkNotNullParameter(r2, "resMode");
        Intrinsics.checkNotNullParameter(r3, "res");
        Intrinsics.checkNotNullParameter(r7, "lifecycleListener");
        Intrinsics.checkNotNullParameter(r5, "onError");
        this.a = r2;
        this.b = r3;
        this.c = null;
        this.d = false;
        this.e = r7;
        this.f = r5;
    }
}
