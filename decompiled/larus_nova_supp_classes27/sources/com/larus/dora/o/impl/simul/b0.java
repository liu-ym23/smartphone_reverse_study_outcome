package com.larus.dora.o.impl.simul;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sheet.v2.OSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b0 {
    public final Context a;
    public final List<w88.j> b;
    public final OSimulDeviceForm c;
    public final Function2<w88.j, w88.j, Unit> d;
    public w88.j e;
    public w88.j f;
    public boolean g;
    public final OSheet h;
    public OButton i;
    public OButton j;
    public LinearLayout k;
    public final int l;
    public final int m;

    public static final class a extends ImageSpan {
        public a(Drawable r2) {
            Intrinsics.checkNotNullParameter(r2, "drawable");
            super(r2);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
            Intrinsics.checkNotNullParameter(r1, "paint");
            if (r5 == null) goto L6;
            r1.getFontMetricsInt(r5);
        L6:
            return getDrawable().getBounds().right;
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
            Intrinsics.checkNotNullParameter(r1, "canvas");
            Intrinsics.checkNotNullParameter(r9, "paint");
            Drawable r10 = getDrawable();
            r1.save();
            r1.translate(r5, r6 + (((r8 - r6) - r10.getBounds().height()) / 2.0f));
            r10.draw(r1);
            r1.restore();
        }
    }

    public static final class b {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List<w88.j>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
    public final void d() {
        LinearLayout r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listContainer");
        r0 = null;
    L5:
        r0.removeAllViews();
        if (this.g == false) goto L8;
        w88.j r1 = this.f;
    L10:
        if (r1 != null) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L22;
        List<w88.j> r3 = this.b;
        ?? r5 = new ArrayList();
        Iterator r4 = r3.iterator();
    L18:
        if (r4.hasNext() == false) goto L24;
        Object r6 = r4.next();
        if (((w88.j) r6).d == false) goto L18;
        r5.add(r6);
    L24:
        if (this.g == false) goto L26;
        w88.j r7 = this.e;
    L27:
        int r8 = CollectionsKt.getLastIndex(r5);
        Iterator r9 = ((Iterable) r5).iterator();
        int r10 = 0;
    L29:
        if (r9.hasNext() == false) goto L58;
        Object r11 = r9.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        final w88.j r13 = (w88.j) r11;
        LayoutInflater r14 = LayoutInflater.from(this.a);
        LinearLayout r15 = this.k;
        if (r15 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("listContainer");
        r15 = null;
    L36:
        View r16 = r14.inflate(2131560153, r15, false);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
        View r17 = (OCardListItem) r16;
        String r18 = r13.a;
        if (r18 != null) goto L39;
        r18 = "";
    L39:
        r17.setTitle(r18);
        r17.s(true);
        int r110 = 2;
        r17.getTitleView().setTextSize(2, 16.0f);
        if (r8 != 0) goto L42;
        r110 = 0;
    L46:
        OCardListItem.h(r17, r110);
        String r111 = r13.b;
        if (r7 == null) goto L49;
        String r112 = r7.b;
    L50:
        r17.m(Intrinsics.areEqual(r111, r112));
        if (r10 == r8) goto L53;
        boolean r20 = true;
    L54:
        r17.o(r20);
        r17.setOnContentClickListener(new a0(this, r13));
        LinearLayout r21 = this.k;
        if (r21 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("listContainer");
        r21 = null;
    L57:
        r21.addView(r17);
        r10 = r12;
        goto L29
    L53:
        r20 = false;
        goto L54
    L49:
        r112 = null;
        goto L50
    L42:
        if (r10 != 0) goto L44;
        r110 = 1;
        goto L46
    L44:
        if (r10 != r8) goto L46;
        r110 = 3;
        goto L46
    L58:
        return;
    L26:
        r7 = this.f;
        goto L27
    L22:
        r5 = this.b;
        goto L24
    L12:
        if (r1.d == true) goto L14;
        r2 = true;
        goto L15
    L8:
        r1 = this.e;
        goto L10
    }

    public final void e() {
        OButton r0 = this.i;
        OButton r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topSide");
        r0 = null;
    L5:
        b(r0, this.e, this.c.getTopIconRes(), this.g);
        OButton r2 = this.j;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSide");
    L9:
        b(r1, this.f, this.c.getBottomIconRes(), !this.g);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public static void a(OSheet r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final int c(int r3) {
        Resources r0 = this.a.getResources();
        return (int) ((WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * r3) + 0.5f);
    }

    public final void b(OButton r7, w88.j r8, int r9, boolean r10) {
        if (r10 == false) goto L4;
        int r11 = this.m;
    L5:
        r7.setTextColor(r11);
        if (r8 == null) goto L8;
        CharSequence r12 = r8.a;
    L9:
        if (r12 != null) goto L11;
        r12 = "";
    L11:
        Context r0 = this.a;
        if (r9 != 2131233960) goto L15;
        r9 = 2131233961;
    L17:
        Drawable r13 = ContextCompat.getDrawable(r0, r9);
        CharSequence r14 = r12;
        if (r13 == null) goto L23;
        Drawable r1 = r13.mutate();
        r14 = r12;
        if (r1 == null) goto L23;
        r1.setTint(r11);
        InsetDrawable r15 = new InsetDrawable(r1, 0, 0, c(4), 0);
        r15.setBounds(0, 0, c(24), c(20));
        SpannableStringBuilder r16 = new SpannableStringBuilder("\u200b").append(r12);
        r16.setSpan(new a(r15), 0, 1, 33);
        Intrinsics.checkNotNull(r16);
        r14 = r16;
    L23:
        r7.setText(r14);
        return;
    L15:
        if (r9 != 2131233952) goto L17;
        r9 = 2131233953;
        goto L17
    L8:
        r12 = null;
        goto L9
    L4:
        r11 = this.l;
        goto L5
    }

    public b0(Context r2, List r3, w88.j r4, w88.j r5, boolean r6, OSimulDeviceForm r7, f r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "languages");
        Intrinsics.checkNotNullParameter(r7, "deviceForm");
        Intrinsics.checkNotNullParameter(r8, "onConfirm");
        this.a = r2;
        this.b = r3;
        this.c = r7;
        this.d = r8;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = new OSheet(r2, 0, false, 30);
        this.l = ContextCompat.getColor(r2, 2131101368);
        this.m = ContextCompat.getColor(r2, 2131101363);
    }
}
