package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.content.Context;
import com.bytedance.android.livesdkapi.livereplay.IECLiveReplayParams;
import com.bytedance.android.livesdkapi.livereplay.IECLiveReplayService;
import com.bytedance.android.livesdkapi.livereplay.ILiveRoomInfo;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements yr1.c, com.bytedance.android.scope.o {

    public static final class a implements ILiveRoomInfo {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public final String authorId() {
            return this.b;
        }

        public final String roomId() {
            return this.a;
        }

        public final String secAuthorId() {
            return this.c;
        }

        public a(String r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public d() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yr1.c
    public final IExternalWidget a(Context r12, String r13, String r14, String r15, String r16, long r17, IECLiveReplayParams r19) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "roomId");
        Intrinsics.checkNotNullParameter(r14, "authorId");
        Intrinsics.checkNotNullParameter(r15, "secAuthorId");
        Intrinsics.checkNotNullParameter(r16, "replayId");
        Intrinsics.checkNotNullParameter(r19, "params");
        IHostCommerceServiceLive r3 = jc1.k.f(IHostCommerceServiceLive.class);
        if (r3 == null) goto L7;
        IECLiveReplayService r4 = r3.getECLiveReplayService();
        if (r4 == null) goto L7;
        return r4.getECProductWidget(r12, new a(r13, r14, r15), r16, r17, r19);
    L7:
        return null;
    }
}
