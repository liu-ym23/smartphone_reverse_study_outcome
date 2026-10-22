package com.obric.assistant.interaction.impl.window;

import android.graphics.Rect;
import android.view.Gravity;
import com.obric.capabilitykit.common.ErrorCode;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JZ\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007J \u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowHostBoundsCalculator;", "", "<init>", "()V", "resolveBounds", "Landroid/graphics/Rect;", "displayWidth", "", "displayHeight", "attrsWidth", "attrsHeight", "gravity", "x", "y", "decorWidth", "decorHeight", "layoutDirection", "resolveWindowDimension", "attrsSize", "decorSize", "displaySize", "resolveGravity", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowHostBoundsCalculator {
    public static final WindowHostBoundsCalculator INSTANCE = null;

    static {
        INSTANCE = new WindowHostBoundsCalculator();
    }

    private WindowHostBoundsCalculator() {
    }

    private final int resolveGravity(int r5) {
        boolean r1 = false;
        if ((r5 & 7) == 0) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if ((r5 & ErrorCode.DEVICE_LOCK_ERROR) == 0) goto L12;
        r1 = true;
    L12:
        if (r0 == true) goto L14;
        r5 = r5 | 8388611;
    L14:
        if (r1 == false) goto L16;
        return r5;
    L16:
        return r5 | 48;
    L5:
        if ((8388615 & r5) != 0) goto L8;
        r0 = false;
        goto L10
    }

    private final int resolveWindowDimension(int r2, int r3, int r4) {
        if (r2 == (-1)) goto L11;
        if (r2 > 0) goto L13;
        if (r3 > 0) goto L12;
        return 0;
    L12:
        return r3;
    L13:
        return r2;
    L11:
        return r4;
    }

    public final Rect resolveBounds(int r15, int r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24) {
        if (r15 <= 0) goto L18;
        if (r16 <= 0) goto L21;
        int r5 = resolveWindowDimension(r17, r22, r15);
        int r6 = resolveWindowDimension(r18, r23, r16);
        if (r5 <= 0) goto L19;
        if (r6 <= 0) goto L22;
        boolean r13 = false;
        Rect r12 = new Rect(0, 0, r15, r16);
        Rect r1 = new Rect();
        Gravity.apply(resolveGravity(r19), r5, r6, r12, r20, r21, r1, r24);
        if (r1.intersect(r12) == true) goto L13;
    L15:
        if (r13 == true) goto L17;
        return null;
    L17:
        return r1;
    L13:
        if (r1.isEmpty() == true) goto L15;
        r13 = true;
        goto L15
    L22:
        return null;
    L19:
        return null;
    L21:
        return null;
    L18:
        return null;
    }

    public static /* synthetic */ Rect resolveBounds$default(WindowHostBoundsCalculator r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23, Object r24) {
        if ((r23 & 512) == 0) goto L5;
        int r11 = 0;
    L7:
        return r12.resolveBounds(r13, r14, r15, r16, r17, r18, r19, r20, r21, r11);
    L5:
        r11 = r22;
        goto L7
    }
}
