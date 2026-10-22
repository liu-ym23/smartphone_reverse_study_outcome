package com.larus.bmhome.auth;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/auth/ILaunchMetricService;", "", "report", "", "type", "", "stage", "success", "", "error", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface ILaunchMetricService {

    public static final class a {
        public static /* synthetic */ void a(LaunchMetricDelegate r1, String r2, boolean r3, int r4) {
            if ((r4 & 4) == 0) goto L6;
            r3 = false;
        L6:
            if ((r4 & 8) == 0) goto L8;
            String r5 = "";
        L9:
            r1.a(r2, r3, r5);
            return;
        L8:
            r5 = null;
            goto L9
        }
    }

    void a(String r1, boolean r2, String r3);
}
