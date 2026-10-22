package bm8;

import com.larus.bmhome.chat.api.r;
import com.larus.bmhome.chat.layout.widget.AppletWidget;
import com.larus.bmhome.chat.standarduikit.markdown.view.MarkdownAppletContainer;
import ic8.y;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h implements ue8.d {
    public Function0<Unit> a;
    public final e b;
    public final /* synthetic */ MarkdownAppletContainer c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public static final class a extends y {
        public final /* synthetic */ MarkdownAppletContainer a;
        public final /* synthetic */ h b;

        public final void c() {
            AppletWidget r0 = this.a.a;
            if (r0 == null) goto L5;
            Intrinsics.checkNotNullParameter(this, "observer");
            r0.r.remove(this);
        L5:
            this.b.a.invoke();
        }

        public a(MarkdownAppletContainer r1, h r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.b.invoke();
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        final MarkdownAppletContainer r5 = this.c;
        final String r0 = this.d;
        final String r1 = this.e;
        this.a = new f(r5, r0, r1);
        AppletWidget r6 = r5.a;
        if (r6 == null) goto L5;
        r r7 = r6.getWidgetContainer();
    L6:
        if (r7 == null) goto L8;
        this.a.invoke();
        return;
    L8:
        MarkdownAppletContainer r8 = this.c;
        AppletWidget r2 = r8.a;
        if (r2 == null) goto L15;
        a r3 = new a(r8, this);
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (r2.r.contains(r3) == true) goto L16;
        r2.r.add(r3);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r7 = null;
        goto L6
    }

    public h(MarkdownAppletContainer r2, String r3, String r4) {
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = new d();
        this.b = new e(this, r2, r3, r4);
    }
}
