package zka;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import androidx.core.util.Consumer;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.miniapp.calendar.proxy.function.AppletVersionInfo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b extends ContentObserver {
    public final /* synthetic */ a a;

    public b(a r1, Handler r2) {
        this.a = r1;
        super(r2);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r5, Uri r6) {
        a r7 = this.a;
        r7.getClass();
        if (r6 == null) goto L32;
        List<String> r0 = r6.getPathSegments();
        if (r0.size() >= 3) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(ListProtector.get(r0, 0), "ai_package_version") == false) goto L34;
        String r1 = (String) ListProtector.get(r0, 1);
        String r2 = (String) ListProtector.get(r0, 2);
        String r8 = UriProtector.getQueryParameter(r6, "versionCode");
        if (r8 == null) goto L27;
        Long r9 = StringsKt.toLongOrNull(r8);
        if (r9 == null) goto L30;
        long r3 = r9.longValue();
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNull(r2);
        AppletVersionInfo r10 = new AppletVersionInfo(r1, r2, r3);
        CopyOnWriteArraySet<Consumer<AppletVersionInfo>> r4 = r7.b.get("*|*");
        if (r4 == null) goto L21;
        Iterator<T> r11 = r4.iterator();
    L19:
        if (r11.hasNext() == false) goto L21;
        ((Consumer) r11.next()).accept(r10);
    L21:
        CopyOnWriteArraySet<Consumer<AppletVersionInfo>> r12 = r7.b.get(r1 + '|' + r2);
        if (r12 == null) goto L31;
        Iterator<T> r13 = r12.iterator();
    L25:
        if (r13.hasNext() == false) goto L35;
        ((Consumer) r13.next()).accept(r10);
        goto L25
    L35:
        return;
    L31:
        return;
    L30:
        return;
    L27:
        return;
    L34:
        return;
    }
}
