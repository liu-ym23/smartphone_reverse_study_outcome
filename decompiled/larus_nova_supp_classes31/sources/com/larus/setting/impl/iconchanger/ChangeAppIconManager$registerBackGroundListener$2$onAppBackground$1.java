package com.larus.setting.impl.iconchanger;

import android.app.Application;
import androidx.lifecycle.FlowLiveDataConversions;
import com.larus.bmhome.auth.CocoSetting;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.e0;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.home.api.main.AppIconsType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.setting.api.CustomAppIcon;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
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
@DebugMetadata(c = "com.larus.setting.impl.iconchanger.ChangeAppIconManager$registerBackGroundListener$2$onAppBackground$1", f = "ChangeAppIconManager.kt", i = {2}, l = {329, 329, 333}, m = "invokeSuspend", n = {"mainBotId"}, s = {"L$0"})
public final class ChangeAppIconManager$registerBackGroundListener$2$onAppBackground$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Application $context;
    Object L$0;
    int label;

    public static final class a implements IIMCallback<BotModel> {
        public final /* synthetic */ String a;
        public final /* synthetic */ Application b;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.i("ChangeAppIconDynamicImgLoader", "IIMError:" + r4);
        }

        public final void onSuccess(Object r4) {
            BotModel r5 = (BotModel) r4;
            Intrinsics.checkNotNullParameter(r5, "result");
            String r6 = r5.getBotIconMappedAppIcon();
            if (r6 == null) goto L5;
            Integer r7 = StringsKt.toIntOrNull(r6);
        L6:
            CustomAppIcon.a.a(r7, this.a);
            LinkedHashSet r0 = new LinkedHashSet();
            c1 r1 = (c1) AuthModelDelegate.b.c().getValue();
            if (r1 == null) goto L16;
            e0 r2 = (e0) r1.d;
            if (r2 == null) goto L16;
            List r3 = r2.p();
            if (r3 == null) goto L16;
            Iterator r8 = r3.iterator();
        L14:
            if (r8.hasNext() == false) goto L16;
            r0.add(((CocoSetting) r8.next()).a());
        L16:
            if (r7 != null) goto L19;
            WeakReference<CommonDialog> r9 = ChangeAppIconManager.a;
            ChangeAppIconManager.d(this.b, AppIconsType.DEFAULT);
        L19:
            if (r0.contains(r7) == true) goto L22;
            WeakReference<CommonDialog> r10 = ChangeAppIconManager.a;
            ChangeAppIconManager.d(this.b, AppIconsType.DEFAULT);
        L22:
            if (r0.contains(r7) == false) goto L28;
            AppIconsType.Companion.getClass();
            AppIconsType r11 = AppIconsType.a.a(r7);
            if (r11 == null) goto L29;
            ChangeAppIconManager.d(this.b, r11);
            return;
        L29:
            return;
        L28:
            return;
        L5:
            r7 = null;
            goto L6
        }

        public a(String r1, Application r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public ChangeAppIconManager$registerBackGroundListener$2$onAppBackground$1(Application r1, Continuation<? super ChangeAppIconManager$registerBackGroundListener$2$onAppBackground$1> r2) {
        this.$context = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChangeAppIconManager$registerBackGroundListener$2$onAppBackground$1(this.$context, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r5 = null;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r13);
        String r7 = r2;
    L30:
        wc9.e r14 = (wc9.e) r13;
        if (r14 == null) goto L33;
        r5 = r14.a;
    L33:
        com.larus.im.service.o.a.a(com.larus.im.d.a(), r7, false, null, new a(r5, this.$context), 12);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r13);
    L20:
        List r15 = (List) r13;
        if (r15 == null) goto L25;
        String r16 = (String) CollectionsKt.firstOrNull(r15);
        if (r16 == null) goto L25;
    L26:
        Flow r3 = FlowLiveDataConversions.asFlow(AuthModelDelegate.b.y());
        ChangeAppIconManager$registerBackGroundListener$2$onAppBackground$1$conversationId$1 r4 = new ChangeAppIconManager$registerBackGroundListener$2$onAppBackground$1$conversationId$1(null);
        this.L$0 = r16;
        this.label = 3;
        Object r6 = kotlinx.coroutines.flow.e.u(r3, r4, this);
        if (r6 != r0) goto L29;
        return r0;
    L29:
        r7 = r16;
        r13 = r6;
    L25:
        r16 = "";
        goto L26
    L11:
        ResultKt.throwOnFailure(r13);
    L15:
        wc9.e r17 = (wc9.e) r13;
        if (r17 == null) goto L25;
        this.label = 2;
        r13 = ic8.n.c(r17, this);
        if (r13 != r0) goto L20;
        return r0;
    L12:
        ResultKt.throwOnFailure(r13);
        Flow r18 = FlowLiveDataConversions.asFlow(AuthModelDelegate.b.y());
        ChangeAppIconManager$registerBackGroundListener$2$onAppBackground$1$mainBotId$1 r8 = new ChangeAppIconManager$registerBackGroundListener$2$onAppBackground$1$mainBotId$1(null);
        this.label = 1;
        r13 = kotlinx.coroutines.flow.e.u(r18, r8, this);
        if (r13 != r0) goto L15;
        return r0;
    }
}
