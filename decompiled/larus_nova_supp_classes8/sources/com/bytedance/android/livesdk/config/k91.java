package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR0\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R0\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/config/k91;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "", "sceneFlag", "I", "getSceneFlag", "()I", "setSceneFlag", "(I)V", "anchorSceneFlag", "getAnchorSceneFlag", "setAnchorSceneFlag", "", "timeout", "J", "b", "()J", "setTimeout", "(J)V", "isForceRecover", "c", "setForceRecover", "", "", "Lcom/bytedance/android/livesdk/config/k91$a;", "configs", "Ljava/util/Map;", "getConfigs", "()Ljava/util/Map;", "setConfigs", "(Ljava/util/Map;)V", "anchorConfigs", "getAnchorConfigs", "setAnchorConfigs", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k91 {

    @SerializedName("anchor_config")
    private Map<String, a> anchorConfigs;

    @SerializedName("anchor_scene_flag")
    private int anchorSceneFlag;

    @SerializedName("config")
    private Map<String, a> configs;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("is_force")
    private boolean isForceRecover;

    @SerializedName("scene_flag")
    private int sceneFlag;

    @SerializedName("timeout")
    private long timeout;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/config/k91$a;", "", "", "", "hybridPage", "Ljava/util/List;", "getHybridPage", "()Ljava/util/List;", "setHybridPage", "(Ljava/util/List;)V", "nativePage", "getNativePage", "setNativePage", "", "hybridEnable", "Z", "getHybridEnable", "()Z", "setHybridEnable", "(Z)V", "nativeEnable", "getNativeEnable", "setNativeEnable", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("hybrid_enable")
        private boolean hybridEnable;

        @SerializedName("hybrids")
        private List<String> hybridPage;

        @SerializedName("native_enable")
        private boolean nativeEnable;

        @SerializedName("natives")
        private List<String> nativePage;

        public final String toString() {
            return "config{hybrid_enable=" + this.hybridEnable + ",native_enable=" + this.nativeEnable + "}";
        }

        public a() {
            this.hybridPage = CollectionsKt.emptyList();
            this.nativePage = CollectionsKt.emptyList();
            this.hybridEnable = true;
            this.nativeEnable = true;
        }

        public final boolean a(String r7) {
            Intrinsics.checkNotNullParameter(r7, "page");
            if (this.hybridEnable == false) goto L19;
            List<String> r0 = this.hybridPage;
            Object r2 = null;
            if (r0 == null) goto L13;
            Iterator<T> r1 = r0.iterator();
        L8:
            if (r1.hasNext() == false) goto L12;
            Object r3 = r1.next();
            if (StringsKt.contains$default(r7, (String) r3, false, 2, null) == false) goto L8;
            r2 = r3;
        L12:
            r2 = (String) r2;
        L13:
            if (r2 == null) goto L20;
            return true;
        L20:
            return false;
        L19:
            return false;
        }

        public final boolean b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "page");
            if (this.nativeEnable == false) goto L9;
            List<String> r0 = this.nativePage;
            if (r0 == null) goto L9;
            if (r0.contains(r2) != true) goto L9;
            return true;
        L9:
            return false;
        }
    }

    public final String toString() {
        return "LinkWindowDegradeStrategy{config=" + this.configs + ",enable=" + this.enable + "}";
    }

    public k91() {
        this.sceneFlag = 127;
        this.anchorSceneFlag = 127;
        this.timeout = 100;
        this.isForceRecover = true;
        this.configs = MapsKt.emptyMap();
        this.anchorConfigs = MapsKt.emptyMap();
    }

    public final boolean a() {
        return this.enable;
    }

    public final long b() {
        return this.timeout;
    }

    public final boolean c() {
        return this.isForceRecover;
    }

    public final boolean f(int r2, boolean r3) {
        if (this.enable == false) goto L12;
        if (r3 == false) goto L6;
        Map<String, a> r4 = this.anchorConfigs;
    L7:
        if (r4 == null) goto L9;
        a r5 = r4.get(String.valueOf(r2));
    L10:
        if (r5 == null) goto L12;
        return true;
    L9:
        r5 = null;
        goto L10
    L6:
        r4 = this.configs;
    L12:
        return false;
    }

    public final boolean g(int r3, boolean r4) {
        if (this.enable == true) goto L5;
        return false;
    L5:
        if (r4 == false) goto L10;
        if ((this.anchorSceneFlag & r3) == r3) goto L11;
    L12:
        boolean r5 = false;
    L13:
        if (r5 == false) goto L17;
        return true;
    L17:
        return false;
    L11:
        r5 = true;
        goto L13
    L10:
        if ((this.sceneFlag & r3) != r3) goto L12;
        goto L11
    }

    public final boolean d(int r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "page");
        if (f(r2, r4) == false) goto L13;
        if (r4 == false) goto L6;
        Map<String, a> r5 = this.anchorConfigs;
    L7:
        if (r5 == null) goto L13;
        a r6 = r5.get(String.valueOf(r2));
        if (r6 == null) goto L13;
        if (r6.a(r3) != true) goto L13;
        return true;
    L6:
        r5 = this.configs;
    L13:
        return false;
    }

    public final boolean e(int r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "page");
        if (f(r2, r4) == false) goto L13;
        if (r4 == false) goto L6;
        Map<String, a> r5 = this.anchorConfigs;
    L7:
        if (r5 == null) goto L13;
        a r6 = r5.get(String.valueOf(r2));
        if (r6 == null) goto L13;
        if (r6.b(r3) != true) goto L13;
        return true;
    L6:
        r5 = this.configs;
    L13:
        return false;
    }
}
