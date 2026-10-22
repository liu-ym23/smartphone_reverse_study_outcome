package com.larus.feedback.impl.parser;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.larus.im.bean.InAppBannerScene;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import q99.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public static final Lazy<Gson> a = null;
    public static final Lazy<Type> b = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/feedback/impl/parser/FlowFeedbackDeliveryParser$Companion$metricsInfoType$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<Map<String, ? extends String>> {
        public a() {
        }
    }

    public static final class b {
    }

    /* JADX INFO: renamed from: com.larus.feedback.impl.parser.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0003J;\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR&\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/feedback/impl/parser/FlowFeedbackDeliveryParser$FeedbackCmdPayload;", "", "feedbackSceneName", "", "feedbackScene", "metricsInfo", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getFeedbackSceneName", "()Ljava/lang/String;", "getFeedbackScene", "getMetricsInfo", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C0119c {

        @SerializedName("feedback_scene")
        private final String feedbackScene;

        @SerializedName("feedback_scene_name")
        private final String feedbackSceneName;

        @SerializedName("metrics_info")
        private final Map<String, String> metricsInfo;

        public C0119c() {
            this(null, null, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0119c) == true) goto L8;
            return false;
        L8:
            C0119c r6 = (C0119c) r5;
            if (Intrinsics.areEqual(this.feedbackSceneName, r6.feedbackSceneName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.feedbackScene, r6.feedbackScene) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.metricsInfo, r6.metricsInfo) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.feedbackSceneName;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.feedbackScene;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Map<String, String> r7 = this.metricsInfo;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "FeedbackCmdPayload(feedbackSceneName=" + this.feedbackSceneName + ", feedbackScene=" + this.feedbackScene + ", metricsInfo=" + this.metricsInfo + ')';
        }

        public final String a() {
            return this.feedbackScene;
        }

        public final String b() {
            return this.feedbackSceneName;
        }

        public final Map<String, String> c() {
            return this.metricsInfo;
        }

        public C0119c(String r1, String r2, Map<String, String> r3) {
            this.feedbackSceneName = r1;
            this.feedbackScene = r2;
            this.metricsInfo = r3;
        }
    }

    public c() {
    }

    static {
        a = LazyKt.lazy(new com.larus.feedback.impl.parser.a());
        b = LazyKt.lazy(new com.larus.feedback.impl.parser.b());
    }

    public static e b(tc9.e r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r10.f(), InAppBannerScene.FEEDBACK_POPUP.getScene()) == false) goto L54;
        String r11 = r10.c();
        if (r11 != null) goto L10;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == false) goto L48;
        C0119c r3 = null;
    L29:
        if (r3 != null) goto L31;
        return null;
    L31:
        String r12 = r3.b();
        if (r12 != null) goto L34;
        return null;
    L34:
        if ((true ^ StringsKt.isBlank(r12)) == false) goto L36;
        String r6 = r12;
    L37:
        if (r6 == null) goto L55;
        String r13 = r3.a();
        if (r13 == null) goto L52;
        Integer r14 = StringsKt.toIntOrNull(r13);
        if (r14 == null) goto L53;
        int r15 = r14.intValue();
        Map<String, String> r0 = r3.c();
        if (r0 != null) goto L46;
        r0 = MapsKt.emptyMap();
    L46:
        Map<String, String> r8 = r0;
        return new e(r8.get("msg_id"), Integer.valueOf(r15), r6, null, r8, 49);
    L53:
        return null;
    L52:
        return null;
    L55:
        return null;
    L36:
        r6 = null;
        goto L37
    L48:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
        JsonObject r5 = (JsonObject) ((Gson) a.getValue()).fromJson(r11, JsonObject.class);     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L18
        Object r7 = Result.constructor-impl(new C0119c(a(r5, "feedback_scene_name"), a(r5, "feedback_scene"), c(a(r5, "metrics_info"))));     // Catch: Throwable -> L18
    L20:
        Throwable r9 = Result.exceptionOrNull-impl(r7);
        if (r9 != null) goto L24;
    L28:
        r3 = (C0119c) r7;
        goto L29
    L24:
        if ((r9 instanceof JsonSyntaxException) == false) goto L26;
        FLogger.a.e("FlowFeedbackDeliveryParser", "parse cmd payload failed, raw=" + r11, r9);
    L27:
        r7 = null;
        goto L28
    L26:
        FLogger.a.e("FlowFeedbackDeliveryParser", "parse cmd payload unexpected failed", r9);
    L18:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L10:
        if (StringsKt.isBlank(r11) == true) goto L13;
        r2 = false;
        goto L14
    L54:
        return null;
    }

    public static Map c(String r5) {
        if (r5 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        Object r1 = null;
        if (r0 == false) goto L21;
        return null;
    L21:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        Object r3 = Result.constructor-impl((Map) ((Gson) a.getValue()).fromJson(r5, (Type) b.getValue()));     // Catch: Throwable -> L13
    L15:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 != null) goto L18;
        r1 = r3;
    L20:
        return (Map) r1;
    L18:
        FLogger.a.e("FlowFeedbackDeliveryParser", "parse metrics_info failed, raw=" + r5, r4);
    L13:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L4:
        if (StringsKt.isBlank(r5) == true) goto L7;
        r0 = false;
        goto L8
    }

    public static String a(JsonObject r1, String r2) {
        JsonElement r3 = r1.get(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.isJsonNull() == false) goto L9;
        return null;
    L9:
        return r3.getAsString();
    }
}
