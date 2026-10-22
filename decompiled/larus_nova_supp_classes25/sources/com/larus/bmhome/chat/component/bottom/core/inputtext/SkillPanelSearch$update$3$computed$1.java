package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/SkillPanelSearchResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.SkillPanelSearch$update$3$computed$1", f = "SkillPanelSearch.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
public final class SkillPanelSearch$update$3$computed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super s1>, Object> {
    final /* synthetic */ String $currentUserId;
    final /* synthetic */ String $newQuery;
    final /* synthetic */ List<be8.b> $newSkills;
    int label;
    final /* synthetic */ SkillPanelSearch this$0;

    public SkillPanelSearch$update$3$computed$1(SkillPanelSearch r1, String r2, List<be8.b> r3, String r4, Continuation<? super SkillPanelSearch$update$3$computed$1> r5) {
        this.this$0 = r1;
        this.$currentUserId = r2;
        this.$newSkills = r3;
        this.$newQuery = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SkillPanelSearch$update$3$computed$1(this.this$0, this.$currentUserId, this.$newSkills, this.$newQuery, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super s1> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        List r7 = (List) r6;
        JobKt.ensureActive(getContext());
        Context r2 = this.this$0.c;
        List r3 = r7;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L13:
        if (r5.hasNext() == false) goto L16;
        r4.add(((t1) r5.next()).a);
        goto L13
    L16:
        return new s1(r7, r1.a(r2, r4, this.$newQuery));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        SkillSearchIndex r8 = this.this$0.b;
        String r9 = this.$currentUserId;
        List<be8.b> r10 = this.$newSkills;
        String r11 = this.$newQuery;
        this.label = 1;
        r6 = r8.b(r9, r10, r11, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
