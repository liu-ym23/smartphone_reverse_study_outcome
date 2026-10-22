package com.ss.ttvideoengine.source.strategy;

import android.text.TextUtils;
import com.ss.ttvideoengine.AppInfo;
import com.ss.ttvideoengine.FeatureManager;
import com.ss.ttvideoengine.InfoWrapper;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.selector.BestResolution;
import com.ss.ttvideoengine.source.DirectUrlSource;
import com.ss.ttvideoengine.source.Source;
import com.ss.ttvideoengine.source.VidPlayAuthTokenSource;
import com.ss.ttvideoengine.strategy.source.StrategySource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class CodecStrategy {
    public static final List<Dimension> COST_SAVING_FIRST_LIST = null;
    public static final List<Dimension> FALLBACK_LIST = null;
    public static final List<Dimension> HARDWARE_DECODE_FIRST_LIST = null;
    public static final int KEY_COST_SAVING_FIST = 1;
    public static final int KEY_HARDWARE_DECODE_FIRST = 2;
    public static final String TAG = "CodecStrategy";

    /* JADX INFO: renamed from: com.ss.ttvideoengine.source.strategy.CodecStrategy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$ttvideoengine$source$Source$Type = null;
        static final /* synthetic */ int[] $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension = null;

        static {
            int[] r0 = new int[Source.Type.values().length];
            $SwitchMap$com$ss$ttvideoengine$source$Source$Type = r0;
            r0[Source.Type.DIRECT_URL_SOURCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L20:
            $SwitchMap$com$ss$ttvideoengine$source$Source$Type[Source.Type.VID_PLAY_AUTH_TOKEN_SOURCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L6:
            int[] r2 = new int[Dimension.values().length];
            $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension = r2;
            r2[Dimension.BYTEVC1_HARDWARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L26:
            $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[Dimension.BYTEVC1_SOFTWARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L32:
            $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[Dimension.BYTEVC2_SOFTWARE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L22:
            $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[Dimension.H264_HARDWARE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L28:
            $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[Dimension.H264_SOFTWARE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static final class Decoder {
        public static final int HARDWARE = 1;
        public static final int SOFTWARE = 0;

        public Decoder() {
        }

        private static boolean isSupportByteVC1HardwareDecode() {
            if (InfoWrapper.getByteVC1HardwareEnable() == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private static boolean isSupportByteVC1SoftwareCapability() {
            if (InfoWrapper.getByteVC1SoftwareCapabilityEnable() == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private static boolean isSupportByteVC1SoftwareDecode() {
            if (InfoWrapper.getByteVC1SoftwareEnable() == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private static boolean isSupportByteVC2SoftWareDecode() {
            if (InfoWrapper.getByteVC2SoftwareEnable() == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private static boolean isSupportH264HardwareDecode() {
            if (InfoWrapper.getH264HardwareEnable() == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private static boolean isDeviceSupport(Dimension r3) {
            int r0 = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[r3.ordinal()];
            if (r0 == 1) goto L26;
            if (r0 == 2) goto L24;
            if (r0 == 3) goto L18;
            if (r0 == 4) goto L16;
            if (r0 != 5) goto L14;
            return true;
        L14:
            throw new IllegalArgumentException("unsupported dimension! " + r3);
        L16:
            return isSupportH264HardwareDecode();
        L18:
            if (isSupportByteVC1SoftwareDecode() == true) goto L20;
            return false;
        L20:
            return isSupportByteVC2SoftWareDecode();
        L24:
            return isSupportByteVC1SoftwareDecode();
        L26:
            return isSupportByteVC1HardwareDecode();
        }

        private static boolean isSDKSupport(Dimension r3) {
            int r0 = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[r3.ordinal()];
            if (r0 != 1) goto L5;
            return true;
        L5:
            if (r0 == 2) goto L19;
            if (r0 == 3) goto L17;
            if (r0 != 4) goto L11;
            return true;
        L11:
            if (r0 != 5) goto L14;
            return true;
        L14:
            throw new IllegalArgumentException("unsupported dimension! " + r3);
        L17:
            return FeatureManager.hasPermission(Source.EncodeType.BYTEVC2);
        L19:
            return isSupportByteVC1SoftwareCapability();
        }

        public static boolean isSupport(Dimension r1) {
            if (isDeviceSupport(r1) == true) goto L5;
        L7:
            return false;
        L5:
            if (isSDKSupport(r1) == false) goto L7;
            return true;
        }
    }

    public static final enum Dimension extends Enum<Dimension> {
        private static final /* synthetic */ Dimension[] $VALUES = null;
        public static final Dimension BYTEVC1_HARDWARE = null;
        public static final Dimension BYTEVC1_SOFTWARE = null;
        public static final Dimension BYTEVC2_SOFTWARE = null;
        public static final Dimension H264_HARDWARE = null;
        public static final Dimension H264_SOFTWARE = null;
        public final int decoder;
        public final String encodeType;

        static {
            Dimension r0 = new Dimension("BYTEVC1_HARDWARE", 0, 1, Source.EncodeType.BYTEVC1);
            BYTEVC1_HARDWARE = r0;
            Dimension r1 = new Dimension("BYTEVC1_SOFTWARE", 1, 0, Source.EncodeType.BYTEVC1);
            BYTEVC1_SOFTWARE = r1;
            Dimension r4 = new Dimension("BYTEVC2_SOFTWARE", 2, 0, Source.EncodeType.BYTEVC2);
            BYTEVC2_SOFTWARE = r4;
            Dimension r5 = new Dimension("H264_HARDWARE", 3, 1, Source.EncodeType.H264);
            H264_HARDWARE = r5;
            Dimension r6 = new Dimension("H264_SOFTWARE", 4, 0, Source.EncodeType.H264);
            H264_SOFTWARE = r6;
            $VALUES = new Dimension[]{r0, r1, r4, r5, r6};
        }

        public static Dimension[] values() {
            return (Dimension[]) $VALUES.clone();
        }

        public static Dimension valueOf(String r1) {
            return (Dimension) a.a(Dimension.class, r1);
        }

        private Dimension(String r1, int r2, int r3, String r4) {
            super(r1, r2);
            this.decoder = r3;
            this.encodeType = r4;
        }
    }

    public static class ResolveResult {
        public Dimension correctedDimension;
        public final Dimension dimension;
        public final DirectUrlSource.UrlItem requestItem;
        public final StrategySource source;
        public final DirectUrlSource.UrlItem urlItem;

        public String toString() {
            return "ResolveResult{vid=" + this.source.vid() + ", sourceType=" + this.source.type() + ", dimension=" + this.dimension + ", correctedDimension=" + this.correctedDimension + ", urlItem=" + this.urlItem + ", requestItem=" + this.requestItem + '}';
        }

        public ResolveResult(VidPlayAuthTokenSource r1, Dimension r2) {
            this.source = r1;
            this.dimension = r2;
            this.urlItem = null;
            this.requestItem = null;
        }

        public ResolveResult(DirectUrlSource r1, Dimension r2, DirectUrlSource.UrlItem r3, DirectUrlSource.UrlItem r4) {
            this.source = r1;
            this.dimension = r2;
            this.urlItem = r3;
            this.requestItem = r4;
        }
    }

    public static final class SmartUrlVod {
        private static final Resolution SMART_URL_DEFAULT_RESOLUTION = null;

        public SmartUrlVod() {
        }

        public static String encodeType() {
            return Source.EncodeType.BYTEVC1;
        }

        static {
            SMART_URL_DEFAULT_RESOLUTION = Resolution.SuperHigh;
        }

        public static String getApiHost() {
            return AppInfo.getSmartUrlApiHost();
        }

        public static boolean isSettingsEnable() {
            if (InfoWrapper.getSmartUrlEnabled() == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public static Resolution videoResolution() {
            return SMART_URL_DEFAULT_RESOLUTION;
        }

        public static Resolution findTargetResolution(IVideoModel r1) {
            return BestResolution.findDefaultResolution(r1, videoResolution());
        }

        public static boolean isEnable(DirectUrlSource r0) {
            if (r0.isSmartUrlValid() == true) goto L5;
        L7:
            return false;
        L5:
            if (isSettingsEnable() == false) goto L7;
            return true;
        }
    }

    static {
        Dimension r2 = Dimension.BYTEVC2_SOFTWARE;
        Dimension r4 = Dimension.BYTEVC1_HARDWARE;
        Dimension r6 = Dimension.BYTEVC1_SOFTWARE;
        Dimension r8 = Dimension.H264_HARDWARE;
        Dimension r10 = Dimension.H264_SOFTWARE;
        COST_SAVING_FIRST_LIST = Collections.unmodifiableList(Arrays.asList(new Dimension[]{r2, r4, r6, r8, r10}));
        HARDWARE_DECODE_FIRST_LIST = Collections.unmodifiableList(Arrays.asList(new Dimension[]{r4, r8, r2, r6, r10}));
        FALLBACK_LIST = Collections.unmodifiableList(Arrays.asList(new Dimension[]{r10, r8, r6, r4, r2}));
    }

    public CodecStrategy() {
    }

    public static boolean isCodecStrategyValid(int r2) {
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public static String dump() {
        return "smartUrl=" + InfoWrapper.getSmartUrlEnabled() + ", 4_h=" + InfoWrapper.getH264HardwareEnable() + ", b_h=" + InfoWrapper.getByteVC1HardwareEnable() + ", b_s=" + InfoWrapper.getByteVC1SoftwareEnable() + ", b_s_cap=" + InfoWrapper.getByteVC1SoftwareCapabilityEnable() + ", b2_s=" + InfoWrapper.getByteVC2SoftwareEnable();
    }

    public static List<Dimension> dimensions(StrategySource r3) {
        int r0 = r3.codecStrategy();
        if (r0 != 1) goto L7;
        return supportedDimensions(r3, COST_SAVING_FIRST_LIST);
    L7:
        if (r0 != 2) goto L11;
        return supportedDimensions(r3, HARDWARE_DECODE_FIRST_LIST);
    L11:
        throw new IllegalArgumentException("unsupported strategy! " + r0);
    }

    public static List<Dimension> fallbackDimensions(StrategySource r1) {
        return supportedDimensions(r1, FALLBACK_LIST);
    }

    public static ResolveResult resolveFallback(StrategySource r4, List<Dimension> r5) {
        List<Dimension> r0 = fallbackDimensions(r4);
        Source.Type r1 = r4.type();
        int r2 = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$source$Source$Type[r1.ordinal()];
        if (r2 == 1) goto L11;
        if (r2 != 2) goto L9;
        return resolveVidPlayAuthToken((VidPlayAuthTokenSource) r4, r0, r5);
    L9:
        throw new IllegalArgumentException("unsupported type! " + r1);
    L11:
        return resolveDirectUrl((DirectUrlSource) r4, r0, r5);
    }

    public static ResolveResult resolveStartPlayback(StrategySource r5, boolean r6) {
        List<Dimension> r0 = dimensions(r5);
        Source.Type r1 = r5.type();
        int r2 = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$source$Source$Type[r1.ordinal()];
        if (r2 != 1) goto L5;
        DirectUrlSource r7 = (DirectUrlSource) r5;
        if (SmartUrlVod.isEnable(r7) == false) goto L16;
        if (r6 == false) goto L16;
        return resolveSmartUrl(r7, r0, null);
    L16:
        return resolveDirectUrl(r7, r0, null);
    L5:
        if (r2 != 2) goto L9;
        return resolveVidPlayAuthToken((VidPlayAuthTokenSource) r5, r0, null);
    L9:
        throw new IllegalArgumentException("unsupported type! " + r1);
    }

    private static List<Dimension> supportedDimensions(StrategySource r3, List<Dimension> r4) {
        if (r3.type() != Source.Type.VID_PLAY_AUTH_TOKEN_SOURCE) goto L5;
        List<String> r5 = ((VidPlayAuthTokenSource) r3).supportedEncodeTypes();
    L6:
        ArrayList r0 = new ArrayList();
        Iterator<Dimension> r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L15;
        Dimension r1 = r6.next();
        if (Decoder.isSupport(r1) == false) goto L8;
        if (r5 == null) goto L14;
        if (r5.contains(r1.encodeType) == false) goto L8;
    L14:
        r0.add(r1);
        goto L8
    L15:
        return r0;
    L5:
        r5 = null;
        goto L6
    }

    private static ResolveResult resolveDirectUrl(DirectUrlSource r3, List<Dimension> r4, List<Dimension> r5) {
        if (r3.allItems().isEmpty() == false) goto L5;
        return null;
    L5:
        Iterator<Dimension> r6 = r4.iterator();
    L7:
        if (r6.hasNext() == false) goto L16;
        Dimension r0 = r6.next();
        if (r5 == null) goto L12;
        if (r5.contains(r0) == true) goto L7;
    L12:
        DirectUrlSource.UrlItem r2 = r3.findItemByEncodeType(r0.encodeType);
        if (r2 == null) goto L7;
        return new ResolveResult(r3, r0, r2, null);
    L16:
        return null;
    }

    private static ResolveResult resolveSmartUrl(DirectUrlSource r4, List<Dimension> r5, List<Dimension> r6) {
        if (r4.allItems().isEmpty() == false) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<Dimension> r7 = r5.iterator();
    L7:
        if (r7.hasNext() == false) goto L14;
        Dimension r2 = r7.next();
        if (r6 == null) goto L12;
        if (r6.contains(r2) == true) goto L7;
    L12:
        r0.add(r2);
        goto L7
    L14:
        if (r0.isEmpty() == false) goto L16;
        return null;
    L16:
        Iterator r8 = r0.iterator();
    L18:
        if (r8.hasNext() == false) goto L27;
        Dimension r9 = (Dimension) r8.next();
        DirectUrlSource.UrlItem r1 = r4.findItemByEncodeType(r9.encodeType);
        if (r1 != null) goto L22;
        if (TextUtils.equals(r9.encodeType, SmartUrlVod.encodeType()) == false) goto L18;
        return new ResolveResult(r4, r9, null, r4.firstItem());
    L22:
        return new ResolveResult(r4, r9, r1, null);
    L27:
        return null;
    }

    private static ResolveResult resolveVidPlayAuthToken(VidPlayAuthTokenSource r3, List<Dimension> r4, List<Dimension> r5) {
        Iterator<Dimension> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L15;
        Dimension r0 = r6.next();
        if (r5 == null) goto L10;
        if (r5.contains(r0) == true) goto L4;
    L10:
        if (r3.encodeType() == null) goto L14;
        if (TextUtils.equals(r3.encodeType(), r0.encodeType) == false) goto L4;
    L14:
        return new ResolveResult(r3, r0);
    L15:
        return null;
    }

    public static Dimension resolveWithEncoderType(String r2, StrategySource r3, List<Dimension> r4) {
        Iterator<Dimension> r5 = dimensions(r3).iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        Dimension r0 = r5.next();
        if (r4 == null) goto L10;
        if (r4.contains(r0) == true) goto L4;
    L10:
        if (TextUtils.equals(r2, r0.encodeType) == false) goto L4;
        return r0;
    L12:
        return null;
    }
}
