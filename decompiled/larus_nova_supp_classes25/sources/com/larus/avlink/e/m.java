package com.larus.avlink.e;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.avlink.gallery.thumbnail.l0;
import com.larus.avlink.gallery.thumbnail.m0;
import com.larus.avlink.model.DoraVisionBizScene;
import com.larus.avlink.record.util.LarkRecordMinutesManager;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m {
    public static final m a = null;

    public static final class a {
        public final boolean a;
        public final f98.h b;
        public final AsyncThrowable c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            f98.h r2 = this.b;
            int r3 = 0;
            if (r2 != null) goto L9;
            int r4 = 0;
        L10:
            int r5 = (r1 + r4) * 31;
            AsyncThrowable r6 = this.c;
            if (r6 == null) goto L15;
            r3 = r6.hashCode();
        L15:
            return r5 + r3;
        L9:
            r4 = r2.hashCode();
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "UploadResult(success=" + this.a + ", response=" + this.b + ", error=" + this.c + ')';
        }

        public a(boolean r1, f98.h r2, AsyncThrowable r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        a = new m();
    }

    public m() {
    }

    public static void b(int r9, List r10, Map r11, int r12, l0 r13, m0 r14) {
        Intrinsics.checkNotNullParameter(r10, "visionInfo");
        Intrinsics.checkNotNullParameter(r11, "extra");
        Unit r15 = Unit.INSTANCE;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraENetworkUtil$uploadOcrResult$1(r9, r14, r10, r12, null), 3, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0345 -> B:13:0x0051). Please report as a decompilation issue!!! */
    public final Object a(b49.h r23, int r24, List r25, String r26, String r27, int r28, Integer r29, int r30, f r31, g r32, Continuation r33) {
        int r1 = r24;
        if ((r33 instanceof DoraENetworkUtil$uploadImageWithRetry$1) == false) goto L7;
        DoraENetworkUtil$uploadImageWithRetry$1 r3 = (DoraENetworkUtil$uploadImageWithRetry$1) r33;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        int r9 = 1;
        if (r6 == 0) goto L17;
        if (r6 == 1) goto L16;
        if (r6 != 2) goto L15;
        int r0 = r3.I$3;
        int r7 = r3.I$2;
        int r8 = r3.I$1;
        int r13 = r3.I$0;
        f98.e r14 = (f98.e) r3.L$2;
        Function8 r15 = (Function8) r3.L$1;
        List r10 = (List) r3.L$0;
        ResultKt.throwOnFailure(r2);
        int r11 = r7;
        r1 = r13;
        Function8 r12 = r15;
    L13:
        Object r19 = r5;
        DoraENetworkUtil$uploadImageWithRetry$1 r16 = r3;
        int r17 = r8;
        Object r18 = r19;
        int r110 = r0 + 1;
        List r20 = r10;
        f98.e r21 = r14;
        r9 = 1;
        int r111 = r11;
    L69:
        int r112 = t39.e.a;
        if (r110 > r9) goto L113;
        com.larus.dora.api.network.a r113 = com.larus.dora.api.network.a.a;
        JSONObject r114 = new JSONObject(GsonProtectorUtils.toJson(new Gson(), r21));
        r16.L$0 = r20;
        r16.L$1 = r12;
        r16.L$2 = r21;
        r16.I$0 = r1;
        r16.I$1 = r17;
        r16.I$2 = r111;
        r16.I$3 = r110;
        r16.label = r9;
        Object r22 = com.larus.dora.api.network.a.c(r113, f98.h.class, "/alice/audio/process_vision_file", r114, null, r16, 248);
        if (r22 != r18) goto L74;
        return r18;
    L74:
        List r115 = r20;
        r0 = r110;
        f98.e r116 = r21;
        int r34 = r1;
        int r35 = r111;
        r14 = r116;
        Function8 r36 = r12;
        r2 = r22;
        Object r210 = r18;
        r8 = r17;
        r3 = r16;
        r5 = r210;
    L75:
        y r37 = (com.larus.network.http.a) r2;
        if ((r37 instanceof y) == false) goto L102;
        f98.h r38 = (f98.h) ((com.larus.network.http.a) r37).b;
        if (r38 == null) goto L80;
        List<f98.o> r39 = r38.a();
    L81:
        List<f98.o> r40 = r39;
        if (r40 != null) goto L84;
    L87:
        boolean r41 = true;
    L89:
        if (r41 == false) goto L95;
        FLogger r42 = FLogger.a;
        StringBuilder r43 = new StringBuilder("uploadImage response contents is empty. mode: ");
        r43.append(r14.b);
        r43.append(", cid: ");
        r43.append(r14.b());
        r43.append(", imageId: ");
        r43.append(r8);
        r43.append(", imageCount: ");
        r43.append(r14.a);
        r43.append(", realCount: ");
        List<f98.l> r44 = r14.a();
        if (r44 == null) goto L93;
        Integer r45 = Boxing.boxInt(r44.size());
    L94:
        r43.append(r45);
        r43.append('.');
        r42.e("DoraE_Camera", r43.toString());
    L100:
        AsyncThrowable r46 = null;
        int r47 = 1;
    L114:
        if (r36 == null) goto L129;
        Integer r48 = Boxing.boxInt(r8);
        Integer r49 = Boxing.boxInt(r34);
        if (r47 == 0) goto L118;
        boolean r50 = true;
    L119:
        Boolean r51 = Boxing.boxBoolean(r50);
        f98.l r52 = (f98.l) CollectionsKt.firstOrNull(r115);
        if (r52 == null) goto L122;
        Integer r53 = r52.d();
    L123:
        f98.l r54 = (f98.l) CollectionsKt.firstOrNull(r115);
        if (r54 == null) goto L126;
        Integer r55 = r54.a();
    L127:
        r36.invoke(r48, r49, r14, r38, r51, r46, r53, r55);
        goto L129
    L126:
        r55 = null;
        goto L127
    L122:
        r53 = null;
        goto L123
    L118:
        r50 = false;
    L129:
        if (r47 == 0) goto L131;
        boolean r56 = true;
    L133:
        return new a(r56, r38, r46);
    L131:
        r56 = false;
        goto L133
    L93:
        r45 = null;
        goto L94
    L95:
        FLogger r57 = FLogger.a;
        StringBuilder r58 = new StringBuilder("uploadImage success. mode: ");
        r58.append(r14.b);
        r58.append(", cid: ");
        r58.append(r14.b());
        r58.append(", imageId: ");
        r58.append(r8);
        r58.append(", imageCount: ");
        r58.append(r14.a);
        r58.append(", realCount: ");
        List<f98.l> r59 = r14.a();
        if (r59 == null) goto L98;
        Integer r60 = Boxing.boxInt(r59.size());
    L99:
        r58.append(r60);
        r58.append('.');
        r57.i("DoraE_Camera", r58.toString());
        goto L100
    L98:
        r60 = null;
        goto L99
    L84:
        if (r40.isEmpty() == true) goto L87;
        r41 = false;
        goto L89
    L80:
        r39 = null;
        goto L81
    L102:
        if ((r37 instanceof com.larus.network.http.f) == false) goto L111;
        com.larus.network.http.f r61 = (com.larus.network.http.f) r37;
        FLogger.a.e("DoraE_Camera", "uploadImage failed. cid: " + r14.b() + ", imageId: " + r8 + ", imageCount: " + r14.a + ", retry: " + r0 + '.', r61.d);
        int r62 = t39.e.a;
        if (r0 >= 1) goto L110;
        r3.L$0 = r115;
        r3.L$1 = r36;
        r3.L$2 = r14;
        r3.I$0 = r34;
        r3.I$1 = r8;
        r3.I$2 = r35;
        r3.I$3 = r0;
        r3.label = 2;
        if (DelayKt.delay(500, r3) != r5) goto L108;
        return r5;
    L108:
        r12 = r36;
        r11 = r35;
        r1 = r34;
        r10 = r115;
        goto L13
    L110:
        r46 = r61.d;
        r38 = null;
        r47 = 0;
        goto L114
    L111:
        FLogger.a.i("DoraE_Camera", "uploadImage is loading. cid: " + r14.b() + ", imageId: " + r8 + ", imageCount: " + r14.a + '.');
        r17 = r8;
        r12 = r36;
        r20 = r115;
        f98.e r117 = r14;
        r111 = r35;
        r1 = r34;
        r21 = r117;
    L113:
        r115 = r20;
        r36 = r12;
        r8 = r17;
        r47 = r111;
        r38 = null;
        r14 = r21;
        r34 = r1;
        r46 = null;
        goto L114
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r0 = r3.I$3;
        r35 = r3.I$2;
        r8 = r3.I$1;
        r34 = r3.I$0;
        f98.e r118 = (f98.e) r3.L$2;
        Function8 r119 = (Function8) r3.L$1;
        r115 = (List) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r36 = r119;
        r14 = r118;
        goto L75
    L17:
        ResultKt.throwOnFailure(r2);
        int r63 = r23.a;
        List r64 = r25;
        if ((r64 instanceof Collection) == true) goto L20;
    L22:
        Iterator r65 = r64.iterator();
        int r120 = 0;
    L24:
        if (r65.hasNext() == false) goto L33;
        if (((f98.l) r65.next()) == null) goto L28;
        boolean r121 = true;
    L29:
        if (r121 == false) goto L24;
        r120 = r120 + 1;
        if (r120 >= 0) goto L24;
        CollectionsKt.throwCountOverflow();
        goto L24
    L28:
        r121 = false;
    L33:
        r21 = new f98.e();
        r21.c(r26);
        r21.e(r27);
        r21.a = r120;
        r21.b = r1;
        r21.i(r28);
        r21.d(CollectionsKt.filterNotNull(r64));
        r21.h(r30);
        f98.m r66 = new f98.m();
        r66.a(r23.e);
        r21.g(r66);
        if (ia8.e.a().isRecording() == true) goto L36;
    L50:
        r21.j(r29);
    L51:
        FLogger r67 = FLogger.a;
        StringBuilder r68 = new StringBuilder("uploadImage. imageId: ");
        r68.append(r63);
        r68.append(", mode: ");
        r68.append(r1);
        r68.append(", imageCount: ");
        r68.append(r21.a);
        r68.append(", imageUUID: ");
        List<f98.l> r122 = r21.a();
        if (r122 == null) goto L56;
        f98.l r123 = (f98.l) CollectionsKt.firstOrNull(r122);
        if (r123 == null) goto L56;
        String r124 = r123.b();
    L57:
        r68.append(r124);
        r67.i("DoraE_Camera", r68.toString());
        if (r31 == null) goto L68;
        Object r69 = Boxing.boxInt(r63);
        Object r70 = Boxing.boxInt(r24);
        f98.l r125 = (f98.l) CollectionsKt.firstOrNull(r25);
        if (r125 == null) goto L62;
        Object r126 = r125.d();
    L63:
        f98.l r127 = (f98.l) CollectionsKt.firstOrNull(r25);
        if (r127 == null) goto L66;
        Object r128 = r127.a();
    L67:
        r31.invoke(r69, r70, r21, r126, r128);
        goto L68
    L66:
        r128 = null;
        goto L67
    L62:
        r126 = null;
    L68:
        r20 = r25;
        r18 = r5;
        r110 = 0;
        r111 = 0;
        r16 = r3;
        r17 = r63;
        r12 = r32;
    L56:
        r124 = null;
        goto L57
    L36:
        if (r1 != 20) goto L50;
        IDoraService r71 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r71 == null) goto L44;
        DeviceService r72 = r71.device();
        if (r72 == null) goto L44;
        if (r72.J() != true) goto L44;
        boolean r73 = true;
    L45:
        if (r73 == false) goto L50;
        FLogger r74 = FLogger.a;
        StringBuilder r75 = new StringBuilder("GRecord, upload image recordId: ");
        LarkRecordMinutesManager.a.getClass();
        r75.append(LarkRecordMinutesManager.j());
        r74.i("DoraE_Camera", r75.toString());
        r21.j(Boxing.boxInt(DoraVisionBizScene.FPA_MEETING.getValue()));
        JSONObject r76 = new JSONObject();
        String r77 = LarkRecordMinutesManager.j();
        if (r77 != null) goto L49;
        r77 = "";
    L49:
        r76.put("meeting_message_id", r77);
        r21.f(r76.toString());
    L44:
        r73 = false;
        goto L45
    L20:
        if (r64.isEmpty() == false) goto L22;
        r120 = 0;
    L7:
        r3 = new DoraENetworkUtil$uploadImageWithRetry$1(this, r33);
        goto L8
    }
}
