package kc8;

import com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService;
import com.larus.bmhome.chat.block.base.config.RichMediaCreationClickServiceNoop;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r0 implements d0 {
    public d0 a;

    public r0() {
    }

    @Override // kc8.d0
    public final s0 a() {
        d0 r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    @Override // kc8.d0
    public final void recycle() {
        d0 r0 = this.a;
        if (r0 == null) goto L5;
        r0.recycle();
    L5:
        this.a = null;
    }

    @Override // kc8.d0
    public final void b(VideoPlayView r12, Message r13, CreationItem r14, int r15, q r16, CoroutineScope r17, JSONObject r18, fn8.r r19, fn8.s r20) {
        Intrinsics.checkNotNullParameter(r12, "playbackView");
        Intrinsics.checkNotNullParameter(r13, "message");
        Intrinsics.checkNotNullParameter(r14, "clickItem");
        Intrinsics.checkNotNullParameter(r17, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r19, "onPlaybackReadyChanged");
        Intrinsics.checkNotNullParameter(r20, "onPlayingChanged");
        Object r1 = ServiceManager.get().getService(IRichMediaCreationClickService.class);
        if ((((IRichMediaCreationClickService) r1) instanceof RichMediaCreationClickServiceNoop) == false) goto L6;
        r1 = null;
    L6:
        IRichMediaCreationClickService r2 = (IRichMediaCreationClickService) r1;
        if (r2 == null) goto L9;
        d0 r3 = r2.g();
    L10:
        if (r3 == null) goto L15;
        if (r3 == this) goto L15;
        this.a = r3;
        r3.b(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        return;
    L15:
        r19.invoke(Boolean.FALSE);
        return;
    L9:
        r3 = null;
        goto L10
    }
}
