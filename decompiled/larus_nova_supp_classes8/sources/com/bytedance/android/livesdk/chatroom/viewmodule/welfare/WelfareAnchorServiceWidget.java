package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import android.net.Uri;
import com.bytedance.android.live.broadcast.api.model.WelfarePermissionInfo;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.utils.WelfareAppLogger;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.qy0;
import com.bytedance.android.livesdk.message.model.tn;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.WelfareProjectInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/welfare/WelfareAnchorServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WelfareAnchorServiceWidget extends RoomRecyclableWidget implements vlc.l, Observer<KVData> {
    public final Lazy a;
    public final CompositeDisposable b;
    public long c;
    public long d;

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
    }

    public WelfareAnchorServiceWidget() {
        this.a = LazyKt.lazy(WelfareAnchorServiceWidget$welfareApi$2.INSTANCE);
        this.b = new CompositeDisposable();
        this.d = 15;
    }

    public static final JSONObject wq(WelfareAnchorServiceWidget r2) {
        r2.getClass();
        JSONObject r3 = new JSONObject();
        r3.put("code", 0);
        return r3;
    }

    public static final void xq(WelfareAnchorServiceWidget r8) {
        DataCenter r0 = ((Widget) r8).dataCenter;
        if (r0 == null) goto L40;
        WelfarePermissionInfo r1 = (WelfarePermissionInfo) r0.get("data_welfare_permission_info");
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.available == true) goto L9;
        return;
    L9:
        if (yt2.b.a().booleanValue() == false) goto L43;
        String r2 = r1.settingPageUrl;
        boolean r3 = false;
        if (r2 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == true) goto L44;
        Uri r5 = UriProtector.parse(r1.settingPageUrl);
        String r6 = UriProtector.getQueryParameter(r5, "url");
        if (r6 != null) goto L21;
    L22:
        r3 = true;
    L23:
        if (r3 == true) goto L31;
        String r7 = UriProtector.parse(r6).buildUpon().appendQueryParameter("is_living", "1").build().toString();
        Uri.Builder r9 = r5.buildUpon().clearQuery();
        Iterator r10 = UriProtector.getQueryParameterNames(r5).iterator();
    L26:
        if (r10.hasNext() == false) goto L30;
        String r11 = (String) r10.next();
        if ((!Intrinsics.areEqual(r11, "url")) == false) goto L26;
        r9.appendQueryParameter(r11, UriProtector.getQueryParameter(r5, r11));
        goto L26
    L30:
        r9.appendQueryParameter("url", r7);
        r5 = r9.build();
    L31:
        ILiveActionHandler r12 = jc1.k.f(ILiveActionHandler.class);
        if (r12 == null) goto L45;
        r12.handle(((Widget) r8).context, r5);
        return;
    L45:
        return;
    L21:
        if (r6.length() != 0) goto L23;
    L44:
        return;
    L13:
        if (r2.length() == 0) goto L16;
        r4 = false;
        goto L17
    L43:
        return;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L16;
        String r0 = r5.getKey();
        if (r0.hashCode() == 919040494) goto L9;
        return;
    L9:
        if (r0.equals("data_live_mini_app_commerce_status") == false) goto L15;
        p2 r6 = (p2) r5.getData();
        if (r6 == null) goto L18;
        yq(r6);
        return;
    L18:
        return;
    L15:
        return;
    }

    public final void onLoad(Object[] r4) {
        RoomContext r5 = getDataContext();
        if (r5 == null) goto L9;
        com.bytedance.live.datacontext.m r6 = r5.getRoom();
        if (r6 == null) goto L9;
        Room r7 = (Room) r6.getValue();
        if (r7 == null) goto L9;
        WelfareProjectInfo r8 = r7.welfareProjectInfo;
    L10:
        if (r8 != null) goto L12;
    L14:
        this.c = ((Number) ((Widget) this).dataCenter.get("data_anchor_welfare_id", 0L)).longValue();
        this.d = ((Number) ((Widget) this).dataCenter.get("data_anchor_welfare_frequency", Long.valueOf(qy0.a.getValue().f()))).longValue();
    L16:
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L18;
        y3.m(((Widget) this).dataCenter).k(ToolbarButton.WELFARE, new ToolbarAnchorWelfareBehavior(false));
    L18:
        RoomContext r9 = getDataContext();
        if (r9 == null) goto L23;
        com.bytedance.live.datacontext.j r10 = r9.getMessageManager();
        if (r10 == null) goto L23;
        r10.c(new AnonymousClass1(this));
    L23:
        IBrowserService r11 = jc1.k.f(IBrowserService.class);
        if (r11 == null) goto L30;
        Observable r12 = r11.registerExternalMethodFactory(new i(this));
        if (r12 == null) goto L30;
        ObservableSubscribeProxy r13 = (ObservableSubscribeProxy) r12.as(autoDispose());
        if (r13 == null) goto L30;
        r13.subscribe();
    L30:
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L33;
        r14.observe("data_live_mini_app_commerce_status", this);
    L33:
        yq(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(((Widget) this).dataCenter));
        return;
    L12:
        if (r8.isValid() != true) goto L14;
        this.c = r8.getProjectId();
        this.d = r8.get_showFrequency();
    L9:
        r8 = null;
        goto L10
    }

    public final void onMessage(tlc.d r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if ((r3 instanceof tn) == false) goto L18;
        tn r4 = (tn) r3;
        int r0 = r4.getOpType();
        if (r0 != 1) goto L9;
        WelfareProjectInfo r1 = r4.E();
        if (r1 != null) goto L15;
        return;
    L15:
        if (r1.isValid() != true) goto L21;
        this.c = r4.E().getProjectId();
        yq(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(((Widget) this).dataCenter));
        return;
    L21:
        return;
    L9:
        if (r0 != 3) goto L22;
        this.c = 0;
        yq(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(((Widget) this).dataCenter));
        return;
    L22:
        return;
    }

    public final void yq(p2 r4) {
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L6;
        return;
    L6:
        if (r4.i() == 1) goto L8;
        y3.f(((Widget) this).dataCenter).i(ToolbarButton.WELFARE_FOLD.extended());
    L10:
        if (r4.j() == 1) goto L12;
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.WELFARE.extended());
        return;
    L12:
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.WELFARE.extended());
        WelfareAppLogger.h();
        return;
    L8:
        y3.f(((Widget) this).dataCenter).c(ToolbarButton.WELFARE_FOLD.extended());
        goto L10
    }
}
