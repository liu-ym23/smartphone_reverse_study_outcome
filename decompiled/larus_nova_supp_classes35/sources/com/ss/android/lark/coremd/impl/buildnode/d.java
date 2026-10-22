package com.ss.android.lark.coremd.impl.buildnode;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.ss.android.lark.coremd.base.buildnode.NodeDisplayType;
import com.ss.android.lark.coremd.facade.gennode.SpanToNodeMappers;
import com.ss.android.lark.coremd.utils.NodeBISUUtils;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import u9b.e;
import v7b.q;
import v7b.s;
import v7b.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements e {
    public final Context a;
    public final ConcurrentHashMap<Class<?>, u9b.d<Object>> b;
    public u9b.c c;
    public u9b.b d;
    public final a e;

    public static final class a implements b.a {
        public final /* synthetic */ d a;

        public final List<Class<?>> c() {
            return CollectionsKt.toList(this.a.b.keySet());
        }

        public a(d r1) {
            this.a = r1;
        }

        public final boolean d(s r2) {
            Intrinsics.checkNotNullParameter(r2, "node");
            NodeDisplayType r3 = this.a.d.a(r2);
            if (r3 != NodeDisplayType.Block) goto L5;
        L8:
            return true;
        L5:
            if (r3 == NodeDisplayType.NonContainerBlock) goto L8;
            return false;
        }

        public final boolean e(s r2) {
            Intrinsics.checkNotNullParameter(r2, "node");
            NodeDisplayType r3 = this.a.d.a(r2);
            if (r3 != NodeDisplayType.Block) goto L5;
        L8:
            return true;
        L5:
            if (r3 == NodeDisplayType.InlineBlock) goto L8;
            return false;
        }

        @Override // com.ss.android.lark.coremd.impl.buildnode.b.a
        public final int a(s r2, s r3) {
            Intrinsics.checkNotNullParameter(r2, "o1");
            Intrinsics.checkNotNullParameter(r3, "o2");
            return this.a.c.a(r2, r3);
        }

        public final s f(Class<? extends Object> r2, Spanned r3, Object r4) {
            Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
            Intrinsics.checkNotNullParameter(r3, "spanned");
            Intrinsics.checkNotNullParameter(r4, "span");
            u9b.d<Object> r5 = this.a.b.get(r2);
            if (r5 != null) goto L7;
            return null;
        L7:
            return r5.b(this.a.a, r3, r4);
        }

        public final List<s> b(s r5, CharSequence r6, int r7, char[] r8) {
            Intrinsics.checkNotNullParameter(r5, "parent");
            Intrinsics.checkNotNullParameter(r6, "text");
            Intrinsics.checkNotNullParameter(r8, "bisuBitmap");
            boolean r0 = true;
            int r1 = 0;
            if ((r5 instanceof q) == true) goto L5;
        L9:
            boolean r9 = false;
        L10:
            if (r9 == true) goto L12;
            NodeBISUUtils.c.getClass();
            Intrinsics.checkNotNullParameter(r6, "content");
            Intrinsics.checkNotNullParameter(r8, "flags");
            if (r6.length() == 0) goto L17;
            r0 = false;
        L17:
            if (r0 == true) goto L44;
            LinkedList r10 = new LinkedList();
            int r2 = 0;
        L21:
            if (r1 >= r6.length()) goto L32;
        L23:
            if (r1 >= r6.length()) goto L30;
            if (r6.charAt(r1) != '\n') goto L30;
            if (r1 <= r2) goto L28;
            r10.addAll(NodeBISUUtils.a(r2 + r7, r6.subSequence(r2, r1), r8));
        L28:
            r10.add(new v());
            r1 = r1 + 1;
            r2 = r1;
        L30:
            if (r1 >= r6.length()) goto L21;
            r1 = r1 + 1;
            goto L21
        L32:
            if (r1 <= r2) goto L45;
            CharSequence r11 = r6.subSequence(r2, r1);
            r10.addAll(NodeBISUUtils.a(r2 + r7, r11, r8));
            return r10;
        L45:
            return r10;
        L44:
            return CollectionsKt.emptyList();
        L12:
            return CollectionsKt.emptyList();
        L5:
            if (r6.length() != 1) goto L9;
            if (r6.charAt(0) != 8203) goto L9;
            r9 = true;
            goto L10
        }
    }

    public d(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this.a = r4;
        this.b = new ConcurrentHashMap();
        this.c = new com.ss.android.lark.coremd.facade.gennode.b();
        this.d = new com.ss.android.lark.coremd.facade.gennode.a(0);
        u9b.a.a(this, CollectionsKt.listOf(new u9b.d[]{SpanToNodeMappers.b, SpanToNodeMappers.c, SpanToNodeMappers.d, SpanToNodeMappers.e}));
        com.ss.android.lark.coremd.facade.gennode.b r5 = new com.ss.android.lark.coremd.facade.gennode.b();
        Intrinsics.checkNotNullParameter(r5, "handler");
        this.c = r5;
        com.ss.android.lark.coremd.facade.gennode.a r6 = new com.ss.android.lark.coremd.facade.gennode.a(0);
        Intrinsics.checkNotNullParameter(r6, "displayTypeMapper");
        this.d = r6;
        this.e = new a(this);
    }

    @Override // u9b.e
    public final d a(u9b.d r3) {
        Intrinsics.checkNotNullParameter(r3, "spanNodeMapper");
        Class<?> r0 = r3.a();
        this.b.put(r0, r3);
        return this;
    }

    public final s b(Object r7) {
        Spanned r8 = (Spanned) r7;
        Intrinsics.checkNotNullParameter(r8, Keys.API_RETURN_KEY_DATA);
        SpannableStringBuilder r0 = new SpannableStringBuilder(r8);
        int r2 = 0;
        x9b.e[] r9 = (x9b.e[]) r0.getSpans(0, r0.length(), x9b.e.class);
        int r1 = r9.length;
    L3:
        if (r2 >= r1) goto L5;
        x9b.e r3 = r9[r2];
        r0.replace(r0.getSpanStart(r3), r0.getSpanEnd(r3), BuildConfig.FLAVOR);
        r2 = r2 + 1;
        goto L3
    L5:
        b r10 = b.a;
        return b.a(r0, this.e);
    }
}
