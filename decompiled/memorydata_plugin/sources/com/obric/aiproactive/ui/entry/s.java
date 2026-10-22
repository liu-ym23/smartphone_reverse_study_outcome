package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003Jc\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006*"}, d2 = {"Lcom/obric/aiproactive/ui/entry/NowVisualConfig;", "", "avatarSize", "", "centerYOffset", "titleTopMarginDp", "titleTextSizeSp", "subtitleTopMarginDp", "subtitleTextSizeSp", "subtitleHorizontalMarginDp", "eventTopMarginDp", "contentBottomPaddingDp", "<init>", "(FFFFFFFFF)V", "getAvatarSize", "()F", "getCenterYOffset", "getTitleTopMarginDp", "getTitleTextSizeSp", "getSubtitleTopMarginDp", "getSubtitleTextSizeSp", "getSubtitleHorizontalMarginDp", "getEventTopMarginDp", "getContentBottomPaddingDp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6634a = null;
    private static final s k = null;
    private static final s l = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f6635b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;
    private final float j;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/ui/entry/NowVisualConfig$Companion;", "", "<init>", "()V", "CENTERED_LARGE", "Lcom/obric/aiproactive/ui/entry/NowVisualConfig;", "getCENTERED_LARGE", "()Lcom/obric/aiproactive/ui/entry/NowVisualConfig;", "TOP_ALIGNED_SMALL", "getTOP_ALIGNED_SMALL", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final s a() {
            return s.j();
        }

        public final s b() {
            return s.k();
        }
    }

    static {
        f6634a = new a(null);
        k = new s(132.0f, 274.0f, 24.0f, 20.0f, 12.0f, 14.0f, 36.0f, 4.0f, 32.0f);
        l = new s(100.0f, 120.0f, 12.0f, 16.0f, 2.0f, 12.0f, 16.0f, 2.0f, 16.0f);
    }

    public s(float r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9) {
        this.f6635b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
    }

    public static final /* synthetic */ s j() {
        return k;
    }

    public static final /* synthetic */ s k() {
        return l;
    }

    public final float a() {
        return this.f6635b;
    }

    public final float b() {
        return this.c;
    }

    public final float c() {
        return this.d;
    }

    public final float d() {
        return this.e;
    }

    public final float e() {
        return this.f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, s.class) == true) goto L8;
        return false;
    L8:
        s r6 = (s) ZeusTransformUtils.preCheckCast(r5, s.class, "com.obric.memorydata.plugin");
        if (Float.compare(this.f6635b, r6.f6635b) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.c, r6.c) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.d, r6.d) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.e, r6.e) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f, r6.f) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.g, r6.g) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.h, r6.h) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.i, r6.i) == 0) goto L33;
        return false;
    L33:
        if (Float.compare(this.j, r6.j) == 0) goto L35;
        return false;
    L35:
        return true;
    }

    public final float f() {
        return this.g;
    }

    public final float g() {
        return this.h;
    }

    public final float h() {
        return this.i;
    }

    public int hashCode() {
        return (((((((((((((((Float.hashCode(this.f6635b) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + Float.hashCode(this.f)) * 31) + Float.hashCode(this.g)) * 31) + Float.hashCode(this.h)) * 31) + Float.hashCode(this.i)) * 31) + Float.hashCode(this.j);
    }

    public final float i() {
        return this.j;
    }

    public String toString() {
        return "NowVisualConfig(avatarSize=" + this.f6635b + ", centerYOffset=" + this.c + ", titleTopMarginDp=" + this.d + ", titleTextSizeSp=" + this.e + ", subtitleTopMarginDp=" + this.f + ", subtitleTextSizeSp=" + this.g + ", subtitleHorizontalMarginDp=" + this.h + ", eventTopMarginDp=" + this.i + ", contentBottomPaddingDp=" + this.j + ')';
    }
}
