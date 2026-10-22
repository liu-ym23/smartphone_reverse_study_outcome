package lf6;

import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.artist.render.RenderRequest;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends c {
    public final C0245a b;

    /* JADX INFO: renamed from: lf6.a$a, reason: collision with other inner class name */
    public final class C0245a implements Function1<RenderEntity, Unit> {
        public float a;

        public C0245a() {
        }

        public final Object invoke(Object r2) {
            mf6.a r3 = ((RenderEntity) r2).i;
            if (r3 == null) goto L6;
            r3.a(this.a);
        L6:
            return Unit.INSTANCE;
        }
    }

    public a() {
        this.b = new C0245a();
    }

    @Override // lf6.c
    public final void b(RenderRequest r2, float r3) {
        C0245a r0 = this.b;
        r0.a = r3;
        r2.a(r0);
    }
}
