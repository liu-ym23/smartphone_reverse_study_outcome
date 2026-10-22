package com.larus.bmhome.chat.instruction.helper;

import af8.a;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.instruction.helper.IConvReplyModeRecordHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R'\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/instruction/helper/ConvReplyModeRecordHelper;", "Lcom/larus/bmhome/instruction/helper/IConvReplyModeRecordHelper;", "<init>", "()V", "latestReplyModeMap", "Lcom/flow/kmp/common/collections/ConcurrentHashMap;", "", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "getLatestReplyModeMap", "()Lcom/flow/kmp/common/collections/ConcurrentHashMap;", "latestReplyModeMap$delegate", "Lkotlin/Lazy;", "updateLatestReplyOption", "", "conversationId", "replyOption", "getLatestReplyOption", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ConvReplyModeRecordHelper implements IConvReplyModeRecordHelper {
    public final Lazy b;

    public ConvReplyModeRecordHelper() {
        this.b = LazyKt.lazy(new a());
    }

    public final ReplyOption b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        if (FeatureKitDelegate.b.C0().b() == true) goto L7;
        return null;
    L7:
        return (ReplyOption) ((vt7.a) this.b.getValue()).get(r2);
    }

    public final void a(String r2, ReplyOption r3) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        ((vt7.a) this.b.getValue()).put(r2, r3);
        return;
    L4:
        if (StringsKt.isBlank(r2) == true) goto L7;
        r0 = false;
        goto L8
    }
}
