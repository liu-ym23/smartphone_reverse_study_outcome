package com.obric.aiproactive.impl.spell;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.ak;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016JM\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0010J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010 \u001a\u00020!H\u0002J\"\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00120#j\b\u0012\u0004\u0012\u00020\u0012`$2\b\u0010%\u001a\u0004\u0018\u00010\u001eH\u0002J\"\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\f0#j\b\u0012\u0004\u0012\u00020\f`$2\b\u0010%\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\f2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\fH\u0002J\u0012\u0010/\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u00100\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u000102H\u0016J1\u00103\u001a\u00020-2\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0002\u00104J;\u00105\u001a\u00020-2\u0006\u0010\b\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u0001022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0002\u00106¨\u00068"}, d2 = {"Lcom/obric/aiproactive/impl/spell/SpellProactiveProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "onCreate", "", ChatMessage.TYPE_QUERY, "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "arg", "extras", "checkPermission", "", "appContext", "Landroid/content/Context;", "validateCommon", "validateMethod", "eventsCursor", "events", "Lorg/json/JSONArray;", "taskSuccess", "output", "Lorg/json/JSONObject;", "jsonObjectList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "array", "jsonStringList", "taskFailure", "result", "Lcom/obric/memorydata/task/impl/TaskResult;", "mapTaskMessage", "errorBundle", "code", "", "message", "getType", "insert", "values", "Landroid/content/ContentValues;", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", BuildConfig.CHANNEL, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SpellProactiveProvider extends PluginContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6513a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f6514b = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/impl/spell/SpellProactiveProvider$Companion;", "", "<init>", "()V", "TAG", "", "SPELL_PACKAGE_NAME", "EVENT_COLUMNS", "", "[Ljava/lang/String;", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6513a = new a(null);
        f6514b = new String[]{"happened_at", "recorded_at", "fullContent"};
    }

    public SpellProactiveProvider() {
    }

    private final Cursor a(JSONArray r8) {
        MatrixCursor r7 = new MatrixCursor(f6514b, r8.length());
        int r0 = r8.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        JSONObject r3 = r8.optJSONObject(r2);
        if (r3 == null) goto L8;
        r7.addRow(new Object[]{Long.valueOf(r3.optLong("happened_at")), Long.valueOf(r3.optLong("recorded_at")), r3.optString("fullContent")});
    L8:
        r2 = r2 + 1;
        goto L3
    L10:
        return (Cursor) ZeusTransformUtils.preCheckCast(r7, Cursor.class, "com.obric.memorydata.plugin");
    }

    private final Bundle a(int r2, String r3) {
        Bundle r1 = new Bundle();
        r1.putInt("code", r2);
        r1.putString("message", r3);
        return r1;
    }

    private final Bundle a(TaskResult r4) {
        int r0 = r4.getCode();
        int r2 = 1004;
        if (r0 == 1) goto L6;
        if (r0 == 1004) goto L8;
        r2 = NearElevator.WIFI_SCAN_INTERVAL_WHEN_OUT_ELEVATOR;
    L8:
        return a(r2, b(r4));
    L6:
        r2 = 1400;
        goto L8
    }

    private final Bundle a(String r4, JSONObject r5) {
        Bundle r0 = new Bundle();
        r0.putInt("code", 0);
        r0.putString("message", "success");
        switch(r4.hashCode()) {
            case -2131051939: goto L19;
            case -537343635: goto L14;
            case 708472570: goto L10;
            case 965667071: goto L6;
            default: goto L21;
        };
    L21:
        return r0;
    L6:
        if (r4.equals("invoke_tool") == false) goto L21;
        String r3 = "result_json";
        String r6 = "{}";
    L17:
        r0.putString(r3, r5.optString(r3, r6));
        goto L21
    L10:
        if (r4.equals("list_tools") == false) goto L21;
        r0.putStringArrayList("tools", c(r5.optJSONArray("tools")));
        goto L21
    L14:
        if (r4.equals("get_user_insight") == false) goto L21;
        r3 = "user_insight";
        r6 = "";
        goto L17
    L19:
        if (r4.equals("get_realtime_status") == false) goto L21;
        r0.putParcelableArrayList("statuses", b(r5.optJSONArray("statuses")));
        goto L21
    }

    private final void a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        int r3 = Binder.getCallingUid();
        if (r3 != r1.getApplicationInfo().uid) goto L5;
        return;
    L5:
        String[] r4 = r1.getPackageManager().getPackagesForUid(r3);
        if (r4 != null) goto L9;
        r4 = new String[0];
    L9:
        if (ArraysKt.contains(r4, "com.obric.agentskills") == false) goto L14;
        if (ak.f13164a.a("com.obric.agentskills") == false) goto L14;
        return;
    L14:
        throw new SecurityException("caller is not allowed to access Spell proactive provider");
    }

    private final void a(Bundle r3) {
        if (r3.getInt(LocationMonitorConst.API_VERSION, -1) != 1) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L16;
        String r4 = r3.getString("log_id");
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("log_id is required".toString());
    L16:
        throw new IllegalArgumentException("unsupported api_version".toString());
    L5:
        r2 = false;
        goto L6
    }

    private final void a(String r6, Bundle r7) {
        String r2 = "";
        boolean r3 = true;
        switch(r6.hashCode()) {
            case -2131051939: goto L58;
            case -537343635: goto L55;
            case 198276776: goto L36;
            case 708472570: goto L33;
            case 965667071: goto L6;
            default: goto L71;
        };
    L6:
        if (r6.equals("invoke_tool") == false) goto L71;
        String r8 = r7.getString("tool_name");
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L31;
        String r9 = r7.getString("arguments_json");
        if (r9 == null) goto L17;
        r2 = r9;
    L17:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L74;
    L25:
        r3 = false;
    L26:
        if (r3 == false) goto L29;
        return;
    L29:
        throw new IllegalArgumentException("arguments_json must be a JSON object".toString());
    L74:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L20
        SpellProactiveProvider r5 = (SpellProactiveProvider) ZeusTransformUtils.preCheckCast(this, SpellProactiveProvider.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Object r11 = Result.m1421constructorimpl(new JSONObject(r2));     // Catch: Throwable -> L20
    L23:
        if (Result.m1428isSuccessimpl(r11) == false) goto L25;
    L20:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L23
    L31:
        throw new IllegalArgumentException("tool_name is required".toString());
    L33:
        if (r6.equals("list_tools") == false) goto L71;
        return;
    L36:
        if (r6.equals("upsert_trigger") == false) goto L71;
        String r13 = r7.getString("condition_json");
        if (r13 == null) goto L42;
        r2 = r13;
    L42:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L53;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L45
        SpellProactiveProvider r15 = (SpellProactiveProvider) ZeusTransformUtils.preCheckCast(this, SpellProactiveProvider.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        Object r16 = Result.m1421constructorimpl(new JSONObject(r2));     // Catch: Throwable -> L45
    L48:
        if (Result.m1428isSuccessimpl(r16) == false) goto L51;
        return;
    L51:
        throw new IllegalArgumentException("condition_json must be a JSON object".toString());
    L45:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L48
    L53:
        throw new IllegalArgumentException("condition_json is required".toString());
    L55:
        if (r6.equals("get_user_insight") == false) goto L71;
        return;
    L58:
        if (r6.equals("get_realtime_status") == false) goto L71;
        ArrayList<String> r18 = r7.getStringArrayList("keys");
        if (r18 == null) goto L69;
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L63:
        if (r19.hasNext() == false) goto L83;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r20);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L63;
        throw new IllegalArgumentException("keys must not contain blank values".toString());
    L83:
        return;
    L69:
        return;
    L71:
        throw new IllegalArgumentException("unsupported method=" + r6);
    }

    private final String b(TaskResult r2) {
        String r1 = r2.getMsg();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r1 = null;
    L6:
        if (r1 != null) goto L9;
        return "algorithm package failed";
    L9:
        return r1;
    }

    private final ArrayList<Bundle> b(JSONArray r8) {
        ArrayList<Bundle> r7 = new ArrayList();
        if (r8 != null) goto L5;
        return r7;
    L5:
        int r0 = 0;
        int r1 = r8.length();
    L6:
        if (r0 >= r1) goto L12;
        JSONObject r2 = r8.optJSONObject(r0);
        if (r2 == null) goto L11;
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin");
        Bundle r4 = new Bundle();
        r4.putString("key", r2.optString("key"));
        r4.putString(EventBody.KEY_VALUE, r2.optString(EventBody.KEY_VALUE));
        r3.add(r4);
    L11:
        r0 = r0 + 1;
        goto L6
    L12:
        return r7;
    }

    private final ArrayList<String> c(JSONArray r6) {
        ArrayList<String> r5 = new ArrayList();
        if (r6 != null) goto L5;
        return r5;
    L5:
        int r0 = 0;
        int r1 = r6.length();
    L6:
        if (r0 >= r1) goto L14;
        String r2 = r6.optString(r0);
        Intrinsics.checkNotNull(r2);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L13;
        r5.add(r2);
    L13:
        r0 = r0 + 1;
        goto L6
    L14:
        return r5;
    }

    public Bundle call(String r10, String r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "method");
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L36;
        if (r12 != null) goto L37;
        r12 = Bundle.EMPTY;
    L37:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        SpellProactiveProvider r2 = (SpellProactiveProvider) ZeusTransformUtils.preCheckCast(this, SpellProactiveProvider.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        r2.a(r13);     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L18
        r2.a(r12);     // Catch: Throwable -> L18
        String r14 = r12.getString("log_id");     // Catch: Throwable -> L18
        if (r14 != null) goto L9;
        r14 = "";
    L9:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SpellProactiveProvider", "call method=" + r10 + " logId=" + r14, false, 4, null);     // Catch: Throwable -> L18
        r2.a(r10, r12);     // Catch: Throwable -> L18
        TaskResult r15 = d.f6520a.a(r10, r12);     // Catch: Throwable -> L18
        if (r15.getCode() == 0) goto L13;
        Bundle r16 = r2.a(r15);     // Catch: Throwable -> L18
    L16:
        Object r17 = Result.m1421constructorimpl(r16);     // Catch: Throwable -> L18
    L20:
        Throwable r18 = Result.m1424exceptionOrNullimpl(r17);
        if (r18 == null) goto L34;
        if (ZeusTransformUtils.instanceOf(r18, IllegalArgumentException.class) == false) goto L29;
        int r19 = 1400;
        String r110 = r18.getMessage();
        if (r110 != null) goto L32;
        r110 = "invalid argument";
    L32:
        r17 = a(r19, r110);
        goto L34
    L29:
        if (ZeusTransformUtils.instanceOf(r18, SecurityException.class) == false) goto L31;
        r19 = 1403;
        r110 = "unauthorized";
        goto L32
    L31:
        RunLog.INSTANCE.error("SpellProactiveProvider", "call failed method=" + r10, r18);
        r19 = NearElevator.WIFI_SCAN_INTERVAL_WHEN_OUT_ELEVATOR;
        r110 = "internal error";
    L34:
        return (Bundle) ZeusTransformUtils.preCheckCast(r17, Bundle.class, "com.obric.memorydata.plugin");
    L13:
        if (Intrinsics.areEqual(r10, "upsert_trigger") == false) goto L15;
        com.obric.aiproactive.impl.aidb.b.f6306a.a((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf("SpellProactiveEca"), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L18
    L15:
        r16 = r2.a(r10, r15.getOutput());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L20
    L36:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        throw new UnsupportedOperationException();
    }

    public String getType(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        throw new UnsupportedOperationException();
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri r11, String[] r12, String r13, String[] r14, String r15) {
        Intrinsics.checkNotNullParameter(r11, "uri");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L72;
        a(r0);
        if (Intrinsics.areEqual(r11, com.obric.aiproactive.impl.spell.a.f6515a.a()) == false) goto L70;
        boolean r16 = true;
        if (r12 != null) goto L9;
        boolean r17 = true;
    L10:
        if (r17 == false) goto L68;
        if (r13 != null) goto L13;
        boolean r18 = true;
    L14:
        if (r18 == false) goto L66;
        if (r15 != null) goto L17;
        boolean r19 = true;
    L18:
        if (r19 == false) goto L64;
        if (r14 != null) goto L21;
    L23:
        boolean r110 = false;
    L24:
        if (r110 == false) goto L62;
        if (r14 == null) goto L60;
        String r111 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r14[0], CharSequence.class, "com.obric.memorydata.plugin")).toString();
        Long r112 = StringsKt.toLongOrNull(r14[1]);
        if (r112 == null) goto L58;
        long r2 = r112.longValue();
        Long r113 = StringsKt.toLongOrNull(r14[2]);
        if (r113 == null) goto L56;
        long r114 = r113.longValue();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L33;
        boolean r115 = true;
    L34:
        if (r115 == false) goto L54;
        if (r2 >= 0) goto L38;
    L40:
        r16 = false;
    L41:
        if (r16 == false) goto L52;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SpellProactiveProvider", "query events logId=" + r111 + " start=" + r2 + " end=" + r114, false, 4, null);
        Bundle r116 = new Bundle();
        r116.putLong("start_time_ms", r2);
        r116.putLong("end_time_ms", r114);
        TaskResult r117 = d.f6520a.a("query_events", r116);
        if (r117.getCode() != 0) goto L50;
        JSONArray r118 = r117.getOutput().optJSONArray("events");
        if (r118 != null) goto L48;
        r118 = new JSONArray();
    L48:
        return a(r118);
    L50:
        throw new IllegalStateException(b(r117));
    L52:
        throw new IllegalArgumentException("invalid time range".toString());
    L38:
        if (r2 >= r114) goto L40;
    L54:
        throw new IllegalArgumentException("log_id is required".toString());
    L33:
        r115 = false;
        goto L34
    L56:
        throw new IllegalArgumentException("end_time_ms must be a long");
    L58:
        throw new IllegalArgumentException("start_time_ms must be a long");
    L60:
        throw new IllegalArgumentException("Required value was null.".toString());
    L62:
        throw new IllegalArgumentException("selectionArgs must be [log_id, start_time_ms, end_time_ms]".toString());
    L21:
        if (r14.length != 3) goto L23;
        r110 = true;
        goto L24
    L64:
        throw new IllegalArgumentException("sortOrder is not supported".toString());
    L17:
        r19 = false;
        goto L18
    L66:
        throw new IllegalArgumentException("selection is not supported".toString());
    L13:
        r18 = false;
        goto L14
    L68:
        throw new IllegalArgumentException("projection is not supported".toString());
    L9:
        r17 = false;
        goto L10
    L70:
        throw new IllegalArgumentException(("unsupported uri=" + r11).toString());
    L72:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        throw new UnsupportedOperationException();
    }
}
