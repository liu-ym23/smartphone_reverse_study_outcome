package kh;

import androidx.room.f;
import com.bytedance.pia.core.metrics.PvEventType;
import com.bytedance.pia.core.utils.m;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements fh.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet f18643c;
    public boolean d;
    public final HashMap e;

    public c(String r5) {
        this.f18643c = new HashSet();
        this.d = false;
        this.e = new HashMap();
        this.f18642b = r5;
    }

    public final void a(PvEventType r5, Integer r10) {
        m.b(new f(this, 9, r5, r10));
    }

    public final void b(final int r5, final String r10, final String r11) {
        m.b(new a(this, r10, r5, r11));
    }

    public final void c() {
        m.b(new com.obric.oui.lisitem.a(this, 12));
    }

    @Override // fh.c
    public final void release() {
        c();
    }
}
