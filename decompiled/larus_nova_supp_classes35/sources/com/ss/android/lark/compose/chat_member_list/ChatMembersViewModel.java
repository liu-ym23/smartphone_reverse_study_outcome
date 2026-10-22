package com.ss.android.lark.compose.chat_member_list;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lark.kmp.pb.basic.v1.Chat;
import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.basic.v1.Entity;
import com.lark.kmp.pb.basic.v1.LarkError;
import com.lark.kmp.pb.im.v1.GetChatChattersRequest;
import com.lark.kmp.pb.im.v1.GetChatChattersResponse;
import com.lark.kmp.pb.im.v1.MGetChatsRequest;
import com.lark.kmp.pb.im.v1.MGetChatsResponse;
import com.lark.kmp.pb.im.v1.PushChatChattersResponse;
import com.lark.kmp.rustclient.api.model.RustClientException;
import com.lark.kmp.rustclient.api.model.RustOutputKt$errorAsException$;
import com.lark.kmp.rustclient.api.model.i;
import com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepository;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 W2\u00020\u0001:\u0004TUVWB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\u001eH\u0002J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'H\u0002J$\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0017\u0010-\u001a\u00020\u001e2\n\u0010.\u001a\u00060/j\u0002`0¢\u0006\u0002\u00101J\u0017\u00102\u001a\u00020\u001e2\n\u0010.\u001a\u00060/j\u0002`0¢\u0006\u0002\u00101J\u0006\u00103\u001a\u00020\u001eJ\u000e\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0003J\u0006\u00106\u001a\u00020\u001eJ\u0010\u00107\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0003H\u0002J\b\u00108\u001a\u00020\u001eH\u0002J@\u00109\u001a\b\u0012\u0004\u0012\u00020;0:2\u0006\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\b\u0010B\u001a\u0004\u0018\u00010\u00032\u0006\u0010C\u001a\u00020\u0003H\u0002J\u0018\u0010D\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u00032\u0006\u0010E\u001a\u00020FH\u0002J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00020'0:H\u0002J\u000e\u0010H\u001a\b\u0012\u0004\u0012\u00020'0:H\u0002J2\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\b\u0010B\u001a\u0004\u0018\u00010\u00032\u0006\u0010C\u001a\u00020\u0003H\u0002J\u0016\u0010K\u001a\b\u0012\u0004\u0012\u00020L0)2\u0006\u0010M\u001a\u00020NH\u0002J\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020P0)2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020P0)H\u0002J\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020P0)2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020P0)H\u0002J\f\u0010S\u001a\u00020**\u00020NH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/ss/android/lark/compose/chat_member_list/ChatMembersViewModel;", "Landroidx/lifecycle/ViewModel;", "chatId", BuildConfig.FLAVOR, "rustClient", "Lcom/lark/kmp/rustclient/api/IRustClient;", "platformEffects", "Lcom/ss/android/lark/compose/chatsetting/common/platform/ChatSettingPlatformEffects;", "userId", "<init>", "(Ljava/lang/String;Lcom/lark/kmp/rustclient/api/IRustClient;Lcom/ss/android/lark/compose/chatsetting/common/platform/ChatSettingPlatformEffects;Ljava/lang/String;)V", "repository", "Lcom/ss/android/lark/compose/chatsetting/common/repository/ChatSettingRepository;", "uiFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ss/android/lark/compose/chat_member_list/ChatMembersUiState;", "membersUiState", "Lkotlinx/coroutines/flow/StateFlow;", "getMembersUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "owner", "Lcom/ss/android/lark/compose/chat_member_list/ChatMembersViewModel$Owner;", "memberRequestGeneration", BuildConfig.FLAVOR, "firstPageJob", "Lkotlinx/coroutines/Job;", "loadMoreJob", "memberRequestId", "searchLogSession", "logMemberSearch", BuildConfig.FLAVOR, "event", "detail", "fetchChatInfo", "subscribeChatPush", "subscribeChatChattersPush", "subscribeChatterPush", "updateChatPermissionState", "pbChat", "Lcom/lark/kmp/pb/basic/v1/Chat;", "updateOwnerTagInMembers", BuildConfig.FLAVOR, "Lcom/ss/android/lark/compose/chatterselector/ChatterSelectorChatter;", "members", "ownerId", "routeToAddMember", "context", "Landroid/content/Context;", "Lcom/ss/android/lark/compose/chatsetting/common/router/PlatformContext;", "(Landroid/content/Context;)V", "routeToRemoveMember", "refresh", "updateQuery", "query", "loadNextPage", "loadFirstPage", "loadMorePage", "fetchChatChattersFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/ss/android/lark/compose/chat_member_list/ChatMembersViewModel$ChatChattersPage;", "requestGeneration", "fromServer", BuildConfig.FLAVOR, "limit", BuildConfig.FLAVOR, "offset", "cursor", "filter", "logMemberSearchError", Keys.API_RETURN_KEY_ERROR, BuildConfig.FLAVOR, "fetchChatFlow", "observeChatPushFlow", "buildGetChatChattersRequest", "Lcom/lark/kmp/pb/im/v1/GetChatChattersRequest$Builder;", "parseUDTagParams", "Lcom/ss/android/lark/compose/chatterselector/UDTagParams;", "pbChatter", "Lcom/lark/kmp/pb/basic/v1/Chatter;", "filterAndSortTags", "Lcom/ss/android/lark/compose/chat_member_list/ChatMembersViewModel$BizTag;", "tags", "filterTags", "toSelectorChatter", "Owner", "ChatChattersPage", "BizTag", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ChatMembersViewModel extends ViewModel {
    public static final int $stable = 0;
    private static final b Companion = null;
    private static final List<BizTag> EXCLUSIVE_TAGS = null;
    public static final int LOCAL_LIMIT = 50;
    private static final List<Set<BizTag>> MUTEX_TAGS = null;
    public static final int NET_PAGE_SIZE = 50;
    private final String chatId;
    private Job firstPageJob;
    private Job loadMoreJob;
    private long memberRequestGeneration;
    private long memberRequestId;
    private final i1<com.ss.android.lark.compose.chat_member_list.d> membersUiState;
    private c owner;
    private final com.ss.android.lark.compose.chatsetting.common.platform.b platformEffects;
    private final ChatSettingRepository repository;
    private final com.lark.kmp.rustclient.api.d rustClient;
    private final String searchLogSession;
    private final z0<com.ss.android.lark.compose.chat_member_list.d> uiFlow;
    private final String userId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/compose/chat_member_list/ChatMembersViewModel$BizTag;", BuildConfig.FLAVOR, "order", BuildConfig.FLAVOR, "model", "Lcom/ss/android/lark/compose/chatterselector/UDTagParams;", "<init>", "(Ljava/lang/String;IILcom/ss/android/lark/compose/chatterselector/UDTagParams;)V", "getOrder", "()I", "getModel", "()Lcom/ss/android/lark/compose/chatterselector/UDTagParams;", "SPECIAL_FOCUS", "FROZEN", "UNREGISTERED", "GROUP_OWNER", "GROUP_MANAGER", "ROBOT", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BizTag extends Enum<BizTag> {
        public static final BizTag FROZEN = null;
        public static final BizTag GROUP_MANAGER = null;
        public static final BizTag GROUP_OWNER = null;
        public static final BizTag ROBOT = null;
        public static final BizTag SPECIAL_FOCUS = null;
        public static final BizTag UNREGISTERED = null;
        public static final /* synthetic */ BizTag[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final com.ss.android.lark.compose.chatterselector.d model;
        private final int order;

        public static EnumEntries<BizTag> getEntries() {
            return b;
        }

        static {
            BizTag r0 = new BizTag("SPECIAL_FOCUS", 0, -1, new com.ss.android.lark.compose.chatterselector.d("特别关注", 6));
            SPECIAL_FOCUS = r0;
            BizTag r1 = new BizTag("FROZEN", 1, 0, new com.ss.android.lark.compose.chatterselector.d("已停用", 6));
            FROZEN = r1;
            BizTag r2 = new BizTag("UNREGISTERED", 2, 0, new com.ss.android.lark.compose.chatterselector.d("未注册", 6));
            UNREGISTERED = r2;
            BizTag r4 = new BizTag("GROUP_OWNER", 3, 50, new com.ss.android.lark.compose.chatterselector.d("群主", 6));
            GROUP_OWNER = r4;
            BizTag r7 = new BizTag("GROUP_MANAGER", 4, 50, new com.ss.android.lark.compose.chatterselector.d("管理员", 6));
            GROUP_MANAGER = r7;
            BizTag r9 = new BizTag("ROBOT", 5, 50, new com.ss.android.lark.compose.chatterselector.d("机器人", 6));
            ROBOT = r9;
            BizTag[] r3 = {r0, r1, r2, r4, r7, r9};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static BizTag[] values() {
            return (BizTag[]) a.clone();
        }

        public final com.ss.android.lark.compose.chatterselector.d getModel() {
            return this.model;
        }

        public final int getOrder() {
            return this.order;
        }

        public static BizTag valueOf(String r1) {
            return (BizTag) r27.a.a(BizTag.class, r1);
        }

        public BizTag(String r1, int r2, int r3, com.ss.android.lark.compose.chatterselector.d r4) {
            super(r1, r2);
            this.order = r3;
            this.model = r4;
        }
    }

    public static final class a {
        public final List<com.ss.android.lark.compose.chatterselector.a> a;
        public final String b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            if (this.c == false) goto L9;
            int r4 = 1231;
        L11:
            return r3 + r4;
        L9:
            r4 = 1237;
            goto L11
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ChatChattersPage(members=" + this.a + ", cursor=" + this.b + ", hasMore=" + this.c + ')';
        }

        public a(List<com.ss.android.lark.compose.chatterselector.a> r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "members");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Owner(id=" + this.a + ')';
        }

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "id");
            this.a = r2;
        }
    }

    public static final class d<T> implements Comparator {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((BizTag) r1).getOrder()), Integer.valueOf(((BizTag) r2).getOrder()));
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$fetchChatChattersFlow$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/ss/android/lark/compose/chat_member_list/ChatMembersViewModel$ChatChattersPage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$fetchChatChattersFlow$2", f = "ChatMembersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<FlowCollector<? super a>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $context;
        int label;
        final /* synthetic */ ChatMembersViewModel this$0;

        public AnonymousClass2(ChatMembersViewModel r1, String r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$context = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$context, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((FlowCollector) r1, (Continuation) r2);
        }

        public final Object invoke(FlowCollector<? super a> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            ChatMembersViewModel.access$logMemberSearch(this.this$0, "request", this.$context);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$fetchChatChattersFlow$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/ss/android/lark/compose/chat_member_list/ChatMembersViewModel$ChatChattersPage;", Keys.API_RETURN_KEY_ERROR, BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$fetchChatChattersFlow$3", f = "ChatMembersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super a>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $context;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChatMembersViewModel this$0;

        public AnonymousClass3(ChatMembersViewModel r1, String r2, Continuation<? super AnonymousClass3> r3) {
            this.this$0 = r1;
            this.$context = r2;
            super(3, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((FlowCollector) r1, (Throwable) r2, (Continuation) r3);
        }

        public final Object invoke(FlowCollector<? super a> r3, Throwable r4, Continuation<? super Unit> r5) {
            AnonymousClass3 r6 = new AnonymousClass3(this.this$0, this.$context, r5);
            r6.L$0 = r4;
            return r6.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r3);
            Throwable r4 = (Throwable) this.L$0;
            if (r4 != null) goto L7;
            ChatMembersViewModel.access$logMemberSearch(this.this$0, "request_done", this.$context);
        L9:
            return Unit.INSTANCE;
        L7:
            ChatMembersViewModel.access$logMemberSearchError(this.this$0, this.$context, r4);
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$fetchChatInfo$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$fetchChatInfo$1", f = "ChatMembersViewModel.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatMembersViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$fetchChatInfo$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "pbChat", "Lcom/lark/kmp/pb/basic/v1/Chat;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$fetchChatInfo$1$1", f = "ChatMembersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01221 extends SuspendLambda implements Function2<Chat, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ChatMembersViewModel this$0;

            public C01221(ChatMembersViewModel r1, Continuation<? super C01221> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                C01221 r0 = new C01221(this.this$0, r4);
                r0.L$0 = r3;
                return r0;
            }

            public final Object invoke(Chat r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((Chat) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                Chat r3 = (Chat) this.L$0;
                ChatMembersViewModel.access$updateChatPermissionState(this.this$0, r3);
                ChatMembersViewModel.access$getPlatformEffects$p(this.this$0).h(r3);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$fetchChatInfo$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_ERROR, BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$fetchChatInfo$1$2", f = "ChatMembersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<Throwable, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ChatMembersViewModel this$0;

            public AnonymousClass2(ChatMembersViewModel r1, Continuation<? super AnonymousClass2> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r4);
                r0.L$0 = r3;
                return r0;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((Throwable) r1, (Continuation) r2);
            }

            public final Object invoke(Throwable r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r3);
                Throwable r4 = (Throwable) this.L$0;
                ChatMembersViewModel.access$logMemberSearchError(this.this$0, "chat_info", r4);
                if ((r4 instanceof CancellationException) == false) goto L9;
                return Unit.INSTANCE;
            L9:
                return Unit.INSTANCE;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(ChatMembersViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            Flow r8 = ChatMembersViewModel.access$fetchChatFlow(this.this$0);
            C01221 r2 = new C01221(this.this$0, null);
            AnonymousClass2 r3 = new AnonymousClass2(this.this$0, null);
            this.label = 1;
            if (f.a(r8, r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$loadFirstPage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$loadFirstPage$1", f = "ChatMembersViewModel.kt", i = {}, l = {360, 391}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        final /* synthetic */ long $requestGeneration;
        int label;
        final /* synthetic */ ChatMembersViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$loadFirstPage$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "local", "Lcom/ss/android/lark/compose/chat_member_list/ChatMembersViewModel$ChatChattersPage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$loadFirstPage$1$2", f = "ChatMembersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<a, Continuation<? super Unit>, Object> {
            final /* synthetic */ long $requestGeneration;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ChatMembersViewModel this$0;

            public AnonymousClass2(ChatMembersViewModel r1, long r2, Continuation<? super AnonymousClass2> r4) {
                this.this$0 = r1;
                this.$requestGeneration = r2;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
                AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$requestGeneration, r6);
                r0.L$0 = r5;
                return r0;
            }

            public final Object invoke(a r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((a) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r15) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L20;
                ResultKt.throwOnFailure(r15);
                a r16 = (a) this.L$0;
                ChatMembersViewModel r0 = this.this$0;
                StringBuilder r1 = new StringBuilder("generation=");
                r1.append(this.$requestGeneration);
                r1.append(" current=");
                r1.append(ChatMembersViewModel.access$getMemberRequestGeneration$p(this.this$0));
                r1.append(" members=");
                r1.append(r16.a.size());
                r1.append(" apply=");
                if (this.$requestGeneration == ChatMembersViewModel.access$getMemberRequestGeneration$p(this.this$0)) goto L7;
            L9:
                boolean r2 = false;
            L10:
                r1.append(r2);
                ChatMembersViewModel.access$logMemberSearch(r0, "local_result", r1.toString());
                if (this.$requestGeneration != ChatMembersViewModel.access$getMemberRequestGeneration$p(this.this$0)) goto L18;
                if ((!r16.a.isEmpty()) == false) goto L18;
                z0 r3 = ChatMembersViewModel.access$getUiFlow$p(this.this$0);
            L15:
                Object r4 = r3.getValue();
                if (r3.compareAndSet(r4, com.ss.android.lark.compose.chat_member_list.d.a((com.ss.android.lark.compose.chat_member_list.d) r4, null, r16.a, false, false, r16.c, r16.b, false, 0, false, false, 973)) == false) goto L15;
            L18:
                return Unit.INSTANCE;
            L7:
                if ((!r16.a.isEmpty()) == false) goto L9;
                r2 = true;
                goto L10
            L20:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$loadFirstPage$1$3, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$loadFirstPage$1$3", f = "ChatMembersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<Throwable, Continuation<? super Unit>, Object> {
            int label;

            public AnonymousClass3(Continuation<? super AnonymousClass3> r2) {
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
                return new AnonymousClass3(r2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((Throwable) r1, (Continuation) r2);
            }

            public final Object invoke(Throwable r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$loadFirstPage$1$4, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "net", "Lcom/ss/android/lark/compose/chat_member_list/ChatMembersViewModel$ChatChattersPage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$loadFirstPage$1$4", f = "ChatMembersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass4 extends SuspendLambda implements Function2<a, Continuation<? super Unit>, Object> {
            final /* synthetic */ long $requestGeneration;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ChatMembersViewModel this$0;

            public AnonymousClass4(ChatMembersViewModel r1, long r2, Continuation<? super AnonymousClass4> r4) {
                this.this$0 = r1;
                this.$requestGeneration = r2;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
                AnonymousClass4 r0 = new AnonymousClass4(this.this$0, this.$requestGeneration, r6);
                r0.L$0 = r5;
                return r0;
            }

            public final Object invoke(a r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((a) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r15) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L16;
                ResultKt.throwOnFailure(r15);
                a r16 = (a) this.L$0;
                ChatMembersViewModel r0 = this.this$0;
                StringBuilder r1 = new StringBuilder("generation=");
                r1.append(this.$requestGeneration);
                r1.append(" current=");
                r1.append(ChatMembersViewModel.access$getMemberRequestGeneration$p(this.this$0));
                r1.append(" members=");
                r1.append(r16.a.size());
                r1.append(" hasMore=");
                r1.append(r16.c);
                r1.append(" apply=");
                if (this.$requestGeneration != ChatMembersViewModel.access$getMemberRequestGeneration$p(this.this$0)) goto L7;
                boolean r2 = true;
            L8:
                r1.append(r2);
                ChatMembersViewModel.access$logMemberSearch(r0, "network_result", r1.toString());
                if (this.$requestGeneration != ChatMembersViewModel.access$getMemberRequestGeneration$p(this.this$0)) goto L14;
                z0 r3 = ChatMembersViewModel.access$getUiFlow$p(this.this$0);
            L11:
                Object r4 = r3.getValue();
                List<com.ss.android.lark.compose.chatterselector.a> r5 = r16.a;
                String r8 = r16.b;
                if (r3.compareAndSet(r4, com.ss.android.lark.compose.chat_member_list.d.a((com.ss.android.lark.compose.chat_member_list.d) r4, null, r5, false, false, r16.c, r8, false, 0, false, false, 973)) == false) goto L11;
            L14:
                return Unit.INSTANCE;
            L7:
                r2 = false;
                goto L8
            L16:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$loadFirstPage$1$5, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_ERROR, BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$loadFirstPage$1$5", f = "ChatMembersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass5 extends SuspendLambda implements Function2<Throwable, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;

            public AnonymousClass5(Continuation<? super AnonymousClass5> r2) {
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                AnonymousClass5 r0 = new AnonymousClass5(r3);
                r0.L$0 = r2;
                return r0;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((Throwable) r1, (Continuation) r2);
            }

            public final Object invoke(Throwable r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r2);
                if ((((Throwable) this.L$0) instanceof CancellationException) == false) goto L9;
                return Unit.INSTANCE;
            L9:
                return Unit.INSTANCE;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C03781(ChatMembersViewModel r1, long r2, String r4, Continuation<? super C03781> r5) {
            this.this$0 = r1;
            this.$requestGeneration = r2;
            this.$query = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C03781(this.this$0, this.$requestGeneration, this.$query, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r20) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            ResultKt.throwOnFailure(r20);
        L20:
            if (this.$requestGeneration != ChatMembersViewModel.access$getMemberRequestGeneration$p(this.this$0)) goto L26;
            z0 r3 = ChatMembersViewModel.access$getUiFlow$p(this.this$0);
        L22:
            Object r4 = r3.getValue();
            if (r3.compareAndSet(r4, com.ss.android.lark.compose.chat_member_list.d.a((com.ss.android.lark.compose.chat_member_list.d) r4, null, null, false, false, false, null, false, 0, false, false, 1019)) == false) goto L22;
            ChatMembersViewModel.access$logMemberSearch(this.this$0, "first_page_done", "generation=" + this.$requestGeneration + " members=" + ((com.ss.android.lark.compose.chat_member_list.d) ChatMembersViewModel.access$getUiFlow$p(this.this$0).getValue()).b.size() + " hasMore=" + ((com.ss.android.lark.compose.chat_member_list.d) ChatMembersViewModel.access$getUiFlow$p(this.this$0).getValue()).e);
        L26:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r20);
        L16:
            Flow r5 = ChatMembersViewModel.access$fetchChatChattersFlow(this.this$0, this.$requestGeneration, true, 50, 0, null, this.$query);
            AnonymousClass4 r6 = new AnonymousClass4(this.this$0, this.$requestGeneration, null);
            AnonymousClass5 r7 = new AnonymousClass5(null);
            this.label = 2;
            if (f.a(r5, r6, r7, this) != r1) goto L20;
            return r1;
        L10:
            ResultKt.throwOnFailure(r20);
            z0 r8 = ChatMembersViewModel.access$getUiFlow$p(this.this$0);
        L11:
            Object r9 = r8.getValue();
            if (r8.compareAndSet(r9, com.ss.android.lark.compose.chat_member_list.d.a((com.ss.android.lark.compose.chat_member_list.d) r9, null, CollectionsKt.emptyList(), true, false, true, null, false, 0, false, false, 961)) == false) goto L11;
            Flow r10 = ChatMembersViewModel.access$fetchChatChattersFlow(this.this$0, this.$requestGeneration, false, 50, 0, null, this.$query);
            AnonymousClass2 r11 = new AnonymousClass2(this.this$0, this.$requestGeneration, null);
            AnonymousClass3 r12 = new AnonymousClass3(null);
            this.label = 1;
            if (f.a(r10, r11, r12, this) != r1) goto L16;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$loadMorePage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$loadMorePage$1", f = "ChatMembersViewModel.kt", i = {}, l = {434}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $requestGeneration;
        final /* synthetic */ com.ss.android.lark.compose.chat_member_list.d $snapshot;
        int label;
        final /* synthetic */ ChatMembersViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$loadMorePage$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "page", "Lcom/ss/android/lark/compose/chat_member_list/ChatMembersViewModel$ChatChattersPage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$loadMorePage$1$2", f = "ChatMembersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<a, Continuation<? super Unit>, Object> {
            final /* synthetic */ long $requestGeneration;
            final /* synthetic */ com.ss.android.lark.compose.chat_member_list.d $snapshot;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ChatMembersViewModel this$0;

            public AnonymousClass2(ChatMembersViewModel r1, long r2, com.ss.android.lark.compose.chat_member_list.d r4, Continuation<? super AnonymousClass2> r5) {
                this.this$0 = r1;
                this.$requestGeneration = r2;
                this.$snapshot = r4;
                super(2, r5);
            }

            public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
                AnonymousClass2 r6 = new AnonymousClass2(this.this$0, this.$requestGeneration, this.$snapshot, r9);
                r6.L$0 = r8;
                return r6;
            }

            public final Object invoke(a r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((a) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r15) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L16;
                ResultKt.throwOnFailure(r15);
                a r16 = (a) this.L$0;
                ChatMembersViewModel r0 = this.this$0;
                StringBuilder r1 = new StringBuilder("generation=");
                r1.append(this.$requestGeneration);
                r1.append(" current=");
                r1.append(ChatMembersViewModel.access$getMemberRequestGeneration$p(this.this$0));
                r1.append(" offset=");
                r1.append(this.$snapshot.b.size());
                r1.append(" members=");
                r1.append(r16.a.size());
                r1.append(" hasMore=");
                r1.append(r16.c);
                r1.append(" apply=");
                if (this.$requestGeneration != ChatMembersViewModel.access$getMemberRequestGeneration$p(this.this$0)) goto L7;
                boolean r2 = true;
            L8:
                r1.append(r2);
                ChatMembersViewModel.access$logMemberSearch(r0, "page_result", r1.toString());
                if (this.$requestGeneration != ChatMembersViewModel.access$getMemberRequestGeneration$p(this.this$0)) goto L14;
                z0 r3 = ChatMembersViewModel.access$getUiFlow$p(this.this$0);
            L11:
                Object r4 = r3.getValue();
                com.ss.android.lark.compose.chat_member_list.d r5 = (com.ss.android.lark.compose.chat_member_list.d) r4;
                List r6 = CollectionsKt.plus(r5.b, r16.a);
                String r8 = r16.b;
                if (r3.compareAndSet(r4, com.ss.android.lark.compose.chat_member_list.d.a(r5, null, r6, false, false, r16.c, r8, false, 0, false, false, 973)) == false) goto L11;
            L14:
                return Unit.INSTANCE;
            L7:
                r2 = false;
                goto L8
            L16:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$loadMorePage$1$3, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_ERROR, BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$loadMorePage$1$3", f = "ChatMembersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<Throwable, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;

            public AnonymousClass3(Continuation<? super AnonymousClass3> r2) {
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                AnonymousClass3 r0 = new AnonymousClass3(r3);
                r0.L$0 = r2;
                return r0;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((Throwable) r1, (Continuation) r2);
            }

            public final Object invoke(Throwable r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r2);
                if ((((Throwable) this.L$0) instanceof CancellationException) == false) goto L9;
                return Unit.INSTANCE;
            L9:
                return Unit.INSTANCE;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C03791(ChatMembersViewModel r1, long r2, com.ss.android.lark.compose.chat_member_list.d r4, Continuation<? super C03791> r5) {
            this.this$0 = r1;
            this.$requestGeneration = r2;
            this.$snapshot = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C03791(this.this$0, this.$requestGeneration, this.$snapshot, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r18);
        L15:
            if (this.$requestGeneration != ChatMembersViewModel.access$getMemberRequestGeneration$p(this.this$0)) goto L21;
            z0 r3 = ChatMembersViewModel.access$getUiFlow$p(this.this$0);
        L17:
            Object r4 = r3.getValue();
            if (r3.compareAndSet(r4, com.ss.android.lark.compose.chat_member_list.d.a((com.ss.android.lark.compose.chat_member_list.d) r4, null, null, false, false, false, null, false, 0, false, false, 1015)) == false) goto L17;
            ChatMembersViewModel.access$logMemberSearch(this.this$0, "page_done", "generation=" + this.$requestGeneration + " members=" + ((com.ss.android.lark.compose.chat_member_list.d) ChatMembersViewModel.access$getUiFlow$p(this.this$0).getValue()).b.size() + " hasMore=" + ((com.ss.android.lark.compose.chat_member_list.d) ChatMembersViewModel.access$getUiFlow$p(this.this$0).getValue()).e);
        L21:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r18);
            z0 r5 = ChatMembersViewModel.access$getUiFlow$p(this.this$0);
        L9:
            Object r6 = r5.getValue();
            if (r5.compareAndSet(r6, com.ss.android.lark.compose.chat_member_list.d.a((com.ss.android.lark.compose.chat_member_list.d) r6, null, null, false, true, false, null, false, 0, false, false, 1015)) == false) goto L9;
            ChatMembersViewModel r7 = this.this$0;
            long r8 = this.$requestGeneration;
            int r10 = this.$snapshot.b.size();
            com.ss.android.lark.compose.chat_member_list.d r9 = this.$snapshot;
            Flow r11 = ChatMembersViewModel.access$fetchChatChattersFlow(r7, r8, true, 50, r10, r9.f, r9.a);
            AnonymousClass2 r12 = new AnonymousClass2(this.this$0, this.$requestGeneration, this.$snapshot, null);
            AnonymousClass3 r13 = new AnonymousClass3(null);
            this.label = 1;
            if (f.a(r11, r12, r13, this) != r1) goto L15;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$subscribeChatChattersPush$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$subscribeChatChattersPush$1", f = "ChatMembersViewModel.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatMembersViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$subscribeChatChattersPush$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ChatMembersViewModel a;

            /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$subscribeChatChattersPush$1$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0123a {
                public static final /* synthetic */ int[] a = null;

                static {
                    int[] r0 = new int[PushChatChattersResponse.Type.values().length];
                    r0[PushChatChattersResponse.Type.ADD_CHATTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
                L13:
                    r0[PushChatChattersResponse.Type.DELETE_CHATTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
                L19:
                    r0[PushChatChattersResponse.Type.DELETE_ME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
                L15:
                    r0[PushChatChattersResponse.Type.UPDATE_CHATTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
                L7:
                    a = r0;
                }
            }

            public a(ChatMembersViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r20, Continuation r21) {
                PushChatChattersResponse r1 = (PushChatChattersResponse) r20;
                Entity r2 = r1.getEntity();
                if (r2 == null) goto L83;
                Map r3 = r2.getChat_chatters();
                if (r3 == null) goto L83;
                Entity.ChatChatter r4 = (Entity.ChatChatter) r3.get(ChatMembersViewModel.access$getChatId$p(this.a));
                if (r4 == null) goto L83;
                Map r5 = r4.getChatters();
                if (r5 == null) goto L83;
                ChatMembersViewModel.access$logMemberSearch(this.a, "member_push", "generation=" + ChatMembersViewModel.access$getMemberRequestGeneration$p(this.a) + " type=" + r1.getType() + " incoming=" + r5.size() + " before=" + ((com.ss.android.lark.compose.chat_member_list.d) ChatMembersViewModel.access$getUiFlow$p(this.a).getValue()).b.size() + " queryLength=" + ((com.ss.android.lark.compose.chat_member_list.d) ChatMembersViewModel.access$getUiFlow$p(this.a).getValue()).a.length());
                int r6 = C0123a.a[r1.getType().ordinal()];
                if (r6 != 1) goto L14;
                z0 r7 = ChatMembersViewModel.access$getUiFlow$p(this.a);
                ChatMembersViewModel r8 = this.a;
            L54:
                Object r9 = r7.getValue();
                com.ss.android.lark.compose.chat_member_list.d r10 = (com.ss.android.lark.compose.chat_member_list.d) r9;
                List<com.ss.android.lark.compose.chatterselector.a> r11 = r10.b;
                if (r11.isEmpty() == false) goto L61;
                Collection r12 = r5.values();
                ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
                Iterator<T> r14 = r12.iterator();
            L58:
                if (r14.hasNext() == false) goto L60;
                r13.add(ChatMembersViewModel.access$toSelectorChatter(r8, (Chatter) r14.next()));
                goto L58
            L60:
                r10 = com.ss.android.lark.compose.chat_member_list.d.a(r10, null, r13, false, false, false, null, false, 0, false, false, 1021);
            L80:
                if (r7.compareAndSet(r9, r10) == false) goto L54;
            L81:
                ChatMembersViewModel.access$logMemberSearch(this.a, "member_push_applied", "members=" + ((com.ss.android.lark.compose.chat_member_list.d) ChatMembersViewModel.access$getUiFlow$p(this.a).getValue()).b.size());
                return Unit.INSTANCE;
            L61:
                List<com.ss.android.lark.compose.chatterselector.a> r15 = r11;
                ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
                Iterator<T> r17 = r15.iterator();
            L63:
                if (r17.hasNext() == false) goto L65;
                r16.add(((com.ss.android.lark.compose.chatterselector.a) r17.next()).a);
                goto L63
            L65:
                Set r18 = CollectionsKt.toSet(r16);
                Collection r19 = r5.values();
                ArrayList r110 = new ArrayList();
                Iterator<T> r22 = r19.iterator();
            L67:
                if (r22.hasNext() == false) goto L71;
                T r111 = r22.next();
                if (r18.contains(((Chatter) r111).getId()) == true) goto L67;
                r110.add(r111);
                goto L67
            L71:
                ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
                Iterator r24 = r110.iterator();
            L73:
                if (r24.hasNext() == false) goto L76;
                r23.add(ChatMembersViewModel.access$toSelectorChatter(r8, (Chatter) r24.next()));
                goto L73
            L76:
                if (r23.isEmpty() == true) goto L80;
                r10 = com.ss.android.lark.compose.chat_member_list.d.a(r10, null, CollectionsKt.plus(r11, r23), false, false, false, null, false, 0, false, false, 1021);
                goto L80
            L14:
                if (r6 != 2) goto L16;
                z0 r25 = ChatMembersViewModel.access$getUiFlow$p(this.a);
            L40:
                Object r26 = r25.getValue();
                com.ss.android.lark.compose.chat_member_list.d r27 = (com.ss.android.lark.compose.chat_member_list.d) r26;
                Set r28 = r5.keySet();
                if (r28.isEmpty() == true) goto L51;
                List<com.ss.android.lark.compose.chatterselector.a> r29 = r27.b;
                ArrayList r30 = new ArrayList();
                Iterator<T> r31 = r29.iterator();
            L45:
                if (r31.hasNext() == false) goto L49;
                T r32 = r31.next();
                if (r28.contains(((com.ss.android.lark.compose.chatterselector.a) r32).a) == true) goto L45;
                r30.add(r32);
                goto L45
            L49:
                r27 = com.ss.android.lark.compose.chat_member_list.d.a(r27, null, r30, false, false, false, null, false, 0, false, false, 1021);
            L51:
                if (r25.compareAndSet(r26, r27) == false) goto L40;
            L16:
                if (r6 == 3) goto L81;
                if (r6 != 4) goto L38;
                z0 r33 = ChatMembersViewModel.access$getUiFlow$p(this.a);
                ChatMembersViewModel r34 = this.a;
            L20:
                Object r35 = r33.getValue();
                com.ss.android.lark.compose.chat_member_list.d r36 = (com.ss.android.lark.compose.chat_member_list.d) r35;
                List<com.ss.android.lark.compose.chatterselector.a> r37 = r36.b;
                if (r37.isEmpty() == true) goto L35;
                List<com.ss.android.lark.compose.chatterselector.a> r38 = r37;
                ArrayList r39 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r38, 10));
                Iterator<T> r40 = r38.iterator();
            L25:
                if (r40.hasNext() == false) goto L33;
                com.ss.android.lark.compose.chatterselector.a r41 = (com.ss.android.lark.compose.chatterselector.a) r40.next();
                Chatter r112 = (Chatter) r5.get(r41.a);
                if (r112 == null) goto L32;
                com.ss.android.lark.compose.chatterselector.a r113 = ChatMembersViewModel.access$toSelectorChatter(r34, r112);
                if (r113 == null) goto L32;
                r41 = r113;
            L32:
                r39.add(r41);
                goto L25
            L33:
                r36 = com.ss.android.lark.compose.chat_member_list.d.a(r36, null, r39, false, false, false, null, false, 0, false, false, 1021);
            L35:
                if (r33.compareAndSet(r35, r36) == false) goto L20;
            L38:
                throw new NoWhenBranchMatchedException();
            L83:
                return Unit.INSTANCE;
            }
        }

        public C03801(ChatMembersViewModel r1, Continuation<? super C03801> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03801(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1 r6 = ChatMembersViewModel.access$getRepository$p(this.this$0).j();
            ChatMembersViewModel r2 = this.this$0;
            a r3 = new a(r2);
            this.label = 1;
            Object r7 = r6.collect(new ChatMembersViewModel$subscribeChatChattersPush$1$invokeSuspend$$inlined$filter$1$2(r3, r2), this);
            if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
            r7 = Unit.INSTANCE;
        L12:
            if (r7 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$subscribeChatPush$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$subscribeChatPush$1", f = "ChatMembersViewModel.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatMembersViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$subscribeChatPush$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "pbChat", "Lcom/lark/kmp/pb/basic/v1/Chat;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$subscribeChatPush$1$1", f = "ChatMembersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01241 extends SuspendLambda implements Function2<Chat, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ChatMembersViewModel this$0;

            public C01241(ChatMembersViewModel r1, Continuation<? super C01241> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                C01241 r0 = new C01241(this.this$0, r4);
                r0.L$0 = r3;
                return r0;
            }

            public final Object invoke(Chat r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((Chat) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                Chat r3 = (Chat) this.L$0;
                ChatMembersViewModel.access$updateChatPermissionState(this.this$0, r3);
                ChatMembersViewModel.access$getPlatformEffects$p(this.this$0).h(r3);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$subscribeChatPush$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_ERROR, BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$subscribeChatPush$1$2", f = "ChatMembersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<Throwable, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;

            public AnonymousClass2(Continuation<? super AnonymousClass2> r2) {
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                AnonymousClass2 r0 = new AnonymousClass2(r3);
                r0.L$0 = r2;
                return r0;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((Throwable) r1, (Continuation) r2);
            }

            public final Object invoke(Throwable r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r2);
                if ((((Throwable) this.L$0) instanceof CancellationException) == false) goto L9;
                return Unit.INSTANCE;
            L9:
                return Unit.INSTANCE;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C03811(ChatMembersViewModel r1, Continuation<? super C03811> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03811(this.this$0, r3);
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
            Flow r7 = ChatMembersViewModel.access$observeChatPushFlow(this.this$0);
            C01241 r2 = new C01241(this.this$0, null);
            AnonymousClass2 r3 = new AnonymousClass2(null);
            this.label = 1;
            if (f.a(r7, r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$subscribeChatterPush$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$subscribeChatterPush$1", f = "ChatMembersViewModel.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatMembersViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel$subscribeChatterPush$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ChatMembersViewModel a;

            public a(ChatMembersViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r18, Continuation r19) {
                List<com.ss.android.lark.compose.chatterselector.a> r2 = ((com.ss.android.lark.compose.chat_member_list.d) ChatMembersViewModel.access$getUiFlow$p(this.a).getValue()).b;
                Map r1 = ((Entity) r18).getChatters();
                List<com.ss.android.lark.compose.chatterselector.a> r3 = r2;
                ChatMembersViewModel r4 = this.a;
                ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
                Iterator<T> r5 = r3.iterator();
                boolean r6 = false;
            L4:
                if (r5.hasNext() == false) goto L12;
                com.ss.android.lark.compose.chatterselector.a r7 = (com.ss.android.lark.compose.chatterselector.a) r5.next();
                Chatter r8 = (Chatter) r1.get(r7.a);
                if (r8 == null) goto L11;
                com.ss.android.lark.compose.chatterselector.a r9 = ChatMembersViewModel.access$toSelectorChatter(r4, r8);
                if (r9 == null) goto L10;
                r7 = com.ss.android.lark.compose.chatterselector.a.a(r9, r7.e);
            L10:
                r6 = true;
            L11:
                r15.add(r7);
                goto L4
            L12:
                if (r6 == false) goto L19;
                z0 r10 = ChatMembersViewModel.access$getUiFlow$p(this.a);
            L14:
                Object r11 = r10.getValue();
                ArrayList r16 = r15;
                if (r10.compareAndSet(r11, com.ss.android.lark.compose.chat_member_list.d.a((com.ss.android.lark.compose.chat_member_list.d) r11, null, r15, false, false, false, null, false, 0, false, false, 1021)) == true) goto L19;
                r15 = r16;
            L19:
                return Unit.INSTANCE;
            }
        }

        public C03821(ChatMembersViewModel r1, Continuation<? super C03821> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03821(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1 r6 = ChatMembersViewModel.access$getRepository$p(this.this$0).k();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new b();
        $stable = 8;
        EXCLUSIVE_TAGS = CollectionsKt.listOf(BizTag.SPECIAL_FOCUS);
        MUTEX_TAGS = CollectionsKt.listOf(new Set[]{SetsKt.setOf(new BizTag[]{BizTag.GROUP_OWNER, BizTag.GROUP_MANAGER}), SetsKt.setOf(new BizTag[]{BizTag.FROZEN, BizTag.UNREGISTERED})});
    }

    private final Flow<Chat> fetchChatFlow() {
        com.lark.kmp.rustclient.api.d r0 = this.rustClient;
        MGetChatsRequest.a r2 = new MGetChatsRequest.a();
        List r1 = CollectionsKt.listOf(this.chatId);
        Intrinsics.checkNotNullParameter(r1, "chat_ids");
        com.lark.wire.internal.a.a(r1);
        r2.d = r1;
        final RustOutputKt$errorAsException$.inlined.map.1 r3 = i.a(r0.b(new com.lark.kmp.rustclient.api.model.c(r2, MGetChatsResponse.ADAPTER, Command.MGET_CHATS, null, 120)).a());
        return new ChatMembersViewModel$fetchChatFlow$$inlined$mapNotNull$1(r3, this);
    }

    private final void loadMorePage() {
        long r2 = this.memberRequestGeneration;
        com.ss.android.lark.compose.chat_member_list.d r4 = (com.ss.android.lark.compose.chat_member_list.d) this.uiFlow.getValue();
        this.loadMoreJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03791(this, r2, r4, null), 3, null);
    }

    private final Flow<Chat> observeChatPushFlow() {
        return this.repository.i(this.chatId);
    }

    public final void loadNextPage() {
        if (StringsKt.isBlank(this.chatId) == false) goto L5;
        return;
    L5:
        com.ss.android.lark.compose.chat_member_list.d r0 = (com.ss.android.lark.compose.chat_member_list.d) this.uiFlow.getValue();
        if (r0.c == false) goto L8;
    L14:
        logMemberSearch("page_skipped", "generation=" + this.memberRequestGeneration + " loading=" + r0.c + " loadingMore=" + r0.d + " hasMore=" + r0.e);
        return;
    L8:
        if (r0.d == true) goto L14;
        if (r0.e == false) goto L14;
        loadMorePage();
    }

    public final void refresh() {
        if (StringsKt.isBlank(this.chatId) == false) goto L6;
        this.uiFlow.setValue(new com.ss.android.lark.compose.chat_member_list.d(0));
        return;
    L6:
        loadFirstPage(((com.ss.android.lark.compose.chat_member_list.d) this.uiFlow.getValue()).a);
    }

    private final void fetchChatInfo() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    private final void subscribeChatChattersPush() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03801(this, null), 3, null);
    }

    private final void subscribeChatPush() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03811(this, null), 3, null);
    }

    private final void subscribeChatterPush() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03821(this, null), 3, null);
    }

    public final i1<com.ss.android.lark.compose.chat_member_list.d> getMembersUiState() {
        return this.membersUiState;
    }

    public static final /* synthetic */ Flow access$fetchChatFlow(ChatMembersViewModel r0) {
        return r0.fetchChatFlow();
    }

    public static final /* synthetic */ String access$getChatId$p(ChatMembersViewModel r0) {
        return r0.chatId;
    }

    public static final /* synthetic */ long access$getMemberRequestGeneration$p(ChatMembersViewModel r2) {
        return r2.memberRequestGeneration;
    }

    public static final /* synthetic */ com.ss.android.lark.compose.chatsetting.common.platform.b access$getPlatformEffects$p(ChatMembersViewModel r0) {
        return r0.platformEffects;
    }

    public static final /* synthetic */ ChatSettingRepository access$getRepository$p(ChatMembersViewModel r0) {
        return r0.repository;
    }

    public static final /* synthetic */ z0 access$getUiFlow$p(ChatMembersViewModel r0) {
        return r0.uiFlow;
    }

    public static final /* synthetic */ Flow access$observeChatPushFlow(ChatMembersViewModel r0) {
        return r0.observeChatPushFlow();
    }

    private final List<BizTag> filterAndSortTags(List<? extends BizTag> r2) {
        return CollectionsKt.sortedWith(CollectionsKt.distinct(filterTags(r2)), new d());
    }

    private final List<BizTag> filterTags(List<? extends BizTag> r10) {
        if (r10.isEmpty() == true) goto L5;
        List<BizTag> r0 = EXCLUSIVE_TAGS;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L7:
        Object r4 = null;
        if (r2.hasNext() == false) goto L22;
        BizTag r3 = (BizTag) r2.next();
        Iterator<T> r6 = r10.iterator();
    L11:
        if (r6.hasNext() == false) goto L18;
        Object r7 = r6.next();
        if (((BizTag) r7) != r3) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == false) goto L11;
        r4 = r7;
        goto L18
    L15:
        r8 = false;
    L18:
        BizTag r5 = (BizTag) r4;
        if (r5 == null) goto L7;
        r1.add(r5);
        goto L7
    L22:
        if ((!r1.isEmpty()) == false) goto L24;
        return r1;
    L24:
        List<Set<BizTag>> r9 = MUTEX_TAGS;
        List<BizTag> r11 = CollectionsKt.toList(r10);
        Iterator<T> r12 = r9.iterator();
    L26:
        if (r12.hasNext() == false) goto L40;
        Set r13 = (Set) r12.next();
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r11.iterator();
        BizTag r16 = null;
    L29:
        if (r15.hasNext() == false) goto L37;
        Object r17 = r15.next();
        BizTag r18 = (BizTag) r17;
        boolean r19 = r13.contains(r18);
        if (r19 == false) goto L35;
        if (r16 != null) goto L35;
        r16 = r18;
    L35:
        if ((!r19) == false) goto L29;
        r14.add(r17);
        goto L29
    L37:
        r11 = CollectionsKt.toMutableList(r14);
        if (r16 == null) goto L26;
        ListProtector.add(r11, 0, r16);
        goto L26
    L40:
        return r11;
    L5:
        return CollectionsKt.emptyList();
    }

    private final void loadFirstPage(String r15) {
        long r6 = this.memberRequestGeneration + 1;
        this.memberRequestGeneration = r6;
        StringBuilder r0 = new StringBuilder("generation=");
        r0.append(r6);
        r0.append(" queryLength=");
        r0.append(r15.length());
        r0.append(" cancelFirst=");
        Job r1 = this.firstPageJob;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        r0.append(r3);
        r0.append(" cancelMore=");
        Job r4 = this.loadMoreJob;
        if (r4 != null) goto L11;
    L13:
        r0.append(r2);
        logMemberSearch("first_page", r0.toString());
        Job r5 = this.firstPageJob;
        if (r5 == null) goto L16;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L16:
        Job r7 = this.loadMoreJob;
        if (r7 == null) goto L19;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L19:
        this.firstPageJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03781(this, r6, r15, null), 3, null);
        return;
    L11:
        if (r4.isActive() != true) goto L13;
        r2 = true;
        goto L13
    L5:
        if (r1.isActive() != true) goto L7;
        r3 = true;
        goto L8
    }

    private final List<com.ss.android.lark.compose.chatterselector.d> parseUDTagParams(Chatter r7) {
        ArrayList r0 = new ArrayList();
        if (r7.getType() != Chatter.Type.BOT) goto L5;
        r0.add(BizTag.ROBOT);
    L5:
        Chatter.ChatExtra r1 = r7.getChat_extra();
        String r2 = null;
        if (r1 == null) goto L17;
        Chatter.ChatExtra.ChatChatterTagInfo r3 = r1.getTag_infos();
        if (r3 == null) goto L17;
        List r4 = r3.getTags();
        if (r4 == null) goto L17;
        List r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L13:
        if (r6.hasNext() == false) goto L18;
        Chatter.ChatExtra.ChatChatterTagInfo.TagInfo.TagType r8 = ((Chatter.ChatExtra.ChatChatterTagInfo.TagInfo) r6.next()).getTag_type();
        if (r8 == null) goto L13;
        r5.add(r8);
    L18:
        if (r5 != null) goto L20;
        r5 = CollectionsKt.emptyList();
    L20:
        c r9 = this.owner;
        if (r9 == null) goto L27;
        if (r9 == null) goto L25;
        r2 = r9.a;
    L25:
        if (Intrinsics.areEqual(r2, r7.getId()) == false) goto L27;
        r0.add(BizTag.GROUP_OWNER);
    L27:
        List r10 = r5;
        boolean r11 = false;
        if ((r10 instanceof Collection) == true) goto L30;
    L32:
        Iterator r12 = r10.iterator();
    L34:
        if (r12.hasNext() == false) goto L41;
        if (((Chatter.ChatExtra.ChatChatterTagInfo.TagInfo.TagType) r12.next()) != Chatter.ChatExtra.ChatChatterTagInfo.TagInfo.TagType.ADMIN_USER) goto L38;
        boolean r13 = true;
    L39:
        if (r13 == false) goto L34;
        r11 = true;
        goto L41
    L38:
        r13 = false;
    L41:
        if (r11 == false) goto L44;
        r0.add(BizTag.GROUP_MANAGER);
    L44:
        if (Intrinsics.areEqual(r7.is_special_focus(), Boolean.TRUE) == false) goto L46;
        r0.add(BizTag.SPECIAL_FOCUS);
    L46:
        List<BizTag> r14 = filterAndSortTags(r0);
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r16 = r14.iterator();
    L48:
        if (r16.hasNext() == false) goto L50;
        r15.add(((BizTag) r16.next()).getModel());
        goto L48
    L50:
        return r15;
    L30:
        if (r10.isEmpty() == false) goto L32;
    L17:
        r5 = null;
        goto L18
    }

    private final com.ss.android.lark.compose.chatterselector.a toSelectorChatter(Chatter r9) {
        String r1 = r9.getId();
        String r0 = r9.getAlias();
        boolean r2 = true;
        if (r0 != null) goto L5;
    L9:
        r0 = r9.getName();
    L10:
        String r3 = r0;
        String r4 = r9.getAlias();
        if (r4 == null) goto L17;
        if (StringsKt.isBlank(r4) == true) goto L17;
        r2 = false;
    L17:
        if (r2 == false) goto L19;
    L21:
        String r5 = r9.getAlias();
        if (r5 != null) goto L24;
        String r6 = BuildConfig.FLAVOR;
    L25:
        String r7 = r9.getAvatar_key();
        if (r7 != null) goto L28;
        String r8 = BuildConfig.FLAVOR;
    L30:
        return new com.ss.android.lark.compose.chatterselector.a(r1, r3, r6, r8, parseUDTagParams(r9), ChatMemberStatusTag_androidKt.b(r9));
    L28:
        r8 = r7;
    L24:
        r6 = r5;
        goto L25
    L19:
        if (Intrinsics.areEqual(r9.getAlias(), r9.getName()) == true) goto L21;
        r5 = r9.getName();
        goto L24
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        goto L9
    }

    private final void updateChatPermissionState(Chat r21) {
        c r1 = this.owner;
        c r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.a;
    L6:
        String r4 = BuildConfig.FLAVOR;
        if (r3 != null) goto L9;
        r3 = BuildConfig.FLAVOR;
    L9:
        String r5 = r21.getOwner_id();
        if (r5 == null) goto L14;
        r4 = r5;
    L14:
        if ((!StringsKt.isBlank(r4)) == false) goto L16;
        String r6 = r4;
    L17:
        if (r6 == null) goto L19;
        r2 = new c(r6);
    L19:
        this.owner = r2;
        boolean r7 = false;
        if (r21.getType() != Chat.Type.P2P) goto L23;
    L35:
        boolean r8 = false;
    L37:
        Integer r9 = r21.getUser_count();
        if (r9 == null) goto L40;
        int r10 = r9.intValue();
    L41:
        logMemberSearch("chat_info", "type=" + r21.getType() + " isSuper=" + r21.is_super() + " userCount=" + r10 + " canSort=" + r21.getCan_be_sorted_alphabetically() + " userCountVisible=" + r21.is_user_count_visible());
        if (r21.getAdd_member_permission() != Chat.AddMemberPermission.Enum.ALL_MEMBERS) goto L44;
        boolean r19 = true;
    L45:
        Boolean r11 = r21.getCan_be_sorted_alphabetically();
        if (r11 == null) goto L48;
        r7 = r11.booleanValue();
    L48:
        if (r7 == false) goto L52;
        Boolean r12 = r21.is_super();
        if (r12 == null) goto L52;
        r12.booleanValue();
    L52:
        z0<com.ss.android.lark.compose.chat_member_list.d> r13 = this.uiFlow;
    L53:
        Object r15 = r13.getValue();
        com.ss.android.lark.compose.chat_member_list.d r14 = (com.ss.android.lark.compose.chat_member_list.d) r15;
        Boolean r16 = r21.is_user_count_visible();
        if (r16 == null) goto L56;
        boolean r17 = r16.booleanValue();
    L58:
        if (Intrinsics.areEqual(r3, r4) == true) goto L60;
        List<com.ss.android.lark.compose.chatterselector.a> r18 = updateOwnerTagInMembers(r14.b, r4);
    L62:
        if (r13.compareAndSet(r15, com.ss.android.lark.compose.chat_member_list.d.a(r14, null, r18, false, false, false, null, r8, r10, r17, r19, 61)) == false) goto L53;
        return;
    L60:
        r18 = r14.b;
        goto L62
    L56:
        r17 = true;
        goto L58
    L44:
        r19 = false;
        goto L45
    L40:
        r10 = 0;
        goto L41
    L23:
        if ((!StringsKt.isBlank(this.userId)) == true) goto L25;
    L27:
        boolean r20 = false;
    L28:
        if (r20 == true) goto L36;
        Boolean r22 = r21.is_admin();
        if (r22 == null) goto L32;
        boolean r23 = r22.booleanValue();
    L33:
        if (r23 == false) goto L35;
    L32:
        r23 = false;
    L36:
        r8 = true;
        goto L37
    L25:
        if (Intrinsics.areEqual(r21.getOwner_id(), this.userId) == false) goto L27;
        r20 = true;
        goto L28
    L16:
        r6 = null;
        goto L17
    L5:
        r3 = null;
        goto L6
    }

    public final void routeToAddMember(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        int r0 = d8b.a.a;
        d8b.a.b(r2, this.chatId);
    }

    public final void routeToRemoveMember(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        int r0 = d8b.a.a;
        d8b.a.d(r2, this.chatId);
    }

    public final void updateQuery(String r15) {
        Intrinsics.checkNotNullParameter(r15, "query");
        logMemberSearch("query", "unchanged=" + Intrinsics.areEqual(r15, ((com.ss.android.lark.compose.chat_member_list.d) this.uiFlow.getValue()).a) + " length=" + r15.length() + " trimmedLength=" + StringsKt.trim(r15).toString().length() + " blank=" + StringsKt.isBlank(r15));
        if (Intrinsics.areEqual(r15, ((com.ss.android.lark.compose.chat_member_list.d) this.uiFlow.getValue()).a) == false) goto L5;
        return;
    L5:
        z0<com.ss.android.lark.compose.chat_member_list.d> r0 = this.uiFlow;
    L6:
        Object r1 = r0.getValue();
        if (r0.compareAndSet(r1, com.ss.android.lark.compose.chat_member_list.d.a((com.ss.android.lark.compose.chat_member_list.d) r1, r15, null, false, false, false, null, false, 0, false, false, 1022)) == false) goto L6;
        if (StringsKt.isBlank(this.chatId) == false) goto L11;
        return;
    L11:
        loadFirstPage(r15);
    }

    public static final /* synthetic */ com.ss.android.lark.compose.chatterselector.a access$toSelectorChatter(ChatMembersViewModel r0, Chatter r1) {
        return r0.toSelectorChatter(r1);
    }

    public static final /* synthetic */ void access$updateChatPermissionState(ChatMembersViewModel r0, Chat r1) {
        r0.updateChatPermissionState(r1);
    }

    private final void logMemberSearch(String r3, String r4) {
        int r0 = c8b.a.a;
        c8b.a.b("[FlowMemberSearch:v2] session=" + this.searchLogSession + " event=" + r3 + ' ' + r4);
    }

    private final void logMemberSearchError(String r5, Throwable r6) {
        String r1 = null;
        if ((r6 instanceof RustClientException) == false) goto L5;
        RustClientException r0 = (RustClientException) r6;
    L6:
        if (r0 == null) goto L8;
        LarkError r2 = r0.getRustError();
    L10:
        if ((r6 instanceof CancellationException) == false) goto L12;
        String r3 = "request_cancelled";
    L13:
        StringBuilder r4 = new StringBuilder();
        r4.append(r5);
        r4.append(" type=");
        r4.append(Reflection.getOrCreateKotlinClass(r6.getClass()).getSimpleName());
        r4.append(" code=");
        if (r2 == null) goto L16;
        Integer r7 = r2.getCode();
    L17:
        r4.append(r7);
        r4.append(" status=");
        if (r2 == null) goto L20;
        Integer r8 = r2.getStatus();
    L21:
        r4.append(r8);
        r4.append(" logId=");
        if (r2 == null) goto L26;
        LarkError.ErrorDetails r9 = r2.getDetails();
        if (r9 == null) goto L26;
        String r10 = r9.getX_tt_logid();
    L27:
        r4.append(r10);
        r4.append(" serverRequestId=");
        if (r2 == null) goto L32;
        LarkError.ErrorDetails r11 = r2.getDetails();
        if (r11 == null) goto L32;
        String r12 = r11.getServer_request_id();
    L33:
        r4.append(r12);
        r4.append(" causeType=");
        Throwable r13 = r6.getCause();
        if (r13 == null) goto L36;
        r1 = Reflection.getOrCreateKotlinClass(r13.getClass()).getSimpleName();
    L36:
        r4.append(r1);
        logMemberSearch(r3, r4.toString());
        return;
    L32:
        r12 = null;
    L26:
        r10 = null;
        goto L27
    L20:
        r8 = null;
        goto L21
    L16:
        r7 = null;
        goto L17
    L12:
        r3 = "request_error";
        goto L13
    L8:
        r2 = null;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    private final List<com.ss.android.lark.compose.chatterselector.a> updateOwnerTagInMembers(List<com.ss.android.lark.compose.chatterselector.a> r12, String r13) {
        if (r12.isEmpty() == false) goto L5;
        return r12;
    L5:
        List<com.ss.android.lark.compose.chatterselector.a> r14 = r12;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
    L7:
        if (r15.hasNext() == false) goto L43;
        com.ss.android.lark.compose.chatterselector.a r2 = (com.ss.android.lark.compose.chatterselector.a) r15.next();
        List<com.ss.android.lark.compose.chatterselector.d> r3 = r2.e;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L9:
        int r6 = 0;
        if (r5.hasNext() == false) goto L20;
        com.ss.android.lark.compose.chatterselector.d r7 = (com.ss.android.lark.compose.chatterselector.d) r5.next();
        BizTag[] r8 = BizTag.values();
        int r9 = r8.length;
    L12:
        if (r6 >= r9) goto L17;
        BizTag r10 = r8[r6];
        if (Intrinsics.areEqual(r10.getModel(), r7) == true) goto L18;
        r6 = r6 + 1;
    L18:
        if (r10 == null) goto L9;
        r4.add(r10);
        goto L9
    L17:
        r10 = null;
        goto L18
    L20:
        List<? extends BizTag> r11 = CollectionsKt.toMutableList(r4);
        CollectionsKt.removeAll(r11, ChatMembersViewModel$updateOwnerTagInMembers$1$1.INSTANCE);
        if ((!StringsKt.isBlank(r13)) == true) goto L23;
    L38:
        List<BizTag> r16 = filterAndSortTags(r11);
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r18 = r16.iterator();
    L40:
        if (r18.hasNext() == false) goto L42;
        r17.add(((BizTag) r18.next()).getModel());
        goto L40
    L42:
        r0.add(com.ss.android.lark.compose.chatterselector.a.a(r2, r17));
        goto L7
    L23:
        if (Intrinsics.areEqual(r2.a, r13) == false) goto L38;
        Iterator<? extends BizTag> r19 = r11.iterator();
        int r20 = 0;
    L26:
        if (r19.hasNext() == false) goto L34;
        if (r19.next() != BizTag.GROUP_MANAGER) goto L30;
        boolean r21 = true;
    L31:
        if (r21 == true) goto L35;
        r20 = r20 + 1;
    L35:
        if (r20 < 0) goto L37;
        ListProtector.add(r11, r20, BizTag.GROUP_OWNER);
        goto L38
    L37:
        r11.add(BizTag.GROUP_OWNER);
        goto L38
    L30:
        r21 = false;
        goto L31
    L34:
        r20 = -1;
        goto L35
    L43:
        return r0;
    }

    public static final /* synthetic */ void access$logMemberSearch(ChatMembersViewModel r0, String r1, String r2) {
        r0.logMemberSearch(r1, r2);
    }

    public static final /* synthetic */ void access$logMemberSearchError(ChatMembersViewModel r0, String r1, Throwable r2) {
        r0.logMemberSearchError(r1, r2);
    }

    public ChatMembersViewModel(String r2, com.lark.kmp.rustclient.api.d r3, com.ss.android.lark.compose.chatsetting.common.platform.b r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "rustClient");
        Intrinsics.checkNotNullParameter(r4, "platformEffects");
        Intrinsics.checkNotNullParameter(r5, "userId");
        this.chatId = r2;
        this.rustClient = r3;
        this.platformEffects = r4;
        this.userId = r5;
        this.repository = new ChatSettingRepository(r3);
        StateFlowImpl r6 = j1.a(new com.ss.android.lark.compose.chat_member_list.d(0));
        this.uiFlow = r6;
        this.membersUiState = kotlinx.coroutines.flow.e.b(r6);
        this.searchLogSession = Integer.toString(hashCode(), CharsKt.checkRadix(16));
        StringBuilder r7 = new StringBuilder("chatIdPresent=");
        r7.append(!StringsKt.isBlank(r2));
        logMemberSearch("init", r7.toString());
        if ((!StringsKt.isBlank(r2)) == false) goto L5;
        fetchChatInfo();
        subscribeChatPush();
        subscribeChatChattersPush();
        subscribeChatterPush();
    L5:
        refresh();
    }

    private final GetChatChattersRequest.a buildGetChatChattersRequest(boolean r4, int r5, int r6, String r7, String r8) {
        GetChatChattersRequest.a r0 = new GetChatChattersRequest.a();
        String r1 = this.chatId;
        Intrinsics.checkNotNullParameter(r1, "chat_id");
        r0.d = r1;
        r0.i = Integer.valueOf(r5);
        r0.l = Integer.valueOf(r6);
        r0.e = Boolean.valueOf(r4);
        if (r7 != null) goto L5;
    L8:
        boolean r9 = true;
    L9:
        if (r9 == true) goto L12;
        r0.h = r7;
    L12:
        if ((true ^ StringsKt.isBlank(r8)) == false) goto L14;
        r0.g = r8;
    L14:
        return r0;
    L5:
        if (StringsKt.isBlank(r7) == true) goto L8;
        r9 = false;
        goto L9
    }

    public /* synthetic */ ChatMembersViewModel(String r1, com.lark.kmp.rustclient.api.d r2, com.ss.android.lark.compose.chatsetting.common.platform.b r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = BuildConfig.FLAVOR;
    L5:
        this(r1, r2, r3, r4);
    }

    private final Flow<a> fetchChatChattersFlow(long r8, boolean r10, int r11, int r12, final String r13, String r14) {
        long r0 = this.memberRequestId + 1;
        this.memberRequestId = r0;
        StringBuilder r2 = new StringBuilder("generation=");
        r2.append(r8);
        r2.append(" request=");
        r2.append(r0);
        r2.append(" fromServer=");
        r2.append(r10);
        r2.append(" limit=");
        r2.append(r11);
        r2.append(" offset=");
        r2.append(r12);
        r2.append(" cursorPresent=");
        if (r13 != null) goto L5;
    L8:
        boolean r9 = true;
    L9:
        r2.append(!r9);
        r2.append(" queryLength=");
        r2.append(r14.length());
        r2.append(" filterPresent=");
        r2.append(true ^ StringsKt.isBlank(r14));
        final String r15 = r2.toString();
        final RustOutputKt$errorAsException$.inlined.map.1 r16 = i.a(new FlowKt__LimitKt$take$.inlined.unsafeFlow.1(this.rustClient.b(new com.lark.kmp.rustclient.api.model.c(buildGetChatChattersRequest(r10, r11, r12, r13, r14), GetChatChattersResponse.ADAPTER, Command.GET_CHAT_CHATTERS, null, 120)).a()));
        return new FlowKt__EmittersKt$onCompletion$.inlined.unsafeFlow.1(new FlowKt__EmittersKt$onStart$.inlined.unsafeFlow.1(new AnonymousClass2(this, r15, null), new ChatMembersViewModel$fetchChatChattersFlow$$inlined$map$1(r16, this, r15, r13)), new AnonymousClass3(this, r15, null));
    L5:
        if (StringsKt.isBlank(r13) == true) goto L8;
        r9 = false;
        goto L9
    }

    public static final /* synthetic */ Flow access$fetchChatChattersFlow(ChatMembersViewModel r0, long r1, boolean r3, int r4, int r5, String r6, String r7) {
        return r0.fetchChatChattersFlow(r1, r3, r4, r5, r6, r7);
    }
}
