package com.ss.android.lark.keyboard.edittext2.edittors.richText;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor;
import com.ss.android.lark.keyboard.edittext2.edittors.e;
import com.ss.android.lark.keyboard.edittext2.edittors.image.ImageEditor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.LingoLocalExtraData;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import com.ss.android.lark.widget.span.TextStyleInfo;
import hob.f;
import hob.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ncc.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class RichTextEditor extends BaseFunctionEditor<RichText> implements com.ss.android.lark.widget.richtext.b, com.ss.android.lark.keyboard.edittext2.base.c {
    public static final a t = null;
    public int c;
    public final Lazy d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public boolean o;
    public SpannableStringBuilder p;
    public final List<Object> q;
    public final LinkedList<RichTextElement> r;
    public final LinkedList<Integer> s;

    public static final class a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a<RichTextEditor> {
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a
        public final Class<RichTextEditor> a() {
            return this.a.a;
        }

        public a() {
            this.a = new com.ss.android.lark.keyboard.edittext2.base.d(RichTextEditor.class);
        }
    }

    static {
        t = new a();
    }

    public final /* synthetic */ void C(RichTextElement.ItalicProperty r1) {
    }

    public final /* synthetic */ void F() {
    }

    public final /* synthetic */ void H(RichTextElement.ProgressSelectOptionProperty r1) {
    }

    public final /* synthetic */ void I() {
    }

    public final /* synthetic */ void M() {
    }

    public final /* synthetic */ void e(RichTextElement.SelectProperty r1) {
    }

    public final /* synthetic */ void j() {
    }

    public final /* synthetic */ void n() {
    }

    public final /* synthetic */ void v(RichTextElement.UnderlineProperty r1) {
    }

    public final /* synthetic */ void y(RichTextElement.ButtonProperty r1) {
    }

    public final /* synthetic */ void z(RichTextElement.BoldProperty r1) {
    }

    public void E() {
        SpannableStringBuilder r0 = this.p;
        if (r0 == null) goto L6;
        W(r0);
        return;
    }

    public void O() {
        SpannableStringBuilder r0 = this.p;
        if (r0 == null) goto L6;
        W(r0);
        return;
    }

    public void h() {
        SpannableStringBuilder r0 = this.p;
        if (r0 == null) goto L6;
        W(r0);
        return;
    }

    public void l() {
        SpannableStringBuilder r0 = this.p;
        if (r0 == null) goto L6;
        W(r0);
        return;
    }

    public void w() {
        SpannableStringBuilder r0 = this.p;
        if (r0 == null) goto L6;
        W(r0);
        return;
    }

    public void x() {
        SpannableStringBuilder r0 = this.p;
        if (r0 == null) goto L6;
        W(r0);
        return;
    }

    public RichTextEditor() {
        this.c = -1;
        this.d = LazyKt.lazy(new RichTextEditor$styleParser$2(this));
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.k = true;
        this.l = true;
        this.n = -1;
        this.q = new ArrayList();
        this.r = new LinkedList();
        this.s = new LinkedList();
    }

    public static void U(Editable r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        Character r1 = StringsKt.lastOrNull(r2);
        if (r1 != null) goto L11;
    L12:
        r2.append("\n");
        return;
    L11:
        if (r1.charValue() != '\n') goto L12;
        return;
    L14:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void W(Editable r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r1.append("\n");
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void B(RichTextElement.LIProperty r5) {
        SpannableStringBuilder r0 = this.p;
        if (r0 == null) goto L5;
        W(r0);
    L5:
        if (r5 == null) goto L22;
        String r1 = r5.getListNum();
        if (r1 == null) goto L25;
        int r6 = r5.getFloor();
        int r2 = 0;
        if (r1.length() <= 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L23;
        StringBuilder r4 = new StringBuilder();
    L15:
        if (r2 >= r6) goto L17;
        r4.append("  ");
        r2 = r2 + 1;
        goto L15
    L17:
        r4.append(r1);
        String r7 = r4.toString();
        SpannableStringBuilder r8 = this.p;
        if (r8 == null) goto L24;
        r8.append(r7);
        return;
    L24:
        return;
    L23:
        return;
    L12:
        r3 = false;
        goto L13
    L25:
        return;
    }

    public final void D(RichTextElement.MyAIToolProperty r1) {
        SpannableStringBuilder r2 = this.p;
        if (r2 == null) goto L6;
        W(r2);
        return;
    }

    public final void J(RichTextElement.MediaProperty r18) {
        if (r18 != null) goto L5;
        return;
    L5:
        SpannableStringBuilder r7 = this.p;
        if (r7 != null) goto L9;
        return;
    L9:
        if (this.h == true) goto L12;
        r7.append(UIHelper.getString(2131891923));
        return;
    L12:
        String r1 = r18.getOriginPath();
        String r2 = r18.getKey();
        boolean r3 = true;
        if (r2 != null) goto L15;
    L18:
        boolean r4 = true;
    L19:
        if (r4 == false) goto L21;
    L23:
        boolean r5 = false;
    L25:
        if (FileUtils.r(r1) == true) goto L29;
        if (r5 == true) goto L29;
        Log.i("RichTextEditor", "recover video failed, localPath is:" + r1);
        return;
    L29:
        int r6 = g.f;
        Intrinsics.checkNotNullParameter(r18, "property");
        String r8 = r18.getOriginPath();
        String r9 = "";
        if (r8 != null) goto L32;
        String r10 = "";
    L33:
        String r11 = r18.getCompressPath();
        if (r11 != null) goto L36;
        String r12 = "";
    L37:
        String r13 = r18.getMime();
        if (r13 != null) goto L40;
        String r14 = "";
    L41:
        VideoInfo r15 = new VideoInfo(r10, r12, r14, r18.getSize(), r18.getDuration());
        String r16 = r18.getKey();
        if (r16 != null) goto L44;
        r16 = "";
    L44:
        r15.setKey(r16);
        r15.setOriginImage(r18.getOriginImage());
        String r17 = r18.getUrl();
        if (r17 != null) goto L47;
        r17 = "";
    L47:
        r15.setUrl(r17);
        String r19 = r18.getMediaUploadId();
        if (r19 != null) goto L50;
        r19 = "";
    L50:
        r15.setMediaUploadId(r19);
        String r20 = r18.getImageUploadId();
        if (r20 != null) goto L53;
        r20 = "";
    L53:
        r15.setImageUploadId(r20);
        int r21 = r18.getWidth();
        int r22 = r18.getHeight();
        String r23 = r18.getKey();
        if (r23 != null) goto L56;
    L59:
        boolean r24 = true;
    L60:
        if (r24 == false) goto L62;
    L64:
        r3 = false;
    L65:
        String r25 = r18.getCoverPath();
        if (r25 == null) goto L69;
        r9 = r25;
    L69:
        FrameInfo r26 = new FrameInfo(r9, r18.getWidth(), r18.getHeight());
        if (r3 == false) goto L72;
        com.ss.android.lark.widget.span.b.b r27 = new com.ss.android.lark.widget.span.b.b.b(r18.getOriginImage().getKey(), r18.getOriginImage().getWidth(), r18.getOriginImage().getHeight(), r18.getOriginImage().getFsUnit(), r18.getOriginImage().getCrypto());
    L73:
        g r28 = new g(r27, r18.getDuration(), r15, r26, r18);
        SpannableStringBuilder r29 = this.p;
        if (r29 == null) goto L76;
        W(r29);
    L76:
        ((e) q(e.e)).R(r28, r7);
        return;
    L72:
        r27 = new com.ss.android.lark.widget.span.b.b.a(r18.getCoverPath(), r21, r22);
        goto L73
    L62:
        if (r18.getOriginImage() == null) goto L64;
    L56:
        if (r23.length() == 0) goto L59;
        r24 = false;
        goto L60
    L40:
        r14 = r13;
        goto L41
    L36:
        r12 = r11;
        goto L37
    L32:
        r10 = r8;
        goto L33
    L21:
        if (r18.getOriginImage() == null) goto L23;
        r5 = true;
        goto L25
    L15:
        if (r2.length() == 0) goto L18;
        r4 = false;
        goto L19
    }

    public void K(RichTextElement.CodeBlockV2Property r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        SpannableStringBuilder r0 = this.p;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.m == true) goto L13;
        String r5 = com.ss.android.lark.widget.codeblock.entity.a.a(r4.getLineContents());
        SpannableStringBuilder r1 = this.p;
        if (r1 == null) goto L27;
        r1.append(r5);
        return;
    L27:
        return;
    L13:
        RichTextElement r2 = (RichTextElement) CollectionsKt.getOrNull(this.r, 1);
        if (r2 == null) goto L16;
        RichTextElement.RichTextTag r3 = r2.getTag();
    L18:
        if (r3 == RichTextElement.RichTextTag.PARAGRAPH) goto L22;
        SpannableStringBuilder r6 = this.p;
        if (r6 == null) goto L22;
        W(r6);
    L22:
        int r7 = hob.e.c;
        Intrinsics.checkNotNullParameter(r4, "property");
        List r8 = r4.getLineContents();
        if (r8 != null) goto L25;
        r8 = CollectionsKt.emptyList();
    L25:
        hob.e r9 = new hob.e(r8, r4);
        ((com.ss.android.lark.keyboard.edittext2.edittors.c) q(com.ss.android.lark.keyboard.edittext2.edittors.c.d)).R(r9, r0);
        return;
    L16:
        r3 = null;
        goto L18
    }

    public void L(RichTextElement.AtUserGroupProperty r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        SpannableStringBuilder r0 = this.p;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.o == false) goto L10;
    L13:
        Intrinsics.checkNotNullParameter(r7, "property");
        V(null, "@" + r7.getContentDisplayName());
        return;
    L10:
        if (r7.getPermissionStatus() != 1) goto L13;
        com.ss.android.lark.keyboard.edittext2.edittors.b r1 = (com.ss.android.lark.keyboard.edittext2.edittors.b) q(com.ss.android.lark.keyboard.edittext2.edittors.b.d);
        int r2 = hob.d.e;
        Intrinsics.checkNotNullParameter(r7, "atProperty");
        hob.d r3 = new hob.d(r7.getUserGroupId(), r7.getContentDisplayName(), r7.getPermissionStatus());
        r3.d = false;
        r1.R(r3, r0);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void P(Editable r6) {
        Intrinsics.checkNotNullParameter(r6, "targetEditable");
        if (((ArrayList) this.q).isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r0 = ((ArrayList) this.q).iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        Object r1 = r0.next();
        int r2 = r6.getSpanStart(r1);
        int r3 = r6.getSpanEnd(r1);
        if (r2 == (-1)) goto L7;
        if (r3 == (-1)) goto L7;
        r6.setSpan(r1, r2, r3, 34);
        goto L7
    L13:
        ((ArrayList) this.q).clear();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void Q(Editable r9) {
        Intrinsics.checkNotNullParameter(r9, "targetEditable");
        Object[] r0 = r9.getSpans(0, r9.length(), h.class);
        ArrayList r1 = new ArrayList();
        int r3 = r0.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L12;
        Object r5 = r0[r4];
        if (r9.getSpanFlags((h) r5) != 34) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L10;
        r1.add(r5);
    L10:
        r4 = r4 + 1;
        goto L3
    L7:
        r6 = false;
        goto L8
    L12:
        if (r1.isEmpty() == false) goto L14;
        return;
    L14:
        ((ArrayList) this.q).addAll(r1);
        Iterator r2 = ((ArrayList) this.q).iterator();
    L16:
        if (r2.hasNext() == false) goto L22;
        Object r7 = r2.next();
        int r8 = r9.getSpanStart(r7);
        int r10 = r9.getSpanEnd(r7);
        if (r8 == (-1)) goto L16;
        if (r10 == (-1)) goto L16;
        r9.setSpan(r7, r8, r10, 33);
        goto L16
    }

    public void a(RichText r7) {
        SpannableStringBuilder r8 = this.p;
        if (r8 == null) goto L5;
        int r1 = r8.length();
    L6:
        int r2 = this.c;
        if (r2 < 0) goto L17;
        if (r1 < r2) goto L17;
        if (r8 == null) goto L17;
        Iterator r3 = ArrayIteratorKt.iterator((h[]) r8.getSpans(r2, r1, h.class));
    L13:
        if (r3.hasNext() == false) goto L15;
        h r4 = (h) r3.next();
        int r5 = r8.getSpanStart(r4);
        int r6 = r8.getSpanEnd(r4);
        r8.removeSpan(r4);
        r8.setSpan(r4, r5, r6, 34);
        goto L13
    L15:
        this.c = -1;
        List<String> r9 = com.ss.android.lark.keyboard.edittext2.utils.b.a;
        com.ss.android.lark.keyboard.edittext2.utils.b.d(r8, 0, r8.length());
        this.r.clear();
        return;
    L17:
        Log.e("RichTextEditor", "replaceDraftSpanFailed, textLen:" + r1 + ", start:" + this.c + ", end:" + r1);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public void b(RichText r2) {
        SpannableStringBuilder r3 = this.p;
        if (r3 != null) goto L5;
        return;
    L5:
        this.c = r3.length();
        Log.i("RichTextEditor", "onRenderStart:{parseTextStyle: " + this.e + " , parseAt: " + this.f + " , parseMedia: " + this.h + " , parseImage: " + this.i + " , parseAnchor: " + this.k + ", parseCodeBlockV2: " + this.m + "showLinkWhenParseAnchorOff : " + this.l + '}');
    }

    public final void f(RichTextElement.ImageProperty r14) {
        if (r14 != null) goto L4;
        return;
    L4:
        String r0 = r14.getToken();
        boolean r1 = false;
        if (r0 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        boolean r3 = !r2;
        List r4 = r14.getUrls();
        if (r4 != null) goto L14;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L22;
        if (r3 == true) goto L22;
        Log.i("RichTextEditor", "current image property has no image key or url to load");
        return;
    L22:
        SpannableStringBuilder r6 = this.p;
        if (r6 != null) goto L26;
        return;
    L26:
        if (this.i == true) goto L29;
        r6.append(UIHelper.getString(2131891845));
        return;
    L29:
        int r7 = f.f;
        Intrinsics.checkNotNullParameter(r14, "property");
        String r8 = r14.getToken();
        if (r8 != null) goto L32;
    L35:
        boolean r9 = true;
    L36:
        boolean r10 = !r9;
        String r11 = r14.getToken();
        if (r10 == false) goto L53;
        String r12 = r14.getMiddleKey();
        if (r12 != null) goto L41;
    L44:
        boolean r13 = true;
    L45:
        if (r13 == false) goto L47;
        r12 = r14.getOriginKey();
    L47:
        if (r12 != null) goto L49;
    L50:
        r1 = true;
    L51:
        if (r1 == false) goto L58;
        r14.setOriginKey(r11);
        r12 = r11;
    L58:
        String r15 = r12;
    L60:
        int r16 = r14.getWidth();
        if (r14.getWidth() != 0) goto L63;
        r16 = r14.getOriginWidth();
    L63:
        int r17 = r16;
        int r18 = r14.getHeight();
        if (r14.getHeight() != 0) goto L66;
        r18 = r14.getOriginHeight();
    L66:
        int r19 = r18;
        if (r10 == false) goto L69;
        Intrinsics.checkNotNull(r15);
        com.ss.android.lark.widget.span.b.b.b r20 = new com.ss.android.lark.widget.span.b.b.b(r15, r17, r19, r14.getFsUnit(), r14.getCrypto());
    L71:
        if (r11 != null) goto L73;
        r11 = "";
    L73:
        f r21 = new f(r20, r11, r14.isOriginSource(), r14);
        r21.e = this.n;
        SpannableStringBuilder r110 = this.p;
        if (r110 == null) goto L76;
        U(r110);
    L76:
        ((ImageEditor) q(ImageEditor.c)).R(r21, r6);
        return;
    L69:
        Intrinsics.checkNotNull(r15);
        r20 = new com.ss.android.lark.widget.span.b.b.a(r15, r17, r19);
        goto L71
    L49:
        if (r12.length() != 0) goto L51;
    L41:
        if (r12.length() == 0) goto L44;
        r13 = false;
        goto L45
    L53:
        List r22 = r14.getUrls();
        if (r22 == null) goto L59;
        r12 = (String) CollectionsKt.getOrNull(r22, 0);
        if (r12 != null) goto L58;
    L59:
        r15 = "";
        goto L60
    L32:
        if (r8.length() == 0) goto L35;
        r9 = false;
        goto L36
    L14:
        if (r4.isEmpty() == true) goto L17;
        r5 = false;
        goto L18
    L7:
        if (r0.length() == 0) goto L10;
        r2 = false;
        goto L11
    }

    public void i(RichTextElement.ParagraphProperty r3) {
        boolean r0 = false;
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L19;
        SpannableStringBuilder r5 = this.p;
        if (r5 != null) goto L12;
    L13:
        r0 = true;
    L14:
        if (r0 == true) goto L20;
        SpannableStringBuilder r6 = this.p;
        if (r6 == null) goto L21;
        W(r6);
        return;
    L21:
        return;
    L20:
        return;
    L12:
        if (r5.length() != 0) goto L14;
    L19:
        return;
    L5:
        if (r3.getIsNeedEnter() != true) goto L7;
        r4 = true;
        goto L8
    }

    public final void o(RichTextElement.MarkdownProperty r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        String r0 = r8.getContent();
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        return;
    L13:
        SpannableStringBuilder r2 = this.p;
        if (r2 != null) goto L16;
        return;
    L16:
        int r3 = r2.length();
        V(null, r0);
        int r4 = r2.length();
        if (r4 > r3) goto L19;
        return;
    L19:
        RichTextElement r5 = new RichTextElement();
        r5.setTag(RichTextElement.RichTextTag.MARKDOWN);
        RichTextElement.MarkdownProperty r6 = new RichTextElement.MarkdownProperty();
        r6.setContent(r8.getContent());
        r6.setImages(r8.getImages());
        r6.setAtUserIds(r8.getAtUserIds());
        r6.setAtAll(r8.isAtAll());
        r6.setAtUsers(r8.getAtUsers());
        r5.setProperty(r6);
        r2.setSpan(new p(r5, r0), r3, r4, 18);
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    }

    public void p(RichTextElement r2) {
        this.r.push(r2);
        LinkedList<Integer> r3 = this.s;
        SpannableStringBuilder r0 = this.p;
        if (r0 == null) goto L5;
        int r1 = r0.length();
    L6:
        r3.push(Integer.valueOf(r1));
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void r(RichTextElement.EmotionProperty r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        SpannableStringBuilder r0 = this.p;
        if (r0 != null) goto L7;
        return;
    L7:
        ((com.ss.android.lark.keyboard.edittext2.edittors.d) q(com.ss.android.lark.keyboard.edittext2.edittors.d.e)).R(r3.getKey(), r0);
    }

    public void s(RichTextElement r1) {
        if (this.r.isEmpty() == true) goto L6;
        this.r.pop();
    L6:
        if (this.s.isEmpty() == true) goto L9;
        this.s.pop();
        return;
    }

    public final void u(RichTextElement.MentionProperty r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        V(null, r2.getContent());
    }

    public final void N(RichTextElement.TextProperty r1, Map<String, String> r2) {
        if (r1 == null) goto L4;
        String r3 = r1.getContent();
    L5:
        V(r2, r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public final void V(Map<String, String> r5, String r6) {
        if (r6 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L18;
        SpannableStringBuilder r2 = this.p;
        if (r2 == null) goto L19;
        Intrinsics.checkNotNullParameter(r6, "content");
        SpannableStringBuilder r3 = new SpannableStringBuilder();
        r3.append(r6);
        if (this.e == false) goto L16;
        lec.f r4 = (lec.f) this.d.getValue();
        r4.d();
        r4.c(r5);
        TextStyleInfo r7 = r4.e(r6);
        c.a(r3, 0, r6.length(), r7);
    L16:
        r2.append(r3);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r6.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public void X(SpannableStringBuilder r4, RichText r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "data");
        this.p = r4;
        com.ss.android.lark.widget.richtext.g.b(r5, this);
        SpannableStringBuilder r6 = this.p;
        if (r6 == null) goto L21;
        if (r5 == null) goto L18;
        RichTextExtraInfo r7 = r5.getExtraInfo();
        if (r7 == null) goto L19;
        LingoLocalExtraData r8 = r7.getLingoLocalExtraData();
        if (r8 == null) goto L22;
        com.ss.android.lark.keyboard.edittext2.span.g[] r0 = (com.ss.android.lark.keyboard.edittext2.span.g[]) r6.getSpans(0, r6.length(), com.ss.android.lark.keyboard.edittext2.span.g.class);
        Intrinsics.checkNotNull(r0);
        if (r0.length != 0) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == false) goto L20;
        com.ss.android.lark.keyboard.edittext2.span.g r2 = new com.ss.android.lark.keyboard.edittext2.span.g();
        r2.b = r8.getPinInfo();
        r2.a = r8.getHighlightIgnoreWords();
        r6.setSpan(r2, 0, r6.length(), 18);
        return;
    L20:
        return;
    L14:
        r1 = false;
        goto L15
    L22:
        return;
    L19:
        return;
    L18:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(RichTextElement.AnchorProperty r6, Map<String, String> r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        SpannableStringBuilder r0 = this.p;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.k == false) goto L10;
        eob.a r1 = (eob.a) q(eob.a.f);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "anchorProperty");
        Iterator<T> r2 = r1.e.values().iterator();
    L16:
        if (r2.hasNext() == false) goto L20;
        fob.c r3 = (fob.c) r2.next();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.keyboard.edittext2.edittors.anchor.base.IAnchorResolver<com.ss.android.lark.widget.richtext.RichTextElement.AnchorProperty, out com.ss.android.lark.keyboard.edittext2.edittors.editinfo.InsertAnchorInfo>");
        fob.c.a r4 = r3.resolve(r6);
        if (r4.a == false) goto L16;
        hob.b r5 = (hob.b) r4.b;
    L21:
        if (r5 != null) goto L24;
        Log.i("RichTextEditor", "insertAnchorElement: insertInfo is null , method return");
        V(r7, r6.getHref());
        return;
    L24:
        if (this.e == false) goto L26;
        r5.b = r7;
    L26:
        r1.R(r5, r0);
        return;
    L20:
        Log.w("AnchorEditor", "parseAnchorProperty: found no anchor strategy to handle anchorProperty");
        r5 = null;
        goto L21
    L10:
        if (this.l == false) goto L12;
        String r8 = r6.getHref();
    L13:
        V(r7, r8);
        return;
    L12:
        r8 = r6.getContent();
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void t(RichTextElement.AtProperty r8, Map<String, String> r9) {
        if (r8 != null) goto L4;
        return;
    L4:
        SpannableStringBuilder r0 = this.p;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.f == true) goto L11;
        V(r9, r8.getAtContent());
        return;
    L11:
        com.ss.android.lark.keyboard.edittext2.edittors.a r1 = (com.ss.android.lark.keyboard.edittext2.edittors.a) q(com.ss.android.lark.keyboard.edittext2.edittors.a.e);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "atProperty");
        boolean r3 = true;
        if (r8.getUserId().length() != 0) goto L14;
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
    L32:
        Log.i("ATEditor", "tryParseAtProperty: chatter id or chatter name is null. now return");
    L33:
        hob.c r4 = null;
    L34:
        if (r4 != null) goto L36;
        Log.i("RichTextEditor", "insertAtElement: insertInfo is null, method return");
        V(r9, r8.getAtContent());
        return;
    L36:
        r4.f = false;
        if (this.e == false) goto L39;
        r4.h = r9;
    L39:
        r1.R(r4, r0);
        return;
    L18:
        if (r8.getAtContent().length() == 0) goto L21;
        r3 = false;
    L21:
        if (r3 == true) goto L32;
        if (r8.isAnonymous() == true) goto L32;
        Iterator r5 = ((LinkedHashMap) r1.c).entrySet().iterator();
    L27:
        if (r5.hasNext() == false) goto L31;
        fob.c.a r6 = ((com.ss.android.lark.keyboard.edittext2.edittors.at.c) ((Map.Entry) r5.next()).getValue()).k(r1, r8);
        if (r6.a == false) goto L27;
        r4 = (hob.c) r6.b;
        goto L34
    L31:
        Log.w("ATEditor", "parseAtProperty: found no at strategy to handle atProperty");
        goto L33
    L14:
        r2 = false;
        goto L16
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public /* bridge */ /* synthetic */ void S(SpannableStringBuilder r1, RichText r2, int r3) {
        X(r1, r2);
    }
}
