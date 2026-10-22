package com.larus.bmhome.chat.list.cell.text.components.middle;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.components.middle.MiddleTextComponent$trackTextCellMarkdownRender$2", f = "MiddleTextComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MiddleTextComponent$trackTextCellMarkdownRender$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enableDataTagOptimize;
    final /* synthetic */ Long $getContentDuration;
    final /* synthetic */ List<String> $nodeTypeList;
    final /* synthetic */ Long $prepareDuration;
    final /* synthetic */ Long $renderDuration;
    final /* synthetic */ Long $renderOptimizeMode;
    final /* synthetic */ Boolean $useCache;
    int label;

    public MiddleTextComponent$trackTextCellMarkdownRender$2(List<String> r1, Long r2, Long r3, Long r4, Boolean r5, Long r6, boolean r7, Continuation<? super MiddleTextComponent$trackTextCellMarkdownRender$2> r8) {
        this.$nodeTypeList = r1;
        this.$prepareDuration = r2;
        this.$getContentDuration = r3;
        this.$renderDuration = r4;
        this.$useCache = r5;
        this.$renderOptimizeMode = r6;
        this.$enableDataTagOptimize = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MiddleTextComponent$trackTextCellMarkdownRender$2(this.$nodeTypeList, this.$prepareDuration, this.$getContentDuration, this.$renderDuration, this.$useCache, this.$renderOptimizeMode, this.$enableDataTagOptimize, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r11);
        String r12 = this.$nodeTypeList.toString();
        Long r0 = this.$prepareDuration;
        Long r1 = this.$getContentDuration;
        Long r2 = this.$renderDuration;
        Boolean r3 = this.$useCache;
        Long r4 = this.$renderOptimizeMode;
        Boolean r5 = Boxing.boxBoolean(this.$enableDataTagOptimize);
        JSONObject r6 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r0 != null) goto L27;
    L9:
        if (r1 == null) goto L11;
        r6.put("get_content_duration", r1.longValue());     // Catch: JSONException -> L7
    L11:
        if (r2 == null) goto L13;
        r6.put("render_duration", r2.longValue());     // Catch: JSONException -> L7
    L13:
        if (r3 == null) goto L15;
        r6.put("use_cache", r3.booleanValue());     // Catch: JSONException -> L7
    L15:
        if (r4 == null) goto L17;
        r6.put("render_optimize_mode", r4.longValue());     // Catch: JSONException -> L7
    L17:
        if (r5 == null) goto L19;
        r6.put("enable_datatag_optimize", r5.booleanValue());     // Catch: JSONException -> L7
    L19:
        if (r12 == null) goto L23;
        r6.put("node_type_list", r12);     // Catch: JSONException -> L7
    L7:
        e = move-exception;
        FLogger.a.e("MarkdownSpanEventHelper", "error in MarkdownSpanEventHelper mobTextcellMarkdownRender " + e.getLocalizedMessage());
    L23:
        TrackParams r13 = new TrackParams().merge(r6);
        by7.a r7 = new by7.a("flow_textcell_markdown_render");
        r7.a.merge(r13);
        r7.b();
        return Unit.INSTANCE;
    L27:
        r6.put("prepare_duration", r0.longValue());     // Catch: JSONException -> L7
        goto L9
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
