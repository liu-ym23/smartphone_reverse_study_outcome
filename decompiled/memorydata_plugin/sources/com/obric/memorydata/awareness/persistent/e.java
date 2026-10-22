package com.obric.memorydata.awareness.persistent;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.AwarenessTarget;
import com.obric.memorydata.sdk.awareness.PersistentAwarenessCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000fJ6\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00052\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000fJ(\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J*\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J\u001e\u0010\u001c\u001a\u00020\u0007*\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u0010\u001f\u001a\u00020\u0016*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH\u0002J \u0010 \u001a\u00020\u0007*\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00052\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/awareness/persistent/PersistentAwarenessCallbackDispatcher;", "", "<init>", "()V", "TAG", "", "dispatchFeature", "", "context", "Landroid/content/Context;", "entity", "Lcom/obric/memorydata/awareness/persistent/PersistentAwarenessSubscription;", "oldValue", "newValue", WsConstants.KEY_EXTRA, "", "dispatchContextEvent", "eventName", "dispatch", "callbackTarget", "Lcom/obric/memorydata/sdk/awareness/AwarenessTarget;", "payload", "Landroid/os/Bundle;", "unstableCallProvider", "uri", "Landroid/net/Uri;", "method", "extras", "putSupportedValue", "key", EventBody.KEY_VALUE, "toSafeBundle", "putListValue", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f8770a = null;

    static {
        f8770a = new e();
    }

    private e() {
    }

    private final Bundle a(Context r10, Uri r11, String r12, Bundle r13) {
        ContentProviderClient r14 = ((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin")).getContentResolver().acquireUnstableContentProviderClient(r11);
        Bundle r2 = null;
        if (r14 != null) goto L20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessCallbackDispatcher", "acquire provider client failed uri=" + r11 + " method=" + r12, null, 4, null);
        return null;
    L20:
        r2 = r14.call(r12, null, r13);     // Catch: Throwable -> L8 Exception -> L10 DeadObjectException -> L13
    L7:
        r14.close();
        return r2;
    L13:
        e = move-exception;
        RunLog r3 = RunLog.INSTANCE;     // Catch: Throwable -> L8
        String r15 = "provider died during call uri=" + r11 + " method=" + r12;     // Catch: Throwable -> L8
        Throwable r16 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
    L12:
        r3.warn("PersistentAwarenessCallbackDispatcher", r15, r16);     // Catch: Throwable -> L8
    L10:
        e = move-exception;
        r3 = RunLog.INSTANCE;     // Catch: Throwable -> L8
        r15 = "provider call failed uri=" + r11 + " method=" + r12;     // Catch: Throwable -> L8
        r16 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r14.close();
        throw th;
    }

    private final Bundle a(Map<String, ? extends Object> r8) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Bundle r9 = new Bundle();
        Iterator r10 = r7.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L21;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        Object r3 = r1.getValue();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
        f8770a.a(r9, r2, r3);     // Catch: Throwable -> L8
        Object r5 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 == null) goto L4;
        RunLog r11 = RunLog.INSTANCE;
        StringBuilder r12 = new StringBuilder().append("ignore unsupported callback extra key=").append(r2).append(" value=");
        if (r3 == null) goto L17;
        Class<?> r13 = r3.getClass();
        if (r13 == null) goto L17;
        String r14 = r13.getName();
    L18:
        r11.warn("PersistentAwarenessCallbackDispatcher", r12.append(r14).toString(), r6);
        if (r3 == null) goto L4;
        r9.putString(r2 + "_string", r3.toString());
    L17:
        r14 = null;
    L8:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L21:
        return r9;
    }

    private final void a(Context r10, h r11, AwarenessTarget r12, Bundle r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        PersistentAwarenessCallback r0 = new PersistentAwarenessCallback(r11.b(), r12, r13);
        Bundle r15 = new Bundle();
        r15.putParcelable("callback", (Parcelable) ZeusTransformUtils.preCheckCast(r0, Parcelable.class, "com.obric.memorydata.plugin"));
        String r1 = r11.h();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessCallbackDispatcher", "persistent callback begin authority=" + r1 + " callbackTarget=" + r12.getTargetType() + '/' + r12.getTargetName() + ' ' + r11.i(), false, 4, null);
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L9
        e r9 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        Uri r17 = Uri.parse("content://" + r1);     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L9
        MemoryResponse<Void> r18 = com.obric.memorydata.sdk.awareness.g.f12826a.a(r9.a(r14, r17, "persistent_awareness_callback", r15));     // Catch: Throwable -> L9
        if (r18.isSuccess() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessCallbackDispatcher", "persistent callback failed code=" + r18.getCode() + " msg=" + r18.getMessage() + ' ' + r11.i(), null, 4, null);     // Catch: Throwable -> L9
    L7:
        Object r19 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r20 = Result.m1424exceptionOrNullimpl(r19);
        if (r20 == null) goto L17;
        RunLog.INSTANCE.warn("PersistentAwarenessCallbackDispatcher", "persistent callback exception " + r11.i(), r20);
        return;
    L17:
        return;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessCallbackDispatcher", "persistent callback success " + r11.i(), false, 4, null);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final void a(Bundle r7, String r8, Object r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (ZeusTransformUtils.instanceOf(r9, Boolean.class) == false) goto L7;
        r7.putBoolean(r8, ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r9, Byte.class) == false) goto L10;
        r7.putByte(r8, ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).byteValue());
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r9, Character.class) == false) goto L13;
        r7.putChar(r8, ((Character) ZeusTransformUtils.preCheckCast(r9, Character.class, "com.obric.memorydata.plugin")).charValue());
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r9, Short.class) == false) goto L16;
        r7.putShort(r8, ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).shortValue());
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(r9, Integer.class) == false) goto L19;
        r7.putInt(r8, ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r9, Long.class) == false) goto L22;
        r7.putLong(r8, ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L22:
        if (ZeusTransformUtils.instanceOf(r9, Float.class) == false) goto L25;
        r7.putFloat(r8, ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L25:
        if (ZeusTransformUtils.instanceOf(r9, Double.class) == false) goto L28;
        r7.putDouble(r8, ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).doubleValue());
        return;
    L28:
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L31;
        r7.putString(r8, (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin"));
        return;
    L31:
        if (ZeusTransformUtils.instanceOf(r9, CharSequence.class) == false) goto L34;
        r7.putCharSequence(r8, (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L34:
        if (ZeusTransformUtils.instanceOf(r9, Bundle.class) == false) goto L38;
        Bundle r6 = (Bundle) ZeusTransformUtils.preCheckCast(r9, Bundle.class, "com.obric.memorydata.plugin");
    L36:
        r7.putBundle(r8, r6);
        return;
    L38:
        if (ZeusTransformUtils.instanceOf(r9, ArrayList.class) == false) goto L41;
    L39:
        a(r7, r8, (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"));
        return;
    L41:
        if (ZeusTransformUtils.instanceOf(r9, Map.class) == false) goto L55;
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.entrySet().iterator();
    L44:
        if (r11.hasNext() == false) goto L53;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r3 = r2.getKey();
        Object r4 = r2.getValue();
        Pair r5 = null;
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L48;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
    L49:
        if (r12 == null) goto L51;
        r5 = TuplesKt.to(r12, r4);
    L51:
        if (r5 == null) goto L44;
        r0.add(r5);
        goto L44
    L48:
        r12 = null;
        goto L49
    L53:
        r6 = a(MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));
        goto L36
    L55:
        if (ZeusTransformUtils.instanceOf(r9, List.class) == true) goto L39;
        if (ZeusTransformUtils.instanceOf(r9, Parcelable.class) == false) goto L61;
        r7.putParcelable(r8, (Parcelable) ZeusTransformUtils.preCheckCast(r9, Parcelable.class, "com.obric.memorydata.plugin"));
        return;
    L61:
        if (ZeusTransformUtils.instanceOf(r9, Serializable.class) == false) goto L63;
        r7.putSerializable(r8, (Serializable) ZeusTransformUtils.preCheckCast(r9, Serializable.class, "com.obric.memorydata.plugin"));
        return;
    L63:
        r7.putString(r8 + "_string", r9.toString());
    }

    private final void a(Bundle r6, String r7, List<?> r8) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L5;
    L7:
        Iterator r10 = r9.iterator();
    L9:
        if (r10.hasNext() == false) goto L6;
        if (ZeusTransformUtils.instanceOf(r10.next(), String.class) == true) goto L9;
        boolean r11 = false;
    L13:
        if (r11 == false) goto L21;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L16:
        if (r14.hasNext() == false) goto L20;
        Object r1 = r14.next();
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L16;
        r13.add(r1);
        goto L16
    L20:
        r6.putStringArrayList(r7, new ArrayList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        return;
    L21:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L24;
    L26:
        Iterator r16 = r15.iterator();
    L28:
        if (r16.hasNext() == false) goto L25;
        if (ZeusTransformUtils.instanceOf(r16.next(), CharSequence.class) == true) goto L28;
        boolean r17 = false;
    L32:
        if (r17 == false) goto L40;
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r18.iterator();
    L35:
        if (r20.hasNext() == false) goto L39;
        Object r3 = r20.next();
        if (ZeusTransformUtils.instanceOf(r3, CharSequence.class) == false) goto L35;
        r19.add(r3);
        goto L35
    L39:
        r6.putCharSequenceArrayList(r7, new ArrayList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        return;
    L40:
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r21, Collection.class) == true) goto L43;
    L45:
        Iterator r22 = r21.iterator();
    L47:
        if (r22.hasNext() == false) goto L44;
        if (ZeusTransformUtils.instanceOf(r22.next(), Integer.class) == true) goto L47;
        boolean r23 = false;
    L51:
        if (r23 == false) goto L59;
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r26 = r24.iterator();
    L54:
        if (r26.hasNext() == false) goto L58;
        Object r4 = r26.next();
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L54;
        r25.add(r4);
        goto L54
    L58:
        r6.putIntegerArrayList(r7, new ArrayList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        return;
    L59:
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r27, Collection.class) == true) goto L62;
    L64:
        Iterator r28 = r27.iterator();
    L66:
        if (r28.hasNext() == false) goto L63;
        if (ZeusTransformUtils.instanceOf(r28.next(), Parcelable.class) == true) goto L66;
    L69:
        if (r2 == false) goto L71;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.List<android.os.Parcelable>");
        r6.putParcelableArrayList(r7, new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")));
        return;
    L71:
        r6.putString(r7 + "_string", r5.toString());
        return;
    L63:
        r2 = true;
        goto L69
    L62:
        if (((Collection) ZeusTransformUtils.preCheckCast(r27, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L64;
    L44:
        r23 = true;
        goto L51
    L43:
        if (((Collection) ZeusTransformUtils.preCheckCast(r21, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L45;
    L25:
        r17 = true;
        goto L32
    L24:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L26;
    L6:
        r11 = true;
        goto L13
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    public final void a(Context r4, h r5, Object r6, Object r7, Map<String, ? extends Object> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Map<String, ? extends Object> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r5, "entity");
        Bundle r0 = new Bundle();
        e r1 = f8770a;
        r1.a(r0, "old_value", r6);
        r1.a(r0, "new_value", r7);
        if (r10 == null) goto L5;
        r0.putBundle("extras", r1.a(r10));
    L5:
        a(r9, r5, new AwarenessTarget("feature", r5.d()), r0);
    }

    public final void a(Context r3, h r4, String r5, Map<String, ? extends Object> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Map<String, ? extends Object> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r4, "entity");
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Bundle r0 = new Bundle();
        if (r8 == null) goto L5;
        r0.putBundle("extras", f8770a.a(r8));
    L5:
        a(r7, r4, new AwarenessTarget("event", r5), r0);
    }
}
