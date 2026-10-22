package com.ss.android.lark.richtextmd.generate;

import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import com.ss.android.lark.coremd.impl.buildnode.ListItemBuildExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkCodeBlockExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkImageExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import com.ss.android.lark.coremdbiz.facade.link.LinkType;
import com.ss.android.lark.coremdbiz.facade.node.MarkdownAtUser;
import com.ss.android.lark.widget.richtext.MarkdownImageSet;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v7b.b0;
import v7b.d0;
import v7b.u;
import v7b.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static final q a = null;
    public static final r b = null;
    public static final g c = null;
    public static final a d = null;
    public static final b e = null;
    public static final s f = null;
    public static final p g = null;
    public static final n h = null;
    public static final c i = null;
    public static final f j = null;
    public static final m k = null;
    public static final h l = null;
    public static final j m = null;
    public static final i n = null;
    public static final k o = null;
    public static final e p = null;
    public static final C0129d q = null;
    public static final l r = null;
    public static final o s = null;

    public static final class a<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final a<N> a = null;

        /* JADX INFO: renamed from: com.ss.android.lark.richtextmd.generate.d$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0128a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[LinkType.values().length];
                r0[LinkType.CustomLink.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[LinkType.PossibleLink.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        static {
            a = new a();
        }

        public a() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r4, v7b.s r5) {
            final v7b.n r6 = (v7b.n) r5;
            Intrinsics.checkNotNullParameter(r4, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r6, "it");
            RichTextElement.AnchorProperty r7 = RichTextElementCreator.a(r6.k, r6.j);
            r7.setDisplayTitle(r6.k);
            int r0 = com.ss.android.lark.richtextmd.parse.impl.a.a;
            LarkLinkExtend.a r1 = LarkLinkExtend.f;
            dab.b r2 = (dab.a) r1.b(new MarkdownToRichTextHandlers$anchor$1$1(r6));
            Intrinsics.checkNotNullParameter(r7, "property");
            if (r2 != null) goto L6;
        L11:
            LinkType r8 = (LinkType) r1.b(new MarkdownToRichTextHandlers$anchor$1$2(r6));
            int r9 = C0128a.a[r8.ordinal()];
            if (r9 != 1) goto L14;
            r7.setCustom(true);
        L19:
            return RichTextElementCreator.h(r7);
        L14:
            if (r9 != 2) goto L19;
            r7.setScene(RichTextElement.AnchorProperty.Scene.COPY_PASTE_TEXT);
            goto L19
        L6:
            if ((r2 instanceof dab.b) == false) goto L9;
            dab.b r3 = r2;
            r7.setIconKey(r3.a);
            r7.setLocalIconRes(r3.b);
            r7.setUrlPreview(r3.c);
            r7.setIconColor(r3.d);
            r7.setColorIcon(r3.e);
            goto L11
        L9:
            if ((r2 instanceof dab.c) == false) goto L11;
            dab.c r10 = (dab.c) r2;
            r7.setLocalIconRes(r10.a);
            r7.setIconColor(r10.b);
            r7.setUnicode(r10.c);
            r7.setColorIcon(r10.d);
            goto L11
        }
    }

    public static final class b<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final b<N> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r3, v7b.s r4) {
            final v7b.s r5 = (v7b.n) r4;
            Intrinsics.checkNotNullParameter(r3, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r5, "it");
            if (((LinkType) LarkLinkExtend.f.b(new MarkdownToRichTextHandlers$anchorDowngrade$1$linkType$1(r5))) != LinkType.UrlInline) goto L6;
            return RichTextElementCreator.e(((v7b.n) r5).j);
        L6:
            return d.d.a(r3, r5);
        }
    }

    public static final class c<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final c<N> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r2, v7b.s r3) {
            eab.a r4 = (eab.a) r3;
            Intrinsics.checkNotNullParameter(r2, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r4, "it");
            RichTextElement.AtProperty r5 = new RichTextElement.AtProperty();
            r5.setUserId(r4.k);
            r5.setOriginUserName(r4.j);
            r5.setContent(r4.j);
            return RichTextElementCreator.h(r5);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.richtextmd.generate.d$d, reason: collision with other inner class name */
    public static final class C0129d<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final C0129d<N> a = null;

        static {
            a = new C0129d();
        }

        public C0129d() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r3, v7b.s r4) {
            eab.b r5 = (eab.b) r4;
            Intrinsics.checkNotNullParameter(r3, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r5, "it");
            RichTextElement.AtUserGroupProperty r6 = new RichTextElement.AtUserGroupProperty();
            r6.setUserGroupId(r5.j);
            r6.setDisplayName(r5.k);
            r6.setPermissionStatus(r5.l);
            return RichTextElementCreator.h(r6);
        }
    }

    public static final class e<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final e<N> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r2, v7b.s r3) {
            Intrinsics.checkNotNullParameter(r2, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter((v7b.b) r3, "it");
            Map r4 = RichTextElementCreator.a;
            return RichTextElementCreator.h(new RichTextElement.QuoteProperty());
        }
    }

    public static final class f<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final f<N> a = null;

        static {
            a = new f();
        }

        public f() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r3, v7b.s r4) {
            final v7b.g r5 = (v7b.g) r4;
            Intrinsics.checkNotNullParameter(r3, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r5, "it");
            final RichTextElement.CodeBlockV2Property r6 = new RichTextElement.CodeBlockV2Property();
            LarkCodeBlockExtend.f.b(new MarkdownToRichTextHandlers$codeBlockV2$1$1(r6, r5));
            return RichTextElementCreator.h(r6);
        }
    }

    public static final class g<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final g<N> a = null;

        static {
            a = new g();
        }

        public g() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r2, v7b.s r3) {
            eab.c r4 = (eab.c) r3;
            Intrinsics.checkNotNullParameter(r2, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r4, "it");
            String r5 = r4.k;
            Map r6 = RichTextElementCreator.a;
            if (r5 != null) goto L5;
            r5 = "";
        L5:
            Intrinsics.checkNotNullParameter(r5, "emojiKey");
            RichTextElement.EmotionProperty r7 = new RichTextElement.EmotionProperty();
            r7.setKey(r5);
            return RichTextElementCreator.h(r7);
        }
    }

    public static final class h<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final h<N> a = null;

        static {
            a = new h();
        }

        public h() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r2, v7b.s r3) {
            Intrinsics.checkNotNullParameter(r2, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter((v7b.h) r3, "it");
            return RichTextElementCreator.d();
        }
    }

    public static final class i<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final i<N> a = null;

        static {
            a = new i();
        }

        public i() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r2, v7b.s r3) {
            v7b.i r4 = (v7b.i) r3;
            Intrinsics.checkNotNullParameter(r2, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r4, "it");
            switch(r4.j) {
                case 1: goto L11;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                default: goto L4;
            };
        L4:
            return null;
        L13:
            return RichTextElementCreator.h(new RichTextElement.H6Property());
        L14:
            return RichTextElementCreator.h(new RichTextElement.H5Property());
        L15:
            return RichTextElementCreator.h(new RichTextElement.H4Property());
        L16:
            return RichTextElementCreator.h(new RichTextElement.H3Property());
        L17:
            return RichTextElementCreator.h(new RichTextElement.H2Property());
        L11:
            return RichTextElementCreator.h(new RichTextElement.H1Property());
        }
    }

    public static final class j<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final j<N> a = null;

        static {
            a = new j();
        }

        public j() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r2, v7b.s r3) {
            Intrinsics.checkNotNullParameter(r2, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter((d0) r3, "it");
            return RichTextElementCreator.h(new RichTextElement.HRProperty());
        }
    }

    public static final class k<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final k<N> a = null;

        static {
            a = new k();
        }

        public k() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r4, v7b.s r5) {
            final v7b.l r6 = (v7b.l) r5;
            Intrinsics.checkNotNullParameter(r4, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r6, "it");
            final RichTextElement.ImageProperty r0 = new RichTextElement.ImageProperty();
            LarkImageExtend.g.b(new MarkdownToRichTextHandlers$image$1$1(r0, r6));
            RichTextElement r7 = RichTextElementCreator.h(r0);
            RichTextElement r1 = RichTextElementCreator.h(new RichTextElement.FigureProperty());
            r4.a(r1, r7);
            return r1;
        }
    }

    public static final class l<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final l<N> a = null;

        static {
            a = new l();
        }

        public l() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r5, v7b.s r6) {
            eab.d r7 = (eab.d) r6;
            Intrinsics.checkNotNullParameter(r5, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r7, "it");
            RichTextElement.ImageGalleryProperty r0 = new RichTextElement.ImageGalleryProperty();
            RichTextElement r1 = new RichTextElement();
            r1.setTag(RichTextElement.RichTextTag.IMAGE_GALLERY);
            r1.setProperty(r0);
            Iterator r8 = r7.j.iterator();
        L4:
            if (r8.hasNext() == false) goto L11;
            v7b.l r2 = (v7b.l) r8.next();
            Intrinsics.checkNotNullParameter(v7b.l.class, "clazz");
            com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c<v7b.s> r3 = r5.a.get(v7b.l.class);
            if (r3 == null) goto L8;
            RichTextElement r4 = r3.a(r5, r2);
        L9:
            if (r4 == null) goto L4;
            r5.a(r1, r4);
            goto L4
        L8:
            r4 = null;
            goto L9
        L11:
            return r1;
        }
    }

    public static final class m<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final m<N> a = null;

        static {
            a = new m();
        }

        public m() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r3, v7b.s r4) {
            v7b.d r5 = (v7b.d) r4;
            Intrinsics.checkNotNullParameter(r3, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r5, "it");
            RichTextElement r0 = RichTextElementCreator.h(new RichTextElement.CodeProperty());
            String r1 = r5.j;
            if (((v7b.s) r5).e != null) goto L6;
            if (r1 == null) goto L6;
            RichTextElement r6 = RichTextElementCreator.e(r1);
            String r2 = String.valueOf(r3.d.getAndIncrement());
            r3.c.put(r2, r6);
            r0.setChildIds(CollectionsKt.listOf(r2));
        L6:
            return r0;
        }
    }

    public static final class n<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final n<N> a = null;

        static {
            a = new n();
        }

        public n() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r2, v7b.s r3) {
            v7b.q r4 = (v7b.q) r3;
            Intrinsics.checkNotNullParameter(r2, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r4, "it");
            RichTextElement.LIProperty r5 = new RichTextElement.LIProperty();
            u r6 = (v7b.a) ((v7b.s) r4).d;
            if ((r6 instanceof u) == false) goto L6;
            r5.setListNum(r6.k + ". ");
        L6:
            return RichTextElementCreator.h(r5);
        }
    }

    public static final class o<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final o<N> a = null;

        static {
            a = new o();
        }

        public o() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r7, v7b.s r8) {
            eab.e r9 = (eab.e) r8;
            Intrinsics.checkNotNullParameter(r7, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r9, "node");
            Map r10 = RichTextElementCreator.a;
            RichTextElement r11 = RichTextElementCreator.h(new RichTextElement.MarkdownProperty());
            RichTextElement.MarkdownProperty r0 = r11.getProperty();
            r0.setContent(r9.j);
            Map r1 = r9.k;
            LinkedHashMap r2 = null;
            if (r1 == null) goto L16;
            ArrayList r3 = new ArrayList();
            Iterator r4 = r1.entrySet().iterator();
        L6:
            if (r4.hasNext() == false) goto L13;
            Map.Entry r5 = (Map.Entry) r4.next();
            String r6 = (String) r5.getKey();
            MarkdownImageSet r12 = MarkdownImageSet.fromImageSetV2((ImageSetV2) r5.getValue());
            if (r12 == null) goto L10;
            Pair r13 = TuplesKt.to(r6, r12);
        L11:
            if (r13 == null) goto L6;
            r3.add(r13);
            goto L6
        L10:
            r13 = null;
            goto L11
        L13:
            Map r14 = MapsKt.toMap(r3);
            if (r14 == null) goto L16;
            HashMap r15 = new HashMap(r14);
        L17:
            r0.setImages(r15);
            r0.setAtUserIds(r9.l);
            r0.setAtAll(r9.m);
            Map r16 = r9.n;
            if (r16 == null) goto L23;
            r2 = new LinkedHashMap(MapsKt.mapCapacity(r16.size()));
            Iterator r17 = r16.entrySet().iterator();
        L21:
            if (r17.hasNext() == false) goto L23;
            Map.Entry r18 = (Map.Entry) r17.next();
            Object r19 = r18.getKey();
            MarkdownAtUser r20 = (MarkdownAtUser) r18.getValue();
            q r21 = d.a;
            RichTextElement.AtProperty r22 = new RichTextElement.AtProperty();
            r22.setUserId(r20.getUserId());
            r22.setContent(r20.getContent());
            r22.setOutChatUser(r20.isOutChatUser());
            r22.setAnonymous(r20.isAnonymous());
            r22.setHighLight(r20.isHighLight());
            r2.put(r19, r22);
        L23:
            r0.setAtUsers(r2);
            return r11;
        L16:
            r15 = null;
            goto L17
        }
    }

    public static final class p<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final p<N> a = null;

        static {
            a = new p();
        }

        public p() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r3, v7b.s r4) {
            final u r5 = (u) r4;
            Intrinsics.checkNotNullParameter(r3, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r5, "it");
            ListItemBuildExtend.a r6 = ListItemBuildExtend.g;
            Function1<ListItemBuildExtend, RichTextElement.OLProperty.Type> r0 = new MarkdownToRichTextHandlers$ol$1$type$1(r5);
            r6.getClass();
            Intrinsics.checkNotNullParameter(r0, "action");
            RichTextElement.OLProperty.Type r7 = (RichTextElement.OLProperty.Type) r6.c.b(r0);
            Integer r8 = r5.k;
            if (r8 == null) goto L5;
            int r9 = r8.intValue();
        L6:
            Map r1 = RichTextElementCreator.a;
            RichTextElement.OLProperty r2 = new RichTextElement.OLProperty();
            r2.setStart(r9);
            RichTextElement r10 = RichTextElementCreator.h(r2);
            r10.getProperty().setType(r7);
            return r10;
        L5:
            r9 = 1;
            goto L6
        }
    }

    public static final class q<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final q<N> a = null;

        static {
            a = new q();
        }

        public q() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r2, v7b.s r3) {
            Intrinsics.checkNotNullParameter(r2, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter((v) r3, "it");
            return RichTextElementCreator.d();
        }
    }

    public static final class r<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final r<N> a = null;

        static {
            a = new r();
        }

        public r() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r2, v7b.s r3) {
            b0 r4 = (b0) r3;
            Intrinsics.checkNotNullParameter(r2, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r4, "it");
            return RichTextElementCreator.e(r4.j);
        }
    }

    public static final class s<N extends v7b.s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c {
        public static final s<N> a = null;

        static {
            a = new s();
        }

        public s() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC0127c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r2, v7b.s r3) {
            final v7b.c r4 = (v7b.c) r3;
            Intrinsics.checkNotNullParameter(r2, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r4, "it");
            ListItemBuildExtend.a r5 = ListItemBuildExtend.g;
            Function1<ListItemBuildExtend, RichTextElement.ULProperty.Type> r0 = new MarkdownToRichTextHandlers$ul$1$type$1(r4);
            r5.getClass();
            Intrinsics.checkNotNullParameter(r0, "action");
            RichTextElement.ULProperty.Type r6 = (RichTextElement.ULProperty.Type) r5.c.b(r0);
            Map r7 = RichTextElementCreator.a;
            Intrinsics.checkNotNullParameter(r6, "type");
            Intrinsics.checkNotNullParameter(r6, "type");
            RichTextElement.ULProperty r8 = new RichTextElement.ULProperty();
            r8.setType(r6);
            return RichTextElementCreator.h(r8);
        }
    }

    static {
        a = q.a;
        b = r.a;
        c = g.a;
        d = a.a;
        e = b.a;
        f = s.a;
        g = p.a;
        h = n.a;
        i = c.a;
        j = f.a;
        k = m.a;
        l = h.a;
        m = j.a;
        n = i.a;
        o = k.a;
        p = e.a;
        q = C0129d.a;
        r = l.a;
        s = o.a;
    }
}
