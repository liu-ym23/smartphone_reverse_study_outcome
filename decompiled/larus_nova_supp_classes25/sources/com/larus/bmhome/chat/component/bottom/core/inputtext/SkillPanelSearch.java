package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.AccountService;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SkillPanelSearch {
    public final CoroutineScope a;
    public final SkillSearchIndex b;
    public final Context c;
    public String d;
    public List<be8.b> e;
    public String f;
    public long g;
    public Job h;
    public s1 i;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.SkillPanelSearch$update$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.SkillPanelSearch$update$3", f = "SkillPanelSearch.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $currentUserId;
        final /* synthetic */ String $newQuery;
        final /* synthetic */ List<be8.b> $newSkills;
        final /* synthetic */ Function0<Unit> $onResult;
        final /* synthetic */ long $requestGeneration;
        int label;
        final /* synthetic */ SkillPanelSearch this$0;

        public AnonymousClass3(SkillPanelSearch r1, long r2, String r4, Function0<Unit> r5, List<be8.b> r6, String r7, Continuation<? super AnonymousClass3> r8) {
            this.this$0 = r1;
            this.$requestGeneration = r2;
            this.$currentUserId = r4;
            this.$onResult = r5;
            this.$newSkills = r6;
            this.$newQuery = r7;
            super(2, r8);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass3(this.this$0, this.$requestGeneration, this.$currentUserId, this.$onResult, this.$newSkills, this.$newQuery, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            s1 r11 = (s1) r10;
            if (this.this$0.g != this.$requestGeneration) goto L19;
            if (Intrinsics.areEqual(AccountService.a.getUserId(), this.$currentUserId) == false) goto L19;
            SkillPanelSearch r2 = this.this$0;
            r2.i = r11;
            r2.h = null;
            this.$onResult.invoke();
            return Unit.INSTANCE;
        L19:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            CoroutineDispatcher r12 = Dispatchers.getDefault();
            SkillPanelSearch$update$3$computed$1 r3 = new SkillPanelSearch$update$3$computed$1(this.this$0, this.$currentUserId, this.$newSkills, this.$newQuery, null);
            this.label = 1;
            r10 = BuildersKt.withContext(r12, r3, this);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    public final void a() {
        this.g++;
        Job r0 = this.h;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.h = null;
        this.i = null;
        this.e = null;
        this.f = null;
        this.d = null;
    }

    public SkillPanelSearch(Context r2, CoroutineScope r3, SkillSearchIndex r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "coroutineScope");
        Intrinsics.checkNotNullParameter(r4, "index");
        this.a = r3;
        this.b = r4;
        this.c = r2.getApplicationContext();
    }

    public final s1 update(List<be8.b> r17, String r18, Function0<Unit> r19) {
        Intrinsics.checkNotNullParameter(r17, "newSkills");
        Intrinsics.checkNotNullParameter(r18, "newQuery");
        Intrinsics.checkNotNullParameter(r19, "onResult");
        String r4 = AccountService.a.getUserId();
        if (Intrinsics.areEqual(this.d, r4) == true) goto L5;
    L10:
        a();
        this.d = r4;
        this.e = r17;
        this.f = r18;
        if (r18.length() != 0) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L21;
        List<be8.b> r1 = r17;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L17:
        if (r3.hasNext() == false) goto L19;
        r2.add(new t1((be8.b) r3.next(), CollectionsKt.emptyList(), CollectionsKt.emptyList()));
        goto L17
    L19:
        s1 r5 = new s1(r2, r1.a(this.c, r17, r18));
        this.i = r5;
        return r5;
    L21:
        long r6 = this.g;
        this.h = BuildersKt.launch$default(this.a, null, null, new AnonymousClass3(this, r6, r4, r19, r17, r18, null), 3, null);
        return null;
    L13:
        r0 = false;
        goto L14
    L5:
        if (this.e != r17) goto L10;
        if (Intrinsics.areEqual(this.f, r18) == false) goto L10;
        return this.i;
    }
}
