package com.obric.assistant.card;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.MusicEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/aiagent/assistant/idl/bean/AppIntentCardData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.card.ShowAllDialogFragment$loadInitialData$1$initialData$1", f = "ShowAllDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ShowAllDialogFragment$loadInitialData$1$initialData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends MessageExtraForViewHolder, ? extends List<? extends AppIntentCardData>>>, Object> {
    int label;
    final /* synthetic */ ShowAllDialogFragment this$0;

    public ShowAllDialogFragment$loadInitialData$1$initialData$1(ShowAllDialogFragment r1, Continuation<? super ShowAllDialogFragment$loadInitialData$1$initialData$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ShowAllDialogFragment$loadInitialData$1$initialData$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Pair<MessageExtraForViewHolder, ? extends List<AppIntentCardData>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L68;
        ResultKt.throwOnFailure(r19);
        ShowAllDialogFragment r2 = this.this$0;
        int r0 = ShowAllDialogFragment.n;
        Bundle r3 = r2.getArguments();
        if (r3 == null) goto L10;
        MessageExtraForViewHolder r1 = (MessageExtraForViewHolder) r3.getParcelable("message_extra");
        if (r1 == null) goto L10;
        MessageExtraForViewHolder r4 = r1;
    L11:
        boolean r5 = false;
        Object r7 = null;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L35
        if (r3 != null) goto L16;
    L18:
        boolean r8 = false;
    L19:
        if (r8 == false) goto L23;
        Object r9 = r3.getParcelableArrayList("dataV2");     // Catch: Throwable -> L35
        if (r9 != null) goto L33;
        r9 = CollectionsKt.emptyList();     // Catch: Throwable -> L35
    L33:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L35
    L37:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L41;
        FLogger.a.w("ShowAllDialogFragment", "failed to get dataList: " + r11.getMessage(), r11);
    L41:
        if (Result.isFailure-impl(r10) == true) goto L44;
        r7 = r10;
    L44:
        List r12 = (List) r7;
        if (r12 != null) goto L48;
        r12 = CollectionsKt.emptyList();
    L48:
        if (r3 == null) goto L51;
        Bundle r13 = r3.getBundle("trace_info");
        if (r13 == null) goto L51;
    L52:
        r2.k = new Bundle(r13);
        List r14 = r12;
        if ((r14 instanceof Collection) == true) goto L55;
    L57:
        Iterator r15 = r14.iterator();
    L59:
        if (r15.hasNext() == false) goto L63;
        if ((((AppIntentCardData) r15.next()).getAppEntity() instanceof MusicEntity) == false) goto L59;
        r5 = true;
    L63:
        if (r5 == false) goto L66;
        r2.k.putString("current_page", "doubao_apps_detail");
        r2.k.remove("operation_type");
        r2.k.remove("click_result");
        r2.k.remove("click_music_result");
        gda.a r16 = gda.a.a;
        Bundle r17 = r2.k;
        Intrinsics.checkNotNullParameter(r17, "traceInfo");
        com.larus.platform.service.o.a.b("obric_card_show", r17);
    L66:
        return TuplesKt.to(r4, r12);
    L55:
        if (r14.isEmpty() == false) goto L57;
    L51:
        r13 = new Bundle();
        goto L52
    L23:
        if (r3 == null) goto L25;
        List r18 = r3.getParcelableArrayList(LynxResourceModule.DATA_KEY);     // Catch: Throwable -> L35
    L26:
        if (r18 != null) goto L28;
        r18 = CollectionsKt.emptyList();     // Catch: Throwable -> L35
    L28:
        List r20 = r18;     // Catch: Throwable -> L35
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));     // Catch: Throwable -> L35
        Iterator r22 = r20.iterator();     // Catch: Throwable -> L35
    L30:
        if (r22.hasNext() == false) goto L32;
        AppEntity r110 = (AppEntity) r22.next();     // Catch: Throwable -> L35
        AppIntentCardData.a r23 = AppIntentCardData.Companion;     // Catch: Throwable -> L35
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L35
        r23.getClass();     // Catch: Throwable -> L35
        Intrinsics.checkNotNullParameter(r110, "appEntity");     // Catch: Throwable -> L35
        r21.add(new AppIntentCardData(0, r110, null, false, false, 28, null));     // Catch: Throwable -> L35
        goto L30
    L32:
        r9 = r21;
        goto L33
    L25:
        r18 = null;
        goto L26
    L16:
        if (r3.containsKey("dataV2") != true) goto L18;
        r8 = true;
    L35:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L10:
        r4 = new MessageExtraForViewHolder(false, false, null, null, null, null, null, 127);
        goto L11
    L68:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
