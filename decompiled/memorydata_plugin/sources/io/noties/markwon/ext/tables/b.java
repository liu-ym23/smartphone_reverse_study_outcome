package io.noties.markwon.ext.tables;

import android.text.Layout;
import kotlin.Metadata;
import org.commonmark.ext.gfm.tables.TableCell;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0010\u0010\u0007\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"ALIGN_CENTER", "", "ALIGN_LEFT", "ALIGN_RIGHT", "layoutAlignment", "Landroid/text/Layout$Alignment;", "alignment", "tableCellAlignment", "Lorg/commonmark/ext/gfm/tables/TableCell$Alignment;", "markwon-ext-tables_release"}, k = 2, mv = {1, 1, 15})
public final class b {
    public static final int a(TableCell.Alignment r4) {
        if (r4 == null) goto L10;
        int r5 = c.f16494a[r4.ordinal()];
        if (r5 == 1) goto L12;
        if (r5 != 2) goto L10;
        return 2;
    L12:
        return 1;
    L10:
        return 0;
    }

    public static final Layout.Alignment a(int r1) {
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L11;
        return Layout.Alignment.ALIGN_NORMAL;
    L11:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L9:
        return Layout.Alignment.ALIGN_CENTER;
    }
}
