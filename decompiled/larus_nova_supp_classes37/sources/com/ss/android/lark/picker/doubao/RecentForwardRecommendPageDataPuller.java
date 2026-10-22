package com.ss.android.lark.picker.doubao;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.feed.v1.ForwardIncludeItem;
import com.bytedance.lark.pb.feed.v1.GetRecentTransmitTargetsRequestV2;
import com.bytedance.lark.pb.feed.v1.GetRecentTransmitTargetsResponseV2;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y3c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/picker/doubao/RecentForwardRecommendPageDataPuller;", "Lcom/ss/android/lark/search/dto/recommend/IRecommendPageDataPuller;", "<init>", "()V", "loadData", "", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "getPbForwardIncludeItem", "", "Lcom/bytedance/lark/pb/feed/v1/ForwardIncludeItem$IncludeItem;", "needHeader", "", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class RecentForwardRecommendPageDataPuller implements a {
    public RecentForwardRecommendPageDataPuller() {
    }

    public boolean canLoadMore() {
        return false;
    }

    public boolean needHeader() {
        return false;
    }

    private final List<ForwardIncludeItem.IncludeItem> getPbForwardIncludeItem() {
        ArrayList r0 = new ArrayList();
        ForwardIncludeItem.IncludeItem r1 = new ForwardIncludeItem.IncludeItem.Builder().user_configs(new ForwardIncludeItem.IncludeItem.UserConfig.Builder().talked_status_condition(ForwardIncludeItem.TalkedStatusCondition.ALL_TALKED).work_status_condition(ForwardIncludeItem.WorkStatusCondition.NOT_RESIGNED).tenant_condition(ForwardIncludeItem.TenantCondition.ALL_TENANT).user_type_condition(ForwardIncludeItem.UserTypeCondition.ALL_USER).build()).build();
        Intrinsics.checkNotNull(r1);
        r0.add(r1);
        return r0;
    }

    public void loadData(final IGetDataCallback<List<SearchBaseInfo>> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        GetRecentTransmitTargetsRequestV2.Builder r0 = new GetRecentTransmitTargetsRequestV2.Builder().limit(20).sync_data_strategy(SyncDataStrategy.FORCE_SERVER).include_items(getPbForwardIncludeItem());
        IGetDataCallback<GetRecentTransmitTargetsResponseV2> r1 = new RecentForwardRecommendPageDataPuller$loadData$innerCallback$1(r4);
        SdkSender.asynSendRequestNonWrap(Command.GET_RECENT_TRANSMIT_TARGETS_V2, r0, r1, AnonymousClass1.INSTANCE);
    }

    public void onLoadMore(IGetDataCallback<List<SearchBaseInfo>> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }
}
