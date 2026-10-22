package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.model.LiveBroadcastMusicEffectInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o3 implements i0.f {
    public final /* synthetic */ m3.g a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ JSONObject c;
    public final /* synthetic */ com.bytedance.android.live.pushstream.d d;

    public static final class a implements Runnable {
        public final /* synthetic */ o3 a;

        public a(o3 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o3 r0 = this.a;     // Catch: Throwable -> L6
            com.bytedance.android.live.pushstream.d r1 = r0.d;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r1.e0("MusicInformationData", r0.c.toString());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b {
        public b() {
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.f
    public final void onFinish() {
        if (this.a.b == false) goto L24;
        i0 r0 = (i0) this.b.element;
        r0.getClass();
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r2 = ((ArrayList) r0.c).iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r1.putAll(((i0.d) r2.next()).getResult());
        goto L6
    L8:
        Iterator r3 = r1.entrySet().iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        Map.Entry r4 = (Map.Entry) r3.next();
        this.c.put((String) r4.getKey(), r4.getValue());
        goto L10
    L12:
        com.bytedance.android.live.core.utils.i0.c().post(new a(this));
        m3.g r5 = this.a;
        m3 r6 = r5.a;
        r6.e = r5.d;
        RoomContext.a r7 = RoomContext.Companion;
        DataCenter r8 = r6.a;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L15:
        RoomContext r9 = RoomContext.a.c(r7, r8, 0, 2);
        if (r9 == null) goto L20;
        com.bytedance.live.datacontext.n r10 = r9.getBroadcastMusicEffectInfo();
        if (r10 == null) goto L20;
        m3.g r11 = this.a;
        r10.setValue(new LiveBroadcastMusicEffectInfo(r11.e, String.valueOf(r11.d.a), null, 4, null));
    L20:
        m3.a(this.a.a).put("anchor_interact_effect_music_open", Boolean.TRUE);
        m3.a(this.a.a).put("anchor_interact_effect_music_error_observer", new b());
        return;
    }

    public o3(m3.g r1, Ref.ObjectRef r2, JSONObject r3, com.bytedance.android.live.pushstream.d r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
