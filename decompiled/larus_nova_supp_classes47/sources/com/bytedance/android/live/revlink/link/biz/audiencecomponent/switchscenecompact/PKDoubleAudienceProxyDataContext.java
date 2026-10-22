package com.bytedance.android.live.revlink.link.biz.audiencecomponent.switchscenecompact;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAudienceDataContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPkAudienceLoadService;
import com.bytedance.android.live.revlink.impl.pk.service.f;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.DataContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\r\u001a\u00020\fH\u0096\u0001J\u0011\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fH\u0096\u0001J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u0017\u001a\u00020\nH\u0096\u0001¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/revlink/link/biz/audiencecomponent/switchscenecompact/PKDoubleAudienceProxyDataContext;", "Lcom/bytedance/android/live/revlink/impl/pk/service/f;", "Lcom/bytedance/live/datacontext/DataContext;", "", "channelId", "", Constants.Keys.duration, "", "Lcom/bytedance/android/livesdk/link/model/p;", "getAnchorList", "", "getConnectSource", "Lcom/bytedance/android/live/revlink/impl/pk/service/IPkAudienceLoadService$LoadType;", "getLoadType", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "guestUserEx", "guestUserId", "matchType", "battleID", "", "notifyRoomUpdate", "reportUiFirstLoad", FileUtils.PICTURE_THEME, "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleAudienceDataContext;", "audienceDoubleDataContext", "<init>", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleAudienceDataContext;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKDoubleAudienceProxyDataContext extends DataContext implements f {
    private final /* synthetic */ PkDoubleAudienceDataContext $$delegate_0;

    @Override // com.bytedance.android.live.revlink.impl.pk.service.f
    public long channelId() {
        return this.$$delegate_0.channelId();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.f
    public int duration() {
        return this.$$delegate_0.duration();
    }

    public List<p> getAnchorList() {
        return this.$$delegate_0.getAnchorList();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.f
    public String getConnectSource() {
        return this.$$delegate_0.getConnectSource();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.f
    public IPkAudienceLoadService.LoadType getLoadType() {
        return this.$$delegate_0.getLoadType();
    }

    public IBaseUser guestUserEx() {
        return this.$$delegate_0.guestUserEx();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.f
    public String guestUserId() {
        return this.$$delegate_0.guestUserId();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.f
    public int matchType() {
        return this.$$delegate_0.matchType();
    }

    public void notifyRoomUpdate(long r2) {
        this.$$delegate_0.notifyRoomUpdate(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.f, com.bytedance.android.live.revlink.impl.mergepk.pkdouble.a
    public void reportUiFirstLoad() {
        this.$$delegate_0.reportUiFirstLoad();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.f
    public String theme() {
        return this.$$delegate_0.theme();
    }

    public PKDoubleAudienceProxyDataContext(PkDoubleAudienceDataContext r2) {
        Intrinsics.checkNotNullParameter(r2, "audienceDoubleDataContext");
        this.$$delegate_0 = r2;
    }
}
