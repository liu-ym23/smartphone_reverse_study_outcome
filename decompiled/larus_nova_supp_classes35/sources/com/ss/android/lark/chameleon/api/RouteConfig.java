package com.ss.android.lark.chameleon.api;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f¢\u0006\u0002\u0010\rJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u001d\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J)\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fHÆ\u0003J{\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\b\u0010'\u001a\u00020\u0006H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R:\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019¨\u0006("}, d2 = {"Lcom/ss/android/lark/chameleon/api/RouteConfig;", "Ljava/io/Serializable;", "hostConfig", "Lcom/ss/android/lark/chameleon/api/HostConfig;", "urlInterceptPaths", "Ljava/util/ArrayList;", BuildConfig.FLAVOR, "Lkotlin/collections/ArrayList;", "urlInterceptBlackListSchemes", "microAppInterceptConfig", "Ljava/util/HashMap;", "Lcom/ss/android/lark/chameleon/api/MicroAppInterceptConfig;", "Lkotlin/collections/HashMap;", "(Lcom/ss/android/lark/chameleon/api/HostConfig;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/HashMap;)V", "getHostConfig", "()Lcom/ss/android/lark/chameleon/api/HostConfig;", "setHostConfig", "(Lcom/ss/android/lark/chameleon/api/HostConfig;)V", "getMicroAppInterceptConfig", "()Ljava/util/HashMap;", "setMicroAppInterceptConfig", "(Ljava/util/HashMap;)V", "getUrlInterceptBlackListSchemes", "()Ljava/util/ArrayList;", "setUrlInterceptBlackListSchemes", "(Ljava/util/ArrayList;)V", "getUrlInterceptPaths", "setUrlInterceptPaths", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RouteConfig implements Serializable {
    private HostConfig hostConfig;
    private HashMap<String, MicroAppInterceptConfig> microAppInterceptConfig;
    private ArrayList<String> urlInterceptBlackListSchemes;
    private ArrayList<String> urlInterceptPaths;

    public RouteConfig() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RouteConfig copy$default(RouteConfig r0, HostConfig r1, ArrayList r2, ArrayList r3, HashMap r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.hostConfig;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.urlInterceptPaths;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.urlInterceptBlackListSchemes;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.microAppInterceptConfig;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final HostConfig component1() {
        return this.hostConfig;
    }

    public final ArrayList<String> component2() {
        return this.urlInterceptPaths;
    }

    public final ArrayList<String> component3() {
        return this.urlInterceptBlackListSchemes;
    }

    public final HashMap<String, MicroAppInterceptConfig> component4() {
        return this.microAppInterceptConfig;
    }

    public final RouteConfig copy(HostConfig r2, ArrayList<String> r3, ArrayList<String> r4, HashMap<String, MicroAppInterceptConfig> r5) {
        return new RouteConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RouteConfig) == true) goto L8;
        return false;
    L8:
        RouteConfig r6 = (RouteConfig) r5;
        if (Intrinsics.areEqual(this.hostConfig, r6.hostConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.urlInterceptPaths, r6.urlInterceptPaths) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.urlInterceptBlackListSchemes, r6.urlInterceptBlackListSchemes) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.microAppInterceptConfig, r6.microAppInterceptConfig) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        HostConfig r0 = this.hostConfig;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ArrayList<String> r4 = this.urlInterceptPaths;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ArrayList<String> r7 = this.urlInterceptBlackListSchemes;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        HashMap<String, MicroAppInterceptConfig> r10 = this.microAppInterceptConfig;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "RouteConfig(hostConfig=" + this.hostConfig + ", urlInterceptPaths=" + this.urlInterceptPaths + ", urlInterceptBlackListSchemes=" + this.urlInterceptBlackListSchemes + ", microAppInterceptConfig=" + this.microAppInterceptConfig + ')';
    }

    public final HostConfig getHostConfig() {
        return this.hostConfig;
    }

    public final HashMap<String, MicroAppInterceptConfig> getMicroAppInterceptConfig() {
        return this.microAppInterceptConfig;
    }

    public final ArrayList<String> getUrlInterceptBlackListSchemes() {
        return this.urlInterceptBlackListSchemes;
    }

    public final ArrayList<String> getUrlInterceptPaths() {
        return this.urlInterceptPaths;
    }

    public final void setHostConfig(HostConfig r1) {
        this.hostConfig = r1;
    }

    public final void setMicroAppInterceptConfig(HashMap<String, MicroAppInterceptConfig> r1) {
        this.microAppInterceptConfig = r1;
    }

    public final void setUrlInterceptBlackListSchemes(ArrayList<String> r1) {
        this.urlInterceptBlackListSchemes = r1;
    }

    public final void setUrlInterceptPaths(ArrayList<String> r1) {
        this.urlInterceptPaths = r1;
    }

    public RouteConfig(HostConfig r1, ArrayList<String> r2, ArrayList<String> r3, HashMap<String, MicroAppInterceptConfig> r4) {
        this.hostConfig = r1;
        this.urlInterceptPaths = r2;
        this.urlInterceptBlackListSchemes = r3;
        this.microAppInterceptConfig = r4;
    }

    public /* synthetic */ RouteConfig(HostConfig r2, ArrayList r3, ArrayList r4, HashMap r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
