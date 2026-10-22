package com.ss.android.lark.coremdbiz.facade;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.ss.android.lark.coremd.facade.gennode.SpanToNodeMappers;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.widget.span.InlineCodeCenterSpan;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final C0187a a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.coremdbiz.facade.a$a, reason: collision with other inner class name */
    public static final class C0187a implements u9b.d<InlineCodeCenterSpan> {
        public final Class<InlineCodeCenterSpan> a;

        public C0187a() {
            this.a = InlineCodeCenterSpan.class;
        }

        @Override // u9b.d
        public final Class<InlineCodeCenterSpan> a() {
            return this.a;
        }

        @Override // u9b.d
        public final s b(Context r2, Spanned r3, InlineCodeCenterSpan r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "spanned");
            InlineCodeCenterSpan r5 = r4;
            SpannableStringBuilder r6 = (SpannableStringBuilder) r3;
            return new v7b.d(r6.subSequence(r6.getSpanStart(r5), r6.getSpanEnd(r5)).toString());
        }
    }

    static {
        a = new C0187a();
    }

    public static /* synthetic */ com.ss.android.lark.coremd.base.parse.j b() {
        t9b.e r0 = t9b.e.a;
        return a(LarkMarkdownConfigKt$default$1.INSTANCE);
    }

    public static final List c() {
        Intrinsics.checkNotNullParameter(SpanToNodeMappers.a, "<this>");
        return CollectionsKt.listOf(new u9b.d[]{SpanToNodeMappers.b, SpanToNodeMappers.c, SpanToNodeMappers.d, SpanToNodeMappers.e, a});
    }

    public static final com.ss.android.lark.coremd.base.parse.j a(final Function2 r2) {
        Intrinsics.checkNotNullParameter(t9b.e.a, "<this>");
        Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
        return com.ss.android.lark.coremd.base.parse.l.a(LarkThemeExtend.m, new LarkMarkdownConfigKt$default$2(r2));
    }
}
