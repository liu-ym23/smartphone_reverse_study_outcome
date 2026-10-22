package com.obric.memorydata.middleware.impl.playground;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 O2\u00020\u0001:\u0002NOB'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\fJ\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00112\u0006\u0010\u0019\u001a\u00020\fJ\u0014\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0018J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u00112\u0006\u0010\"\u001a\u00020\fJ \u0010#\u001a\b\u0012\u0004\u0012\u00020\f0$2\u0006\u0010%\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0002J \u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180\u00112\u0006\u0010'\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0002J\u001e\u0010(\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00182\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0$H\u0002J(\u0010*\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0$H\u0002J(\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0$H\u0002J\u001e\u0010.\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0$H\u0002J$\u0010.\u001a\u00020\u001f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00112\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0$H\u0002J*\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00180\u00112\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00112\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0$H\u0002J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00180\u00112\u0006\u00101\u001a\u00020\fH\u0002J$\u00102\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00112\f\u00103\u001a\b\u0012\u0004\u0012\u00020\f0$H\u0002J\u0010\u00104\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0018H\u0002J\u0010\u00105\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\fH\u0002J\b\u00107\u001a\u00020\u001cH\u0002J\"\u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020\f2\u0010\u0010:\u001a\f\u0012\u0004\u0012\u00020\f\u0012\u0002\b\u00030;H\u0002J\b\u0010<\u001a\u00020\fH\u0002J\u0010\u0010=\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\fH\u0002J\b\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020?H\u0002J\u0018\u0010B\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fH\u0002J\u0010\u0010C\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0018H\u0002J\u0010\u0010D\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0018H\u0002J\u0012\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011*\u00020-H\u0002J\u001a\u0010F\u001a\u00020\u001c*\u00020-2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011H\u0002J\u0012\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011*\u00020\u0018H\u0002J\u000e\u0010H\u001a\u0004\u0018\u00010I*\u00020\u0001H\u0002J\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011*\u00020-2\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0002J\u000e\u0010K\u001a\u0004\u0018\u00010\u0018*\u00020\fH\u0002J*\u0010L\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002HM0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002HM`\r\"\u0004\b\u0000\u0010MH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0010\u001a*\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00110\u000bj\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0011`\rX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/EntityStore;", "", "maxEntities", "", "maxVirtualEntities", "persistence", "Lcom/obric/memorydata/middleware/impl/playground/EntityStorePersistence;", "<init>", "(IILcom/obric/memorydata/middleware/impl/playground/EntityStorePersistence;)V", "lock", "entityMap", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "ecaEntityMap", "deletedEntityMap", "virtualEntityMap", "", "localEntityMap", "normalCapacity", "processAppIntentResult", "rawJson", "sourceIntent", "findEntity", "Lorg/json/JSONObject;", "ecaId", "findEntities", "markDeleted", "", "entities", "isDeleted", "", "entity", "extractEntityData", "rawResult", "collectBatchProtectedKeys", "", "root", "collectIntentSearchEntities", ChatMessage.TYPE_RESPONSE, "processEntityData", "protectedKeys", "processIntentSearchResponse", "processSearchEntityList", "entityList", "Lorg/json/JSONArray;", "processNormalEntityList", "addVirtualEntitiesLocked", "findVirtualEntitiesLocked", "virtualId", "addNormalEntitiesLocked", "batchProtectedKeys", "addNormalEntityLocked", "removeNormalEntityLocked", "key", "evictDeletedOverflowLocked", "nextAvailableIdLocked", "prefix", AILabCheckPermissionTask.KEY_SOURCE, "", "nextVirtualIdLocked", "releaseVirtualGroupLocked", "snapshotLocked", "Lcom/obric/memorydata/middleware/impl/playground/EntityStoreSnapshot;", "restoreSnapshotLocked", "snapshot", "setOnlyEcaId", "entityKey", "deletedEntityKey", "toEntityList", "replaceWith", "entityDataList", "toEntityDataValue", "Lcom/obric/memorydata/middleware/impl/playground/EntityStore$EntityDataValue;", "toSearchEntityListForResult", "toJsonObjectOrNull", "accessOrderMap", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "EntityDataValue", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f11812a = null;
    private static final Set<String> l = null;
    private static final Set<String> m = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11813b;
    private final int c;
    private final e d;
    private final Object e;
    private final LinkedHashMap<String, String> f;
    private final LinkedHashMap<String, String> g;
    private final LinkedHashMap<String, String> h;
    private final LinkedHashMap<String, List<String>> i;
    private final LinkedHashMap<String, String> j;
    private int k;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\"\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!¨\u0006$"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/EntityStore$Companion;", "", "<init>", "()V", "DEFAULT_MAX_ENTITIES", "", "DEFAULT_MAX_VIRTUAL_ENTITIES", "DEFAULT_INITIAL_CAPACITY", "LOAD_FACTOR", "", "ECA_PREFIX", "", "VIRTUAL_ENTITY_PREFIX", "LOCAL_ENTITY_PREFIX", "MAX_DEFAULT_ENTITY_RESULT", "MAX_FIFTY_ENTITY_RESULT", "ID", "TYPE", "MSG", "ENTITY_DATA", "DATA", "ENTITY_LIST", "SEARCH_RESPONSE", "GLOBAL_SEARCH_RESPONSE", "ENTITY_RESULT", "MEMORY_RESULT", "PROACTIVE_RECOMMENDATION_RESULT", "ECA_ID_COMPACT_FIELD", "ECA_ID_CAMEL_FIELD", "ECA_ID_SNAKE_FIELD", "VIRTUAL_ENTITY_INTENTS", "", "getVIRTUAL_ENTITY_INTENTS", "()Ljava/util/Set;", "FIFTY_ENTITY_INTENTS", "getFIFTY_ENTITY_INTENTS", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/EntityStore$EntityDataValue;", "", "<init>", "()V", "entities", "", "Lorg/json/JSONObject;", "getEntities", "()Ljava/util/List;", "ArrayValue", "ObjectValue", "Lcom/obric/memorydata/middleware/impl/playground/EntityStore$EntityDataValue$ArrayValue;", "Lcom/obric/memorydata/middleware/impl/playground/EntityStore$EntityDataValue$ObjectValue;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static abstract class b {

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/EntityStore$EntityDataValue$ArrayValue;", "Lcom/obric/memorydata/middleware/impl/playground/EntityStore$EntityDataValue;", "array", "Lorg/json/JSONArray;", "entities", "", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONArray;Ljava/util/List;)V", "getArray", "()Lorg/json/JSONArray;", "getEntities", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final JSONArray f11814a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final List<JSONObject> f11815b;

            public a(JSONArray r3, List<? extends JSONObject> r4) {
                List<JSONObject> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, "array");
                Intrinsics.checkNotNullParameter(r5, "entities");
                super(null);
                this.f11814a = r3;
                this.f11815b = r5;
            }

            @Override // com.obric.memorydata.middleware.impl.playground.d.b
            public List<JSONObject> a() {
                return this.f11815b;
            }

            public final JSONArray b() {
                return this.f11814a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f11814a, r6.f11814a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f11815b, r6.f11815b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.f11814a.hashCode() * 31) + this.f11815b.hashCode();
            }

            public String toString() {
                return "ArrayValue(array=" + this.f11814a + ", entities=" + this.f11815b + ')';
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.playground.d$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/EntityStore$EntityDataValue$ObjectValue;", "Lcom/obric/memorydata/middleware/impl/playground/EntityStore$EntityDataValue;", "entity", "Lorg/json/JSONObject;", "entities", "", "<init>", "(Lorg/json/JSONObject;Ljava/util/List;)V", "getEntity", "()Lorg/json/JSONObject;", "getEntities", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0640b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final JSONObject f11816a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final List<JSONObject> f11817b;

            public C0640b(JSONObject r3, List<? extends JSONObject> r4) {
                List<JSONObject> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, "entity");
                Intrinsics.checkNotNullParameter(r5, "entities");
                super(null);
                this.f11816a = r3;
                this.f11817b = r5;
            }

            @Override // com.obric.memorydata.middleware.impl.playground.d.b
            public List<JSONObject> a() {
                return this.f11817b;
            }

            public final JSONObject b() {
                return this.f11816a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0640b.class) == true) goto L8;
                return false;
            L8:
                C0640b r6 = (C0640b) ZeusTransformUtils.preCheckCast(r5, C0640b.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f11816a, r6.f11816a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f11817b, r6.f11817b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.f11816a.hashCode() * 31) + this.f11817b.hashCode();
            }

            public String toString() {
                return "ObjectValue(entity=" + this.f11816a + ", entities=" + this.f11817b + ')';
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }

        public abstract List<JSONObject> a();
    }

    static {
        f11812a = new a(null);
        l = SetsKt.setOf(new String[]{"Phone_Delete", "Messages_Delete"});
        m = SetsKt.setOf(new String[]{"Clock_TurnOnAlarm", "Clock_DeleteAlarm", "Clock_TurnOffAlarm", "Clock_StartCountdown", "Clock_PauseCountdown", "Clock_DeleteCountdown", "Memory_Produce", "Memory_Delete"});
    }

    public d() {
        this(0, 0, null, 7, null);
    }

    public d(int r3, int r4, e r5) {
        this.f11813b = r3;
        this.c = r4;
        this.d = r5;
        Object r0 = new Object();
        this.e = r0;
        this.f = d();
        this.g = d();
        this.h = d();
        this.i = d();
        this.j = d();
        this.k = r3;
        monitor-enter(r0);
        if (r5 != null) goto L24;
    L22:
        monitor-exit(r0);
        return;
    L24:
        f r6 = r5.a();     // Catch: Throwable -> L19
        if (r6 == null) goto L22;
        if (r6.c().size() <= r4) goto L10;
    L12:
        boolean r7 = false;
    L13:
        if (r7 == true) goto L16;
        r6 = null;
    L16:
        if (r6 == null) goto L22;
        a(r6);     // Catch: Throwable -> L19
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L19
        goto L22
    L10:
        if (r6.b().size() > r6.a()) goto L12;
        r7 = true;
    L19:
        th = move-exception;
        throw th;
    }

    public /* synthetic */ d(int r1, int r2, e r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 100;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 10;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = null;
    L11:
        this(r1, r2, r3);
    }

    private final b a(Object r5) {
        Object r1 = null;
        if (ZeusTransformUtils.instanceOf(r5, JSONArray.class) == false) goto L7;
        Object r4 = ZeusTransformUtils.preCheckCast(new b.a((JSONArray) ZeusTransformUtils.preCheckCast(r5, JSONArray.class, "com.obric.memorydata.plugin"), a((JSONArray) ZeusTransformUtils.preCheckCast(r5, JSONArray.class, "com.obric.memorydata.plugin"))), b.class, "com.obric.memorydata.plugin");
    L31:
        return (b) r4;
    L7:
        if (ZeusTransformUtils.instanceOf(r5, JSONObject.class) == false) goto L11;
        Object r6 = new b.C0640b((JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.memorydata.plugin"), CollectionsKt.listOf(r5));
    L9:
        r4 = ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin");
        goto L31
    L11:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L36;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        JSONArray r3 = new JSONArray((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        Object r7 = Result.m1421constructorimpl(new b.a(r3, a(r3)));     // Catch: Throwable -> L14
    L17:
        if (Result.m1427isFailureimpl(r7) == false) goto L19;
        r7 = null;
    L19:
        r6 = (b.a) ZeusTransformUtils.preCheckCast(r7, b.a.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L9;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L24
        JSONObject r9 = new JSONObject((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L24
        Object r10 = Result.m1421constructorimpl(new b.C0640b(r9, CollectionsKt.listOf(r9)));     // Catch: Throwable -> L24
    L27:
        if (Result.m1427isFailureimpl(r10) == true) goto L30;
        r1 = r10;
    L30:
        r4 = ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.memorydata.plugin");
    L24:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L14:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    L36:
        return null;
    }

    private final String a(String r5, Map<String, ?> r6) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        int r7 = 0;
    L3:
        String r0 = r5 + StringsKt.padStart(String.valueOf(r7), 2, '0');
        if (r4.containsKey(r0) == false) goto L5;
        r7 = r7 + 1;
        goto L3
    L5:
        return r0;
    }

    private final List<JSONObject> a(JSONArray r4) {
        List r3 = CollectionsKt.createListBuilder();
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        JSONObject r2 = r4.optJSONObject(r1);
        if (r2 == null) goto L7;
        r3.add(r2);
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return CollectionsKt.build(r3);
    }

    private final List<JSONObject> a(JSONArray r3, String r4) {
        List<JSONObject> r2 = a(r3);
        if (CollectionsKt.contains((Iterable) ZeusTransformUtils.preCheckCast(l, Iterable.class, "com.obric.memorydata.plugin"), r4) == false) goto L7;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        int r6 = 5;
    L9:
        return CollectionsKt.take(r5, r6);
    L7:
        if (CollectionsKt.contains((Iterable) ZeusTransformUtils.preCheckCast(m, Iterable.class, "com.obric.memorydata.plugin"), r4) == false) goto L10;
        r5 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        r6 = 50;
        goto L9
    L10:
        return r2;
    }

    private final Set<String> a(JSONObject r3, String r4) {
        LinkedHashSet r0 = new LinkedHashSet();
        a(this, r0, r4, r3);
        String r5 = r3.optString(NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullExpressionValue(r5, "optString(...)");
        JSONObject r6 = g(r5);
        if (r6 == null) goto L6;
        a(this, r0, r4, r6);
    L6:
        return (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin");
    }

    private final void a() {
    L3:
        if (this.h.size() <= this.k) goto L10;
        Set<Map.Entry<String, String>> r0 = this.h.entrySet();
        Intrinsics.checkNotNullExpressionValue(r0, "<get-entries>(...)");
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L14;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L15;
        this.h.remove(r2);
        goto L3
    L15:
        return;
    L14:
        return;
    }

    private static final void a(d r5, LinkedHashSet<String> r6, String r7, JSONObject r8) {
        Object r0 = r8.opt("entity_data");
        if (r0 == null) goto L13;
        b r1 = r5.a(r0);
        if (r1 == null) goto L13;
        List<JSONObject> r2 = r1.a();
        if (r2 == null) goto L13;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        ((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).add(r5.c((JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin")));
        goto L10
    L12:
        LinkedHashSet r9 = (LinkedHashSet) ZeusTransformUtils.preCheckCast((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin"), LinkedHashSet.class, "com.obric.memorydata.plugin");
    L13:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r5.b(r8, r7), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r10.hasNext() == false) goto L17;
        Object r11 = r10.next();
        ((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).add(r5.c((JSONObject) ZeusTransformUtils.preCheckCast(r11, JSONObject.class, "com.obric.memorydata.plugin")));
        goto L15
    L17:
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin");
    }

    private final void a(f r8) {
        this.f.clear();
        this.g.clear();
        this.i.clear();
        this.j.clear();
        this.h.clear();
        this.k = Math.max(this.f11813b, r8.a());
        Iterator r0 = ((Map) ZeusTransformUtils.preCheckCast(r8.b(), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.memorydata.plugin");
        JSONObject r4 = new JSONObject(r2);
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.memorydata.plugin")).put(c(r4), r2);
        ((Map) ZeusTransformUtils.preCheckCast(this.g, Map.class, "com.obric.memorydata.plugin")).put(r3, r2);
        goto L4
    L6:
        Iterator r5 = ((Map) ZeusTransformUtils.preCheckCast(r8.c(), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.preCheckCast(r6.getValue(), List.class, "com.obric.memorydata.plugin");
        ((Map) ZeusTransformUtils.preCheckCast(this.i, Map.class, "com.obric.memorydata.plugin")).put(r7, CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")));
        goto L8
    L10:
        this.j.putAll((Map) ZeusTransformUtils.preCheckCast(r8.d(), Map.class, "com.obric.memorydata.plugin"));
        this.h.putAll((Map) ZeusTransformUtils.preCheckCast(r8.e(), Map.class, "com.obric.memorydata.plugin"));
    }

    private final void a(JSONArray r2, List<? extends JSONObject> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    L4:
        if (r2.length() <= 0) goto L6;
        r2.remove(r2.length() - 1);
        goto L4
    L6:
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r2.put(r4.next());
        goto L8
    }

    private final boolean a(List<? extends JSONObject> r3, Set<String> r4) {
        List<? extends JSONObject> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == false) goto L6;
        return false;
    L6:
        Object r0 = this.e;
        monitor-enter(r0);
        c(r5, r6);     // Catch: Throwable -> L12
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    private final boolean a(JSONArray r6, String r7, Set<String> r8) {
        Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
        List<JSONObject> r0 = a(r6);
        if (r0.isEmpty() == false) goto L6;
        return false;
    L6:
        Object r1 = this.e;
        monitor-enter(r1);
    L18:
        th = move-exception;
        throw th;
    L9:
        if (CollectionsKt.contains((Iterable) ZeusTransformUtils.preCheckCast(l, Iterable.class, "com.obric.memorydata.plugin"), r7) == false) goto L12;
        r0 = b(r0, r9);     // Catch: Throwable -> L18
    L15:
        monitor-exit(r1);
        a(r6, r0);
        return true;
    L12:
        if (CollectionsKt.contains((Iterable) ZeusTransformUtils.preCheckCast(m, Iterable.class, "com.obric.memorydata.plugin"), r7) == false) goto L14;
        r0 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), 50);     // Catch: Throwable -> L18
    L14:
        c(r0, r9);     // Catch: Throwable -> L18
        goto L15
    }

    private final boolean a(JSONArray r3, Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        return a(a(r3), r5);
    }

    private final boolean a(JSONObject r5, String r6, Set<String> r7) {
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        JSONObject r1 = r5.optJSONObject("data");
        boolean r3 = false;
        if (r1 == null) goto L7;
        JSONArray r2 = r1.optJSONArray("entityList");
        if (r2 == null) goto L7;
        r3 = false | a(r2, r6, r8);
    L7:
        JSONObject r4 = r5.optJSONObject("searchResponse");
        if (r4 == null) goto L14;
        JSONObject r0 = r4.optJSONObject("data");
        if (r0 == null) goto L14;
        JSONArray r9 = r0.optJSONArray("entityList");
        if (r9 == null) goto L14;
        r3 = r3 | a(r9, r6, r8);
    L14:
        JSONObject r10 = r5.optJSONObject("globalSearchResponse");
        if (r10 == null) goto L21;
        JSONObject r11 = r10.optJSONObject("entityResult");
        if (r11 == null) goto L21;
        JSONArray r12 = r11.optJSONArray("entityList");
        if (r12 == null) goto L21;
        r3 = r3 | a(r12, r8);
    L21:
        if (r10 == null) goto L27;
        JSONObject r13 = r10.optJSONObject("memoryResult");
        if (r13 == null) goto L27;
        JSONArray r14 = r13.optJSONArray("entityList");
        if (r14 == null) goto L27;
        r3 = r3 | a(r14, r8);
    L27:
        if (r10 == null) goto L34;
        JSONObject r15 = r10.optJSONObject("proactiveRecommendationResult");
        if (r15 == null) goto L35;
        JSONArray r16 = r15.optJSONArray("entityList");
        if (r16 != null) goto L33;
        return r3;
    L33:
        return r3 | a(r16, r8);
    L35:
        return r3;
    L34:
        return r3;
    }

    private final boolean a(JSONObject r7, Set<String> r8) {
        Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
        Object r2 = r7.opt("entity_data");
        if (r2 != null) goto L5;
        return false;
    L5:
        b r4 = a(r2);
        if (r4 != null) goto L9;
        return false;
    L9:
        if (a(r4.a(), r9) == true) goto L12;
        return false;
    L12:
        if (ZeusTransformUtils.instanceOf(r4, b.a.class) == false) goto L20;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L17;
        Object r6 = ((b.a) ZeusTransformUtils.preCheckCast(r4, b.a.class, "com.obric.memorydata.plugin")).b().toString();
    L16:
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
    L18:
        r7.put("entity_data", r6);
        return true;
    L17:
        r6 = ((b.a) ZeusTransformUtils.preCheckCast(r4, b.a.class, "com.obric.memorydata.plugin")).b();
        goto L18
    L20:
        if (ZeusTransformUtils.instanceOf(r4, b.C0640b.class) == false) goto L28;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L24;
        r6 = ((b.C0640b) ZeusTransformUtils.preCheckCast(r4, b.C0640b.class, "com.obric.memorydata.plugin")).b().toString();
        goto L16
    L24:
        r6 = ((b.C0640b) ZeusTransformUtils.preCheckCast(r4, b.C0640b.class, "com.obric.memorydata.plugin")).b();
        goto L18
    L28:
        throw new NoWhenBranchMatchedException();
    }

    private final String b() {
        if (this.i.size() < this.c) goto L7;
        Set<Map.Entry<String, List<String>>> r0 = this.i.entrySet();
        Intrinsics.checkNotNullExpressionValue(r0, "<get-entries>(...)");
        Object r1 = ((Map.Entry) ZeusTransformUtils.preCheckCast(CollectionsKt.first((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")), Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-key>(...)");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
        f(r2);
        return r2;
    L7:
        return a("$E_A", (Map) ZeusTransformUtils.preCheckCast(this.i, Map.class, "com.obric.memorydata.plugin"));
    }

    private final List<JSONObject> b(List<? extends JSONObject> r9, Set<String> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Set<String> r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        List<JSONObject> r0 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"), 5);
        c(r0, r12);
        List r13 = CollectionsKt.drop((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"), 5);
        if (r13.isEmpty() == false) goto L5;
        return r0;
    L5:
        String r14 = b();
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        JSONObject r5 = (JSONObject) ZeusTransformUtils.preCheckCast(r4.next(), JSONObject.class, "com.obric.memorydata.plugin");
        this.h.remove(d(r5));
        String r6 = a("$NE_", (Map) ZeusTransformUtils.preCheckCast(this.j, Map.class, "com.obric.memorydata.plugin"));
        JSONObject r7 = new JSONObject(r5.toString());
        c(r7, r6);
        ((Map) ZeusTransformUtils.preCheckCast(this.j, Map.class, "com.obric.memorydata.plugin")).put(r6, r7.toString());
        r3.add(r6);
        goto L7
    L9:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        JSONObject r15 = new JSONObject(((JSONObject) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r13), JSONObject.class, "com.obric.memorydata.plugin")).toString());
        c(r15, r14);
        ((Map) ZeusTransformUtils.preCheckCast(this.i, Map.class, "com.obric.memorydata.plugin")).put(r14, r8);
        return CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), r15);
    }

    private final List<JSONObject> b(JSONObject r8, String r9) {
        List<JSONObject> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        JSONObject r3 = r8.optJSONObject("data");
        if (r3 == null) goto L7;
        JSONArray r4 = r3.optJSONArray("entityList");
        if (r4 == null) goto L7;
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(a(r4, r9), Iterable.class, "com.obric.memorydata.plugin"));
    L7:
        JSONObject r5 = r8.optJSONObject("searchResponse");
        if (r5 == null) goto L14;
        JSONObject r1 = r5.optJSONObject("data");
        if (r1 == null) goto L14;
        JSONArray r2 = r1.optJSONArray("entityList");
        if (r2 == null) goto L14;
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(a(r2, r9), Iterable.class, "com.obric.memorydata.plugin"));
    L14:
        JSONObject r10 = r8.optJSONObject("globalSearchResponse");
        if (r10 == null) goto L21;
        JSONObject r11 = r10.optJSONObject("entityResult");
        if (r11 == null) goto L21;
        JSONArray r12 = r11.optJSONArray("entityList");
        if (r12 == null) goto L21;
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(a(r12), Iterable.class, "com.obric.memorydata.plugin"));
    L21:
        if (r10 == null) goto L27;
        JSONObject r13 = r10.optJSONObject("memoryResult");
        if (r13 == null) goto L27;
        JSONArray r14 = r13.optJSONArray("entityList");
        if (r14 == null) goto L27;
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(a(r14), Iterable.class, "com.obric.memorydata.plugin"));
    L27:
        if (r10 == null) goto L33;
        JSONObject r15 = r10.optJSONObject("proactiveRecommendationResult");
        if (r15 == null) goto L33;
        JSONArray r16 = r15.optJSONArray("entityList");
        if (r16 == null) goto L33;
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(a(r16), Iterable.class, "com.obric.memorydata.plugin"));
    L33:
        return r0;
    }

    private final void b(JSONObject r6) {
        String r0 = c(r6);
        this.h.remove(d(r6));
        if (this.f.containsKey(r0) == false) goto L14;
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.f.get(r0), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L14;
        String r2 = new JSONObject(r1).optString("ecaId");
        if (r2 == null) goto L14;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L14;
    L15:
        c(r6, r2);
        String r7 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.memorydata.plugin")).put(r0, r7);
        ((Map) ZeusTransformUtils.preCheckCast(this.g, Map.class, "com.obric.memorydata.plugin")).put(r2, r7);
        return;
    L14:
        r2 = a("$E_", (Map) ZeusTransformUtils.preCheckCast(this.g, Map.class, "com.obric.memorydata.plugin"));
        goto L15
    }

    private final f c() {
        LinkedHashMap r2 = new LinkedHashMap();
        Collection<String> r0 = this.f.values();
        Intrinsics.checkNotNullExpressionValue(r0, "<get-values>(...)");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        String r4 = new JSONObject(r3).optString("ecaId");
        Intrinsics.checkNotNull(r4);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        ((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin")).put(r4, r3);
        goto L4
    L8:
        int r5 = this.k;
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(this.i, Map.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r6.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r8.hasNext() == false) goto L13;
        Object r9 = r8.next();
        r7.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r9, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r9, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Iterable.class, "com.obric.memorydata.plugin")));
        goto L10
    L13:
        return new f(r5, r2, new LinkedHashMap(r7), new LinkedHashMap((Map) ZeusTransformUtils.preCheckCast(this.j, Map.class, "com.obric.memorydata.plugin")), new LinkedHashMap((Map) ZeusTransformUtils.preCheckCast(this.h, Map.class, "com.obric.memorydata.plugin")));
    }

    private final String c(JSONObject r2) {
        return r2.optString(OaidModel.KEY_ID) + '_' + r2.optString("type");
    }

    private final void c(List<? extends JSONObject> r6, Set<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r2.add(c((JSONObject) ZeusTransformUtils.preCheckCast(r1.next(), JSONObject.class, "com.obric.memorydata.plugin")));
        goto L7
    L9:
        Set r10 = SetsKt.plus(r9, (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"));
        this.k = Math.max(this.k, r10.size());
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L12;
    L14:
        Iterator r5 = r3.iterator();
    L16:
        if (r5.hasNext() == false) goto L22;
        if ((!this.f.containsKey((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin"))) == false) goto L16;
        r4 = r4 + 1;
        if (r4 >= 0) goto L16;
        CollectionsKt.throwCountOverflow();
    L22:
        int r11 = this.f.size() + r4;
    L24:
        if (r11 <= this.k) goto L36;
        Set<String> r12 = this.f.keySet();
        Intrinsics.checkNotNullExpressionValue(r12, "<get-keys>(...)");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L27:
        if (r13.hasNext() == false) goto L31;
        Object r14 = r13.next();
        if ((!r10.contains((String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin"))) == false) goto L27;
    L32:
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L36;
        e(r15);
        r11 = r11 - 1;
        goto L24
    L31:
        r14 = null;
    L36:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L38:
        if (r16.hasNext() == false) goto L40;
        b((JSONObject) ZeusTransformUtils.preCheckCast(r16.next(), JSONObject.class, "com.obric.memorydata.plugin"));
        goto L38
    L40:
        return;
    L12:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L14;
        goto L14
    }

    private final void c(JSONObject r1, String r2) {
        r1.remove("ecaid");
        r1.remove("eca_id");
        r1.put("ecaId", r2);
    }

    private final String d(JSONObject r1) {
        return c(r1);
    }

    private final <V> LinkedHashMap<String, V> d() {
        return new LinkedHashMap(16, 0.75f, true);
    }

    private final List<JSONObject> d(String r5) {
        List r6 = (List) ZeusTransformUtils.preCheckCast(this.i.get(r5), List.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L5;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L16;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(this.j.get(r2), String.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L12;
        JSONObject r4 = new JSONObject(r3);
    L13:
        if (r4 == null) goto L8;
        r0.add(r4);
        goto L8
    L12:
        r4 = null;
        goto L13
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L5:
        return CollectionsKt.emptyList();
    }

    private final List<JSONObject> e(JSONObject r2) {
        Object r3 = r2.opt("entity_data");
        if (r3 == null) goto L5;
        b r1 = a(r3);
        if (r1 == null) goto L9;
        List<JSONObject> r4 = r1.a();
    L10:
        if (r4 == null) goto L12;
        return r4;
    L12:
        return CollectionsKt.emptyList();
    L9:
        r4 = null;
        goto L10
    L5:
        return CollectionsKt.emptyList();
    }

    private final void e(String r7) {
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.f.remove(r7), String.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L35;
        return;
    L35:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        d r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        Object r4 = Result.m1421constructorimpl(new JSONObject(r1));     // Catch: Throwable -> L7
    L9:
        Object r5 = null;
        if (Result.m1427isFailureimpl(r4) == false) goto L12;
        r4 = null;
    L12:
        JSONObject r6 = (JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L15;
        String r8 = r6.optString("ecaId");
    L16:
        if (r8 != null) goto L18;
        r8 = "";
    L18:
        String r9 = (String) ZeusTransformUtils.preCheckCast(this.g.get(r8), String.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L30;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L22
        Object r0 = Result.m1421constructorimpl(((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin")).c(new JSONObject(r9)));     // Catch: Throwable -> L22
    L25:
        if (Result.m1427isFailureimpl(r0) == true) goto L28;
        r5 = r0;
    L28:
        r5 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
    L22:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r0 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L30:
        if (Intrinsics.areEqual(r5, r7) == false) goto L37;
        this.g.remove(r8);
        return;
    L37:
        return;
    L15:
        r8 = null;
    L7:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    private final void f(String r4) {
        List r5 = (List) ZeusTransformUtils.preCheckCast(this.i.remove(r4), List.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        r5 = CollectionsKt.emptyList();
    L5:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        LinkedHashMap<String, String> r3 = this.j;
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        r3.remove((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"));
        goto L7
    }

    private final JSONObject g(String r6) {
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        Object r4 = null;
        if (StringsKt.startsWith$default(r5, "{", false, 2, null) == true) goto L5;
    L17:
        return null;
    L5:
        if (StringsKt.endsWith$default(r5, "}", false, 2, null) == false) goto L17;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L9
        Object r8 = Result.m1421constructorimpl(new JSONObject(r6));     // Catch: Throwable -> L9
    L12:
        if (Result.m1427isFailureimpl(r8) == true) goto L16;
        r4 = r8;
    L16:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin");
    L9:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final String a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "rawJson");
        Object r0 = this.e;
        monitor-enter(r0);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        d r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        Object r3 = Result.m1421constructorimpl(new JSONObject(r10));     // Catch: Throwable -> L6
    L9:
        if (Result.m1424exceptionOrNullimpl(r3) != null) goto L30;
        JSONObject r4 = (JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        f r5 = c();     // Catch: Throwable -> L32
        Set<String> r6 = a(r4, r11);     // Catch: Throwable -> L32
        boolean r7 = a(r4, r6);     // Catch: Throwable -> L32
        String r8 = r4.optString(NotificationCompat.CATEGORY_MESSAGE);     // Catch: Throwable -> L32
        Intrinsics.checkNotNullExpressionValue(r8, "optString(...)");     // Catch: Throwable -> L32
        JSONObject r9 = g(r8);     // Catch: Throwable -> L32
        boolean r12 = true;
        if (r9 == null) goto L16;
        if ((a(r9, r6) | a(r9, r11, r6)) == false) goto L16;
        r4.put(NotificationCompat.CATEGORY_MESSAGE, r9.toString());     // Catch: Throwable -> L32
        r7 = true;
    L16:
        if ((a(r4, r11, r6) | r7) == false) goto L28;
        String r13 = r4.toString();     // Catch: Throwable -> L32
        Intrinsics.checkNotNullExpressionValue(r13, "toString(...)");     // Catch: Throwable -> L32
        e r14 = this.d;     // Catch: Throwable -> L32
        if (r14 != null) goto L21;
    L23:
        r12 = false;
    L24:
        if (r12 == false) goto L27;
        a(r5);     // Catch: Throwable -> L32
        goto L28
    L27:
        r10 = r13;
        goto L28
    L21:
        if (r14.a(c()) == true) goto L23;
    L28:
        monitor-exit(r0);
        return r10;
    L30:
        monitor-exit(r0);
        return r10;
    L32:
        th = move-exception;
        throw th;
    L6:
        th = move-exception;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L32
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L32
        goto L9
    }

    public final JSONObject a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "ecaId");
        Object r0 = this.e;
        monitor-enter(r0);
        JSONObject r4 = null;
        if (StringsKt.startsWith$default(r6, "$E_A", false, 2, null) == false) goto L7;
        r4 = (JSONObject) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(d(r6)), JSONObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);
        return r4;
    L7:
        String r7 = (String) ZeusTransformUtils.preCheckCast(this.g.get(r6), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r7 == null) goto L11;
        r4 = new JSONObject(r7);     // Catch: Throwable -> L13
        this.f.get(c(r4));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final void a(List<? extends JSONObject> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "entities");
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        Object r0 = this.e;
        monitor-enter(r0);
        f r1 = c();     // Catch: Throwable -> L21
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L21
    L9:
        if (r9.hasNext() == false) goto L11;
        JSONObject r2 = (JSONObject) ZeusTransformUtils.preCheckCast(r9.next(), JSONObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        ((Map) ZeusTransformUtils.preCheckCast(this.h, Map.class, "com.obric.memorydata.plugin")).put(d(r2), r2.toString());     // Catch: Throwable -> L21
        goto L9
    L11:
        a();     // Catch: Throwable -> L21
        e r10 = this.d;     // Catch: Throwable -> L21
        boolean r3 = false;
        if (r10 != null) goto L14;
    L16:
        if (r3 == false) goto L18;
        a(r1);     // Catch: Throwable -> L21
    L18:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r0);
        return;
    L14:
        if (r10.a(c()) == true) goto L16;
        r3 = true;
    L21:
        th = move-exception;
        throw th;
    }

    public final boolean a(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "entity");
        Object r0 = this.e;
        monitor-enter(r0);
        if (this.h.get(d(r3)) == null) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);
        return r2;
    L7:
        r2 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final List<JSONObject> b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "ecaId");
        Object r0 = this.e;
        monitor-enter(r0);
        List<JSONObject> r4 = null;
        if (StringsKt.startsWith$default(r6, "$E_A", false, 2, null) == false) goto L7;
        List<JSONObject> r5 = d(r6);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r0);
        return r5;
    L7:
        JSONObject r7 = a(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L10;
        r4 = CollectionsKt.listOf(r7);     // Catch: Throwable -> L16
    L10:
        if (r4 != null) goto L13;
        r5 = CollectionsKt.emptyList();     // Catch: Throwable -> L16
        goto L14
    L13:
        r5 = r4;
    L16:
        th = move-exception;
        throw th;
    }

    public final List<JSONObject> c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "rawResult");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        d r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r6 = Result.m1421constructorimpl(new JSONObject(r5));     // Catch: Throwable -> L5
    L7:
        List<JSONObject> r3 = null;
        if (Result.m1427isFailureimpl(r6) == false) goto L10;
        r6 = null;
    L10:
        JSONObject r7 = (JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        List<JSONObject> r4 = e(r7);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L17;
        return r4;
    L17:
        String r8 = r7.optString(NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullExpressionValue(r8, "optString(...)");
        JSONObject r9 = g(r8);
        if (r9 == null) goto L20;
        r3 = e(r9);
    L20:
        if (r3 == null) goto L22;
        return r3;
    L22:
        return CollectionsKt.emptyList();
    L13:
        return CollectionsKt.emptyList();
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
