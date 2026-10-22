package com.obric.memorydata.memory;

import android.os.Bundle;
import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 '2\u00020\u0001:\u0007!\"#$%&'B9\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003J\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017J0\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog;", "", "globalVersion", "", "entries", "", "Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$ActivityKey;", "Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$ActivityRules;", "favoriteEvents", "Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$FavoriteEventKey;", "Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$FavoriteEvent;", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getGlobalVersion", "()Ljava/lang/String;", "favoriteEvent", ObricMemoryConstants.KEY_PACKAGE_NAME, "activityName", "ruleId", "eventType", "activityIndex", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "find", "engineVersion", "", "ruleVersion", "appVersionCode", "", "deltaFrom", "Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$Delta;", "previous", "ActivityKey", "FavoriteEventKey", "FavoriteEvent", "ActivityVariant", "ActivityRules", "Delta", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f10124a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10125b;
    private final Map<a, b> c;
    private final Map<f, e> d;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$ActivityKey;", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "activityName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "getActivityName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10127b;

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(r3, "activityName");
            this.f10126a = r2;
            this.f10127b = r3;
        }

        public final String a() {
            return this.f10126a;
        }

        public final String b() {
            return this.f10127b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10126a, r6.f10126a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10127b, r6.f10127b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f10126a.hashCode() * 31) + this.f10127b.hashCode();
        }

        public String toString() {
            return "ActivityKey(packageName=" + this.f10126a + ", activityName=" + this.f10127b + ')';
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006$"}, d2 = {"Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$ActivityRules;", "", "key", "Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$ActivityKey;", "engineVersion", "", "ruleVersion", "", "variants", "", "Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$ActivityVariant;", "<init>", "(Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$ActivityKey;ILjava/lang/String;Ljava/util/List;)V", "getKey", "()Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$ActivityKey;", "getEngineVersion", "()I", "getRuleVersion", "()Ljava/lang/String;", "getVariants", "()Ljava/util/List;", "toIndexBundle", "Landroid/os/Bundle;", "rulesJsonFor", "versionCode", "", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f10128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10129b;
        private final String c;
        private final List<c> d;

        public b(a r3, int r4, String r5, List<c> r6) {
            List<c> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r5, "ruleVersion");
            Intrinsics.checkNotNullParameter(r7, "variants");
            this.f10128a = r3;
            this.f10129b = r4;
            this.c = r5;
            this.d = r7;
        }

        public final a a() {
            return this.f10128a;
        }

        public final String a(long r5) {
            Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.d, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r4.hasNext() == false) goto L8;
            Object r0 = r4.next();
            if (((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin")).a(r5) == false) goto L4;
        L9:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L12;
            return null;
        L12:
            return r6.c();
        L8:
            r0 = null;
            goto L9
        }

        public final int b() {
            return this.f10129b;
        }

        public final String c() {
            return this.c;
        }

        public final Bundle d() {
            Bundle r0 = new Bundle();
            r0.putString(ObricMemoryConstants.IN_APP_KEY_PACKAGE_NAME, this.f10128a.a());
            r0.putString(ObricMemoryConstants.IN_APP_KEY_ACTIVITY_NAME, this.f10128a.b());
            r0.putString(ObricMemoryConstants.IN_APP_KEY_ACTIVITY_RULE_VERSION, this.c);
            return r0;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10128a, r6.f10128a) == true) goto L12;
            return false;
        L12:
            if (this.f10129b == r6.f10129b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f10128a.hashCode() * 31) + Integer.hashCode(this.f10129b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "ActivityRules(key=" + this.f10128a + ", engineVersion=" + this.f10129b + ", ruleVersion=" + this.c + ", variants=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$ActivityVariant;", "", "minVersionCode", "", "maxVersionCode", "rulesJson", "", "<init>", "(JJLjava/lang/String;)V", "getMinVersionCode", "()J", "getMaxVersionCode", "getRulesJson", "()Ljava/lang/String;", "matches", "", "versionCode", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f10130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f10131b;
        private final String c;

        public c(long r2, long r4, String r6) {
            Intrinsics.checkNotNullParameter(r6, "rulesJson");
            this.f10130a = r2;
            this.f10131b = r4;
            this.c = r6;
        }

        public final long a() {
            return this.f10130a;
        }

        public final boolean a(long r8) {
            if (r8 < 0) goto L5;
            long r5 = this.f10130a;
            if (r5 >= 0) goto L14;
        L15:
            long r6 = this.f10131b;
            if (r6 >= 0) goto L18;
            return true;
        L18:
            if (r8 > r6) goto L21;
            return true;
        L21:
            return false;
        L14:
            if (r8 < r5) goto L21;
        L5:
            if (this.f10130a >= 0) goto L10;
            if (this.f10131b >= 0) goto L10;
            return true;
        L10:
            return false;
        }

        public final long b() {
            return this.f10131b;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
            return false;
        L8:
            c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.memorydata.plugin");
            if (this.f10130a == r10.f10130a) goto L12;
            return false;
        L12:
            if (this.f10131b == r10.f10131b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f10130a) * 31) + Long.hashCode(this.f10131b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "ActivityVariant(minVersionCode=" + this.f10130a + ", maxVersionCode=" + this.f10131b + ", rulesJson=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0007H\u0002¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$Companion;", "", "<init>", "()V", "parse", "Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog;", "catalogJson", "", "emittedEvents", "", "rule", "Lorg/json/JSONObject;", "favoriteAction", "Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$FavoriteEvent;", "eventType", "sha256", EventBody.KEY_VALUE, "runtimeRule", AILabCheckPermissionTask.KEY_SOURCE, "activityName", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d {

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class a<T> implements Comparator {
            public a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r8, T r9) {
                c r7 = (c) ZeusTransformUtils.preCheckCast(r8, c.class, "com.obric.memorydata.plugin");
                long r1 = Long.MIN_VALUE;
                if (r7.a() >= 0) goto L5;
                long r10 = Long.MIN_VALUE;
            L6:
                Comparable r11 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r10), Comparable.class, "com.obric.memorydata.plugin");
                c r12 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.memorydata.plugin");
                if (r12.a() < 0) goto L11;
                r1 = r12.a();
            L11:
                return ComparisonsKt.compareValues(r11, (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r1), Comparable.class, "com.obric.memorydata.plugin"));
            L5:
                r10 = r7.a();
                goto L6
            }
        }

        private d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker r1) {
            this();
        }

        private static final CharSequence a(byte r3) {
            String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
            Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
            return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        }

        private static final CharSequence a(c r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            StringBuilder r0 = new StringBuilder().append(r4.a()).append(':').append(r4.b()).append(':');
            d r1 = g.f10124a;
            JSONObject r2 = new JSONObject(r4.c());
            r2.remove("templateVersion");
            Unit r5 = Unit.INSTANCE;
            String r6 = r2.toString();
            Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
            return (CharSequence) ZeusTransformUtils.preCheckCast(r0.append(r1.c(r6)).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        }

        private static final Comparable a(b r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            return (Comparable) ZeusTransformUtils.preCheckCast(r2.a().a(), Comparable.class, "com.obric.memorydata.plugin");
        }

        private final List<String> a(JSONObject r8) {
            JSONObject r0 = r8.optJSONObject("emit");
            if (r0 == null) goto L5;
            JSONArray r1 = r0.optJSONArray("cases");
        L7:
            if (r1 != null) goto L9;
            List r2 = CollectionsKt.emptyList();
        L23:
            Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin");
            JSONObject r9 = r8.optJSONObject(ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CONFIRM);
            if (r9 == null) goto L28;
            List<String> r7 = a(r9);
            if (r7 == null) goto L28;
        L30:
            return CollectionsKt.plus(r3, (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"));
        L28:
            r7 = CollectionsKt.emptyList();
            goto L30
        L9:
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r1.length()), Iterable.class, "com.obric.memorydata.plugin");
            Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r6 = r4.iterator();
        L11:
            if (r6.hasNext() == false) goto L22;
            JSONObject r10 = r1.optJSONObject(((IntIterator) ZeusTransformUtils.preCheckCast(r6, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
            if (r10 == null) goto L19;
            String r11 = r10.optString("eventType");
            if (r11 == null) goto L19;
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L19;
        L20:
            if (r11 == null) goto L11;
            r5.add(r11);
        L19:
            r11 = null;
            goto L20
        L22:
            r2 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
            goto L23
        L5:
            r1 = null;
            goto L7
        }

        private final JSONObject a(JSONObject r3, String r4) {
            JSONObject r2 = new JSONObject(r3.toString());
            JSONObject r5 = new JSONObject(r2.getJSONObject("scope").toString());
            r5.remove("activities");
            r5.put("activityNames", new JSONArray().put(r4));
            Unit r6 = Unit.INSTANCE;
            r2.put("scope", r5);
            r2.remove("sceneDesc");
            r2.remove("rationaleDesc");
            return r2;
        }

        private final e b(String r10) {
            String r9 = "_UNFAVORITED";
            boolean r0 = false;
            if (StringsKt.endsWith$default(r10, "_UNFAVORITED", false, 2, null) == false) goto L6;
        L8:
            if (r0 == false) goto L10;
            r9 = "_FAVORITED";
        L10:
            String r11 = StringsKt.removeSuffix(r10, (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"));
            int r12 = r11.hashCode();
            if (r12 == 421503586) goto L26;
            if (r12 == 918950238) goto L22;
            if (r12 == 948532691) goto L18;
        L28:
            StringBuilder r13 = new StringBuilder();
            Locale r1 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(r1, "ROOT");
            String r3 = r11.toLowerCase(r1);
            Intrinsics.checkNotNullExpressionValue(r3, "toLowerCase(...)");
            String r14 = r13.append(StringsKt.replace$default(r3, '_', '.', false, 4, null)).append(".favorite").toString();
        L30:
            return new e(r0, r14);
        L18:
            if (r11.equals("OBRIC_BROWSER_BOOKMARK") == false) goto L28;
            r14 = "obric.browser.bookmark";
            goto L30
        L22:
            if (r11.equals("XHS_VIDEO_FEED") == false) goto L28;
            r14 = "xhs.video.feed.favorite";
            goto L30
        L26:
            if (r11.equals("XHS_NOTE_DETAIL") == false) goto L28;
            r14 = "xhs.note.detail.favorite";
            goto L30
        L6:
            if (StringsKt.endsWith$default(r10, "_FAVORITED", false, 2, null) == false) goto L31;
            r0 = true;
            goto L8
        L31:
            return null;
        }

        private static final Comparable b(b r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            return (Comparable) ZeusTransformUtils.preCheckCast(r2.a().b(), Comparable.class, "com.obric.memorydata.plugin");
        }

        private static final CharSequence c(b r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a().a() + '/' + r2.a().b() + '=' + r2.c(), CharSequence.class, "com.obric.memorydata.plugin");
        }

        private final String c(String r11) {
            MessageDigest r10 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
            byte[] r12 = r11.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(r12, "getBytes(...)");
            byte[] r1 = r10.digest(r12);
            Intrinsics.checkNotNullExpressionValue(r1, "digest(...)");
            return ArraysKt.joinToString$default(r1, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$g$d$t_khwP1OJjZKjLLnIs6tsaoOZQ.INSTANCE, 30, null);
        }

        public static /* synthetic */ CharSequence lambda$HU7yGIRWSBD7vdtBAlsnlWCo2lk(b r0) {
            return c(r0);
        }

        public static /* synthetic */ Comparable lambda$aLNF6IiVr3vzn0BKdBu2zVfgbCE(b r0) {
            return b(r0);
        }

        /* JADX INFO: renamed from: lambda$oqsnzxoAOuD-8fjixm1eHLkr-I0, reason: not valid java name */
        public static /* synthetic */ CharSequence m695lambda$oqsnzxoAOuD8fjixm1eHLkrI0(c r0) {
            return a(r0);
        }

        /* JADX INFO: renamed from: lambda$t-_khwP1OJjZKjLLnIs6tsaoOZQ, reason: not valid java name */
        public static /* synthetic */ CharSequence m696lambda$t_khwP1OJjZKjLLnIs6tsaoOZQ(byte r0) {
            return a(r0);
        }

        public static /* synthetic */ Comparable lambda$w_aT4CVVGX3Nl4lqAvaDwE_ernI(b r0) {
            return a(r0);
        }

        public final g a(String r43) {
            Intrinsics.checkNotNullParameter(r43, "catalogJson");
            JSONObject r2 = new JSONObject(r43);
            String r1 = "engineVersion";
            int r3 = r2.getInt("engineVersion");
            String r4 = "templateVersion";
            long r5 = r2.getLong("templateVersion");
            String r7 = "defaults";
            JSONObject r8 = r2.getJSONObject("defaults");
            LinkedHashMap r9 = new LinkedHashMap();
            LinkedHashMap r10 = new LinkedHashMap();
            JSONArray r6 = r2.getJSONArray("apps");
            int r11 = r6.length();
            int r13 = 0;
        L4:
            if (r13 >= r11) goto L63;
            JSONObject r14 = r6.getJSONObject(r13);
            String r15 = r14.getString(ObricMemoryConstants.KEY_PACKAGE_NAME);
            JSONArray r19 = r6;
            JSONObject r12 = r14.getJSONObject("appConstraint");
            int r20 = r11;
            long r27 = r12.getLong("minVersionCode");
            long r29 = r12.getLong("maxVersionCode");
            if (r27 >= (-1)) goto L8;
        L16:
            boolean r16 = false;
        L17:
            if (r16 == false) goto L62;
            LinkedHashMap r17 = new LinkedHashMap();
            String r18 = "rules";
            int r110 = r13;
            JSONArray r111 = r14.getJSONArray("rules");
            LinkedHashMap r31 = r9;
            int r21 = r111.length();
            String r112 = r7;
            int r22 = 0;
        L19:
            if (r22 >= r21) goto L49;
            int r23 = r21;
            JSONObject r24 = r111.getJSONObject(r22);
            JSONArray r25 = r111;
            JSONObject r113 = r24.getJSONObject("scope");
            JSONObject r32 = r8;
            String r26 = "activityNames";
            if (r113.has("activityNames") == true) goto L24;
            r26 = "activities";
        L24:
            JSONArray r28 = r113.getJSONArray(r26);
            int r114 = r28.length();
            String r33 = r4;
            int r30 = 0;
        L25:
            if (r30 >= r114) goto L48;
            int r210 = r114;
            String r115 = r28.getString(r30);
            Intrinsics.checkNotNull(r115);
            JSONArray r211 = r28;
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r115, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L29;
        L31:
            boolean r34 = false;
        L33:
            if (r34 == false) goto L47;
            Intrinsics.checkNotNull(r15);
            a r35 = new a(r15, r115);
            Intrinsics.checkNotNull(r24);
            String r36 = r1;
            Iterator r37 = ((Iterable) ZeusTransformUtils.preCheckCast(a(r24), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L36:
            if (r37.hasNext() == false) goto L42;
            Iterator r212 = r37;
            String r38 = (String) ZeusTransformUtils.preCheckCast(r37.next(), String.class, "com.obric.memorydata.plugin");
            e r39 = g.f10124a.b(r38);
            int r310 = r3;
            if (r39 == null) goto L41;
            Map r40 = (Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.memorydata.plugin");
            String r116 = r24.getString(OaidModel.KEY_ID);
            Intrinsics.checkNotNullExpressionValue(r116, "getString(...)");
            r40.put(new f(r15, r115, r116, r38), r39);
        L41:
            r37 = r212;
            r3 = r310;
            r10 = r10;
            r18 = r18;
            r14 = r14;
            goto L36
        L42:
            int r311 = r3;
            LinkedHashMap r312 = r10;
            String r313 = r18;
            JSONObject r41 = r14;
            Map r42 = (Map) ZeusTransformUtils.preCheckCast(r17, Map.class, "com.obric.memorydata.plugin");
            Object r44 = r42.get(r35);
            if (r44 != null) goto L45;
            r44 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            r42.put(r35, r44);
        L45:
            ((Collection) ZeusTransformUtils.preCheckCast(r44, Collection.class, "com.obric.memorydata.plugin")).add(a(r24, r115));
            r30 = r30 + 1;
            r114 = r210;
            r28 = r211;
            r5 = r5;
            r1 = r36;
            r3 = r311;
            r10 = r312;
            r18 = r313;
            r14 = r41;
            goto L25
        L47:
            throw new IllegalArgumentException(("L1 mock rule requires an exact activityName: " + r24.optString(OaidModel.KEY_ID)).toString());
        L29:
            if (Intrinsics.areEqual(r115, "*") == true) goto L31;
            r34 = true;
            goto L33
        L48:
            r22 = r22 + 1;
            r21 = r23;
            r111 = r25;
            r8 = r32;
            r4 = r33;
            goto L19
        L49:
            String r314 = r1;
            int r315 = r3;
            String r316 = r4;
            long r317 = r5;
            JSONObject r318 = r8;
            LinkedHashMap r319 = r10;
            String r320 = r18;
            JSONObject r45 = r14;
            Iterator r46 = ((Map) ZeusTransformUtils.preCheckCast(r17, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
        L51:
            if (r46.hasNext() == false) goto L60;
            Map.Entry r47 = (Map.Entry) ZeusTransformUtils.preCheckCast(r46.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            a r48 = (a) ZeusTransformUtils.preCheckCast(r47.getKey(), a.class, "com.obric.memorydata.plugin");
            List r49 = (List) ZeusTransformUtils.preCheckCast(r47.getValue(), List.class, "com.obric.memorydata.plugin");
            JSONObject r50 = new JSONObject(r45.toString());
            JSONArray r51 = new JSONArray();
            Iterator r52 = ((Iterable) ZeusTransformUtils.preCheckCast(r49, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L54:
            if (r52.hasNext() == false) goto L56;
            r51.put((JSONObject) ZeusTransformUtils.preCheckCast(r52.next(), JSONObject.class, "com.obric.memorydata.plugin"));
            goto L54
        L56:
            Unit r53 = Unit.INSTANCE;
            String r54 = r320;
            r50.put(r54, r51);
            JSONObject r55 = new JSONObject();
            String r56 = r314;
            int r57 = r315;
            r55.put(r56, r57);
            String r117 = r316;
            long r58 = r317;
            r55.put(r117, r58);
            String r118 = r112;
            r55.put(r118, new JSONObject(r318.toString()));
            r55.put("app", r50);
            LinkedHashMap r119 = r31;
            Map r59 = (Map) ZeusTransformUtils.preCheckCast(r119, Map.class, "com.obric.memorydata.plugin");
            Object r120 = r59.get(r48);
            if (r120 != null) goto L59;
            r120 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            r59.put(r48, r120);
        L59:
            Collection r60 = (Collection) ZeusTransformUtils.preCheckCast(r120, Collection.class, "com.obric.memorydata.plugin");
            String r61 = r55.toString();
            Intrinsics.checkNotNullExpressionValue(r61, "toString(...)");
            r60.add(new c(r27, r29, r61));
            r315 = r57;
            r320 = r54;
            r314 = r56;
            r317 = r58;
            r316 = r117;
            r31 = r119;
            r112 = r118;
            goto L51
        L60:
            r3 = r315;
            r5 = r317;
            r4 = r316;
            r9 = r31;
            r6 = r19;
            r11 = r20;
            r8 = r318;
            r10 = r319;
            r13 = r110 + 1;
            r1 = r314;
            r7 = r112;
            goto L4
        L62:
            throw new IllegalArgumentException(("invalid appConstraint for " + r15).toString());
        L8:
            if (r29 < (-1)) goto L16;
            if (r27 >= 0) goto L12;
        L15:
            r16 = true;
            goto L17
        L12:
            if (r29 < 0) goto L15;
            if (r27 > r29) goto L16;
        L63:
            int r62 = r3;
            LinkedHashMap r321 = r10;
            Map r63 = (Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.memorydata.plugin");
            Map r64 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r63.size())), Map.class, "com.obric.memorydata.plugin");
            Iterator r65 = ((Iterable) ZeusTransformUtils.preCheckCast(r63.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L65:
            if (r65.hasNext() == false) goto L87;
            Object r66 = r65.next();
            Object r67 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r66, Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
            Map.Entry r68 = (Map.Entry) ZeusTransformUtils.preCheckCast(r66, Map.Entry.class, "com.obric.memorydata.plugin");
            a r69 = (a) ZeusTransformUtils.preCheckCast(r68.getKey(), a.class, "com.obric.memorydata.plugin");
            List r70 = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r68.getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.memorydata.plugin"));
            Iterator r71 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.zipWithNext((Iterable) ZeusTransformUtils.preCheckCast(r70, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L68:
            if (r71.hasNext() == false) goto L85;
            Pair r121 = (Pair) ZeusTransformUtils.preCheckCast(r71.next(), Pair.class, "com.obric.memorydata.plugin");
            c r122 = (c) ZeusTransformUtils.preCheckCast(r121.component1(), c.class, "com.obric.memorydata.plugin");
            c r123 = (c) ZeusTransformUtils.preCheckCast(r121.component2(), c.class, "com.obric.memorydata.plugin");
            if (r122.b() >= 0) goto L72;
            long r124 = Long.MAX_VALUE;
        L74:
            if (r123.a() >= 0) goto L76;
            long r125 = Long.MIN_VALUE;
        L78:
            if (r124 >= r125) goto L80;
            boolean r126 = true;
        L81:
            if (r126 == true) goto L68;
            throw new IllegalArgumentException(("overlapping appConstraint for " + r69.a() + '/' + r69.b()).toString());
        L80:
            r126 = false;
            goto L81
        L76:
            r125 = r123.a();
            goto L78
        L72:
            r124 = r122.b();
            goto L74
        L85:
            r64.put(r67, new b(r69, r62, StringsKt.take(g.f10124a.c(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r70, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$g$d$oqsnzxoAOuD8fjixm1eHLkrI0.INSTANCE, 30, null)), 16), r70));
            goto L65
        L87:
            return new g(StringsKt.take(c(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r64.values(), Iterable.class, "com.obric.memorydata.plugin"), ComparisonsKt.compareBy(new Function1[]{$$Lambda$g$d$w_aT4CVVGX3Nl4lqAvaDwE_ernI.INSTANCE, $$Lambda$g$d$aLNF6IiVr3vzn0BKdBu2zVfgbCE.INSTANCE})), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$g$d$HU7yGIRWSBD7vdtBAlsnlWCo2lk.INSTANCE, 30, null)), 16), r64, (Map) ZeusTransformUtils.preCheckCast(r321, Map.class, "com.obric.memorydata.plugin"), null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$FavoriteEvent;", "", "favorite", "", "ruleFamily", "", "<init>", "(ZLjava/lang/String;)V", "getFavorite", "()Z", "getRuleFamily", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f10132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10133b;

        public e(boolean r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "ruleFamily");
            this.f10132a = r2;
            this.f10133b = r3;
        }

        public final boolean a() {
            return this.f10132a;
        }

        public final String b() {
            return this.f10133b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
            if (this.f10132a == r6.f10132a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10133b, r6.f10133b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f10132a) * 31) + this.f10133b.hashCode();
        }

        public String toString() {
            return "FavoriteEvent(favorite=" + this.f10132a + ", ruleFamily=" + this.f10133b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$FavoriteEventKey;", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "activityName", "ruleId", "eventType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "getActivityName", "getRuleId", "getEventType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10135b;
        private final String c;
        private final String d;

        public f(String r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(r3, "activityName");
            Intrinsics.checkNotNullParameter(r4, "ruleId");
            Intrinsics.checkNotNullParameter(r5, "eventType");
            this.f10134a = r2;
            this.f10135b = r3;
            this.c = r4;
            this.d = r5;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10134a, r6.f10134a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10135b, r6.f10135b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f10134a.hashCode() * 31) + this.f10135b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "FavoriteEventKey(packageName=" + this.f10134a + ", activityName=" + this.f10135b + ", ruleId=" + this.c + ", eventType=" + this.d + ')';
        }
    }

    static {
        f10124a = new d(null);
    }

    private g(String r3, Map<a, b> r4, Map<f, e> r5) {
        Map<a, b> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Map<f, e> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        this.f10125b = r3;
        this.c = r6;
        this.d = r7;
    }

    public /* synthetic */ g(String r2, Map r3, Map r4, DefaultConstructorMarker r5) {
        this(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
    }

    private static final Comparable a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (Comparable) ZeusTransformUtils.preCheckCast(r2.a().a(), Comparable.class, "com.obric.memorydata.plugin");
    }

    private static final Comparable b(b r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (Comparable) ZeusTransformUtils.preCheckCast(r2.a().b(), Comparable.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Comparable lambda$TMpIBHhEX2lCJEWC8iCPrQh_z2s(b r0) {
        return b(r0);
    }

    public static /* synthetic */ Comparable lambda$y3AinMBBp22mCyY61xqgNEK41yY(b r0) {
        return a(r0);
    }

    public final e a(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r3, "activityName");
        Intrinsics.checkNotNullParameter(r4, "ruleId");
        Intrinsics.checkNotNullParameter(r5, "eventType");
        return (e) ZeusTransformUtils.preCheckCast(this.d.get(new f(r2, r3, r4, r5)), e.class, "com.obric.memorydata.plugin");
    }

    public final String a() {
        return this.f10125b;
    }

    public final String a(String r2, String r3, int r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r3, "activityName");
        Intrinsics.checkNotNullParameter(r5, "ruleVersion");
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.c.get(new a(r2, r3)), b.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.b() == r4) goto L7;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == true) goto L13;
        r1 = null;
    L13:
        if (r1 != null) goto L15;
        return null;
    L15:
        return r1.a(r6);
    L7:
        if (Intrinsics.areEqual(r1.c(), r5) == false) goto L9;
        r7 = true;
        goto L10
    }

    public final ArrayList<Bundle> b() {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(this.c.values(), Iterable.class, "com.obric.memorydata.plugin"), ComparisonsKt.compareBy(new Function1[]{$$Lambda$g$y3AinMBBp22mCyY61xqgNEK41yY.INSTANCE, $$Lambda$g$TMpIBHhEX2lCJEWC8iCPrQh_z2s.INSTANCE})), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        r0.add(((b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.memorydata.plugin")).d());
        goto L4
    L7:
        return new ArrayList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
    }
}
