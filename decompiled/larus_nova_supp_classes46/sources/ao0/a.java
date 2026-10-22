package ao0;

import com.bytedance.android.livesdkapi.ILiveResponseExtraInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements ILiveResponseExtraInfo.IStatusInfo {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public final int getCode() {
        return this.a;
    }

    public final String getMessage() {
        return this.b;
    }

    public final String getPrompts() {
        return this.c;
    }

    public final String getVerifyConfig() {
        return this.d;
    }

    public a(int r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = null;
    }
}
