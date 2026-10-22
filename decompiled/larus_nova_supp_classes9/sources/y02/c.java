package y02;

import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends y02.b<EffectMessage> {
    public final List<EffectMessage> c;

    public static final class a {
    }

    public static final class b implements g<EffectMessage> {
        public final Iterator<EffectMessage> a;

        @Override // y02.g
        public final boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // y02.g
        public final EffectMessage next() {
            return this.a.next();
        }

        @Override // y02.g
        public final void remove() {
            this.a.remove();
        }

        public b(c r1) {
            this.a = ((ArrayList) r1.c).iterator();
        }
    }

    static {
    }

    @Override // y02.f
    public final int b() {
        return ((ArrayList) this.c).size();
    }

    @Override // y02.f
    public final void clear() {
        ((ArrayList) this.c).clear();
    }

    @Override // y02.f
    public final g<EffectMessage> iterator() {
        return new b(this);
    }

    @Override // y02.f
    public final Object pollFirst() {
        if (((ArrayList) this.c).size() != 0) goto L6;
        return null;
    L6:
        return (EffectMessage) ListProtector.remove(this.c, 0);
    }

    @Override // y02.f
    public final int size() {
        return ((ArrayList) this.c).size();
    }

    public c() {
        this.c = new ArrayList();
        Intrinsics.checkNotNullParameter("EffectMsgQueue", "<set-?>");
        this.b = "EffectMsgQueue";
    }

    @Override // y02.f
    public final void a(Function1<? super EffectMessage, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.invoke(r0.next());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // y02.f
    public final boolean d(NormalGiftMessage r2) {
        Intrinsics.checkNotNullParameter((EffectMessage) r2, "msg");
        return false;
    }

    @Override // y02.f
    public final void put(Object r2) {
        EffectMessage r3 = (EffectMessage) r2;
        Intrinsics.checkNotNullParameter(r3, "msg");
        ((ArrayList) this.c).add(r3);
        e();
    }

    @Override // y02.f
    public final void putFirst(Object r3) {
        EffectMessage r4 = (EffectMessage) r3;
        Intrinsics.checkNotNullParameter(r4, "msg");
        ListProtector.add(this.c, 0, r4);
        e();
    }
}
