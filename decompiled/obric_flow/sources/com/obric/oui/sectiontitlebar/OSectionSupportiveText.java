package com.obric.oui.sectiontitlebar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/sectiontitlebar/OSectionSupportiveText;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "sectionText", "", "setSectionDes", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "a", "Lkotlin/Lazy;", "getSectionDes", "()Landroid/widget/TextView;", "sectionDes", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"AppCompatCustomView"})
public final class OSectionSupportiveText extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f14290a;

    @JvmOverloads
    public OSectionSupportiveText(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    private final TextView getSectionDes() {
        return (TextView) this.f14290a.getValue();
    }

    public final void setSectionDes(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sectionText");
        getSectionDes().setText(r5);
    }

    @JvmOverloads
    public OSectionSupportiveText(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OSectionSupportiveText(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OSectionSupportiveText(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f14290a = LazyKt.lazy(new OSectionSupportiveText$sectionDes$2(this));
        LayoutInflater.from(r5).inflate(R$layout.o_view_section_supportive_text, this, true);
        TypedArray r12 = r5.obtainStyledAttributes(r10, R$styleable.OSectionSupportiveText, r11, 0);
        String r13 = r12.getString(R$styleable.OSectionSupportiveText_section_des_text);
        getSectionDes().setText(r13);
        r12.recycle();
    }
}
