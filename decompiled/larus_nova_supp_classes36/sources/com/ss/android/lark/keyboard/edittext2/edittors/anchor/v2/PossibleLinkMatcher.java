package com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2;

import android.text.Editable;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class PossibleLinkMatcher implements c {
    public static final /* synthetic */ int f = 0;
    public final StateFlowImpl a;
    public final CoroutineScope b;
    public FunctionEditText c;
    public long d;
    public final Map<Long, Pair<Integer, Integer>> e;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2.c
    public final void unbind() {
        CoroutineScopeKt.cancel$default(this.b, null, 1, null);
        this.a.setValue(null);
        this.d = 0;
        ((LinkedHashMap) this.e).clear();
        this.c = null;
    }

    public PossibleLinkMatcher() {
        this.a = j1.a(null);
        this.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.e = new LinkedHashMap();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2.c
    public final void afterTextChanged(Editable r11) {
        if (r11 == null) goto L34;
        int r0 = r11.length();
        Object[] r1 = r11.getSpans(0, r0, f.class);
        ArrayList r3 = new ArrayList(r1.length);
        int r4 = r1.length;
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L7;
        Object r6 = (f) r1[r5];
        r3.add(new Triple(r6, Integer.valueOf(r11.getSpanStart(r6)), Integer.valueOf(r11.getSpanEnd(r6))));
        r5 = r5 + 1;
        goto L4
    L7:
        if (r3.isEmpty() == true) goto L15;
        boolean r7 = true;
        if (r3.size() <= 1) goto L16;
        Iterator r2 = r3.iterator();
    L13:
        if (r2.hasNext() == false) goto L15;
        r11.removeSpan(((Triple) r2.next()).getFirst());
        goto L13
    L16:
        f r8 = (f) ((Triple) CollectionsKt.first(r3)).getFirst();
        int r9 = ((Number) ((Triple) CollectionsKt.first(r3)).getSecond()).intValue();
        int r10 = ((Number) ((Triple) CollectionsKt.first(r3)).getThird()).intValue();
        if (r9 > 0) goto L22;
        if (r10 < r0) goto L22;
        if (Intrinsics.areEqual(r8.getContent(), r11.subSequence(r9, r10).toString()) == false) goto L22;
    L23:
        if (r7 == true) goto L25;
        r11.removeSpan(r8);
    L25:
        if (r7 == true) goto L35;
        long r12 = this.d;
        this.d = 1 + r12;
        Pair<Integer, Integer> r13 = this.e.remove(Long.valueOf(r12));
        if (r13 != null) goto L30;
        r13 = TuplesKt.to(0, Integer.valueOf(r11.length()));
    L30:
        int r14 = ((Number) r13.component1()).intValue();
        int r15 = ((Number) r13.component2()).intValue();
        h.a.getClass();
        r11.setSpan(new g(), r14, r15, 33);
        this.a.setValue(new b(r12, r11));
        return;
    L35:
        return;
    L22:
        r7 = false;
    L15:
        r7 = false;
        goto L25
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2.c
    public final void b(FunctionEditText r8) {
        Intrinsics.checkNotNullParameter(r8, "editText");
        this.c = r8;
        BuildersKt.launch$default(this.b, null, null, new PossibleLinkMatcher$bindEditText$1(this, null), 3, null);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2.c
    public final void a(int r4, int r5) {
        if (r5 != 0) goto L4;
        int r0 = Math.max(r4 - 1, 0);
    L5:
        this.e.put(Long.valueOf(this.d), TuplesKt.to(Integer.valueOf(r0), Integer.valueOf(r4 + r5)));
        return;
    L4:
        r0 = r4;
        goto L5
    }

    public final void c(int r7, int r8, Editable r9) {
        if (r7 >= 0) goto L4;
        return;
    L4:
        if (r8 > r9.length()) goto L19;
        if (r7 <= r8) goto L7;
        return;
    L7:
        if ((r8 - r7) >= 5) goto L10;
        return;
    L10:
        if (this.c != null) goto L13;
        Log.w("PossibleLinkMatcher", "matchChangedText return, edit text is null");
        return;
    L13:
        CharSequence r10 = r9.subSequence(r7, r8);
        ArrayList r0 = new ArrayList();
        com.ss.android.lark.keyboard.edittext2.utils.b.b(r10, r0);
        Iterator r11 = r0.iterator();
    L15:
        if (r11.hasNext() == false) goto L22;
        com.ss.android.lark.keyboard.edittext2.utils.b.a r1 = (com.ss.android.lark.keyboard.edittext2.utils.b.a) r11.next();
        int r2 = r1.b + r7;
        int r3 = r1.a.length() + r2;
        r9.setSpan(new i(null, true, r1.a), r2, r3, 33);
        goto L15
    L22:
        return;
    }
}
