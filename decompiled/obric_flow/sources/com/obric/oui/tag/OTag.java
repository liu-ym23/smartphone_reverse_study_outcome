package com.obric.oui.tag;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.lynx.tasm.utils.a;
import com.obric.common.oui.R$styleable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "use OTextTag")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\n\u0010\u000b\u0012\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/tag/OTag;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tagSize", "I", "getTagSize$annotations", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTag extends AppCompatTextView {
    @JvmOverloads
    public OTag(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    private static /* synthetic */ void getTagSize$annotations() {
    }

    @JvmOverloads
    public OTag(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OTag(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OTag(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        TypedArray r12 = r5.getTheme().obtainStyledAttributes(r10, R$styleable.OTag, 0, 0);
        int r13 = r12.getInteger(R$styleable.OTag_oui_size, 0);     // Catch: Throwable -> L17
        r12.getBoolean(R$styleable.OTag_oui_bordered, false);     // Catch: Throwable -> L17
        r12.getColor(R$styleable.OTag_oui_borderColor, 0);     // Catch: Throwable -> L17
        int r14 = r12.getColor(R$styleable.OTag_oui_bgGradientStartColor, 0);     // Catch: Throwable -> L17
        int r15 = r12.getColor(R$styleable.OTag_oui_bgGradientEndColor, 0);     // Catch: Throwable -> L17
        r12.recycle();
        if (r13 == 0) goto L9;
        if (r13 == 2) goto L8;
        int r16 = a.B(1, this);
        int r17 = a.B(3, this);
    L10:
        setPadding(r17, r16, r17, r16);
        if (r14 == 0) goto L14;
        if (r15 == 0) goto L14;
        GradientDrawable r18 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{r14, r15});
    L15:
        r18.setCornerRadius(a.B(2, this));
        setBackground(r18);
        return;
    L14:
        r18 = new GradientDrawable();
        goto L15
    L8:
        r16 = a.B(2, this);
        r17 = a.B(4, this);
        goto L10
    L9:
        r17 = a.B(3, this);
        r16 = a.B(1, this);
    L17:
        th = move-exception;
        r12.recycle();
        throw th;
    }
}
