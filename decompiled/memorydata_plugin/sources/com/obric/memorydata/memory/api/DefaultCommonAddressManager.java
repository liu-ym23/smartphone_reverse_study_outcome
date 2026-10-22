package com.obric.memorydata.memory.api;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.api.model.AddressInfo;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n\u0018\u00010\u0015H\u0016J0\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0016¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/memory/api/DefaultCommonAddressManager;", "Lcom/obric/memorydata/memory/api/ICommonAddressManager;", "<init>", "()V", "getAddressList", "", "Lcom/obric/memorydata/memory/api/model/AddressInfo;", "addressType", "", "clearAll", "", "sureOnlyOneAddressSelect", Constants.KEY_LIST, "getAutoLearnAddress", "updateUserSetAddress", "addressInfoList", "reOrganizeAddress", "setAutoLearnState", "", "enabled", "onStateChanged", "Lkotlin/Function1;", "setLocation", "locationType", "longitude", "", "latitude", ActivityLifecycle.NAME, MemoryListActivity.JUMP_FROM_DETAIL, "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultCommonAddressManager implements ICommonAddressManager {
    public static final DefaultCommonAddressManager INSTANCE = null;

    static {
        INSTANCE = new DefaultCommonAddressManager();
    }

    private DefaultCommonAddressManager() {
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public void clearAll() {
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public List<AddressInfo> getAddressList(String r1) {
        Intrinsics.checkNotNullParameter(r1, "addressType");
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public AddressInfo getAutoLearnAddress(String r1) {
        Intrinsics.checkNotNullParameter(r1, "addressType");
        return null;
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public void reOrganizeAddress(String r1) {
        Intrinsics.checkNotNullParameter(r1, "addressType");
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public boolean setAutoLearnState(boolean r1, Function1<? super Boolean, Unit> r2) {
        Function1 r0 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        return false;
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public boolean setLocation(String r1, double r2, double r4, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r1, "locationType");
        Intrinsics.checkNotNullParameter(r6, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r7, MemoryListActivity.JUMP_FROM_DETAIL);
        return false;
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public List<AddressInfo> sureOnlyOneAddressSelect(List<AddressInfo> r2) {
        List<AddressInfo> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, Constants.KEY_LIST);
        return r1;
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public void updateUserSetAddress(List<AddressInfo> r2, String r3) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), "addressInfoList");
        Intrinsics.checkNotNullParameter(r3, "addressType");
    }
}
