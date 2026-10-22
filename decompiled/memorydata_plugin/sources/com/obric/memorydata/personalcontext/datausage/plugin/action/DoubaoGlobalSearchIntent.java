package com.obric.memorydata.personalcontext.datausage.plugin.action;

import android.app.KeyguardManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BasePCDoubaoGlobalSearchIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PCDoubaoGlobalSearchParams;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.controller.ApiController;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.personalcontext.search.global.f;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchResponse;
import com.obric.memorydata.utils.q;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/personalcontext/datausage/plugin/action/DoubaoGlobalSearchIntent;", "Lcom/obric/capabilitykit/common/intent/BasePCDoubaoGlobalSearchIntent;", "<init>", "()V", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/intent/Empty;", TrackerImpl.PARAMS, "Lcom/obric/capabilitykit/common/intent/PCDoubaoGlobalSearchParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/PCDoubaoGlobalSearchParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "couldNotUseDataOnLockScreen", "", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DoubaoGlobalSearchIntent extends BasePCDoubaoGlobalSearchIntent {
    public static final a Companion = null;
    private static final String TAG = "DoubaoGlobalSearchIntent";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/datausage/plugin/action/DoubaoGlobalSearchIntent$Companion;", "", "<init>", "()V", "TAG", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public DoubaoGlobalSearchIntent() {
    }

    private final boolean couldNotUseDataOnLockScreen() {
        Object r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("keyguard");
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.app.KeyguardManager");
        boolean r1 = false;
        if (((KeyguardManager) ZeusTransformUtils.preCheckCast(r9, KeyguardManager.class, "com.obric.memorydata.plugin")).isDeviceLocked() == true) goto L5;
        return false;
    L5:
        Cursor r10 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), Uri.parse("content://com.obric.assistant.provider.ObricPersonalContextProvider/settings"), null, null, null, null, "com.obric.memorydata.plugin");
        if (r10 == null) goto L35;
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(r10, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r3 = (Cursor) ZeusTransformUtils.preCheckCast(r11, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        Integer r5 = Integer.valueOf(r3.getColumnIndex("toggle_name"));     // Catch: Throwable -> L30
        if (((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L11;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L16;
        r5 = null;
    L16:
        if (r5 == null) goto L29;
        int r7 = r5.intValue();     // Catch: Throwable -> L30
        Integer r8 = Integer.valueOf(r3.getColumnIndex("is_on"));     // Catch: Throwable -> L30
        if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L20;
        r1 = true;
    L20:
        if (r1 == true) goto L23;
        r8 = null;
    L23:
        if (r8 == null) goto L29;
        int r0 = r8.intValue();     // Catch: Throwable -> L30
    L26:
        if (r3.moveToNext() == false) goto L29;
        r4.put(r3.getString(r7), Boolean.valueOf(Boolean.parseBoolean(r3.getString(r0))));     // Catch: Throwable -> L30
    L29:
        CloseableKt.closeFinally(r11, null);
    L37:
        return !Intrinsics.areEqual(r4.get("SESSION_AUTHENTICATED"), true);
    L11:
        r6 = false;
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L35:
        r4 = MapsKt.emptyMap();
        goto L37
    }

    @Override // com.obric.capabilitykit.common.intent.BasePCDoubaoGlobalSearchIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, Continuation<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        Continuation<? super IntentResult<Empty>> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return doAction((PCDoubaoGlobalSearchParams) ZeusTransformUtils.preCheckCast(r6, PCDoubaoGlobalSearchParams.class, "com.obric.memorydata.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BasePCDoubaoGlobalSearchIntent
    public Object doAction(PCDoubaoGlobalSearchParams r24, DispatchContext r25, Continuation<? super IntentResult<Empty>> r26) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r26, Continuation.class, "com.obric.memorydata.plugin");
        if (ApiController.INSTANCE.isEnable() == true) goto L7;
        return new IntentResult(100, null, null, null, false, false, 0, null, null, null, 1022, null);
    L7:
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "user not agree privacy", false, 4, null);
        return new IntentResult(0, null, null, "", false, false, 256, null, null, null, 950, null);
    L11:
        if (couldNotUseDataOnLockScreen() == false) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "could not use data on lock screen", false, 4, null);
        return new IntentResult(0, null, null, "", false, false, 256, null, null, null, 950, null);
    L14:
        String r1 = r24.getQuResult();
        Long r2 = r25.getQuestionId();
        if (r2 == null) goto L18;
        String r3 = r2.toString();
        if (r3 == null) goto L18;
    L19:
        GlobalAssistantSearchResponse r4 = f.f12331a.c(r1, r3, "VOICE");
        ApiController r5 = ApiController.INSTANCE;
        if (r5.needLog() == true) goto L23;
        r5 = null;
    L23:
        if (r5 == null) goto L29;
        if (r1 == null) goto L26;
        String r6 = q.f13259a.b(r1);
    L27:
        r5.log(TAG, PCDoubaoGlobalSearchParams.copy$default(r24, r6, null, 2, null), GlobalAssistantSearchResponse.copy$default(r4, 0, null, null, null, null, null, null, null, 227, null));
        goto L29
    L26:
        r6 = null;
    L29:
        if (r4.getCode() != 1003) goto L31;
        int r7 = R.string.qu_search_error;
        String r8 = "qu_search_error";
    L32:
        int r9 = ZeusTransformUtils.mapRes(r7, TypedValues.Custom.S_STRING, r8);
        if (r4.getCode() == 0) goto L37;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "doAction failed, code: " + r4.getCode() + ", msg: " + r4.getMessage(), null, 4, null);
        return new IntentResult(1, null, null, ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getString(r9), false, false, 1, null, null, null, 950, null);
    L37:
        return new IntentResult(0, null, null, EntityExtKt.getEntityGson().toJson(r4), false, false, 256, null, null, null, 950, null);
    L31:
        r7 = R.string.intent_search_error;
        r8 = "intent_search_error";
    L18:
        r3 = "";
        goto L19
    }
}
