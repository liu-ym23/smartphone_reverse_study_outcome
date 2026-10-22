package com.ss.android.lark.richtextmd.parse.impl;

import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkCodeBlockExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkImageExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import com.ss.android.lark.coremdbiz.facade.node.MarkdownAtUser;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.MarkdownImageSet;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.b0;
import v7b.d0;
import v7b.u;
import v7b.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RichTextTagHandlers {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final Lazy k = null;
    public static final Lazy l = null;
    public static final Lazy m = null;
    public static final Lazy n = null;
    public static final Lazy o = null;
    public static final Lazy p = null;
    public static final Lazy q = null;
    public static final Lazy r = null;
    public static final Lazy s = null;
    public static final Lazy t = null;
    public static final Lazy u = null;
    public static final Lazy v = null;
    public static final Lazy w = null;
    public static final Lazy x = null;

    public static class AnchorTagHandler implements b3c.a {
        public AnchorTagHandler() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r17) {
            Intrinsics.checkNotNullParameter(r17, "context");
            final RichTextElement.AnchorProperty r0 = r17.getElement().getProperty();
            String r1 = r0.getContent();
            boolean r2 = false;
            if (r1 != null) goto L5;
        L8:
            boolean r4 = true;
        L9:
            if (r4 == false) goto L11;
            r1 = r0.getHref();
        L11:
            int r5 = com.ss.android.lark.richtextmd.parse.impl.a.a;
            Intrinsics.checkNotNull(r0);
            Intrinsics.checkNotNullParameter(r0, "property");
            String r6 = r0.getIconKey();
            String r7 = r0.getFaviconUrl();
            String r8 = r0.getDisplayTitle();
            if (r8 != null) goto L14;
        L17:
            boolean r9 = true;
        L18:
            final dab.c r10 = null;
            if (r9 == true) goto L59;
            if (r6 != null) goto L23;
        L26:
            boolean r11 = true;
        L27:
            String r12 = "";
            if (r11 == false) goto L51;
            if (r7 != null) goto L31;
        L34:
            boolean r13 = true;
        L35:
            if (r13 == false) goto L51;
            if (r0.getLocalIconRes() > 0) goto L45;
            String r14 = r0.getUnicode();
            if (r14 != null) goto L42;
        L43:
            r2 = true;
        L44:
            if (r2 == true) goto L59;
        L42:
            if (r14.length() != 0) goto L44;
        L45:
            int r3 = r0.getLocalIconRes();
            int r15 = r0.getIconColor();
            String r16 = r0.getUnicode();
            if (r16 == null) goto L49;
            r12 = r16;
        L49:
            r10 = new dab.c(r3, r15, r12, r0.isColorIcon());
            goto L59
        L31:
            if (r7.length() == 0) goto L34;
            r13 = false;
        L51:
            if (r6 != null) goto L53;
            String r18 = "";
        L54:
            int r19 = r0.getLocalIconRes();
            boolean r110 = r0.isUrlPreview();
            int r111 = r0.getIconColor();
            boolean r112 = r0.isColorIcon();
            if (r7 != null) goto L57;
            String r113 = "";
        L58:
            r10 = new dab.b(r18, r19, r110, r111, r112, r113);
            goto L59
        L57:
            r113 = r7;
            goto L58
        L53:
            r18 = r6;
            goto L54
        L23:
            if (r6.length() == 0) goto L26;
            r11 = false;
        L59:
            final v7b.n r20 = new v7b.n(r0.getHref(), r1);
            LarkLinkExtend.f.b(new RichTextTagHandlers$AnchorTagHandler$mapToNode$1(r10, r20, r0));
            return r20;
        L14:
            if (r8.length() == 0) goto L17;
            r9 = false;
            goto L18
        L5:
            if (r1.length() == 0) goto L8;
            r4 = false;
            goto L9
        }
    }

    public static class CodeBlockTagHandler implements b3c.a {
        public CodeBlockTagHandler() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            final RichTextElement.CodeBlockV2Property r4 = r3.getElement().getProperty();
            return (v7b.s) LarkCodeBlockExtend.f.b(new RichTextTagHandlers$CodeBlockTagHandler$mapToNode$1(r4));
        }
    }

    public static class ImageTagHandler implements b3c.a {
        public ImageTagHandler() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public v7b.s b(b3c.b r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            final RichTextElement.ImageProperty r0 = r4.getElement().getProperty();
            String r1 = r0.getAlt();
            if (r1 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L11;
            r1 = UIUtils.getString(r4.getContext(), 2131891922);
        L11:
            final v7b.l r5 = new v7b.l(r0.getToken(), r1);
            LarkImageExtend.g.b(new RichTextTagHandlers$ImageTagHandler$mapToNode$1(r5, r0));
            return r5;
        L5:
            if (r1.length() == 0) goto L8;
            r2 = false;
            goto L9
        }
    }

    public static class a implements b3c.a {
        public a() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public v7b.s b(b3c.b r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            RichTextElement.AtProperty r4 = r3.getElement().getProperty();
            return new eab.a(r4.getContentWithoutAt(), r4.getUserId());
        }
    }

    public static class b implements b3c.a {
        public b() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            RichTextElement.AtUserGroupProperty r6 = r5.getElement().getProperty();
            long r1 = r6.getUserGroupId();
            String r3 = r6.getContentDisplayName();
            if (r3 != null) goto L6;
            r3 = "";
        L6:
            return new eab.b(r1, r3, r6.getPermissionStatus());
        }
    }

    public static class c implements b3c.a {
        public c() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new v7b.b();
        }
    }

    public static class d implements b3c.a {
        public d() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new v7b.c();
        }
    }

    public static class e implements b3c.a {
        public e() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new v7b.d();
        }
    }

    public static class f implements b3c.a {
        public f() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            RichTextElement.EmotionProperty r4 = r3.getElement().getProperty();
            return new eab.c(EmojiHandler.e(r4.getKey()), r4.getKey());
        }
    }

    public static class g implements b3c.a {
        public g() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            v7b.i r3 = new v7b.i();
            r3.j = 1;
            return r3;
        }
    }

    public static class h implements b3c.a {
        public h() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            v7b.i r3 = new v7b.i();
            r3.j = 2;
            return r3;
        }
    }

    public static class i implements b3c.a {
        public i() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            v7b.i r3 = new v7b.i();
            r3.j = 3;
            return r3;
        }
    }

    public static class j implements b3c.a {
        public j() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            v7b.i r3 = new v7b.i();
            r3.j = 4;
            return r3;
        }
    }

    public static class k implements b3c.a {
        public k() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            v7b.i r3 = new v7b.i();
            r3.j = 5;
            return r3;
        }
    }

    public static class l implements b3c.a {
        public l() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            v7b.i r3 = new v7b.i();
            r3.j = 6;
            return r3;
        }
    }

    public static class m implements b3c.a {
        public m() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new d0();
        }
    }

    public static class n implements b3c.a {
        public n() {
        }

        @Override // b3c.a
        public final boolean a() {
            return false;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r8) {
            Intrinsics.checkNotNullParameter(r8, "context");
            List r0 = r8.getElement().getChildIds();
            b3c.a r1 = r8.a(RichTextElement.RichTextTag.IMG);
            if (r1 != null) goto L5;
            return null;
        L5:
            ArrayList r3 = new ArrayList();
            if (r0 == null) goto L23;
            Iterator r2 = r0.iterator();
        L9:
            if (r2.hasNext() == false) goto L23;
            String r4 = (String) r2.next();
            Intrinsics.checkNotNull(r4);
            RichTextElement r5 = r8.getElementById(r4);
            if (r5 == null) goto L9;
            if (r5.getTag() != RichTextElement.RichTextTag.IMG) goto L9;
            v7b.l r6 = r1.b(r8.e(r5));
            if ((r6 instanceof v7b.l) == false) goto L19;
            v7b.l r7 = r6;
        L20:
            if (r7 == null) goto L9;
            r3.add(r7);
            goto L9
        L19:
            r7 = null;
        L23:
            return new eab.d(r3);
        }
    }

    public static class o implements b3c.a {
        public o() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new v7b.q();
        }
    }

    public static class p implements b3c.a {
        public p() {
        }

        @Override // b3c.a
        public final boolean a() {
            return false;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r15) {
            Intrinsics.checkNotNullParameter(r15, "context");
            RichTextElement.MarkdownProperty r16 = r15.getElement().getProperty();
            LinkedHashMap r0 = null;
            if (r16 == null) goto L5;
            String r1 = r16.getContent();
        L6:
            if (r1 != null) goto L8;
            r1 = "";
        L8:
            String r3 = r1;
            if (r16 == null) goto L22;
            Map r2 = r16.getImages();
            if (r2 == null) goto L22;
            ArrayList r4 = new ArrayList();
            Iterator r5 = r2.entrySet().iterator();
        L14:
            if (r5.hasNext() == false) goto L21;
            Map.Entry r6 = (Map.Entry) r5.next();
            String r7 = (String) r6.getKey();
            ImageSetV2 r8 = ((MarkdownImageSet) r6.getValue()).toImageSetV2();
            if (r8 == null) goto L18;
            Pair r9 = TuplesKt.to(r7, r8);
        L19:
            if (r9 == null) goto L14;
            r4.add(r9);
            goto L14
        L18:
            r9 = null;
            goto L19
        L21:
            Map r10 = MapsKt.toMap(r4);
        L23:
            if (r16 == null) goto L25;
            List r11 = r16.getAtUserIds();
        L26:
            if (r16 == null) goto L28;
            boolean r12 = r16.isAtAll();
        L29:
            if (r16 == null) goto L37;
            Map r17 = r16.getAtUsers();
            if (r17 == null) goto L37;
            r0 = new LinkedHashMap(MapsKt.mapCapacity(r17.size()));
            Iterator r18 = r17.entrySet().iterator();
        L34:
            if (r18.hasNext() == false) goto L37;
            Map.Entry r13 = (Map.Entry) r18.next();
            Object r14 = r13.getKey();
            RichTextElement.AtProperty r19 = (RichTextElement.AtProperty) r13.getValue();
            Intrinsics.checkNotNull(r19);
            r0.put(r14, new MarkdownAtUser(r19.getUserId(), r19.getContent(), r19.isOutChatUser(), r19.isAnonymous(), r19.isHighLight()));
        L37:
            return new eab.e(r3, r10, r11, r12, r0);
        L28:
            r12 = false;
            goto L29
        L25:
            r11 = null;
        L22:
            r10 = null;
            goto L23
        L5:
            r1 = null;
            goto L6
        }
    }

    public static class q implements b3c.a {
        public q() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public v7b.s b(b3c.b r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            RichTextElement.MediaProperty r0 = r10.getElement().getProperty();
            Image r1 = r0.getOriginImage();
            if (r1 == null) goto L5;
            int r6 = r1.getWidth();
        L6:
            Image r2 = r0.getOriginImage();
            if (r2 == null) goto L9;
            int r7 = r2.getHeight();
        L10:
            int r8 = r0.getDuration();
            String r4 = UIUtils.getString(r10.getContext(), 2131891923);
            Intrinsics.checkNotNull(r4);
            return new eab.f(r4, r0.getKey(), r6, r7, r8);
        L9:
            r7 = 0;
            goto L10
        L5:
            r6 = 0;
            goto L6
        }
    }

    public static class r implements b3c.a {
        public r() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            u r0 = new u();
            r0.k = Integer.valueOf(r2.getElement().getProperty().getStart());
            return r0;
        }
    }

    public static class s implements b3c.a {
        public s() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final v7b.s b(b3c.b r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            List r3 = r2.getElement().getChildIds();
            if (r3 != null) goto L5;
        L8:
            boolean r4 = true;
        L9:
            if (r4 == false) goto L13;
            return new v7b.h();
        L13:
            return new v();
        L5:
            if (r3.isEmpty() == true) goto L8;
            r4 = false;
            goto L9
        }
    }

    public static class t implements b3c.a {
        public t() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public v7b.s b(b3c.b r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new b0(r2.getElement().getProperty().getContent());
        }
    }

    static {
        a = LazyKt.lazy(RichTextTagHandlers$paragraphHandler$2.INSTANCE);
        b = LazyKt.lazy(RichTextTagHandlers$textHandler$2.INSTANCE);
        c = LazyKt.lazy(RichTextTagHandlers$emojiHandler$2.INSTANCE);
        d = LazyKt.lazy(RichTextTagHandlers$anchorHandler$2.INSTANCE);
        e = LazyKt.lazy(RichTextTagHandlers$atHandler$2.INSTANCE);
        f = LazyKt.lazy(RichTextTagHandlers$imageHandler$2.INSTANCE);
        g = LazyKt.lazy(RichTextTagHandlers$h1Handler$2.INSTANCE);
        h = LazyKt.lazy(RichTextTagHandlers$h2Handler$2.INSTANCE);
        i = LazyKt.lazy(RichTextTagHandlers$h3Handler$2.INSTANCE);
        j = LazyKt.lazy(RichTextTagHandlers$h4Handler$2.INSTANCE);
        k = LazyKt.lazy(RichTextTagHandlers$h5Handler$2.INSTANCE);
        l = LazyKt.lazy(RichTextTagHandlers$h6Handler$2.INSTANCE);
        m = LazyKt.lazy(RichTextTagHandlers$hrHandler$2.INSTANCE);
        n = LazyKt.lazy(RichTextTagHandlers$blockQuoteHandler$2.INSTANCE);
        o = LazyKt.lazy(RichTextTagHandlers$bulletListHandler$2.INSTANCE);
        p = LazyKt.lazy(RichTextTagHandlers$orderedListHandler$2.INSTANCE);
        q = LazyKt.lazy(RichTextTagHandlers$listItemHandler$2.INSTANCE);
        r = LazyKt.lazy(RichTextTagHandlers$codeHandler$2.INSTANCE);
        s = LazyKt.lazy(RichTextTagHandlers$codeBlockHandler$2.INSTANCE);
        t = LazyKt.lazy(RichTextTagHandlers$atUserGroupHandler$2.INSTANCE);
        u = LazyKt.lazy(RichTextTagHandlers$tableHandler$2.INSTANCE);
        v = LazyKt.lazy(RichTextTagHandlers$imageGalleryHandler$2.INSTANCE);
        w = LazyKt.lazy(RichTextTagHandlers$mediaTagHandler$2.INSTANCE);
        x = LazyKt.lazy(RichTextTagHandlers$markdownHandler$2.INSTANCE);
    }
}
