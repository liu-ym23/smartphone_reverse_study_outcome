package d5;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f6784e;

    public b(Context r8) {
        super(true, false);
        this.f6784e = r8;
    }

    @Override // d5.d
    public final boolean a(JSONObject r8) {
        Context r10 = this.f6784e;
        String r11 = r10.getPackageName();
        Bundle r12 = r10.getPackageManager().getApplicationInfo(r11, 128).metaData;     // Catch: Exception -> L7
        if (r12 == null) goto L12;
        r8.put("appkey", r12.getString("UMENG_APPKEY"));     // Catch: Exception -> L7
        return true;
    L12:
        return true;
    L7:
        int r13 = x4.r.f13543a;
        return true;
    }
}
