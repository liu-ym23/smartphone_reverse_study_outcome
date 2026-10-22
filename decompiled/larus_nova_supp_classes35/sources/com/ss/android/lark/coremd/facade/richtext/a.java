package com.ss.android.lark.coremd.facade.richtext;

import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import com.ss.android.lark.coremd.facade.bizext.props.IMImageExtend;
import com.ss.android.lark.coremd.facade.bizext.props.IMMediaExtend;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import eab.f;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.l;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final b a = null;
    public static final c b = null;
    public static final C0184a c = null;

    /* JADX INFO: renamed from: com.ss.android.lark.coremd.facade.richtext.a$a, reason: collision with other inner class name */
    public static final class C0184a<N extends s> implements com.ss.android.lark.richtextmd.generate.c.c {
        public static final C0184a<N> a = null;

        static {
            a = new C0184a();
        }

        public C0184a() {
        }

        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r3, s r4) {
            final eab.a r5 = (eab.a) r4;
            Intrinsics.checkNotNullParameter(r3, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r5, "it");
            final RichTextElement.AtProperty r6 = new RichTextElement.AtProperty();
            r6.setUserId(r5.k);
            r6.setContent(r5.j);
            IMAtNodeExtend.i.b(new IMMarkdownToRichTextHandlers$at$1$1(r6, r5));
            return RichTextElementCreator.h(r6);
        }
    }

    public static final class b<N extends s> implements com.ss.android.lark.richtextmd.generate.c.c {
        public static final b<N> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r4, s r5) {
            final l r6 = (l) r5;
            Intrinsics.checkNotNullParameter(r4, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r6, "it");
            final RichTextElement.ImageProperty r0 = new RichTextElement.ImageProperty();
            IMImageExtend.p.b(new IMMarkdownToRichTextHandlers$image$1$1(r0, r6));
            RichTextElement r7 = RichTextElementCreator.h(r0);
            RichTextElement r1 = RichTextElementCreator.h(new RichTextElement.FigureProperty());
            r4.a(r1, r7);
            return r1;
        }
    }

    public static final class c<N extends s> implements com.ss.android.lark.richtextmd.generate.c.c {
        public static final c<N> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r4, s r5) {
            final f r6 = (f) r5;
            Intrinsics.checkNotNullParameter(r4, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r6, "it");
            final RichTextElement.MediaProperty r0 = new RichTextElement.MediaProperty();
            IMMediaExtend.q.b(new IMMarkdownToRichTextHandlers$media$1$1(r0, r6));
            RichTextElement r7 = RichTextElementCreator.h(r0);
            RichTextElement r1 = RichTextElementCreator.h(new RichTextElement.FigureProperty());
            String r2 = String.valueOf(r4.d.getAndIncrement());
            r1.setChildIds(CollectionsKt.listOf(r2));
            r4.c.put(r2, r7);
            return r1;
        }
    }

    static {
        a = b.a;
        b = c.a;
        c = C0184a.a;
    }
}
