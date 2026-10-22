package com.ss.android.lark.coremdbiz.facade.bizext;

import android.view.View;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import com.ss.android.lark.coremd.base.parse.b;
import com.ss.android.lark.coremd.base.parse.o;
import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremd.ext.m;
import com.ss.android.lark.coremdbiz.facade.node.MarkdownUrlPreviewInline;
import com.ss.android.lark.movable.selection.g;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class LarkContextExtend implements f {
    public static final a s = null;
    public static final /* synthetic */ KProperty<Object>[] t = null;
    public final c c;
    public final m d;
    public final c e;
    public final c f;
    public final c g;
    public final c h;
    public final c i;
    public final c j;
    public final c k;
    public final c l;
    public final c m;
    public final c n;
    public final c o;
    public final c p;
    public final m q;
    public final c r;

    public static final class a implements h<LarkContextExtend> {
        public final /* synthetic */ ExtendProviderImpl c;

        public final <R> R b(Function1<? super LarkContextExtend, ? extends R> r2) {
            Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
            return (R) this.c.b(r2);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (LarkContextExtend) this.c.a();
        }

        public a() {
            this.c = new ExtendProviderImpl(LarkContextExtend.class);
        }
    }

    static {
        t = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "markdownMaxWidth", "getMarkdownMaxWidth(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)I", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "tableCellLayoutParserFactory", "getTableCellLayoutParserFactory(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lcom/ss/android/lark/coremdbiz/facade/table/TableCellLayoutParserFactory;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "curUserIdProvider", "getCurUserIdProvider(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lcom/ss/android/lark/coremdbiz/facade/bizext/DefaultUserIdProvider;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableImageClickHandler", "getMovableImageClickHandler(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lkotlin/jvm/functions/Function3;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableEnableSelection", "getMovableEnableSelection(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableLongPressHandler", "getMovableLongPressHandler(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lkotlin/jvm/functions/Function1;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableAutoScrollStrategyProvider", "getMovableAutoScrollStrategyProvider(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lkotlin/jvm/functions/Function0;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableSelectionHandleDragStartHandler", "getMovableSelectionHandleDragStartHandler(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lkotlin/jvm/functions/Function0;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableSelectionClearHandler", "getMovableSelectionClearHandler(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lkotlin/jvm/functions/Function0;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableCopyHandler", "getMovableCopyHandler(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lcom/ss/android/lark/movable/selection/MovableCopyStrategy;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "isFromTopicGroup", "isFromTopicGroup(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "isFromReplyInThread", "isFromReplyInThread(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableDocumentPreloadOnly", "getMovableDocumentPreloadOnly(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableUrlPreviewInlines", "getMovableUrlPreviewInlines(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Ljava/util/List;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableRenderConfig", "getMovableRenderConfig(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderConfig;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "draftResourceSourceProvider", "getDraftResourceSourceProvider(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lkotlin/jvm/functions/Function0;", 0))};
        s = new a();
    }

    public LarkContextExtend() {
        final int r0 = Integer.MAX_VALUE;
        Function1<j, Integer> r1 = new LarkContextExtend$special$$inlined$extend$1(r0);
        Intrinsics.checkNotNullParameter(r1, "defaultProvider");
        KProperty<Object>[] r2 = t;
        KProperty<Object> r3 = r2[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r6 = d.a;
        Intrinsics.checkNotNullParameter(r3, "kProperty");
        Intrinsics.checkNotNullParameter(r1, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r8 = d.a;
        r8.put(e.a(r3), r1);
        this.c = new c();
        KProperty<Object> r4 = r2[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r4, "property");
        this.d = new m();
        LarkContextExtend$curUserIdProvider$2 r5 = LarkContextExtend$curUserIdProvider$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r5, "defaultProvider");
        KProperty<Object> r7 = r2[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r7, "property");
        Intrinsics.checkNotNullParameter(r7, "kProperty");
        Intrinsics.checkNotNullParameter(r5, "value");
        r8.put(e.a(r7), r5);
        this.e = new c();
        final Object r9 = null;
        Function1<j, Function3<? super View, ? super String, ? super Map<String, ? extends ImageSetV2>, ? extends Boolean>> r10 = new LarkContextExtend$special$$inlined$extend$2(r9);
        Intrinsics.checkNotNullParameter(r10, "defaultProvider");
        KProperty<Object> r11 = r2[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r11, "property");
        Intrinsics.checkNotNullParameter(r11, "kProperty");
        Intrinsics.checkNotNullParameter(r10, "value");
        r8.put(e.a(r11), r10);
        this.f = new c();
        final Boolean r12 = Boolean.FALSE;
        Function1<j, Boolean> r13 = new LarkContextExtend$special$$inlined$extend$3(r12);
        Intrinsics.checkNotNullParameter(r13, "defaultProvider");
        KProperty<Object> r14 = r2[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r14, "property");
        Intrinsics.checkNotNullParameter(r14, "kProperty");
        Intrinsics.checkNotNullParameter(r13, "value");
        r8.put(e.a(r14), r13);
        this.g = new c();
        Function1<j, Function1<? super View, ? extends Boolean>> r15 = new LarkContextExtend$special$$inlined$extend$4(r9);
        Intrinsics.checkNotNullParameter(r15, "defaultProvider");
        KProperty<Object> r16 = r2[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r16, "property");
        Intrinsics.checkNotNullParameter(r16, "kProperty");
        Intrinsics.checkNotNullParameter(r15, "value");
        r8.put(e.a(r16), r15);
        this.h = new c();
        Function1<j, Function0<? extends g>> r17 = new LarkContextExtend$special$$inlined$extend$5(r9);
        Intrinsics.checkNotNullParameter(r17, "defaultProvider");
        KProperty<Object> r18 = r2[6];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r18, "property");
        Intrinsics.checkNotNullParameter(r18, "kProperty");
        Intrinsics.checkNotNullParameter(r17, "value");
        r8.put(e.a(r18), r17);
        this.i = new c();
        Function1<j, Function0<? extends Unit>> r19 = new LarkContextExtend$special$$inlined$extend$6(r9);
        Intrinsics.checkNotNullParameter(r19, "defaultProvider");
        KProperty<Object> r110 = r2[7];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r110, "property");
        Intrinsics.checkNotNullParameter(r110, "kProperty");
        Intrinsics.checkNotNullParameter(r19, "value");
        r8.put(e.a(r110), r19);
        this.j = new c();
        Function1<j, Function0<? extends Unit>> r20 = new LarkContextExtend$special$$inlined$extend$7(r9);
        Intrinsics.checkNotNullParameter(r20, "defaultProvider");
        KProperty<Object> r111 = r2[8];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r111, "property");
        Intrinsics.checkNotNullParameter(r111, "kProperty");
        Intrinsics.checkNotNullParameter(r20, "value");
        r8.put(e.a(r111), r20);
        this.k = new c();
        Function1<j, com.ss.android.lark.movable.selection.h> r21 = new LarkContextExtend$special$$inlined$extend$8(r9);
        Intrinsics.checkNotNullParameter(r21, "defaultProvider");
        KProperty<Object> r22 = r2[9];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r22, "property");
        Intrinsics.checkNotNullParameter(r22, "kProperty");
        Intrinsics.checkNotNullParameter(r21, "value");
        r8.put(e.a(r22), r21);
        this.l = new c();
        Function1<j, Boolean> r23 = new LarkContextExtend$special$$inlined$extend$9(r12);
        Intrinsics.checkNotNullParameter(r23, "defaultProvider");
        KProperty<Object> r24 = r2[10];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r24, "property");
        Intrinsics.checkNotNullParameter(r24, "kProperty");
        Intrinsics.checkNotNullParameter(r23, "value");
        r8.put(e.a(r24), r23);
        this.m = new c();
        Function1<j, Boolean> r25 = new LarkContextExtend$special$$inlined$extend$10(r12);
        Intrinsics.checkNotNullParameter(r25, "defaultProvider");
        KProperty<Object> r26 = r2[11];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r26, "property");
        Intrinsics.checkNotNullParameter(r26, "kProperty");
        Intrinsics.checkNotNullParameter(r25, "value");
        r8.put(e.a(r26), r25);
        this.n = new c();
        Function1<j, Boolean> r27 = new LarkContextExtend$special$$inlined$extend$11(r12);
        Intrinsics.checkNotNullParameter(r27, "defaultProvider");
        KProperty<Object> r28 = r2[12];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r28, "property");
        Intrinsics.checkNotNullParameter(r28, "kProperty");
        Intrinsics.checkNotNullParameter(r27, "value");
        r8.put(e.a(r28), r27);
        this.o = new c();
        final List r29 = CollectionsKt.emptyList();
        Function1<j, List<? extends MarkdownUrlPreviewInline>> r30 = new LarkContextExtend$special$$inlined$extend$12(r29);
        Intrinsics.checkNotNullParameter(r30, "defaultProvider");
        KProperty<Object> r31 = r2[13];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r31, "property");
        Intrinsics.checkNotNullParameter(r31, "kProperty");
        Intrinsics.checkNotNullParameter(r30, "value");
        r8.put(e.a(r31), r30);
        this.p = new c();
        KProperty<Object> r32 = r2[14];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r32, "property");
        this.q = new m();
        LarkContextExtend$draftResourceSourceProvider$2 r33 = LarkContextExtend$draftResourceSourceProvider$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r33, "defaultProvider");
        KProperty<Object> r34 = r2[15];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r34, "property");
        Intrinsics.checkNotNullParameter(r34, "kProperty");
        Intrinsics.checkNotNullParameter(r33, "value");
        r8.put(e.a(r34), r33);
        this.r = new c();
    }

    public final DefaultUserIdProvider a(o r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (DefaultUserIdProvider) this.e.getValue(r4, t[2]);
    }

    public final int b(b r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return ((Number) this.c.getValue(r4, t[0])).intValue();
    }

    public final Function1<View, Boolean> d(b r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (Function1) this.h.getValue(r4, t[5]);
    }

    public final com.ss.android.lark.coremdbiz.facade.table.a f(b r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return (com.ss.android.lark.coremdbiz.facade.table.a) this.d.getValue(r4, t[1]);
    }

    public final void g(b r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        this.c.setValue(r4, t[0], Integer.valueOf(r5));
    }

    public final void h(b r4, Function0<? extends g> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        this.i.setValue(r4, t[6], r5);
    }

    public final void i(b r4, com.ss.android.lark.movable.selection.h r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        this.l.setValue(r4, t[9], r5);
    }

    public final void j(b r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        this.g.setValue(r4, t[4], Boolean.valueOf(r5));
    }

    public final void k(b r4, Function3<? super View, ? super String, ? super Map<String, ImageSetV2>, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        this.f.setValue(r4, t[3], r5);
    }

    public final void l(b r4, Function1<? super View, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        this.h.setValue(r4, t[5], r5);
    }

    public final void m(b r4, MovableRenderConfig r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        this.q.setValue(r4, t[14], r5);
    }

    public final void n(b r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        this.k.setValue(r4, t[8], r5);
    }

    public final void o(b r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        this.j.setValue(r4, t[7], r5);
    }

    public final void p(b r4, List<MarkdownUrlPreviewInline> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.p.setValue(r4, t[13], r5);
    }
}
