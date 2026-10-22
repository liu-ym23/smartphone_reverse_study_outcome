package com.ss.android.lark.qrcode.ui;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.imageqrcode.QRCodeContentInfo;
import com.ss.android.lark.imageqrcode.QRCodeResultInfo;
import com.ss.android.lark.imageqrcode.QRCodeShowParam;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements mlb.d.a {
    public final /* synthetic */ QRCodeScanFragment a;
    public final /* synthetic */ String b;

    public final void a(ArrayList<QRCodeResultInfo> r10) {
        Intrinsics.checkNotNullParameter(r10, "resultList");
        if (this.a.isActive() == true) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        QRCodeResultInfo r1 = (QRCodeResultInfo) r11.next();
        r0.add(new QRCodeContentInfo(r1.getContent(), r1.getLeft(), r1.getTop(), r1.getRight(), r1.getBottom()));
        goto L7
    L9:
        boolean r2 = true;
        if (r0.size() > 1) goto L13;
        r2 = false;
    L13:
        FragmentActivity r12 = this.a.requireActivity();
        QRCodeShowParam r3 = new QRCodeShowParam(null);
        r3.setPath(this.b);
        Intrinsics.checkNotNullParameter(r0, "contentList");
        r3.setContentList(r0);
        if (r2 == false) goto L16;
        int r4 = 1001;
    L17:
        r3.setRequestCode(Integer.valueOf(r4));
        Intrinsics.checkNotNullParameter("scan_code", "from");
        r3.setFrom("scan_code");
        mlb.b.g(r12, r3);
        return;
    L16:
        r4 = 1000;
        goto L17
    }

    public final void onError(String r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (this.a.isActive() == true) goto L5;
        return;
    L5:
        this.a.S90().a.showToast(y9c.d.i(this.a.requireActivity(), 2131892110));
        Log.e("QRCodeScanFragment", "scan picture error:" + r4);
    }

    public d(QRCodeScanFragment r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
