package com.larus.community.impl.applet.music;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.NativeAppletApplication;
import com.bytedance.ai.applet.app.base.RouteOptions;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.platform.service.z2;
import com.larus.uaigc.applet.IMusicAppletPageProvider;
import com.larus.utils.logger.FLogger;
import ir8.c;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@NativeAppletApplication
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016¨\u0006\u0011"}, d2 = {"Lcom/larus/community/impl/applet/music/MusicGenerationAppletApplication;", "Lcom/bytedance/ai/applet/app/AppletApplication;", "<init>", "()V", "onCreateView", "Landroidx/fragment/app/Fragment;", "context", "Landroid/content/Context;", "url", "", "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "onTaskBackground", "", "onDestroyView", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicGenerationAppletApplication extends AppletApplication {
    public static Bundle p;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MusicAppletPage.values().length];
            r0[MusicAppletPage.TEMPLATE_LIST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MusicAppletPage.TEMPLATE_DETAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MusicAppletPage.CHAT_MUSIC_DETAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final void onDestroy() {
        FLogger.a.i("MusicGenerationAppletApplication", "onDestroy");
        super.onDestroy();
        ir8.a.a.clear();
        c.a.clear();
        c.b.clear();
    }

    public MusicGenerationAppletApplication() {
    }

    public final void C(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        FLogger.a.i("MusicGenerationAppletApplication", "onTaskBackground");
        CopyOnWriteArraySet r0 = c.a;
        Intrinsics.checkNotNullParameter("db_2c90E66", "appId");
        Iterator r1 = c.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((c.a) r1.next()).a();
        goto L4
    L6:
        super.C(r4);
    }

    public final void u(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        FLogger.a.i("MusicGenerationAppletApplication", "onDestroyView");
        super.u(r4);
        ir8.a.a.clear();
        c.a.clear();
        c.b.clear();
    }

    public final Fragment t(Context r5, String r6, RouteOptions r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "url");
        FLogger r8 = FLogger.a;
        r8.i("MusicGenerationAppletApplication", "onCreateView url=" + r6);
        if (z2.a.V3() == true) goto L6;
        r8.i("MusicGenerationAppletApplication", "onCreateView ignored by experiment");
        p = null;
        return null;
    L6:
        Bundle r9 = p;
        if (r9 == null) goto L9;
        p = null;
    L10:
        MusicAppletPage r2 = MusicAppletPage.Companion.a(r6, r9);
        if (r9 != null) goto L23;
        int r10 = b.a[r2.ordinal()];
        if (r10 != 1) goto L15;
        r9 = IMusicAppletPageProvider.a.a();
        goto L23
    L15:
        if (r10 != 2) goto L17;
    L21:
        r9 = null;
        goto L23
    L17:
        if (r10 == 3) goto L21;
        throw new NoWhenBranchMatchedException();
    L23:
        if (r9 != null) goto L27;
        r8.e("MusicGenerationAppletApplication", "onCreateView launch arguments are null, page=" + r2.getValue());
        return null;
    L27:
        return IMusicAppletPageProvider.a.b(r6, r9);
    L9:
        r9 = null;
        goto L10
    }
}
