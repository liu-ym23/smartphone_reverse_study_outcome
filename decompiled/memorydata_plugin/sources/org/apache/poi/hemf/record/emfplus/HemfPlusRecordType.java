package org.apache.poi.hemf.record.emfplus;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes7.dex */
public final enum HemfPlusRecordType extends Enum<HemfPlusRecordType> {
    private static final /* synthetic */ HemfPlusRecordType[] $VALUES = null;
    public static final HemfPlusRecordType beginContainer = null;
    public static final HemfPlusRecordType beginContainerNoParams = null;
    public static final HemfPlusRecordType clear = null;
    public static final HemfPlusRecordType comment = null;
    public static final HemfPlusRecordType drawArc = null;
    public static final HemfPlusRecordType drawBeziers = null;
    public static final HemfPlusRecordType drawClosedCurve = null;
    public static final HemfPlusRecordType drawCurve = null;
    public static final HemfPlusRecordType drawDriverString = null;
    public static final HemfPlusRecordType drawEllipse = null;
    public static final HemfPlusRecordType drawImage = null;
    public static final HemfPlusRecordType drawImagePoints = null;
    public static final HemfPlusRecordType drawLines = null;
    public static final HemfPlusRecordType drawPath = null;
    public static final HemfPlusRecordType drawPie = null;
    public static final HemfPlusRecordType drawRects = null;
    public static final HemfPlusRecordType drawString = null;
    public static final HemfPlusRecordType endContainer = null;
    public static final HemfPlusRecordType eof = null;
    public static final HemfPlusRecordType fillClosedCurve = null;
    public static final HemfPlusRecordType fillEllipse = null;
    public static final HemfPlusRecordType fillPath = null;
    public static final HemfPlusRecordType fillPie = null;
    public static final HemfPlusRecordType fillPolygon = null;
    public static final HemfPlusRecordType fillRects = null;
    public static final HemfPlusRecordType fillRegion = null;
    public static final HemfPlusRecordType getDC = null;
    public static final HemfPlusRecordType header = null;
    public static final HemfPlusRecordType multiFormatEnd = null;
    public static final HemfPlusRecordType multiFormatSection = null;
    public static final HemfPlusRecordType multiFormatStart = null;
    public static final HemfPlusRecordType multiplyWorldTransform = null;
    public static final HemfPlusRecordType object = null;
    public static final HemfPlusRecordType offsetClip = null;
    public static final HemfPlusRecordType resetClip = null;
    public static final HemfPlusRecordType resetWorldTransform = null;
    public static final HemfPlusRecordType restore = null;
    public static final HemfPlusRecordType rotateWorldTransform = null;
    public static final HemfPlusRecordType save = null;
    public static final HemfPlusRecordType scaleWorldTransform = null;
    public static final HemfPlusRecordType serializableObject = null;
    public static final HemfPlusRecordType setAntiAliasMode = null;
    public static final HemfPlusRecordType setClipPath = null;
    public static final HemfPlusRecordType setClipRect = null;
    public static final HemfPlusRecordType setClipRegion = null;
    public static final HemfPlusRecordType setCompositingMode = null;
    public static final HemfPlusRecordType setCompositingQuality = null;
    public static final HemfPlusRecordType setInterpolationMode = null;
    public static final HemfPlusRecordType setPageTransform = null;
    public static final HemfPlusRecordType setPixelOffsetMode = null;
    public static final HemfPlusRecordType setRenderingOrigin = null;
    public static final HemfPlusRecordType setTSClip = null;
    public static final HemfPlusRecordType setTSGraphics = null;
    public static final HemfPlusRecordType setTextContrast = null;
    public static final HemfPlusRecordType setTextRenderingHint = null;
    public static final HemfPlusRecordType setWorldTransform = null;
    public static final HemfPlusRecordType strokeFillPath = null;
    public static final HemfPlusRecordType translateWorldTransform = null;
    public final Supplier<? extends HemfPlusRecord> constructor;
    public final long id;

