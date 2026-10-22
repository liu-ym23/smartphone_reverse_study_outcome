package i18;

import android.content.Intent;
import com.larksuite.framework.apiplugin.LKApiCode;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.framework.apiplugin.entity.LKPluginHandleResult;
import com.ss.android.lark.log.Log;
import j18.e;
import j18.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class d implements g, Comparable<d> {
    private static final String TAG = "LKPlugin";

    public d() {
    }

    public abstract void addEvents(e r1);

    public abstract void onRelease();

    public int priority() {
        return 0;
    }

    public boolean shouldHandleActivityResult() {
        return false;
    }

    public void callBackOk(LKEvent r3) {
        r3.getClass();
        JSONObject r0 = new JSONObject();
        if (r3.g == null) goto L6;
        r3.a(r0);
        r3.g.onSuccess(r0);
        return;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(d r2) {
        return priority() - r2.priority();
    }

    @Override // j18.g
    public LKPluginHandleResult handleEvent(LKEvent r2) {
        r2.getClass();
        LKPluginHandleResult.a r3 = new LKPluginHandleResult.a();
        r3.c = LKBaseResponseModel.DEFAULT_ERROR_CODE;
        r3.e = true;
        return new LKPluginHandleResult(r3);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(d r1) {
        return compareTo2(r1);
    }

    public void callBackFail(String r2, LKEvent r3) {
        callBackFail(LKApiCode.GENERAL_UNKONW_ERROR.code, r2, r3);
    }

    public void callBackFail(int r3, String r4, LKEvent r5) {
        r5.b(new LKBaseResponseModel(new k18.b(r3, r4)));
    }

    public boolean handleActivityResult(int r2, int r3, Intent r4) {
        Log.i(TAG, "requestCode:" + r2 + " resultCode:" + r3);
        return false;
    }
}
