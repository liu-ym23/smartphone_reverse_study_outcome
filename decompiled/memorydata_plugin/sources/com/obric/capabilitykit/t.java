package com.obric.capabilitykit;

import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.intent.IntentFunction;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityClassData;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.logger.Logger;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.da;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u00014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004J \u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00192\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0002JV\u0010\u001c\u001aR\u0012\u0004\u0012\u00020\u0004\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030 0\u001f0\u001e0\u001dj(\u0012\u0004\u0012\u00020\u0004\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030 0\u001f0\u001e`!J-\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010'J\u001d\u0010(\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0002\u0010)J\"\u0010*\u001a\u0004\u0018\u00010\u00012\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010,\u001a\u00020\u0004H\u0002J \u00100\u001a\n\u0012\u0004\u0012\u0002H2\u0018\u000101\"\u0004\b\u0000\u00102*\b\u0012\u0004\u0012\u0002H203H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lcom/obric/capabilitykit/execution/IntentExecutor;", "", "()V", "TAG", "", "entitesGson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getEntitesGson", "()Lcom/google/gson/Gson;", "intentMap", "com/obric/capabilitykit/execution/IntentExecutor$intentMap$1", "Lcom/obric/capabilitykit/execution/IntentExecutor$intentMap$1;", "keyguardManager", "Landroid/app/KeyguardManager;", "getKeyguardManager", "()Landroid/app/KeyguardManager;", "keyguardManager$delegate", "Lkotlin/Lazy;", "cancelTaskByMessageId", "", "messageId", InfoRequestQPSOptTraceLogger.REASON, "jobId", "genFailedResult", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "errorCode", "", "getIntentMap", "Ljava/util/LinkedHashMap;", "", "Lkotlin/Pair;", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "Lkotlin/collections/LinkedHashMap;", "handleIntentCalling", "context", "Landroid/content/Context;", "intentCalling", "Lcom/obric/capabilitykit/common/execution/IntentCalling;", "(Landroid/content/Context;Lcom/obric/capabilitykit/common/execution/IntentCalling;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isTaskRunning", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "parseJsonInputParams", "intentName", "typeName", "json", "queryIntentParamType", "Ljava/lang/reflect/Type;", "cachedConstructor", "Ljava/lang/reflect/Constructor;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "AppEntityTypeAdapter", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f7622a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7623b = "IntentExecutor";
    private static final Lazy c = null;
    private static final d d = null;
    private static final Gson e = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/execution/IntentExecutor$AppEntityTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements JsonDeserializer<AppEntity> {
        public a() {
        }

        public AppEntity a(JsonElement r2, Type r3, JsonDeserializationContext r4) {
            Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
            JsonDeserializationContext r5 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r4, JsonDeserializationContext.class, "com.obric.memorydata.plugin");
            Integer r6 = null;
            if (r2 == null) goto L5;
            JsonObject r7 = r2.getAsJsonObject();
        L6:
            if (r7 == null) goto L10;
            JsonElement r8 = r7.get("type");
            if (r8 == null) goto L10;
            r6 = Integer.valueOf(r8.getAsInt());
        L10:
            EntityClassData r9 = (EntityClassData) ZeusTransformUtils.preCheckCast(EntityType.INSTANCE.getClassMap().get(r6), EntityClassData.class, "com.obric.memorydata.plugin");
            if (r9 == null) goto L17;
            Class r10 = r9.getClazz();
            if (r10 == null) goto L17;
            Object r11 = UtilsKt.getGson().fromJson(r2, r10);
            Intrinsics.checkNotNullExpressionValue(r11, "gson.fromJson(json, targetClass)");
            return (AppEntity) ZeusTransformUtils.preCheckCast(r11, AppEntity.class, "com.obric.memorydata.plugin");
        L17:
            throw new IllegalArgumentException("Unknown entity type: " + r6);
        L5:
            r7 = null;
            goto L6
        }

        @Override // com.google.gson.JsonDeserializer
        public /* synthetic */ AppEntity deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
            return a(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.IntentExecutor", f = "IntentExecutor.kt", i = {0, 0, 0, 1, 1, 1}, l = {124, 129}, m = "handleIntentCalling", n = {"this", "context", "intentCalling", "this", "context", "intentCalling"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f7624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f7625b;
        public Object c;
        public /* synthetic */ Object d;
        public final /* synthetic */ t e;
        public int f;

        public b(t r3, Continuation<? super b> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.e = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.d = r2;
            this.f |= Integer.MIN_VALUE;
            return this.e.a(null, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.IntentExecutor$handleIntentCalling$result$1", f = "IntentExecutor.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<al, Continuation<? super IntentResult<? extends Object>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IntentFunction<Parcelable, ?> f7627b;
        public final /* synthetic */ Parcelable c;
        public final /* synthetic */ DispatchContext d;

        public c(IntentFunction<Parcelable, ?> r3, Parcelable r4, DispatchContext r5, Continuation<? super c> r6) {
            IntentFunction<Parcelable, ?> r7 = (IntentFunction) ZeusTransformUtils.wrapperContextForParams(r3, IntentFunction.class, "com.obric.memorydata.plugin");
            Parcelable r8 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r4, Parcelable.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.f7627b = r7;
            this.c = r8;
            this.d = r5;
            super(2, r9);
        }

        public final Object a(al r3, Continuation<? super IntentResult<? extends Object>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), c.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return new c(this.f7627b, this.c, this.d, r5);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super IntentResult<? extends Object>> r4) {
            return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.f7626a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IntentFunction<Parcelable, ?> r6 = this.f7627b;
            Parcelable r2 = this.c;
            DispatchContext r3 = this.d;
            this.f7626a = 1;
            r5 = r6.doAction(r2, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002R\u0012\u0004\u0012\u00020\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00040\u00030\u0001j(\u0012\u0004\u0012\u00020\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00040\u0003`\u0006J8\u0010\t\u001a\u00020\n2.\u0010\u000b\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00040\u0003\u0018\u00010\fH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"com/obric/capabilitykit/execution/IntentExecutor$intentMap$1", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/Pair;", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "Lkotlin/collections/LinkedHashMap;", "MAX_SIZE", "", "removeEldestEntry", "", "eldest", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d extends LinkedHashMap<String, Set<Pair<? extends String, ? extends IntentFunction<?, ?>>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f7628a;

        public d() {
            this.f7628a = 10;
        }

        public Set<Map.Entry<String, Set<Pair<String, IntentFunction<?, ?>>>>> a() {
            return super.entrySet();
        }

        public final Set<Pair<String, IntentFunction<?, ?>>> a(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        public final Set a(Object r3, Set r4) {
            Set<Pair<String, IntentFunction<?, ?>>> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return r5;
        L6:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), r5);
        }

        public Set<Pair<String, IntentFunction<?, ?>>> a(String r3, Set<Pair<String, IntentFunction<?, ?>>> r4) {
            return (Set) ZeusTransformUtils.preCheckCast(super.getOrDefault(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin")), Set.class, "com.obric.memorydata.plugin");
        }

        public boolean a(String r1) {
            return super.containsKey(r1);
        }

        public boolean a(Set<Pair<String, IntentFunction<?, ?>>> r3) {
            return super.containsValue((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"));
        }

        public Set<String> b() {
            return super.keySet();
        }

        public final Set<Pair<String, IntentFunction<?, ?>>> b(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return c((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        public Set<Pair<String, IntentFunction<?, ?>>> b(String r2) {
            return (Set) ZeusTransformUtils.preCheckCast(super.get(r2), Set.class, "com.obric.memorydata.plugin");
        }

        public boolean b(String r3, Set<Pair<String, IntentFunction<?, ?>>> r4) {
            return super.remove(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin"));
        }

        public int c() {
            return super.size();
        }

        public Set<Pair<String, IntentFunction<?, ?>>> c(String r2) {
            return (Set) ZeusTransformUtils.preCheckCast(super.remove(r2), Set.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return false;
        L7:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsValue(Object r3) {
            if (TypeIntrinsics.isMutableSet(r3) == true) goto L7;
            return false;
        L7:
            return a((Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.memorydata.plugin"));
        }

        public Collection<Set<Pair<String, IntentFunction<?, ?>>>> d() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<Map.Entry<String, Set<Pair<String, IntentFunction<?, ?>>>>> entrySet() {
            return a();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object get(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* synthetic */ Object getOrDefault(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return r4;
        L6:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<String> keySet() {
            return b();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object remove(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return c((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.HashMap, java.util.Map
        public final boolean remove(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return false;
        L6:
            if (TypeIntrinsics.isMutableSet(r4) == true) goto L9;
            return false;
        L9:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Set<Pair<? extends String, ? extends IntentFunction<?, ?>>>> r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            if (size() <= this.f7628a) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final int size() {
            return c();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Collection<Set<Pair<String, IntentFunction<?, ?>>>> values() {
            return d();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/KeyguardManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<KeyguardManager> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f7629a = null;

        static {
            f7629a = new e();
        }

        public e() {
            super(0);
        }

        public final KeyguardManager a() {
            Object r2 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSystemService("keyguard");
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.app.KeyguardManager");
            return (KeyguardManager) ZeusTransformUtils.preCheckCast(r2, KeyguardManager.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function0
        public /* synthetic */ KeyguardManager invoke() {
            return a();
        }
    }

    static {
        f7622a = new t();
        c = LazyKt.lazy(e.f7629a);
        d = new d();
        e = new GsonBuilder().registerTypeAdapter(AppEntity.class, new a()).create();
    }

    private t() {
    }

    public static /* synthetic */ IntentResult a(t r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = 1;
    L9:
        return r0.a(r1, r2);
    }

    private final IntentResult<?> a(String r14, int r15) {
        return new IntentResult(r15, null, null, r14, false, false, 0, null, null, null, 1014, null);
    }

    private final <T> Constructor<T> a(Class<T> r1) {
        return r1.getConstructor(new Class[0]);
    }

    private final Type a(String r4) {
        return ZeusTransformUtils.forName(r4, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        Logger.INSTANCE.e(f7623b, "queryIntentParamType -- invalid typeName=" + r4 + "; e=" + e);
        return null;
    }

    private final Object b(String r3, String r4, String r5) {
        Type r2 = a(r4);
        if (r2 != null) goto L10;
        return null;
    L10:
        return e.fromJson(r5, r2);
    L7:
        e = move-exception;
        Logger.INSTANCE.e(f7623b, "handleIntentCalling -- parsing InputParams for intent: `" + r3 + "`: jsonException=" + e);
        return null;
    }

    private final KeyguardManager c() {
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(c.getValue(), KeyguardManager.class, "com.obric.memorydata.plugin");
    }

    public final Gson a() {
        return e;
    }

    public final Boolean a(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "messageId");
        Intrinsics.checkNotNullParameter(r7, "jobId");
        d r5 = d;
        monitor-enter(r5);
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(r5.get(r6), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r0 == null) goto L15;
        Intrinsics.checkNotNullExpressionValue(r0, "intentMap[messageId]");     // Catch: Throwable -> L22
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L22
    L8:
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();     // Catch: Throwable -> L22
        if (Intrinsics.areEqual(((Pair) ZeusTransformUtils.preCheckCast(r2, Pair.class, "com.obric.memorydata.plugin")).getFirst(), r7) == false) goto L8;
    L13:
        Pair r8 = (Pair) ZeusTransformUtils.preCheckCast(r2, Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
    L16:
        monitor-exit(r5);
        if (r8 == null) goto L30;
        IntentFunction r9 = (IntentFunction) ZeusTransformUtils.preCheckCast(r8.getSecond(), IntentFunction.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L21;
        return null;
    L21:
        return r9.isTaskOnGoing(new DispatchContext((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), Long.valueOf(Long.parseLong(r6)), MapsKt.emptyMap()));
    L30:
        return null;
    L12:
        r2 = null;
        goto L13
    L15:
        r8 = null;
    L22:
        th = move-exception;
        throw th;
    }

    public final Object a(Context r19, IntentCalling r20, String r21, Continuation<? super IntentResult<?>> r22) {
        t r1 = this;
        IntentCalling r2 = r20;
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.memorydata.plugin");
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, b.class) == false) goto L7;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin");
        int r6 = r5.f;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.f = r6 - Integer.MIN_VALUE;
    L8:
        Object r7 = r5.d;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r9 = r5.f;
        if (r9 == 0) goto L22;
        if (r9 == 1) goto L15;
        if (r9 != 2) goto L14;
        IntentCalling r10 = (IntentCalling) ZeusTransformUtils.preCheckCast(r5.c, IntentCalling.class, "com.obric.memorydata.plugin");
        r3 = (Context) ZeusTransformUtils.preCheckCast(r5.f7625b, Context.class, "com.obric.memorydata.plugin");
        t r11 = (t) ZeusTransformUtils.preCheckCast(r5.f7624a, t.class, "com.obric.memorydata.plugin");
    L99:
        ResultKt.throwOnFailure(r7);     // Catch: Exception -> L18 ClassCastException -> L20
        t r17 = r11;
        r2 = r10;
        r1 = r17;
    L74:
        IntentResult r0 = (IntentResult) ZeusTransformUtils.preCheckCast(r7, IntentResult.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L78 ClassCastException -> L80
        if (r0 != null) goto L101;
        String r12 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_action_exec_started, TypedValues.Custom.S_STRING, "obric_action_exec_started"));
        Intrinsics.checkNotNullExpressionValue(r12, "context.getString(R.stri…bric_action_exec_started)");
        return new IntentResult(0, null, null, r12, false, false, 0, null, null, null, 1014, null);
    L101:
        return r0;
    L80:
        ClassCastException e2 = e;
    L83:
        Logger.INSTANCE.e(f7623b, "execIntentAsync -- the injection of InputParams for intent: `" + r2.getIntentName() + "` failed at execution; e=" + e2);
        String r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, TypedValues.Custom.S_STRING, "obric_intent_app_exec_failed"));
        Intrinsics.checkNotNullExpressionValue(r13, "context.getString(R.stri…c_intent_app_exec_failed)");
        int r14 = -1007;
    L28:
        return r1.a(r13, r14);
    L78:
        Exception e3 = e;
    L82:
        Logger.INSTANCE.e(f7623b, "execIntentAsync -- the execution for intent: `" + r2.getIntentName() + "` failed; e=" + e3, e3);
        r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, TypedValues.Custom.S_STRING, "obric_intent_app_exec_failed"));
        Intrinsics.checkNotNullExpressionValue(r13, "context.getString(R.stri…c_intent_app_exec_failed)");
        r14 = -1008;
        goto L28
    L20:
        e2 = e;
        t r18 = r11;
        r2 = r10;
        r1 = r18;
    L18:
        e3 = e;
        t r110 = r11;
        r2 = r10;
        r1 = r110;
        goto L82
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (IntentCalling) ZeusTransformUtils.preCheckCast(r5.c, IntentCalling.class, "com.obric.memorydata.plugin");
        r3 = (Context) ZeusTransformUtils.preCheckCast(r5.f7625b, Context.class, "com.obric.memorydata.plugin");
        r11 = (t) ZeusTransformUtils.preCheckCast(r5.f7624a, t.class, "com.obric.memorydata.plugin");
        goto L99
    L22:
        ResultKt.throwOnFailure(r7);
        Logger r15 = Logger.INSTANCE;
        r15.d(f7623b, "handleIntentCalling = " + r20.getIntentName() + '/' + r20.getQuestionId());
        Class r16 = ZeusTransformUtils.forName(r20.getImplClassName(), "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L90
        Intrinsics.checkNotNullExpressionValue(r16, "intentClazz");
        Constructor r23 = r1.a(r16);
        if (r23 != null) goto L91;
        r15.d(f7623b, "handleIntentCalling - impl `" + r20.getImplClassName() + "`: no constructor");
        r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, TypedValues.Custom.S_STRING, "obric_intent_app_exec_failed"));
        Intrinsics.checkNotNullExpressionValue(r13, "context.getString(R.stri…c_intent_app_exec_failed)");
        r14 = -1001;
        goto L28
    L91:
        Object r24 = r23.newInstance(new Object[0]);     // Catch: Exception -> L88
        Class<?> r111 = null;
        if (ZeusTransformUtils.instanceOf(r24, IntentFunction.class) == false) goto L34;
        Object r25 = r24;
    L35:
        IntentFunction r26 = (IntentFunction) ZeusTransformUtils.preCheckCast(r25, IntentFunction.class, "com.obric.memorydata.plugin");
        if (r26 != null) goto L38;
        r15.d(f7623b, "handleIntentCalling - impl `" + r20.getImplClassName() + "`: cannot cast intent object (" + r24 + ") to IntentFunction<Parcelable, *>");
        r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, TypedValues.Custom.S_STRING, "obric_intent_app_exec_failed"));
        Intrinsics.checkNotNullExpressionValue(r13, "context.getString(R.stri…c_intent_app_exec_failed)");
        r14 = -1003;
        goto L28
    L38:
        d r27 = d;
        monitor-enter(r27);
        String r112 = String.valueOf(r20.getQuestionId());     // Catch: Throwable -> L85
        Object r113 = r27.get(r112);     // Catch: Throwable -> L85
        if (r113 != null) goto L43;
        r113 = new LinkedHashSet();     // Catch: Throwable -> L85
        r27.put(r112, r113);     // Catch: Throwable -> L85
    L43:
        ((Set) ZeusTransformUtils.preCheckCast(r113, Set.class, "com.obric.memorydata.plugin")).add(TuplesKt.to(r21, r26));     // Catch: Throwable -> L85
        monitor-exit(r27);
        if (r20.getInputParamsParcel() == null) goto L49;
        Object r28 = r20.getInputParamsParcel();
        Intrinsics.checkNotNull(r28);
    L56:
        if (ZeusTransformUtils.instanceOf(r28, Parcelable.class) == false) goto L58;
        Object r114 = r28;
    L59:
        Parcelable r115 = (Parcelable) ZeusTransformUtils.preCheckCast(r114, Parcelable.class, "com.obric.memorydata.plugin");
        if (r115 != null) goto L65;
        StringBuilder r29 = new StringBuilder().append("execIntentAsync -- casting InputParams for intent: `").append(r20.getIntentName()).append("` failed; required type = `Parcelable`; tried `");
        if (r28 == null) goto L64;
        r111 = r28.getClass();
    L64:
        r15.e(f7623b, r29.append(r111).append('`').toString());
        r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, TypedValues.Custom.S_STRING, "obric_intent_app_exec_failed"));
        Intrinsics.checkNotNullExpressionValue(r13, "context.getString(R.stri…c_intent_app_exec_failed)");
        r14 = -1006;
        goto L28
    L65:
        DispatchContext r30 = new DispatchContext(r3, Boxing.boxLong(r20.getQuestionId()), r20.getExt());
        if (r26.isBlock() == false) goto L71;
        r5.f7624a = r1;     // Catch: Exception -> L78 ClassCastException -> L80
        r5.f7625b = r3;     // Catch: Exception -> L78 ClassCastException -> L80
        r5.c = r2;     // Catch: Exception -> L78 ClassCastException -> L80
        r5.f = 1;     // Catch: Exception -> L78 ClassCastException -> L80
        r7 = r26.doAction(r115, r30, r5);     // Catch: Exception -> L78 ClassCastException -> L80
        if (r7 != r8) goto L74;
        return r8;
    L71:
        c r31 = new c(r26, r115, r30, null);     // Catch: Exception -> L78 ClassCastException -> L80
        r5.f7624a = r1;     // Catch: Exception -> L78 ClassCastException -> L80
        r5.f7625b = r3;     // Catch: Exception -> L78 ClassCastException -> L80
        r5.c = r2;     // Catch: Exception -> L78 ClassCastException -> L80
        r5.f = 2;     // Catch: Exception -> L78 ClassCastException -> L80
        r7 = da.b(3000, r31, r5);     // Catch: Exception -> L78 ClassCastException -> L80
        if (r7 != r8) goto L74;
        return r8;
    L58:
        r114 = null;
        goto L59
    L49:
        if (r20.getInputParamTypeName() != null) goto L51;
    L84:
        r15.e(f7623b, "handleIntentCalling -- InputParams not available: (" + r2 + ')');
        r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, TypedValues.Custom.S_STRING, "obric_intent_app_exec_failed"));
        Intrinsics.checkNotNullExpressionValue(r13, "context.getString(R.stri…c_intent_app_exec_failed)");
        r14 = -1005;
        goto L28
    L51:
        if (r20.getInputParams() == null) goto L84;
        String r32 = r20.getIntentName();
        String r116 = r20.getInputParamTypeName();
        Intrinsics.checkNotNull(r116);
        String r117 = r20.getInputParams();
        Intrinsics.checkNotNull(r117);
        r28 = r1.b(r32, r116, r117);
        if (r28 != null) goto L56;
        r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, TypedValues.Custom.S_STRING, "obric_intent_app_exec_failed"));
        Intrinsics.checkNotNullExpressionValue(r13, "context.getString(R.stri…c_intent_app_exec_failed)");
        r14 = -1004;
    L85:
        th = move-exception;
        throw th;
    L34:
        r25 = null;
    L88:
        e = move-exception;
        Logger.INSTANCE.e(f7623b, "handleIntentCalling - impl `" + r20.getImplClassName() + "`: creation of intent object failed; e=" + e, e);
        r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, TypedValues.Custom.S_STRING, "obric_intent_app_exec_failed"));
        Intrinsics.checkNotNullExpressionValue(r13, "context.getString(R.stri…c_intent_app_exec_failed)");
        r14 = -1002;
    L90:
        Logger.INSTANCE.d(f7623b, "handleIntentCalling - impl `" + r20.getImplClassName() + "`: not found");
        r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_action_not_support, TypedValues.Custom.S_STRING, "obric_action_not_support"));
        Intrinsics.checkNotNullExpressionValue(r13, "context.getString(R.stri…obric_action_not_support)");
        r14 = -1000;
    L7:
        r5 = new b(r1, r4);
        goto L8
    }

    public final boolean a(String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "messageId");
        Intrinsics.checkNotNullParameter(r7, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r8, "jobId");
        Logger.INSTANCE.i(f7623b, "ready to cancel task messageId " + r6 + ", reason=" + r7);
        d r5 = d;
        monitor-enter(r5);
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(r5.get(r6), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        Pair r1 = null;
        Object r2 = null;
        if (r0 == null) goto L13;
        Intrinsics.checkNotNullExpressionValue(r0, "intentMap[messageId]");     // Catch: Throwable -> L18
        Iterator r3 = r0.iterator();     // Catch: Throwable -> L18
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(((Pair) ZeusTransformUtils.preCheckCast(r4, Pair.class, "com.obric.memorydata.plugin")).getFirst(), r8) == false) goto L8;
        r2 = r4;
    L12:
        r1 = (Pair) ZeusTransformUtils.preCheckCast(r2, Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
    L13:
        monitor-exit(r5);
        if (r1 == null) goto L16;
        boolean r9 = ((IntentFunction) ZeusTransformUtils.preCheckCast(r1.getSecond(), IntentFunction.class, "com.obric.memorydata.plugin")).cancelTask(r7);
        Logger.INSTANCE.i(f7623b, "Task cancellation for messageId " + r6 + ", jobId " + r8 + ": " + r9 + ", reason=" + r7);
        return r9;
    L16:
        Logger.INSTANCE.w(f7623b, "No targetIntent found for messageId " + r6);
        return false;
    L18:
        th = move-exception;
        throw th;
    }

    public final LinkedHashMap<String, Set<Pair<String, IntentFunction<?, ?>>>> b() {
        return d;
    }
}
