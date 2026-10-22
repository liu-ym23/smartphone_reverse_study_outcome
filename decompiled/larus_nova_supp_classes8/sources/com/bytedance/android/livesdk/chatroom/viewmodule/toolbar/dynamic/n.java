package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface n {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static n a(DataCenter r5) {
            IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
            if (r0 == null) goto L9;
            com.bytedance.android.livesdk.chatroom.o r6 = IRoomContextService.a.a(r0, r5, 0, 2);
            if (r6 == null) goto L9;
            com.bytedance.live.datacontext.j r7 = r6.getCompactTbLoader();
            if (r7 == null) goto L9;
            m r8 = (m) r7.getValue();
        L11:
            if ((r8 instanceof m) == true) goto L13;
            r8 = null;
        L13:
            if (r8 != null) goto L15;
            return null;
        L15:
            return r8.getCheckManager();
        L9:
            r8 = null;
            goto L11
        }
    }

    static {
        a = a.a;
    }

    void a();

    void b(NewToolbarButtonConstants r1, ToolbarComponentCheckInterface r2);

    boolean c(int r1);

    void clear();

    void d(NewToolbarButtonConstants r1);
}
