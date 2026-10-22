package androidx.cursoradapter.widget;

import ai.j0;
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

    public class ChangeObserver extends ContentObserver {
        final /* synthetic */ CursorAdapter this$0;

        public ChangeObserver(CursorAdapter r5) {
            this.this$0 = r5;
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r5) {
            this.this$0.onContentChanged();
        }
    }

    public class MyDataSetObserver extends DataSetObserver {
        final /* synthetic */ CursorAdapter this$0;

        public MyDataSetObserver(CursorAdapter r5) {
            this.this$0 = r5;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CursorAdapter r5 = this.this$0;
            r5.mDataValid = true;
            r5.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            CursorAdapter r5 = this.this$0;
            r5.mDataValid = false;
            r5.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public CursorAdapter(Context r5, Cursor r10) {
        init(r5, r10, 1);
    }

    public abstract void bindView(View r5, Context r10, Cursor r11);

    public void changeCursor(Cursor r5) {
        Cursor r10 = swapCursor(r5);
        if (r10 == null) goto L6;
        r10.close();
        return;
    }

    public CharSequence convertToString(Cursor r5) {
        if (r5 != null) goto L5;
        return "";
    L5:
        return r5.toString();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mDataValid == false) goto L8;
        Cursor r5 = this.mCursor;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getCount();
    L8:
        return 0;
    }

    @Override // androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor getCursor() {
        return this.mCursor;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int r5, View r10, ViewGroup r11) {
        if (this.mDataValid == false) goto L9;
        this.mCursor.moveToPosition(r5);
        if (r10 != null) goto L7;
        r10 = newDropDownView(this.mContext, this.mCursor, r11);
    L7:
        bindView(r10, this.mContext, this.mCursor);
        return r10;
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
    public Object getItem(int r5) {
        if (this.mDataValid == false) goto L8;
        Cursor r10 = this.mCursor;
        if (r10 == null) goto L10;
        r10.moveToPosition(r5);
        return this.mCursor;
    L10:
        return null;
    L8:
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int r5) {
        if (this.mDataValid == false) goto L10;
        Cursor r10 = this.mCursor;
        if (r10 == null) goto L10;
        if (r10.moveToPosition(r5) == false) goto L10;
        return this.mCursor.getLong(this.mRowIDColumn);
    L10:
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int r5, View r10, ViewGroup r11) {
        if (this.mDataValid == false) goto L13;
        if (this.mCursor.moveToPosition(r5) == false) goto L11;
        if (r10 != null) goto L8;
        r10 = newView(this.mContext, this.mCursor, r11);
    L8:
        bindView(r10, this.mContext, this.mCursor);
        return r10;
    L11:
        throw new IllegalStateException(j0.g(r5, "couldn't move cursor to position "));
    L13:
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Deprecated
    public void init(Context r5, Cursor r10, boolean r11) {
        if (r11 == false) goto L4;
        int r12 = 1;
    L5:
        init(r5, r10, r12);
        return;
    L4:
        r12 = 2;
        goto L5
    }

    public View newDropDownView(Context r5, Cursor r10, ViewGroup r11) {
        return newView(r5, r10, r11);
    }

    public abstract View newView(Context r5, Cursor r10, ViewGroup r11);

    public void onContentChanged() {
        if (this.mAutoRequery == false) goto L10;
        Cursor r5 = this.mCursor;
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.isClosed() == true) goto L12;
        this.mDataValid = this.mCursor.requery();
        return;
    L12:
        return;
    }

    public Cursor runQueryOnBackgroundThread(CharSequence r5) {
        FilterQueryProvider r10 = this.mFilterQueryProvider;
        if (r10 == null) goto L7;
        return r10.runQuery(r5);
    L7:
        return this.mCursor;
    }

    public void setFilterQueryProvider(FilterQueryProvider r5) {
        this.mFilterQueryProvider = r5;
    }

    public Cursor swapCursor(Cursor r5) {
        Cursor r10 = this.mCursor;
        if (r5 != r10) goto L6;
        return null;
    L6:
        if (r10 == null) goto L13;
        ChangeObserver r11 = this.mChangeObserver;
        if (r11 == null) goto L10;
        r10.unregisterContentObserver(r11);
    L10:
        DataSetObserver r12 = this.mDataSetObserver;
        if (r12 == null) goto L13;
        r10.unregisterDataSetObserver(r12);
    L13:
        this.mCursor = r5;
        if (r5 == null) goto L22;
        ChangeObserver r13 = this.mChangeObserver;
        if (r13 == null) goto L18;
        r5.registerContentObserver(r13);
    L18:
        DataSetObserver r14 = this.mDataSetObserver;
        if (r14 == null) goto L21;
        r5.registerDataSetObserver(r14);
    L21:
        this.mRowIDColumn = r5.getColumnIndexOrThrow("_id");
        this.mDataValid = true;
        notifyDataSetChanged();
    L23:
        return r10;
    L22:
        this.mRowIDColumn = -1;
        this.mDataValid = false;
        notifyDataSetInvalidated();
        goto L23
    }

    public void init(Context r5, Cursor r10, int r11) {
        boolean r12 = false;
        if ((r11 & 1) != 1) goto L5;
        r11 = r11 | 2;
        this.mAutoRequery = true;
    L6:
        if (r10 == null) goto L8;
        r12 = true;
    L8:
        this.mCursor = r10;
        this.mDataValid = r12;
        this.mContext = r5;
        if (r12 == false) goto L11;
        int r13 = r10.getColumnIndexOrThrow("_id");
    L12:
        this.mRowIDColumn = r13;
        if ((r11 & 2) != 2) goto L15;
        this.mChangeObserver = new ChangeObserver(this);
        this.mDataSetObserver = new MyDataSetObserver(this);
    L16:
        if (r12 == false) goto L24;
        ChangeObserver r14 = this.mChangeObserver;
        if (r14 == null) goto L20;
        r10.registerContentObserver(r14);
    L20:
        DataSetObserver r15 = this.mDataSetObserver;
        if (r15 == null) goto L25;
        r10.registerDataSetObserver(r15);
        return;
    L25:
        return;
    L24:
        return;
    L15:
        this.mChangeObserver = null;
        this.mDataSetObserver = null;
        goto L16
    L11:
        r13 = -1;
        goto L12
    L5:
        this.mAutoRequery = false;
        goto L6
    }

    public CursorAdapter(Context r5, Cursor r10, boolean r11) {
        if (r11 == false) goto L5;
        int r12 = 1;
    L6:
        init(r5, r10, r12);
        return;
    L5:
        r12 = 2;
        goto L6
    }

    public CursorAdapter(Context r5, Cursor r10, int r11) {
        init(r5, r10, r11);
    }
}
