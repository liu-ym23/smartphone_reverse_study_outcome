package xq1;

import android.content.Context;
import com.bytedance.android.live.base.model.message.q5;
import com.bytedance.android.live.base.model.message.r5;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import ylc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements f, o {
    public final f a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final void a(d r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        Intrinsics.checkNotNullParameter(r3, "customParams");
        this.a.a(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final d c(Context r9, long r10, String r12, e r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r12, "roomTag");
        Intrinsics.checkNotNullParameter(r13, "wrdsManager");
        Intrinsics.checkNotNullParameter(r14, "anchorId");
        return this.a.c(r9, r10, r12, r13, r14);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final void d(d r2) {
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        this.a.d(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final e f(long r2) {
        return this.a.f(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final void g() {
        this.a.g();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final void h(d r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        Intrinsics.checkNotNullParameter(r3, "cursor");
        this.a.h(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final q5 i() {
        return this.a.i();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final r5 j() {
        return this.a.j();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final void k() {
        this.a.k();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final d n(DataCenter r2) {
        return this.a.n(r2);
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final d provideSeekMessageManager(Context r13, DataCenter r14, boolean r15, long r16, long r18, int r20, long r21) {
        Intrinsics.checkNotNullParameter(r13, "context");
        return this.a.provideSeekMessageManager(r13, r14, false, r16, r18, r20, r21);
    }

    public a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "hostMessage");
        this.a = r2;
    }
}
