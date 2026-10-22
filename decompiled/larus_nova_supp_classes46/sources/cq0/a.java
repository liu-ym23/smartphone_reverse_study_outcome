package cq0;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {

    /* JADX INFO: renamed from: cq0.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0194a implements View.OnClickListener {
        public final /* synthetic */ Ref.IntRef a;
        public final /* synthetic */ Ref.LongRef b;
        public final /* synthetic */ Function1 c;

        public ViewOnClickListenerC0194a(Ref.IntRef r1, Ref.LongRef r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            long r0 = System.currentTimeMillis();
            Ref.LongRef r2 = this.b;
            if ((r0 - r2.element) < this.a.element) goto L6;
            r2.element = r0;
            this.c.invoke(r9);
            return;
        }
    }

    public static final void a(View r3, Function1<? super View, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$setOnSingleClickListener");
        Intrinsics.checkNotNullParameter(r4, "onClick");
        Ref.LongRef r0 = new Ref.LongRef();
        r0.element = 0;
        Ref.IntRef r1 = new Ref.IntRef();
        r1.element = 500;
        r3.setOnClickListener(new ViewOnClickListenerC0194a(r1, r0, r4));
    }
}
