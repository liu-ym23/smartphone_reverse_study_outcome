package com.larus.business.floatchat.api;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class AIChatInputConfig {
    public static final List<PlusAction> m = null;
    public final int a;
    public final String b;
    public final String c;
    public final int d;
    public final Map<String, String> e;
    public final boolean f;
    public final List<PlusAction> g;
    public final boolean h;
    public final boolean i;
    public final int j;
    public final Integer k;
    public final Boolean l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/business/floatchat/api/AIChatInputConfig$PlusAction;", "", "<init>", "(Ljava/lang/String;I)V", "CAMERA", "ALBUM", "FILE", "VOICE_CALL", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PlusAction extends Enum<PlusAction> {
        public static final PlusAction ALBUM = null;
        public static final PlusAction CAMERA = null;
        public static final PlusAction FILE = null;
        public static final PlusAction VOICE_CALL = null;
        public static final /* synthetic */ PlusAction[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PlusAction> getEntries() {
            return b;
        }

        static {
            PlusAction r0 = new PlusAction("CAMERA", 0);
            CAMERA = r0;
            PlusAction r1 = new PlusAction("ALBUM", 1);
            ALBUM = r1;
            PlusAction r3 = new PlusAction("FILE", 2);
            FILE = r3;
            PlusAction r5 = new PlusAction("VOICE_CALL", 3);
            VOICE_CALL = r5;
            PlusAction[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static PlusAction[] values() {
            return (PlusAction[]) a.clone();
        }

        public static PlusAction valueOf(String r1) {
            return (PlusAction) r27.a.a(PlusAction.class, r1);
        }

        public PlusAction(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public AIChatInputConfig() {
        this(0, null, 0, false, null, 0, null, 4095);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AIChatInputConfig) == true) goto L8;
        return false;
    L8:
        AIChatInputConfig r6 = (AIChatInputConfig) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.d) * 31;
        Map<String, String> r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        int r11 = 1231;
        if (this.f == false) goto L17;
        int r12 = 1231;
    L18:
        int r13 = (((r10 + r12) * 31) + this.g.hashCode()) * 31;
        if (this.h == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (r13 + r14) * 31;
        if (this.i == true) goto L26;
        r11 = 1237;
    L26:
        int r16 = (((r15 + r11) * 31) + this.j) * 31;
        Integer r17 = this.k;
        if (r17 != null) goto L29;
        int r18 = 0;
    L30:
        int r19 = (r16 + r18) * 31;
        Boolean r20 = this.l;
        if (r20 == null) goto L35;
        r2 = r20.hashCode();
    L35:
        return r19 + r2;
    L29:
        r18 = r17.hashCode();
        goto L30
    L21:
        r14 = 1237;
        goto L22
    L17:
        r12 = 1237;
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "AIChatInputConfig(defaultInputMode=" + this.a + ", hint=" + this.b + ", speakHint=" + this.c + ", indicateActionEntrance=" + this.d + ", actionEntranceConfig=" + this.e + ", showPlusMenu=" + this.f + ", plusActions=" + this.g + ", enableActionBar=" + this.h + ", useAlphaStyle=" + this.i + ", colorMode=" + this.j + ", answerIntentLogic=" + this.k + ", userPromptHoverEverytimeOverride=" + this.l + ')';
    }

    static {
        m = CollectionsKt.listOf(new PlusAction[]{PlusAction.CAMERA, PlusAction.ALBUM, PlusAction.FILE, PlusAction.VOICE_CALL});
    }

    public static AIChatInputConfig a(AIChatInputConfig r17, String r18, String r19, int r20, boolean r21, List r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        int r5 = r17.a;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r6 = r17.b;
    L11:
        if ((r23 & 4) == 0) goto L13;
        String r7 = r17.c;
    L15:
        if ((r23 & 8) == 0) goto L17;
        int r8 = r17.d;
    L19:
        if ((r23 & 16) == 0) goto L21;
        Map<String, String> r9 = r17.e;
    L23:
        if ((r23 & 32) == 0) goto L25;
        boolean r10 = r17.f;
    L27:
        if ((r23 & 64) == 0) goto L29;
        List r11 = r17.g;
    L31:
        if ((r23 & 128) == 0) goto L33;
        boolean r12 = r17.h;
    L35:
        if ((r23 & 256) == 0) goto L37;
        boolean r13 = r17.i;
    L39:
        if ((r23 & 512) == 0) goto L41;
        int r14 = r17.j;
    L43:
        if ((r23 & 1024) == 0) goto L45;
        Integer r15 = r17.k;
    L47:
        if ((r23 & 2048) == 0) goto L49;
        Boolean r16 = r17.l;
    L50:
        r17.getClass();
        Intrinsics.checkNotNullParameter(r11, "plusActions");
        return new AIChatInputConfig(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L49:
        r16 = null;
        goto L50
    L45:
        r15 = null;
        goto L47
    L41:
        r14 = 0;
        goto L43
    L37:
        r13 = false;
        goto L39
    L33:
        r12 = false;
        goto L35
    L29:
        r11 = r22;
        goto L31
    L25:
        r10 = r21;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = r20;
        goto L19
    L13:
        r7 = r19;
        goto L15
    L9:
        r6 = r18;
        goto L11
    L5:
        r5 = 0;
        goto L7
    }

    public /* synthetic */ AIChatInputConfig(int r17, String r18, int r19, boolean r20, List r21, int r22, Boolean r23, int r24) {
        if ((r24 & 1) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r24 & 8) == 0) goto L13;
        int r1 = 1;
    L15:
        if ((r24 & 32) == 0) goto L17;
        boolean r9 = true;
    L19:
        if ((r24 & 64) == 0) goto L21;
        List r10 = m;
    L23:
        if ((r24 & 512) == 0) goto L25;
        int r13 = 0;
    L27:
        if ((r24 & 2048) == 0) goto L29;
        Boolean r15 = null;
    L30:
        this(r4, r5, null, r1, null, r9, r10, false, false, r13, null, r15);
        return;
    L29:
        r15 = r23;
        goto L30
    L25:
        r13 = r22;
        goto L27
    L21:
        r10 = r21;
        goto L23
    L17:
        r9 = r20;
        goto L19
    L13:
        r1 = r19;
        goto L15
    L9:
        r5 = r18;
        goto L11
    L5:
        r4 = r17;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AIChatInputConfig(int r2, String r3, String r4, int r5, Map<String, String> r6, boolean r7, List<? extends PlusAction> r8, boolean r9, boolean r10, int r11, Integer r12, Boolean r13) {
        Intrinsics.checkNotNullParameter(r8, "plusActions");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }
}
