package com.obric.assistant.guide.ui;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import com.obric.assistant.settings.SelectableToggleItem;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.guide.ui.LocalDataSearchFragment$onViewCreated$5$1", f = "LocalDataSearchFragment.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
public final class LocalDataSearchFragment$onViewCreated$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LocalDataSearchFragment this$0;

    public LocalDataSearchFragment$onViewCreated$5$1(LocalDataSearchFragment r1, Continuation<? super LocalDataSearchFragment$onViewCreated$5$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new LocalDataSearchFragment$onViewCreated$5$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.obric.assistant.guide.ui.q] */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        final List r11 = (List) r10;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("openStart toggleList built, size=");
        r3.append(r11.size());
        r3.append(", items=");
        List r4 = r11;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r7 = r4.iterator();
    L13:
        if (r7.hasNext() == false) goto L15;
        r5.add(((SelectableToggleItem) r7.next()).a);
        goto L13
    L15:
        r3.append(r5);
        r2.i("LocalDataSearchFragment", r3.toString());
        if ((!r11.isEmpty()) == false) goto L29;
        final LocalDataSearchFragment r6 = this.this$0;
        int r8 = LocalDataSearchFragment.f;
        r6.getClass();
        FLogger r9 = FLogger.a;
        StringBuilder r12 = new StringBuilder("requestCustomPermissions, size=");
        r12.append(r11.size());
        r12.append(", items=");
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r14 = r4.iterator();
    L19:
        if (r14.hasNext() == false) goto L21;
        r13.add(((SelectableToggleItem) r14.next()).a);
        goto L19
    L21:
        r12.append(r13);
        r9.i("LocalDataSearchFragment", r12.toString());
        FragmentActivity r15 = r6.getActivity();
        if (r15 == null) goto L28;
        LiveData r16 = ObricPersonalContextSettingApiDelegate.b.k(r15, r11);
        if (r16 == null) goto L26;
        r16.observe(r6.getViewLifecycleOwner(), new LocalDataSearchFragment.b(new q(r11, r6)));
        Unit r17 = Unit.INSTANCE;
    L27:
        if (r17 == null) goto L28;
    L31:
        return Unit.INSTANCE;
    L26:
        r17 = null;
    L28:
        FLogger.a.w("LocalDataSearchFragment", "requestCustomPermissions skipped, activity is null");
        r6.U90();
        goto L31
    L29:
        LocalDataSearchFragment r18 = this.this$0;
        int r19 = LocalDataSearchFragment.f;
        r18.U90();
        goto L31
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        LocalDataSearchFragment r110 = this.this$0;
        this.label = 1;
        r10 = LocalDataSearchFragment.S90(r110, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
