package f1b;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.officesdk.utils.di.t;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.vfs.VFSFiles;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;
import swb.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends y0b.c {
    public final qpc.a a;

    public d() {
        this.a = (qpc.a) ApiUtils.getApi(qpc.a.class);
    }

    @Override // y0b.c
    public final WebResourceResponse a(Uri r23) {
        if (r23 == null) goto L41;
        LinkedHashMap r1 = new LinkedHashMap();
        String r2 = r23.getEncodedQuery();
        String r9 = BuildConfig.FLAVOR;
        boolean r10 = true;
        if (r2 == null) goto L17;
        Iterator r3 = StringsKt.split$default(r2, new String[]{"&"}, false, 0, 6, null).iterator();
    L9:
        if (r3.hasNext() == false) goto L17;
        List r4 = StringsKt.split$default((String) r3.next(), new String[]{"="}, false, 2, 2, null);
        int r5 = r4.size();
        if (r5 != 1) goto L13;
        r1.put(ListProtector.get(r4, 0), BuildConfig.FLAVOR);
        goto L9
    L13:
        if (r5 != 2) goto L9;
        r1.put((String) ListProtector.get(r4, 0), (String) ListProtector.get(r4, 1));
    L17:
        String r6 = (String) r1.get("crypto");
        String r14 = (String) r1.get("fsUnit");
        String r7 = (String) r1.get("key");
        if (r7 == null) goto L41;
        if (r6 == null) goto L21;
        ByteString.Companion.getClass();
        ByteString r15 = ByteString.a.a(r6);
    L22:
        qpc.a r11 = this.a;
        String r8 = (String) t.a.get();
        if (r8 == null) goto L26;
        r9 = r8;
    L26:
        Intrinsics.checkNotNullParameter(r9, "traceId");
        if (r9.length() == 0) goto L31;
        r10 = false;
    L31:
        if (r10 == false) goto L33;
        String r12 = StringsKt.replace$default(String.valueOf(t.a()), "-", BuildConfig.FLAVOR, false, 4, null).substring(0, 10);
    L34:
        Resource r13 = r11.getEncryptImage(null, r7, r14, r15, r12, false);
        if (r13 == null) goto L41;
        String r16 = r13.b;
        if (r16 == null) goto L41;
        return new WebResourceResponse(j.i(r7), Charset.defaultCharset().name(), VFSFiles.b.k(r16));
    L33:
        r12 = r9 + '_' + StringsKt.replace$default(String.valueOf(t.a()), "-", BuildConfig.FLAVOR, false, 4, null).substring(0, 10);
        goto L34
    L21:
        r15 = null;
    L41:
        return null;
    }
}
