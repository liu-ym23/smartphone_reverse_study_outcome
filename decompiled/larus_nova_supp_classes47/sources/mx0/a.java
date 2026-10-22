package mx0;

import com.bytedance.android.livesdkapi.service.RevMessageHub;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;
import u01.l;
import yh6.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final RevMessageHub a;

    public a(l r2) {
        Intrinsics.checkNotNullParameter(r2, "revMessageHub");
        this.a = r2;
    }

    public final Observable a(f r3) {
        Intrinsics.checkNotNullParameter(r3, "desc");
        return this.a.observe(r3.a, r3.getType().getType());
    }
}
