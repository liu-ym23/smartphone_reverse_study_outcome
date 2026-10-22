package com.ss.android.lark.flow.feed.cell.doc;

import com.bytedance.lark.pb.feed.v1.DocData;
import com.bytedance.lark.pb.feed.v1.FeedEntityPreview;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.FeedPreviewInfo;
import com.ss.android.lark.doc.entity.DocMessage;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.f;
import com.ss.android.lark.feed.shared.data.preview.DocFeedPreview;
import com.ss.android.lark.feed.shared.data.utils.j;
import kotlin.jvm.internal.Intrinsics;
import leb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements f {
    public final d a;

    public c() {
        this.a = new d();
    }

    public final FeedPreviewInfo a(FeedEntityPreview r5) {
        Intrinsics.checkNotNullParameter(r5, "pbFeed");
        FeedPreviewInfo r0 = beb.b.c(r5);
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r5, "pb");
        DocData r6 = r5.doc_data;
        if (r6 == null) goto L12;
        r0.d = FeedCard.Type.DOC;
        r0.g = r6.name;
        r0.i = r6.unread_count.intValue();
        r0.j = r6.is_remind.booleanValue();
        r0.o = r6.is_shortcut.booleanValue();
        r0.s = com.ss.android.lark.feed.shared.data.utils.b.a(r6.draft_preview);
        r0.k = r6.display_time.longValue();
        r0.l = r6.rank_time.longValue();
        r0.L0 = r6.cross_tenant.booleanValue();
        r0.P0 = j.a(r6.reactions);
        int r1 = r6.doc_type.getValue();
        DocType r2 = DocType.MIAODA;
        if (r1 == r2.getNumber()) goto L7;
        r2 = DocType.forNumber(r6.doc_type.getValue());
    L11:
        r0.B = r2;
        r0.C = r6.doc_url;
        r0.F = r6.icon_info;
        r0.D = DocMessage.Type.forNumber(r6.doc_message_type.getValue());
        r0.E = r6.last_doc_message_id;
        r0.p0 = r6.digest;
        r0.p = com.ss.android.lark.feed.shared.data.utils.b.c(r6.at_info);
        r0.X = r6.tag_info;
        goto L12
    L7:
        if (heb.a.a.getFeatureGatingDependency().isCurrentEnable("apaas.miaoda.migrate_to_ccm") == true) goto L11;
        r2 = DocType.UNKNOWN_DOC_TYPE;
    L12:
        return r0;
    }

    public final UIFeedCard b(FeedPreviewInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "feedPreviewInfo");
        Object r4 = this.a.e(r3);
        ((DocFeedPreview) r4).setReactionDisplayCount(6);
        return (UIFeedCard) r4;
    }

    public final boolean c(FeedEntityPreview r2) {
        Intrinsics.checkNotNullParameter(r2, "pbFeed");
        if (r2.doc_data == null) goto L5;
        return true;
    L5:
        return false;
    }
}
