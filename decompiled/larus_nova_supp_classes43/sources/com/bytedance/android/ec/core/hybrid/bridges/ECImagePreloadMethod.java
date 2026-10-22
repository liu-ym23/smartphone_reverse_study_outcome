package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.facebook.imagepipeline.common.Priority;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECImagePreloadMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECImagePreloadMethod extends ECBaseBridgeMethod {

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.ec.core.hybrid.bridges.ECImagePreloadMethod$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECImagePreloadMethod$a$a;", "", "", "", "imageUrl", "Ljava/util/List;", "b", "()Ljava/util/List;", "bizTag", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "sceneTag", "d", "priority", "c", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C0132a {

            @SerializedName("bizTag")
            private final String bizTag;

            @SerializedName("imageUrl")
            private final List<String> imageUrl;

            @SerializedName("priority")
            private final String priority;

            @SerializedName("sceneTag")
            private final String sceneTag;

            public final boolean equals(Object r10) {
                if (this != r10) goto L4;
                return true;
            L4:
                if ((r10 instanceof C0132a) == false) goto L14;
                C0132a r11 = (C0132a) r10;
                if (Intrinsics.areEqual(this.imageUrl, r11.imageUrl) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.bizTag, r11.bizTag) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.sceneTag, r11.sceneTag) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.priority, r11.priority) == true) goto L22;
                return false;
            L22:
                return true;
            L14:
                return false;
            }

            public final int hashCode() {
                List<String> r0 = this.imageUrl;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r10 = r0.hashCode();
            L6:
                int r11 = r10 * 31;
                String r12 = this.bizTag;
                if (r12 == null) goto L9;
                int r13 = r12.hashCode();
            L10:
                int r14 = (r11 + r13) * 31;
                String r15 = this.sceneTag;
                if (r15 == null) goto L13;
                int r16 = r15.hashCode();
            L14:
                int r17 = (r14 + r16) * 31;
                String r18 = this.priority;
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
                return "PreloadImageConfig(imageUrl=" + this.imageUrl + ", bizTag=" + this.bizTag + ", sceneTag=" + this.sceneTag + ", priority=" + this.priority + ")";
            }

            public C0132a() {
                this.imageUrl = null;
                this.bizTag = null;
                this.sceneTag = null;
                this.priority = null;
            }

            public final String a() {
                return this.bizTag;
            }

            public final List<String> b() {
                return this.imageUrl;
            }

            public final String c() {
                return this.priority;
            }

            public final String d() {
                return this.sceneTag;
            }
        }
    }

    static {
    }

    public final String getName() {
        return "ec.imagePreload";
    }

    public ECImagePreloadMethod() {
    }

    public final void c(JSONObject r13, ECBaseBridgeMethod.a r14) {
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r14, "iReturn");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L42
        a.C0132a r15 = (a.C0132a) u0.c().fromJson(r13.toString(), a.C0132a.class);     // Catch: Throwable -> L42
        if (r15 == null) goto L39;
        List<String> r1 = r15.b();     // Catch: Throwable -> L42
        if (r1 == null) goto L40;
        Iterator<T> r10 = r1.iterator();     // Catch: Throwable -> L42
    L9:
        if (r10.hasNext() == false) goto L40;
        String r11 = (String) r10.next();     // Catch: Throwable -> L42
        String r12 = r15.a();     // Catch: Throwable -> L42
        String r16 = "";
        if (r12 != null) goto L14;
        r12 = "";
    L14:
        String r17 = r15.d();     // Catch: Throwable -> L42
        if (r17 == null) goto L18;
        r16 = r17;
    L18:
        r r18 = new r(r12, r16);     // Catch: Throwable -> L42
        String r19 = r15.c();     // Catch: Throwable -> L42
        if (r19 != null) goto L21;
        Priority r20 = null;
    L38:
        ImageExtensionsKt.B(r11, r18, null, null, r20, null, null, false, 192);     // Catch: Throwable -> L42
        goto L9
    L21:
        switch(r19.hashCode()) {
            case -1078030475: goto L33;
            case 107348: goto L30;
            case 3202466: goto L27;
            case 1124382641: goto L24;
            default: goto L35;
        };     // Catch: Throwable -> L42
    L35:
        Priority r21 = null;
    L36:
        r20 = r21;
        goto L38
    L24:
        if (r19.equals("immediate") == false) goto L35;
        r21 = Priority.IMMEDIATE;     // Catch: Throwable -> L42
        goto L36
    L27:
        if (r19.equals("high") == false) goto L35;
        r21 = Priority.HIGH;     // Catch: Throwable -> L42
        goto L36
    L30:
        if (r19.equals("low") == false) goto L35;
        r21 = Priority.LOW;     // Catch: Throwable -> L42
        goto L36
    L33:
        if (r19.equals("medium") == false) goto L35;
        r21 = Priority.MEDIUM;     // Catch: Throwable -> L42
    L40:
        Result.constructor-impl(r15);     // Catch: Throwable -> L42
    L44:
        JSONObject r110 = new JSONObject();
        r110.putOpt("code", 1);
        Unit r22 = Unit.INSTANCE;
        r14.a(r110);
        return;
    L39:
        r15 = null;
    L42:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L44
    }
}
