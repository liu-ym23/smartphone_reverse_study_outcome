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
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {

    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    protected boolean mAutoRequery;
    protected ChangeObserver mChangeObserver;
    protected Context mContext;
    protected Cursor mCursor;
    protected CursorFilter mCursorFilter;
    protected DataSetObserver mDataSetObserver;
    protected boolean mDataValid;
    protected FilterQueryProvider mFilterQueryProvider;
    protected int mRowIDColumn;

    private class ChangeObserver extends ContentObserver {
        final /* synthetic */ CursorAdapter this$0;

        ChangeObserver(CursorAdapter r1) {
            this.this$0 = r1;
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1) {
            this.this$0.onContentChanged();
        }
    }

    private class MyDataSetObserver extends DataSetObserver {
        final /* synthetic */ CursorAdapter this$0;

        MyDataSetObserver(CursorAdapter r1) {
            this.this$0 = r1;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.this$0.mDataValid = true;
            this.this$0.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.this$0.mDataValid = false;
            this.this$0.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public CursorAdapter(Context r3, Cursor r4) {
        init((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin"), 1);
    }

    public CursorAdapter(Context r3, Cursor r4, int r5) {
        init((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin"), r5);
    }

    public CursorAdapter(Context r3, Cursor r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Cursor r7 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin");
        if (r5 == false) goto L5;
        int r8 = 1;
    L6:
        init(r6, r7, r8);
        return;
    L5:
        r8 = 2;
        goto L6
    }

    public abstract void bindView(View r1, Context r2, Cursor r3);

    public void changeCursor(Cursor r3) {
        Cursor r2 = swapCursor((Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L6;
        r2.close();
        return;
    }

    public CharSequence convertToString(Cursor r2) {
        Cursor r1 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1.toString();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mDataValid == false) goto L8;
        Cursor r1 = this.mCursor;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.getCount();
    L8:
        return 0;
    }

    @Override // androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor getCursor() {
        return this.mCursor;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int r2, View r3, ViewGroup r4) {
        if (this.mDataValid == false) goto L9;
        this.mCursor.moveToPosition(r2);
        if (r3 != null) goto L7;
        r3 = newDropDownView(this.mContext, this.mCursor, r4);
    L7:
        bindView(r3, this.mContext, this.mCursor);
        return r3;
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
    public Object getItem(int r2) {
        if (this.mDataValid == false) goto L8;
        Cursor r0 = this.mCursor;
        if (r0 == null) goto L10;
        r0.moveToPosition(r2);
        return this.mCursor;
    L10:
        return null;
    L8:
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int r4) {
        if (this.mDataValid == false) goto L10;
        Cursor r0 = this.mCursor;
        if (r0 == null) goto L10;
        if (r0.moveToPosition(r4) == false) goto L10;
        return this.mCursor.getLong(this.mRowIDColumn);
    L10:
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int r2, View r3, ViewGroup r4) {
        if (this.mDataValid == false) goto L13;
        if (this.mCursor.moveToPosition(r2) == false) goto L11;
        if (r3 != null) goto L8;
        r3 = newView(this.mContext, this.mCursor, r4);
    L8:
        bindView(r3, this.mContext, this.mCursor);
        return r3;
    L11:
        throw new IllegalStateException("couldn't move cursor to position " + r2);
    L13:
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    void init(Context r5, Cursor r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Cursor r9 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r6, Cursor.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if ((r7 & 1) != 1) goto L5;
        r7 = r7 | 2;
        this.mAutoRequery = true;
    L6:
        if (r9 == null) goto L8;
        r2 = true;
    L8:
        this.mCursor = r9;
        this.mDataValid = r2;
        this.mContext = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        if (r2 == false) goto L11;
        int r10 = r9.getColumnIndexOrThrow("_id");
    L12:
        this.mRowIDColumn = r10;
        if ((r7 & 2) != 2) goto L15;
        this.mChangeObserver = new ChangeObserver(this);
        MyDataSetObserver r11 = new MyDataSetObserver(this);
    L16:
        this.mDataSetObserver = r11;
        if (r2 == false) goto L25;
        ChangeObserver r12 = this.mChangeObserver;
        if (r12 == null) goto L21;
        r9.registerContentObserver(r12);
    L21:
        DataSetObserver r4 = this.mDataSetObserver;
        if (r4 == null) goto L26;
        r9.registerDataSetObserver(r4);
        return;
    L26:
        return;
    L25:
        return;
    L15:
        r11 = null;
        this.mChangeObserver = null;
        goto L16
    L11:
        r10 = -1;
        goto L12
    L5:
        this.mAutoRequery = false;
        goto L6
    }

    @Deprecated
    public void init(Context r3, Cursor r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Cursor r7 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin");
        if (r5 == false) goto L5;
        int r8 = 1;
    L6:
        init(r6, r7, r8);
        return;
    L5:
        r8 = 2;
        goto L6
    }

    public View newDropDownView(Context r3, Cursor r4, ViewGroup r5) {
        return newView((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin"), r5);
    }

    public abstract View newView(Context r1, Cursor r2, ViewGroup r3);

    public void onContentChanged() {
        if (this.mAutoRequery == false) goto L10;
        Cursor r0 = this.mCursor;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isClosed() == true) goto L12;
        this.mDataValid = this.mCursor.requery();
        return;
    L12:
        return;
    }

    public Cursor runQueryOnBackgroundThread(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        FilterQueryProvider r0 = this.mFilterQueryProvider;
        if (r0 == null) goto L7;
        return r0.runQuery(r4);
    L7:
        return this.mCursor;
    }

    public void setFilterQueryProvider(FilterQueryProvider r3) {
        this.mFilterQueryProvider = (FilterQueryProvider) ZeusTransformUtils.wrapperContextForParams(r3, FilterQueryProvider.class, "com.obric.memorydata.plugin");
    }

    public Cursor swapCursor(Cursor r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        Cursor r0 = this.mCursor;
        if (r4 != r0) goto L6;
        return null;
    L6:
        if (r0 == null) goto L13;
        ChangeObserver r1 = this.mChangeObserver;
        if (r1 == null) goto L10;
        r0.unregisterContentObserver(r1);
    L10:
        DataSetObserver r2 = this.mDataSetObserver;
        if (r2 == null) goto L13;
        r0.unregisterDataSetObserver(r2);
    L13:
        this.mCursor = r4;
        if (r4 == null) goto L22;
        ChangeObserver r5 = this.mChangeObserver;
        if (r5 == null) goto L18;
        r4.registerContentObserver(r5);
    L18:
        DataSetObserver r6 = this.mDataSetObserver;
        if (r6 == null) goto L21;
        r4.registerDataSetObserver(r6);
    L21:
        this.mRowIDColumn = r4.getColumnIndexOrThrow("_id");
        this.mDataValid = true;
        notifyDataSetChanged();
    L23:
        return r0;
    L22:
        this.mRowIDColumn = -1;
        this.mDataValid = false;
        notifyDataSetInvalidated();
        goto L23
    }
}
