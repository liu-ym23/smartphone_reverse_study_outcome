package com.larus.dora.impl.device.settings.camera;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.databinding.LarusDoraPageCameraSettingsBinding;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.camera.CameraSettingsFragment$mBurstTakeImageSwitchCheckedChangeListener$1$realSyncConfig$1$1", f = "CameraSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CameraSettingsFragment$mBurstTakeImageSwitchCheckedChangeListener$1$realSyncConfig$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $b;
    int label;
    final /* synthetic */ CameraSettingsFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.camera.CameraSettingsFragment$mBurstTakeImageSwitchCheckedChangeListener$1$realSyncConfig$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.camera.CameraSettingsFragment$mBurstTakeImageSwitchCheckedChangeListener$1$realSyncConfig$1$1$1", f = "CameraSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $b;
        final /* synthetic */ int $ret;
        int label;
        final /* synthetic */ CameraSettingsFragment this$0;

        public AnonymousClass1(int r1, CameraSettingsFragment r2, boolean r3, Continuation<? super AnonymousClass1> r4) {
            this.$ret = r1;
            this.this$0 = r2;
            this.$b = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$ret, this.this$0, this.$b, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r4);
            if (this.$ret == 0) goto L12;
            CameraSettingsFragment r5 = this.this$0;
            boolean r0 = !this.$b;
            int r2 = CameraSettingsFragment.k;
            LarusDoraPageCameraSettingsBinding r3 = r5.f;
            if (r3 == null) goto L20;
            ItemTextToggle r6 = r3.d;
            if (r6 == null) goto L20;
            CameraSettingsFragment.X90(r0, r6, r5.j, true);
        L20:
            return Unit.INSTANCE;
        L12:
            if (this.$b == false) goto L14;
            CameraSettingsFragment r7 = this.this$0;
            int r1 = CameraSettingsFragment.k;
            r7.W90().updateLiveAITalkEnable();
        L14:
            CameraSettingsFragment r8 = this.this$0;
            boolean r9 = this.$b;
            int r10 = CameraSettingsFragment.k;
            LarusDoraPageCameraSettingsBinding r11 = r8.f;
            if (r11 == null) goto L20;
            ItemTextToggle r12 = r11.d;
            if (r12 == null) goto L20;
            CameraSettingsFragment.X90(r9, r12, r8.j, false);
            goto L20
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CameraSettingsFragment$mBurstTakeImageSwitchCheckedChangeListener$1$realSyncConfig$1$1(boolean r1, CameraSettingsFragment r2, Continuation<? super CameraSettingsFragment$mBurstTakeImageSwitchCheckedChangeListener$1$realSyncConfig$1$1> r3) {
        this.$b = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CameraSettingsFragment$mBurstTakeImageSwitchCheckedChangeListener$1$realSyncConfig$1$1(this.$b, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r8);
        int r9 = kj4.a.g().d.f(this.$b ? 1 : 0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getMain(), null, new AnonymousClass1(r9, this.this$0, this.$b, null), 2, null);
        t39.c r0 = j49.b.a;
        boolean r1 = this.$b;
        DoraBuryPointManager r2 = DoraBuryPointManager.a;
        Pair[] r3 = new Pair[2];
        int r4 = 0;
        r3[0] = TuplesKt.to("settings_detail", j49.b.l(r1));
        if (r9 != 0) goto L7;
        r4 = 1;
    L7:
        r3[1] = TuplesKt.to("is_success", Integer.valueOf(r4));
        r2.L("dora_continuous_photo_settings", MapsKt.mapOf(r3));
        g49.d.d(this.this$0.h, "doraBurstTakeImageSwitch set: " + this.$b + ", ret: " + r9);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
