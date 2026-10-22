package com.ss.android.lark.coremd.facade.gennode;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.ss.android.lark.coremd.impl.buildnode.ListItemBuildExtend;
import com.ss.android.lark.coremd.span.BlockQuoteSpan;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v7b.b0;
import v7b.i;
import v7b.q;
import v7b.s;
import x9b.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SpanToNodeMappers {
    public static final SpanToNodeMappers a = null;
    public static final a b = null;
    public static final b c = null;
    public static final c d = null;
    public static final d e = null;
    public static final List<u9b.d<? extends Object>> f = null;

    public static final class a implements u9b.d<com.ss.android.lark.coremd.impl.buildnode.a> {
        public final Class<com.ss.android.lark.coremd.impl.buildnode.a> a;

        public a() {
            this.a = com.ss.android.lark.coremd.impl.buildnode.a.class;
        }

        @Override // u9b.d
        public final Class<com.ss.android.lark.coremd.impl.buildnode.a> a() {
            return this.a;
        }

        @Override // u9b.d
        public final s b(Context r2, Spanned r3, com.ss.android.lark.coremd.impl.buildnode.a r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "spanned");
            com.ss.android.lark.coremd.impl.buildnode.a r5 = r4;
            SpannableStringBuilder r6 = (SpannableStringBuilder) r3;
            String r7 = r6.subSequence(r6.getSpanStart(r5), r6.getSpanEnd(r5)).toString();
            r5.getClass();
            Intrinsics.checkNotNullParameter(r7, "what");
            if (r5.c == false) goto L5;
            boolean r8 = Intrinsics.areEqual(r7, r5.b);
        L6:
            if (r8 == false) goto L9;
            s r9 = r5.a;
            s r10 = r9.h();
            r10.c.putAll(r9.c);
            return r10;
        L9:
            return new b0(r7);
        L5:
            r8 = true;
            goto L6
        }
    }

    public static final class b implements u9b.d<y9b.a> {
        public final Class<y9b.a> a;

        public b() {
            this.a = y9b.a.class;
        }

        @Override // u9b.d
        public final Class<y9b.a> a() {
            return this.a;
        }

        @Override // u9b.d
        public final s b(Context r2, Spanned r3, y9b.a r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "spanned");
            final y9b.a r5 = r4;
            final q r6 = new q();
            ListItemBuildExtend.a r7 = ListItemBuildExtend.g;
            Function1<ListItemBuildExtend, Unit> r0 = new SpanToNodeMappers$list$1$1(r5, r6);
            r7.getClass();
            Intrinsics.checkNotNullParameter(r0, Keys.API_PARAM_KEY_ACTION);
            r7.c.b(r0);
            return r6;
        }
    }

    public static final class c implements u9b.d<BlockQuoteSpan> {
        public final Class<BlockQuoteSpan> a;

        public c() {
            this.a = BlockQuoteSpan.class;
        }

        @Override // u9b.d
        public final Class<BlockQuoteSpan> a() {
            return this.a;
        }

        @Override // u9b.d
        public final s b(Context r2, Spanned r3, BlockQuoteSpan r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "spanned");
            return new v7b.b();
        }
    }

    public static final class d implements u9b.d<g> {
        public final Class<g> a;

        public d() {
            this.a = g.class;
        }

        @Override // u9b.d
        public final Class<g> a() {
            return this.a;
        }

        @Override // u9b.d
        public final s b(Context r2, Spanned r3, g r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "spanned");
            return new i();
        }
    }

    public SpanToNodeMappers() {
    }

    static {
        a = new SpanToNodeMappers();
        a r0 = new a();
        b = r0;
        b r1 = new b();
        c = r1;
        c r2 = new c();
        d = r2;
        d r3 = new d();
        e = r3;
        f = CollectionsKt.listOf(new u9b.d[]{r0, r1, r2, r3});
    }
}
