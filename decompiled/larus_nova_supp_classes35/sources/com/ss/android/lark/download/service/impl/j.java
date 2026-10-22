package com.ss.android.lark.download.service.impl;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.text.TextUtils;
import com.bytedance.lark.pb.media.v1.DownloadFileOptions;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.n;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.compliance.CanUserDownloadRiskFileRequest;
import com.ss.android.lark.pb.compliance.CanUserDownloadRiskFileResponse;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements wbb.d {
    public final e a;

    public class a implements SdkSender.IParser<Boolean> {
        public a() {
        }

        public final Object parse(byte[] r2) throws IOException {
            return ((CanUserDownloadRiskFileResponse) CanUserDownloadRiskFileResponse.ADAPTER.decode(r2)).mcan_download;
        }
    }

    public j() {
        this.a = e.b.a;
    }

    public final void c(IGetDataCallback<Boolean> r4) {
        Log.i("DownloadFile", "canUserDownloadRiskFile calls.");
        CanUserDownloadRiskFileRequest.Builder r0 = new CanUserDownloadRiskFileRequest.Builder().op_usage(CanUserDownloadRiskFileRequest.FileOperateUsage.Download).source_terminal(CanUserDownloadRiskFileRequest.SourceTerminal.Mobile);
        SdkSender.sendPassThroughRequest(Command.CAN_USER_DOWNLOAD_FILE, r0, r4, new a());
    }

    public static void a(Context r3, String r4, Token r5) {
        Log.i("DownloadFile", "notifySystemScanFile, filePath = " + r4);
        if (r5 != null) goto L14;
        FileUtils.u(r3, r4);
    L9:
        String[] r6 = FileUtils.a;
        if (TextUtils.isEmpty(r4) == true) goto L16;
        MediaScannerConnection.scanFile(r3, new String[]{r4}, new String[]{FileUtils.p(r4)}, new n());
        return;
    L16:
        return;
    L14:
        FileUtils.v(r3, r4, r5);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Log.w("DownloadFile", "notifySystemScanFilePsda failed", e);
        goto L9
    }

    public static DownloadFileOptions b(String r3, String r4, String r5) {
        if (TextUtils.isEmpty(r3) == true) goto L5;
    L11:
        boolean r0 = false;
    L12:
        if (r0 == false) goto L14;
        return null;
    L14:
        DownloadFileOptions.Builder r1 = new DownloadFileOptions.Builder();
        if (TextUtils.isEmpty(r3) == true) goto L18;
        r1.preview_token(r3);
    L18:
        if (TextUtils.isEmpty(r4) == true) goto L21;
        r1.auth_file_key(r4);
    L21:
        if (TextUtils.isEmpty(null) == true) goto L24;
        r1.watermark_scene(null);
    L24:
        if (TextUtils.isEmpty(r5) == true) goto L27;
        r1.msg_link_token(r5);
    L27:
        return r1.build();
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L11;
        if (TextUtils.isEmpty(null) == false) goto L11;
        if (TextUtils.isEmpty(r5) == false) goto L11;
        r0 = true;
        goto L12
    }
}
