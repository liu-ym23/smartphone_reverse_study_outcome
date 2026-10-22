package leb;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.ss.android.lark.biz.im.api.FeedPreviewInfo;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.feed.shared.data.preview.DocFeedPreview;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;
import com.ss.android.lark.parser.internal.a0;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends b<DocFeedPreview> {
    public d() {
    }

    @Override // leb.b
    public final DocFeedPreview e(FeedPreviewInfo r5) {
        DocFeedPreview r0 = new DocFeedPreview();
        f(r0, r5);
        r0.setDocType(r5.B);
        r0.setDocMessageType(r5.D);
        r0.setLastDocMessageId(r5.E);
        r0.setDocUrl(r5.C);
        r0.setIconInfo(r5.F);
        if (TextUtils.isEmpty(r0.getName()) == false) goto L5;
        r0.setName(UIHelper.getString(2131891661));
    L5:
        Context r6 = UIHelper.getContext();
        int r1 = LarkNameTag.d;
        Intrinsics.checkNotNullParameter(r6, "context");
        LarkNameTag.g r2 = new LarkNameTag.g(r6);
        TagData r7 = a0.a(r0.getTagData());
        if (r7 == null) goto L8;
        r2.g(TagData.parse(r7));
    L8:
        LarkNameTag r8 = r2.f();
        if (com.ss.android.lark.feed.shared.data.utils.e.b == null) goto L11;
    L20:
        com.ss.android.lark.feed.shared.data.utils.e.b.a(r0.getId(), r8, r8.b());
        r0.setFeedNameTag(r8);
        return r0;
    L11:
        monitor-enter(com.ss.android.lark.feed.shared.data.utils.e.class);
    L17:
        th = move-exception;
        throw th;
    L13:
        if (com.ss.android.lark.feed.shared.data.utils.e.b != null) goto L15;
        com.ss.android.lark.feed.shared.data.utils.e.b = new com.ss.android.lark.feed.shared.data.utils.e();     // Catch: Throwable -> L17
    L15:
        monitor-exit(com.ss.android.lark.feed.shared.data.utils.e.class);     // Catch: Throwable -> L17
        goto L20
    }

    @Override // leb.b
    public final void d(FeedPreview r1, FeedPreviewInfo r2) {
        a(r1, r2);
        b.b(r1);
    }
}
