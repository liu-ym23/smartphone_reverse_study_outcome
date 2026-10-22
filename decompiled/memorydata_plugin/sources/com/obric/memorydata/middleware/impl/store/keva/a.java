package com.obric.memorydata.middleware.impl.store.keva;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.keva.Keva;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.utils.j;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\u0010\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0000\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001EB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0019H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u001aH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u001bH\u0016J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\u001a\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001aH\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0006H\u0016J\u0018\u0010#\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0018H\u0016J\u0018\u0010$\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0018\u0010%\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0019H\u0016J9\u0010&\u001a\u0004\u0018\u0001H'\"\b\b\u0000\u0010'*\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\b\u0010 \u001a\u0004\u0018\u0001H'H\u0016¢\u0006\u0002\u0010*J!\u0010+\u001a\u00020\u001a2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040-\"\u00020\u0004H\u0016¢\u0006\u0002\u0010.J\u001e\u0010/\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH\u0016J$\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u0016\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH\u0016J\b\u00101\u001a\u00020\u0015H\u0016J\u0018\u00102\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u0002042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0006H\u0016J\u0013\u00107\u001a\b\u0012\u0004\u0012\u00020\u00040-H\u0016¢\u0006\u0002\u00108J\u0014\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020;0:H\u0016J\u0018\u0010<\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u0018\u0010<\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0018\u0010<\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u001bH\u0016J\u000e\u0010+\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004J\u0010\u0010=\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u000bH\u0016J\u0010\u0010@\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u000bH\u0016J\u0018\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\u0018\u0010C\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001e\u0010D\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR6\u0010\u0010\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00120\u0011j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0012`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/obric/memorydata/middleware/impl/store/keva/BaseStore;", "Lcom/obric/memorydata/middleware/api/store/IStore;", "Lcom/bytedance/keva/Keva$OnChangeListener;", ActivityLifecycle.NAME, "", "storeMode", "", "<init>", "(Ljava/lang/String;I)V", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/obric/memorydata/middleware/api/store/StoreChangeListener;", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "Lcom/bytedance/keva/Keva;", "mCreators", "Ljava/util/HashMap;", "Landroid/os/Parcelable$Creator;", "Lkotlin/collections/HashMap;", "save", "", "key", EventBody.KEY_VALUE, "", "", "", "", "values", "", "Landroid/os/Parcelable;", "getString", "defaultValue", "getBoolean", "getInt", "getFloat", "getLong", "getDouble", "getParcelable", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;)Landroid/os/Parcelable;", "remove", "keys", "", "([Ljava/lang/String;)Z", "saveStringSet", "getStringSet", "clearAll", "saveBooleanArray", "array", "", "getBooleanArray", "arrayLength", "allKeys", "()[Ljava/lang/String;", "dumpAll", "", "", "syncSave", "contains", "registerChangeListener", "listener", "unregisterChangeListener", "onChanged", "repo", "checkLargeString", "checkLargeStringSet", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements Keva.OnChangeListener, IStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0641a f11870a = null;
    private static int e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArraySet<com.obric.memorydata.middleware.api.store.b> f11871b;
    private final Keva c;
    private final HashMap<String, Parcelable.Creator<?>> d;

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.store.keva.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/impl/store/keva/BaseStore$Companion;", "", "<init>", "()V", "MAX_STRING_SIZE_BYTES", "", "getMAX_STRING_SIZE_BYTES", "()I", "setMAX_STRING_SIZE_BYTES", "(I)V", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0641a {
        private C0641a() {
        }

        public /* synthetic */ C0641a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11870a = new C0641a(null);
        e = 204800;
    }

    public a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        this.f11871b = new CopyOnWriteArraySet();
        Keva r4 = Keva.getRepo(r2, r3);
        this.c = r4;
        r4.registerChangeListener((Keva.OnChangeListener) ZeusTransformUtils.preCheckCast(this, Keva.OnChangeListener.class, "com.obric.memorydata.plugin"));
        this.d = new HashMap();
    }

    private static final Unit a(com.obric.memorydata.middleware.api.store.b r2, Keva r3, String r4) {
        com.obric.memorydata.middleware.api.store.b r5 = (com.obric.memorydata.middleware.api.store.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.middleware.api.store.b.class, "com.obric.memorydata.plugin");
        String r6 = r3.name();
        Intrinsics.checkNotNullExpressionValue(r6, "name(...)");
        r5.onKeyChanged(r6, r4);
        return Unit.INSTANCE;
    }

    private static final Unit a(a r4, final Keva r5, final String r6) {
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.f11871b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        final com.obric.memorydata.middleware.api.store.b r0 = (com.obric.memorydata.middleware.api.store.b) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.memorydata.middleware.api.store.b.class, "com.obric.memorydata.plugin");
        y.a(null, new $$Lambda$a$OLt4VzkCD00XkEB5_K1Y3RKDtSc(r0, r5, r6), 1, null);
        goto L4
    L7:
        return Unit.INSTANCE;
    }

    private final void a(String r9, String r10) {
        if (AppContext.INSTANCE.isDebug() == true) goto L5;
        return;
    L5:
        int r8 = e;
        if (r10.length() >= (r8 / 2)) goto L8;
        return;
    L8:
        byte[] r0 = r10.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r0, "getBytes(...)");
        int r1 = r0.length;
        if (r1 <= r8) goto L12;
        String r11 = "OOMChecker:BaseStore save string too large: key=" + r9 + " size=" + (r1 / 1024) + "KB > " + (r8 / 1024) + "KB";
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BaseStore", r11, null, 4, null);
        Ensure.ensureNotReachHere(new Throwable(r11 + "\ncontent: " + StringsKt.take(r10, 1024)), r11);
        return;
    }

    private final void a(String r13, Set<String> r14) {
        Set r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.memorydata.plugin");
        int r15 = e;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L7;
        r3 = r3 + ((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")).length();
        goto L4
    L7:
        if (r3 >= (r15 / 2)) goto L9;
        return;
    L9:
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        byte[] r5 = ((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin")).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r5, "getBytes(...)");
        r2 = r2 + r5.length;
        goto L11
    L13:
        if (r2 <= r15) goto L18;
        String r16 = "OOMChecker: BaseStore save string set too large: key=" + r13 + " count=" + r12.size() + " size=" + (r2 / 1024) + "KB > " + (r15 / 1024) + "KB";
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BaseStore", r16, null, 4, null);
        Ensure.ensureNotReachHere(new Throwable(r16 + "\ncontent=" + StringsKt.take(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null), 1024)), r16);
        return;
    }

    public static /* synthetic */ Unit lambda$OLt4VzkCD00XkEB5_K1Y3RKDtSc(com.obric.memorydata.middleware.api.store.b r0, Keva r1, String r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$_xJDOH820wK-wMx0Tsh5DkqXmlE, reason: not valid java name */
    public static /* synthetic */ Unit m1037lambda$_xJDOH820wKwMx0Tsh5DkqXmlE(a r0, Keva r1, String r2) {
        return a(r0, r1, r2);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public String[] allKeys() {
        return (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(this.c.getAll().keySet(), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public void clearAll() {
        this.c.clear();
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public boolean contains(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.c.contains(r2);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public Map<String, Object> dumpAll() {
        Map<String, ?> r1 = this.c.getAll();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        return r1;
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public boolean getBoolean(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.c.getBoolean(r2, false);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public boolean getBoolean(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.c.getBoolean(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public boolean[] getBooleanArray(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        boolean[] r5 = new boolean[r4];
        JSONArray r0 = new JSONArray(this.c.getString(r3, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));     // Catch: Exception -> L7
        int r2 = 0;
        int r6 = r0.length();     // Catch: Exception -> L7
    L4:
        if (r2 >= r6) goto L9;
        r5[r2] = r0.getBoolean(r2);     // Catch: Exception -> L7
        r2 = r2 + 1;
    L9:
        return r5;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public double getDouble(String r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.c.getDouble(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public float getFloat(String r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.c.getFloat(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public int getInt(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.c.getInt(r2, 0);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public int getInt(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.c.getInt(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public long getLong(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.c.getLong(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public <T extends Parcelable> T getParcelable(String r6, Class<T> r7, T r8) {
        T r9 = (T) ZeusTransformUtils.wrapperContextForParams(r8, Parcelable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r7, "clazz");
        byte[] r10 = this.c.getBytes(r6, new byte[0]);
        if (r10 != null) goto L6;
        r10 = new byte[0];
    L6:
        if (r10.length != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return r9;
    L11:
        Parcel r1 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(r1, "obtain(...)");
        r1.unmarshall(r10, 0, r10.length);
        r1.setDataPosition(0);
        String r11 = r7.toString();     // Catch: Throwable -> L32
        Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");     // Catch: Throwable -> L32
        HashMap<String, Parcelable.Creator<?>> r2 = this.d;     // Catch: Throwable -> L32
        monitor-enter(r2);     // Catch: Throwable -> L32
        Parcelable.Creator<?> r3 = this.d.get(r11);     // Catch: Throwable -> L29
        Parcelable r4 = null;
        if (r3 != null) goto L17;
        Field r12 = r7.getField("CREATOR");     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r12, "getField(...)");     // Catch: Throwable -> L29
        Object r13 = r12.get(null);     // Catch: Throwable -> L29
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.os.Parcelable.Creator<*>");     // Catch: Throwable -> L29
        r3 = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(r13, Parcelable.Creator.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        ((Map) ZeusTransformUtils.preCheckCast(this.d, Map.class, "com.obric.memorydata.plugin")).put(r11, r3);     // Catch: Throwable -> L29
    L17:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L29
        monitor-exit(r2);     // Catch: Throwable -> L32
        Parcelable.Creator r14 = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(r3, Parcelable.Creator.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        if (r14 == null) goto L22;
        Object r15 = r14.createFromParcel(r1);     // Catch: Throwable -> L32
    L24:
        if (ZeusTransformUtils.instanceOf(r15, Parcelable.class) == false) goto L26;
        r4 = (Parcelable) ZeusTransformUtils.preCheckCast(r15, Parcelable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
    L26:
        if (r4 == null) goto L34;
        r9 = (T) r4;
    L34:
        r1.recycle();
        return r9;
    L22:
        r15 = null;
        goto L24
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r1.recycle();
        throw th;
    L8:
        r0 = false;
        goto L9
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public String getString(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        String r0 = this.c.getString(r3, "");
        Intrinsics.checkNotNull(r0);
        a(r3, r0);
        return r0;
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public String getString(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        String r4 = this.c.getString(r2, r3);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        a(r2, r4);
        return r4;
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public Set<String> getStringSet(String r3, Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r5, "defaultValue");
        Set<String> r6 = this.c.getStringSet(r3, r5);
        Intrinsics.checkNotNull(r6);
        a(r3, r6);
        return r6;
    }

    @Override // com.bytedance.keva.Keva.OnChangeListener
    public void onChanged(final Keva r2, final String r3) {
        Intrinsics.checkNotNullParameter(r2, "repo");
        Intrinsics.checkNotNullParameter(r3, "key");
        j.b(new $$Lambda$a$_xJDOH820wKwMx0Tsh5DkqXmlE(this, r2, r3));
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public void registerChangeListener(com.obric.memorydata.middleware.api.store.b r3) {
        com.obric.memorydata.middleware.api.store.b r4 = (com.obric.memorydata.middleware.api.store.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.middleware.api.store.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.f11871b.add(r4);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public boolean remove(String... r5) {
        Intrinsics.checkNotNullParameter(r5, "keys");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        String r2 = r5[r1];
        this.c.erase(r2);
        r1 = r1 + 1;
        goto L3
    L5:
        return true;
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public void save(String r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.c.storeDouble(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public void save(String r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.c.storeFloat(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public void save(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.c.storeInt(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public void save(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.c.storeLong(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public void save(String r3, Parcelable r4) {
        Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r4, Parcelable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
        Parcel r0 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(r0, "obtain(...)");
        r5.writeToParcel(r0, r5.describeContents());
        byte[] r6 = r0.marshall();
        r0.recycle();
        this.c.storeBytes(r3, r6);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public void save(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
        a(r2, r3);
        this.c.storeString(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public void save(String r3, Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r5, "values");
        a(r3, r5);
        this.c.storeStringSet(r3, r5);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public void save(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.c.storeBoolean(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public void saveBooleanArray(String r5, boolean[] r6) {
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "array");
        JSONArray r0 = new JSONArray();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.put(r6[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        this.c.storeString(r5, r0.toString());
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public void saveStringSet(String r3, Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
        a(r3, r5);
        this.c.storeStringSet(r3, r5);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public boolean syncSave(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.c.storeInt(r2, r3);
        return true;
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public boolean syncSave(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.c.storeLong(r2, r3);
        return true;
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public boolean syncSave(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
        a(r2, r3);
        this.c.storeString(r2, r3);
        return true;
    }

    @Override // com.obric.memorydata.middleware.api.store.IStore
    public void unregisterChangeListener(com.obric.memorydata.middleware.api.store.b r3) {
        com.obric.memorydata.middleware.api.store.b r4 = (com.obric.memorydata.middleware.api.store.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.middleware.api.store.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.f11871b.remove(r4);
    }
}
