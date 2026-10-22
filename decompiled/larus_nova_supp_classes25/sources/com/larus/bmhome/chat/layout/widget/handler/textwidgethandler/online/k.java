package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.online;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.widget.ThreeLoadingIndicator;
import com.larus.bmhome.chat.layout.widget.handler.w;
import com.larus.bmhome.chat.layout.widget.v0;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.utils.u2;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.IMMetaInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import fh8.x;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k implements pw8.b {
    public static boolean d;
    public final hf8.a a;
    public long b;
    public final Lazy c;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.e;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "CitationSpanInfo(inlineType=" + this.a + ", inlineText=" + this.b + ", docId=" + this.c + ", docPosition=" + this.d + ", inlineDisplayPosition=" + this.e + ')';
        }

        public a(String r2, String r3, String r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "inlineType");
            Intrinsics.checkNotNullParameter(r3, "inlineText");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class b {
    }

    static {
    }

    public final boolean c(uvc.b r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        return true;
    }

    public final int priority() {
        return 1;
    }

    public final boolean n() {
        Map r0 = this.a.b.getExt();
        if (r0 == null) goto L5;
        String r1 = (String) r0.get("text2image_text_finish");
    L7:
        return Intrinsics.areEqual(r1, "1");
    L5:
        r1 = null;
        goto L7
    }

    public k(hf8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "markdownTextViewWidgetHandlerParams");
        this.a = r2;
        this.c = LazyKt.lazy(new c(this));
    }

    public final String k(SpannableStringBuilder r6) {
        boolean r1 = false;
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L12;
        int r2 = r6.length();
        ReplacementSpan[] r3 = (ReplacementSpan[]) r6.getSpans(r2 - 1, r2, ReplacementSpan.class);
        Intrinsics.checkNotNull(r3);
        if (r3.length != 0) goto L11;
        r1 = true;
    L11:
        r1 = !r1;
    L12:
        if (r1 == false) goto L15;
        return "";
    L15:
        o(this.a.k);
        r6.append("⚫", this.a.k, 17);
        return "⚫";
    L5:
        r0 = false;
        goto L6
    }

    public final Map<String, Object> l(Message r3) {
        w r0 = w.a;
        fh8.f r1 = this.a.e;
        if (r1 == null) goto L5;
        fh8.g r2 = fh8.h.a(r1);
        r2.b = r3;
        fh8.f r4 = r2.a();
    L6:
        r0.getClass();
        return w.a(r4);
    L5:
        r4 = new fh8.f(0);
        goto L6
    }

    public final JSONObject m(Message r4) {
        JSONObject r0 = new JSONObject();
        q0.a r1 = this.a.i;
        if (r1 == null) goto L8;
        y r2 = r1.u0();
        if (r2 == null) goto L8;
        String r3 = r2.getBotId();
        if (r3 == null) goto L8;
    L9:
        r0.put("bot_id", r3);
        r0.put("message_id", r4.getMessageId());
        r0.put("conversation_id", r4.getConversationId());
        r0.put("footnote_style", ChatDraftItem.TYPE_TEXT);
        return r0;
    L8:
        r3 = "";
        goto L9
    }

    public final void o(v0 r3) {
        if (r3 == null) goto L4;
        Drawable r4 = r3.getDrawable();
    L5:
        int r0 = (int) (i5.r0() * ((Number) this.c.getValue()).floatValue());
        if (r4 == null) goto L9;
        r4.setBounds(0, 0, r0, r0);
        return;
    L9:
        return;
    L4:
        r4 = null;
        goto L5
    }

    public static final void d(k r9, CustomMarkdownTextView r10) {
        com.larus.bmhome.chat.layout.widget.handler.q r0 = r9.a.u;
        if (r0 == null) goto L24;
        int r1 = r0.a;
        if (r1 == 0) goto L7;
        r10.setTextColor(r1);
    L7:
        float r3 = r0.b;
        boolean r8 = false;
        if (r3 <= 0.0f) goto L14;
        Boolean r2 = r9.a.g;
        if (r2 == null) goto L12;
        boolean r4 = r2.booleanValue();
    L13:
        we8.a.b(r10, r3, r4, null, null, 12);
        goto L14
    L12:
        r4 = false;
    L14:
        int r5 = r0.c;
        if (r5 <= 0) goto L20;
        Boolean r11 = r9.a.g;
        if (r11 == null) goto L19;
        r8 = r11.booleanValue();
    L19:
        r10.setLineHeight((int) we8.a.a(r5, r8));
    L20:
        RectF r12 = r0.d;
        if (r12 == null) goto L25;
        r10.setPadding((int) r12.left, (int) r12.top, (int) r12.right, (int) r12.bottom);
        return;
    L25:
        return;
    }

    public static final a e(k r9, lw8.g r10) {
        r9.getClass();
        Uri r11 = UriProtector.parse(r10.a());
        String r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Set<String> r2 = com.larus.bmhome.chat.list.trace.a.a;     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L13
        JSONObject r3 = com.larus.bmhome.chat.list.trace.a.b(r11);     // Catch: Throwable -> L13
        String r12 = UriProtector.getQueryParameter(r11, "inline_doc_id");     // Catch: Throwable -> L13
        if (r12 != null) goto L36;
        r12 = r3.optString("doc_id");     // Catch: Throwable -> L13
    L36:
        String r4 = r3.optString("inline_display_position");     // Catch: Throwable -> L11
        r0 = r3.optString("doc_position");     // Catch: Throwable -> L9
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L16:
        String r6 = r12;
        String r7 = r0;
        String r8 = r4;
        if (new Regex("^\\[\\d{1,2}\\]$").matches(r10.getTitle()) == false) goto L21;
        String r5 = "number";
    L19:
        String r13 = r5;
        if (new Regex("^\\[\\d{1,2}\\]$").matches(r10.getTitle()) == false) goto L29;
        String r14 = StringsKt.trim(r10.getTitle(), new char[]{'[', ']'});
    L33:
        return new a(r13, r14, r6, r7, r8);
    L29:
        if (Intrinsics.areEqual(r10.getTitle(), "[__LINK_ICON]") == false) goto L31;
        r14 = "";
        goto L33
    L31:
        r14 = StringsKt.trim(StringsKt.trim(r10.getTitle(), new char[]{'[', ']'}), new char[]{'(', ')'});
        goto L33
    L21:
        if (Intrinsics.areEqual(r10.getTitle(), "[__LINK_ICON]") == false) goto L23;
        r5 = "link";
        goto L19
    L23:
        r5 = "icon";
    L9:
        Throwable th = th;
    L15:
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L11:
        th = th;
        r4 = null;
    L13:
        th = move-exception;
        th = th;
        r12 = null;
        r4 = null;
        goto L15
    }

    public static final String f(k r13, String r14) {
        r13.getClass();
        if (r14.length() != 0) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L8;
        return "";
    L8:
        StringBuilder r16 = new StringBuilder();
        Regex r2 = new Regex("\\[(.*?)]\\((.*?)\\)");
        Iterator r17 = StringsKt.split$default(r14, new String[]{"\n"}, false, 0, 6, null).iterator();
    L10:
        if (r17.hasNext() == false) goto L34;
        List r5 = StringsKt.split$default(StringsKt.trim((String) r17.next()).toString(), new String[]{"|"}, false, 0, 6, null);
        Iterator r6 = r5.iterator();
        int r7 = 0;
    L13:
        if (r6.hasNext() == false) goto L32;
        Object r8 = r6.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        String r10 = (String) r8;
        if (r10.length() <= 0) goto L20;
        boolean r11 = true;
    L21:
        if (r11 == false) goto L29;
        if (StringsKt.startsWith$default(r10, "<data-", false, 2, null) == true) goto L29;
        if (r2.containsMatchIn(r10) == false) goto L27;
        r10 = r2.replace(r10, new j());
    L27:
        r16.append(r10);
    L29:
        if (r7 == (r5.size() - 1)) goto L31;
        r16.append("|");
    L31:
        r7 = r9;
        goto L13
    L20:
        r11 = false;
        goto L21
    L32:
        r16.append("\n");
        goto L10
    L34:
        return r16.toString();
    L5:
        r15 = false;
        goto L6
    }

    public static final void j(final k r1, final Context r2, final CustomMarkdownTextView r3) {
        if (r1.a.t == false) goto L5;
        r3.setDownListener(null);
        return;
    L5:
        r3.setDownListener(new g(r2));
        r3.setOnClickListener(new h(r1, r3));
        r3.setOnLongClickListener(new i(r1, r3));
        Function1<CustomMarkdownTextView, Unit> r4 = r1.a.v;
        if (r4 == null) goto L10;
        r4.invoke(r3);
        return;
    }

    public static final void g(k r10, CustomMarkdownTextView r11, lw8.l r12, Message r13) {
        r10.getClass();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MarkdownTextViewWidgetHandler$markdownClickSpanOnShow$1(r12, r10, r13, r11, null), 3, null);
    }

    public static final void h(k r3, CustomMarkdownTextView r4, Message r5, BotModel r6, Map r7) {
        r3.getClass();
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, "conversationId", r5.getConversationId());
        q0 r1 = r3.a.f;
        Message r2 = null;
        if (r1 == null) goto L5;
        ChatMessageList r8 = r1.B7();
    L6:
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, "chatMessageList", new WeakReference(r8));
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, "chatMessage", r5);
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, "botId", r6.getBotId());
        q0 r0 = r3.a.f;
        if (r0 == null) goto L9;
        r2 = r0.C7(r5);
    L9:
        hc8.c r9 = hc8.c.a;
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, r9.b(), r6);
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, r9.i(), r5);
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, r9.l(), new WeakReference(r3.a.i));
        String r10 = r9.c();
        String r11 = r3.a.d.c;
        if (r11 != null) goto L12;
        r11 = "";
    L12:
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, r10, r11);
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, r9.n(), r2);
        r4.setPayload(r7);
        return;
    L5:
        r8 = null;
        goto L6
    }

    public final pw8.a a(Context r22, int r23, uvc.b r24, Boolean r25, lw8.h r26) {
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r24, "node");
        hf8.a r0 = this.a;
        Message r4 = r0.b;
        BotModel r5 = r0.c;
        Map<String, Object> r6 = l(r4);
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        gw8.c.a.getClass();
        gw8.c r10 = gw8.c.a.b();
        lw8.l r11 = null;
        if (r10 == null) goto L9;
        hf8.a r12 = this.a;
        boolean r14 = !r12.r;
        lw8.d r15 = r12.h;
        ConcurrentHashMap<String, CharSequence> r13 = r12.a;
        if (r13 == null) goto L7;
        CharSequence r16 = r13.get(r4.getMessageId());
    L8:
        r11 = r10.createMarkdownContentFromNode(r22, r23, r24, r14, r15, r16, r6, r26, new lw8.i(vg8.e.b(), this.a.D, false, null), new com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.online.a(r8));
        goto L9
    L7:
        r16 = null;
    L9:
        if (r11 == null) goto L60;
        SpannableStringBuilder r1 = r11.e();
        if (this.a.x == false) goto L18;
        if (Intrinsics.areEqual(r25, Boolean.TRUE) == false) goto L18;
        if (this.a.s == false) goto L18;
        r1.append("...");
    L52:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L60;
        ConcurrentHashMap<String, CharSequence> r2 = this.a.a;
        if (r2 == null) goto L60;
        String r7 = r4.getMessageId();
        if (r7 != null) goto L58;
        r7 = "";
    L58:
        CharSequence r3 = r2.put(r7, r1);
    L18:
        if (this.a.x == false) goto L43;
        if (Intrinsics.areEqual(r25, Boolean.TRUE) == false) goto L43;
        hf8.a r9 = this.a;
        if (r9.t == false) goto L43;
        ThreeLoadingIndicator r17 = r9.l;
        if (r17 == null) goto L52;
        List<v0> r18 = r17.b;
        if (r18 == null) goto L52;
        Iterator<T> r19 = r18.iterator();
    L29:
        if (r19.hasNext() == false) goto L52;
        v0 r110 = (v0) r19.next();
        o(r110);
        String r111 = r4.getContent();
        if (r111 == null) goto L40;
        if (r111.length() != 0) goto L35;
        boolean r112 = true;
    L37:
        if (r112 != true) goto L40;
        boolean r113 = true;
    L41:
        r110.f = r113;
        r1.append("⚫", r110, 17);
        goto L29
    L35:
        r112 = false;
    L40:
        r113 = false;
    L43:
        if (this.a.x == false) goto L52;
        if (Intrinsics.areEqual(r25, Boolean.TRUE) == false) goto L52;
        if (this.a.r == false) goto L52;
        if (n() == true) goto L52;
        k(r1);
    L60:
        return new m(r22, this, r25, r4, r5, r6, r11, r8);
    }

    public static final void i(final k r15, Block r16, final CustomMarkdownTextView r17, lw8.l r18, final BotModel r19, final Message r20, Context r21) {
        r15.getClass();
        if (r18 == null) goto L5;
        r18.b(new d(r15, r20), new e(r15, r20));
    L5:
        if (r16 == null) goto L8;
        List<IMMetaInfo.f> r0 = com.larus.bmhome.chat.bean.d.d1(r16);
        if (r0 == null) goto L8;
    L9:
        final List<IMMetaInfo.f> r1 = r0;
        if (r18 == null) goto L12;
        x.a(r18, new f(r1, r20, r19, r15, r17));
    L12:
        if (r18 == null) goto L15;
        r18.g(r17, new o(r15, r20, r19));
    L15:
        if (r18 == null) goto L17;
        r18.d(r17, new q(r15, r20, r19, r21, r17));
    L17:
        if (r18 == null) goto L19;
        r18.h(r17, new r(r21, r20, r19, r15, r17));
    L19:
        q0 r2 = r15.a.f;
        if (r2 == null) goto L29;
        u2 r3 = r2.G7();
        if (r3 == null) goto L29;
        String r4 = r20.getMessageId();
        if (r4 != null) goto L26;
        r4 = "";
    L26:
        Intrinsics.checkNotNullParameter(r4, "msgId");
        boolean r5 = r3.a.contains(r4);
        boolean r6 = true;
        if (r5 != true) goto L29;
    L30:
        if (r6 == false) goto L32;
        return;
    L32:
        if (r15.a.r == true) goto L36;
        by7.e r7 = by7.h.g(r17);
        s r8 = new s(CoroutineExceptionHandler.Key);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(r8)), null, null, new MarkdownTextViewWidgetHandler$setMarkdownClickSpanListener$1$7(r18, r19, r15, r20, r7, null), 3, null);
        return;
    L36:
        return;
    L29:
        r6 = false;
    L8:
        r0 = com.larus.bmhome.chat.bean.d.c1(r20);
        goto L9
    }

    public final pw8.a b(Context r23, int r24, int r25, ViewGroup r26, uvc.b r27, Boolean r28, lw8.h r29) {
        Intrinsics.checkNotNullParameter(r23, "context");
        Intrinsics.checkNotNullParameter(r26, "currentViewGroup");
        Intrinsics.checkNotNullParameter(r27, "node");
        hf8.a r3 = this.a;
        Message r5 = r3.b;
        BotModel r6 = r3.c;
        Map<String, Object> r8 = l(r5);
        lw8.l r11 = null;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L7;
        ConcurrentHashMap<String, CharSequence> r1 = this.a.a;
        if (r1 == null) goto L21;
        CharSequence r2 = r1.get(r5.getMessageId() + '-' + r25);
    L20:
        CharSequence r17 = r2;
    L22:
        final Ref.ObjectRef r4 = new Ref.ObjectRef();
        gw8.c.a.getClass();
        gw8.c r7 = gw8.c.a.b();
        if (r7 == null) goto L51;
        hf8.a r12 = this.a;
        boolean r16 = !r12.r;
        lw8.d r13 = r12.h;
        boolean r14 = vg8.e.b();
        View r9 = this.a.D;
        if (vg8.e.b() == false) goto L49;
        hf8.a r15 = this.a;
        if (r15.E == false) goto L49;
        if (r15.x == false) goto L49;
        if (Intrinsics.areEqual(r28, Boolean.TRUE) == false) goto L49;
        hf8.a r18 = this.a;
        if (r18.r == false) goto L49;
        if (r18.s == true) goto L49;
        if (r18.t == true) goto L49;
        if (n() == true) goto L49;
        String r19 = this.a.F;
        if (r19 != null) goto L43;
    L46:
        boolean r110 = true;
    L47:
        if (r110 == true) goto L49;
        boolean r111 = true;
    L50:
        boolean r10 = true;
        r11 = r7.createMarkdownContentFromNode(r23, r24, r27, r16, r13, r17, r8, r29, new lw8.i(r14, r9, r111, this.a.F), new com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.online.b(r4));
    L52:
        Ref.ObjectRef r20 = new Ref.ObjectRef();
        r20.element = "";
        Ref.BooleanRef r21 = new Ref.BooleanRef();
        if (r11 == null) goto L99;
        SpannableStringBuilder r112 = r11.e();
        if (this.a.x == false) goto L62;
        if (Intrinsics.areEqual(r28, Boolean.TRUE) == false) goto L62;
        if (this.a.s == false) goto L62;
        r20.element = "...";
        r112.append("...");
    L94:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L99;
        r21.element = r10;
        ConcurrentHashMap<String, CharSequence> r22 = this.a.a;
        if (r22 == null) goto L99;
        CharSequence r0 = r22.put(r5.getMessageId() + '-' + r25, r112);
    L62:
        if (this.a.x == false) goto L85;
        if (Intrinsics.areEqual(r28, Boolean.TRUE) == false) goto L85;
        hf8.a r113 = this.a;
        if (r113.t == false) goto L85;
        ThreeLoadingIndicator r30 = r113.l;
        if (r30 == null) goto L94;
        List<v0> r31 = r30.b;
        if (r31 == null) goto L94;
        Iterator<T> r32 = r31.iterator();
    L73:
        if (r32.hasNext() == false) goto L94;
        v0 r114 = (v0) r32.next();
        o(r114);
        String r115 = r5.getContent();
        if (r115 != null) goto L77;
    L82:
        boolean r116 = false;
    L83:
        r114.f = r116;
        r112.append("⚫", r114, 17);
        goto L73
    L77:
        if (r115.length() != 0) goto L79;
        boolean r117 = true;
    L80:
        if (r117 != r10) goto L82;
        r116 = true;
        goto L83
    L79:
        r117 = false;
    L85:
        if (this.a.x == false) goto L94;
        if (Intrinsics.areEqual(r28, Boolean.TRUE) == false) goto L94;
        if (this.a.r == false) goto L94;
        if (n() == true) goto L94;
        r20.element = k(r112);
    L99:
        return new u(r21, this, r5, r6, r8, r11, r23, r20, r4);
    L43:
        if (r19.length() == 0) goto L46;
        r110 = false;
    L49:
        r111 = false;
        goto L50
    L51:
        r10 = true;
    L21:
        r17 = null;
        goto L22
    L7:
        View r33 = r26.getChildAt(r25);
        if ((r33 instanceof FrameLayout) == false) goto L10;
        FrameLayout r34 = (FrameLayout) r33;
    L11:
        if (r34 == null) goto L13;
        View r35 = r34.getChildAt(0);
    L15:
        if ((r35 instanceof CustomMarkdownTextView) == false) goto L17;
        CustomMarkdownTextView r36 = (CustomMarkdownTextView) r35;
    L18:
        if (r36 == null) goto L21;
        r2 = r36.getText();
        goto L20
    L17:
        r36 = null;
        goto L18
    L13:
        r35 = null;
        goto L15
    L10:
        r34 = null;
        goto L11
    }
}
