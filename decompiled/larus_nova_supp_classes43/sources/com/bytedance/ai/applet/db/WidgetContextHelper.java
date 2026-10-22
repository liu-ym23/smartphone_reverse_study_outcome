package com.bytedance.ai.applet.db;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.byted.cast.sink.api.IAPI;
import com.bytedance.ai.bridge.remote.UserAuthService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import p4.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class WidgetContextHelper {
    public static final WidgetContextHelper a = null;

    /* JADX INFO: renamed from: com.bytedance.ai.applet.db.WidgetContextHelper$insert$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.applet.db.WidgetContextHelper", f = "WidgetContextHelper.kt", i = {0}, l = {IAPI.OPTION_DMPLISTENER}, m = "insert", n = {"cardId"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetContextHelper this$0;

        public AnonymousClass1(WidgetContextHelper r1, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r1;
            super(r10);
        }

        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.insert(null, null, null, null, this);
        }
    }

    static {
        a = new WidgetContextHelper();
    }

    public WidgetContextHelper() {
    }

    public static a a() {
        WidgetContextDatabase.a r0 = WidgetContextDatabase.a;
        WidgetContextDatabase r1 = WidgetContextDatabase.b;
        if (r1 != null) goto L14;
        monitor-enter(r0);
        r1 = WidgetContextDatabase.b;     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        RoomDatabase r10 = Room.databaseBuilder(o2.a.a(), WidgetContextDatabase.class, "applet_widget_context.db").fallbackToDestructiveMigration().addCallback(new WidgetContextDatabase$Companion$get$1$1()).build();     // Catch: Throwable -> L10
        WidgetContextDatabase.b = (WidgetContextDatabase) r10;     // Catch: Throwable -> L10
        r1 = (WidgetContextDatabase) r10;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);
    L10:
        th = move-exception;
        throw th;
    L14:
        return r1.c();
    }

    public final Object c(String r10, Continuation<? super i> r11) {
        if ((r11 instanceof WidgetContextHelper$queryByCardId$1) == false) goto L7;
        WidgetContextHelper$queryByCardId$1 r0 = (WidgetContextHelper$queryByCardId$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L16;
        if (r14 != 1) goto L15;
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L22
    L20:
        return (i) r12;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r12);
        a r15 = a();     // Catch: Exception -> L22
        r0.L$0 = r10;     // Catch: Exception -> L22
        r0.label = 1;     // Catch: Exception -> L22
        r12 = r15.a(r10, r0);     // Catch: Exception -> L22
        if (r12 != r13) goto L20;
        return r13;
    L22:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("WidgetContextHelper", "queryByCardId: query widget context failed, cardId=" + r10, e);
        return null;
    L7:
        r0 = new WidgetContextHelper$queryByCardId$1(this, r11);
        goto L8
    }

    public final Object d(String r10, Continuation<? super String> r11) {
        if ((r11 instanceof WidgetContextHelper$queryConversationIdByCardId$1) == false) goto L7;
        WidgetContextHelper$queryConversationIdByCardId$1 r0 = (WidgetContextHelper$queryConversationIdByCardId$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        boolean r15 = true;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L17:
        i r16 = (i) r12;
        if (r16 == null) goto L20;
        String r17 = r16.c;
    L21:
        if (r17 != null) goto L23;
    L26:
        if (r15 == true) goto L28;
        return r17;
    L28:
        com.bytedance.ai.utils.g r18 = com.bytedance.ai.utils.g.a;
        r18.e("WidgetContextHelper", "queryConversationIdByCardId: can not find conversationId by cardId " + r10 + " from db");
        UserAuthService r19 = UserAuthService.a;
        p r20 = UserAuthService.l(r10);
        if (r20 == null) goto L33;
        String r21 = r20.e();
        if (r21 == null) goto L33;
        return r21;
    L33:
        r18.e("WidgetContextHelper", "queryConversationIdByCardId: can not find conversationId by cardId " + r10 + " from server");
        return null;
    L23:
        if (r17.length() == 0) goto L26;
        r15 = false;
        goto L26
    L20:
        r17 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r0.L$0 = r10;
        r0.label = 1;
        r12 = c(r10, r0);
        if (r12 != r13) goto L17;
        return r13;
    L7:
        r0 = new WidgetContextHelper$queryConversationIdByCardId$1(this, r11);
        goto L8
    }

    public final Object e(String r10, Continuation<? super String> r11) {
        if ((r11 instanceof WidgetContextHelper$queryMessageIdByCardId$1) == false) goto L7;
        WidgetContextHelper$queryMessageIdByCardId$1 r0 = (WidgetContextHelper$queryMessageIdByCardId$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        boolean r15 = true;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L17:
        i r16 = (i) r12;
        if (r16 == null) goto L20;
        String r17 = r16.b;
    L21:
        if (r17 != null) goto L23;
    L26:
        if (r15 == true) goto L28;
        return r17;
    L28:
        com.bytedance.ai.utils.g r18 = com.bytedance.ai.utils.g.a;
        r18.e("WidgetContextHelper", "queryMessageIdByCardId: can not find messageId by cardId " + r10 + " from db");
        UserAuthService r19 = UserAuthService.a;
        p r20 = UserAuthService.l(r10);
        if (r20 == null) goto L33;
        String r21 = r20.f();
        if (r21 == null) goto L33;
        return r21;
    L33:
        r18.e("WidgetContextHelper", "queryMessageIdByCardId: can not find messageId by cardId " + r10 + " from server");
        return null;
    L23:
        if (r17.length() == 0) goto L26;
        r15 = false;
        goto L26
    L20:
        r17 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r0.L$0 = r10;
        r0.label = 1;
        r12 = c(r10, r0);
        if (r12 != r13) goto L17;
        return r13;
    L7:
        r0 = new WidgetContextHelper$queryMessageIdByCardId$1(this, r11);
        goto L8
    }

    public static void b(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "cardId");
        Intrinsics.checkNotNullParameter(r11, "messageId");
        Intrinsics.checkNotNullParameter(r12, "conversationId");
        Intrinsics.checkNotNullParameter(r13, "botId");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WidgetContextHelper$insertAsync$1(r10, r11, r12, r13, null), 3, null);
    }

    public final Object insert(String r10, String r11, String r12, String r13, Continuation<? super Boolean> r14) {
        if ((r14 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r0.label;
        boolean r18 = true;
        if (r17 == 0) goto L16;
        if (r17 != 1) goto L15;
        String r19 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L24
    L20:
        if (((Number) r15).longValue() != (-1)) goto L28;
    L26:
        r18 = false;
    L28:
        return Boxing.boxBoolean(r18);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r15);
        a r20 = a();     // Catch: Exception -> L24
        i r21 = new i(r10, r11, r12, r13);     // Catch: Exception -> L24
        r0.L$0 = r10;     // Catch: Exception -> L24
        r0.label = 1;     // Catch: Exception -> L24
        r15 = r20.b(r21, r0);     // Catch: Exception -> L24
        if (r15 != r16) goto L20;
        return r16;
    L24:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("WidgetContextHelper", "insert: insert widget context failed, cardId=" + r10, e);
    L7:
        r0 = new AnonymousClass1(this, r14);
        goto L8
    }
}
