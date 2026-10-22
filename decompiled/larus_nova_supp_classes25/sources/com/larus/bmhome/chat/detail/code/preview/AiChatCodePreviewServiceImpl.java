package com.larus.bmhome.chat.detail.code.preview;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.code.IAiChatCodePreviewService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/detail/code/preview/AiChatCodePreviewServiceImpl;", "Lcom/larus/bmhome/code/IAiChatCodePreviewService;", "<init>", "()V", "getCodeForPreviewByCodeId", "", "codeId", "getLanguageForPreviewByCodeId", "showCodePreviewWeb", "", "isSuccess", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AiChatCodePreviewServiceImpl implements IAiChatCodePreviewService {
    public AiChatCodePreviewServiceImpl() {
    }

    public final String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "codeId");
        Lazy r0 = i.a;
        if (r2 == null) goto L11;
        i.a r1 = (i.a) ((Map) i.b.getValue()).get(r2);
        if (r1 != null) goto L13;
        j r3 = (j) ((Map) i.a.getValue()).get(r2);
        if (r3 == null) goto L11;
        return r3.getCode();
    L13:
        return r1.a;
    L11:
        return null;
    }

    public final String c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "codeId");
        Lazy r0 = i.a;
        if (r2 == null) goto L11;
        i.a r1 = (i.a) ((Map) i.b.getValue()).get(r2);
        if (r1 != null) goto L13;
        j r3 = (j) ((Map) i.a.getValue()).get(r2);
        if (r3 == null) goto L11;
        return r3.getLanguage();
    L13:
        return r1.b;
    L11:
        return null;
    }

    public final boolean a(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "codeId");
        Lazy r1 = i.a;
        if (r5 == null) goto L26;
        j r2 = (j) ((Map) i.a.getValue()).get(r5);
        if (r2 == null) goto L11;
        if (r6 == false) goto L9;
        CodePreviewStatus r7 = CodePreviewStatus.SUCCESS;
    L10:
        r2.cw(r7);
    L23:
        return true;
    L9:
        r7 = CodePreviewStatus.FAIL;
        goto L10
    L11:
        m r3 = m.a;
        if (r6 == false) goto L14;
        CodePreviewStatus r8 = CodePreviewStatus.SUCCESS;
    L15:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "codeId");
        Intrinsics.checkNotNullParameter(r8, "status");
        m.a r0 = m.b;
        if (r0 != null) goto L19;
    L20:
        boolean r9 = false;
    L22:
        if (r9 == true) goto L23;
        return false;
    L19:
        if (Intrinsics.areEqual(r0.b, r5) == false) goto L20;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r0.f = r8;
        r9 = true;
        goto L22
    L14:
        r8 = CodePreviewStatus.FAIL;
        goto L15
    L26:
        return false;
    }
}
