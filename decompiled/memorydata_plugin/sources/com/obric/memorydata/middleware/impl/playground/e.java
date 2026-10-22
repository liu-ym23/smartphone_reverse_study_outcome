package com.obric.memorydata.middleware.impl.playground;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001f*\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\f\u0010 \u001a\u00020\u000e*\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/EntityStorePersistence;", "", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "<init>", "(Lcom/obric/memorydata/middleware/api/store/IStore;)V", "restore", "Lcom/obric/memorydata/middleware/impl/playground/EntityStoreSnapshot;", "commit", "", "state", "logCommitFailure", "", InfoRequestQPSOptTraceLogger.REASON, "", "errorType", "encodeSnapshot", "decodeSnapshot", "raw", "toEntityArray", "Lorg/json/JSONArray;", "", "validEntity", "Lorg/json/JSONObject;", "ecaPattern", "Lkotlin/text/Regex;", "strictPositiveInt", "", ActivityLifecycle.NAME, "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "uniqueStrings", "", "identity", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f11818a = null;
    private static final Regex c = null;
    private static final Regex d = null;
    private static final Regex e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IStore f11819b;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/EntityStorePersistence$Companion;", "", "<init>", "()V", "TAG", "", "LOG_CODE_RESTORE_INVALID", "LOG_CODE_RESTORE_FAILED", "LOG_CODE_COMMIT_FAILED", "SNAPSHOT_KEY", "CURRENT_SCHEMA_VERSION", "", "SCHEMA_VERSION", "NORMAL_CAPACITY", "NORMAL", "VIRTUAL", "LOCAL", "DELETED", "LOCAL_IDS", "ID", "TYPE", "ECA_ID", "NORMAL_ID", "Lkotlin/text/Regex;", "getNORMAL_ID", "()Lkotlin/text/Regex;", "VIRTUAL_ID", "getVIRTUAL_ID", "LOCAL_ID", "getLOCAL_ID", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11818a = new a(null);
        c = new Regex("^\\$E_\\d+$");
        d = new Regex("^\\$E_A\\d+$");
        e = new Regex("^\\$NE_\\d+$");
    }

    public e(IStore r3) {
        IStore r4 = (IStore) ZeusTransformUtils.wrapperContextForParams(r3, IStore.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "store");
        this.f11819b = r4;
    }

    private final f a(String r19) {
        Object r2 = null;
        f r3 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L136
        e r1 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L136
        JSONObject r4 = new JSONObject(r19);     // Catch: Throwable -> L136
        Integer r5 = r1.a(r4, "schemaVersion");     // Catch: Throwable -> L136
        if (r5 != null) goto L7;
    L8:
        return null;
    L7:
        if (r5.intValue() != 1) goto L8;
        Integer r6 = r1.a(r4, "normalCapacity");     // Catch: Throwable -> L136
        if (r6 == null) goto L135;
        int r7 = r6.intValue();     // Catch: Throwable -> L136
        JSONArray r8 = r4.optJSONArray("normal");     // Catch: Throwable -> L136
        if (r8 != null) goto L14;
        return null;
    L14:
        JSONArray r9 = r4.optJSONArray("virtual");     // Catch: Throwable -> L136
        if (r9 != null) goto L17;
        return null;
    L17:
        JSONArray r10 = r4.optJSONArray("local");     // Catch: Throwable -> L136
        if (r10 != null) goto L20;
        return null;
    L20:
        JSONArray r11 = r4.optJSONArray("deleted");     // Catch: Throwable -> L136
        if (r11 != null) goto L23;
        return null;
    L23:
        LinkedHashMap r12 = new LinkedHashMap();     // Catch: Throwable -> L136
        Set r13 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L136
        int r14 = r8.length();     // Catch: Throwable -> L136
        int r15 = 0;
    L26:
        if (r15 >= r14) goto L40;
        JSONObject r16 = r8.optJSONObject(r15);     // Catch: Throwable -> L136
        if (r16 == null) goto L38;
        JSONObject r17 = r1.a(r16, c);     // Catch: Throwable -> L136
        if (r17 == null) goto L38;
        if (r12.put(r17.getString("ecaId"), r17.toString()) != null) goto L38;
        if (r13.add(r1.a(r17)) == false) goto L38;
        r15 = r15 + 1;     // Catch: Throwable -> L136
    L38:
        return null;
    L40:
        if (r12.size() <= r7) goto L42;
        return null;
    L42:
        LinkedHashMap r18 = new LinkedHashMap();     // Catch: Throwable -> L136
        int r20 = r10.length();     // Catch: Throwable -> L136
        int r110 = 0;
    L43:
        if (r110 >= r20) goto L54;
        JSONObject r111 = r10.optJSONObject(r110);     // Catch: Throwable -> L136
        if (r111 == null) goto L53;
        JSONObject r112 = r1.a(r111, e);     // Catch: Throwable -> L136
        if (r112 == null) goto L53;
        if (r18.put(r112.getString("ecaId"), r112.toString()) != null) goto L51;
        r110 = r110 + 1;     // Catch: Throwable -> L136
        goto L43
    L51:
        return null;
    L53:
        return null;
    L54:
        LinkedHashMap r21 = new LinkedHashMap();     // Catch: Throwable -> L136
        Set r22 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L136
        int r113 = r9.length();     // Catch: Throwable -> L136
        int r114 = 0;
    L55:
        if (r114 >= r113) goto L108;
        JSONObject r115 = r9.optJSONObject(r114);     // Catch: Throwable -> L136
        if (r115 == null) goto L58;
        String r116 = r115.optString("ecaId");     // Catch: Throwable -> L136
    L133:
        th = th;
        r2 = null;
    L137:
        Result.Companion r23 = Result.Companion;
        Object r24 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L139:
        if (Result.m1427isFailureimpl(r24) == true) goto L143;
        r2 = r24;
    L143:
        return (f) ZeusTransformUtils.preCheckCast(r2, f.class, "com.obric.memorydata.plugin");
    L61:
        if (d.matches((CharSequence) ZeusTransformUtils.preCheckCast(r116, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L64;
        r116 = null;
    L64:
        if (r116 == null) goto L65;
        List<String> r25 = r1.b(r115, "localIds");     // Catch: Throwable -> L133
        if (r25 == null) goto L105;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r25, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L73;
        r25 = null;
    L73:
        if (r25 == null) goto L175;
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L133
        if (ZeusTransformUtils.instanceOf(r26, Collection.class) == true) goto L77;
    L79:
        Iterator r27 = r26.iterator();     // Catch: Throwable -> L133
    L81:
        if (r27.hasNext() == false) goto L94;
        Iterator r117 = r27;
        String r28 = (String) ZeusTransformUtils.preCheckCast(r27.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L133
        JSONArray r118 = r9;
        if (e.matches((CharSequence) ZeusTransformUtils.preCheckCast(r28, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L85;
    L90:
        boolean r119 = true;
    L91:
        if (r119 == true) goto L92;
        r27 = r117;
        r9 = r118;
        goto L81
    L92:
        boolean r120 = true;
    L95:
        if (r120 == true) goto L96;
        if (r21.put(r116, r25) != null) goto L101;
        r114 = r114 + 1;
        r9 = r118;
        r3 = null;
        goto L55
    L101:
        return null;
    L103:
        th = th;
        r2 = null;
        goto L137
    L96:
        return null;
    L85:
        if (((Map) ZeusTransformUtils.preCheckCast(r18, Map.class, "com.obric.memorydata.plugin")).containsKey(r28) == false) goto L90;
        if (r22.add(r28) == false) goto L90;
        r119 = false;
    L94:
        r118 = r9;
        r120 = false;
        goto L95
    L77:
        if (((Collection) ZeusTransformUtils.preCheckCast(r26, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L79;
    L175:
        return null;
    L105:
        return null;
    L65:
        return null;
    L58:
        return r3;
    L108:
        if (Intrinsics.areEqual(r22, r18.keySet()) == true) goto L111;
        return null;
    L111:
        LinkedHashMap r121 = new LinkedHashMap();     // Catch: Throwable -> L133
        int r29 = r11.length();     // Catch: Throwable -> L133
        int r122 = 0;
    L112:
        if (r122 >= r29) goto L127;
        JSONObject r30 = r11.optJSONObject(r122);     // Catch: Throwable -> L133
        if (r30 == null) goto L125;
        JSONObject r31 = a(r1, r30, null, 1, null);     // Catch: Throwable -> L123
        if (r31 == null) goto L174;
        if (r121.put(r1.a(r31), r31.toString()) != null) goto L121;
        r122 = r122 + 1;
        goto L112
    L121:
        return null;
    L174:
        return null;
    L123:
        th = th;
        r2 = null;
        goto L137
    L125:
        return null;
    L127:
        r2 = null;
        if (r121.size() <= r7) goto L131;
        return null;
    L131:
        r24 = Result.m1421constructorimpl(new f(r7, r12, r21, r18, r121));     // Catch: Throwable -> L133
        r2 = null;
        goto L139
    L135:
        return null;
    L136:
        th = th;
        goto L137
    }

    private final Integer a(JSONObject r6, String r7) {
        Object r5 = r6.opt(r7);
        if (ZeusTransformUtils.instanceOf(r5, Number.class) == false) goto L5;
        Number r8 = (Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin");
    L6:
        if (r8 != null) goto L8;
        return null;
    L8:
        long r0 = r8.longValue();
        boolean r9 = true;
        if (r8.doubleValue() != r0) goto L11;
        boolean r10 = true;
    L12:
        if (r10 == true) goto L14;
    L23:
        return null;
    L14:
        if (1 <= r0) goto L16;
    L18:
        r9 = false;
    L19:
        if (r9 == false) goto L23;
        return Integer.valueOf((int) r0);
    L16:
        if (r0 > 2147483647L) goto L18;
    L11:
        r10 = false;
        goto L12
    L5:
        r8 = null;
        goto L6
    }

    private final String a(JSONObject r2) {
        return r2.optString(OaidModel.KEY_ID) + '_' + r2.optString("type");
    }

    private final JSONArray a(Collection<String> r4) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        JSONArray r5 = new JSONArray();
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r5.put(new JSONObject((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        return r5;
    }

    static /* synthetic */ JSONObject a(e r0, JSONObject r1, Regex r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = null;
    L6:
        return r0.a(r1, r2);
    }

    private final JSONObject a(JSONObject r6, Regex r7) {
        if (r6.has(OaidModel.KEY_ID) == true) goto L5;
    L30:
        return null;
    L5:
        if (r6.isNull(OaidModel.KEY_ID) == true) goto L30;
        if (r6.has("type") == false) goto L30;
        if (r6.isNull("type") == true) goto L30;
        String r5 = r6.optString(OaidModel.KEY_ID);
        Intrinsics.checkNotNullExpressionValue(r5, "optString(...)");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L30;
        String r8 = r6.optString("type");
        Intrinsics.checkNotNullExpressionValue(r8, "optString(...)");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L30;
        if (r7 == null) goto L21;
        String r0 = r6.optString("ecaId");
        Intrinsics.checkNotNullExpressionValue(r0, "optString(...)");
        if (r7.matches((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L21;
        return null;
    L21:
        if (r7 == null) goto L23;
    L29:
        return r6;
    L23:
        if (r6.has("ecaId") == false) goto L29;
        Regex r9 = c;
        String r1 = r6.optString("ecaId");
        Intrinsics.checkNotNullExpressionValue(r1, "optString(...)");
        if (r9.matches((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L29;
        Regex r10 = e;
        String r11 = r6.optString("ecaId");
        Intrinsics.checkNotNullExpressionValue(r11, "optString(...)");
        if (r10.matches((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L29;
        return null;
    }

    static /* synthetic */ void a(e r0, f r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.a(r1, r2, r3);
    }

    private final void a(f r7, String r8, String r9) {
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r6 = new StringBuilder().append("[code=playground_eca_snapshot_commit_failed] ECA snapshot commit failed reason=").append(r8).append(" normalCount=").append(r7.b().size()).append(" virtualCount=").append(r7.c().size()).append(" localCount=").append(r7.d().size()).append(" deletedCount=").append(r7.e().size());
        if (r9 == null) goto L5;
        String r10 = " errorType=" + r9;
    L6:
        if (r10 != null) goto L8;
        r10 = "";
    L8:
        IRunLog.a.a(r0, "EntityStorePersistence", r6.append(r10).toString(), null, 4, null);
        return;
    L5:
        r10 = null;
        goto L6
    }

    private final String b(f r10) {
        JSONObject r0 = new JSONObject().put("schemaVersion", 1).put("normalCapacity", r10.a());
        Collection<String> r1 = r10.b().values();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-values>(...)");
        JSONObject r2 = r0.put("normal", a(r1));
        JSONArray r3 = new JSONArray();
        Iterator r4 = ((Map) ZeusTransformUtils.preCheckCast(r10.c(), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.preCheckCast(r5.getValue(), List.class, "com.obric.memorydata.plugin");
        r3.put(new JSONObject().put("ecaId", r6).put("localIds", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin"))));
        goto L4
    L6:
        Unit r8 = Unit.INSTANCE;
        JSONObject r9 = r2.put("virtual", r3);
        Collection<String> r11 = r10.d().values();
        Intrinsics.checkNotNullExpressionValue(r11, "<get-values>(...)");
        JSONObject r12 = r9.put("local", a(r11));
        Collection<String> r13 = r10.e().values();
        Intrinsics.checkNotNullExpressionValue(r13, "<get-values>(...)");
        String r14 = r12.put("deleted", a(r13)).toString();
        Intrinsics.checkNotNullExpressionValue(r14, "toString(...)");
        return r14;
    }

    private final List<String> b(JSONObject r8, String r9) {
        JSONArray r7 = r8.optJSONArray(r9);
        if (r7 != null) goto L5;
        return null;
    L5:
        List r10 = CollectionsKt.createListBuilder();
        int r0 = r7.length();
        boolean r1 = false;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L15;
        String r5 = r7.optString(r2);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L13;
        r10.add(r5);
        r2 = r2 + 1;
        goto L7
    L13:
        return null;
    L15:
        List<String> r11 = CollectionsKt.build(r10);
        if (r11.size() != CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).size()) goto L18;
        r1 = true;
    L18:
        if (r1 == true) goto L20;
        return null;
    L20:
        return r11;
    }

    public final f a() {
        String r2 = this.f11819b.getString("ai_proactive_agent:playground_eca:v1:snapshot");     // Catch: Exception -> L10
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L15;
        f r9 = a(r2);     // Catch: Exception -> L10
        if (r9 != null) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityStorePersistence", "[code=playground_eca_snapshot_restore_invalid] ECA snapshot is invalid", null, 4, null);     // Catch: Exception -> L10
    L16:
        return r9;
    L15:
        return null;
    L10:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityStorePersistence", "[code=playground_eca_snapshot_restore_failed] ECA snapshot restore failed errorType=" + e.getClass().getSimpleName(), null, 4, null);
        return null;
    }

    public final boolean a(f r8) {
        Intrinsics.checkNotNullParameter(r8, "state");
        boolean r0 = this.f11819b.syncSave("ai_proactive_agent:playground_eca:v1:snapshot", b(r8));     // Catch: Exception -> L7
        if (r0 == true) goto L12;
        a(this, r8, "sync_save_false", null, 4, null);     // Catch: Exception -> L7
        return r0;
    L12:
        return r0;
    L7:
        e = move-exception;
        a(r8, CommonConsts.LOG_REPORT_TYPE_EXCEPTION, e.getClass().getSimpleName());
        return false;
    }
}
