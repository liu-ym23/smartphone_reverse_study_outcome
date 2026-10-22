package com.ss.android.lark.parser.internal;

import com.bytedance.lark.pb.basic.v1.RichTextElement;
import com.ss.android.lark.widget.table.entity.Column;
import com.ss.android.lark.widget.table.entity.HorizontalAlign;
import com.ss.android.lark.widget.table.entity.VerticalAlign;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h0 {
    static {
    }

    @JvmStatic
    public static final RichTextElement.TableCellProperty a(com.ss.android.lark.widget.richtext.RichTextElement.TableCellProperty r5) {
        RichTextElement.TableCellProperty.Builder r0 = new RichTextElement.TableCellProperty.Builder();
        if (r5 == null) goto L7;
        HorizontalAlign r1 = r5.getHorizontalAlign();
        if (r1 == null) goto L7;
    L8:
        RichTextElement.TableCellProperty.Builder r2 = r0.horizontal_align(RichTextElement.HorizontalAlign.fromValue(r1.getNumber()));
        if (r5 == null) goto L13;
        VerticalAlign r3 = r5.getVerticalAlign();
        if (r3 == null) goto L13;
    L14:
        RichTextElement.TableCellProperty.Builder r4 = r2.vertical_align(RichTextElement.VerticalAlign.fromValue(r3.getNumber()));
        Integer r6 = null;
        if (r5 == null) goto L17;
        Integer r7 = Integer.valueOf(r5.getColumnSpan());
    L18:
        RichTextElement.TableCellProperty.Builder r8 = r4.colspan(Integer.valueOf(d(r7, 1)));
        if (r5 == null) goto L21;
        r6 = Integer.valueOf(r5.getRowSpan());
    L21:
        RichTextElement.TableCellProperty.Builder r9 = r8.rowspan(Integer.valueOf(d(r6, 1)));
        if (r5 == null) goto L24;
        boolean r10 = r5.isMerged();
    L25:
        r9.is_merged(Boolean.valueOf(r10));
        return r0.build();
    L24:
        r10 = false;
        goto L25
    L17:
        r7 = null;
    L13:
        r3 = VerticalAlign.VERTICAL_ALIGN_CENTER;
    L7:
        r1 = HorizontalAlign.HORIZONTAL_ALIGN_CENTER;
        goto L8
    }

    @JvmStatic
    public static final RichTextElement.TableProperty b(com.ss.android.lark.widget.richtext.RichTextElement.TableProperty r6) {
        RichTextElement.TableProperty.Builder r0 = new RichTextElement.TableProperty.Builder();
        if (r6 == null) goto L20;
        LinkedList r7 = r6.getColumns();
        if (r7 == null) goto L20;
        ArrayList r1 = new ArrayList();
        Iterator r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L18;
        Column r2 = (Column) r8.next();
        RichTextElement.TableProperty.Column.Builder r3 = new RichTextElement.TableProperty.Column.Builder().width(Integer.valueOf(d(r2.getWidth(), 100)));
        HorizontalAlign r4 = r2.getHorizontalAlign();
        if (r4 != null) goto L13;
        r4 = HorizontalAlign.HORIZONTAL_ALIGN_CENTER;
    L13:
        RichTextElement.TableProperty.Column.Builder r5 = r3.horizontal_align(RichTextElement.HorizontalAlign.fromValue(r4.getNumber()));
        VerticalAlign r9 = r2.getVerticalAlign();
        if (r9 != null) goto L17;
        r9 = VerticalAlign.VERTICAL_ALIGN_CENTER;
    L17:
        r1.add(r5.vertical_align(RichTextElement.VerticalAlign.fromValue(r9.getNumber())).is_header(Boolean.valueOf(r2.isHeader())).build());
        goto L8
    L18:
        r0.columns(r1);
    L20:
        return r0.build();
    }

    @JvmStatic
    public static final RichTextElement.TableRowProperty c(com.ss.android.lark.widget.richtext.RichTextElement.TableRowProperty r3) {
        RichTextElement.TableRowProperty.Builder r0 = new RichTextElement.TableRowProperty.Builder();
        if (r3 == null) goto L7;
        HorizontalAlign r1 = r3.getHorizontalAlign();
        if (r1 == null) goto L7;
    L8:
        RichTextElement.TableRowProperty.Builder r2 = r0.horizontal_align(RichTextElement.HorizontalAlign.fromValue(r1.getNumber()));
        if (r3 == null) goto L13;
        VerticalAlign r4 = r3.getVerticalAlign();
        if (r4 == null) goto L13;
    L14:
        RichTextElement.TableRowProperty.Builder r5 = r2.vertical_align(RichTextElement.VerticalAlign.fromValue(r4.getNumber()));
        if (r3 == null) goto L17;
        boolean r6 = r3.isHeader();
    L18:
        r5.is_header(Boolean.valueOf(r6));
        return r0.build();
    L17:
        r6 = false;
    L13:
        r4 = VerticalAlign.VERTICAL_ALIGN_CENTER;
    L7:
        r1 = HorizontalAlign.HORIZONTAL_ALIGN_CENTER;
        goto L8
    }

    public static int d(Integer r1, int r2) {
        if (r1 != null) goto L4;
        return r2;
    L4:
        if (r1.intValue() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r1 = null;
    L10:
        if (r1 != null) goto L12;
        return r2;
    L12:
        return r1.intValue();
    L6:
        r0 = false;
        goto L7
    }
}
