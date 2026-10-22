package l1b;

import android.app.Application;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.storage.IStorage$Internal$CreateStorageRequest;
import com.ss.android.lark.chameleonv2.lkapi.storage.IStorage$Internal$CreateStorageResponse;
import com.ss.android.lark.chameleonv2.lkapi.storage.IStorage$Internal$GetItemsResponse;
import com.ss.android.lark.chameleonv2.lkapi.storage.IStorage$Internal$GetStorageRequest;
import com.ss.android.lark.chameleonv2.lkapi.storage.IStorage$Internal$ItemsRequest;
import com.ss.android.lark.chameleonv2.lkapi.storage.IStorage$Internal$KeyValue;
import com.ss.android.lark.chameleonv2.lkapi.storage.IStorage$Internal$SetItemsRequest;
import com.ss.android.lark.chameleonv2.lkapi.storage.IStorage$Internal$StorageResult;
import com.ss.android.lark.chameleonv2.lkapi.storage.IStorage$Internal$StorageStatus;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends z0b.a {
    public final Map<String, k> a;

    /* JADX INFO: renamed from: l1b.a$a, reason: collision with other inner class name */
    public final class C0249a extends j<String> {
        public final String a;
        public final /* synthetic */ a b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        public C0249a(a r1) {
            this.b = r1;
            this.a = LKAPIModules.Internal.Storage.ClearPersistentItems.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Object r2, Callback r3) {
            String r4 = (String) r2;
            Intrinsics.checkNotNullParameter(r4, "req");
            Intrinsics.checkNotNullParameter(r3, "callback");
            if (this.b.a.containsKey(r4) == false) goto L9;
            k r5 = (k) ((LinkedHashMap) this.b.a).get(r4);
            if (r5 == null) goto L9;
            com.ss.android.lark.storage.kv.repo.a r6 = j.a(r5.a, r5.b);
            if (r6 == null) goto L9;
            r6.clear();
        L9:
            r3.success(Boolean.TRUE);
        }
    }

    public static final class b {
    }

    public final class c extends j<IStorage$Internal$CreateStorageRequest> {
        public final String a;
        public final /* synthetic */ a b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        public c(a r1) {
            this.b = r1;
            this.a = LKAPIModules.Internal.Storage.CreatePersistentStorage.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Object r5, Callback r6) {
            IStorage$Internal$CreateStorageRequest r7 = (IStorage$Internal$CreateStorageRequest) r5;
            Intrinsics.checkNotNullParameter(r7, "req");
            Intrinsics.checkNotNullParameter(r6, "callback");
            String r0 = r7 + ".userId" + r7 + ".partition";
            this.b.a.put(r0, new k(r7.getUserId(), r7.getPartition()));
            r6.success(new IStorage$Internal$CreateStorageResponse(r0, new IStorage$Internal$StorageResult("ok", IStorage$Internal$StorageStatus.Ok)));
        }
    }

    public final class d extends j<IStorage$Internal$ItemsRequest> {
        public final String a;
        public final /* synthetic */ a b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        public d(a r1) {
            this.b = r1;
            this.a = LKAPIModules.Internal.Storage.GetPersistentItems.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Object r6, Callback r7) {
            IStorage$Internal$ItemsRequest r8 = (IStorage$Internal$ItemsRequest) r6;
            Intrinsics.checkNotNullParameter(r8, "req");
            Intrinsics.checkNotNullParameter(r7, "callback");
            if (this.b.a.containsKey(r8.getStorageId()) == false) goto L15;
            Map<String, k> r0 = this.b.a;
            LinkedHashMap r1 = (LinkedHashMap) r0;
            k r2 = (k) r1.get(r8.getStorageId());
            if (r2 == null) goto L16;
            com.ss.android.lark.storage.kv.repo.a r3 = j.a(r2.a, r2.b);
            if (r3 == null) goto L17;
            ArrayList r4 = new ArrayList();
            Iterator<T> r9 = r8.getKeys().iterator();
        L10:
            if (r9.hasNext() == false) goto L12;
            String r5 = (String) r9.next();
            r4.add(new IStorage$Internal$KeyValue(r5, r3.getString(r5, BuildConfig.FLAVOR)));
            goto L10
        L12:
            r7.success(new IStorage$Internal$GetItemsResponse(r4, new IStorage$Internal$StorageResult("ok", IStorage$Internal$StorageStatus.Ok)));
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    public final class e extends j<String> {
        public final String a;
        public final /* synthetic */ a b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        public e(a r1) {
            this.b = r1;
            this.a = LKAPIModules.Internal.Storage.GetPersistentKeys.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Object r2, Callback r3) {
            String r4 = (String) r2;
            Intrinsics.checkNotNullParameter(r4, "req");
            Intrinsics.checkNotNullParameter(r3, "callback");
            if (this.b.a.containsKey(r4) == false) goto L10;
            k r5 = (k) ((LinkedHashMap) this.b.a).get(r4);
            if (r5 == null) goto L11;
            com.ss.android.lark.storage.kv.repo.a r6 = j.a(r5.a, r5.b);
            if (r6 == null) goto L12;
            r3.success(r6.b());
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public final class f extends j<IStorage$Internal$GetStorageRequest> {
        public final String a;
        public final /* synthetic */ a b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        public f(a r1) {
            this.b = r1;
            this.a = LKAPIModules.Internal.Storage.GetPersistentStorageId.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Object r5, Callback r6) {
            IStorage$Internal$GetStorageRequest r7 = (IStorage$Internal$GetStorageRequest) r5;
            Intrinsics.checkNotNullParameter(r7, "req");
            Intrinsics.checkNotNullParameter(r6, "callback");
            String r0 = r7 + ".userId" + r7 + ".partition";
            this.b.a.put(r0, new k(r7.getUserId(), r7.getPartition()));
            r6.success(new IStorage$Internal$CreateStorageResponse(r0, new IStorage$Internal$StorageResult("ok", IStorage$Internal$StorageStatus.Ok)));
        }
    }

    public final class g extends j<IStorage$Internal$ItemsRequest> {
        public final String a;
        public final /* synthetic */ a b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        public g(a r1) {
            this.b = r1;
            this.a = LKAPIModules.Internal.Storage.HasPersistentItems.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Object r4, Callback r5) {
            IStorage$Internal$ItemsRequest r6 = (IStorage$Internal$ItemsRequest) r4;
            Intrinsics.checkNotNullParameter(r6, "req");
            Intrinsics.checkNotNullParameter(r5, "callback");
            if (this.b.a.containsKey(r6.getStorageId()) == false) goto L15;
            Map<String, k> r0 = this.b.a;
            LinkedHashMap r1 = (LinkedHashMap) r0;
            k r2 = (k) r1.get(r6.getStorageId());
            if (r2 == null) goto L16;
            com.ss.android.lark.storage.kv.repo.a r3 = j.a(r2.a, r2.b);
            if (r3 == null) goto L17;
            ArrayList r7 = new ArrayList();
            Iterator<T> r8 = r6.getKeys().iterator();
        L10:
            if (r8.hasNext() == false) goto L12;
            r7.add(Boolean.valueOf(r3.contains((String) r8.next())));
            goto L10
        L12:
            r5.success(r7);
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    public final class h extends j<IStorage$Internal$ItemsRequest> {
        public final String a;
        public final /* synthetic */ a b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        public h(a r1) {
            this.b = r1;
            this.a = LKAPIModules.Internal.Storage.RemovePersistentItems.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Object r4, Callback r5) {
            IStorage$Internal$ItemsRequest r6 = (IStorage$Internal$ItemsRequest) r4;
            Intrinsics.checkNotNullParameter(r6, "req");
            Intrinsics.checkNotNullParameter(r5, "callback");
            if (this.b.a.containsKey(r6.getStorageId()) == false) goto L15;
            Map<String, k> r0 = this.b.a;
            LinkedHashMap r1 = (LinkedHashMap) r0;
            k r2 = (k) r1.get(r6.getStorageId());
            if (r2 == null) goto L16;
            com.ss.android.lark.storage.kv.repo.a r3 = j.a(r2.a, r2.b);
            if (r3 == null) goto L17;
            ArrayList r7 = new ArrayList();
            Iterator<T> r8 = r6.getKeys().iterator();
        L10:
            if (r8.hasNext() == false) goto L12;
            r3.remove((String) r8.next());
            r7.add(Boolean.TRUE);
            goto L10
        L12:
            r5.success(r7);
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    public final class i extends j<IStorage$Internal$SetItemsRequest> {
        public final String a;
        public final /* synthetic */ a b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        public i(a r1) {
            this.b = r1;
            this.a = LKAPIModules.Internal.Storage.SetPersistentItems.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Object r6, Callback r7) {
            IStorage$Internal$SetItemsRequest r8 = (IStorage$Internal$SetItemsRequest) r6;
            Intrinsics.checkNotNullParameter(r8, "req");
            Intrinsics.checkNotNullParameter(r7, "callback");
            if (this.b.a.containsKey(r8.getStorageId()) == false) goto L15;
            Map<String, k> r0 = this.b.a;
            LinkedHashMap r1 = (LinkedHashMap) r0;
            k r2 = (k) r1.get(r8.getStorageId());
            if (r2 == null) goto L16;
            com.ss.android.lark.storage.kv.repo.a r3 = j.a(r2.a, r2.b);
            if (r3 == null) goto L17;
            ArrayList r4 = new ArrayList();
            Iterator<T> r9 = r8.getPairs().iterator();
        L10:
            if (r9.hasNext() == false) goto L12;
            IStorage$Internal$KeyValue r5 = (IStorage$Internal$KeyValue) r9.next();
            r3.putString(r5.component1(), r5.component2());
            r4.add(new IStorage$Internal$StorageResult("ok", IStorage$Internal$StorageStatus.Ok));
            goto L10
        L12:
            r7.success(r4);
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    public abstract class j<T> extends AbsChameleonHandler<T> {
        public j() {
        }

        public static com.ss.android.lark.storage.kv.repo.a a(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, "userId");
            Intrinsics.checkNotNullParameter(r8, "partition");
            Application r1 = LarkContext.getApplication();
            if (r1 != null) goto L5;
            return null;
        L5:
            return com.ss.android.lark.storage.c.d(r1, r7, new com.ss.android.lark.storage.a(r8), null, null, 56);
        }
    }

    public static final class k {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof k) == true) goto L8;
            return false;
        L8:
            k r6 = (k) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "StorageMeta(userId=" + this.a + ", partition=" + this.b + ')';
        }

        public k(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            Intrinsics.checkNotNullParameter(r3, "partition");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        return CollectionsKt.arrayListOf(new j[]{new c(this), new f(this), new e(this), new d(this), new i(this), new g(this), new h(this), new C0249a(this)});
    }

    public a() {
        this.a = new LinkedHashMap();
    }
}
