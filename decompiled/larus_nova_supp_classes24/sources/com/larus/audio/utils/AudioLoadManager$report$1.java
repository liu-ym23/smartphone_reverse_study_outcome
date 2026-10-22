package com.larus.audio.utils;

import com.ixigua.lib.track.TrackParams;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.report.g;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.utils.AudioLoadManager$report$1", f = "AudioLoadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AudioLoadManager$report$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $error;
    final /* synthetic */ String $eventName;
    final /* synthetic */ String $styleId;
    final /* synthetic */ String $url;
    int label;

    public AudioLoadManager$report$1(String r1, String r2, String r3, String r4, Continuation<? super AudioLoadManager$report$1> r5) {
        this.$styleId = r1;
        this.$url = r2;
        this.$eventName = r3;
        this.$error = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AudioLoadManager$report$1(this.$styleId, this.$url, this.$eventName, this.$error, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r6);
        JSONObject r7 = new JSONObject();
        String r0 = this.$styleId;
        String r1 = this.$url;
        String r2 = this.$eventName;
        String r3 = this.$error;
        r7.put("id", r0);
        r7.put("url", r1);
        r7.put("event", r2);
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r7.put("error", r3);
        r7.put("env", AppHost.a.getBuildChannel());
        int r4 = g.a;
        Intrinsics.checkNotNullParameter("tts_sample", "event");
        Intrinsics.checkNotNullParameter(r7, "params");
        TrackParams r8 = new TrackParams().merge(r7);
        by7.a r5 = new by7.a("tts_sample");
        r5.a.merge(r8);
        r5.b();
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
