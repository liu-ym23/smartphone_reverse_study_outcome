package uq8;

import android.text.Editable;
import android.text.TextWatcher;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import oq8.b;
import qq8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements TextWatcher {
    public final b a;
    public final Function0<Pair<Integer, Integer>> b;
    public final Function1<oq8.a, Unit> c;
    public oq8.a d;

    /* JADX INFO: renamed from: uq8.a$a, reason: collision with other inner class name */
    public static final class C0136a {
    }

    static {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r11) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("afterTextChanged textLen=");
        if (r11 == null) goto L5;
        int r3 = r11.length();
    L6:
        r1.append(r3);
        r1.append(" suppress=false");
        r0.d("InlineTriggerWatcher", r1.toString());
        if (r11 != null) goto L10;
        this.d = null;
        return;
    L10:
        Pair r4 = (Pair) this.b.invoke();
        int r5 = ((Number) r4.component1()).intValue();
        int r6 = ((Number) r4.component2()).intValue();
        r0.d("InlineTriggerWatcher", "selection start=" + r5 + " end=" + r6);
        if (r5 == r6) goto L14;
        this.d = null;
        return;
    L14:
        boolean r7 = false;
        int r8 = RangesKt.coerceIn(r6, 0, r11.length());
        r0.d("InlineTriggerWatcher", "findTriggerStart cursor=" + r8);
        if (r8 > 0) goto L17;
    L16:
        Integer r2 = null;
    L26:
        if (r2 == null) goto L55;
        int r9 = r2.intValue();
        FLogger.a.d("InlineTriggerWatcher", "isInsideToken triggerStart=" + r9 + " cursor=" + r8);
        Iterator r10 = ArrayIteratorKt.iterator((tq8.a[]) r11.getSpans(r9, r8, tq8.a.class));
    L29:
        if (r10.hasNext() == false) goto L36;
        tq8.a r12 = (tq8.a) r10.next();
        int r13 = r11.getSpanStart(r12);
        int r14 = r11.getSpanEnd(r12);
        if (r13 < 0) goto L29;
        if (r14 < 0) goto L29;
        if (r9 < r13) goto L29;
        if (r9 >= r14) goto L29;
        boolean r15 = true;
    L37:
        if (r15 == false) goto L40;
        this.d = null;
        return;
    L40:
        char r16 = r11.charAt(r9);
        String r17 = r11.subSequence(r9 + 1, r8).toString();
        int r18 = 0;
    L42:
        if (r18 >= r17.length()) goto L47;
        if (CharsKt.isWhitespace(r17.charAt(r18)) == true) goto L45;
        r18 = r18 + 1;
        goto L42
    L45:
        r7 = true;
    L47:
        if (r7 == false) goto L50;
        this.d = null;
        return;
    L50:
        oq8.a r19 = new oq8.a(r16, r17, r9, r8);
        if (Intrinsics.areEqual(r19, this.d) == false) goto L53;
        return;
    L53:
        this.d = r19;
        FLogger.a.i("InlineTriggerWatcher", "request trigger='" + r16 + "' keywordLen=" + r17.length() + " triggerStart=" + r9 + " cursor=" + r8);
        this.c.invoke(r19);
        return;
    L36:
        r15 = false;
        goto L37
    L55:
        this.d = null;
        return;
    L17:
        int r20 = r8 - 1;
    L18:
        if ((-1) >= r20) goto L16;
        char r21 = r11.charAt(r20);
        if (CharsKt.isWhitespace(r21) == true) goto L16;
        if (this.a.a.contains(Character.valueOf(r21)) == true) goto L24;
        r20 = r20 - 1;
        goto L18
    L24:
        r2 = Integer.valueOf(r20);
        goto L26
    L5:
        r3 = -1;
        goto L6
    }

    public a(b r2, qq8.b r3, c r4) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "selectionProvider");
        Intrinsics.checkNotNullParameter(r4, "onRequest");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
