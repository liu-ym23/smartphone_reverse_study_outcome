package com.obric.assistant.remote_card_container.widget;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.RemoteViews;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant_card.provider_core.bean.ActionType;
import com.obric.aiagent.assistant_card.provider_core.bean.CardAction;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.assistant.remote_card_container.cache.m;
import com.obric.assistant.remote_card_container.cache.n;
import com.obric.assistant.remote_card_container.manager.RemoteCardManager;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.widget.RemoteCardContainer$loadRemoteCard$1", f = "RemoteCardContainer.kt", i = {0, 1, 1, 1}, l = {174, 175}, m = "invokeSuspend", n = {"cardUri", "cardUri", "remoteCard", "isFromCache"}, s = {"L$0", "L$0", "L$1", "Z$0"})
public final class RemoteCardContainer$loadRemoteCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $allowCache;
    final /* synthetic */ a $remoteCardData;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ RemoteCardContainer this$0;

    /* JADX INFO: renamed from: com.obric.assistant.remote_card_container.widget.RemoteCardContainer$loadRemoteCard$1$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.remote_card_container.widget.RemoteCardContainer$loadRemoteCard$1$6", f = "RemoteCardContainer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ a $remoteCardData;
        int label;
        final /* synthetic */ RemoteCardContainer this$0;

        public AnonymousClass6(RemoteCardContainer r1, a r2, Continuation<? super AnonymousClass6> r3) {
            this.this$0 = r1;
            this.$remoteCardData = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass6(this.this$0, this.$remoteCardData, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            FLogger.a.i("RemoteCardContainer", "is expired, reload without cache");
            RemoteCardContainer r4 = this.this$0;
            a r0 = this.$remoteCardData;
            int r1 = RemoteCardContainer.h;
            r4.d(r0, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.remote_card_container.widget.RemoteCardContainer$loadRemoteCard$1$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.remote_card_container.widget.RemoteCardContainer$loadRemoteCard$1$7", f = "RemoteCardContainer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ a $remoteCardData;
        int label;
        final /* synthetic */ RemoteCardContainer this$0;

        public AnonymousClass7(RemoteCardContainer r1, a r2, Continuation<? super AnonymousClass7> r3) {
            this.this$0 = r1;
            this.$remoteCardData = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass7(this.this$0, this.$remoteCardData, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            FLogger.a.i("RemoteCardContainer", "cached apply failed, reload without cache");
            RemoteCardContainer r4 = this.this$0;
            a r0 = this.$remoteCardData;
            int r1 = RemoteCardContainer.h;
            r4.d(r0, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public RemoteCardContainer$loadRemoteCard$1(a r1, RemoteCardContainer r2, boolean r3, Continuation<? super RemoteCardContainer$loadRemoteCard$1> r4) {
        this.$remoteCardData = r1;
        this.this$0 = r2;
        this.$allowCache = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RemoteCardContainer$loadRemoteCard$1(this.$remoteCardData, this.this$0, this.$allowCache, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        boolean r1 = this.Z$0;
        o9a.d r3 = (o9a.d) this.L$1;
        String r8 = (String) this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r10 = r19;
        final String r9 = r8;
        boolean r11 = r1;
    L47:
        Pair r12 = (Pair) r10;
        View r13 = (View) r12.component1();
        boolean r14 = ((Boolean) r12.component2()).booleanValue();
        if (r11 == false) goto L51;
        if (r14 == true) goto L51;
        n.a.b(r9);
        com.obric.assistant.remote_card_container.cache.i r4 = com.obric.assistant.remote_card_container.cache.i.a;
        com.obric.assistant.remote_card_container.cache.i.b(r9);
    L51:
        p9a.e r5 = p9a.b.a;
        p9a.b.a("RemoteCardContainer", "view for " + r9 + " is " + r13);
        if (r13 == null) goto L94;
        if (r3 == null) goto L74;
        List r6 = r3.b;
        if (r6 == null) goto L74;
        final RemoteCardContainer r15 = this.this$0;
        Iterator r7 = r6.iterator();
    L58:
        if (r7.hasNext() == false) goto L74;
        final CardAction r16 = (CardAction) r7.next();
        final Context r17 = r15.getContext();
        String r18 = r16.getType();
        if (Intrinsics.areEqual(r18, ActionType.ACTION_ON_CLICK.getType()) == false) goto L66;
        FLogger.a.i("RemoteCardContainer", "set on click for " + r16.getActionName());
        View r20 = r13.findViewById(r16.getViewId());
        if (r20 == null) goto L64;
        e1.d(r20, new e(r15, r17, r9, r16));
        goto L58
    L64:
        p9a.e r21 = p9a.b.a;
        p9a.b.b("RemoteCardContainer", "not found view " + r9 + " $ " + r16.getViewId());
        goto L58
    L66:
        if (Intrinsics.areEqual(r18, ActionType.ACTION_ON_LONG_CLICK.getType()) == false) goto L71;
        FLogger.a.i("RemoteCardContainer", "set on long click for " + r16.getActionName());
        View r22 = r13.findViewById(r16.getViewId());
        if (r22 == null) goto L70;
        r22.setOnLongClickListener(new f(r15, r17, r9, r16));
        goto L58
    L70:
        p9a.e r23 = p9a.b.a;
        p9a.b.b("RemoteCardContainer", "not found view " + r9 + " $ " + r16.getViewId());
        goto L58
    L71:
        p9a.e r24 = p9a.b.a;
        p9a.b.b("RemoteCardContainer", "setToRemoteViews type not support: " + r16.getType());
    L74:
        if (Build.VERSION.SDK_INT < 30) goto L76;
        boolean r25 = r13.hasOnLongClickListeners();
    L77:
        if (r25 == true) goto L81;
        final RemoteCardContainer r26 = this.this$0;
        if (r26.g == null) goto L81;
        r13.setOnLongClickListener(new j(r26));
    L81:
        this.this$0.removeAllViews();
        this.this$0.addView(r13);
        if (IWindowContextKt.isWindowContext(this.this$0.getContext()) == false) goto L94;
        Set<String> r27 = k.a;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L86
        Object r29 = Result.constructor-impl(p9a.f.a(UriProtector.parse(r9)));     // Catch: Throwable -> L86
    L89:
        if (Result.isFailure-impl(r29) == false) goto L92;
        r29 = null;
    L92:
        if (CollectionsKt.contains(r27, r29) == true) goto L94;
        r13.setBackground(null);
    L86:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L89
    L76:
        FLogger.a.i("RemoteCardContainer", "sdk version too low, use false as default");
        r25 = false;
    L94:
        RemoteCardContainer r31 = this.this$0;
        r31.c = r9;
        if (r3 != null) goto L97;
    L108:
        if (r3 == null) goto L112;
        int r32 = r3.g;
        if (r32 <= 0) goto L112;
        this.this$0.setDefaultRoundAngle(r32);
    L113:
        RemoteCardContainer r33 = this.this$0;
        ViewGroup.LayoutParams r34 = r33.getLayoutParams();
        if (r34 == null) goto L116;
        r34.height = -2;
    L117:
        r33.setLayoutParams(r34);
        if (this.$allowCache == false) goto L131;
        if (r11 == false) goto L131;
        com.obric.assistant.remote_card_container.cache.j r35 = m.a.a(this.$remoteCardData.a);
        if (r35 == null) goto L125;
        boolean r36 = true;
        if (r35.i() != true) goto L125;
    L126:
        if (r36 == false) goto L128;
        RemoteCardContainer r37 = this.this$0;
        BuildersKt.launch$default(r37.a, null, null, new AnonymousClass6(r37, this.$remoteCardData, null), 3, null);
        goto L131
    L128:
        if (r14 == true) goto L131;
        RemoteCardContainer r38 = this.this$0;
        BuildersKt.launch$default(r38.a, null, null, new AnonymousClass7(r38, this.$remoteCardData, null), 3, null);
    L125:
        r36 = false;
    L131:
        return Unit.INSTANCE;
    L116:
        r34 = null;
    L112:
        this.this$0.setDefaultRoundAngle(0);
        goto L113
    L97:
        if (r3.h <= 0) goto L108;
        Context r39 = r31.getContext();
        View r40 = this.this$0.findViewById(r3.h);
        if (r40 == null) goto L108;
        ViewParent r41 = r40.getParent();
        if ((r41 instanceof ViewGroup) == false) goto L104;
        ViewGroup r42 = (ViewGroup) r41;
    L105:
        if (r42 == null) goto L108;
        int r43 = r42.indexOfChild(r40);
        ViewGroup.LayoutParams r44 = r40.getLayoutParams();
        r42.removeView(r40);
        HorizontalScrollView r45 = new HorizontalScrollView(r39);
        r45.setLayoutParams(r44);
        r45.setHorizontalScrollBarEnabled(false);
        r45.setOverScrollMode(2);
        r40.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        r45.addView(r40);
        r42.addView(r45, r43);
        goto L108
    L104:
        r42 = null;
        goto L105
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r46 = (String) this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r47 = r19;
    L39:
        Pair r48 = (Pair) r47;
        o9a.d r49 = (o9a.d) r48.component1();
        r11 = ((Boolean) r48.component2()).booleanValue();
        RemoteCardManager r110 = RemoteCardManager.a;
        Context r111 = this.this$0.getContext();
        RemoteCardContainer r112 = this.this$0;
        if (r49 == null) goto L42;
        RemoteViews r113 = r49.a;
    L43:
        this.L$0 = r46;
        this.L$1 = r49;
        this.Z$0 = r11;
        this.label = 2;
        r10 = RemoteCardManager.a(r111, r112, r113, r46, this);
        if (r10 != r0) goto L46;
        return r0;
    L46:
        r9 = r46;
        r3 = r49;
        goto L47
    L42:
        r113 = null;
        goto L43
    L10:
        ResultKt.throwOnFailure(r19);
        r46 = this.$remoteCardData.a;
        if (Intrinsics.areEqual(this.this$0.c, r46) == true) goto L13;
        RemoteCardContainer r50 = this.this$0;
        r50.c = null;
        r50.removeAllViews();
    L13:
        com.obric.assistant.remote_card_container.cache.j r51 = m.a.a(this.$remoteCardData.a);
        if (r51 != null) goto L16;
        p9a.b.a("RemoteCardContainer", "has not preset height, because of no card info");
        if (this.$remoteCardData.d <= 0) goto L36;
        p9a.b.a("RemoteCardContainer", "use card data height. set height to " + this.$remoteCardData.d);
        RemoteCardContainer r52 = this.this$0;
        ViewGroup.LayoutParams r53 = r52.getLayoutParams();
        if (r53 == null) goto L34;
        r53.height = this.$remoteCardData.d;
    L35:
        r52.setLayoutParams(r53);
        goto L36
    L34:
        r53 = null;
    L36:
        RemoteCardManager r54 = RemoteCardManager.a;
        Context r55 = this.this$0.getContext();
        boolean r114 = this.$allowCache;
        this.L$0 = r46;
        this.label = 1;
        r47 = r54.b(r55, r46, r114, this);
        if (r47 != r0) goto L39;
        return r0;
    L16:
        if (r51.b() <= 0) goto L19;
        int r56 = r51.b();
    L22:
        if (r56 <= 0) goto L28;
        p9a.e r57 = p9a.b.a;
        p9a.b.a("RemoteCardContainer", "set height to " + r56);
        RemoteCardContainer r58 = this.this$0;
        ViewGroup.LayoutParams r115 = r58.getLayoutParams();
        if (r115 == null) goto L26;
        r115.height = r56;
    L27:
        r58.setLayoutParams(r115);
        goto L36
    L26:
        r115 = null;
        goto L27
    L28:
        p9a.b.a("RemoteCardContainer", "has not preset height, because of no height");
        goto L36
    L19:
        if (r51.e() <= 0) goto L21;
        r56 = com.obric.assistant.common.utils.f.a(r51.e());
        goto L22
    L21:
        r56 = 0;
        goto L22
    }
}
