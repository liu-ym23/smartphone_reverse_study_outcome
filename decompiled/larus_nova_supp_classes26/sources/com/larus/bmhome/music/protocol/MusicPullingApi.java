package com.larus.bmhome.music.protocol;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.stream.JsonReader;
import com.larus.bmhome.chat.resp.MessageList;
import com.larus.bmhome.music.widget.n2;
import com.larus.im.bean.IMMsg;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.LyricsSeekContent;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.im.bean.message.block.MusicCreationContentList;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import java.io.StringReader;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class MusicPullingApi {
    public static final MusicPullingApi a = null;

    static {
        a = new MusicPullingApi();
    }

    public MusicPullingApi() {
    }

    public static Pair a(MusicCreationContent r5) {
        if (TextUtils.isEmpty(r5.getLyricsSeekContent()) == false) goto L5;
        return null;
    L5:
        JsonReader r0 = new JsonReader(new StringReader(r5.getLyricsSeekContent()));
        boolean r2 = true;
        r0.setLenient(true);
        LyricsSeekContent r1 = (LyricsSeekContent) GsonProtectorUtils.fromJson(HttpExtKt.f, r0, LyricsSeekContent.class);
        if (TextUtils.isEmpty(r5.getVid()) == true) goto L18;
        if (r1 == null) goto L13;
        List r3 = r1.getUtterances();
        if (r3 == null) goto L13;
        if (r3.isEmpty() == true) goto L13;
    L14:
        if (r2 == false) goto L18;
        return TuplesKt.to(r5, r1);
    L13:
        r2 = false;
    L18:
        return null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008d -> B:25:0x0094). Please report as a decompilation issue!!! */
    public final Object b(Message r19, String r20, int r21, Continuation<? super Pair<? extends MusicCreationContent, LyricsSeekContent>> r22) {
        if ((r22 instanceof MusicPullingApi$pullMusicStateTillCanPlay$1) == false) goto L7;
        MusicPullingApi$pullMusicStateTillCanPlay$1 r1 = (MusicPullingApi$pullMusicStateTillCanPlay$1) r22;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        int r6 = 1;
        String r7 = "MusicPlayerDetailFragment";
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        int r5 = r1.I$0;
        String r8 = (String) r1.L$1;
        Message r9 = (Message) r1.L$0;
        ResultKt.throwOnFailure(r0);
        Object r15 = r3;
        int r10 = r5;
        MusicPullingApi$pullMusicStateTillCanPlay$1 r11 = r1;
        String r12 = r8;
    L25:
        dm9.a.b r13 = (dm9.a) r0;
        if ((r13 instanceof dm9.a.b) == false) goto L88;
        dm9.a.b r14 = r13;
        MessageList r16 = (MessageList) r14.a.getData();
        if (r16 == null) goto L90;
        List r17 = r16.getMessageList();
        if (r17 == null) goto L90;
        List r18 = CollectionsKt.filterNotNull(r17);
        if (r18 == null) goto L90;
        IMMsg r23 = (IMMsg) CollectionsKt.firstOrNull(r18);
        if (r23 == null) goto L90;
        FLogger r24 = FLogger.a;
        r24.i(r7, "[fetchMessageListForMusic] isSuccess=" + r14.a.isSuccess() + ", content=" + r23.a());
        Integer r25 = r23.b();
        String r110 = "";
        if (r25 != null) goto L39;
    L51:
        if (r25 != null) goto L54;
    L71:
        if (r25 != null) goto L74;
    L86:
        r24.e(r7, "[MusicPullingApi] e: fault content type un noticed");
        goto L90
    L74:
        if (r25.intValue() != 9999) goto L86;
        MusicCreationContentList r26 = n2.a(r23.a());
        if (r26 == null) goto L90;
        Map r27 = r26.getContentMap();
        if (r27 == null) goto L90;
        MusicCreationContent r28 = (MusicCreationContent) r27.get(r12);
        if (r28 == null) goto L90;
        Pair r29 = a(r28);
        if (r29 == null) goto L90;
        r24.e(r7, "[MusicPullingApi] fetched match with vid " + r28.getVid() + ' ');
        return r29;
    L54:
        if (r25.intValue() != 72) goto L71;
        String r30 = r23.i();
        if (r30 != null) goto L58;
        r30 = "";
    L58:
        String r31 = r23.a();
        if (r31 == null) goto L62;
        r110 = r31;
    L62:
        Map r32 = a.b(r30, r110).getContentMap();
        if (r32 == null) goto L90;
        MusicCreationContent r33 = (MusicCreationContent) r32.get(r12);
        if (r33 == null) goto L90;
        Pair r34 = a(r33);
        if (r34 == null) goto L90;
        r24.e(r7, "[MusicPullingApi] fetched match with vid " + r33.getVid() + ' ');
        return r34;
    L39:
        if (r25.intValue() != 70) goto L51;
        MusicCreationContent.b r35 = MusicCreationContent.Companion;
        String r36 = r23.a();
        if (r36 == null) goto L44;
        r110 = r36;
    L44:
        Function1 r37 = new i();
        r35.getClass();
        MusicCreationContent r38 = MusicCreationContent.b.a(r110, r37);
        if (r38 == null) goto L90;
        Pair r39 = a(r38);
        if (r39 == null) goto L90;
        r24.e(r7, "[MusicPullingApi] fetched match with vid " + r38.getVid() + ' ');
        return r39;
    L90:
        String r111 = r7;
        Message r40 = r9;
        r6 = 1;
    L19:
        int r112 = r10 - 1;
        if (r10 <= 0) goto L91;
        MusicMessageFetchApi.a r41 = MusicMessageFetchApi.a;
        MusicPullingApi$pullMusicStateTillCanPlay$result$1 r42 = new MusicPullingApi$pullMusicStateTillCanPlay$result$1(r40, null);
        r11.L$0 = r40;
        r11.L$1 = r12;
        r11.I$0 = r112;
        r11.label = r6;
        r41.getClass();
        FlowHttpConnection r43 = FlowHttpConnection.a;
        Object r44 = r15;
        Object r45 = FlowHttpConnection.g("Basic", MusicMessageFetchApi.class, r42, false, null, null, null, r11, 248);
        if (r45 != r44) goto L24;
        return r44;
    L24:
        r9 = r40;
        r0 = r45;
        r15 = r44;
        r7 = r111;
        r10 = r112;
        goto L25
    L91:
        return null;
    L88:
        if ((r13 instanceof dm9.a.a) == false) goto L90;
        FLogger.a.e(r7, "[MusicPullingApi] e:" + ((dm9.a.a) r13).c);
        goto L90
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (r19 != null) goto L18;
        FLogger.a.i("MusicPlayerDetailFragment", "[MusicPullingApi] lyrics binding message is null");
        return null;
    L18:
        r40 = r19;
        r11 = r1;
        r15 = r3;
        r111 = "MusicPlayerDetailFragment";
        r12 = r20;
        r10 = r21;
    L7:
        r1 = new MusicPullingApi$pullMusicStateTillCanPlay$1(this, r22);
        goto L8
    }
}
