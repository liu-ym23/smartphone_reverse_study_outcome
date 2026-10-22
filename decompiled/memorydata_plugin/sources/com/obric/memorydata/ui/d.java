package com.obric.memorydata.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0001¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/ui/FragmentViewCallbackPolicy;", "", "<init>", "()V", "shouldRun", "", "isAdded", "postedFragmentView", "currentFragmentView", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f13003a = null;

    static {
        f13003a = new d();
    }

    private d() {
    }

    public final boolean a(boolean r1, Object r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "postedFragmentView");
        if (r1 == false) goto L6;
        if (r3 != r2) goto L6;
        return true;
    L6:
        return false;
    }
}
