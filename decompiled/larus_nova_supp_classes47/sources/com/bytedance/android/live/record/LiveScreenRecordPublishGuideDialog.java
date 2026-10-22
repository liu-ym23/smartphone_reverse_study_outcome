package com.bytedance.android.live.record;

import am2.x;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.live.room.api.record.LiveScreenRecordGuideConfig;
import com.bytedance.android.live.room.api.record.f;
import com.bytedance.android.live.room.api.record.guide.PublishDialogInfo;
import com.bytedance.android.live.room.api.record.guide.b;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import hd0.c;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/record/LiveScreenRecordPublishGuideDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "Lcom/bytedance/android/live/room/api/record/guide/b;", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveScreenRecordPublishGuideDialog extends CommonStandardBottomDialog implements b {
    public static final /* synthetic */ int G = 0;
    public final String B;
    public final CompositeDisposable C;
    public View D;
    public ImageView E;
    public final PublishDialogInfo F;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565765;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        this.C.clear();
        return;
    L12:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public final void W0(boolean r6) {
        if (r6 == false) goto L6;
        IInteractivityInjectService r0 = k.f(IInteractivityInjectService.class);
        if (r0 == null) goto L9;
        r0.muteLivePlayerClient();
    L9:
        LiveScreenRecordGuideConfig.c.getClass();
        if (((Boolean) LiveScreenRecordGuideConfig.b.getValue()).booleanValue() == true) goto L12;
        return;
    L12:
        if (c.f().h() == true) goto L14;
        return;
    L14:
        if (r6 == false) goto L20;
        IPushStreamService r7 = (IPushStreamService) k.f(IPushStreamService.class);
        if (r7 == null) goto L28;
        com.bytedance.android.live.pushstream.d r8 = r7.getPushLiveStream();
        if (r8 == null) goto L29;
        r8.J0("live screen record preview", new uv0.a(LiveRequestSourceRole.Business, "LiveScreenRecordPublishGuideDialog.mutePlayerClient", null));
        return;
    L29:
        return;
    L28:
        return;
    L20:
        IPushStreamService r9 = (IPushStreamService) k.f(IPushStreamService.class);
        if (r9 == null) goto L31;
        com.bytedance.android.live.pushstream.d r10 = r9.getPushLiveStream();
        if (r10 == null) goto L32;
        r10.q1("live screen record preview", new uv0.a(LiveRequestSourceRole.Business, "LiveScreenRecordPublishGuideDialog.mutePlayerClient", null));
        return;
    L32:
        return;
    L31:
        return;
    L6:
        IInteractivityInjectService r1 = k.f(IInteractivityInjectService.class);
        if (r1 == null) goto L9;
        r1.unmuteLivePlayerClient();
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        Window r8 = getWindow();
        if (r8 == null) goto L7;
        WindowManager.LayoutParams r9 = r8.getAttributes();
        if (r9 == null) goto L7;
        r9.dimAmount = 0.0f;
    L7:
        this.D = findViewById(2131378591);
        this.E = (ImageView) findViewById(2131375947);
        View r10 = this.D;
        if (r10 == null) goto L10;
        r10.setOnClickListener(new lx0.b(this));
    L10:
        String r12 = this.B;
        int r0 = f.a;
        Intrinsics.checkNotNullParameter(r12, "videoPath");
        MediaMetadataRetriever r2 = null;
        String r3 = null;
        r3 = null;
        if (FileUtils.isFileEmpty(r12) == false) goto L64;
    L33:
        Observable r13 = null;
    L34:
        if (r13 == null) goto L42;
        Observable r14 = r13.subscribeOn(Schedulers.io());
        if (r14 == null) goto L42;
        Observable r15 = RxUtilKt.h(r14);
        if (r15 == null) goto L42;
        Disposable r16 = r15.subscribe(new lx0.c(this));
        if (r16 == null) goto L42;
        com.bytedance.revenue.platform.api.core.rx.f.a(r16, this.C);
    L42:
        Pair[] r17 = new Pair[4];
        r17[0] = TuplesKt.to("event_page", "live_detail");
        r17[1] = TuplesKt.to("module_name", "comment_highlight_publish_guide");
        r17[2] = TuplesKt.to("highlights_content_id", (String) this.F.d.getValue());
        DataCenter r1 = this.F.c;
        if (r1 == null) goto L47;
        Room r4 = z.o(r1);
        if (r4 == null) goto L47;
        r3 = r4.getIdStr();
    L47:
        r17[3] = TuplesKt.to("room_id", String.valueOf(r3));
        j0.l().sendLog("livesdk_comment_highlight_module_show", MapsKt.mutableMapOf(r17), new Object[]{IRoom.class, x.class});
        return;
    L64:
        MediaMetadataRetriever r5 = new MediaMetadataRetriever();     // Catch: Throwable -> L23 Exception -> L25
        r5.setDataSource(r12);     // Catch: Throwable -> L19 Exception -> L21
        r13 = Observable.just(r5.getFrameAtTime(0, 2));     // Catch: Throwable -> L19 Exception -> L21
        r5.release();     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = e;
    L27:
        e.printStackTrace();     // Catch: Throwable -> L19
        if (r5 == null) goto L33;
        r5.release();     // Catch: Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
        r2 = r5;
    L49:
        if (r2 != null) goto L55;
    L54:
        throw th;
    L55:
        r2.release();     // Catch: Exception -> L52
    L52:
        e = move-exception;
        e.printStackTrace();
        goto L54
    L25:
        e = e;
        r5 = null;
    L23:
        th = th;
        goto L49
    }

    public LiveScreenRecordPublishGuideDialog(Context r2, PublishDialogInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "info");
        super(r2, false);
        this.F = r3;
        this.B = (String) r3.b.getValue();
        this.C = new CompositeDisposable();
    }
}
