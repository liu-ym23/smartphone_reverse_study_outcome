package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public class SimpleCursorAdapter extends ResourceCursorAdapter {
    private CursorToStringConverter mCursorToStringConverter;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int[] mFrom;
    String[] mOriginalFrom;
    private int mStringConversionColumn;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int[] mTo;
    private ViewBinder mViewBinder;

    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor r5);
    }

    public interface ViewBinder {
        boolean setViewValue(View r5, Cursor r10, int r11);
    }

    @Deprecated
    public SimpleCursorAdapter(Context r5, int r10, Cursor r11, String[] r12, int[] r13) {
        super(r5, r10, r11);
        this.mStringConversionColumn = -1;
        this.mTo = r13;
        this.mOriginalFrom = r12;
        findColumns(r11, r12);
    }

    private void findColumns(Cursor r5, String[] r10) {
        if (r5 == null) goto L11;
        int r11 = r10.length;
        int[] r12 = this.mFrom;
        if (r12 != null) goto L6;
    L7:
        this.mFrom = new int[r11];
    L8:
        int r13 = 0;
    L9:
        if (r13 >= r11) goto L14;
        this.mFrom[r13] = r5.getColumnIndexOrThrow(r10[r13]);
        r13 = r13 + 1;
        goto L9
    L14:
        return;
    L6:
        if (r12.length == r11) goto L8;
    L11:
        this.mFrom = null;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View r10, Context r11, Cursor r12) {
        ViewBinder r13 = this.mViewBinder;
        int[] r5 = this.mTo;
        int r14 = r5.length;
        int[] r15 = this.mFrom;
        int r16 = 0;
    L3:
        if (r16 >= r14) goto L22;
        View r17 = r10.findViewById(r5[r16]);
        if (r17 == null) goto L21;
        if (r13 == null) goto L8;
        boolean r18 = r13.setViewValue(r17, r12, r15[r16]);
    L9:
        if (r18 == true) goto L21;
        String r19 = r12.getString(r15[r16]);
        if (r19 != null) goto L14;
        r19 = "";
    L14:
        if ((r17 instanceof TextView) == false) goto L17;
        setViewText((TextView) r17, r19);
        goto L21
    L17:
        if ((r17 instanceof ImageView) == false) goto L20;
        setViewImage((ImageView) r17, r19);
        goto L21
    L20:
        throw new IllegalStateException(r17.getClass().getName().concat(" is not a  view that can be bounds by this SimpleCursorAdapter"));
    L8:
        r18 = false;
    L21:
        r16 = r16 + 1;
        goto L3
    }

    public void changeCursorAndColumns(Cursor r5, String[] r10, int[] r11) {
        this.mOriginalFrom = r10;
        this.mTo = r11;
        findColumns(r5, r10);
        super.changeCursor(r5);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor r5) {
        CursorToStringConverter r10 = this.mCursorToStringConverter;
        if (r10 != null) goto L5;
        int r11 = this.mStringConversionColumn;
        if (r11 <= (-1)) goto L11;
        return r5.getString(r11);
    L11:
        return super.convertToString(r5);
    L5:
        return r10.convertToString(r5);
    }

    public CursorToStringConverter getCursorToStringConverter() {
        return this.mCursorToStringConverter;
    }

    public int getStringConversionColumn() {
        return this.mStringConversionColumn;
    }

    public ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    public void setCursorToStringConverter(CursorToStringConverter r5) {
        this.mCursorToStringConverter = r5;
    }

    public void setStringConversionColumn(int r5) {
        this.mStringConversionColumn = r5;
    }

    public void setViewBinder(ViewBinder r5) {
        this.mViewBinder = r5;
    }

    public void setViewImage(ImageView r5, String r10) {
        r5.setImageResource(Integer.parseInt(r10));     // Catch: NumberFormatException -> L4
        return;
    L4:
        r5.setImageURI(Uri.parse(r10));
    }

    public void setViewText(TextView r5, String r10) {
        r5.setText(r10);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public Cursor swapCursor(Cursor r5) {
        findColumns(r5, this.mOriginalFrom);
        return super.swapCursor(r5);
    }

    public SimpleCursorAdapter(Context r5, int r10, Cursor r11, String[] r12, int[] r13, int r14) {
        super(r5, r10, r11, r14);
        this.mStringConversionColumn = -1;
        this.mTo = r13;
        this.mOriginalFrom = r12;
        findColumns(r11, r12);
    }
}
