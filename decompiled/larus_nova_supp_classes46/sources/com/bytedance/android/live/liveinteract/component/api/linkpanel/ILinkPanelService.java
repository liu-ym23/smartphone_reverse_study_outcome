package com.bytedance.android.live.liveinteract.component.api.linkpanel;

import android.content.Context;
import android.content.DialogInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.liveinteract.component.api.IComponentService;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkDynamicWidgetNew;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/component/api/linkpanel/ILinkPanelService;", "Lcom/bytedance/android/live/liveinteract/component/api/IComponentService;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkPanelService extends IComponentService {

    public static final class a {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public static void onCreate(ILinkPanelService r0) {
            IComponentService.a.onCreate(r0);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public static void onDestroy(ILinkPanelService r0) {
            IComponentService.a.onDestroy(r0);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public static void onPause(ILinkPanelService r0) {
            IComponentService.a.onPause(r0);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public static void onResume(ILinkPanelService r0) {
            IComponentService.a.onResume(r0);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public static void onStart(ILinkPanelService r0) {
            IComponentService.a.onStart(r0);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public static void onStop(ILinkPanelService r0) {
            IComponentService.a.onStop(r0);
        }

        public static /* synthetic */ void a(ILinkPanelService r6, Context r7, IRoom r8, a5 r9, String r10) {
            r6.pj(r7, r8, r9, r10, -1);
        }
    }

    void C70(Context r1, DataCenter r2, int r3, String r4, int r5, IRoom r6, LifecycleOwner r7);

    void JR(Context r1, DataCenter r2, IRoom r3, boolean r4, LifecycleOwner r5);

    void NO(int r1);

    void PQ(Context r1, DataCenter r2, IRoom r3, String r4, MultiLinkDynamicWidgetNew r5);

    void T60(int r1);

    void Tp(Function1<? super Integer, Unit> r1);

    void Uo(Function1<? super com.bytedance.android.live.liveinteract.api.data.a, Unit> r1);

    void VG(Function1<? super com.bytedance.android.live.liveinteract.api.data.a, Unit> r1);

    void X40(Function1<? super Integer, Unit> r1);

    void ad(Context r1, DataCenter r2, String r3, int r4, LifecycleOwner r5);

    void close();

    void eq(Function1<? super Integer, Unit> r1);

    boolean isShowing();

    void jk(com.bytedance.android.live.liveinteract.api.data.a r1);

    void js(int r1);

    void k50(Function1<? super Integer, Unit> r1);

    @Override // com.bytedance.android.live.liveinteract.component.api.IComponentService
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    /* synthetic */ void onCreate();

    @Override // com.bytedance.android.live.liveinteract.component.api.IComponentService
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    /* synthetic */ void onDestroy();

    @Override // com.bytedance.android.live.liveinteract.component.api.IComponentService
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    /* synthetic */ void onPause();

    @Override // com.bytedance.android.live.liveinteract.component.api.IComponentService
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    /* synthetic */ void onResume();

    @Override // com.bytedance.android.live.liveinteract.component.api.IComponentService
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    /* synthetic */ void onStart();

    @Override // com.bytedance.android.live.liveinteract.component.api.IComponentService
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    /* synthetic */ void onStop();

    void pj(Context r1, IRoom r2, a5 r3, String r4, int r5);

    void removePermitCallback();

    void setOnDismissListener(DialogInterface.OnDismissListener r1);

    void uO(Context r1, DataCenter r2, IRoom r3, List r4, String r5, LifecycleOwner r6);
}
