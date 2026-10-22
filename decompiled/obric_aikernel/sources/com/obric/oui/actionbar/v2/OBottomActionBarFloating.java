package com.obric.oui.actionbar.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.e;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000fB\u001d\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;", "Landroid/widget/FrameLayout;", "Landroid/view/ViewGroup;", "getActionGroup", "", "Landroid/view/View;", "buttons", "", "setButtons", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OBottomActionBarFloating extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinearLayout f6163c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LinearLayout f6164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LinearLayout f6165h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ViewGroup f6166i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OBottomActionBarFloating(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OBottomActionBarFloating(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        View.inflate(r10, h.o_widget_bottom_action_bar_v2_floating, this);
        this.f6163c = (LinearLayout) findViewById(f.action_bar_left_container);
        this.f6164g = (LinearLayout) findViewById(f.action_bar_center_container);
        this.f6165h = (LinearLayout) findViewById(f.action_bar_right_container);
        setClipChildren(false);
        setClipToPadding(false);
        setBackgroundResource(e.oui_bottom_action_bar_bg_overlay);
    }

    public /* synthetic */ OBottomActionBarFloating(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    private final void a() {
        LinearLayout r10 = this.f6163c;
        if (r10 == null) goto L5;
        r10.removeAllViews();
    L5:
        LinearLayout r11 = this.f6164g;
        if (r11 == null) goto L8;
        r11.removeAllViews();
    L8:
        LinearLayout r12 = this.f6165h;
        if (r12 == null) goto L11;
        r12.removeAllViews();
    L11:
        LinearLayout r13 = this.f6163c;
        if (r13 == null) goto L14;
        r13.setVisibility(8);
    L14:
        LinearLayout r14 = this.f6164g;
        if (r14 == null) goto L17;
        r14.setVisibility(8);
    L17:
        LinearLayout r15 = this.f6165h;
        if (r15 == null) goto L20;
        r15.setVisibility(8);
    L20:
        this.f6166i = null;
    }

    public final ViewGroup getActionGroup() {
        return this.f6166i;
    }

    public final void setButtons(List<? extends View> r10) {
        Intrinsics.checkNotNullParameter(r10, "buttons");
        a();
        if (r10.isEmpty() == false) goto L6;
        return;
    L6:
        if (r10.size() != 1) goto L14;
        LinearLayout r11 = this.f6164g;
        if (r11 == null) goto L10;
        r11.addView(r10.get(0));
    L10:
        LinearLayout r12 = this.f6164g;
        if (r12 == null) goto L27;
    L12:
        r12.setVisibility(0);
        return;
    L27:
        return;
    L14:
        if (r10.size() < 2) goto L29;
        LinearLayout r13 = this.f6163c;
        if (r13 == null) goto L18;
        r13.addView(r10.get(0));
    L18:
        LinearLayout r14 = this.f6163c;
        if (r14 == null) goto L21;
        r14.setVisibility(0);
    L21:
        LinearLayout r15 = this.f6165h;
        if (r15 == null) goto L24;
        r15.addView(r10.get(1));
    L24:
        r12 = this.f6165h;
        if (r12 != null) goto L12;
        return;
    }
}
