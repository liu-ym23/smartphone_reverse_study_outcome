package w2b;

import android.text.Layout;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.h;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.TextLayoutCacheStoreImpl2;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.TextLayoutRender2;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.m;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.p;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements z2b.b {
    public static final b d = null;
    public z2b.a a;
    public final TextLayoutRender b;
    public final TextLayoutRender2 c;

    public static final class a {
    }

    static {
        d = new b();
    }

    public b() {
        this.b = new TextLayoutRender();
        this.c = new TextLayoutRender2();
    }

    @Override // z2b.b
    public final CharSequence a(z2b.b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        if ((r2 instanceof TextLayoutRender.e) == false) goto L7;
        return this.b.a(r2);
    L7:
        if ((r2 instanceof m) == true) goto L9;
        return BuildConfig.FLAVOR;
    L9:
        return this.c.a(r2);
    }

    @Override // z2b.b
    public final Layout b(z2b.b.InterfaceC0324b r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        if ((r2 instanceof TextLayoutRender.g) == false) goto L7;
        return this.b.b(r2);
    L7:
        if ((r2 instanceof p) == true) goto L9;
        return null;
    L9:
        return this.c.b(r2);
    }

    public final void c(z2b.a r3) {
        this.a = r3;
        if ((r3 instanceof h) == false) goto L6;
        this.b.f(r3);
    L6:
        if ((r3 instanceof TextLayoutCacheStoreImpl2) == false) goto L9;
        this.c.g = r3;
    L9:
        if ((r3 instanceof w2b.a) == false) goto L12;
        w2b.a r4 = (w2b.a) r3;
        this.b.f(r4.a);
        TextLayoutRender2 r0 = this.c;
        r0.g = r4.b;
        return;
    }
}
