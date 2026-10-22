package fh8;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public jh8.a A;
    public Function0<String> B;
    public Function0<String> C;
    public String a;
    public Message b;
    public String c;
    public String d;
    public String e;
    public String f;
    public LruSet<String> g;
    public Boolean h;
    public Function0<Unit> i;
    public String j;
    public Integer k;
    public Function0<? extends Fragment> l;
    public q0.a m;
    public AttachReceiver n;
    public RecyclerView.Adapter<?> o;
    public c p;
    public q0 q;
    public j r;
    public Function0<? extends Map<String, ? extends Object>> s;
    public bc8.b t;
    public Boolean u;
    public jh8.b v;
    public Integer w;
    public Function0<Integer> x;
    public Function1<? super Integer, Unit> y;
    public Function1<? super String, Unit> z;

    public final f a() {
        return new f(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.p, this.k, this.l, this.m, this.n, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C);
    }

    public g() {
        this.h = Boolean.FALSE;
    }
}
