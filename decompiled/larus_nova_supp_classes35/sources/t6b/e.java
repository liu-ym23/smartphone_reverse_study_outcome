package t6b;

import com.ss.android.lark.biz.im.api.m1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class e implements s6b.b<e, f> {
    public final m1 a;
    public final List<b<?>> b;

    public interface a {
    }

    public interface b<Event extends a> {
        Class<Event> getEventType();

        void onEvent(Event r1);
    }

    public e() {
        this(null, null, null);
    }

    public jya.b d() {
        return null;
    }

    @Override // s6b.b
    public final s6b.b a() {
        return new f(this);
    }

    public List<b<?>> c() {
        return this.b;
    }

    public m1 e() {
        return this.a;
    }

    @Override // s6b.b
    public final s6b.b b(s6b.b r4) {
        e r5 = (e) r4;
        Intrinsics.checkNotNullParameter(r5, "patch");
        return new e(r5.e(), r5.d(), r5.c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(m1 r1, jya.b r2, List<? extends b<?>> r3) {
        this.a = r1;
        this.b = r3;
    }
}
