package com.ss.android.lark.hobby;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.ug.brand.PullTenantBuildResourceResponse;
import com.ss.android.lark.util.share_preference.UserSP;
import com.ss.android.lark.utils.ApiUtils;
import java.io.File;
import qpc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class HobbyResManager$1 implements IGetDataCallback<PullTenantBuildResourceResponse> {
    final /* synthetic */ d this$0;
    final /* synthetic */ Context val$context;
    final /* synthetic */ String val$tid;

    public void onError(ErrorResult r4) {
        Log.e("HobbyResManager", "PullTenantBuildResource onError", r4, true);
    }

    public void onSuccess(PullTenantBuildResourceResponse r13) {
        if (r13 != null) goto L5;
        onError(new ErrorResult("response is null"));
        return;
    L5:
        String r0 = r13.mresource_url;
        final String r7 = r13.mtask_id;
        Log.i("HobbyResManager", "PullTenantBuildResource onSuccess, resourceUrl: " + r0 + ", taskId: " + r7);
        final d r2 = this.this$0;
        final Context r4 = this.val$context;
        final String r5 = this.val$tid;
        r2.getClass();
        if (TextUtils.isEmpty(r7) == false) goto L8;
    L14:
        Log.e("HobbyResManager", "taskId or resourceUrl is empty, taskId: " + r7 + ", resourceUrl: " + r0);
        return;
    L8:
        if (TextUtils.isEmpty(r0) == true) goto L14;
        String r14 = UserSP.getInstance().getString("hobby_res_task_id", "");
        Log.i("HobbyResManager", "lastTaskId: " + r14);
        if (r14.compareTo(r7) >= 0) goto L17;
        final String r15 = Integer.toString(r7.hashCode());
        String r1 = d.d(r5);
        StringBuilder r3 = new StringBuilder();
        StringBuilder r6 = new StringBuilder();
        StringBuilder r9 = new StringBuilder();
        r9.append(d.c(r4));
        String r10 = File.separator;
        r9.append(r10);
        r9.append(r1);
        r6.append(r9.toString());
        r6.append("_zip");
        r3.append(r6.toString());
        r3.append(r10);
        r3.append("res.zip");
        final String r11 = r3.toString();
        ((e) ApiUtils.getApi(e.class)).addPushPushResourceListener(new b(r2, r15, r4, r5, r11, r7));
        ((e) ApiUtils.getApi(e.class)).downloadResource(r15, r11, r0);
        Log.i("HobbyResManager", "download ka dynamic resource start");
        return;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((PullTenantBuildResourceResponse) r1);
    }

    public HobbyResManager$1(d r1, Context r2, String r3) {
        this.this$0 = r1;
        this.val$context = r2;
        this.val$tid = r3;
    }
}
