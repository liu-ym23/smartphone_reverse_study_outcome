package io.noties.markwon.scrollable;

import com.bytedance.crash.entity.EventBody;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R$\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004R\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lio/noties/markwon/scrollable/HorizontalScrollable;", "", "overScale", "", "(F)V", "isScrollable", "", "()Z", EventBody.KEY_VALUE, "maxScroll", "getMaxScroll", "()F", "setMaxScroll", "over", "getOver", "getOverScale", "scrollX", "getScrollX", "setScrollX$markwon_core_release", "toString", "", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f16664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f16665b;
    private final float c;

    public b() {
        this(0.0f, 1, null);
    }

    public b(float r1) {
        this.c = r1;
    }

    public /* synthetic */ b(float r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0.1f;
    L5:
        this(r1);
    }

    public final float a() {
        return Math.abs(this.f16665b) * this.c;
    }

    public final void a(float r3) {
        this.f16664a = Math.max((-this.f16665b) - a(), Math.min(a(), r3));
    }

    public final float b() {
        return this.f16664a;
    }

    public final void b(float r2) {
        this.f16665b = Math.max(0.0f, r2);
    }

    public final float c() {
        return this.f16665b;
    }

    public final boolean d() {
        if (this.f16665b <= 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public final float e() {
        return this.c;
    }

    public String toString() {
        return "HorizontalScrollable(scrollX=" + this.f16664a + ", maxScroll=" + this.f16665b + ')';
    }
}
