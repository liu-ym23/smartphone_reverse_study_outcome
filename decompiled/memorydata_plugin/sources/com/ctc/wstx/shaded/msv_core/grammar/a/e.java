package com.ctc.wstx.shaded.msv_core.grammar.a;

import com.ctc.wstx.shaded.msv_core.grammar.AnyNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.ChoiceNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.DifferenceNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.NameClass;
import com.ctc.wstx.shaded.msv_core.grammar.NamespaceNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.NotNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.SimpleNameClass;
import com.ctc.wstx.shaded.msv_core.util.StringPair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static NameClass a(NameClass r12) {
        Set r0 = f.a(r12);
        HashSet r1 = new HashSet();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L19;
        StringPair r3 = (StringPair) ZeusTransformUtils.preCheckCast(r2.next(), StringPair.class, "com.obric.memorydata.plugin");
        if (r3.localName == "\u0000") goto L11;
        if (r12.accepts(r3) == r12.accepts(r3.namespaceURI, "\u0000")) goto L9;
    L16:
        if (r3.namespaceURI == "\u0000") goto L4;
        r1.add(r3.namespaceURI);
    L9:
        r2.remove();
        goto L4
    L11:
        if (r3.namespaceURI == "\u0000") goto L16;
        if (r12.accepts(r3) != r12.accepts("\u0000", "\u0000")) goto L16;
    L19:
        if (r12.accepts("\u0000", "\u0000") == true) goto L21;
        r0.remove(new StringPair("\u0000", "\u0000"));
    L21:
        Iterator r4 = r1.iterator();
        NameClass r5 = null;
    L23:
        if (r4.hasNext() == false) goto L46;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        Iterator r7 = r0.iterator();
        NameClass r8 = null;
    L26:
        if (r7.hasNext() == false) goto L37;
        StringPair r9 = (StringPair) ZeusTransformUtils.preCheckCast(r7.next(), StringPair.class, "com.obric.memorydata.plugin");
        if (r9.namespaceURI.equals(r6) == false) goto L26;
        if (r9.localName == "\u0000") goto L26;
        if (r8 == null) goto L34;
        r8 = new ChoiceNameClass(r8, new SimpleNameClass(r9));
        goto L26
    L34:
        r8 = new SimpleNameClass(r9);
        goto L26
    L37:
        if (r0.contains(new StringPair(r6, "\u0000")) == false) goto L41;
        if (r8 != null) goto L40;
        r8 = new NamespaceNameClass(r6);
        goto L41
    L40:
        r8 = new DifferenceNameClass(new NamespaceNameClass(r6), r8);
    L41:
        if (r8 == null) goto L23;
        if (r5 == null) goto L43;
        r5 = new ChoiceNameClass(r5, r8);
        goto L23
    L43:
        r5 = r8;
        goto L23
    L46:
        if (r12.accepts("\u0000", "\u0000") == false) goto L50;
        if (r5 != null) goto L49;
        r5 = NameClass.ALL;
        goto L50
    L49:
        r5 = new NotNameClass(r5);
    L50:
        if (r5 == null) goto L52;
        return r5;
    L52:
        return AnyNameClass.NONE;
    }
}
