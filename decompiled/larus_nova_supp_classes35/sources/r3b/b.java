package r3b;

import a2b.f;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chatbase.j;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import j6b.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements j<MessageInfo> {
    public final f a;

    public static final class a {
        @JvmStatic
        public static void a(List r9, f r10) {
            Intrinsics.checkNotNullParameter(r9, "<this>");
            Intrinsics.checkNotNullParameter(r10, "previewService");
            ArrayList r0 = new ArrayList();
            HashMap r1 = new HashMap();
            Iterator r11 = r9.iterator();
        L4:
            if (r11.hasNext() == false) goto L21;
            f5b.b r2 = (f5b.b) r11.next();
            HashMap r3 = new HashMap();
            Content r4 = r2.getMessage().getContent();
            Map<String, PreviewHangPoint> r5 = new HashMap();
            if ((r4 instanceof TextContent) == false) goto L9;
            r5 = ((TextContent) r4).getPreviewHangPoints();
        L11:
            Iterator<Map.Entry<String, PreviewHangPoint>> r6 = r5.entrySet().iterator();
        L13:
            if (r6.hasNext() == false) goto L18;
            UrlCardPreviewEntity r7 = r6.next().getValue().getUrlCardPreviewEntity();
            if (r7 == null) goto L13;
            k r8 = k.b;
            String r12 = r7.getInlineEntity().getPreviewId();
            r8.getClass();
            Intrinsics.checkNotNullParameter(r7, "urlPreviewEntity");
            Intrinsics.checkNotNullParameter(r0, "templateList");
            Intrinsics.checkNotNullParameter(r3, "previewEntityNoTemplate");
            Intrinsics.checkNotNullParameter(r12, "previewId");
            r8.a.getClass();
            k6b.b.a(r7, r0, r3, r12);
            goto L13
        L18:
            if ((!r3.isEmpty()) == false) goto L4;
            r1.put(r2.getMessage().getId(), r3);
            goto L4
        L9:
            if ((r4 instanceof PostContent) == false) goto L11;
            r5 = ((PostContent) r4).getPreviewHangPoints();
            goto L11
        L21:
            if ((!r0.isEmpty()) == false) goto L34;
            r10.lc(r0, r1);
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chatbase.j
    public final void a(f5b.b r2) {
        Intrinsics.checkNotNullParameter(r2, "updateItem");
    }

    public b(f r2) {
        Intrinsics.checkNotNullParameter(r2, "previewService");
        this.a = r2;
    }

    @Override // com.ss.android.lark.chatbase.j
    public final void c(List<MessageInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "updateItems");
        a.a(r2, this.a);
    }

    @Override // com.ss.android.lark.chatbase.j
    public final void b(List<MessageInfo> r2, x4b.a<MessageInfo> r3) {
        Intrinsics.checkNotNullParameter(r2, "appendItems");
        if (r3 == null) goto L6;
        a.a(r2, this.a);
        return;
    }
}
