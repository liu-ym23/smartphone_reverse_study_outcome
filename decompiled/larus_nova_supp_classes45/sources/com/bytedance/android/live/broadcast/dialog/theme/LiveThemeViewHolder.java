package com.bytedance.android.live.broadcast.dialog.theme;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b;
import com.bytedance.android.live.liveinteract.radio.RadioDarkMaskView;
import com.bytedance.android.live.ui.o;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfo;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcast/dialog/theme/LiveThemeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveThemeViewHolder extends RecyclerView.ViewHolder {
    public final HSImageView a;
    public final RadioDarkMaskView b;
    public final View c;
    public final ImageView d;
    public final View e;
    public final TextView f;
    public final TextView g;
    public final o h;
    public final ConstraintLayout i;
    public final ProgressBar j;
    public IVoiceLiveTheme k;
    public final a l;

    public static final class a implements b {
        public final /* synthetic */ LiveThemeViewHolder a;
        public final /* synthetic */ View b;

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcast.dialog.theme.LiveThemeViewHolder$a$a, reason: collision with other inner class name */
        public static final class RunnableC0019a implements Runnable {
            public final /* synthetic */ a a;
            public final /* synthetic */ String b;

            public RunnableC0019a(a r1, String r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                ProgressBar r0 = this.a.a.j;
                if (r0 == null) goto L5;
                r0.setVisibility(8);
            L5:
                ALogger.d("VideoThemeView", "onDownloadCompleted: 下载完成，开始播放");
                LiveThemeViewHolder r1 = this.a.a;
                o r2 = r1.h;
                String r3 = this.b;
                IVoiceLiveTheme r4 = r1.k;
                if (r4 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
            L8:
                IAnimatedBgInfo r5 = r4.getAnimatedBgInfo();
                if (r5 == null) goto L13;
                k r6 = r5.getAnimatedBg();
                if (r6 == null) goto L13;
                String r7 = r6.getUri();
            L14:
                r2.d(r3, r7, null);
                return;
            L13:
                r7 = null;
                goto L14
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void b() {
        }

        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "path");
            this.b.post(new RunnableC0019a(this, r3));
        }

        public a(LiveThemeViewHolder r1, View r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public LiveThemeViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (HSImageView) r2.findViewById(2131388563);
        this.b = r2.findViewById(2131388564);
        this.c = r2.findViewById(2131385793);
        this.d = (ImageView) r2.findViewById(2131364705);
        this.e = r2.findViewById(2131377887);
        this.f = (TextView) r2.findViewById(2131388560);
        this.g = (TextView) r2.findViewById(2131388561);
        this.h = r2.findViewById(2131388565);
        this.i = r2.findViewById(2131362269);
        this.j = (ProgressBar) r2.findViewById(2131392330);
        this.l = new a(this, r2);
    }
}
