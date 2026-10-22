package wd0;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import tf0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public DataCenter a;
    public IRoom b;
    public Integer c;
    public Integer d;
    public Boolean e;
    public IVoiceLiveTheme f;
    public Boolean g;
    public int h;
    public List<? extends e> i;

    public b() {
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("LiveBgRenderContext(room=");
        IRoom r1 = this.b;
        if (r1 == null) goto L5;
        String r2 = r1.getTitle();
    L6:
        r0.append(r2);
        r0.append(", scene=");
        r0.append(this.c);
        r0.append(", uiLayout=");
        r0.append(this.d);
        r0.append(", isPlayerShow=");
        r0.append(this.e);
        r0.append(", theme=");
        r0.append(this.f);
        r0.append(", hideBg=");
        r0.append(this.g);
        r0.append(", layoutOrientation=");
        r0.append(this.h);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }
}
