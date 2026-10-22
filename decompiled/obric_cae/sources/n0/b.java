package n0;

import android.database.Cursor;
import android.util.Log;
import android.widget.Filter;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.p0;

/* JADX INFO: loaded from: classes.dex */
public final class b extends Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f9415a;

    public interface a {
    }

    public b(a r8) {
        this.f9415a = r8;
    }

    @Override // android.widget.Filter
    public final CharSequence convertResultToString(Object r8) {
        p0 r10 = (p0) this.f9415a;
        return r10.d((Cursor) r8);
    }

    @Override // android.widget.Filter
    public final Filter.FilterResults performFiltering(CharSequence r8) {
        p0 r10 = (p0) this.f9415a;
        if (r8 != null) goto L5;
        String r11 = "";
    L6:
        SearchView r12 = r10.f1234u;
        if (r12.getVisibility() == 0) goto L9;
    L17:
        Cursor r13 = null;
    L18:
        Filter.FilterResults r14 = new Filter.FilterResults();
        if (r13 == null) goto L21;
        r14.count = r13.getCount();
        r14.values = r13;
    L22:
        return r14;
    L21:
        r14.count = 0;
        r14.values = null;
        goto L22
    L9:
        if (r12.getWindowVisibility() != 0) goto L17;
        r13 = r10.h(r10.f1235v, r11);     // Catch: RuntimeException -> L15
        if (r13 == null) goto L17;
        r13.getCount();     // Catch: RuntimeException -> L15
    L15:
        e = move-exception;
        Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        goto L17
    L5:
        r10.getClass();
        r11 = r8.toString();
        goto L6
    }

    @Override // android.widget.Filter
    public final void publishResults(CharSequence r8, Filter.FilterResults r10) {
        a r11 = this.f9415a;
        Cursor r12 = ((n0.a) r11).f9408m;
        Object r13 = r10.values;
        if (r13 == null) goto L7;
        if (r13 == r12) goto L8;
        p0 r14 = (p0) r11;
        r14.c((Cursor) r13);
        return;
    L8:
        return;
    }
}