    static {
        header = new HemfPlusRecordType("header", 0, 16385, $$Lambda$xiQfZpIi4HoW9enY8BCWt0ckc4.INSTANCE);
        eof = new HemfPlusRecordType("eof", 1, 16386, $$Lambda$faqyMhLMehpCIQD64K5YHNb7Vw.INSTANCE);
        comment = new HemfPlusRecordType("comment", 2, 16387, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        getDC = new HemfPlusRecordType("getDC", 3, 16388, $$Lambda$sCojxuhzzEYKlgPCiuKSDsXLZc.INSTANCE);
        multiFormatStart = new HemfPlusRecordType("multiFormatStart", 4, 16389, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        multiFormatSection = new HemfPlusRecordType("multiFormatSection", 5, 16390, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        multiFormatEnd = new HemfPlusRecordType("multiFormatEnd", 6, 16391, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        object = new HemfPlusRecordType("object", 7, 16392, $$Lambda$epn7HkUaxOiVFLL3cxRsH8viI.INSTANCE);
        clear = new HemfPlusRecordType("clear", 8, 16393, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        fillRects = new HemfPlusRecordType("fillRects", 9, 16394, $$Lambda$b07PT0UXnDtcidV_mBWPavZXigE.INSTANCE);
        drawRects = new HemfPlusRecordType("drawRects", 10, 16395, $$Lambda$oJnp89IdUcCVossODjGgjH19JME.INSTANCE);
        fillPolygon = new HemfPlusRecordType("fillPolygon", 11, 16396, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        drawLines = new HemfPlusRecordType("drawLines", 12, 16397, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        fillEllipse = new HemfPlusRecordType("fillEllipse", 13, 16398, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        drawEllipse = new HemfPlusRecordType("drawEllipse", 14, 16399, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        fillPie = new HemfPlusRecordType("fillPie", 15, 16400, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        drawPie = new HemfPlusRecordType("drawPie", 16, 16401, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        drawArc = new HemfPlusRecordType("drawArc", 17, 16402, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        fillRegion = new HemfPlusRecordType("fillRegion", 18, 16403, $$Lambda$1BO3R9SvYMXrZisWojHHR5VMJuI.INSTANCE);
        fillPath = new HemfPlusRecordType("fillPath", 19, 16404, $$Lambda$9acX0_qnh6w2VJb69l2SGNzWV4Q.INSTANCE);
        drawPath = new HemfPlusRecordType("drawPath", 20, 16405, $$Lambda$jhfHyJ8uilYhPKyqkP7_yCG9kls.INSTANCE);
        fillClosedCurve = new HemfPlusRecordType("fillClosedCurve", 21, 16406, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        drawClosedCurve = new HemfPlusRecordType("drawClosedCurve", 22, 16407, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        drawCurve = new HemfPlusRecordType("drawCurve", 23, 16408, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        drawBeziers = new HemfPlusRecordType("drawBeziers", 24, 16409, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        drawImage = new HemfPlusRecordType("drawImage", 25, 16410, $$Lambda$_jbqNOgMw874hguzLqGSpjsMU0A.INSTANCE);
        drawImagePoints = new HemfPlusRecordType("drawImagePoints", 26, 16411, $$Lambda$I5824X9N3gbL5wehWejGizKnUo0.INSTANCE);
        drawString = new HemfPlusRecordType("drawString", 27, 16412, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        setRenderingOrigin = new HemfPlusRecordType("setRenderingOrigin", 28, 16413, $$Lambda$GuBnW0h5oY9GjSHvqqMbcFTMty0.INSTANCE);
        setAntiAliasMode = new HemfPlusRecordType("setAntiAliasMode", 29, 16414, $$Lambda$GRtNESDmHEXHLcTAVB1uauyU2Y.INSTANCE);
        setTextRenderingHint = new HemfPlusRecordType("setTextRenderingHint", 30, 16415, $$Lambda$IQNk4RCtFQbeXYZZQDyNseZpb4s.INSTANCE);
        setTextContrast = new HemfPlusRecordType("setTextContrast", 31, 16416, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        setInterpolationMode = new HemfPlusRecordType("setInterpolationMode", 32, 16417, $$Lambda$j3D1_DIZbwMxUongkwO1JxDHZKg.INSTANCE);
        setPixelOffsetMode = new HemfPlusRecordType("setPixelOffsetMode", 33, 16418, $$Lambda$8i413y9dV623P3WbVFoM5eDAugg.INSTANCE);
        setCompositingMode = new HemfPlusRecordType("setCompositingMode", 34, 16419, $$Lambda$MMfhurmQxFfQxcnmh_VgH9NRrG8.INSTANCE);
        setCompositingQuality = new HemfPlusRecordType("setCompositingQuality", 35, 16420, $$Lambda$SoSD1jQW4AKvA9ihAC5GPLyosoE.INSTANCE);
        save = new HemfPlusRecordType("save", 36, 16421, $$Lambda$K0qUFnDpnLjtwjMDx0Bq69tVFc8.INSTANCE);
        restore = new HemfPlusRecordType("restore", 37, 16422, $$Lambda$pH94JwqaBgqwmQdLhzIs2KxTnBA.INSTANCE);
        beginContainer = new HemfPlusRecordType("beginContainer", 38, 16423, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        beginContainerNoParams = new HemfPlusRecordType("beginContainerNoParams", 39, 1064, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        endContainer = new HemfPlusRecordType("endContainer", 40, 16425, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        setWorldTransform = new HemfPlusRecordType("setWorldTransform", 41, 16426, $$Lambda$3J7ZtJND03Fbfd5TZOvgvCNqNP0.INSTANCE);
        resetWorldTransform = new HemfPlusRecordType("resetWorldTransform", 42, 16427, $$Lambda$LL2CErjm4NC9BloBZZY0ytiR8WI.INSTANCE);
        multiplyWorldTransform = new HemfPlusRecordType("multiplyWorldTransform", 43, 16428, $$Lambda$UzS29CSM5UK4e_ht9zOPXGCakEA.INSTANCE);
        translateWorldTransform = new HemfPlusRecordType("translateWorldTransform", 44, 16429, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        scaleWorldTransform = new HemfPlusRecordType("scaleWorldTransform", 45, 16430, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        rotateWorldTransform = new HemfPlusRecordType("rotateWorldTransform", 46, 16431, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        setPageTransform = new HemfPlusRecordType("setPageTransform", 47, 16432, $$Lambda$rUEaAaxhLlzQfPpwxtKz6d5yUVU.INSTANCE);
        resetClip = new HemfPlusRecordType("resetClip", 48, 16433, $$Lambda$tGH8w0T05EKVFW_13QyjaUahJcM.INSTANCE);
        setClipRect = new HemfPlusRecordType("setClipRect", 49, 16434, $$Lambda$g_rs2JXbI4RYLSieMpoco4gWIs0.INSTANCE);
        setClipRegion = new HemfPlusRecordType("setClipRegion", 50, 16435, $$Lambda$LQELSyBtlwq3czC8Yck1WrGKxc.INSTANCE);
        setClipPath = new HemfPlusRecordType("setClipPath", 51, 16436, $$Lambda$IJY01ALfIcrcznQnGpJwp9Vkk.INSTANCE);
        offsetClip = new HemfPlusRecordType("offsetClip", 52, 16437, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        drawDriverString = new HemfPlusRecordType("drawDriverString", 53, 16438, $$Lambda$KSrq806duMot4aCdUwDEbfhqUyw.INSTANCE);
        strokeFillPath = new HemfPlusRecordType("strokeFillPath", 54, 16439, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        serializableObject = new HemfPlusRecordType("serializableObject", 55, 16440, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        setTSGraphics = new HemfPlusRecordType("setTSGraphics", 56, 16441, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        setTSClip = new HemfPlusRecordType("setTSClip", 57, 16442, $$Lambda$BlREA3IKFBelpRuGnxLr5wD6PGQ.INSTANCE);
        $VALUES = new HemfPlusRecordType[]{header, eof, comment, getDC, multiFormatStart, multiFormatSection, multiFormatEnd, object, clear, fillRects, drawRects, fillPolygon, drawLines, fillEllipse, drawEllipse, fillPie, drawPie, drawArc, fillRegion, fillPath, drawPath, fillClosedCurve, drawClosedCurve, drawCurve, drawBeziers, drawImage, drawImagePoints, drawString, setRenderingOrigin, setAntiAliasMode, setTextRenderingHint, setTextContrast, setInterpolationMode, setPixelOffsetMode, setCompositingMode, setCompositingQuality, save, restore, beginContainer, beginContainerNoParams, endContainer, setWorldTransform, resetWorldTransform, multiplyWorldTransform, translateWorldTransform, scaleWorldTransform, rotateWorldTransform, setPageTransform, resetClip, setClipRect, setClipRegion, setClipPath, offsetClip, drawDriverString, strokeFillPath, serializableObject, setTSGraphics, setTSClip};
    }

    private HemfPlusRecordType(String r3, int r4, long r5, Supplier r7) {
        Supplier<? extends HemfPlusRecord> r8 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r7, Supplier.class, "com.obric.memorydata.plugin");
        super(r3, r4);
        this.id = r5;
        this.constructor = r8;
    }

    public static HemfPlusRecordType getById(long r6) {
        HemfPlusRecordType[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        HemfPlusRecordType r3 = r0[r2];
        if (r3.id == r6) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static HemfPlusRecordType valueOf(String r2) {
        return (HemfPlusRecordType) ZeusTransformUtils.preCheckCast(Enum.valueOf(HemfPlusRecordType.class, r2), HemfPlusRecordType.class, "com.obric.memorydata.plugin");
    }

    public static HemfPlusRecordType[] values() {
        return (HemfPlusRecordType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HemfPlusRecordType[].class, "com.obric.memorydata.plugin");
    }
}
