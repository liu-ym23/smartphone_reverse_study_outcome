package com.larus.bmhome.bot;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.FullPermissionSettings;
import com.larus.bmhome.chat.model.repo.ServiceBotNoticeRepo;
import com.larus.bmhome.chat.model.repo.SupplierDetail;
import com.larus.bmhome.chat.model.repo.Tile;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.ServiceBotSettingViewModel$flushDetailToFullCache$1", f = "ServiceBotSettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ServiceBotSettingViewModel$flushDetailToFullCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $currentBotId;
    final /* synthetic */ String $currentSupplierId;
    final /* synthetic */ List<Tile> $tiles;
    int label;

    public ServiceBotSettingViewModel$flushDetailToFullCache$1(String r1, String r2, List<Tile> r3, Continuation<? super ServiceBotSettingViewModel$flushDetailToFullCache$1> r4) {
        this.$currentBotId = r1;
        this.$currentSupplierId = r2;
        this.$tiles = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ServiceBotSettingViewModel$flushDetailToFullCache$1(this.$currentBotId, this.$currentSupplierId, this.$tiles, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r26) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L68;
        ResultKt.throwOnFailure(r26);
        ServiceBotNoticeRepo r1 = ServiceBotNoticeRepo.a;
        String r2 = this.$currentBotId;
        String r3 = this.$currentSupplierId;
        List<Tile> r4 = this.$tiles;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "botId");
        Intrinsics.checkNotNullParameter(r3, "supplierId");
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("overwriteSupplierTilesInFullCache botId=");
        r6.append(r2);
        r6.append(" supplierId=");
        r6.append(r3);
        r6.append(" supplierTilesSize=");
        if (r4 == null) goto L7;
        Integer r7 = Integer.valueOf(r4.size());
    L8:
        r6.append(r7);
        r5.i("ServiceBotNoticeRepo", r6.toString());
        boolean r8 = false;
        if (r2.length() != 0) goto L11;
        boolean r9 = true;
    L12:
        if (r9 == false) goto L14;
    L64:
        r5.i("ServiceBotNoticeRepo", "overwriteSupplierTilesInFullCache skip: empty botId/supplierId");
    L65:
        FLogger.a.i("ServiceBotSettingVM", "flushDetailToFullCacheOnPause updated=" + r8);
        return Unit.INSTANCE;
    L14:
        if (r3.length() != 0) goto L16;
        boolean r10 = true;
    L17:
        if (r10 == true) goto L64;
        String r11 = ServiceBotNoticeRepo.e(r2);
        if (Intrinsics.areEqual(ServiceBotNoticeRepo.c, r11) == false) goto L24;
        FullPermissionSettings r12 = ServiceBotNoticeRepo.d;
        if (r12 == null) goto L24;
    L25:
        if (r12 != null) goto L27;
        r5.i("ServiceBotNoticeRepo", "overwriteSupplierTilesInFullCache skip: fullCache=null");
        goto L65
    L27:
        List<Tile> r13 = r12.getTiles();
        if (r13 != null) goto L31;
        r13 = CollectionsKt.emptyList();
    L31:
        if (r13.isEmpty() == false) goto L33;
        r5.i("ServiceBotNoticeRepo", "overwriteSupplierTilesInFullCache skip: fullTiles empty");
        goto L65
    L33:
        List<Tile> r14 = r13;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r16 = r14.iterator();
        boolean r17 = false;
    L35:
        if (r16.hasNext() == false) goto L61;
        Tile r18 = (Tile) r16.next();
        if (r18 != null) goto L39;
        r18 = null;
    L60:
        r15.add(r18);
        goto L35
    L39:
        Integer r19 = r18.getType();
        if (r19 != null) goto L43;
    L53:
        boolean r110 = false;
    L54:
        if (r110 == false) goto L60;
        SupplierDetail r111 = r18.getSupplierValue();
        if (r111 != null) goto L59;
        r111 = new SupplierDetail(r3, null, 2, null);
    L59:
        r18 = Tile.copy$default(r18, null, null, null, null, null, null, null, null, SupplierDetail.copy$default(r111, null, r4, 1, null), 255, null);
        r17 = true;
        goto L60
    L43:
        if (r19.intValue() != 1) goto L53;
        SupplierDetail r112 = r18.getSupplierValue();
        if (r112 == null) goto L47;
        String r113 = r112.getSupplierId();
    L49:
        if (Intrinsics.areEqual(r113, r3) == false) goto L51;
    L52:
        r110 = true;
        goto L54
    L51:
        if (Intrinsics.areEqual(r18.getId(), r3) == false) goto L53;
    L47:
        r113 = null;
        goto L49
    L61:
        if (r17 == true) goto L63;
        FLogger.a.i("ServiceBotNoticeRepo", "overwriteSupplierTilesInFullCache skip: target supplier not found in full");
        goto L65
    L63:
        ServiceBotNoticeRepo.i(r2, r12.copy(r15));
        FLogger.a.i("ServiceBotNoticeRepo", "overwriteSupplierTilesInFullCache success");
        r8 = true;
    L24:
        r12 = ServiceBotNoticeRepo.h(r11);
        goto L25
    L16:
        r10 = false;
        goto L17
    L11:
        r9 = false;
        goto L12
    L7:
        r7 = null;
        goto L8
    L68:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
