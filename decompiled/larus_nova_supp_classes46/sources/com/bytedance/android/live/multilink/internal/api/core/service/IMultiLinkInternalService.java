package com.bytedance.android.live.multilink.internal.api.core.service;

import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget;
import com.bytedance.android.live.multilink.external.api.core.service.IMultiLinkExternalService;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.live.utility.ServiceLookup;
import dn0.c;
import gd0.p;
import hh1.w0;
import jn0.a;
import kotlin.Metadata;
import tc0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ServiceLookup("com.bytedance.android.live.multilink.impl.MultiLinkGlobalService")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\rH&J\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/multilink/internal/api/core/service/IMultiLinkInternalService;", "Ljn0/a;", "Lcom/bytedance/android/live/multilink/external/api/core/service/IMultiLinkExternalService;", "Lcom/bytedance/android/live/base/IService;", "Ldn0/a;", "Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "Lcom/bytedance/android/live/pushstream/d;", "liveStream", "Lhh1/w0;", "callback", "Lcom/bytedance/android/live/liveinteract/linkbase/api/BaseMultiLinkWidget;", "createVoiceAnchorContainerWidget", "Lgd0/p;", "liveCycleCallback", "createVoiceGuestContainerWidget", "", "dataCenter", "roomContext", "Lcg6/a;", "getMultiLinkComponentService", "multilink-internal-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IMultiLinkInternalService extends a, IMultiLinkExternalService, IService, dn0.a {
    BaseMultiLinkWidget createVoiceAnchorContainerWidget(FragmentManager r1, d r2, w0 r3);

    BaseMultiLinkWidget createVoiceGuestContainerWidget(w0 r1, p r2);

    @Override // com.bytedance.android.live.multilink.external.api.core.service.IMultiLinkExternalService
    /* synthetic */ String getGlobalTestString();

    /* synthetic */ b getLinkInRoomDataHolderKt();

    /* synthetic */ c getLinkSecurityService();

    /* synthetic */ jb6.a getLinkServiceScopeService();

    cg6.a getMultiLinkComponentService(Object r1, Object r2);

    /* synthetic */ void registerInRoomService(jn0.b r1);

    /* synthetic */ void unregisterInRoomService();
}
