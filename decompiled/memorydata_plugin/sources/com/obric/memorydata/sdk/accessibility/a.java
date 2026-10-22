package com.obric.memorydata.sdk.accessibility;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/sdk/accessibility/MemoryAccessibilityEvent;", "", "<init>", "()V", "TYPE_VIEW_CLICKED", "", "TYPE_VIEW_LONG_CLICKED", "isMemoryAccessibilityEvent", "", "type", "hasMemoryAccessibilityEvent", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12814a = null;

    static {
        f12814a = new a();
    }

    private a() {
    }

    public final boolean a(int r1) {
        if (r1 != 268435456) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 536870912) goto L8;
        return false;
    }

    public final boolean b(int r1) {
        if ((805306368 & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
