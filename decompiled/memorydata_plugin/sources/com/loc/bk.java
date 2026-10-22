package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class bk extends bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f5357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected long f5358b;
    private String d;
    private Context e;

    public bk(Context r3, int r4, String r5, bl r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r6);
        this.f5357a = r4;
        this.d = r5;
        this.e = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
    }

    @Override // com.loc.bl
    public final void a(boolean r3) {
        super.a(r3);
        if (r3 == false) goto L6;
        String r4 = this.d;
        long r0 = System.currentTimeMillis();
        this.f5358b = r0;
        o.a(this.e, r4, String.valueOf(r0));
        return;
    }

    @Override // com.loc.bl
    public final boolean a() {
        long r2 = 0;
        if (this.f5358b != 0) goto L10;
        String r0 = o.a(this.e, this.d);
        if (TextUtils.isEmpty(r0) == true) goto L8;
        r2 = Long.parseLong(r0);
    L8:
        this.f5358b = r2;
    L10:
        if ((System.currentTimeMillis() - this.f5358b) >= this.f5357a) goto L13;
        return false;
    L13:
        return true;
    }
}
