package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;

/* JADX INFO: loaded from: classes.dex */
class CursorFilter extends Filter {
    CursorFilterClient mClient;

    public interface CursorFilterClient {
        void changeCursor(Cursor r5);

        CharSequence convertToString(Cursor r5);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence r5);
    }

    public CursorFilter(CursorFilterClient r5) {
        this.mClient = r5;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object r5) {
        return this.mClient.convertToString((Cursor) r5);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence r5) {
        Cursor r10 = this.mClient.runQueryOnBackgroundThread(r5);
        Filter.FilterResults r11 = new Filter.FilterResults();
        if (r10 == null) goto L5;
        r11.count = r10.getCount();
        r11.values = r10;
    L6:
        return r11;
    L5:
        r11.count = 0;
        r11.values = null;
        goto L6
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence r5, Filter.FilterResults r10) {
        Cursor r11 = this.mClient.getCursor();
        Object r12 = r10.values;
        if (r12 == null) goto L7;
        if (r12 == r11) goto L8;
        this.mClient.changeCursor((Cursor) r12);
        return;
    L8:
        return;
    }
}
