package com.ss.android.lark.coremdbiz.facade.table;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.lark.widget.table.entity.Column;
import com.ss.android.lark.widget.table.entity.HorizontalAlign;
import com.ss.android.lark.widget.table.entity.TableInfo;
import com.ss.android.lark.widget.table.entity.VerticalAlign;
import eab.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static TableInfo a(Context r27, a r28, h r29) {
        h r2 = r29;
        Intrinsics.checkNotNullParameter(r27, "context");
        Intrinsics.checkNotNullParameter(r28, "parserFactory");
        Intrinsics.checkNotNullParameter(r2, "node");
        b r3 = r28.a(r27);
        TextLayoutBuilder r1 = r28.b(r27);
        TableInfo r4 = new TableInfo();
        r4.setColumnSpan(r2.k.size());
        r4.setRowSpan(r2.l.size());
        r4.setColumnInfo(new LinkedList(r2.k));
        r4.setTableRootId(r2.j);
        HashMap r5 = new HashMap();
        HashMap r6 = new HashMap();
        Iterator r7 = r2.l.iterator();
        int r9 = 0;
        int r10 = 0;
    L4:
        if (r7.hasNext() == false) goto L24;
        Object r11 = r7.next();
        int r12 = r9 + 1;
        if (r9 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        h.b r13 = (h.b) r11;
        r5.put(Integer.valueOf(r9), new TableInfo.TableRowPropertyWrapper(r13.b, r13.c, r13.a));
        Iterator r8 = r13.d.iterator();
        int r14 = 0;
    L10:
        if (r8.hasNext() == false) goto L23;
        Object r15 = r8.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        h.a r17 = (h.a) r15;
        if (r2.k.size() <= r14) goto L17;
        Column r18 = (Column) ListProtector.get(r2.k, r14);
    L18:
        Integer r19 = r18.getWidth();
        if (r19 == null) goto L21;
        int r110 = r19.intValue();
    L22:
        Integer r20 = Integer.valueOf(r10);
        Integer r111 = Integer.valueOf(r17.a);
        Integer r21 = Integer.valueOf(r17.b);
        HorizontalAlign r112 = r17.c;
        VerticalAlign r22 = r17.d;
        Integer r23 = Integer.valueOf(r110);
        boolean r24 = r17.e;
        UIUtils.dp2px(r27, r110 * r17.a);
        r1.h(r3.b(r17.f));
        r6.put(r20, new TableInfo.TableCellPropertyWrapper(r111, r21, r112, r22, r23, r24, r1.a()));
        r2 = r29;
        r14 = r16;
        r10 = r10 + 1;
        r7 = r7;
        r8 = r8;
        goto L10
    L21:
        r110 = 100;
        goto L22
    L17:
        r18 = new Column(100, HorizontalAlign.HORIZONTAL_ALIGN_CENTER, VerticalAlign.VERTICAL_ALIGN_CENTER, false);
        goto L18
    L23:
        r2 = r29;
        r9 = r12;
        goto L4
    L24:
        r4.setTableCellPropertyMap(r6);
        r4.setTableRowPropertyMap(r5);
        return r4;
    }
}
