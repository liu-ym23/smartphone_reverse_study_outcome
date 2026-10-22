package com.larus.avlink.gallery.thumbnail;

import com.larus.avlink.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.MediaInfo;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.thumbnail.ThumbnailManager$startSyncThumbnail$1", f = "ThumbnailManager.kt", i = {0, 2}, l = {465, 476, 488, 489, 501, 501, 501}, m = "invokeSuspend", n = {"displayItem", "uploadItem"}, s = {"L$0", "L$0"})
public final class ThumbnailManager$startSyncThumbnail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    public ThumbnailManager$startSyncThumbnail$1(Continuation<? super ThumbnailManager$startSyncThumbnail$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ThumbnailManager$startSyncThumbnail$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0185 -> B:149:0x0080). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r17) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r6 = false;
        switch(this.label) {
            case 0: goto L20;
            case 1: goto L17;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        th = (Throwable) this.L$0;
        ResultKt.throwOnFailure(r17);
    L131:
        FLogger r3 = FLogger.a;
        r3.i("ThumbnailManager", "Thumbnail sync finished, wait 1s to check queue.");
        if ((!ThumbnailManager.e.isEmpty()) == false) goto L134;
    L135:
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L142;
        DeviceService r5 = r4.device();
        if (r5 == null) goto L142;
        if (r5.J() != true) goto L142;
        r6 = true;
    L142:
        if (r6 == false) goto L144;
        r3.i("ThumbnailManager", "Queue not empty in finally, restarting sync...");
        ThumbnailManager r7 = ThumbnailManager.a;
        ThumbnailManager.s("Restart from finally");
    L145:
        r3.i("ThumbnailManager", "Thumbnail sync finished.");
        throw th;
    L144:
        r3.i("ThumbnailManager", "Device not connected, thumbnail sync skip restart.");
        goto L145
    L134:
        if ((!ThumbnailManager.g.isEmpty()) == false) goto L145;
    L7:
        ResultKt.throwOnFailure(r17);
    L111:
        FLogger r0 = FLogger.a;
        r0.i("ThumbnailManager", "Thumbnail sync finished, wait 1s to check queue.");
        if ((!ThumbnailManager.e.isEmpty()) == false) goto L114;
    L115:
        IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r8 == null) goto L122;
        DeviceService r9 = r8.device();
        if (r9 == null) goto L122;
        if (r9.J() != true) goto L122;
        r6 = true;
    L122:
        if (r6 == false) goto L124;
    L123:
        r0.i("ThumbnailManager", "Queue not empty in finally, restarting sync...");
        ThumbnailManager r10 = ThumbnailManager.a;
        ThumbnailManager.s("Restart from finally");
    L125:
        r0.i("ThumbnailManager", "Thumbnail sync finished.");
        return Unit.INSTANCE;
    L124:
        r0.i("ThumbnailManager", "Device not connected, thumbnail sync skip restart.");
        goto L125
    L114:
        if ((!ThumbnailManager.g.isEmpty()) == false) goto L125;
    L8:
        ResultKt.throwOnFailure(r17);
    L93:
        r0 = FLogger.a;
        r0.i("ThumbnailManager", "Thumbnail sync finished, wait 1s to check queue.");
        if ((!ThumbnailManager.e.isEmpty()) == false) goto L96;
    L97:
        IDoraService r11 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r11 == null) goto L104;
        DeviceService r12 = r11.device();
        if (r12 == null) goto L104;
        if (r12.J() != true) goto L104;
        r6 = true;
    L104:
        if (r6 == false) goto L124;
    L96:
        if ((!ThumbnailManager.g.isEmpty()) == false) goto L125;
    L9:
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L15
    L31:
        ThumbnailManager$startSyncThumbnail$1 r14 = this;
    L149:
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L55
        if (r1 == null) goto L39;
        DeviceService r13 = r1.device();     // Catch: Throwable -> L55
        if (r13 == null) goto L39;
        if (r13.J() != true) goto L39;
        boolean r15 = true;
    L40:
        if (r15 == false) goto L90;
        ThumbnailManager.f = false;     // Catch: Throwable -> L55
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L55
        r16.append("thumbnail sync loop， count: ");     // Catch: Throwable -> L55
        ConcurrentLinkedQueue<MediaInfo> r18 = ThumbnailManager.e;     // Catch: Throwable -> L55
        r16.append(r18.size());     // Catch: Throwable -> L55
        r16.append(",  ");     // Catch: Throwable -> L55
        ConcurrentLinkedQueue<MediaInfo> r19 = ThumbnailManager.g;     // Catch: Throwable -> L55
        r16.append(r19.size());     // Catch: Throwable -> L55
        n1.d("ThumbnailManager", r16.toString());     // Catch: Throwable -> L55
        if ((!r18.isEmpty()) == true) goto L43;
        if ((!r19.isEmpty()) == false) goto L90;
        ThumbnailManager r20 = ThumbnailManager.a;     // Catch: Throwable -> L55
        if (ThumbnailManager.b() == true) goto L80;
        MediaInfo r21 = r19.peek();     // Catch: Throwable -> L55
        if (r21 == null) goto L149;
        r14.L$0 = r21;     // Catch: Throwable -> L55
        r14.label = 3;     // Catch: Throwable -> L55
        if (r20.h(r21, null, r14) != r2) goto L86;
        return r2;
    L86:
        MediaInfo r22 = r21;
    L87:
        ThumbnailManager r23 = ThumbnailManager.a;     // Catch: Throwable -> L55
        r14.L$0 = null;     // Catch: Throwable -> L55
        r14.label = 4;     // Catch: Throwable -> L55
        if (ThumbnailManager.e(r23, r22, r14) != r2) goto L149;
        return r2;
    L80:
        n1.b("ThumbnailManager", "Skip upload queue iterate due to In Conflict Scene");     // Catch: Throwable -> L55
        goto L90
    L43:
        MediaInfo r24 = r18.peek();     // Catch: Throwable -> L55
        if (r24 == null) goto L149;
        ThumbnailManager r25 = ThumbnailManager.a;     // Catch: Throwable -> L55
        r14.L$0 = r24;     // Catch: Throwable -> L55
        r14.label = 1;     // Catch: Throwable -> L55
        if (r25.h(r24, null, r14) != r2) goto L48;
        return r2;
    L48:
        ThumbnailManager r26 = ThumbnailManager.a;     // Catch: Throwable -> L55
        if (r24.getThumbnailTypes() == null) goto L61;
        Byte[] r27 = r24.getThumbnailTypes();     // Catch: Throwable -> L55
        if (r27 != null) goto L53;
    L57:
        boolean r28 = false;
    L58:
        if (r28 == true) goto L61;
        boolean r29 = false;
    L62:
        if (r29 == false) goto L72;
        ThumbnailManager.f = true;     // Catch: Throwable -> L55
        if (ThumbnailManager.b() == false) goto L72;
        Function0<Boolean> r30 = ThumbnailManager.n;     // Catch: Throwable -> L55
        if (r30 == null) goto L68;
        Boolean r31 = (Boolean) r30.invoke();     // Catch: Throwable -> L55
    L68:
        ThumbnailManager.f = false;     // Catch: Throwable -> L55
        Intrinsics.checkNotNullParameter("Old Big Thumb In Conflict Scene", "reason");     // Catch: Throwable -> L55
        FLogger.a.i("ThumbnailManager", "Thumbnail sync stopped. reason: Old Big Thumb In Conflict Scene");     // Catch: Throwable -> L55
        Job r32 = ThumbnailManager.c;     // Catch: Throwable -> L55
        if (r32 == null) goto L71;
        Job.DefaultImpls.cancel$default(r32, null, 1, null);     // Catch: Throwable -> L55
    L71:
        ThumbnailManager.d.set(false);     // Catch: Throwable -> L55
    L72:
        r14.L$0 = null;     // Catch: Throwable -> L55
        r14.label = 2;     // Catch: Throwable -> L55
        if (ThumbnailManager.d(r26, r24, r14) != r2) goto L75;
        return r2;
    L75:
        ThumbnailManager.f = false;     // Catch: Throwable -> L55
        goto L149
    L53:
        if (r27.length != 0) goto L57;
        r28 = true;
    L61:
        r29 = true;
    L90:
        ThumbnailManager.d.set(false);
        r14.L$0 = null;
        r14.label = 5;
        if (DelayKt.delay(1000, r14) != r2) goto L93;
        return r2;
    L39:
        r15 = false;
    L55:
        th = th;
    L147:
        FLogger.a.e("ThumbnailManager", "Error in startSyncThumbnail: " + th.getMessage(), th);     // Catch: Throwable -> L127
        ThumbnailManager.d.set(false);
        r14.L$0 = null;
        r14.label = 6;
        if (DelayKt.delay(1000, r14) != r2) goto L111;
        return r2;
    L127:
        th = th;
        ThumbnailManager.d.set(false);
        r14.L$0 = th;
        r14.label = 7;
        if (DelayKt.delay(1000, r14) != r2) goto L131;
        return r2;
    L11:
        r22 = (MediaInfo) this.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L15
        r14 = this;
        goto L87
    L13:
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L15
        r14 = this;
        ThumbnailManager.f = false;     // Catch: Throwable -> L55
        goto L149
    L17:
        r24 = (MediaInfo) this.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L15
        r14 = this;
        goto L48
    L20:
        ResultKt.throwOnFailure(r17);
        IDoraService r33 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L15
        if (r33 == null) goto L28;
        DeviceService r34 = r33.device();     // Catch: Throwable -> L15
        if (r34 == null) goto L28;
        if (r34.J() != true) goto L28;
        boolean r35 = true;
    L29:
        if (r35 == true) goto L31;
        FLogger.a.e("ThumbnailManager", "Device not connected, thumbnail sync abort.");     // Catch: Throwable -> L15
    L28:
        r35 = false;
        goto L29
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        th = th;
        r14 = this;
        goto L147
    }
}
