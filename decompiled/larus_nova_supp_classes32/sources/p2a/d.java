package p2a;

import com.larus.im.bean.bot.SpeakerVoice;
import com.lynx.tasm.event.LynxTouchEvent;
import kotlin.collections.MapsKt;
import ouc.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ void a(d r23, SpeakerVoice r24, String r25, boolean r26, String r27, String r28, String r29, String r30, String r31, String r32, Float r33, Float r34, Integer r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, d0 r44, int r45) {
            if ((r45 & 1) == 0) goto L5;
            SpeakerVoice r1 = null;
        L7:
            if ((r45 & 2) == 0) goto L9;
            String r3 = null;
        L11:
            if ((r45 & 4) == 0) goto L13;
            boolean r4 = false;
        L15:
            if ((r45 & 8) == 0) goto L17;
            String r5 = null;
        L19:
            if ((r45 & 16) == 0) goto L21;
            String r6 = null;
        L23:
            if ((r45 & 32) == 0) goto L25;
            String r7 = null;
        L27:
            if ((r45 & 64) == 0) goto L29;
            String r8 = null;
        L31:
            if ((r45 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L33;
            String r9 = null;
        L35:
            if ((r45 & 256) == 0) goto L37;
            String r10 = null;
        L39:
            if ((r45 & 512) == 0) goto L41;
            String r11 = null;
        L43:
            if ((r45 & 1024) == 0) goto L45;
            Float r12 = null;
        L47:
            if ((r45 & 2048) == 0) goto L49;
            Float r13 = null;
        L51:
            if ((r45 & 4096) == 0) goto L53;
            Integer r14 = null;
        L55:
            if ((r45 & 8192) == 0) goto L57;
            String r15 = null;
        L59:
            if ((r45 & 16384) == 0) goto L61;
            String r2 = null;
        L63:
            if ((r45 & 32768) == 0) goto L65;
            String r17 = null;
        L67:
            if ((r45 & 65536) == 0) goto L69;
            String r18 = null;
        L71:
            if ((r45 & 131072) == 0) goto L73;
            String r19 = null;
        L75:
            if ((r45 & 262144) == 0) goto L77;
            String r20 = null;
        L79:
            if ((r45 & 524288) == 0) goto L81;
            String r21 = null;
        L83:
            if ((r45 & 1048576) == 0) goto L85;
            String r16 = null;
        L87:
            if ((r45 & 2097152) == 0) goto L89;
            d0 r0 = new d0(MapsKt.emptyMap());
        L90:
            r23.a(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r17, r18, r19, r20, r21, r16, r0);
            return;
        L89:
            r0 = r44;
            goto L90
        L85:
            r16 = r43;
            goto L87
        L81:
            r21 = r42;
            goto L83
        L77:
            r20 = r41;
            goto L79
        L73:
            r19 = r40;
            goto L75
        L69:
            r18 = r39;
            goto L71
        L65:
            r17 = r38;
            goto L67
        L61:
            r2 = r37;
            goto L63
        L57:
            r15 = r36;
            goto L59
        L53:
            r14 = r35;
            goto L55
        L49:
            r13 = r34;
            goto L51
        L45:
            r12 = r33;
            goto L47
        L41:
            r11 = r32;
            goto L43
        L37:
            r10 = r31;
            goto L39
        L33:
            r9 = r30;
            goto L35
        L29:
            r8 = r29;
            goto L31
        L25:
            r7 = r28;
            goto L27
        L21:
            r6 = "bot_voice_change";
            goto L23
        L17:
            r5 = r27;
            goto L19
        L13:
            r4 = r26;
            goto L15
        L9:
            r3 = r25;
            goto L11
        L5:
            r1 = r24;
            goto L7
        }
    }

    void a(SpeakerVoice r1, String r2, boolean r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, Float r11, Float r12, Integer r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, d0 r22);
}
