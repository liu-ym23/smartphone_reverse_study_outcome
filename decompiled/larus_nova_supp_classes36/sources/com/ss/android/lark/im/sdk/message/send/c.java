package com.ss.android.lark.im.sdk.message.send;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.SendScene;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.im.sdk.message.SendMessagePipelines;
import com.ss.android.lark.im.sdk.service.o;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.parser.internal.r;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements jkb.d<k> {
    public final boolean a;
    public final SendMessagePipelines.b b;
    public final nkb.a c;

    public static final class a {
    }

    static {
    }

    @Override // jkb.d
    public final String getName() {
        return "ClientCreatePreMessageStep";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r13v21, types: [java.util.LinkedHashMap] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v12, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r14v13, types: [java.util.LinkedHashMap] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r27v0 */
    @Override // jkb.d
    public final void a(jkb.b r30, jkb.c r31) {
        k r1 = (k) r30;
        Intrinsics.checkNotNullParameter(r1, "pipelineContext");
        Intrinsics.checkNotNullParameter(r31, "pipelineControl");
        MessageParams<?, ?> r2 = r1.a;
        o r4 = r1.b;
        if (this.a == true) goto L15;
        Message.Type r5 = r2.e;
        Intrinsics.checkNotNullParameter(r5, "type");
        if (r5 != Message.Type.TEXT) goto L7;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == true) goto L15;
        int r3 = com.ss.android.lark.im.sdk.a.a;
        String r7 = "Client can't create pre-message for message type: " + r2.e;
        Intrinsics.checkNotNullParameter("ClientCreatePreMessageStep", "tag");
        Intrinsics.checkNotNullParameter(r7, INotificationHitPoint.NoticeType.MESSAGE);
        Log.w("ClientCreatePreMessageStep", r7);
        r31.a();
        return;
    L7:
        if (r5 == Message.Type.POST) goto L12;
        if (r5 == Message.Type.FILE) goto L12;
        r6 = false;
    L15:
        Log.i("ClientCreatePreMessageStep", "client crate pre message");
        r4.j();
        nkb.a r8 = this.c;
        Intrinsics.checkNotNullParameter(r2, "messageParam");
        Intrinsics.checkNotNullParameter(r8, "currentChatChatterProvider");
        String r11 = r2.d;
        if (r11 != null) goto L18;
    L21:
        boolean r12 = true;
    L23:
        if (r12 == false) goto L25;
        Log.e("ClientCreatePreMessageStep", "messageParam.cId.isNullOrEmpty()");
        k r28 = r1;
        MessageInfo r9 = null;
    L117:
        r4.f();
        if (r9 == null) goto L120;
        r4.h(r9);
        com.ss.android.lark.im.sdk.a.b("ClientCreatePreMessageStep", "MessageInfo created, push pre-message");
        this.b.I(r9);
    L121:
        if (r9 == null) goto L123;
        String r13 = r9.getcId();
    L124:
        r4.o(r13);
        r28.c = r9;
        r31.a();
        return;
    L123:
        r13 = null;
        goto L124
    L120:
        int r10 = com.ss.android.lark.im.sdk.a.a;
        Intrinsics.checkNotNullParameter("ClientCreatePreMessageStep", "tag");
        Intrinsics.checkNotNullParameter("MessageInfo create failed", INotificationHitPoint.NoticeType.MESSAGE);
        Log.w("ClientCreatePreMessageStep", "MessageInfo create failed");
        goto L121
    L25:
        Log.i("ClientCreatePreMessageStep", "createLocalPreMessage: " + r2.e + '/' + r2.d);
        Message r14 = r2.c(null, ImSdkProxy.e().getCurrentUserId());
        if (r14.getType() != Message.Type.TEXT) goto L115;
        Map r15 = r2.y;
        if (r15 != null) goto L30;
    L33:
        boolean r16 = true;
    L34:
        if (r16 == true) goto L115;
        Map r17 = r2.z;
        if (r17 != null) goto L38;
    L41:
        boolean r18 = true;
    L42:
        if (r18 == true) goto L115;
        Map r19 = r2.y;
        if (r19 == null) goto L55;
        ?? r110 = new LinkedHashMap();
        Iterator r111 = r19.entrySet().iterator();
    L47:
        if (r111.hasNext() == false) goto L56;
        Map.Entry r112 = (Map.Entry) r111.next();
        if (((UrlPreviewHangPoint) r112.getValue()).send_scene == UrlPreviewHangPoint.SendScene.DOUBAO_CLOUD_DRIVE_CHOOSE) goto L51;
        boolean r20 = true;
    L52:
        if (r20 == false) goto L47;
        r110.put(r112.getKey(), r112.getValue());
        goto L47
    L51:
        r20 = false;
    L56:
        if (r110 != 0) goto L58;
        r110 = MapsKt.emptyMap();
    L58:
        Collection r21 = r110.values();
        ArrayList r113 = new ArrayList();
        Iterator r22 = r21.iterator();
    L60:
        if (r22.hasNext() == false) goto L64;
        String r114 = ((UrlPreviewHangPoint) r22.next()).preview_id;
        if (r114 == null) goto L60;
        r113.add(r114);
        goto L60
    L64:
        Set r23 = CollectionsKt.toSet(r113);
        Map r115 = r2.z;
        if (r115 == null) goto L72;
        ?? r116 = new LinkedHashMap();
        Iterator r117 = r115.entrySet().iterator();
    L68:
        if (r117.hasNext() == false) goto L73;
        Map.Entry r118 = (Map.Entry) r117.next();
        if (r23.contains((String) r118.getKey()) == false) goto L68;
        r116.put(r118.getKey(), r118.getValue());
    L73:
        if (r116 != 0) goto L75;
        r116 = MapsKt.emptyMap();
    L75:
        RichText r24 = r14.getMessageContent().getRichText();
        if (r24 == null) goto L115;
        if (CollectionUtils.isEmpty(r110) == true) goto L115;
        LinkedHashMap r25 = new LinkedHashMap();
        Iterator r119 = r110.entrySet().iterator();
    L82:
        if (r119.hasNext() == false) goto L114;
        Map.Entry r120 = (Map.Entry) r119.next();
        String r121 = (String) r120.getKey();
        UrlPreviewHangPoint r122 = (UrlPreviewHangPoint) r120.getValue();
        if (r122 == null) goto L82;
        if (CollectionUtils.isEmpty(r116) == false) goto L89;
    L93:
        UrlCardPreviewEntity r26 = null;
    L94:
        String r123 = r122.url;
        ?? r27 = r116;
        String r124 = r122.preview_id;
        k r29 = r1;
        Boolean r32 = r122.need_local_preview;
        if (r32 != null) goto L97;
    L99:
        boolean r210 = false;
    L100:
        Boolean r33 = r122.is_lazy_load;
        if (r33 != null) goto L103;
    L105:
        boolean r211 = false;
    L106:
        UrlPreviewHangPoint.SendScene r34 = r122.send_scene;
        if (r34 == null) goto L112;
        SendScene.a r125 = SendScene.Companion;
        int r35 = r34.getValue();
        r125.getClass();
        if (r35 != 1) goto L111;
        SendScene r36 = SendScene.DOUBAO_CLOUD_DRIVE_CHOOSE;
    L113:
        r25.put(r121, new PreviewHangPoint(r123, r121, null, r124, r210, r211, r36, r26));
        r119 = r119;
        r116 = r27;
        r1 = r29;
        goto L82
    L111:
        r36 = SendScene.DEFAULT;
        goto L113
    L112:
        r36 = SendScene.DEFAULT;
        goto L113
    L103:
        if (r33.booleanValue() == false) goto L105;
        r211 = true;
        goto L106
    L97:
        if (r32.booleanValue() == false) goto L99;
        r210 = true;
        goto L100
    L89:
        if (TextUtils.isEmpty(r122.preview_id) == true) goto L93;
        UrlPreviewEntity r37 = (UrlPreviewEntity) r116.get(r122.preview_id);
        if (r37 == null) goto L93;
        r26 = j6b.d.d(r37, false);
        goto L94
    L114:
        r28 = r1;
        r.x(r24, r25);
    L116:
        r14.setNewTopic(false);
        r9 = new MessageInfo(r14, r8.a(r2.c));
        goto L117
    L72:
        r116 = 0;
        goto L73
    L55:
        r110 = 0;
        goto L56
    L38:
        if (r17.isEmpty() == true) goto L41;
        r18 = false;
        goto L42
    L30:
        if (r15.isEmpty() == true) goto L33;
        r16 = false;
    L115:
        r28 = r1;
        goto L116
    L18:
        if (r11.length() == 0) goto L21;
        r12 = false;
        goto L23
    }

    public c(boolean r2, SendMessagePipelines.b r3, nkb.a r4) {
        Intrinsics.checkNotNullParameter(r3, "preMessageCallback");
        Intrinsics.checkNotNullParameter(r4, "currentChatChatterProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
