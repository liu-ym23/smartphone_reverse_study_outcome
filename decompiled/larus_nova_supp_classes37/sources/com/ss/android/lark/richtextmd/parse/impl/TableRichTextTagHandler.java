package com.ss.android.lark.richtextmd.parse.impl;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.table.entity.Column;
import eab.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.e;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TableRichTextTagHandler implements b3c.a {
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    @Override // b3c.a
    public final boolean a() {
        return true;
    }

    public TableRichTextTagHandler() {
        this.a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, TableRichTextTagHandler$boldValue$2.INSTANCE);
    }

    @Override // b3c.a
    public final s b(b3c.b r25) {
        Intrinsics.checkNotNullParameter(r25, "context");
        RichTextElement r1 = r25.getElement();
        RichTextElement.TableProperty r2 = r1.getProperty();
        List r3 = r2.getColumns();
        if (r3 != null) goto L6;
        r3 = CollectionsKt.emptyList();
    L6:
        List r4 = r1.getChildIds();
        ArrayList r5 = new ArrayList();
        if (r4 == null) goto L61;
        Iterator r6 = r4.iterator();
    L10:
        if (r6.hasNext() == false) goto L61;
        String r7 = (String) r6.next();
        Intrinsics.checkNotNull(r7);
        RichTextElement r8 = r25.getElementById(r7);
        if (r8 == null) goto L14;
        RichTextElement.RichTextTag r9 = r8.getTag();
    L16:
        if (r9 == RichTextElement.RichTextTag.TABLE_ROW) goto L18;
        Iterator r23 = r6;
    L59:
        r6 = r23;
        goto L10
    L18:
        Log.i("TableRichTextTagHandler", "table row id = " + r7);
        List r10 = r8.getChildIds();
        RichTextElement.TableRowProperty r11 = r8.getProperty();
        ArrayList r12 = new ArrayList();
        Intrinsics.checkNotNull(r10);
        Iterator r13 = r10.iterator();
        int r14 = 0;
    L20:
        if (r13.hasNext() == false) goto L58;
        String r15 = (String) r13.next();
        Intrinsics.checkNotNull(r15);
        RichTextElement r16 = r25.getElementById(r15);
        if (r16 == null) goto L24;
        RichTextElement.RichTextTag r17 = r16.getTag();
    L26:
        if (r17 != RichTextElement.RichTextTag.TABLE_CELL) goto L20;
        boolean r18 = true;
        if (r11.isHeader() == true) goto L39;
        Column r19 = (Column) CollectionsKt.getOrNull(r3, r14);
        if (r19 != null) goto L33;
    L35:
        boolean r110 = false;
    L36:
        if (r110 == true) goto L39;
        r18 = false;
        goto L39
    L33:
        if (r19.isHeader() != true) goto L35;
        r110 = true;
    L39:
        Log.i("TableRichTextTagHandler", "table cell id = " + r15 + ", isHeader = " + r18);
        RichTextElement.TableCellProperty r20 = r16.getProperty();
        e r111 = new e();
        if (r18 == false) goto L43;
        ((s) r111).c.put("fontWeight", (String) this.a.getValue());
    L43:
        List r21 = r16.getChildIds();
        Intrinsics.checkNotNull(r21);
        Iterator r22 = r21.iterator();
    L45:
        if (r22.hasNext() == false) goto L57;
        String r112 = (String) r22.next();
        Intrinsics.checkNotNull(r112);
        RichTextElement r113 = r25.getElementById(r112);
        if (r113 == null) goto L45;
        RichTextElement.RichTextTag r114 = r113.getTag();
        if (r114 == RichTextElement.RichTextTag.TABLE) goto L45;
        if (r114 == RichTextElement.RichTextTag.TABLE_CELL) goto L45;
        if (r114 == RichTextElement.RichTextTag.TABLE_ROW) goto L45;
        c(r25, r113, r111);
        goto L45
    L57:
        r25.d().d(r111);
        h.a r24 = new h.a(r20.getColumnSpan(), r20.getRowSpan(), r20.getHorizontalAlign(), r20.getVerticalAlign(), r20.isMerged(), r111);
        r12.add(r24);
        r14 = r14 + r24.a;
        r6 = r6;
        goto L20
    L24:
        r17 = null;
        goto L26
    L58:
        r23 = r6;
        r5.add(new h.b(r11.isHeader(), r11.getHorizontalAlign(), r11.getVerticalAlign(), r12));
        goto L59
    L14:
        r9 = null;
    L61:
        return new h(String.valueOf(r2.hashCode()), r3, r5);
    }

    public static void c(b3c.b r3, RichTextElement r4, s r5) {
        RichTextElement.RichTextTag r0 = r4.getTag();
        if (r0 != RichTextElement.RichTextTag.TABLE) goto L5;
        return;
    L5:
        if (r0 != RichTextElement.RichTextTag.TABLE_CELL) goto L7;
        return;
    L7:
        if (r0 == RichTextElement.RichTextTag.TABLE_ROW) goto L35;
        b3c.a r1 = r3.a(r4.getTag());
        if (r1 != null) goto L12;
        r1 = r3.c();
    L12:
        c r6 = r3.e(r4);
        s r2 = r1.b(r6);
        if (r2 == null) goto L15;
        r2.c.putAll(r4.getStyle());
        r5.e(r2);
    L15:
        if (r2 == null) goto L18;
        r5 = r2;
    L18:
        List r7 = r4.getChildIds();
        if (r7 == null) goto L34;
        Iterator r8 = r7.iterator();
    L22:
        if (r8.hasNext() == false) goto L36;
        String r9 = (String) r8.next();
        Intrinsics.checkNotNull(r9);
        RichTextElement r10 = r6.getElementById(r9);
        if (r10 == null) goto L22;
        c(r6, r10, r5);
        goto L22
    L36:
        return;
    L34:
        return;
    }
}
