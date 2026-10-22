package com.bytedance.android.live.liveinteract.videotalk.dialog;

import android.widget.Switch;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ VideoTalkIntegrationPanelDailog a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ boolean c;

    public e(VideoTalkIntegrationPanelDailog r1, Ref.ObjectRef r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r4) {
        com.bytedance.android.live.network.response.a r5 = (com.bytedance.android.live.network.response.a) r4;
        ALogger.i("ttlive_link", "videoTalk update_setting " + ((HashMap) this.b.element));
        TalkRoomLogUtils.j0(this.c, ((Switch) this.a.findViewById(2131387923)).isChecked(), ((Switch) this.a.findViewById(2131387924)).isChecked());
    }
}
