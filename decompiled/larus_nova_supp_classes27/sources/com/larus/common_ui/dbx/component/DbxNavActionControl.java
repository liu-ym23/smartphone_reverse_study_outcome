package com.larus.common_ui.dbx.component;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DbxNavActionControl extends FrameLayout {
    public final Appearance a;
    public final Function0<Integer> b;
    public final DbxButton c;
    public Function0<Unit> d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxNavActionControl$Appearance;", "", "<init>", "(Ljava/lang/String;I)V", "STANDARD", "MINI_PROGRAM", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Appearance extends Enum<Appearance> {
        public static final Appearance MINI_PROGRAM = null;
        public static final Appearance STANDARD = null;
        public static final /* synthetic */ Appearance[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Appearance> getEntries() {
            return b;
        }

        static {
            Appearance r0 = new Appearance("STANDARD", 0);
            STANDARD = r0;
            Appearance r1 = new Appearance("MINI_PROGRAM", 1);
            MINI_PROGRAM = r1;
            Appearance[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Appearance[] values() {
            return (Appearance[]) a.clone();
        }

        public static Appearance valueOf(String r1) {
            return (Appearance) r27.a.a(Appearance.class, r1);
        }

        public Appearance(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public final void a() {
        float r2 = 1.0f;
        if (this.a == Appearance.MINI_PROGRAM) goto L5;
        setAlpha(1.0f);
        return;
    L5:
        if (isEnabled() == true) goto L8;
        r2 = 0.3f;
    L10:
        setAlpha(r2);
        return;
    L8:
        if (isPressed() == false) goto L10;
        r2 = 0.5f;
        goto L10
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // android.view.View
    public final boolean performClick() {
        Function0<Unit> r0 = this.d;
        boolean r1 = super.performClick();
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        if (r1 == true) goto L9;
        if (r0 != null) goto L9;
        return false;
    L9:
        return true;
    }

    @Override // android.view.View
    public final void setEnabled(boolean r2) {
        super.setEnabled(r2);
        DbxButton r0 = this.c;
        if (r0 == null) goto L5;
        r0.setEnabled(r2);
    L5:
        a();
    }

    @Override // android.view.View
    public final void setPressed(boolean r2) {
        super.setPressed(r2);
        DbxButton r0 = this.c;
        if (r0 == null) goto L5;
        r0.setPressed(r2);
    L5:
        a();
    }

    public DbxNavActionControl(Context r7, Appearance r8, int r9, c r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "appearance");
        Intrinsics.checkNotNullParameter(r10, "defaultContentColor");
        super(r7);
        this.a = r8;
        this.b = r10;
        AttributeSet r0 = null;
        if (r8 != Appearance.STANDARD) goto L5;
        DbxButton r11 = new DbxButton(r7, r0, 6, 0);
        r11.b(DbxButton.Style.PLAIN, DbxButton.Size.L);
        r11.setClickable(false);
        r11.setFocusable(false);
        r11.setImportantForAccessibility(2);
    L6:
        this.c = r11;
        Appearance r1 = Appearance.MINI_PROGRAM;
        if (r8 != r1) goto L9;
        ImageView r2 = new ImageView(r7);
        r2.setScaleType(ImageView.ScaleType.FIT_CENTER);
    L10:
        setVisibility(8);
        setClickable(true);
        setFocusable(true);
        float r3 = 44;
        Resources r4 = getResources();
        setMinimumHeight((int) ((WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density * r3) + 0.5f));
        if (r8 != r1) goto L14;
        Resources r12 = getResources();
        setMinimumWidth((int) ((r3 * WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics()).density) + 0.5f));
    L14:
        if (r11 == null) goto L16;
        addView(r11, new FrameLayout.LayoutParams(-2, -2, 17));
    L16:
        if (r2 == null) goto L18;
        addView(r2, new FrameLayout.LayoutParams(r9, r9, 17));
    L18:
        this.d = null;
        setVisibility(8);
        setContentDescription(null);
        if (r11 == null) goto L21;
        r11.setTitle(null);
        r11.setLeadingIconDrawable(null);
        r11.setAccessibleLabel(null);
        r11.setContentColor(null);
    L21:
        if (r2 == null) goto L23;
        r2.setImageDrawable(null);
        r2.clearColorFilter();
    L23:
        requestLayout();
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }
}
