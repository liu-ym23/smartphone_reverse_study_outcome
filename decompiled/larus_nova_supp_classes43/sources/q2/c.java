package q2;

import com.bytedance.ai.applet.render.core.lynx.o;
import com.bytedance.ai.lynx.AppletLynxViewApi;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.ai.utils.g;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.TemplateBundle;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class c extends o {
    public String a;
    public final boolean b;
    public final String c;
    public final String d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.render.core.lynx.o
    public final String c(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        AppletResourceTool r0 = AppletResourceTool.a;
        String r1 = this.a;
        h2.a r11 = f2.b.c;
        if (r11 == null) goto L6;
        String r12 = r11.m;
        if (r12 == null) goto L6;
    L7:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r12, "bid");
        return IIvyAIPackageResourceService.a.d(r1, r10, r12);
    L6:
        r12 = "";
        goto L7
    }

    @Override // w2.d
    public Object a(String r10, Continuation<? super TemplateBundle> r11) {
        String r0 = UriProtector.getQueryParameter(UriProtector.parse(r10), "forest_session_id");
        if (r0 == null) goto L5;
        this.a = r0;
    L5:
        int r1 = AppletLynxViewApi.a;
        return AppletLynxViewApi.b(this.a, r10, this.b, this.c, this.d, r11);
    }

    @Override // com.bytedance.ai.applet.render.core.lynx.o
    public final void b(String r10, final Function1<? super byte[], Unit> r11, final Function1<? super Exception, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "onSuccess");
        Intrinsics.checkNotNullParameter(r12, "onFailure");
        boolean r13 = true;
        if (r10.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r12.invoke(new Exception("url is empty"));
        return;
    L9:
        g.a.i("DefaultLynxResourceLoader", "loadResourceAsync: start to load ".concat(r10));
        String r1 = this.c;
        if (r1 != null) goto L12;
    L15:
        if (r13 == true) goto L18;
        r10 = AppletResourceTool.a.g(r10, this.c);
    L18:
        AppletResourceTool r14 = AppletResourceTool.a;
        String r15 = this.a;
        Function1 r16 = new q2.a(r11, r12);
        Function1 r17 = new b(r12);
        r14.getClass();
        AppletResourceTool.q(r15, r10, r16, r17, false);
        return;
    L12:
        if (r1.length() == 0) goto L15;
        r13 = false;
        goto L15
    L5:
        r0 = false;
        goto L6
    }

    public c(String r10, boolean r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
    }
}
