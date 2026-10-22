package com.larus.business.markdown.impl.markwon;

import android.content.Context;
import android.graphics.Rect;
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
import lw8.h;
import tsc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/larus/business/markdown/impl/markwon/MarkwonContent;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class MarkwonContent$Companion$create$2 extends Lambda implements Function0<MarkwonContent> {
    final /* synthetic */ String $content;
    final /* synthetic */ Context $context;
    final /* synthetic */ d $customMarkDownInfo;
    final /* synthetic */ boolean $finished;
    final /* synthetic */ MarkdownConfigManager $markdownConfigManager;
    final /* synthetic */ h $markwonStructCache;
    final /* synthetic */ int $maxContentWidth;
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

    public MarkwonContent$Companion$create$2(h r1, boolean r2, Context r3, MarkdownConfigManager r4, int r5, d r6, Map<String, ? extends Object> r7, String r8, CharSequence r9) {
        this.$markwonStructCache = r1;
        this.$finished = r2;
        this.$context = r3;
        this.$markdownConfigManager = r4;
        this.$maxContentWidth = r5;
        this.$customMarkDownInfo = r6;
        this.$payload = r7;
        this.$content = r8;
        this.$reuseCharSequence = r9;
        super(0);
    }

    public final MarkwonContent invoke() {
        System.currentTimeMillis();
        MarkwonStruct r0 = this.$markwonStructCache;
        if (r0 == null) goto L5;
    L8:
        MarkwonStruct r7 = r0;
        System.currentTimeMillis();
        e.h = false;
        Object r1 = MarkwonContent.n;
        MarkwonContent.Companion.d(this.$context, this.$maxContentWidth, (Rect) this.$markdownConfigManager.f.getValue());
        String r2 = MarkwonContent.Companion.c(this.$content, this.$finished, this.$markdownConfigManager);
        if (this.$markdownConfigManager.a().b == true) goto L11;
    L13:
        System.currentTimeMillis();
        uvc.b r6 = r7.a().a(r2, this.$finished);
        System.currentTimeMillis();
        if (this.$finished == true) goto L16;
        this.$markdownConfigManager.a().c(r6);
    L16:
        System.currentTimeMillis();
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        y.b r4 = r7.a().c(r6, this.$reuseCharSequence, new a(r3));
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
        System.currentTimeMillis();
        return new MarkwonContent(r4, MarkwonContent.Companion.a(r4, io.noties.markwon.ext.tables.s.class), e.h, MarkwonContent.Companion.a(r4, io.noties.markwon.core.spans.e.class), r6, r7, (HashMap) r3.element, this.$finished);
    L11:
        if (this.$finished == true) goto L13;
        r2 = MarkwonContent.Companion.b(r2);
        goto L13
    L5:
        if (this.$finished == false) goto L7;
        r0 = e.a(this.$context, this.$markdownConfigManager, Integer.valueOf(this.$maxContentWidth), this.$customMarkDownInfo, this.$payload);
        goto L8
    L7:
        r0 = e.b(this.$context, this.$markdownConfigManager, Integer.valueOf(this.$maxContentWidth), this.$customMarkDownInfo, this.$payload);
        goto L8
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m94invoke() {
        return invoke();
    }
}
