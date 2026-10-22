package com.larus.api.bussiness;

import com.bytedance.keva.Keva;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.account.base.model.SettingsAccountInfo;
import com.larus.account.base.model.SettingsConnectAccountInfo;
import com.larus.audio.call.dora.CommandStatus;
import com.larus.common.apphost.AppHost;
import com.larus.login.api.i0;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.settings.value.e10;
import com.larus.settings.value.g9;
import com.larus.utils.l0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.api.bussiness.VideoChatFragment$needShowAuthorizationDialog$1", f = "VideoChatFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VideoChatFragment$needShowAuthorizationDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ long $currentShowTimes;
    final /* synthetic */ boolean $haveReachNCycle;
    final /* synthetic */ long $lastRemindTime;
    int label;

    /* JADX INFO: renamed from: com.larus.api.bussiness.VideoChatFragment$needShowAuthorizationDialog$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.api.bussiness.VideoChatFragment$needShowAuthorizationDialog$1$1", f = "VideoChatFragment.kt", i = {}, l = {457}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        final /* synthetic */ long $currentShowTimes;
        final /* synthetic */ boolean $haveReachNCycle;
        final /* synthetic */ long $lastRemindTime;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super Boolean, Unit> r1, boolean r2, long r3, long r5, Continuation<? super AnonymousClass1> r7) {
            this.$callback = r1;
            this.$haveReachNCycle = r2;
            this.$lastRemindTime = r3;
            this.$currentShowTimes = r5;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new AnonymousClass1(this.$callback, this.$haveReachNCycle, this.$lastRemindTime, this.$currentShowTimes, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r16) {
            Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            ResultKt.throwOnFailure(r16);
            Object r1 = r16;
        L11:
            y r2 = (com.larus.network.http.a) r1;
            if ((r2 instanceof y) == false) goto L32;
            SettingsAccountInfo r3 = (SettingsAccountInfo) ((com.larus.network.http.a) r2).b;
            if (r3 == null) goto L16;
            List<SettingsConnectAccountInfo> r4 = r3.b();
        L17:
            if (r4 != null) goto L20;
            this.$callback.invoke(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L20:
            Function1<Boolean, Unit> r5 = this.$callback;
            Iterator<T> r6 = r4.iterator();
        L22:
            if (r6.hasNext() == false) goto L36;
            SettingsConnectAccountInfo r7 = (SettingsConnectAccountInfo) r6.next();
            if (r7 == null) goto L26;
            String r8 = r7.a();
        L28:
            if (Intrinsics.areEqual(r8, "aweme_v2") == false) goto L22;
            r5.invoke(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L26:
            r8 = null;
        L36:
            if (this.$haveReachNCycle == false) goto L44;
            long r9 = this.$lastRemindTime;
            AppHost.Companion r10 = AppHost.a;
            long r11 = Math.abs(r9 - r10.getAppClock().currentTimeMillis());
            e10 r12 = e10.a;
            if (r11 <= (((cw9.a) l0.a(new cw9.a(0), new g9())).b() * ((long) CommandStatus.DORA_TRACE))) goto L40;
            boolean r14 = true;
        L41:
            if (r14 == false) goto L43;
            this.$callback.invoke(Boxing.boxBoolean(true));
            Keva r15 = a.a;
            a.a(r10.getAppClock().currentTimeMillis());
            a.a.storeLong("have_show_times", this.$currentShowTimes + 1);
        L54:
            return Unit.INSTANCE;
        L43:
            this.$callback.invoke(Boxing.boxBoolean(false));
            goto L54
        L40:
            r14 = false;
            goto L41
        L44:
            long r17 = this.$lastRemindTime;
            if (r17 != (-1)) goto L47;
            this.$callback.invoke(Boxing.boxBoolean(true));
            Keva r19 = a.a;
            a.a(AppHost.a.getAppClock().currentTimeMillis());
            a.a.storeLong("have_show_times", this.$currentShowTimes + 1);
            goto L54
        L47:
            AppHost.Companion r20 = AppHost.a;
            long r21 = Math.abs(r17 - r20.getAppClock().currentTimeMillis());
            e10 r22 = e10.a;
            if (r21 <= (((cw9.a) l0.a(new cw9.a(0), new g9())).a() * ((long) CommandStatus.DORA_TRACE))) goto L52;
            this.$callback.invoke(Boxing.boxBoolean(true));
            Keva r23 = a.a;
            a.a(r20.getAppClock().currentTimeMillis());
            long r24 = this.$currentShowTimes + 1;
            Keva r25 = a.a;
            r25.storeLong("have_show_times", r24);
            if ((this.$currentShowTimes + 1) < 3) goto L54;
            r25.storeBoolean("have_enter_specific_cycle_day", true);
            goto L54
        L52:
            this.$callback.invoke(Boxing.boxBoolean(false));
            goto L54
        L16:
            r4 = null;
            goto L17
        L32:
            if ((r2 instanceof com.larus.network.http.f) == false) goto L36;
            this.$callback.invoke(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r16);
            String r26 = i0.c;
            JSONObject r27 = new JSONObject();
            this.label = 1;
            r1 = HttpExtKt.k("Basic", SettingsAccountInfo.class, r26, r27, null, null, false, null, null, null, this, 1008);
            if (r1 != r13) goto L11;
            return r13;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoChatFragment$needShowAuthorizationDialog$1(Function1<? super Boolean, Unit> r1, boolean r2, long r3, long r5, Continuation<? super VideoChatFragment$needShowAuthorizationDialog$1> r7) {
        this.$callback = r1;
        this.$haveReachNCycle = r2;
        this.$lastRemindTime = r3;
        this.$currentShowTimes = r5;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new VideoChatFragment$needShowAuthorizationDialog$1(this.$callback, this.$haveReachNCycle, this.$lastRemindTime, this.$currentShowTimes, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r13);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new AnonymousClass1(this.$callback, this.$haveReachNCycle, this.$lastRemindTime, this.$currentShowTimes, null), 2, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
