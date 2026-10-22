package com.ss.android.lark.chat.preview.memberlist;

import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.pb.url.v1.PullUrlPreviewChattersListResponse;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.preview.PullUrlPreviewChatterListResponse;
import com.ss.android.lark.chat.preview.entity.component.property.ChattersPreviewProperty;
import com.ss.android.lark.export.entity.preview.ChatterPreviewChatterInfo;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import j6b.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BE\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0017\u001a\u00020\u0002H\u0014J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0007J>\u0010\u001c\u001a\u00020\u00192\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001` 2\b\b\u0002\u0010!\u001a\u00020\"H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/chat/preview/memberlist/MemberListViewModel;", "Lcom/larksuite/arch/jack/JackViewModel;", "Lcom/ss/android/lark/chat/preview/memberlist/MemberListState;", "mode", BuildConfig.FLAVOR, "chatterIdList", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "previewId", "componentId", "showTitle", "<init>", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMode", "()I", "getChatterIdList", "()Ljava/util/List;", "getPreviewId", "()Ljava/lang/String;", "getComponentId", "getShowTitle", "model", "Lcom/ss/android/lark/chat/preview/memberlist/MemberListModel;", "defaultState", "start", BuildConfig.FLAVOR, "getMemberList", "nextToken", "getChattersByIds", "chatterInfos", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo;", "Lkotlin/collections/ArrayList;", Keys.API_RETURN_KEY_HAS_MORE, BuildConfig.FLAVOR, "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MemberListViewModel extends JackViewModel<d> {
    private final List<String> chatterIdList;
    private final String componentId;
    private final int mode;
    private final c model;
    private final String previewId;
    private final String showTitle;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.preview.memberlist.MemberListViewModel$getChattersByIds$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.preview.memberlist.MemberListViewModel$getChattersByIds$1", f = "MemberListViewModel.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $chatterIdList;
        final /* synthetic */ ArrayList<ChatterPreviewChatterInfo> $chatterInfos;
        final /* synthetic */ boolean $hasMore;
        int label;
        final /* synthetic */ MemberListViewModel this$0;

        public AnonymousClass1(List<String> r1, MemberListViewModel r2, ArrayList<ChatterPreviewChatterInfo> r3, boolean r4, Continuation<? super AnonymousClass1> r5) {
            this.$chatterIdList = r1;
            this.this$0 = r2;
            this.$chatterInfos = r3;
            this.$hasMore = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$chatterIdList, this.this$0, this.$chatterInfos, this.$hasMore, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            Integer r2 = null;
            boolean r3 = false;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L36:
            MemberListService.b r12 = (MemberListService.b) r11;
        L39:
            if ((r12 instanceof MemberListService.b.C0110b) == false) goto L82;
            MemberListService.b.C0110b r13 = (MemberListService.b.C0110b) r12;
            List r4 = CollectionsKt.toList(((Map) r13.a).values());
            ArrayList<ChatterPreviewChatterInfo> r5 = this.$chatterInfos;
            if (r5 != null) goto L43;
        L44:
            r3 = true;
        L45:
            if (r3 == true) goto L60;
            ArrayList<ChatterPreviewChatterInfo> r6 = this.$chatterInfos;
            Iterator r14 = r4.iterator();
        L48:
            if (r14.hasNext() == false) goto L59;
            Chatter r7 = (Chatter) r14.next();
            ArrayList r8 = new ArrayList();
            Iterator<T> r9 = r6.iterator();
        L51:
            if (r9.hasNext() == false) goto L55;
            Object r10 = r9.next();
            if (Intrinsics.areEqual(((ChatterPreviewChatterInfo) r10).getChatterId(), r7.getId()) == false) goto L51;
            r8.add(r10);
            goto L51
        L55:
            ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator r16 = r8.iterator();
        L57:
            if (r16.hasNext() == false) goto L48;
            ((ChatterPreviewChatterInfo) r16.next()).setName(r7.getName());
            r15.add(Unit.INSTANCE);
            goto L57
        L59:
            final ArrayList<ChatterPreviewChatterInfo> r17 = this.$chatterInfos;
        L77:
            StringBuilder r18 = new StringBuilder("chatterInfoList size:");
            ArrayList<ChatterPreviewChatterInfo> r19 = this.$chatterInfos;
            if (r19 == null) goto L80;
            r2 = Boxing.boxInt(r19.size());
        L80:
            r18.append(r2);
            r18.append(", chatterList size :");
            r18.append(r4.size());
            r18.append(", resultList size: ");
            r18.append(r17.size());
            Log.i("[URLPreview] MemberList", r18.toString());
            MemberListViewModel r20 = this.this$0;
            final boolean r21 = this.$hasMore;
            MemberListViewModel.access$setState(r20, new AnonymousClass3(r17, r21));
        L85:
            return Unit.INSTANCE;
        L60:
            ArrayList<ChatterPreviewChatterInfo> r22 = new ArrayList();
            HashSet r23 = new HashSet();
            List<String> r24 = this.$chatterIdList;
            if (r24 != null) goto L63;
            r24 = CollectionsKt.emptyList();
        L63:
            ArrayList r25 = new ArrayList();
            Iterator<T> r26 = r24.iterator();
        L65:
            if (r26.hasNext() == false) goto L69;
            Object r27 = r26.next();
            if (r23.add((String) r27) == false) goto L65;
            r25.add(r27);
            goto L65
        L69:
            Iterator r28 = r25.iterator();
        L71:
            if (r28.hasNext() == false) goto L76;
            String r29 = (String) r28.next();
            Chatter r30 = (Chatter) ((Map) r13.a).get(r29);
            if (r30 == null) goto L71;
            r22.add(new ChatterPreviewChatterInfo(r30.getAvatarKey(), r29, r30.getName(), ChatterPreviewChatterInfo.ChatterType.USER));
            goto L71
        L76:
            r17 = r22;
            goto L77
        L43:
            if (r5.isEmpty() == false) goto L45;
        L82:
            if ((r12 instanceof MemberListService.b.a) == false) goto L87;
            MemberListViewModel.access$setState(this.this$0, AnonymousClass4.INSTANCE);
            Log.e("[URLPreview] MemberList", "pbResponse.error.displayMsg:" + ((MemberListService.b.a) r12).a.getDisplayMsg());
            goto L85
        L87:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            List<String> r110 = this.$chatterIdList;
            if (r110 != null) goto L11;
        L14:
            boolean r111 = true;
        L15:
            if (r111 == true) goto L37;
            c r112 = MemberListViewModel.access$getModel$p(this.this$0);
            List<String> r31 = this.$chatterIdList;
            this.label = 1;
            r112.getClass();
            j r113 = new j(IntrinsicsKt.intercepted(this), 1);
            r113.C();
            g6b.a.InterfaceC0223a r32 = g6b.a.a;
            if (r32 == null) goto L21;
            com.ss.android.lark.officesdk.integrator.im.c r33 = r32.c();
            if (r33 == null) goto L21;
            Map r34 = r33.a(r31);
        L22:
            if (r34 != null) goto L24;
        L27:
            boolean r35 = true;
        L28:
            if (r35 == true) goto L30;
            Result.Companion r36 = Result.Companion;
            r113.resumeWith(Result.constructor-impl(new MemberListService.b.C0110b(r34)));
        L31:
            r11 = r113.B();
            if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
            DebugProbesKt.probeCoroutineSuspended(this);
        L34:
            if (r11 != r0) goto L36;
            return r0;
        L30:
            Result.Companion r37 = Result.Companion;
            r113.resumeWith(Result.constructor-impl(new MemberListService.b.a(new ErrorResult("chatters is null"))));
            goto L31
        L24:
            if (r34.isEmpty() == true) goto L27;
            r35 = false;
        L21:
            r34 = null;
            goto L22
        L37:
            r12 = new MemberListService.b.a(new ErrorResult("chatterIdList isNullOrEmpty"));
            goto L39
        L11:
            if (r110.isEmpty() == true) goto L14;
            r111 = false;
            goto L15
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.preview.memberlist.MemberListViewModel$getMemberList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.preview.memberlist.MemberListViewModel$getMemberList$1", f = "MemberListViewModel.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $nextToken;
        int label;
        final /* synthetic */ MemberListViewModel this$0;

        public C03761(MemberListViewModel r1, String r2, Continuation<? super C03761> r3) {
            this.this$0 = r1;
            this.$nextToken = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03761(this.this$0, this.$nextToken, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L15:
            MemberListService.b r15 = (MemberListService.b) r14;
        L18:
            if ((r15 instanceof MemberListService.b.C0110b) == false) goto L37;
            PullUrlPreviewChattersListResponse r16 = (PullUrlPreviewChattersListResponse) ((MemberListService.b.C0110b) r15).a;
            int r3 = j6b.c.a;
            if (r16 == null) goto L22;
            final PullUrlPreviewChatterListResponse r4 = new PullUrlPreviewChatterListResponse(f.a(r16.chatter_infos), r16.chatter_ids, r16.has_more.booleanValue(), r16.next_token);
        L23:
            List<ChatterPreviewChatterInfo> r17 = r4.getChatterInfos();
            Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type java.util.ArrayList<com.ss.android.lark.export.entity.preview.ChatterPreviewChatterInfo>");
            final ArrayList r18 = (ArrayList) r17;
            List<String> r5 = r4.getChatterIds();
            if (r18.isEmpty() == false) goto L35;
            List<String> r6 = r5;
            if (r6 != null) goto L28;
        L31:
            if (r2 == true) goto L34;
            Log.i("[URLPreview] MemberList", "chatterInfoList is Empty, chatterIds size: " + r5.size());
            MemberListViewModel.access$getChattersByIds(this.this$0, r5, null, r4.getHasMore());
            return Unit.INSTANCE;
        L34:
            MemberListViewModel.access$setState(this.this$0, new C01111(r18));
            goto L35
        L28:
            if (r6.isEmpty() == true) goto L31;
            r2 = false;
        L35:
            MemberListViewModel.access$setState(this.this$0, new AnonymousClass2(r4, r18));
        L40:
            return Unit.INSTANCE;
        L22:
            r4 = new PullUrlPreviewChatterListResponse(null, null, false, null, 15, null);
            goto L23
        L37:
            if ((r15 instanceof MemberListService.b.a) == false) goto L42;
            MemberListViewModel.access$setState(this.this$0, AnonymousClass3.INSTANCE);
            Log.e("[URLPreview] MemberList", "pbResponse.error.displayMsg:" + ((MemberListService.b.a) r15).a.getDisplayMsg());
            goto L40
        L42:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            if (this.this$0.getPreviewId() != null) goto L11;
        L16:
            r15 = new MemberListService.b.a(new ErrorResult("previewId or componentId is null"));
            goto L18
        L11:
            if (this.this$0.getComponentId() == null) goto L16;
            c r19 = MemberListViewModel.access$getModel$p(this.this$0);
            String r7 = this.this$0.getPreviewId();
            String r8 = this.this$0.getComponentId();
            String r9 = this.$nextToken;
            this.label = 1;
            r19.getClass();
            r14 = MemberListService.a.a(r7, r8, r9, this);
            if (r14 != r0) goto L15;
            return r0;
        }
    }

    public MemberListViewModel() {
        this(0, null, null, null, null, 31, null);
    }

    /* JADX INFO: renamed from: defaultState, reason: collision with other method in class */
    public d m672defaultState() {
        return new d(0);
    }

    public final void start() {
        setState(new C03771(this));
        if (this.mode != ChattersPreviewProperty.ChattersMode.STATIC.getValue()) goto L14;
        List<String> r0 = this.chatterIdList;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        getChattersByIds$default(this, this.chatterIdList, null, false, 4, null);
        return;
    L13:
        setState(AnonymousClass2.INSTANCE);
        return;
    L7:
        if (r0.isEmpty() == true) goto L10;
        r1 = false;
        goto L11
    L14:
        withState(new AnonymousClass3(this));
    }

    public final List<String> getChatterIdList() {
        return this.chatterIdList;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final int getMode() {
        return this.mode;
    }

    public final String getPreviewId() {
        return this.previewId;
    }

    public final String getShowTitle() {
        return this.showTitle;
    }

    public /* bridge */ /* synthetic */ com.larksuite.arch.jack.j defaultState() {
        return m672defaultState();
    }

    public static final /* synthetic */ c access$getModel$p(MemberListViewModel r0) {
        return r0.model;
    }

    public final void getMemberList(String r8) {
        Intrinsics.checkNotNullParameter(r8, "nextToken");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03761(this, r8, null), 3, null);
    }

    public static final /* synthetic */ void access$setState(MemberListViewModel r0, Function1 r1) {
        r0.setState(r1);
    }

    private final void getChattersByIds(List<String> r11, ArrayList<ChatterPreviewChatterInfo> r12, boolean r13) {
        boolean r0 = false;
        if (r11 != null) goto L5;
    L7:
        if (r0 == false) goto L9;
        return;
    L9:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(r11, this, r12, r13, null), 3, null);
        return;
    L5:
        if (r11.isEmpty() != true) goto L7;
        r0 = true;
        goto L7
    }

    public static final /* synthetic */ void access$getChattersByIds(MemberListViewModel r0, List r1, ArrayList r2, boolean r3) {
        r0.getChattersByIds(r1, r2, r3);
    }

    public MemberListViewModel(int r2, List<String> r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "showTitle");
        this.mode = r2;
        this.chatterIdList = r3;
        this.previewId = r4;
        this.componentId = r5;
        this.showTitle = r6;
        this.model = new c();
    }

    public static /* synthetic */ void getChattersByIds$default(MemberListViewModel r0, List r1, ArrayList r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.getChattersByIds(r1, r2, r3);
    }

    public /* synthetic */ MemberListViewModel(int r4, List r5, String r6, String r7, String r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L5;
        r4 = 1;
    L5:
        String r0 = null;
        if ((r9 & 2) == 0) goto L8;
        List r11 = null;
    L10:
        if ((r9 & 4) == 0) goto L12;
        String r1 = null;
    L14:
        if ((r9 & 8) != 0) goto L18;
        r0 = r7;
    L18:
        if ((r9 & 16) == 0) goto L20;
        r8 = BuildConfig.FLAVOR;
    L20:
        this(r4, r11, r1, r0, r8);
        return;
    L12:
        r1 = r6;
        goto L14
    L8:
        r11 = r5;
        goto L10
    }
}
