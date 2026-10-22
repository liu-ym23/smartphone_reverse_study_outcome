package rvb;

import android.util.LruCache;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmParticipantType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmSubtitleSpeakerType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.helper.MmSubtitleSmoothType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.j;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.pb.minutes.v1.ByteviewUser;
import com.ss.android.lark.pb.minutes.v1.RecordingSubtitleData;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public final MmRecordingSession a;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a b;
    public final MmRecordingSubtitleRepo c;
    public final d d;
    public volatile long e;
    public final HashMap<Long, Long> f;
    public final LruCache<String, i> g;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmSubtitleSmoothType.values().length];
            r0[MmSubtitleSmoothType.SOURCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MmSubtitleSmoothType.TARGET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final boolean a(RecordingSubtitleData r7) {
        RecordingSubtitleData.Subtitle r0 = r7.target;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.content;
    L7:
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        return false;
    L15:
        RecordingSubtitleData.Subtitle r4 = r7.target;
        if (r4 == null) goto L18;
        String r5 = r4.language;
    L19:
        String r6 = "";
        if (r5 != null) goto L23;
        r5 = "";
    L23:
        if (r5.length() != 0) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == false) goto L28;
    L58:
        return true;
    L28:
        if (Intrinsics.areEqual(r5, "source") == true) goto L58;
        RecordingSubtitleData.Subtitle r9 = r7.source;
        if (r9 == null) goto L33;
        String r10 = r9.language;
    L34:
        if (r10 == null) goto L38;
        r6 = r10;
    L38:
        if (r6.length() != 0) goto L40;
        boolean r11 = true;
    L41:
        if (r11 == false) goto L44;
        r6 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f) this.b.l().l().b().getValue()).c.a;
    L44:
        if (r6.length() != 0) goto L46;
        boolean r12 = true;
    L47:
        if (r12 == false) goto L57;
        RecordingSubtitleData.Subtitle r13 = r7.source;
        if (r13 == null) goto L51;
        r1 = r13.content;
    L51:
        if (r1 != null) goto L53;
    L54:
        return true;
    L53:
        if (r1.length() == 0) goto L54;
        return false;
    L57:
        return e.a(r6, r5);
    L46:
        r12 = false;
        goto L47
    L40:
        r11 = false;
        goto L41
    L33:
        r10 = null;
        goto L34
    L25:
        r8 = false;
        goto L26
    L18:
        r5 = null;
        goto L19
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    public f(MmRecordingSession r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a r3, MmRecordingSubtitleRepo r4, d r5) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r3, "repoContainer");
        Intrinsics.checkNotNullParameter(r4, "subtitleRepo");
        Intrinsics.checkNotNullParameter(r5, "bilingualHelper");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.f = new HashMap();
        this.g = new LruCache(50);
    }

    public final i c(String r10, ByteviewUser.ParticipantType r11, MmSubtitleSpeakerType r12, String r13) {
        String r7 = r10 + "||" + r12.ordinal() + '|' + r11.name() + '|' + r13;
        i r0 = this.g.get(r7);
        if (r0 != null) goto L21;
        MmParticipantType.a r1 = MmParticipantType.Companion;
        int r14 = r11.getValue();
        r1.getClass();
        MmParticipantType[] r2 = MmParticipantType.values();
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L13;
        MmParticipantType r5 = r2[r4];
        if (r5.getValue() != r14) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == true) goto L14;
        r4 = r4 + 1;
    L14:
        if (r5 != null) goto L16;
        MmParticipantType r8 = MmParticipantType.UNKNOWN;
    L17:
        i r9 = new i(r10, "", r8, r12, r13, 96);
        this.g.put(r7, r9);
        return r9;
    L16:
        r8 = r5;
        goto L17
    L9:
        r6 = false;
        goto L10
    L13:
        r5 = null;
        goto L14
    L21:
        return r0;
    }

    public final h b(RecordingSubtitleData r32, boolean r33, h r34, MmSubtitleSmoothType r35, String r36) {
        Intrinsics.checkNotNullParameter(r32, "data");
        if (r35 != null) goto L5;
        int r5 = -1;
    L7:
        if (r5 != 1) goto L9;
        if (r36 != null) goto L29;
        String r6 = "";
    L30:
        if (r34 == null) goto L33;
        String r8 = r34.f;
        if (r8 == null) goto L33;
    L35:
        if (Intrinsics.areEqual(this.b.o(), "source") == true) goto L37;
        String r20 = r6;
        String r21 = r8;
    L92:
        Boolean r2 = r32.is_seg_final;
        if (r2 == null) goto L95;
        boolean r15 = r2.booleanValue();
    L96:
        Long r3 = r32.seg_id;
        if (r3 == null) goto L99;
        long r4 = r3.longValue();
    L100:
        long r13 = r4;
        RecordingSubtitleData.SSDSpeaker r7 = r32.ssd_speaker;
        if (r7 == null) goto L134;
        RecordingSubtitleData.SSDSpeaker.SSDSpeakerUserType r9 = r7.user_type;
        if (r9 != null) goto L105;
    L107:
        boolean r10 = false;
    L108:
        String r11 = r7.user_id;
        String r12 = r7.speaker_user_id;
        String r14 = r7.speaker_info_source;
        if (r14 != null) goto L112;
        r14 = "";
    L112:
        if (r14.length() != 0) goto L114;
        boolean r16 = true;
    L115:
        if (r16 == false) goto L117;
        r14 = "unknown";
    L117:
        if (r10 == false) goto L126;
        if (r11 != null) goto L120;
    L123:
        boolean r17 = true;
    L124:
        if (r17 == true) goto L126;
        Pair r18 = new Pair(r11, c(r11, ByteviewUser.ParticipantType.LARK_USER, MmSubtitleSpeakerType.VOICE_PRINT_SPEAKER, r14));
    L135:
        String r19 = (String) r18.component1();
        i r22 = (i) r18.component2();
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.f r23 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.f) this.b.h().l().b().getValue();
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r24 = r23.b.get(r19);
        Long r25 = r32.seg_id;
        long r26 = 0;
        if (r25 == null) goto L144;
        long r110 = r25.longValue();
        Long r27 = this.f.get(Long.valueOf(r110));
        if (r27 == null) goto L141;
        r26 = r27.longValue();
        goto L144
    L141:
        if (r33 == false) goto L143;
        r26 = RangesKt.coerceAtLeast(Math.min(r32.absolute_timestamp.longValue() - this.e, ((Number) this.a.p.getValue()).longValue()), 0);
        this.f.put(Long.valueOf(r110), Long.valueOf(r26));
        goto L144
    L143:
        r26 = r32.timestamp.longValue();
    L144:
        h r28 = new h(r13, r15, r26, r32.absolute_timestamp.longValue(), r20, r21, r22, r24, r19, r32.show_edit_speaker_button.booleanValue(), r23.a, false, ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.d) this.c.l().b().getValue()).e, 24576);
        d r29 = this.d;
        String r30 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f) this.b.l().l().b().getValue()).c.a;
        String r31 = this.b.o();
        r29.getClass();
        Intrinsics.checkNotNullParameter(r32, "data");
        Intrinsics.checkNotNullParameter(r28, "model");
        Intrinsics.checkNotNullParameter(r30, "sourceLanguageFallback");
        Intrinsics.checkNotNullParameter(r31, "targetLanguageFallback");
        if (r29.d != null) goto L148;
        r29.d = Boolean.valueOf(r28.m);
    L148:
        if (Intrinsics.areEqual(r29.d, Boolean.TRUE) == false) goto L236;
        RecordingSubtitleData.Subtitle r37 = r32.source;
        if (r37 == null) goto L153;
        String r38 = r37.language;
    L154:
        if (r38 != null) goto L157;
        r38 = "";
    L157:
        if (r38.length() != 0) goto L159;
        boolean r39 = true;
    L160:
        if (r39 == true) goto L163;
        r30 = r38;
    L163:
        RecordingSubtitleData.Subtitle r40 = r32.target;
        if (r40 == null) goto L166;
        String r41 = r40.language;
    L167:
        if (r41 != null) goto L170;
        r41 = r7;
    L170:
        if (r41.length() != 0) goto L172;
        boolean r42 = true;
    L173:
        if (r42 == true) goto L176;
        r31 = r41;
    L176:
        String r43 = r30 + "->" + r31;
        if (Intrinsics.areEqual(r43, r29.g) == true) goto L180;
        r29.h = false;
        r29.g = r43;
    L180:
        if (e.a(r30, r31) == false) goto L197;
        RecordingSubtitleData.Subtitle r44 = r32.source;
        if (r44 == null) goto L184;
        String r45 = r44.content;
    L185:
        if (r45 != null) goto L187;
        r45 = r7;
    L187:
        RecordingSubtitleData.Subtitle r1 = r32.target;
        if (r1 == null) goto L190;
        String r111 = r1.content;
    L191:
        if (r111 != null) goto L193;
        r111 = r7;
    L193:
        e.b(r28, r45, r111);
        if (r29.f == false) goto L236;
        r29.f = false;
        lvb.a.e(r29.b, "processSimilarity sameLang, sourceLang=" + r30 + ", targetLang=" + r31);
        goto L236
    L190:
        r111 = null;
        goto L191
    L184:
        r45 = null;
        goto L185
    L197:
        if (r29.c == false) goto L236;
        String r46 = r28.e;
        String r47 = r28.f;
        if (r46.length() != 0) goto L202;
        boolean r48 = true;
    L203:
        if (r48 == true) goto L236;
        if (r47.length() != 0) goto L207;
        boolean r49 = true;
    L208:
        if (r49 == true) goto L236;
        r28.o = true;
        int r50 = r47.length();
        int r112 = r29.j;
        if (r50 <= r112) goto L213;
        boolean r51 = true;
    L214:
        boolean r113 = r28.b;
        if (r29.h == false) goto L218;
        if (r113 == true) goto L218;
        r28.n = true;
    L218:
        if (r51 == true) goto L222;
        if (r113 == true) goto L222;
        boolean r52 = false;
    L224:
        if (r52 == false) goto L234;
        r29.e = true;
        float r53 = j.b(StringsKt.take(r46, r112), StringsKt.take(r47, r29.j));
        boolean r54 = r29.h;
        if (r53 <= r29.i) goto L228;
        r28.n = true;
        r29.h = true;
    L230:
        if (r54 == r29.h) goto L232;
        lvb.a.e(r29.b, "processSimilarity changed--- segId=" + r28.a + ", similarity=" + r53 + ", model=" + r28);
    L232:
        lvb.a.a(r29.b, "processSimilarity --- segId=" + r28.a + ", similarity=" + r53 + ", model=" + r28);
        goto L236
    L228:
        r29.h = false;
        goto L230
    L234:
        if (r29.e == false) goto L236;
        r29.e = false;
        lvb.a.a(r29.b, "processSimilarity, sourceLang=" + r30 + ", targetLang=" + r31 + ", model=" + r28);
    L222:
        r52 = true;
        goto L224
    L213:
        r51 = false;
        goto L214
    L207:
        r49 = false;
        goto L208
    L202:
        r48 = false;
        goto L203
    L172:
        r42 = false;
        goto L173
    L166:
        r41 = null;
        goto L167
    L159:
        r39 = false;
        goto L160
    L153:
        r38 = null;
    L236:
        return r28;
    L120:
        if (r11.length() == 0) goto L123;
        r17 = false;
    L126:
        if (r12 != null) goto L128;
    L131:
        boolean r55 = true;
    L132:
        if (r55 == true) goto L134;
        r18 = new Pair(r12, c(r12, ByteviewUser.ParticipantType.UNKNOW, MmSubtitleSpeakerType.SCD_SPEAKER, r14));
        goto L135
    L128:
        if (r12.length() == 0) goto L131;
        r55 = false;
        goto L132
    L114:
        r16 = false;
        goto L115
    L105:
        if (r9.getValue() != RecordingSubtitleData.SSDSpeaker.SSDSpeakerUserType.LARK_USER.getValue()) goto L107;
        r10 = true;
    L134:
        r18 = new Pair("-" + r32.seg_id, c("1", ByteviewUser.ParticipantType.UNKNOW, MmSubtitleSpeakerType.UNKNOWN, "unknown"));
        goto L135
    L99:
        r4 = System.currentTimeMillis();
        goto L100
    L95:
        r15 = false;
        goto L96
    L37:
        if (r35 != MmSubtitleSmoothType.SOURCE) goto L41;
        if (r36 == null) goto L47;
    L46:
        String r56 = r36;
    L49:
        if (r56.length() != 0) goto L51;
        boolean r57 = true;
    L52:
        if (r57 == true) goto L56;
        r6 = r56;
    L56:
        if (r6.length() != 0) goto L58;
        boolean r58 = true;
    L59:
        if (r58 == false) goto L67;
        RecordingSubtitleData.Subtitle r59 = r32.source;
        if (r59 == null) goto L63;
        r6 = r59.content;
    L64:
        if (r6 != null) goto L67;
        r6 = "";
        goto L67
    L63:
        r6 = null;
    L67:
        if (r6.length() != 0) goto L69;
        boolean r60 = true;
    L70:
        if (r60 == false) goto L80;
        if (a(r32) == false) goto L78;
        RecordingSubtitleData.Subtitle r61 = r32.target;
        if (r61 == null) goto L76;
        r6 = r61.content;
    L77:
        if (r6 != null) goto L80;
    L76:
        r6 = null;
    L78:
        r6 = "";
    L80:
        if (r6.length() != 0) goto L82;
        boolean r62 = true;
    L83:
        if (r62 == false) goto L90;
        if (r34 == null) goto L86;
        String r63 = r34.e;
    L87:
        if (r63 != null) goto L89;
        r63 = "";
    L89:
        r6 = r63;
        goto L90
    L86:
        r63 = null;
    L90:
        r20 = r6;
        r21 = r20;
        goto L92
    L82:
        r62 = false;
        goto L83
    L69:
        r60 = false;
        goto L70
    L58:
        r58 = false;
        goto L59
    L51:
        r57 = false;
    L47:
        r56 = "";
        goto L49
    L41:
        if (r35 != MmSubtitleSmoothType.TARGET) goto L47;
        if (a(r32) == false) goto L47;
        if (r36 != null) goto L46;
    L33:
        r8 = "";
        goto L35
    L29:
        r6 = r36;
        goto L30
    L9:
        if (r5 == 2) goto L20;
        RecordingSubtitleData.Subtitle r64 = r32.source;
        if (r64 == null) goto L14;
        r6 = r64.content;
        if (r6 == null) goto L14;
    L15:
        RecordingSubtitleData.Subtitle r65 = r32.target;
        if (r65 == null) goto L33;
        r8 = r65.content;
        if (r8 != null) goto L35;
    L14:
        r6 = "";
        goto L15
    L20:
        if (r34 == null) goto L23;
        r6 = r34.e;
        if (r6 == null) goto L23;
    L24:
        if (r36 == null) goto L33;
        r8 = r36;
    L23:
        r6 = "";
        goto L24
    L5:
        r5 = a.a[r35.ordinal()];
        goto L7
    }
}
