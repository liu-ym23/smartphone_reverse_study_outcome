package com.larus.bmhome.chat.bubble.floating.report;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/report/BannerShowReportServiceImpl;", "Lcom/larus/bmhome/chat/bubble/floating/report/IBannerShowReportService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "reportShow", "", "input", "Lcom/larus/bmhome/chat/bubble/floating/report/BannerShowReportInput;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BannerShowReportServiceImpl implements IBannerShowReportService {
    public final CoroutineScope a;

    public static final class a {
    }

    static {
    }

    public BannerShowReportServiceImpl() {
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    @Override // com.larus.bmhome.chat.bubble.floating.report.IBannerShowReportService
    public final void a(com.larus.bmhome.chat.bubble.floating.report.a r10) {
        Intrinsics.checkNotNullParameter(r10, "input");
        String r0 = r10.a;
        if (r0 != null) goto L5;
    L7:
        r0 = null;
    L8:
        String r2 = r10.c;
        if (r2 != null) goto L11;
    L13:
        r2 = null;
    L14:
        if (r0 != null) goto L17;
        if (r2 != null) goto L17;
        return;
    L17:
        BuildersKt.launch$default(this.a, null, null, new BannerShowReportServiceImpl$reportShow$1(r0, r10, r2, null), 3, null);
        return;
    L11:
        if ((!StringsKt.isBlank(r2)) == false) goto L13;
    L5:
        if ((!StringsKt.isBlank(r0)) == false) goto L7;
        goto L7
    }
}
