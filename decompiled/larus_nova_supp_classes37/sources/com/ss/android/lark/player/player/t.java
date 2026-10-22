package com.ss.android.lark.player.player;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.lark.profile.v2.entity.BaseField;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class t {
    public final int a;
    public boolean b;
    public boolean c;
    public boolean d;
    public b e;
    public final a f;

    public class a extends Handler {
        public final /* synthetic */ t a;

        @Override // android.os.Handler
        public final void handleMessage(Message r7) {
            super.handleMessage(r7);
            if (r7.what != 1) goto L28;
            t r8 = this.a;
            if (r8.d == true) goto L8;
            return;
        L8:
            if (r8.b == true) goto L10;
            return;
        L10:
            if (r8.c == false) goto L29;
            b r9 = r8.e;
            if (r9 == null) goto L24;
            v.a r10 = (v.a) r9;
            int r1 = r10.a.a();
            int r2 = r10.a.b();
            v r3 = r10.a;
            if (r3.f() == false) goto L17;
            int r4 = r3.a.e;
        L18:
            if (r2 <= 0) goto L24;
            if (r1 < 0) goto L24;
            Bundle r5 = w0c.a.a();
            r5.putInt("int_arg1", r1);
            r5.putInt("int_arg2", r2);
            r5.putInt("int_arg3", r4);
            n r11 = r10.a.d;
            if (r11 == null) goto L24;
            r11.a(-99019, r5);
            goto L24
        L17:
            r4 = 0;
        L24:
            t r12 = this.a;
            r12.f.removeMessages(1);
            r12.f.sendEmptyMessageDelayed(1, r12.a);
            return;
        L29:
            return;
        }

        public a(t r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public interface b {
    }

    public t() {
        this.d = false;
        this.f = new a(this, Looper.getMainLooper());
        this.a = BaseField.FIELD_TYPE_NAME_CARD_PHONE;
    }
}
