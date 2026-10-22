package com.bytedance.android.live.liveinteract.interactivesong.speech;

import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.RTSDataContext;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.live.datacontext.n;
import hg6.g;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends vb6.a {
    public final /* synthetic */ com.bytedance.android.live.liveinteract.interactivesong.speech.a a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.liveinteract.interactivesong.speech.a r0 = this.a.a;
            String r4 = (String) sh6.c.b((sh6.b) r3);
            int r1 = com.bytedance.android.live.liveinteract.interactivesong.speech.a.m;
            r0.d(r4);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.interactivesong.speech.b$b, reason: collision with other inner class name */
    public static final class C0036b<T> implements Consumer {
        public final /* synthetic */ b a;

        public C0036b(b r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.liveinteract.interactivesong.speech.a r0 = this.a.a;
            String r4 = (String) sh6.c.b((sh6.b) r3);
            int r1 = com.bytedance.android.live.liveinteract.interactivesong.speech.a.m;
            r0.getClass();
            if (r4 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L14;
            if (r0.a == true) goto L14;
            return;
        L14:
            if (new JSONObject(r4).optJSONObject("song_recognition_result") != null) goto L16;
            return;
        L16:
            if (r0.i == true) goto L20;
            PadConfigUtils.c();
            return;
        L20:
            return;
        L5:
            if (StringsKt.isBlank(r4) == true) goto L8;
            r2 = false;
            goto L9
        }
    }

    public final void H1() {
        this.a.h();
        com.bytedance.android.live.liveinteract.interactivesong.speech.a r0 = this.a;
        cg6.a r1 = r0.c();
        if (r1 == null) goto L8;
        g r2 = r1.getRtcManager();
        if (r2 == null) goto L8;
        r2.p(new f(r0));
    L8:
        if (this.a.i == false) goto L16;
        RTSDataContext r3 = RTSDataContext.Companion.getContext();
        if (r3 == null) goto L24;
        n<String> r4 = r3.getAedStateEvent();
        if (r4 == null) goto L25;
        Observable r5 = r4.a();
        if (r5 == null) goto L26;
        r5.subscribe(new a(this));
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L16:
        RTSDataContext r6 = RTSDataContext.Companion.getContext();
        if (r6 == null) goto L28;
        n<String> r7 = r6.getRoomRtsEvent();
        if (r7 == null) goto L29;
        Observable r8 = r7.a();
        if (r8 == null) goto L30;
        r8.subscribe(new C0036b(this));
        return;
    L30:
        return;
    L29:
        return;
    }

    public b(com.bytedance.android.live.liveinteract.interactivesong.speech.a r1) {
        this.a = r1;
    }
}
