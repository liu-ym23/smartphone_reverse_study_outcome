package or1;

import android.content.Context;
import com.bytedance.android.live.base.model.message.q5;
import com.bytedance.android.live.base.model.message.r5;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.message.model.VSShowChatMessageCommentRoleConfig;
import com.bytedance.android.livesdk.message.model.an;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdk.utils.z4;
import com.bytedance.android.livesdk.vscore_api.IEpisodeInteractiveService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f, com.bytedance.android.scope.o {
    public g() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final void g() {
        PlatformMessageHelper.INSTANCE.start(new f());
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final q5 i() {
        an r0 = new an();
        r0.setMessageMethod("WebcastShowChatMessage");
        return r0;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final r5 j() {
        return new VSShowChatMessageCommentRoleConfig();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final void k() {
        PlatformMessageHelper.INSTANCE.stop();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final void d(vlc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        q52.b.b(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final ylc.e f(long r1) {
        return n3.a(r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final vlc.d n(DataCenter r1) {
        return n3.e(r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final void a(vlc.d r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        Intrinsics.checkNotNullParameter(r3, "customParams");
        d4.j(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final void h(vlc.d r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        Intrinsics.checkNotNullParameter(r3, "cursor");
        q52.b.a(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final vlc.d c(Context r13, long r14, String r16, ylc.e r17, String r18) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r16, "roomTag");
        Intrinsics.checkNotNullParameter(r17, "wrdsManager");
        Intrinsics.checkNotNullParameter(r18, "anchorId");
        n0.d();
        return z4.a(r13, new com.bytedance.android.livesdk.utils.r5(r14, r18, false, false, false, r16, r17, false));
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final vlc.d provideSeekMessageManager(Context r13, DataCenter r14, boolean r15, long r16, long r18, int r20, long r21) {
        Intrinsics.checkNotNullParameter(r13, "context");
        return jc1.k.n(IEpisodeInteractiveService.class).provideSeekMessageManager(r13, r14, false, r16, r18, r20, r21);
    }
}
