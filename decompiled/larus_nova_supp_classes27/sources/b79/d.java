package b79;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public final Context a;
    public final Function0<Unit> b;
    public final LinearLayout c;
    public LinearLayout d;
    public final View e;
    public final View f;

    public static final class a {
    }

    static {
    }

    public final int b(int r3) {
        Resources r0 = this.a.getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void a(View r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        LinearLayout r0 = this.c;
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, -2);
        r1.topMargin = b(r6);
        Unit r7 = Unit.INSTANCE;
        r0.addView(r5, r1);
    }

    public d(Context r9, String r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "title");
        Intrinsics.checkNotNullParameter(r11, "onBack");
        this.a = r9;
        this.b = r11;
        OFloatingTitleBar r12 = new OFloatingTitleBar(r9, null, 6, 0);
        com.larus.dora.obric.utils.c.a(r12);
        r12.setBackgroundColor(v19.c.a(2130970531, r9, 2131102535));
        r12.setCenterTitle(r10);
        r12.setCenterTitleColor(v19.c.a(2130972079, r9, 2131103136));
        TextView r6 = (TextView) r12.findViewById(2131365427);
        if (r6 == null) goto L5;
        r6.setTextColor(v19.c.a(2130972079, r9, 2131103136));
        r6.setTextSize(2, 16.0f);
        Resources r13 = r9.getResources();
        TextViewCompat.setLineHeight(r6, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics())));
        r6.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 600, false));
    L5:
        r12.R(false);
        final View r14 = OFloatingTitleBar.k(r12, null, 6);
        r14.setOnClickListener(new b79.a(this));
        r12.post(new b(this, r14));
        LinearLayout r15 = new LinearLayout(r9);
        r15.setOrientation(1);
        r15.setClipChildren(false);
        r15.setClipToPadding(false);
        r15.setPadding(b(12), 0, b(12), b(24));
        this.c = r15;
        NestedScrollView r1 = new NestedScrollView(r9);
        r1.setClipChildren(false);
        r1.setClipToPadding(false);
        r1.setOverScrollMode(2);
        r1.setFillViewport(true);
        r1.setPadding(0, b(8), 0, 0);
        r1.addView(r15, new ViewGroup.LayoutParams(-1, -2));
        LinearLayout r16 = new LinearLayout(r9);
        r16.setOrientation(1);
        r16.setClipChildren(true);
        r16.setClipToPadding(true);
        r16.setBackgroundColor(v19.c.a(2130970531, r9, 2131102535));
        r16.addView(r12, new LinearLayout.LayoutParams(-1, -2));
        r16.addView(r1, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        View r17 = new View(r9);
        r17.setBackgroundColor(ContextCompat.getColor(r17.getContext(), 2131103066));
        r17.setClickable(true);
        r17.setFocusable(true);
        this.e = r17;
        FrameLayout r0 = new FrameLayout(r9);
        r0.setBackgroundColor(v19.c.a(2130970531, r9, 2131102535));
        r0.addView(r16, new FrameLayout.LayoutParams(-1, -1));
        r0.addView(r17, new FrameLayout.LayoutParams(-1, -1));
        this.f = r0;
    }
}
