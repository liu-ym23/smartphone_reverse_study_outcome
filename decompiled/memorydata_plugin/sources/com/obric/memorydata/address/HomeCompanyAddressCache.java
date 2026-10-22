package com.obric.memorydata.address;

import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/address/HomeCompanyAddressCache;", "", "<init>", "()V", "ADDRESS_TYPE_HOME", "", "ADDRESS_TYPE_COMPANY", "clear", "", "cacheTypes", "", "Lcom/obric/memorydata/address/HomeCompanyAddressCache$CacheType;", "([Lcom/obric/memorydata/address/HomeCompanyAddressCache$CacheType;)V", "clearUserSet", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "clearAutoLearn", "CacheType", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HomeCompanyAddressCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HomeCompanyAddressCache f8425a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/address/HomeCompanyAddressCache$CacheType;", "", "<init>", "(Ljava/lang/String;I)V", "USER_SET", "AUTO_LEARN", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum CacheType extends Enum<CacheType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ CacheType[] $VALUES = null;
        public static final CacheType AUTO_LEARN = null;
        public static final CacheType USER_SET = null;

        private static final /* synthetic */ CacheType[] $values() {
            return new CacheType[]{USER_SET, AUTO_LEARN};
        }

        static {
            USER_SET = new CacheType("USER_SET", 0);
            AUTO_LEARN = new CacheType("AUTO_LEARN", 1);
            CacheType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private CacheType(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<CacheType> getEntries() {
            return $ENTRIES;
        }

        public static CacheType valueOf(String r2) {
            return (CacheType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CacheType.class, r2), CacheType.class, "com.obric.memorydata.plugin");
        }

        public static CacheType[] values() {
            return (CacheType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CacheType[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8426a = null;

        static {
            int[] r0 = new int[CacheType.values().length];
            r0[CacheType.USER_SET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CacheType.AUTO_LEARN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f8426a = r0;
        }
    }

    static {
        f8425a = new HomeCompanyAddressCache();
    }

    private HomeCompanyAddressCache() {
    }

    private final void a(IStore r4) {
        IStore r3 = (IStore) ZeusTransformUtils.wrapperContextForParams(r4, IStore.class, "com.obric.memorydata.plugin");
        String r5 = AppContext.INSTANCE.getUserId();
        r3.remove(new String[]{"user_set_address_家", "user_set_address_公司", "user_set_address_家_" + r5, "user_set_address_公司_" + r5});
    }

    private final void b(IStore r4) {
        IStore r3 = (IStore) ZeusTransformUtils.wrapperContextForParams(r4, IStore.class, "com.obric.memorydata.plugin");
        String r5 = AppContext.INSTANCE.getUserId();
        r3.remove(new String[]{"home_address", "home_address_" + r5, "company_address", "company_address_" + r5});
    }

    public final void a(CacheType... r7) {
        Intrinsics.checkNotNullParameter(r7, "cacheTypes");
        if (r7.length != 0) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L8;
        return;
    L8:
        IStore r8 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(ArraysKt.toSet(r7), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r9.hasNext() == false) goto L18;
        int r1 = a.f8426a[((CacheType) ZeusTransformUtils.preCheckCast(r9.next(), CacheType.class, "com.obric.memorydata.plugin")).ordinal()];
        if (r1 != 1) goto L13;
        f8425a.a(r8);
        goto L10
    L13:
        if (r1 != 2) goto L16;
        f8425a.b(r8);
        goto L10
    L16:
        throw new NoWhenBranchMatchedException();
    L18:
        return;
    L5:
        r6 = false;
        goto L6
    }
}
