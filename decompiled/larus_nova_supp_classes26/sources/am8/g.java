package am8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.im.bean.message.ContainerAttribute;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.RichMediaMeta;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.SearchRuyiCardItem;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import pg9.i;
import va8.p;
import va8.x;
import va8.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements usc.f {
    public final zl8.e a;

    public static final class a implements Function0<y> {
        public final /* synthetic */ AttachReceiver a;

        public a(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(y.class));
        }
    }

    public static final class b implements Function0<x> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(x.class));
        }
    }

    public static final class c implements Function0<p> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(p.class));
        }
    }

    public final void a() {
    }

    public final Integer b(Size r1, TextView r2, Canvas r3, Paint r4) {
        return null;
    }

    public final Size c(TextView r1, usc.e r2, Map<String, ? extends Object> r3) {
        return null;
    }

    public final void e() {
    }

    public final View asView() {
        return this.a.b();
    }

    public final void f() {
        this.a.c();
    }

    public g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = new zl8.e(r2);
    }

    public final Size d(TextView r26, Spanned r27, final usc.e r28, int r29, Map<String, ? extends Object> r30) {
        Intrinsics.checkNotNullParameter(r26, "textView");
        Intrinsics.checkNotNullParameter(r27, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r28, "span");
        boolean r13 = Intrinsics.areEqual(r28.i(), "data-block-full");
        if (r30 == null) goto L5;
        Object r0 = r30.get("markdown_common_input_data");
    L7:
        if ((r0 instanceof fh8.f) == false) goto L9;
        final fh8.f r15 = (fh8.f) r0;
    L10:
        if (r15 == null) goto L12;
        RecyclerView.Adapter r1 = r15.p;
    L14:
        if ((r1 instanceof ry8.d) == false) goto L16;
        ry8.d r2 = (ry8.d) r1;
    L17:
        if (r2 == null) goto L19;
        r2.l0(new d(r15));
    L19:
        if (r15 == null) goto L21;
        Message r10 = r15.b;
    L22:
        if (r15 == null) goto L28;
        AttachReceiver r3 = r15.o;
        if (r3 == null) goto L28;
        Lazy r4 = LazyKt.lazy(new a(r3));
        if (r4 == null) goto L28;
        final y r6 = (y) r4.getValue();
    L29:
        if (r15 == null) goto L35;
        AttachReceiver r5 = r15.o;
        if (r5 == null) goto L35;
        Lazy r7 = LazyKt.lazy(new b(r5));
        if (r7 == null) goto L35;
        x r8 = (x) r7.getValue();
    L36:
        if (r15 == null) goto L42;
        AttachReceiver r9 = r15.o;
        if (r9 == null) goto L42;
        Lazy r11 = LazyKt.lazy(new c(r9));
        if (r11 == null) goto L42;
        final p r12 = (p) r11.getValue();
    L43:
        wc8.b r14 = wc8.b.a;
        if (r10 == null) goto L46;
        String r16 = r10.getMessageId();
    L47:
        RichMediaMeta r17 = r14.h(r16, r28.k(), "MarkdownLynxWidget");
        if (r17 == null) goto L54;
        List r18 = r17.getMedia();
        if (r18 == null) goto L54;
        RichMediaItem r19 = (RichMediaItem) CollectionsKt.firstOrNull(r18);
        if (r19 == null) goto L54;
        SearchRuyiCardItem r20 = r19.ruyi;
    L56:
        if (r20 != null) goto L79;
        if (r28.k().length() != 0) goto L60;
        boolean r21 = true;
    L61:
        if (r21 == false) goto L63;
        String r22 = r28.h();
    L193:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L69
        Object r24 = Result.constructor-impl((SearchRuyiCardItem) new Gson().fromJson(r22, new h().getType()));     // Catch: Throwable -> L69
    L72:
        if (Result.isFailure-impl(r24) == false) goto L74;
        r24 = null;
    L74:
        r20 = (SearchRuyiCardItem) r24;
        if (r20 != null) goto L79;
        return new Size(0, 0);
    L69:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L72
    L63:
        if (r10 == null) goto L65;
        String r31 = r10.getMessageId();
    L66:
        r22 = r14.c(r31, r28.k(), "MarkdownLynxWidget");
        goto L193
    L65:
        r31 = null;
        goto L66
    L60:
        r21 = false;
    L79:
        if (r27.getSpanStart(r28) != 0) goto L81;
        boolean r32 = true;
    L83:
        if (r27.getSpanEnd(r28) != r27.length()) goto L85;
        boolean r33 = true;
    L86:
        wc8.b r34 = wc8.b.a;
        if (r10 == null) goto L89;
        String r110 = r10.getMessageId();
    L90:
        RichMediaMeta r35 = r34.h(r110, r28.k(), "MarkdownLynxWidget");
        if (r35 == null) goto L93;
        ContainerAttribute r36 = r35.getContainerAttribute();
    L94:
        if (r36 == null) goto L96;
        boolean r111 = Intrinsics.areEqual(r36.isFullWidth(), Boolean.TRUE);
    L97:
        String r37 = r20.data;
        if (r37 == null) goto L100;
        JSONObject r112 = new JSONObject(r37);
    L101:
        HashMap r38 = new HashMap();
        String r113 = r20.templateId;
        if (r113 != null) goto L104;
        r113 = "";
    L104:
        r38.put("templateId", r113);
        if (r10 == null) goto L107;
        String r114 = r10.getSenderId();
    L108:
        r38.put("botId", r114);
        if (r10 == null) goto L111;
        String r115 = r10.getMessageId();
    L112:
        r38.put("messageId", r115);
        if (r10 == null) goto L115;
        String r116 = r10.getConversationId();
    L116:
        r38.put("conversationId", r116);
        if (r8 == null) goto L119;
        String r117 = r8.jd();
    L120:
        r38.put("chatType", r117);
        if (r10 == null) goto L123;
        String r118 = r10.getReplyId();
    L124:
        r38.put("replyId", r118);
        if (r8 == null) goto L127;
        String r119 = r8.k();
    L128:
        r38.put("currentPage", r119);
        if (r8 == null) goto L131;
        String r39 = r8.L1();
    L132:
        r38.put("previousPage", r39);
        if (Intrinsics.areEqual(r28.i(), "data-inline-no-margin") == false) goto L135;
    L138:
        int r120 = 1;
    L139:
        r38.put("cardInText", Integer.valueOf(r120));
        if (r12 == null) goto L156;
        List r40 = r12.getCurrentList();
        if (r40 == null) goto L156;
        Iterator r41 = r40.iterator();
    L145:
        if (r41.hasNext() == false) goto L154;
        Object r121 = r41.next();
        String r122 = ((Message) r121).getMessageId();
        if (r10 == null) goto L149;
        String r42 = r10.getReplyId();
    L151:
        if (Intrinsics.areEqual(r122, r42) == false) goto L145;
    L155:
        Message r123 = (Message) r121;
    L157:
        if (r123 == null) goto L159;
        String r43 = com.larus.bmhome.chat.bean.d.x(r123).getActionBarKey();
    L160:
        r38.put("actionBarKey", r43);
        if (r112 == null) goto L163;
        r112.put("commonProps", new JSONObject(r38));
    L163:
        JSONObject r44 = new JSONObject();
        r44.put("applet_id", "com.ruyi.card");
        r44.put("widget_id", r20.ruyiCardType);
        String r45 = r20.mixtureCardId;
        if (r45 != null) goto L166;
    L178:
        r44.put("widget_data", String.valueOf(r112));
        String r124 = r44.toString();
        if (r111 == false) goto L186;
        if (r15 == null) goto L184;
        Integer r46 = r15.w;
        if (r46 == null) goto L184;
        int r47 = r46.intValue();
    L185:
        int r125 = (r47 + r26.getPaddingStart()) + r26.getPaddingEnd();
    L187:
        String r48 = r20.templateUrl;
        if (r48 == null) goto L190;
        String r126 = i.a(r48);
    L191:
        final Message r49 = r10;
        final fh8.f r50 = r15;
        cm8.f r51 = new cm8.f(r125, r124, r10, r126, true, r13, r32, r33, r111, r26.getPaddingStart(), r26.getPaddingEnd(), new e(r28, r49, r6, r50, r12));
        this.a.a(r51, new cm8.e(r15));
        return this.a.e(r51);
    L190:
        r126 = null;
    L184:
        r47 = r29;
        goto L185
    L186:
        r125 = r29;
        goto L187
    L166:
        if (StringsKt.isBlank(r45) == true) goto L178;
        if (r10 == null) goto L173;
        String r127 = r10.getMessageId();
        if (r127 == null) goto L173;
        List r52 = StringsKt.split$default(r127, new String[]{"long_screenshot_"}, false, 0, 6, null);
        if (r52 == null) goto L173;
        int r53 = r52.size();
    L175:
        if (r53 <= 1) goto L177;
        r45 = r45 + '_' + r53;
    L177:
        r44.put("mixture_card_id", r45);
    L173:
        r53 = 1;
        goto L175
    L159:
        r43 = null;
        goto L160
    L149:
        r42 = null;
        goto L151
    L154:
        r121 = null;
    L156:
        r123 = null;
        goto L157
    L135:
        if (Intrinsics.areEqual(r28.i(), "data-inline") == true) goto L138;
        r120 = 0;
        goto L139
    L131:
        r39 = null;
        goto L132
    L127:
        r119 = null;
        goto L128
    L123:
        r118 = null;
        goto L124
    L119:
        r117 = null;
        goto L120
    L115:
        r116 = null;
        goto L116
    L111:
        r115 = null;
        goto L112
    L107:
        r114 = null;
        goto L108
    L100:
        r112 = null;
        goto L101
    L96:
        r111 = false;
        goto L97
    L93:
        r36 = null;
        goto L94
    L89:
        r110 = null;
        goto L90
    L85:
        r33 = false;
        goto L86
    L81:
        r32 = false;
    L54:
        r20 = null;
        goto L56
    L46:
        r16 = null;
    L42:
        r12 = null;
    L35:
        r8 = null;
    L28:
        r6 = null;
        goto L29
    L21:
        r10 = null;
        goto L22
    L16:
        r2 = null;
        goto L17
    L12:
        r1 = null;
        goto L14
    L9:
        r15 = null;
        goto L10
    L5:
        r0 = null;
        goto L7
    }
}
