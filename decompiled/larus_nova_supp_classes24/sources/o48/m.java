package o48;

import com.larus.common_ui.dialog.u;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.platform.service.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class m implements u {
    public final /* synthetic */ Function1<Boolean, Unit> a;
    public final /* synthetic */ JSONObject b;

    public final void cancel() {
        this.a.invoke(Boolean.FALSE);
        qr9.b r0 = VideoFeedProviderDelegate.b.getTopPlayerController();
        if (r0 == null) goto L5;
        r0.playPlayer();
    L5:
        o r1 = o.a;
        JSONObject r2 = this.b;
        r2.put("click_type", "cancel");
        Unit r3 = Unit.INSTANCE;
        r1.reportEvent("sdk_video_notice_click", r2);
    }

    public m(f r1, JSONObject r2) {
        this.a = r1;
        this.b = r2;
    }
}
