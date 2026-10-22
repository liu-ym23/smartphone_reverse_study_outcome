package com.larus.dora.impl.dynamic;

import android.content.Intent;
import android.os.Build;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import com.larus.platform.service.i2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.DoraDynamicFragment$checkReady$1", f = "DoraDynamicFragment.kt", i = {}, l = {880}, m = "invokeSuspend", n = {}, s = {})
final class DoraDynamicFragment$checkReady$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraDynamicFragment this$0;

    public static final class a implements com.larus.platform.api.g1.c {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ DoraDynamicFragment b;

        public final void onSettingPageReturn() {
        }

        public final void onGoSettingsDialogShow() {
            g49.d.d("DoraDynamicFragment", "checkReady: permission onGoSettingsDialogShow");
            this.a.element = true;
        }

        public final void onGoSettingsDialogDismiss(boolean r3) {
            g49.d.d("DoraDynamicFragment", "checkReady: permission onGoSettingsDialogDismiss, " + r3);
            if (r3 == true) goto L8;
            FragmentActivity r4 = this.b.getActivity();
            if (r4 == null) goto L9;
            r4.finish();
            return;
        L9:
            return;
        }

        public a(Ref.BooleanRef r1, DoraDynamicFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onResult(boolean r1, List<String> r2, List<String> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "grantedList");
            Intrinsics.checkNotNullParameter(r3, "deniedList");
            g49.d.d("DoraDynamicFragment", "checkReady: request permission, isGranted = " + r1);
            if (r1 == false) goto L5;
            DoraDynamicFragment r5 = this.b;
            int r6 = DoraDynamicFragment.C;
            r5.Z90();
            return;
        L5:
            g49.d.d("DoraDynamicFragment", "checkReady: request permission failed, goSettingsDialogShown=" + this.a.element);
            if (this.a.element == true) goto L12;
            FragmentActivity r7 = this.b.getActivity();
            if (r7 == null) goto L13;
            r7.finish();
            return;
        L13:
            return;
        }
    }

    public DoraDynamicFragment$checkReady$1(DoraDynamicFragment r1, Continuation<? super DoraDynamicFragment$checkReady$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraDynamicFragment$checkReady$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        int r13 = ((Number) r12).intValue();
        if (r13 == 1) goto L22;
        if (r13 != 2) goto L32;
        g49.d.d("DoraDynamicFragment", "checkReady: request open bluetooth switch");
        ActivityResultLauncher<Intent> r14 = this.this$0.r;     // Catch: Throwable -> L20
        if (r14 == null) goto L32;
        r14.launch(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        g49.d.c("DoraDynamicFragment", "launch android.bluetooth.adapter.action.REQUEST_ENABLE error", th);
    L32:
        return Unit.INSTANCE;
    L22:
        ArrayList r3 = new ArrayList();
        int r15 = Build.VERSION.SDK_INT;
        if (r15 < 31) goto L25;
        r3.add("android.permission.BLUETOOTH_SCAN");
        r3.add("android.permission.BLUETOOTH_CONNECT");
        r3.add("android.permission.BLUETOOTH");
    L26:
        g49.d.d("DoraDynamicFragment", "checkReady: request permission");
        Ref.BooleanRef r2 = new Ref.BooleanRef();
        i2 r9 = i2.b;
        DoraDynamicFragment r10 = this.this$0;
        a r11 = new a(r2, r10);
        if (r15 < 31) goto L29;
        int r16 = com.larus.utils.j0.a;
        Map r17 = MapsKt.mapOf(TuplesKt.to("android.permission.BLUETOOTH_SCAN", com.larus.utils.j0.d(2131898388)));
    L30:
        com.larus.platform.api.g1.a.a(r10, r3, r11, r17, null, 16);
        goto L32
    L29:
        int r4 = com.larus.utils.j0.a;
        r17 = MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.BLUETOOTH", com.larus.utils.j0.d(2131898388)), TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", com.larus.utils.j0.d(2131898388)), TuplesKt.to("android.permission.ACCESS_COARSE_LOCATION", com.larus.utils.j0.d(2131898388))});
        goto L30
    L25:
        r3.add("android.permission.BLUETOOTH");
        r3.add("android.permission.BLUETOOTH_ADMIN");
        r3.add("android.permission.ACCESS_FINE_LOCATION");
        r3.add("android.permission.ACCESS_COARSE_LOCATION");
        goto L26
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r18 = Dispatchers.getIO();
        DoraDynamicFragment$checkReady$1$ready$1 r5 = new DoraDynamicFragment$checkReady$1$ready$1(null);
        this.label = 1;
        r12 = BuildersKt.withContext(r18, r5, this);
        if (r12 != r0) goto L11;
        return r0;
    }
}
