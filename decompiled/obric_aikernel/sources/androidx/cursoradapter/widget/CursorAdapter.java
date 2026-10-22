package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {

    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean mAutoRequery;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected ChangeObserver mChangeObserver;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Context mContext;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Cursor mCursor;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected CursorFilter mCursorFilter;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected DataSetObserver mDataSetObserver;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean mDataValid;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected FilterQueryProvider mFilterQueryProvider;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int mRowIDColumn;

    private class ChangeObserver extends ContentObserver {
        final /* synthetic */ CursorAdapter this$0;

        ChangeObserver(CursorAdapter r10) {
            this.this$0 = r10;
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r10) {
            this.this$0.onContentChanged();
        }
    }

    private class MyDataSetObserver extends DataSetObserver {
        final /* synthetic */ CursorAdapter this$0;

        MyDataSetObserver(CursorAdapter r10) {
            this.this$0 = r10;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CursorAdapter r10 = this.this$0;
            r10.mDataValid = true;
            r10.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            CursorAdapter r10 = this.this$0;
            r10.mDataValid = false;
            r10.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public CursorAdapter(Context r10, Cursor r11) {
        init(r10, r11, 1);
    }

    public CursorAdapter(Context r10, Cursor r11, int r12) {
        init(r10, r11, r12);
    }

    public CursorAdapter(Context r10, Cursor r11, boolean r12) {
        if (r12 == false) goto L5;
        int r13 = 1;
    L6:
        init(r10, r11, r13);
        return;
    L5:
        r13 = 2;
        goto L6
    }

    public abstract void bindView(View r10, Context r11, Cursor r12);

    public void changeCursor(Cursor r10) {
        Cursor r11 = swapCursor(r10);
        if (r11 == null) goto L6;
        r11.close();
        return;
    }

    public CharSequence convertToString(Cursor r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        return r10.toString();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mDataValid == false) goto L8;
        Cursor r10 = this.mCursor;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getCount();
    L8:
        return 0;
    }

    @Override // androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor getCursor() {
        return this.mCursor;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int r10, View r11, ViewGroup r12) {
        if (this.mDataValid == false) goto L9;
        this.mCursor.moveToPosition(r10);
        if (r11 != null) goto L7;
        r11 = newDropDownView(this.mContext, this.mCursor, r12);
    L7:
        bindView(r11, this.mContext, this.mCursor);
        return r11;
    L9:
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.mCursorFilter != null) goto L6;
        this.mCursorFilter = new CursorFilter(this);
    L6:
        return this.mCursorFilter;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }

    @Override // android.widget.Adapter
    public Object getItem(int r10) {
        if (this.mDataValid == false) goto L8;
        Cursor r11 = this.mCursor;
        if (r11 == null) goto L10;
        r11.moveToPosition(r10);
        return this.mCursor;
    L10:
        return null;
    L8:
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int r10) {
        if (this.mDataValid == false) goto L10;
        Cursor r11 = this.mCursor;
        if (r11 == null) goto L10;
        if (r11.moveToPosition(r10) == false) goto L10;
        return this.mCursor.getLong(this.mRowIDColumn);
    L10:
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int r10, View r11, ViewGroup r12) {
        if (this.mDataValid == false) goto L13;
        if (this.mCursor.moveToPosition(r10) == false) goto L11;
        if (r11 != null) goto L8;
        r11 = newView(this.mContext, this.mCursor, r12);
    L8:
        bindView(r11, this.mContext, this.mCursor);
        return r11;
    L11:
        throw new IllegalStateException("couldn't move cursor to position " + r10);
    L13:
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    void init(Context r10, Cursor r11, int r12) {
        boolean r13 = false;
        if ((r12 & 1) != 1) goto L5;
        r12 = r12 | 2;
        this.mAutoRequery = true;
    L6:
        if (r11 == null) goto L8;
        r13 = true;
    L8:
        this.mCursor = r11;
        this.mDataValid = r13;
        this.mContext = r10;
        if (r13 == false) goto L11;
        int r14 = r11.getColumnIndexOrThrow("_id");
    L12:
        this.mRowIDColumn = r14;
        if ((r12 & 2) != 2) goto L15;
        this.mChangeObserver = new ChangeObserver(this);
        MyDataSetObserver r15 = new MyDataSetObserver(this);
    L16:
        this.mDataSetObserver = r15;
        if (r13 == false) goto L25;
        ChangeObserver r16 = this.mChangeObserver;
        if (r16 == null) goto L21;
        r11.registerContentObserver(r16);
    L21:
        DataSetObserver r17 = this.mDataSetObserver;
        if (r17 == null) goto L26;
        r11.registerDataSetObserver(r17);
        return;
    L26:
        return;
    L25:
        return;
    L15:
        r15 = null;
        this.mChangeObserver = null;
        goto L16
    L11:
        r14 = -1;
        goto L12
    L5:
        this.mAutoRequery = false;
        goto L6
    }

    @Deprecated
    protected void init(Context r10, Cursor r11, boolean r12) {
        if (r12 == false) goto L4;
        int r13 = 1;
    L5:
        init(r10, r11, r13);
        return;
    L4:
        r13 = 2;
        goto L5
    }

    public View newDropDownView(Context r10, Cursor r11, ViewGroup r12) {
        return newView(r10, r11, r12);
    }

    public abstract View newView(Context r10, Cursor r11, ViewGroup r12);

    protected void onContentChanged() {
        if (this.mAutoRequery == false) goto L10;
        Cursor r10 = this.mCursor;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.isClosed() == true) goto L12;
        this.mDataValid = this.mCursor.requery();
        return;
    L12:
        return;
    }

    public Cursor runQueryOnBackgroundThread(CharSequence r10) {
        FilterQueryProvider r11 = this.mFilterQueryProvider;
        if (r11 == null) goto L7;
        return r11.runQuery(r10);
    L7:
        return this.mCursor;
    }

    public void setFilterQueryProvider(FilterQueryProvider r10) {
        this.mFilterQueryProvider = r10;
    }

    public Cursor swapCursor(Cursor r10) {
        Cursor r11 = this.mCursor;
        if (r10 != r11) goto L6;
        return null;
    L6:
        if (r11 == null) goto L13;
        ChangeObserver r12 = this.mChangeObserver;
        if (r12 == null) goto L10;
        r11.unregisterContentObserver(r12);
    L10:
        DataSetObserver r13 = this.mDataSetObserver;
        if (r13 == null) goto L13;
        r11.unregisterDataSetObserver(r13);
    L13:
        this.mCursor = r10;
        if (r10 == null) goto L22;
        ChangeObserver r14 = this.mChangeObserver;
        if (r14 == null) goto L18;
        r10.registerContentObserver(r14);
    L18:
        DataSetObserver r15 = this.mDataSetObserver;
        if (r15 == null) goto L21;
        r10.registerDataSetObserver(r15);
    L21:
        this.mRowIDColumn = r10.getColumnIndexOrThrow("_id");
        this.mDataValid = true;
        notifyDataSetChanged();
    L23:
        return r11;
    L22:
        this.mRowIDColumn = -1;
        this.mDataValid = false;
        notifyDataSetInvalidated();
        goto L23
    }
}
