package com.larus.profile.impl.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.utils.u;
import com.larus.network.http.y;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.ModifiedUserCreationMusic;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationMusic;
import com.larus.profile.api.bean.UserCreationGroup;
import com.larus.profile.api.bean.UserCreationGroupListResponse;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.profile.impl.ProfileRepo;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import fs9.a0;
import fs9.b0;
import fs9.x;
import gs9.d;
import gs9.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 X2\u00020\u0001:\u0001XB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010+\u001a\u00020,2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#J5\u0010-\u001a\u00020,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190/2\b\u00100\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020,\u0018\u000102¢\u0006\u0002\u00103J7\u00104\u001a\u00020,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190/2\b\u00100\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020,\u0018\u000102H\u0002¢\u0006\u0002\u00103J\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\u00190/2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00190/H\u0002J\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00190/J\"\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020\u000b2\b\b\u0002\u0010:\u001a\u00020\u000b2\b\b\u0002\u0010;\u001a\u00020\u0005J\u0010\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020\u0005H\u0002J\u001a\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010;\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u0005J\u000e\u0010A\u001a\u00020,2\u0006\u0010;\u001a\u00020\u0005J$\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020\u00052\b\b\u0002\u0010:\u001a\u00020\u000b2\b\b\u0002\u0010;\u001a\u00020\u0005H\u0002J\u0018\u0010D\u001a\u00020,2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010;\u001a\u00020\u0005J\u000e\u0010G\u001a\u00020,2\u0006\u0010@\u001a\u00020\u0005J\u0006\u0010H\u001a\u00020\u0005J\u0006\u0010I\u001a\u00020,J\u001d\u0010J\u001a\u00020,2\u0006\u0010K\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010LJ6\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00190/2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190/2\u0006\u0010N\u001a\u00020\u00112\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u0010PJ0\u0010Q\u001a\u00020,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190/2\u0006\u0010N\u001a\u00020\u00112\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u0010PJ\u0016\u0010R\u001a\u00020\u000b2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190/H\u0002J\u001c\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00190/2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190/H\u0002J\u0019\u0010T\u001a\u00020\u000b2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010UJ\u0006\u0010V\u001a\u00020\u0005J\u0006\u0010W\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R+\u0010\u0016\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0019 \u001a*\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00180\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR+\u0010\u001d\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0019 \u001a*\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00180\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000f¨\u0006Y"}, d2 = {"Lcom/larus/profile/impl/viewmodel/CreationPagerViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "currentPagerIndex", "", "getCurrentPagerIndex", "()I", "setCurrentPagerIndex", "(I)V", "hasmore", "", "getHasmore", "()Z", "setHasmore", "(Z)V", "cursor", "", "getCursor", "()Ljava/lang/String;", "setCursor", "(Ljava/lang/String;)V", "feedData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/profile/api/bean/UserCreationModel;", "kotlin.jvm.PlatformType", "getFeedData", "()Landroidx/lifecycle/MutableLiveData;", "realCreationList", "getRealCreationList", "creationMode", "getCreationMode", "setCreationMode", "creationPagerInitParams", "Lcom/larus/profile/api/model/CreationPagerInitParams;", "getCreationPagerInitParams", "()Lcom/larus/profile/api/model/CreationPagerInitParams;", "setCreationPagerInitParams", "(Lcom/larus/profile/api/model/CreationPagerInitParams;)V", "hasInit", "getHasInit", "setHasInit", "initParams", "", "updateFeedData", "creationList", "", "initPos", "callback", "Lkotlin/Function0;", "(Ljava/util/List;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "applyFeedData", "filterBanCreation", "originList", "getCurrentCreationList", "setCreationPrivacy", "private", "splitMode", "sessionIndex", "initPosition", "pos", "getCurrentCreation", "Lcom/larus/platform/api/creation/UserCreation;", "pagerIndex", "deleteCreation", "updateCreationModelPrivacy", "privacy", "updateCreationContent", "content", "Lcom/larus/platform/api/ModifiedUserCreationMusic;", "updatePagerIndex", "getItemCountWithoutLoading", "addLoading", "loadFeedData", "visitId", "(Ljava/lang/String;Ljava/lang/Integer;)V", "prepareNoWatermarkForDetail", "scene", "mode", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureNoWatermarkForDetail", "shouldPrepareNoWatermarkForDetail", "selectNoWatermarkCreationList", "shouldResolveNoWatermarkForDetail", "(Ljava/lang/Integer;)Z", "getCurrentIndex", "getCurrentIndexInFeedData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationPagerViewModel extends ViewModel {
    private static final String CREATION_PROFILE_DETAIL_LOAD_MORE_SCENE = "profile_detail_load_more";
    public static final a Companion = null;
    private static final String TAG = "CreationPagerViewModel";
    private int creationMode;
    private d creationPagerInitParams;
    private volatile int currentPagerIndex;
    private String cursor;
    private final MutableLiveData<List<UserCreationModel>> feedData;
    private volatile boolean hasInit;
    private boolean hasmore;
    private final MutableLiveData<List<UserCreationModel>> realCreationList;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.viewmodel.CreationPagerViewModel$loadFeedData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.viewmodel.CreationPagerViewModel$loadFeedData$1", f = "CreationPagerViewModel.kt", i = {2}, l = {328, 332, 360}, m = "invokeSuspend", n = {"data"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $creationMode;
        final /* synthetic */ String $visitId;
        Object L$0;
        int label;
        final /* synthetic */ CreationPagerViewModel this$0;

        public AnonymousClass1(Integer r1, String r2, CreationPagerViewModel r3, Continuation<? super AnonymousClass1> r4) {
            this.$creationMode = r1;
            this.$visitId = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$creationMode, this.$visitId, this.this$0, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r19) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            boolean r4 = false;
            List<UserCreation> r5 = null;
            boolean r7 = true;
            if (r2 == 0) goto L12;
            if (r2 == 1) goto L11;
            if (r2 == 2) goto L10;
            if (r2 != 3) goto L9;
            Object r3 = this.L$0;
            ResultKt.throwOnFailure(r19);
            Object r6 = r19;
        L85:
            List r8 = (List) r6;
            List r9 = (List) this.this$0.getRealCreationList().getValue();
            if (r9 == null) goto L88;
            Boxing.boxBoolean(r9.addAll(CollectionsKt.toMutableList(r8)));
        L88:
            this.this$0.getRealCreationList().postValue(r9);
            List r10 = CreationPagerViewModel.access$filterBanCreation(this.this$0, r8);
            ArrayList r11 = new ArrayList();
            List r12 = (List) this.this$0.getFeedData().getValue();
            if (r12 == null) goto L91;
            List r13 = r12;
        L92:
            r11.addAll(r13);
            if ((!r11.isEmpty()) == false) goto L105;
            UserCreationModel r14 = (UserCreationModel) CollectionsKt.lastOrNull(r11);
            if (r14 == null) goto L97;
            r5 = r14.b();
        L97:
            List<UserCreation> r15 = r5;
            if (r15 != null) goto L100;
        L103:
            if (r7 == false) goto L105;
            ListProtector.remove(r11, CollectionsKt.getLastIndex(r11));
            goto L105
        L100:
            if (r15.isEmpty() == true) goto L103;
            r7 = false;
        L105:
            r11.addAll(r10);
            HashSet r16 = new HashSet();
            ArrayList r17 = new ArrayList();
            Iterator r18 = r11.iterator();
        L107:
            if (r18.hasNext() == false) goto L111;
            Object r20 = r18.next();
            if (r16.add(((UserCreationModel) r20).d()) == false) goto L107;
            r17.add(r20);
            goto L107
        L111:
            this.this$0.getFeedData().postValue(CollectionsKt.toMutableList(r17));
            Object r21 = r3;
        L112:
            CreationPagerViewModel r22 = this.this$0;
            boolean r23 = r21 instanceof b0;
            if (r23 == false) goto L116;
            r4 = ((b0) r21).b();
        L118:
            r22.setHasmore(r4);
            CreationPagerViewModel r24 = this.this$0;
            if (r23 == false) goto L124;
            String r25 = ((b0) r21).c();
            if (r25 == null) goto L127;
        L128:
            r24.setCursor(r25);
        L130:
            return Unit.INSTANCE;
        L127:
            r25 = "";
            goto L128
        L124:
            if ((r21 instanceof UserCreationGroupListResponse) == false) goto L127;
            r25 = ((UserCreationGroupListResponse) r21).c();
            if (r25 != null) goto L128;
        L116:
            if ((r21 instanceof UserCreationGroupListResponse) == false) goto L118;
            r4 = ((UserCreationGroupListResponse) r21).b();
            goto L118
        L91:
            r13 = new ArrayList();
            goto L92
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r19);
            Object r26 = r19;
        L39:
            com.larus.network.http.a r27 = (com.larus.network.http.a) r26;
        L41:
            if ((r27 instanceof y) == false) goto L130;
            r21 = ((com.larus.network.http.a) ((y) r27)).b;
            if ((r21 instanceof b0) == false) goto L53;
            List<UserCreation> r28 = ((b0) r21).a();
            if (r28 == null) goto L73;
            List r29 = CollectionsKt.filterNotNull(r28);
            if (r29 == null) goto L73;
            List r30 = r29;
            ArrayList r31 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10));
            Iterator r32 = r30.iterator();
        L50:
            if (r32.hasNext() == false) goto L74;
            UserCreationModel r110 = new UserCreationModel(1, CollectionsKt.arrayListOf(new UserCreation[]{(UserCreation) r32.next()}), null, 4);
            a0.c(r110);
            r31.add(r110);
        L74:
            if (r31 != null) goto L77;
            r31 = new ArrayList();
        L77:
            if ((!r31.isEmpty()) != true) goto L79;
            boolean r33 = true;
        L80:
            if (r33 == false) goto L112;
            CreationPagerViewModel r34 = this.this$0;
            Integer r35 = this.$creationMode;
            this.L$0 = r21;
            this.label = 3;
            r6 = CreationPagerViewModel.access$prepareNoWatermarkForDetail(r34, r31, CreationPagerViewModel.CREATION_PROFILE_DETAIL_LOAD_MORE_SCENE, r35, this);
            if (r6 != r1) goto L84;
            return r1;
        L84:
            r3 = r21;
            goto L85
        L79:
            r33 = false;
        L73:
            r31 = null;
            goto L74
        L53:
            if ((r21 instanceof UserCreationGroupListResponse) == false) goto L55;
            UserCreationGroupListResponse r36 = (UserCreationGroupListResponse) r21;
        L56:
            if (r36 == null) goto L73;
            List<UserCreationGroup> r37 = r36.a();
            if (r37 == null) goto L73;
            ArrayList r38 = new ArrayList();
            Iterator<T> r39 = r37.iterator();
        L61:
            if (r39.hasNext() == false) goto L72;
            UserCreationGroup r111 = (UserCreationGroup) r39.next();
            if (r111 == null) goto L70;
            List<UserCreation> r112 = r111.a();
            if (r112 == null) goto L70;
            List r113 = CollectionsKt.filterNotNull(r112);
            if (r113 == null) goto L70;
            List r114 = CollectionsKt.toMutableList(r113);
            if (r114 == null) goto L70;
        L71:
            UserCreationModel r115 = new UserCreationModel(2, r114, null, 4);
            a0.c(r115);
            r38.add(r115);
        L70:
            r114 = new ArrayList();
            goto L71
        L72:
            r31 = r38;
            goto L74
        L55:
            r36 = null;
            goto L56
        L11:
            ResultKt.throwOnFailure(r19);
            Object r40 = r19;
        L22:
            r27 = (com.larus.network.http.a) r40;
            goto L41
        L12:
            ResultKt.throwOnFailure(r19);
            Integer r41 = this.$creationMode;
            if (r41 != null) goto L16;
        L23:
            Lazy<ProfileRepo> r42 = ProfileRepo.b;
            ProfileRepo r43 = ProfileRepo.a.a();
            String r116 = this.$visitId;
            String r117 = this.this$0.getCursor();
            Integer r44 = this.$creationMode;
            if (r44 != null) goto L27;
        L29:
            if (r44 != null) goto L32;
        L35:
            Integer r118 = null;
        L36:
            x r119 = new x(20, r116, r117, r118, DowngradeSource.LOAD_MORE.getValue(), null, null, 96);
            this.label = 2;
            r43.getClass();
            r26 = ProfileRepo.d(r119, this);
            if (r26 != r1) goto L39;
            return r1;
        L32:
            if (r44.intValue() != 1) goto L35;
            Integer r45 = Boxing.boxInt(1);
        L34:
            r118 = r45;
            goto L36
        L27:
            if (r44.intValue() != 2) goto L29;
            r45 = Boxing.boxInt(2);
            goto L34
        L16:
            if (r41.intValue() != 2) goto L23;
            if (u.e() == false) goto L23;
            Lazy<ProfileRepo> r46 = ProfileRepo.b;
            ProfileRepo r47 = ProfileRepo.a.a();
            String r48 = this.$visitId;
            String r49 = this.this$0.getCursor();
            String r120 = DowngradeSource.LOAD_MORE.getValue();
            this.label = 1;
            r47.getClass();
            r40 = ProfileRepo.b(20, r48, r49, r120, this);
            if (r40 != r1) goto L22;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.viewmodel.CreationPagerViewModel$prepareNoWatermarkForDetail$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.viewmodel.CreationPagerViewModel", f = "CreationPagerViewModel.kt", i = {0}, l = {410}, m = "prepareNoWatermarkForDetail", n = {"creationList"}, s = {"L$0"})
    public static final class C01041 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CreationPagerViewModel this$0;

        public C01041(CreationPagerViewModel r1, Continuation<? super C01041> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return CreationPagerViewModel.access$prepareNoWatermarkForDetail(this.this$0, null, null, null, this);
        }
    }

    static {
        Companion = new a();
    }

    public final int getCurrentIndex() {
        String r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        List r2 = (List) this.feedData.getValue();     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        UserCreationModel r3 = (UserCreationModel) ListProtector.get(r2, this.currentPagerIndex);     // Catch: Throwable -> L9
    L7:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L9
    L12:
        if (Result.exceptionOrNull-impl(r4) == null) goto L15;
        r4 = null;
    L15:
        UserCreationModel r5 = (UserCreationModel) r4;
        if (r5 == null) goto L18;
        r0 = r5.d();
    L18:
        List r6 = (List) this.realCreationList.getValue();
        int r7 = 0;
        if (r6 == null) goto L28;
        Iterator r8 = r6.iterator();
    L22:
        if (r8.hasNext() == false) goto L27;
        if (Intrinsics.areEqual(((UserCreationModel) r8.next()).d(), r0) == true) goto L28;
        r7 = r7 + 1;
        goto L22
    L27:
        r7 = -1;
    L28:
        FLogger.a.i(TAG, "greationListgerIndex is " + this.currentPagerIndex + " ; real index is " + r7);
        return r7;
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void addLoading() {
        ArrayList r0 = new ArrayList();
        List r1 = (List) this.feedData.getValue();
        if (r1 == null) goto L5;
        List r2 = r1;
    L6:
        r0.addAll(r2);
        UserCreationModel r3 = new UserCreationModel(0, null, null, 7);
        a0.c(r3);
        r0.add(r3);
        this.feedData.postValue(r0);
        return;
    L5:
        r2 = new ArrayList();
        goto L6
    }

    public final List<UserCreationModel> getCurrentCreationList() {
        List r0 = (List) this.realCreationList.getValue();
        if (r0 == null) goto L7;
        List<UserCreationModel> r1 = CollectionsKt.toMutableList(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    public final int getItemCountWithoutLoading() {
        List r0 = (List) this.feedData.getValue();
        if (r0 == null) goto L14;
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L16;
        Object r3 = r2.next();
        List<UserCreation> r4 = ((UserCreationModel) r3).b();
        boolean r5 = false;
        if (r4 != null) goto L10;
    L12:
        if (r5 == false) goto L6;
        r1.add(r3);
        goto L6
    L10:
        if ((!r4.isEmpty()) != true) goto L12;
        r5 = true;
    L16:
        return r1.size();
    L14:
        r1 = new ArrayList();
        goto L16
    }

    public CreationPagerViewModel() {
        this.cursor = "";
        this.feedData = new MutableLiveData(new ArrayList());
        this.realCreationList = new MutableLiveData(new ArrayList());
    }

    public final int getCreationMode() {
        return this.creationMode;
    }

    public final d getCreationPagerInitParams() {
        return this.creationPagerInitParams;
    }

    public final int getCurrentIndexInFeedData() {
        return this.currentPagerIndex;
    }

    public final int getCurrentPagerIndex() {
        return this.currentPagerIndex;
    }

    public final String getCursor() {
        return this.cursor;
    }

    public final MutableLiveData<List<UserCreationModel>> getFeedData() {
        return this.feedData;
    }

    public final boolean getHasInit() {
        return this.hasInit;
    }

    public final boolean getHasmore() {
        return this.hasmore;
    }

    public final MutableLiveData<List<UserCreationModel>> getRealCreationList() {
        return this.realCreationList;
    }

    private final List<UserCreationModel> filterBanCreation(List<UserCreationModel> r12) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator<T> r13 = r12.iterator();
    L3:
        boolean r4 = true;
        if (r13.hasNext() == false) goto L13;
        Object r3 = r13.next();
        UserCreationModel r6 = (UserCreationModel) r3;
        if (this.creationMode == 2) goto L8;
    L10:
        r4 = false;
    L11:
        if (r4 == true) goto L3;
        r2.add(r3);
        goto L3
    L8:
        if (a0.b(r6) == false) goto L10;
    L13:
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r5 = r2.iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        r14.add(a0.a((UserCreationModel) r5.next()));
        goto L15
    L17:
        r1.addAll(r14);
        Iterator r15 = r1.iterator();
    L19:
        if (r15.hasNext() == false) goto L51;
        UserCreationModel r7 = (UserCreationModel) r15.next();
        List<UserCreation> r8 = r7.b();
        if (r8 == null) goto L41;
        ArrayList r9 = new ArrayList();
        Iterator<T> r10 = r8.iterator();
    L24:
        if (r10.hasNext() == false) goto L39;
        Object r11 = r10.next();
        UserCreation r16 = (UserCreation) r11;
        Integer r17 = r16.c;
        if (r17 != null) goto L29;
    L30:
        Integer r18 = r16.c;
        if (r18 != null) goto L34;
    L35:
        boolean r19 = true;
    L37:
        if (r19 == false) goto L24;
        r9.add(r11);
        goto L24
    L34:
        if (r18.intValue() != 100) goto L35;
    L36:
        r19 = false;
        goto L37
    L29:
        if (r17.intValue() == 5) goto L36;
    L39:
        List<UserCreation> r20 = CollectionsKt.toMutableList(r9);
        if (r20 == null) goto L41;
    L42:
        r7.e(r20);
        List<UserCreation> r21 = r7.b();
        if (r21 != null) goto L45;
    L48:
        boolean r22 = true;
    L49:
        if (r22 == false) goto L19;
        r0.add(r7);
        goto L19
    L45:
        if (r21.isEmpty() == true) goto L48;
        r22 = false;
    L41:
        r20 = new ArrayList();
        goto L42
    L51:
        r1.removeAll(r0);
        return r1;
    }

    private final void initPosition(int r5) {
        Collection r0 = (Collection) this.feedData.getValue();
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        List r3 = (List) this.feedData.getValue();
        List r4 = (List) this.realCreationList.getValue();
        if (r4 == null) goto L17;
        UserCreationModel r6 = (UserCreationModel) CollectionsKt.getOrNull(r4, r5);
        if (r6 == null) goto L17;
        String r7 = r6.d();
        if (r7 == null) goto L17;
    L19:
        if (Intrinsics.areEqual(r7, "") == false) goto L21;
        this.currentPagerIndex = 0;
    L30:
        FLogger.a.i(TAG, "initPosition pos:" + r5 + " currentPagerIndex:" + this.currentPagerIndex);
        return;
    L21:
        if (r3 == null) goto L30;
        Iterator r8 = r3.iterator();
    L24:
        if (r8.hasNext() == false) goto L30;
        if (Intrinsics.areEqual(((UserCreationModel) r8.next()).d(), r7) == true) goto L27;
        r1 = r1 + 1;
        goto L24
    L27:
        this.currentPagerIndex = r1;
        return;
    L17:
        r7 = "";
        goto L19
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    private final List<UserCreationModel> selectNoWatermarkCreationList(List<UserCreationModel> r9) {
        List<UserCreationModel> r10 = r9;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L17;
        UserCreationModel r2 = (UserCreationModel) r11.next();
        List<UserCreation> r3 = r2.b();
        if (r3 != null) goto L8;
        r3 = CollectionsKt.emptyList();
    L8:
        List<UserCreation> r4 = r3;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L10:
        if (r6.hasNext() == false) goto L16;
        UserCreation r7 = (UserCreation) r6.next();
        UserCreation r8 = CreationNoWatermarkManager.a.f0(r7, false);
        if (r8 == null) goto L15;
        r7 = r8;
    L15:
        r5.add(r7);
        goto L10
    L16:
        r0.add(UserCreationModel.a(r2, CollectionsKt.toMutableList(r5)));
        goto L4
    L17:
        return r0;
    }

    private final boolean shouldPrepareNoWatermarkForDetail(List<UserCreationModel> r5) {
        if (CreationNoWatermarkManager.a.D() == true) goto L5;
        return false;
    L5:
        List<UserCreationModel> r6 = r5;
        if ((r6 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L44;
        List<UserCreation> r0 = ((UserCreationModel) r7.next()).b();
        if (r0 != null) goto L16;
        r0 = CollectionsKt.emptyList();
    L16:
        List<UserCreation> r1 = r0;
        if ((r1 instanceof Collection) == true) goto L19;
    L21:
        Iterator<T> r2 = r1.iterator();
    L23:
        if (r2.hasNext() == false) goto L20;
        if (((UserCreation) r2.next()).b == 1) goto L27;
        boolean r3 = true;
    L28:
        if (r3 == false) goto L23;
        boolean r4 = true;
    L30:
        if (r4 == false) goto L12;
        return true;
    L27:
        r3 = false;
    L20:
        r4 = false;
        goto L30
    L19:
        if (r1.isEmpty() == false) goto L21;
    L44:
        return false;
    L8:
        if (r6.isEmpty() == false) goto L10;
        return false;
    }

    private final boolean shouldResolveNoWatermarkForDetail(Integer r3) {
        if (r3 != null) goto L6;
    L7:
        if (r3 != null) goto L10;
    L12:
        return false;
    L10:
        if (r3.intValue() != 2) goto L12;
        return true;
    L6:
        if (r3.intValue() != 1) goto L7;
        return true;
    }

    public final void deleteCreation(int r11) {
        ArrayList r0 = new ArrayList();
        List r1 = (List) this.feedData.getValue();
        if (r1 == null) goto L8;
        List r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L9;
        r3.add(a0.a((UserCreationModel) r4.next()));
    L9:
        r0.addAll(r3);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L12
        Object r6 = Result.constructor-impl((UserCreationModel) ListProtector.get(r0, this.currentPagerIndex));     // Catch: Throwable -> L12
    L14:
        Object r7 = null;
        if (Result.exceptionOrNull-impl(r6) == null) goto L18;
        r6 = null;
    L18:
        UserCreationModel r8 = (UserCreationModel) r6;
        if (r8 != null) goto L110;
        return;
    L110:
        List<UserCreation> r9 = r8.b();     // Catch: Throwable -> L27
        if (r9 == null) goto L24;
        UserCreation r12 = (UserCreation) ListProtector.get(r9, r11);     // Catch: Throwable -> L27
    L25:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L27
    L30:
        if (Result.exceptionOrNull-impl(r13) == null) goto L33;
        r13 = null;
    L33:
        UserCreation r14 = (UserCreation) r13;
        if (r14 != null) goto L36;
        return;
    L36:
        ArrayList r10 = new ArrayList();
        List r15 = (List) this.realCreationList.getValue();
        if (r15 == null) goto L42;
        List r16 = r15;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r18 = r16.iterator();
    L40:
        if (r18.hasNext() == false) goto L43;
        r17.add(a0.a((UserCreationModel) r18.next()));
    L43:
        r10.addAll(r17);
        Iterator r19 = r10.iterator();
        int r20 = 0;
    L44:
        int r21 = -1;
        if (r19.hasNext() == false) goto L50;
        if (Intrinsics.areEqual(((UserCreationModel) r19.next()).d(), r8.d()) == true) goto L51;
        r20 = r20 + 1;
    L51:
        if (r20 >= 0) goto L116;
        return;
    L116:
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L55
        Object r23 = Result.constructor-impl((UserCreationModel) ListProtector.get(r10, r20));     // Catch: Throwable -> L55
    L58:
        if (Result.exceptionOrNull-impl(r23) != null) goto L60;
        r7 = r23;
    L60:
        UserCreationModel r24 = (UserCreationModel) r7;
        if (r24 != null) goto L63;
        return;
    L63:
        List<UserCreation> r25 = r24.b();
        if (r25 == null) goto L72;
        Iterator<UserCreation> r26 = r25.iterator();
        int r27 = 0;
    L67:
        if (r26.hasNext() == false) goto L72;
        if (Intrinsics.areEqual(r26.next().a, r14.a) == true) goto L70;
        r27 = r27 + 1;
        goto L67
    L70:
        r21 = r27;
    L72:
        if (r21 >= 0) goto L112;
        return;
    L112:
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L99
        List<UserCreation> r29 = r8.b();     // Catch: Throwable -> L99
        if (r29 == null) goto L77;
        r29.remove(r14);     // Catch: Throwable -> L99
    L77:
        List<UserCreation> r30 = r8.b();     // Catch: Throwable -> L99
        boolean r31 = true;
        if (r30 != null) goto L80;
    L83:
        boolean r32 = true;
    L84:
        if (r32 == false) goto L86;
        r0.remove(r8);     // Catch: Throwable -> L99
    L86:
        List<UserCreation> r33 = r24.b();     // Catch: Throwable -> L99
        if (r33 == null) goto L89;
        UserCreation r34 = (UserCreation) ListProtector.remove(r33, r21);     // Catch: Throwable -> L99
    L89:
        List<UserCreation> r35 = r24.b();     // Catch: Throwable -> L99
        if (r35 != null) goto L92;
    L95:
        if (r31 == false) goto L97;
        r10.remove(r24);     // Catch: Throwable -> L99
    L97:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L99
    L101:
        this.feedData.postValue(r0);
        this.realCreationList.postValue(r10);
        d r36 = this.creationPagerInitParams;
        if (r36 == null) goto L124;
        e r37 = r36.a;
        if (r37 == null) goto L125;
        String r38 = r14.a;
        if (r38 != null) goto L108;
        r38 = "";
    L108:
        r37.deleteUserCreation(r38, false);
        FLogger.a.i(TAG, "deleteCreation by outerSide:" + r14.a);
        return;
    L125:
        return;
    L124:
        return;
    L92:
        if (r35.isEmpty() == true) goto L95;
        r31 = false;
        goto L95
    L80:
        if (r30.isEmpty() == true) goto L83;
        r32 = false;
    L99:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L55:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L50:
        r20 = -1;
        goto L51
    L42:
        r17 = new ArrayList();
        goto L43
    L24:
        r12 = null;
    L27:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
    L12:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L8:
        r3 = new ArrayList();
        goto L9
    }

    public final void initParams(d r1) {
        this.creationPagerInitParams = r1;
    }

    public final void setCreationMode(int r1) {
        this.creationMode = r1;
    }

    public final void setCreationPagerInitParams(d r1) {
        this.creationPagerInitParams = r1;
    }

    public final void setCurrentPagerIndex(int r1) {
        this.currentPagerIndex = r1;
    }

    public final void setCursor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cursor = r2;
    }

    public final void setHasInit(boolean r1) {
        this.hasInit = r1;
    }

    public final void setHasmore(boolean r1) {
        this.hasmore = r1;
    }

    public final void updatePagerIndex(int r1) {
        this.currentPagerIndex = r1;
    }

    public static final /* synthetic */ List access$filterBanCreation(CreationPagerViewModel r0, List r1) {
        return r0.filterBanCreation(r1);
    }

    public final UserCreation getCurrentCreation(int r4, int r5) {
        List r0 = (List) this.feedData.getValue();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        UserCreationModel r6 = (UserCreationModel) ListProtector.get(r0, r5);     // Catch: Throwable -> L10
        if (r6 == null) goto L7;
    L8:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L10
    L13:
        if (Result.exceptionOrNull-impl(r7) == null) goto L16;
        r7 = null;
    L16:
        UserCreationModel r8 = (UserCreationModel) r7;
        if (r8 != null) goto L35;
        return null;
    L35:
        List<UserCreation> r9 = r8.b();     // Catch: Throwable -> L25
        if (r9 == null) goto L22;
        UserCreation r10 = (UserCreation) ListProtector.get(r9, r4);     // Catch: Throwable -> L25
    L23:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L25
    L28:
        if (Result.exceptionOrNull-impl(r11) == null) goto L31;
        r11 = null;
    L31:
        UserCreation r12 = (UserCreation) r11;
        if (r12 != null) goto L34;
        return null;
    L34:
        return r12;
    L22:
        r10 = null;
    L25:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r6 = null;
    L10:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final void loadFeedData(String r8, Integer r9) {
        Intrinsics.checkNotNullParameter(r8, "visitId");
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(r9, r8, this, null), 3, null);
    }

    public final void updateCreationContent(ModifiedUserCreationMusic r27, int r28) {
        FLogger.a.i(TAG, "updateCreationContent content is " + r27);
        if (r27 == null) goto L5;
        String r4 = r27.a;
    L6:
        if (r27 == null) goto L8;
        ImageInfo r6 = r27.b;
    L9:
        if (r27 == null) goto L11;
        String r7 = r27.c;
    L12:
        ArrayList r8 = new ArrayList();
        List r0 = (List) this.feedData.getValue();
        if (r0 == null) goto L18;
        List r1 = r0;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r2 = r1.iterator();
    L16:
        if (r2.hasNext() == false) goto L19;
        r10.add(a0.a((UserCreationModel) r2.next()));
    L19:
        r8.addAll(r10);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L22
        Object r5 = Result.constructor-impl((UserCreationModel) ListProtector.get(r8, this.currentPagerIndex));     // Catch: Throwable -> L22
    L25:
        if (Result.exceptionOrNull-impl(r5) == null) goto L28;
        r5 = null;
    L28:
        UserCreationModel r11 = (UserCreationModel) r5;
        if (r11 != null) goto L136;
        return;
    L136:
        List<UserCreation> r9 = r11.b();     // Catch: Throwable -> L37
        if (r9 == null) goto L34;
        UserCreation r12 = (UserCreation) ListProtector.get(r9, r28);     // Catch: Throwable -> L37
    L35:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L37
    L40:
        if (Result.exceptionOrNull-impl(r13) == null) goto L43;
        r13 = null;
    L43:
        UserCreation r15 = (UserCreation) r13;
        if (r15 != null) goto L46;
        return;
    L46:
        ArrayList r14 = new ArrayList();
        List r16 = (List) this.realCreationList.getValue();
        if (r16 == null) goto L52;
        List r17 = r16;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
    L50:
        if (r19.hasNext() == false) goto L53;
        r18.add(a0.a((UserCreationModel) r19.next()));
    L53:
        r14.addAll(r18);
        Iterator r20 = r14.iterator();
        int r21 = 0;
        int r110 = 0;
    L54:
        int r111 = -1;
        if (r20.hasNext() == false) goto L60;
        if (Intrinsics.areEqual(((UserCreationModel) r20.next()).d(), r11.d()) == true) goto L58;
        r110 = r110 + 1;
        goto L54
    L58:
        int r22 = r110;
    L61:
        if (r22 >= 0) goto L134;
        return;
    L134:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L65
        Object r24 = Result.constructor-impl((UserCreationModel) ListProtector.get(r14, r22));     // Catch: Throwable -> L65
    L68:
        if (Result.exceptionOrNull-impl(r24) == null) goto L71;
        r24 = null;
    L71:
        UserCreationModel r25 = (UserCreationModel) r24;
        if (r25 != null) goto L74;
        return;
    L74:
        List<UserCreation> r26 = r25.b();
        if (r26 == null) goto L84;
        Iterator<UserCreation> r29 = r26.iterator();
    L78:
        if (r29.hasNext() == false) goto L83;
        if (Intrinsics.areEqual(r29.next().a, r15.a) == true) goto L81;
        r21 = r21 + 1;
        goto L78
    L81:
        r111 = r21;
    L83:
        int r30 = r111;
    L85:
        if (r30 >= 0) goto L87;
        return;
    L87:
        UserCreationContent r31 = r15.e;
        if (r31 == null) goto L90;
        UserCreationContent r112 = UserCreationContent.a(r31, null, null, null, null, 63);
    L91:
        UserCreation r113 = UserCreation.c(r15, null, r112, null, null, null, null, 131055);
        UserCreationContent r114 = r113.e;
        if (r114 == null) goto L100;
        UserCreationContent r32 = r15.e;
        if (r32 == null) goto L98;
        UserCreationMusic r33 = r32.b;
        if (r33 == null) goto L98;
        UserCreationMusic r34 = UserCreationMusic.a(r33);
    L99:
        r114.b = r34;
    L98:
        r34 = null;
    L100:
        if (r6 == null) goto L107;
        UserCreationContent r35 = r113.e;
        if (r35 == null) goto L107;
        UserCreationMusic r36 = r35.b;
        if (r36 == null) goto L107;
        r36.d = r6;
    L107:
        if (o0.d(r4) == false) goto L114;
        UserCreationContent r37 = r113.e;
        if (r37 == null) goto L114;
        UserCreationMusic r38 = r37.b;
        if (r38 == null) goto L114;
        r38.b = r4;
    L114:
        if (o0.d(r7) == false) goto L120;
        UserCreationContent r39 = r113.e;
        if (r39 == null) goto L120;
        UserCreationMusic r40 = r39.b;
        if (r40 == null) goto L120;
        r40.f = r7;
    L120:
        List<UserCreation> r41 = ((UserCreationModel) ListProtector.get(r8, this.currentPagerIndex)).b();
        if (r41 == null) goto L123;
        UserCreation r42 = (UserCreation) ListProtector.set(r41, r28, r113);
    L123:
        UserCreationModel r43 = (UserCreationModel) ListProtector.get(r14, r22);
        if (r43 == null) goto L128;
        List<UserCreation> r44 = r43.b();
        if (r44 == null) goto L128;
        UserCreation r45 = (UserCreation) ListProtector.set(r44, r30, r113);
    L128:
        this.feedData.postValue(r8);
        this.realCreationList.postValue(r14);
        d r46 = this.creationPagerInitParams;
        if (r46 == null) goto L146;
        e r47 = r46.a;
        if (r47 == null) goto L147;
        r47.updateCreationContent(r113);
        FLogger.a.i(TAG, "updateCreationContent by outerSide:" + r113.a);
        return;
    L147:
        return;
    L146:
        return;
    L90:
        r112 = null;
        goto L91
    L84:
        r30 = -1;
    L65:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L68
    L60:
        r22 = -1;
        goto L61
    L52:
        r18 = new ArrayList();
        goto L53
    L34:
        r12 = null;
    L37:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
    L22:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L18:
        r10 = new ArrayList();
        goto L19
    L11:
        r7 = null;
        goto L12
    L8:
        r6 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }

    private final void applyFeedData(List<UserCreationModel> r6, Integer r7, Function0<Unit> r8) {
        MutableLiveData<List<UserCreationModel>> r0 = this.realCreationList;
        ArrayList r1 = new ArrayList();
        List<UserCreationModel> r2 = r6;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r3.add(a0.a((UserCreationModel) r4.next()));
        goto L4
    L6:
        r1.addAll(r3);
        r0.setValue(r1);
        List<UserCreationModel> r9 = filterBanCreation(r6);
        this.feedData.setValue(CollectionsKt.toMutableList(r9));
        if (this.hasInit == true) goto L15;
        this.hasInit = true;
        if (r7 == null) goto L11;
        initPosition(r7.intValue());
    L11:
        if (r8 == null) goto L16;
        r8.invoke();
        return;
    L16:
        return;
    }

    private final void updateCreationModelPrivacy(int r18, boolean r19, int r20) {
        ArrayList r4 = new ArrayList();
        List r0 = (List) this.feedData.getValue();
        if (r0 == null) goto L8;
        List r1 = r0;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L9;
        r6.add(a0.a((UserCreationModel) r2.next()));
    L9:
        r4.addAll(r6);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        Object r5 = Result.constructor-impl((UserCreationModel) ListProtector.get(r4, this.currentPagerIndex));     // Catch: Throwable -> L12
    L14:
        Object r7 = null;
        if (Result.exceptionOrNull-impl(r5) == null) goto L18;
        r5 = null;
    L18:
        UserCreationModel r8 = (UserCreationModel) r5;
        if (r8 != null) goto L119;
        return;
    L119:
        List<UserCreation> r9 = r8.b();     // Catch: Throwable -> L27
        if (r9 == null) goto L24;
        UserCreation r10 = (UserCreation) ListProtector.get(r9, r20);     // Catch: Throwable -> L27
    L25:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L27
    L30:
        if (Result.exceptionOrNull-impl(r11) == null) goto L33;
        r11 = null;
    L33:
        UserCreation r15 = (UserCreation) r11;
        if (r15 != null) goto L36;
        return;
    L36:
        ArrayList r14 = new ArrayList();
        List r12 = (List) this.realCreationList.getValue();
        if (r12 == null) goto L42;
        List r13 = r12;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r17 = r13.iterator();
    L40:
        if (r17.hasNext() == false) goto L43;
        r16.add(a0.a((UserCreationModel) r17.next()));
    L43:
        r14.addAll(r16);
        Iterator r21 = r14.iterator();
        int r22 = 0;
    L44:
        int r110 = -1;
        if (r21.hasNext() == false) goto L50;
        if (Intrinsics.areEqual(((UserCreationModel) r21.next()).d(), r8.d()) == true) goto L48;
        r22 = r22 + 1;
        goto L44
    L48:
        int r111 = r22;
    L51:
        if (r111 >= 0) goto L117;
        return;
    L117:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L55
        Object r24 = Result.constructor-impl((UserCreationModel) ListProtector.get(r14, r111));     // Catch: Throwable -> L55
    L58:
        if (Result.exceptionOrNull-impl(r24) != null) goto L60;
        r7 = r24;
    L60:
        UserCreationModel r25 = (UserCreationModel) r7;
        if (r25 != null) goto L63;
        return;
    L63:
        List<UserCreation> r26 = r25.b();
        if (r26 == null) goto L73;
        Iterator<UserCreation> r27 = r26.iterator();
        int r28 = 0;
    L67:
        if (r27.hasNext() == false) goto L72;
        if (Intrinsics.areEqual(r27.next().a, r15.a) == true) goto L70;
        r28 = r28 + 1;
        goto L67
    L70:
        r110 = r28;
    L72:
        int r29 = r110;
    L74:
        if (r29 >= 0) goto L76;
        return;
    L76:
        if (r19 == false) goto L101;
        List<UserCreation> r30 = r8.b();
        if (r30 == null) goto L80;
        r30.remove(r15);
    L80:
        List<UserCreation> r31 = r8.b();
        boolean r32 = true;
        if (r31 != null) goto L83;
    L86:
        boolean r33 = true;
    L87:
        if (r33 == false) goto L89;
        r4.remove(r8);
    L89:
        List<UserCreation> r34 = r25.b();
        if (r34 == null) goto L92;
        UserCreation r35 = (UserCreation) ListProtector.remove(r34, r29);
    L92:
        List<UserCreation> r36 = r25.b();
        if (r36 != null) goto L95;
    L98:
        if (r32 == false) goto L100;
        r14.remove(r25);
    L100:
        ArrayList r37 = r14;
        UserCreation r38 = r15;
    L109:
        this.feedData.postValue(r4);
        this.realCreationList.postValue(r37);
        d r39 = this.creationPagerInitParams;
        if (r39 == null) goto L127;
        e r40 = r39.a;
        if (r40 == null) goto L128;
        r40.updateCreationModelPrivacy(r18, r19, r38, false);
        FLogger.a.i(TAG, "updateCreationModelPrivacy by outerSide:" + r38.a);
        return;
    L128:
        return;
    L127:
        return;
    L95:
        if (r36.isEmpty() == true) goto L98;
        r32 = false;
        goto L98
    L83:
        if (r31.isEmpty() == true) goto L86;
        r33 = false;
        goto L87
    L101:
        int r41 = r111;
        r37 = r14;
        r38 = r15;
        UserCreation r42 = UserCreation.c(r15, Integer.valueOf(r18), null, null, null, null, null, 131063);
        List<UserCreation> r43 = ((UserCreationModel) ListProtector.get(r4, this.currentPagerIndex)).b();
        if (r43 == null) goto L104;
        UserCreation r44 = (UserCreation) ListProtector.set(r43, r20, r42);
    L104:
        UserCreationModel r45 = (UserCreationModel) ListProtector.get(r37, r41);
        if (r45 == null) goto L109;
        List<UserCreation> r46 = r45.b();
        if (r46 == null) goto L109;
        UserCreation r47 = (UserCreation) ListProtector.set(r46, r29, r42);
        goto L109
    L73:
        r29 = -1;
    L55:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L50:
        r111 = -1;
        goto L51
    L42:
        r16 = new ArrayList();
        goto L43
    L24:
        r10 = null;
    L27:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L12:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L8:
        r6 = new ArrayList();
        goto L9
    }

    public final void setCreationPrivacy(boolean r1, boolean r2, int r3) {
        if (r1 == false) goto L4;
        int r4 = 2;
    L5:
        updateCreationModelPrivacy(r4, r2, r3);
        return;
    L4:
        r4 = 1;
        goto L5
    }

    public final void updateFeedData(List<UserCreationModel> r4, Integer r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "creationList");
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        FLogger.a.i(TAG, "creationList size:" + r4.size() + " initPos:" + r5);
        if (shouldResolveNoWatermarkForDetail$default(this, null, 1, null) == true) goto L8;
    L10:
        applyFeedData(r4, r5, r6);
        return;
    L8:
        if (shouldPrepareNoWatermarkForDetail(r4) == false) goto L10;
        r4 = selectNoWatermarkCreationList(r4);
        goto L10
    }

    private final Object ensureNoWatermarkForDetail(List<UserCreationModel> r2, String r3, Integer r4, Continuation<? super Unit> r5) {
        if (shouldResolveNoWatermarkForDetail(r4) == false) goto L5;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r2.iterator();
    L8:
        if (r7.hasNext() == false) goto L13;
        List<UserCreation> r0 = ((UserCreationModel) r7.next()).b();
        if (r0 != null) goto L12;
        r0 = CollectionsKt.emptyList();
    L12:
        CollectionsKt.addAll(r6, r0);
        goto L8
    L13:
        Object r8 = CreationNoWatermarkManager.a.s(r6, r3, r5);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r8;
    L17:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void initParams$default(CreationPagerViewModel r0, d r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.initParams(r1);
    }

    private final Object prepareNoWatermarkForDetail(List<UserCreationModel> r5, String r6, Integer r7, Continuation<? super List<UserCreationModel>> r8) {
        if ((r8 instanceof C01041) == false) goto L7;
        C01041 r0 = (C01041) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = (List) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L23:
        return selectNoWatermarkCreationList(r5);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        if (shouldResolveNoWatermarkForDetail(r7) == true) goto L17;
        return r5;
    L17:
        if (shouldPrepareNoWatermarkForDetail(r5) == false) goto L25;
        r0.L$0 = r5;
        r0.label = 1;
        if (ensureNoWatermarkForDetail(r5, r6, r7, r0) != r2) goto L23;
        return r2;
    L25:
        return r5;
    L7:
        r0 = new C01041(this, r8);
        goto L8
    }

    public static /* synthetic */ boolean shouldResolveNoWatermarkForDetail$default(CreationPagerViewModel r0, Integer r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = Integer.valueOf(r0.creationMode);
    L6:
        return r0.shouldResolveNoWatermarkForDetail(r1);
    }

    public static final /* synthetic */ Object access$ensureNoWatermarkForDetail(CreationPagerViewModel r0, List r1, String r2, Integer r3, Continuation r4) {
        return r0.ensureNoWatermarkForDetail(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Object access$prepareNoWatermarkForDetail(CreationPagerViewModel r0, List r1, String r2, Integer r3, Continuation r4) {
        return r0.prepareNoWatermarkForDetail(r1, r2, r3, r4);
    }

    public static /* synthetic */ UserCreation getCurrentCreation$default(CreationPagerViewModel r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0.currentPagerIndex;
    L6:
        return r0.getCurrentCreation(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void applyFeedData$default(CreationPagerViewModel r0, List r1, Integer r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.applyFeedData(r1, r2, r3);
    }

    public static /* synthetic */ void setCreationPrivacy$default(CreationPagerViewModel r1, boolean r2, boolean r3, int r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        r1.setCreationPrivacy(r2, r3, r4);
    }

    public static /* synthetic */ void updateCreationModelPrivacy$default(CreationPagerViewModel r1, int r2, boolean r3, int r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        r1.updateCreationModelPrivacy(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateFeedData$default(CreationPagerViewModel r0, List r1, Integer r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.updateFeedData(r1, r2, r3);
    }

    public static /* synthetic */ Object ensureNoWatermarkForDetail$default(CreationPagerViewModel r0, List r1, String r2, Integer r3, Continuation r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = Integer.valueOf(r0.creationMode);
    L6:
        return r0.ensureNoWatermarkForDetail(r1, r2, r3, r4);
    }

    public static /* synthetic */ Object prepareNoWatermarkForDetail$default(CreationPagerViewModel r0, List r1, String r2, Integer r3, Continuation r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = Integer.valueOf(r0.creationMode);
    L6:
        return r0.prepareNoWatermarkForDetail(r1, r2, r3, r4);
    }
}
