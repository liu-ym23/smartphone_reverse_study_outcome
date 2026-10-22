package com.obric.memorydata.memory.ui.settings;

import androidx.core.app.FrameMetricsAggregator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003Jc\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006%"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/MemorySettingsState;", "", "needIdentityAuth", "", "joinInUXP", "isProactiveMemoryEnabled", "screenObservationConfigured", "audioMemoryEnabled", "audioMemoryConfigured", "isLifelogInstall", "isAILabEnabled", "showUxpSwitch", "<init>", "(ZZZZZZZZZ)V", "getNeedIdentityAuth", "()Z", "getJoinInUXP", "getScreenObservationConfigured", "getAudioMemoryEnabled", "getAudioMemoryConfigured", "getShowUxpSwitch", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f11477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f11478b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;

    public k() {
        this(false, false, false, false, false, false, false, false, false, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public k(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9) {
        this.f11477a = r1;
        this.f11478b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    public /* synthetic */ k(boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r4 = false;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r5 = false;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r6 = false;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r7 = false;
    L21:
        if ((r11 & 64) == 0) goto L24;
        r8 = false;
    L24:
        if ((r11 & 128) == 0) goto L27;
        r9 = false;
    L27:
        if ((r11 & 256) == 0) goto L29;
        r10 = false;
    L29:
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ k a(k r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        boolean r2 = r10.f11477a;
    L7:
        if ((r20 & 2) == 0) goto L9;
        boolean r3 = r10.f11478b;
    L11:
        if ((r20 & 4) == 0) goto L13;
        boolean r4 = r10.c;
    L15:
        if ((r20 & 8) == 0) goto L17;
        boolean r5 = r10.d;
    L19:
        if ((r20 & 16) == 0) goto L21;
        boolean r6 = r10.e;
    L23:
        if ((r20 & 32) == 0) goto L25;
        boolean r7 = r10.f;
    L27:
        if ((r20 & 64) == 0) goto L29;
        boolean r8 = r10.g;
    L31:
        if ((r20 & 128) == 0) goto L33;
        boolean r9 = r10.h;
    L35:
        if ((r20 & 256) == 0) goto L37;
        boolean r1 = r10.i;
    L39:
        return r10.a(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final k a(boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20) {
        return new k(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public final boolean a() {
        return this.f11477a;
    }

    public final boolean b() {
        return this.f11478b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.e;
    }

    public final boolean e() {
        return this.g;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
        return false;
    L8:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.memorydata.plugin");
        if (this.f11477a == r6.f11477a) goto L12;
        return false;
    L12:
        if (this.f11478b == r6.f11478b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final boolean f() {
        return this.h;
    }

    public final boolean g() {
        return this.i;
    }

    public int hashCode() {
        return (((((((((((((((Boolean.hashCode(this.f11477a) * 31) + Boolean.hashCode(this.f11478b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + Boolean.hashCode(this.i);
    }

    public String toString() {
        return "MemorySettingsState(needIdentityAuth=" + this.f11477a + ", joinInUXP=" + this.f11478b + ", isProactiveMemoryEnabled=" + this.c + ", screenObservationConfigured=" + this.d + ", audioMemoryEnabled=" + this.e + ", audioMemoryConfigured=" + this.f + ", isLifelogInstall=" + this.g + ", isAILabEnabled=" + this.h + ", showUxpSwitch=" + this.i + ')';
    }
}
