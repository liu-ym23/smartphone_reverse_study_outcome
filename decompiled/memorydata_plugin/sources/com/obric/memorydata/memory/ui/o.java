package com.obric.memorydata.memory.ui;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/ui/ViewPagerTouchConflictPolicy;", "", "<init>", "()V", "shouldDisallowParentIntercept", "", "absDx", "", "absDy", "touchSlop", "", "hasVerticalOffset", "isOverscrollActive", "hasVerticalGesture", "allowViewPager2Fling", "disallowParentInterceptWhenVerticalOffset", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f11379a = null;

    static {
        f11379a = new o();
    }

    private o() {
    }

    public final boolean a(float r1, float r2, int r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        if (r7 == false) goto L20;
        if (r5 == true) goto L21;
        if (r6 == true) goto L22;
        if (r8 == false) goto L10;
        if (r4 == false) goto L10;
        return true;
    L10:
        float r9 = r3;
        if (r1 > r9) goto L16;
        if (r2 > r9) goto L16;
        return true;
    L16:
        if (r2 >= r1) goto L23;
        return false;
    L23:
        return true;
    L22:
        return true;
    L21:
        return true;
    L20:
        return true;
    }
}
