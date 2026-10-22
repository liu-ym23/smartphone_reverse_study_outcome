package com.larus.asr;

import com.larus.audio.audiov3.config.task.sami.asr.ReportType;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.audio.audiov3.task.asr.AsrState;
import com.larus.audio.audiov3.task.asr.sami.data.SamiAsrDataBin;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import y58.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public static final CopyOnWriteArrayList<h68.d> a = null;
    public static final a b = null;

    public static final class a implements h68.d {
        public a() {
        }

        public final void a(b r3) {
            Intrinsics.checkNotNullParameter(r3, "result");
            Iterator<h68.d> r0 = d.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().a(r3);
            goto L4
        }

        public final void b(h68.b r3) {
            Intrinsics.checkNotNullParameter(r3, "asrStreamSentenceResp");
            Iterator<h68.d> r0 = d.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().b(r3);
            goto L4
        }

        public final void c(SamiAsrDataBin r3) {
            Iterator<h68.d> r0 = d.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().c(r3);
            goto L4
        }

        public final void e(AsrState r3) {
            Intrinsics.checkNotNullParameter(r3, "asrState");
            Iterator<T> r0 = d.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((h68.d) r0.next()).e(r3);
            goto L4
        }

        public void onEvent(AsrEventEnum r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            Iterator<T> r0 = d.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((h68.d) r0.next()).onEvent(r3);
            goto L4
        }

        public final void f(b r3, ReportType r4) {
            Intrinsics.checkNotNullParameter(r3, "result");
            Intrinsics.checkNotNullParameter(r4, "type");
            Iterator<h68.d> r0 = d.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().f(r3, r4);
            goto L4
        }

        public final void d(AsrLifeState r3, String r4, Map<String, String> r5) {
            Intrinsics.checkNotNullParameter(r3, "lifeState");
            Iterator<T> r0 = d.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((h68.d) r0.next()).d(r3, r4, r5);
            goto L4
        }
    }

    static {
        a = new CopyOnWriteArrayList();
        b = new a();
    }
}
