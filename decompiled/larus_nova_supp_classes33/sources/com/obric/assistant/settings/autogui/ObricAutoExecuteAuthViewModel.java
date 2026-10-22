package com.obric.assistant.settings.autogui;

import androidx.lifecycle.ViewModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.im.FlowRuntime;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.t1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0018*\u00020\u0019H\u0002J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0018H\u0002J\u001a\u0010\u001d\u001a\u00020\u001e*\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006#"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoExecuteAuthViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/assistant/settings/autogui/ObricAutoExecuteAuthUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "refresh", "", "onAuthorizationCheckedChanged", "item", "Lcom/obric/assistant/settings/autogui/AuthorizationItem;", "checked", "", "resolvePageConfig", "Lcom/google/gson/JsonObject;", "configJson", "parsePageConfig", "Lcom/obric/assistant/settings/autogui/AuthorizationPageConfig;", "toAuthorizationItems", "", "Lcom/google/gson/JsonArray;", "buildRows", "Lcom/obric/assistant/settings/autogui/AuthorizationRow;", "authorizations", "resolveCardPosition", "", "index", "getStoredValue", "saveStoredValue", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAutoExecuteAuthViewModel extends ViewModel {
    private static final String CLOUD_CONFIG_KEY = "auto_gui_automatic_execution_authorization";
    public static final a Companion = null;
    private static final String LOG_PREFIX = "[AutoExecuteAuth]";
    private static final String TAG = "ObricAutoExecuteAuthVM";
    private static final String TYPE_SWITCH = "switch";
    private final kotlinx.coroutines.flow.z0<h> _uiState;
    private final i1<h> uiState;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final int resolveCardPosition(List<com.obric.assistant.settings.autogui.a> r1, int r2) {
        return 0;
    }

    public final void refresh() {
        JsonObject r0 = t1.a.getObricCloudConfig(CLOUD_CONFIG_KEY);
        FLogger r1 = FLogger.a;
        if (r0 == null) goto L6;
        String r2 = r0.toString();
        if (r2 == null) goto L6;
    L7:
        r1.i(TAG, "[AutoExecuteAuth] refresh, cloudKey=auto_gui_automatic_execution_authorization, rawConfig=".concat(r2));
        b r3 = parsePageConfig(resolvePageConfig(r0));
        List<c> r4 = buildRows(r3.b);
        r1.i(TAG, "[AutoExecuteAuth] refresh, pageName=" + r3.a + ", authorizationCount=" + r3.b.size() + ", rowCount=" + r4.size());
        kotlinx.coroutines.flow.z0<h> r5 = this._uiState;
        String r6 = r3.a;
        if (StringsKt.isBlank(r6) == false) goto L10;
        r6 = FlowRuntime.a().getApplication().getString(2131912438);
    L10:
        r5.setValue(new h(r6, r4));
        return;
    L6:
        r2 = "null";
        goto L7
    }

    public ObricAutoExecuteAuthViewModel() {
        StateFlowImpl r0 = j1.a(new h(FlowRuntime.a().getApplication().getString(2131912438), CollectionsKt.emptyList()));
        this._uiState = r0;
        this.uiState = kotlinx.coroutines.flow.e.b(r0);
    }

    public final i1<h> getUiState() {
        return this.uiState;
    }

    private final List<c> buildRows(List<com.obric.assistant.settings.autogui.a> r11) {
        if (r11.isEmpty() == true) goto L5;
        ArrayList r0 = new ArrayList();
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<T> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L13;
        com.obric.assistant.settings.autogui.a r2 = (com.obric.assistant.settings.autogui.a) r12.next();
        String r5 = StringsKt.trim(r2.a).toString();
        Object r3 = r1.get(r5);
        if (r3 != null) goto L12;
        r3 = new ArrayList();
        r1.put(r5, r3);
    L12:
        String r6 = r2.b;
        String r7 = r2.c;
        String r8 = r2.d;
        String r9 = r2.e;
        Intrinsics.checkNotNullParameter(r5, "sectionTitle");
        Intrinsics.checkNotNullParameter(r6, "title");
        Intrinsics.checkNotNullParameter(r7, "hint");
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r9, "defaultStatus");
        ((List) r3).add(new com.obric.assistant.settings.autogui.a(r5, r6, r7, r8, r9));
        goto L8
    L13:
        Iterator r13 = r1.entrySet().iterator();
    L15:
        if (r13.hasNext() == false) goto L26;
        Map.Entry r4 = (Map.Entry) r13.next();
        String r10 = (String) r4.getKey();
        List<com.obric.assistant.settings.autogui.a> r14 = (List) r4.getValue();
        if ((!StringsKt.isBlank(r10)) == false) goto L19;
        r0.add(new c.a(r10));
    L19:
        Iterator<T> r15 = r14.iterator();
        int r16 = 0;
    L21:
        if (r15.hasNext() == false) goto L15;
        Object r17 = r15.next();
        int r18 = r16 + 1;
        if (r16 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        com.obric.assistant.settings.autogui.a r19 = (com.obric.assistant.settings.autogui.a) r17;
        r0.add(new c.b(r19, getStoredValue(r19), resolveCardPosition(r14, r16)));
        r16 = r18;
        goto L21
    L26:
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    private final boolean getStoredValue(com.obric.assistant.settings.autogui.a r6) {
        String r0 = t1.a.P1(r6.d, r6.e);
        boolean r1 = Intrinsics.areEqual(com.obric.assistant.c.a(r0), "1");
        FLogger.a.i(TAG, "[AutoExecuteAuth] resolveAuthorizationStatus, key=" + r6.d + ", title=" + r6.b + ", defaultStatus=" + r6.e + ", storedStatus=" + r0 + ", checked=" + r1);
        return r1;
    }

    private final b parsePageConfig(JsonObject r3) {
        if (r3 == null) goto L4;
        String r0 = i.a(r3, "page_name");
        JsonArray r4 = r3.getAsJsonArray("authorizations");
        if (r4 == null) goto L8;
        List<com.obric.assistant.settings.autogui.a> r5 = toAuthorizationItems(r4);
    L9:
        if (r5 != null) goto L12;
        r5 = CollectionsKt.emptyList();
    L12:
        return new b(r0, r5);
    L8:
        r5 = null;
        goto L9
    L4:
        return new b(FlowRuntime.a().getApplication().getString(2131912438), CollectionsKt.emptyList());
    }

    private final JsonObject resolvePageConfig(JsonObject r5) {
        JsonObject r0 = null;
        if (r5 != null) goto L6;
        FLogger.a.i(TAG, "[AutoExecuteAuth] resolvePageConfig, raw config is null");
        return null;
    L6:
        JsonElement r2 = r5.get(CLOUD_CONFIG_KEY);
        if (r2 != null) goto L9;
    L11:
        if (r0 == null) goto L14;
        FLogger.a.i(TAG, "[AutoExecuteAuth] resolvePageConfig, use nested config by key=auto_gui_automatic_execution_authorization, nestedConfig=" + r0);
        return r0;
    L14:
        FLogger.a.i(TAG, "[AutoExecuteAuth] resolvePageConfig, nested key=auto_gui_automatic_execution_authorization not found, fallback to raw config");
        return r5;
    L9:
        if (r2.isJsonObject() == false) goto L11;
        r0 = r2.getAsJsonObject();
        goto L11
    }

    private final List<com.obric.assistant.settings.autogui.a> toAuthorizationItems(JsonArray r11) {
        ArrayList r0 = new ArrayList();
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L19;
        JsonElement r1 = (JsonElement) r12.next();
        Intrinsics.checkNotNull(r1);
        if (r1.isJsonObject() == false) goto L8;
        JsonObject r2 = r1.getAsJsonObject();
    L9:
        if (r2 == null) goto L4;
        String r3 = i.a(r2, "type");
        String r8 = i.a(r2, "key");
        String r6 = i.a(r2, "title");
        if (Intrinsics.areEqual(r3, TYPE_SWITCH) == false) goto L4;
        if (StringsKt.isBlank(r8) == true) goto L4;
        if (StringsKt.isBlank(r6) == true) goto L4;
        String r5 = StringsKt.trim(i.a(r2, "section_title")).toString();
        String r7 = i.a(r2, "hint");
        int r4 = com.obric.assistant.c.a;
        r0.add(new com.obric.assistant.settings.autogui.a(r5, r6, r7, r8, com.obric.assistant.c.a(i.a(r2, "default_value"))));
        goto L4
    L8:
        r2 = null;
        goto L9
    L19:
        return r0;
    }

    private final void saveStoredValue(com.obric.assistant.settings.autogui.a r3, boolean r4) {
        t1 r0 = t1.a;
        String r5 = r3.d;
        int r1 = com.obric.assistant.c.a;
        if (r4 == false) goto L5;
        String r6 = "1";
    L6:
        r0.X(r5, r6);
        return;
    L5:
        r6 = "2";
        goto L6
    }

    public final void onAuthorizationCheckedChanged(com.obric.assistant.settings.autogui.a r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "item");
        saveStoredValue(r10, r11);
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("[AutoExecuteAuth] onAuthorizationCheckedChanged, key=");
        r2.append(r10.d);
        r2.append(", defaultStatus=");
        r2.append(r10.e);
        r2.append(", targetStatus=");
        int r3 = com.obric.assistant.c.a;
        if (r11 == false) goto L5;
        String r4 = "1";
    L6:
        r2.append(r4);
        r2.append(", checked=");
        r2.append(r11);
        r1.i(TAG, r2.toString());
        kotlinx.coroutines.flow.z0<h> r5 = this._uiState;
        h r6 = (h) r5.getValue();
        List<c> r7 = ((h) this._uiState.getValue()).b;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r9 = r7.iterator();
    L8:
        if (r9.hasNext() == false) goto L15;
        c r12 = (c) r9.next();
        if ((r12 instanceof c.b) == false) goto L14;
        c.b r13 = (c.b) r12;
        if (Intrinsics.areEqual(r13.a.d, r10.d) == false) goto L14;
        com.obric.assistant.settings.autogui.a r14 = r13.a;
        int r15 = r13.c;
        Intrinsics.checkNotNullParameter(r14, "item");
        r12 = new c.b(r14, r11, r15);
    L14:
        r8.add(r12);
        goto L8
    L15:
        String r16 = r6.a;
        Intrinsics.checkNotNullParameter(r16, "pageName");
        Intrinsics.checkNotNullParameter(r8, "rows");
        r5.setValue(new h(r16, r8));
        return;
    L5:
        r4 = "2";
        goto L6
    }
}
