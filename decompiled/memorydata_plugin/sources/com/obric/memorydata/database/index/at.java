package com.obric.memorydata.database.index;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.exifinterface.media.ExifInterface;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.database.entity.ck;
import com.obric.memorydata.database.entity.gq;
import com.obric.memorydata.database.entity.hb;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u00015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ2\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\"\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\nH\u0002J(\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J(\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001e\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0002J#\u0010*\u001a\u0004\u0018\u00010\u00142\b\u0010+\u001a\u0004\u0018\u00010\u00052\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010-J\u0017\u0010.\u001a\u0004\u0018\u00010\u00142\u0006\u0010/\u001a\u00020\u0005H\u0002¢\u0006\u0002\u00100J\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/obric/memorydata/database/index/LocationUtils;", "", "<init>", "()V", "TAG", "", "COORDINATE_SCALE", "", "RESOLVER_VERSION", "POSITIVE_CACHE_TTL_MS", "", "EMPTY_CACHE_TTL_MS", "getAddress", "Lcom/obric/memorydata/database/index/LocationResult;", "photoEntity", "Lcom/obric/memorydata/database/entity/RawPhotoEntity;", "getAddressesFromLatLng", "", "Landroid/location/Address;", "lat", "", "lng", "maxResults", "locale", "Ljava/util/Locale;", "queryCache", "Lcom/obric/memorydata/database/entity/LocationAddressCacheEntity;", "cacheKey", "Lcom/obric/memorydata/database/index/LocationUtils$LocationCacheKey;", "saveCache", "", "locationEntity", "Lcom/obric/memorydata/database/entity/RawMetaLocationEntity;", "ttlMs", "cacheToRawMetaLocation", "cache", "addressToRawMetaLocation", MemoryKeyInfoEntity.KEY_ADDRESS, "readLatLngFromExif", "Lkotlin/Pair;", "exif", "Landroid/media/ExifInterface;", "dmsToDecimal", "dms", "ref", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Double;", "rationalToDouble", "rational", "(Ljava/lang/String;)Ljava/lang/Double;", "isValidCoordinate", "", "latitude", "longitude", "LocationCacheKey", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final at f9383a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/index/LocationUtils$LocationCacheKey;", "", "latitudeE5", "", "longitudeE5", "localeTag", "", "<init>", "(IILjava/lang/String;)V", "getLatitudeE5", "()I", "getLongitudeE5", "getLocaleTag", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0457a f9384a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9385b;
        private final int c;
        private final String d;

        /* JADX INFO: renamed from: com.obric.memorydata.database.index.at$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/index/LocationUtils$LocationCacheKey$Companion;", "", "<init>", "()V", "from", "Lcom/obric/memorydata/database/index/LocationUtils$LocationCacheKey;", "latitude", "", "longitude", "locale", "Ljava/util/Locale;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0457a {
            private C0457a() {
            }

            public /* synthetic */ C0457a(DefaultConstructorMarker r1) {
                this();
            }

            public final a a(double r3, double r5, Locale r7) {
                Intrinsics.checkNotNullParameter(r7, "locale");
                double r0 = 100000;
                int r4 = MathKt.roundToInt(r3 * r0);
                int r6 = MathKt.roundToInt(r5 * r0);
                String r8 = r7.toLanguageTag();
                Intrinsics.checkNotNullExpressionValue(r8, "toLanguageTag(...)");
                return new a(r4, r6, r8);
            }
        }

        static {
            f9384a = new C0457a(null);
        }

        public a(int r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "localeTag");
            this.f9385b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final int a() {
            return this.f9385b;
        }

        public final int b() {
            return this.c;
        }

        public final String c() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f9385b == r6.f9385b) goto L12;
            return false;
        L12:
            if (this.c == r6.c) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f9385b) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "LocationCacheKey(latitudeE5=" + this.f9385b + ", longitudeE5=" + this.c + ", localeTag=" + this.d + ')';
        }
    }

    static {
        f9383a = new at();
    }

    private at() {
    }

    private final ck a(a r8) {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getLocationAddressCacheDao().queryValid(r8.a(), r8.b(), r8.c(), 1, System.currentTimeMillis());
    L4:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationUtils", "queryCache failed: " + e.getMessage(), null, 4, null);
        return null;
    }

    private final gq a(Address r32, hb r33, double r34, double r36) {
        if (r32.getMaxAddressLineIndex() <= 0) goto L6;
        String r0 = r32.getAddressLine(0);
    L5:
        String r24 = r0;
        return new gq(0, r33.getEntityId(), r33.getCreateTime(), r33.getModifyTime(), NetError.ERR_DISALLOWED_URL_SCHEME, 0, r33.getPackageName(), r33.getHashCodeValue(), r33.getType(), r32.getCountryName(), null, r32.getAdminArea(), r32.getSubAdminArea(), r32.getLocality(), r32.getThoroughfare(), r32.getSubThoroughfare(), r32.getFeatureName(), r24, r36, r34, 33, null);
    L6:
        StringBuilder r1 = new StringBuilder();
        String r2 = r32.getAdminArea();
        String r3 = "";
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        StringBuilder r4 = r1.append(r2);
        String r5 = r32.getSubAdminArea();
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        StringBuilder r6 = r4.append(r5);
        String r7 = r32.getLocality();
        if (r7 != null) goto L15;
        r7 = "";
    L15:
        StringBuilder r8 = r6.append(r7);
        String r9 = r32.getSubLocality();
        if (r9 != null) goto L18;
        r9 = "";
    L18:
        StringBuilder r10 = r8.append(r9);
        String r11 = r32.getThoroughfare();
        if (r11 != null) goto L21;
        r11 = "";
    L21:
        StringBuilder r12 = r10.append(r11);
        String r13 = r32.getSubThoroughfare();
        if (r13 == null) goto L25;
        r3 = r13;
    L25:
        r0 = r12.append(r3).toString();
        goto L5
    }

    private final gq a(ck r31, hb r32, double r33, double r35) {
        return new gq(0, r32.getEntityId(), r32.getCreateTime(), r32.getModifyTime(), NetError.ERR_DISALLOWED_URL_SCHEME, 0, r32.getPackageName(), r32.getHashCodeValue(), r32.getType(), r31.f(), r31.g(), r31.h(), r31.i(), r31.j(), r31.k(), r31.l(), r31.m(), r31.n(), r35, r33, 33, null);
    }

    private final Double a(String r10) {
        List r9 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"/"}, false, 0, 6, null);
        if (r9.size() != 2) goto L11;
        boolean r11 = false;
        double r2 = Double.parseDouble((String) ZeusTransformUtils.preCheckCast(r9.get(0), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L14
        double r5 = Double.parseDouble((String) ZeusTransformUtils.preCheckCast(r9.get(1), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L14
        if (r5 != 0.0d) goto L8;
        r11 = true;
    L8:
        if (r11 == true) goto L16;
        Double r12 = Double.valueOf(r2 / r5);     // Catch: Exception -> L14
    L13:
        return r12;
    L16:
        return null;
    L11:
        r12 = StringsKt.toDoubleOrNull(r10);     // Catch: Exception -> L14
        goto L13
    L17:
        return null;
    }

    private final Double a(String r13, String r14) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L31;
        return null;
    L31:
        List r2 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{","}, false, 0, 6, null);     // Catch: Exception -> L28
        if (r2.size() == 3) goto L15;
        return null;
    L15:
        Double r3 = a((String) ZeusTransformUtils.preCheckCast(r2.get(0), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L28
        Double r5 = a((String) ZeusTransformUtils.preCheckCast(r2.get(1), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L28
        Double r12 = a((String) ZeusTransformUtils.preCheckCast(r2.get(2), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L28
        if (r3 == null) goto L27;
        if (r5 == null) goto L27;
        if (r12 == null) goto L27;
        double r6 = (r3.doubleValue() + (r5.doubleValue() / 60.0d)) + (r12.doubleValue() / 3600.0d);     // Catch: Exception -> L28
        if (StringsKt.equals(r14, "S", true) == false) goto L23;
    L24:
        r6 = -r6;
    L25:
        return Double.valueOf(r6);
    L23:
        if (StringsKt.equals(r14, ExifInterface.LONGITUDE_WEST, true) == false) goto L25;
    L27:
        return null;
    L28:
        e = move-exception;
        RunLog.INSTANCE.error("LocationUtils", "dmsToDecimal parse error: " + r13, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    private final List<Address> a(double r8, double r10, int r12, Locale r13) {
        List<Address> r9 = new Geocoder((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r13).getFromLocation(r8, r10, r12);     // Catch: IOException -> L23
        if (r9 != null) goto L6;
        return null;
    L6:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L23
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L23
        Iterator r15 = r11.iterator();     // Catch: IOException -> L23
    L8:
        if (r15.hasNext() == false) goto L21;
        Object r16 = r15.next();     // Catch: IOException -> L23
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(((Address) ZeusTransformUtils.preCheckCast(r16, Address.class, "com.obric.memorydata.plugin")).getAdminArea(), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L23
        boolean r18 = false;
        if (r17 != null) goto L12;
    L15:
        boolean r19 = true;
    L16:
        if (r19 == false) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationUtils", "getAddressesFromLatLng: adminArea is empty", null, 4, null);     // Catch: IOException -> L23
    L19:
        if (r18 == false) goto L8;
        r14.add(r16);     // Catch: IOException -> L23
        goto L8
    L18:
        r18 = true;
        goto L19
    L12:
        if (r17.length() == 0) goto L15;
        r19 = false;
        goto L16
    L21:
        return (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
    L23:
        e = move-exception;
        RunLog.INSTANCE.error("LocationUtils", "getAddressesFromLatLng: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    private final Pair<Double, Double> a(android.media.ExifInterface r9) {
        String r0 = r9.getAttribute(ExifInterface.TAG_GPS_LATITUDE);
        String r1 = r9.getAttribute(ExifInterface.TAG_GPS_LATITUDE_REF);
        String r2 = r9.getAttribute(ExifInterface.TAG_GPS_LONGITUDE);
        String r10 = r9.getAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF);
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r5 = false;
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == true) goto L24;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L14;
    L15:
        r5 = true;
    L16:
        if (r5 == true) goto L24;
        Double r7 = a(r0, r1);
        Double r8 = a(r2, r10);
        if (r7 == null) goto L24;
        if (r8 == null) goto L24;
        return TuplesKt.to(r7, r8);
    L14:
        if (r6.length() != 0) goto L16;
    L24:
        return null;
    L5:
        if (r3.length() == 0) goto L8;
        r4 = false;
        goto L10
    }

    private final void a(a r25, gq r26, long r27) {
        long r20 = System.currentTimeMillis();
        int r4 = r25.a();
        int r5 = r25.b();
        String r6 = r25.c();
        String r1 = null;
        if (r26 == null) goto L5;
        String r8 = r26.b();
    L6:
        if (r26 == null) goto L8;
        String r9 = r26.c();
    L9:
        if (r26 == null) goto L11;
        String r10 = r26.d();
    L12:
        if (r26 == null) goto L14;
        String r11 = r26.e();
    L15:
        if (r26 == null) goto L17;
        String r12 = r26.f();
    L18:
        if (r26 == null) goto L20;
        String r13 = r26.g();
    L21:
        if (r26 == null) goto L23;
        String r14 = r26.h();
    L24:
        if (r26 == null) goto L26;
        String r15 = r26.i();
    L27:
        if (r26 == null) goto L29;
        r1 = r26.j();
    L29:
        String r16 = r1;
        if (r26 != null) goto L32;
        boolean r2 = true;
    L39:
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getLocationAddressCacheDao().insertOrReplace(new ck(0, r4, r5, r6, 1, r8, r9, r10, r11, r12, r13, r14, r15, r16, r2, r20 + r27, r20, 1, null));     // Catch: Exception -> L36
        return;
    L36:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationUtils", "saveCache failed: " + e.getMessage(), null, 4, null);
        return;
    L32:
        r2 = false;
        goto L39
    L26:
        r15 = null;
        goto L27
    L23:
        r14 = null;
        goto L24
    L20:
        r13 = null;
        goto L21
    L17:
        r12 = null;
        goto L18
    L14:
        r11 = null;
        goto L15
    L11:
        r10 = null;
        goto L12
    L8:
        r9 = null;
        goto L9
    L5:
        r8 = null;
        goto L6
    }

    private final boolean a(double r5, double r7) {
        if (Double.isInfinite(r5) == false) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L32;
        if (Double.isInfinite(r7) == false) goto L12;
    L14:
        boolean r6 = false;
    L15:
        if (r6 == false) goto L32;
        if ((-90.0d) <= r5) goto L19;
    L21:
        boolean r8 = false;
    L22:
        if (r8 == false) goto L32;
        if ((-180.0d) <= r7) goto L26;
    L28:
        boolean r9 = false;
    L29:
        if (r9 == false) goto L32;
        return true;
    L26:
        if (r7 > 180.0d) goto L28;
        r9 = true;
        goto L29
    L19:
        if (r5 > 90.0d) goto L21;
        r8 = true;
        goto L22
    L12:
        if (Double.isNaN(r7) == true) goto L14;
        r6 = true;
    L32:
        return false;
    L5:
        if (Double.isNaN(r5) == true) goto L7;
        r4 = true;
        goto L8
    }

    public final as a(hb r15) {
        Intrinsics.checkNotNullParameter(r15, "photoEntity");
        if (StringsKt.equals(r15.b(), "VIDEO", true) == true) goto L5;
        FileEntity r0 = com.obric.memorydata.personalcontext.util.f.c(r15.a());
        if (r0 != null) goto L10;
        at r14 = (at) ZeusTransformUtils.preCheckCast(this, at.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationUtils", "getAddress: fileEntity is null, entityId=" + r15.getEntityId(), null, 4, null);
        return new as(true, null);
    L10:
        Uri r16 = r0.getContentUrl();
        if (r16 != null) goto L63;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationUtils", "getAddress: contentUrl is null, entityId=" + r15.getEntityId(), null, 4, null);
        return new as(true, null);
    L63:
        ParcelFileDescriptor r17 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver().openFileDescriptor(r16, "r");     // Catch: Exception -> L56
        if (r17 == null) goto L59;
        Closeable r18 = (Closeable) ZeusTransformUtils.preCheckCast(r17, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L56
        android.media.ExifInterface r5 = new android.media.ExifInterface(((ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r18, ParcelFileDescriptor.class, "com.obric.memorydata.plugin")).getFileDescriptor());     // Catch: Throwable -> L51
        at r4 = f9383a;     // Catch: Throwable -> L51
        Pair<Double, Double> r6 = r4.a(r5);     // Catch: Throwable -> L51
        if (r6 != null) goto L24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationUtils", "getAddress: exif has no GPS, entityId=" + r15.getEntityId(), false, 4, null);     // Catch: Throwable -> L51
        as r19 = new as(true, null);     // Catch: Throwable -> L51
        CloseableKt.closeFinally(r18, null);     // Catch: Exception -> L56
        return r19;
    L24:
        if (r4.a(((Number) ZeusTransformUtils.preCheckCast(r6.getFirst(), Number.class, "com.obric.memorydata.plugin")).doubleValue(), ((Number) ZeusTransformUtils.preCheckCast(r6.getSecond(), Number.class, "com.obric.memorydata.plugin")).doubleValue()) == true) goto L28;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationUtils", "getAddress: invalid GPS, entityId=" + r15.getEntityId(), null, 4, null);     // Catch: Throwable -> L51
        as r110 = new as(true, null);     // Catch: Throwable -> L51
        CloseableKt.closeFinally(r18, null);     // Catch: Exception -> L56
        return r110;
    L28:
        Locale r12 = Locale.getDefault();     // Catch: Throwable -> L51
        a.C0457a r7 = a.f9384a;     // Catch: Throwable -> L51
        double r8 = ((Number) ZeusTransformUtils.preCheckCast(r6.getFirst(), Number.class, "com.obric.memorydata.plugin")).doubleValue();     // Catch: Throwable -> L51
        double r9 = ((Number) ZeusTransformUtils.preCheckCast(r6.getSecond(), Number.class, "com.obric.memorydata.plugin")).doubleValue();     // Catch: Throwable -> L51
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L51
        a r13 = r7.a(r8, r9, r12);     // Catch: Throwable -> L51
        ck r10 = r4.a(r13);     // Catch: Throwable -> L51
        if (r10 != null) goto L31;
        List<Address> r11 = r4.a(((Number) ZeusTransformUtils.preCheckCast(r6.getFirst(), Number.class, "com.obric.memorydata.plugin")).doubleValue(), ((Number) ZeusTransformUtils.preCheckCast(r6.getSecond(), Number.class, "com.obric.memorydata.plugin")).doubleValue(), 3, r12);     // Catch: Throwable -> L51
        if (r11 != null) goto L43;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationUtils", "getAddress: geocoder failed, entityId=" + r15.getEntityId(), null, 4, null);     // Catch: Throwable -> L51
        as r111 = new as(false, null);     // Catch: Throwable -> L51
        CloseableKt.closeFinally(r18, null);     // Catch: Exception -> L56
        return r111;
    L43:
        Address r20 = (Address) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r11), Address.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        if (r20 != null) goto L48;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationUtils", "getAddress: geocoder returns empty, entityId=" + r15.getEntityId(), null, 4, null);     // Catch: Throwable -> L51
        r4.a(r13, null, 21600000);     // Catch: Throwable -> L51
        as r112 = new as(true, null);     // Catch: Throwable -> L51
        CloseableKt.closeFinally(r18, null);     // Catch: Exception -> L56
        return r112;
    L48:
        gq r113 = r4.a(r20, r15, ((Number) ZeusTransformUtils.preCheckCast(r6.getFirst(), Number.class, "com.obric.memorydata.plugin")).doubleValue(), ((Number) ZeusTransformUtils.preCheckCast(r6.getSecond(), Number.class, "com.obric.memorydata.plugin")).doubleValue());     // Catch: Throwable -> L51
        r4.a(r13, r113, 2592000000L);     // Catch: Throwable -> L51
        as r21 = new as(true, r113);     // Catch: Throwable -> L51
        CloseableKt.closeFinally(r18, null);     // Catch: Exception -> L56
        return r21;
    L31:
        if (r10.o() == false) goto L35;
        as r114 = new as(true, null);     // Catch: Throwable -> L51
        CloseableKt.closeFinally(r18, null);     // Catch: Exception -> L56
        return r114;
    L35:
        as r115 = new as(true, r4.a(r10, r15, ((Number) ZeusTransformUtils.preCheckCast(r6.getFirst(), Number.class, "com.obric.memorydata.plugin")).doubleValue(), ((Number) ZeusTransformUtils.preCheckCast(r6.getSecond(), Number.class, "com.obric.memorydata.plugin")).doubleValue()));     // Catch: Throwable -> L51
        CloseableKt.closeFinally(r18, null);     // Catch: Exception -> L56
        return r115;
    L51:
        th = move-exception;
        throw th;     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);     // Catch: Exception -> L56
        throw th;     // Catch: Exception -> L56
    L59:
        return new as(false, null);
    L56:
        e = move-exception;
        RunLog.INSTANCE.error("LocationUtils", "getAddress error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L59
    L5:
        return new as(true, null);
    }
}
