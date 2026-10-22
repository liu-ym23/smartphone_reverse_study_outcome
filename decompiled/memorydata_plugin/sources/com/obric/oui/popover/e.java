package com.obric.oui.popover;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u001aJ\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\b¨\u0006\u000e"}, d2 = {"showPopoverSmartly", "", "Lcom/obric/oui/popover/OPopover;", "anchor", "Landroid/view/View;", "gravity", "", "isMiddle", "", "arrowOffset", "", "xOffset", "yOffset", "hasAdapted", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class e {
    public static final void a(b r15, View r16, int r17, boolean r18, float r19, int r20, int r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r15, "<this>");
        Intrinsics.checkNotNullParameter(r16, "anchor");
        c.a(c.f14327a, r15, r16, r17, r18, r19, r20, r21, r22, 0, 0, false, 1792, null);
    }

    public static /* synthetic */ void a(b r9, View r10, int r11, boolean r12, float r13, int r14, int r15, boolean r16, int r17, Object r18) {
        if ((r17 & 8) == 0) goto L5;
        float r5 = 0.0f;
    L7:
        if ((r17 & 16) == 0) goto L9;
        int r6 = 0;
    L11:
        if ((r17 & 32) == 0) goto L13;
        int r7 = 0;
    L15:
        if ((r17 & 64) == 0) goto L17;
        boolean r8 = false;
    L18:
        a(r9, r10, r11, r12, r5, r6, r7, r8);
        return;
    L17:
        r8 = r16;
        goto L18
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }
}
