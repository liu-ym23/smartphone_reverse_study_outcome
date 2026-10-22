package com.bytedance.android.ec.core.hybrid.prefetch;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/f;", "", "", "version", "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", "project", "getProject", "Lorg/json/JSONObject;", "rules", "Lorg/json/JSONObject;", "b", "()Lorg/json/JSONObject;", "prefetchApis", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("prefetch_apis")
    private final JSONObject prefetchApis;

    @SerializedName("project")
    private final String project;

    @SerializedName("rules")
    private final JSONObject rules;

    @SerializedName("version")
    private final String version;

    public static final class a {
    }

    static {
    }

    public f() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof f) == false) goto L14;
        f r11 = (f) r10;
        if (Intrinsics.areEqual(this.version, r11.version) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.project, r11.project) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rules, r11.rules) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.prefetchApis, r11.prefetchApis) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.version;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.project;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        JSONObject r15 = this.rules;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        JSONObject r18 = this.prefetchApis;
        if (r18 == null) goto L18;
        r1 = r18.hashCode();
    L18:
        return r17 + r1;
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "NativePreFetchConfig(version=" + this.version + ", project=" + this.project + ", rules=" + this.rules + ", prefetchApis=" + this.prefetchApis + ")";
    }

    public final JSONObject a() {
        return this.prefetchApis;
    }

    public final JSONObject b() {
        return this.rules;
    }

    public f(String r1, String r10, JSONObject r11, JSONObject r12) {
        this.version = r1;
        this.project = r10;
        this.rules = r11;
        this.prefetchApis = r12;
    }
}
