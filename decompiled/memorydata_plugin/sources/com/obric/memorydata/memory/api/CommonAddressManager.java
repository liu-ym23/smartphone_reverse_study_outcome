package com.obric.memorydata.memory.api;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.memorydata.memory.api.model.AddressInfo;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J'\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011H\u0096\u0001J1\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0096\u0001J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0001J\u001f\u0010\u001b\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0096\u0001¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/memory/api/CommonAddressManager;", "Lcom/obric/memorydata/memory/api/ICommonAddressManager;", "<init>", "()V", "clearAll", "", "getAddressList", "", "Lcom/obric/memorydata/memory/api/model/AddressInfo;", "addressType", "", "getAutoLearnAddress", "reOrganizeAddress", "setAutoLearnState", "", "enabled", "onStateChanged", "Lkotlin/Function1;", "setLocation", "locationType", "longitude", "", "latitude", ActivityLifecycle.NAME, MemoryListActivity.JUMP_FROM_DETAIL, "sureOnlyOneAddressSelect", Constants.KEY_LIST, "updateUserSetAddress", "addressInfoList", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CommonAddressManager implements ICommonAddressManager {
    public static final CommonAddressManager INSTANCE = null;
    private final /* synthetic */ ICommonAddressManager $$delegate_0;

    static {
        INSTANCE = new CommonAddressManager();
    }

    private CommonAddressManager() {
        ICommonAddressManager r0 = (ICommonAddressManager) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(ICommonAddressManager.class)), ICommonAddressManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = (ICommonAddressManager) ZeusTransformUtils.preCheckCast(DefaultCommonAddressManager.INSTANCE, ICommonAddressManager.class, "com.obric.memorydata.plugin");
    L5:
        this.$$delegate_0 = r0;
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public void clearAll() {
        this.$$delegate_0.clearAll();
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public List<AddressInfo> getAddressList(String r2) {
        Intrinsics.checkNotNullParameter(r2, "addressType");
        return this.$$delegate_0.getAddressList(r2);
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public AddressInfo getAutoLearnAddress(String r2) {
        Intrinsics.checkNotNullParameter(r2, "addressType");
        return this.$$delegate_0.getAutoLearnAddress(r2);
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public void reOrganizeAddress(String r2) {
        Intrinsics.checkNotNullParameter(r2, "addressType");
        this.$$delegate_0.reOrganizeAddress(r2);
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public boolean setAutoLearnState(boolean r3, Function1<? super Boolean, Unit> r4) {
        Function1<? super Boolean, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        return this.$$delegate_0.setAutoLearnState(r3, r5);
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public boolean setLocation(String r10, double r11, double r13, String r15, String r16) {
        Intrinsics.checkNotNullParameter(r10, "locationType");
        Intrinsics.checkNotNullParameter(r15, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r16, MemoryListActivity.JUMP_FROM_DETAIL);
        return this.$$delegate_0.setLocation(r10, r11, r13, r15, r16);
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public List<AddressInfo> sureOnlyOneAddressSelect(List<AddressInfo> r3) {
        List<AddressInfo> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, Constants.KEY_LIST);
        return this.$$delegate_0.sureOnlyOneAddressSelect(r4);
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public void updateUserSetAddress(List<AddressInfo> r3, String r4) {
        List<AddressInfo> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "addressInfoList");
        Intrinsics.checkNotNullParameter(r4, "addressType");
        this.$$delegate_0.updateUserSetAddress(r5, r4);
    }
}
