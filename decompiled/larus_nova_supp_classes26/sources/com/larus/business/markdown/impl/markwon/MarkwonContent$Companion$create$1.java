package com.larus.business.markdown.impl.markwon;

import android.content.Context;
import android.graphics.Rect;
import android.widget.TextView;
import com.larus.business.markdown.impl.common.MarkdownConfigManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import lsc.s;
import lsc.y;
import lw8.d;
import tsc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/larus/business/markdown/impl/markwon/MarkwonContent;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class MarkwonContent$Companion$create$1 extends Lambda implements Function0<MarkwonContent> {
    final /* synthetic */ String $content;
    final /* synthetic */ d $customMarkDownInfo;
    final /* synthetic */ boolean $finished;
    final /* synthetic */ MarkdownConfigManager $markdownConfigManager;
    final /* synthetic */ ow8.a $markdownTextView;
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

    public MarkwonContent$Companion$create$1(ow8.a r1, MarkdownConfigManager r2, String r3, boolean r4, d r5, Map<String, ? extends Object> r6) {
        this.$markdownTextView = r1;
        this.$markdownConfigManager = r2;
        this.$content = r3;
        this.$finished = r4;
        this.$customMarkDownInfo = r5;
        this.$payload = r6;
        super(0);
    }

    public final MarkwonContent invoke() {
        ow8.a r0 = this.$markdownTextView;
        Integer r1 = null;
        if (r0 == null) goto L5;
        TextView r2 = r0.o();
    L6:
        if (r2 == null) goto L9;
        Context r3 = r2.getContext();
        if (r3 == null) goto L9;
    L11:
        System.currentTimeMillis();
        ow8.a r4 = this.$markdownTextView;
        if (r4 == null) goto L17;
        TextView r5 = r4.o();
        if (r5 == null) goto L17;
        r1 = Integer.valueOf((this.$markdownTextView.getMarkdownWidth() - r5.getPaddingStart()) - r5.getPaddingEnd());
    L17:
        if (this.$finished == false) goto L19;
        MarkwonStruct r6 = e.a(r3, this.$markdownConfigManager, r1, this.$customMarkDownInfo, this.$payload);
    L20:
        MarkwonStruct r8 = r6;
        System.currentTimeMillis();
        e.h = false;
        Object r7 = MarkwonContent.n;
        MarkwonContent.Companion.e(r2, (Rect) this.$markdownConfigManager.f.getValue());
        String r9 = MarkwonContent.Companion.c(this.$content, this.$finished, this.$markdownConfigManager);
        if (this.$markdownConfigManager.a().b == true) goto L23;
    L25:
        System.currentTimeMillis();
        uvc.b r10 = r8.m.a(r9, this.$finished);
        System.currentTimeMillis();
        if (this.$finished == true) goto L28;
        this.$markdownConfigManager.a().c(r10);
    L28:
        System.currentTimeMillis();
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        y.b r12 = r8.m.b(r10, r2, new a(r11));
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
        System.currentTimeMillis();
        return new MarkwonContent(r12, MarkwonContent.Companion.a(r12, io.noties.markwon.ext.tables.s.class), e.h, MarkwonContent.Companion.a(r12, io.noties.markwon.core.spans.e.class), r10, r8, (HashMap) r11.element, this.$finished);
    L23:
        if (this.$finished == true) goto L25;
        r9 = MarkwonContent.Companion.b(r9);
        goto L25
    L19:
        r6 = e.b(r3, this.$markdownConfigManager, r1, this.$customMarkDownInfo, this.$payload);
    L9:
        gw8.c.a.getClass();
        r3 = gw8.c.a.c;
        if (r3 != null) goto L11;
        Object r13 = MarkwonContent.n;
        MarkwonContent r14 = MarkwonContent.Companion.j(this.$markdownConfigManager, this.$content);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.larus.business.markdown.impl.markwon.MarkwonContent");
        return r14;
    L5:
        r2 = null;
        goto L6
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m93invoke() {
        return invoke();
    }
}
