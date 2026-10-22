package com.larus.bmhome.chat.deepresearch.component;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepresearch.component.DeepReSearchContentComponent$initPodcastBtn$1", f = "DeepReSearchContentComponent.kt", i = {}, l = {DoraCallStateCode.RTC_STOP_FROM_P2P_FAILED}, m = "invokeSuspend", n = {}, s = {})
final class DeepReSearchContentComponent$initPodcastBtn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enablePodcastButton;
    int label;
    final /* synthetic */ DeepReSearchContentComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DeepReSearchContentComponent a;
        public final /* synthetic */ boolean b;

        public a(DeepReSearchContentComponent r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r6, Continuation r7) {
            Pair r8 = (Pair) r6;
            String r0 = (String) r8.getFirst();
            int r1 = r0.hashCode();
            if (r1 == (-1537528217)) goto L17;
            if (r1 == 348432464) goto L14;
            if (r1 == 1804650550) goto L10;
        L26:
            FLogger r9 = FLogger.a;
            Map<String, Long> r2 = DeepReSearchContentComponent.M;
            r9.e("DeepSearchContent", "receive event [" + ((String) r8.getFirst()) + "], payload=" + r8.getSecond());
        L28:
            return Unit.INSTANCE;
        L10:
            if (r0.equals("EVENT_DEEP_RESEARCH_PODCAST_PLAYER_OPENED") == false) goto L26;
            FLogger r10 = FLogger.a;
            Map<String, Long> r3 = DeepReSearchContentComponent.M;
            r10.i("DeepSearchContent", "receive applet EVENT_DEEP_RESEARCH_PODCAST_PLAYER_OPENED payload=" + r8.getSecond());
            this.a.E = false;
            goto L28
        L14:
            if (r0.equals("EVENT_DEEP_RESEARCH_PODCAST_STARTED") == false) goto L26;
        L18:
            String r4 = JSONObjectProtectorUtils.getString((JSONObject) r8.getSecond(), "resource_id");
            DeepReSearchContentComponent r5 = this.a;
            Map<String, Long> r11 = DeepReSearchContentComponent.M;
            if (Intrinsics.areEqual(r4, r5.C3()) == false) goto L28;
            if ((!StringsKt.isBlank(this.a.C3())) == false) goto L28;
            Object r12 = BuildersKt.withContext(Dispatchers.getMain(), new DeepReSearchContentComponent$initPodcastBtn$1$1$1(this.a, this.b, r8, null), r7);
            if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
            return r12;
        L29:
            return Unit.INSTANCE;
        L17:
            if (r0.equals("EVENT_ATTACH_FLOAT_PAGE") == false) goto L26;
            goto L18
        }
    }

    public DeepReSearchContentComponent$initPodcastBtn$1(DeepReSearchContentComponent r1, boolean r2, Continuation<? super DeepReSearchContentComponent$initPodcastBtn$1> r3) {
        this.this$0 = r1;
        this.$enablePodcastButton = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DeepReSearchContentComponent$initPodcastBtn$1(this.this$0, this.$enablePodcastButton, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L18:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L20;
        FlowAppletServiceImpl r8 = r7.g0();
        if (r8 == null) goto L20;
        i1 r9 = r8.k();
        if (r9 == null) goto L20;
        a r2 = new a(this.this$0, this.$enablePodcastButton);
        this.label = 1;
        if (r9.collect(r2, this) != r0) goto L18;
        return r0;
    L20:
        return Unit.INSTANCE;
    }
}
