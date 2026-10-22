package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0002¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsMiddlewareDynamicLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/data/g$c;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/a2;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsMiddlewareDynamicLoader implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c<a2>, Observer<KVData>, a2 {
    public final DataCenter a;
    public LiveMode b;
    public boolean c;
    public boolean d;
    public IRoom e;
    public final e f;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public boolean b() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public void d() {
    }

    public void e(KVData r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public void onLoad() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public void onUnLoad() {
        this.a.removeObserver(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2
    public String debugName() {
        return getClass().getSimpleName();
    }

    public AbsMiddlewareDynamicLoader(e r3) {
        Intrinsics.checkNotNullParameter(r3, "env");
        this.f = r3;
        DataCenter r4 = r3.a;
        this.a = r4;
        this.d = true;
        this.b = (LiveMode) r4.get("data_live_mode", LiveMode.VIDEO);
        this.c = ((Boolean) r4.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.d = ((Boolean) r4.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        this.e = (IRoom) r4.get("data_room");
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        e((KVData) r1);
    }
}
