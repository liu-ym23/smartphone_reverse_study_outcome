package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender;

import android.content.Context;
import android.text.Layout;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class TextLayoutRender extends com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.c {
    public static final /* synthetic */ int j = 0;
    public final v2b.a g;
    public final v2b.g h;
    public z2b.a i;

    public static abstract class a<V> {
        public final V a;
        public final Context b;
        public final com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b c;

        public final Context getContext() {
            return this.b;
        }

        public a(b<?, V> r2) {
            Intrinsics.checkNotNullParameter(r2, "builder");
            this.a = r2.a;
            this.b = r2.getContext();
            com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r3 = r2.c;
            if (r3 != null) goto L5;
            r3 = new com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b();
        L5:
            this.c = r3;
        }
    }

    public static abstract class b<O extends a<V>, V> {
        public final V a;
        public final Context b;
        public com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b c;

        public final Context getContext() {
            return this.b;
        }

        public b(V r2, Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
        @JvmStatic
        public static boolean a() {
            return FeatureGatingModule.getFeatureGatingService().isCurrentEnable("messenger.im.refactor_message_richtext");
        }
    }

    public static final class d extends b<e, RichText> {
        public d(Context r2, RichText r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "richText");
            super(r3, r2);
        }
    }

    public static final class e extends a<RichText> implements z2b.b.a {
        public final RichText d;

        public e(d r2) {
            Intrinsics.checkNotNullParameter(r2, "builder");
            super(r2);
            this.d = (RichText) this.a;
        }
    }

    public static final class f extends b<g, CharSequence> {
        public f(Context r2, CharSequence r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "text");
            super(r3, r2);
        }
    }

    public static final class g extends a<CharSequence> implements z2b.b.InterfaceC0324b {
        public final CharSequence d;

        public g(f r2) {
            Intrinsics.checkNotNullParameter(r2, "builder");
            super(r2);
            this.d = (CharSequence) this.a;
        }
    }

    static {
    }

    public TextLayoutRender() {
        this.g = new v2b.a();
        this.h = new v2b.g();
    }

    @Override // z2b.b
    public final CharSequence a(final z2b.b.a r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        e r0 = (e) r10;
        Function0<CharSequence> r1 = new TextLayoutRender$parse$parseAction$1(this, r10);
        z2b.a r2 = this.i;
        if (r2 == null) goto L5;
        e(r0.c.p);
        d(this.c);
        CharSequence r3 = r2.b(r10);
        if (r3 == null) goto L10;
        d(this.d);
        Log.d("TextLayoutRender", "parse, hit cache for message " + r0.c.p);
        return r3;
    L10:
        long r5 = System.currentTimeMillis();
        CharSequence r4 = (CharSequence) r1.invoke();
        long r7 = System.currentTimeMillis() - r5;
        if (this.a == false) goto L13;
        Log.i("TextLayoutRender", "parse, message " + r0.c.p + " , build charSequence, build charSequence cost " + r7 + " millis");
    L13:
        r2.a(r10, r4);
        return r4;
    L5:
        return (CharSequence) r1.invoke();
    }

    @Override // z2b.b
    public final Layout b(final z2b.b.InterfaceC0324b r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        g r0 = (g) r10;
        Function0<Layout> r1 = new TextLayoutRender$render$renderAction$1(this, r10);
        z2b.a r2 = this.i;
        if (r2 == null) goto L5;
        e(r0.c.p);
        d(this.e);
        Layout r3 = r2.c(r10);
        if (r3 == null) goto L10;
        d(this.f);
        Log.d("TextLayoutRender", "render, hit cache for message " + r0.c.p);
        return r3;
    L10:
        long r5 = System.currentTimeMillis();
        Layout r4 = (Layout) r1.invoke();
        if (r4 != null) goto L14;
        return null;
    L14:
        long r7 = System.currentTimeMillis() - r5;
        if (this.a == false) goto L17;
        Log.i("TextLayoutRender", "render, message " + r0.c.p + " not hit cache, build layout, build layout cost " + r7 + " millis");
    L17:
        r2.d(r10, r4);
        return r4;
    L5:
        return (Layout) r1.invoke();
    }

    public final void f(final z2b.a r3) {
        this.i = r3;
        v2b.a r0 = this.g;
        if ((r3 instanceof AbsTextLayoutCacheStore) == false) goto L5;
        Function1<Context, com.ss.android.lark.widget.light.viewstub.f> r1 = new TextLayoutRender$updateCacheStoreInner$1(r3);
    L6:
        r0.b = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }
}
