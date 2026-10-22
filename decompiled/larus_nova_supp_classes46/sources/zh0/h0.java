package zh0;

import com.bytedance.android.live.liveinteract.radio.impl.RadioWidget;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h0 implements Observer<KVData> {
    public final /* synthetic */ RadioWidget a;

    public h0(RadioWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (MultiLinkLoadWidgetUtils.g() == true) goto L28;
        if (r4 != null) goto L7;
        return;
    L7:
        if (r4.getData() != null) goto L9;
        return;
    L9:
        if (r4.getKey().equals("data_audio_background_load") == false) goto L24;
        boolean r5 = ((Boolean) r4.getData()).booleanValue();
        x00.c r0 = this.a.z;
        if (r0 == null) goto L29;
        IVoiceLiveTheme r1 = r0.q(2);
        if (r5 == false) goto L18;
        com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.a r6 = this.a.B;
        if (r6 == null) goto L25;
        r6.b(r1);
        return;
    L25:
        return;
    L18:
        com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.a r7 = this.a.B;
        if (r7 == null) goto L27;
        r7.c(r1);
        return;
    L27:
        return;
    L29:
        return;
    L24:
        return;
    }
}
