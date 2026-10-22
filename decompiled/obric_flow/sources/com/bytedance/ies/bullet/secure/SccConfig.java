package com.bytedance.ies.bullet.secure;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0002\u0005,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0005\u0010\u0015R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00108\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0015R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010'\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R$\u0010+\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0006\u001a\u0004\b)\u0010\b\"\u0004\b*\u0010\n¨\u0006-"}, d2 = {"Lcom/bytedance/ies/bullet/secure/SccConfig;", "", "<init>", "()V", "", "a", "Ljava/lang/Boolean;", "getEnableScc$anniex_release", "()Ljava/lang/Boolean;", "c", "(Ljava/lang/Boolean;)V", "enableScc", "b", "getDebug$anniex_release", "setDebug$anniex_release", "debug", "", "", "Ljava/util/List;", "getAllowList$anniex_release", "()Ljava/util/List;", "(Ljava/util/List;)V", "allowList", "Lcom/bytedance/ies/bullet/secure/SccConfig$a;", "d", "getDenyList$anniex_release", "setDenyList$anniex_release", "denyList", "", "e", "Ljava/lang/Integer;", "getMaxReloadCount$anniex_release", "()Ljava/lang/Integer;", "setMaxReloadCount$anniex_release", "(Ljava/lang/Integer;)V", "maxReloadCount", "f", "getMaxWaitTime$anniex_release", "setMaxWaitTime$anniex_release", "maxWaitTime", "g", "getEnablePrefetch$anniex_release", "setEnablePrefetch$anniex_release", "enablePrefetch", "SccLevel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nSccConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SccConfig.kt\ncom/bytedance/ies/bullet/secure/SccConfig\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,113:1\n1819#2,2:114\n1819#2,2:116\n1#3:118\n*E\n*S KotlinDebug\n*F\n+ 1 SccConfig.kt\ncom/bytedance/ies/bullet/secure/SccConfig\n*L\n58#1,2:114\n63#1,2:116\n*E\n"})
public final class SccConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("scc_cs_enable")
    private Boolean f5891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("scc_cs_debug")
    private Boolean f5892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("scc_cs_allow_list")
    private List<String> f5893c;

    @SerializedName("scc_cs_deny_list")
    private List<a> d;

    @SerializedName("scc_cs_max_reload_count")
    private Integer e;

    @SerializedName("scc_cs_max_wait_time")
    private Integer f;

    @SerializedName("scc_cs_enable_prefetch")
    private Boolean g;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/secure/SccConfig$SccLevel;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final enum SccLevel extends Enum<SccLevel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SccLevel f5894a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final SccLevel f5895b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final SccLevel f5896c = null;
        public static final /* synthetic */ SccLevel[] d = null;

        static {
            SccLevel r5 = new SccLevel("SAFE", 0);
            f5894a = r5;
            SccLevel r10 = new SccLevel("NOTICE", 1);
            f5895b = r10;
            SccLevel r11 = new SccLevel("DENY", 2);
            f5896c = r11;
            d = new SccLevel[]{r5, r10, r11};
        }

        public SccLevel(String r5, int r10) {
            super(r5, r10);
        }

        public static SccLevel valueOf(String r5) {
            return (SccLevel) Enum.valueOf(SccLevel.class, r5);
        }

        public static SccLevel[] values() {
            return (SccLevel[]) d.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/secure/SccConfig$a;", "", "<init>", "()V", "", "a", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "setReason", "(Ljava/lang/String;)V", "reason", "", "b", "Ljava/util/List;", "getUrlSet", "()Ljava/util/List;", "setUrlSet", "(Ljava/util/List;)V", "urlSet", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("reason")
        private String f5897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("urlSet")
        private List<String> f5898b;

        public a() {
        }
    }

    public SccConfig() {
        Boolean r5 = Boolean.FALSE;
        this.f5891a = r5;
        this.f5892b = r5;
        this.e = 5;
        this.f = 1000;
        this.g = r5;
    }

    public final SccConfig a() {
        SccConfig r5 = new SccConfig();
        r5.f5891a = this.f5891a;
        r5.f5892b = this.f5892b;
        ArrayList r10 = new ArrayList();
        List<String> r11 = this.f5893c;
        if (r11 == null) goto L8;
        Iterator<T> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r10.add((String) r12.next());
    L8:
        r5.f5893c = r10;
        ArrayList r13 = new ArrayList();
        List<a> r14 = this.d;
        if (r14 == null) goto L14;
        Iterator<T> r15 = r14.iterator();
    L12:
        if (r15.hasNext() == false) goto L14;
        r13.add((a) r15.next());
    L14:
        r5.d = r13;
        r5.e = this.e;
        r5.f = this.f;
        r5.g = this.g;
        return r5;
    }

    public final void b(SccConfig r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        Boolean r10 = r5.f5891a;
        if (r10 == null) goto L5;
        this.f5891a = r10;
    L5:
        Boolean r11 = r5.f5892b;
        if (r11 == null) goto L8;
        this.f5892b = r11;
    L8:
        Integer r12 = r5.e;
        if (r12 == null) goto L11;
        this.e = Integer.valueOf(r12.intValue());
    L11:
        Integer r13 = r5.f;
        if (r13 == null) goto L14;
        this.f = Integer.valueOf(r13.intValue());
    L14:
        Boolean r14 = r5.g;
        if (r14 == null) goto L18;
        this.g = r14;
        return;
    }

    public final void c(Boolean r5) {
        this.f5891a = r5;
    }

    public final void d(ArrayList r5) {
        this.f5893c = r5;
    }

    public final JsonObject e() {
        JsonElement r5 = new Gson().toJsonTree(this);     // Catch: Throwable -> L7
        if ((r5 instanceof JsonObject) == false) goto L9;
        return (JsonObject) r5;
    L9:
        return null;
    L7:
        th = move-exception;
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("Bullet_secure", "parse scc config error, e=" + th.getMessage(), null, 12);
        return null;
    }
}
