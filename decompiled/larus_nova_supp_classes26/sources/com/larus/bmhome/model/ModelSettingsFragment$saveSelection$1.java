package com.larus.bmhome.model;

import com.larus.bmhome.bot.AppSettingModel;
import com.larus.bmhome.chat.model.api.DefaultActiveModelSettingItem;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuConfigV2;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuDataV2;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.model.ModelSettingsFragment$saveSelection$1", f = "ModelSettingsFragment.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {})
final class ModelSettingsFragment$saveSelection$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $modeId;
    final /* synthetic */ String $modelKey;
    final /* synthetic */ Map<String, DefaultActiveModelSettingItem> $updatedModels;
    int label;
    final /* synthetic */ ModelSettingsFragment this$0;

    public ModelSettingsFragment$saveSelection$1(ModelSettingsFragment r1, Map<String, DefaultActiveModelSettingItem> r2, String r3, String r4, Continuation<? super ModelSettingsFragment$saveSelection$1> r5) {
        this.this$0 = r1;
        this.$updatedModels = r2;
        this.$modeId = r3;
        this.$modelKey = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ModelSettingsFragment$saveSelection$1(this.this$0, this.$updatedModels, this.$modeId, this.$modelKey, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L12;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L7 CancellationException -> L9 Exception -> L22
    L17:
        boolean r6 = ((Boolean) r5).booleanValue();     // Catch: Throwable -> L7 CancellationException -> L9 Exception -> L22
        ModelSettingsAdapter r2 = this.this$0.f;
        if (r2 == null) goto L21;
        r2.z2(this.$modeId, this.$modelKey, false);
    L21:
        this.this$0.g = false;
    L26:
        if (r6 == false) goto L35;
        ModelSettingsFragment r7 = this.this$0;
        int r3 = ModelSettingsFragment.h;
        DefaultReplyMenuDataV2 r4 = r7.S90().getDefaultActiveModelMenu();
        if (r4 == null) goto L30;
        DefaultReplyMenuConfigV2 r8 = r4.getMenuConfV2();
    L31:
        Map<String, DefaultActiveModelSettingItem> r9 = this.this$0.S90().getDefaultActiveModelSettingItem();
        if (r9 != null) goto L34;
        r9 = MapsKt.emptyMap();
    L34:
        r7.T90(r8, r9);
    L37:
        return Unit.INSTANCE;
    L30:
        r8 = null;
        goto L31
    L35:
        s.a.g(this.this$0.requireContext(), 2131908080, false);
        goto L37
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r5);
        ModelSettingsFragment r10 = this.this$0;     // Catch: Throwable -> L7 CancellationException -> L9 Exception -> L22
        int r11 = ModelSettingsFragment.h;     // Catch: Throwable -> L7 CancellationException -> L9 Exception -> L22
        AppSettingModel r12 = r10.S90();     // Catch: Throwable -> L7 CancellationException -> L9 Exception -> L22
        Map<String, DefaultActiveModelSettingItem> r13 = this.$updatedModels;     // Catch: Throwable -> L7 CancellationException -> L9 Exception -> L22
        this.label = 1;     // Catch: Throwable -> L7 CancellationException -> L9 Exception -> L22
        r5 = r12.saveDefaultActiveModelSettingItemMap(r13, this);     // Catch: Throwable -> L7 CancellationException -> L9 Exception -> L22
        if (r5 != r0) goto L17;
        return r0;
    L7:
        th = move-exception;
        ModelSettingsAdapter r14 = this.this$0.f;
        if (r14 == null) goto L42;
        r14.z2(this.$modeId, this.$modelKey, false);
    L42:
        this.this$0.g = false;
        throw th;
    L9:
        e = move-exception;
        throw e;     // Catch: Throwable -> L7
    L22:
        ModelSettingsAdapter r15 = this.this$0.f;
        if (r15 == null) goto L25;
        r15.z2(this.$modeId, this.$modelKey, false);
    L25:
        this.this$0.g = false;
        r6 = false;
        goto L26
    }
}
