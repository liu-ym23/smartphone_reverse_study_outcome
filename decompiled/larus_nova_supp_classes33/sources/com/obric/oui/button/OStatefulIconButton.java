package com.obric.oui.button;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0001\nR*\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/button/OStatefulIconButton;", "Lcom/obric/oui/button/OIconButton;", "", "value", "m", "Z", "isChecked", "()Z", "setChecked", "(Z)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OStatefulIconButton extends OIconButton {
    public static final int[] n = null;
    public boolean m;

    public static final class a {
    }

    public OStatefulIconButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public OStatefulIconButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public OStatefulIconButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    @Override // com.obric.oui.button.OIconButton, com.obric.oui.common.style.a
    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r1) {
    }

    @Override // com.obric.oui.button.OIconButton
    public /* bridge */ /* synthetic */ void setFakePressed(boolean r1) {
    }

    static {
        n = new int[]{2130974253};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int[] onCreateDrawableState(int r2) {
        int[] r3 = super/*android.widget.ImageView*/.onCreateDrawableState(r2 + 1);
        if (this.m == false) goto L5;
        ImageView.mergeDrawableStates(r3, n);
    L5:
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setChecked(boolean r2) {
        if (this.m == r2) goto L6;
        this.m = r2;
        refreshDrawableState();
        return;
    }

    public OStatefulIconButton(Context r7, AttributeSet r8, int r9, int r10) {
        if ((r10 & 2) == 0) goto L5;
        r8 = null;
    L5:
        AttributeSet r2 = r8;
        if ((r10 & 4) == 0) goto L8;
        int r3 = 0;
    L9:
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r2, r3, 0, 16);
        return;
    L8:
        r3 = r9;
        goto L9
    }
}
