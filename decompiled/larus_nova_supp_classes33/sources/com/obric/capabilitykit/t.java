package com.obric.capabilitykit;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Parcelable;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.security.provision.check.bean.ProvisionResult;
import com.obric.cae.libs.useraware.ApWakeEvent;
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
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class t {
    public static final t a = null;
    public static final Lazy b = null;
    public static final d c = null;
    public static final Gson d = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/execution/IntentExecutor$AppEntityTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements JsonDeserializer<AppEntity> {
        public a() {
        }

        public final Object deserialize(JsonElement r2, Type r3, JsonDeserializationContext r4) {
            Integer r5 = null;
            if (r2 == null) goto L5;
            JsonObject r6 = r2.getAsJsonObject();
        L6:
            if (r6 == null) goto L10;
            JsonElement r7 = r6.get("type");
            if (r7 == null) goto L10;
            r5 = Integer.valueOf(r7.getAsInt());
        L10:
            EntityClassData r8 = (EntityClassData) EntityType.INSTANCE.getClassMap().get(r5);
            if (r8 == null) goto L17;
            Class r9 = r8.getClazz();
            if (r9 == null) goto L17;
            return (AppEntity) GsonProtectorUtils.fromJson(UtilsKt.a(), r2, r9);
        L17:
            throw new IllegalArgumentException("Unknown entity type: " + r5);
        L5:
            r6 = null;
            goto L6
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.IntentExecutor", f = "IntentExecutor.kt", i = {0, 0, 0, 1, 1, 1}, l = {124, 129}, m = "handleIntentCalling", n = {"this", "context", "intentCalling", "this", "context", "intentCalling"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class b extends ContinuationImpl {
        public Object a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public final /* synthetic */ t e;
        public int f;

        public b(t r1, Continuation<? super b> r2) {
            this.e = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.d = r2;
            this.f |= Integer.MIN_VALUE;
            return this.e.d(null, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.obric.capabilitykit.execution.IntentExecutor$handleIntentCalling$result$1", f = "IntentExecutor.kt", i = {}, l = {ApWakeEvent.ACCELERATING_START}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IntentResult<? extends Object>>, Object> {
        public int a;
        public final /* synthetic */ IntentFunction<Parcelable, ?> b;
        public final /* synthetic */ Parcelable c;
        public final /* synthetic */ DispatchContext d;

        public c(IntentFunction<Parcelable, ?> r1, Parcelable r2, DispatchContext r3, Continuation<? super c> r4) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
            super(2, r4);
        }

        public final Object a(CoroutineScope r1, Continuation<? super IntentResult<? extends Object>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new c(this.b, this.c, this.d, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return a((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IntentFunction<Parcelable, ?> r6 = this.b;
            Parcelable r2 = this.c;
            DispatchContext r3 = this.d;
            this.a = 1;
            r5 = r6.doAction(r2, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002R\u0012\u0004\u0012\u00020\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00040\u00030\u0001j(\u0012\u0004\u0012\u00020\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00040\u0003`\u0006J8\u0010\t\u001a\u00020\n2.\u0010\u000b\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00040\u0003\u0018\u00010\fH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"com/obric/capabilitykit/execution/IntentExecutor$intentMap$1", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/Pair;", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "Lkotlin/collections/LinkedHashMap;", "MAX_SIZE", "", "removeEldestEntry", "", "eldest", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d extends LinkedHashMap<String, Set<Pair<? extends String, ? extends IntentFunction<?, ?>>>> {
        private final int a;

        public d() {
            this.a = 10;
        }

        public /* bridge */ Set<Map.Entry<String, Set<Pair<String, IntentFunction<?, ?>>>>> a() {
            return super.entrySet();
        }

        public final /* bridge */ Set<Pair<String, IntentFunction<?, ?>>> a(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return b((String) r2);
        }

        public final /* bridge */ Set a(Object r2, Set r3) {
            if ((r2 instanceof String) == true) goto L6;
            return r3;
        L6:
            return a((String) r2, r3);
        }

        public /* bridge */ Set<Pair<String, IntentFunction<?, ?>>> a(String r1, Set<Pair<String, IntentFunction<?, ?>>> r2) {
            return (Set) super.getOrDefault(r1, r2);
        }

        public /* bridge */ boolean a(String r1) {
            return super.containsKey(r1);
        }

        public /* bridge */ boolean a(Set<Pair<String, IntentFunction<?, ?>>> r1) {
            return super.containsValue(r1);
        }

        public /* bridge */ Set<String> b() {
            return super.keySet();
        }

        public final /* bridge */ Set<Pair<String, IntentFunction<?, ?>>> b(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return c((String) r2);
        }

        public /* bridge */ Set<Pair<String, IntentFunction<?, ?>>> b(String r1) {
            return (Set) super.get(r1);
        }

        public /* bridge */ boolean b(String r1, Set<Pair<String, IntentFunction<?, ?>>> r2) {
            return super.remove(r1, r2);
        }

        public /* bridge */ int c() {
            return super.size();
        }

        public /* bridge */ Set<Pair<String, IntentFunction<?, ?>>> c(String r1) {
            return (Set) super.remove(r1);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return false;
        L7:
            return a((String) r2);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object r2) {
            if (TypeIntrinsics.isMutableSet(r2) == true) goto L7;
            return false;
        L7:
            return a((Set) r2);
        }

        public /* bridge */ Collection<Set<Pair<String, IntentFunction<?, ?>>>> d() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, Set<Pair<String, IntentFunction<?, ?>>>>> entrySet() {
            return a();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return b((String) r2);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object r2, Object r3) {
            if ((r2 instanceof String) == true) goto L6;
            return r3;
        L6:
            return a((String) r2, (Set) r3);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return b();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return c((String) r2);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object r3, Object r4) {
            if ((r3 instanceof String) == true) goto L6;
            return false;
        L6:
            if (TypeIntrinsics.isMutableSet(r4) == true) goto L9;
            return false;
        L9:
            return b((String) r3, (Set) r4);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Set<Pair<? extends String, ? extends IntentFunction<?, ?>>>> r2) {
            if (size() <= this.a) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return c();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<Set<Pair<String, IntentFunction<?, ?>>>> values() {
            return d();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/app/KeyguardManager;", "invoke", "()Landroid/app/KeyguardManager;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class e extends Lambda implements Function0<KeyguardManager> {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
            super(0);
        }

        public final KeyguardManager a() {
            Object r0 = AppHost.Companion.getApplication().getSystemService("keyguard");
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
            return (KeyguardManager) r0;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return a();
        }
    }

    static {
        a = new t();
        b = LazyKt.lazy(e.a);
        c = new d();
        d = new GsonBuilder().registerTypeAdapter(AppEntity.class, new a()).create();
    }

    public t() {
    }

    public static IntentResult b(String r14, int r15) {
        return new IntentResult(r15, null, null, r14, false, false, 0, null, null, null, 1014, null);
    }

    public static Boolean c(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "messageId");
        Intrinsics.checkNotNullParameter(r6, "jobId");
        d r0 = c;
        monitor-enter(r0);
        Set r1 = (Set) r0.get(r5);     // Catch: Throwable -> L22
        if (r1 == null) goto L15;
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L22
    L8:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();     // Catch: Throwable -> L22
        if (Intrinsics.areEqual(((Pair) r3).getFirst(), r6) == false) goto L8;
    L13:
        Pair r4 = (Pair) r3;     // Catch: Throwable -> L22
    L16:
        monitor-exit(r0);
        if (r4 == null) goto L30;
        IntentFunction r7 = (IntentFunction) r4.getSecond();
        if (r7 != null) goto L21;
        return null;
    L21:
        return r7.isTaskOnGoing(new DispatchContext(AppHost.Companion.getApplication(), Long.valueOf(CastLongProtector.parseLong(r5)), MapsKt.emptyMap()));
    L30:
        return null;
    L12:
        r3 = null;
        goto L13
    L15:
        r4 = null;
    L22:
        th = move-exception;
        throw th;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public final Object d(Context r18, IntentCalling r19, String r20, Continuation<? super IntentResult<?>> r21) {
        Context r2 = r18;
        IntentCalling r3 = r19;
        if ((r21 instanceof b) == false) goto L7;
        b r4 = (b) r21;
        int r5 = r4.f;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.f = r5 - Integer.MIN_VALUE;
    L8:
        Object r0 = r4.d;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.f;
        if (r7 == 0) goto L22;
        if (r7 == 1) goto L15;
        if (r7 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        IntentCalling r8 = (IntentCalling) r4.c;
        Context r9 = (Context) r4.b;
        t r10 = (t) r4.a;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L18 ClassCastException -> L20
        r3 = r8;
        r2 = r9;
    L114:
        IntentResult r1 = (IntentResult) r0;     // Catch: Exception -> L86 ClassCastException -> L88
        if (r1 == null) goto L85;
        return r1;
    L85:
        return new IntentResult(0, null, null, r2.getString(2131911936), false, false, 0, null, null, null, 1014, null);
    L88:
        e = e;
    L95:
        Logger.INSTANCE.e("IntentExecutor", "execIntentAsync -- the injection of InputParams for intent: `" + r3.f + "` failed at execution; e=" + e);
        String r11 = r2.getString(2131912185);
        r10.getClass();
        int r12 = -1007;
    L28:
        return b(r11, r12);
    L86:
        e = e;
    L92:
        Logger.INSTANCE.e("IntentExecutor", "execIntentAsync -- the execution for intent: `" + r3.f + "` failed; e=" + e, e);
        r11 = r2.getString(2131912185);
        r10.getClass();
        r12 = -1008;
        goto L28
    L20:
        e = e;
        r3 = r8;
        r2 = r9;
    L18:
        e = e;
        r3 = r8;
        r2 = r9;
        goto L92
    L22:
        ResultKt.throwOnFailure(r0);
        Logger r13 = Logger.INSTANCE;
        r13.d("IntentExecutor", "handleIntentCalling = " + r3.f + '/' + r3.a);
        Constructor r14 = a(r3.g).getConstructor(new Class[0]);
        if (r14 != null) goto L103;
        r13.d("IntentExecutor", "handleIntentCalling - impl `" + r3.g + "`: no constructor");
        r11 = r2.getString(2131912185);
        r12 = -1001;
        goto L28
    L103:
        Object r15 = r14.newInstance(new Object[0]);     // Catch: Exception -> L100
        if ((r15 instanceof IntentFunction) == false) goto L33;
        Object r16 = r15;
    L34:
        IntentFunction r17 = (IntentFunction) r16;
        if (r17 != null) goto L37;
        r13.d("IntentExecutor", "handleIntentCalling - impl `" + r3.g + "`: cannot cast intent object (" + r15 + ") to IntentFunction<Parcelable, *>");
        r11 = r2.getString(2131912185);
        r12 = -1003;
        goto L28
    L37:
        d r110 = c;
        monitor-enter(r110);
        String r22 = String.valueOf(r3.a);     // Catch: Throwable -> L97
        Set r111 = r110.get(r22);     // Catch: Throwable -> L97
        if (r111 != null) goto L42;
        r111 = new LinkedHashSet();     // Catch: Throwable -> L97
        r110.put(r22, r111);     // Catch: Throwable -> L97
    L42:
        r111.add(TuplesKt.to(r20, r17));     // Catch: Throwable -> L97
        monitor-exit(r110);
        Object r23 = r3.j;
        if (r23 == null) goto L48;
        Intrinsics.checkNotNull(r23);
    L66:
        if ((r23 instanceof Parcelable) == false) goto L68;
        Object r24 = r23;
    L69:
        Parcelable r25 = (Parcelable) r24;
        if (r25 != null) goto L72;
        r13.e("IntentExecutor", "execIntentAsync -- casting InputParams for intent: `" + r3.f + "` failed; required type = `Parcelable`; tried `" + r23.getClass() + '`');
        r11 = r2.getString(2131912185);
        r12 = -1006;
        goto L28
    L72:
        DispatchContext r26 = new DispatchContext(r2, Boxing.boxLong(r3.a), r3.k);
    L93:
        e = e;
        r10 = this;
    L90:
        e = e;
        r10 = this;
        goto L92
    L74:
        if (r17.isBlock() == false) goto L78;
        r4.a = this;     // Catch: Exception -> L90 ClassCastException -> L93
        r4.b = r2;     // Catch: Exception -> L90 ClassCastException -> L93
        r4.c = r3;     // Catch: Exception -> L90 ClassCastException -> L93
        r4.f = 1;     // Catch: Exception -> L90 ClassCastException -> L93
        r0 = r17.doAction(r25, r26, r4);     // Catch: Exception -> L90 ClassCastException -> L93
        if (r0 != r6) goto L81;
        return r6;
    L81:
        r10 = this;
        goto L114
    L78:
        c r27 = new c(r17, r25, r26, null);     // Catch: Exception -> L90 ClassCastException -> L93
        r4.a = this;     // Catch: Exception -> L90 ClassCastException -> L93
        r4.b = r2;     // Catch: Exception -> L90 ClassCastException -> L93
        r4.c = r3;     // Catch: Exception -> L90 ClassCastException -> L93
        r4.f = 2;     // Catch: Exception -> L90 ClassCastException -> L93
        r0 = TimeoutKt.c(3000, r27, r4);     // Catch: Exception -> L90 ClassCastException -> L93
        if (r0 != r6) goto L81;
        return r6;
    L68:
        r24 = null;
        goto L69
    L48:
        if (r3.h != null) goto L50;
    L96:
        r13.e("IntentExecutor", "handleIntentCalling -- InputParams not available: (" + r3 + ')');
        r11 = r2.getString(2131912185);
        r12 = -1005;
        goto L28
    L50:
        if (r3.i == null) goto L96;
        String r112 = r3.f;
        String r113 = r3.h;
        Intrinsics.checkNotNull(r113);
        String r114 = r3.i;
        Intrinsics.checkNotNull(r114);
        Class r28 = a(r113);     // Catch: Exception -> L54
    L56:
        if (r28 != null) goto L111;
    L62:
        r23 = null;
    L63:
        if (r23 != null) goto L66;
        r11 = r2.getString(2131912185);
        r12 = -1004;
        goto L28
    L111:
        r23 = d.fromJson(r114, r28);     // Catch: Exception -> L60
    L60:
        e = move-exception;
        Logger.INSTANCE.e("IntentExecutor", "handleIntentCalling -- parsing InputParams for intent: `" + r112 + "`: jsonException=" + e);
    L54:
        e = move-exception;
        Logger.INSTANCE.e("IntentExecutor", "queryIntentParamType -- invalid typeName=" + r113 + "; e=" + e);
        r28 = null;
    L97:
        th = move-exception;
        throw th;
    L33:
        r16 = null;
    L100:
        e = move-exception;
        Logger.INSTANCE.e("IntentExecutor", "handleIntentCalling - impl `" + r3.g + "`: creation of intent object failed; e=" + e, e);
        r11 = r2.getString(2131912185);
        r12 = -1002;
    L102:
        Logger.INSTANCE.d("IntentExecutor", "handleIntentCalling - impl `" + r3.g + "`: not found");
        r11 = r2.getString(2131911938);
        r12 = ProvisionResult.CODE_DEFAULT;
    L7:
        r4 = new b(this, r21);
        goto L8
    }
}
