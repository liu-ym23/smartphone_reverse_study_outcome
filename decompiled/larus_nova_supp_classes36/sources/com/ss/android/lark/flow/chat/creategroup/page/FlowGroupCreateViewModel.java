package com.ss.android.lark.flow.chat.creategroup.page;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.contact.entity.SelectedData;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.dto.GroupCreateInfo;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.message.lynxcard.message.r;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,J\u0010\u0010-\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,J\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020,0/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020201J\u001e\u00103\u001a\u00020'2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209J\u0010\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0010\u0010 \u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006>"}, d2 = {"Lcom/ss/android/lark/flow/chat/creategroup/page/FlowGroupCreateViewModel;", "Landroidx/lifecycle/ViewModel;", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "<init>", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "getChatAppContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "selectedMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/ss/android/lark/search/dto/info/SearchChatterInfo;", "getSelectedMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "selectedMap$delegate", "Lkotlin/Lazy;", "mustSelectedMap", "getMustSelectedMap", "mustSelectedMap$delegate", "groupCreateInfo", "Lcom/ss/android/lark/create/groupchat/dto/GroupCreateInfo;", "getGroupCreateInfo", "()Lcom/ss/android/lark/create/groupchat/dto/GroupCreateInfo;", "groupCreateInfo$delegate", "selectUserCountData", "Landroidx/lifecycle/MutableLiveData;", "", "getSelectUserCountData", "()Landroidx/lifecycle/MutableLiveData;", "enableConfirmBtn", "", "getEnableConfirmBtn", "groupCreateScene", "chatId", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "initData", "", "args", "Landroid/os/Bundle;", "selectUser", "searchBaseInfo", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "removeSelectedUser", "resetSelectedUser", "", LocationHitPoint$ResultType.LIST, "", "Lcom/ss/android/lark/contact/entity/SelectedData;", "createGroupFromPicker", "context", "Landroid/content/Context;", "fragment", "Landroidx/fragment/app/Fragment;", "callback", "Lcom/ss/android/lark/flow/chat/creategroup/page/ICreateGroupCallback;", "getCheckBoxBindStatus", "Lcom/ss/android/lark/picker/base/view/SearchResultView$CheckBoxBindStatus;", "data", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowGroupCreateViewModel extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    public static final String LOG_TAG = "FlowGroupCreateViewModel";
    private final v chatAppContainer;
    private String chatId;
    private final MutableLiveData<Boolean> enableConfirmBtn;
    private final Lazy groupCreateInfo$delegate;
    private String groupCreateScene;
    private final Lazy mustSelectedMap$delegate;
    private final MutableLiveData<Integer> selectUserCountData;
    private final Lazy selectedMap$delegate;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.creategroup.page.FlowGroupCreateViewModel$initData$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.flow.chat.creategroup.page.FlowGroupCreateViewModel$initData$2", f = "FlowGroupCreateViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03592 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FlowGroupCreateViewModel this$0;

        public C03592(FlowGroupCreateViewModel r1, Continuation<? super C03592> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03592(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L25;
            ResultKt.throwOnFailure(r3);
            if (Intrinsics.areEqual(FlowGroupCreateViewModel.access$getGroupCreateScene$p(this.this$0), "group_create_scene_p2p_chat") == false) goto L13;
            String r4 = this.this$0.getChatId();
            if (r4 == null) goto L13;
            FlowGroupCreateViewModel r0 = this.this$0;
            Chat r5 = ImSdkService.b().we(r4);
            if (r5 == null) goto L13;
            String r6 = r5.getP2pChatterId();
            if (r.a(r6) == false) goto L13;
            r0.getMustSelectedMap().put(r6, r6);
        L13:
            String r7 = this.this$0.getChatAppContainer().getUserId();
            if (r7 != null) goto L16;
        L19:
            boolean r1 = true;
        L20:
            if (r1 == true) goto L23;
            this.this$0.getMustSelectedMap().put(r7, r7);
        L23:
            return Unit.INSTANCE;
        L16:
            if (r7.length() == 0) goto L19;
            r1 = false;
            goto L20
        L25:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    private final GroupCreateInfo getGroupCreateInfo() {
        return (GroupCreateInfo) this.groupCreateInfo$delegate.getValue();
    }

    public final ConcurrentHashMap<String, String> getMustSelectedMap() {
        return (ConcurrentHashMap) this.mustSelectedMap$delegate.getValue();
    }

    public final ConcurrentHashMap<String, SearchChatterInfo> getSelectedMap() {
        return (ConcurrentHashMap) this.selectedMap$delegate.getValue();
    }

    public final v getChatAppContainer() {
        return this.chatAppContainer;
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final MutableLiveData<Boolean> getEnableConfirmBtn() {
        return this.enableConfirmBtn;
    }

    public final MutableLiveData<Integer> getSelectUserCountData() {
        return this.selectUserCountData;
    }

    public FlowGroupCreateViewModel(v r2) {
        Intrinsics.checkNotNullParameter(r2, "chatAppContainer");
        this.chatAppContainer = r2;
        this.selectedMap$delegate = LazyKt.lazy(FlowGroupCreateViewModel$selectedMap$2.INSTANCE);
        this.mustSelectedMap$delegate = LazyKt.lazy(FlowGroupCreateViewModel$mustSelectedMap$2.INSTANCE);
        this.groupCreateInfo$delegate = LazyKt.lazy(FlowGroupCreateViewModel$groupCreateInfo$2.INSTANCE);
        this.selectUserCountData = new MutableLiveData(0);
        this.enableConfirmBtn = new MutableLiveData(Boolean.FALSE);
    }

    public static final /* synthetic */ GroupCreateInfo access$getGroupCreateInfo(FlowGroupCreateViewModel r0) {
        return r0.getGroupCreateInfo();
    }

    public static final /* synthetic */ String access$getGroupCreateScene$p(FlowGroupCreateViewModel r0) {
        return r0.groupCreateScene;
    }

    public final SearchResultView.CheckBoxBindStatus getCheckBoxBindStatus(SearchBaseInfo r4) {
        String r0 = this.groupCreateScene;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L35;
        if (r4 == null) goto L35;
        String r2 = r4.getId();
        if (r2 != null) goto L14;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == true) goto L35;
        if ((r4 instanceof SearchChatterInfo) == false) goto L23;
        SearchChatterInfo r5 = (SearchChatterInfo) r4;
    L24:
        if (r5 != null) goto L26;
    L28:
        boolean r6 = false;
    L29:
        if (r6 == false) goto L33;
        return new SearchResultView.CheckBoxBindStatus(true, false, false);
    L33:
        return new SearchResultView.CheckBoxBindStatus(getMustSelectedMap().contains(r4.getId()), true, false);
    L26:
        if (r5.isResigned() != true) goto L28;
        r6 = true;
        goto L29
    L23:
        r5 = null;
        goto L24
    L14:
        if (r2.length() == 0) goto L17;
        r3 = false;
    L35:
        return new SearchResultView.CheckBoxBindStatus(false, false, false);
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void initData(Bundle r8) {
        if (r8 == null) goto L4;
        this.groupCreateScene = r8.getString("key_group_create_scene");
        this.chatId = r8.getString("key_group_create_chat_id");
        getGroupCreateInfo().setNeedBadge(r8.getBoolean("key_group_create_need_badge", true));
    L4:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03592(this, null), 2, null);
    }

    public final void removeSelectedUser(SearchBaseInfo r2) {
        if ((r2 instanceof SearchChatterInfo) == true) goto L5;
        return;
    L5:
        SearchChatterInfo r3 = (SearchChatterInfo) r2;
        String r0 = r3.getId();
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        return;
    L14:
        getSelectedMap().remove(r3.getId());
        this.selectUserCountData.postValue(Integer.valueOf(getSelectedMap().size()));
        return;
    L8:
        if (r0.length() == 0) goto L11;
        r1 = false;
        goto L12
    }

    public final List<SearchBaseInfo> resetSelectedUser(List<? extends SelectedData> r4) {
        Intrinsics.checkNotNullParameter(r4, LocationHitPoint$ResultType.LIST);
        int r0 = lab.a.a;
        ConcurrentHashMap<String, SearchChatterInfo> r1 = getSelectedMap();
        Intrinsics.checkNotNullParameter(r4, "dataList");
        Intrinsics.checkNotNullParameter(r1, "map");
        ArrayList r2 = new ArrayList();
        if (CollectionUtils.isEmpty(r4) == false) goto L5;
    L13:
        getSelectedMap().clear();
        Iterator r5 = r2.iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        SearchChatterInfo r3 = (SearchChatterInfo) r5.next();
        getSelectedMap().put(r3.getId(), r3);
        r3.selected(true);
        goto L15
    L17:
        this.selectUserCountData.postValue(Integer.valueOf(getSelectedMap().size()));
        return CollectionsKt.toMutableList(getSelectedMap().values());
    L5:
        if (CollectionUtils.isEmpty(r1) == true) goto L13;
        Iterator<? extends SelectedData> r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        SearchBaseInfo r7 = r1.get(r6.next().id);
        if (r7 == null) goto L9;
        r2.add(r7);
        goto L9
    }

    public final void selectUser(SearchBaseInfo r4) {
        if ((r4 instanceof SearchChatterInfo) == true) goto L5;
        return;
    L5:
        SearchChatterInfo r0 = (SearchChatterInfo) r4;
        String r1 = r0.getId();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(this.chatAppContainer.getUserId(), r0.getId()) == false) goto L17;
        return;
    L17:
        getSelectedMap().put(r0.getId(), r4);
        this.selectUserCountData.postValue(Integer.valueOf(getSelectedMap().size()));
        return;
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    public final void setChatId(String r1) {
        this.chatId = r1;
    }

    public final void createGroupFromPicker(final Context r12, Fragment r13, final j r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "fragment");
        Intrinsics.checkNotNullParameter(r14, "callback");
        List r0 = CollectionsKt.toList(getSelectedMap().values());
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = getMustSelectedMap().values().iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        String r3 = (String) r2.next();
        SearchChatterInfo r4 = new SearchChatterInfo();
        r4.setId(r3);
        r1.add(r4);
        goto L4
    L7:
        if (Intrinsics.areEqual(this.groupCreateScene, "group_create_scene_p2p_chat") == false) goto L10;
        ArrayList r6 = new ArrayList();
        r6.addAll(r0);
        r6.addAll(r1);
        int r5 = dgb.a.d;
        dgb.a.C0248a.a().b(r12, getGroupCreateInfo(), r6, new AnonymousClass1(r14, this), CreateGroupScene.P2P, new AnonymousClass2(this, r12), r13);
        return;
    L10:
        if (r0.size() != 1) goto L12;
        this.chatAppContainer.j0().getP2pChatCreatedByChatterId(((SearchChatterInfo) ListProtector.get(r0, 0)).getId(), new AnonymousClass3(this, r12, r14));
        return;
    L12:
        ArrayList r7 = new ArrayList();
        r7.addAll(r0);
        r7.addAll(r1);
        int r8 = dgb.a.d;
        dgb.a.C0248a.a().b(r12, getGroupCreateInfo(), r7, new AnonymousClass4(r14, this), CreateGroupScene.PLUS_MENU, new AnonymousClass5(this, r12), r13);
    }
}
