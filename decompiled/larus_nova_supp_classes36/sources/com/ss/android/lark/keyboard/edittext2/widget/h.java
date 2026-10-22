package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Editable;
import android.text.Selection;
import android.text.method.MetaKeyKeyListener;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ReplacementSpan;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnectionWrapper;
import com.ss.android.lark.widget.light.viewstub.ViewHolderSpan;
import com.ss.android.lark.widget.span.VideoImageSpan;
import com.ss.android.lark.widget.span.m0;
import com.ss.android.lark.widget.span.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h {
    public static final h a = null;
    public static final Set<Class<? extends CharacterStyle>> b = null;
    public static final Set<Class<? extends Object>> c = null;
    public static final Set<Class<? extends Object>> d = null;
    public static final Set<Class<? extends ReplacementSpan>> e = null;

    public static final class a {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public h() {
    }

    static {
        a = new h();
        b = SetsKt.setOf(new Class[]{com.ss.android.lark.widget.linked_emojicon.base.a.class, ncc.e.class, com.ss.android.lark.widget.span.a.class, com.ss.android.lark.keyboard.edittext2.span.a.class});
        c = SetsKt.setOf(new Class[]{com.ss.android.lark.widget.linked_emojicon.base.a.class, ncc.e.class, com.ss.android.lark.widget.span.a.class, VideoImageSpan.class, m0.class, ViewHolderSpan.class, com.ss.android.lark.keyboard.edittext2.span.f.class, v.class});
        d = SetsKt.setOf(new Class[]{ReplacementSpan.class, ClickableSpan.class, com.ss.android.lark.keyboard.edittext2.span.f.class, com.ss.android.lark.widget.light.span.p.class});
        e = SetsKt.setOf(new Class[]{VideoImageSpan.class, m0.class, ViewHolderSpan.class, v.class});
    }

    private final boolean delete(Editable r8, KeyEvent r9, boolean r10) {
        if ((!KeyEvent.metaStateHasNoModifiers(r9.getMetaState())) == false) goto L5;
        return false;
    L5:
        int r11 = Selection.getSelectionStart(r8);
        int r2 = Selection.getSelectionEnd(r8);
        if (r11 == (-1)) goto L11;
        if (r2 == (-1)) goto L11;
        if (r11 != r2) goto L11;
        boolean r3 = false;
    L12:
        if (r3 == false) goto L14;
        return false;
    L14:
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = c.iterator();
    L16:
        if (r5.hasNext() == false) goto L19;
        CollectionsKt.addAll(r4, r8.getSpans(r11, r2, (Class) r5.next()));
        goto L16
    L19:
        if (r4.isEmpty() == false) goto L21;
        return false;
    L21:
        Iterator r6 = r4.iterator();
    L23:
        if (r6.hasNext() == false) goto L41;
        Object r7 = r6.next();
        int r12 = r8.getSpanStart(r7);
        int r13 = r8.getSpanEnd(r7);
        if (r10 == false) goto L27;
        if (r12 != r11) goto L27;
    L35:
        r8.delete(r12, r13);
        if (CollectionsKt.contains(e, r7.getClass()) == true) goto L38;
    L40:
        return true;
    L38:
        if ((r8 instanceof p) == false) goto L40;
        ((p) r8).b();
    L27:
        if (r10 == true) goto L30;
        if (r13 == r11) goto L35;
    L30:
        if ((r12 + 1) > r11) goto L33;
        if (r11 >= r13) goto L33;
        boolean r14 = true;
    L34:
        if (r14 == false) goto L23;
    L33:
        r14 = false;
        goto L34
    L41:
        return false;
    L11:
        r3 = true;
        goto L12
    }

    public final boolean b(Editable r4, int r5, KeyEvent r6) {
        Intrinsics.checkNotNullParameter(r4, "editable");
        Intrinsics.checkNotNullParameter(r6, "event");
        if (r5 != 67) goto L5;
        boolean r7 = delete(r4, r6, false);
    L9:
        if (r7 == false) goto L12;
        MetaKeyKeyListener.adjustMetaAfterKeypress(r4);
        return true;
    L12:
        return false;
    L5:
        if (r5 == 112) goto L7;
        r7 = false;
        goto L9
    L7:
        r7 = delete(r4, r6, true);
        goto L9
    }

    public static boolean a(InputConnectionWrapper r8, Editable r9, int r10, int r11, boolean r12) {
        if (r9 == null) goto L91;
        if (r8 == null) goto L91;
        if (r10 < 0) goto L91;
        if (r11 < 0) goto L91;
        int r1 = Selection.getSelectionStart(r9);
        int r2 = Selection.getSelectionEnd(r9);
        if (r1 == (-1)) goto L15;
        if (r2 == (-1)) goto L15;
        if (r1 != r2) goto L15;
        boolean r5 = false;
    L16:
        if (r5 == false) goto L18;
        return false;
    L18:
        if (r12 == false) goto L77;
        int r13 = a.a;
        int r14 = RangesKt.coerceAtLeast(r10, 0);
        Intrinsics.checkNotNullParameter(r9, "cs");
        int r6 = r9.length();
        if (r1 < 0) goto L46;
        if (r6 < r1) goto L46;
        if (r14 < 0) goto L46;
    L25:
        boolean r7 = false;
    L26:
        if (r14 == 0) goto L47;
        r1 = r1 - 1;
        if (r1 < 0) goto L30;
        char r15 = r9.charAt(r1);
        if (r7 == true) goto L36;
        if (Character.isSurrogate(r15) == false) goto L41;
        if (Character.isHighSurrogate(r15) == true) goto L46;
        r7 = true;
        goto L26
    L41:
        r14 = r14 - 1;
        goto L26
    L36:
        if (Character.isHighSurrogate(r15) == false) goto L46;
        r14 = r14 - 1;
        goto L25
    L30:
        if (r7 == true) goto L46;
        r1 = 0;
    L47:
        int r16 = a.a;
        int r17 = RangesKt.coerceAtLeast(r11, 0);
        Intrinsics.checkNotNullParameter(r9, "cs");
        int r18 = r9.length();
        if (r2 < 0) goto L73;
        if (r18 < r2) goto L73;
        if (r17 < 0) goto L73;
    L53:
        boolean r19 = false;
    L54:
        if (r17 == 0) goto L74;
        if (r2 >= r18) goto L57;
        char r20 = r9.charAt(r2);
        if (r19 == true) goto L63;
        if (Character.isSurrogate(r20) == false) goto L68;
        if (Character.isLowSurrogate(r20) == true) goto L73;
        r2 = r2 + 1;
        r19 = true;
        goto L54
    L68:
        r17 = r17 - 1;
        r2 = r2 + 1;
        goto L54
    L63:
        if (Character.isLowSurrogate(r20) == false) goto L73;
        r17 = r17 - 1;
        r2 = r2 + 1;
        goto L53
    L57:
        if (r19 == false) goto L59;
        r18 = -1;
    L59:
        r2 = r18;
    L74:
        if (r1 == (-1)) goto L76;
        if (r2 == (-1)) goto L76;
    L78:
        ArrayList r110 = new ArrayList();
        Iterator<T> r111 = c.iterator();
    L80:
        if (r111.hasNext() == false) goto L83;
        CollectionsKt.addAll(r110, r9.getSpans(r1, r2, (Class) r111.next()));
        goto L80
    L83:
        if (r110.isEmpty() == false) goto L85;
        return false;
    L85:
        Iterator r112 = r110.iterator();
    L87:
        if (r112.hasNext() == false) goto L89;
        Object r113 = r112.next();
        int r114 = r9.getSpanStart(r113);
        int r115 = r9.getSpanEnd(r113);
        r1 = RangesKt.coerceAtMost(r114, r1);
        r2 = RangesKt.coerceAtLeast(r115, r2);
        goto L87
    L89:
        int r116 = RangesKt.coerceAtLeast(r1, 0);
        int r117 = RangesKt.coerceAtMost(r2, r9.length());
        r8.beginBatchEdit();
        r9.delete(r116, r117);
        r8.endBatchEdit();
        return true;
    L76:
        return false;
    L73:
        r2 = -1;
    L46:
        r1 = -1;
        goto L47
    L77:
        r1 = RangesKt.coerceAtLeast(r1 - r10, 0);
        r2 = RangesKt.coerceAtMost(r2 + r11, r9.length());
    L15:
        r5 = true;
    L91:
        return false;
    }
}
