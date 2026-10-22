package com.larus.avlink.plugins;

import com.google.gson.Gson;
import com.larus.avlink.e.DoraImageEvent;
import com.larus.avlink.e.l;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.bean.ChatParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraCameraSoundPluginEvent extends com.larus.audio.call.arch.a<n4> implements com.larus.avlink.e.s {
    public boolean f;
    public boolean g;
    public boolean h;

    public static final class a {
    }

    public static final class b extends com.larus.im.service.audio.z0 {
        public final /* synthetic */ DoraCameraSoundPluginEvent a;

        public final String g() {
            this.a.getClass();
            return "DoraCameraSoundPlugin";
        }

        public b(DoraCameraSoundPluginEvent r1) {
            this.a = r1;
        }

        public final void n(com.larus.im.service.audio.z0.a r9) {
            Intrinsics.checkNotNullParameter(r9, "event");
            if ((r9 instanceof pf9.q) == false) goto L19;
            final DoraCameraSoundPluginEvent r0 = this.a;
            r0.getClass();
            List r10 = ((pf9.q) r9).a;
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
            Iterator r11 = r10.iterator();
        L6:
            if (r11.hasNext() == false) goto L55;
            pf9.p r2 = (pf9.p) r11.next();
            Long r3 = r2.a;
            if (r3 == null) goto L18;
            int r4 = (int) r3.longValue();
            JSONObject r5 = new JSONObject();
            Map r6 = r2.b;
            if (r6 == null) goto L15;
            Iterator r7 = r6.entrySet().iterator();
        L13:
            if (r7.hasNext() == false) goto L15;
            Map.Entry r8 = (Map.Entry) r7.next();
            r5.putOpt((String) r8.getKey(), r8.getValue());
        L15:
            Gson r12 = ha8.a.a;
            final ChatParam r13 = (ChatParam) ha8.a.a(r5.toString(), ChatParam.class);
            if (r4 != 23) goto L18;
            com.larus.utils.l0.b(new z(r13, r0));
        L18:
            r1.add(r2);
            goto L6
        L55:
            return;
        L19:
            boolean r14 = false;
            if ((r9 instanceof pf9.z) == false) goto L26;
            DoraCameraSoundPluginEvent r15 = this.a;
            r15.g = false;
            if (r15.h == false) goto L24;
            r15.h = false;
            return;
        L24:
            r15.f = false;
            FLogger.a.i("DoraCameraSoundPlugin", "notifyDoraCameraSound abort by new query");
            return;
        L26:
            if ((r9 instanceof pf9.c0) == false) goto L39;
            pf9.a r16 = ((pf9.c0) r9).a;
            if (r16 == null) goto L49;
            Map r17 = r16.d;
            if (r17 == null) goto L50;
            final String r18 = (String) r17.get("command_list");
            if (r18 == null) goto L51;
            final DoraCameraSoundPluginEvent r19 = this.a;
            if (r18.length() != 0) goto L36;
            r14 = true;
        L36:
            if (r14 == true) goto L52;
            com.larus.utils.l0.b(new a0(r18, r19));
            return;
        L52:
            return;
        L51:
            return;
        L50:
            return;
        L49:
            return;
        L39:
            if ((r9 instanceof pf9.a0) == false) goto L54;
            FLogger r20 = FLogger.a;
            this.a.getClass();
            r20.i("DoraCameraSoundPlugin", "notifyDoraCameraSound ");
            this.a.j3();
            return;
        }
    }

    static {
    }

    @Override // com.larus.avlink.e.s
    public final void M() {
    }

    public final String T2() {
        return "DoraCameraSoundPlugin";
    }

    @Override // com.larus.avlink.e.s
    public final void j(boolean r1, int r2, byte r3) {
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new b(this);
    }

    public final void b3() {
        l r0 = l.a;
        l.c.remove(this);
    }

    public final void j3() {
        FLogger r0 = FLogger.a;
        r0.i("DoraCameraSoundPlugin", "notifyDoraCameraSound skip. canCameraSoundPlay: " + this.f + ", hasPlayCameraSound: " + this.g);
        if (this.f == true) goto L5;
    L9:
        r0.i("DoraCameraSoundPlugin", "notifyDoraCameraSound skip");
        return;
    L5:
        if (this.g == true) goto L9;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraCameraSoundPluginEvent$notifyDoraCameraSound$1(this, null), 3, null);
    }

    public DoraCameraSoundPluginEvent(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        l r3 = l.a;
        l.c.add(this);
    }

    @Override // com.larus.avlink.e.s
    public final void w(b49.k r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
    }

    @Override // com.larus.avlink.e.s
    public final void p1(com.larus.avlink.model.a r1, DoraImageEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.avlink.e.s
    public final boolean D0(int r1, int r2, int r3, int r4, int r5) {
        FLogger r6 = FLogger.a;
        r6.i("DoraCameraSoundPlugin", "postTakeImageStart, mode: " + r3);
        if (r3 != 7) goto L8;
        if (r5 == 0) goto L9;
        this.f = true;
        r6.i("DoraCameraSoundPlugin", "notifyDoraCameraSound 1, canCameraSoundPlay: " + this.f);
        return false;
    L9:
        return false;
    L8:
        return false;
    }
}
