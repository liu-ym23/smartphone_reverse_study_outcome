package com.obric.oui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/titlebar/OCentralizedTextTitleBar;", "Lcom/obric/oui/titlebar/OTitleBar;", "", TypedValues.Custom.S_COLOR, "", "setDividerLineBackground", "Landroid/widget/FrameLayout;", "getLeadingElement", "()Landroid/widget/FrameLayout;", "leadingElement", "getTrailingElement", "trailingElement", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OCentralizedTextTitleBar extends OTitleBar {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private FrameLayout f7664g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FrameLayout f7665h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f7666i;

    @JvmOverloads
    public OCentralizedTextTitleBar(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OCentralizedTextTitleBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OCentralizedTextTitleBar(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        FrameLayout.inflate(r10, h.o_centralized_title_bar, this);
        this.f7664g = (FrameLayout) findViewById(f.fl_leading_element);
        this.f7665h = (FrameLayout) findViewById(f.fl_trailing_element);
        this.f7718c = (TextView) findViewById(f.tv_content_title);
        this.f7666i = findViewById(f.divider_view);
    }

    public /* synthetic */ OCentralizedTextTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public final FrameLayout getLeadingElement() {
        return this.f7664g;
    }

    public final FrameLayout getTrailingElement() {
        return this.f7665h;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r10) {
        View r11 = this.f7666i;
        if (r11 == null) goto L6;
        r11.setBackgroundColor(r10);
        return;
    }
}
