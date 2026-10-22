package com.obric.assistant.applet;

import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/obric/assistant/applet/IObricAppletService;", NameKeys.UnloadStrategy_No_Strategy, "checkPersonalPermission", NameKeys.UnloadStrategy_No_Strategy, "appletId", NameKeys.UnloadStrategy_No_Strategy, CloudControlInf.PERMISSION, "updatePersonalPermission", NameKeys.UnloadStrategy_No_Strategy, "granted", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricAppletService {
    boolean a(String r1, String r2);

    void b(String r1, String r2, boolean r3);
}
