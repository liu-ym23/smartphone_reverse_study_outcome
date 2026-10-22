package f1;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import com.obric.cae.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class u extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f7299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f7300b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ View f7301m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ v f7302n;

    public u(v r8, ViewGroup r10, View r11, View r12) {
        this.f7302n = r8;
        this.f7299a = r10;
        this.f7300b = r11;
        this.f7301m = r12;
    }

    @Override // f1.k, f1.h.d
    public final void a() {
        ((ViewGroupOverlay) new androidx.lifecycle.s(this.f7299a).f2194b).remove(this.f7300b);
    }

    @Override // f1.k, f1.h.d
    public final void c() {
        View r8 = this.f7300b;
        if (r8.getParent() != null) goto L5;
        ((ViewGroupOverlay) new androidx.lifecycle.s(this.f7299a).f2194b).add(r8);
        return;
    L5:
        v r10 = this.f7302n;
        ArrayList<Animator> r11 = r10.f7274w;
        int r12 = r11.size();
    L6:
        r12 = r12 - 1;
        if (r12 < 0) goto L9;
        r11.get(r12).cancel();
        goto L6
    L9:
        ArrayList<h.d> r13 = r10.A;
        if (r13 != null) goto L12;
        return;
    L12:
        if (r13.size() <= 0) goto L20;
        ArrayList r14 = (ArrayList) r10.A.clone();
        int r15 = r14.size();
        int r16 = 0;
    L14:
        if (r16 >= r15) goto L21;
        ((h.d) r14.get(r16)).b();
        r16 = r16 + 1;
        goto L14
    L21:
        return;
    }

    @Override // f1.h.d
    public final void d(h r8) {
        this.f7301m.setTag(R.id.save_overlay_view, null);
        ((ViewGroupOverlay) new androidx.lifecycle.s(this.f7299a).f2194b).remove(this.f7300b);
        r8.v(this);
    }
}
