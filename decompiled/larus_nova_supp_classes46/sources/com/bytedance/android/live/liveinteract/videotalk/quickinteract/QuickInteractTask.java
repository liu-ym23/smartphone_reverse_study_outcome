package com.bytedance.android.live.liveinteract.videotalk.quickinteract;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.l;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.livesdkapi.message.Text;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class QuickInteractTask {
    public static final /* synthetic */ int n = 0;
    public final String a;
    public final String b;
    public long c;
    public final String d;
    public final k e;
    public CharSequence f;
    public final int g;
    public final Source h;
    public final boolean i;
    public final Text j;
    public final String k;
    public final Integer l;
    public final l m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/QuickInteractTask$Source;", "", "Native", "Dynamic", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Source extends Enum<Source> {
        public static final Source Dynamic = null;
        public static final Source Native = null;
        public static final /* synthetic */ Source[] a = null;

        static {
            Source r1 = new Source("Native", 0);
            Native = r1;
            Source r2 = new Source("Dynamic", 1);
            Dynamic = r2;
            a = new Source[]{r1, r2};
        }

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }

        public static Source[] values() {
            return (Source[]) a.clone();
        }

        public Source(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        @JvmStatic
        public static QuickInteractTask a(String r3, l r4) {
            Intrinsics.checkNotNullParameter(r3, "score");
            Intrinsics.checkNotNullParameter(r4, "quickInteract");
            return new QuickInteractTask(je0.d.b0(), ThemedCompetitionContext.Companion.a(r3), 4, r4);
        }
    }

    static {
    }

    public QuickInteractTask() {
        this(null, null, 0, null, null, null, 0, null, false, null, null, null, null, 8191);
    }

    public final String toString() {
        return "score: " + this.b + ", receive from: " + this.a + ", duration: " + this.c + ", send from " + this.d + ", content: " + this.f + ", type = " + this.g;
    }

    public final int getType() {
        return this.g;
    }

    public /* synthetic */ QuickInteractTask(String r7, String r8, int r9, l r10) {
        this(r7, r8, r9, r10, Source.Native);
    }

    public QuickInteractTask(String r17, String r18, int r19, l r20, Source r21) {
        Intrinsics.checkNotNullParameter(r17, "usedID");
        Intrinsics.checkNotNullParameter(r18, "score");
        Intrinsics.checkNotNullParameter(r21, "source");
        if (r20 == null) goto L5;
        long r3 = r20.getInteractCarouselDuration();
    L7:
        if (r20 == null) goto L12;
        IBaseUser r5 = r20.getSendGiftUser();
        if (r5 == null) goto L12;
        String r6 = r5.getIdString();
        if (r6 == null) goto L12;
    L14:
        if (r20 == null) goto L18;
        IBaseUser r7 = r20.getSendGiftUser();
        if (r7 == null) goto L18;
        k r8 = r7.getAvatarThumbKt();
    L19:
        if (r20 == null) goto L22;
        CharSequence r9 = r20.getInteractContent();
        if (r9 == null) goto L22;
    L24:
        if (r20 == null) goto L26;
        Text r11 = r20.getText();
    L27:
        if (r20 == null) goto L29;
        String r12 = r20.getSchema();
    L30:
        if (r20 == null) goto L32;
        Integer r13 = Integer.valueOf(r20.getInteractType());
    L33:
        this(r17, r18, r3, r6, r8, r9, r19, r21, false, r11, r12, r13, r20, 256);
        return;
    L32:
        r13 = null;
        goto L33
    L29:
        r12 = null;
        goto L30
    L26:
        r11 = null;
    L22:
        r9 = "";
    L18:
        r8 = null;
    L12:
        r6 = "";
        goto L14
    L5:
        r3 = 0;
        goto L7
    }

    public QuickInteractTask(String r17, String r18, long r19, String r21, k r22, CharSequence r23, int r24, Source r25, boolean r26, Text r27, String r28, Integer r29, l r30, int r31) {
        String r3 = "";
        if ((r31 & 1) == 0) goto L5;
        String r2 = "";
    L7:
        if ((r31 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r31 & 4) == 0) goto L13;
        long r5 = 0;
    L15:
        if ((r31 & 8) != 0) goto L18;
        r3 = r21;
    L18:
        l r8 = null;
        if ((r31 & 16) == 0) goto L21;
        k r7 = null;
    L23:
        if ((r31 & 32) == 0) goto L25;
        CharSequence r9 = "感谢TA";
    L26:
        boolean r11 = false;
        if ((r31 & 64) == 0) goto L29;
        int r10 = 0;
    L31:
        if ((r31 & 128) == 0) goto L33;
        Source r12 = Source.Native;
    L35:
        if ((r31 & 256) != 0) goto L39;
        r11 = r26;
    L39:
        if ((r31 & 512) == 0) goto L41;
        Text r13 = null;
    L43:
        if ((r31 & 1024) == 0) goto L45;
        String r14 = null;
    L47:
        if ((r31 & 2048) == 0) goto L49;
        Integer r15 = -1;
    L51:
        if ((r31 & 4096) != 0) goto L54;
        r8 = r30;
    L54:
        Intrinsics.checkNotNullParameter(r2, "receiveGiftUserID");
        Intrinsics.checkNotNullParameter(r4, "score");
        Intrinsics.checkNotNullParameter(r3, "sendGiftUserID");
        Intrinsics.checkNotNullParameter(r9, "quickInteractContent");
        Intrinsics.checkNotNullParameter(r12, "source");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r3;
        this.e = r7;
        this.f = r9;
        this.g = r10;
        this.h = r12;
        this.i = r11;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r8;
        return;
    L49:
        r15 = r29;
        goto L51
    L45:
        r14 = r28;
        goto L47
    L41:
        r13 = r27;
        goto L43
    L33:
        r12 = r25;
        goto L35
    L29:
        r10 = r24;
        goto L31
    L25:
        r9 = r23;
        goto L26
    L21:
        r7 = r22;
        goto L23
    L13:
        r5 = r19;
        goto L15
    L9:
        r4 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }
}
