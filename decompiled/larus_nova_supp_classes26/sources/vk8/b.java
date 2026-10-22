package vk8;

import android.content.Context;
import com.larus.bmhome.chat.block.base.renderer.FileCardVMData;
import com.larus.bmhome.chat.standarduikit.fileblock.view.FileCardView;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.common_ui.icon.CommonFileIconType;
import com.larus.utils.r;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import vl8.g;
import zk8.n;
import zk8.q;
import zk8.v;
import zk8.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final Context a;
    public final Lazy b;
    public final w c;

    public final Context getContext() {
        return this.a;
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new a(this));
        this.c = new w();
    }

    public final void a(FileCardVMData r24, lc8.a r25) {
        Intrinsics.checkNotNullParameter(r24, "vmData");
        w r3 = this.c;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r24, "vmData");
        r3.a = r24;
        r3.b = r25;
        w r2 = this.c;
        FileCardVMData r0 = r2.a;
        Integer r5 = null;
        if (r0 == null) goto L23;
        Long r1 = r0.g();
        if (r1 == null) goto L23;
        if (r1.longValue() <= 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L23;
        long r7 = r1.longValue();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L17
        Object r8 = Result.constructor-impl(r.p(r7));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r8) == false) goto L22;
        r8 = null;
    L22:
        String r9 = (String) r8;
    L25:
        if (r9 != null) goto L27;
        String r13 = "";
    L28:
        FileCardVMData r10 = r2.a;
        if (r10 == null) goto L31;
        Integer r11 = r10.h();
    L32:
        h19.b r12 = h19.b.a;
        CommonFileIconType r14 = CommonFileIconType.UNKNOWN;
        r12.getClass();
        int r15 = h19.b.a(r14);
        FileCardVMData r16 = r2.a;
        if (r16 == null) goto L38;
        String r17 = r16.e();
        if (r17 == null) goto L38;
        String r18 = r17;
    L39:
        FileCardVMData r19 = r2.a;
        if (r19 == null) goto L42;
        String r20 = r19.getType();
    L43:
        if (r20 != null) goto L45;
        r20 = "";
    L45:
        String r110 = r20.toUpperCase(Locale.ROOT);
        FileCardVMData r21 = r2.a;
        if (r21 != null) goto L48;
    L50:
        boolean r111 = false;
    L51:
        FileCardVMData r22 = r2.a;
        if (r22 != null) goto L54;
    L56:
        boolean r112 = false;
    L57:
        FileCardVMData r23 = r2.a;
        if (r23 != null) goto L60;
    L62:
        boolean r113 = false;
    L63:
        FileCardVMData r26 = r2.a;
        if (r26 == null) goto L66;
        String r27 = r26.t();
    L67:
        if (r27 != null) goto L69;
        String r114 = "";
    L70:
        FileCardVMData r28 = r2.a;
        if (r28 == null) goto L75;
        String r29 = r28.t();
        if (r29 == null) goto L75;
        int r30 = q.a;
        Intrinsics.checkNotNullParameter(r29, ShareType.URL);
        g r115 = n.a.c(r29);
    L76:
        FileCardVMData r31 = r2.a;
        if (r31 == null) goto L79;
        r5 = r31.o();
    L79:
        yk8.g r32 = new yk8.g(r11, r15, r18, r110, r111, r13, r112, r113, r114, r115, r5);
        w r33 = this.c;
        r33.getClass();
        ((FileCardView) this.b.getValue()).S5(r32, new v(r33));
        return;
    L75:
        r115 = new g(false, false, false, 0.0f, 15);
        goto L76
    L69:
        r114 = r27;
        goto L70
    L66:
        r27 = null;
        goto L67
    L60:
        if (r23.r() != true) goto L62;
        r113 = true;
        goto L63
    L54:
        if (r22.q() != true) goto L56;
        r112 = true;
        goto L57
    L48:
        if (r21.s() != true) goto L50;
        r111 = true;
        goto L51
    L42:
        r20 = null;
    L38:
        r18 = "";
        goto L39
    L31:
        r11 = null;
        goto L32
    L27:
        r13 = r9;
    L17:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L9:
        r6 = false;
    L23:
        r9 = null;
        goto L25
    }
}
