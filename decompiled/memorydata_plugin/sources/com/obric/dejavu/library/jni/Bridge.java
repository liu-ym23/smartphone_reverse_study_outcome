package com.obric.dejavu.library.jni;

import android.os.Debug;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.dejavu.library.DbKvResult;
import com.obric.dejavu.library.DbLogWriter;
import com.obric.dejavu.library.DbObjResult;
import com.obric.dejavu.library.DbStatus;
import com.obric.dejavu.library.b;
import com.obric.dejavu.library.d;
import com.obric.dejavu.library.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 J\u0019\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0087 J\u0011\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0087 J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0012J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0013J\u001d\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 J5\u0010\u0019\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001b0\u001aj\u0002`\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\tH\u0087 J\b\u0010\u001f\u001a\u00020 H\u0007J\u0019\u0010!\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0087 J\t\u0010\"\u001a\u00020#H\u0087 J3\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010'\u001a\u00020\rH\u0087 J\u0011\u0010(\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 J\u0019\u0010)\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0087 J\u0010\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\tJ\u0011\u0010.\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 J\u0019\u0010/\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0087 J\u0019\u00100\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0087 J\u0019\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\tH\u0087 J-\u00104\u001a\u00020#2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t06H\u0087 J)\u00107\u001a\u0002082\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020\rH\u0087 JV\u0010;\u001a$\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160<0\u001b0\u001b0\u001aj\u0002`=2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010>\u001a\b\u0012\u0004\u0012\u00020&0\u001b2\u0006\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020\tH\u0087 ¢\u0006\u0002\u0010AJ\u0011\u0010B\u001a\u00020#2\u0006\u0010C\u001a\u00020 H\u0087 J\u0013\u0010D\u001a\u00020#2\b\u0010E\u001a\u0004\u0018\u00010FH\u0087 J\u0011\u0010G\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 J!\u0010H\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\rH\u0087 J\u0011\u0010K\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 ¨\u0006L"}, d2 = {"Lcom/obric/dejavu/library/jni/Bridge;", "", "()V", "clear", "Lcom/obric/dejavu/library/DbStatus;", "handle", "", "createDb", "dirPrefix", "", "dbOption", "dims", "exists", "", "key", "formatOptStr", "opt", "Lcom/obric/dejavu/library/DbIndexConfig;", "Lcom/obric/dejavu/library/DbOptions;", "Lcom/obric/dejavu/library/DbSearchOption;", "formatOptionalFloat", EventBody.KEY_VALUE, "", "(Ljava/lang/String;Ljava/lang/Float;)Ljava/lang/String;", "getDbInfo", "getKeys", "Lcom/obric/dejavu/library/DbObjResult;", "", "Lcom/obric/dejavu/library/DbKeysResult;", CommonConsts.APM_INNER_EVENT_COST_START, "end", "getNativePss", "", "getProperty", "initNative", "", "insert", "vec", "", "normalize", ActivityLifecycle.NAME, "openDb", "dbName", "parseDbInfo", "Lcom/obric/dejavu/library/DbInfo;", "info", "releaseDb", "remove", "removeDb", "runTest", "cwd", "filter", "runTestEnv", "envMap", "", "searchKv", "Lcom/obric/dejavu/library/DbKvResult;", "getValue", "getVec", "searchVec", "Lkotlin/Pair;", "Lcom/obric/dejavu/library/DbVecResult;", "vecs", "k", WsConstants.KEY_EXTRA, "(J[[FILjava/lang/String;)Lcom/obric/dejavu/library/DbObjResult;", "setLogLevel", "level", "setLogWriter", "writer", "Lcom/obric/dejavu/library/DbLogWriter;", "size", "updateIndexConfig", "cfg", "rebuildNow", "validate", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Bridge {
    public static final Bridge INSTANCE = null;

    static {
        INSTANCE = new Bridge();
        System.loadLibrary("dejavu_lib");
        initNative();
    }

    private Bridge() {
    }

    @JvmStatic
    public static final native DbStatus clear(long r0);

    @JvmStatic
    public static final native long createDb(String r0, String r1);

    @JvmStatic
    public static final native long dims(long r0);

    @JvmStatic
    public static final native boolean exists(long r0, String r2);

    @JvmStatic
    public static final native String getDbInfo(long r0);

    @JvmStatic
    public static final native DbObjResult<String[]> getKeys(long r0, String r2, String r3);

    public static /* synthetic */ DbObjResult getKeys$default(long r1, String r3, String r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = "";
    L9:
        return getKeys(r1, r3, r4);
    }

    @JvmStatic
    public static final int getNativePss() {
        Debug.MemoryInfo r0 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r0);
        return r0.nativePss * 1024;
    }

    @JvmStatic
    public static final native String getProperty(long r0, String r2);

    @JvmStatic
    public static final native void initNative();

    @JvmStatic
    public static final native DbStatus insert(long r0, String r2, float[] r3, String r4, boolean r5);

    @JvmStatic
    public static final native String name(long r0);

    @JvmStatic
    public static final native long openDb(String r0, String r1);

    @JvmStatic
    public static final native void releaseDb(long r0);

    @JvmStatic
    public static final native DbStatus remove(long r0, String r2);

    @JvmStatic
    public static final native DbStatus removeDb(String r0, String r1);

    @JvmStatic
    public static final native void runTest(String r0, String r1);

    @JvmStatic
    public static final native void runTestEnv(String r0, String r1, Map<String, String> r2);

    @JvmStatic
    public static final native DbKvResult searchKv(long r0, String r2, boolean r3, boolean r4);

    @JvmStatic
    public static final native DbObjResult<Pair<String, Float>[][]> searchVec(long r0, float[][] r2, int r3, String r4);

    @JvmStatic
    public static final native void setLogLevel(int r0);

    @JvmStatic
    public static final native void setLogWriter(DbLogWriter r0);

    @JvmStatic
    public static final native long size(long r0);

    @JvmStatic
    public static final native DbStatus updateIndexConfig(long r0, String r2, boolean r3);

    @JvmStatic
    public static final native DbStatus validate(long r0);

    public final String formatOptStr(com.obric.dejavu.library.a r2) {
        Intrinsics.checkNotNullParameter(r2, "opt");
        return "{\n            \"strategy\" : " + r2.a().getData() + ",\n            \"metricType\" : " + r2.b().getData() + ",\n            \"searchProbe\" : " + r2.c() + ",\n            \"downgradeLimit\" : " + r2.d() + ",\n            \"upgradeLimit\" : " + r2.e() + ",\n            \"ivfNodeMin\" : " + r2.f() + ",\n            \"ivfNodeMax\" : " + r2.g() + ",\n            \"bspNodeSize\" : " + r2.h() + ",\n            \"pqSubDim\": " + r2.i() + ",\n            \"pqTrainInsert\": " + r2.j() + "\n        }";
    }

    public final String formatOptStr(d r3) {
        Intrinsics.checkNotNullParameter(r3, "opt");
        return "{\n            \"dbname\":\"" + r3.a() + "\",\n            \"dims\": " + r3.b() + ",\n            \"createIfMissing\": " + r3.c() + ",\n            \"errorIfExists\": " + r3.d() + ",\n            \"compressLevel\": " + r3.e() + ",\n            \"kvEngine\": " + r3.f().getData() + ",\n            \"indexCfg\": " + formatOptStr(r3.g()) + " \n        }";
    }

    public final String formatOptStr(e r13) {
        Intrinsics.checkNotNullParameter(r13, "opt");
        StringBuilder r12 = new StringBuilder().append("{\n            \"searchProbe\" : ").append(r13.b()).append(",\n            ").append(formatOptionalFloat("searchProbeFilter", Float.valueOf(r13.c()))).append("\n            ").append(formatOptionalFloat("distFilter", Float.valueOf(r13.d()))).append("\n            \"normalize\" : ").append(r13.a()).append(",\n            \"filters\" : [");
        String[] r14 = r13.e();
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r14.length), Collection.class, "com.obric.memorydata.plugin");
        int r1 = r14.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        r0.add(Typography.quote + r14[r3] + Typography.quote);
        r3 = r3 + 1;
        goto L3
    L6:
        return r12.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null)).append("]\n        }").toString();
    }

    public final String formatOptionalFloat(String r2, Float r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r3 != null) goto L5;
        return "";
    L5:
        if (Float.isNaN(r3.floatValue()) == false) goto L8;
        return "";
    L8:
        return Typography.quote + r2 + "\" : " + r3 + ',';
    }

    public final b parseDbInfo(String r7) {
        Intrinsics.checkNotNullParameter(r7, "info");
        JSONObject r6 = new JSONObject(r7);     // Catch: Exception -> L5
        return new b(r6.getInt("dims"), r6.getInt("kvType"), r6.getInt("viewType"), r6.getInt("bankType"), r6.getInt("metricType"));
    L5:
        return null;
    }
}
