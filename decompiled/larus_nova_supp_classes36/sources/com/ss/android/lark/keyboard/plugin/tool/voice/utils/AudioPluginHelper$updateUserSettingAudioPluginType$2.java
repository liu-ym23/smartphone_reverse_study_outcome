package com.ss.android.lark.keyboard.plugin.tool.voice.utils;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.UniversalUserSetting;
import com.bytedance.lark.pb.settings.v1.UpdateUniversalUserSettingRequest;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.audio.voiceinput.AudioPluginUseType;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.larkconfig.universal.UniversalUserSettingService$updateUniversalUserSetting$1;
import com.ss.android.lark.larkconfig.universal.d;
import com.ss.android.lark.larkconfig.universal.e;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.utils.AudioPluginHelper$updateUserSettingAudioPluginType$2", f = "AudioPluginHelper.kt", i = {}, l = {182}, m = "invokeSuspend", n = {}, s = {})
final class AudioPluginHelper$updateUserSettingAudioPluginType$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ AudioPluginUseType $type;
    Object L$0;
    int label;

    public AudioPluginHelper$updateUserSettingAudioPluginType$2(AudioPluginUseType r1, Continuation<? super AudioPluginHelper$updateUserSettingAudioPluginType$2> r2) {
        this.$type = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AudioPluginHelper$updateUserSettingAudioPluginType$2(this.$type, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Long> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        AudioPluginUseType r2 = (AudioPluginUseType) this.L$0;
        ResultKt.throwOnFailure(r8);
    L13:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        final AudioPluginUseType r9 = this.$type;
        this.L$0 = r9;
        this.label = 1;
        final j r3 = new j(IntrinsicsKt.intercepted(this), 1);
        r3.C();
        final UIGetDataCallback r4 = new UIGetDataCallback(new AudioPluginHelper$updateUserSettingAudioPluginType$2$1$callback$1(r9, r3));
        r3.i(new AudioPluginHelper$updateUserSettingAudioPluginType$2$1$1(r4));
        e r5 = e.a;
        long r6 = r9.getType();
        final String r7 = "VOICE_SEND_MENU_OPTION";
        Intrinsics.checkNotNullParameter("VOICE_SEND_MENU_OPTION", TabAppInfo.IMAGE_JSON_KEY);
        UpdateUniversalUserSettingRequest.Builder r10 = new UpdateUniversalUserSettingRequest.Builder().settings(CollectionsKt.listOf(new UniversalUserSetting.Builder().key("VOICE_SEND_MENU_OPTION").int_value(Long.valueOf(r6)).build()));
        Intrinsics.checkNotNull(r10);
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_UNIVERSAL_USER_SETTING, r10, new UniversalUserSettingService$updateUniversalUserSetting$1(r4, r7), d.a);
        r8 = r3.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r8 != r0) goto L13;
        return r0;
    }
}
