package com.obric.oui.sectiontitlebar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\u00020\u00068B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/sectiontitlebar/OSectionSupportiveText;", "Landroid/widget/FrameLayout;", "", "sectionText", "", "setSectionDes", "Landroid/widget/TextView;", "c", "Lkotlin/Lazy;", "getSectionDes", "()Landroid/widget/TextView;", "sectionDes", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
@SuppressLint({"AppCompatCustomView"})
public final class OSectionSupportiveText extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f7237c;

    @JvmOverloads
    public OSectionSupportiveText(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OSectionSupportiveText(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OSectionSupportiveText(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f7237c = LazyKt.lazy(new OSectionSupportiveText$sectionDes$2(this));
        LayoutInflater.from(r10).inflate(h.o_view_section_supportive_text, this, true);
        int[] r13 = l.OSectionSupportiveText;
        Intrinsics.checkNotNullExpressionValue(r13, "R.styleable.OSectionSupportiveText");
        TypedArray r14 = r10.obtainStyledAttributes(r11, r13, r12, 0);
        String r15 = r14.getString(l.OSectionSupportiveText_section_des_text);
        getSectionDes().setText(r15);
        r14.recycle();
    }

    public /* synthetic */ OSectionSupportiveText(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final TextView getSectionDes() {
        return (TextView) this.f7237c.getValue();
    }

    public final void setSectionDes(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sectionText");
        getSectionDes().setText(r10);
    }
}
