package com.ss.android.lark.filedetail.impl.open;

import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.officesdk.integrator.mock.FileDetailModuleDependencyMock;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FileOpenMenu$2 implements com.ss.android.lark.widget.menu.b.b {
    public final /* synthetic */ j a;

    public final void a() {
        if (this.a.d.mFileContent.getSaveToDrive() != 0) goto L6;
        LKUIToast.show(this.a.e, 2131889635);
        return;
    L6:
        int r0 = pfb.a.a;
        String r1 = this.a.d.mFileContent.getMime();
        Intrinsics.checkNotNullParameter(r1, "fileType");
        Statistics.sendEvent("click_save_clouddisk", new JSONObject().put("file_type", r1));
        final UIGetDataCallback r2 = new UIGetDataCallback(new AnonymousClass1(this));
        final j r3 = this.a;
        String r4 = r3.d.mFileContent.getKey();
        OpenFileInfo r5 = this.a.d;
        final String r6 = r5.mMessageId;
        String r7 = r5.mChatId;
        String r8 = r5.mSourceId;
        Message.SourceType r9 = r5.mSourceType;
        com.ss.android.lark.storage.a r10 = FileDetailModule.a;
        ytb.j r11 = FileDetailModule.a.a().getDriveDependency();
        UIGetDataCallback r12 = new UIGetDataCallback(new FileOpenMenu$7(r3, r6, r2));
        OpenFileInfo r13 = r3.d;
        r11.getClass();
        FileDetailModuleDependencyMock.a(r4, r6, r7, r8, r9, r13, r12);
        this.a.g = true;
        UICallbackExecutor.executeDelayed(new f(this), 1000);
    }

    public FileOpenMenu$2(j r1) {
        this.a = r1;
    }
}
