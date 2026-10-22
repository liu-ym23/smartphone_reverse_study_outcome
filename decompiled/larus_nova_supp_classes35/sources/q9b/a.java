package q9b;

import android.content.res.Configuration;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public Configuration a;
    public InterfaceC0281a b;

    /* JADX INFO: renamed from: q9b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0281a {
        void a();
    }

    public a(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.a = r2;
    }

    public final void a(Configuration r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r0 = r3.diff(this.a);
        if ((r0 & 256) == 0) goto L7;
    L8:
        InterfaceC0281a r1 = this.b;
        if (r1 == null) goto L11;
        r1.a();
    L11:
        this.a = new Configuration(r3);
        return;
    L7:
        if ((r0 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L11;
        goto L8
    }
}
