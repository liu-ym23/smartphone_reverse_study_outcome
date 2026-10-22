package org.apache.poi.sl.draw.geom;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.Rectangle2D;

/* JADX INFO: loaded from: classes7.dex */
final enum BuiltInGuide extends Enum<BuiltInGuide> {
    private static final /* synthetic */ BuiltInGuide[] $VALUES = null;
    public static final BuiltInGuide _3cd4 = null;
    public static final BuiltInGuide _3cd8 = null;
    public static final BuiltInGuide _5cd8 = null;
    public static final BuiltInGuide _7cd8 = null;
    public static final BuiltInGuide _b = null;
    public static final BuiltInGuide _cd2 = null;
    public static final BuiltInGuide _cd4 = null;
    public static final BuiltInGuide _cd8 = null;
    public static final BuiltInGuide _h = null;
    public static final BuiltInGuide _hc = null;
    public static final BuiltInGuide _hd2 = null;
    public static final BuiltInGuide _hd3 = null;
    public static final BuiltInGuide _hd4 = null;
    public static final BuiltInGuide _hd5 = null;
    public static final BuiltInGuide _hd6 = null;
    public static final BuiltInGuide _hd8 = null;
    public static final BuiltInGuide _l = null;
    public static final BuiltInGuide _ls = null;
    public static final BuiltInGuide _r = null;
    public static final BuiltInGuide _ss = null;
    public static final BuiltInGuide _ssd16 = null;
    public static final BuiltInGuide _ssd2 = null;
    public static final BuiltInGuide _ssd32 = null;
    public static final BuiltInGuide _ssd4 = null;
    public static final BuiltInGuide _ssd6 = null;
    public static final BuiltInGuide _ssd8 = null;
    public static final BuiltInGuide _t = null;
    public static final BuiltInGuide _vc = null;
    public static final BuiltInGuide _w = null;
    public static final BuiltInGuide _wd10 = null;
    public static final BuiltInGuide _wd2 = null;
    public static final BuiltInGuide _wd3 = null;
    public static final BuiltInGuide _wd32 = null;
    public static final BuiltInGuide _wd4 = null;
    public static final BuiltInGuide _wd5 = null;
    public static final BuiltInGuide _wd6 = null;
    public static final BuiltInGuide _wd8 = null;

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.geom.BuiltInGuide$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide = null;

