package k2;

import android.net.Uri;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {

    /* JADX INFO: renamed from: k2.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0172a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PageType.values().length];
            r0[PageType.FULL_PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PageType.POPUP_PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final String a(PageInfo r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r0 = r10.getPageUrl();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == true) goto L24;
        String r12 = r10.getPageUrl();
        Intrinsics.checkNotNull(r12);
        ReadableMap r13 = r10.getPageSettings();
        Intrinsics.checkNotNullParameter(r12, "uri");
        h2.a r14 = f2.b.c;
        if (r14 != null) goto L14;
    L16:
        if (r1 == true) goto L26;
        if (r13 == null) goto L26;
        Uri.Builder r15 = UriProtector.parse(r12).buildUpon();
        ReadableMapKeySetIterator r16 = r13.keySetIterator();
    L21:
        if (r16.hasNextKey() == false) goto L23;
        String r17 = r16.nextKey();
        r15.appendQueryParameter(r17, r13.getString(r17));
        goto L21
    L23:
        r12 = r15.build().toString();
    L26:
        return r12;
    L14:
        if (r14.j != true) goto L16;
        r1 = true;
        goto L16
    L24:
        return r10.getPageUrl();
    L5:
        if (r0.length() == 0) goto L8;
        r11 = false;
        goto L9
    }
}
