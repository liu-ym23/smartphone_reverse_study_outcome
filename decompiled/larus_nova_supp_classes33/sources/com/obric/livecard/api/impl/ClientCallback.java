package com.obric.livecard.api.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.livecard.api.IIslandCardCallback;
import com.obric.livecard.api.IslandCardCallback;
import com.obric.livecard.api.LiveCard;
import com.obric.livecard.api.annotation.Event;
import com.obric.livecard.api.annotation.Params;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001a\u0010\u0014\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/obric/livecard/api/impl/ClientCallback;", "Lcom/obric/livecard/api/IIslandCardCallback$Stub;", "session", "Lcom/obric/livecard/api/entity/IslandSession;", "(Lcom/obric/livecard/api/entity/IslandSession;)V", "customEventMethodMap", "", "", "Lcom/obric/livecard/api/impl/ClientCallback$MethodWrapper;", "mainHandler", "Landroid/os/Handler;", "getSession", "()Lcom/obric/livecard/api/entity/IslandSession;", "asBinder", "Landroid/os/IBinder;", "handleCardOnClick", "Landroid/os/Bundle;", "params", "handleCustomEvent", "handleHasCardClick", "handleViewOnClick", "handleWidgetOnShow", "", "hasViewClickId", "viewId", "injectCustomEvent", "callback", "Lcom/obric/livecard/api/IslandCardCallback;", "onCardEvent", "event", "MethodWrapper", "ParameterWrapper", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClientCallback extends IIslandCardCallback.Stub {
    private final Map<String, MethodWrapper> customEventMethodMap;
    private final Handler mainHandler;
    private final IslandSession session;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/livecard/api/impl/ClientCallback$MethodWrapper;", "", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "getMethod", "()Ljava/lang/reflect/Method;", "parameters", "", "Lcom/obric/livecard/api/impl/ClientCallback$ParameterWrapper;", "getParameters", "()Ljava/util/List;", "component1", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MethodWrapper {
        private final Method method;
        private final List<ParameterWrapper> parameters;

        public static /* synthetic */ MethodWrapper copy$default(MethodWrapper r0, Method r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.method;
        L6:
            return r0.copy(r1);
        }

        public final Method component1() {
            return this.method;
        }

        public final MethodWrapper copy(Method r2) {
            Intrinsics.checkNotNullParameter(r2, "method");
            return new MethodWrapper(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof MethodWrapper) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.method, ((MethodWrapper) r4).method) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.method.hashCode();
        }

        public String toString() {
            return "MethodWrapper(method=" + this.method + ')';
        }

        public final Method getMethod() {
            return this.method;
        }

        public final List<ParameterWrapper> getParameters() {
            return this.parameters;
        }

        public MethodWrapper(Method r2) {
            Intrinsics.checkNotNullParameter(r2, "method");
            this.method = r2;
            this.parameters = new ArrayList();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\r\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\b\u0002\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/livecard/api/impl/ClientCallback$ParameterWrapper;", "", "required", "", "name", "", "type", "Ljava/lang/Class;", "(ZLjava/lang/String;Ljava/lang/Class;)V", "getName", "()Ljava/lang/String;", "getRequired", "()Z", "getType", "()Ljava/lang/Class;", "component1", "component2", "component3", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ParameterWrapper {
        private final String name;
        private final boolean required;
        private final Class<?> type;

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

        public final ParameterWrapper copy(boolean r2, String r3, Class<?> r4) {
            Intrinsics.checkNotNullParameter(r3, "name");
            Intrinsics.checkNotNullParameter(r4, "type");
            return new ParameterWrapper(r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ParameterWrapper) == true) goto L8;
            return false;
        L8:
            ParameterWrapper r6 = (ParameterWrapper) r5;
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

        public final String getName() {
            return this.name;
        }

        public final boolean getRequired() {
            return this.required;
        }

        public final Class<?> getType() {
            return this.type;
        }

        public ParameterWrapper(boolean r2, String r3, Class<?> r4) {
            Intrinsics.checkNotNullParameter(r3, "name");
            Intrinsics.checkNotNullParameter(r4, "type");
            this.required = r2;
            this.name = r3;
            this.type = r4;
        }
    }

    public static /* synthetic */ void a(ClientCallback r0, Bundle r1) {
        onCardEvent$lambda$30(r0, r1);
    }

    public static /* synthetic */ void b(Bundle r0, ClientCallback r1) {
        onCardEvent$lambda$26(r0, r1);
    }

    public static /* synthetic */ void c(ClientCallback r0, Bundle r1) {
        onCardEvent$lambda$28(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IBinder asBinder() {
        return this;
    }

    public final IslandSession getSession() {
        return this.session;
    }

    public ClientCallback(IslandSession r3) {
        Intrinsics.checkNotNullParameter(r3, "session");
        this.session = r3;
        this.customEventMethodMap = new LinkedHashMap();
        this.mainHandler = new Handler(Looper.getMainLooper());
        injectCustomEvent(r3.getCallback());
    }

    private final void injectCustomEvent(IslandCardCallback r14) {
        if (r14 != null) goto L4;
        return;
    L4:
        Method[] r15 = r14.getClass().getDeclaredMethods();
        ArrayList r0 = new ArrayList();
        int r1 = r15.length;
        int r3 = 0;
    L5:
        boolean r4 = true;
        if (r3 >= r1) goto L17;
        Method r5 = r15[r3];
        Annotation[] r6 = r5.getAnnotations();
        int r7 = r6.length;
        int r8 = 0;
    L8:
        if (r8 >= r7) goto L13;
        if ((r6[r8] instanceof Event) == true) goto L14;
        r8 = r8 + 1;
    L14:
        if (r4 == false) goto L16;
        r0.add(r5);
    L16:
        r3 = r3 + 1;
        goto L5
    L13:
        r4 = false;
        goto L14
    L17:
        Iterator r16 = r0.iterator();
    L19:
        if (r16.hasNext() == false) goto L30;
        Method r2 = (Method) r16.next();
        r2.setAccessible(true);
        Event r9 = (Event) r2.getAnnotation(Event.class);
        if (r9 == null) goto L19;
        Map<String, MethodWrapper> r10 = this.customEventMethodMap;
        String r11 = r9.name();
        MethodWrapper r12 = new MethodWrapper(r2);
        Parameter[] r13 = r2.getParameters();
        int r17 = r13.length;
        int r18 = 0;
    L23:
        if (r18 >= r17) goto L29;
        Parameter r19 = r13[r18];
        Params r20 = (Params) r19.getAnnotation(Params.class);
        if (r20 == null) goto L28;
        r12.getParameters().add(new ParameterWrapper(r20.required(), r20.name(), r19.getType()));
        r18 = r18 + 1;
        goto L23
    L28:
        throw new IllegalArgumentException("参数" + r19.getName() + "缺少@Params注解");
    L29:
        r10.put(r11, r12);
        goto L19
    }

    public Bundle hasViewClickId(String r4) {
        Bundle r0 = new Bundle();
        Function0 r1 = null;
        if (r4 == null) goto L28;
        IslandWidget r2 = this.session.getCurrWidget();
        if (r2 == null) goto L10;
        Function0 r3 = r2.findOnViewClickCallbackById(r4);
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
        r0.putBoolean(WindowEvent.Params.RESULT, r9);
        return r0;
    L30:
        r9 = false;
        goto L31
    }

    private final Bundle handleCardOnClick(Bundle r3, final IslandSession r4) {
        String r0 = null;
        if (r3 == null) goto L36;
        String r5 = r3.getString("templateId");
        if (r5 == null) goto L37;
        IslandWidget r1 = r4.getCollapseWidget();
        if (r1 == null) goto L9;
        String r2 = r1.getTemplateId();
    L11:
        if (Intrinsics.areEqual(r5, r2) == false) goto L13;
        boolean r6 = ((Boolean) ClientCallbackKt.runOnMainThreadBlock(new ClientCallback$handleCardOnClick$1$handled$1(r4))).booleanValue();
    L34:
        Bundle r7 = new Bundle();
        r7.putBoolean("handled", r6);
        return r7;
    L13:
        IslandWidget r8 = r4.getExpandWidget();
        if (r8 == null) goto L16;
        String r9 = r8.getTemplateId();
    L18:
        if (Intrinsics.areEqual(r5, r9) == false) goto L20;
        r6 = ((Boolean) ClientCallbackKt.runOnMainThreadBlock(new ClientCallback$handleCardOnClick$1$handled$2(r4))).booleanValue();
        goto L34
    L20:
        IslandWidget r10 = r4.getNotificationWidget();
        if (r10 == null) goto L23;
        String r11 = r10.getTemplateId();
    L25:
        if (Intrinsics.areEqual(r5, r11) == false) goto L27;
        r6 = ((Boolean) ClientCallbackKt.runOnMainThreadBlock(new ClientCallback$handleCardOnClick$1$handled$3(r4))).booleanValue();
        goto L34
    L27:
        IslandWidget r12 = r4.getNodeWidget();
        if (r12 == null) goto L31;
        r0 = r12.getTemplateId();
    L31:
        if (Intrinsics.areEqual(r5, r0) == false) goto L33;
        r6 = ((Boolean) ClientCallbackKt.runOnMainThreadBlock(new ClientCallback$handleCardOnClick$1$handled$4(r4))).booleanValue();
        goto L34
    L33:
        r6 = false;
        goto L34
    L23:
        r11 = null;
        goto L25
    L16:
        r9 = null;
        goto L18
    L9:
        r2 = null;
        goto L11
    L37:
        return null;
    L36:
        return null;
    }

    private final Bundle handleCustomEvent(Bundle r10, IslandSession r11) {
        if (r10 == null) goto L53;
        String r1 = r10.getString("eventName");
        if (r1 == null) goto L53;
        String r12 = r10.getString("eventParams");
        if (r12 == null) goto L10;
        JsonObject r13 = (JsonObject) GsonProtectorUtils.fromJson(new Gson(), r12, JsonObject.class);
    L11:
        IslandCardCallback r14 = r11.getCallback();
        if (r14 != null) goto L15;
        Bundle r15 = new Bundle();
        r15.putString("error_message", "client not register callback");
        return r15;
    L15:
        MethodWrapper r3 = this.customEventMethodMap.get(r1);
        if (r3 != null) goto L19;
        Bundle r16 = new Bundle();
        r16.putString("error_message", "not found method : ".concat(r1));
        return r16;
    L19:
        List<ParameterWrapper> r2 = r3.getParameters();
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r5 = r2.iterator();
    L21:
        if (r5.hasNext() == false) goto L43;
        ParameterWrapper r6 = (ParameterWrapper) r5.next();
        if (r13 == null) goto L36;
        JsonElement r7 = r13.get(r6.getName());
        if (r7 == null) goto L36;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L28
        Object r9 = Result.constructor-impl(new Gson().fromJson(r7, r6.getType()));     // Catch: Throwable -> L28
    L31:
        if (Result.exceptionOrNull-impl(r9) != null) goto L32;
        Result.isSuccess-impl(r9);
        if (Result.isFailure-impl(r9) == true) goto L36;
    L38:
        if (r6.getRequired() == false) goto L42;
        if (r9 != null) goto L42;
        Bundle r17 = new Bundle();
        r17.putString("error_message", "the " + r6.getName() + " is required");
        return r17;
    L42:
        r4.add(r9);
        goto L21
    L32:
        Bundle r18 = new Bundle();
        r18.putString("error_message", "parse error, " + r6.getType() + " is not match " + r7 + ' ');
        return r18;
    L28:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L36:
        r9 = null;
        goto L38
    L43:
        Bundle r110 = new Bundle();
        Method r0 = r3.getMethod();
        Object[] r20 = r4.toArray(new Object[0]);
        if (r20 == null) goto L52;
        Object r111 = r0.invoke(r14, Arrays.copyOf(r20, r20.length));
        if (r111 == null) goto L50;
        String r112 = GsonProtectorUtils.toJson(new Gson(), r111);
        if (r112 == null) goto L50;
        r110.putString(WindowEvent.Params.RESULT, r112);
    L50:
        return r110;
    L52:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L10:
        r13 = null;
    L53:
        Bundle r113 = new Bundle();
        r113.putString("error_message", "not found eventName");
        return r113;
    }

    private final Bundle handleHasCardClick(Bundle r5, IslandSession r6) {
        Function0 r0 = null;
        if (r5 == null) goto L52;
        String r7 = r5.getString("templateId");
        if (r7 == null) goto L53;
        IslandWidget r1 = r6.getCollapseWidget();
        if (r1 == null) goto L9;
        String r2 = r1.getTemplateId();
    L10:
        boolean r3 = true;
        if (Intrinsics.areEqual(r7, r2) == false) goto L18;
        IslandWidget r8 = r6.getCollapseWidget();
        if (r8 == null) goto L15;
        r0 = r8.getOnCardClickCallback();
    L15:
        if (r0 != null) goto L50;
    L17:
        r3 = false;
    L50:
        Bundle r4 = new Bundle();
        r4.putBoolean(WindowEvent.Params.RESULT, r3);
        return r4;
    L18:
        IslandWidget r9 = r6.getExpandWidget();
        if (r9 == null) goto L21;
        String r10 = r9.getTemplateId();
    L23:
        if (Intrinsics.areEqual(r7, r10) == false) goto L29;
        IslandWidget r11 = r6.getExpandWidget();
        if (r11 == null) goto L27;
        r0 = r11.getOnCardClickCallback();
    L27:
        if (r0 == null) goto L17;
    L29:
        IslandWidget r12 = r6.getNotificationWidget();
        if (r12 == null) goto L32;
        String r13 = r12.getTemplateId();
    L34:
        if (Intrinsics.areEqual(r7, r13) == false) goto L40;
        IslandWidget r14 = r6.getNotificationWidget();
        if (r14 == null) goto L38;
        r0 = r14.getOnCardClickCallback();
    L38:
        if (r0 == null) goto L17;
    L40:
        IslandWidget r15 = r6.getNodeWidget();
        if (r15 == null) goto L43;
        String r16 = r15.getTemplateId();
    L45:
        if (Intrinsics.areEqual(r7, r16) == false) goto L17;
        IslandWidget r17 = r6.getNodeWidget();
        if (r17 == null) goto L49;
        r0 = r17.getOnCardClickCallback();
    L49:
        if (r0 == null) goto L17;
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
        r2 = null;
        goto L10
    L53:
        return null;
    L52:
        return null;
    }

    private final Bundle handleViewOnClick(Bundle r5, IslandSession r6) {
        if (r5 == null) goto L44;
        String r1 = r5.getString("viewId");
        if (r1 == null) goto L44;
        String r7 = r5.getString("templateId");
        final Function0 r2 = null;
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
        r2 = r8.findOnViewClickCallbackById(r1);
    L41:
        ClientCallbackKt.runOnMainThreadBlock(new ClientCallback$handleViewOnClick$1$1(r2));
        Bundle r9 = new Bundle();
        if (r2 != null) goto L46;
        r9.putString("error_message", "client not register click listener");
        return r9;
    L46:
        return r9;
    L15:
        IslandWidget r10 = r6.getExpandWidget();
        if (r10 == null) goto L18;
        String r11 = r10.getTemplateId();
    L20:
        if (Intrinsics.areEqual(r11, r7) == false) goto L22;
        r8 = r6.getExpandWidget();
        goto L37
    L22:
        IslandWidget r12 = r6.getNotificationWidget();
        if (r12 == null) goto L25;
        String r13 = r12.getTemplateId();
    L27:
        if (Intrinsics.areEqual(r13, r7) == false) goto L29;
        r8 = r6.getNotificationWidget();
        goto L37
    L29:
        IslandWidget r14 = r6.getNodeWidget();
        if (r14 == null) goto L32;
        String r15 = r14.getTemplateId();
    L34:
        if (Intrinsics.areEqual(r15, r7) == false) goto L36;
        r8 = r6.getNodeWidget();
        goto L37
    L36:
        r8 = null;
        goto L37
    L32:
        r15 = null;
        goto L34
    L25:
        r13 = null;
        goto L27
    L18:
        r11 = null;
        goto L20
    L11:
        r4 = null;
    L38:
        r8 = r6.getCurrWidget();
    L44:
        Bundle r16 = new Bundle();
        r16.putString("error_message", "not found viewId");
        return r16;
    }

    private final void handleWidgetOnShow(Bundle r3, IslandSession r4) {
        if (r3 == null) goto L40;
        String r5 = r3.getString("templateId");
        if (r5 == null) goto L41;
        IslandWidget r0 = r4.getCollapseWidget();
        if (r0 == null) goto L8;
        String r1 = r0.getTemplateId();
    L10:
        if (Intrinsics.areEqual(r5, r1) == false) goto L12;
        r4.setCurrWidget(r4.getCollapseWidget());
    L34:
        IslandWidget r6 = r4.getCurrWidget();
        if (r6 == null) goto L42;
        IslandCardCallback r7 = r4.getCallback();
        if (r7 == null) goto L43;
        r7.onWidgetShow(r6);
        return;
    L43:
        return;
    L42:
        return;
    L12:
        IslandWidget r2 = r4.getExpandWidget();
        if (r2 == null) goto L15;
        String r8 = r2.getTemplateId();
    L17:
        if (Intrinsics.areEqual(r5, r8) == false) goto L19;
        r4.setCurrWidget(r4.getExpandWidget());
        goto L34
    L19:
        IslandWidget r9 = r4.getNotificationWidget();
        if (r9 == null) goto L22;
        String r10 = r9.getTemplateId();
    L24:
        if (Intrinsics.areEqual(r5, r10) == false) goto L26;
        r4.setCurrWidget(r4.getNotificationWidget());
        goto L34
    L26:
        IslandWidget r11 = r4.getNodeWidget();
        if (r11 == null) goto L29;
        String r12 = r11.getTemplateId();
    L31:
        if (Intrinsics.areEqual(r5, r12) == false) goto L33;
        r4.setCurrWidget(r4.getNodeWidget());
        goto L34
    L33:
        r4.setCurrWidget(null);
        goto L34
    L29:
        r12 = null;
        goto L31
    L22:
        r10 = null;
        goto L24
    L15:
        r8 = null;
        goto L17
    L8:
        r1 = null;
        goto L10
    L41:
        return;
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

    public Bundle onCardEvent(String r10, final Bundle r11) {
        if (r10 == null) goto L95;
        boolean r2 = true;
        int r6 = 0;
        switch(r10.hashCode()) {
            case -1801488983: goto L91;
            case -1629899068: goto L86;
            case -1357275426: goto L81;
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
            default: goto L95;
        };
    L8:
        if (r10.equals("onSessionInactive") == false) goto L95;
        IslandCardCallback r12 = this.session.getCallback();
        if (r12 == null) goto L95;
        r12.onSessionInactive(this.session);
        goto L95
    L14:
        if (r10.equals("onSessionCreate") == false) goto L95;
        if (r11 == null) goto L26;
        Long r13 = Long.valueOf(r11.getLong("taskId"));
        if (r13.longValue() != 0) goto L21;
        r2 = false;
    L21:
        if (r2 == true) goto L24;
        r13 = null;
    L24:
        if (r13 == null) goto L26;
        this.session.setTaskId(r13.longValue());
    L26:
        IslandCardCallback r14 = this.session.getCallback();
        if (r14 == null) goto L95;
        r14.onSessionCreate(this.session);
        goto L95
    L30:
        if (r10.equals("onSessionActive") == false) goto L95;
        IslandCardCallback r15 = this.session.getCallback();
        if (r15 == null) goto L95;
        r15.onSessionActive(this.session);
        goto L95
    L36:
        if (r10.equals("onSessionStatusChanged") == false) goto L95;
        this.mainHandler.post(new b(this, r11));
        goto L95
    L40:
        if (r10.equals("onSessionDestroy") == false) goto L95;
        if (r11 == null) goto L44;
        r6 = r11.getInt(WindowEvent.Params.REASON);
    L44:
        IslandCardCallback r16 = this.session.getCallback();
        if (r16 == null) goto L47;
        r16.onSessionDestroy(this.session, Integer.valueOf(r6));
    L47:
        LiveCard.INSTANCE.clearSession(this.session);
        goto L95
    L49:
        if (r10.equals("onCardClick") == false) goto L95;
        return handleCardOnClick(r11, this.session);
    L54:
        if (r10.equals("updateSessionConfig") == false) goto L95;
        if (r11 == null) goto L66;
        Long r17 = Long.valueOf(r11.getLong("taskId"));
        if (r17.longValue() != 0) goto L61;
        r2 = false;
    L61:
        if (r2 == true) goto L64;
        r17 = null;
    L64:
        if (r17 == null) goto L66;
        this.session.setTaskId(r17.longValue());
    L66:
        if (r11 == null) goto L95;
        this.session.setCanFrontShow(Boolean.valueOf(r11.getBoolean("canFrontShow")));
        goto L95
    L69:
        if (r10.equals("onSessionDisplayStatusChanged") == false) goto L95;
        this.mainHandler.post(new c(this, r11));
        goto L95
    L73:
        if (r10.equals("onWidgetShow") == false) goto L95;
        handleWidgetOnShow(r11, this.session);
        goto L95
    L77:
        if (r10.equals("onFlagsChange") == false) goto L95;
        this.mainHandler.post(new a(r11, this));
        goto L95
    L81:
        if (r10.equals("hasCardClick") == false) goto L95;
        return handleHasCardClick(r11, this.session);
    L86:
        if (r10.equals("onViewClick") == false) goto L95;
        return handleViewOnClick(r11, this.session);
    L91:
        if (r10.equals("customEvent") == false) goto L95;
        return handleCustomEvent(r11, this.session);
    L95:
        return null;
    }
}
