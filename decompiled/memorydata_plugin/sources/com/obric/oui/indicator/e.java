package com.obric.oui.indicator;

import com.obric.oui.common.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ%\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH ¢\u0006\u0002\b\u0010J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u0006X \u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/indicator/OnPageChangeListenerHelper;", "", "()V", "TAG", "", "pageCount", "", "getPageCount$OUI_standardRelease", "()I", "onPageScrolled", "", "position", "positionOffset", "", "selectedPosition", "nextPosition", "onPageScrolled$OUI_standardRelease", "resolveScrollState", "Lcom/obric/oui/indicator/OnPageChangeListenerHelper$ScrollState;", "ScrollState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13957a;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/indicator/OnPageChangeListenerHelper$ScrollState;", "", "selectedPosition", "", "nextPosition", "positionOffset", "", "(IIF)V", "getNextPosition", "()I", "getPositionOffset", "()F", "getSelectedPosition", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f13958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13959b;
        private final float c;

        public a(int r1, int r2, float r3) {
            this.f13958a = r1;
            this.f13959b = r2;
            this.c = r3;
        }

        public final int a() {
            return this.f13958a;
        }

        public final int b() {
            return this.f13959b;
        }

        public final float c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f13958a == r6.f13958a) goto L12;
            return false;
        L12:
            if (this.f13959b == r6.f13959b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.c), Float.valueOf(r6.c)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f13958a) * 31) + Integer.hashCode(this.f13959b)) * 31) + Float.hashCode(this.c);
        }

        public String toString() {
            return "ScrollState(selectedPosition=" + this.f13958a + ", nextPosition=" + this.f13959b + ", positionOffset=" + this.c + ')';
        }
    }

    public e() {
        this.f13957a = "OnPageChangeHelper";
    }

    private final a b(int r7, float r8) {
        int r0 = a();
        if (r0 > 0) goto L6;
        f.f13501a.b(this.f13957a, Intrinsics.stringPlus("Ignore onPageScrolled because pageCount=", Integer.valueOf(r0)));
        return null;
    L6:
        boolean r3 = true;
        if (r0 == 1) goto L9;
        int r5 = r0 - 1;
        if (r7 < 0) goto L14;
        if (r7 > r5) goto L14;
    L15:
        if (r3 == true) goto L18;
        f.f13501a.b(this.f13957a, "Ignore onPageScrolled because position=" + r7 + ", pageCount=" + r0);
        return null;
    L18:
        if (r7 != r5) goto L23;
        if (r8 <= 0.0f) goto L23;
        return new a(r5, 0, r8);
    L23:
        if (r7 != r5) goto L26;
        return new a(r5, r5, 0.0f);
    L26:
        return new a(r7, r7 + 1, r8);
    L14:
        r3 = false;
        goto L15
    L9:
        return new a(0, 0, 0.0f);
    }

    public abstract int a();

    public final void a(int r3, float r4) {
        a r5 = b(r3, r4);
        if (r5 != null) goto L13;
        return;
    L13:
        a(r5.a(), r5.b(), r5.c());     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, IndexOutOfBoundsException.class) == false) goto L11;
        f.f13501a.b(this.f13957a, Intrinsics.stringPlus("OIndicator: ", e.getMessage()));
        return;
    L11:
        f.f13501a.a(this.f13957a, "抓住了一个Exception并ignore", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public abstract void a(int r1, int r2, float r3);
}
