package com.larus.business.markdown.impl.markwon;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.larus.business.markdown.impl.common.MarkdownConfigManager;
import io.noties.markwon.ext.tables.TableRowSpan2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import lsc.s;
import lw8.d;
import lw8.h;
import lw8.i;
import lw8.m;
import tsc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/larus/business/markdown/impl/markwon/MarkwonContent;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class MarkwonContent$Companion$createFromNode$2 extends Lambda implements Function0<MarkwonContent> {
    final /* synthetic */ Function1<m, Unit> $callBack;
    final /* synthetic */ Context $context;
    final /* synthetic */ d $customMarkDownInfo;
    final /* synthetic */ boolean $finished;
    final /* synthetic */ i $incrementalTextSpanParams;
    final /* synthetic */ MarkdownConfigManager $markdownConfigManager;
    final /* synthetic */ h $markwonStructCache;
    final /* synthetic */ int $maxContentWidth;
    final /* synthetic */ uvc.b $node;
    final /* synthetic */ Map<String, Object> $payload;
    final /* synthetic */ CharSequence $reuseCharSequence;

    public static final class a implements s {
        public final /* synthetic */ Ref.ObjectRef<HashMap<String, Integer>> a;

        public a(Ref.ObjectRef<HashMap<String, Integer>> r1) {
            this.a = r1;
        }

        public final void a(HashMap<String, Integer> r2) {
            this.a.element = r2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MarkwonContent$Companion$createFromNode$2(h r1, boolean r2, Context r3, MarkdownConfigManager r4, int r5, d r6, Map<String, ? extends Object> r7, uvc.b r8, i r9, CharSequence r10, Function1<? super m, Unit> r11) {
        this.$markwonStructCache = r1;
        this.$finished = r2;
        this.$context = r3;
        this.$markdownConfigManager = r4;
        this.$maxContentWidth = r5;
        this.$customMarkDownInfo = r6;
        this.$payload = r7;
        this.$node = r8;
        this.$incrementalTextSpanParams = r9;
        this.$reuseCharSequence = r10;
        this.$callBack = r11;
        super(0);
    }

    public final MarkwonContent invoke() {
        long r1 = System.currentTimeMillis();
        MarkwonStruct r3 = this.$markwonStructCache;
        if (r3 == null) goto L5;
    L8:
        MarkwonStruct r10 = r3;
        long r4 = System.currentTimeMillis();
        e.h = false;
        Object r6 = MarkwonContent.n;
        MarkwonContent.Companion.d(this.$context, this.$maxContentWidth, (Rect) this.$markdownConfigManager.f.getValue());
        if (this.$finished == true) goto L11;
        this.$markdownConfigManager.a().c(this.$node);
    L11:
        long r7 = System.currentTimeMillis();
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        Map r9 = d.a;
        i r11 = this.$incrementalTextSpanParams;
        if (r11 != null) goto L14;
    L16:
        boolean r12 = false;
    L17:
        if (r12 == true) goto L20;
    L36:
        r7 = r7;
        d.a r13 = null;
    L74:
        if (r13 == null) goto L76;
        r8.element = r13.b;
    L77:
        if (r13 == null) goto L80;
        SpannableStringBuilder r5 = r13.a;
        if (r5 == null) goto L80;
    L81:
        Object r14 = MarkwonContent.n;
        boolean r15 = MarkwonContent.Companion.a(r5, io.noties.markwon.ext.tables.s.class);
        Map r16 = d.a;
        i r17 = this.$incrementalTextSpanParams;
        boolean r18 = this.$finished;
        HashMap r19 = (HashMap) r8.element;
        Intrinsics.checkNotNullParameter(r5, "markdownSpan");
        if (r17 != null) goto L84;
    L86:
        boolean r110 = false;
    L87:
        if (r110 == false) goto L101;
        View r20 = r17.b;
        if (r20 == null) goto L101;
        if (r18 == true) goto L100;
        if (r15 == true) goto L100;
        Map r21 = d.a;
        SpannableStringBuilder r111 = d.a(r5, r15);
        if (r19 == null) goto L98;
        HashMap r112 = new HashMap(r19);
    L99:
        r21.put(r20, new d.a(r111, r112, r15));
        goto L101
    L98:
        r112 = null;
    L100:
        d.a.remove(r20);
    L101:
        long r113 = System.currentTimeMillis();
        Function1<m, Unit> r22 = this.$callBack;
        if (r22 == null) goto L105;
        r22.invoke(new m(Long.valueOf(r4 - r1), null, Long.valueOf(r113 - r7), 2));
    L105:
        return new MarkwonContent(r5, r15, e.h, MarkwonContent.Companion.a(r5, io.noties.markwon.core.spans.e.class), this.$node, r10, (HashMap) r8.element, this.$finished);
    L84:
        if (r17.a != true) goto L86;
        r110 = true;
    L80:
        r5 = r10.a().c(this.$node, this.$reuseCharSequence, new a(r8));
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
        goto L81
    L76:
        r13 = null;
        goto L77
    L20:
        if (r11.c == false) goto L36;
        View r114 = r11.b;
        if (r114 == null) goto L36;
        String r23 = r11.d;
        if (r23 != null) goto L28;
    L31:
        boolean r115 = true;
    L32:
        if (r115 == true) goto L36;
        d.a r116 = (d.a) d.a.get(r114);
        if (r116 == null) goto L36;
        SpannableStringBuilder r117 = d.a(r116.a, r116.c);
        int r118 = r117.length();
        if (r118 > 0) goto L40;
        List r119 = CollectionsKt.emptyList();
    L61:
        List r120 = r119;
        Iterator r24 = r120.iterator();
    L63:
        if (r24.hasNext() == false) goto L65;
        r117.removeSpan(((d$b) r24.next()).a);
        goto L63
    L65:
        r117.append(r23);
        int r25 = r117.length();
        Iterator r26 = r120.iterator();
    L67:
        if (r26.hasNext() == false) goto L69;
        d$b r27 = (d$b) r26.next();
        r117.setSpan(r27.a, r27.b, r25, r27.c);
        goto L67
    L69:
        HashMap r28 = r116.b;
        if (r28 == null) goto L72;
        HashMap r29 = new HashMap(r28);
    L73:
        r13 = new d.a(r117, r29, r116.c);
        goto L74
    L72:
        r29 = null;
        goto L73
    L40:
        Object[] r30 = r117.getSpans(r118 - 1, r118, Object.class);
        ArrayList r121 = new ArrayList();
        int r122 = r30.length;
        int r31 = 0;
    L41:
        if (r31 >= r122) goto L60;
        Object r32 = r30[r31];
        Object[] r123 = r30;
        int r33 = r117.getSpanStart(r32);
        int r210 = r122;
        int r124 = r117.getSpanEnd(r32);
        if (r33 < 0) goto L56;
        if (r124 != r118) goto L56;
        if ((r32 instanceof TableRowSpan2) == false) goto L48;
    L53:
        boolean r125 = true;
    L54:
        if (r125 == true) goto L56;
        d$b r126 = new d$b(r32, r33, r117.getSpanFlags(r32));
    L57:
        if (r126 == null) goto L59;
        r121.add(r126);
    L59:
        r31 = r31 + 1;
        r30 = r123;
        r122 = r210;
        r118 = r118;
        goto L41
    L48:
        if ((r32 instanceof io.noties.markwon.ext.tables.s) == true) goto L53;
        if ((r32 instanceof ctc.a) == true) goto L53;
        r125 = false;
    L56:
        r126 = null;
        goto L57
    L60:
        r119 = r121;
        goto L61
    L28:
        if (r23.length() == 0) goto L31;
        r115 = false;
        goto L32
    L14:
        if (r11.a != true) goto L16;
        r12 = true;
        goto L17
    L5:
        if (this.$finished == false) goto L7;
        r3 = e.a(this.$context, this.$markdownConfigManager, Integer.valueOf(this.$maxContentWidth), this.$customMarkDownInfo, this.$payload);
        goto L8
    L7:
        r3 = e.b(this.$context, this.$markdownConfigManager, Integer.valueOf(this.$maxContentWidth), this.$customMarkDownInfo, this.$payload);
        goto L8
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m96invoke() {
        return invoke();
    }
}
