package com.larus.bmhome.chat;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.bmhome.ConversationChangeModel;
import com.larus.bmhome.chat.adapter.ConversationAdapter;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ConversationListModel;
import com.larus.bmhome.chat.model.ConversationModel;
import com.larus.bmhome.chat.setting.IUserSettingCacheService;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.view.ChatConversationList;
import com.larus.common_ui.paging.FPagingAdapter;
import com.larus.platform.model.UserConfigItem;
import com.larus.platform.model.showcase.Case;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0012\u00103\u001a\u00020.2\b\b\u0002\u00104\u001a\u00020\u001aH\u0014J\b\u00105\u001a\u00020.H\u0014J\u0016\u00106\u001a\u00020.2\f\u00107\u001a\b\u0012\u0004\u0012\u00020908H&J\b\u0010:\u001a\u00020.H\u0002J\u0010\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020\tH\u0014J\n\u0010=\u001a\u0004\u0018\u00010>H&J\u0010\u0010?\u001a\u00020.2\u0006\u0010<\u001a\u00020\tH\u0002J\b\u0010@\u001a\u00020.H&J\b\u0010A\u001a\u00020.H\u0002J\u001a\u0010B\u001a\u00020.2\u0006\u0010C\u001a\u0002002\b\u0010D\u001a\u0004\u0018\u000109H\u0002J\u0019\u0010E\u001a\u0004\u0018\u00010\t2\b\u0010F\u001a\u0004\u0018\u000109H\u0002¢\u0006\u0002\u0010GJ\u0012\u0010H\u001a\u00020\u001a2\b\u0010F\u001a\u0004\u0018\u000109H\u0002J\u0014\u0010I\u001a\u0004\u0018\u00010\u00052\b\u0010F\u001a\u0004\u0018\u000109H&J\b\u0010J\u001a\u00020\u001aH\u0016J\b\u0010K\u001a\u00020LH&J\n\u0010M\u001a\u0004\u0018\u00010\u0005H&J\b\u0010N\u001a\u00020.H\u0016J\b\u0010O\u001a\u00020.H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0013\u001a\u0004\b#\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b*\u0010+¨\u0006P"}, d2 = {"Lcom/larus/bmhome/chat/CommonChatListFragment;", "Lcom/larus/bmhome/BaseHomeTabFragment;", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "PREFETCH_DISTANCE", "", "adapter", "Lcom/larus/bmhome/chat/adapter/ConversationAdapter;", "getAdapter", "()Lcom/larus/bmhome/chat/adapter/ConversationAdapter;", "model", "Lcom/larus/bmhome/chat/model/ConversationModel;", "getModel", "()Lcom/larus/bmhome/chat/model/ConversationModel;", "model$delegate", "Lkotlin/Lazy;", "conversationChangeModel", "Lcom/larus/bmhome/ConversationChangeModel;", "getConversationChangeModel", "()Lcom/larus/bmhome/ConversationChangeModel;", "conversationChangeModel$delegate", "enableForsetiPageSizeSlot", "", "getEnableForsetiPageSizeSlot", "()Z", "chatPassThroughParams", "Lcom/larus/bmhome/chat/bean/ChatPassThroughParams;", "getChatPassThroughParams", "()Lcom/larus/bmhome/chat/bean/ChatPassThroughParams;", "screenMenu", "Lcom/larus/bmhome/view/screenmenu/ScreenMenu;", "getScreenMenu", "()Lcom/larus/bmhome/view/screenmenu/ScreenMenu;", "screenMenu$delegate", "listener", "Lcom/larus/bmhome/chat/model/api/ConversationListener;", "clickUtils", "Lcom/larus/bmhome/chat/helper/ConversationClickHelper;", "getClickUtils", "()Lcom/larus/bmhome/chat/helper/ConversationClickHelper;", "clickUtils$delegate", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupListener", "isStick", "setupModel", "onCvsListChangeEvent", "list", "", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "setupRecycler", "onConversationItemVisible", "index", "getChatListRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "reportItemShow", "initData", "setupList", "showScreenMenu", "v", "c", "getBotType", "conversationData", "(Lcom/larus/bmhome/chat/model/api/ConversationData;)Ljava/lang/Integer;", "getBotIsOwner", "getRecommendFromString", "autoLogEnterPage", "getTraceNode", "Lcom/ixigua/lib/track/ITrackNode;", "getPreviousPage", "onDestroyView", "adapterLoadMore", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract class CommonChatListFragment extends BaseHomeTabFragment {
    public static final /* synthetic */ int p = 0;
    public final ConversationAdapter j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public b n;
    public final Lazy o;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class b implements wh8.b {
        public final /* synthetic */ CommonChatListFragment a;

        public b(CommonChatListFragment r1) {
            this.a = r1;
        }

        @Override // wh8.b
        public final void IJ(int r22) {
            ConversationAdapter r2 = this.a.j;
            r2.getClass();
            FLogger.a.i("ConversationAdapter", "updateLoadMoreStatus, status = " + r22);
            AsyncListDiffer<wh8.a> r3 = r2.y2();
            if (r3 == null) goto L7;
            List r4 = r3.getCurrentList();
            if (r4 == null) goto L7;
            wh8.a r5 = (wh8.a) CollectionsKt.getOrNull(r4, r2.getItemCount() - 1);
        L8:
            boolean r6 = false;
            if (r5 == null) goto L16;
            Integer r7 = r5.j;
            if (r7 == null) goto L16;
            if (r7.intValue() != r22) goto L16;
            boolean r8 = true;
        L17:
            if (r8 == true) goto L53;
            wh8.a r9 = new wh8.a(null, null, null, null, null, null, null, null, null, Integer.valueOf(r22), null, false, 3582);
            if (r5 == null) goto L27;
            Integer r10 = r5.j;
            if (r10 == null) goto L27;
            if (r10.intValue() != 1) goto L27;
            boolean r11 = true;
        L29:
            if (r11 == true) goto L39;
            if (r5 == null) goto L37;
            Integer r12 = r5.j;
            if (r12 == null) goto L37;
            if (r12.intValue() != (-1)) goto L37;
            boolean r13 = true;
        L38:
            if (r13 == true) goto L39;
        L40:
            if (r22 == (-1)) goto L46;
            if (r22 == 0) goto L44;
            if (r22 == 1) goto L46;
            return;
        L44:
            if (r6 == false) goto L50;
            List<wh8.a> r1 = CollectionsKt.toMutableList(r2.getCurrentList());
            CollectionsKt.removeLastOrNull(r1);
            r2.E2(r1);
            return;
        L50:
            return;
        L46:
            if (r6 == false) goto L48;
            List<wh8.a> r14 = CollectionsKt.toMutableList(r2.getCurrentList());
            CollectionsKt.removeLastOrNull(r14);
            r14.add(r9);
            r2.E2(r14);
            return;
        L48:
            List<wh8.a> r15 = CollectionsKt.toMutableList(r2.getCurrentList());
            r15.add(r9);
            r2.E2(r15);
            return;
        L37:
            r13 = false;
        L39:
            r6 = true;
        L27:
            r11 = false;
            goto L29
        L53:
            return;
        L16:
            r8 = false;
        L7:
            r5 = null;
            goto L8
        }

        @Override // wh8.b
        public final void Yo(List<wh8.a> r2) {
            Intrinsics.checkNotNullParameter(r2, "list");
            this.a.da0(r2);
        }

        @Override // wh8.b
        public final void R70(List r1, List r2) {
            wh8.b.a.a(r1, r2);
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.CommonChatListFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.CommonChatListFragment$onViewCreated$1", f = "CommonChatListFragment.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.CommonChatListFragment$onViewCreated$1$a */
        public static final class a<T> implements FlowCollector {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final Object emit(Object r4, Continuation r5) {
                if (((UserConfigKey) r4) != UserConfigKey.PERSONAL_RECOMMEND) goto L28;
                IUserSettingCacheService r6 = (IUserSettingCacheService) ServiceManager.get().getService(IUserSettingCacheService.class);
                String r7 = null;
                if (r6 == null) goto L25;
                List r8 = r6.g();
                if (r8 == null) goto L25;
                Iterator<T> r9 = r8.iterator();
            L10:
                if (r9.hasNext() == false) goto L20;
                T r0 = r9.next();
                Integer r1 = ((UserConfigItem) r0).b();
                int r2 = UserConfigKey.PERSONAL_RECOMMEND.getValue();
                if (r1 != null) goto L15;
            L17:
                boolean r3 = false;
            L18:
                if (r3 == false) goto L10;
            L21:
                UserConfigItem r10 = (UserConfigItem) r0;
                if (r10 == null) goto L25;
                r7 = r10.c();
                goto L25
            L15:
                if (r1.intValue() != r2) goto L17;
                r3 = true;
                goto L18
            L20:
                r0 = null;
            L25:
                if (Intrinsics.areEqual(r7, "0") == false) goto L28;
                com.larus.utils.t0.e(new f2());
            L28:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
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
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r4);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            IUserSettingCacheService r5 = (IUserSettingCacheService) ServiceManager.get().getService(IUserSettingCacheService.class);
            if (r5 == null) goto L18;
            kotlinx.coroutines.flow.d1 r6 = r5.i();
            if (r6 == null) goto L18;
            FlowCollector r2 = a.a;
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L16;
            return r0;
        L18:
            return Unit.INSTANCE;
        }
    }

    public CommonChatListFragment() {
        super(false);
        this.j = new ConversationAdapter(this, new FPagingAdapter.a(6, new j1(this)));
        final Function0<Fragment> r0 = new CommonChatListFragment$special$$inlined$viewModels$default$1(this);
        this.k = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ConversationModel.class), new CommonChatListFragment$special$$inlined$viewModels$default$2(r0), new CommonChatListFragment$special$$inlined$viewModels$default$3(r0, this));
        this.l = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ConversationChangeModel.class), new CommonChatListFragment$special$$inlined$activityViewModels$default$1(this), new CommonChatListFragment$special$$inlined$activityViewModels$default$2(this));
        this.m = LazyKt.lazy(new u1(this));
        this.o = LazyKt.lazy(new x1(this));
    }

    public boolean S90() {
        return false;
    }

    public abstract ChatConversationList Y90();

    public abstract String aa0(wh8.a r1);

    public abstract String b();

    public abstract by7.e ba0();

    public void ca0() {
    }

    public abstract void da0(List<wh8.a> r1);

    public abstract void initData();

    public final ConversationModel Z90() {
        return (ConversationModel) this.k.getValue();
    }

    public void fa0() {
        Z90().getDelete().observe(getViewLifecycleOwner(), new a(new y1(this)));
        Z90().getUpdateNameStatus().observe(getViewLifecycleOwner(), new a(new z1(this)));
    }

    public void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        b r0 = this.n;
        if (r0 == null) goto L5;
        ConversationListModel.a.f(r0);
    L5:
        this.n = null;
    }

    public void ea0(boolean r4) {
        if (this.n != null) goto L6;
        b r0 = new b(this);
        this.n = r0;
        ConversationListModel r1 = ConversationListModel.a;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.bmhome.chat.model.api.ConversationListener");
        r1.e(r0, r4);
        return;
    }

    public void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        ea0(false);
        fa0();
        ChatConversationList r0 = Y90();
        if (r0 == null) goto L5;
        r0.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        y6.f(r0, new a2(this), new b2(this), 0.1f, new c2(this), 49);
    L5:
        initData();
        ConversationAdapter r10 = this.j;
        Function2<? super wh8.a, ? super String, Unit> r11 = new d2(this);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "listener");
        r10.c = r11;
        ConversationAdapter r12 = this.j;
        Function2<? super View, ? super wh8.a, Unit> r13 = new e2(this);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "listener");
        r12.d = r13;
        ConversationAdapter r14 = this.j;
        Function3<? super View, ? super Case, ? super Integer, Unit> r15 = new k1(this);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "listener");
        r14.e = r15;
        ConversationAdapter r16 = this.j;
        Function2<? super Case, ? super Integer, Unit> r17 = new l1(this);
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "listener");
        r16.f = r17;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(null), 3, null);
    }
}
