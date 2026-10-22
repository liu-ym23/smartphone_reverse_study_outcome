package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.bytedance.lark.pb.im.v1.VisitInfo;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.utils.AuditUtilsV2;
import com.ss.android.lark.chat.base.view.vo.ThreadMessageVO;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.coremd.facade.gennode.SpanToNodeMappers;
import com.ss.android.lark.keyboard.edittext2.utils.RichTextCopyUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.columns.entity.ColumnsInfo;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import com.ss.android.lark.widget.richtext.genv2.RichTextGenerateUtils2;
import com.ss.android.lark.widget.table.entity.TableInfo;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import z5c.d4;
import z5c.q1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMRichTextCopyUtils {
    public static final IMRichTextCopyUtils a = null;
    public static final Lazy b = null;
    public static final CoroutineScope c = null;
    public static final Lazy d = null;

    public interface a {
        void onError(Exception r1);

        void onSuccess();
    }

    public static final class b implements com.ss.android.lark.keyboard.edittext2.utils.f.a {
        public final com.ss.android.lark.keyboard.edittext2.utils.f.a a;

        public b() {
            l0 r0 = l0.a;
            Intrinsics.checkNotNullParameter(r0, "handler");
            this.a = r0;
        }

        public final RichTextElement a(Object r3) {
            Intrinsics.checkNotNullParameter(r3, "span");
            if ((r3 instanceof com.ss.android.lark.widget.light.span.p) == true) goto L6;
            return null;
        L6:
            Object r0 = ((com.ss.android.lark.widget.light.span.p) r3).b;
            if ((r0 instanceof TableInfo) == false) goto L10;
            TableInfo r1 = (TableInfo) r0;
            RichTextElement.TextProperty r4 = new RichTextElement.TextProperty();
            r4.setContent(uec.a.a());
            return RichTextElementCreator.h(r4);
        L10:
            if ((r0 instanceof ColumnsInfo) == false) goto L13;
            ColumnsInfo r2 = (ColumnsInfo) r0;
            RichTextElement.TextProperty r5 = new RichTextElement.TextProperty();
            int r6 = dcc.a.a;
            r5.setContent(UIHelper.getString(2131891027));
            return RichTextElementCreator.h(r5);
        L13:
            return this.a.a(r3);
        }

        public final void e(Spanned r2, List<Object> r3) {
            Intrinsics.checkNotNullParameter(r2, "editable");
            Intrinsics.checkNotNullParameter(r3, "spans");
            this.a.e(r2, r3);
        }

        public final boolean c(Spannable r1, Object r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "editable");
            Intrinsics.checkNotNullParameter(r2, "span");
            Intrinsics.checkNotNullParameter(r1, "editable");
            Intrinsics.checkNotNullParameter(r2, "span");
            return false;
        }
    }

    public IMRichTextCopyUtils() {
    }

    static {
        a = new IMRichTextCopyUtils();
        b = LazyKt.lazy(IMRichTextCopyUtils$statistics$2.INSTANCE);
        c = CoroutineScopeKt.MainScope();
        d = LazyKt.lazy(IMRichTextCopyUtils$copyAuthEnabled$2.INSTANCE);
    }

    @JvmStatic
    public static final Map<String, Object> d(y6b.a<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "vo");
        Map<String, Object> r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("msg_id", r3.getId()), TuplesKt.to("cid", r3.getcId())});
        if ((r3 instanceof y6b.c) == false) goto L6;
        String r1 = ChatParamUtils.a;
        r0.put("msg_type", ChatParamUtils.k(((y6b.c) r3).getType()));
    L6:
        if ((r3 instanceof ThreadMessageVO) == false) goto L8;
        String r2 = ChatParamUtils.a;
        r0.put("msg_type", ChatParamUtils.k(((ThreadMessageVO) r3).getType()));
    L8:
        return r0;
    }

    @JvmStatic
    public static final RichText e(CharSequence r2) {
        RichText r3 = RichTextGenerateUtils2.b(r2, l0.a);
        Log.i("IMRichTextCopyUtils", "generateRichText: richText path is: " + com.ss.android.lark.widget.richtext.utils.d.c(r3));
        return r3;
    }

    @JvmStatic
    public static final RichText f(CharSequence r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        l0 r1 = l0.a;
        return com.ss.android.lark.widget.richtext.c.b(com.ss.android.lark.keyboard.edittext2.utils.f.c(r2, new b()));
    }

    public static RichText g(Context r3, CharSequence r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (r4 != null) goto L7;
        return null;
    L7:
        if ((r4 instanceof Spanned) == false) goto L9;
        t9b.a r1 = t9b.a.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        com.ss.android.lark.coremd.impl.buildnode.d r2 = new com.ss.android.lark.coremd.impl.buildnode.d(r3);
        SpanToNodeMappers r5 = SpanToNodeMappers.a;
        u9b.a.a(r2, com.ss.android.lark.coremdbiz.facade.a.c());
        v7b.s r6 = r2.b(r4);
        Intrinsics.checkNotNullParameter(t9b.b.a, "<this>");
        Intrinsics.checkNotNullParameter(r3, "context");
        com.ss.android.lark.richtextmd.generate.c r0 = new com.ss.android.lark.richtextmd.generate.c(r3);
        com.ss.android.lark.richtextmd.generate.a.a(r0, IMRichTextCopyUtils$getMessageRichTextV2$1.INSTANCE);
        return r0.b(r6);
    L9:
        return com.ss.android.lark.widget.richtext.c.c(r4.toString());
    }

    @JvmStatic
    public static final RichText h(RichText r5, y6b.a<?> r6) {
        Intrinsics.checkNotNullParameter(r6, "messageVO");
        PostContentVO r1 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        IMRichTextCopyUtils r2 = a;
        if (MessagePermissionUtil.k(r6, BuildConfig.FLAVOR) == false) goto L10;
        Lazy r3 = AuditUtilsV2.a;
        if (AuditUtilsV2.b() == true) goto L10;
    L14:
        String r4 = r6.getChatId();
        if (r4.length() != 0) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == false) goto L21;
    L26:
        Intrinsics.checkNotNullParameter(r5, "richText");
        Intrinsics.checkNotNullParameter(r6, "messageVO");
        if (r6.isPreMessage() == false) goto L30;
        k(r5, SetsKt.mutableSetOf(new RichTextElement.RichTextTag[]{RichTextElement.RichTextTag.MEDIA}));
    L30:
        return r5;
    L21:
        if (r5.getExtraInfo() != null) goto L23;
        r5.setExtraInfo(new RichTextExtraInfo());
    L23:
        RichTextExtraInfo r8 = r5.getExtraInfo();
        if (r8 == null) goto L26;
        r8.setCurChatId(r4);
        goto L26
    L17:
        r7 = false;
    L10:
        Object r9 = r6.b();
        if ((r9 instanceof PostContentVO) == false) goto L13;
        r1 = (PostContentVO) r9;
    L13:
        r2.b(r5, r1);
        goto L14
    }

    @JvmStatic
    public static final CharSequence j(CharSequence r1, RichText r2) {
        Intrinsics.checkNotNullParameter(r1, "content");
        RichTextCopyUtils.e(r1, r2);
        return RichTextCopyUtils.a(r1.toString());
    }

    public static void k(RichText r3, Set r4) {
        Intrinsics.checkNotNullParameter(r3, "richText");
        Intrinsics.checkNotNullParameter(r4, "needRemovedTags");
        Map r0 = r3.getElements().getDictionary();
        List r1 = r3.getElementIds();
        Intrinsics.checkNotNull(r1);
        Iterator r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        RichTextElement r5 = (RichTextElement) r0.get((String) r2.next());
        if (r5 == null) goto L4;
        Intrinsics.checkNotNull(r0);
        c(r3, r5, r0, r4);
        goto L4
    }

    public final RichText b(RichText r7, PostContentVO r8) {
        Intrinsics.checkNotNullParameter(r7, "richText");
        List r1 = r7.getImageIds();
        List r2 = r7.getMediaIds();
        List r3 = r1;
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L38;
        List r5 = r2;
        if (r5 != null) goto L14;
    L17:
        boolean r6 = true;
    L18:
        if (r6 == false) goto L38;
        if (((Boolean) d.getValue()).booleanValue() == false) goto L36;
        if (r8 == null) goto L23;
        Object r9 = r8.g;
    L24:
        if (r9 == null) goto L36;
        Log.i("IMRichTextCopyUtils", "translateInfo is not null, search for valid image or media property.");
        Set r10 = SetsKt.setOf(new RichTextElement.RichTextTag[]{RichTextElement.RichTextTag.IMG, RichTextElement.RichTextTag.MEDIA});
        Intrinsics.checkNotNullParameter(r7, "richText");
        Intrinsics.checkNotNullParameter(r10, "targetTags");
        Map r0 = r7.getElements().getDictionary();
        List r11 = r7.getElementIds();
        Intrinsics.checkNotNull(r11);
        Iterator r12 = r11.iterator();
    L27:
        if (r12.hasNext() == false) goto L33;
        RichTextElement r13 = (RichTextElement) r0.get((String) r12.next());
        if (r13 == null) goto L27;
        Intrinsics.checkNotNull(r0);
        if (i(r13, r0, r10) == false) goto L27;
        boolean r14 = true;
    L34:
        if (r14 == true) goto L38;
        return r7;
    L33:
        r14 = false;
        goto L34
    L23:
        r9 = null;
    L36:
        Log.i("IMRichTextCopyUtils", "filterRichTextBySecurePolicyInner: richText has no image or media, skip checking security policy");
        return r7;
    L14:
        if (r5.isEmpty() == true) goto L17;
        r6 = false;
    L38:
        w4b.a r15 = ChatCoreModule.a().getAuditDependency();
        ValidateResult r16 = r15.d();
        r15.a(r16, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        boolean r17 = !r15.isAuthorizationPassed(r16);
        boolean r18 = !r15.b();
        if (r17 == true) goto L43;
        if (r18 == true) goto L43;
        boolean r19 = false;
    L44:
        if (r19 == true) goto L46;
        return r7;
    L46:
        k(r7, SetsKt.mutableSetOf(new RichTextElement.RichTextTag[]{RichTextElement.RichTextTag.IMG, RichTextElement.RichTextTag.MEDIA}));
        return r7;
    L43:
        r19 = true;
        goto L44
    L5:
        if (r3.isEmpty() == true) goto L8;
        r4 = false;
        goto L10
    }

    public static boolean i(RichTextElement r2, Map r3, Set r4) {
        if (r4.contains(r2.getTag()) == false) goto L5;
        return true;
    L5:
        List r5 = r2.getChildIds();
        if (r5 == null) goto L15;
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L23;
        RichTextElement r0 = (RichTextElement) r3.get((String) r6.next());
        if (r0 == null) goto L9;
        if (i(r0, r3, r4) == false) goto L9;
        return true;
    L23:
        return false;
    L15:
        return false;
    }

    @JvmStatic
    public static final void l(boolean r4, RichText r5, Map<String, ? extends Object> r6) {
        z5c.a1 r0 = z5c.a1.c;
        Integer r1 = null;
        if (r5 == null) goto L7;
        List r2 = r5.getImageIds();
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.size());
    L8:
        s5c.a r7 = r0.a(String.valueOf(r3));
        d4 r8 = d4.c;
        if (r5 == null) goto L13;
        List r9 = r5.getMediaIds();
        if (r9 == null) goto L13;
        r1 = Integer.valueOf(r9.size());
    L13:
        s5c.a r10 = r8.a(String.valueOf(r1));
        if (r4 == false) goto L16;
        s5c.a r11 = q1.d;
    L17:
        s5c.a r12 = z5c.s0.c.a(DocTabPayload.DocType.UNKNOWN);
        ((o5c.b) b.getValue()).sendEvent("im_msg_copy_click", s5c.d.b.b(r7, r10).plus(r11).plus(r12).plus(z5c.y.c).plus(r6).toJson());
        return;
    L16:
        r11 = q1.c;
    L7:
        r3 = null;
        goto L8
    }

    @JvmStatic
    public static final void a(Context r16, String r17, CharSequence r18, String r19) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "selectedMarkdown");
        Intrinsics.checkNotNullParameter(r19, "messageId");
        if (r17.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        Editable r3 = null;
        Object r4 = null;
        if ((r18 instanceof Spanned) == false) goto L20;
        SpannableStringBuilder r10 = new SpannableStringBuilder(r18);
        Object[] r1 = r10.getSpans(0, r10.length(), com.ss.android.lark.coremd.impl.buildnode.a.class);
        int r5 = r1.length;
        int r6 = 0;
    L11:
        if (r6 >= r5) goto L16;
        Object r7 = r1[r6];
        if ((((com.ss.android.lark.coremd.impl.buildnode.a) r7).a instanceof eab.e) == true) goto L14;
        r6 = r6 + 1;
        goto L11
    L14:
        r4 = r7;
    L16:
        com.ss.android.lark.coremd.impl.buildnode.a r11 = (com.ss.android.lark.coremd.impl.buildnode.a) r4;
        if (r11 == null) goto L19;
        v7b.s r8 = r11.a;
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.ss.android.lark.coremdbiz.facade.node.MarkdownNode");
        eab.e r9 = (eab.e) r8;
        int r12 = r10.getSpanStart(r11);
        int r13 = r10.getSpanEnd(r11);
        int r14 = r10.getSpanFlags(r11);
        eab.e r15 = new eab.e(r17, r9.k, r9.l, r9.m, r9.n);
        r10.removeSpan(r11);
        r10.setSpan(new com.ss.android.lark.coremd.impl.buildnode.a(r15, r10.subSequence(r12, r13).toString(), false), r12, r13, r14);
    L19:
        r3 = r10;
    L20:
        RichText r20 = g(r16, r3);
        b7b.b.b(r16, j(r17, r20), r20, r19, new Token("LARK-PSDA-messenger-android-copy-movable-markdown"), true);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static void c(RichText r6, RichTextElement r7, Map r8, Set r9) {
        List r10 = r7.getChildIds();
        r6.setImageIds(CollectionsKt.toMutableList(r6.getImageIds()));
        r6.setMediaIds(CollectionsKt.toMutableList(r6.getMediaIds()));
        if (r10 == null) goto L20;
        Iterator r0 = r10.iterator();
    L6:
        if (r0.hasNext() == false) goto L20;
        String r1 = (String) r0.next();
        RichTextElement r2 = (RichTextElement) r8.get(r1);
        RichTextElement.RichTextTag r3 = RichTextElement.RichTextTag.IMG;
        RichTextElement.RichTextTag r5 = null;
        if (r9.contains(r3) == false) goto L14;
        if (r2 == null) goto L11;
        RichTextElement.RichTextTag r4 = r2.getTag();
    L12:
        if (r4 != r3) goto L14;
        r6.getImageIds().remove(r1);
        r8.remove(r1);
        r8.put(r1, RichTextElementCreator.e(UIHelper.getString(2131891845)));
        goto L14
    L11:
        r4 = null;
    L14:
        RichTextElement.RichTextTag r11 = RichTextElement.RichTextTag.MEDIA;
        if (r9.contains(r11) == false) goto L6;
        if (r2 == null) goto L18;
        r5 = r2.getTag();
    L18:
        if (r5 != r11) goto L6;
        r6.getMediaIds().remove(r1);
        r8.remove(r1);
        r8.put(r1, RichTextElementCreator.e(UIHelper.getString(2131891923)));
    L20:
        if (r10 == null) goto L27;
        Iterator r12 = r10.iterator();
    L23:
        if (r12.hasNext() == false) goto L40;
        RichTextElement r13 = (RichTextElement) r8.get((String) r12.next());
        if (r13 == null) goto L23;
        c(r6, r13, r8, r9);
        goto L23
    L40:
        return;
    }

    @JvmStatic
    public static final void m(Context r12, CharSequence r13, RichText r14, VisitInfo r15, Token r16, b7b.b.a r17) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "content");
        Intrinsics.checkNotNullParameter(r15, "visitInfo");
        Intrinsics.checkNotNullParameter(r16, "copyToken");
        Intrinsics.checkNotNullParameter(r17, "callback");
        if (r13.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        BuildersKt.launch$default(c, null, null, new IMRichTextCopyUtils$writeClipboardWithHtml$1(r14, r15, r12, r13, r16, r17, null), 3, null);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
