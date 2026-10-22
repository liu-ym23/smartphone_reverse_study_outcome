package com.larus.profile.impl.creation.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.community.api.ICommunityService;
import com.larus.im.bean.message.AICreationTaskDurationInfo;
import com.larus.im.bean.message.Message;
import com.larus.network.http.y;
import com.larus.platform.api.UserCreationPrivateStatus;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.profile.impl.ProfileRepo;
import com.larus.profile.impl.creation.repository.ProfileCreationFeedPrivateTabRepository;
import com.larus.profile.impl.creation.repository.ProfileCreationFeedRepository;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import t19.s;
import tx9.e2;
import tx9.o0;
import tx9.u;
import zp9.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J:\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00192\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u0013H\u0086@¢\u0006\u0002\u0010%J@\u0010&\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010\u00192\b\u0010'\u001a\u0004\u0018\u00010\u00192\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u001f2\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u0013H\u0086@¢\u0006\u0002\u0010+R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006-"}, d2 = {"Lcom/larus/profile/impl/creation/viewmodel/ProfileCreationViewModelV2;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "profileCreationFeedRepository", "Lcom/larus/profile/impl/creation/repository/ProfileCreationFeedRepository;", "getProfileCreationFeedRepository", "()Lcom/larus/profile/impl/creation/repository/ProfileCreationFeedRepository;", "profileCreationFeedRepository$delegate", "Lkotlin/Lazy;", "profileCreationFeedPrivateTabRepository", "Lcom/larus/profile/impl/creation/repository/ProfileCreationFeedPrivateTabRepository;", "getProfileCreationFeedPrivateTabRepository", "()Lcom/larus/profile/impl/creation/repository/ProfileCreationFeedPrivateTabRepository;", "profileCreationFeedPrivateTabRepository$delegate", "profileStatusLiveData", "Landroidx/lifecycle/LiveData;", "", "getProfileStatusLiveData", "()Landroidx/lifecycle/LiveData;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "userId", "", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "deleteUserCreation", "", "userCreationModel", "Lcom/larus/profile/api/bean/UserCreationModel;", "currentPage", "previousPage", "privateStatus", "(Lcom/larus/profile/api/bean/UserCreationModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "modifyUserCreationPrivacyStatus", "recommendFrom", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "splitMode", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/api/creation/UserCreation;ZLjava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileCreationViewModelV2 extends AndroidViewModel {
    public static final a Companion = null;
    private static final int PAGE_SIZE = 20;
    private final kotlinx.coroutines.sync.a mutex;
    private final Lazy profileCreationFeedPrivateTabRepository$delegate;
    private final Lazy profileCreationFeedRepository$delegate;
    private String userId;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.creation.viewmodel.ProfileCreationViewModelV2$deleteUserCreation$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.creation.viewmodel.ProfileCreationViewModelV2", f = "ProfileCreationViewModelV2.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l = {214, 55, 61, 89, 95}, m = "deleteUserCreation", n = {"userCreationModel", "currentPage", "previousPage", "privateStatus", "$this$withLock_u24default$iv", "userCreationModel", "currentPage", "previousPage", "privateStatus", "$this$withLock_u24default$iv", "userCreationModel", "currentPage", "previousPage", "privateStatus", "$this$withLock_u24default$iv", "userCreationModel", "currentPage", "previousPage", "$this$withLock_u24default$iv", "userCreationModel", "currentPage", "previousPage", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ProfileCreationViewModelV2 this$0;

        public AnonymousClass1(ProfileCreationViewModelV2 r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.deleteUserCreation(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.creation.viewmodel.ProfileCreationViewModelV2$modifyUserCreationPrivacyStatus$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.creation.viewmodel.ProfileCreationViewModelV2", f = "ProfileCreationViewModelV2.kt", i = {0, 0, 0, 1, 1, 2, 2, 3}, l = {151, 214, 164, 189}, m = "modifyUserCreationPrivacyStatus", n = {"previousPage", "recommendFrom", "creation", "creation", "$this$withLock_u24default$iv", "creation", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$0"})
    public static final class C00971 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ProfileCreationViewModelV2 this$0;

        public C00971(ProfileCreationViewModelV2 r1, Continuation<? super C00971> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.modifyUserCreationPrivacyStatus(null, null, null, false, null, this);
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ProfileCreationFeedPrivateTabRepository Mo(ProfileCreationViewModelV2 r0) {
        return profileCreationFeedPrivateTabRepository_delegate$lambda$1(r0);
    }

    public static /* synthetic */ ProfileCreationFeedRepository yo(ProfileCreationViewModelV2 r0) {
        return profileCreationFeedRepository_delegate$lambda$0(r0);
    }

    public final ProfileCreationFeedPrivateTabRepository getProfileCreationFeedPrivateTabRepository() {
        return (ProfileCreationFeedPrivateTabRepository) this.profileCreationFeedPrivateTabRepository$delegate.getValue();
    }

    public final ProfileCreationFeedRepository getProfileCreationFeedRepository() {
        return (ProfileCreationFeedRepository) this.profileCreationFeedRepository$delegate.getValue();
    }

    public final LiveData<Integer> getProfileStatusLiveData() {
        ProfileCreationFeedRepository r0 = getProfileCreationFeedRepository();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    public final String getUserId() {
        return this.userId;
    }

    public ProfileCreationViewModelV2(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        this.profileCreationFeedRepository$delegate = LazyKt.lazy(new com.larus.profile.impl.creation.viewmodel.a(this));
        this.profileCreationFeedPrivateTabRepository$delegate = LazyKt.lazy(new b(this));
        this.mutex = kotlinx.coroutines.sync.b.a();
        this.userId = "";
    }

    private static final ProfileCreationFeedPrivateTabRepository profileCreationFeedPrivateTabRepository_delegate$lambda$1(ProfileCreationViewModelV2 r1) {
        return new ProfileCreationFeedPrivateTabRepository(r1.userId);
    }

    private static final ProfileCreationFeedRepository profileCreationFeedRepository_delegate$lambda$0(ProfileCreationViewModelV2 r1) {
        return new ProfileCreationFeedRepository(r1.userId);
    }

    public final void setUserId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userId = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v5, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v58 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v62 */
    /* JADX WARN: Type inference failed for: r3v63 */
    /* JADX WARN: Type inference failed for: r3v7, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r3v76 */
    /* JADX WARN: Type inference failed for: r3v77 */
    /* JADX WARN: Type inference failed for: r3v78 */
    /* JADX WARN: Type inference failed for: r3v79 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v80 */
    /* JADX WARN: Type inference failed for: r3v81 */
    /* JADX WARN: Type inference failed for: r3v82 */
    /* JADX WARN: Type inference failed for: r3v83 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v5 */
    public final Object deleteUserCreation(UserCreationModel r39, String r40, String r41, @UserCreationPrivateStatus Integer r42, Continuation<? super Boolean> r43) {
        if ((r43 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r2 = (AnonymousClass1) r43;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r4 = r2.label;
        boolean r16 = false;
        if (r4 == 0) goto L32;
        if (r4 != 1) goto L298;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) r2.L$4;
        Integer r6 = (Integer) r2.L$3;
        String r7 = (String) r2.L$2;
        String r8 = (String) r2.L$1;
        UserCreationModel r14 = (UserCreationModel) r2.L$0;
        ResultKt.throwOnFailure(r0);
        String r1 = r8;
        String r9 = r7;
        Integer r10 = r6;
        kotlinx.coroutines.sync.a r12 = r5;
    L283:
    L275:
        th = th;
        kotlinx.coroutines.sync.a r24 = r12;
        com.larus.network.http.a r13 = null;
    L85:
        ?? r15 = r24;
    L274:
        r4 = r15;
    L277:
        r4.unlock(r13);
        throw th;
    L37:
        if (r14.c() != 2) goto L296;
        Lazy<ProfileRepo> r17 = ProfileRepo.b;     // Catch: Throwable -> L275
        ProfileRepo r18 = ProfileRepo.a.a();     // Catch: Throwable -> L275
        List<UserCreation> r20 = r14.b();     // Catch: Throwable -> L275
        if (r20 == null) goto L290;
        List<UserCreation> r19 = r20;     // Catch: Throwable -> L48
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));     // Catch: Throwable -> L48
        Iterator r21 = r19.iterator();     // Catch: Throwable -> L48
    L42:
        if (r21.hasNext() == false) goto L51;
        String r111 = ((UserCreation) r21.next()).a;     // Catch: Throwable -> L48
        if (r111 != null) goto L46;
        r111 = "";
    L46:
        r110.add(r111);     // Catch: Throwable -> L48
    L51:
        Integer r22 = Boxing.boxInt(3);     // Catch: Throwable -> L60
        r2.L$0 = r14;     // Catch: Throwable -> L60
        r2.L$1 = r1;     // Catch: Throwable -> L60
        r2.L$2 = r9;     // Catch: Throwable -> L60
        r2.L$3 = r10;     // Catch: Throwable -> L60
        r2.L$4 = r12;     // Catch: Throwable -> L60
        r2.label = 2;     // Catch: Throwable -> L60
        Object r23 = ProfileRepo.a(r18, r110, r22, r2);     // Catch: Throwable -> L60
        if (r23 != r11) goto L54;
        return r11;
    L54:
        String r36 = r9;
        String r25 = r1;
        r0 = r23;
        r4 = r12;
        Integer r26 = r10;
        String r27 = r36;
    L285:
        com.larus.network.http.a r28 = (com.larus.network.http.a) r0;     // Catch: Throwable -> L58
        String r29 = r27;
        boolean r310 = true;
        r13 = null;
        int r112 = 2;
        ?? r30 = r4;
    L57:
        Integer r31 = r26;
        ?? r113 = r30;
        String r114 = r25;
    L292:
    L270:
        th = th;
    L271:
        r15 = r113;
        goto L274
    L289:
        if ((r28 instanceof y) == false) goto L140;
        s r32 = s.a;     // Catch: Throwable -> L270
        AppHost.Companion r33 = AppHost.a;     // Catch: Throwable -> L270
        Application r34 = r33.getApplication();     // Catch: Throwable -> L270
        String r35 = r33.getApplication().getString(2131900648);     // Catch: Throwable -> L270
        r32.getClass();     // Catch: Throwable -> L270
        s.p(r34, r35);     // Catch: Throwable -> L270
        if (r14.c() != r112) goto L100;
        List<UserCreation> r37 = r14.b();     // Catch: Throwable -> L270
        if (r37 == null) goto L108;
        Iterator r38 = r37.iterator();     // Catch: Throwable -> L270
    L95:
        if (r38.hasNext() == false) goto L108;
        UserCreation r44 = (UserCreation) r38.next();     // Catch: Throwable -> L270
        ICommunityService.Companion r45 = ICommunityService.a;     // Catch: Throwable -> L270
        String r46 = r44.a;     // Catch: Throwable -> L270
        if (r46 != null) goto L99;
        r46 = "";
    L99:
        r45.X0(r46);     // Catch: Throwable -> L270
    L108:
        List<UserCreation> r47 = r14.b();     // Catch: Throwable -> L270
        if (r47 == null) goto L113;
        UserCreation r48 = (UserCreation) CollectionsKt.firstOrNull(r47);     // Catch: Throwable -> L270
        if (r48 == null) goto L113;
        com.larus.network.http.a r311 = r48.a;     // Catch: Throwable -> L270
    L114:
        List<UserCreation> r49 = r14.b();     // Catch: Throwable -> L270
        if (r49 == null) goto L119;
        UserCreation r50 = (UserCreation) CollectionsKt.firstOrNull(r49);     // Catch: Throwable -> L270
        if (r50 == null) goto L119;
        com.larus.network.http.a r312 = d.d(r50);     // Catch: Throwable -> L270
    L120:
        List<UserCreation> r51 = r14.b();     // Catch: Throwable -> L270
        if (r51 == null) goto L130;
        UserCreation r52 = (UserCreation) CollectionsKt.firstOrNull(r51);     // Catch: Throwable -> L270
        if (r52 == null) goto L130;
        Integer r53 = r52.d;     // Catch: Throwable -> L270
        if (r53 == null) goto L130;
        if (r53.intValue() != r112) goto L130;
        r16 = true;
    L130:
        if (r16 == false) goto L132;
        String r313 = "0";
    L135:
        e2.a.b(new u(r29, r114, "1", r311, r312, r313, null, 129), r13, 3);     // Catch: Throwable -> L186
        Boolean r54 = Boxing.boxBoolean(r310);     // Catch: Throwable -> L186
        r113.unlock(r13);
        return r54;
    L132:
        r313 = "1";
    L119:
        r312 = r13;
    L113:
        r311 = r13;
        goto L114
    L100:
        ICommunityService.Companion r55 = ICommunityService.a;     // Catch: Throwable -> L270
        List<UserCreation> r56 = r14.b();     // Catch: Throwable -> L270
        if (r56 == null) goto L106;
        UserCreation r57 = (UserCreation) CollectionsKt.firstOrNull(r56);     // Catch: Throwable -> L270
        if (r57 == null) goto L106;
        String r58 = r57.a;     // Catch: Throwable -> L270
        if (r58 == null) goto L106;
    L107:
        r55.X0(r58);     // Catch: Throwable -> L270
    L106:
        r58 = "";
        goto L107
    L140:
        if (r14.c() != r112) goto L162;
        Lazy<ProfileRepo> r59 = ProfileRepo.b;     // Catch: Throwable -> L270
        ProfileRepo r60 = ProfileRepo.a.a();     // Catch: Throwable -> L270
        List<UserCreation> r61 = r14.b();     // Catch: Throwable -> L270
        if (r61 == null) goto L150;
        List<UserCreation> r62 = r61;     // Catch: Throwable -> L270
        ArrayList r63 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r62, 10));     // Catch: Throwable -> L270
        Iterator r64 = r62.iterator();     // Catch: Throwable -> L270
    L145:
        if (r64.hasNext() == false) goto L151;
        String r65 = ((UserCreation) r64.next()).a;     // Catch: Throwable -> L270
        if (r65 != null) goto L149;
        r65 = "";
    L149:
        r63.add(r65);     // Catch: Throwable -> L270
    L151:
        Integer r66 = Boxing.boxInt(3);     // Catch: Throwable -> L270
        r2.L$0 = r14;     // Catch: Throwable -> L270
        r2.L$1 = r114;     // Catch: Throwable -> L270
        r2.L$2 = r29;     // Catch: Throwable -> L270
        r2.L$3 = r113;     // Catch: Throwable -> L270
        r2.L$4 = r13;     // Catch: Throwable -> L160
        r2.label = 4;     // Catch: Throwable -> L270
        Object r67 = ProfileRepo.a(r60, r63, r66, r2);     // Catch: Throwable -> L270
        if (r67 != r11) goto L157;
        return r11;
    L157:
        String r68 = r29;
        r0 = r67;
        String r69 = r114;
        ?? r70 = r113;
        UserCreationModel r71 = r14;
    L158:
        com.larus.network.http.a r72 = (com.larus.network.http.a) r0;     // Catch: Throwable -> L238
        r14 = r71;
        String r210 = r68;
        String r211 = r69;
        int r115 = 3;
        ?? r73 = r70;
    L190:
        if ((r72 instanceof y) == false) goto L241;
        s r74 = s.a;     // Catch: Throwable -> L238
        AppHost.Companion r75 = AppHost.a;     // Catch: Throwable -> L238
        Application r76 = r75.getApplication();     // Catch: Throwable -> L238
        String r77 = r75.getApplication().getString(2131900648);     // Catch: Throwable -> L238
        r74.getClass();     // Catch: Throwable -> L238
        s.p(r76, r77);     // Catch: Throwable -> L238
        if (r14.c() != 2) goto L202;
        List<UserCreation> r78 = r14.b();     // Catch: Throwable -> L238
        if (r78 == null) goto L210;
        Iterator r79 = r78.iterator();     // Catch: Throwable -> L238
    L197:
        if (r79.hasNext() == false) goto L210;
        UserCreation r80 = (UserCreation) r79.next();     // Catch: Throwable -> L238
        ICommunityService.Companion r81 = ICommunityService.a;     // Catch: Throwable -> L238
        String r82 = r80.a;     // Catch: Throwable -> L238
        if (r82 != null) goto L201;
        r82 = "";
    L201:
        r81.X0(r82);     // Catch: Throwable -> L238
    L210:
        List<UserCreation> r83 = r14.b();     // Catch: Throwable -> L238
        if (r83 == null) goto L215;
        UserCreation r84 = (UserCreation) CollectionsKt.firstOrNull(r83);     // Catch: Throwable -> L238
        if (r84 == null) goto L215;
        com.larus.network.http.a r212 = r84.a;     // Catch: Throwable -> L238
    L216:
        List<UserCreation> r85 = r14.b();     // Catch: Throwable -> L238
        if (r85 == null) goto L221;
        UserCreation r86 = (UserCreation) CollectionsKt.firstOrNull(r85);     // Catch: Throwable -> L238
        if (r86 == null) goto L221;
        com.larus.network.http.a r213 = d.d(r86);     // Catch: Throwable -> L238
    L222:
        List<UserCreation> r87 = r14.b();     // Catch: Throwable -> L238
        if (r87 == null) goto L232;
        UserCreation r88 = (UserCreation) CollectionsKt.firstOrNull(r87);     // Catch: Throwable -> L238
        if (r88 == null) goto L232;
        Integer r89 = r88.d;     // Catch: Throwable -> L238
        if (r89 == null) goto L232;
        if (r89.intValue() != 2) goto L232;
        r16 = true;
    L232:
        if (r16 == false) goto L234;
        String r214 = "0";
    L235:
        e2.a.b(new u(r210, r211, "1", r212, r213, r214, null, 129), r13, r115);     // Catch: Throwable -> L238
        Boolean r90 = Boxing.boxBoolean(true);     // Catch: Throwable -> L238
        r73.unlock(r13);
        return r90;
    L234:
        r214 = "1";
    L221:
        r213 = r13;
    L215:
        r212 = r13;
        goto L216
    L202:
        ICommunityService.Companion r91 = ICommunityService.a;     // Catch: Throwable -> L238
        List<UserCreation> r92 = r14.b();     // Catch: Throwable -> L238
        if (r92 == null) goto L208;
        UserCreation r93 = (UserCreation) CollectionsKt.firstOrNull(r92);     // Catch: Throwable -> L238
        if (r93 == null) goto L208;
        String r94 = r93.a;     // Catch: Throwable -> L238
        if (r94 == null) goto L208;
    L209:
        r91.X0(r94);     // Catch: Throwable -> L238
    L208:
        r94 = "";
        goto L209
    L241:
        List<UserCreation> r95 = r14.b();     // Catch: Throwable -> L238
        if (r95 == null) goto L246;
        UserCreation r96 = (UserCreation) CollectionsKt.firstOrNull(r95);     // Catch: Throwable -> L238
        if (r96 == null) goto L246;
        com.larus.network.http.a r215 = r96.a;     // Catch: Throwable -> L238
    L247:
        List<UserCreation> r97 = r14.b();     // Catch: Throwable -> L238
        if (r97 == null) goto L252;
        UserCreation r98 = (UserCreation) CollectionsKt.firstOrNull(r97);     // Catch: Throwable -> L238
        if (r98 == null) goto L252;
        com.larus.network.http.a r216 = d.d(r98);     // Catch: Throwable -> L238
    L253:
        List<UserCreation> r99 = r14.b();     // Catch: Throwable -> L238
        if (r99 == null) goto L263;
        UserCreation r100 = (UserCreation) CollectionsKt.firstOrNull(r99);     // Catch: Throwable -> L238
        if (r100 == null) goto L263;
        Integer r101 = r100.d;     // Catch: Throwable -> L238
        if (r101 == null) goto L263;
        if (r101.intValue() != 2) goto L263;
        boolean r102 = true;
    L264:
        if (r102 == false) goto L266;
        String r217 = "0";
    L267:
        e2.a.b(new u(r210, r211, "0", r215, r216, r217, null, 129), r13, r115);     // Catch: Throwable -> L238
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L238
        r73.unlock(r13);
        return Boxing.boxBoolean(false);
    L266:
        r217 = "1";
    L263:
        r102 = false;
    L252:
        r216 = r13;
    L246:
        r215 = r13;
    L160:
        th = th;
        goto L271
    L150:
        r63 = new ArrayList();     // Catch: Throwable -> L270
        goto L151
    L162:
        List<UserCreation> r104 = r14.b();     // Catch: Throwable -> L270
        if (r104 == null) goto L188;
        UserCreation r105 = (UserCreation) CollectionsKt.firstOrNull(r104);     // Catch: Throwable -> L270
        if (r105 == null) goto L188;
        String r106 = r105.a;     // Catch: Throwable -> L270
        if (r106 == null) goto L188;
        Lazy<ProfileRepo> r107 = ProfileRepo.b;     // Catch: Throwable -> L270
        ProfileRepo r108 = ProfileRepo.a.a();     // Catch: Throwable -> L270
        Integer r109 = Boxing.boxInt(3);     // Catch: Throwable -> L270
        if (r31 != null) goto L172;
    L174:
        boolean r218 = false;
    L175:
        r2.L$0 = r14;     // Catch: Throwable -> L270
        r2.L$1 = r114;     // Catch: Throwable -> L270
        r2.L$2 = r29;     // Catch: Throwable -> L270
        r2.L$3 = r113;     // Catch: Throwable -> L270
        r2.L$4 = r13;     // Catch: Throwable -> L186
        r2.label = 5;     // Catch: Throwable -> L270
        r115 = 3;
        AnonymousClass1 r116 = r2;
        String r117 = r114;
        Object r118 = ProfileRepo.i(r108, r106, null, r109, null, r218, r116, 10);     // Catch: Throwable -> L270
        if (r118 != r11) goto L181;
        return r11;
    L181:
        String r119 = r29;
        String r120 = r117;
        r0 = r118;
        ?? r121 = r113;
        UserCreationModel r122 = r14;
    L281:
        r72 = (com.larus.network.http.a) r0;     // Catch: Throwable -> L184
        r14 = r122;
        r210 = r119;
        r211 = r120;
        r73 = r121;
    L184:
        th = th;
        r15 = r121;
        goto L274
    L172:
        if (r31.intValue() != 1) goto L174;
        r218 = true;
    L188:
        r115 = 3;
        r210 = r29;
        r211 = r114;
        r73 = r113;
        r72 = r13;
    L186:
        th = th;
        r4 = r113;
    L58:
        th = th;
    L59:
        r13 = null;
    L60:
        th = th;
    L61:
        r13 = null;
        r15 = r12;
    L48:
        th = th;
        r4 = r12;
        goto L59
    L290:
        r110 = new ArrayList();     // Catch: Throwable -> L60
        goto L51
    L296:
        List<UserCreation> r123 = r14.b();     // Catch: Throwable -> L272
        if (r123 == null) goto L86;
        UserCreation r124 = (UserCreation) CollectionsKt.firstOrNull(r123);     // Catch: Throwable -> L272
        if (r124 == null) goto L86;
        String r125 = r124.a;     // Catch: Throwable -> L272
        if (r125 == null) goto L86;
        Lazy<ProfileRepo> r126 = ProfileRepo.b;     // Catch: Throwable -> L272
        ProfileRepo r127 = ProfileRepo.a.a();     // Catch: Throwable -> L272
        Integer r128 = Boxing.boxInt(3);     // Catch: Throwable -> L272
        if (r10 != null) goto L72;
    L74:
        boolean r129 = false;
    L75:
        r2.L$0 = r14;     // Catch: Throwable -> L272
        r2.L$1 = r1;     // Catch: Throwable -> L272
        r2.L$2 = r9;     // Catch: Throwable -> L272
        r2.L$3 = r10;     // Catch: Throwable -> L272
        r2.L$4 = r12;     // Catch: Throwable -> L272
        r2.label = 3;     // Catch: Throwable -> L272
        r24 = r12;
        Integer r219 = r10;
        String r130 = r9;
        r13 = null;
        r310 = true;
        r112 = 2;
        Object r131 = ProfileRepo.i(r127, r125, null, r128, null, r129, r2, 10);     // Catch: Throwable -> L84
        if (r131 != r11) goto L80;
        return r11;
    L80:
        r25 = r1;
        r0 = r131;
        String r132 = r130;
        r4 = r24;
        r26 = r219;
    L293:
    L238:
        th = th;
        goto L277
    L82:
        r28 = (com.larus.network.http.a) r0;     // Catch: Throwable -> L238
        r29 = r132;
        r30 = r4;
    L84:
        th = th;
        goto L85
    L72:
        if (r10.intValue() != 1) goto L74;
        r129 = true;
    L86:
        r310 = true;
        r13 = null;
        r112 = 2;
        r114 = r1;
        r29 = r9;
        r28 = null;
        r113 = r12;
        r31 = r10;
    L272:
        th = th;
        goto L61
    L298:
        if (r4 == 2) goto L26;
        if (r4 == 3) goto L23;
        if (r4 == 4) goto L20;
        if (r4 != 5) goto L19;
        kotlinx.coroutines.sync.a r133 = (kotlinx.coroutines.sync.a) r2.L$3;
        r119 = (String) r2.L$2;
        r120 = (String) r2.L$1;
        r122 = (UserCreationModel) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L29
        r13 = null;
        r115 = 3;
        r121 = r133;
        goto L281
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        kotlinx.coroutines.sync.a r134 = (kotlinx.coroutines.sync.a) r2.L$3;
        r68 = (String) r2.L$2;
        r69 = (String) r2.L$1;
        r71 = (UserCreationModel) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L29
        r13 = null;
        r70 = r134;
        goto L158
    L23:
        kotlinx.coroutines.sync.a r135 = (kotlinx.coroutines.sync.a) r2.L$4;
        r26 = (Integer) r2.L$3;
        r132 = (String) r2.L$2;
        r25 = (String) r2.L$1;
        r14 = (UserCreationModel) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L29
        r13 = null;
        r310 = true;
        r112 = 2;
        r4 = r135;
        goto L293
    L26:
        kotlinx.coroutines.sync.a r136 = (kotlinx.coroutines.sync.a) r2.L$4;
        r26 = (Integer) r2.L$3;
        r27 = (String) r2.L$2;
        r25 = (String) r2.L$1;
        r14 = (UserCreationModel) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L29
        r4 = r136;
    L29:
        th = th;
        r13 = null;
        goto L277
    L32:
        ResultKt.throwOnFailure(r0);
        kotlinx.coroutines.sync.a r137 = this.mutex;
        r2.L$0 = r39;
        r2.L$1 = r40;
        r2.L$2 = r41;
        r2.L$3 = r42;
        r2.L$4 = r137;
        r2.label = 1;
        if (r137.a(null, r2) != r11) goto L35;
        return r11;
    L35:
        r14 = r39;
        r12 = r137;
        r1 = r40;
        r9 = r41;
        r10 = r42;
    L7:
        r2 = new AnonymousClass1(this, r43);
        goto L8
    }

    public final Object modifyUserCreationPrivacyStatus(String r39, String r40, UserCreation r41, boolean r42, @UserCreationPrivateStatus Integer r43, Continuation<? super Boolean> r44) {
        UserCreation r0 = r41;
        if ((r44 instanceof C00971) == false) goto L7;
        C00971 r3 = (C00971) r44;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        com.larus.network.http.a r10 = null;
        if (r5 == 0) goto L29;
        if (r5 == 1) goto L28;
        if (r5 == 2) goto L27;
        if (r5 == 3) goto L21;
        if (r5 != 4) goto L20;
        kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L17
        com.larus.network.http.a r14 = null;
        boolean r15 = true;
    L171:
        com.larus.network.http.a r11 = (com.larus.network.http.a) r2;     // Catch: Throwable -> L154
        kotlinx.coroutines.sync.a r7 = r6;
    L158:
        if ((r11 instanceof y) == false) goto L162;
        Boolean r1 = Boxing.boxBoolean(r15);     // Catch: Throwable -> L165
        r7.unlock(r14);
        return r1;
    L162:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L165
        r7.unlock(r14);
        return Boxing.boxBoolean(false);
    L154:
        th = th;
    L167:
        r6.unlock(r14);
        throw th;
    L17:
        th = th;
    L26:
        r14 = null;
        goto L167
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        kotlinx.coroutines.sync.a r9 = (kotlinx.coroutines.sync.a) r3.L$1;
        r0 = (UserCreation) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L24
        r14 = null;
        r15 = true;
    L175:
        r10 = (com.larus.network.http.a) r2;     // Catch: Throwable -> L107
        r7 = r9;
    L179:
    L165:
        th = th;
    L166:
        r6 = r7;
        goto L167
    L115:
        if ((r10 instanceof y) == false) goto L139;
        s r13 = s.a;     // Catch: Throwable -> L165
        Application r16 = AppHost.a.getApplication();     // Catch: Throwable -> L165
        Integer r17 = r0.d;     // Catch: Throwable -> L165
        if (r17 != null) goto L120;
    L122:
        int r18 = 2131900634;
    L123:
        r13.getClass();     // Catch: Throwable -> L165
        s.o(r16, r18, false);     // Catch: Throwable -> L165
        Integer r19 = r0.d;     // Catch: Throwable -> L165
        if (r19 != null) goto L127;
    L136:
        Boolean r20 = Boxing.boxBoolean(r15);     // Catch: Throwable -> L165
        r7.unlock(r14);
        return r20;
    L127:
        if (r19.intValue() != r15) goto L136;
        ICommunityService.Companion r21 = ICommunityService.a;     // Catch: Throwable -> L133
        String r22 = r0.a;     // Catch: Throwable -> L133
        if (r22 != null) goto L131;
        r22 = "";
    L131:
        r21.X0(r22);     // Catch: Throwable -> L133
    L133:
        th = th;
    L134:
        r9 = r7;
    L135:
        r6 = r9;
        goto L167
    L120:
        if (r17.intValue() != r15) goto L122;
        r18 = 2131900633;
        goto L123
    L139:
        String r23 = r0.a;     // Catch: Throwable -> L165
        if (r23 == null) goto L156;
        Lazy<ProfileRepo> r24 = ProfileRepo.b;     // Catch: Throwable -> L165
        ProfileRepo r25 = ProfileRepo.a.a();     // Catch: Throwable -> L165
        Integer r26 = r0.d;     // Catch: Throwable -> L165
        if (r26 != null) goto L145;
    L147:
        int r27 = 1;
    L148:
        Integer r28 = Boxing.boxInt(r27);     // Catch: Throwable -> L165
        r3.L$0 = r7;     // Catch: Throwable -> L165
        r3.L$1 = r14;     // Catch: Throwable -> L165
        r3.label = 4;     // Catch: Throwable -> L165
        Object r29 = ProfileRepo.i(r25, r23, null, null, r28, false, r3, 22);     // Catch: Throwable -> L165
        if (r29 != r12) goto L151;
        return r12;
    L151:
        r6 = r7;
        r2 = r29;
        goto L171
    L145:
        if (r26.intValue() != r15) goto L147;
        r27 = 2;
        goto L148
    L156:
        r11 = r14;
    L107:
        th = th;
    L24:
        th = th;
        r6 = r9;
        goto L26
    L27:
        kotlinx.coroutines.sync.a r30 = (kotlinx.coroutines.sync.a) r3.L$1;
        UserCreation r31 = (UserCreation) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r7 = r30;
        r0 = r31;
    L180:
        String r32 = r0.a;     // Catch: Throwable -> L111
        if (r32 == null) goto L113;
        Lazy<ProfileRepo> r33 = ProfileRepo.b;     // Catch: Throwable -> L111
        ProfileRepo r34 = ProfileRepo.a.a();     // Catch: Throwable -> L111
        Integer r35 = r0.d;     // Catch: Throwable -> L109
        if (r35 != null) goto L96;
    L98:
        int r36 = 1;
    L99:
        Integer r37 = Boxing.boxInt(r36);     // Catch: Throwable -> L111
        r3.L$0 = r0;     // Catch: Throwable -> L111
        r3.L$1 = r7;     // Catch: Throwable -> L111
        r3.label = 3;     // Catch: Throwable -> L111
        r14 = null;
        r15 = true;
        Object r38 = ProfileRepo.i(r34, r32, null, null, r37, false, r3, 22);     // Catch: Throwable -> L133
        if (r38 != r12) goto L104;
        return r12;
    L104:
        r9 = r7;
        r2 = r38;
        goto L175
    L96:
        if (r35.intValue() != 1) goto L98;
        r36 = 2;
    L109:
        th = th;
        r14 = null;
        goto L134
    L113:
        r14 = null;
        r15 = true;
    L111:
        th = th;
        r14 = null;
        goto L166
    L28:
        String r45 = (String) r3.L$4;
        String r46 = (String) r3.L$3;
        UserCreation r47 = (UserCreation) r3.L$2;
        String r48 = (String) r3.L$1;
        r39 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r110 = r48;
        String r49 = r45;
        r0 = r47;
        Object r50 = r2;
    L51:
        Message r51 = (Message) r50;
        if (r51 == null) goto L59;
        List r52 = ap8.a.a(r51);
        if (r52 == null) goto L59;
        AICreationTaskDurationInfo r53 = (AICreationTaskDurationInfo) CollectionsKt.firstOrNull(r52);
        if (r53 == null) goto L59;
        String r210 = r49;
        String r111 = r46;
        String r211 = r53.taskId;
        String r112 = r39;
    L60:
        String r212 = r110;
        CreationDynamicInfo r54 = r0.h;
        if (r54 == null) goto L66;
        String r55 = r54.d;
        if (r55 == null) goto L66;
        String r213 = r55;
    L67:
        String r214 = d.d(r0);
        String r310 = d.c(r0);
        Integer r56 = r0.d;
        if (r56 != null) goto L71;
    L73:
        String r215 = "0";
    L74:
        Integer r57 = r0.d;
        if (r57 != null) goto L78;
    L80:
        String r216 = "1";
    L81:
        String r58 = r0.a;
        UserCreationTrackParams r59 = r0.n;
        if (r59 == null) goto L84;
        String r217 = r59.a;
    L85:
        e2.a.b(new o0(r111, r112, r210, r211, r213, r214, r215, r216, r212, r58, r217, null, null, r310, null, null, null, null, 503809), null, 3);
        r7 = this.mutex;
        r3.L$0 = r0;
        r3.L$1 = r7;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.L$4 = null;
        r3.label = 2;
        if (r7.a(null, r3) != r12) goto L180;
        return r12;
    L84:
        r217 = null;
        goto L85
    L78:
        if (r57.intValue() != 1) goto L80;
        r216 = "0";
        goto L81
    L71:
        if (r56.intValue() != 1) goto L73;
        r215 = "1";
    L66:
        r213 = "";
    L59:
        r210 = r49;
        r111 = r46;
        r112 = r39;
        r211 = null;
        goto L60
    L29:
        ResultKt.throwOnFailure(r2);
        if (r42 == false) goto L38;
        Integer r60 = r0.d;
        if (r60 != null) goto L35;
    L37:
        String r61 = "creation_private";
    L39:
        r46 = r61;
        r49 = r0.a;
        IChatRepoService r62 = RepoDispatcherDelegate.b.e();
        if (r62 == null) goto L58;
        CreationDynamicInfo r63 = r0.h;
        if (r63 == null) goto L47;
        String r64 = r63.d;
        if (r64 == null) goto L47;
    L48:
        r3.L$0 = r39;
        r110 = r40;
        r3.L$1 = r110;
        r3.L$2 = r0;
        r3.L$3 = r46;
        r3.L$4 = r49;
        r3.label = 1;
        r50 = r62.E1(r64, r3);
        if (r50 != r12) goto L51;
        return r12;
    L47:
        r64 = "0";
        goto L48
    L58:
        r39 = r39;
        r110 = r40;
        goto L59
    L35:
        if (r60.intValue() != 1) goto L37;
    L38:
        r61 = "creation_list";
    L7:
        r3 = new C00971(this, r44);
        goto L8
    }

    public static /* synthetic */ Object deleteUserCreation$default(ProfileCreationViewModelV2 r7, UserCreationModel r8, String r9, String r10, Integer r11, Continuation r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r13 & 8) == 0) goto L13;
        Integer r5 = null;
    L15:
        return r7.deleteUserCreation(r8, r3, r4, r5, r12);
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public static /* synthetic */ Object modifyUserCreationPrivacyStatus$default(ProfileCreationViewModelV2 r7, String r8, String r9, UserCreation r10, boolean r11, Integer r12, Continuation r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r14 & 16) == 0) goto L10;
        r12 = null;
    L10:
        return r7.modifyUserCreationPrivacyStatus(r8, r9, r10, r4, r12, r13);
    L5:
        r4 = r11;
        goto L7
    }
}
