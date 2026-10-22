package com.larus.bmhome.bot;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.Category;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.DetailedPermissionSetting;
import com.larus.bmhome.chat.model.repo.FullPermissionSettings;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.ServiceBotNoticeRepo;
import com.larus.bmhome.chat.model.repo.SupplierDetail;
import com.larus.bmhome.chat.model.repo.Tile;
import com.larus.bmhome.chat.model.repo.TileForUpdate;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.livedata.NonStickyLiveData;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\r\u0010\u001e\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\u001fJ\r\u0010 \u001a\u00020\u001dH\u0000¢\u0006\u0002\b!J\u0016\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0015J\u0018\u0010&\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0015H\u0002J\u0018\u0010'\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0015H\u0002J\u0018\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0015H\u0002J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00192\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u001aH\u0002J\u0010\u00100\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u001aH\u0002J\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J \u00102\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010\u0012\u001a\u00020\u0010H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/bmhome/bot/ServiceBotSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lcom/larus/utils/livedata/NonStickyLiveData;", "Lcom/larus/bmhome/bot/ServiceBotSettingUiState;", "uiState", "Landroidx/lifecycle/LiveData;", "getUiState", "()Landroidx/lifecycle/LiveData;", "_event", "Lcom/larus/bmhome/bot/ServiceBotSettingEvent;", "event", "getEvent", "botId", "", "conversationId", "supplierId", "supplierName", "isSubPage", "", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "subPageLatestTiles", "", "Lcom/larus/bmhome/chat/model/repo/Tile;", "subPageDirty", "loadSettings", "", "refreshFromFullCache", "refreshFromFullCache$impl_mainlandRelease", "flushDetailToFullCache", "flushDetailToFullCache$impl_mainlandRelease", "onToggleChanged", "item", "Lcom/larus/bmhome/bot/ServiceBotSettingItem$ToggleItem;", "checked", "updatePinTop", "updatePermission", "updateToggleState", "itemId", "buildBlocks", "Lcom/larus/bmhome/bot/ServiceBotSettingBlock;", "tiles", "toItem", "Lcom/larus/bmhome/bot/ServiceBotSettingItem;", "tile", "computeSupplierSubText", "filterSubPageTiles", "findSupplierTilesFromFull", "full", "Lcom/larus/bmhome/chat/model/repo/FullPermissionSettings;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ServiceBotSettingViewModel extends ViewModel {
    private final NonStickyLiveData<r5> _event;
    private final NonStickyLiveData<f6> _uiState;
    private String botId;
    private wc9.e conversation;
    private String conversationId;
    private final LiveData<r5> event;
    private boolean isSubPage;
    private boolean subPageDirty;
    private List<Tile> subPageLatestTiles;
    private String supplierId;
    private String supplierName;
    private final LiveData<f6> uiState;

    /* JADX INFO: renamed from: com.larus.bmhome.bot.ServiceBotSettingViewModel$loadSettings$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.ServiceBotSettingViewModel$loadSettings$1", f = "ServiceBotSettingViewModel.kt", i = {}, l = {108, 132, 155}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ String $conversationId;
        final /* synthetic */ boolean $isSubPage;
        final /* synthetic */ String $supplierId;
        Object L$0;
        int label;
        final /* synthetic */ ServiceBotSettingViewModel this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.bot.ServiceBotSettingViewModel$loadSettings$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.bot.ServiceBotSettingViewModel$loadSettings$1$1", f = "ServiceBotSettingViewModel.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wc9.e>, Object> {
            final /* synthetic */ String $conversationId;
            int label;

            public C00371(String r1, Continuation<? super C00371> r2) {
                this.$conversationId = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00371(this.$conversationId, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super wc9.e> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r10) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r10);
            L11:
                return r10;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r10);
                RepoDispatcher.a.getClass();
                ConversationRepo r3 = RepoDispatcher.f;
                String r4 = this.$conversationId;
                this.label = 1;
                r10 = IConversationRepoService$a.c(r3, r4, false, null, this, 6);
                if (r10 != r0) goto L11;
                return r0;
            }
        }

        public AnonymousClass1(String r1, boolean r2, String r3, ServiceBotSettingViewModel r4, String r5, Continuation<? super AnonymousClass1> r6) {
            this.$botId = r1;
            this.$isSubPage = r2;
            this.$conversationId = r3;
            this.this$0 = r4;
            this.$supplierId = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.$botId, this.$isSubPage, this.$conversationId, this.this$0, this.$supplierId, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r4 = false;
            DetailedPermissionSetting r5 = null;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r13);
        L111:
            FullPermissionSettings r14 = (FullPermissionSettings) r13;
            if (r14 == null) goto L114;
            List<Tile> r15 = r14.getTiles();
            if (r15 != null) goto L118;
            r15 = CollectionsKt.emptyList();
        L118:
            List r16 = CollectionsKt.filterNotNull(r15);
            FLogger.a.i("ServiceBotSettingVM", "loadSettings(main) freshFull size=" + r16.size());
            ServiceBotSettingViewModel.access$get_uiState$p(this.this$0).postValue(new f6(ServiceBotSettingViewModel.access$buildBlocks(this.this$0, r16)));
            return Unit.INSTANCE;
        L114:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r13);
        L93:
            r5 = (DetailedPermissionSetting) r13;
        L94:
            if (r5 == null) goto L99;
            List<Tile> r17 = r5.getTiles();
            if (r17 != null) goto L98;
            r17 = CollectionsKt.emptyList();
        L98:
            List r18 = CollectionsKt.filterNotNull(r17);
            FLogger.a.i("ServiceBotSettingVM", "loadSettings(sub) freshDetail size=" + r18.size());
            NonStickyLiveData r2 = ServiceBotSettingViewModel.access$get_uiState$p(this.this$0);
            ServiceBotSettingViewModel r3 = this.this$0;
            r2.postValue(new f6(ServiceBotSettingViewModel.access$buildBlocks(r3, ServiceBotSettingViewModel.access$filterSubPageTiles(r3, r18))));
            ServiceBotSettingViewModel.access$setSubPageLatestTiles$p(this.this$0, r5.getTiles());
            ServiceBotSettingViewModel.access$setSubPageDirty$p(this.this$0, true);
        L101:
            return Unit.INSTANCE;
        L99:
            FLogger.a.i("ServiceBotSettingVM", "loadSettings(sub) freshDetail=null");
            goto L101
        L11:
            ServiceBotSettingViewModel r6 = (ServiceBotSettingViewModel) this.L$0;
            ResultKt.throwOnFailure(r13);
        L29:
            ServiceBotSettingViewModel.access$setConversation$p(r6, (wc9.e) r13);
        L31:
            if (this.$isSubPage == true) goto L33;
            ServiceBotNoticeRepo r19 = ServiceBotNoticeRepo.a;
            String r7 = this.$botId;
            r19.getClass();
            FullPermissionSettings r110 = ServiceBotNoticeRepo.f(r7);
            if (r110 == null) goto L108;
            List<Tile> r111 = r110.getTiles();
            if (r111 != null) goto L107;
            r111 = CollectionsKt.emptyList();
        L107:
            List r112 = CollectionsKt.filterNotNull(r111);
            FLogger.a.i("ServiceBotSettingVM", "loadSettings(main) cachedFull size=" + r112.size());
            ServiceBotSettingViewModel.access$get_uiState$p(this.this$0).postValue(new f6(ServiceBotSettingViewModel.access$buildBlocks(this.this$0, r112)));
        L108:
            String r113 = this.$botId;
            this.L$0 = null;
            this.label = 3;
            r13 = ServiceBotNoticeRepo.d(r113, this);
            if (r13 != r0) goto L111;
            return r0;
        L33:
            if (this.$supplierId.length() <= 0) goto L35;
            boolean r114 = true;
        L36:
            if (r114 == false) goto L38;
            ServiceBotSettingViewModel r115 = this.this$0;
            ServiceBotNoticeRepo r8 = ServiceBotNoticeRepo.a;
            String r9 = this.$botId;
            r8.getClass();
            List r116 = ServiceBotSettingViewModel.access$findSupplierTilesFromFull(r115, ServiceBotNoticeRepo.f(r9), this.$supplierId);
        L40:
            if ((!r116.isEmpty()) == false) goto L43;
            FLogger.a.i("ServiceBotSettingVM", "loadSettings(sub) cachedFromFull size=" + r116.size());
            NonStickyLiveData r10 = ServiceBotSettingViewModel.access$get_uiState$p(this.this$0);
            ServiceBotSettingViewModel r11 = this.this$0;
            r10.postValue(new f6(ServiceBotSettingViewModel.access$buildBlocks(r11, ServiceBotSettingViewModel.access$filterSubPageTiles(r11, r116))));
        L87:
            if (this.$supplierId.length() <= 0) goto L89;
            r4 = true;
        L89:
            if (r4 == false) goto L94;
            ServiceBotNoticeRepo r117 = ServiceBotNoticeRepo.a;
            String r12 = this.$botId;
            String r20 = this.$supplierId;
            this.L$0 = null;
            this.label = 2;
            r117.getClass();
            r13 = ServiceBotNoticeRepo.c(r12, r20, this);
            if (r13 != r0) goto L93;
            return r0;
        L43:
            if (this.$supplierId.length() <= 0) goto L45;
            boolean r118 = true;
        L46:
            if (r118 == false) goto L87;
            ServiceBotNoticeRepo r119 = ServiceBotNoticeRepo.a;
            String r21 = this.$botId;
            String r22 = this.$supplierId;
            r119.getClass();
            Intrinsics.checkNotNullParameter(r21, "botId");
            Intrinsics.checkNotNullParameter(r22, "supplierId");
            String r120 = ServiceBotNoticeRepo.b(r21, r22);
            DetailedPermissionSetting r23 = ServiceBotNoticeRepo.e.get(r120);
            if (r23 != null) goto L78;
            FLogger.a.i("ServiceBotNoticeRepo", "readDetailedCacheFromKeva key: " + r120);
            String r24 = ServiceBotNoticeRepo.g().getString(r120, null);
            if (r24 != null) goto L124;
        L74:
            r23 = null;
        L75:
            if (r23 == null) goto L77;
            ServiceBotNoticeRepo.e.put(r120, r23);
            goto L78
        L77:
            r23 = null;
            goto L78
        L124:
            Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L55
            r23 = (DetailedPermissionSetting) HttpExtKt.f.fromJson(r24, DetailedPermissionSetting.class);     // Catch: Throwable -> L55
        L55:
            th = move-exception;
            Result.Companion r26 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            ((ServiceBotNoticeRepo.a) HttpExtKt.f.fromJson(r24, ServiceBotNoticeRepo.a.class)).getClass();     // Catch: Throwable -> L59
            Object r27 = Result.constructor-impl(null);     // Catch: Throwable -> L59
        L61:
            Throwable r28 = Result.exceptionOrNull-impl(r27);
            if (r28 == null) goto L65;
            ServiceBotNoticeRepo.a.getClass();
            ServiceBotNoticeRepo.g().erase(r120);
            FLogger.a.e("ServiceBotNoticeRepo", "readDetailedCacheFromKeva fail: " + r28);
        L65:
            if (Result.isFailure-impl(r27) == false) goto L67;
            r27 = null;
        L67:
            r23 = (DetailedPermissionSetting) r27;
            if (r23 == null) goto L74;
            ServiceBotNoticeRepo.a.getClass();     // Catch: Throwable -> L72
            ServiceBotNoticeRepo.g().storeString(r120, HttpExtKt.f.toJson(r23));     // Catch: Throwable -> L72
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L72
        L72:
            th = move-exception;
            Result.Companion r29 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L59:
            th = move-exception;
            Result.Companion r30 = Result.Companion;
            r27 = Result.constructor-impl(ResultKt.createFailure(th));
        L78:
            if (r23 == null) goto L80;
            List<Tile> r121 = r23.getTiles();
        L81:
            if (r121 != null) goto L83;
            r121 = CollectionsKt.emptyList();
        L83:
            List r122 = CollectionsKt.filterNotNull(r121);
            if ((!r122.isEmpty()) == false) goto L87;
            FLogger.a.i("ServiceBotSettingVM", "loadSettings(sub) cachedFromDetail size=" + r122.size());
            NonStickyLiveData r31 = ServiceBotSettingViewModel.access$get_uiState$p(this.this$0);
            ServiceBotSettingViewModel r32 = this.this$0;
            r31.postValue(new f6(ServiceBotSettingViewModel.access$buildBlocks(r32, ServiceBotSettingViewModel.access$filterSubPageTiles(r32, r122))));
            goto L87
        L80:
            r121 = null;
            goto L81
        L45:
            r118 = false;
            goto L46
        L38:
            r116 = CollectionsKt.emptyList();
            goto L40
        L35:
            r114 = false;
            goto L36
        L12:
            ResultKt.throwOnFailure(r13);
            if (this.$botId.length() != 0) goto L15;
            boolean r123 = true;
        L16:
            if (r123 == false) goto L20;
            return Unit.INSTANCE;
        L20:
            if (this.$isSubPage == true) goto L31;
            if (this.$conversationId.length() <= 0) goto L24;
            boolean r124 = true;
        L25:
            if (r124 == false) goto L31;
            r6 = this.this$0;
            CoroutineDispatcher r125 = Dispatchers.getIO();
            C00371 r33 = new C00371(this.$conversationId, null);
            this.L$0 = r6;
            this.label = 1;
            r13 = BuildersKt.withContext(r125, r33, this);
            if (r13 != r0) goto L29;
            return r0;
        L24:
            r124 = false;
            goto L25
        L15:
            r123 = false;
            goto L16
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.ServiceBotSettingViewModel$updatePermission$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.ServiceBotSettingViewModel$updatePermission$1", f = "ServiceBotSettingViewModel.kt", i = {}, l = {267}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $checked;
        final /* synthetic */ d6.b $item;
        int label;
        final /* synthetic */ ServiceBotSettingViewModel this$0;

        public C01451(d6.b r1, boolean r2, ServiceBotSettingViewModel r3, Continuation<? super C01451> r4) {
            this.$item = r1;
            this.$checked = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01451(this.$item, this.$checked, this.this$0, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r23) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r23);
            Object r3 = r23;
        L20:
            DetailedPermissionSetting r6 = (DetailedPermissionSetting) r3;
        L21:
            if (r6 == null) goto L26;
            List<Tile> r4 = r6.getTiles();
            if (r4 != null) goto L25;
            r4 = CollectionsKt.emptyList();
        L25:
            List r5 = CollectionsKt.filterNotNull(r4);
            FLogger.a.i("ServiceBotSettingVM", "updatePermission success tilesSize=" + r5.size());
            NonStickyLiveData r7 = ServiceBotSettingViewModel.access$get_uiState$p(this.this$0);
            ServiceBotSettingViewModel r8 = this.this$0;
            r7.postValue(new f6(ServiceBotSettingViewModel.access$buildBlocks(r8, ServiceBotSettingViewModel.access$filterSubPageTiles(r8, r5))));
            ServiceBotSettingViewModel.access$setSubPageLatestTiles$p(this.this$0, r6.getTiles());
            ServiceBotSettingViewModel.access$setSubPageDirty$p(this.this$0, true);
        L28:
            return Unit.INSTANCE;
        L26:
            FLogger.a.i("ServiceBotSettingVM", "updatePermission fail");
            NonStickyLiveData r9 = ServiceBotSettingViewModel.access$get_event$p(this.this$0);
            d6.b r10 = this.$item;
            r9.postValue(new r5.b(r10.a, r10.f));
            ServiceBotSettingViewModel.access$get_event$p(this.this$0).postValue(r5.a.a);
            goto L28
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r23);
            d6.b r11 = this.$item;
            int r12 = r11.e;
            r6 = null;
            if (r12 != 3) goto L11;
            TileForUpdate r13 = new TileForUpdate(r11.a, Boxing.boxInt(3), Boxing.boxBoolean(this.$checked), null, 8, null);
        L15:
            FLogger.a.i("ServiceBotSettingVM", "updatePermission supplierId=" + ServiceBotSettingViewModel.access$getSupplierId$p(this.this$0) + " update=" + r13);
            if (r13 == null) goto L21;
            ServiceBotNoticeRepo r14 = ServiceBotNoticeRepo.a;
            String r15 = ServiceBotSettingViewModel.access$getBotId$p(this.this$0);
            String r16 = ServiceBotSettingViewModel.access$getSupplierId$p(this.this$0);
            List r17 = CollectionsKt.listOf(r13);
            this.label = 1;
            r14.getClass();
            r3 = ServiceBotNoticeRepo.j(r15, r16, r17, this);
            if (r3 != r1) goto L20;
            return r1;
        L11:
            if (r12 == 4) goto L13;
            r13 = null;
            goto L15
        L13:
            r13 = new TileForUpdate(r11.a, Boxing.boxInt(4), null, Boxing.boxBoolean(this.$checked), 4, null);
            goto L15
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.ServiceBotSettingViewModel$updatePinTop$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.ServiceBotSettingViewModel$updatePinTop$1", f = "ServiceBotSettingViewModel.kt", i = {}, l = {226}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $checked;
        final /* synthetic */ wc9.e $currentConversation;
        final /* synthetic */ d6.b $item;
        int label;
        final /* synthetic */ ServiceBotSettingViewModel this$0;

        public C01461(ServiceBotSettingViewModel r1, d6.b r2, boolean r3, wc9.e r4, Continuation<? super C01461> r5) {
            this.this$0 = r1;
            this.$item = r2;
            this.$checked = r3;
            this.$currentConversation = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C01461(this.this$0, this.$item, this.$checked, this.$currentConversation, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            boolean r9 = ((Boolean) r8).booleanValue();
            FLogger.a.i("ServiceBotSettingVM", "updatePinTop success=" + r9);
            if (r9 == false) goto L14;
            ServiceBotSettingViewModel.access$updateToggleState(this.this$0, this.$item.a, this.$checked);
        L16:
            return Unit.INSTANCE;
        L14:
            NonStickyLiveData r10 = ServiceBotSettingViewModel.access$get_event$p(this.this$0);
            d6.b r2 = this.$item;
            r10.postValue(new r5.b(r2.a, r2.f));
            ServiceBotSettingViewModel.access$get_event$p(this.this$0).postValue(r5.a.a);
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            CoroutineDispatcher r11 = Dispatchers.getIO();
            ServiceBotSettingViewModel$updatePinTop$1$success$1 r3 = new ServiceBotSettingViewModel$updatePinTop$1$success$1(this.$currentConversation, this.$checked, this.this$0, null);
            this.label = 1;
            r8 = BuildersKt.withContext(r11, r3, this);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    public final void flushDetailToFullCache$impl_mainlandRelease() {
        if (this.isSubPage == true) goto L5;
        return;
    L5:
        String r0 = this.botId;
        String r1 = this.supplierId;
        List<Tile> r2 = this.subPageLatestTiles;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("flushDetailToFullCacheOnPause botId=");
        r4.append(r0);
        r4.append(" supplierId=");
        r4.append(r1);
        r4.append(" dirty=");
        r4.append(this.subPageDirty);
        r4.append(" tilesSize=");
        if (r2 == null) goto L8;
        Integer r6 = Integer.valueOf(r2.size());
    L9:
        r4.append(r6);
        r3.i("ServiceBotSettingVM", r4.toString());
        boolean r5 = true;
        if (r0.length() != 0) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L15;
        return;
    L15:
        if (r1.length() == 0) goto L18;
        r5 = false;
    L18:
        if (r5 == true) goto L26;
        if (r2 != null) goto L21;
        return;
    L21:
        if (this.subPageDirty == false) goto L28;
        this.subPageDirty = false;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new ServiceBotSettingViewModel$flushDetailToFullCache$1(r0, r1, r2, null), 2, null);
        return;
    L28:
        return;
    L26:
        return;
    L12:
        r7 = false;
        goto L13
    L8:
        r6 = null;
        goto L9
    }

    public final void refreshFromFullCache$impl_mainlandRelease() {
        if (this.isSubPage == false) goto L5;
        return;
    L5:
        String r0 = this.botId;
        if (r0.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        FLogger.a.i("ServiceBotSettingVM", "refreshFromFullCacheOnResume botId=" + r0);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ServiceBotSettingViewModel$refreshFromFullCache$1(this, r0, null), 3, null);
        return;
    L8:
        r1 = false;
        goto L9
    }

    public ServiceBotSettingViewModel() {
        NonStickyLiveData<f6> r0 = new NonStickyLiveData();
        this._uiState = r0;
        this.uiState = r0;
        NonStickyLiveData<r5> r1 = new NonStickyLiveData();
        this._event = r1;
        this.event = r1;
        this.botId = "";
        this.conversationId = "";
        this.supplierId = "";
        this.supplierName = "";
    }

    public final LiveData<r5> getEvent() {
        return this.event;
    }

    public final LiveData<f6> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ String access$getBotId$p(ServiceBotSettingViewModel r0) {
        return r0.botId;
    }

    public static final /* synthetic */ String access$getConversationId$p(ServiceBotSettingViewModel r0) {
        return r0.conversationId;
    }

    public static final /* synthetic */ String access$getSupplierId$p(ServiceBotSettingViewModel r0) {
        return r0.supplierId;
    }

    public static final /* synthetic */ NonStickyLiveData access$get_event$p(ServiceBotSettingViewModel r0) {
        return r0._event;
    }

    public static final /* synthetic */ NonStickyLiveData access$get_uiState$p(ServiceBotSettingViewModel r0) {
        return r0._uiState;
    }

    private final List<q5> buildBlocks(List<Tile> r12) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = "";
        Iterator<T> r13 = r12.iterator();
        String r5 = null;
    L4:
        if (r13.hasNext() == false) goto L38;
        Tile r6 = (Tile) r13.next();
        Category r7 = r6.getCategory();
        StringBuilder r8 = new StringBuilder();
        if (r7 == null) goto L10;
        Long r9 = r7.getId();
        if (r9 == null) goto L10;
        long r10 = r9.longValue();
    L11:
        r8.append(r10);
        r8.append('_');
        if (r7 == null) goto L14;
        String r11 = r7.getName();
    L15:
        if (r11 != null) goto L17;
        r11 = "";
    L17:
        r8.append(r11);
        String r14 = r8.toString();
        if (r5 != null) goto L26;
        if (r7 == null) goto L21;
        String r15 = r7.getName();
    L22:
        if (r15 != null) goto L24;
        r15 = "";
    L24:
        r2.element = r15;
    L34:
        r5 = r14;
    L35:
        d6 r16 = toItem(r6);
        if (r16 == null) goto L4;
        r1.add(r16);
        goto L4
    L21:
        r15 = null;
        goto L22
    L26:
        if (Intrinsics.areEqual(r5, r14) == true) goto L35;
        buildBlocks$flush(r1, r0, r2);
        if (r7 == null) goto L30;
        String r17 = r7.getName();
    L31:
        if (r17 != null) goto L33;
        r17 = "";
    L33:
        r2.element = r17;
        goto L34
    L30:
        r17 = null;
        goto L31
    L14:
        r11 = null;
    L10:
        r10 = 0;
        goto L11
    L38:
        buildBlocks$flush(r1, r0, r2);
        return r0;
    }

    private final String computeSupplierSubText(Tile r8) {
        SupplierDetail r9 = r8.getSupplierValue();
        Boolean r0 = null;
        if (r9 == null) goto L5;
        List<Tile> r10 = r9.getTiles();
    L6:
        if (r10 != null) goto L8;
        r10 = CollectionsKt.emptyList();
    L8:
        List r11 = CollectionsKt.filterNotNull(r10);
        Iterator r1 = r11.iterator();
    L9:
        boolean r3 = true;
        if (r1.hasNext() == false) goto L20;
        Object r2 = r1.next();
        Integer r5 = ((Tile) r2).getType();
        if (r5 != null) goto L15;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == false) goto L9;
    L21:
        Tile r4 = (Tile) r2;
        if (r4 == null) goto L24;
        r0 = r4.getNoticeEnabledValue();
    L24:
        ArrayList r7 = new ArrayList();
        Iterator r12 = r11.iterator();
    L26:
        if (r12.hasNext() == false) goto L37;
        Object r13 = r12.next();
        Integer r14 = ((Tile) r13).getType();
        if (r14 != null) goto L31;
    L33:
        boolean r15 = false;
    L34:
        if (r15 == false) goto L26;
        r7.add(r13);
        goto L26
    L31:
        if (r14.intValue() != 4) goto L33;
        r15 = true;
        goto L34
    L37:
        if (Intrinsics.areEqual(r0, Boolean.FALSE) == false) goto L41;
        int r16 = com.larus.utils.j0.a;
        return com.larus.utils.j0.d(2131909210);
    L41:
        if (r7.isEmpty() == true) goto L50;
        Iterator r17 = r7.iterator();
    L45:
        if (r17.hasNext() == false) goto L50;
        if (Intrinsics.areEqual(((Tile) r17.next()).getNoticePermissionValue(), Boolean.TRUE) == true) goto L45;
        r3 = false;
    L50:
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L57;
        int r18 = com.larus.utils.j0.a;
        if (r3 == false) goto L55;
        return com.larus.utils.j0.d(2131909215);
    L55:
        return com.larus.utils.j0.d(2131909216);
    L57:
        if (r7.isEmpty() == false) goto L60;
        return "";
    L60:
        int r19 = com.larus.utils.j0.a;
        if (r3 == false) goto L64;
        return com.larus.utils.j0.d(2131909215);
    L64:
        return com.larus.utils.j0.d(2131909216);
    L15:
        if (r5.intValue() != 3) goto L17;
        r6 = true;
        goto L18
    L20:
        r2 = null;
        goto L21
    L5:
        r10 = null;
        goto L6
    }

    private final List<Tile> filterSubPageTiles(List<Tile> r9) {
        if (this.isSubPage == true) goto L5;
        return r9;
    L5:
        List<Tile> r0 = r9;
        Iterator<T> r1 = r0.iterator();
    L6:
        Boolean r5 = null;
        if (r1.hasNext() == false) goto L17;
        Object r2 = r1.next();
        Integer r6 = ((Tile) r2).getType();
        if (r6 != null) goto L12;
    L14:
        boolean r7 = false;
    L15:
        if (r7 == false) goto L6;
    L18:
        Tile r3 = (Tile) r2;
        if (r3 == null) goto L22;
        r5 = r3.getNoticeEnabledValue();
    L22:
        if (Intrinsics.areEqual(r5, Boolean.FALSE) == true) goto L24;
        return r9;
    L24:
        ArrayList r4 = new ArrayList();
        Iterator<T> r8 = r0.iterator();
    L26:
        if (r8.hasNext() == false) goto L36;
        Object r10 = r8.next();
        Integer r11 = ((Tile) r10).getType();
        if (r11 != null) goto L31;
    L32:
        boolean r12 = true;
    L34:
        if (r12 == false) goto L26;
        r4.add(r10);
        goto L26
    L31:
        if (r11.intValue() != 4) goto L32;
        r12 = false;
        goto L34
    L36:
        FLogger.a.i("ServiceBotSettingVM", "filterSubPageTiles hidePermissionItems origin=" + r9.size() + " filtered=" + r4.size());
        return r4;
    L12:
        if (r6.intValue() != 3) goto L14;
        r7 = true;
        goto L15
    L17:
        r2 = null;
        goto L18
    }

    private final d6 toItem(Tile r13) {
        Integer r0 = r13.getType();
        if (r0 != null) goto L6;
    L26:
        if (r0 != null) goto L29;
    L48:
        if (r0 != null) goto L51;
    L61:
        if (r0 != null) goto L64;
    L74:
        return null;
    L64:
        if (r0.intValue() != 4) goto L74;
        String r2 = r13.getId();
        if (r2 != null) goto L68;
        String r4 = "";
    L69:
        String r3 = r13.getName();
        if (r3 != null) goto L72;
        String r5 = "";
    L79:
        return new d6.b(r4, r5, r13.getIconUrl(), r13.getIconUrlDark(), 4, Intrinsics.areEqual(r13.getNoticePermissionValue(), Boolean.TRUE));
    L72:
        r5 = r3;
        goto L79
    L68:
        r4 = r2;
        goto L69
    L51:
        if (r0.intValue() != 3) goto L61;
        String r6 = r13.getId();
        if (r6 != null) goto L55;
        String r7 = "";
    L56:
        String r8 = r13.getName();
        if (r8 != null) goto L59;
        String r9 = "";
    L78:
        return new d6.b(r7, r9, r13.getIconUrl(), r13.getIconUrlDark(), 3, Intrinsics.areEqual(r13.getNoticeEnabledValue(), Boolean.TRUE));
    L59:
        r9 = r8;
        goto L78
    L55:
        r7 = r6;
        goto L56
    L29:
        if (r0.intValue() != 2) goto L48;
        String r10 = r13.getId();
        if (r10 != null) goto L33;
        String r11 = "";
    L34:
        String r12 = r13.getName();
        if (r12 != null) goto L37;
        String r14 = "";
    L38:
        String r15 = r13.getIconUrl();
        String r16 = r13.getIconUrlDark();
        wc9.e r17 = this.conversation;
        if (r17 == null) goto L43;
        Integer r18 = r17.e;
        if (r18 == null) goto L43;
        int r19 = r18.intValue();
    L44:
        if (r19 <= 0) goto L46;
        boolean r110 = true;
    L77:
        return new d6.b(r11, r14, r15, r16, 2, r110);
    L46:
        r110 = false;
    L43:
        r19 = 0;
        goto L44
    L37:
        r14 = r12;
        goto L38
    L33:
        r11 = r10;
        goto L34
    L6:
        if (r0.intValue() != 1) goto L26;
        String r111 = computeSupplierSubText(r13);
        String r20 = r13.getId();
        if (r20 != null) goto L10;
        String r21 = "";
    L11:
        String r22 = r13.getName();
        if (r22 != null) goto L14;
        String r23 = "";
    L15:
        String r24 = r13.getIconUrl();
        String r25 = r13.getIconUrlDark();
        SupplierDetail r26 = r13.getSupplierValue();
        if (r26 == null) goto L21;
        String r27 = r26.getSupplierId();
        if (r27 == null) goto L21;
        String r28 = r27;
    L76:
        return new d6.a(r21, r23, r24, r25, r28, r111);
    L21:
        String r112 = r13.getId();
        if (r112 != null) goto L24;
        r28 = "";
        goto L76
    L24:
        r28 = r112;
        goto L76
    L14:
        r23 = r22;
        goto L15
    L10:
        r21 = r20;
        goto L11
    }

    public static final /* synthetic */ List access$buildBlocks(ServiceBotSettingViewModel r0, List r1) {
        return r0.buildBlocks(r1);
    }

    public static final /* synthetic */ List access$filterSubPageTiles(ServiceBotSettingViewModel r0, List r1) {
        return r0.filterSubPageTiles(r1);
    }

    public static final /* synthetic */ void access$setConversation$p(ServiceBotSettingViewModel r0, wc9.e r1) {
        r0.conversation = r1;
    }

    public static final /* synthetic */ void access$setSubPageDirty$p(ServiceBotSettingViewModel r0, boolean r1) {
        r0.subPageDirty = r1;
    }

    public static final /* synthetic */ void access$setSubPageLatestTiles$p(ServiceBotSettingViewModel r0, List r1) {
        r0.subPageLatestTiles = r1;
    }

    private final List<Tile> findSupplierTilesFromFull(FullPermissionSettings r7, String r8) {
        if (r7 == null) goto L43;
        if (r8.length() != 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L43;
        List<Tile> r9 = r7.getTiles();
        if (r9 != null) goto L12;
        r9 = CollectionsKt.emptyList();
    L12:
        Iterator r10 = CollectionsKt.filterNotNull(r9).iterator();
    L13:
        List<Tile> r3 = null;
        if (r10.hasNext() == false) goto L32;
        Object r1 = r10.next();
        Tile r4 = (Tile) r1;
        Integer r5 = r4.getType();
        if (r5 != null) goto L19;
    L29:
        boolean r6 = false;
    L30:
        if (r6 == false) goto L13;
    L33:
        Tile r2 = (Tile) r1;
        if (r2 == null) goto L38;
        SupplierDetail r11 = r2.getSupplierValue();
        if (r11 == null) goto L38;
        r3 = r11.getTiles();
    L38:
        if (r3 != null) goto L41;
        r3 = CollectionsKt.emptyList();
    L41:
        return CollectionsKt.filterNotNull(r3);
    L19:
        if (r5.intValue() != 1) goto L29;
        SupplierDetail r12 = r4.getSupplierValue();
        if (r12 == null) goto L23;
        String r13 = r12.getSupplierId();
    L25:
        if (Intrinsics.areEqual(r13, r8) == false) goto L27;
    L28:
        r6 = true;
        goto L30
    L27:
        if (Intrinsics.areEqual(r4.getId(), r8) == false) goto L29;
    L23:
        r13 = null;
        goto L25
    L32:
        r1 = null;
        goto L33
    L6:
        r0 = false;
    L43:
        return CollectionsKt.emptyList();
    }

    private final void updatePermission(d6.b r9, boolean r10) {
        if (this.supplierId.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        this._event.postValue(new r5.b(r9.a, r9.f));
        return;
    L9:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01451(r9, r10, this, null), 3, null);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void updatePinTop(d6.b r12, boolean r13) {
        wc9.e r4 = this.conversation;
        if (this.conversationId.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L11;
        if (r4 == null) goto L11;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01461(this, r12, r13, r4, null), 3, null);
        return;
    L11:
        this._event.postValue(new r5.b(r12.a, r12.f));
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void updateToggleState(String r19, boolean r20) {
        f6 r1 = (f6) this._uiState.getValue();
        if (r1 != null) goto L5;
        return;
    L5:
        List<q5> r2 = r1.a;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L19;
        q5 r5 = (q5) r4.next();
        List<d6> r6 = r5.b;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L10:
        if (r8.hasNext() == false) goto L18;
        d6 r9 = (d6) r8.next();
        if ((r9 instanceof d6.b) == false) goto L17;
        d6.b r10 = (d6.b) r9;
        if (Intrinsics.areEqual(r10.a, r19) == false) goto L17;
        String r12 = r10.a;
        String r13 = r10.b;
        String r14 = r10.c;
        String r15 = r10.d;
        int r11 = r10.e;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r12, "id");
        Intrinsics.checkNotNullParameter(r13, "name");
        r9 = new d6.b(r12, r13, r14, r15, r11, r20);
    L17:
        r7.add(r9);
        goto L10
    L18:
        String r16 = r5.a;
        Intrinsics.checkNotNullParameter(r16, "categoryName");
        Intrinsics.checkNotNullParameter(r7, "items");
        r3.add(new q5(r16, r7));
        goto L7
    L19:
        NonStickyLiveData<f6> r17 = this._uiState;
        Intrinsics.checkNotNullParameter(r3, "blocks");
        r17.postValue(new f6(r3));
    }

    public final void onToggleChanged(d6.b r30, boolean r31) {
        Intrinsics.checkNotNullParameter(r30, "item");
        FLogger.a.i("ServiceBotSettingVM", "onToggleChanged " + r30 + " checked=" + r31);
        if (r30.f != r31) goto L5;
        return;
    L5:
        int r3 = r30.e;
        boolean r4 = true;
        if (r3 != 2) goto L8;
        int r5 = e6.a;
        String r6 = this.botId;
        Intrinsics.checkNotNullParameter(r6, "botId");
        if (r6.length() == 0) goto L44;
        r4 = false;
    L44:
        if (r4 == true) goto L49;
        if (r31 == false) goto L48;
        tx9.v2.b(r6, "switch", "bot_setting", "notice", null, null, null, null, null, null, null, 4, 6128);
        goto L49
    L48:
        tx9.v2.e(r6, "switch", "bot_setting", "notice", null, null, null, null, null, null, null, 4, 6128);
    L49:
        updatePinTop(r30, r31);
        return;
    L8:
        if (r3 == 3) goto L12;
        if (r3 == 4) goto L12;
        return;
    L12:
        if (this.isSubPage == false) goto L39;
        int r10 = e6.a;
        String r11 = this.botId;
        String r12 = this.supplierId;
        String r13 = this.supplierName;
        String r14 = r30.a;
        String r15 = r30.b;
        Intrinsics.checkNotNullParameter(r11, "botId");
        Intrinsics.checkNotNullParameter(r12, "supplierId");
        Intrinsics.checkNotNullParameter(r13, "supplierName");
        Intrinsics.checkNotNullParameter(r14, "noticeTypeId");
        Intrinsics.checkNotNullParameter(r15, "noticeTypeName");
        if (r11.length() != 0) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == true) goto L39;
        if (r12.length() != 0) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == true) goto L39;
        if (r14.length() != 0) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == true) goto L39;
        if (r3 == 3) goto L33;
        if (r3 == 4) goto L32;
        String r16 = "";
    L34:
        com.larus.platform.service.o r17 = com.larus.platform.service.o.a;
        Pair[] r18 = new Pair[10];
        r18[0] = TuplesKt.to("current_page", "bot_setting");
        r18[1] = TuplesKt.to("auth_type", r16);
        r18[2] = TuplesKt.to("supplier_id", r12);
        r18[3] = TuplesKt.to("supplier_name", r13);
        r18[4] = TuplesKt.to("notice_type_id", r14);
        r18[5] = TuplesKt.to("notice_type_name", r15);
        if (r31 == false) goto L37;
        String r19 = "on";
    L38:
        r18[6] = TuplesKt.to("to_status", r19);
        r18[7] = TuplesKt.to("chat_type", "notice");
        r18[8] = TuplesKt.to("bot_id", r11);
        r18[9] = TuplesKt.to("bot_type", 4);
        r17.b("click_notice_auth_switch", com.larus.utils.f.c(r18));
        goto L39
    L37:
        r19 = "off";
        goto L38
    L32:
        r16 = "single";
        goto L34
    L33:
        r16 = "all";
        goto L34
    L26:
        r9 = false;
        goto L27
    L21:
        r8 = false;
        goto L22
    L16:
        r7 = false;
    L39:
        updatePermission(r30, r31);
    }

    public static final /* synthetic */ List access$findSupplierTilesFromFull(ServiceBotSettingViewModel r0, FullPermissionSettings r1, String r2) {
        return r0.findSupplierTilesFromFull(r1, r2);
    }

    public static final /* synthetic */ void access$updateToggleState(ServiceBotSettingViewModel r0, String r1, boolean r2) {
        r0.updateToggleState(r1, r2);
    }

    private static final void buildBlocks$flush(ArrayList<d6> r2, ArrayList<q5> r3, Ref.ObjectRef<String> r4) {
        if (r2.isEmpty() == false) goto L5;
        return;
    L5:
        r3.add(new q5((String) r4.element, CollectionsKt.toList(r2)));
        r2.clear();
    }

    public final void loadSettings(String r11, String r12, String r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r11, "botId");
        Intrinsics.checkNotNullParameter(r12, "conversationId");
        Intrinsics.checkNotNullParameter(r13, "supplierId");
        Intrinsics.checkNotNullParameter(r14, "supplierName");
        FLogger.a.i("ServiceBotSettingVM", "loadSettings botId=" + r11 + " conversationId=" + r12 + " supplierId=" + r13 + " supplierName=" + r14 + " isSubPage=" + r15);
        this.botId = r11;
        this.conversationId = r12;
        this.supplierId = r13;
        this.supplierName = r14;
        this.isSubPage = r15;
        this.subPageLatestTiles = null;
        this.subPageDirty = false;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(r11, r15, r12, this, r13, null), 3, null);
    }
}
