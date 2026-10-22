package w2b;

import android.text.Layout;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.h;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.TextLayoutCacheStoreImpl2;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.m;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements z2b.a {
    public final h a;
    public final TextLayoutCacheStoreImpl2 b;

    @Override // z2b.a
    public final void clearCache() {
        this.a.clearCache();
        this.b.clearCache();
    }

    public a() {
        this.a = new h();
        this.b = new TextLayoutCacheStoreImpl2();
    }

    @Override // z2b.a
    public final CharSequence b(z2b.b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "parseRequest");
        if ((r2 instanceof TextLayoutRender.e) == false) goto L7;
        return this.a.b(r2);
    L7:
        if ((r2 instanceof m) == true) goto L9;
        return null;
    L9:
        return this.b.b(r2);
    }

    @Override // z2b.a
    public final Layout c(z2b.b.InterfaceC0324b r2) {
        Intrinsics.checkNotNullParameter(r2, "renderRequest");
        if ((r2 instanceof TextLayoutRender.g) == false) goto L7;
        return this.a.c(r2);
    L7:
        if ((r2 instanceof p) == true) goto L9;
        return null;
    L9:
        return this.b.c(r2);
    }

    @Override // z2b.a
    public final void a(z2b.b.a r2, CharSequence r3) {
        Intrinsics.checkNotNullParameter(r2, "parseRequest");
        Intrinsics.checkNotNullParameter(r3, "charSequence");
        if ((r2 instanceof TextLayoutRender.e) == false) goto L7;
        this.a.a(r2, r3);
        return;
    L7:
        if ((r2 instanceof m) == false) goto L10;
        this.b.a(r2, r3);
        return;
    }

    @Override // z2b.a
    public final void d(z2b.b.InterfaceC0324b r2, Layout r3) {
        Intrinsics.checkNotNullParameter(r2, "renderRequest");
        Intrinsics.checkNotNullParameter(r3, "layout");
        if ((r2 instanceof TextLayoutRender.g) == false) goto L7;
        this.a.d(r2, r3);
        return;
    L7:
        if ((r2 instanceof p) == false) goto L10;
        this.b.d(r2, r3);
        return;
    }
}
