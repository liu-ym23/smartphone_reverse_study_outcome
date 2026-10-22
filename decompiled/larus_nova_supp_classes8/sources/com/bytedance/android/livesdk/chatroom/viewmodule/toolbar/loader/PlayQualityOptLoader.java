package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.AudienceExperienceSettingDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.TopSpeedGuideDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.utils.k4;
import com.bytedance.services.apm.api.EnsureManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/PlayQualityOptLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "Landroid/content/Context;", "j", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayQualityOptLoader extends AbsDynamicLoader {
    public final CompositeDisposable h;
    public final Lazy i;
    public final Context j;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ PlayQualityOptLoader a;

        public a(PlayQualityOptLoader r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            h61.b r5 = (h61.b) r4;
            int r6 = TopSpeedGuideDialog.B;
            Context r7 = this.a.getContext();
            if (r7 == null) goto L24;
            Activity r0 = k4.b(r7);
            if (r0 != null) goto L8;
        L10:
            if (r0 != null) goto L12;
        L14:
            TopSpeedGuideDialog r1 = new TopSpeedGuideDialog(r7);
            if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L21;
            DialogLancet.handleBlockedDialogShow(r1);
            return;
        L21:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
        L18:
            DialogLancet.beforeDialogShow(r1);
            r1.show();
            DialogLancet.afterDialogShow(r1);
            return;
        L12:
            if (r0.isDestroyed() != true) goto L14;
            return;
        L8:
            if (r0.isFinishing() != true) goto L10;
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r1) {
            EnsureManager.ensureNotReachHere((Throwable) r1);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PlayQualityOptLoader a;

        public c(PlayQualityOptLoader r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            h61.a r3 = (h61.a) r2;
            int r4 = AudienceExperienceSettingDialog.M;
            AudienceExperienceSettingDialog.a.a(this.a.getContext(), this.a.f.a);
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r1) {
            EnsureManager.ensureNotReachHere((Throwable) r1);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final boolean b() {
        if (z.e(this.f.a, false) == false) goto L5;
        return false;
    L5:
        if (PlatformExpUtils.a() == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        return CollectionsKt.listOf(ToolbarButton.PLAY_QUALITY_OPT);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        y3.f(this.a).p(ToolbarButton.PLAY_QUALITY_OPT.extended(), (c0.b) this.i.getValue());
        RxUtilKt.c(xs2.b.a().b(h61.b.class).subscribe(new a(this), b.a), this.h);
        RxUtilKt.c(xs2.b.a().b(h61.a.class).subscribe(new c(this), d.a), this.h);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onUnLoad() {
        super.onUnLoad();
        this.h.clear();
    }

    public final Context getContext() {
        return this.j;
    }

    public PlayQualityOptLoader(e r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "env");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2);
        this.j = r3;
        this.h = new CompositeDisposable();
        this.i = LazyKt.lazy(PlayQualityOptLoader$behavior$2.INSTANCE);
    }
}
