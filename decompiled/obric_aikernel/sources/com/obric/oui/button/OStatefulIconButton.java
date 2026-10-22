package com.obric.oui.button;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bytedance.crash.entity.EventBody;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B1\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R*\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/button/OStatefulIconButton;", "Lcom/obric/oui/button/OIconButton;", "", "extraSpace", "", "onCreateDrawableState", "", EventBody.KEY_VALUE, "isChecked", "Z", "()Z", "setChecked", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OStatefulIconButton extends OIconButton {
    public static final a Companion = null;
    private static final int[] STATE_CHECKED = null;
    private boolean isChecked;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new a(null);
        STATE_CHECKED = new int[]{b.state_checked};
    }

    @JvmOverloads
    public OStatefulIconButton(Context r10) {
        this(r10, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public OStatefulIconButton(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 0, 12, null);
    }

    @JvmOverloads
    public OStatefulIconButton(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 0, 8, null);
    }

    @JvmOverloads
    public OStatefulIconButton(Context r10, AttributeSet r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, r13, null, 16, null);
    }

    public /* synthetic */ OStatefulIconButton(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = 0;
    L11:
        this(r10, r11, r12, r13);
    }

    /* JADX INFO: renamed from: access$mergeDrawableStates$s-1588574979, reason: not valid java name */
    public static final /* synthetic */ int[] m25access$mergeDrawableStates$s1588574979(int[] r10, int[] r11) {
        return ImageView.mergeDrawableStates(r10, r11);
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int r10) {
        int[] r11 = super.onCreateDrawableState(r10 + 1);
        if (this.isChecked == false) goto L5;
        m25access$mergeDrawableStates$s1588574979(r11, STATE_CHECKED);
    L5:
        Intrinsics.checkNotNullExpressionValue(r11, "drawableState");
        return r11;
    }

    public final void setChecked(boolean r10) {
        if (this.isChecked == r10) goto L6;
        this.isChecked = r10;
        refreshDrawableState();
        return;
    }
}
