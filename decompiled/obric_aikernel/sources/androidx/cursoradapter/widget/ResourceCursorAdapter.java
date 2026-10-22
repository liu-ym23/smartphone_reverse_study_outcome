package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    @Deprecated
    public ResourceCursorAdapter(Context r10, int r11, Cursor r12) {
        super(r10, r12);
        this.mDropDownLayout = r11;
        this.mLayout = r11;
        this.mInflater = (LayoutInflater) r10.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context r10, int r11, Cursor r12, int r13) {
        super(r10, r12, r13);
        this.mDropDownLayout = r11;
        this.mLayout = r11;
        this.mInflater = (LayoutInflater) r10.getSystemService("layout_inflater");
    }

    @Deprecated
    public ResourceCursorAdapter(Context r10, int r11, Cursor r12, boolean r13) {
        super(r10, r12, r13);
        this.mDropDownLayout = r11;
        this.mLayout = r11;
        this.mInflater = (LayoutInflater) r10.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newDropDownView(Context r10, Cursor r11, ViewGroup r12) {
        return this.mInflater.inflate(this.mDropDownLayout, r12, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context r10, Cursor r11, ViewGroup r12) {
        return this.mInflater.inflate(this.mLayout, r12, false);
    }

    public void setDropDownViewResource(int r10) {
        this.mDropDownLayout = r10;
    }

    public void setViewResource(int r10) {
        this.mLayout = r10;
    }
}
