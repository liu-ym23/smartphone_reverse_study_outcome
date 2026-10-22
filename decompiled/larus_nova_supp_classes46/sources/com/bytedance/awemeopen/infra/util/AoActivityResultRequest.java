package com.bytedance.awemeopen.infra.util;

import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Handler;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AoActivityResultRequest {
    public static Handler b;
    public final Activity a;

    public static class OnActivityResultFragment extends Fragment {
        public final AtomicBoolean a;
        public Intent b;
        public int c;
        public a d;
        public final AtomicBoolean e;

        public OnActivityResultFragment() {
            this.a = new AtomicBoolean(false);
            this.e = new AtomicBoolean(false);
        }

        @Override // android.app.Fragment
        public final void onAttach(Activity r4) {
            super.onAttach(r4);
            if (this.b != null) goto L5;
            Activity r5 = getActivity();
            if (r5 == null) goto L23;
            r5.getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
            return;
        L23:
            return;
        L5:
            if (this.e.getAndSet(true) == true) goto L19;
            setRetainInstance(true);
            startActivityForResult(this.b, this.c);     // Catch: ActivityNotFoundException -> L9
            return;
        L9:
            a r6 = this.d;
            if (r6 == null) goto L20;
            com.bytedance.awemeopen.infra.util.a r7 = (com.bytedance.awemeopen.infra.util.a) r6;
            r7.a(this.c, ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION, null);
            return;
        L20:
            return;
        }

        @Override // android.app.Fragment
        public final void onActivityResult(int r2, int r3, Intent r4) {
            a r0 = this.d;
            if (r0 == null) goto L5;
            ((com.bytedance.awemeopen.infra.util.a) r0).a(r2, r3, r4);
        L5:
            Activity r5 = getActivity();
            if (r5 == null) goto L10;
            r5.getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
            return;
        }
    }

    public interface a {
    }

    public AoActivityResultRequest(Activity r1) {
        this.a = r1;
    }
}
