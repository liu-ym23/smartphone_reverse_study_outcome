package org.apache.poi.hwmf.record;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import com.obric.cae.userAware.WifiScanSceneType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes7.dex */
public final enum HwmfRecordType extends Enum<HwmfRecordType> {
    private static final /* synthetic */ HwmfRecordType[] $VALUES = null;
    public static final HwmfRecordType animatePalette = null;
    public static final HwmfRecordType arc = null;
    public static final HwmfRecordType bitBlt = null;
    public static final HwmfRecordType chord = null;
    public static final HwmfRecordType createBrushIndirect = null;
    public static final HwmfRecordType createFontIndirect = null;
    public static final HwmfRecordType createPalette = null;
    public static final HwmfRecordType createPatternBrush = null;
    public static final HwmfRecordType createPenIndirect = null;
    public static final HwmfRecordType createRegion = null;
    public static final HwmfRecordType deleteObject = null;
    public static final HwmfRecordType dibBitBlt = null;
    public static final HwmfRecordType dibCreatePatternBrush = null;
    public static final HwmfRecordType dibStretchBlt = null;
    public static final HwmfRecordType ellipse = null;
    public static final HwmfRecordType eof = null;
    public static final HwmfRecordType escape = null;
    public static final HwmfRecordType excludeClipRect = null;
    public static final HwmfRecordType extFloodFill = null;
    public static final HwmfRecordType extTextOut = null;
    public static final HwmfRecordType fillRegion = null;
    public static final HwmfRecordType floodFill = null;
    public static final HwmfRecordType frameRegion = null;
    public static final HwmfRecordType intersectClipRect = null;
    public static final HwmfRecordType invertRegion = null;
    public static final HwmfRecordType lineTo = null;
    public static final HwmfRecordType moveTo = null;
    public static final HwmfRecordType offsetClipRgn = null;
    public static final HwmfRecordType offsetViewportOrg = null;
    public static final HwmfRecordType offsetWindowOrg = null;
    public static final HwmfRecordType paintRegion = null;
    public static final HwmfRecordType patBlt = null;
    public static final HwmfRecordType pie = null;
    public static final HwmfRecordType polyPolygon = null;
    public static final HwmfRecordType polygon = null;
    public static final HwmfRecordType polyline = null;
    public static final HwmfRecordType realizePalette = null;
    public static final HwmfRecordType rectangle = null;
    public static final HwmfRecordType resizePalette = null;
    public static final HwmfRecordType restoreDc = null;
    public static final HwmfRecordType roundRect = null;
    public static final HwmfRecordType saveDc = null;
    public static final HwmfRecordType scaleViewportExt = null;
    public static final HwmfRecordType scaleWindowExt = null;
    public static final HwmfRecordType selectClipRegion = null;
    public static final HwmfRecordType selectObject = null;
    public static final HwmfRecordType selectPalette = null;
    public static final HwmfRecordType setBkColor = null;
    public static final HwmfRecordType setBkMode = null;
    public static final HwmfRecordType setDibToDev = null;
    public static final HwmfRecordType setLayout = null;
    public static final HwmfRecordType setMapMode = null;
    public static final HwmfRecordType setMapperFlags = null;
    public static final HwmfRecordType setPalEntries = null;
    public static final HwmfRecordType setPixel = null;
    public static final HwmfRecordType setPolyFillMode = null;
    public static final HwmfRecordType setRelabs = null;
    public static final HwmfRecordType setRop2 = null;
    public static final HwmfRecordType setStretchBltMode = null;
    public static final HwmfRecordType setTextAlign = null;
    public static final HwmfRecordType setTextCharExtra = null;
    public static final HwmfRecordType setTextColor = null;
    public static final HwmfRecordType setTextJustification = null;
    public static final HwmfRecordType setViewportExt = null;
    public static final HwmfRecordType setViewportOrg = null;
    public static final HwmfRecordType setWindowExt = null;
    public static final HwmfRecordType setWindowOrg = null;
    public static final HwmfRecordType stretchBlt = null;
    public static final HwmfRecordType stretchDib = null;
    public static final HwmfRecordType textOut = null;
    public final Supplier<? extends HwmfRecord> constructor;
    public final int id;

