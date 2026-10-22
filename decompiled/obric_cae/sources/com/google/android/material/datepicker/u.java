package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class u<S> extends z<S> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4727b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public DateSelector<S> f4728m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CalendarConstraints f4729n;

    public class a extends y<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f4730a;

        public a(u r8) {
            this.f4730a = r8;
        }

        @Override // com.google.android.material.datepicker.y
        public final void a() {
            Iterator<y<S>> r8 = this.f4730a.f4748a.iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            r8.next().a();
            goto L4
        }

        @Override // com.google.android.material.datepicker.y
        public final void b(S r8) {
            Iterator<y<S>> r10 = this.f4730a.f4748a.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            r10.next().b(r8);
            goto L4
        }
    }

    public u() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        if (r8 != null) goto L5;
        r8 = getArguments();
    L5:
        this.f4727b = r8.getInt("THEME_RES_ID_KEY");
        this.f4728m = (DateSelector) r8.getParcelable("DATE_SELECTOR_KEY");
        this.f4729n = (CalendarConstraints) r8.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r8, ViewGroup r10, Bundle r11) {
        LayoutInflater r12 = r8.cloneInContext(new ContextThemeWrapper(getContext(), this.f4727b));
        return this.f4728m.f(r12, r10, this.f4729n, new a(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r8) {
        super.onSaveInstanceState(r8);
        r8.putInt("THEME_RES_ID_KEY", this.f4727b);
        r8.putParcelable("DATE_SELECTOR_KEY", this.f4728m);
        r8.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f4729n);
    }
}
