package com.ss.android.lark.coremd.impl.parse;

import com.ss.android.lark.coremd.base.parse.a0;
import com.ss.android.lark.coremd.base.theme.HeadingThemeData;
import com.ss.android.lark.coremd.base.theme.ListThemeData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MarkdownThemeImpl implements com.ss.android.lark.coremd.base.parse.j {
    public final Map<Object, Object> c;

    public static final class ThemeExtendImpl implements com.ss.android.lark.coremd.base.parse.k, com.ss.android.lark.coremd.ext.h<com.ss.android.lark.coremd.base.parse.k> {
        public static final /* synthetic */ KProperty<Object>[] l = null;
        public final com.ss.android.lark.coremd.ext.c c;
        public final com.ss.android.lark.coremd.ext.c d;
        public final com.ss.android.lark.coremd.ext.c e;
        public final com.ss.android.lark.coremd.ext.c f;
        public final com.ss.android.lark.coremd.ext.c g;
        public final com.ss.android.lark.coremd.ext.c h;
        public final com.ss.android.lark.coremd.ext.c i;
        public final com.ss.android.lark.coremd.ext.c j;
        public final com.ss.android.lark.coremd.ext.c k;

        @Override // com.ss.android.lark.coremd.ext.h
        public final com.ss.android.lark.coremd.ext.f a() {
            return this;
        }

        static {
            l = new KProperty[]{Reflection.property2(new PropertyReference2Impl(ThemeExtendImpl.class, "imageThemeData", "getImageThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/base/theme/ImageThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(ThemeExtendImpl.class, "linkThemeData", "getLinkThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/base/theme/LinkThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(ThemeExtendImpl.class, "listThemeData", "getListThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/base/theme/ListThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(ThemeExtendImpl.class, "inlineCodeThemeData", "getInlineCodeThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/base/theme/InlineCodeThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(ThemeExtendImpl.class, "codeBlockThemeData", "getCodeBlockThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/base/theme/CodeBlockThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(ThemeExtendImpl.class, "blockQuoteThemeData", "getBlockQuoteThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/base/theme/BlockQuoteThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(ThemeExtendImpl.class, "headingThemeData", "getHeadingThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/base/theme/HeadingThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(ThemeExtendImpl.class, "thematicBreakThemeData", "getThematicBreakThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/base/theme/ThematicBreakThemeData;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(ThemeExtendImpl.class, "showBISU", "getShowBISU(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Z", 0))};
        }

        public ThemeExtendImpl() {
            MarkdownThemeImpl$ThemeExtendImpl$imageThemeData$2 r0 = MarkdownThemeImpl$ThemeExtendImpl$imageThemeData$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r0, "defaultProvider");
            KProperty<Object>[] r2 = l;
            KProperty<Object> r3 = r2[0];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r3, "property");
            ConcurrentHashMap<Object, Function1<com.ss.android.lark.coremd.ext.j, Object>> r6 = com.ss.android.lark.coremd.ext.d.a;
            Intrinsics.checkNotNullParameter(r3, "kProperty");
            Intrinsics.checkNotNullParameter(r0, "value");
            ConcurrentHashMap<Object, Function1<com.ss.android.lark.coremd.ext.j, Object>> r8 = com.ss.android.lark.coremd.ext.d.a;
            r8.put(com.ss.android.lark.coremd.ext.e.a(r3), r0);
            this.c = new com.ss.android.lark.coremd.ext.c();
            MarkdownThemeImpl$ThemeExtendImpl$linkThemeData$2 r1 = MarkdownThemeImpl$ThemeExtendImpl$linkThemeData$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r1, "defaultProvider");
            KProperty<Object> r4 = r2[1];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r4, "property");
            Intrinsics.checkNotNullParameter(r4, "kProperty");
            Intrinsics.checkNotNullParameter(r1, "value");
            r8.put(com.ss.android.lark.coremd.ext.e.a(r4), r1);
            this.d = new com.ss.android.lark.coremd.ext.c();
            MarkdownThemeImpl$ThemeExtendImpl$listThemeData$2 r5 = MarkdownThemeImpl$ThemeExtendImpl$listThemeData$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r5, "defaultProvider");
            KProperty<Object> r7 = r2[2];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r7, "property");
            Intrinsics.checkNotNullParameter(r7, "kProperty");
            Intrinsics.checkNotNullParameter(r5, "value");
            r8.put(com.ss.android.lark.coremd.ext.e.a(r7), r5);
            this.e = new com.ss.android.lark.coremd.ext.c();
            MarkdownThemeImpl$ThemeExtendImpl$inlineCodeThemeData$2 r9 = MarkdownThemeImpl$ThemeExtendImpl$inlineCodeThemeData$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r9, "defaultProvider");
            KProperty<Object> r10 = r2[3];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r10, "property");
            Intrinsics.checkNotNullParameter(r10, "kProperty");
            Intrinsics.checkNotNullParameter(r9, "value");
            r8.put(com.ss.android.lark.coremd.ext.e.a(r10), r9);
            this.f = new com.ss.android.lark.coremd.ext.c();
            MarkdownThemeImpl$ThemeExtendImpl$codeBlockThemeData$2 r11 = MarkdownThemeImpl$ThemeExtendImpl$codeBlockThemeData$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r11, "defaultProvider");
            KProperty<Object> r12 = r2[4];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r12, "property");
            Intrinsics.checkNotNullParameter(r12, "kProperty");
            Intrinsics.checkNotNullParameter(r11, "value");
            r8.put(com.ss.android.lark.coremd.ext.e.a(r12), r11);
            this.g = new com.ss.android.lark.coremd.ext.c();
            MarkdownThemeImpl$ThemeExtendImpl$blockQuoteThemeData$2 r13 = MarkdownThemeImpl$ThemeExtendImpl$blockQuoteThemeData$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r13, "defaultProvider");
            KProperty<Object> r14 = r2[5];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r14, "property");
            Intrinsics.checkNotNullParameter(r14, "kProperty");
            Intrinsics.checkNotNullParameter(r13, "value");
            r8.put(com.ss.android.lark.coremd.ext.e.a(r14), r13);
            this.h = new com.ss.android.lark.coremd.ext.c();
            MarkdownThemeImpl$ThemeExtendImpl$headingThemeData$2 r15 = MarkdownThemeImpl$ThemeExtendImpl$headingThemeData$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r15, "defaultProvider");
            KProperty<Object> r16 = r2[6];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r16, "property");
            Intrinsics.checkNotNullParameter(r16, "kProperty");
            Intrinsics.checkNotNullParameter(r15, "value");
            r8.put(com.ss.android.lark.coremd.ext.e.a(r16), r15);
            this.i = new com.ss.android.lark.coremd.ext.c();
            MarkdownThemeImpl$ThemeExtendImpl$thematicBreakThemeData$2 r17 = MarkdownThemeImpl$ThemeExtendImpl$thematicBreakThemeData$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r17, "defaultProvider");
            KProperty<Object> r18 = r2[7];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r18, "property");
            Intrinsics.checkNotNullParameter(r18, "kProperty");
            Intrinsics.checkNotNullParameter(r17, "value");
            r8.put(com.ss.android.lark.coremd.ext.e.a(r18), r17);
            this.j = new com.ss.android.lark.coremd.ext.c();
            final Boolean r19 = Boolean.TRUE;
            Function1<com.ss.android.lark.coremd.ext.j, Boolean> r20 = new MarkdownThemeImpl$ThemeExtendImpl$special$$inlined$extend$1(r19);
            Intrinsics.checkNotNullParameter(r20, "defaultProvider");
            KProperty<Object> r21 = r2[8];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r21, "property");
            Intrinsics.checkNotNullParameter(r21, "kProperty");
            Intrinsics.checkNotNullParameter(r20, "value");
            r8.put(com.ss.android.lark.coremd.ext.e.a(r21), r20);
            this.k = new com.ss.android.lark.coremd.ext.c();
        }

        @Override // com.ss.android.lark.coremd.base.parse.k
        public final ListThemeData c(com.ss.android.lark.coremd.base.parse.j r4) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            return (ListThemeData) this.e.getValue(r4, l[2]);
        }

        @Override // com.ss.android.lark.coremd.base.parse.k
        public final HeadingThemeData e(com.ss.android.lark.coremd.base.parse.j r4) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            return (HeadingThemeData) this.i.getValue(r4, l[6]);
        }
    }

    @Override // com.ss.android.lark.coremd.base.parse.j
    public final MarkdownThemeImpl clone() {
        MarkdownThemeImpl r0 = new MarkdownThemeImpl();
        Map<Object, Object> r1 = r0.c;
        Map<Object, Object> r2 = this.c;
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator r4 = ((LinkedHashMap) r2).entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Map.Entry r5 = (Map.Entry) r4.next();
        if ((!(r5.getValue() instanceof a0)) == false) goto L4;
        r3.put(r5.getKey(), r5.getValue());
        goto L4
    L8:
        r1.putAll(r3);
        return r0;
    }

    public MarkdownThemeImpl() {
        this.c = new LinkedHashMap();
    }

    @Override // com.ss.android.lark.coremd.ext.j
    public final Map<Object, Object> getValues() {
        return this.c;
    }
}
