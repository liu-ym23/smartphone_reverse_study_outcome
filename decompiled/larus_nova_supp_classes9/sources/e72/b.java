package e72;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public boolean a;
    public DownloadTask b;
    public final List<Pair<String, String>> c;
    public int d;
    public final a e;
    public final InterfaceC0228b f;

    public static final class a extends AbsDownloadListener {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void onProgress(DownloadInfo r4) {
            super.onProgress(r4);
            if (r4 == null) goto L6;
            int r0 = ((ArrayList) this.a.c).size();
            b r1 = this.a;
            r1.f.onProgress(((r1.d * 100) / r0) + (r4.getDownloadProcess() / r0));
            return;
        }

        public final void onSuccessed(DownloadInfo r3) {
            super.onSuccessed(r3);
            b r4 = this.a;
            boolean r1 = true;
            if (r4.d == (((ArrayList) r4.c).size() - 1)) goto L6;
            r1 = false;
        L6:
            if (r1 == false) goto L8;
            b r5 = this.a;
            r5.f.onSuccess(r5.c);
            return;
        L8:
            this.a.a();
        }

        public final void onFailed(DownloadInfo r2, BaseException r3) {
            super.onFailed(r2, r3);
            b r4 = this.a;
            r4.f.a(r4.c, r3);
        }
    }

    /* JADX INFO: renamed from: e72.b$b, reason: collision with other inner class name */
    public interface InterfaceC0228b {
        void a(List<Pair<String, String>> r1, BaseException r2);

        void onProgress(int r1);

        void onSuccess(List<Pair<String, String>> r1);
    }

    public final void a() {
        this.d++;
        DownloadTask r0 = Downloader.with(s1.getContext()).url((String) ((Pair) ListProtector.get(this.c, this.d)).getFirst());
        String r1 = (String) ((Pair) ListProtector.get(this.c, this.d)).getSecond();
        int r2 = StringsKt.lastIndexOf$default(r1, "/", 0, false, 6, null);
        String r4 = null;
        if (r2 == (-1)) goto L9;
        int r3 = r2 + 1;
        if (r1 == null) goto L8;
        String r5 = r1.substring(r3);
    L10:
        DownloadTask r6 = r0.name(r5).monitorScene("live_highlight_mark");
        String r7 = (String) ((Pair) ListProtector.get(this.c, this.d)).getSecond();
        int r8 = StringsKt.lastIndexOf$default(r7, "/", 0, false, 6, null);
        if (r8 == (-1)) goto L16;
        if (r7 == null) goto L15;
        r4 = r7.substring(0, r8);
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L16:
        DownloadTask r9 = r6.savePath(r4);
        this.b = r9;
        if (r9 == null) goto L19;
        r9.mainThreadListener(this.e);
    L19:
        DownloadTask r10 = this.b;
        if (r10 == null) goto L23;
        r10.download();
        return;
    L23:
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L9:
        r5 = null;
        goto L10
    }

    public b(List<Pair<String, String>> r2, InterfaceC0228b r3) {
        Intrinsics.checkNotNullParameter(r2, "urlToPathMap");
        Intrinsics.checkNotNullParameter(r3, "mDownloadCallback");
        this.f = r3;
        this.c = new ArrayList(r2);
        this.d = -1;
        this.e = new a(this);
    }
}
