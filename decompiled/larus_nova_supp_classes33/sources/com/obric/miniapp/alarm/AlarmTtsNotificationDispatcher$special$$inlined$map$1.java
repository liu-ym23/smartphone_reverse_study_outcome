package com.obric.miniapp.alarm;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class AlarmTtsNotificationDispatcher$special$$inlined$map$1 implements Flow<f0> {
    public final /* synthetic */ Flow a;

    /* JADX INFO: renamed from: com.obric.miniapp.alarm.AlarmTtsNotificationDispatcher$special$$inlined$map$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements FlowCollector {
        public final /* synthetic */ FlowCollector a;

        /* JADX INFO: renamed from: com.obric.miniapp.alarm.AlarmTtsNotificationDispatcher$special$$inlined$map$1$2$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.miniapp.alarm.AlarmTtsNotificationDispatcher$special$$inlined$map$1$2", f = "AlarmTtsNotificationDispatcher.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
        public static final class AnonymousClass1 extends ContinuationImpl {
            Object L$0;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ AnonymousClass2 this$0;

            public AnonymousClass1(AnonymousClass2 r1, Continuation r2) {
                this.this$0 = r1;
                super(r2);
            }

            public final Object invokeSuspend(Object r2) {
                this.result = r2;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        }

        public AnonymousClass2(FlowCollector r1) {
            this.a = r1;
        }

        public final Object emit(Object r11, Continuation r12) {
            if ((r12 instanceof AnonymousClass1) == false) goto L7;
            AnonymousClass1 r0 = (AnonymousClass1) r12;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r13 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            ResultKt.throwOnFailure(r13);
        L62:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r13);
            FlowCollector r14 = this.a;
            List r5 = (List) r11;
            IBluetoothHeadSetAPI r15 = tha.c.a();
            boolean r4 = false;
            if (r15 != null) goto L17;
        L19:
            boolean r6 = false;
        L20:
            IDoraService r16 = AlarmTtsNotificationDispatcher.a();
            if (r16 == null) goto L27;
            DeviceService r17 = r16.device();
            if (r17 == null) goto L27;
            if (r17.J() != true) goto L27;
            boolean r7 = true;
        L28:
            IBluetoothHeadSetAPI r18 = tha.c.a();
            if (r18 == null) goto L31;
            String r8 = r18.r();
        L32:
            IDoraService r19 = AlarmTtsNotificationDispatcher.a();
            if (r19 == null) goto L57;
            DeviceService r110 = r19.device();
            if (r110 == null) goto L57;
            int r111 = r110.y();
            if (r111 != 0) goto L56;
            IDoraService r9 = AlarmTtsNotificationDispatcher.a();
            if (r9 == null) goto L45;
            DeviceService r10 = r9.device();
            if (r10 == null) goto L45;
            if (r10.J() != true) goto L45;
            boolean r20 = true;
        L46:
            if (r20 == false) goto L56;
            IDoraService r21 = AlarmTtsNotificationDispatcher.a();
            if (r21 == null) goto L54;
            DeviceService r22 = r21.device();
            if (r22 == null) goto L54;
            if (r22.a() != true) goto L54;
            r4 = true;
        L54:
            if (r4 == false) goto L56;
            r111 = 1;
        L45:
            r20 = false;
        L56:
            Integer r23 = Boxing.boxInt(r111);
        L58:
            f0 r112 = new f0(r5, r6, r7, r8, r23);
            r0.label = 1;
            if (r14.emit(r112, r0) != r2) goto L62;
            return r2;
        L57:
            r23 = null;
            goto L58
        L31:
            r8 = null;
        L27:
            r7 = false;
            goto L28
        L17:
            if (r15.h() != true) goto L19;
            r6 = true;
        L7:
            r0 = new AnonymousClass1(this, r12);
            goto L8
        }
    }

    public AlarmTtsNotificationDispatcher$special$$inlined$map$1(kotlinx.coroutines.flow.c r1) {
        this.a = r1;
    }

    public final Object collect(FlowCollector r3, Continuation r4) {
        Object r5 = this.a.collect(new AnonymousClass2(r3), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }
}
