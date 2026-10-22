package zk0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.linksecurity.CheckAudienceLinkersResponse;
import com.bytedance.android.live.livepkaudience.linksecurity.LinkSecurityApi;
import com.bytedance.android.live.livepkaudience.linksecurity.LinkSecurityManager;
import com.bytedance.android.live.network.response.e;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;
    public final /* synthetic */ LinkSecurityApi.VideoCaptureType c;
    public final /* synthetic */ LinkSecurityApi.AudioCaptureType d;
    public final /* synthetic */ LinkSecurityApi.FilterReasonID e;

    public a(long r1, String r3, LinkSecurityApi.VideoCaptureType r4, LinkSecurityApi.AudioCaptureType r5, LinkSecurityApi.FilterReasonID r6) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r6) {
        e r7 = (e) r6;
        if (r7 == null) goto L17;
        CheckAudienceLinkersResponse r8 = (CheckAudienceLinkersResponse) r7.data;
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.getSleepSecond() <= 1) goto L9;
        CompositeDisposable r0 = LinkSecurityManager.b;
        LinkSecurityManager.a = r8.getSleepSecond();
    L9:
        ALogger.e("LinkSecurityManager", "startCheckAudienceLinkers roomId = " + this.a + ", selfUserId = " + this.b + ", action = " + r8.getAction() + ", videoCaptureType = " + this.c + ", audioCaptureType = " + this.d + ", filterReasonId = " + this.e);
        if (r8.getAction() == LinkSecurityManager.CheckAudienceLinkersAction.CheckAudienceLinkersAction_Silence.ordinal()) goto L14;
        if (r8.getAction() == LinkSecurityManager.CheckAudienceLinkersAction.CheckAudienceLinkersAction_UnSilence.ordinal()) goto L14;
        return;
    L14:
        if (v.a() == false) goto L20;
        f2.c(s1.B(2131921438), 0);
        return;
    L20:
        return;
    }
}
