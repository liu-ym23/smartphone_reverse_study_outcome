package com.lynx.component.svg.parser;

import com.larus.voice_setting.voice.base.VoiceDisplayScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class PreserveAspectRatio {
    public static final PreserveAspectRatio c = null;
    public static final PreserveAspectRatio d = null;
    public final Alignment a;
    public final Scale b;

    public static final enum Alignment extends Enum<Alignment> {
        public static final /* synthetic */ Alignment[] a = null;
        public static final Alignment none = null;
        public static final Alignment xMaxYMax = null;
        public static final Alignment xMaxYMid = null;
        public static final Alignment xMaxYMin = null;
        public static final Alignment xMidYMax = null;
        public static final Alignment xMidYMid = null;
        public static final Alignment xMidYMin = null;
        public static final Alignment xMinYMax = null;
        public static final Alignment xMinYMid = null;
        public static final Alignment xMinYMin = null;

        static {
            Alignment r0 = new Alignment(VoiceDisplayScene.NONE, 0);
            none = r0;
            Alignment r1 = new Alignment("xMinYMin", 1);
            xMinYMin = r1;
            Alignment r3 = new Alignment("xMidYMin", 2);
            xMidYMin = r3;
            Alignment r5 = new Alignment("xMaxYMin", 3);
            xMaxYMin = r5;
            Alignment r7 = new Alignment("xMinYMid", 4);
            xMinYMid = r7;
            Alignment r9 = new Alignment("xMidYMid", 5);
            xMidYMid = r9;
            Alignment r11 = new Alignment("xMaxYMid", 6);
            xMaxYMid = r11;
            Alignment r13 = new Alignment("xMinYMax", 7);
            xMinYMax = r13;
            Alignment r15 = new Alignment("xMidYMax", 8);
            xMidYMax = r15;
            Alignment r14 = new Alignment("xMaxYMax", 9);
            xMaxYMax = r14;
            a = new Alignment[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        }

        public static Alignment[] values() {
            return (Alignment[]) a.clone();
        }

        public static Alignment valueOf(String r1) {
            return (Alignment) r27.a.a(Alignment.class, r1);
        }

        public Alignment(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum Scale extends Enum<Scale> {
        public static final /* synthetic */ Scale[] a = null;
        public static final Scale meet = null;
        public static final Scale slice = null;

        static {
            Scale r0 = new Scale("meet", 0);
            meet = r0;
            Scale r1 = new Scale("slice", 1);
            slice = r1;
            a = new Scale[]{r0, r1};
        }

        public static Scale[] values() {
            return (Scale[]) a.clone();
        }

        public static Scale valueOf(String r1) {
            return (Scale) r27.a.a(Scale.class, r1);
        }

        public Scale(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        c = new PreserveAspectRatio(Alignment.none, null);
        d = new PreserveAspectRatio(Alignment.xMidYMid, Scale.meet);
        Alignment r0 = Alignment.none;
        Alignment r1 = Alignment.none;
        Alignment r2 = Alignment.none;
        Alignment r3 = Alignment.none;
        Scale r4 = Scale.meet;
    }

    public final String toString() {
        return this.a + " " + this.b;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (PreserveAspectRatio.class == r5.getClass()) goto L11;
        return false;
    L11:
        PreserveAspectRatio r6 = (PreserveAspectRatio) r5;
        if (this.a == r6.a) goto L14;
    L16:
        return false;
    L14:
        if (this.b != r6.b) goto L16;
        return true;
    }

    public PreserveAspectRatio(Alignment r1, Scale r2) {
        this.a = r1;
        this.b = r2;
    }
}
