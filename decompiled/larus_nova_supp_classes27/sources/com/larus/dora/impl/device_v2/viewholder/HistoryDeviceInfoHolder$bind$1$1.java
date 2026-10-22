package com.larus.dora.impl.device_v2.viewholder;

import com.bytedance.dora.device.DoraDevice;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraHistoryDeviceInfoLayoutBinding;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.util.DoraImageType;
import com.larus.dora.impl.util.DoraResourceUtil;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.utils.e1;
import d59.b;
import g49.d;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import v19.h;
import z49.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device_v2.viewholder.HistoryDeviceInfoHolder$bind$1$1", f = "HistoryDeviceInfoHolder.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
final class HistoryDeviceInfoHolder$bind$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $cardContext;
    final /* synthetic */ c $data;
    final /* synthetic */ LarusDoraHistoryDeviceInfoLayoutBinding $this_run;
    int label;

    /* JADX INFO: renamed from: com.larus.dora.impl.device_v2.viewholder.HistoryDeviceInfoHolder$bind$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device_v2.viewholder.HistoryDeviceInfoHolder$bind$1$1$1", f = "HistoryDeviceInfoHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ b $cardContext;
        final /* synthetic */ c $data;
        final /* synthetic */ String $deviceName;
        final /* synthetic */ LarusDoraHistoryDeviceInfoLayoutBinding $this_run;
        int label;

        public AnonymousClass1(String r1, c r2, LarusDoraHistoryDeviceInfoLayoutBinding r3, b r4, Continuation<? super AnonymousClass1> r5) {
            this.$deviceName = r1;
            this.$data = r2;
            this.$this_run = r3;
            this.$cardContext = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$deviceName, this.$data, this.$this_run, this.$cardContext, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L45;
            ResultKt.throwOnFailure(r6);
            String r7 = this.$deviceName;
            boolean r0 = false;
            if (r7 == null) goto L13;
            if (r7.length() <= 0) goto L9;
            boolean r8 = true;
        L10:
            if (r8 != true) goto L13;
            r0 = true;
            goto L13
        L9:
            r8 = false;
        L13:
            if (r0 == false) goto L41;
            d.d("HistoryDeviceInfoHolder", "onBindData the deviceName");
            if (Intrinsics.areEqual(this.$data.e(), Boxing.boxBoolean(true)) == false) goto L17;
            e1.x(this.$this_run.c);
            this.$this_run.c.setText(this.$data.c());
        L18:
            Integer r9 = null;
            h.a(null);
            b r1 = this.$cardContext;
            if (r1 == null) goto L30;
            List<? extends DoraDevice> r2 = r1.b;
            if (r2 == null) goto L30;
            c r3 = this.$data;
            Iterator<T> r4 = r2.iterator();
        L24:
            if (r4.hasNext() == false) goto L28;
            Object r5 = r4.next();
            if (Intrinsics.areEqual(((DoraDevice) r5).mac, r3.b()) == false) goto L24;
        L29:
            DoraDevice r10 = (DoraDevice) r5;
        L31:
            DoraSKU.a r11 = DoraSKU.Companion;
            if (r10 == null) goto L34;
            Integer r12 = Boxing.boxInt(r10.sku);
        L35:
            DoraSKU r13 = DoraSKU.a.b(r11, r12);
            SimpleDraweeView r14 = this.$this_run.b;
            DoraResourceUtil r15 = DoraResourceUtil.a;
            DoraImageType r16 = DoraImageType.ICON_DORA_MANAGE_NAV_BAR;
            DoraSKU r17 = n1.e(r13);
            boolean r18 = h.a;
            boolean r20 = h.a(null);
            b r21 = this.$cardContext;
            if (r21 == null) goto L40;
            z49.b r22 = r21.a;
            if (r22 == null) goto L40;
            r9 = r22.f();
        L40:
            r14.setImageBitmap(DoraResourceUtil.e(r16.fileName(r17, r20, r9)));
        L43:
            return Unit.INSTANCE;
        L34:
            r12 = null;
            goto L35
        L28:
            r5 = null;
        L30:
            r10 = null;
            goto L31
        L17:
            e1.o(this.$this_run.c);
            goto L18
        L41:
            d.d("HistoryDeviceInfoHolder", "the deviceName is empty");
            goto L43
        L45:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public HistoryDeviceInfoHolder$bind$1$1(c r1, LarusDoraHistoryDeviceInfoLayoutBinding r2, b r3, Continuation<? super HistoryDeviceInfoHolder$bind$1$1> r4) {
        this.$data = r1;
        this.$this_run = r2;
        this.$cardContext = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new HistoryDeviceInfoHolder$bind$1$1(this.$data, this.$this_run, this.$cardContext, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        String r4 = this.$data.c();
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(r4, this.$data, this.$this_run, this.$cardContext, null);
        this.label = 1;
        if (BuildersKt.withContext(r11, r2, this) != r0) goto L12;
        return r0;
    }
}
