package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;

/* JADX INFO: loaded from: classes.dex */
class CursorFilter extends Filter {
    CursorFilterClient mClient;

    interface CursorFilterClient {
        void changeCursor(Cursor r10);

        CharSequence convertToString(Cursor r10);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence r10);
    }

    CursorFilter(CursorFilterClient r10) {
        this.mClient = r10;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object r10) {
        return this.mClient.convertToString((Cursor) r10);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence r10) {
        Cursor r11 = this.mClient.runQueryOnBackgroundThread(r10);
        Filter.FilterResults r12 = new Filter.FilterResults();
        if (r11 == null) goto L5;
        r12.count = r11.getCount();
    L6:
        r12.values = r11;
        return r12;
    L5:
        r12.count = 0;
        r11 = null;
        goto L6
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence r10, Filter.FilterResults r11) {
        Cursor r12 = this.mClient.getCursor();
        Object r13 = r11.values;
        if (r13 == null) goto L7;
        if (r13 == r12) goto L8;
        this.mClient.changeCursor((Cursor) r13);
        return;
    L8:
        return;
    }
}
