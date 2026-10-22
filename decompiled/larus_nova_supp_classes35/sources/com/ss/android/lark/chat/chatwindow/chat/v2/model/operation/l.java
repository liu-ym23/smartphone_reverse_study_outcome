package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.parser.internal.r;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements Function1<f5b.b, f5b.b> {
    public static final /* synthetic */ int c = 0;
    public final Map<String, Map<String, UrlCardPreviewEntity>> a;
    public final Map<String, Map<String, MessageLink>> b;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.model.operation.l$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0076a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[Message.Type.values().length];
                r0[Message.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[Message.Type.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[Message.Type.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        @JvmStatic
        public static void a(Message r2, Map r3) {
            Intrinsics.checkNotNullParameter(r2, "message");
            Message.Type r0 = r2.getType();
            if (r0 != null) goto L5;
            int r1 = -1;
        L7:
            if (r1 != 1) goto L9;
            TextContent r4 = (TextContent) r2.getContent();
            b(r4.getPreviewHangPoints(), r3);
            r.x(r4.getRichText(), r4.getPreviewHangPoints());
            return;
        L9:
            if (r1 != 2) goto L11;
            PostContent r5 = (PostContent) r2.getContent();
            b(r5.getPreviewHangPoints(), r3);
            r.x(r5.getRichText(), r5.getPreviewHangPoints());
            return;
        L11:
            if (r1 != 3) goto L19;
            b(((FileContent) r2.getContent()).getPreviewHangPoints(), r3);
            return;
        L19:
            return;
        L5:
            r1 = C0076a.a[r0.ordinal()];
            goto L7
        }

        @JvmStatic
        public static void b(Map r3, Map r4) {
            Intrinsics.checkNotNullParameter(r3, "hangPoints");
            Iterator r5 = r3.entrySet().iterator();
        L4:
            if (r5.hasNext() == false) goto L18;
            Map.Entry r0 = (Map.Entry) r5.next();
            String r1 = ((PreviewHangPoint) r0.getValue()).getPreviewId();
            if (r1 == null) goto L4;
            if (r4 == null) goto L10;
            UrlCardPreviewEntity r2 = (UrlCardPreviewEntity) r4.get(r1);
        L11:
            PreviewHangPoint r6 = (PreviewHangPoint) r0.getValue();
            if (r6.getUrlCardPreviewEntity() == null) goto L13;
            if (r2 == null) goto L4;
            UrlCardPreviewEntity r7 = r6.getUrlCardPreviewEntity();
            Intrinsics.checkNotNull(r7);
            if (r2.compareTo2(r7) < 0) goto L4;
            r6.setUrlCardPreviewEntity(r2);
            goto L4
        L13:
            r6.setUrlCardPreviewEntity(r2);
            goto L4
        L10:
            r2 = null;
            goto L11
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Message.Type.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Message.Type.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final Object invoke(Object r14) {
        f5b.b r15 = (f5b.b) r14;
        Map<String, MessageLink> r0 = null;
        if (r15 == null) goto L79;
        final f5b.b r16 = r15.clone();
        Map<String, Map<String, UrlCardPreviewEntity>> r1 = this.a;
        if (r1 == null) goto L59;
        Map<String, UrlCardPreviewEntity> r2 = r1.get(r16.getId());
        Message r3 = r16.getMessage();
        Message r4 = r16.getMessage();
        Message.Type r5 = r4.getType();
        if (r5 != null) goto L11;
        int r6 = -1;
    L13:
        if (r6 != 1) goto L15;
    L20:
        Map<String, PreviewHangPoint> r7 = ((BaseTextContent) r4.getContent()).getPreviewHangPoints();
    L21:
        if (r7 == null) goto L47;
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator<Map.Entry<String, PreviewHangPoint>> r9 = r7.entrySet().iterator();
    L24:
        if (r9.hasNext() == false) goto L28;
        Map.Entry<String, PreviewHangPoint> r10 = r9.next();
        String r11 = r10.getValue().getPreviewId();
        if (r11 == null) goto L24;
        r8.put(r11, r10.getValue());
        goto L24
    L28:
        boolean r12 = false;
        if (r2 == null) goto L46;
        Iterator<Map.Entry<String, UrlCardPreviewEntity>> r13 = r2.entrySet().iterator();
    L32:
        if (r13.hasNext() == false) goto L46;
        Map.Entry<String, UrlCardPreviewEntity> r17 = r13.next();
        String r18 = r17.getKey();
        UrlCardPreviewEntity r19 = r17.getValue();
        LinkedHashMap r20 = new LinkedHashMap();
        Iterator r110 = r8.entrySet().iterator();
    L35:
        if (r110.hasNext() == false) goto L39;
        Map.Entry r111 = (Map.Entry) r110.next();
        if (Intrinsics.areEqual(((PreviewHangPoint) r111.getValue()).getPreviewId(), r18) == false) goto L35;
        r20.put(r111.getKey(), r111.getValue());
        goto L35
    L39:
        PreviewHangPoint r21 = (PreviewHangPoint) r20.get(r18);
        if (r21 == null) goto L32;
        if (r21.getUrlCardPreviewEntity() == null) goto L45;
        if (r19.isContentSame(r21.getUrlCardPreviewEntity()) == true) goto L32;
    L45:
        r12 = true;
    L46:
        r16.setForceUpdate(r12);
    L47:
        a.a(r3, r2);
        LinkedHashMap<String, MessageLink> r22 = r3.getMessageLinkMap();
        Map<String, Map<String, MessageLink>> r23 = this.b;
        if (r23 == null) goto L50;
        r0 = r23.get(r3.getId());
    L50:
        if (r0 == null) goto L56;
        Iterator<Map.Entry<String, MessageLink>> r24 = r0.entrySet().iterator();
    L53:
        if (r24.hasNext() == false) goto L56;
        Map.Entry<String, MessageLink> r25 = r24.next();
        Intrinsics.checkNotNull(r22);
        r22.put(r25.getKey(), r25.getValue());
    L56:
        if (Message.Type.MERGE_FORWARD != r16.getMessage().getType()) goto L59;
        r16.setForceUpdate(m.a(r16, new PreviewUpdater$invoke$isForceUpdate$1(this, r16)));
        goto L59
    L15:
        if (r6 == 2) goto L20;
        if (r6 == 3) goto L19;
        r7 = null;
        goto L21
    L19:
        r7 = ((FileContent) r4.getContent()).getPreviewHangPoints();
        goto L21
    L11:
        r6 = b.a[r5.ordinal()];
    L59:
        return r16;
    L79:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(Map<String, ? extends Map<String, UrlCardPreviewEntity>> r1, Map<String, ? extends Map<String, MessageLink>> r2) {
        this.a = r1;
        this.b = r2;
    }
}