        static {
            int[] r0 = new int[BuiltInGuide.values().length];
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide = r0;
            r0[BuiltInGuide._3cd4.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L100:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._3cd8.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L122:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._5cd8.ordinal()] = 3;     // Catch: NoSuchFieldError -> L43
        L132:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._7cd8.ordinal()] = 4;     // Catch: NoSuchFieldError -> L44
        L138:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._t.ordinal()] = 5;     // Catch: NoSuchFieldError -> L45
        L84:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._b.ordinal()] = 6;     // Catch: NoSuchFieldError -> L46
        L88:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._l.ordinal()] = 7;     // Catch: NoSuchFieldError -> L47
        L112:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._r.ordinal()] = 8;     // Catch: NoSuchFieldError -> L48
        L116:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._cd2.ordinal()] = 9;     // Catch: NoSuchFieldError -> L49
        L142:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._cd4.ordinal()] = 10;     // Catch: NoSuchFieldError -> L50
        L146:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._cd8.ordinal()] = 11;     // Catch: NoSuchFieldError -> L51
        L92:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._hc.ordinal()] = 12;     // Catch: NoSuchFieldError -> L52
        L98:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._h.ordinal()] = 13;     // Catch: NoSuchFieldError -> L53
        L120:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._hd2.ordinal()] = 14;     // Catch: NoSuchFieldError -> L54
        L126:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._hd3.ordinal()] = 15;     // Catch: NoSuchFieldError -> L55
        L150:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._hd4.ordinal()] = 16;     // Catch: NoSuchFieldError -> L56
        L80:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._hd5.ordinal()] = 17;     // Catch: NoSuchFieldError -> L57
        L104:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._hd6.ordinal()] = 18;     // Catch: NoSuchFieldError -> L58
        L108:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._hd8.ordinal()] = 19;     // Catch: NoSuchFieldError -> L59
        L130:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._ls.ordinal()] = 20;     // Catch: NoSuchFieldError -> L60
        L136:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._ss.ordinal()] = 21;     // Catch: NoSuchFieldError -> L61
        L82:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._ssd2.ordinal()] = 22;     // Catch: NoSuchFieldError -> L62
        L86:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._ssd4.ordinal()] = 23;     // Catch: NoSuchFieldError -> L63
        L110:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._ssd6.ordinal()] = 24;     // Catch: NoSuchFieldError -> L64
        L114:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._ssd8.ordinal()] = 25;     // Catch: NoSuchFieldError -> L65
        L140:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._ssd16.ordinal()] = 26;     // Catch: NoSuchFieldError -> L66
        L144:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._ssd32.ordinal()] = 27;     // Catch: NoSuchFieldError -> L67
        L90:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._vc.ordinal()] = 28;     // Catch: NoSuchFieldError -> L68
        L96:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._w.ordinal()] = 29;     // Catch: NoSuchFieldError -> L69
        L118:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._wd2.ordinal()] = 30;     // Catch: NoSuchFieldError -> L70
        L124:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._wd3.ordinal()] = 31;     // Catch: NoSuchFieldError -> L71
        L148:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._wd4.ordinal()] = 32;     // Catch: NoSuchFieldError -> L72
        L78:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._wd5.ordinal()] = 33;     // Catch: NoSuchFieldError -> L73
        L102:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._wd6.ordinal()] = 34;     // Catch: NoSuchFieldError -> L74
        L106:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._wd8.ordinal()] = 35;     // Catch: NoSuchFieldError -> L75
        L128:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._wd10.ordinal()] = 36;     // Catch: NoSuchFieldError -> L76
        L134:
            $SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[BuiltInGuide._wd32.ordinal()] = 37;     // Catch: NoSuchFieldError -> L77
            return;
        }
    }

    static {
        BuiltInGuide r0 = new BuiltInGuide("_3cd4", 0);
        _3cd4 = r0;
        BuiltInGuide r1 = new BuiltInGuide("_3cd8", 1);
        _3cd8 = r1;
        BuiltInGuide r3 = new BuiltInGuide("_5cd8", 2);
        _5cd8 = r3;
        BuiltInGuide r5 = new BuiltInGuide("_7cd8", 3);
        _7cd8 = r5;
        BuiltInGuide r7 = new BuiltInGuide("_b", 4);
        _b = r7;
        BuiltInGuide r9 = new BuiltInGuide("_cd2", 5);
        _cd2 = r9;
        BuiltInGuide r11 = new BuiltInGuide("_cd4", 6);
        _cd4 = r11;
        BuiltInGuide r13 = new BuiltInGuide("_cd8", 7);
        _cd8 = r13;
        BuiltInGuide r15 = new BuiltInGuide("_hc", 8);
        _hc = r15;
        BuiltInGuide r14 = new BuiltInGuide("_h", 9);
        _h = r14;
        BuiltInGuide r12 = new BuiltInGuide("_hd2", 10);
        _hd2 = r12;
        BuiltInGuide r10 = new BuiltInGuide("_hd3", 11);
        _hd3 = r10;
        BuiltInGuide r8 = new BuiltInGuide("_hd4", 12);
        _hd4 = r8;
        BuiltInGuide r6 = new BuiltInGuide("_hd5", 13);
        _hd5 = r6;
        BuiltInGuide r4 = new BuiltInGuide("_hd6", 14);
        _hd6 = r4;
        BuiltInGuide r2 = new BuiltInGuide("_hd8", 15);
        _hd8 = r2;
        BuiltInGuide r16 = new BuiltInGuide("_l", 16);
        _l = r16;
        BuiltInGuide r17 = new BuiltInGuide("_ls", 17);
        _ls = r17;
        BuiltInGuide r18 = new BuiltInGuide("_r", 18);
        _r = r18;
        BuiltInGuide r19 = new BuiltInGuide("_ss", 19);
        _ss = r19;
        BuiltInGuide r20 = new BuiltInGuide("_ssd2", 20);
        _ssd2 = r20;
        BuiltInGuide r21 = new BuiltInGuide("_ssd4", 21);
        _ssd4 = r21;
        BuiltInGuide r22 = new BuiltInGuide("_ssd6", 22);
        _ssd6 = r22;
        BuiltInGuide r23 = new BuiltInGuide("_ssd8", 23);
        _ssd8 = r23;
        BuiltInGuide r24 = new BuiltInGuide("_ssd16", 24);
        _ssd16 = r24;
        BuiltInGuide r25 = new BuiltInGuide("_ssd32", 25);
        _ssd32 = r25;
        BuiltInGuide r26 = new BuiltInGuide("_t", 26);
        _t = r26;
        BuiltInGuide r27 = new BuiltInGuide("_vc", 27);
        _vc = r27;
        BuiltInGuide r28 = new BuiltInGuide("_w", 28);
        _w = r28;
        BuiltInGuide r29 = new BuiltInGuide("_wd2", 29);
        _wd2 = r29;
        BuiltInGuide r30 = new BuiltInGuide("_wd3", 30);
        _wd3 = r30;
        BuiltInGuide r31 = new BuiltInGuide("_wd4", 31);
        _wd4 = r31;
        BuiltInGuide r32 = new BuiltInGuide("_wd5", 32);
        _wd5 = r32;
        BuiltInGuide r33 = new BuiltInGuide("_wd6", 33);
        _wd6 = r33;
        BuiltInGuide r34 = new BuiltInGuide("_wd8", 34);
        _wd8 = r34;
        BuiltInGuide r35 = new BuiltInGuide("_wd10", 35);
        _wd10 = r35;
        BuiltInGuide r36 = new BuiltInGuide("_wd32", 36);
        _wd32 = r36;
        $VALUES = new BuiltInGuide[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36};
    }

    private BuiltInGuide(String r1, int r2) {
        super(r1, r2);
    }

    public static BuiltInGuide valueOf(String r2) {
        return (BuiltInGuide) ZeusTransformUtils.preCheckCast(Enum.valueOf(BuiltInGuide.class, r2), BuiltInGuide.class, "com.obric.memorydata.plugin");
    }

    public static BuiltInGuide[] values() {
        return (BuiltInGuide[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BuiltInGuide[].class, "com.obric.memorydata.plugin");
    }

    public double evaluate(Context r23) {
        Rectangle2D r0 = r23.getShapeAnchor();
        double r1 = r0.getHeight();
        double r3 = r0.getWidth();
        double r5 = Math.min(r3, r1);
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$sl$draw$geom$BuiltInGuide[ordinal()]) {
            case 1: goto L72;
            case 2: goto L70;
            case 3: goto L68;
            case 4: goto L66;
            case 5: goto L65;
            case 6: goto L63;
            case 7: goto L61;
            case 8: goto L59;
            case 9: goto L56;
            case 10: goto L54;
            case 11: goto L52;
            case 12: goto L51;
            case 13: goto L76;
            case 14: goto L49;
            case 15: goto L47;
            case 16: goto L45;
            case 17: goto L43;
            case 18: goto L41;
            case 19: goto L39;
            case 20: goto L37;
            case 21: goto L75;
            case 22: goto L35;
            case 23: goto L33;
            case 24: goto L31;
            case 25: goto L29;
            case 26: goto L27;
            case 27: goto L25;
            case 28: goto L23;
            case 29: goto L74;
            case 30: goto L21;
            case 31: goto L19;
            case 32: goto L17;
            case 33: goto L15;
            case 34: goto L13;
            case 35: goto L11;
            case 36: goto L9;
            case 37: goto L7;
            default: goto L4;
        };
    L4:
        return 0.0d;
    L52:
        return 2700000.0d;
    L54:
        return 5400000.0d;
    L56:
        return 1.08E7d;
    L66:
        return 1.89E7d;
    L68:
        return 1.35E7d;
    L70:
        return 8100000.0d;
    L72:
        return 1.62E7d;
    L74:
        return r3;
    L75:
        return r5;
    L76:
        return r1;
    L7:
        return r3 / 32.0d;
    L9:
        return r3 / 10.0d;
    L11:
        return r3 / 8.0d;
    L13:
        return r3 / 6.0d;
    L15:
        return r3 / 5.0d;
    L17:
        return r3 / 4.0d;
    L19:
        return r3 / 3.0d;
    L21:
        return r3 / 2.0d;
    L23:
        return r0.getCenterY();
    L25:
        return r5 / 32.0d;
    L27:
        return r5 / 16.0d;
    L29:
        return r5 / 8.0d;
    L31:
        return r5 / 6.0d;
    L33:
        return r5 / 4.0d;
    L35:
        return r5 / 2.0d;
    L37:
        return Math.max(r3, r1);
    L39:
        return r1 / 8.0d;
    L41:
        return r1 / 6.0d;
    L43:
        return r1 / 5.0d;
    L45:
        return r1 / 4.0d;
    L47:
        return r1 / 3.0d;
    L49:
        return r1 / 2.0d;
    L51:
        return r0.getCenterX();
    L59:
        return r0.getMaxX();
    L61:
        return r0.getX();
    L63:
        return r0.getMaxY();
    L65:
        return r0.getY();
    }

    public String getName() {
        return name().substring(1);
    }
}
