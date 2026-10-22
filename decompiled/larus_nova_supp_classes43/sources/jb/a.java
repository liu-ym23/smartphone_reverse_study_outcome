package jb;

import android.view.View;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.core.BulletContext;
import h36.b;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements tz2.a {
    public final Function0<WeakReference<AnnieXWebModel>> a;

    public final void b(View r1, long r10) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends WeakReference<AnnieXWebModel>> r10) {
        Intrinsics.checkNotNullParameter(r10, "contextRefProvider");
        this.a = r10;
    }

    public final void a(View r10, int r11) {
        AnnieXWebModel r12 = (AnnieXWebModel) ((WeakReference) this.a.invoke()).get();
        if (r12 == null) goto L6;
        BulletContext r13 = r12.l;
        Regex r0 = b.a;
        b.b(r13, Integer.valueOf(2 - r11), null);
        return;
    }
}
