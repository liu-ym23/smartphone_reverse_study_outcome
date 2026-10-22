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
    public ResourceCursorAdapter(Context r5, int r10, Cursor r11) {
        super(r5, r11);
        this.mDropDownLayout = r10;
        this.mLayout = r10;
        this.mInflater = (LayoutInflater) r5.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newDropDownView(Context r5, Cursor r10, ViewGroup r11) {
        return this.mInflater.inflate(this.mDropDownLayout, r11, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context r5, Cursor r10, ViewGroup r11) {
        return this.mInflater.inflate(this.mLayout, r11, false);
    }

    public void setDropDownViewResource(int r5) {
        this.mDropDownLayout = r5;
    }

    public void setViewResource(int r5) {
        this.mLayout = r5;
    }

    @Deprecated
    public ResourceCursorAdapter(Context r5, int r10, Cursor r11, boolean r12) {
        super(r5, r11, r12);
        this.mDropDownLayout = r10;
        this.mLayout = r10;
        this.mInflater = (LayoutInflater) r5.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context r5, int r10, Cursor r11, int r12) {
        super(r5, r11, r12);
        this.mDropDownLayout = r10;
        this.mLayout = r10;
        this.mInflater = (LayoutInflater) r5.getSystemService("layout_inflater");
    }
}
