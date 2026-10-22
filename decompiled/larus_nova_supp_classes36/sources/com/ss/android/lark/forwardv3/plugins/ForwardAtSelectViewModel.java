package com.ss.android.lark.forwardv3.plugins;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v1.GetWantToMentionChattersRequest;
import com.bytedance.lark.pb.contact.v1.GetWantToMentionChattersResponse;
import com.bytedance.lark.pb.contact.v2.GetWantToMentionChattersRequestV2;
import com.bytedance.lark.pb.contact.v2.GetWantToMentionChattersResponseV2;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.forwardv3.ForwardModuleV3;
import com.ss.android.lark.forwardv3.settings.ImComponentConfigData;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.utils.SearchCommonUtils;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.utils.UIHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.j;
import z5c.p3;
import z5c.r;
import z5c.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0014J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\rH\u0002J\u0006\u0010!\u001a\u00020\rJ\u001a\u0010!\u001a\u00020\r2\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170#J(\u0010$\u001a\u00020\r2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00172\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170#J:\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020*\u0018\u00010)2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001f\u0018\u00010)H\u0002J\u001c\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0082@¢\u0006\u0002\u0010-J>\u0010.\u001a\u0004\u0018\u0001H/\"\u0004\b\u0000\u0010/2\u0006\u00100\u001a\u0002012\u000e\u00102\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003032\u000e\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H/05H\u0082@¢\u0006\u0002\u00106J\u0014\u00107\u001a\u00020\r2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\u000e\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020\u0018J\u000e\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u0005J\u000e\u0010=\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u0005J\u000e\u0010>\u001a\u00020\r2\u0006\u0010?\u001a\u00020@R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR#\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00180\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/ss/android/lark/forwardv3/plugins/ForwardAtSelectViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mSelectType", "", "dispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "dispatcher$delegate", "Lkotlin/Lazy;", "onCleared", "", "rightTitleTextAndColor", "Landroidx/lifecycle/MutableLiveData;", "Landroid/util/Pair;", "", "getRightTitleTextAndColor", "()Landroidx/lifecycle/MutableLiveData;", "selectType", "getSelectType", "userList", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "getUserList", "selectedData", "", "onMultiItemSelectedChanged", "selectBean", "isSelected", "", "updateTitleText", "loadRecommendUserList", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "loadRecommendUserListV2", "targets", "Lcom/ss/android/lark/forwardv3/plugins/ForwardAtSelectContainerFragment$ForwardTarget;", "trans2PickerBeans", "recommendAtList", "", "Lcom/bytedance/lark/pb/basic/v1/Chatter;", "chatterInChat", "getRecommendAtList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdkRequest", "T", "command", "Lcom/bytedance/lark/pb/basic/v1/Command;", "builder", "Lcom/squareup/wire/Message$Builder;", "iParser", "Lcom/ss/android/lark/sdk/SdkSender$IParser;", "(Lcom/bytedance/lark/pb/basic/v1/Command;Lcom/squareup/wire/Message$Builder;Lcom/ss/android/lark/sdk/SdkSender$IParser;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePickerSelectedState", "infoList", "onPickerUnSelected", "info", "isMaxSelect", "maxMultiSelectCount", "isMaxSelectV2", "onConfirmed", "fragment", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardAtSelectViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String LOG_TAG = "ForwardAtSelectViewModel";
    private static int MULTI;
    private static int SINGLE;
    private final Lazy dispatcher$delegate;
    private int mSelectType;
    private final MutableLiveData<Pair<String, Integer>> rightTitleTextAndColor;
    private final MutableLiveData<Integer> selectType;
    private final Map<String, SearchBaseInfo> selectedData;
    private final MutableLiveData<List<SearchBaseInfo>> userList;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements SdkSender.IParser {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object parse(byte[] r6) {
            LinkedHashMap r0 = new LinkedHashMap();
            if (r6 == null) goto L19;
            GetWantToMentionChattersResponse r7 = (GetWantToMentionChattersResponse) GetWantToMentionChattersResponse.ADAPTER.decode(r6);
            if (r7 == null) goto L19;
            List r1 = r7.want_to_mention_ids;
            Entity r8 = r7.entity;
            if (r8 == null) goto L9;
            Map r9 = r8.chatters;
        L10:
            if (r1 == null) goto L19;
            Iterator<T> r2 = r1.iterator();
        L13:
            if (r2.hasNext() == false) goto L19;
            String r3 = (String) r2.next();
            if (r9 == null) goto L13;
            if (r9.get(r3) == null) goto L13;
            Object r4 = r9.get(r3);
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.lark.pb.basic.v1.Chatter");
            r0.put(r3, (Chatter) r4);
            goto L13
        L9:
            r9 = null;
        L19:
            return r0;
        }
    }

    public static final class c<T> implements SdkSender.IParser {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object parse(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, "bytes");
            return (GetWantToMentionChattersResponseV2) GetWantToMentionChattersResponseV2.ADAPTER.decode(r2);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.plugins.ForwardAtSelectViewModel$loadRecommendUserList$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.forwardv3.plugins.ForwardAtSelectViewModel$loadRecommendUserList$1", f = "ForwardAtSelectViewModel.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ ForwardAtSelectViewModel this$0;

        public AnonymousClass1(ForwardAtSelectViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ForwardAtSelectViewModel r2 = (ForwardAtSelectViewModel) this.L$0;
            ResultKt.throwOnFailure(r4);
        L12:
            List r5 = ForwardAtSelectViewModel.access$trans2PickerBeans(r2, (Map) r4, null);
            if (CollectionUtils.isNotEmpty(r5) == false) goto L15;
            this.this$0.getUserList().postValue(r5);
        L17:
            return Unit.INSTANCE;
        L15:
            Log.e(ForwardAtSelectViewModel.LOG_TAG, "recommend at list is empty");
            goto L17
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ForwardAtSelectViewModel r6 = this.this$0;
            this.L$0 = r6;
            this.label = 1;
            Object r3 = ForwardAtSelectViewModel.access$getRecommendAtList(r6, this);
            if (r3 != r0) goto L11;
            return r0;
        L11:
            r2 = r6;
            r4 = r3;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.plugins.ForwardAtSelectViewModel$loadRecommendUserList$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.forwardv3.plugins.ForwardAtSelectViewModel$loadRecommendUserList$2", f = "ForwardAtSelectViewModel.kt", i = {}, l = {126, 127}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IGetDataCallback<List<SearchBaseInfo>> $callback;
        Object L$0;
        int label;
        final /* synthetic */ ForwardAtSelectViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.plugins.ForwardAtSelectViewModel$loadRecommendUserList$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
        @DebugMetadata(c = "com.ss.android.lark.forwardv3.plugins.ForwardAtSelectViewModel$loadRecommendUserList$2$1", f = "ForwardAtSelectViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ IGetDataCallback<List<SearchBaseInfo>> $callback;
            final /* synthetic */ List<SearchBaseInfo> $recommendAtList;
            int label;

            public AnonymousClass1(IGetDataCallback<List<SearchBaseInfo>> r1, List<? extends SearchBaseInfo> r2, Continuation<? super AnonymousClass1> r3) {
                this.$callback = r1;
                this.$recommendAtList = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass1(this.$callback, this.$recommendAtList, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                this.$callback.onSuccess(this.$recommendAtList);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass2(ForwardAtSelectViewModel r1, IGetDataCallback<List<SearchBaseInfo>> r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$callback, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ForwardAtSelectViewModel r2 = (ForwardAtSelectViewModel) this.L$0;
            ResultKt.throwOnFailure(r7);
        L13:
            List r8 = ForwardAtSelectViewModel.access$trans2PickerBeans(r2, (Map) r7, null);
            MainCoroutineDispatcher r3 = Dispatchers.getMain();
            AnonymousClass1 r4 = new AnonymousClass1(this.$callback, r8, null);
            this.L$0 = null;
            this.label = 2;
            if (BuildersKt.withContext(r3, r4, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            r2 = this.this$0;
            this.L$0 = r2;
            this.label = 1;
            r7 = ForwardAtSelectViewModel.access$getRecommendAtList(r2, this);
            if (r7 != r0) goto L13;
            return r0;
        }
    }

    static {
        Companion = new a();
        MULTI = 1;
    }

    private final void updateTitleText() {
        if (this.selectedData.isEmpty() == true) goto L5;
        Pair r0 = new Pair(UIHelper.mustacheFormat(2131892073, "count", Integer.toString(this.selectedData.size())), 2131105548);
        this.rightTitleTextAndColor.postValue(r0);
        return;
    L5:
        if (this.mSelectType != SINGLE) goto L7;
        Pair r1 = new Pair(UIUtils.getString(UIHelper.getContext(), 2131892181), 2131106622);
    L8:
        this.rightTitleTextAndColor.postValue(r1);
        return;
    L7:
        r1 = new Pair(UIUtils.getString(UIHelper.getContext(), 2131892187), 2131105548);
        goto L8
    }

    public final ExecutorCoroutineDispatcher getDispatcher() {
        return (ExecutorCoroutineDispatcher) this.dispatcher$delegate.getValue();
    }

    public ForwardAtSelectViewModel() {
        this.mSelectType = SINGLE;
        this.dispatcher$delegate = LazyKt.lazy(ForwardAtSelectViewModel$dispatcher$2.INSTANCE);
        this.rightTitleTextAndColor = new MutableLiveData();
        this.selectType = new MutableLiveData();
        this.userList = new MutableLiveData();
        this.selectedData = new LinkedHashMap();
    }

    public final void loadRecommendUserList() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), getDispatcher(), null, new AnonymousClass1(this, null), 2, null);
    }

    public void onCleared() {
        super.onCleared();
        getDispatcher().close();
        this.selectedData.clear();
    }

    public static final /* synthetic */ int access$getMULTI$cp() {
        return MULTI;
    }

    public static final /* synthetic */ int access$getSINGLE$cp() {
        return SINGLE;
    }

    public final MutableLiveData<Pair<String, Integer>> getRightTitleTextAndColor() {
        return this.rightTitleTextAndColor;
    }

    public final MutableLiveData<Integer> getSelectType() {
        return this.selectType;
    }

    public final MutableLiveData<List<SearchBaseInfo>> getUserList() {
        return this.userList;
    }

    public static final /* synthetic */ void access$setMULTI$cp(int r0) {
        MULTI = r0;
    }

    public static final /* synthetic */ void access$setSINGLE$cp(int r0) {
        SINGLE = r0;
    }

    private final Object getRecommendAtList(Continuation<? super Map<String, Chatter>> r4) {
        WeakReference<Message> r0 = ForwardDataUtils.a;
        ForwardDataUtils.c = SystemClock.elapsedRealtime();
        GetWantToMentionChattersRequest.Builder r1 = new GetWantToMentionChattersRequest.Builder().top_count(Boxing.boxInt(30));
        Command r2 = Command.GET_WANT_TO_MENTION_CHATTERS;
        Intrinsics.checkNotNull(r1);
        return sdkRequest(r2, r1, b.a, r4);
    }

    public final boolean isMaxSelect(int r3) {
        if (this.mSelectType == MULTI) goto L5;
    L7:
        return false;
    L5:
        if (r3 > this.selectedData.size()) goto L7;
        return true;
    }

    public final boolean isMaxSelectV2(int r2) {
        if (r2 > this.selectedData.size()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void loadRecommendUserList(IGetDataCallback<List<SearchBaseInfo>> r8) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), getDispatcher(), null, new AnonymousClass2(this, r8, null), 2, null);
    }

    /* JADX WARN: Type inference failed for: r8v2, types: [android.app.Activity, com.ss.android.lark.forwardv3.plugins.ForwardAtSelectActivity, java.lang.Object] */
    public final void onConfirmed(BaseFragment r8) {
        Intrinsics.checkNotNullParameter(r8, "fragment");
        ArrayList r0 = (ArrayList) CollectionsKt.toCollection(this.selectedData.values(), new ArrayList());
        Context r1 = r8.getContext();
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (ForsetiConfig.a(r1) != true) goto L7;
    L9:
        if (r2 == false) goto L12;
        Bundle r3 = new Bundle();
        r3.putSerializable("EXTRA_KEY_CHATTER_INFO", r0);
        Unit r4 = Unit.INSTANCE;
        zab.a.b(r8, -1, r3);
        return;
    L12:
        if ((r8 instanceof ForwardAtSelectFragmentV2) == true) goto L14;
    L16:
        FragmentActivity r9 = r8.getActivity();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.ss.android.lark.forwardv3.plugins.ForwardAtSelectActivity");
        ?? r10 = (ForwardAtSelectActivity) r9;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r0, "info");
        s5c.a r5 = r.k;
        s5c.a r6 = p3.e;
        s5c.a r7 = z2.h;
        int r11 = zib.e.a;
        r5.getClass();
        zib.e.a.e(s5c.d.b.b(r5, r6).plus(r7));
        Intent r12 = new Intent();
        r12.putExtra("EXTRA_KEY_CHATTER_INFO", r0);
        Unit r13 = Unit.INSTANCE;
        r10.setResult(-1, r12);
        r10.finish();
        return;
    L14:
        if (ForsetiFGHelpers.d() == false) goto L16;
        ForwardAtSelectFragmentV2 r14 = (ForwardAtSelectFragmentV2) r8;
        Intrinsics.checkNotNullParameter(r0, "info");
        s5c.a r15 = r.k;
        s5c.a r16 = p3.e;
        s5c.a r17 = z2.h;
        int r18 = zib.e.a;
        r15.getClass();
        zib.e.a.e(s5c.d.b.b(r15, r16).plus(r17));
        Intent r19 = new Intent();
        r19.putExtra("EXTRA_KEY_CHATTER_INFO", r0);
        Unit r20 = Unit.INSTANCE;
        r14.setResult(-1, r19);
        com.ss.android.lark.ui.component_container.a.d(r14, null);
        return;
    L7:
        r2 = false;
        goto L9
    }

    public final void onPickerUnSelected(SearchBaseInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        if (this.mSelectType != MULTI) goto L6;
        onMultiItemSelectedChanged(r3, false);
        return;
    }

    public final void updatePickerSelectedState(List<? extends SearchBaseInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, "infoList");
        this.selectedData.clear();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        SearchBaseInfo r0 = (SearchBaseInfo) r5.next();
        this.selectedData.put(r0.getId(), r0);
        goto L4
    }

    public static final /* synthetic */ Object access$getRecommendAtList(ForwardAtSelectViewModel r0, Continuation r1) {
        return r0.getRecommendAtList(r1);
    }

    private final void onMultiItemSelectedChanged(SearchBaseInfo r3, boolean r4) {
        String r0 = r3.getId();
        if (r4 == true) goto L5;
    L7:
        if (r4 == false) goto L9;
    L11:
        updateTitleText();
        return;
    L9:
        if (this.selectedData.containsKey(r0) == false) goto L11;
        this.selectedData.remove(r0);
        goto L11
    L5:
        if (this.selectedData.containsKey(r0) == true) goto L7;
        this.selectedData.put(r0, r3);
        goto L11
    }

    private final List<SearchBaseInfo> trans2PickerBeans(Map<String, Chatter> r5, Map<String, Boolean> r6) {
        ArrayList r0 = new ArrayList();
        if (CollectionUtils.isNotEmpty(r5) == false) goto L21;
        Map<String, com.ss.android.lark.chat.entity.chatter.Chatter> r7 = ForwardModuleV3.a().getChatterMap(r5);
        if (r7 == null) goto L21;
        Collection<com.ss.android.lark.chat.entity.chatter.Chatter> r8 = r7.values();
        if (r8 == null) goto L21;
        Iterator<T> r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L21;
        com.ss.android.lark.chat.entity.chatter.Chatter r1 = (com.ss.android.lark.chat.entity.chatter.Chatter) r9.next();
        SearchChatterInfo r2 = SearchCommonUtils.parseFromChatterEntity$default(r1, null, null, 6, null);
        if (r6 == null) goto L20;
        if (com.ss.android.lark.forwardv3.utils.b.b() == false) goto L20;
        Boolean r3 = r6.get(r1.getId());
        if (r3 == null) goto L18;
        boolean r4 = r3.booleanValue();
    L19:
        r2.setInChat(r4);
        goto L20
    L18:
        r4 = false;
    L20:
        r0.add(r2);
    L21:
        Log.i(LOG_TAG, "GET_WANT_TO_MENTION_CHATTERS Recommend size: " + r0.size());
        return r0;
    }

    public final void loadRecommendUserListV2(List<ForwardAtSelectContainerFragment.ForwardTarget> r4, final IGetDataCallback<List<SearchBaseInfo>> r5) {
        Intrinsics.checkNotNullParameter(r4, "targets");
        Intrinsics.checkNotNullParameter(r5, "callback");
        List<ForwardAtSelectContainerFragment.ForwardTarget> r6 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        ForwardAtSelectContainerFragment.ForwardTarget r1 = (ForwardAtSelectContainerFragment.ForwardTarget) r7.next();
        r0.add(new GetWantToMentionChattersRequestV2.ForwardTargetInfo.Builder().target_id(r1.getChatId()).chat_type(Chat.Type.GROUP).build());
        goto L4
    L6:
        GetWantToMentionChattersRequestV2.Builder r8 = new GetWantToMentionChattersRequestV2.Builder().strategy(SyncDataStrategy.FORCE_SERVER).target_infos(r0);
        int r2 = yib.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        ImComponentConfigData r9 = (ImComponentConfigData) SettingManager.getInstance().get(ImComponentConfigData.class);     // Catch: Throwable -> L9
    L11:
        if (r9 == null) goto L17;
        yib.b r10 = r9.a();
        if (r10 == null) goto L17;
        Integer r11 = r10.a();
        if (r11 == null) goto L17;
        int r12 = RangesKt.coerceAtLeast(r11.intValue(), 1);
    L18:
        GetWantToMentionChattersRequestV2.Builder r13 = r8.im_mention_count(Integer.valueOf(r12));
        WeakReference<Message> r14 = ForwardDataUtils.a;
        ForwardDataUtils.c = SystemClock.elapsedRealtime();
        SdkSender.asynSendRequestNonWrap(Command.GET_WANT_TO_MENTION_CHATTERS_V2, r13, new C03811(r5, this), c.a);
        return;
    L17:
        r12 = 15;
    L9:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        r9 = null;
        goto L11
    }

    public static final /* synthetic */ List access$trans2PickerBeans(ForwardAtSelectViewModel r0, Map r1, Map r2) {
        return r0.trans2PickerBeans(r1, r2);
    }

    private final <T> Object sdkRequest(final Command r4, com.squareup.wire.Message.Builder<?, ?> r5, SdkSender.IParser<T> r6, Continuation<? super T> r7) {
        final j r0 = new j(IntrinsicsKt.intercepted(r7), 1);
        r0.C();
        Log.i(LOG_TAG, "sdkRequest " + r4);
        SdkSender.asynSendRequestNonWrap(r4, r5, new ForwardAtSelectViewModel$sdkRequest$2$1(r0, r4), r6);
        Object r8 = r0.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L5:
        return r8;
    }

    public static final /* synthetic */ Object access$sdkRequest(ForwardAtSelectViewModel r0, Command r1, com.squareup.wire.Message.Builder r2, SdkSender.IParser r3, Continuation r4) {
        return r0.sdkRequest(r1, r2, r3, r4);
    }
}
