package f3b;

import android.text.TextUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.MessageUrlPreview;
import com.ss.android.lark.chat.entity.message.PreviewVideo;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.doc.entity.Doc;
import com.ss.android.lark.doc.entity.DocResult;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.statistics.video_site.VideoSiteHitPoint;
import com.ss.android.lark.widget.span.AtUserGroupInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(y6b.a r1) {
        Intrinsics.checkNotNullParameter(r1, "messageVO");
        MessageUrlPreview r2 = ((BaseTextContentVO) r1.b()).h;
        if (r2 == null) goto L8;
        PreviewVideo r3 = r2.getPreviewVideo();
        if (r3 == null) goto L9;
        VideoSiteHitPoint.b(r3.getSite());
        return;
    L9:
        return;
    }

    public static void a(m2b.a r4, y6b.a r5) {
        Intrinsics.checkNotNullParameter(r4, "chatContext");
        Intrinsics.checkNotNullParameter(r5, "messageVO");
        if (r4.m() == false) goto L5;
        return;
    L5:
        if (r4.Y() == true) goto L10;
        Lazy r0 = ChatHitPointNew.a;
        ChatHitPointNew.f(r4.getChat(), "@someone", ChatHitPointNew.c("@someone"), ChatHitPointNew.b(r4, r5, null, null, null));
        return;
    }

    public static void b(m2b.a r4, y6b.a r5, AtUserGroupInfo r6) {
        Intrinsics.checkNotNullParameter(r4, "chatContext");
        Intrinsics.checkNotNullParameter(r5, "messageVO");
        Intrinsics.checkNotNullParameter(r6, "info");
        if (r4.m() == false) goto L5;
        return;
    L5:
        if (r4.Y() == true) goto L10;
        Lazy r0 = ChatHitPointNew.a;
        Chat r1 = r4.getChat();
        String r2 = ChatHitPointNew.c("@someone");
        Map r7 = MapsKt.toMutableMap(ChatHitPointNew.b(r4, r5, null, null, null));
        r7.put("at_user_group", "true");
        r7.put("user_group_id", String.valueOf(r6.getUserGroupId()));
        Unit r8 = Unit.INSTANCE;
        ChatHitPointNew.f(r1, "@someone", r2, r7);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(m2b.a r6, y6b.a r7, String r8, ChatHitPointExtraParams.Occasion r9) {
        Intrinsics.checkNotNullParameter(r6, "chatContext");
        Intrinsics.checkNotNullParameter(r7, "messageVO");
        Intrinsics.checkNotNullParameter(r8, "text");
        BaseTextContentVO r0 = (BaseTextContentVO) r7.b();
        DocResult r1 = r0.i;
        Map<String, PreviewHangPoint> r2 = ((BaseTextContent) r0.a).getPreviewHangPoints();
        String r3 = "docs";
        String r4 = null;
        if (r1 == null) goto L6;
        String r5 = r1.getDoc().getId();
        DocType r10 = r1.getDoc().getDocType();
    L46:
        ChatHitPointNew.j(r7);
        com.ss.android.lark.chat.utils.d.a(r8, r9, r2);
        if (r6.m() == false) goto L49;
        return;
    L49:
        if (r6.Y() == true) goto L62;
        if (r10 == null) goto L53;
        r4 = ChatHitPointNew.k(r10);
    L53:
        ChatHitPointNew.f(r6.getChat(), r3, ChatHitPointNew.c(r3), ChatHitPointNew.b(r6, r7, r5, r4, r8));
        return;
    L62:
        return;
    L6:
        if (CollectionUtils.isNotEmpty(((BaseTextContent) r0.a).getDocEntityMap()) == false) goto L21;
        Map<String, Doc> r11 = ((BaseTextContent) r0.a).getDocEntityMap();
        if (r11 == null) goto L13;
        Collection<Doc> r12 = r11.values();
        if (r12 == null) goto L13;
        List r13 = CollectionsKt.toList(r12);
        if (r13 == null) goto L13;
    L14:
        Iterator r14 = r13.iterator();
    L16:
        if (r14.hasNext() == false) goto L45;
        Doc r15 = (Doc) r14.next();
        if (TextUtils.equals(r8, r15.getUrl()) == false) goto L16;
        r5 = r15.getId();
        r10 = r15.getDocType();
    L45:
        r3 = "url";
        r5 = null;
        r10 = null;
    L13:
        r13 = CollectionsKt.emptyList();
        goto L14
    L21:
        if ((!r2.isEmpty()) == false) goto L45;
        Iterator r16 = new ArrayList(r2.values()).iterator();
    L24:
        if (r16.hasNext() == false) goto L45;
        PreviewHangPoint r17 = (PreviewHangPoint) r16.next();
        if (TextUtils.equals(r17.getUrl(), r8) == false) goto L24;
        UrlCardPreviewEntity r18 = r17.getUrlCardPreviewEntity();
        if (r18 == null) goto L32;
        UrlInlinePreviewEntity r19 = r18.getInlineEntity();
        if (r19 == null) goto L32;
        UrlInlinePreviewEntity.AppInfo r20 = r19.getAppInfo();
    L33:
        String r21 = r17.getUrl();
        String r22 = r17.getPreviewId();
        if (r20 == null) goto L38;
        Long r23 = r20.getAppId();
        if (r23 == null) goto L38;
        String r24 = r23.toString();
    L39:
        if (r20 == null) goto L43;
        Long r25 = r20.getSceneType();
        if (r25 == null) goto L43;
        String r26 = r25.toString();
    L44:
        ChatHitPointNew.i(r21, r22, r24, r26, r7);
    L43:
        r26 = null;
    L38:
        r24 = null;
    L32:
        r20 = null;
        goto L33
    }
}
