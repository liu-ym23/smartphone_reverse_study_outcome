package com.larus.browsertakeover.signaling;

import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.larus.im.internal.jni.bean.RoomMeta;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/larus/browsertakeover/signaling/RtcSessionMetaApi;", "", "sessionMeta", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/browsertakeover/signaling/RtcSessionMetaData;", "sessionId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface RtcSessionMetaApi {
    public static final Companion a = null;

    public static final class Companion {
        public static final /* synthetic */ Companion a = null;

        static {
            a = new Companion();
        }

        public Companion() {
        }

        public final Object a(String r14, Continuation<? super RoomMeta> r15) {
            if ((r15 instanceof RtcSessionMetaApi$Companion$refresh$1) == false) goto L7;
            RtcSessionMetaApi$Companion$refresh$1 r0 = (RtcSessionMetaApi$Companion$refresh$1) r15;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r16 = r0.result;
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            boolean r11 = true;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            r14 = (String) r0.L$0;
            ResultKt.throwOnFailure(r16);
        L20:
            dm9.a.b r17 = (dm9.a) r16;
            JobKt.ensureActive(r0.getContext());
            if ((r17 instanceof dm9.a.b) == false) goto L41;
            BizResponse r18 = r17.a;
            if (r18.isSuccess() == true) goto L25;
            return null;
        L25:
            RtcSessionMetaData r19 = (RtcSessionMetaData) r18.getData();
            if (r19 == null) goto L45;
            RtcRoomMetaData r110 = r19.getRoomMeta();
            if (r110 == null) goto L46;
            RoomMeta r111 = r110.toRoomMeta();
            if (r111 != null) goto L32;
            return null;
        L32:
            if (j.b(r111) == true) goto L34;
        L36:
            r11 = false;
        L37:
            if (r11 == true) goto L39;
            return null;
        L39:
            return r111;
        L34:
            if (Intrinsics.areEqual(r111.sessionId, r14) == false) goto L36;
        L46:
            return null;
        L45:
            return null;
        L41:
            if ((r17 instanceof dm9.a.a) == false) goto L44;
            return null;
        L44:
            throw new NoWhenBranchMatchedException();
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r16);
            if (StringsKt.isBlank(r14) == false) goto L17;
            return null;
        L17:
            FlowHttpConnection r112 = FlowHttpConnection.a;
            RtcSessionMetaApi$Companion$refresh$result$1 r3 = new RtcSessionMetaApi$Companion$refresh$result$1(r14, null);
            r0.L$0 = r14;
            r0.label = 1;
            r16 = FlowHttpConnection.g("MainBot", RtcSessionMetaApi.class, r3, false, null, null, null, r0, 240);
            if (r16 != r10) goto L20;
            return r10;
        L7:
            r0 = new RtcSessionMetaApi$Companion$refresh$1(this, r15);
            goto L8
        }
    }

    static {
        a = Companion.a;
    }

    @GET("/alice/dispatch/rtc/session_meta")
    Object sessionMeta(@Query("session_id") String r1, Continuation<? super BizResponse<RtcSessionMetaData>> r2);
}
