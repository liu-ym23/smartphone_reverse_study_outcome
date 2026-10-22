package com.obric.memorydata.migration.sdk.internal.a;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.migration.sdk.KvValueType;
import com.obric.memorydata.migration.sdk.i;
import com.obric.memorydata.migration.sdk.j;
import com.obric.memorydata.migration.sdk.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017J$\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0019\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001e\u0010\u001c\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001e\u0010\u001d\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J&\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0014H\u0002J,\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00052\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!0%H\u0002J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020!H\u0002J \u0010.\u001a\u00020/2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020!2\u0006\u00100\u001a\u00020+H\u0002J\u001a\u00101\u001a\u0004\u0018\u00010+2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0001H\u0002J \u00104\u001a\u00020/2\u0006\u0010,\u001a\u00020)2\u0006\u00102\u001a\u00020\u00052\u0006\u00100\u001a\u00020+H\u0002J(\u00105\u001a\u00020/2\u0006\u0010,\u001a\u00020)2\u0006\u00102\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\u0006\u00100\u001a\u00020+H\u0002J\u0010\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u000208H\u0002J\u0016\u00109\u001a\u00020:2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00050<H\u0002J\u0018\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00050<2\b\u0010>\u001a\u0004\u0018\u00010:H\u0002J\n\u0010?\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/kv/KvBackup;", "", "<init>", "()V", "KV_DIR_NAME", "", "PERSONAL_FILE_NAME", "PERSONAL_LOGIC_NAME", "TYPE_BOOLEAN", "TYPE_DOUBLE", "TYPE_FLOAT", "TYPE_INT", "TYPE_LONG", "TYPE_STRING", "TYPE_STRING_SET", "dump", "", "context", "Landroid/content/Context;", "kvRepos", "", "Lcom/obric/memorydata/migration/sdk/KvRepoConfig;", "rootDir", "Ljava/io/File;", "restore", "restoreDir", "kvDir", "personalFile", "dumpWhitelist", "restoreWhitelist", "dumpWhitelistOneRepo", "repoName", "keys", "Lcom/obric/memorydata/migration/sdk/KvKey;", "restoreWhitelistOneRepo", "file", "whitelist", "", "dumpPersonal", "restorePersonal", "openStore", "Lcom/obric/memorydata/middleware/api/store/IStore;", "readEntryByDeclaredType", "Lorg/json/JSONObject;", "store", "kvKey", "restoreEntryByDeclaredType", "", "entry", "entryFromTypedValue", "key", EventBody.KEY_VALUE, "restoreEntryByTag", "saveValueByType", "typeTag", "type", "Lcom/obric/memorydata/migration/sdk/KvValueType;", "stringSetToJson", "Lorg/json/JSONArray;", "set", "", "stringSetFromJson", "arr", "resolvePersonalUserIdOrNull", "maskUserId", "userId", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11904a = null;

    /* JADX INFO: renamed from: com.obric.memorydata.migration.sdk.internal.a.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class C0643a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11905a = null;

        static {
            int[] r0 = new int[KvValueType.values().length];
            r0[KvValueType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[KvValueType.DOUBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[KvValueType.FLOAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[KvValueType.INT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[KvValueType.LONG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[KvValueType.STRING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[KvValueType.STRING_SET.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f11905a = r0;
        }
    }

    static {
        f11904a = new a();
    }

    private a() {
    }

    private final IStore a(String r2) {
        return StoreManager.INSTANCE.getStore(r2, 0);
    }

    private static final CharSequence a(j r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a() + "(keys=" + r2.b().size() + ')', CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final String a() {
        String r4 = AppContext.INSTANCE.getUserId();
        Long r0 = StringsKt.toLongOrNull(r4);
        if (AppContext.INSTANCE.isLogin() == false) goto L8;
        if (r0 == null) goto L8;
        if (r0.longValue() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L13;
        return null;
    L13:
        return r4;
    L8:
        r1 = false;
        goto L9
    }

    private final String a(KvValueType r1) {
        switch(C0643a.f11905a[r1.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return "stringSet";
    L7:
        return TypedValues.Custom.S_STRING;
    L8:
        return "long";
    L9:
        return "int";
    L10:
        return TypedValues.Custom.S_FLOAT;
    L11:
        return "double";
    L12:
        return TypedValues.Custom.S_BOOLEAN;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    private final Set<String> a(JSONArray r4) {
        if (r4 == null) goto L4;
        LinkedHashSet r3 = new LinkedHashSet();
        int r0 = 0;
        int r1 = r4.length();
    L6:
        if (r0 >= r1) goto L13;
        String r2 = r4.optString(r0, null);
        if (r2 == null) goto L11;
        r3.add(r2);
    L11:
        r0 = r0 + 1;
        goto L6
    L13:
        return (Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.memorydata.plugin");
    L4:
        return SetsKt.emptySet();
    }

    private final JSONArray a(Set<String> r3) {
        Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        JSONArray r4 = new JSONArray();
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r4.put(r5.next());
        goto L4
    L6:
        return r4;
    }

    private final JSONObject a(IStore r9, i r10) {
        IStore r0 = (IStore) ZeusTransformUtils.wrapperContextForParams(r9, IStore.class, "com.obric.memorydata.plugin");
        JSONObject r11 = new JSONObject().put("key", r10.a());
        r11.put("type", a(r10.getType()));
        switch(C0643a.f11905a[r10.getType().ordinal()]) {
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        JSONObject r8 = r11.put(EventBody.KEY_VALUE, a(r0.getStringSet(r10.a(), SetsKt.emptySet())));
        Intrinsics.checkNotNull(r8);
        return r8;
    L7:
        JSONObject r12 = r11.put(EventBody.KEY_VALUE, r0.getString(r10.a()));
    L14:
        Intrinsics.checkNotNullExpressionValue(r12, "put(...)");
        return r12;
    L8:
        r12 = r11.put(EventBody.KEY_VALUE, IStore.a.a(r0, r10.a(), 0, 2, null));
        goto L14
    L9:
        r12 = r11.put(EventBody.KEY_VALUE, r0.getInt(r10.a()));
        goto L14
    L10:
        double r1 = IStore.a.a(r0, r10.a(), 0.0f, 2, null);
    L12:
        r12 = r11.put(EventBody.KEY_VALUE, r1);
        goto L14
    L11:
        r1 = IStore.a.a(r0, r10.a(), 0.0d, 2, null);
        goto L12
    L13:
        r12 = r11.put(EventBody.KEY_VALUE, r0.getBoolean(r10.a()));
        goto L14
    L5:
        throw new NoWhenBranchMatchedException();
    }

    private final JSONObject a(String r8, Object r9) {
        JSONObject r7 = new JSONObject().put("key", r8);
        if (ZeusTransformUtils.instanceOf(r9, Boolean.class) == false) goto L6;
        return r7.put("type", TypedValues.Custom.S_BOOLEAN).put(EventBody.KEY_VALUE, ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
    L6:
        if (ZeusTransformUtils.instanceOf(r9, Double.class) == false) goto L10;
        JSONObject r10 = r7.put("type", "double");
        double r11 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).doubleValue();
    L49:
        return r10.put(EventBody.KEY_VALUE, r11);
    L10:
        if (ZeusTransformUtils.instanceOf(r9, Float.class) == false) goto L13;
        r10 = r7.put("type", TypedValues.Custom.S_FLOAT);
        r11 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).floatValue();
        goto L49
    L13:
        if (ZeusTransformUtils.instanceOf(r9, Integer.class) == false) goto L16;
        return r7.put("type", "int").put(EventBody.KEY_VALUE, ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue());
    L16:
        if (ZeusTransformUtils.instanceOf(r9, Long.class) == false) goto L19;
        return r7.put("type", "long").put(EventBody.KEY_VALUE, ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).longValue());
    L19:
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L22;
        return r7.put("type", TypedValues.Custom.S_STRING).put(EventBody.KEY_VALUE, r9);
    L22:
        if ((r9 instanceof Object[]) == false) goto L31;
        JSONArray r12 = new JSONArray();
        Object[] r13 = (Object[]) ZeusTransformUtils.preCheckCast(r9, Object[].class, "com.obric.memorydata.plugin");
        int r0 = 0;
        int r4 = r13.length;
    L24:
        if (r0 >= r4) goto L53;
        Object r5 = r13[r0];
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L28;
        r12.put(r5);
    L28:
        r0 = r0 + 1;
    L53:
        return r7.put("type", "stringSet").put(EventBody.KEY_VALUE, r12);
    L31:
        if (ZeusTransformUtils.instanceOf(r9, Set.class) == false) goto L38;
        r12 = new JSONArray();
        Iterator r14 = ((Set) ZeusTransformUtils.preCheckCast(r9, Set.class, "com.obric.memorydata.plugin")).iterator();
    L34:
        if (r14.hasNext() == false) goto L53;
        Object r1 = r14.next();
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L34;
        r12.put(r1);
        goto L34
    L38:
        return null;
    }

    private final void a(File r12, String r13, List<i> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        IStore r0 = a(r13);
        JSONArray r2 = new JSONArray();
        Iterator r16 = r15.iterator();
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r16.hasNext() == false) goto L10;
        i r5 = (i) ZeusTransformUtils.preCheckCast(r16.next(), i.class, "com.obric.memorydata.plugin");
        if (r0.contains(r5.a()) == true) goto L8;
        r4 = r4 + 1;
        t r6 = t.f11981a;
        StringBuilder r7 = new StringBuilder().append("kv dump: miss   repo=").append(r13).append(" key=").append(r5.a()).append(" type=").append(r5.getType()).append(" (not in store)");
    L9:
        r6.a(r7.toString());
        goto L4
    L8:
        r2.put(a(r0, r5));
        r3 = r3 + 1;
        r6 = t.f11981a;
        r7 = new StringBuilder().append("kv dump: write  repo=").append(r13).append(" key=").append(r5.a()).append(" type=").append(r5.getType());
        goto L9
    L10:
        JSONObject r11 = new JSONObject().put("repoName", r13).put("entries", r2);
        File r17 = new File(r12, r13 + ".json");
        String r18 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r18, "toString(...)");
        FilesKt.writeText(r17, r18, Charsets.UTF_8);
        t.f11981a.a("kv dump: repo=" + r13 + " done, written=" + r3 + ", missingInRepo=" + r4 + ", file=" + r17.getAbsolutePath() + ", size=" + r17.length() + 'B');
    }

    private final void a(File r17, String r18, Map<String, i> r19) {
        a r0 = this;
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        JSONArray r4 = new JSONObject(FilesKt.readText(r17, Charsets.UTF_8)).optJSONArray("entries");
        if (r4 != null) goto L5;
        r4 = new JSONArray();
    L5:
        IStore r6 = r0.a(r18);
        t.f11981a.a("kv restore: repo=" + r18 + " begin, file=" + r17.getAbsolutePath() + ", size=" + r17.length() + "B, onDiskEntries=" + r4.length() + ", whitelistKeys=" + r2.size());
        int r5 = r4.length();
        int r8 = 0;
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L6:
        if (r8 >= r5) goto L23;
        JSONObject r13 = r4.optJSONObject(r8);
        if (r13 != null) goto L10;
    L9:
        Map r110 = r2;
    L22:
        r8 = r8 + 1;
        r0 = this;
        r2 = r110;
        goto L6
    L10:
        String r14 = r13.optString("key", "");
        Intrinsics.checkNotNull(r14);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L13;
        boolean r15 = true;
    L14:
        if (r15 == true) goto L9;
        i r7 = (i) ZeusTransformUtils.preCheckCast(r2.get(r14), i.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L18;
        r11 = r11 + 1;
        r110 = r2;
        t.f11981a.a("kv restore: skip   repo=" + r18 + " key=" + r14 + " (not in whitelist)");
        goto L22
    L18:
        r110 = r2;
        if (r0.a(r6, r7, r13) == false) goto L21;
        r10 = r10 + 1;
        t.f11981a.a("kv restore: write  repo=" + r18 + " key=" + r14 + " type=" + r7.getType());
        goto L22
    L21:
        r12 = r12 + 1;
        goto L22
    L13:
        r15 = false;
        goto L14
    L23:
        t.f11981a.a("kv restore: repo=" + r18 + " done, written=" + r10 + ", skippedByWhitelist=" + r11 + ", skippedTypeMismatch=" + r12);
    }

    private final void a(List<j> r14, File r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        if (r16.isEmpty() == false) goto L7;
        t r13 = t.f11981a;
        String r17 = "kv dump: no kv repo configured, skip whitelist";
    L5:
        r13.a(r17);
        return;
    L7:
        t.f11981a.a("kv dump: start (whitelist), repoCount=" + r16.size() + ", repos=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$a$d7oq0Z2xApVkyeqClHe8acNdKK0.INSTANCE, 30, null));
        File r18 = a(r15);
        r18.mkdirs();
        Iterator r19 = r16.iterator();
        int r2 = 0;
        int r3 = 0;
    L9:
        if (r19.hasNext() == false) goto L31;
        j r4 = (j) ZeusTransformUtils.preCheckCast(r19.next(), j.class, "com.obric.memorydata.plugin");
        String r5 = r4.a();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L12;
        if (StringsKt.startsWith$default(r5, "_", false, 2, null) == true) goto L16;
        if (r4.b().isEmpty() == true) goto L20;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L23
        ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).a(r18, r5, r4.b());     // Catch: Throwable -> L23
        Object r7 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L26:
        if (Result.m1428isSuccessimpl(r7) == false) goto L28;
        Unit r8 = (Unit) ZeusTransformUtils.preCheckCast(r7, Unit.class, "com.obric.memorydata.plugin");
        r2 = r2 + 1;
    L28:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r7);
        if (r9 == null) goto L9;
        r3 = r3 + 1;
        t.f11981a.a("kv dump: repo=" + r5 + " failed", r9);
    L23:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L26
    L20:
        t r11 = t.f11981a;
        StringBuilder r12 = new StringBuilder().append("kv dump: skip repo=").append(r5);
        String r20 = ", key whitelist is empty";
    L17:
        String r21 = r12.append(r20).toString();
    L13:
        r11.a(r21);
        goto L9
    L16:
        r11 = t.f11981a;
        r12 = new StringBuilder().append("kv dump: skip repo=").append(r5);
        r20 = ", name reserved for SDK-internal (leading '_')";
        goto L17
    L12:
        r11 = t.f11981a;
        r21 = "kv dump: skip anonymous repo (blank repoName)";
        goto L13
    L31:
        r13 = t.f11981a;
        r17 = "kv dump: end (whitelist), repoOk=" + r2 + ", repoFailed=" + r3;
        goto L5
    }

    private final boolean a(IStore r5, i r6, JSONObject r7) {
        IStore r8 = (IStore) ZeusTransformUtils.wrapperContextForParams(r5, IStore.class, "com.obric.memorydata.plugin");
        String r0 = a(r6.getType());
        String r2 = r7.optString("type", "");
        Intrinsics.checkNotNull(r2);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L12;
        if (Intrinsics.areEqual(r2, r0) == true) goto L12;
        t.f11981a.a("kv restore: type mismatch, key=" + r6.a() + " declared=" + r0 + " onDisk=" + r2 + ", skip");
        return false;
    L12:
        return a(r8, r6.a(), r0, r7);
    L5:
        r1 = false;
        goto L6
    }

    private final boolean a(IStore r7, String r8, String r9, JSONObject r10) {
        IStore r11 = (IStore) ZeusTransformUtils.wrapperContextForParams(r7, IStore.class, "com.obric.memorydata.plugin");
        switch(r9.hashCode()) {
            case -1325958191: goto L30;
            case -891985903: goto L26;
            case -189292911: goto L22;
            case 104431: goto L18;
            case 3327612: goto L14;
            case 64711720: goto L10;
            case 97526364: goto L6;
            default: goto L36;
        };
    L36:
        return false;
    L6:
        if (r9.equals(TypedValues.Custom.S_FLOAT) == false) goto L37;
        r11.save(r8, (float) r10.optDouble(EventBody.KEY_VALUE, 0.0d));
    L33:
        Unit r6 = Unit.INSTANCE;
    L35:
        return true;
    L37:
        return false;
    L10:
        if (r9.equals(TypedValues.Custom.S_BOOLEAN) == false) goto L38;
        r11.save(r8, r10.optBoolean(EventBody.KEY_VALUE, false));
        goto L33
    L38:
        return false;
    L14:
        if (r9.equals("long") == false) goto L39;
        r11.save(r8, r10.optLong(EventBody.KEY_VALUE, 0));
        goto L33
    L39:
        return false;
    L18:
        if (r9.equals("int") == false) goto L40;
        r11.save(r8, r10.optInt(EventBody.KEY_VALUE, 0));
        goto L33
    L40:
        return false;
    L22:
        if (r9.equals("stringSet") == false) goto L41;
        r11.saveStringSet(r8, a(r10.optJSONArray(EventBody.KEY_VALUE)));
        goto L35
    L41:
        return false;
    L26:
        if (r9.equals(TypedValues.Custom.S_STRING) == false) goto L42;
        String r12 = r10.optString(EventBody.KEY_VALUE, "");
        Intrinsics.checkNotNullExpressionValue(r12, "optString(...)");
        r11.save(r8, r12);
        goto L33
    L42:
        return false;
    L30:
        if (r9.equals("double") == false) goto L43;
        r11.save(r8, r10.optDouble(EventBody.KEY_VALUE, 0.0d));
        goto L33
    L43:
        return false;
    }

    private final boolean a(IStore r4, String r5, JSONObject r6) {
        IStore r7 = (IStore) ZeusTransformUtils.wrapperContextForParams(r4, IStore.class, "com.obric.memorydata.plugin");
        String r0 = r6.optString("type", "");
        Intrinsics.checkNotNull(r0);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return false;
    L9:
        return a(r7, r5, r0, r6);
    L5:
        r1 = false;
        goto L6
    }

    private final File b(File r2) {
        return new File(a(r2), "_personal.json");
    }

    private static final CharSequence b(j r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a() + "(keys=" + r2.b().size() + ')', CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final String b(String r4) {
        if (r4.length() > 6) goto L6;
        return "***";
    L6:
        return StringsKt.take(r4, 3) + "***" + StringsKt.takeLast(r4, 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b(List<j> r14, File r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        if (r16.isEmpty() == false) goto L7;
        t r13 = t.f11981a;
        String r17 = "kv restore: no kv repo configured, skip whitelist";
    L5:
        r13.a(r17);
        return;
    L7:
        File r18 = a(r15);
        if (r18.isDirectory() == true) goto L10;
        r13 = t.f11981a;
        r17 = "kv restore: no kv/ dir, skip whitelist";
        goto L5
    L10:
        t.f11981a.a("kv restore: start (whitelist), repoCount=" + r16.size() + ", repos=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$a$hlDyJWLULj7P5QFrurodJKuvyjQ.INSTANCE, 30, null));
        Iterator r19 = r16.iterator();
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L12:
        if (r19.hasNext() == false) goto L40;
        j r5 = (j) ZeusTransformUtils.preCheckCast(r19.next(), j.class, "com.obric.memorydata.plugin");
        String r6 = r5.a();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L39;
        if (r5.b().isEmpty() == true) goto L39;
        if (StringsKt.startsWith$default(r6, "_", false, 2, null) == true) goto L20;
        File r7 = new File(r18, r6 + ".json");
        if (r7.isFile() == false) goto L23;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L31
        a r9 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r5.b(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r10, 10)), 16)), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        Iterator r12 = r10.iterator();     // Catch: Throwable -> L31
    L27:
        if (r12.hasNext() == false) goto L29;
        Object r110 = r12.next();     // Catch: Throwable -> L31
        r11.put(((i) ZeusTransformUtils.preCheckCast(r110, i.class, "com.obric.memorydata.plugin")).a(), r110);     // Catch: Throwable -> L31
        goto L27
    L29:
        r9.a(r7, r6, r11);     // Catch: Throwable -> L31
        Object r20 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L34:
        if (Result.m1428isSuccessimpl(r20) == false) goto L36;
        Unit r21 = (Unit) ZeusTransformUtils.preCheckCast(r20, Unit.class, "com.obric.memorydata.plugin");
        r2 = r2 + 1;
    L36:
        Throwable r22 = Result.m1424exceptionOrNullimpl(r20);
        if (r22 == null) goto L12;
        r3 = r3 + 1;
        t.f11981a.a("kv restore: repo=" + r6 + " failed", r22);
    L31:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r20 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L34
    L23:
        r4 = r4 + 1;
        t r24 = t.f11981a;
        StringBuilder r25 = new StringBuilder().append("kv restore: dump file not found for repo=").append(r6);
        String r26 = ", skip";
    L24:
        r24.a(r25.append(r26).toString());
        goto L12
    L20:
        r24 = t.f11981a;
        r25 = new StringBuilder().append("kv restore: skip repo=").append(r6);
        r26 = ", name reserved for SDK-internal (leading '_')";
    L39:
        r24 = t.f11981a;
        r25 = new StringBuilder().append("kv restore: skip repo=").append(r6);
        r26 = " (blank name or empty keys)";
        goto L24
    L40:
        r13 = t.f11981a;
        r17 = "kv restore: end (whitelist), repoOk=" + r2 + ", repoFailed=" + r3 + ", repoNoDump=" + r4;
        goto L5
    }

    private final void c(File r14) {
        String r1 = a();
        if (r1 != null) goto L6;
        t.f11981a.a("kv dump personal: skip (anonymous profile)");
        return;
    L6:
        String r2 = "memorydata_personal_kv_" + r1;
        String r3 = b(r1);
        String r4 = "memorydata_personal_kv_" + r3;
        IStore r5 = a(r2);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L9
        a r7 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        Object r8 = Result.m1421constructorimpl(r5.dumpAll());     // Catch: Throwable -> L9
    L11:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 != null) goto L22;
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin");
        t.f11981a.a("kv dump personal: start, maskedRepo=" + r4 + ", senderProfile=" + r3 + ", entries=" + r10.size());
        JSONArray r11 = new JSONArray();
        Iterator r12 = r10.entrySet().iterator();
        int r13 = 0;
        int r15 = 0;
    L15:
        if (r12.hasNext() == false) goto L20;
        Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.getKey(), String.class, "com.obric.memorydata.plugin");
        Object r18 = r16.getValue();
        JSONObject r19 = a(r17, r18);
        if (r19 == null) goto L18;
        r11.put(r19);
        r13 = r13 + 1;
        t.f11981a.a("kv dump personal: write key=" + r17 + " type=" + r19.optString("type", ""));
        goto L15
    L18:
        r15 = r15 + 1;
        t.f11981a.a("kv dump personal: skip  key=" + r17 + " type=" + r18.getClass().getSimpleName() + " (unsupported)");
        goto L15
    L20:
        File r110 = a(r14);
        r110.mkdirs();
        File r111 = new File(r110, "_personal.json");
        String r112 = new JSONObject().put("logicName", "memorydata_personal_kv").put("senderProfile", r3).put("entries", r11).toString();
        Intrinsics.checkNotNullExpressionValue(r112, "toString(...)");
        FilesKt.writeText(r111, r112, Charsets.UTF_8);
        t.f11981a.a("kv dump personal: end, maskedRepo=" + r4 + ", written=" + r13 + ", skippedUnknownType=" + r15 + ", file=" + r111.getAbsolutePath() + ", size=" + r111.length() + 'B');
        return;
    L22:
        t.f11981a.a("kv dump personal: dumpAll failed, maskedRepo=" + r4, r9);
        return;
    L9:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final void d(File r18) {
        File r4 = b(r18);
        if (r4.isFile() == true) goto L6;
        t.f11981a.a("kv restore personal: no _personal.json, skip");
        return;
    L6:
        String r0 = a();
        if (r0 != null) goto L10;
        t.f11981a.a("kv restore personal: skip (anonymous profile)");
        return;
    L10:
        String r5 = "memorydata_personal_kv_" + r0;
        String r7 = b(r0);
        String r6 = "memorydata_personal_kv_" + r7;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Object r3 = Result.m1421constructorimpl(FilesKt.readText(r4, Charsets.UTF_8));     // Catch: Throwable -> L13
    L15:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r3);
        if (r8 != null) goto L46;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L20
        a r11 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Object r12 = Result.m1421constructorimpl(new JSONObject(r9));     // Catch: Throwable -> L20
    L22:
        Throwable r13 = Result.m1424exceptionOrNullimpl(r12);
        if (r13 != null) goto L44;
        JSONObject r14 = (JSONObject) ZeusTransformUtils.preCheckCast(r12, JSONObject.class, "com.obric.memorydata.plugin");
        JSONArray r15 = r14.optJSONArray("entries");
        if (r15 != null) goto L27;
        r15 = new JSONArray();
    L27:
        t.f11981a.a("kv restore personal: start, maskedRepo=" + r6 + ", receiverProfile=" + r7 + ", senderProfile=" + r14.optString("senderProfile", "") + ", entries=" + r15.length());
        IStore r16 = a(r5);
        int r17 = r15.length();
        int r19 = 0;
        int r20 = 0;
        int r110 = 0;
    L28:
        if (r19 >= r17) goto L42;
        JSONObject r111 = r15.optJSONObject(r19);
        if (r111 == null) goto L41;
        String r112 = r111.optString("key", "");
        Intrinsics.checkNotNull(r112);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r112, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L35;
        boolean r113 = true;
    L36:
        if (r113 == true) goto L41;
        if (a(r16, r112, r111) == false) goto L40;
        r20 = r20 + 1;
        t.f11981a.a("kv restore personal: write key=" + r112 + " type=" + r111.optString("type", ""));
        goto L41
    L40:
        r110 = r110 + 1;
        t.f11981a.a("kv restore personal: skip  key=" + r112 + " type=" + r111.optString("type", "") + " (unsupported)");
        goto L41
    L35:
        r113 = false;
    L41:
        r19 = r19 + 1;
        r16 = r16;
        goto L28
    L42:
        t.f11981a.a("kv restore personal: end, maskedRepo=" + r6 + ", written=" + r20 + ", skippedUnknownType=" + r110);
        return;
    L44:
        t.f11981a.a("kv restore personal: parse failed, file=" + r4.getAbsolutePath(), r13);
        return;
    L20:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    L46:
        t.f11981a.a("kv restore personal: read failed, file=" + r4.getAbsolutePath(), r8);
        return;
    L13:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static /* synthetic */ CharSequence lambda$d7oq0Z2xApVkyeqClHe8acNdKK0(j r0) {
        return a(r0);
    }

    public static /* synthetic */ CharSequence lambda$hlDyJWLULj7P5QFrurodJKuvyjQ(j r0) {
        return b(r0);
    }

    public final File a(File r2) {
        Intrinsics.checkNotNullParameter(r2, "rootDir");
        return new File(r2, "kv");
    }

    public final void a(Context r3, List<j> r4, File r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        List<j> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "kvRepos");
        Intrinsics.checkNotNullParameter(r5, "rootDir");
        a(r7, r5);
        c(r5);
    }

    public final void b(Context r3, List<j> r4, File r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        List<j> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "kvRepos");
        Intrinsics.checkNotNullParameter(r5, "restoreDir");
        b(r7, r5);
        d(r5);
    }
}
