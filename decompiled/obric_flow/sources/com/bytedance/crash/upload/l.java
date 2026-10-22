package com.bytedance.crash.upload;

import com.bytedance.vmsdk.worker.JsWorker;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements z8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f4139c;

    public /* synthetic */ l(Object r5, long r10, int r11) {
        this.f4137a = r11;
        this.f4139c = r5;
        this.f4138b = r10;
    }

    public void a(Error r5) {
        JsWorker r10 = (JsWorker) this.f4139c;
        if (r10.isRunning() == false) goto L6;
        JsWorker.access$300(JsWorker.access$000(r10).get(), r5.getMessage(), this.f4138b);
        return;
    }

    public void b(int r5) {
        if (r5 < 64) goto L7;
        l r10 = (l) this.f4139c;
        if (r10 == null) goto L9;
        r10.b(r5 - 64);
        return;
    L9:
        return;
    L7:
        this.f4138b &= ~(1 << r5);
    }

    public int c(int r5) {
        l r10 = (l) this.f4139c;
        if (r10 != null) goto L9;
        if (r5 >= 64) goto L6;
        long r11 = this.f4138b;
        return Long.bitCount(((1 << r5) - 1) & r11);
    L6:
        return Long.bitCount(this.f4138b);
    L9:
        if (r5 >= 64) goto L12;
        long r12 = this.f4138b;
        return Long.bitCount(((1 << r5) - 1) & r12);
    L12:
        int r13 = r10.c(r5 - 64);
        return Long.bitCount(this.f4138b) + r13;
    }

    public void d() {
        if (((l) this.f4139c) != null) goto L6;
        this.f4139c = new l(1);
        return;
    }

    public boolean e(int r5) {
        if (r5 < 64) goto L6;
        d();
        return ((l) this.f4139c).e(r5 - 64);
    L6:
        long r10 = this.f4138b;
        if (((1 << r5) & r10) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public void f(int r10, boolean r11) {
        if (r10 < 64) goto L5;
        d();
        ((l) this.f4139c).f(r10 - 64, r11);
        return;
    L5:
        long r5 = this.f4138b;
        if ((Long.MIN_VALUE & r5) == 0) goto L8;
        boolean r12 = true;
    L9:
        long r13 = (1 << r10) - 1;
        this.f4138b = ((r5 & (~r13)) << 1) | (r5 & r13);
        if (r11 == false) goto L12;
        i(r10);
    L13:
        if (r12 == false) goto L15;
    L16:
        d();
        ((l) this.f4139c).f(0, r12);
        return;
    L15:
        if (((l) this.f4139c) != null) goto L16;
        return;
    L12:
        b(r10);
        goto L13
    L8:
        r12 = false;
        goto L9
    }

    public boolean g(int r11) {
        if (r11 < 64) goto L6;
        d();
        return ((l) this.f4139c).g(r11 - 64);
    L6:
        long r5 = 1 << r11;
        long r10 = this.f4138b;
        if ((r10 & r5) == 0) goto L9;
        boolean r12 = true;
    L10:
        long r13 = r10 & (~r5);
        this.f4138b = r13;
        long r14 = r5 - 1;
        this.f4138b = (r13 & r14) | Long.rotateRight((~r14) & r13, 1);
        l r15 = (l) this.f4139c;
        if (r15 != null) goto L13;
    L16:
        return r12;
    L13:
        if (r15.e(0) == false) goto L15;
        i(63);
    L15:
        ((l) this.f4139c).g(0);
        goto L16
    L9:
        r12 = false;
        goto L10
    }

    public void h() {
        this.f4138b = 0;
        l r5 = (l) this.f4139c;
        if (r5 == null) goto L6;
        r5.h();
        return;
    }

    public void i(int r5) {
        if (r5 < 64) goto L5;
        d();
        ((l) this.f4139c).i(r5 - 64);
        return;
    L5:
        this.f4138b |= 1 << r5;
    }

    public String toString() {
        switch(this.f4137a) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.toString();
    L7:
        if (((l) this.f4139c) != null) goto L10;
        return Long.toBinaryString(this.f4138b);
    L10:
        return ((l) this.f4139c).toString() + "xx" + Long.toBinaryString(this.f4138b);
    }

    public l(int r5) {
        this.f4137a = r5;
        switch(r5) {
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        this.f4138b = 0;
        return;
    L6:
        this.f4139c = new ArrayList();
        new ArrayList();
        this.f4138b = 39;
    }

    @Override // z8.a
    public void a(JSONObject r10) {
        b.a("ensure_zip", com.bytedance.crash.n.f4062j.getExceptionZipUploadUrl(), r10.toString(), null, new c5.a[]{new c5.a((File) this.f4139c, true), new c5.a(b.e(), false), com.bytedance.android.anniex.base.service.e.m(this.f4138b)});
    }
}
