package r29;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import zp9.u;
import zp9.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j extends HorizontalScrollView implements u {
    public final LinearLayout a;
    public final List<w> b;
    public Function2<? super Integer, ? super String, Unit> c;
    public Function0<Boolean> d;
    public int e;

    public int getCurrent() {
        return this.e;
    }

    public j(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        LinearLayout r0 = new LinearLayout(r4);
        r0.setOrientation(0);
        r0.setGravity(16);
        this.a = r0;
        this.b = new ArrayList();
        this.e = -1;
        setHorizontalScrollBarEnabled(false);
        addView(r0, new FrameLayout.LayoutParams(-2, -1));
    }

    public final void a(Function2<? super Integer, ? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "click");
        this.c = r2;
    }

    public final void c(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "scroll");
        this.d = r2;
    }

    public final void d(List<w> r12) {
        Intrinsics.checkNotNullParameter(r12, "list");
        w r0 = (w) CollectionsKt.getOrNull(this.b, this.e);
        Integer r1 = null;
        if (r0 == null) goto L5;
        Long r2 = Long.valueOf(r0.a);
    L6:
        ((ArrayList) this.b).clear();
        List<w> r3 = this.b;
        ArrayList r4 = new ArrayList();
        Iterator<T> r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L12;
        Object r5 = r13.next();
        if (((w) r5).a() == true) goto L8;
        r4.add(r5);
        goto L8
    L12:
        ((ArrayList) r3).addAll(r4);
        this.a.removeAllViews();
        Iterator<T> r14 = this.b.iterator();
        final int r6 = 0;
    L13:
        int r7 = -1;
        if (r14.hasNext() == false) goto L29;
        Object r8 = r14.next();
        int r9 = r6 + 1;
        if (r6 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        final w r10 = (w) r8;
        LinearLayout r11 = this.a;
        TextView r15 = new TextView(getContext());
        String r16 = r10.b;
        if (r16 != null) goto L21;
        r16 = "";
    L21:
        r15.setText(r16);
        r15.setTextSize(16.0f);
        r15.setGravity(17);
        r15.setSingleLine(true);
        r15.setPadding(e(12), 0, e(12), 0);
        r15.setOnClickListener(new i(this, r6, r10));
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(-2, -1);
        if (r6 != 0) goto L25;
        r17.setMarginStart(e(4));
    L25:
        if (r6 != CollectionsKt.getLastIndex(this.b)) goto L27;
        r17.setMarginEnd(e(4));
    L27:
        Unit r18 = Unit.INSTANCE;
        r11.addView(r15, r17);
        r6 = r9;
        goto L13
    L29:
        if (((ArrayList) this.b).isEmpty() == false) goto L31;
        int r110 = 8;
    L32:
        setVisibility(r110);
        Iterator r111 = ((ArrayList) this.b).iterator();
        int r20 = 0;
    L34:
        if (r111.hasNext() == false) goto L45;
        long r21 = ((w) r111.next()).a;
        if (r2 != null) goto L39;
    L41:
        boolean r22 = false;
    L42:
        if (r22 == true) goto L43;
        r20 = r20 + 1;
        goto L34
    L43:
        r7 = r20;
        goto L45
    L39:
        if (r21 != r2.longValue()) goto L41;
        r22 = true;
    L45:
        Integer r112 = Integer.valueOf(r7);
        if (r112.intValue() < 0) goto L48;
        boolean r23 = true;
    L49:
        if (r23 == true) goto L52;
        r112 = null;
    L52:
        if (r112 == null) goto L54;
        int r113 = r112.intValue();
    L66:
        if ((!this.b.isEmpty()) == false) goto L79;
        b(r113, false);
        return;
    L79:
        return;
    L54:
        Integer r114 = Integer.valueOf(this.e);
        int r24 = r114.intValue();
        if (r24 >= 0) goto L57;
    L59:
        boolean r25 = false;
    L60:
        if (r25 == false) goto L62;
        r1 = r114;
    L62:
        if (r1 == null) goto L64;
        r113 = r1.intValue();
        goto L66
    L64:
        r113 = 0;
        goto L66
    L57:
        if (r24 >= this.b.size()) goto L59;
        r25 = true;
        goto L60
    L48:
        r23 = false;
        goto L49
    L31:
        r110 = 0;
        goto L32
    L5:
        r2 = null;
        goto L6
    }

    public final int e(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r3) {
        Function0<Boolean> r0 = this.d;
        if (r0 == null) goto L5;
        boolean r1 = ((Boolean) r0.invoke()).booleanValue();
    L6:
        if (r1 == true) goto L8;
    L10:
        return false;
    L8:
        if (super.onTouchEvent(r3) == false) goto L10;
        return true;
    L5:
        r1 = true;
        goto L6
    }

    public void setCurrent(int r2) {
        b(r2, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final void b(final int r11, final boolean r12) {
        if (r11 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        return;
    L10:
        this.e = r11;
        int r3 = this.a.getChildCount();
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L51;
        View r5 = this.a.getChildAt(r4);
        Object r6 = null;
        if ((r5 instanceof TextView) == false) goto L15;
        TextView r7 = (TextView) r5;
    L16:
        if (r7 == 0) goto L50;
        if (r4 != r11) goto L20;
        ?? r8 = 1;
    L21:
        r7.setSelected(r8);
        r7.setTypeface(Typeface.DEFAULT, r8);
        w r9 = (w) ListProtector.get(this.b, r4);
        if (r8 != 0) goto L24;
    L45:
        if (r8 == 0) goto L47;
        int r10 = 2131103136;
    L48:
        int r13 = ContextCompat.getColor(getContext(), r10);
    L49:
        r7.setTextColor(r13);
        goto L50
    L47:
        r10 = 2131103146;
        goto L48
    L24:
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L26;
        boolean r14 = true;
    L27:
        if (r14 == false) goto L29;
        String r15 = r9.f;
    L55:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L36
        if (r15 == null) goto L33;
        Integer r17 = Integer.valueOf(Color.parseColor(r15));     // Catch: Throwable -> L36
    L34:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L36
    L39:
        if (Result.isFailure-impl(r18) == true) goto L42;
        r6 = r18;
    L42:
        Integer r20 = (Integer) r6;
        if (r20 == null) goto L45;
        r13 = r20.intValue();
        goto L49
    L33:
        r17 = null;
    L36:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L29:
        r15 = r9.e;
        goto L55
    L26:
        r14 = false;
        goto L27
    L20:
        r8 = 0;
    L50:
        r4 = r4 + 1;
        goto L11
    L15:
        r7 = 0;
        goto L16
    L51:
        View r0 = this.a.getChildAt(r11);
        if (r0 == null) goto L60;
        r0.post(new h(this, r11, r12));
        return;
    L60:
        return;
    L5:
        if (r11 >= this.b.size()) goto L7;
        r2 = true;
        goto L8
    }
}
