package rvb;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmSubtitleAsrOptConfig;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.helper.MmSubtitleSmoothType;
import com.ss.android.lark.pb.minutes.v1.RecordingSubtitleData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b extends Handler {
    public final /* synthetic */ a a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.util.ArrayList] */
    @Override // android.os.Handler
    public final void handleMessage(Message r18) {
        Intrinsics.checkNotNullParameter(r18, "msg");
        if (r18.what != 1) goto L145;
        a r1 = this.a;
        if (r1.d.isEmpty() == false) goto L7;
        r1.h.set(false);
    L120:
        if (this.a.h.get() == false) goto L146;
        a r2 = this.a;
        Handler r3 = r2.g;
        if (r3 == null) goto L147;
        r3.sendEmptyMessageDelayed(1, r2.j);
        return;
    L147:
        return;
    L146:
        return;
    L7:
        Iterator<Map.Entry<Long, a.d>> r4 = r1.d.entrySet().iterator();
    L9:
        if (r4.hasNext() == false) goto L120;
        Map.Entry<Long, a.d> r5 = r4.next();
        a.d r6 = r5.getValue();
        RecordingSubtitleData r7 = r6.a;
        MmSubtitleSmoothType r8 = r1.a;
        MmSubtitleSmoothType r9 = MmSubtitleSmoothType.TARGET;
        if (r8 != r9) goto L13;
        RecordingSubtitleData.Subtitle r10 = r7.target;
    L14:
        if (r10 == null) goto L17;
        String r11 = r10.content;
        if (r11 == null) goto L17;
    L18:
        if (r8 != r9) goto L20;
        RecordingSubtitleData.Subtitle r12 = r7.target;
    L21:
        if (r12 == null) goto L35;
        RecordingSubtitleData.Subtitle.Punctuation r13 = r12.punctuation;
        if (r13 == null) goto L35;
        List<Long> r14 = r13.word_ends;
        if (r14 == null) goto L35;
        ?? r15 = new ArrayList();
        Iterator r16 = r14.iterator();
    L28:
        if (r16.hasNext() == false) goto L36;
        Long r17 = (Long) r16.next();
        if (r17 == null) goto L32;
        Integer r19 = Integer.valueOf((int) r17.longValue());
    L33:
        if (r19 == null) goto L28;
        r15.add(r19);
        goto L28
    L32:
        r19 = null;
    L36:
        RecordingSubtitleData.SSDSpeaker r20 = r7.ssd_speaker;
        if (r20 == null) goto L40;
        String r110 = r20.speaker_user_id;
        if (r110 == null) goto L40;
    L45:
        int r21 = r6.b;
        RecordingSubtitleData r111 = r6.a;
        Boolean r112 = r111.is_seg_final;
        if (r112 == null) goto L48;
        boolean r113 = r112.booleanValue();
    L50:
        if (r21 != (-1)) goto L52;
    L105:
        Object r22 = new a.b.c(r11.length());
    L107:
        if (Intrinsics.areEqual(r22, a.b.C0187a.a) == true) goto L108;
        if ((r22 instanceof a.b.c) == true) goto L111;
        if (Intrinsics.areEqual(r22, a.b.C0188b.a) == true) goto L9;
        throw new NoWhenBranchMatchedException();
    L111:
        a.b.c r23 = (a.b.c) r22;
        int r24 = r23.a;
        if (r24 == r6.b) goto L9;
        r1.c(r7, r11.substring(0, r24));
        int r25 = r23.a;
        RecordingSubtitleData r26 = r6.a;
        Intrinsics.checkNotNullParameter(r26, "data");
        r5.setValue(new a.d(r26, r25));
        goto L9
    L108:
        r4.remove();
        r1.c(r7, r11);
        goto L9
    L52:
        if (r21 > r11.length()) goto L105;
        if (r21 != r11.length()) goto L74;
        if (r113 == true) goto L73;
        MmSubtitleAsrOptConfig r27 = r1.k;
        if (r27 != null) goto L60;
    L62:
        boolean r28 = false;
    L63:
        if (r28 == true) goto L65;
    L69:
        boolean r29 = false;
    L70:
        if (r29 == true) goto L73;
        r22 = a.b.C0188b.a;
        goto L107
    L65:
        if (r111.sound_type != RecordingSubtitleData.SoundType.NOISE) goto L67;
    L68:
        r29 = true;
        goto L70
    L67:
        if (TextUtils.isEmpty(r11) == false) goto L69;
    L60:
        if (r27.getEnabled() != true) goto L62;
        r28 = true;
    L73:
        r22 = a.b.C0187a.a;
        goto L107
    L74:
        Long r114 = r1.f.get(r110);
        if (r114 == null) goto L79;
        a.d r30 = r1.d.get(Long.valueOf(r114.longValue()));
        if (r30 == null) goto L79;
        RecordingSubtitleData r31 = r30.a;
    L80:
        MmSubtitleAsrOptConfig r115 = r1.k;
        if (r115 != null) goto L83;
    L85:
        boolean r116 = false;
    L86:
        if (r116 == false) goto L98;
        if (r114 == null) goto L98;
        long r117 = r114.longValue();
        Long r118 = r111.seg_id;
        if (r118 == null) goto L91;
        long r119 = r118.longValue();
    L93:
        if (r117 >= r119) goto L98;
        if (r31 == null) goto L98;
        if (Intrinsics.areEqual(r31.is_seg_final, Boolean.TRUE) == true) goto L98;
        r22 = new a.b.c(r11.length());
        goto L107
    L91:
        r119 = 0;
    L98:
        Iterator r32 = r15.iterator();
    L100:
        if (r32.hasNext() == false) goto L104;
        int r120 = ((Number) r32.next()).intValue();
        if (r120 <= r21) goto L100;
        r22 = new a.b.c(r120);
        goto L107
    L104:
        r22 = new a.b.c(r11.length());
        goto L107
    L83:
        if (r115.getEnabled() != true) goto L85;
        r116 = true;
    L79:
        r31 = null;
        goto L80
    L48:
        r113 = false;
    L40:
        if (r20 == null) goto L42;
        r110 = r20.user_id;
    L43:
        if (r110 != null) goto L45;
        r110 = "1";
        goto L45
    L42:
        r110 = null;
    L35:
        r15 = CollectionsKt.emptyList();
        goto L36
    L20:
        r12 = r7.source;
    L17:
        r11 = "";
        goto L18
    L13:
        r10 = r7.source;
        goto L14
    }

    public b(a r1, Looper r2) {
        this.a = r1;
        super(r2);
    }
}
