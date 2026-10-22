package com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a a;
    public b b;
    public final a c;

    public static final class a implements zj8.f {
        public final /* synthetic */ h a;

        @Override // zj8.f
        public final void a() {
            h r0 = this.a;
            com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r1 = r0.a;
            if (r1 != null) goto L5;
            return;
        L5:
            b r2 = r0.b;
            if (r2 == null) goto L9;
            r2.a(r1);
            return;
        }

        public a(h r1) {
            this.a = r1;
        }

        @Override // zj8.f
        public final void b(Context r3) {
            h r0 = this.a;
            com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r1 = r0.a;
            if (r1 != null) goto L5;
            return;
        L5:
            b r2 = r0.b;
            if (r2 == null) goto L9;
            r2.b(r1, r3);
            return;
        }
    }

    public h() {
        this.c = new a(this);
    }
}
