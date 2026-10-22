package zk8;

import android.content.Context;
import com.larus.bmhome.chat.block.base.renderer.FileCardVMData;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v implements yk8.h {
    public final /* synthetic */ w a;

    public v(w r1) {
        this.a = r1;
    }

    @Override // yk8.h
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        w r0 = this.a;
        FileCardVMData r1 = r0.a;
        if (r1 == null) goto L8;
        lc8.a r2 = r0.b;
        if (r2 == null) goto L9;
        r2.a(r3, r1);
        return;
    L9:
        return;
    }

    @Override // yk8.h
    public final void b(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        w r0 = this.a;
        FileCardVMData r1 = r0.a;
        if (r1 == null) goto L8;
        lc8.a r2 = r0.b;
        if (r2 == null) goto L9;
        r2.b(r3, r1);
        return;
    L9:
        return;
    }

    @Override // yk8.h
    public final void c(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        w r0 = this.a;
        FileCardVMData r1 = r0.a;
        if (r1 == null) goto L8;
        lc8.a r2 = r0.b;
        if (r2 == null) goto L9;
        r2.a(r3, r1);
        return;
    L9:
        return;
    }

    @Override // yk8.h
    public final void d(final Context r5, yk8.f r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "onStateChanged");
        FileCardVMData r2 = this.a.a;
        if (r2 == null) goto L12;
        int r3 = q.a;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r6, "onStateChanged");
        String r0 = r2.t();
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        if (StringsKt.isBlank(r0) == false) goto L10;
        FLogger.a.i("FileBlockAudioController", "playAudio failed, empty url, fileName=" + r2.e());
        y.c(new p(r5));
        return;
    L10:
        n.a.f(r5, r0, r6, new o(r5));
        return;
    }
}
