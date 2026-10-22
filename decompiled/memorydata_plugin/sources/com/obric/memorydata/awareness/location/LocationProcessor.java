package com.obric.memorydata.awareness.location;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.obric.memory.model.GetLocationRequest;
import com.bytedance.rpc.callback.RpcCallback;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tJ\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/awareness/location/LocationProcessor;", "", "<init>", "()V", "TAG", "", "locationCache", "", "Lkotlin/Pair;", "", "ADDRESS_TYPE_HOME", "ADDRESS_TYPE_COMPANY", "scope", "Lkotlinx/coroutines/CoroutineScope;", "processLocationData", "jsonStr", "getAddressByGps", "longitude", "latitude", "getCachedAddressByGps", "getAddressInfo", "Lcom/obric/memorydata/awareness/location/LocationProcessor$AddressInfo;", "addressType", "getUserSetAddress", "AddressInfo", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocationProcessor {
    public static final String ADDRESS_TYPE_COMPANY = "公司";
    public static final String ADDRESS_TYPE_HOME = "家";
    public static final LocationProcessor INSTANCE = null;
    private static final String TAG = "LocationProcessor";
    private static final Map<Pair<Double, Double>, String> locationCache = null;
    private static final al scope = null;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013¨\u0006\""}, d2 = {"Lcom/obric/memorydata/awareness/location/LocationProcessor$AddressInfo;", "", ActivityLifecycle.NAME, "", MemoryListActivity.JUMP_FROM_DETAIL, "longitude", "", "latitude", "isSelect", "", "isFromAutoLearn", "<init>", "(Ljava/lang/String;Ljava/lang/String;DDZZ)V", "getName", "()Ljava/lang/String;", "getDetail", "getLongitude", "()D", "getLatitude", "()Z", "setSelect", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class AddressInfo {
        private final String detail;
        private final boolean isFromAutoLearn;
        private boolean isSelect;
        private final double latitude;
        private final double longitude;
        private final String name;

        public AddressInfo(String r2, String r3, double r4, double r6, boolean r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r3, MemoryListActivity.JUMP_FROM_DETAIL);
            this.name = r2;
            this.detail = r3;
            this.longitude = r4;
            this.latitude = r6;
            this.isSelect = r8;
            this.isFromAutoLearn = r9;
        }

        public /* synthetic */ AddressInfo(String r11, String r12, double r13, double r15, boolean r17, boolean r18, int r19, DefaultConstructorMarker r20) {
            if ((r19 & 32) == 0) goto L5;
            boolean r9 = false;
        L6:
            this(r11, r12, r13, r15, r17, r9);
            return;
        L5:
            r9 = r18;
            goto L6
        }

        public static /* synthetic */ AddressInfo copy$default(AddressInfo r9, String r10, String r11, double r12, double r14, boolean r16, boolean r17, int r18, Object r19) {
            if ((r18 & 1) == 0) goto L5;
            String r1 = r9.name;
        L7:
            if ((r18 & 2) == 0) goto L9;
            String r2 = r9.detail;
        L11:
            if ((r18 & 4) == 0) goto L13;
            double r3 = r9.longitude;
        L15:
            if ((r18 & 8) == 0) goto L17;
            double r5 = r9.latitude;
        L19:
            if ((r18 & 16) == 0) goto L21;
            boolean r7 = r9.isSelect;
        L23:
            if ((r18 & 32) == 0) goto L25;
            boolean r8 = r9.isFromAutoLearn;
        L27:
            return r9.copy(r1, r2, r3, r5, r7, r8);
        L25:
            r8 = r17;
            goto L27
        L21:
            r7 = r16;
            goto L23
        L17:
            r5 = r14;
            goto L19
        L13:
            r3 = r12;
            goto L15
        L9:
            r2 = r11;
            goto L11
        L5:
            r1 = r10;
            goto L7
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.detail;
        }

        public final double component3() {
            return this.longitude;
        }

        public final double component4() {
            return this.latitude;
        }

        public final boolean component5() {
            return this.isSelect;
        }

        public final boolean component6() {
            return this.isFromAutoLearn;
        }

        public final AddressInfo copy(String r11, String r12, double r13, double r15, boolean r17, boolean r18) {
            Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r12, MemoryListActivity.JUMP_FROM_DETAIL);
            return new AddressInfo(r11, r12, r13, r15, r17, r18);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, AddressInfo.class) == true) goto L8;
            return false;
        L8:
            AddressInfo r10 = (AddressInfo) ZeusTransformUtils.preCheckCast(r9, AddressInfo.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.detail, r10.detail) == true) goto L15;
            return false;
        L15:
            if (Double.compare(this.longitude, r10.longitude) == 0) goto L18;
            return false;
        L18:
            if (Double.compare(this.latitude, r10.latitude) == 0) goto L21;
            return false;
        L21:
            if (this.isSelect == r10.isSelect) goto L24;
            return false;
        L24:
            if (this.isFromAutoLearn == r10.isFromAutoLearn) goto L26;
            return false;
        L26:
            return true;
        }

        public final String getDetail() {
            return this.detail;
        }

        public final double getLatitude() {
            return this.latitude;
        }

        public final double getLongitude() {
            return this.longitude;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (((((((((this.name.hashCode() * 31) + this.detail.hashCode()) * 31) + Double.hashCode(this.longitude)) * 31) + Double.hashCode(this.latitude)) * 31) + Boolean.hashCode(this.isSelect)) * 31) + Boolean.hashCode(this.isFromAutoLearn);
        }

        public final boolean isFromAutoLearn() {
            return this.isFromAutoLearn;
        }

        public final boolean isSelect() {
            return this.isSelect;
        }

        public final void setSelect(boolean r1) {
            this.isSelect = r1;
        }

        public String toString() {
            return "AddressInfo(name=" + this.name + ", detail=" + this.detail + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ", isSelect=" + this.isSelect + ", isFromAutoLearn=" + this.isFromAutoLearn + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends AddressInfo>> {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.location.LocationProcessor$getAddressByGps$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.awareness.location.LocationProcessor$getAddressByGps$2", f = "LocationProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ CountDownLatch $countDownLatch;
        final /* synthetic */ double $latitude;
        final /* synthetic */ double $longitude;
        final /* synthetic */ Ref.ObjectRef<String> $result;
        int label;

        AnonymousClass2(CountDownLatch r3, double r4, double r6, Ref.ObjectRef<String> r8, Continuation<? super AnonymousClass2> r9) {
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            this.$countDownLatch = r3;
            this.$longitude = r4;
            this.$latitude = r6;
            this.$result = r8;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$countDownLatch, this.$longitude, this.$latitude, this.$result, r8), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r12);
            GetLocationRequest r13 = new GetLocationRequest();     // Catch: Exception -> L7
            double r0 = this.$longitude;     // Catch: Exception -> L7
            double r2 = this.$latitude;     // Catch: Exception -> L7
            r13.longitude = r0;     // Catch: Exception -> L7
            r13.latitude = r2;     // Catch: Exception -> L7
            final CountDownLatch r5 = this.$countDownLatch;     // Catch: Exception -> L7
            final Ref.ObjectRef<String> r6 = this.$result;     // Catch: Exception -> L7
            final double r7 = this.$longitude;     // Catch: Exception -> L7
            final double r9 = this.$latitude;     // Catch: Exception -> L7
            com.bytedance.obric.memory.a.a.a(r13, (RpcCallback) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5, r6, r7, r9), RpcCallback.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L7
        L9:
            return Unit.INSTANCE;
        L7:
            this.$countDownLatch.countDown();
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        INSTANCE = new LocationProcessor();
        locationCache = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        scope = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    private LocationProcessor() {
    }

    public static final /* synthetic */ Map access$getLocationCache$p() {
        return locationCache;
    }

    private final AddressInfo getAddressInfo(String r12) {
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(AppContext.INSTANCE.getUserId(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return null;
    L9:
        String r13 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString("user_set_address_" + r12 + '_' + AppContext.INSTANCE.getUserId(), IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString("user_set_address_" + r12, ""));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L36;
        r1 = false;
    L36:
        if (r1 == false) goto L38;
        return null;
    L38:
        List r14 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r13, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L17 JsonParseException -> L19 JsonSyntaxException -> L22
    L25:
        if (r14 != null) goto L27;
        r14 = CollectionsKt.emptyList();     // Catch: Exception -> L17
    L27:
        Iterator r11 = r14.iterator();     // Catch: Exception -> L17
    L28:
        if (r11.hasNext() == false) goto L33;
        AddressInfo r15 = (AddressInfo) ZeusTransformUtils.preCheckCast(r11.next(), AddressInfo.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L17
        if (r15.isSelect() == false) goto L28;
        return r15;
    L33:
        return null;
    L22:
        e = move-exception;
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L17
        String r6 = "GsonExt";
        String r7 = "toListObj error : " + e;     // Catch: Exception -> L17
    L21:
        IRunLog.a.b(r5, r6, r7, null, 4, null);     // Catch: Exception -> L17
        r14 = null;
    L19:
        e = move-exception;
        r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L17
        r6 = "GsonExt";
        r7 = "toListObj error : " + e;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getAddressList error: " + e.getMessage(), null, 4, null);
        return null;
    L5:
        r0 = false;
        goto L7
    }

    public final synchronized String getAddressByGps(double r15, double r17) {
        monitor-enter(this);
        RunLog.INSTANCE.debug(TAG, "经度: " + r15 + ", 纬度: " + r17);     // Catch: Throwable -> L10
        String r0 = getCachedAddressByGps(r15, r17);     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        monitor-exit(this);
        return r0;
    L7:
        CountDownLatch r1 = new CountDownLatch(1);     // Catch: Throwable -> L10
        Ref.ObjectRef r2 = new Ref.ObjectRef();     // Catch: Throwable -> L10
        r2.element = "";     // Catch: Throwable -> L10
        i.a(scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r1, r15, r17, r2, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L10
        r1.await(5, TimeUnit.SECONDS);     // Catch: Throwable -> L10
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.element, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        monitor-exit(this);
        return r3;
    L10:
        th = move-exception;
        throw th;
    }

    public final String getCachedAddressByGps(double r8, double r10) {
        Map<Pair<Double, Double>, String> r7 = locationCache;
        monitor-enter(r7);
        Iterator<Map.Entry<Pair<Double, Double>, String>> r0 = r7.entrySet().iterator();     // Catch: Throwable -> L18
    L6:
        if (r0.hasNext() == false) goto L14;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (Math.abs(((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r1.getKey(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), Number.class, "com.obric.memorydata.plugin")).doubleValue() - r8) > 1.0E-4d) goto L6;
        if (Math.abs(((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r1.getKey(), Pair.class, "com.obric.memorydata.plugin")).getSecond(), Number.class, "com.obric.memorydata.plugin")).doubleValue() - r10) > 1.0E-4d) goto L6;
        RunLog.INSTANCE.debug(TAG, "hit cached location");     // Catch: Throwable -> L18
        String r9 = (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        monitor-exit(r7);
        return r9;
    L14:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r7);
        return null;
    L18:
        th = move-exception;
        throw th;
    }

    public final String getUserSetAddress(String r2) {
        Intrinsics.checkNotNullParameter(r2, "addressType");
        AddressInfo r3 = getAddressInfo(r2);
        if (r3 != null) goto L5;
        LocationProcessor r1 = (LocationProcessor) ZeusTransformUtils.preCheckCast(this, LocationProcessor.class, "com.obric.memorydata.plugin");
        return "";
    L5:
        return r3.getDetail() + r3.getName();
    }

    public final String processLocationData(String r12) {
        Intrinsics.checkNotNullParameter(r12, "jsonStr");
        LocationData r13 = (LocationData) ZeusTransformUtils.preCheckCast(u.a().fromJson(r12, LocationData.class), LocationData.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L75
        if (r13 == null) goto L10;
        Country r2 = r13.getCountry();     // Catch: Exception -> L75
        if (r2 == null) goto L10;
        String r3 = r2.getName();     // Catch: Exception -> L75
        if (r3 == null) goto L10;
    L11:
        if (r13 == null) goto L16;
        Place r4 = r13.getPlace();     // Catch: Exception -> L75
        if (r4 == null) goto L16;
        String r5 = r4.getAdminArea();     // Catch: Exception -> L75
        if (r5 == null) goto L16;
    L18:
        if (Intrinsics.areEqual(r3, "中国") == true) goto L20;
    L22:
        StringBuilder r1 = new StringBuilder().append(r3).append(r5);     // Catch: Exception -> L75
        if (r13 == null) goto L28;
        Place r6 = r13.getPlace();     // Catch: Exception -> L75
        if (r6 == null) goto L28;
        String r7 = r6.getLocality();     // Catch: Exception -> L75
        if (r7 == null) goto L28;
    L29:
        StringBuilder r8 = r1.append(r7);     // Catch: Exception -> L75
        if (r13 == null) goto L35;
        Place r9 = r13.getPlace();     // Catch: Exception -> L75
        if (r9 == null) goto L35;
        String r10 = r9.getSubLocality();     // Catch: Exception -> L75
        if (r10 == null) goto L35;
    L36:
        String r11 = r8.append(r10).toString();     // Catch: Exception -> L75
        List r14 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L75
        if (r13 == null) goto L42;
        Place r15 = r13.getPlace();     // Catch: Exception -> L75
        if (r15 == null) goto L42;
        List<AreaOfInterest> r16 = r15.getAoi();     // Catch: Exception -> L75
        if (r16 == null) goto L42;
    L43:
        Iterator<AreaOfInterest> r17 = r16.iterator();     // Catch: Exception -> L75
    L45:
        if (r17.hasNext() == false) goto L60;
        AreaOfInterest r18 = (AreaOfInterest) ZeusTransformUtils.preCheckCast(r17.next(), AreaOfInterest.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L75
        Double r19 = r18.getDistance();     // Catch: Exception -> L75
        if (r19 == null) goto L45;
        if (((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.memorydata.plugin")).doubleValue() > 1.0E-5d) goto L45;
        CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast(r18.getName(), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L75
        if (r20 != null) goto L53;
    L56:
        boolean r21 = true;
    L57:
        if (r21 == true) goto L45;
        r14.add(r18.getName());     // Catch: Exception -> L75
        goto L45
    L53:
        if (r20.length() == 0) goto L56;
        r21 = false;
        goto L57
    L60:
        if (r14.isEmpty() == false) goto L74;
        StringBuilder r22 = new StringBuilder().append(r11);     // Catch: Exception -> L75
        if (r13 == null) goto L71;
        Place r110 = r13.getPlace();     // Catch: Exception -> L75
        if (r110 == null) goto L71;
        List<AreaOfInterest> r111 = r110.getAoi();     // Catch: Exception -> L75
        if (r111 == null) goto L71;
        AreaOfInterest r112 = (AreaOfInterest) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r111), AreaOfInterest.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L75
        if (r112 == null) goto L71;
        String r113 = r112.getName();     // Catch: Exception -> L75
        if (r113 == null) goto L71;
    L88:
        return r22.append(r113).append("附近").toString();
    L71:
        r113 = "";
        goto L88
    L74:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), null, 0, null, null, 60, null);
    L42:
        r16 = CollectionsKt.emptyList();     // Catch: Exception -> L75
    L35:
        r10 = "";
    L28:
        r7 = "";
        goto L29
    L20:
        if (StringsKt.endsWith$default(r5, "市", false, 2, null) == false) goto L22;
        r5 = "";
    L16:
        r5 = "";
    L10:
        r3 = "中国";
    L75:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "get location desc failed, error: " + e, null, 4, null);
        return "";
    }
}
