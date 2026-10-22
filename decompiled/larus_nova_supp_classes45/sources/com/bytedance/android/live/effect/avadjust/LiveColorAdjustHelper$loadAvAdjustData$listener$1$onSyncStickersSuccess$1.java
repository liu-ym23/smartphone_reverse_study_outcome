package com.bytedance.android.live.effect.avadjust;

import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.effect.avadjust.LiveColorAdjustHelper$loadAvAdjustData$listener$1$onSyncStickersSuccess$1", f = "LiveColorAdjustHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LiveColorAdjustHelper$loadAvAdjustData$listener$1$onSyncStickersSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EffectChannelResponse $effectCategoryResponseList;
    int label;
    final /* synthetic */ LiveColorAdjustHelper$loadAvAdjustData$listener$1 this$0;

    public LiveColorAdjustHelper$loadAvAdjustData$listener$1$onSyncStickersSuccess$1(LiveColorAdjustHelper$loadAvAdjustData$listener$1 r1, EffectChannelResponse r2, Continuation r3) {
        this.this$0 = r1;
        this.$effectCategoryResponseList = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new LiveColorAdjustHelper$loadAvAdjustData$listener$1$onSyncStickersSuccess$1(this.this$0, this.$effectCategoryResponseList, r4);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L110;
        ResultKt.throwOnFailure(r21);
        ALogger.i("ttlive_anchor_effect_LiveColorAdjustHelper", "loadAvAdjustData start callback");
        l r2 = this.this$0.a;
        List r3 = this.$effectCategoryResponseList.getAllCategoryEffects();
        l.c r4 = this.this$0.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "list");
        ALogger.i("ttlive_anchor_effect_LiveColorAdjustHelper", "loadSmallItemBeautySuccess, " + System.currentTimeMillis());
        ((CopyOnWriteArrayList) r2.b).clear();
        ArrayList r5 = new ArrayList();
        List r6 = r3;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = r6.iterator();
    L6:
        if (r8.hasNext() == false) goto L52;
        Effect r9 = (Effect) r8.next();
        if (r9.getEffectType() == 1) goto L10;
    L12:
        boolean r11 = false;
    L13:
        ArrayList r12 = new ArrayList();
        if (r11 == false) goto L51;
        String r13 = r9.getResourceId();
        List r14 = r9.getChildEffects();
        if (r14 == null) goto L36;
        Iterator r15 = r14.iterator();
        int r16 = 0;
    L19:
        if (r15.hasNext() == false) goto L34;
        Effect r17 = (Effect) r15.next();
        List<String> r18 = LiveEffectContext.h;
        Iterator<T> r19 = LiveEffectContext.a.a(r2.e).a().o("live_adjustment").iterator();
    L22:
        if (r19.hasNext() == false) goto L27;
        Object r110 = r19.next();
        if (Intrinsics.areEqual(((Sticker) r110).getEffectId(), r17.getEffectId()) == false) goto L22;
    L28:
        if (r110 == null) goto L30;
        boolean r0 = true;
    L31:
        if (r0 == true) goto L35;
        r16 = r16 + 1;
    L35:
        Integer r1 = Integer.valueOf(r16);
    L37:
        int r22 = r1.intValue();
        if (r22 > 0) goto L40;
        r22 = 0;
    L40:
        List r23 = r9.getChildEffects();
        if (r23 == null) goto L51;
        int r24 = r23.size();
        int r111 = 0;
    L43:
        if (r111 >= r24) goto L51;
        if (r111 != r22) goto L46;
        boolean r112 = true;
    L47:
        int r113 = r22;
        Sticker r25 = l.a(r2, r2.b, (Effect) ListProtector.get(r23, r111), r112, r13);
        if (r25.getSmallItemConfig() == null) goto L50;
        r12.add(r25);
    L50:
        r111 = r111 + 1;
        r22 = r113;
        goto L43
    L46:
        r112 = false;
        goto L47
    L30:
        r0 = false;
        goto L31
    L27:
        r110 = null;
        goto L28
    L34:
        r16 = -1;
        goto L35
    L36:
        r1 = null;
    L51:
        Sticker r26 = l.a(r2, r2.b, r9, !r11, null);
        r26.setSubStickers(r12);
        r7.add(r26);
        goto L6
    L10:
        if (CollectionUtils.isEmpty(r9.getChildEffects()) == true) goto L12;
        r11 = true;
        goto L13
    L52:
        r5.clear();
        r5.addAll(r7);
        if (r7.isEmpty() == false) goto L55;
        r2.d.l("empty beauty list");
        ALogger.e("ttlive_anchor_effect_LiveColorAdjustHelper", "empty beauty list: " + r5);
    L55:
        ArrayList r27 = new ArrayList();
        Iterator r28 = r7.iterator();
    L57:
        if (r28.hasNext() == false) goto L89;
        Object r29 = r28.next();
        Sticker r31 = (Sticker) r29;
        if (CollectionUtils.isEmpty(r31.getSubStickers()) == true) goto L64;
        List r32 = r31.getSubStickers();
        if (r32 == null) goto L64;
        Sticker r33 = (Sticker) ListProtector.get(r32, 0);
    L65:
        List r114 = r31.getSubStickers();
        if (r114 == null) goto L77;
        Iterator r115 = r114.iterator();
    L69:
        if (r115.hasNext() == false) goto L77;
        Sticker r116 = (Sticker) r115.next();
        Effect r117 = r31.getEffect();
        if (r117 == null) goto L73;
        String r118 = r117.getResourceId();
    L74:
        r116.setParentResId(r118);
        if (r116.getDefault() == false) goto L69;
        r33 = r116;
        goto L69
    L73:
        r118 = null;
    L77:
        if (r33 == null) goto L80;
        ((CopyOnWriteArrayList) r2.a).add(r33);
    L80:
        if (r31.getSmallItemConfig() == null) goto L82;
    L85:
        boolean r34 = true;
    L86:
        if (r34 == false) goto L57;
        r27.add(r29);
        goto L57
    L82:
        if (CollectionUtils.isEmpty(r31.getSubStickers()) == false) goto L85;
        r34 = false;
    L64:
        r33 = null;
        goto L65
    L89:
        if (r27.isEmpty() == false) goto L91;
        r2.d.l("beauty list cleared by filter1");
        ALogger.e("ttlive_anchor_effect_LiveColorAdjustHelper", "beauty list cleared by filter1: " + r5);
    L91:
        List<Sticker> r35 = CollectionsKt.toList(r27);
        if (r4 != null) goto L95;
    L107:
        ALogger.i("ttlive_anchor_effect_LiveColorAdjustHelper", "loadAvAdjustData end callback");
        return Unit.INSTANCE;
    L95:
        if ((!Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()))) == false) goto L97;
        AndroidSchedulers.mainThread().scheduleDirect(new n(r35, r4));
        goto L107
    L97:
        List<Sticker> r36 = r35;
        if (r36 != null) goto L100;
    L103:
        boolean r37 = true;
    L104:
        if (r37 == false) goto L106;
        r4.onError();
        goto L107
    L106:
        r4.onSuccess(r35);
        goto L107
    L100:
        if (r36.isEmpty() == true) goto L103;
        r37 = false;
        goto L104
    L110:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
