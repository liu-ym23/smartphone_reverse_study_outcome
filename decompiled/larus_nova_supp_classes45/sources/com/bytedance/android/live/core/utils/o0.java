package com.bytedance.android.live.core.utils;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o0 implements WeakHandler.IHandler {
    public int a;
    public boolean b;
    public final WeakHandler c;
    public b d;

    public class a implements IHostFrescoHelper.DownloadImageCallBack {
        public final /* synthetic */ List a;
        public final /* synthetic */ py.k b;
        public final /* synthetic */ o0 c;

        public final void onFailureImpl() {
            o0 r0 = this.c;
            if (r0.b == false) goto L5;
            return;
        L5:
            r0.b = true;
            ALogger.e("ImageDownloader", "download image failed, model=" + this.b);
            this.c.c.removeMessages(1);
            this.c.c.sendEmptyMessage(3);
        }

        public final void onNewResultImpl() {
            o0 r0 = this.c;
            if (r0.b == false) goto L5;
            return;
        L5:
            int r1 = r0.a + 1;
            r0.a = r1;
            if (r1 != this.a.size()) goto L9;
            this.c.c.removeMessages(1);
            this.c.c.sendEmptyMessage(2);
            return;
        }

        public a(o0 r1, List r2, py.k r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    public o0() {
        this.b = false;
        this.c = new WeakHandler(Looper.getMainLooper(), this);
    }

    public final void handleMsg(Message r3) {
        if (r3 == null) goto L25;
        int r4 = r3.what;
        if (r4 != 1) goto L6;
        b r5 = this.d;
        if (r5 != null) goto L21;
    L23:
        this.b = true;
        return;
    L21:
        if (this.b == true) goto L23;
        r5.b();
        goto L23
    L6:
        if (r4 != 2) goto L8;
        b r6 = this.d;
        if (r6 == null) goto L17;
        r6.c();
    L17:
        this.b = false;
        return;
    L8:
        if (r4 != 3) goto L28;
        b r7 = this.d;
        if (r7 == null) goto L13;
        r7.a();
    L13:
        this.b = true;
        return;
    L28:
        return;
    }

    public final void a(List<? extends py.k> r8, b r9) {
        if (Lists.isEmpty(r8) == false) goto L5;
        return;
    L5:
        this.d = r9;
        this.a = 0;
        this.c.sendEmptyMessageDelayed(1, n5.DEFAULT_SHOW_DURATION);
        ArrayList r0 = (ArrayList) r8;
        Iterator r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L19;
        py.k r3 = (py.k) r2.next();
        if (TextUtils.isEmpty(jc1.k.f(IHostFrescoHelper.class).getImageFilePath(r3)) == false) goto L10;
        if (r3 == null) goto L7;
        if (Lists.isEmpty(r3.getUrls()) == true) goto L7;
        if (TextUtils.isEmpty((CharSequence) ListProtector.get(r3.getUrls(), 0)) == true) goto L7;
        jc1.k.f(IHostFrescoHelper.class).tryDownloadImage((String) ListProtector.get(r3.getUrls(), 0), new a(this, r8, r3));
        goto L7
    L10:
        int r4 = this.a + 1;
        this.a = r4;
        if (r4 != r0.size()) goto L7;
        this.c.removeMessages(1);
        this.c.sendEmptyMessage(2);
        goto L7
    }
}