    static {
        eof = new HwmfRecordType("eof", 0, 0, null);
        animatePalette = new HwmfRecordType("animatePalette", 1, 1078, $$Lambda$X8dWdUCUnD2IoRHYzRQBzCelOc8.INSTANCE);
        arc = new HwmfRecordType("arc", 2, 2071, $$Lambda$KFjpjHy5EW6u71ghd2QkBq2prw.INSTANCE);
        bitBlt = new HwmfRecordType("bitBlt", 3, 2338, $$Lambda$i0vWAfjUR266bzrke3ebdd5QbCQ.INSTANCE);
        chord = new HwmfRecordType("chord", 4, 2096, $$Lambda$BU_Tc4u6lsJ4eEH7IgW2LtMIZfg.INSTANCE);
        createBrushIndirect = new HwmfRecordType("createBrushIndirect", 5, 764, $$Lambda$4SOaJWpwASBFWaOUn7pz8Pd4aEY.INSTANCE);
        createFontIndirect = new HwmfRecordType("createFontIndirect", 6, 763, $$Lambda$Cmd41NnjazzcTwWSSyvVwmZI6k.INSTANCE);
        createPalette = new HwmfRecordType("createPalette", 7, 247, $$Lambda$KB4N1HAyMSae2g0jv2WjRsyyh4.INSTANCE);
        createPatternBrush = new HwmfRecordType("createPatternBrush", 8, TypedValues.PositionType.TYPE_SIZE_PERCENT, $$Lambda$7HQhQEjBdSuFu73vzOzD_jtn6Bc.INSTANCE);
        createPenIndirect = new HwmfRecordType("createPenIndirect", 9, 762, $$Lambda$iql9nIvWTDTfvW2GIpjKLyQu5Y.INSTANCE);
        createRegion = new HwmfRecordType("createRegion", 10, 1791, $$Lambda$CndKNiYRR2KMKNktTp0RBLpvDFM.INSTANCE);
        deleteObject = new HwmfRecordType("deleteObject", 11, 496, $$Lambda$vHLiIxgZeDOCt5bCL6HCwC4JlDg.INSTANCE);
        dibBitBlt = new HwmfRecordType("dibBitBlt", 12, 2368, $$Lambda$0qnOHSDMEExc4_6NQ62spmGD8g.INSTANCE);
        dibCreatePatternBrush = new HwmfRecordType("dibCreatePatternBrush", 13, 322, $$Lambda$ZMwQJ1wajlRJVMDR4mTWSgOZK4.INSTANCE);
        dibStretchBlt = new HwmfRecordType("dibStretchBlt", 14, 2881, $$Lambda$jYGQcTrDjL2htEXwM0PXXLPpGfk.INSTANCE);
        ellipse = new HwmfRecordType("ellipse", 15, 1048, $$Lambda$ttQmg5Lpk17UDjKyFFGMfR7BCa8.INSTANCE);
        escape = new HwmfRecordType("escape", 16, 1574, $$Lambda$0M41ku1plpiFuo7iKKuKewOnqoQ.INSTANCE);
        excludeClipRect = new HwmfRecordType("excludeClipRect", 17, 1045, $$Lambda$1m_diR6hYF9m0IFm56t2sUOqhg.INSTANCE);
        extFloodFill = new HwmfRecordType("extFloodFill", 18, 1352, $$Lambda$JXUTHmfLaz6jFNrqJt6YHL3XWow.INSTANCE);
        extTextOut = new HwmfRecordType("extTextOut", 19, 2610, $$Lambda$qyu77a_BhYCwVGJjTXLrXqQBEE.INSTANCE);
        fillRegion = new HwmfRecordType("fillRegion", 20, 552, $$Lambda$KXc_2BAYW2HM1RXAJEFzGVLvShc.INSTANCE);
        floodFill = new HwmfRecordType("floodFill", 21, 1049, $$Lambda$fmTqkKuK613_4Hze6yJU5ADTNOg.INSTANCE);
        frameRegion = new HwmfRecordType("frameRegion", 22, 1065, $$Lambda$cxRx84lRnLR5o6KrBG0ZUEABbgw.INSTANCE);
        intersectClipRect = new HwmfRecordType("intersectClipRect", 23, 1046, $$Lambda$wUYLVOUaJM5qxCakNl5wWJIBpTI.INSTANCE);
        invertRegion = new HwmfRecordType("invertRegion", 24, 298, $$Lambda$RlJgZYMeHbv5r2YylehBo3RWbuM.INSTANCE);
        lineTo = new HwmfRecordType("lineTo", 25, 531, $$Lambda$8V3m_jKYu3zZ7WEuMNfFJS3nI4I.INSTANCE);
        moveTo = new HwmfRecordType("moveTo", 26, 532, $$Lambda$6eVmKfGUjSFiE9uZtgArPS47PQ.INSTANCE);
        offsetClipRgn = new HwmfRecordType("offsetClipRgn", 27, 544, $$Lambda$Tx14tOVBVI4z2w4E9jQYkEl2MbM.INSTANCE);
        offsetViewportOrg = new HwmfRecordType("offsetViewportOrg", 28, 529, $$Lambda$N8aCUMBMFjzGG6j9tURYq2UhDhk.INSTANCE);
        offsetWindowOrg = new HwmfRecordType("offsetWindowOrg", 29, 527, $$Lambda$htpq3JVFMmFJpeQcd1EKRMbAh8.INSTANCE);
        paintRegion = new HwmfRecordType("paintRegion", 30, WifiScanSceneType.ELEVATOR_END, $$Lambda$_aInLiROeLQCRKrffYQqAU8Yo.INSTANCE);
        patBlt = new HwmfRecordType("patBlt", 31, 1565, $$Lambda$mDzuQoj9MFxN4yv3SHOZswoFOa4.INSTANCE);
        pie = new HwmfRecordType("pie", 32, 2074, $$Lambda$yMNiut2Cj7ptyBdvx9r7rWz2IDs.INSTANCE);
        polygon = new HwmfRecordType("polygon", 33, 804, $$Lambda$TxAIc3X4VMYYwoG0f0dK5LVhC54.INSTANCE);
        polyline = new HwmfRecordType("polyline", 34, 805, $$Lambda$xi3x5rQrPKOoU2Nt9myu1tsviE.INSTANCE);
        polyPolygon = new HwmfRecordType("polyPolygon", 35, 1336, $$Lambda$djwucMHWQQPywawRKJVN94EJquQ.INSTANCE);
        realizePalette = new HwmfRecordType("realizePalette", 36, 53, $$Lambda$rS54A6iTfNm1nd8EOPGORfw4F10.INSTANCE);
        rectangle = new HwmfRecordType("rectangle", 37, 1051, $$Lambda$0gg6sDwWUOFCrJ8RwV4hgrrMg.INSTANCE);
        resizePalette = new HwmfRecordType("resizePalette", 38, 313, $$Lambda$3R31qjlhPUoupyqrWpKHaQBoT8.INSTANCE);
        restoreDc = new HwmfRecordType("restoreDc", 39, 295, $$Lambda$f8V7X4glcDMuHNVI9bGJr1erMns.INSTANCE);
        roundRect = new HwmfRecordType("roundRect", 40, 1564, $$Lambda$A2CoeHee7QCCzykMYsCwff7y4.INSTANCE);
        saveDc = new HwmfRecordType("saveDc", 41, 30, $$Lambda$arDgRV8vvXj1UUpip7aZbwSSuVE.INSTANCE);
        scaleViewportExt = new HwmfRecordType("scaleViewportExt", 42, 1042, $$Lambda$AZNuDS7jFdRxE1JRkfwVtv3amr8.INSTANCE);
        scaleWindowExt = new HwmfRecordType("scaleWindowExt", 43, 1040, $$Lambda$G03ugdsnUlsFRSmhQ3gZuN2rNqU.INSTANCE);
        selectClipRegion = new HwmfRecordType("selectClipRegion", 44, 300, $$Lambda$xvdTKS6Rpnv3s_oNO2rpxoOvC0Y.INSTANCE);
        selectObject = new HwmfRecordType("selectObject", 45, 301, $$Lambda$79hGv6VuvkQB79yEGCo7rYMYPPE.INSTANCE);
        selectPalette = new HwmfRecordType("selectPalette", 46, 564, $$Lambda$QNCxe3aKXURgXILF4DZa0q0jHPE.INSTANCE);
        setBkColor = new HwmfRecordType("setBkColor", 47, InputDeviceCompat.SOURCE_DPAD, $$Lambda$g1oeOjTmFfzHm5EQimmrhJigXoc.INSTANCE);
        setBkMode = new HwmfRecordType("setBkMode", 48, 258, $$Lambda$vnb2AQ8btxYhMX8HmCT469iUsLU.INSTANCE);
        setDibToDev = new HwmfRecordType("setDibToDev", 49, 3379, $$Lambda$CHZAiO_puPLgGd6Y3VBjzf0TppQ.INSTANCE);
        setLayout = new HwmfRecordType("setLayout", 50, 329, $$Lambda$IxudvvIUg4VSaU9GBW3GDehXkdI.INSTANCE);
        setMapMode = new HwmfRecordType("setMapMode", 51, 259, $$Lambda$Cc3OL9cDJDTawhdoU9ScOUoqE78.INSTANCE);
        setMapperFlags = new HwmfRecordType("setMapperFlags", 52, 561, $$Lambda$0nfxtNf5COkxcMuIzXM9MUxOxGw.INSTANCE);
        setPalEntries = new HwmfRecordType("setPalEntries", 53, 55, $$Lambda$k0S8B9Tn0yxv3JAtBdoYVXidlYM.INSTANCE);
        setPixel = new HwmfRecordType("setPixel", 54, 1055, $$Lambda$R8FNUoZGyiPUcorvBfyLvpLr3zw.INSTANCE);
        setPolyFillMode = new HwmfRecordType("setPolyFillMode", 55, 262, $$Lambda$9YuNOqTeAD8VsbiOtFfZBlxMiE.INSTANCE);
        setRelabs = new HwmfRecordType("setRelabs", 56, 261, $$Lambda$3ZPafl0DB9Mh5qMLcv7P9EW7nA.INSTANCE);
        setRop2 = new HwmfRecordType("setRop2", 57, 260, $$Lambda$UL8Ll4YbdKc_42J5jcnBIOzjgYg.INSTANCE);
        setStretchBltMode = new HwmfRecordType("setStretchBltMode", 58, 263, $$Lambda$_OkfyjLTl7fDchO65Fl0je8cI0.INSTANCE);
        setTextAlign = new HwmfRecordType("setTextAlign", 59, 302, $$Lambda$yMGs4dwTHmJaiVPK3Bny8aaXXlE.INSTANCE);
        setTextCharExtra = new HwmfRecordType("setTextCharExtra", 60, 264, $$Lambda$GilLpXkCWE9ODPFZ3ANxEkbnTIE.INSTANCE);
        setTextColor = new HwmfRecordType("setTextColor", 61, 521, $$Lambda$ds12jnWxEk10k3VX05ulJkxx6NM.INSTANCE);
        setTextJustification = new HwmfRecordType("setTextJustification", 62, 522, $$Lambda$AA36pvImYEMrZDxrwDS3PMBWsG0.INSTANCE);
        setViewportExt = new HwmfRecordType("setViewportExt", 63, 526, $$Lambda$AhbVru1xNpeQskgRSKGvzeqSUEk.INSTANCE);
        setViewportOrg = new HwmfRecordType("setViewportOrg", 64, 525, $$Lambda$e3qrZBbEUFZpmWINO6Z6IBqW1g.INSTANCE);
        setWindowExt = new HwmfRecordType("setWindowExt", 65, 524, $$Lambda$7QQHUMjh_OWQslFfXxB074iLeUk.INSTANCE);
        setWindowOrg = new HwmfRecordType("setWindowOrg", 66, 523, $$Lambda$QaqOTftPSmqF6TFMNWkwbx0n6vw.INSTANCE);
        stretchBlt = new HwmfRecordType("stretchBlt", 67, 2851, $$Lambda$ZIKCgiUK5_XKUDZ23iJcSEAaPY.INSTANCE);
        stretchDib = new HwmfRecordType("stretchDib", 68, 3907, $$Lambda$5qOeLb64y3WjM6fyNr85fzX5w4.INSTANCE);
        textOut = new HwmfRecordType("textOut", 69, 1313, $$Lambda$ks1eEDvC_6qVO4EvM0CyvKm6Qc.INSTANCE);
        $VALUES = new HwmfRecordType[]{eof, animatePalette, arc, bitBlt, chord, createBrushIndirect, createFontIndirect, createPalette, createPatternBrush, createPenIndirect, createRegion, deleteObject, dibBitBlt, dibCreatePatternBrush, dibStretchBlt, ellipse, escape, excludeClipRect, extFloodFill, extTextOut, fillRegion, floodFill, frameRegion, intersectClipRect, invertRegion, lineTo, moveTo, offsetClipRgn, offsetViewportOrg, offsetWindowOrg, paintRegion, patBlt, pie, polygon, polyline, polyPolygon, realizePalette, rectangle, resizePalette, restoreDc, roundRect, saveDc, scaleViewportExt, scaleWindowExt, selectClipRegion, selectObject, selectPalette, setBkColor, setBkMode, setDibToDev, setLayout, setMapMode, setMapperFlags, setPalEntries, setPixel, setPolyFillMode, setRelabs, setRop2, setStretchBltMode, setTextAlign, setTextCharExtra, setTextColor, setTextJustification, setViewportExt, setViewportOrg, setWindowExt, setWindowOrg, stretchBlt, stretchDib, textOut};
    }

    private HwmfRecordType(String r3, int r4, int r5, Supplier r6) {
        Supplier<? extends HwmfRecord> r7 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r6, Supplier.class, "com.obric.memorydata.plugin");
        super(r3, r4);
        this.id = r5;
        this.constructor = r7;
    }

    public static HwmfRecordType getById(int r5) {
        HwmfRecordType[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        HwmfRecordType r3 = r0[r2];
        if (r3.id == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static HwmfRecordType valueOf(String r2) {
        return (HwmfRecordType) ZeusTransformUtils.preCheckCast(Enum.valueOf(HwmfRecordType.class, r2), HwmfRecordType.class, "com.obric.memorydata.plugin");
    }

    public static HwmfRecordType[] values() {
        return (HwmfRecordType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HwmfRecordType[].class, "com.obric.memorydata.plugin");
    }
}
