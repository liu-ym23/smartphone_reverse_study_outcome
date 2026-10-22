package com.larus.dora.impl.noti_v3.special_contacts.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tJ\u0016\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\u001e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tJ\u0016\u0010\u001c\u001a\u00020\u00132\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0006\u0010\u001e\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/larus/dora/impl/noti_v3/special_contacts/viewmodel/NotificationBroadcastV3SpecialContactsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "_specialContacts", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/larus/dora/impl/noti_v3/special_contacts/model/NotificationBroadcastV3SpecialContact;", "specialContacts", "Lkotlinx/coroutines/flow/StateFlow;", "getSpecialContacts", "()Lkotlinx/coroutines/flow/StateFlow;", "isEmpty", "Lkotlinx/coroutines/flow/Flow;", "", "()Lkotlinx/coroutines/flow/Flow;", "toggleSelection", "", "contact", "addContact", "appName", "", "chatName", "updateContact", "id", "deleteContact", "updateSettings", "newList", "syncSettings", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationBroadcastV3SpecialContactsViewModel extends ViewModel {
    private final z0<List<y59.a>> _specialContacts;
    private final Gson gson;
    private final Flow<Boolean> isEmpty;
    private final i1<List<y59.a>> specialContacts;

    /* JADX INFO: renamed from: com.larus.dora.impl.noti_v3.special_contacts.viewmodel.NotificationBroadcastV3SpecialContactsViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.noti_v3.special_contacts.viewmodel.NotificationBroadcastV3SpecialContactsViewModel$1", f = "NotificationBroadcastV3SpecialContactsViewModel.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ NotificationBroadcastV3SpecialContactsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.noti_v3.special_contacts.viewmodel.NotificationBroadcastV3SpecialContactsViewModel$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ CoroutineScope a;
            public final /* synthetic */ NotificationBroadcastV3SpecialContactsViewModel b;

            public a(CoroutineScope r1, NotificationBroadcastV3SpecialContactsViewModel r2) {
                this.a = r1;
                this.b = r2;
            }

            public final Object emit(Object r3, Continuation r4) {
                String r5 = ((q59.a) r3).f;
                if (r5 != null) goto L5;
            L8:
                boolean r6 = true;
            L9:
                if (r6 == true) goto L22;
                NotificationBroadcastV3SpecialContactsViewModel r7 = this.b;
                Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
                Type r1 = new com.larus.dora.impl.noti_v3.special_contacts.viewmodel.a().getType();     // Catch: Throwable -> L16
                List r8 = (List) NotificationBroadcastV3SpecialContactsViewModel.access$getGson$p(r7).fromJson(r5, r1);     // Catch: Throwable -> L16
                z0 r9 = NotificationBroadcastV3SpecialContactsViewModel.access$get_specialContacts$p(r7);     // Catch: Throwable -> L16
                if (r8 != null) goto L14;
                r8 = CollectionsKt.emptyList();     // Catch: Throwable -> L16
            L14:
                r9.setValue(r8);     // Catch: Throwable -> L16
                Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
            L18:
                NotificationBroadcastV3SpecialContactsViewModel r11 = this.b;
                if (Result.exceptionOrNull-impl(r10) == null) goto L21;
                NotificationBroadcastV3SpecialContactsViewModel.access$get_specialContacts$p(r11).setValue(CollectionsKt.emptyList());
            L21:
                Result.box-impl(r10);
            L24:
                return Unit.INSTANCE;
            L16:
                th = move-exception;
                Result.Companion r12 = Result.Companion;
                r10 = Result.constructor-impl(ResultKt.createFailure(th));
                goto L18
            L22:
                NotificationBroadcastV3SpecialContactsViewModel.access$get_specialContacts$p(this.b).setValue(CollectionsKt.emptyList());
                goto L24
            L5:
                if (StringsKt.isBlank(r5) == true) goto L8;
                r6 = false;
                goto L9
            }
        }

        public AnonymousClass1(NotificationBroadcastV3SpecialContactsViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
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
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            CoroutineScope r7 = (CoroutineScope) this.L$0;
            StateFlowImpl r2 = DoraUserSettingsManager.m;
            a r3 = new a(r7, this.this$0);
            this.label = 1;
            if (r2.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    public final void syncSettings() {
        DoraUserSettingsManager r0 = DoraUserSettingsManager.a;
        DoraUserSettingsManager.i("NotificationBroadcastV3SpecialContactsViewModel");
    }

    public NotificationBroadcastV3SpecialContactsViewModel() {
        this.gson = new Gson();
        final StateFlowImpl r0 = j1.a(CollectionsKt.emptyList());
        this._specialContacts = r0;
        this.specialContacts = r0;
        this.isEmpty = new NotificationBroadcastV3SpecialContactsViewModel$special$$inlined$map$1(r0);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final i1<List<y59.a>> getSpecialContacts() {
        return this.specialContacts;
    }

    public final Flow<Boolean> isEmpty() {
        return this.isEmpty;
    }

    public static final /* synthetic */ Gson access$getGson$p(NotificationBroadcastV3SpecialContactsViewModel r0) {
        return r0.gson;
    }

    public static final /* synthetic */ z0 access$get_specialContacts$p(NotificationBroadcastV3SpecialContactsViewModel r0) {
        return r0._specialContacts;
    }

    private final void updateSettings(List<y59.a> r3) {
        String r4 = GsonProtectorUtils.toJson(this.gson, r3);
        DoraUserSettingsManager r0 = DoraUserSettingsManager.a;
        Intrinsics.checkNotNull(r4);
        DoraUserSettingsManager.k("notification_social_special_chat_list", r4, null);
    }

    public final void deleteContact(y59.a r6) {
        Intrinsics.checkNotNullParameter(r6, "contact");
        Iterable r0 = (Iterable) this._specialContacts.getValue();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((!Intrinsics.areEqual(((y59.a) r3).d(), r6.d())) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        updateSettings(r1);
    }

    public final void toggleSelection(y59.a r7) {
        Intrinsics.checkNotNullParameter(r7, "contact");
        Iterable r0 = (Iterable) this._specialContacts.getValue();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        y59.a r3 = (y59.a) r2.next();
        if (Intrinsics.areEqual(r3.d(), r7.d()) == false) goto L12;
        Boolean r4 = r3.e();
        if (r4 == null) goto L10;
        boolean r5 = r4.booleanValue();
    L11:
        r3 = y59.a.a(r3, null, null, Boolean.valueOf(!r5), 7);
        goto L12
    L10:
        r5 = false;
    L12:
        r1.add(r3);
        goto L4
    L13:
        updateSettings(r1);
    }

    public final void addContact(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "appName");
        Intrinsics.checkNotNullParameter(r5, "chatName");
        y59.a r0 = new y59.a(UUID.randomUUID().toString(), r4, r5, Boolean.TRUE);
        updateSettings(CollectionsKt.plus((Collection) this._specialContacts.getValue(), r0));
    }

    public final void updateContact(String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "id");
        Intrinsics.checkNotNullParameter(r7, "appName");
        Intrinsics.checkNotNullParameter(r8, "chatName");
        Iterable r0 = (Iterable) this._specialContacts.getValue();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        y59.a r3 = (y59.a) r2.next();
        if (Intrinsics.areEqual(r3.d(), r6) == false) goto L8;
        r3 = y59.a.a(r3, r7, r8, null, 9);
    L8:
        r1.add(r3);
        goto L4
    L9:
        updateSettings(r1);
    }
}
