package com.larus.bmhome.chat.doclink;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&JL\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\u001e\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\n\u0012\u0004\u0012\u00020\u00050\fH&J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH&J8\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00050\fH&¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/doclink/IMessageDocPreviewService;", "", "isSupported", "", "getPreviewEntities", "", "previewIds", "", "", "fallbackUrlsByPreviewId", "", "callback", "Lkotlin/Function1;", "Lcom/larus/bmhome/chat/doclink/MessageDocPreviewEntity;", "getPreviewIconDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "preview", "loadPreviewIconDrawable", "defaultDrawable", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IMessageDocPreviewService {
    void a(Context r1, h r2, Drawable r3, i r4);

    Drawable b(Context r1, h r2);

    void c(List r1, Map r2, MessageDocPreviewRepository.b r3);

    boolean isSupported();
}
