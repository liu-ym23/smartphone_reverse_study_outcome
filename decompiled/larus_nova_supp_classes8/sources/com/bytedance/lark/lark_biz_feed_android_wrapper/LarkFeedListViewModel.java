package com.bytedance.lark.lark_biz_feed_android_wrapper;

import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowError;
import com.bytedance.lark.lark_biz_feed_android.g0;
import com.bytedance.lark.lark_biz_feed_android.o;
import com.bytedance.lark.molten_livequery_wrapper.h;
import com.bytedance.lark.view_flow_wrapper.MoltenViewModel;
import com.bytedance.lark.view_flow_wrapper.i;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB*\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\bH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018JB\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001d0\u001b0\u001a\"\b\b\u0000\u0010\u001c*\u00020\u001e\"\b\b\u0001\u0010\u001d*\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001d0 H\u0016J(\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H!0\u001a\"\b\b\u0000\u0010!*\u00020\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#H\u0016R\u0014\u0010\u0010\u001a\u00020\u0002X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Lcom/bytedance/lark/lark_biz_feed_android_wrapper/LarkFeedListViewModel;", "Lcom/bytedance/lark/view_flow_wrapper/MoltenViewModel;", "Lcom/bytedance/lark/lark_biz_feed_android_wrapper/ILarkFeedListViewFlow;", "creator", "Lcom/bytedance/lark/lark_biz_feed_android_wrapper/ILarkFeedListViewFlow$ProviderCreator;", "context", "Lcom/bytedance/lark/lark_biz_feed_android/LarkFeedListContextWrapped;", "initialAction", "Lcom/bytedance/lark/lark_biz_feed_android/LarkFeedListAction;", "(Lcom/bytedance/lark/lark_biz_feed_android_wrapper/ILarkFeedListViewFlow$ProviderCreator;Lcom/bytedance/lark/lark_biz_feed_android/LarkFeedListContextWrapped;Lcom/bytedance/lark/lark_biz_feed_android/LarkFeedListAction;)V", "provider", "Lkotlin/Function1;", "Lcom/bytedance/lark/lark_biz_feed_android_wrapper/ILarkFeedListViewFlow$Companion;", "Lcom/bytedance/lark/lark_biz_feed_android_wrapper/ILarkFeedListViewFlow$Provider;", "Lkotlin/ExtensionFunctionType;", "(Lcom/bytedance/lark/lark_biz_feed_android/LarkFeedListAction;Lkotlin/jvm/functions/Function1;)V", "viewFlow", "getViewFlow", "()Lcom/bytedance/lark/lark_biz_feed_android_wrapper/ILarkFeedListViewFlow;", "action", "Lcom/bytedance/lark/view_flow_wrapper/Completable;", "Lcom/bytedance/lark/lark_biz_feed_android/ViewFlowError;", "key", "action-vFDjHp0", "(Lcom/bytedance/lark/lark_biz_feed_android/LarkFeedListAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subscribe", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/bytedance/lark/molten_livequery_wrapper/LiveList;", "Item", "KeyChange", "", "liveQueryType", "Lcom/bytedance/lark/lark_biz_feed_android_wrapper/ILarkFeedListViewFlow$ViewObjectType$LiveQuery;", "Inner", "objectType", "Lcom/bytedance/lark/lark_biz_feed_android_wrapper/ILarkFeedListViewFlow$ViewObjectType$Nullable;", "lark_biz_feed_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class LarkFeedListViewModel extends MoltenViewModel<ILarkFeedListViewFlow> implements ILarkFeedListViewFlow {
    private final ILarkFeedListViewFlow viewFlow;

    @Override // com.bytedance.lark.lark_biz_feed_android_wrapper.ILarkFeedListViewFlow
    /* JADX INFO: renamed from: action-vFDjHp0 */
    public Object mo1707actionvFDjHp0(o r1, Continuation<? super com.bytedance.lark.view_flow_wrapper.d<? extends ViewFlowError>> r2) {
        return m1709actionvFDjHp0$suspendImpl(this, r1, r2);
    }

    /* JADX INFO: renamed from: getViewFlow, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ i m1710getViewFlow() {
        return getViewFlow();
    }

    public ILarkFeedListViewFlow getViewFlow() {
        return this.viewFlow;
    }

    public <Inner> i1<Inner> subscribe(ILarkFeedListViewFlow.c.d<Inner> r2) {
        Intrinsics.checkNotNullParameter(r2, "objectType");
        i1<Inner> r3 = subscribe(r2);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<Inner of com.bytedance.lark.lark_biz_feed_android_wrapper.ILarkFeedListViewFlow.subscribe>");
        return r3;
    }

    @Override // com.bytedance.lark.lark_biz_feed_android_wrapper.ILarkFeedListViewFlow
    public <Item, KeyChange> i1<h<Item, KeyChange>> subscribe(ILarkFeedListViewFlow.c.C0374c<Item, KeyChange> r2) {
        Intrinsics.checkNotNullParameter(r2, "liveQueryType");
        return getViewFlow().subscribe(r2);
    }

    @Override // com.bytedance.lark.lark_biz_feed_android_wrapper.ILarkFeedListViewFlow
    public <Inner> i1<Inner> subscribe(ILarkFeedListViewFlow.c.e<Inner> r2) {
        Intrinsics.checkNotNullParameter(r2, "objectType");
        return getViewFlow().subscribe(r2);
    }

    public LarkFeedListViewModel(o r7, Function1<? super ILarkFeedListViewFlow.Companion, ILarkFeedListViewFlow.a> r8) {
        Intrinsics.checkNotNullParameter(r8, "provider");
        ILarkFeedListViewFlow r9 = (ILarkFeedListViewFlow) ((i) ((ILarkFeedListViewFlow.a) r8.invoke(ILarkFeedListViewFlow.w1)).a.invoke());
        if (r7 == null) goto L5;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new LarkFeedListViewModel$viewFlow$1$1$1(this, r7, null), 3, null);
    L5:
        this.viewFlow = r9;
    }

    public LarkFeedListViewModel(final ILarkFeedListViewFlow.b r2, final g0 r3, o r4) {
        Intrinsics.checkNotNullParameter(r2, "creator");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r4, new AnonymousClass1(r2, r3));
    }

    /* JADX INFO: renamed from: action-vFDjHp0$suspendImpl, reason: not valid java name */
    public static /* synthetic */ Object m1709actionvFDjHp0$suspendImpl(LarkFeedListViewModel r4, o r5, Continuation<? super com.bytedance.lark.view_flow_wrapper.d<? extends ViewFlowError>> r6) {
        if ((r6 instanceof LarkFeedListViewModel$action$1) == false) goto L7;
        LarkFeedListViewModel$action$1 r0 = (LarkFeedListViewModel$action$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
        return ((com.bytedance.lark.view_flow_wrapper.d) r7).a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        ILarkFeedListViewFlow r8 = r4.getViewFlow();
        r0.label = 1;
        Object r9 = r8.mo1707actionvFDjHp0(r5, r0);
        if (r9 != r2) goto L18;
        return r2;
    L18:
        return r9;
    L7:
        r0 = new LarkFeedListViewModel$action$1(r4, r6);
        goto L8
    }

    public /* synthetic */ LarkFeedListViewModel(o r1, Function1 r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1, r2);
    }

    public /* synthetic */ LarkFeedListViewModel(ILarkFeedListViewFlow.b r1, g0 r2, o r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
