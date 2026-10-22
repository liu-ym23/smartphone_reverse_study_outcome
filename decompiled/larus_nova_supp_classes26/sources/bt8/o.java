package bt8;

import android.view.View;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.KmpCommandWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o implements View.OnAttachStateChangeListener {
    public final /* synthetic */ KmpCommandWidget a;
    public final /* synthetic */ cq8.i b;
    public final /* synthetic */ com.larus.bmhome.actionbar.model.c c;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ KmpCommandWidget a;
        public final /* synthetic */ cq8.i b;
        public final /* synthetic */ com.larus.bmhome.actionbar.model.c c;

        public a(KmpCommandWidget r1, cq8.i r2, com.larus.bmhome.actionbar.model.c r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            KmpCommandWidget.Y5(this.a, this.b, this.c);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [android.view.View, com.larus.bmhome.view.actionbar.edit.kmp.widget.KmpCommandWidget] */
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r4) {
        Intrinsics.checkNotNullParameter(r4, "v");
        this.a.removeOnAttachStateChangeListener(this);
        ?? r5 = this.a;
        cq8.i r0 = this.b;
        com.larus.bmhome.actionbar.model.c r1 = this.c;
        if (r5.isLaidOut() == true) goto L5;
    L7:
        r5.addOnLayoutChangeListener(new a(r5, r0, r1));
        return;
    L5:
        if (r5.isLayoutRequested() == true) goto L7;
        KmpCommandWidget.Y5(r5, r0, r1);
    }

    public o(KmpCommandWidget r1, cq8.i r2, com.larus.bmhome.actionbar.model.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
