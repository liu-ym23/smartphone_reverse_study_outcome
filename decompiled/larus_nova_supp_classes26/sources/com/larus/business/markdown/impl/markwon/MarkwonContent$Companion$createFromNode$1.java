package com.larus.business.markdown.impl.markwon;

import android.content.Context;
import android.graphics.Rect;
import android.widget.TextView;
import com.larus.business.markdown.impl.common.MarkdownConfigManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import lsc.s;
import lsc.y;
import lw8.d;
import lw8.m;
import tsc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/larus/business/markdown/impl/markwon/MarkwonContent;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class MarkwonContent$Companion$createFromNode$1 extends Lambda implements Function0<MarkwonContent> {
    final /* synthetic */ Function1<m, Unit> $callBack;
    final /* synthetic */ d $customMarkDownInfo;
    final /* synthetic */ boolean $finished;
    final /* synthetic */ MarkdownConfigManager $markdownConfigManager;
    final /* synthetic */ ow8.a $markdownTextView;
    final /* synthetic */ uvc.b $node;
    final /* synthetic */ Map<String, Object> $payload;

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
    public MarkwonContent$Companion$createFromNode$1(ow8.a r1, MarkdownConfigManager r2, boolean r3, d r4, Map<String, ? extends Object> r5, uvc.b r6, Function1<? super m, Unit> r7) {
        this.$markdownTextView = r1;
        this.$markdownConfigManager = r2;
        this.$finished = r3;
        this.$customMarkDownInfo = r4;
        this.$payload = r5;
        this.$node = r6;
        this.$callBack = r7;
        super(0);
    }

    public final MarkwonContent invoke() {
        ow8.a r0 = this.$markdownTextView;
        if (r0 == null) goto L5;
        TextView r1 = r0.o();
    L6:
        if (r1 == null) goto L9;
        Context r2 = r1.getContext();
        if (r2 == null) goto L9;
    L11:
        long r3 = System.currentTimeMillis();
        ow8.a r5 = this.$markdownTextView;
        if (r5 == null) goto L16;
        TextView r6 = r5.o();
        if (r6 == null) goto L16;
        Integer r7 = Integer.valueOf((this.$markdownTextView.getMarkdownWidth() - r6.getPaddingStart()) - r6.getPaddingEnd());
    L18:
        if (this.$finished == false) goto L20;
        MarkwonStruct r4 = e.a(r2, this.$markdownConfigManager, r7, this.$customMarkDownInfo, this.$payload);
    L21:
        MarkwonStruct r11 = r4;
        long r8 = System.currentTimeMillis();
        e.h = false;
        Object r9 = MarkwonContent.n;
        MarkwonContent.Companion.e(r1, (Rect) this.$markdownConfigManager.f.getValue());
        if (this.$finished == true) goto L24;
        this.$markdownConfigManager.a().c(this.$node);
    L24:
        long r10 = System.currentTimeMillis();
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        y.b r13 = r11.m.b(this.$node, r1, new a(r12));
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
        long r14 = System.currentTimeMillis();
        Function1<m, Unit> r15 = this.$callBack;
        if (r15 == null) goto L28;
        r15.invoke(new m(Long.valueOf(r8 - r3), null, Long.valueOf(r14 - r10), 2));
    L28:
        return new MarkwonContent(r13, MarkwonContent.Companion.a(r13, io.noties.markwon.ext.tables.s.class), e.h, MarkwonContent.Companion.a(r13, io.noties.markwon.core.spans.e.class), this.$node, r11, (HashMap) r12.element, this.$finished);
    L20:
        r4 = e.b(r2, this.$markdownConfigManager, r7, this.$customMarkDownInfo, this.$payload);
    L16:
        r7 = null;
    L9:
        gw8.c.a.getClass();
        r2 = gw8.c.a.c;
        if (r2 != null) goto L11;
        Object r16 = MarkwonContent.n;
        MarkwonContent r17 = MarkwonContent.Companion.j(this.$markdownConfigManager, "");
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type com.larus.business.markdown.impl.markwon.MarkwonContent");
        return r17;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m95invoke() {
        return invoke();
    }
}
