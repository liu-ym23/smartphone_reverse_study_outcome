package com.larus.audio;

import android.os.SystemClock;
import com.larus.audio.asr.a0;
import com.larus.audio.asr.c0;
import com.larus.bmhome.chat.component.bottom.voice.service.m;
import com.larus.im.bean.message.Message;
import h68.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface o0 {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(o0 r10, String r11, Function1 r12, Function1 r13, Function1 r14, Function4 r15, m r16, a0 r17, int r19) {
            if ((r19 & 2) == 0) goto L5;
            Function1 r4 = null;
        L7:
            if ((r19 & 4) == 0) goto L9;
            Function1 r5 = null;
        L11:
            if ((r19 & 8) == 0) goto L13;
            Function1 r6 = null;
        L15:
            if ((r19 & 16) == 0) goto L17;
            Function4 r7 = null;
        L19:
            if ((r19 & 32) == 0) goto L21;
            m r8 = null;
        L23:
            if ((r19 & 64) == 0) goto L25;
            a0 r9 = null;
        L26:
            r10.a(r11, r4, r5, r6, r7, r8, r9);
            return;
        L25:
            r9 = r17;
            goto L26
        L21:
            r8 = r16;
            goto L23
        L17:
            r7 = r15;
            goto L19
        L13:
            r6 = r14;
            goto L15
        L9:
            r5 = r13;
            goto L11
        L5:
            r4 = r12;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(o0 r25, Message r26, String r27, String r29, String r210, String r30, JSONObject r31, boolean r32, String r33, boolean r34, Long r35, n58.b r36, String r37, long r38, Integer r40, Long r41, d r42, Function0 r43, long r44, c0 r46, int r47) {
            if ((r47 & 8) == 0) goto L5;
            String r7 = null;
        L7:
            if ((r47 & 16) == 0) goto L9;
            String r8 = null;
        L11:
            if ((r47 & 32) == 0) goto L13;
            JSONObject r9 = new JSONObject();
        L15:
            if ((r47 & 64) == 0) goto L17;
            boolean r10 = false;
        L19:
            if ((r47 & 128) == 0) goto L21;
            String r11 = "";
        L23:
            if ((r47 & 256) == 0) goto L25;
            boolean r12 = false;
        L27:
            if ((r47 & 512) == 0) goto L29;
            Long r13 = null;
        L31:
            if ((r47 & 1024) == 0) goto L33;
            n58.b r14 = null;
        L35:
            if ((r47 & 2048) == 0) goto L37;
            String r15 = null;
        L39:
            if ((r47 & 4096) == 0) goto L41;
            long r16 = SystemClock.elapsedRealtime();
        L43:
            if ((r47 & 8192) == 0) goto L45;
            Integer r19 = null;
        L47:
            if ((r47 & 16384) == 0) goto L49;
            Long r110 = null;
        L51:
            if ((32768 & r47) == 0) goto L53;
            d r20 = null;
        L55:
            if ((65536 & r47) == 0) goto L57;
            Function0 r21 = new m0();
        L59:
            if ((131072 & r47) == 0) goto L61;
            long r22 = 500;
        L63:
            if ((r47 & 262144) == 0) goto L65;
            c0 r24 = new c0(null, null, 0, 255);
        L66:
            r25.e(r26, r27, r29, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r19, r110, r20, r21, r22, r24);
            return;
        L65:
            r24 = r46;
            goto L66
        L61:
            r22 = r44;
            goto L63
        L57:
            r21 = r43;
            goto L59
        L53:
            r20 = r42;
            goto L55
        L49:
            r110 = r41;
            goto L51
        L45:
            r19 = r40;
            goto L47
        L41:
            r16 = r38;
            goto L43
        L37:
            r15 = r37;
            goto L39
        L33:
            r14 = r36;
            goto L35
        L29:
            r13 = r35;
            goto L31
        L25:
            r12 = r34;
            goto L27
        L21:
            r11 = r33;
            goto L23
        L17:
            r10 = r32;
            goto L19
        L13:
            r9 = r31;
            goto L15
        L9:
            r8 = r30;
            goto L11
        L5:
            r7 = r210;
            goto L7
        }
    }

    void a(String r1, Function1<? super byte[], Unit> r2, Function1<? super String, Unit> r3, Function1<? super b, Unit> r4, Function4<? super String, ? super String, ? super Long, ? super Integer, Unit> r5, Function1<? super String, Unit> r6, a0 r7);

    void b();

    void c();

    String d();

    void e(Message r1, String r2, String r3, String r4, String r5, JSONObject r6, boolean r7, String r8, boolean r9, Long r10, n58.b r11, String r12, long r13, Integer r15, Long r16, d r17, Function0<Unit> r19, long r110, c0 r21);

    void f();

    void g(String r1, String r2, String r3, String r4, com.larus.audio.asr.y r5, boolean r6, String r7, boolean r8, Long r9, n58.b r10, long r11, Function0 r13, d r14);

    String getTaskId();

    String h();
}
