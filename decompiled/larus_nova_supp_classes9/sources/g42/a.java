package g42;

import android.content.Context;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a implements f {
    public final CompositeDisposable a;
    public c b;
    public final PinType c;

    /* JADX INFO: renamed from: g42.a$a, reason: collision with other inner class name */
    public static final class C0232a<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public C0232a(Function1 r1) {
            this.a = r1;
        }

        public final void accept(T r2) {
            this.a.invoke(r2);
        }
    }

    @Override // g42.f
    public boolean i(h<?> r2, HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "item");
        return false;
    }

    @Override // g42.f
    public final void onDestroy() {
        this.b = null;
        this.a.clear();
    }

    public final RoomContext r() {
        c r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDataContext();
    }

    @Override // g42.f
    public final PinType f() {
        return this.c;
    }

    @Override // g42.f
    public final void a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        Intrinsics.checkNotNullParameter(r2, "widget");
    }

    @Override // g42.f
    public final void d(g r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        Intrinsics.checkNotNullParameter(r2, "widget");
    }

    @Override // g42.f
    public void e(c r2) {
        Intrinsics.checkNotNullParameter(r2, "pinContainer");
        this.b = r2;
    }

    @Override // g42.f
    public e g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
        return null;
    }

    @Override // g42.f
    public final void h(com.bytedance.android.livesdk.interactivity.api.message.model.a r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // g42.f
    public String l(com.bytedance.android.livesdk.interactivity.api.message.model.a r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r3, "message");
        return String.valueOf(r3.P());
    }

    @Override // g42.f
    public final Long m(HighlightItem r5) {
        Intrinsics.checkNotNullParameter(r5, "item");
        return Long.valueOf(r5.getEndTime() - p6.b());
    }

    @Override // g42.f
    public void p(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public final boolean s(HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        if (r3.getDataType() == this.c.getDataType()) goto L5;
    L7:
        return false;
    L5:
        if (q(r3) == null) goto L7;
        return true;
    }

    public a(String r2, PinType r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "pinType");
        this.c = r3;
        this.a = new CompositeDisposable();
    }

    public final <T> void t(Class<T> r2, Function1<? super T, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventType");
        Intrinsics.checkNotNullParameter(r3, "onEvent");
        RxUtilKt.c(xs2.b.a().b(r2).subscribe(new C0232a(r3)), this.a);
    }
}
