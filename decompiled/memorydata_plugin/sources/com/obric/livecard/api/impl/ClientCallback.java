package com.obric.livecard.api.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.livecard.api.IIslandCardCallback;
import com.obric.livecard.api.IslandCardCallback;
import com.obric.livecard.api.LiveCard;
import com.obric.livecard.api.annotation.Event;
import com.obric.livecard.api.annotation.Params;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001a\u0010\u0014\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/obric/livecard/api/impl/ClientCallback;", "Lcom/obric/livecard/api/IIslandCardCallback$Stub;", "session", "Lcom/obric/livecard/api/entity/IslandSession;", "(Lcom/obric/livecard/api/entity/IslandSession;)V", "customEventMethodMap", "", "", "Lcom/obric/livecard/api/impl/ClientCallback$MethodWrapper;", "mainHandler", "Landroid/os/Handler;", "getSession", "()Lcom/obric/livecard/api/entity/IslandSession;", "asBinder", "Landroid/os/IBinder;", "handleCardOnClick", "Landroid/os/Bundle;", TrackerImpl.PARAMS, "handleCustomEvent", "handleHasCardClick", "handleViewOnClick", "handleWidgetOnShow", "", "hasViewClickId", "viewId", "injectCustomEvent", "callback", "Lcom/obric/livecard/api/IslandCardCallback;", "onCardEvent", "event", "MethodWrapper", "ParameterWrapper", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClientCallback extends IIslandCardCallback.Stub {
    private final Map<String, MethodWrapper> customEventMethodMap;
    private final Handler mainHandler;
    private final IslandSession session;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/livecard/api/impl/ClientCallback$MethodWrapper;", "", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "getMethod", "()Ljava/lang/reflect/Method;", "parameters", "", "Lcom/obric/livecard/api/impl/ClientCallback$ParameterWrapper;", "getParameters", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MethodWrapper {
        private final Method method;
        private final List<ParameterWrapper> parameters;

        public MethodWrapper(Method r3) {
            Intrinsics.checkNotNullParameter(r3, "method");
            this.method = r3;
            this.parameters = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        }

        public static /* synthetic */ MethodWrapper copy$default(MethodWrapper r0, Method r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.method;
        L6:
            return r0.copy(r1);
        }

        public final Method component1() {
            return this.method;
        }

        public final MethodWrapper copy(Method r1) {
            Intrinsics.checkNotNullParameter(r1, "method");
            return new MethodWrapper(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, MethodWrapper.class) == true) goto L8;
            return false;
        L8:
            MethodWrapper r6 = (MethodWrapper) ZeusTransformUtils.preCheckCast(r5, MethodWrapper.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.method, r6.method) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final Method getMethod() {
            return this.method;
        }

        public final List<ParameterWrapper> getParameters() {
            return this.parameters;
        }

        public int hashCode() {
            return this.method.hashCode();
        }

        public String toString() {
            return "MethodWrapper(method=" + this.method + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\r\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\b\u0002\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/livecard/api/impl/ClientCallback$ParameterWrapper;", "", "required", "", ActivityLifecycle.NAME, "", "type", "Ljava/lang/Class;", "(ZLjava/lang/String;Ljava/lang/Class;)V", "getName", "()Ljava/lang/String;", "getRequired", "()Z", "getType", "()Ljava/lang/Class;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ParameterWrapper {
        private final String name;
        private final boolean required;
        private final Class<?> type;

        public ParameterWrapper(boolean r2, String r3, Class<?> r4) {
            Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r4, "type");
            this.required = r2;
            this.name = r3;
            this.type = r4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ParameterWrapper copy$default(ParameterWrapper r0, boolean r1, String r2, Class r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.required;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.name;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.type;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final boolean component1() {
            return this.required;
        }

        public final String component2() {
            return this.name;
        }

        public final Class<?> component3() {
            return this.type;
        }

        public final ParameterWrapper copy(boolean r1, String r2, Class<?> r3) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r3, "type");
            return new ParameterWrapper(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ParameterWrapper.class) == true) goto L8;
            return false;
        L8:
            ParameterWrapper r6 = (ParameterWrapper) ZeusTransformUtils.preCheckCast(r5, ParameterWrapper.class, "com.obric.memorydata.plugin");
            if (this.required == r6.required) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.type, r6.type) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean getRequired() {
            return this.required;
        }

        public final Class<?> getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean r0 = this.required;
            ?? r1 = r0;
            if (r0 == false) goto L6;
            r1 = 1;
        L6:
            return (((r1 * 31) + this.name.hashCode()) * 31) + this.type.hashCode();
        }

        public String toString() {
            return "ParameterWrapper(required=" + this.required + ", name=" + this.name + ", type=" + this.type + ')';
        }
    }

    public ClientCallback(IslandSession r4) {
        Intrinsics.checkNotNullParameter(r4, "session");
        this.session = r4;
        this.customEventMethodMap = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.mainHandler = new Handler(Looper.getMainLooper());
        injectCustomEvent(r4.getCallback());
    }

    private final Bundle handleCardOnClick(Bundle r3, final IslandSession r4) {
        String r2 = null;
        if (r3 == null) goto L37;
        String r5 = r3.getString("templateId");
        if (r5 == null) goto L38;
        IslandWidget r0 = r4.getCollapseWidget();
        if (r0 == null) goto L9;
        String r1 = r0.getTemplateId();
    L11:
        if (Intrinsics.areEqual(r5, r1) == false) goto L14;
        Function0<Boolean> r6 = new ClientCallback$handleCardOnClick$1$handled$1(r4);
    L13:
        boolean r7 = ((Boolean) ZeusTransformUtils.preCheckCast(ClientCallbackKt.runOnMainThreadBlock((Function0) ZeusTransformUtils.preCheckCast(r6, Function0.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L35:
        Bundle r8 = new Bundle();
        r8.putBoolean("handled", r7);
        return r8;
    L14:
        IslandWidget r9 = r4.getExpandWidget();
        if (r9 == null) goto L17;
        String r10 = r9.getTemplateId();
    L19:
        if (Intrinsics.areEqual(r5, r10) == false) goto L21;
        r6 = new ClientCallback$handleCardOnClick$1$handled$2(r4);
        goto L13
    L21:
        IslandWidget r11 = r4.getNotificationWidget();
        if (r11 == null) goto L24;
        String r12 = r11.getTemplateId();
    L26:
        if (Intrinsics.areEqual(r5, r12) == false) goto L28;
        r6 = new ClientCallback$handleCardOnClick$1$handled$3(r4);
        goto L13
    L28:
        IslandWidget r13 = r4.getNodeWidget();
        if (r13 == null) goto L32;
        r2 = r13.getTemplateId();
    L32:
        if (Intrinsics.areEqual(r5, r2) == false) goto L34;
        r6 = new ClientCallback$handleCardOnClick$1$handled$4(r4);
        goto L13
    L34:
        r7 = false;
        goto L35
    L24:
        r12 = null;
        goto L26
    L17:
        r10 = null;
        goto L19
    L9:
        r1 = null;
        goto L11
    L38:
        return null;
    L37:
        return null;
    }

    private final Bundle handleCustomEvent(Bundle r10, IslandSession r11) {
        if (r10 == null) goto L48;
        String r1 = r10.getString("eventName");
        if (r1 == null) goto L48;
        String r12 = r10.getString("eventParams");
        if (r12 == null) goto L10;
        JsonObject r13 = (JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r12, JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");
    L11:
        IslandCardCallback r14 = r11.getCallback();
        if (r14 != null) goto L16;
        Bundle r9 = new Bundle();
        String r15 = "client not register callback";
    L14:
        r9.putString(InfoRequestQPSOptTraceLogger.ERROR_MESSAGE, r15);
        return r9;
    L16:
        MethodWrapper r16 = (MethodWrapper) ZeusTransformUtils.preCheckCast(this.customEventMethodMap.get(r1), MethodWrapper.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L20;
        r9 = new Bundle();
        StringBuilder r17 = new StringBuilder().append("not found method : ").append(r1);
    L19:
        r15 = r17.toString();
        goto L14
    L20:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r16.getParameters(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r2.iterator();
    L22:
        if (r3.hasNext() == false) goto L42;
        ParameterWrapper r5 = (ParameterWrapper) ZeusTransformUtils.preCheckCast(r3.next(), ParameterWrapper.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L36;
        JsonElement r6 = r13.get(r5.getName());
        if (r6 == null) goto L36;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L29
        Object r8 = Result.m1421constructorimpl(new Gson().fromJson(r6, r5.getType()));     // Catch: Throwable -> L29
    L32:
        if (Result.m1424exceptionOrNullimpl(r8) != null) goto L33;
        Result.m1428isSuccessimpl(r8);
        if (Result.m1427isFailureimpl(r8) == true) goto L36;
    L38:
        if (r5.getRequired() == false) goto L41;
        if (r8 != null) goto L41;
        r9 = new Bundle();
        r17 = new StringBuilder().append("the ").append(r5.getName()).append(" is required");
    L41:
        r4.add(r8);
        goto L22
    L33:
        r9 = new Bundle();
        r17 = new StringBuilder().append("parse error, ").append(r5.getType()).append(" is not match ").append(r6).append(' ');
    L29:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L36:
        r8 = null;
        goto L38
    L42:
        List r19 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        Bundle r0 = new Bundle();
        Method r20 = r16.getMethod();
        Object[] r110 = ((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.memorydata.plugin")).toArray(new Object[0]);
        Objects.requireNonNull(r110, "null cannot be cast to non-null type kotlin.Array<T>");
        Object r21 = r20.invoke(r14, Arrays.copyOf(r110, r110.length));
        if (r21 == null) goto L47;
        Intrinsics.checkNotNullExpressionValue(r21, "invoke(callback, *args.toTypedArray())");
        String r22 = new Gson().toJson(r21);
        if (r22 == null) goto L47;
        Intrinsics.checkNotNullExpressionValue(r22, "let { Gson().toJson(it) }");
        r0.putString("result", r22);
    L47:
        return r0;
    L10:
        r13 = null;
    L48:
        r9 = new Bundle();
        r15 = "not found eventName";
        goto L14
    }

    private final Bundle handleHasCardClick(Bundle r4, IslandSession r5) {
        Function0<Unit> r3 = null;
        if (r4 == null) goto L52;
        String r6 = r4.getString("templateId");
        if (r6 == null) goto L53;
        IslandWidget r0 = r5.getCollapseWidget();
        if (r0 == null) goto L9;
        String r1 = r0.getTemplateId();
    L10:
        boolean r2 = true;
        if (Intrinsics.areEqual(r6, r1) == false) goto L18;
        IslandWidget r7 = r5.getCollapseWidget();
        if (r7 == null) goto L15;
        r3 = r7.getOnCardClickCallback();
    L15:
        if (r3 != null) goto L50;
    L17:
        r2 = false;
    L50:
        Bundle r8 = new Bundle();
        r8.putBoolean("result", r2);
        return r8;
    L18:
        IslandWidget r9 = r5.getExpandWidget();
        if (r9 == null) goto L21;
        String r10 = r9.getTemplateId();
    L23:
        if (Intrinsics.areEqual(r6, r10) == false) goto L29;
        IslandWidget r11 = r5.getExpandWidget();
        if (r11 == null) goto L27;
        r3 = r11.getOnCardClickCallback();
    L27:
        if (r3 == null) goto L17;
    L29:
        IslandWidget r12 = r5.getNotificationWidget();
        if (r12 == null) goto L32;
        String r13 = r12.getTemplateId();
    L34:
        if (Intrinsics.areEqual(r6, r13) == false) goto L40;
        IslandWidget r14 = r5.getNotificationWidget();
        if (r14 == null) goto L38;
        r3 = r14.getOnCardClickCallback();
    L38:
        if (r3 == null) goto L17;
    L40:
        IslandWidget r15 = r5.getNodeWidget();
        if (r15 == null) goto L43;
        String r16 = r15.getTemplateId();
    L45:
        if (Intrinsics.areEqual(r6, r16) == false) goto L17;
        IslandWidget r17 = r5.getNodeWidget();
        if (r17 == null) goto L49;
        r3 = r17.getOnCardClickCallback();
    L49:
        if (r3 == null) goto L17;
    L43:
        r16 = null;
        goto L45
    L32:
        r13 = null;
        goto L34
    L21:
        r10 = null;
        goto L23
    L9:
        r1 = null;
        goto L10
    L53:
        return null;
    L52:
        return null;
    }

    private final Bundle handleViewOnClick(Bundle r5, IslandSession r6) {
        if (r5 == null) goto L44;
        String r0 = r5.getString("viewId");
        if (r0 == null) goto L44;
        String r7 = r5.getString("templateId");
        final Function0<Unit> r2 = null;
        if (r7 == null) goto L38;
        IslandWidget r3 = r6.getCollapseWidget();
        if (r3 == null) goto L11;
        String r4 = r3.getTemplateId();
    L13:
        if (Intrinsics.areEqual(r4, r7) == false) goto L15;
        IslandWidget r8 = r6.getCollapseWidget();
    L37:
        if (r8 == null) goto L38;
    L39:
        if (r8 == null) goto L41;
        r2 = r8.findOnViewClickCallbackById(r0);
    L41:
        ClientCallbackKt.runOnMainThreadBlock((Function0) ZeusTransformUtils.preCheckCast(new ClientCallback$handleViewOnClick$1$1(r2), Function0.class, "com.obric.memorydata.plugin"));
        Bundle r9 = new Bundle();
        if (r2 != null) goto L46;
        String r10 = "client not register click listener";
    L45:
        r9.putString(InfoRequestQPSOptTraceLogger.ERROR_MESSAGE, r10);
    L46:
        return r9;
    L15:
        IslandWidget r11 = r6.getExpandWidget();
        if (r11 == null) goto L18;
        String r12 = r11.getTemplateId();
    L20:
        if (Intrinsics.areEqual(r12, r7) == false) goto L22;
        r8 = r6.getExpandWidget();
        goto L37
    L22:
        IslandWidget r13 = r6.getNotificationWidget();
        if (r13 == null) goto L25;
        String r14 = r13.getTemplateId();
    L27:
        if (Intrinsics.areEqual(r14, r7) == false) goto L29;
        r8 = r6.getNotificationWidget();
        goto L37
    L29:
        IslandWidget r15 = r6.getNodeWidget();
        if (r15 == null) goto L32;
        String r16 = r15.getTemplateId();
    L34:
        if (Intrinsics.areEqual(r16, r7) == false) goto L36;
        r8 = r6.getNodeWidget();
        goto L37
    L36:
        r8 = (IslandWidget) ZeusTransformUtils.preCheckCast(null, IslandWidget.class, "com.obric.memorydata.plugin");
        goto L37
    L32:
        r16 = null;
        goto L34
    L25:
        r14 = null;
        goto L27
    L18:
        r12 = null;
        goto L20
    L11:
        r4 = null;
    L38:
        r8 = r6.getCurrWidget();
    L44:
        r9 = new Bundle();
        r10 = "not found viewId";
        goto L45
    }

    private final void handleWidgetOnShow(Bundle r2, IslandSession r3) {
        if (r2 == null) goto L41;
        String r1 = r2.getString("templateId");
        if (r1 == null) goto L42;
        IslandWidget r4 = r3.getCollapseWidget();
        if (r4 == null) goto L8;
        String r5 = r4.getTemplateId();
    L10:
        if (Intrinsics.areEqual(r1, r5) == false) goto L13;
        IslandWidget r6 = r3.getCollapseWidget();
    L12:
        r3.setCurrWidget(r6);
    L35:
        IslandWidget r7 = r3.getCurrWidget();
        if (r7 == null) goto L43;
        IslandCardCallback r8 = r3.getCallback();
        if (r8 == null) goto L44;
        r8.onWidgetShow(r7);
        return;
    L44:
        return;
    L43:
        return;
    L13:
        IslandWidget r9 = r3.getExpandWidget();
        if (r9 == null) goto L16;
        String r10 = r9.getTemplateId();
    L18:
        if (Intrinsics.areEqual(r1, r10) == false) goto L20;
        r6 = r3.getExpandWidget();
        goto L12
    L20:
        IslandWidget r11 = r3.getNotificationWidget();
        if (r11 == null) goto L23;
        String r12 = r11.getTemplateId();
    L25:
        if (Intrinsics.areEqual(r1, r12) == false) goto L27;
        r6 = r3.getNotificationWidget();
        goto L12
    L27:
        IslandWidget r13 = r3.getNodeWidget();
        if (r13 == null) goto L30;
        String r14 = r13.getTemplateId();
    L32:
        if (Intrinsics.areEqual(r1, r14) == false) goto L34;
        r6 = r3.getNodeWidget();
        goto L12
    L34:
        r3.setCurrWidget(null);
        goto L35
    L30:
        r14 = null;
        goto L32
    L23:
        r12 = null;
        goto L25
    L16:
        r10 = null;
        goto L18
    L8:
        r5 = null;
        goto L10
    L42:
        return;
    }

    private final void injectCustomEvent(IslandCardCallback r17) {
        IslandCardCallback r0 = (IslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r17, IslandCardCallback.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        Method[] r1 = r0.getClass().getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(r1, "callback::class.java.declaredMethods");
        Object[] r2 = (Object[]) ZeusTransformUtils.preCheckCast(r1, Object[].class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r4 = r2.length;
        int r5 = 0;
    L6:
        boolean r6 = true;
        if (r5 >= r4) goto L18;
        Object r7 = r2[r5];
        Annotation[] r8 = ((Method) ZeusTransformUtils.preCheckCast(r7, Method.class, "com.obric.memorydata.plugin")).getAnnotations();
        Intrinsics.checkNotNullExpressionValue(r8, "it.annotations");
        Object[] r9 = (Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.memorydata.plugin");
        int r10 = r9.length;
        int r11 = 0;
    L9:
        if (r11 >= r10) goto L14;
        if (ZeusTransformUtils.instanceOf((Annotation) ZeusTransformUtils.preCheckCast(r9[r11], Annotation.class, "com.obric.memorydata.plugin"), Event.class) == true) goto L15;
        r11 = r11 + 1;
    L15:
        if (r6 == false) goto L17;
        r3.add(r7);
    L17:
        r5 = r5 + 1;
        goto L6
    L14:
        r6 = false;
        goto L15
    L18:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r12.hasNext() == false) goto L32;
        Method r13 = (Method) ZeusTransformUtils.preCheckCast(r12.next(), Method.class, "com.obric.memorydata.plugin");
        r13.setAccessible(true);
        Event r14 = (Event) ZeusTransformUtils.preCheckCast(r13.getAnnotation(Event.class), Event.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L20;
        Intrinsics.checkNotNullExpressionValue(r14, "getAnnotation(Event::class.java)");
        Map<String, MethodWrapper> r15 = this.customEventMethodMap;
        String r16 = r14.name();
        Intrinsics.checkNotNullExpressionValue(r13, "method");
        MethodWrapper r18 = new MethodWrapper(r13);
        Parameter[] r19 = r13.getParameters();
        Intrinsics.checkNotNullExpressionValue(r19, "method.parameters");
        Object[] r20 = (Object[]) ZeusTransformUtils.preCheckCast(r19, Object[].class, "com.obric.memorydata.plugin");
        int r21 = r20.length;
        int r110 = 0;
    L24:
        if (r110 >= r21) goto L30;
        Parameter r111 = (Parameter) ZeusTransformUtils.preCheckCast(r20[r110], Parameter.class, "com.obric.memorydata.plugin");
        Params r112 = (Params) ZeusTransformUtils.preCheckCast(r111.getAnnotation(Params.class), Params.class, "com.obric.memorydata.plugin");
        if (r112 == null) goto L29;
        List<ParameterWrapper> r113 = r18.getParameters();
        boolean r114 = r112.required();
        String r115 = r112.name();
        Class<?> r116 = r111.getType();
        Intrinsics.checkNotNullExpressionValue(r116, "param.type");
        r113.add(new ParameterWrapper(r114, r115, r116));
        r110 = r110 + 1;
        goto L24
    L29:
        throw new IllegalArgumentException("参数" + r111.getName() + "缺少@Params注解");
    L30:
        r15.put(r16, r18);
        goto L20
    }

    public static /* synthetic */ void lambda$3d5N3wIawEDTAsuqt3IK_giRk6I(ClientCallback r0, Bundle r1) {
        onCardEvent$lambda$30(r0, r1);
    }

    public static /* synthetic */ void lambda$cizCpi22pv2i9PQPXZ91nUwcN3A(Bundle r0, ClientCallback r1) {
        onCardEvent$lambda$26(r0, r1);
    }

    public static /* synthetic */ void lambda$yV8SDbk5jW_wMLQpNBz3gFhLu6Y(ClientCallback r0, Bundle r1) {
        onCardEvent$lambda$28(r0, r1);
    }

    private static final void onCardEvent$lambda$26(Bundle r2, ClientCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        if (r2 == null) goto L6;
        long r0 = r2.getLong("flags");
        r3.session.setFlags(r0);
        return;
    }

    private static final void onCardEvent$lambda$28(ClientCallback r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.session.getCallback() != null) goto L5;
        return;
    L5:
        if (r2 == null) goto L8;
        int r3 = r2.getInt("status");
        r1.session.getCallback().onSessionStatusChanged(r1.session, r3);
        return;
    }

    private static final void onCardEvent$lambda$30(ClientCallback r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.session.getCallback() != null) goto L5;
        return;
    L5:
        if (r2 == null) goto L8;
        int r3 = r2.getInt("status");
        r1.session.getCallback().onSessionDisplayStatusChanged(r1.session, r3);
        return;
    }

    @Override // com.obric.livecard.api.IIslandCardCallback.Stub, android.os.IInterface
    public IBinder asBinder() {
        return (IBinder) ZeusTransformUtils.preCheckCast(this, IBinder.class, "com.obric.memorydata.plugin");
    }

    public final IslandSession getSession() {
        return this.session;
    }

    @Override // com.obric.livecard.api.IIslandCardCallback
    public Bundle hasViewClickId(String r4) {
        Bundle r0 = new Bundle();
        Function0<Unit> r1 = null;
        if (r4 == null) goto L28;
        IslandWidget r2 = this.session.getCurrWidget();
        if (r2 == null) goto L10;
        Function0<Unit> r3 = r2.findOnViewClickCallbackById(r4);
        if (r3 == null) goto L10;
    L9:
        r1 = r3;
    L10:
        IslandWidget r5 = this.session.getCollapseWidget();
        if (r5 == null) goto L13;
        r3 = r5.findOnViewClickCallbackById(r4);
    L14:
        if (r3 != null) goto L9;
        IslandWidget r6 = this.session.getExpandWidget();
        if (r6 == null) goto L18;
        r3 = r6.findOnViewClickCallbackById(r4);
    L19:
        if (r3 != null) goto L9;
        IslandWidget r7 = this.session.getNotificationWidget();
        if (r7 == null) goto L23;
        r3 = r7.findOnViewClickCallbackById(r4);
    L24:
        if (r3 != null) goto L9;
        IslandWidget r8 = this.session.getNodeWidget();
        if (r8 == null) goto L28;
        r1 = r8.findOnViewClickCallbackById(r4);
        goto L28
    L23:
        r3 = null;
        goto L24
    L18:
        r3 = null;
        goto L19
    L13:
        r3 = null;
    L28:
        if (r1 == null) goto L30;
        boolean r9 = true;
    L31:
        r0.putBoolean("result", r9);
        return r0;
    L30:
        r9 = false;
        goto L31
    }

    @Override // com.obric.livecard.api.IIslandCardCallback
    public Bundle onCardEvent(String r11, final Bundle r12) {
        if (r11 == null) goto L96;
        boolean r2 = true;
        int r6 = 0;
        switch(r11.hashCode()) {
            case -1801488983: goto L92;
            case -1629899068: goto L87;
            case -1357275426: goto L82;
            case -1277610568: goto L77;
            case -1261615456: goto L73;
            case -792506601: goto L69;
            case -657494225: goto L54;
            case -301924039: goto L49;
            case -180131773: goto L40;
            case -149134357: goto L36;
            case 183568797: goto L30;
            case 254225299: goto L14;
            case 1996594498: goto L8;
            default: goto L96;
        };
    L8:
        if (r11.equals("onSessionInactive") == false) goto L96;
        IslandCardCallback r13 = this.session.getCallback();
        if (r13 == null) goto L96;
        r13.onSessionInactive(this.session);
        goto L96
    L14:
        if (r11.equals("onSessionCreate") == false) goto L96;
        if (r12 == null) goto L26;
        Long r14 = Long.valueOf(r12.getLong("taskId"));
        if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).longValue() != 0) goto L21;
        r2 = false;
    L21:
        if (r2 == true) goto L24;
        r14 = null;
    L24:
        if (r14 == null) goto L26;
        this.session.setTaskId(((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).longValue());
    L26:
        IslandCardCallback r15 = this.session.getCallback();
        if (r15 == null) goto L96;
        r15.onSessionCreate(this.session);
        goto L96
    L30:
        if (r11.equals("onSessionActive") == false) goto L96;
        IslandCardCallback r16 = this.session.getCallback();
        if (r16 == null) goto L96;
        r16.onSessionActive(this.session);
        goto L96
    L36:
        if (r11.equals("onSessionStatusChanged") == false) goto L96;
        Handler r17 = this.mainHandler;
        Runnable r1 = new $$Lambda$ClientCallback$yV8SDbk5jW_wMLQpNBz3gFhLu6Y(this, r12);
    L80:
        r17.post(r1);
        goto L96
    L40:
        if (r11.equals("onSessionDestroy") == false) goto L96;
        if (r12 == null) goto L44;
        r6 = r12.getInt(InfoRequestQPSOptTraceLogger.REASON);
    L44:
        IslandCardCallback r18 = this.session.getCallback();
        if (r18 == null) goto L47;
        r18.onSessionDestroy(this.session, Integer.valueOf(r6));
    L47:
        LiveCard.INSTANCE.clearSession(this.session);
        goto L96
    L49:
        if (r11.equals("onCardClick") == false) goto L96;
        return handleCardOnClick(r12, this.session);
    L54:
        if (r11.equals("updateSessionConfig") == false) goto L96;
        if (r12 == null) goto L66;
        Long r19 = Long.valueOf(r12.getLong("taskId"));
        if (((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.memorydata.plugin")).longValue() != 0) goto L61;
        r2 = false;
    L61:
        if (r2 == true) goto L64;
        r19 = null;
    L64:
        if (r19 == null) goto L66;
        this.session.setTaskId(((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.memorydata.plugin")).longValue());
    L66:
        if (r12 == null) goto L96;
        this.session.setCanFrontShow(Boolean.valueOf(r12.getBoolean("canFrontShow")));
        goto L96
    L69:
        if (r11.equals("onSessionDisplayStatusChanged") == false) goto L96;
        r17 = this.mainHandler;
        r1 = new $$Lambda$ClientCallback$3d5N3wIawEDTAsuqt3IK_giRk6I(this, r12);
        goto L80
    L73:
        if (r11.equals("onWidgetShow") == false) goto L96;
        handleWidgetOnShow(r12, this.session);
        goto L96
    L77:
        if (r11.equals("onFlagsChange") == false) goto L96;
        r17 = this.mainHandler;
        r1 = new $$Lambda$ClientCallback$cizCpi22pv2i9PQPXZ91nUwcN3A(r12, this);
        goto L80
    L82:
        if (r11.equals("hasCardClick") == false) goto L96;
        return handleHasCardClick(r12, this.session);
    L87:
        if (r11.equals("onViewClick") == false) goto L96;
        return handleViewOnClick(r12, this.session);
    L92:
        if (r11.equals("customEvent") == false) goto L96;
        return handleCustomEvent(r12, this.session);
    L96:
        return null;
    }
}
