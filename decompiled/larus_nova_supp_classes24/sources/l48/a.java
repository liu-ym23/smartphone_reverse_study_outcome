package l48;

import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.AosRecomendFeedViewModel;
import com.bytedance.awemeopen.export.api.AosConfigService;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements pr9.c {
    public final AosConfigService.c a;

    /* JADX INFO: renamed from: l48.a$a, reason: collision with other inner class name */
    public static final class C0115a {
    }

    static {
    }

    public a(AosRecomendFeedViewModel.f r2) {
        Intrinsics.checkNotNullParameter(r2, "iLoadMoreCallback");
        this.a = r2;
    }

    public final void a(boolean r8, List<String> r9) {
        Intrinsics.checkNotNullParameter(r9, "hostCustomAids");
        StringBuilder r0 = new StringBuilder();
        Iterator<T> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r0.append(((String) r10.next()) + ',');
        goto L4
    L6:
        FLogger.a.d("ILoadMoreCallbackWrapper", "onGetLoadMoreAids:" + r0 + "----haveMoreAid:" + r8);
        AosConfigService.c r11 = this.a;
        String r1 = r0.toString();
        int r2 = r1.length() + (-1);
        if (r2 < 0) goto L17;
    L8:
        int r3 = r2 - 1;
        if (r1.charAt(r2) != ',') goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L13;
        if (r3 < 0) goto L17;
        r2 = r3;
        goto L8
    L13:
        CharSequence r5 = r1.subSequence(0, r2 + 1);
    L18:
        r11.a(r5.toString(), r8);
        return;
    L11:
        r4 = false;
    L17:
        r5 = "";
        goto L18
    }
}
