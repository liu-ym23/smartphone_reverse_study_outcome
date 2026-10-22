package com.ss.android.lark.contact.customized.externalcontact.data;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.lark.pb.contact.v2.ContactProfile;
import com.bytedance.lark.pb.contact.v2.GetContactsDoubaoResponse;
import com.bytedance.lark.pb.contact.v2.GetContactsScene;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.h0;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.externalcontact.repository.OfficeExternalContactRepository;
import com.ss.android.lark.contact.customized.externalcontact.repository.e;
import com.ss.android.lark.contact.customized.externalcontact.repository.j;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.sdk.f;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PersonalContactsLoader extends BaseContactsLoader {
    public static final /* synthetic */ int j = 0;
    public final MutableLiveData<i9b.a<List<mtb.d>>> e;
    public final Map<Long, mtb.d> f;
    public boolean g;
    public final d h;
    public final c i;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ PersonalContactsLoader a;
        public final /* synthetic */ List<mtb.d> b;

        public b(PersonalContactsLoader r1, List<mtb.d> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.e.setValue(new i9b.a.c(this.b));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements h0 {
        public final /* synthetic */ PersonalContactsLoader a;

        public c(PersonalContactsLoader r1) {
            this.a = r1;
        }

        public final void a(Chatter r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            PersonalContactsLoader r0 = this.a;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
            PersonalContactsLoader.g(r0, r3);     // Catch: Throwable -> L7
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static final class d implements com.ss.android.lark.contact.customized.externalcontact.repository.b {
        public final /* synthetic */ PersonalContactsLoader a;

        public d(PersonalContactsLoader r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.contact.customized.externalcontact.repository.b
        public final void a(mtb.d r12) {
            Intrinsics.checkNotNullParameter(r12, "contact");
            PersonalContactsLoader r0 = this.a;
            i9b.a r1 = (i9b.a) r0.e.getValue();
            if ((r1 instanceof i9b.a.c) == false) goto L5;
            i9b.a.c r2 = (i9b.a.c) r1;
        L6:
            if (r2 == null) goto L11;
            List r3 = (List) r2.a;
            if (r3 == null) goto L11;
            List<mtb.d> r4 = CollectionsKt.toMutableList(r3);
            if (r4 == null) goto L11;
        L12:
            long r5 = r12.a;
            Iterator<mtb.d> r6 = r4.iterator();
            int r7 = 0;
        L14:
            if (r6.hasNext() == false) goto L22;
            if (r6.next().a != r5) goto L18;
            boolean r8 = true;
        L19:
            if (r8 == true) goto L23;
            r7 = r7 + 1;
        L23:
            Log.i("Contact_PersonalLoader", "update contact=" + r12.j + " and idx=" + r7);
            if (r12.j == false) goto L27;
            if (r7 < 0) goto L34;
            ListProtector.remove(r4, r7);
            r0.h(r4, false);
            return;
        L34:
            return;
        L27:
            if (r7 < 0) goto L29;
            ListProtector.set(r4, r7, r12);
        L30:
            r0.h(r4, true);
            return;
        L29:
            r4.add(r12);
            goto L30
        L18:
            r8 = false;
            goto L19
        L22:
            r7 = -1;
        L11:
            r4 = new ArrayList();
            goto L12
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.data.BaseContactsLoader
    public final void b() {
        Log.i("Contact_PersonalLoader", "fetchData");
        ((HashMap) this.f).clear();
        this.e.setValue(i9b.a.b.a);
        long r1 = System.currentTimeMillis();
        long r3 = ((KVRepo) ((DoubaoContactSyncStateStore) this.c.getValue()).b.getValue()).getLong("last_full_sync_time_millis", 0);
        if (r3 > 0) goto L6;
        Log.i("Contact_BaseLoader", "no cache, ttl=" + ((Number) this.d.getValue()).longValue());
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
        Log.i("Contact_PersonalLoader", "startFullColdSync");
        i(GetContactsScene.GET_CONTACTS_SCENE_FULL_COLD, true);
        return;
    L12:
        Log.i("Contact_PersonalLoader", "startIncrShortSync");
        i(GetContactsScene.GET_CONTACTS_SCENE_INCR_SHORT, false);
        return;
    L6:
        if ((r1 - r3) < ((Number) this.d.getValue()).longValue()) goto L8;
        r5 = true;
    L9:
        Log.i("Contact_BaseLoader", "isFullSyncExpired last=" + r3 + " now=" + r1 + " ttl=" + ((Number) this.d.getValue()).longValue() + " expired=" + r5);
        goto L10
    L8:
        r5 = false;
        goto L9
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.data.BaseContactsLoader
    public final void c() {
        Log.i("Contact_PersonalLoader", "init");
        Lazy r0 = OfficeExternalContactRepository.a;
        d r1 = this.h;
        Intrinsics.checkNotNullParameter(r1, "listener");
        f.a((List) OfficeExternalContactRepository.b.getValue(), r1, e.a);
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.data.BaseContactsLoader
    public final void e() {
        Log.i("Contact_PersonalLoader", "onCleared");
        if (this.g == false) goto L5;
        ImSdkService.c().te(this.i);
        this.g = false;
    L5:
        Lazy r0 = OfficeExternalContactRepository.a;
        d r1 = this.h;
        Intrinsics.checkNotNullParameter(r1, "listener");
        f.b((List) OfficeExternalContactRepository.b.getValue(), r1, j.a);
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.data.BaseContactsLoader
    public final void a(final long r3) {
        int r0 = com.ss.android.lark.contact.base.service.d.a;
        String r1 = String.valueOf(r3);
        IGetDataCallback<Boolean> r2 = new PersonalContactsLoader$deleteExternalContact$1(this, r3);
        Intrinsics.checkNotNullParameter(r1, "userId");
        Intrinsics.checkNotNullParameter(r2, "callback");
        ImSdkService.d().N7(r1, r2);
    }

    public static final void g(PersonalContactsLoader r6, Chatter r7) {
        r6.getClass();
        Long r0 = StringsKt.toLongOrNull(r7.getId());
        if (r0 == null) goto L19;
        long r1 = r0.longValue();
        Map<Long, mtb.d> r2 = r6.f;
        HashMap r3 = (HashMap) r2;
        mtb.d r4 = (mtb.d) r3.get(Long.valueOf(r1));
        if (r4 == null) goto L20;
        String r5 = r7.getAvatarKey();
        String r8 = r7.getName();
        String r9 = r7.getAlias();
        if (Intrinsics.areEqual(r4.g, r5) == true) goto L10;
    L14:
        boolean r10 = false;
    L15:
        if (r10 == true) goto L21;
        BuildersKt.launch$default(r6.a, Dispatchers.getIO(), null, new PersonalContactsLoader$onChatterPushed$1(r6, null), 2, null);
        return;
    L21:
        return;
    L10:
        if (Intrinsics.areEqual(r4.c, r8) == false) goto L14;
        if (Intrinsics.areEqual(r4.d, r9) == false) goto L14;
        r10 = true;
        goto L15
    L20:
        return;
    }

    public final void h(List<mtb.d> r5, boolean r6) {
        if (r6 == false) goto L4;
        r5 = CollectionsKt.toMutableList(r5);
        Lazy r7 = OfficeContactUtils.a;
        Intrinsics.checkNotNullParameter(r5, "contactList");
        CollectionsKt.sortWith(r5, com.ss.android.lark.contact.customized.common.d.a);
    L4:
        ((HashMap) this.f).clear();
        Iterator<T> r8 = r5.iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        mtb.d r0 = (mtb.d) r8.next();
        Map<Long, mtb.d> r1 = this.f;
        HashMap r2 = (HashMap) r1;
        r2.put(Long.valueOf(r0.a), r0);
        goto L6
    L8:
        UICallbackExecutor.execute(new b(this, r5));
    }

    public final void i(GetContactsScene r20, boolean r21) {
        Ref.IntRef r3 = new Ref.IntRef();
        BuildersKt.launch$default(this.a, Dispatchers.getIO(), null, new PersonalContactsLoader$startLocalAndServer$1(this, r20, r3, null), 2, null);
        BuildersKt.launch$default(this.a, Dispatchers.getIO(), null, new PersonalContactsLoader$startLocalAndServer$2(this, r20, r3, r21, null), 2, null);
    }

    public PersonalContactsLoader(CoroutineScope r2, MutableLiveData<i9b.a<List<mtb.d>>> r3, Function3<? super Boolean, ? super Boolean, ? super ErrorResult, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "contactsLiveData");
        Intrinsics.checkNotNullParameter(r4, "reportPerf");
        super(r2, r4);
        this.e = r3;
        this.f = new HashMap();
        this.h = new d(this);
        this.i = new c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.ArrayList] */
    public static final Pair f(PersonalContactsLoader r2, boolean r3, GetContactsScene r4) {
        r2.getClass();
        SdkSender.d r5 = OfficeExternalContactRepository.a(r3, r4);
        GetContactsDoubaoResponse r6 = (GetContactsDoubaoResponse) r5.a;
        if (r6 == null) goto L15;
        List r7 = r6.contacts;
        if (r7 == null) goto L11;
        List r8 = r7;
        Object r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = r8.iterator();
    L9:
        if (r10.hasNext() == false) goto L13;
        ContactProfile r0 = (ContactProfile) r10.next();
        int r1 = mtb.d.l;
        Intrinsics.checkNotNull(r0);
        r9.add(mtb.d.a.a(r0));
    L13:
        return TuplesKt.to(r9, null);
    L11:
        r9 = CollectionsKt.emptyList();
        goto L13
    L15:
        return TuplesKt.to(null, r5.b);
    }
}
