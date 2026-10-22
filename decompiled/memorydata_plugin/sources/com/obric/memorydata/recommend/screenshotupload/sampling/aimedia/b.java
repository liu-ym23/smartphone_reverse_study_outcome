package com.obric.memorydata.recommend.screenshotupload.sampling.aimedia;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\nH\u0002J\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\nH\u0002¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaCodecLifecycleEventParser;", "", "<init>", "()V", "parse", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaCodecLifecycleEvent;", "event", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaEventEnvelopeDto;", "asString", "", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaEventFieldDto;", "asLong", "", "(Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaEventFieldDto;)Ljava/lang/Long;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12565a = null;

    static {
        f12565a = new b();
    }

    private b() {
    }

    private final String a(e r3) {
        if (r3.b() == 4) goto L5;
        return null;
    L5:
        String r2 = r3.c();
        if (r2 != null) goto L8;
        return null;
    L8:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        return null;
    L10:
        return r2;
    }

    private final Long b(e r2) {
        if (r2.b() == 2) goto L7;
        return null;
    L7:
        return Long.valueOf(r2.d());
    }

    public final a a(d r23) {
        Intrinsics.checkNotNullParameter(r23, "event");
        a r3 = null;
        if (Intrinsics.areEqual(r23.a(), "codec") == true) goto L5;
        return null;
    L5:
        Iterator<e> r1 = r23.e().iterator();
        Long r4 = null;
        Long r5 = null;
        String r6 = null;
        String r14 = null;
        Long r15 = null;
        Long r16 = null;
        Long r17 = null;
        Long r18 = null;
        String r19 = null;
    L7:
        if (r1.hasNext() == false) goto L55;
        e r7 = (e) ZeusTransformUtils.preCheckCast(r1.next(), e.class, "com.obric.memorydata.plugin");
        String r8 = r7.a();
        switch(r8.hashCode()) {
            case -1821129979: goto L51;
            case -1658457926: goto L47;
            case -1607367396: goto L42;
            case -324368021: goto L37;
            case -270583694: goto L32;
            case 3351604: goto L27;
            case 1171617731: goto L22;
            case 1388977410: goto L17;
            case 1721557493: goto L12;
            default: goto L7;
        };
    L12:
        if (r8.equals("use_surface") == false) goto L7;
        if (r5 != null) goto L7;
        r5 = b(r7);
        goto L7
    L17:
        if (r8.equals("video_width") == false) goto L7;
        if (r15 != null) goto L7;
        r15 = b(r7);
        goto L7
    L22:
        if (r8.equals("stall_reason") == false) goto L7;
        if (r19 != null) goto L7;
        r19 = a(r7);
        goto L7
    L27:
        if (r8.equals("mime") == false) goto L7;
        if (r14 != null) goto L7;
        r14 = a(r7);
        goto L7
    L32:
        if (r8.equals("frame_rate") == false) goto L7;
        if (r17 != null) goto L7;
        r17 = b(r7);
        goto L7
    L37:
        if (r8.equals("video_height") == false) goto L7;
        if (r16 != null) goto L7;
        r16 = b(r7);
        goto L7
    L42:
        if (r8.equals("encoder") == false) goto L7;
        if (r4 != null) goto L7;
        r4 = b(r7);
        goto L7
    L47:
        if (r8.equals("key_event") == false) goto L7;
        if (r6 != null) goto L7;
        r6 = a(r7);
        goto L7
    L51:
        if (r8.equals("source_duration_us") == false) goto L7;
        if (r18 != null) goto L7;
        r18 = b(r7);
        goto L7
    L55:
        if (r6 != null) goto L58;
        return null;
    L58:
        switch(r6.hashCode()) {
            case -1930447965: goto L76;
            case -1686561338: goto L72;
            case -1625129743: goto L69;
            case -747124558: goto L65;
            case -743807202: goto L61;
            default: goto L110;
        };
    L110:
        return r3;
    L61:
        if (r6.equals("media_codec_start") == false) goto L110;
        AIMediaCodecLifecycleKind r0 = AIMediaCodecLifecycleKind.START;
    L80:
        if (r14 != null) goto L82;
    L84:
        boolean r9 = false;
    L85:
        if (r9 == false) goto L87;
    L95:
        boolean r11 = true;
    L96:
        long r10 = r23.b();
        String r12 = r23.c();
        String r2 = r23.d();
        if (r4 != null) goto L100;
    L102:
        boolean r20 = false;
    L103:
        if (r5 != null) goto L106;
    L108:
        boolean r13 = false;
    L109:
        r3 = new a(r0, r6, r10, r12, r2, r11, r20, r13, r14, r15, r16, r17, r18, r19);
        goto L110
    L106:
        if (r5.longValue() != 1) goto L108;
        r13 = true;
        goto L109
    L100:
        if (r4.longValue() != 1) goto L102;
        r20 = true;
        goto L103
    L87:
        if (r15 != null) goto L89;
    L90:
        if (r16 != null) goto L92;
    L94:
        r11 = false;
        goto L96
    L92:
        if (r16.longValue() <= 0) goto L94;
    L89:
        if (r15.longValue() > 0) goto L95;
    L82:
        if (StringsKt.startsWith$default(r14, "video/", false, 2, null) != true) goto L84;
        r9 = true;
        goto L85
    L65:
        if (r6.equals("media_codec_pause") == false) goto L110;
        r0 = AIMediaCodecLifecycleKind.PAUSE;
        goto L80
    L69:
        if (r6.equals("media_codec_resume") == false) goto L110;
    L78:
        r0 = AIMediaCodecLifecycleKind.RESUME;
        goto L80
    L72:
        if (r6.equals("media_codec_stop") == false) goto L110;
        r0 = AIMediaCodecLifecycleKind.STOP;
        goto L80
    L76:
        if (r6.equals("media_codec_fps_update") == true) goto L78;
        goto L78
    }
}
