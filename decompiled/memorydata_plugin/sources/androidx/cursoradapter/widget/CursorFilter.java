package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class CursorFilter extends Filter {
    CursorFilterClient mClient;

    interface CursorFilterClient {
        void changeCursor(Cursor r1);

        CharSequence convertToString(Cursor r1);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence r1);
    }

    CursorFilter(CursorFilterClient r3) {
        this.mClient = (CursorFilterClient) ZeusTransformUtils.wrapperContextForParams(r3, CursorFilterClient.class, "com.obric.memorydata.plugin");
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object r3) {
        return this.mClient.convertToString((Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Cursor r2 = this.mClient.runQueryOnBackgroundThread(r4);
        Filter.FilterResults r5 = new Filter.FilterResults();
        if (r2 == null) goto L5;
        r5.count = r2.getCount();
    L6:
        r5.values = r2;
        return r5;
    L5:
        r5.count = 0;
        r2 = null;
        goto L6
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence r3, Filter.FilterResults r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Cursor r6 = this.mClient.getCursor();
        if (r4.values != null) goto L5;
        return;
    L5:
        if (r4.values == r6) goto L9;
        this.mClient.changeCursor((Cursor) ZeusTransformUtils.preCheckCast(r4.values, Cursor.class, "com.obric.memorydata.plugin"));
        return;
    }
}
