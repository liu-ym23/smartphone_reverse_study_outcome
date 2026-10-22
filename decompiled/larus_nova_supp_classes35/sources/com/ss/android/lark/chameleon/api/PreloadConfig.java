package com.ss.android.lark.chameleon.api;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\b\u0010#\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chameleon/api/PreloadConfig;", "Ljava/io/Serializable;", "scene", BuildConfig.FLAVOR, "policy", "Lcom/ss/android/lark/chameleon/api/PreloadPolicy;", ChameleonOpenTracker.OpenResult.TIMEOUT, BuildConfig.FLAVOR, "templateUrl", "(Ljava/lang/String;Lcom/ss/android/lark/chameleon/api/PreloadPolicy;JLjava/lang/String;)V", "getPolicy", "()Lcom/ss/android/lark/chameleon/api/PreloadPolicy;", "setPolicy", "(Lcom/ss/android/lark/chameleon/api/PreloadPolicy;)V", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "getTemplateUrl", "setTemplateUrl", "getTimeout", "()J", "setTimeout", "(J)V", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PreloadConfig implements Serializable {
    public static final Companion Companion = null;
    public static final long DEFAULT_TIMEOUT = 60000;
    private PreloadPolicy policy;
    private String scene;
    private String templateUrl;
    private long timeout;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/api/PreloadConfig$Companion;", BuildConfig.FLAVOR, "()V", "DEFAULT_TIMEOUT", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PreloadConfig() {
        this(null, null, 0, null, 15, null);
    }

    public static /* synthetic */ PreloadConfig copy$default(PreloadConfig r3, String r4, PreloadPolicy r5, long r6, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.scene;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.policy;
    L8:
        PreloadPolicy r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.timeout;
    L11:
        long r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.templateUrl;
    L14:
        String r7 = r4;
        return r3.copy(r7, r11, r0, r8);
    }

    public final String component1() {
        return this.scene;
    }

    public final PreloadPolicy component2() {
        return this.policy;
    }

    public final long component3() {
        return this.timeout;
    }

    public final String component4() {
        return this.templateUrl;
    }

    public final PreloadConfig copy(String r8, PreloadPolicy r9, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r8, "scene");
        Intrinsics.checkNotNullParameter(r9, "policy");
        Intrinsics.checkNotNullParameter(r12, "templateUrl");
        return new PreloadConfig(r8, r9, r10, r12);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof PreloadConfig) == true) goto L8;
        return false;
    L8:
        PreloadConfig r9 = (PreloadConfig) r8;
        if (Intrinsics.areEqual(this.scene, r9.scene) == true) goto L12;
        return false;
    L12:
        if (this.policy == r9.policy) goto L15;
        return false;
    L15:
        if (this.timeout == r9.timeout) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.templateUrl, r9.templateUrl) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.scene.hashCode() * 31) + this.policy.hashCode()) * 31;
        long r1 = this.timeout;
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.templateUrl.hashCode();
    }

    public String toString() {
        return "PreloadConfig(scene=" + this.scene + ", policy=" + this.policy + ", templateUrl='" + this.templateUrl + "', timeout=" + this.timeout + ')';
    }

    public final PreloadPolicy getPolicy() {
        return this.policy;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getTemplateUrl() {
        return this.templateUrl;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public final void setPolicy(PreloadPolicy r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.policy = r2;
    }

    public final void setScene(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scene = r2;
    }

    public final void setTemplateUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.templateUrl = r2;
    }

    public final void setTimeout(long r1) {
        this.timeout = r1;
    }

    public PreloadConfig(String r2, PreloadPolicy r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "policy");
        Intrinsics.checkNotNullParameter(r6, "templateUrl");
        this.scene = r2;
        this.policy = r3;
        this.timeout = r4;
        this.templateUrl = r6;
    }

    public /* synthetic */ PreloadConfig(String r4, PreloadPolicy r5, long r6, String r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = "DEFAULT";
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = PreloadPolicy.NO_PRELOAD;
    L8:
        PreloadPolicy r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = DEFAULT_TIMEOUT;
    L11:
        long r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r8 = BuildConfig.FLAVOR;
    L14:
        String r7 = r4;
        this(r7, r11, r0, r8);
    }
}
