package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class SimpleCursorAdapter extends ResourceCursorAdapter {
    private CursorToStringConverter mCursorToStringConverter;
    protected int[] mFrom;
    String[] mOriginalFrom;
    private int mStringConversionColumn;
    protected int[] mTo;
    private ViewBinder mViewBinder;

    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor r1);
    }

    public interface ViewBinder {
        boolean setViewValue(View r1, Cursor r2, int r3);
    }

    @Deprecated
    public SimpleCursorAdapter(Context r3, int r4, Cursor r5, String[] r6, int[] r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Cursor r9 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.memorydata.plugin");
        super(r8, r4, r9);
        this.mStringConversionColumn = -1;
        this.mTo = r7;
        this.mOriginalFrom = r6;
        findColumns(r9, r6);
    }

    public SimpleCursorAdapter(Context r3, int r4, Cursor r5, String[] r6, int[] r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Cursor r10 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.memorydata.plugin");
        super(r9, r4, r10, r8);
        this.mStringConversionColumn = -1;
        this.mTo = r7;
        this.mOriginalFrom = r6;
        findColumns(r10, r6);
    }

    private void findColumns(Cursor r5, String[] r6) {
        Cursor r7 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L12;
        int r0 = r6.length;
        int[] r1 = this.mFrom;
        if (r1 != null) goto L7;
    L8:
        this.mFrom = new int[r0];
    L9:
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L15;
        this.mFrom[r2] = r7.getColumnIndexOrThrow(r6[r2]);
        r2 = r2 + 1;
        goto L10
    L15:
        return;
    L7:
        if (r1.length == r0) goto L9;
    L12:
        this.mFrom = null;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View r10, Context r11, Cursor r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Cursor r14 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r12, Cursor.class, "com.obric.memorydata.plugin");
        ViewBinder r15 = this.mViewBinder;
        int[] r0 = this.mTo;
        int r2 = r0.length;
        int[] r3 = this.mFrom;
        int r5 = 0;
    L3:
        if (r5 >= r2) goto L22;
        View r6 = r10.findViewById(r0[r5]);
        if (r6 == null) goto L21;
        if (r15 == null) goto L8;
        boolean r7 = r15.setViewValue(r6, r14, r3[r5]);
    L9:
        if (r7 == true) goto L21;
        String r8 = r14.getString(r3[r5]);
        if (r8 != null) goto L14;
        r8 = "";
    L14:
        if (ZeusTransformUtils.instanceOf(r6, TextView.class) == false) goto L17;
        setViewText((TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.memorydata.plugin"), r8);
        goto L21
    L17:
        if (ZeusTransformUtils.instanceOf(r6, ImageView.class) == false) goto L20;
        setViewImage((ImageView) ZeusTransformUtils.preCheckCast(r6, ImageView.class, "com.obric.memorydata.plugin"), r8);
        goto L21
    L20:
        throw new IllegalStateException(r6.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
    L8:
        r7 = false;
    L21:
        r5 = r5 + 1;
        goto L3
    }

    public void changeCursorAndColumns(Cursor r3, String[] r4, int[] r5) {
        Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        this.mOriginalFrom = r4;
        this.mTo = r5;
        findColumns(r6, r4);
        super.changeCursor(r6);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        CursorToStringConverter r0 = this.mCursorToStringConverter;
        if (r0 != null) goto L5;
        int r1 = this.mStringConversionColumn;
        if (r1 <= (-1)) goto L11;
        return r4.getString(r1);
    L11:
        return super.convertToString(r4);
    L5:
        return r0.convertToString(r4);
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

    public void setCursorToStringConverter(CursorToStringConverter r3) {
        this.mCursorToStringConverter = (CursorToStringConverter) ZeusTransformUtils.wrapperContextForParams(r3, CursorToStringConverter.class, "com.obric.memorydata.plugin");
    }

    public void setStringConversionColumn(int r1) {
        this.mStringConversionColumn = r1;
    }

    public void setViewBinder(ViewBinder r3) {
        this.mViewBinder = (ViewBinder) ZeusTransformUtils.wrapperContextForParams(r3, ViewBinder.class, "com.obric.memorydata.plugin");
    }

    public void setViewImage(ImageView r1, String r2) {
        r1.setImageResource(Integer.parseInt(r2));     // Catch: NumberFormatException -> L4
        return;
    L4:
        r1.setImageURI(Uri.parse(r2));
    }

    public void setViewText(TextView r1, String r2) {
        r1.setText(r2);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public Cursor swapCursor(Cursor r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        findColumns(r4, this.mOriginalFrom);
        return super.swapCursor(r4);
    }
}
