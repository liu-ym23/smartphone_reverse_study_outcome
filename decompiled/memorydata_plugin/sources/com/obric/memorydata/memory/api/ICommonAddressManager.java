package com.obric.memorydata.memory.api;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.news.common.service.manager.IService;
import com.obric.memorydata.memory.api.model.AddressInfo;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H&J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013H&J0\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H&¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/memory/api/ICommonAddressManager;", "Lcom/bytedance/news/common/service/manager/IService;", "getAddressList", "", "Lcom/obric/memorydata/memory/api/model/AddressInfo;", "addressType", "", "clearAll", "", "sureOnlyOneAddressSelect", Constants.KEY_LIST, "getAutoLearnAddress", "updateUserSetAddress", "addressInfoList", "reOrganizeAddress", "setAutoLearnState", "", "enabled", "onStateChanged", "Lkotlin/Function1;", "setLocation", "locationType", "longitude", "", "latitude", ActivityLifecycle.NAME, MemoryListActivity.JUMP_FROM_DETAIL, "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ICommonAddressManager extends IService {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ boolean a(ICommonAddressManager r2, boolean r3, Function1 r4, int r5, Object r6) {
            ICommonAddressManager r7 = (ICommonAddressManager) ZeusTransformUtils.wrapperContextForParams(r2, ICommonAddressManager.class, "com.obric.memorydata.plugin");
            Function1<? super Boolean, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L8;
            r8 = null;
        L8:
            return r7.setAutoLearnState(r3, r8);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAutoLearnState");
        }
    }

    void clearAll();

    List<AddressInfo> getAddressList(String r1);

    AddressInfo getAutoLearnAddress(String r1);

    void reOrganizeAddress(String r1);

    boolean setAutoLearnState(boolean r1, Function1<? super Boolean, Unit> r2);

    boolean setLocation(String r1, double r2, double r4, String r6, String r7);

    List<AddressInfo> sureOnlyOneAddressSelect(List<AddressInfo> r1);

    void updateUserSetAddress(List<AddressInfo> r1, String r2);
}
