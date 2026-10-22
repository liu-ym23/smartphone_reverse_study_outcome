package com.larus.bmhome.music.repo;

import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/music/repo/MediaRepo$MusicCheck;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.repo.MediaRepo$requireCheckMusic$2", f = "MediaRepo.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
final class MediaRepo$requireCheckMusic$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a.b>, Object> {
    final /* synthetic */ String $musicId;
    final /* synthetic */ int $scene;
    final /* synthetic */ int $source;
    int label;

    public MediaRepo$requireCheckMusic$2(int r1, String r2, int r3, Continuation<? super MediaRepo$requireCheckMusic$2> r4) {
        this.$source = r1;
        this.$musicId = r2;
        this.$scene = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MediaRepo$requireCheckMusic$2(this.$source, this.$musicId, this.$scene, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a.b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r16);
        Object r1 = r16;
    L20:
        return ((com.larus.network.http.a) r1).b;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r16);
        FLogger.a.d("MusicRepo", "requireCheckMusic");
        if (this.$source != (-1)) goto L11;
        return null;
    L11:
        if (this.$musicId.length() != 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L23;
        JSONObject r5 = new JSONObject();
        int r6 = this.$scene;
        int r7 = this.$source;
        String r8 = this.$musicId;
        JSONObject r10 = new JSONObject();
        r10.put("source_from", r7);
        r10.put("source_id", r8);
        Unit r9 = Unit.INSTANCE;
        r5.put("check_list", new JSONArray(new JSONObject[]{r10}));
        r5.put("scene", r6);
        this.label = 1;
        r1 = HttpExtKt.k("Basic", a.b.class, "/alice/media/mcheck/music", r5, null, null, false, null, null, null, this, 1008);
        if (r1 != r13) goto L20;
        return r13;
    L23:
        return null;
    L13:
        r2 = false;
        goto L14
    }
}
