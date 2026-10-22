package com.obric.memorydata.personalcontext.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.logging.e;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.logging.w;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002./B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J)\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010H\u0000¢\u0006\u0002\b\u0013J{\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102U\u0010\u0014\u001aQ\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u001b\u0012\u0019\u0018\u00010\u001bj\u0004\u0018\u0001`\u001d¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001e0\u0015H\u0002J%\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00050 j\b\u0012\u0004\u0012\u00020\u0005`!2\u0006\u0010\u000e\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\"J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u001a\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005H\u0002J\u001e\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010+\u001a\u00020\u0005H\u0002J/\u0010,\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u000e\u0010\u001c\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001dH\u0002¢\u0006\u0002\u0010-R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/AgentRuntimeContextReader;", "", "<init>", "()V", "OPERATION", "", "EXTRA_KEYS", "EMPTY_RESULT", "KEY_PLAYING_APPS", "KEY_PAUSED_APPS", "KEY_BUSINESS_SCENE", "supportedKeys", "", "get", TrackerImpl.PARAMS, "mediaSessionSource", "Lkotlin/Function0;", "", "Lcom/obric/memorydata/personalcontext/impl/AgentRuntimeContextReader$MediaSessionFact;", "get$personal_context_obricRelease", "failureLogger", "Lkotlin/Function3;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "code", "", "keyCount", "Ljava/lang/Exception;", "error", "Lkotlin/Exception;", "", "parseRequestedKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "parseRequestedKeys$personal_context_obricRelease", "readMediaSessions", "resolveAppLabel", "packageManager", "Landroid/content/pm/PackageManager;", ObricMemoryConstants.KEY_PACKAGE_NAME, "buildMediaField", "Lcom/obric/memorydata/personalcontext/impl/AgentRuntimeContextReader$MediaFieldResult;", "sessions", "key", "logFailure", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Exception;)V", "MediaSessionFact", "MediaFieldResult", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12190a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f12191b = null;

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.impl.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/AgentRuntimeContextReader$MediaFieldResult;", "", EventBody.KEY_VALUE, "", "hasLabelFailure", "", "<init>", "(Ljava/lang/String;Z)V", "getValue", "()Ljava/lang/String;", "getHasLabelFailure", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0655a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12193b;

        public C0655a(String r1, boolean r2) {
            this.f12192a = r1;
            this.f12193b = r2;
        }

        public final String a() {
            return this.f12192a;
        }

        public final boolean b() {
            return this.f12193b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0655a.class) == true) goto L8;
            return false;
        L8:
            C0655a r6 = (C0655a) ZeusTransformUtils.preCheckCast(r5, C0655a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12192a, r6.f12192a) == true) goto L12;
            return false;
        L12:
            if (this.f12193b == r6.f12193b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.f12192a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + Boolean.hashCode(this.f12193b);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "MediaFieldResult(value=" + this.f12192a + ", hasLabelFailure=" + this.f12193b + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J:\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\tHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/AgentRuntimeContextReader$MediaSessionFact;", "", "state", "", "playbackSpeed", "", "lastPositionUpdateTime", "", "appLabel", "", "<init>", "(Ljava/lang/Integer;FJLjava/lang/String;)V", "getState", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPlaybackSpeed", "()F", "getLastPositionUpdateTime", "()J", "getAppLabel", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;FJLjava/lang/String;)Lcom/obric/memorydata/personalcontext/impl/AgentRuntimeContextReader$MediaSessionFact;", "equals", "", "other", "hashCode", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Integer f12194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f12195b;
        private final long c;
        private final String d;

        public b(Integer r1, float r2, long r3, String r5) {
            this.f12194a = r1;
            this.f12195b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final Integer a() {
            return this.f12194a;
        }

        public final float b() {
            return this.f12195b;
        }

        public final long c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12194a, r10.f12194a) == true) goto L12;
            return false;
        L12:
            if (Float.compare(this.f12195b, r10.f12195b) == 0) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            Integer r0 = this.f12194a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((((r2 * 31) + Float.hashCode(this.f12195b)) * 31) + Long.hashCode(this.c)) * 31;
            String r4 = this.d;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "MediaSessionFact(state=" + this.f12194a + ", playbackSpeed=" + this.f12195b + ", lastPositionUpdateTime=" + this.c + ", appLabel=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin")).c()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin")).c()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f12190a = new a();
        f12191b = SetsKt.setOf(new String[]{"o_playing_media_session_apps", "o_paused_media_session_apps", "media_player_business_scene"});
    }

    private a() {
    }

    private final C0655a a(List<b> r14, String r15) {
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r13.iterator();
    L3:
        boolean r2 = true;
        if (r17.hasNext() == false) goto L26;
        Object r1 = r17.next();
        b r4 = (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r15, "o_playing_media_session_apps") == false) goto L16;
        Integer r5 = r4.a();
        if (r5 != null) goto L11;
    L23:
        r2 = false;
    L24:
        if (r2 == false) goto L3;
        r16.add(r1);
        goto L3
    L11:
        if (r5.intValue() != 3) goto L23;
        if (r4.b() <= 0.0f) goto L23;
    L16:
        if (Intrinsics.areEqual(r15, "o_paused_media_session_apps") == false) goto L23;
        Integer r6 = r4.a();
        if (r6 == null) goto L23;
        if (r6.intValue() != 2) goto L23;
    L26:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
        if (r18.isEmpty() == true) goto L29;
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r111 = r19.iterator();
    L32:
        if (r111.hasNext() == false) goto L36;
        String r3 = ((b) ZeusTransformUtils.preCheckCast(r111.next(), b.class, "com.obric.memorydata.plugin")).d();
        if (r3 == null) goto L32;
        r110.add(r3);
        goto L32
    L36:
        List r112 = (List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin");
        String r7 = null;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r112, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L39;
        List r113 = r112;
    L40:
        if (r113 == null) goto L43;
        r7 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r113, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L43:
        if (r112.size() != r18.size()) goto L47;
        r2 = false;
    L47:
        return new C0655a(r7, r2);
    L39:
        r113 = null;
        goto L40
    L29:
        return new C0655a("", false);
    }

    private final String a(PackageManager r5, String r6) {
        boolean r1 = false;
        ApplicationInfo r7 = r5.getApplicationInfo(r6, 0);     // Catch: RuntimeException -> L8 PackageManager.NameNotFoundException -> L10
        Intrinsics.checkNotNullExpressionValue(r7, "getApplicationInfo(...)");     // Catch: RuntimeException -> L8 PackageManager.NameNotFoundException -> L10
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5.getApplicationLabel(r7).toString(), CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: RuntimeException -> L8 PackageManager.NameNotFoundException -> L10
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L6;
        r1 = true;
    L6:
        if (r1 == true) goto L17;
        return null;
    L17:
        return r8;
    L10:
        e = move-exception;
        Exception r9 = (Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.memorydata.plugin");
        String r10 = "media_app_not_found";
    L12:
        a(r10, null, r9);
        return null;
    L8:
        e = move-exception;
        r9 = (Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.memorydata.plugin");
        r10 = "media_app_label_error";
        goto L12
    }

    private final String a(String r8, Function0<? extends List<b>> r9, Function3<? super String, ? super Integer, ? super Exception, Unit> r10) {
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Function3 r12 = (Function3) ZeusTransformUtils.wrapperContextForParams(r10, Function3.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(b(r8), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r7.iterator();
    L3:
        boolean r2 = true;
        if (r14.hasNext() == false) goto L13;
        Object r0 = r14.next();
        String r4 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r4, "o_playing_media_session_apps") == false) goto L8;
    L11:
        if (r2 == false) goto L3;
        r13.add(r0);
        goto L3
    L8:
        if (Intrinsics.areEqual(r4, "o_paused_media_session_apps") == true) goto L11;
        r2 = false;
        goto L11
    L13:
        LinkedHashSet r15 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r13, LinkedHashSet.class, "com.obric.memorydata.plugin");
        if (r15.isEmpty() == false) goto L40;
        return "{}";
    L40:
        List<b> r16 = (List) ZeusTransformUtils.preCheckCast(r11.invoke(), List.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L34 SecurityException -> L38
        JsonObject r17 = new JsonObject();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r5 = false;
    L19:
        if (r1.hasNext() == false) goto L30;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        C0655a r18 = f12190a.a(r16, r6);
        if (r5 == false) goto L23;
    L26:
        r5 = true;
    L27:
        String r19 = r18.a();
        if (r19 == null) goto L19;
        r17.addProperty(r6, r19);
        goto L19
    L23:
        if (r18.b() == true) goto L26;
        r5 = false;
        goto L27
    L30:
        if (r5 == false) goto L32;
        r12.invoke("media_label_unavailable", Integer.valueOf(r15.size()), null);
    L32:
        String r20 = r17.toString();
        Intrinsics.checkNotNullExpressionValue(r20, "toString(...)");
        return r20;
    L38:
        e = e;
        Integer r21 = Integer.valueOf(r15.size());
        String r22 = "media_session_security_error";
    L36:
        r12.invoke(r22, r21, e);
        return "{}";
    L34:
        e = e;
        r21 = Integer.valueOf(r15.size());
        r22 = "media_session_source_error";
        goto L36
    }

    private final List<b> a() {
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        MediaSessionManager r1 = (MediaSessionManager) ZeusTransformUtils.preCheckCast(r13.getSystemService(MediaSessionManager.class), MediaSessionManager.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L22;
        PackageManager r14 = r13.getPackageManager();
        List<MediaController> r2 = r1.getActiveSessions(null);
        Intrinsics.checkNotNullExpressionValue(r2, "getActiveSessions(...)");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L20;
        MediaController r6 = (MediaController) ZeusTransformUtils.preCheckCast(r5.next(), MediaController.class, "com.obric.memorydata.plugin");
        PlaybackState r7 = r6.getPlaybackState();
        if (r7 == null) goto L10;
        Integer r8 = Integer.valueOf(r7.getState());
    L11:
        if (r7 == null) goto L13;
        float r9 = r7.getPlaybackSpeed();
    L14:
        float r10 = r9;
        if (r7 == null) goto L17;
        long r11 = r7.getLastPositionUpdateTime();
    L18:
        long r12 = r11;
        a r15 = f12190a;
        Intrinsics.checkNotNull(r14);
        String r16 = r6.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r16, "getPackageName(...)");
        r4.add(new b(r8, r10, r12, r15.a(r14, r16)));
        goto L6
    L17:
        r11 = 0;
        goto L18
    L13:
        r9 = 0.0f;
        goto L14
    L10:
        r8 = null;
        goto L11
    L20:
        return (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
    L22:
        throw new IllegalStateException("MediaSessionManager unavailable");
    }

    public static final /* synthetic */ List a(a r0) {
        return r0.a();
    }

    public static final /* synthetic */ void a(a r0, String r1, Integer r2, Exception r3) {
        r0.a(r1, r2, r3);
    }

    private final void a(String r10, Integer r11, Exception r12) {
        String r0 = null;
        if (r12 == null) goto L9;
        StackTraceElement[] r1 = r12.getStackTrace();
        if (r1 == null) goto L9;
        StackTraceElement r2 = (StackTraceElement) ZeusTransformUtils.preCheckCast(ArraysKt.firstOrNull(r1), StackTraceElement.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        String r3 = r2.getClassName() + '.' + r2.getMethodName() + ':' + r2.getLineNumber();
    L10:
        o r9 = (o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin");
        e r8 = new e(null, null, null, 7, null);
        g r4 = new g();
        r4.a("operation", "getAgentRuntimeContext");
        r4.a("key_count", r11);
        if (r12 == null) goto L15;
        Class<?> r13 = r12.getClass();
        if (r13 == null) goto L15;
        r0 = r13.getName();
    L15:
        r4.a("error_type", r0);
        r4.a("failure_site", r3);
        r9.a(r10, "获取 Agent 运行时上下文失败，已降级", r8, r4.a());
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final String a(String r5) {
        Intrinsics.checkNotNullParameter(r5, TrackerImpl.PARAMS);
        return a(r5, (Function0) ZeusTransformUtils.preCheckCast(new AgentRuntimeContextReader$get$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new AgentRuntimeContextReader$get$2(this), Function3.class, "com.obric.memorydata.plugin"));
    }

    public final LinkedHashSet<String> b(String r6) {
        Intrinsics.checkNotNullParameter(r6, TrackerImpl.PARAMS);
        JsonElement r7 = JsonParser.parseString(r6);     // Catch: JsonParseException -> L32
        if (r7.isJsonObject() == false) goto L6;
        JsonElement r8 = r7.getAsJsonObject().get("keys");     // Catch: JsonParseException -> L32
        if (r8 == null) goto L31;
        if (r8.isJsonArray() == true) goto L13;
        r8 = null;
    L13:
        if (r8 == null) goto L31;
        JsonArray r9 = r8.getAsJsonArray();     // Catch: JsonParseException -> L32
        if (r9 == null) goto L31;
        LinkedHashSet<String> r2 = new LinkedHashSet();     // Catch: JsonParseException -> L32
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: JsonParseException -> L32
    L19:
        if (r10.hasNext() == false) goto L45;
        JsonElement r3 = (JsonElement) ZeusTransformUtils.preCheckCast(r10.next(), JsonElement.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L32
        if (r3.isJsonPrimitive() == false) goto L19;
        if (r3.getAsJsonPrimitive().isString() == false) goto L19;
        String r4 = r3.getAsString();     // Catch: JsonParseException -> L32
        if (f12191b.contains(r4) == true) goto L28;
        r4 = null;
    L28:
        if (r4 == null) goto L19;
        r2.add(r4);     // Catch: JsonParseException -> L32
        goto L19
    L45:
        return r2;
    L31:
        return new LinkedHashSet();
    L6:
        return new LinkedHashSet();
    L32:
        e = move-exception;
        a("params_parse_error", null, (Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.memorydata.plugin"));
        return new LinkedHashSet();
    }
}
