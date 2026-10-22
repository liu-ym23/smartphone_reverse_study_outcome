package qa;

import android.content.Context;
import android.os.Handler;
import com.ttnet.org.chromium.net.NetError;

/* JADX INFO: loaded from: classes.dex */
public final class a3 extends y2 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f10205h;

    public /* synthetic */ a3(Context r8, String r10, Handler r11, int r12) {
        this.f10205h = r12;
        super(r8, r10, r11);
    }

    @Override // qa.y2
    public final void a(long r8, Object r10) {
        switch(this.f10205h) {
            case 0: goto L5;
            default: goto L9;
        };
    L5:
        b3 r11 = (b3) r10;
        if (r11 == null) goto L13;
        r11.f10248s = r8;
        return;
    L13:
        return;
    L9:
        n2 r12 = (n2) r10;
        if (r12 == null) goto L14;
        r12.f10856f = r8;
        return;
    }

    @Override // qa.y2
    public final String c(Object r8) {
        switch(this.f10205h) {
            case 0: goto L5;
            default: goto L10;
        };
    L5:
        b3 r10 = (b3) r8;
        if (r10 != null) goto L9;
        return "";
    L9:
        return r10.a();
    L10:
        n2 r11 = (n2) r8;
        if (r11 != null) goto L14;
        return "";
    L14:
        return r11.f10858h + "#" + r11.f10851a;
    }

    @Override // qa.y2
    public final int e(Object r8) {
        switch(this.f10205h) {
            case 0: goto L5;
            default: goto L10;
        };
    L5:
        b3 r10 = (b3) r8;
        if (r10 != null) goto L9;
        return 99;
    L9:
        return r10.f10247r;
    L10:
        n2 r11 = (n2) r8;
        if (r11 != null) goto L14;
        return NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH;
    L14:
        return r11.f10853c;
    }

    @Override // qa.y2
    public final long f() {
        switch(this.f10205h) {
            case 0: goto L5;
            default: goto L8;
        };
    L5:
        int r8 = 100;
    L7:
        return r8;
    L8:
        r8 = 1000;
        goto L7
    }

    @Override // qa.y2
    public final long g(Object r8) {
        switch(this.f10205h) {
            case 0: goto L5;
            default: goto L10;
        };
    L5:
        b3 r10 = (b3) r8;
        if (r10 != null) goto L9;
        return 0;
    L9:
        return r10.f10248s;
    L10:
        n2 r11 = (n2) r8;
        if (r11 != null) goto L14;
        return 0;
    L14:
        return r11.f10856f;
    }
}
