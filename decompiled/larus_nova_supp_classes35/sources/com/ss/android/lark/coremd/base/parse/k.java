package com.ss.android.lark.coremd.base.parse;

import com.ss.android.lark.coremd.base.theme.BlockQuoteThemeData;
import com.ss.android.lark.coremd.base.theme.CodeBlockThemeData;
import com.ss.android.lark.coremd.base.theme.HeadingThemeData;
import com.ss.android.lark.coremd.base.theme.InlineCodeThemeData;
import com.ss.android.lark.coremd.base.theme.LinkThemeData;
import com.ss.android.lark.coremd.base.theme.ListThemeData;
import com.ss.android.lark.coremd.base.theme.ThematicBreakThemeData;
import com.ss.android.lark.coremd.impl.parse.MarkdownThemeImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface k extends com.ss.android.lark.coremd.ext.f, com.ss.android.lark.coremd.ext.h<k> {
    public static final a b = null;

    public static final class a implements k {
        public static final /* synthetic */ a d = null;
        public final /* synthetic */ MarkdownThemeImpl.ThemeExtendImpl c;

        static {
            d = new a();
        }

        @Override // com.ss.android.lark.coremd.base.parse.k
        public final ListThemeData c(j r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            return this.c.c(r2);
        }

        @Override // com.ss.android.lark.coremd.base.parse.k
        public final HeadingThemeData e(j r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            return this.c.e(r2);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final com.ss.android.lark.coremd.ext.f a() {
            MarkdownThemeImpl.ThemeExtendImpl r0 = this.c;
            r0.getClass();
            return r0;
        }

        public a() {
            this.c = new MarkdownThemeImpl.ThemeExtendImpl();
        }

        public final BlockQuoteThemeData b(j r4) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            MarkdownThemeImpl.ThemeExtendImpl r1 = this.c;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r4, "<this>");
            return (BlockQuoteThemeData) r1.h.getValue(r4, MarkdownThemeImpl.ThemeExtendImpl.l[5]);
        }

        public final CodeBlockThemeData d(j r4) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            MarkdownThemeImpl.ThemeExtendImpl r1 = this.c;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r4, "<this>");
            return (CodeBlockThemeData) r1.g.getValue(r4, MarkdownThemeImpl.ThemeExtendImpl.l[4]);
        }

        public final InlineCodeThemeData f(j r4) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            MarkdownThemeImpl.ThemeExtendImpl r1 = this.c;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r4, "<this>");
            return (InlineCodeThemeData) r1.f.getValue(r4, MarkdownThemeImpl.ThemeExtendImpl.l[3]);
        }

        public final LinkThemeData g(j r4) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            MarkdownThemeImpl.ThemeExtendImpl r1 = this.c;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r4, "<this>");
            return (LinkThemeData) r1.d.getValue(r4, MarkdownThemeImpl.ThemeExtendImpl.l[1]);
        }

        public final boolean h(j r4) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            MarkdownThemeImpl.ThemeExtendImpl r1 = this.c;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r4, "<this>");
            return ((Boolean) r1.k.getValue(r4, MarkdownThemeImpl.ThemeExtendImpl.l[8])).booleanValue();
        }

        public final ThematicBreakThemeData i(j r4) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            MarkdownThemeImpl.ThemeExtendImpl r1 = this.c;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r4, "<this>");
            return (ThematicBreakThemeData) r1.j.getValue(r4, MarkdownThemeImpl.ThemeExtendImpl.l[7]);
        }
    }

    static {
        b = a.d;
    }

    ListThemeData c(j r1);

    HeadingThemeData e(j r1);
}
