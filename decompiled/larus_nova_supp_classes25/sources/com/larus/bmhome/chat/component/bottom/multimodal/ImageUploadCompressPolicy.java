package com.larus.bmhome.chat.component.bottom.multimodal;

import android.graphics.Bitmap;
import android.os.Build;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.NetConnectionTypeProvider;
import com.larus.platform.model.camera.AppImageUploadPerfOptConf;
import com.larus.platform.model.camera.ImageUploadProfile;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ImageUploadCompressPolicy {
    public static final ImageUploadCompressPolicy a = null;
    public static NetConnectionTypeProvider.NetworkStatus b;
    public static final Lazy c = null;
    public static final Lazy d = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/ImageUploadCompressPolicy$Scene;", "", "sceneName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getSceneName", "()Ljava/lang/String;", "NormalQualityScene", "LowQualityScene", "HighQualityScene", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum Scene extends Enum<Scene> {
        public static final a Companion = null;
        public static final Scene HighQualityScene = null;
        public static final Scene LowQualityScene = null;
        public static final Scene NormalQualityScene = null;
        public static final /* synthetic */ Scene[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String sceneName;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Scene> getEntries() {
            return b;
        }

        static {
            Scene r0 = new Scene("NormalQualityScene", 0, "normal_quality_scene");
            NormalQualityScene = r0;
            Scene r1 = new Scene("LowQualityScene", 1, "low_quality_scene");
            LowQualityScene = r1;
            Scene r3 = new Scene("HighQualityScene", 2, "high_quality_scene");
            HighQualityScene = r3;
            Scene[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static Scene[] values() {
            return (Scene[]) a.clone();
        }

        public final String getSceneName() {
            return this.sceneName;
        }

        public static Scene valueOf(String r1) {
            return (Scene) r27.a.a(Scene.class, r1);
        }

        public Scene(String r1, int r2, String r3) {
            super(r1, r2);
            this.sceneName = r3;
        }
    }

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((ImageUploadProfile) r3).getMaxBytes()), Long.valueOf(((ImageUploadProfile) r4).getMaxBytes()));
        }
    }

    public ImageUploadCompressPolicy() {
    }

    static {
        a = new ImageUploadCompressPolicy();
        b = NetConnectionTypeProvider.NetworkStatus.UNKNOWN;
        int r0 = NetConnectionTypeProvider.NetworkStatus.GOOD_2G.getValue();
        Scene r16 = Scene.LowQualityScene;
        List r14 = CollectionsKt.listOf(new ImageUploadProfile[]{new ImageUploadProfile(r16.getSceneName(), 480, 150000, 65, 80, true, false, r0, 35), new ImageUploadProfile(r16.getSceneName(), 1440, 600000, 60, 75, true, false, r0, 33), new ImageUploadProfile(r16.getSceneName(), 2160, 2000000, 45, 60, true, false, r0, 30)});
        Scene r22 = Scene.NormalQualityScene;
        List r15 = CollectionsKt.listOf(new ImageUploadProfile[]{new ImageUploadProfile(r22.getSceneName(), 480, 150000, 60, 80, true, false, r0, 40), new ImageUploadProfile(r22.getSceneName(), 1440, 600000, 65, 85, true, false, r0, 35), new ImageUploadProfile(r22.getSceneName(), 2160, 2000000, 60, 80, true, false, r0, 20)});
        Scene r23 = Scene.HighQualityScene;
        new AppImageUploadPerfOptConf(r14, r15, CollectionsKt.listOf(new ImageUploadProfile[]{new ImageUploadProfile(r23.getSceneName(), 480, 150000, 80, 95, true, false, r0, 50), new ImageUploadProfile(r23.getSceneName(), 1440, 600000, 75, 90, true, false, r0, 45), new ImageUploadProfile(r23.getSceneName(), 2160, 2000000, 70, 90, true, false, r0, 40)}), false, false);
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.SYNCHRONIZED;
        c = LazyKt.lazy(r1, new j());
        d = LazyKt.lazy(r1, new k());
    }

    @JvmStatic
    public static final ns8.a a(ns8.a r10) {
        z2 r0 = z2.a;
        if (Intrinsics.areEqual(r0.preprocessAlbumImgOptConfig().b(), Boolean.TRUE) == true) goto L5;
        return r10;
    L5:
        a.getClass();
        if (Build.VERSION.SDK_INT < 30) goto L8;
        Bitmap.CompressFormat r1 = Bitmap.CompressFormat.WEBP_LOSSY;
    L9:
        Integer r2 = r0.preprocessAlbumImgOptConfig().e();
        if (r2 == null) goto L12;
        int r3 = r2.intValue();
    L13:
        if (r10 != null) goto L16;
        r10 = new ns8.a(null, null, null, null, false, 255);
    L16:
        return ns8.a.a(r10, r1, r1, RangesKt.coerceAtLeast(r3, 0), 55);
    L12:
        r3 = 0;
        goto L13
    L8:
        r1 = Bitmap.CompressFormat.WEBP;
        goto L9
    }

    @JvmStatic
    public static final ns8.a b(ns8.a r8) {
        if (Intrinsics.areEqual(z2.a.preprocessAlbumImgOptConfig().c(), Boolean.TRUE) == true) goto L5;
        return r8;
    L5:
        a.getClass();
        if (Build.VERSION.SDK_INT < 30) goto L8;
        Bitmap.CompressFormat r0 = Bitmap.CompressFormat.WEBP_LOSSY;
    L9:
        if (r8 != null) goto L12;
        r8 = new ns8.a(null, null, null, null, false, 255);
    L12:
        return ns8.a.a(r8, r0, r0, 0, DoraCallStateCode.ENV_OBSERVE_USER_TIMER_START);
    L8:
        r0 = Bitmap.CompressFormat.WEBP;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void d(Map<String, List<ImageUploadProfile>> r3, List<ImageUploadProfile> r4) {
        if (r4 == null) goto L13;
        Iterator<T> r5 = r4.iterator();
    L5:
        if (r5.hasNext() == false) goto L17;
        ImageUploadProfile r0 = (ImageUploadProfile) r5.next();
        String r1 = r0.getScene();
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        Object r2 = ((LinkedHashMap) r3).get(r1);
        if (r2 != null) goto L12;
        r2 = new ArrayList();
        r3.put(r1, r2);
    L12:
        ((List) r2).add(r0);
        goto L5
    L17:
        return;
    }

    public static ns8.a c(String r18, long r19, boolean r21) {
        List r3 = (List) ((Map) d.getValue()).get(r18);
        List r4 = r3;
        boolean r5 = true;
        if (r4 != null) goto L5;
    L8:
        boolean r6 = true;
    L10:
        if (r6 == false) goto L12;
        FLogger.a.w("ImageUploadCompressPolicy", "[findProfileForSize] no profiles for scene=" + r18);
        ImageUploadProfile r10 = null;
    L26:
        if (r10 != null) goto L29;
        FLogger.a.w("ImageUploadCompressPolicy", "[buildCompressConfigBySize] no profile found for scene=" + r18 + ", size=" + r19);
        return null;
    L29:
        NetConnectionTypeProvider.NetworkStatus r7 = b;
        int r8 = r7.getValue();
        if (r7 != NetConnectionTypeProvider.NetworkStatus.UNKNOWN) goto L33;
        FLogger.a.i("ImageUploadCompressPolicy", "[chooseQuality] skip weakNetwork due to UNKNOWN networkStatus → normal logic");
    L41:
        if (r19 > r10.getMaxBytes()) goto L43;
        int r9 = r10.getMaxQuality();
    L44:
        int r11 = RangesKt.coerceIn(r9, 10, 100);
    L45:
        FLogger r12 = FLogger.a;
        StringBuilder r13 = new StringBuilder("[buildCompressConfigBySize] scene=");
        r13.append(r18);
        r13.append(", size=");
        r13.append(r19);
        r13.append(", targetQuality=");
        r13.append(r11);
        r13.append(", profile=");
        StringBuilder r0 = new StringBuilder("scene=");
        String r1 = r10.getScene();
        if (r1 != null) goto L48;
        r1 = "";
    L48:
        r0.append(r1);
        r0.append(", maxShortSize=");
        r0.append(r10.getMaxShortSize());
        r0.append(", maxBytes=");
        r0.append(r10.getMaxBytes());
        r0.append(", minQ=");
        r0.append(r10.getMinQuality());
        r0.append(", maxQ=");
        r0.append(r10.getMaxQuality());
        r0.append(", preUpload=");
        r0.append(r10.getEnablePreUpload());
        r0.append(", weakNetworkCompressQuality=");
        r0.append(r10.getWeakNetworkCompressQuality());
        r0.append(", weakNetworkQualityLevel=");
        r0.append(r10.getWeakNetworkQualityLevel());
        r0.append(", networkQuality=");
        r0.append(b);
        r13.append(r0.toString());
        r12.i("ImageUploadCompressPolicy", r13.toString());
        return new ns8.a(Integer.valueOf(r10.getMaxShortSize()), null, Integer.valueOf(r11), null, r21, 234);
    L43:
        r9 = r10.getMinQuality();
        goto L44
    L33:
        if (r10.getEnableWeakNetworkCompress() == false) goto L41;
        int r14 = r10.getWeakNetworkQualityLevel();
        if (r8 <= r14) goto L38;
        r5 = false;
    L38:
        if (r5 == false) goto L41;
        r11 = RangesKt.coerceIn(r10.getWeakNetworkCompressQuality(), 10, 100);
        FLogger.a.i("ImageUploadCompressPolicy", "[chooseQuality] weakNetwork HIT! network=" + r7 + " threshold=" + r14 + " → quality=" + r11);
        goto L45
    L12:
        Iterator r15 = r3.iterator();
    L14:
        if (r15.hasNext() == false) goto L21;
        Object r16 = r15.next();
        if (r19 > ((ImageUploadProfile) r16).getMaxBytes()) goto L18;
        boolean r17 = true;
    L19:
        if (r17 == false) goto L14;
    L22:
        r10 = (ImageUploadProfile) r16;
        if (r10 != null) goto L25;
        r10 = (ImageUploadProfile) CollectionsKt.last(r3);
    L25:
        FLogger.a.i("ImageUploadCompressPolicy", "[findProfileForSize] scene=" + r18 + ", size=" + r19 + " → hitMaxBytes=" + r10.getMaxBytes());
        goto L26
    L18:
        r17 = false;
        goto L19
    L21:
        r16 = null;
        goto L22
    L5:
        if (r4.isEmpty() == true) goto L8;
        r6 = false;
        goto L10
    }
}
