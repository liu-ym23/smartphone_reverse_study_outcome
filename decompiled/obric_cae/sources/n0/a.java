package n0;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, n0.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9407b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Cursor f9408m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f9409n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public C0117a f9410o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f9411p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public n0.b f9412q;

    /* JADX INFO: renamed from: n0.a$a, reason: collision with other inner class name */
    public class C0117a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f9413a;

        public C0117a(a r8) {
            this.f9413a = r8;
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public final boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r8) {
            a r10 = this.f9413a;
            if (r10.f9407b == false) goto L10;
            Cursor r11 = r10.f9408m;
            if (r11 != null) goto L7;
            return;
        L7:
            if (r11.isClosed() == true) goto L12;
            r10.f9406a = r10.f9408m.requery();
            return;
        L12:
            return;
        }
    }

    public class b extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f9414a;

        public b(a r8) {
            this.f9414a = r8;
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            a r8 = this.f9414a;
            r8.f9406a = true;
            r8.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            a r8 = this.f9414a;
            r8.f9406a = false;
            r8.notifyDataSetInvalidated();
        }
    }

    public a(Context r8) {
        this.f9407b = true;
        this.f9408m = null;
        this.f9406a = false;
        this.f9409n = -1;
        this.f9410o = new C0117a(this);
        this.f9411p = new b(this);
    }

    public abstract void b(View r8, Cursor r10);

    public void c(Cursor r8) {
        Cursor r10 = this.f9408m;
        if (r8 != r10) goto L5;
        r10 = null;
    L22:
        if (r10 == null) goto L25;
        r10.close();
        return;
    L25:
        return;
    L5:
        if (r10 == null) goto L12;
        C0117a r11 = this.f9410o;
        if (r11 == null) goto L9;
        r10.unregisterContentObserver(r11);
    L9:
        b r12 = this.f9411p;
        if (r12 == null) goto L12;
        r10.unregisterDataSetObserver(r12);
    L12:
        this.f9408m = r8;
        if (r8 == null) goto L21;
        C0117a r13 = this.f9410o;
        if (r13 == null) goto L17;
        r8.registerContentObserver(r13);
    L17:
        b r14 = this.f9411p;
        if (r14 == null) goto L20;
        r8.registerDataSetObserver(r14);
    L20:
        this.f9409n = r8.getColumnIndexOrThrow("_id");
        this.f9406a = true;
        notifyDataSetChanged();
        goto L22
    L21:
        this.f9409n = -1;
        this.f9406a = false;
        notifyDataSetInvalidated();
        goto L22
    }

    public abstract String d(Cursor r8);

    public abstract View e(ViewGroup r8);

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.f9406a == false) goto L8;
        Cursor r8 = this.f9408m;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return r8.getCount();
    L8:
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int r8, View r10, ViewGroup r11) {
        if (this.f9406a == false) goto L9;
        this.f9408m.moveToPosition(r8);
        if (r10 != null) goto L7;
        c r12 = (c) this;
        r10 = r12.f9418t.inflate(r12.f9417s, r11, false);
    L7:
        b(r10, this.f9408m);
        return r10;
    L9:
        return null;
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.f9412q != null) goto L6;
        this.f9412q = new n0.b(this);
    L6:
        return this.f9412q;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int r8) {
        if (this.f9406a == false) goto L8;
        Cursor r10 = this.f9408m;
        if (r10 == null) goto L10;
        r10.moveToPosition(r8);
        return this.f9408m;
    L10:
        return null;
    L8:
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int r8) {
        if (this.f9406a == false) goto L10;
        Cursor r10 = this.f9408m;
        if (r10 == null) goto L10;
        if (r10.moveToPosition(r8) == false) goto L10;
        return this.f9408m.getLong(this.f9409n);
    L10:
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int r8, View r10, ViewGroup r11) {
        if (this.f9406a == false) goto L13;
        if (this.f9408m.moveToPosition(r8) == false) goto L11;
        if (r10 != null) goto L8;
        r10 = e(r11);
    L8:
        b(r10, this.f9408m);
        return r10;
    L11:
        throw new IllegalStateException(defpackage.a.d("couldn't move cursor to position ", r8));
    L13:
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }
}
