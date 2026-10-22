package com.obric.oui.button;

import android.content.Context;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/button/OFloatingActionButton;", "Lcom/obric/oui/button/OIconButtonFloating;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OFloatingActionButton extends OIconButtonFloating {
    @JvmOverloads
    public OFloatingActionButton(Context r10) {
        this(r10, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public OFloatingActionButton(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 0, 12, null);
    }

    @JvmOverloads
    public OFloatingActionButton(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 0, 8, null);
    }

    @JvmOverloads
    public OFloatingActionButton(Context r10, AttributeSet r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, r13);
    }

    public /* synthetic */ OFloatingActionButton(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
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
}
