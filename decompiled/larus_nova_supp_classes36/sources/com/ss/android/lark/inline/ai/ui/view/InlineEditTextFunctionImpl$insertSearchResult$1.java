package com.ss.android.lark.inline.ai.ui.view;

import android.widget.EditText;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.api.ScenarioType;
import com.ss.android.lark.inline.ai.ui.InlineAIEditText;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.ui.view.InlineEditTextFunctionImpl$insertSearchResult$1", f = "InlineEditTextFunctionImpl.kt", i = {}, l = {543}, m = "invokeSuspend", n = {}, s = {})
final class InlineEditTextFunctionImpl$insertSearchResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EditText $editText;
    final /* synthetic */ Ref.BooleanRef $hasContact;
    final /* synthetic */ Ref.BooleanRef $hasDoc;
    final /* synthetic */ ArrayList<Deferred<Object>> $jobs;
    final /* synthetic */ JSONArray $mentionObjId;
    final /* synthetic */ ScenarioType $scenario;
    final /* synthetic */ List<SearchBaseInfo> $searchBaseInfos;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ c this$0;

    public InlineEditTextFunctionImpl$insertSearchResult$1(List<? extends SearchBaseInfo> r1, ArrayList<Deferred<Object>> r2, Ref.BooleanRef r3, Ref.BooleanRef r4, ScenarioType r5, JSONArray r6, c r7, EditText r8, Continuation<? super InlineEditTextFunctionImpl$insertSearchResult$1> r9) {
        this.$searchBaseInfos = r1;
        this.$jobs = r2;
        this.$hasDoc = r3;
        this.$hasContact = r4;
        this.$scenario = r5;
        this.$mentionObjId = r6;
        this.this$0 = r7;
        this.$editText = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        InlineEditTextFunctionImpl$insertSearchResult$1 r10 = new InlineEditTextFunctionImpl$insertSearchResult$1(this.$searchBaseInfos, this.$jobs, this.$hasDoc, this.$hasContact, this.$scenario, this.$mentionObjId, this.this$0, this.$editText, r13);
        r10.L$0 = r12;
        return r10;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0188 -> B:45:0x018b). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r28) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r3 = "doc";
        InlineAIEditText r6 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        Iterator r4 = (Iterator) this.L$2;
        Continuation r8 = (EditText) this.L$1;
        c r9 = (c) this.L$0;
        ResultKt.throwOnFailure(r28);
        Object r7 = r28;
        InlineAIEditText r20 = null;
        InlineEditTextFunctionImpl$insertSearchResult$1 r10 = this;
    L46:
        if ((r7 instanceof Triple) == false) goto L49;
        Triple r11 = (Triple) r7;
        c.a(r9, r8, String.valueOf(r11.getFirst()), String.valueOf(r11.getSecond()), String.valueOf(r11.getThird()));
    L41:
        if (r4.hasNext() == false) goto L56;
        Deferred r12 = (Deferred) r4.next();
        r10.L$0 = r9;
        r10.L$1 = r8;
        r10.L$2 = r4;
        r10.label = 1;
        r7 = r12.await(r10);
        if (r7 != r0) goto L46;
        return r0;
    L56:
        boolean r1 = r10.$hasDoc.element;
        if (r1 == true) goto L59;
    L61:
        if (r1 == true) goto L63;
    L65:
        if (r1 == false) goto L67;
    L69:
        r3 = "";
    L70:
        int r5 = zlb.a.d;
        ScenarioType r13 = r10.$scenario;
        JSONArray r14 = r10.$mentionObjId;
        Intrinsics.checkNotNullParameter(r13, "scenario");
        Intrinsics.checkNotNullParameter(r3, "mentionType");
        Intrinsics.checkNotNullParameter(r14, "mentionObjId");
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L73
        r15.put("product_type", r13.name().toLowerCase(Locale.ROOT));     // Catch: Exception -> L73
        r15.put("target", "none");     // Catch: Exception -> L73
        r15.put("click", "mention_confirm");     // Catch: Exception -> L73
        r15.put("mention_type", r3);     // Catch: Exception -> L73
        r15.put("mention_obj_id", r14.toString());     // Catch: Exception -> L73
        com.ss.android.lark.statistics.b.b("ccm_ai_mention_panel_click", r15);     // Catch: Exception -> L73
        zlb.a.c = 0;     // Catch: Exception -> L73
        Log.d("InlineAIReport", "report, event = ccm_ai_mention_panel_click, params = " + r15);     // Catch: Exception -> L73
    L76:
        return Unit.INSTANCE;
    L73:
        e = move-exception;
        Log.e("InlineAIReport", "Exception: " + e);
        goto L76
    L67:
        if (r10.$hasContact.element == false) goto L69;
        r3 = "user";
        goto L70
    L63:
        if (r10.$hasContact.element == true) goto L65;
    L59:
        if (r10.$hasContact.element == false) goto L61;
        r3 = "doc_and_user";
        goto L70
    L49:
        if ((r7 instanceof hob.c) == false) goto L41;
        if ((r8 instanceof InlineAIEditText) == false) goto L53;
        InlineAIEditText r16 = (InlineAIEditText) r8;
    L54:
        if (r16 == null) goto L41;
        ((com.ss.android.lark.keyboard.edittext2.edittors.a) r16.q(com.ss.android.lark.keyboard.edittext2.edittors.a.e)).insert(r7);
        goto L41
    L53:
        r16 = r20;
        goto L54
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r28);
        CoroutineScope r17 = (CoroutineScope) this.L$0;
        List<SearchBaseInfo> r18 = this.$searchBaseInfos;
        ArrayList<Deferred<Object>> r19 = this.$jobs;
        Ref.BooleanRef r110 = this.$hasContact;
        JSONArray r111 = this.$mentionObjId;
        Ref.BooleanRef r112 = this.$hasDoc;
        c r113 = this.this$0;
        Iterator<T> r114 = r18.iterator();
    L10:
        if (r114.hasNext() == false) goto L39;
        SearchChatterInfo r21 = (SearchBaseInfo) r114.next();
        if ((r21 instanceof SearchChatterInfo) == false) goto L14;
        SearchChatterInfo r22 = r21;
        String r23 = r22.getId();
        String r24 = r22.getTitle() + " \u200b";
        Intrinsics.checkNotNull(r23);
        c r25 = r113;
        Ref.BooleanRef r26 = r112;
        Object r115 = r0;
        JSONArray r27 = r111;
        r19.add(BuildersKt.async$default(r17, null, null, new InlineEditTextFunctionImpl$insertSearchResult$1$1$1(r113, new hob.c(r23, r24, r24, false, false), r6), 3, null));
        r110.element = true;
        JSONObject r29 = new JSONObject();
        r29.put("object_id", du5.b.g(r23));
        r29.put("object_type", "user");
        r27.put(r29);
    L28:
        c r30 = r25;
        Ref.BooleanRef r31 = r26;
        InlineAIEditText r210 = null;
    L38:
        r17 = r17;
        r111 = r27;
        r112 = r31;
        r113 = r30;
        r0 = r115;
        r6 = r210;
        goto L10
    L14:
        r115 = r0;
        r25 = r113;
        r26 = r112;
        r27 = r111;
        boolean r32 = r21 instanceof SearchSpaceInfo;
        if (r32 == false) goto L17;
    L20:
        if (r32 == false) goto L24;
        String r33 = ((SearchSpaceInfo) r21).getDocUrl();
    L22:
        String r116 = r33;
    L27:
        if (r116 == null) goto L28;
        String r34 = r21.getTitle();
        if (r34 == null) goto L28;
        InlineEditTextFunctionImpl$insertSearchResult$1$1$3 r117 = new InlineEditTextFunctionImpl$insertSearchResult$1$1$3(r25, r116, r34, null);
        CoroutineScope r35 = r17;
        r210 = null;
        String r36 = r116;
        r19.add(BuildersKt.async$default(r35, null, null, r117, 3, null));
        r31 = r26;
        r31.element = true;
        r30 = r25;
        sbb.a r118 = r30.g;
        if (r118 == null) goto L36;
        String r37 = r118.a(r36);
        if (r37 == null) goto L36;
    L37:
        JSONObject r119 = new JSONObject();
        r119.put("object_id", du5.b.g(r37));
        r119.put("object_type", "doc");
        r27.put(r119);
    L36:
        r37 = "";
        goto L37
    L24:
        if ((r21 instanceof SearchWikiInfo) == false) goto L26;
        r33 = ((SearchWikiInfo) r21).getUrl();
        goto L22
    L26:
        r116 = null;
        goto L27
    L17:
        if ((r21 instanceof SearchWikiInfo) == true) goto L20;
        Unit r38 = Unit.INSTANCE;
        goto L28
    L39:
        Object r120 = r0;
        r20 = r6;
        ArrayList<Deferred<Object>> r39 = this.$jobs;
        c r40 = this.this$0;
        r9 = r40;
        r8 = this.$editText;
        r4 = r39.iterator();
        r10 = this;
        r0 = r120;
        goto L41
    }
}
