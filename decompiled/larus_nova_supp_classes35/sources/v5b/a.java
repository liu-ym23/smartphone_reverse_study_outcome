package v5b;

import com.ss.android.lark.chat.export.entity.message.Content;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a<T extends Content> {
    public final T a;

    public a(T r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        this.a = r2;
    }

    public String c(c<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return r2.g();
    }

    public boolean d(a<?> r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        T r1 = this.a;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.isContentSame(r3.a);
    }
}
