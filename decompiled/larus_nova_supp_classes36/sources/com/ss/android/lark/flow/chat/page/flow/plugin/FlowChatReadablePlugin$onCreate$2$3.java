package com.ss.android.lark.flow.chat.page.flow.plugin;

import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.StrangerTagType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.flow.chat.titlebar.FlowTitleBarComponent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.page.flow.plugin.FlowChatReadablePlugin$onCreate$2$3", f = "FlowChatReadablePlugin.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
public final class FlowChatReadablePlugin$onCreate$2$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c $chatApp;
    final /* synthetic */ BaseStrangerRelationViewModel $it;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c a;

        public a(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r1) {
            this.a = r1;
        }

        public final Object emit(Object r6, Continuation r7) {
            StrangerTagType r8 = (StrangerTagType) r6;
            Log.i("FlowChatReadablePlugin", "collect tag type: " + r8);
            FlowTitleBarComponent r9 = this.a.a(ITitlebarComponent.class);
            ugb.c r1 = null;
            if ((r9 instanceof FlowTitleBarComponent) == false) goto L5;
            FlowTitleBarComponent r10 = r9;
        L6:
            if (r10 == null) goto L24;
            Intrinsics.checkNotNullParameter(r8, "tagType");
            Chat r2 = (Chat) r10.C0().getValue();
            if (r2 == null) goto L24;
            TitlebarViewModel r3 = r10.s;
            if (r3 == null) goto L14;
            ChatChatter r4 = FlowTitleBarComponent.G0(r3, r2);
            if (r4 == null) goto L14;
        L18:
            ugb.e r11 = r10.n;
            if ((r11 instanceof ugb.c) == false) goto L21;
            r1 = (ugb.c) r11;
        L21:
            if (r1 == null) goto L24;
            sxa.a r12 = new sxa.a(r2, r4);
            Intrinsics.checkNotNullParameter(r8, "tagType");
            Intrinsics.checkNotNullParameter(r12, "titleContext");
            r1.d = r8;
            r1.a(r1.a.getContext(), r12);
        L14:
            i7b.a r5 = (i7b.a) r10.D0().getValue();
            if (r5 == null) goto L17;
            r4 = r5.g;
            goto L18
        L17:
            r4 = null;
        L24:
            return Unit.INSTANCE;
        L5:
            r10 = null;
            goto L6
        }
    }

    public FlowChatReadablePlugin$onCreate$2$3(BaseStrangerRelationViewModel r1, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, Continuation<? super FlowChatReadablePlugin$onCreate$2$3> r3) {
        this.$it = r1;
        this.$chatApp = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowChatReadablePlugin$onCreate$2$3(this.$it, this.$chatApp, r4);
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
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        z0 r6 = this.$it.getTagFlow();
        a r2 = new a(this.$chatApp);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
