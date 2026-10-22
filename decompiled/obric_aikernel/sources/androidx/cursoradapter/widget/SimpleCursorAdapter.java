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
        CharSequence convertToString(Cursor r10);
    }

    public interface ViewBinder {
        boolean setViewValue(View r10, Cursor r11, int r12);
    }

    @Deprecated
    public SimpleCursorAdapter(Context r10, int r11, Cursor r12, String[] r13, int[] r14) {
        super(r10, r11, r12);
        this.mStringConversionColumn = -1;
        this.mTo = r14;
        this.mOriginalFrom = r13;
        findColumns(r12, r13);
    }

    public SimpleCursorAdapter(Context r10, int r11, Cursor r12, String[] r13, int[] r14, int r15) {
        super(r10, r11, r12, r15);
        this.mStringConversionColumn = -1;
        this.mTo = r14;
        this.mOriginalFrom = r13;
        findColumns(r12, r13);
    }

    private void findColumns(Cursor r10, String[] r11) {
        if (r10 == null) goto L11;
        int r12 = r11.length;
        int[] r13 = this.mFrom;
        if (r13 != null) goto L6;
    L7:
        this.mFrom = new int[r12];
    L8:
        int r14 = 0;
    L9:
        if (r14 >= r12) goto L14;
        this.mFrom[r14] = r10.getColumnIndexOrThrow(r11[r14]);
        r14 = r14 + 1;
        goto L9
    L14:
        return;
    L6:
        if (r13.length == r12) goto L8;
    L11:
        this.mFrom = null;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View r10, Context r11, Cursor r12) {
        ViewBinder r13 = this.mViewBinder;
        int[] r14 = this.mTo;
        int r15 = r14.length;
        int[] r16 = this.mFrom;
        int r17 = 0;
    L3:
        if (r17 >= r15) goto L22;
        View r18 = r10.findViewById(r14[r17]);
        if (r18 == null) goto L21;
        if (r13 == null) goto L8;
        boolean r19 = r13.setViewValue(r18, r12, r16[r17]);
    L9:
        if (r19 == true) goto L21;
        String r20 = r12.getString(r16[r17]);
        if (r20 != null) goto L14;
        r20 = "";
    L14:
        if ((r18 instanceof TextView) == false) goto L17;
        setViewText((TextView) r18, r20);
        goto L21
    L17:
        if ((r18 instanceof ImageView) == false) goto L20;
        setViewImage((ImageView) r18, r20);
        goto L21
    L20:
        throw new IllegalStateException(r18.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
    L8:
        r19 = false;
    L21:
        r17 = r17 + 1;
        goto L3
    }

    public void changeCursorAndColumns(Cursor r10, String[] r11, int[] r12) {
        this.mOriginalFrom = r11;
        this.mTo = r12;
        findColumns(r10, r11);
        super.changeCursor(r10);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor r10) {
        CursorToStringConverter r11 = this.mCursorToStringConverter;
        if (r11 != null) goto L5;
        int r12 = this.mStringConversionColumn;
        if (r12 <= (-1)) goto L11;
        return r10.getString(r12);
    L11:
        return super.convertToString(r10);
    L5:
        return r11.convertToString(r10);
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

    public void setCursorToStringConverter(CursorToStringConverter r10) {
        this.mCursorToStringConverter = r10;
    }

    public void setStringConversionColumn(int r10) {
        this.mStringConversionColumn = r10;
    }

    public void setViewBinder(ViewBinder r10) {
        this.mViewBinder = r10;
    }

    public void setViewImage(ImageView r10, String r11) {
        r10.setImageResource(Integer.parseInt(r11));     // Catch: NumberFormatException -> L4
        return;
    L4:
        r10.setImageURI(Uri.parse(r11));
    }

    public void setViewText(TextView r10, String r11) {
        r10.setText(r11);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public Cursor swapCursor(Cursor r10) {
        findColumns(r10, this.mOriginalFrom);
        return super.swapCursor(r10);
    }
}
