package tt0;

import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ k b;
    public final /* synthetic */ String c;

    /* JADX INFO: renamed from: tt0.a$a, reason: collision with other inner class name */
    public static final class C0318a implements a3.b {
        public final /* synthetic */ a a;

        public final void onFail() {
        }

        public C0318a(a r1) {
            this.a = r1;
        }

        public final void a(NinePatchDrawable r2) {
            Intrinsics.checkNotNullParameter(r2, "ninePatchDrawable");
            View r3 = this.a.a.a;
            if (r3 == null) goto L7;
            ViewGroup.LayoutParams r4 = r3.getLayoutParams();
            if (r4 == null) goto L7;
            r4.height = s1.f(16.0f);
        L7:
            a r5 = this.a;
            TextView r0 = r5.a.b;
            if (r0 == null) goto L15;
            String r6 = r5.c;
            if (r6 != null) goto L13;
            r6 = "";
        L13:
            r0.setText(r6);
            return;
        }
    }

    public a(b r1, k r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k r0 = this.b;     // Catch: Throwable -> L7
        if (r0 == null) goto L10;
        int r1 = a3.d;     // Catch: Throwable -> L7
        a3.a.a(this.a.a, r0, new C0318a(this), 0.0f);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }
}
