package com.obric.assistant.interaction.impl.window;

import android.graphics.Rect;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowHostOutsideTouchPolicy;", "", "<init>", "()V", "shouldIgnoreForSystemGesture", "", "rawY", "", "windowBounds", "Landroid/graphics/Rect;", "isLandscapeWindowLayout", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowHostOutsideTouchPolicy {
    public static final WindowHostOutsideTouchPolicy INSTANCE = null;

    static {
        INSTANCE = new WindowHostOutsideTouchPolicy();
    }

    private WindowHostOutsideTouchPolicy() {
    }

    public final boolean shouldIgnoreForSystemGesture(float r2, Rect r3, boolean r4) {
        if (r4 == true) goto L5;
        return false;
    L5:
        if (Float.isNaN(r2) == true) goto L17;
        if (r3 != null) goto L10;
        return false;
    L10:
        if (r2 >= r3.top) goto L12;
    L13:
        return true;
    L12:
        if (r2 >= r3.bottom) goto L13;
        return false;
    L17:
        return false;
    }
}
