package com.larus.uaigc.chat.notification;

import android.content.res.Resources;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.notification.CreationRefreshNotificationStrategy$showNotification$2", f = "CreationRefreshNotificationStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreationRefreshNotificationStrategy$showNotification$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ Message $message;
    final /* synthetic */ int $progress;
    final /* synthetic */ CreationRefreshNotificationStrategy$b $taskNotifyData;
    final /* synthetic */ String $title;
    int label;

    public CreationRefreshNotificationStrategy$showNotification$2(CreationRefreshNotificationStrategy$b r1, String r2, String r3, int r4, Message r5, Continuation<? super CreationRefreshNotificationStrategy$showNotification$2> r6) {
        this.$taskNotifyData = r1;
        this.$title = r2;
        this.$content = r3;
        this.$progress = r4;
        this.$message = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CreationRefreshNotificationStrategy$showNotification$2(this.$taskNotifyData, this.$title, this.$content, this.$progress, this.$message, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L48;
        ResultKt.throwOnFailure(r20);
        if (CreationRefreshNotificationStrategy.f == false) goto L8;
        f.d();
        return Unit.INSTANCE;
    L8:
        Iterator r1 = CreationRefreshNotificationStrategy.c.values().iterator();
        int r3 = 0;
    L10:
        if (r1.hasNext() == false) goto L12;
        r3 = r3 + ((CreationRefreshNotificationStrategy$a) r1.next()).c.size();
        goto L10
    L12:
        Bundle r18 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("task_id", this.$taskNotifyData.b), TuplesKt.to("notify_id", Boxing.boxInt(107))});
        if (r3 <= 1) goto L15;
        CreationService r5 = f.a;
        AppHost.Companion r9 = AppHost.a;
        String r11 = r9.getApplication().getString(2131908638);
        Resources r10 = r9.getApplication().getApplicationContext().getResources();
        if (r10 == null) goto L29;
        String r4 = r10.getQuantityString(2131755207, r3, new Object[]{String.valueOf(r3)});
    L30:
        if (r4 != null) goto L32;
        String r12 = "";
    L33:
        f.c(new k(107, r11, r12, 0, 66, "", false, r18));
        if (CreationRefreshNotificationStrategy.e.contains(this.$taskNotifyData.b) == true) goto L36;
        Bundle r19 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("task_id", this.$taskNotifyData.b), TuplesKt.to("notify_id", Boxing.boxInt(this.$taskNotifyData.a))});
        CreationRefreshNotificationStrategy$b r2 = this.$taskNotifyData;
        int r13 = r2.a;
        String r14 = this.$title;
        String r15 = this.$content;
        long r16 = r2.d;
        int r17 = this.$progress;
        String r6 = this.$message.getMessageId();
        if (r6 != null) goto L43;
        String r110 = "";
    L44:
        f.e(new k(r13, r14, r15, r16, r17, r110, true, r19));
    L46:
        return Unit.INSTANCE;
    L43:
        r110 = r6;
        goto L44
    L36:
        if (f.d.contains(Boxing.boxInt(this.$taskNotifyData.a)) == false) goto L39;
        f.b(this.$taskNotifyData.a);
    L39:
        return Unit.INSTANCE;
    L32:
        r12 = r4;
        goto L33
    L29:
        r4 = null;
        goto L30
    L15:
        if (CreationRefreshNotificationStrategy.e.contains(this.$taskNotifyData.b) == true) goto L17;
        CreationService r7 = f.a;
        String r111 = this.$title;
        String r112 = this.$content;
        long r113 = this.$taskNotifyData.d;
        int r114 = this.$progress;
        String r8 = this.$message.getMessageId();
        if (r8 != null) goto L24;
        String r115 = "";
    L25:
        f.c(new k(107, r111, r112, r113, r114, r115, true, r18));
        goto L46
    L24:
        r115 = r8;
        goto L25
    L17:
        if (f.d.contains(Boxing.boxInt(this.$taskNotifyData.a)) == false) goto L20;
        f.b(this.$taskNotifyData.a);
        f.d();
    L20:
        return Unit.INSTANCE;
    L48:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
