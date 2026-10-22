package com.ss.android.lark.keyboard.edittext2.list;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.coremd.span.list.ListHeadType;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class EditorListApplier implements TextWatcher, InputFilter {
    public static final /* synthetic */ int o = 0;
    public final EditText a;
    public final com.ss.android.lark.keyboard.edittext2.list.b b;
    public boolean c;
    public final d d;
    public final e e;
    public final List<Integer> f;
    public final List<y9b.a> g;
    public final LinkedHashSet<y9b.a> h;
    public final LinkedList<y9b.a> i;
    public final LinkedList<y9b.a> j;
    public final Map<y9b.a, ULong> k;
    public final InsertListStateMachine l;
    public final c m;
    public boolean n;

    public static final class a {
    }

    public final class b implements View.OnKeyListener {
        public boolean a;
        public final /* synthetic */ EditorListApplier b;

        public b(EditorListApplier r1) {
            this.b = r1;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r11, int r12, KeyEvent r13) {
            Intrinsics.checkNotNullParameter(r13, "event");
            Editable r14 = this.b.a.getEditableText();
            boolean r5 = false;
            int r6 = 0;
            if (r13.getAction() != 0) goto L49;
            if (r12 == 61) goto L12;
            if (r12 == 112) goto L10;
            if (r12 == 66) goto L9;
            if (r12 == 67) goto L10;
            this.a = false;
        L47:
            return this.a;
        L9:
            EditorListApplier r15 = this.b;
            Intrinsics.checkNotNull(r14);
            this.a = r15.c(r14, true);
        L10:
            EditorListApplier r16 = this.b;
            Intrinsics.checkNotNull(r14);
            this.a = r16.g(r14, true);
            goto L47
        L12:
            if ((r13.getMetaState() & 1) != 1) goto L14;
            boolean r17 = true;
        L15:
            if (r17 == false) goto L17;
            int r18 = -1;
        L18:
            EditorListApplier r19 = this.b;
            Intrinsics.checkNotNull(r14);
            r19.getClass();
            int r0 = Selection.getSelectionStart(r14);
            int r1 = Selection.getSelectionEnd(r14);
            y9b.a[] r2 = (y9b.a[]) r14.getSpans(Math.min(r0, r1), Math.max(r0, r1), y9b.a.class);
            if (r2.length != 0) goto L21;
            boolean r3 = true;
        L22:
            if (r3 == true) goto L45;
            LinkedHashSet<y9b.a> r4 = r19.h;
            r4.clear();
            int r7 = r2.length;
            boolean r8 = false;
        L25:
            if (r6 >= r7) goto L39;
            y9b.a r9 = r2[r6];
            int r10 = r14.getSpanEnd(r9);
            if (r0 != r10) goto L35;
            Character r20 = StringsKt.getOrNull(r14, r10 - 1);
            if (r20 == null) goto L35;
            if (r20.charValue() != '\n') goto L35;
        L38:
            r6 = r6 + 1;
        L35:
            if ((r9 instanceof y9b.b) == false) goto L37;
            r8 = true;
        L37:
            r9.f(r9.b() + r18);
            r9.g(ListHeadType.None);
            r4.add(r9);
            goto L38
        L39:
            if (r8 == false) goto L42;
            r19.d(r14, r4);
        L42:
            if ((!r4.isEmpty()) == false) goto L44;
            r19.m(r14, r4);
        L44:
            r4.clear();
            r5 = true;
        L45:
            this.a = r5;
            goto L47
        L21:
            r3 = false;
            goto L22
        L17:
            r18 = 1;
            goto L18
        L14:
            r17 = false;
            goto L15
        L49:
            if (r13.getAction() != 1) goto L60;
            if (r12 == 61) goto L56;
            if (r12 == 112) goto L56;
            if (r12 == 66) goto L56;
            if (r12 == 67) goto L56;
            return false;
        L56:
            return this.a;
        L60:
            return false;
        }
    }

    public static final class c implements SpanWatcher {
        public final Function2<Editable, Object, Unit> a;

        @Override // android.text.SpanWatcher
        public final void onSpanAdded(Spannable r1, Object r2, int r3, int r4) {
        }

        @Override // android.text.SpanWatcher
        public final void onSpanRemoved(Spannable r1, Object r2, int r3, int r4) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function2<? super Editable, Object, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "realWatcher");
            this.a = r2;
        }

        @Override // android.text.SpanWatcher
        public final void onSpanChanged(Spannable r1, Object r2, int r3, int r4, int r5, int r6) {
            if (r1 != null) goto L4;
        L7:
            boolean r7 = true;
        L8:
            if (r7 == false) goto L10;
            return;
        L10:
            if ((r1 instanceof Editable) == false) goto L15;
            this.a.invoke(r1, r2);
            return;
        L15:
            return;
        L4:
            if (r1.length() == 0) goto L7;
            r7 = false;
            goto L8
        }
    }

    public static final class d {
        public y9b.a a;
        public int b;
        public int c;
        public int d;
        public boolean e;
        public boolean f;
        public int g;
        public CharSequence h;

        public d() {
            this.a = null;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = false;
            this.f = false;
            this.g = 0;
            this.h = null;
        }
    }

    public static final class e {
        public int a;
        public int b;
        public int c;

        public e() {
            this.a = -1;
            this.b = -1;
            this.c = -1;
        }
    }

    public /* synthetic */ class f {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ListHeadType.values().length];
            r0[ListHeadType.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ListHeadType.VirtualHead.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class g<T> implements Comparator {
        public final /* synthetic */ Editable a;

        public g(Editable r1) {
            this.a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            Editable r0 = this.a;
            Integer r4 = Integer.valueOf(r0.getSpanStart((y9b.a) r2));
            Editable r1 = this.a;
            return ComparisonsKt.compareValues(r4, Integer.valueOf(r1.getSpanStart((y9b.a) r3)));
        }
    }

    public static final class h<T> implements Comparator {
        public final /* synthetic */ Editable a;

        public h(Editable r1) {
            this.a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            Editable r0 = this.a;
            Integer r4 = Integer.valueOf(r0.getSpanStart((y9b.a) r2));
            Editable r1 = this.a;
            return ComparisonsKt.compareValues(r4, Integer.valueOf(r1.getSpanStart((y9b.a) r3)));
        }
    }

    static {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public final void b() {
        this.a.addTextChangedListener(this);
        a(this.a.getEditableText());
        InputFilter[] r0 = this.a.getFilters();
        InputFilter[] r1 = (InputFilter[]) Arrays.copyOf(r0, r0.length + 1);
        r1[r0.length] = this;
        this.a.setFilters(r1);
    }

    public final void a(Editable r5) {
        if (r5.getSpanStart(this.m) != (-1)) goto L6;
        r5.setSpan(this.m, 0, r5.length(), 18);
        this.l.c(r5, Selection.getSelectionStart(r5), Selection.getSelectionEnd(r5));
        return;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        long r0 = System.currentTimeMillis();
        if (this.c == true) goto L12;
        this.c = true;
        d r2 = this.d;
        CharSequence r4 = r2.h;
        if (r2.e == false) goto L10;
        if (r7 != r4) goto L10;
        f(r7, r2);
    L11:
        this.c = false;
    L10:
        e(r7, this.e);
    L12:
        d r8 = this.d;
        r8.a = null;
        r8.b = -1;
        r8.c = -1;
        r8.d = -1;
        r8.f = false;
        r8.e = false;
        r8.h = null;
        r8.g = 0;
        e r9 = this.e;
        r9.a = -1;
        r9.b = -1;
        r9.c = -1;
        Log.d("ListActionHandle", "afterTextChanged: cost time: " + (System.currentTimeMillis() - r0) + "ms");
    }

    public final void h(Editable r3) {
        Intrinsics.checkNotNullParameter(r3, "s");
        LinkedHashSet<y9b.a> r0 = this.h;
        r0.clear();
        d(r3, r0);
        if ((!r0.isEmpty()) == false) goto L5;
        m(r3, r0);
    L5:
        r0.clear();
    }

    public EditorListApplier(EditText r2, com.ss.android.lark.keyboard.edittext2.list.b r3) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        Intrinsics.checkNotNullParameter(r3, "coordinator");
        this.a = r2;
        this.b = r3;
        this.d = new d();
        this.e = new e();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new LinkedHashSet();
        this.i = new LinkedList();
        this.j = new LinkedList();
        this.k = new LinkedHashMap();
        this.l = new InsertListStateMachine(r3, this);
        this.m = new c(new EditorListApplier$innerSpanWatcher$1(this));
    }

    public static y9b.a k(Editable r8, int r9) {
        y9b.a[] r0 = (y9b.a[]) r8.getSpans(r9, r9, y9b.a.class);
        if (r0.length != 2) goto L15;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L28;
        y9b.a r6 = r0[r2];
        if (r8.getSpanStart(r6) != r9) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == true) goto L13;
        r2 = r2 + 1;
        goto L5
    L13:
        return r6;
    L9:
        r7 = false;
        goto L10
    L28:
        return null;
    L15:
        if (r0.length != 1) goto L25;
        y9b.a r3 = r0[0];
        Character r4 = StringsKt.getOrNull(r8, r9 - 1);
        if (r4 != null) goto L20;
    L24:
        return r3;
    L20:
        if (r4.charValue() != '\n') goto L24;
        if (r8.getSpanEnd(r3) != r9) goto L24;
        return null;
    L25:
        return null;
    }

    public static long l(int r4, int r5) {
        return ULong.constructor-impl(ULong.constructor-impl(ULong.constructor-impl(r4) << 32) + ULong.constructor-impl(((long) UInt.constructor-impl(r5)) & 4294967295L));
    }

    public static void p(y9b.a r7, Editable r8) {
        int r0 = r8.getSpanEnd(r7);
        if (r7.c != ListHeadType.ListHead) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == false) goto L25;
        Object[] r10 = r8.getSpans(r0, r0, y9b.b.class);
        int r1 = r10.length;
        int r4 = 0;
    L8:
        if (r4 >= r1) goto L16;
        Object r5 = r10[r4];
        if (r8.getSpanStart((y9b.b) r5) != r0) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L17;
        r4 = r4 + 1;
    L17:
        y9b.b r11 = (y9b.b) r5;
        if (r11 == null) goto L20;
        r11.g(ListHeadType.ListHead);
    L20:
        if (r11 == null) goto L26;
        r11.h(1);
        return;
    L26:
        return;
    L12:
        r6 = false;
        goto L13
    L16:
        r5 = null;
        goto L17
    L25:
        return;
    L5:
        r9 = false;
        goto L6
    }

    public final boolean c(Editable r7, boolean r8) {
        int r0 = Selection.getSelectionStart(r7);
        boolean r2 = false;
        if (r0 == Selection.getSelectionEnd(r7)) goto L5;
        return false;
    L5:
        y9b.a r1 = k(r7, r0);
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r1.b() == 0) goto L11;
    L13:
        int r9 = r7.getSpanStart(r1);
        String r3 = r7.subSequence(r9, r7.getSpanEnd(r1)).toString();
        if (Intrinsics.areEqual(r3, "\u200b\n") == false) goto L16;
    L19:
        boolean r4 = true;
    L20:
        LinkedHashSet<y9b.a> r5 = this.h;
        r5.clear();
        if (r4 == false) goto L35;
        if (r9 <= r0) goto L24;
    L26:
        boolean r10 = false;
    L27:
        if (r10 == false) goto L35;
        r1.f(r1.b() - 1);
        r1.g(ListHeadType.None);
        r5.add(r1);
        if ((r1 instanceof y9b.b) == false) goto L32;
        d(r7, r5);
    L32:
        if ((!r5.isEmpty()) == false) goto L34;
        m(r7, r5);
    L34:
        r2 = true;
        goto L35
    L24:
        if (r0 > (r9 + 1)) goto L26;
        r10 = true;
    L35:
        r5.clear();
        return r2;
    L16:
        if (Intrinsics.areEqual(r3, "\u200b") == true) goto L19;
        r4 = false;
        goto L20
    L11:
        if (o(r7, r0, r1, r8) == false) goto L13;
        return true;
    }

    public final void d(Editable r14, Set<y9b.a> r15) {
        long r0 = System.currentTimeMillis();
        ArrayList r2 = (ArrayList) this.g;
        r2.clear();
        LinkedList<y9b.a> r3 = this.i;
        r3.clear();
        LinkedList<y9b.a> r4 = this.j;
        r4.clear();
        LinkedHashMap r5 = (LinkedHashMap) this.k;
        r5.clear();
        int r8 = 0;
        Object[] r6 = r14.getSpans(0, r14.length(), y9b.b.class);
        int r7 = r6.length;
        int r9 = 0;
    L3:
        if (r9 >= r7) goto L6;
        y9b.b r10 = (y9b.b) r6[r9];
        r2.add(r10);
        r5.put(r10, ULong.box-impl(l(r14.getSpanStart(r10), r14.getSpanEnd(r10))));
        r9 = r9 + 1;
        goto L3
    L6:
        if (r2.size() <= 1) goto L8;
        CollectionsKt.sortWith(r2, new g(r14));
    L8:
        int r16 = r2.size();
    L9:
        if (r8 >= r16) goto L19;
        y9b.a r11 = (y9b.a) ListProtector.get(r2, r8);
        int r12 = r11.b();
        if (r4.isEmpty() == false) goto L13;
    L16:
        r4.add(r11);
    L17:
        r8 = r8 + 1;
        goto L9
    L13:
        if (r4.getLast().b() <= r12) goto L16;
        i(r4, r3, r5, r15, r12);
        r4.add(r11);
        goto L17
    L19:
        if ((!r4.isEmpty()) == false) goto L21;
        i(r4, r3, r5, r15, -1);
    L21:
        r2.clear();
        r3.clear();
        r4.clear();
        r5.clear();
        Log.d("ListActionHandle", "checkAndChangeListNumbers cost: " + (System.currentTimeMillis() - r0));
    }

    public void e(Editable r7, e r8) {
        Intrinsics.checkNotNullParameter(r7, "s");
        Intrinsics.checkNotNullParameter(r8, "info");
        InsertListStateMachine r0 = this.l;
        int r1 = r8.a;
        int r2 = r8.b;
        int r9 = r8.c;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r7, "dest");
        Log.d("InsertListStateMachine", "textChange");
        boolean r4 = true;
        if (r7.length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        r0.d(0);
        r0.g = 0;
        r0.h = 0;
    L18:
        a(r7);
        return;
    L8:
        if (r2 != 0) goto L12;
        if (r9 != 1) goto L12;
        if (r1 < 0) goto L12;
    L14:
        if (r0.c == InsertListStateMachine.State.None) goto L17;
        if (r4 == false) goto L17;
        char r10 = r7.charAt(r1);
        r0.d.append(r10);
        r0.e = r10;
    L17:
        r0.e();
    L12:
        r4 = false;
        goto L14
    L5:
        r3 = false;
        goto L6
    }

    public void f(Editable r18, d r19) {
        Intrinsics.checkNotNullParameter(r18, "s");
        Intrinsics.checkNotNullParameter(r19, "info");
        y9b.a r3 = r19.a;
        if (r3 == null) goto L121;
        int r4 = r19.b;
        int r5 = r19.c;
        int r6 = r19.d;
        int r7 = Math.min(r18.length(), r6);
    L6:
        if (r7 >= r18.length()) goto L11;
        if (r18.charAt(r7) == '\n') goto L11;
        r7 = r7 + 1;
    L11:
        if (r7 >= r18.length()) goto L13;
        r7 = r7 + 1;
    L13:
        LinkedList<y9b.a> r8 = this.j;
        r8.clear();
        if (r18.length() != 0) goto L16;
        boolean r10 = true;
    L17:
        if (r10 == false) goto L19;
        int r15 = 1;
        boolean r16 = false;
    L41:
        if ((r6 - r5) == 1) goto L43;
    L45:
        boolean r9 = false;
    L46:
        if (r9 == false) goto L48;
        r15 = 2;
    L48:
        int r11 = r4;
    L50:
        if (r11 >= r7) goto L57;
        if (r11 >= r18.length()) goto L56;
        if (r18.charAt(r11) != 8203) goto L56;
        r18.delete(r11, r11 + 1);
        r7 = r7 - 1;
    L56:
        r11 = r11 + 1;
    L57:
        int r12 = r4 - 1;
        ArrayList r13 = (ArrayList) this.f;
        r13.clear();
        int r14 = r4;
    L58:
        if (r14 >= r7) goto L71;
        if (r15 <= 0) goto L71;
        if (r18.charAt(r14) == '\n') goto L65;
        if (r14 == (r7 - 1)) goto L65;
    L70:
        r14 = r14 + 1;
    L65:
        if (r18.charAt(r14) == '\n') goto L67;
    L69:
        r13.add(Integer.valueOf(Math.min(r18.length(), r14 + 1)));
        r15 = r15 - 1;
        r12 = r14;
        goto L70
    L67:
        if ((r14 - r12) != 1) goto L69;
        r18.insert(r14, "\u200b");
        r7 = r7 + 1;
        r14 = r14 + 1;
    L71:
        if (r15 <= 0) goto L83;
        if (r7 != r18.length()) goto L83;
        if (r18.length() != 0) goto L77;
        boolean r17 = true;
    L78:
        if (r17 == false) goto L80;
    L81:
        r18.append(8203);
        r13.add(Integer.valueOf(r18.length()));
        goto L83
    L80:
        if (StringsKt.last(r18) != '\n') goto L83;
    L77:
        r17 = false;
    L83:
        if ((!r13.isEmpty()) == false) goto L101;
        int r20 = 0;
        int r21 = 0;
    L86:
        if (r20 >= r13.size()) goto L103;
        int r110 = r20 + 1;
        int r22 = ((Number) ListProtector.get(r13, r20)).intValue();
        if ((r3 instanceof y9b.b) == false) goto L90;
        r21 = r21 + 1;
    L90:
        int r111 = r18.getSpanStart(r3);
        int r112 = r18.getSpanEnd(r3);
        if (r111 != r4) goto L93;
        if (r112 != r22) goto L93;
    L95:
        if (r110 == r13.size()) goto L96;
        y9b.a r23 = r8.pollFirst();
        if (r23 != null) goto L100;
        r23 = this.b.a(r3);
    L100:
        this.b.getClass();
        com.ss.android.lark.keyboard.edittext2.list.b.c(r23, r3);
        this.b.d(r23);
        r3 = r23;
        r4 = r22;
        r20 = r110;
        goto L86
    L96:
        r4 = r22;
    L93:
        r18.setSpan(r3, r4, r22, 33);
    L103:
        if ((!r8.isEmpty()) == false) goto L107;
        y9b.a r24 = r8.pollFirst();
        if (r24 == null) goto L103;
        r18.removeSpan(r24);
        this.b.b(r24);
        goto L103
    L107:
        if (r16 == false) goto L110;
        if (r4 == r7) goto L110;
        boolean r25 = true;
    L111:
        boolean r26 = r19.f;
        if (r21 == r19.g) goto L114;
        boolean r113 = true;
    L115:
        if (r113 == true) goto L118;
        if (r25 == true) goto L118;
        if (r26 == true) goto L118;
        return;
    L118:
        h(r18);
        return;
    L114:
        r113 = false;
    L110:
        r25 = false;
        goto L111
    L101:
        r21 = 0;
        goto L103
    L43:
        if (r18.charAt(r5) != '\n') goto L45;
        r9 = true;
        goto L46
    L19:
        y9b.a[] r114 = (y9b.a[]) r18.getSpans(r4, Math.min(r7 + 1, r18.length()), y9b.a.class);
        if (r114.length <= 1) goto L22;
        ArraysKt.sortWith(r114, new h(r18));
    L22:
        int r115 = r114.length;
        int r116 = 0;
        r15 = 0;
        r16 = false;
    L23:
        if (r116 >= r115) goto L41;
        y9b.a r117 = r114[r116];
        int r27 = r18.getSpanStart(r117);
        int r118 = r18.getSpanEnd(r117);
        if (r27 != r7) goto L27;
        r16 = true;
    L27:
        if (r118 > r7) goto L31;
        if (r118 > r5) goto L30;
        if (r27 >= r6) goto L31;
    L30:
        r15 = r15 + 1;
    L31:
        if (r4 > r27) goto L34;
        if (r27 >= r7) goto L34;
        boolean r28 = true;
    L35:
        if (r28 == false) goto L39;
        if (Intrinsics.areEqual(r117, r3) == true) goto L39;
        r8.addLast(r117);
    L39:
        r116 = r116 + 1;
    L34:
        r28 = false;
        goto L35
    L16:
        r10 = false;
        goto L17
    L121:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final boolean g(Editable r7, boolean r8) {
        int r0 = Selection.getSelectionStart(r7);
        int r1 = Selection.getSelectionEnd(r7);
        int r2 = Math.min(r0, r1);
        int r3 = Math.max(r0, r1);
        if ((r3 - r2) == 1) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r3 == r2) goto L11;
        if (r4 == true) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
    L27:
        return false;
    L14:
        if (r3 == (-1)) goto L27;
        y9b.a r6 = k(r7, r2);
        if (r6 != null) goto L19;
        return false;
    L19:
        int r9 = r7.getSpanStart(r6);
        if (o(r7, r2, r6, r8) == false) goto L22;
        return true;
    L22:
        if (r9 != r2) goto L27;
        p(r6, r7);
        r7.removeSpan(r6);
        this.b.b(r6);
        if ((r6 instanceof y9b.b) == false) goto L26;
        h(r7);
    L26:
        return true;
    L11:
        r5 = false;
        goto L12
    L5:
        if (r7.charAt(r2) != 8203) goto L7;
        r4 = true;
        goto L8
    }

    public final void m(Spannable r18, Set<y9b.a> r19) {
        SpanWatcher[] r9 = (SpanWatcher[]) r18.getSpans(0, r18.length(), SpanWatcher.class);
        Iterator<T> r10 = r19.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        y9b.a r11 = (y9b.a) r10.next();
        this.b.d(r11);
        int r13 = r18.getSpanStart(r11);
        int r14 = r18.getSpanEnd(r11);
        int r15 = r9.length;
        int r6 = 0;
    L6:
        if (r6 >= r15) goto L4;
        r9[r6].onSpanChanged(r18, r11, r13, r14, r13, r14);
        r6 = r6 + 1;
        goto L6
    }

    public static void n(Map r8, List r9, Set r10) {
        Iterator r11 = r9.iterator();
        int r0 = -2;
        int r2 = 0;
    L4:
        if (r11.hasNext() == false) goto L31;
        y9b.a r3 = (y9b.a) r11.next();
        ULong r4 = (ULong) r8.get(r3);
        if (r4 == null) goto L4;
        long r5 = r4.unbox-impl();
        int r7 = (int) ULong.constructor-impl(r5 >>> 32);
        int r6 = (int) r5;
        ListHeadType r12 = r3.c;
        boolean r13 = true;
        if (r7 == r0) goto L10;
        if (r7 <= r0) goto L30;
        int r1 = f.a[r12.ordinal()];
        if (r1 != 1) goto L21;
        int r14 = r2 + 1;
        if (r3.c() == r14) goto L27;
        r3.h(r14);
    L28:
        if (r13 == false) goto L30;
        r10.add(r3);
        goto L30
    L27:
        r13 = false;
        goto L28
    L21:
        if (r1 != 2) goto L30;
        r3.g(ListHeadType.ListHead);
    L30:
        r2 = r3.c();
        r0 = r6;
        goto L4
    L10:
        if (r12 == ListHeadType.ListHead) goto L30;
        r3.g(ListHeadType.None);
        int r15 = r2 + 1;
        if (r3.c() == r15) goto L14;
        r3.h(r15);
    L15:
        if (r13 == false) goto L30;
        r10.add(r3);
        goto L30
    L14:
        r13 = false;
        goto L15
    }

    public static void q(y9b.a r3, List r4, Map r5) {
        ULong r6 = (ULong) r5.get((y9b.a) CollectionsKt.last(r4));
        if (r6 == null) goto L8;
        int r7 = (int) r6.unbox-impl();
        ULong r0 = (ULong) r5.get(r3);
        if (r0 == null) goto L9;
        r5.put(r3, ULong.box-impl(l((int) ULong.constructor-impl(r0.unbox-impl() >>> 32), r7)));
        return;
    L9:
        return;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r12, int r13, int r14, int r15) {
        if (r12 != null) goto L5;
        return;
    L5:
        if (this.c == true) goto L40;
        this.c = true;
        e r1 = this.e;
        r1.a = r13;
        r1.b = r14;
        r1.c = r15;
        if (this.n == true) goto L35;
        Editable r2 = this.a.getEditableText();
        Intrinsics.checkNotNull(r2);
        y9b.a r3 = k(r2, r13);
        if (r3 == null) goto L36;
        int r4 = r2.getSpanStart(r3);
        if (r14 <= 0) goto L15;
        if (r15 != 0) goto L15;
        boolean r5 = true;
    L16:
        int r16 = r14 + r13;
        int r6 = r16 + 1;
        if (r5 == true) goto L19;
    L33:
        boolean r7 = false;
    L34:
        int r17 = r2.getSpans(r4, r16, y9b.b.class).length;
        d r8 = this.d;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r12, "target");
        Intrinsics.checkNotNullParameter(r3, "span");
        r8.b = r4;
        r8.c = r13;
        r8.d = r15 + r13;
        r8.e = true;
        r8.f = r7;
        r8.h = r12;
        r8.g = r17;
        r8.a = r3;
        goto L36
    L19:
        if (r6 > r2.length()) goto L33;
        Object[] r9 = r2.getSpans(r6, r6, y9b.a.class);
        int r10 = r9.length;
        int r11 = 0;
    L21:
        if (r11 >= r10) goto L29;
        Object r18 = r9[r11];
        if (r2.getSpanStart((y9b.a) r18) != r6) goto L25;
        boolean r19 = true;
    L26:
        if (r19 == true) goto L31;
        r11 = r11 + 1;
    L31:
        if (((y9b.a) r18) == null) goto L33;
        r7 = true;
        goto L34
    L25:
        r19 = false;
        goto L26
    L29:
        r18 = null;
    L15:
        r5 = false;
    L36:
        this.c = false;
        return;
    L35:
        this.n = false;
        goto L36
    }

    public final boolean o(Editable r11, int r12, y9b.a r13, boolean r14) {
        int r0 = r11.getSpanStart(r13);
        int r1 = r11.getSpanEnd(r13);
        String r3 = r11.subSequence(r0, r1).toString();
        if (Intrinsics.areEqual(r3, "\u200b\n") == false) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L22;
        if (r0 <= r12) goto L12;
    L14:
        boolean r15 = false;
    L15:
        if (r15 == false) goto L22;
        p(r13, r11);
        r11.removeSpan(r13);
        this.b.b(r13);
        if ((r13 instanceof y9b.b) == false) goto L19;
        h(r11);
    L19:
        if (r14 == false) goto L21;
        r11.replace(r0, r1, StringsKt.replace$default(r3, "\u200b", "", false, 4, null));
    L21:
        return true;
    L12:
        if (r12 > (r0 + 1)) goto L14;
        r15 = true;
    L22:
        return false;
    L5:
        if (Intrinsics.areEqual(r3, "\u200b") == true) goto L8;
        r2 = false;
        goto L9
    }

    public static void i(LinkedList r2, LinkedList r3, Map r4, Set r5, int r6) {
        if (r2.isEmpty() == false) goto L5;
        return;
    L5:
        r3.clear();
    L7:
        if ((!r2.isEmpty()) == false) goto L18;
        if (((y9b.a) r2.getLast()).b() <= r6) goto L18;
        y9b.a r0 = (y9b.a) r2.remove(CollectionsKt.getLastIndex(r2));
        r3.addFirst(r0);
        if ((!r2.isEmpty()) == false) goto L7;
        if (((y9b.a) r2.getLast()).b() >= r0.b()) goto L7;
        n(r4, r3, r5);
        if ((!r3.isEmpty()) == false) goto L7;
        q((y9b.a) r2.getLast(), r3, r4);
        r3.clear();
    L18:
        if ((!r3.isEmpty()) == false) goto L22;
        n(r4, r3, r5);
        if ((!r2.isEmpty()) == false) goto L22;
        q((y9b.a) r2.getLast(), r3, r4);
    L22:
        r3.clear();
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r4, int r5, int r6, Spanned r7, int r8, int r9) {
        if (this.c == true) goto L42;
        this.c = true;
        Editable r10 = this.a.getEditableText();
        if (r4 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
    L15:
        boolean r2 = false;
    L17:
        if (r9 != (r8 + 1)) goto L29;
        if (r7 == null) goto L25;
        Character r11 = StringsKt.getOrNull(r7, r8);
        if (r11 == null) goto L25;
        if (r11.charValue() != 8203) goto L25;
        boolean r12 = true;
    L26:
        if (r12 == false) goto L29;
        boolean r13 = false;
    L31:
        if (r2 == false) goto L37;
        Intrinsics.checkNotNull(r10);
        if (g(r10, r13) == false) goto L41;
        if (r13 == false) goto L41;
        this.n = true;
        r4 = "\n";
    L41:
        this.c = false;
        goto L42
    L37:
        if (Intrinsics.areEqual(r4, "\n") == false) goto L41;
        Intrinsics.checkNotNull(r10);
        if (c(r10, r13) == false) goto L41;
        r4 = "";
    L25:
        r12 = false;
    L29:
        r13 = true;
        goto L31
    L13:
        if ((r9 - r8) != 1) goto L15;
        r2 = true;
        goto L17
    L7:
        if (r4.length() == 0) goto L10;
        r1 = false;
    L42:
        return r4;
    }
}
