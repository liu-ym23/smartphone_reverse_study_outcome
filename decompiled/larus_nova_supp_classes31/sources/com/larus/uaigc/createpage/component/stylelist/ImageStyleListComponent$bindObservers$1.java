package com.larus.uaigc.createpage.component.stylelist;

import com.bytedance.keva.Keva;
import com.larus.bmhome.actionbar.model.w;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.stylelist.ImageStyleListComponent$bindObservers$1", f = "ImageStyleListComponent.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
final class ImageStyleListComponent$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ImageStyleListComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ImageStyleListComponent a;

        public a(ImageStyleListComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r14, Continuation r15) {
            sy9.b r16 = (sy9.b) r14;
            if ((r16 instanceof sy9.b.a) == false) goto L17;
            ImageStyleListComponent r17 = this.a;
            r17.h = false;
            if (r17.j == true) goto L104;
            List<w> r18 = r17.l;
            if (r18 == null) goto L15;
            Iterator<T> r0 = r18.iterator();
        L10:
            if (r0.hasNext() == false) goto L12;
            ((w) r0.next()).s = Boxing.boxInt(0);
            goto L10
        L12:
            ys8.a r19 = r17.L2();
            if (r19 == null) goto L15;
            r19.refreshImageListSelectorWithMore(r18);
        L15:
            this.a.j = true;
        L104:
            return Unit.INSTANCE;
        L17:
            if ((r16 instanceof sy9.b.C0075b) == false) goto L27;
            ImageStyleListComponent r110 = this.a;
            if (r110.j == true) goto L104;
            r110.h = false;
            r110.j = true;
            ys8.a r111 = r110.L2();
            if (r111 == null) goto L104;
            List<w> r112 = this.a.l;
            if (r112 != null) goto L25;
            r112 = CollectionsKt.emptyList();
        L25:
            r111.refreshImageListSelectorWithMore(r112);
            goto L104
        L27:
            if ((r16 instanceof sy9.b.c) == false) goto L60;
            ImageStyleListComponent r113 = this.a;
            if (r113.j == false) goto L104;
            List<w> r1 = r113.l;
            if (r1 != null) goto L36;
            ys8.a r2 = r113.L2();
            if (r2 == null) goto L35;
            r1 = r2.getCurImageList();
            goto L36
        L35:
            r1 = null;
        L36:
            r113.l = r1;
            ImageStyleListComponent r114 = this.a;
            if (r114.h == true) goto L42;
            Object r115 = r114.N2(false, r15);
            if (r115 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L117;
            return r115;
        L117:
            return Unit.INSTANCE;
        L42:
            r114.j = false;
            r114.h = false;
            ImageStyleRecommendApi.ImageStyleRecommendResponse r116 = r114.k;
            if (r116 == null) goto L104;
            List<ImageStyleRecommendApi.ImageStyle> r117 = r116.getStyleList();
            if (r117 == null) goto L104;
            ImageStyleListComponent r118 = this.a;
            ys8.a r3 = r118.L2();
            if (r3 == null) goto L58;
            ArrayList r4 = new ArrayList();
            Iterator<T> r119 = r117.iterator();
        L50:
            if (r119.hasNext() == false) goto L57;
            ImageStyleRecommendApi.ImageStyle r5 = (ImageStyleRecommendApi.ImageStyle) r119.next();
            if (r5 == null) goto L54;
            w r6 = ImageStyleListComponent.P2(r5);
        L55:
            if (r6 == null) goto L50;
            r4.add(r6);
            goto L50
        L54:
            r6 = null;
            goto L55
        L57:
            r3.refreshImageListSelectorWithMore(r4);
        L58:
            Keva r120 = c.a;
            c.a(r118.k, IAIChatUgcAIGCService.a.K0());
            goto L104
        L60:
            if (Intrinsics.areEqual(r16, sy9.b.d.a) == true) goto L104;
            if ((r16 instanceof sy9.b.e) == false) goto L102;
            ImageStyleListComponent r121 = this.a;
            List<w> r7 = r121.l;
            if (r7 != null) goto L69;
            ys8.a r8 = r121.L2();
            if (r8 == null) goto L68;
            r7 = r8.getCurImageList();
            goto L69
        L68:
            r7 = null;
        L69:
            r121.l = r7;
            ImageStyleListComponent r122 = this.a;
            if (r122.j == false) goto L104;
            r122.j = false;
            ImageStyleRecommendApi.ImageStyleRecommendResponse r9 = r122.k;
            if (r9 != null) goto L86;
            r122.h = true;
            ys8.a r123 = r122.L2();
            if (r123 == null) goto L80;
            this.a.getClass();
            ArrayList r10 = new ArrayList();
            int r11 = 1;
        L76:
            r10.add(new w(null, null, null, null, 4, null, null, 8388479));
            if (r11 == 10) goto L79;
            r11 = r11 + 1;
            goto L76
        L79:
            r123.refreshImageListSelectorWithMore(r10);
        L80:
            ImageStyleListComponent r124 = this.a;
            if (r124.i == true) goto L104;
            Object r125 = r124.N2(true, r15);
            if (r125 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L118;
            return r125;
        L118:
            return Unit.INSTANCE;
        L86:
            List<ImageStyleRecommendApi.ImageStyle> r126 = r9.getStyleList();
            if (r126 == null) goto L104;
            ImageStyleListComponent r127 = this.a;
            ys8.a r12 = r127.L2();
            if (r12 == null) goto L100;
            ArrayList r13 = new ArrayList();
            Iterator<T> r128 = r126.iterator();
        L92:
            if (r128.hasNext() == false) goto L99;
            ImageStyleRecommendApi.ImageStyle r20 = (ImageStyleRecommendApi.ImageStyle) r128.next();
            if (r20 == null) goto L96;
            w r21 = ImageStyleListComponent.P2(r20);
        L97:
            if (r21 == null) goto L92;
            r13.add(r21);
            goto L92
        L96:
            r21 = null;
            goto L97
        L99:
            r12.refreshImageListSelectorWithMore(r13);
        L100:
            Keva r129 = c.a;
            c.a(r127.k, IAIChatUgcAIGCService.a.K0());
            goto L104
        L102:
            throw new NoWhenBranchMatchedException();
        }
    }

    public ImageStyleListComponent$bindObservers$1(ImageStyleListComponent r1, Continuation<? super ImageStyleListComponent$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImageStyleListComponent$bindObservers$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ImageStyleListComponent r6 = this.this$0;
        int r2 = ImageStyleListComponent.p;
        sy9.a r7 = (sy9.a) r6.m.getValue();
        if (r7 == null) goto L18;
        i1<sy9.b> r8 = r7.getUiState();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
