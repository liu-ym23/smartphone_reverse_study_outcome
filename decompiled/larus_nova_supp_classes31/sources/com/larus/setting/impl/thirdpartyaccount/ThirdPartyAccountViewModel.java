package com.larus.setting.impl.thirdpartyaccount;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.gson.Gson;
import com.larus.home.impl.sdk.j1;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.y0;
import com.larus.setting.api.u;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONArray;
import org.json.JSONObject;
import zs9.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0014R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR)\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u000f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/setting/impl/thirdpartyaccount/ThirdPartyAccountViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "pageData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/setting/api/data/ThirdPartyAccountResponse;", "getPageData", "()Landroidx/lifecycle/MutableLiveData;", "editStatus", "", "getEditStatus", "editResult", "Lkotlin/Triple;", "", "Lcom/larus/setting/impl/thirdpartyaccount/data/ThirdPartyAccountUiData;", "getEditResult", "editThirdPartyPriority", "", "scene", "thirdPartyAccountUiData", "fetchThirdPartyAccountInfo", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ThirdPartyAccountViewModel extends AndroidViewModel {
    public static final a Companion = null;
    public static final String KEY_EDIT_ACCOUNTS = "ThirdPartyEditAccounts";
    private final MutableLiveData<Triple<Boolean, Integer, ct9.b>> editResult;
    private final MutableLiveData<Integer> editStatus;
    private final MutableLiveData<f> pageData;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.thirdpartyaccount.ThirdPartyAccountViewModel$editThirdPartyPriority$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.thirdpartyaccount.ThirdPartyAccountViewModel$editThirdPartyPriority$1", f = "ThirdPartyAccountViewModel.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $scene;
        final /* synthetic */ ct9.b $thirdPartyAccountUiData;
        int label;
        final /* synthetic */ ThirdPartyAccountViewModel this$0;

        /* JADX INFO: renamed from: com.larus.setting.impl.thirdpartyaccount.ThirdPartyAccountViewModel$editThirdPartyPriority$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.setting.impl.thirdpartyaccount.ThirdPartyAccountViewModel$editThirdPartyPriority$1$1", f = "ThirdPartyAccountViewModel.kt", i = {}, l = {56, 70}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ JSONObject $paramsJson;
            final /* synthetic */ int $scene;
            final /* synthetic */ ct9.b $thirdPartyAccountUiData;
            int label;
            final /* synthetic */ ThirdPartyAccountViewModel this$0;

            /* JADX INFO: renamed from: com.larus.setting.impl.thirdpartyaccount.ThirdPartyAccountViewModel$editThirdPartyPriority$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
            @DebugMetadata(c = "com.larus.setting.impl.thirdpartyaccount.ThirdPartyAccountViewModel$editThirdPartyPriority$1$1$1", f = "ThirdPartyAccountViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C00231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;

                public C00231(Continuation<? super C00231> r2) {
                    super(2, r2);
                }

                public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
                    return new C00231(r2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((CoroutineScope) r1, (Continuation) r2);
                }

                public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                    return create(r1, r2).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object r2) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L12;
                    ResultKt.throwOnFailure(r2);
                    IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
                    if (r3 == null) goto L10;
                    r3.getCollectService();
                    y0 r4 = j1.a.f();
                    if (r4 == null) goto L10;
                    r4.w10();
                L10:
                    return Unit.INSTANCE;
                L12:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            public C00221(JSONObject r1, ThirdPartyAccountViewModel r2, int r3, ct9.b r4, Continuation<? super C00221> r5) {
                this.$paramsJson = r1;
                this.this$0 = r2;
                this.$scene = r3;
                this.$thirdPartyAccountUiData = r4;
                super(2, r5);
            }

            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                return new C00221(this.$paramsJson, this.this$0, this.$scene, this.$thirdPartyAccountUiData, r8);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r17) {
                Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r0 = this.label;
                if (r0 == 0) goto L10;
                if (r0 == 1) goto L9;
                if (r0 != 2) goto L8;
                ResultKt.throwOnFailure(r17);
            L31:
                return Unit.INSTANCE;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                ResultKt.throwOnFailure(r17);
                Object r1 = r17;
            L13:
                y r2 = (com.larus.network.http.a) r1;
                if ((r2 instanceof y) == false) goto L28;
                zs9.a r3 = (zs9.a) ((com.larus.network.http.a) r2).b;
                if (r3 != null) goto L18;
            L20:
                boolean r4 = false;
            L21:
                if (r4 == false) goto L23;
                this.this$0.getEditStatus().postValue(Boxing.boxInt(0));
                this.this$0.getEditResult().postValue(new Triple(Boxing.boxBoolean(true), Boxing.boxInt(this.$scene), this.$thirdPartyAccountUiData));
            L24:
                MainCoroutineDispatcher r5 = Dispatchers.getMain();
                C00231 r6 = new C00231(null);
                this.label = 2;
                if (BuildersKt.withContext(r5, r6, this) != r13) goto L31;
                return r13;
            L23:
                this.this$0.getEditStatus().postValue(Boxing.boxInt(0));
                this.this$0.getEditResult().postValue(new Triple(Boxing.boxBoolean(false), Boxing.boxInt(this.$scene), this.$thirdPartyAccountUiData));
                goto L24
            L18:
                if (r3.b() != true) goto L20;
                r4 = true;
                goto L21
            L28:
                if ((r2 instanceof com.larus.network.http.f) == false) goto L31;
                this.this$0.getEditStatus().postValue(Boxing.boxInt(0));
                this.this$0.getEditResult().postValue(new Triple(Boxing.boxBoolean(false), Boxing.boxInt(this.$scene), this.$thirdPartyAccountUiData));
                goto L31
            L10:
                ResultKt.throwOnFailure(r17);
                String r7 = u.h;
                JSONObject r8 = u.a(ThirdPartyAccountViewModel.KEY_EDIT_ACCOUNTS, this.$paramsJson, 4);
                this.label = 1;
                r1 = HttpExtKt.k("Basic", zs9.a.class, r7, r8, null, null, false, null, null, null, this, 1008);
                if (r1 != r13) goto L13;
                return r13;
            }
        }

        public AnonymousClass1(int r1, ct9.b r2, ThirdPartyAccountViewModel r3, Continuation<? super AnonymousClass1> r4) {
            this.$scene = r1;
            this.$thirdPartyAccountUiData = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$scene, this.$thirdPartyAccountUiData, this.this$0, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            JSONObject r4 = new JSONObject();
            int r11 = this.$scene;
            ct9.b r2 = this.$thirdPartyAccountUiData;
            r4.putOpt("scene", Boxing.boxInt(r11));
            JSONArray r12 = new JSONArray();
            JSONObject r3 = new JSONObject();
            r3.putOpt("third_party_key", r2.a);
            r3.putOpt("chosen_status", r2.c);
            r12.put(r3);
            Unit r5 = Unit.INSTANCE;
            r4.putOpt("list", r12);
            CoroutineDispatcher r13 = Dispatchers.getIO();
            C00221 r6 = new C00221(r4, this.this$0, this.$scene, this.$thirdPartyAccountUiData, null);
            this.label = 1;
            if (BuildersKt.withContext(r13, r6, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.thirdpartyaccount.ThirdPartyAccountViewModel$fetchThirdPartyAccountInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.thirdpartyaccount.ThirdPartyAccountViewModel$fetchThirdPartyAccountInfo$1", f = "ThirdPartyAccountViewModel.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ThirdPartyAccountViewModel this$0;

        /* JADX INFO: renamed from: com.larus.setting.impl.thirdpartyaccount.ThirdPartyAccountViewModel$fetchThirdPartyAccountInfo$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.setting.impl.thirdpartyaccount.ThirdPartyAccountViewModel$fetchThirdPartyAccountInfo$1$1", f = "ThirdPartyAccountViewModel.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ThirdPartyAccountViewModel this$0;

            public C00241(ThirdPartyAccountViewModel r1, Continuation<? super C00241> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00241(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r16) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                String r14 = null;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r16);
                Object r2 = r16;
            L11:
                y r3 = (com.larus.network.http.a) r2;
                if ((r3 instanceof y) == false) goto L25;
                zs9.a r4 = (zs9.a) ((com.larus.network.http.a) r3).b;     // Catch: Exception -> L22
                if (r4 == null) goto L16;
                r14 = r4.a();     // Catch: Exception -> L22
            L16:
                if (r14 != null) goto L18;
                r14 = "";
            L18:
                f r5 = (f) new Gson().fromJson(r14, f.class);     // Catch: Exception -> L22
                if (r5 == null) goto L25;
                this.this$0.getPageData().postValue(r5);     // Catch: Exception -> L22
            L22:
                e = move-exception;
                Boxing.boxInt(Log.d("TAG", "fetchThirdPartyAccountInfo: e:" + e));
            L25:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r16);
                String r6 = u.h;
                JSONObject r7 = u.a("ThirdPartyGetAccountsV2", null, 6);
                this.label = 1;
                r2 = HttpExtKt.k("Basic", zs9.a.class, r6, r7, null, null, false, null, null, null, this, 1008);
                if (r2 != r0) goto L11;
                return r0;
            }
        }

        public C01421(ThirdPartyAccountViewModel r1, Continuation<? super C01421> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01421(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            CoroutineDispatcher r7 = Dispatchers.getIO();
            C00241 r2 = new C00241(this.this$0, null);
            this.label = 1;
            if (BuildersKt.withContext(r7, r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public final void fetchThirdPartyAccountInfo() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01421(this, null), 3, null);
    }

    public final MutableLiveData<Triple<Boolean, Integer, ct9.b>> getEditResult() {
        return this.editResult;
    }

    public final MutableLiveData<Integer> getEditStatus() {
        return this.editStatus;
    }

    public final MutableLiveData<f> getPageData() {
        return this.pageData;
    }

    public ThirdPartyAccountViewModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        this.pageData = new MutableLiveData();
        this.editStatus = new MutableLiveData(0);
        this.editResult = new MutableLiveData();
    }

    public final void editThirdPartyPriority(int r9, ct9.b r10) {
        Intrinsics.checkNotNullParameter(r10, "thirdPartyAccountUiData");
        this.editStatus.postValue(1);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(r9, r10, this, null), 3, null);
    }
}
