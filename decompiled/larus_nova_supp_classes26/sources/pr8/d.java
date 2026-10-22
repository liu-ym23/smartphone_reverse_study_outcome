package pr8;

import com.larus.bmhome.video.AuthorInfo;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.ContentCover;
import com.larus.bmhome.video.ContentDescription;
import com.larus.bmhome.video.InteractInfo;
import com.larus.bmhome.video.InteractionStatistic;
import com.larus.bmhome.video.InteractionStatus;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static final c a(Content r19) {
        Intrinsics.checkNotNullParameter(r19, "<this>");
        ContentCover r0 = r19.getCover();
        Boolean r2 = null;
        if (r0 == null) goto L10;
        IconImage r3 = r0.getSelectedCover();
        if (r3 == null) goto L10;
        ImageObj r4 = r3.imageOri;
        if (r4 == null) goto L10;
        String r5 = r4.url;
        if (r5 == null) goto L10;
    L25:
        String r6 = r5;
    L26:
        if (r0 == null) goto L33;
        IconImage r7 = r0.getSelectedCover();
        if (r7 == null) goto L33;
        ImageObj r8 = r7.imageOri;
        if (r8 == null) goto L33;
        Integer r9 = Integer.valueOf(r8.width);
    L32:
        Integer r10 = r9;
    L46:
        if (r0 == null) goto L53;
        IconImage r11 = r0.getSelectedCover();
        if (r11 == null) goto L53;
        ImageObj r12 = r11.imageOri;
        if (r12 == null) goto L53;
        Integer r1 = Integer.valueOf(r12.height);
    L52:
        Integer r13 = r1;
    L66:
        ContentDescription r14 = r19.getContentDescription();
        if (r14 == null) goto L72;
        String r15 = r14.getDescription();
        if (r15 == null) goto L72;
    L71:
        String r16 = r15;
    L78:
        AuthorInfo r17 = r19.getAuthorInfo();
        if (r17 == null) goto L85;
        IconImage r18 = r17.getAvatar();
        if (r18 == null) goto L85;
        ImageObj r20 = r18.imageThumb;
        if (r20 == null) goto L85;
        String r110 = r20.url;
    L86:
        AuthorInfo r21 = r19.getAuthorInfo();
        if (r21 == null) goto L89;
        String r111 = r21.getNickName();
    L90:
        InteractInfo r22 = r19.getInteractInfo();
        if (r22 == null) goto L95;
        InteractionStatus r23 = r22.getStatus();
        if (r23 == null) goto L95;
        r2 = Boolean.valueOf(r23.isLiked());
    L95:
        Boolean r112 = r2;
        InteractInfo r24 = r19.getInteractInfo();
        if (r24 == null) goto L103;
        InteractionStatistic r25 = r24.getStatistic();
        if (r25 == null) goto L103;
        String r26 = r25.getFormattedLikedCount();
        if (r26 == null) goto L103;
    L102:
        String r113 = r26;
    L110:
        return new c(r19.getItemId(), r6, r10, r13, r19.getItemType(), r16, r110, r111, r112, r113, r19.getRequestId(), null, r19.getBizTag(), null);
    L103:
        InteractInfo r27 = r19.getInteractInfo();
        if (r27 == null) goto L108;
        InteractionStatistic r28 = r27.getStatistic();
        if (r28 == null) goto L108;
        r26 = Long.valueOf(r28.getLikedCount()).toString();
    L108:
        r113 = "";
        goto L110
    L89:
        r111 = null;
    L85:
        r110 = null;
    L72:
        ContentDescription r29 = r19.getContentDescription();
        if (r29 == null) goto L75;
        r15 = r29.getTitle();
    L76:
        if (r15 != null) goto L71;
        r16 = "";
        goto L78
    L75:
        r15 = null;
    L53:
        if (r0 == null) goto L59;
        IconImage r30 = r0.getOriginCover();
        if (r30 == null) goto L59;
        ImageObj r31 = r30.imageOri;
        if (r31 == null) goto L59;
        r1 = Integer.valueOf(r31.height);
    L59:
        if (r0 == null) goto L65;
        IconImage r32 = r0.getDynamicCover();
        if (r32 == null) goto L65;
        ImageObj r33 = r32.imageOri;
        if (r33 == null) goto L65;
        r1 = Integer.valueOf(r33.height);
    L65:
        r13 = null;
    L33:
        if (r0 == null) goto L39;
        IconImage r34 = r0.getOriginCover();
        if (r34 == null) goto L39;
        ImageObj r35 = r34.imageOri;
        if (r35 == null) goto L39;
        r9 = Integer.valueOf(r35.width);
    L39:
        if (r0 == null) goto L45;
        IconImage r36 = r0.getDynamicCover();
        if (r36 == null) goto L45;
        ImageObj r37 = r36.imageOri;
        if (r37 == null) goto L45;
        r9 = Integer.valueOf(r37.width);
    L45:
        r10 = null;
    L10:
        if (r0 == null) goto L16;
        IconImage r38 = r0.getOriginCover();
        if (r38 == null) goto L16;
        ImageObj r39 = r38.imageOri;
        if (r39 == null) goto L16;
        r5 = r39.url;
    L17:
        if (r5 != null) goto L25;
        if (r0 == null) goto L24;
        IconImage r40 = r0.getDynamicCover();
        if (r40 == null) goto L24;
        ImageObj r41 = r40.imageOri;
        if (r41 == null) goto L24;
        r5 = r41.url;
    L24:
        r6 = null;
    L16:
        r5 = null;
        goto L17
    }
}
