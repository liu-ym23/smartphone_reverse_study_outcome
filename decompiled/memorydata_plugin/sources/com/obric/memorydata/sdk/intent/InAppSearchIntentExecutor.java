package com.obric.memorydata.sdk.intent;

import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.search.InAppSearchEntity;
import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.capabilitykit.entity.search.InAppSearchResult;
import com.obric.capabilitykit.entity.search.InAppSearchResultWithoutEntity;
import com.obric.capabilitykit.search.IAppSearchCallback;
import com.obric.capabilitykit.search.InAppSearchClient;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.sdk.entity.search.BertQUAction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.da;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u000eJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/sdk/intent/InAppSearchIntentExecutor;", "", "<init>", "()V", "BIZ_NAME", "", "DEFAULT_TIMEOUT_MS", "", "doAction", "Lcom/obric/memorydata/sdk/intent/InAppSearchIntentExecutor$InAppSearchIntentResult;", ChatMessage.TYPE_QUERY, "quResult", "timeoutMs", "bizName", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDispatchIntentImplInfo", "Lcom/obric/capabilitykit/common/intent/AppIntentImplInfo;", "InAppSearchIntentExecuteException", "InAppSearchIntentResult", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InAppSearchIntentExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InAppSearchIntentExecutor f12833a = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/sdk/intent/InAppSearchIntentExecutor$InAppSearchIntentExecuteException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "<init>", "(Ljava/lang/String;)V", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class InAppSearchIntentExecuteException extends Exception {
        public InAppSearchIntentExecuteException(String r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/intent/InAppSearchIntentExecutor$InAppSearchIntentResult;", "", "entities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "<init>", "([Lcom/obric/capabilitykit/entity/app/AppEntity;)V", "getEntities", "()[Lcom/obric/capabilitykit/entity/app/AppEntity;", "[Lcom/obric/capabilitykit/entity/app/AppEntity;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppEntity[] f12834a;

        public a(AppEntity[] r2) {
            Intrinsics.checkNotNullParameter(r2, "entities");
            this.f12834a = r2;
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/memorydata/sdk/intent/InAppSearchIntentExecutor$doAction$3", "Lcom/obric/capabilitykit/search/IAppSearchCallback;", "onCompleted", "", "onError", "errorCode", "", DTraitConstant.ERROR, "", "onSearchResult", "result", "Lcom/obric/capabilitykit/entity/search/InAppSearchResult;", "onSearchResultWithoutEntity", "Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements IAppSearchCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<AppEntity> f12835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ w<IntentResult<AppEntity[]>> f12836b;

        b(List<AppEntity> r3, w<IntentResult<AppEntity[]>> r4) {
            List<AppEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            w<IntentResult<AppEntity[]>> r6 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.memorydata.plugin");
            this.f12835a = r5;
            this.f12836b = r6;
        }

        @Override // com.obric.capabilitykit.search.IAppSearchCallback
        public void onCompleted() {
            List<AppEntity> r0 = this.f12835a;
            w<IntentResult<AppEntity[]>> r15 = this.f12836b;
            monitor-enter(r0);
            r15.a(new IntentResult(0, (AppEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).toArray(new AppEntity[0]), AppEntity[].class, "com.obric.memorydata.plugin"), null, null, false, false, 256, null, null, null, 956, null));     // Catch: Throwable -> L7
            monitor-exit(r0);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.capabilitykit.search.IAppSearchCallback
        public void onError(int r14, String r15) {
            Intrinsics.checkNotNullParameter(r15, DTraitConstant.ERROR);
            this.f12836b.a(new IntentResult(-2002, null, null, "InAppSearch errorCode: " + r14 + ", errorMsg: " + r15, false, false, 256, null, null, null, 950, null));
        }

        @Override // com.obric.capabilitykit.search.IAppSearchCallback
        public void onSearchResult(InAppSearchResult r5) {
            Intrinsics.checkNotNullParameter(r5, "result");
            List<AppEntity> r4 = this.f12835a;
            monitor-enter(r4);
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5.getEntities(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
            Iterator r7 = r6.iterator();     // Catch: Throwable -> L11
        L6:
            if (r7.hasNext() == false) goto L8;
            r0.add(((InAppSearchEntity) ZeusTransformUtils.preCheckCast(r7.next(), InAppSearchEntity.class, "com.obric.memorydata.plugin")).getAppEntity());     // Catch: Throwable -> L11
            goto L6
        L8:
            r4.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
            monitor-exit(r4);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.capabilitykit.search.IAppSearchCallback
        public void onSearchResultWithoutEntity(InAppSearchResultWithoutEntity r1) {
            Intrinsics.checkNotNullParameter(r1, "result");
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/obric/memorydata/sdk/intent/InAppSearchIntentExecutor$doAction$quResults$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/obric/memorydata/sdk/entity/search/BertQUAction;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends TypeToken<List<? extends BertQUAction>> {
        c() {
        }
    }

    static {
        f12833a = new InAppSearchIntentExecutor();
    }

    private InAppSearchIntentExecutor() {
    }

    private final AppIntentImplInfo a() {
        return null;
    }

    public final Object a(String r20, String r21, long r22, String r24, Continuation<? super a> r25) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r25, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, InAppSearchIntentExecutor$doAction$1.class) == false) goto L7;
        InAppSearchIntentExecutor$doAction$1 r2 = (InAppSearchIntentExecutor$doAction$1) ZeusTransformUtils.preCheckCast(r0, InAppSearchIntentExecutor$doAction$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L31:
        IntentResult r3 = (IntentResult) ZeusTransformUtils.preCheckCast(r1, IntentResult.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L46;
        if (r3.getRet() != 0) goto L40;
        AppEntity[] r6 = (AppEntity[]) ZeusTransformUtils.preCheckCast(r3.getEntity(), AppEntity[].class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L39;
        r6 = new AppEntity[0];
    L39:
        return new a(r6);
    L40:
        String r7 = r3.getDetails();
        if (r7 != null) goto L44;
        r7 = "unknown error";
    L44:
        throw new InAppSearchIntentExecuteException(r7);
    L46:
        throw new InAppSearchIntentExecuteException("InAppSearch timeout");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (a() != null) goto L50;
        List r8 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.sdk.c.f12831a.a().fromJson(r21, new c().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonSyntaxException -> L19
    L20:
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L23;
    L26:
        boolean r10 = true;
    L27:
        if (r10 == true) goto L48;
        w r11 = y.a(null, 1, null);
        List r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        InAppSearchClient.INSTANCE.prepareSearch();
        InAppSearchClient r13 = InAppSearchClient.INSTANCE;
        InAppSearchRequest r15 = new InAppSearchRequest(r20, 0, false, false, 0, 30, null);
        r15.setPresetQUResult(com.obric.memorydata.sdk.c.f12831a.a().toJson(CollectionsKt.first(r8)));
        Unit r14 = Unit.INSTANCE;
        r13.startAppSearch("MemorySdkInAppSearch", r15, (IAppSearchCallback) ZeusTransformUtils.preCheckCast(new b(r12, r11), IAppSearchCallback.class, "com.obric.memorydata.plugin"));
        Function2 r16 = (Function2) ZeusTransformUtils.preCheckCast(new InAppSearchIntentExecutor$doAction$result$1(r11, null), Function2.class, "com.obric.memorydata.plugin");
        r2.label = 1;
        r1 = da.b(r22, r16, r2);
        if (r1 != r4) goto L31;
        return r4;
    L48:
        throw new InAppSearchIntentExecuteException("quResult is null");
    L23:
        if (r9.isEmpty() == true) goto L26;
        r10 = false;
    L19:
        r8 = null;
        goto L20
    L50:
        throw new UnsupportedOperationException("not support dispatch intent");
    L7:
        r2 = new InAppSearchIntentExecutor$doAction$1(this, r0);
        goto L8
    }
}
