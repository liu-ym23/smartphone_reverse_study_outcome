package com.ss.android.lark.coremdbiz.facade.bizext;

import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.base.parse.k;
import com.ss.android.lark.coremd.base.theme.HeadingThemeData;
import com.ss.android.lark.coremd.base.theme.ListThemeData;
import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.impl.parse.MarkdownThemeImpl;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtUserGroupThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkCodeBlockThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkEmojiThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkImageThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkLinkThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkMediaThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkPhoneThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkTableThemeData;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class LarkThemeExtend implements k {
    public static final a m = null;
    public static final /* synthetic */ KProperty<Object>[] n = null;
    public final /* synthetic */ k.a c;
    public final c d;
    public final c e;
    public final c f;
    public final c g;
    public final c h;
    public final c i;
    public final c j;
    public final c k;
    public final c l;

    public static final class a implements h<LarkThemeExtend> {
        public final /* synthetic */ ExtendProviderImpl c;

        public final <R> R b(Function1<? super LarkThemeExtend, ? extends R> r2) {
            Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
            return (R) this.c.b(r2);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (LarkThemeExtend) this.c.a();
        }

        public a() {
            this.c = new ExtendProviderImpl(LarkThemeExtend.class);
        }
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

    static {
        n = new KProperty[]{Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "imageThemeData", "getImageThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkImageThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "linkThemeData", "getLinkThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkLinkThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "codeBlockThemeData", "getCodeBlockThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkCodeBlockThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "atThemeData", "getAtThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkAtThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "emojiThemeData", "getEmojiThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkEmojiThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "mediaThemeData", "getMediaThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkMediaThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "phoneThemeData", "getPhoneThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkPhoneThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "atUserGroupData", "getAtUserGroupData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkAtUserGroupThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "tableThemeData", "getTableThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkTableThemeData;", 0))};
        m = new a();
    }

    @Override // com.ss.android.lark.coremd.ext.h
    public final f a() {
        MarkdownThemeImpl.ThemeExtendImpl r0 = this.c.c;
        r0.getClass();
        return r0;
    }

    public LarkThemeExtend() {
        this.c = k.b;
        LarkThemeExtend$imageThemeData$2 r0 = LarkThemeExtend$imageThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r2 = n;
        KProperty<Object> r3 = r2[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        ConcurrentHashMap<Object, Function1<com.ss.android.lark.coremd.ext.j, Object>> r6 = d.a;
        Intrinsics.checkNotNullParameter(r3, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        ConcurrentHashMap<Object, Function1<com.ss.android.lark.coremd.ext.j, Object>> r8 = d.a;
        r8.put(e.a(r3), r0);
        this.d = new c();
        LarkThemeExtend$linkThemeData$2 r1 = LarkThemeExtend$linkThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r1, "defaultProvider");
        KProperty<Object> r4 = r2[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r4, "property");
        Intrinsics.checkNotNullParameter(r4, "kProperty");
        Intrinsics.checkNotNullParameter(r1, "value");
        r8.put(e.a(r4), r1);
        this.e = new c();
        LarkThemeExtend$codeBlockThemeData$2 r5 = LarkThemeExtend$codeBlockThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r5, "defaultProvider");
        KProperty<Object> r7 = r2[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r7, "property");
        Intrinsics.checkNotNullParameter(r7, "kProperty");
        Intrinsics.checkNotNullParameter(r5, "value");
        r8.put(e.a(r7), r5);
        this.f = new c();
        LarkThemeExtend$atThemeData$2 r9 = LarkThemeExtend$atThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r9, "defaultProvider");
        KProperty<Object> r10 = r2[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r10, "property");
        Intrinsics.checkNotNullParameter(r10, "kProperty");
        Intrinsics.checkNotNullParameter(r9, "value");
        r8.put(e.a(r10), r9);
        this.g = new c();
        LarkThemeExtend$emojiThemeData$2 r11 = LarkThemeExtend$emojiThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r11, "defaultProvider");
        KProperty<Object> r12 = r2[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r12, "property");
        Intrinsics.checkNotNullParameter(r12, "kProperty");
        Intrinsics.checkNotNullParameter(r11, "value");
        r8.put(e.a(r12), r11);
        this.h = new c();
        LarkThemeExtend$mediaThemeData$2 r13 = LarkThemeExtend$mediaThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r13, "defaultProvider");
        KProperty<Object> r14 = r2[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r14, "property");
        Intrinsics.checkNotNullParameter(r14, "kProperty");
        Intrinsics.checkNotNullParameter(r13, "value");
        r8.put(e.a(r14), r13);
        this.i = new c();
        LarkThemeExtend$phoneThemeData$2 r15 = LarkThemeExtend$phoneThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r15, "defaultProvider");
        KProperty<Object> r16 = r2[6];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r16, "property");
        Intrinsics.checkNotNullParameter(r16, "kProperty");
        Intrinsics.checkNotNullParameter(r15, "value");
        r8.put(e.a(r16), r15);
        this.j = new c();
        LarkThemeExtend$atUserGroupData$2 r17 = LarkThemeExtend$atUserGroupData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r17, "defaultProvider");
        KProperty<Object> r18 = r2[7];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r18, "property");
        Intrinsics.checkNotNullParameter(r18, "kProperty");
        Intrinsics.checkNotNullParameter(r17, "value");
        r8.put(e.a(r18), r17);
        this.k = new c();
        LarkThemeExtend$tableThemeData$2 r19 = LarkThemeExtend$tableThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r19, "defaultProvider");
        KProperty<Object> r20 = r2[8];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r20, "property");
        Intrinsics.checkNotNullParameter(r20, "kProperty");
        Intrinsics.checkNotNullParameter(r19, "value");
        r8.put(e.a(r20), r19);
        this.l = new c();
    }

    public LarkAtThemeData b(j r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (LarkAtThemeData) this.g.getValue(r4, n[3]);
    }

    public final LarkAtUserGroupThemeData d(j r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (LarkAtUserGroupThemeData) this.k.getValue(r4, n[7]);
    }

    public final LarkCodeBlockThemeData f(j r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (LarkCodeBlockThemeData) this.f.getValue(r4, n[2]);
    }

    public final LarkEmojiThemeData g(j r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (LarkEmojiThemeData) this.h.getValue(r4, n[4]);
    }

    public LarkImageThemeData h(j r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (LarkImageThemeData) this.d.getValue(r4, n[0]);
    }

    public final LarkLinkThemeData i(j r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (LarkLinkThemeData) this.e.getValue(r4, n[1]);
    }

    public LarkMediaThemeData j(j r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (LarkMediaThemeData) this.i.getValue(r4, n[5]);
    }

    public final LarkPhoneThemeData k(j r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (LarkPhoneThemeData) this.j.getValue(r4, n[6]);
    }

    public final LarkTableThemeData l(j r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (LarkTableThemeData) this.l.getValue(r4, n[8]);
    }
}
