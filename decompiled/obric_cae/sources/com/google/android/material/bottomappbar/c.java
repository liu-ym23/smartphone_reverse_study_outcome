package com.google.android.material.bottomappbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes.dex */
public final class c extends FloatingActionButton.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f4392b;

    public class a extends FloatingActionButton.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f4393a;

        public a(c r8) {
            this.f4393a = r8;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
        public final void b() {
            BottomAppBar r8 = this.f4393a.f4392b;
            int r10 = BottomAppBar.f4365q0;
            r8.getClass();
        }
    }

    public c(BottomAppBar r8, int r10) {
        this.f4392b = r8;
        this.f4391a = r10;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
    public final void a(FloatingActionButton r8) {
        r8.setTranslationX(this.f4392b.y(this.f4391a));
        r8.k(new a(this), true);
    }
}
