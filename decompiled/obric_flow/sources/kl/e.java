package kl;

import android.R;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f18666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f18667b;

    public e(g r5, Handler r10, View r11) {
        this.f18667b = r5;
        this.f18666a = r11;
        super(r10);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r5) {
        g r10 = this.f18667b;
        r10.f = new a(r10.f18672a);
        int r11 = r10.d.getPaddingBottom();
        int r12 = r10.d.getPaddingRight();
        FragmentActivity r13 = r10.f18672a;
        if (r13 != null) goto L5;
    L24:
        int r14 = r10.d.getPaddingTop();
        ViewGroup r15 = r10.d;
        if (r15 == null) goto L28;
        r15.setPadding(0, r14, r12, r11);
        return;
    L28:
        return;
    L5:
        if (r13.getContentResolver() == null) goto L24;
        int r16 = Settings.System.getInt(r10.f18672a.getContentResolver(), "navigationbar_is_min", 0);
        View r17 = this.f18666a;
        if (r16 != 1) goto L10;
        r17.setVisibility(8);
    L9:
        r11 = 0;
        r12 = 0;
        goto L24
    L10:
        r17.setVisibility(0);
        if (g.a(r10.f18674c.findViewById(R.id.content)) == true) goto L9;
        if (r10.f18675h != 0) goto L17;
        r10.f18675h = r10.f.f18655c;
    L17:
        if (r10.f18676i != 0) goto L19;
        r10.f18676i = r10.f.d;
    L19:
        r10.e.getClass();
        FrameLayout.LayoutParams r18 = (FrameLayout.LayoutParams) r17.getLayoutParams();
        if (r10.f.c() == false) goto L22;
        r18.gravity = 80;
        r18.height = r10.f18675h;
        r10.e.getClass();
        int r19 = r10.f18675h;
        int r20 = 0;
    L23:
        r17.setLayoutParams(r18);
        r11 = r19;
        r12 = r20;
        goto L24
    L22:
        r18.gravity = GravityCompat.END;
        r18.width = r10.f18676i;
        r10.e.getClass();
        r20 = r10.f18676i;
        r19 = 0;
        goto L23
    }
}
