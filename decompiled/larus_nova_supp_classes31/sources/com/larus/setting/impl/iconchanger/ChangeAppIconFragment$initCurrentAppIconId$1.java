package com.larus.setting.impl.iconchanger;

import androidx.lifecycle.FlowLiveDataConversions;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.home.api.main.AppIconsType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.tencent.open.log.TraceLevel;
import java.util.List;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.iconchanger.ChangeAppIconFragment$initCurrentAppIconId$1", f = "ChangeAppIconFragment.kt", i = {}, l = {773, 773}, m = "invokeSuspend", n = {}, s = {})
final class ChangeAppIconFragment$initCurrentAppIconId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChangeAppIconFragment this$0;

    public static final class a implements IIMCallback<BotModel> {
        public final /* synthetic */ ChangeAppIconFragment a;

        public final boolean mustInMain() {
            return true;
        }

        public a(ChangeAppIconFragment r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final void onSuccess(Object r3) {
            BotModel r4 = (BotModel) r3;
            Intrinsics.checkNotNullParameter(r4, "result");
            ChangeAppIconFragment r0 = this.a;
            AppIconsType.a r1 = AppIconsType.Companion;
            String r5 = r4.getBotIconMappedAppIcon();
            if (r5 == null) goto L5;
            Integer r6 = StringsKt.toIntOrNull(r5);
        L6:
            r1.getClass();
            AppIconsType r7 = AppIconsType.a.a(r6);
            if (r7 == null) goto L9;
            int r8 = r7.getAppIconId();
        L10:
            r0.h = r8;
            ChangeAppIconFragment r9 = this.a;
            r9.g = r9.h;
            BotModel r2 = r9.r;
            if (r2 == null) goto L16;
            SpeakerVoice r10 = r2.getVoiceType();
            if (r10 == null) goto L16;
            String r11 = r10.getLanguageCode();
            if (r11 == null) goto L16;
        L17:
            r9.u = r11;
            this.a.aa0();
            this.a.ca0();
            return;
        L16:
            r11 = "zh";
            goto L17
        L9:
            r8 = AppIconsType.DEFAULT.getAppIconId();
            goto L10
        L5:
            r6 = null;
            goto L6
        }
    }

    public ChangeAppIconFragment$initCurrentAppIconId$1(ChangeAppIconFragment r1, Continuation<? super ChangeAppIconFragment$initCurrentAppIconId$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChangeAppIconFragment$initCurrentAppIconId$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L18:
        List r8 = (List) r7;
        if (r8 == null) goto L25;
        String r2 = (String) CollectionsKt.firstOrNull(r8);
        if (r2 == null) goto L25;
        com.larus.im.service.o.a.a(com.larus.im.d.a(), r2, false, null, new a(this.this$0), 12);
        return Unit.INSTANCE;
    L25:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        wc9.e r9 = (wc9.e) r7;
        if (r9 == null) goto L25;
        this.label = 2;
        r7 = ic8.n.c(r9, this);
        if (r7 != r0) goto L18;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        Flow r10 = FlowLiveDataConversions.asFlow(AuthModelDelegate.b.y());
        ChangeAppIconFragment$initCurrentAppIconId$1$mainBotId$1 r3 = new ChangeAppIconFragment$initCurrentAppIconId$1$mainBotId$1(null);
        this.label = 1;
        r7 = kotlinx.coroutines.flow.e.u(r10, r3, this);
        if (r7 != r0) goto L13;
        return r0;
    }
}
