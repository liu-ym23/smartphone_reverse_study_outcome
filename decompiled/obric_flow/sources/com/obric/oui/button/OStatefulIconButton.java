package com.obric.oui.button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.common.oui.R$attr;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001R*\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/button/OStatefulIconButton;", "Lcom/obric/oui/button/OIconButton;", "", "value", "m", "Z", "isChecked", "()Z", "setChecked", "(Z)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OStatefulIconButton extends OIconButton {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f12165n = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12166m;

    static {
        f12165n = new int[]{R$attr.state_checked};
    }

    @JvmOverloads
    public OStatefulIconButton(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null, 0, 14);
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int r5) {
        int[] r10 = super.onCreateDrawableState(r5 + 1);
        if (this.f12166m == false) goto L5;
        View.mergeDrawableStates(r10, f12165n);
    L5:
        return r10;
    }

    public final void setChecked(boolean r5) {
        if (this.f12166m == r5) goto L6;
        this.f12166m = r5;
        refreshDrawableState();
        return;
    }

    @Override // com.obric.oui.button.OIconButton
    public /* bridge */ /* synthetic */ void setFakePressed(boolean r5) {
    }

    @JvmOverloads
    public OStatefulIconButton(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 0, 12);
    }

    @JvmOverloads
    public OStatefulIconButton(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, r11, 8);
    }

    public OStatefulIconButton(Context r10, AttributeSet r11, int r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        r11 = null;
    L5:
        AttributeSet r5 = r11;
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r5, r12, 0, 16);
    }
}
