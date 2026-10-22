package com.larus.dora.impl.nl;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\rJ\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u001a\u001a\u00020\u0015H\u0002J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006H\u0002J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/larus/dora/impl/nl/NLAppListViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_appListStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/larus/dora/impl/nl/AppListItem;", "appListStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getAppListStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "currentAppList", "Lcom/larus/dora/impl/network/NLAppInfo;", "query", "", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "initData", "", "saveChangedAppList", "updateAppListItem", "item", "onSearchQueryChanged", "showAppList", "getFormattedAllAppList", "list", "getFormattedSearchAppList", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NLAppListViewModel extends ViewModel {
    private final z0<List<AppListItem>> _appListStateFlow;
    private final i1<List<AppListItem>> appListStateFlow;
    private List<com.larus.dora.impl.network.s> currentAppList;
    private String query;

    /* JADX INFO: renamed from: com.larus.dora.impl.nl.NLAppListViewModel$initData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.nl.NLAppListViewModel$initData$1", f = "NLAppListViewModel.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ NLAppListViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.nl.NLAppListViewModel$initData$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ NLAppListViewModel a;

            public a(NLAppListViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r3, Continuation r4) {
                NLAppListViewModel r5 = this.a;
                List r6 = (List) r3;
                ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
                Iterator<T> r7 = r6.iterator();
            L4:
                if (r7.hasNext() == false) goto L6;
                r0.add(com.larus.dora.impl.network.s.a((com.larus.dora.impl.network.s) r7.next()));
                goto L4
            L6:
                NLAppListViewModel.access$setCurrentAppList$p(r5, r0);
                NLAppListViewModel.access$showAppList(this.a);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(NLAppListViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            StateFlowImpl r6 = DoraUserSettingsManager.k;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.nl.NLAppListViewModel$saveChangedAppList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.nl.NLAppListViewModel$saveChangedAppList$1", f = "NLAppListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ NLAppListViewModel this$0;

        public C03581(NLAppListViewModel r1, Continuation<? super C03581> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03581(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r8);
            DoraUserSettingsManager r9 = DoraUserSettingsManager.a;
            List r10 = NLAppListViewModel.access$getCurrentAppList$p(this.this$0);
            if (r10 != null) goto L7;
            r10 = CollectionsKt.emptyList();
        L7:
            Intrinsics.checkNotNullParameter(r10, "appList");
            BuildersKt.launch$default(DoraUserSettingsManager.b, null, null, new DoraUserSettingsManager$updateNotificationAppList$1(r10, null), 3, null);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.nl.NLAppListViewModel$showAppList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.nl.NLAppListViewModel$showAppList$1", f = "NLAppListViewModel.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ NLAppListViewModel this$0;

        public C03591(NLAppListViewModel r1, Continuation<? super C03591> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03591(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L33:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            if (this.this$0.getQuery().length() != 0) goto L11;
            boolean r13 = true;
        L12:
            if (r13 == false) goto L14;
            NLAppListViewModel r14 = this.this$0;
            List r15 = NLAppListViewModel.access$getFormattedAllAppList(r14, NLAppListViewModel.access$getCurrentAppList$p(r14));
        L29:
            z0 r2 = NLAppListViewModel.access$get_appListStateFlow$p(this.this$0);
            this.label = 1;
            if (r2.emit(r15, this) != r0) goto L33;
            return r0;
        L14:
            NLAppListViewModel r16 = this.this$0;
            List r3 = NLAppListViewModel.access$getCurrentAppList$p(r16);
            ArrayList r4 = null;
            if (r3 == null) goto L28;
            NLAppListViewModel r5 = this.this$0;
            ArrayList r6 = new ArrayList();
            Iterator r7 = r3.iterator();
        L18:
            if (r7.hasNext() == false) goto L27;
            Object r8 = r7.next();
            String r9 = ((com.larus.dora.impl.network.s) r8).c();
            if (r9 != null) goto L22;
        L24:
            boolean r10 = false;
        L25:
            if (r10 == false) goto L18;
            r6.add(r8);
            goto L18
        L22:
            if (StringsKt.contains$default(r9, r5.getQuery(), false, 2, null) != true) goto L24;
            r10 = true;
            goto L25
        L27:
            r4 = r6;
        L28:
            r15 = NLAppListViewModel.access$getFormattedSearchAppList(r16, r4);
            goto L29
        L11:
            r13 = false;
            goto L12
        }
    }

    public NLAppListViewModel() {
        StateFlowImpl r0 = j1.a(new ArrayList());
        this._appListStateFlow = r0;
        this.appListStateFlow = r0;
        this.query = "";
        initData();
    }

    private final void initData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    private final void showAppList() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03591(this, null), 3, null);
    }

    public final void saveChangedAppList() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03581(this, null), 3, null);
    }

    public final i1<List<AppListItem>> getAppListStateFlow() {
        return this.appListStateFlow;
    }

    public final String getQuery() {
        return this.query;
    }

    public static final /* synthetic */ List access$getCurrentAppList$p(NLAppListViewModel r0) {
        return r0.currentAppList;
    }

    public static final /* synthetic */ z0 access$get_appListStateFlow$p(NLAppListViewModel r0) {
        return r0._appListStateFlow;
    }

    public static final /* synthetic */ void access$showAppList(NLAppListViewModel r0) {
        r0.showAppList();
    }

    private final List<AppListItem> getFormattedAllAppList(List<com.larus.dora.impl.network.s> r9) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        if (r9 == null) goto L12;
        Iterator<T> r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L12;
        com.larus.dora.impl.network.s r5 = (com.larus.dora.impl.network.s) r10.next();
        if (r5.e() == 1) goto L9;
        r1.add(new AppListItem.c(false, AppListItem.BackgroundType.MIDDLE, r5));
        goto L6
    L9:
        r2.add(new AppListItem.c(true, AppListItem.BackgroundType.MIDDLE, r5));
    L12:
        if ((!r1.isEmpty()) == false) goto L19;
        int r6 = com.larus.utils.j0.a;
        r0.add(new AppListItem.b(com.larus.utils.j0.d(2131902238)));
        if (r1.size() != 1) goto L16;
        ((AppListItem.c) ListProtector.get(r1, 0)).a(AppListItem.BackgroundType.DEFAULT);
    L17:
        r0.addAll(r1);
        r0.add(AppListItem.a.a);
        goto L19
    L16:
        ((AppListItem.c) CollectionsKt.first(r1)).a(AppListItem.BackgroundType.FIRST);
        ((AppListItem.c) CollectionsKt.last(r1)).a(AppListItem.BackgroundType.LAST);
    L19:
        if ((!r2.isEmpty()) == false) goto L25;
        int r3 = com.larus.utils.j0.a;
        r0.add(new AppListItem.b(com.larus.utils.j0.d(2131902207)));
        if (r2.size() != 1) goto L23;
        ((AppListItem.c) ListProtector.get(r2, 0)).a(AppListItem.BackgroundType.DEFAULT);
    L24:
        r0.addAll(r2);
        r0.add(AppListItem.a.a);
        goto L25
    L23:
        ((AppListItem.c) CollectionsKt.first(r2)).a(AppListItem.BackgroundType.FIRST);
        ((AppListItem.c) CollectionsKt.last(r2)).a(AppListItem.BackgroundType.LAST);
    L25:
        return r0;
    }

    private final List<AppListItem> getFormattedSearchAppList(List<com.larus.dora.impl.network.s> r9) {
        ArrayList r0 = new ArrayList();
        if (r9 == null) goto L12;
        List<com.larus.dora.impl.network.s> r10 = r9;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L13;
        com.larus.dora.impl.network.s r4 = (com.larus.dora.impl.network.s) r11.next();
        if (r4.e() != 1) goto L10;
        boolean r6 = true;
    L11:
        r3.add(new AppListItem.c(r6, AppListItem.BackgroundType.MIDDLE, r4));
        goto L6
    L10:
        r6 = false;
    L13:
        if (r3 != null) goto L15;
    L17:
        boolean r12 = false;
    L18:
        if (r12 == true) goto L20;
    L24:
        return r0;
    L20:
        if (r3.size() != 1) goto L22;
        ((AppListItem.c) ListProtector.get(r3, 0)).a(AppListItem.BackgroundType.DEFAULT);
    L23:
        r0.addAll(r3);
        goto L24
    L22:
        ((AppListItem.c) CollectionsKt.first(r3)).a(AppListItem.BackgroundType.FIRST);
        ((AppListItem.c) CollectionsKt.last(r3)).a(AppListItem.BackgroundType.LAST);
        goto L23
    L15:
        if ((!r3.isEmpty()) != true) goto L17;
        r12 = true;
        goto L18
    L12:
        r3 = null;
        goto L13
    }

    public final void onSearchQueryChanged(String r2) {
        Intrinsics.checkNotNullParameter(r2, "query");
        this.query = r2;
        showAppList();
    }

    public final void setQuery(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.query = r2;
    }

    public final void updateAppListItem(com.larus.dora.impl.network.s r6) {
        Intrinsics.checkNotNullParameter(r6, "item");
        int r1 = 1;
        if (r6.e() != 1) goto L5;
        r1 = 2;
    L5:
        r6.f(r1);
        List<com.larus.dora.impl.network.s> r0 = this.currentAppList;
        if (r0 == null) goto L14;
        List<com.larus.dora.impl.network.s> r2 = r0;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L15;
        com.larus.dora.impl.network.s r5 = (com.larus.dora.impl.network.s) r4.next();
        if (Intrinsics.areEqual(r5.d(), r6.d()) == false) goto L13;
        r5 = r6;
    L13:
        r3.add(r5);
    L15:
        this.currentAppList = r3;
        showAppList();
        return;
    L14:
        r3 = null;
        goto L15
    }

    public static final /* synthetic */ List access$getFormattedAllAppList(NLAppListViewModel r0, List r1) {
        return r0.getFormattedAllAppList(r1);
    }

    public static final /* synthetic */ List access$getFormattedSearchAppList(NLAppListViewModel r0, List r1) {
        return r0.getFormattedSearchAppList(r1);
    }

    public static final /* synthetic */ void access$setCurrentAppList$p(NLAppListViewModel r0, List r1) {
        r0.currentAppList = r1;
    }
}
