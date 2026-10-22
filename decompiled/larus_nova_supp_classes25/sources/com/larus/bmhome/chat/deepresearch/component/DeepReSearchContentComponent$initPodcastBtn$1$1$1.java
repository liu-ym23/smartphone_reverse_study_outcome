package com.larus.bmhome.chat.deepresearch.component;

import androidx.appcompat.widget.AppCompatImageView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.DeepResearchAdapter;
import com.larus.mainbot.impl.databinding.LarusPageDeepResearchBinding;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepresearch.component.DeepReSearchContentComponent$initPodcastBtn$1$1$1", f = "DeepReSearchContentComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DeepReSearchContentComponent$initPodcastBtn$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enablePodcastButton;
    final /* synthetic */ Pair<String, JSONObject> $it;
    int label;
    final /* synthetic */ DeepReSearchContentComponent this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public DeepReSearchContentComponent$initPodcastBtn$1$1$1(DeepReSearchContentComponent r1, boolean r2, Pair<String, ? extends JSONObject> r3, Continuation<? super DeepReSearchContentComponent$initPodcastBtn$1$1$1> r4) {
        this.this$0 = r1;
        this.$enablePodcastButton = r2;
        this.$it = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DeepReSearchContentComponent$initPodcastBtn$1$1$1(this.this$0, this.$enablePodcastButton, this.$it, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r4);
        Job r5 = this.this$0.q;
        if (r5 == null) goto L8;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L8:
        if (this.$enablePodcastButton == false) goto L14;
        LarusPageDeepResearchBinding r6 = this.this$0.p3();
        if (r6 == null) goto L14;
        AppCompatImageView r7 = r6.i;
        if (r7 == null) goto L14;
        Boxing.boxBoolean(r7.postDelayed(this.this$0.H, 400));
    L14:
        DeepResearchAdapter r8 = this.this$0.u;
        if (r8 == null) goto L17;
        r8.y2("complete");
    L17:
        FLogger r9 = FLogger.a;
        Map<String, Long> r0 = DeepReSearchContentComponent.M;
        r9.i("DeepSearchContent", "receive applet event=" + ((String) this.$it.getFirst()) + " payload=" + this.$it.getSecond());
        return Unit.INSTANCE;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
