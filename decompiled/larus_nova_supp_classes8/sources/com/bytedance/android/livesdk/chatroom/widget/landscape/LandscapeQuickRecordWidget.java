package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.content.Intent;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.ui.record.presenter.QuickRecordingPresenter;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.QuickShotRecordControl, needDynamicControl = true, type = PlayerViewControl.Type.ALPHA)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeQuickRecordWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeQuickShotAndRecordBaseWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "Lcom/bytedance/android/livesdk/chatroom/ui/record/presenter/QuickRecordingPresenter$b;", "<init>", "()V", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeQuickRecordWidget extends LandscapeQuickShotAndRecordBaseWidget implements Observer<KVData>, com.bytedance.android.livesdk.chatroom.vsplayer.model.a, QuickRecordingPresenter.b {
    public static boolean j;
    public com.bytedance.android.livesdk.chatroom.ui.record.presenter.b a;
    public IAnchorBacktrackService b;
    public View c;
    public IRoom d;
    public final boolean e;
    public boolean f;
    public final CompositeDisposable g;
    public final CompositeDisposable h;
    public Disposable i;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567243;
    }

    public final void onInit(Object[] r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.QuickRecordingPresenter.b
    public final void Gm() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.put("data_live_quick_record_finish", Boolean.TRUE);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.QuickRecordingPresenter.b
    public final void a1() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.put("data_live_quick_record_start", Boolean.TRUE);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.QuickRecordingPresenter.b
    public final void onShareDialogDismiss() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.put("data_live_quick_record_layer_hide", Boolean.FALSE);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.QuickRecordingPresenter.b
    public final void onShareDialogShow() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.put("data_live_quick_record_layer_show", Boolean.TRUE);
    L5:
        gr1.a r1 = jr1.c.a();
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r2 = r1.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r2 == null) goto L12;
        r2.j(false);
        return;
    L12:
        return;
    }

    public final void onUnload() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L10;
        List r1 = CollectionsKt.mutableListOf(new String[]{"data_live_quick_record_layer_show", "data_live_quick_record_layer_hide", "data_audience_backtrace_service", "data_backtrack_service"});
        if (r1 == null) goto L10;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r0.removeObserver((String) r2.next(), this);
    L10:
        this.h.clear();
        com.bytedance.android.livesdk.chatroom.ui.record.presenter.b r3 = this.a;
        if (r3 == null) goto L13;
        r3.e = true;
    L13:
        Disposable r4 = this.i;
        if (r4 == null) goto L16;
        r4.dispose();
    L16:
        this.f = false;
    }

    public LandscapeQuickRecordWidget() {
        this.e = true;
        this.g = new CompositeDisposable();
        this.h = new CompositeDisposable();
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        com.bytedance.android.livesdk.chatroom.ui.record.presenter.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onStop();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.e;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.QuickRecordingPresenter.b
    public final void lk(boolean r1) {
        j = r1;
        xq(false);
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        Intrinsics.checkNotNullParameter(r6, "t");
        String r7 = r6.getKey();
        boolean r1 = true;
        IAnchorBacktrackService.State r3 = null;
        switch(r7.hashCode()) {
            case 118051045: goto L30;
            case 836394094: goto L20;
            case 1660640366: goto L13;
            case 1660967465: goto L6;
            default: goto L51;
        };
    L51:
        return;
    L6:
        if (r7.equals("data_live_quick_record_layer_show") == false) goto L40;
        gr1.a r8 = jr1.c.a();
        if (r8 == null) goto L41;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r9 = r8.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r9 == null) goto L42;
        r9.j(false);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L13:
        if (r7.equals("data_live_quick_record_layer_hide") == false) goto L44;
        gr1.a r10 = jr1.c.a();
        if (r10 == null) goto L45;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r11 = r10.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r11 == null) goto L46;
        r11.j(false);
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L20:
        if (r7.equals("data_audience_backtrace_service") == false) goto L48;
        IAnchorBacktrackService r12 = this.b;
        if (r12 == null) goto L25;
        r3 = r12.getState();
    L25:
        if (r3 == IAnchorBacktrackService.State.BACKTRACK_DOING) goto L28;
        r1 = false;
    L28:
        xq(r1);
        return;
    L48:
        return;
    L30:
        if (r7.equals("data_backtrack_service") == false) goto L50;
        IAnchorBacktrackService r13 = this.b;
        if (r13 == null) goto L35;
        r3 = r13.getState();
    L35:
        if (r3 == IAnchorBacktrackService.State.BACKTRACK_DOING) goto L38;
        r1 = false;
    L38:
        xq(r1);
        return;
    }

    public final void onLoad(Object[] r14) {
        final Function1<Boolean, Unit> r15 = new AnonymousClass1(this);
        if (oo1.i.a() == false) goto L36;
        int r0 = bs1.a.a;
        Function1<Boolean, Unit> r1 = new LandscapeQuickRecordWidget$enableInsideRecord$1(r15);
        Intrinsics.checkNotNullParameter(r1, "callback");
        MediaCodecInfo[] r16 = new MediaCodecList(1).getCodecInfos();
        int r2 = r16.length;
        int r4 = 0;
        boolean r5 = true;
    L6:
        if (r4 >= r2) goto L20;
        MediaCodecInfo r8 = r16[r4];
        if (r8.isEncoder() == false) goto L19;
        if (StringsKt.contains$default(r8.getName(), "avc", false, 2, null) == false) goto L19;
        String[] r6 = r8.getSupportedTypes();
        int r7 = r6.length;
        int r9 = 0;
    L12:
        if (r9 >= r7) goto L19;
        String r10 = r6[r9];
        if (StringsKt.equals(r10, "video/avc", true) == false) goto L18;
        MediaCodec.createEncoderByType(r10).release();     // Catch: Exception -> L17
    L17:
        r5 = false;
    L18:
        r9 = r9 + 1;
    L19:
        r4 = r4 + 1;
        goto L6
    L20:
        int r3 = r16.length;
        int r11 = 0;
    L21:
        if (r11 >= r3) goto L35;
        MediaCodecInfo r12 = r16[r11];
        if (r12.isEncoder() == false) goto L34;
        if (StringsKt.contains$default(r12.getName(), "aac", false, 2, null) == false) goto L34;
        String[] r13 = r12.getSupportedTypes();
        int r17 = r13.length;
        int r18 = 0;
    L27:
        if (r18 >= r17) goto L34;
        String r19 = r13[r18];
        if (StringsKt.equals(r19, "audio/mp4a-latm", true) == false) goto L33;
        MediaCodec.createEncoderByType(r19).release();     // Catch: Exception -> L32
    L32:
        r5 = false;
    L33:
        r18 = r18 + 1;
    L34:
        r11 = r11 + 1;
        goto L21
    L35:
        r1.invoke(Boolean.valueOf(r5));
        return;
    L36:
        r15.invoke(Boolean.FALSE);
    }

    public final void xq(boolean r4) {
        IRoom r0 = this.d;
        if (r0 == null) goto L17;
        IRoomAuthStatus r1 = r0.getRoomAuthStatus();
        if (r1 == null) goto L17;
        if (r1.enableLandscapeQuickRecord() != true) goto L17;
        if (j == false) goto L11;
    L13:
        View r2 = this.c;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("recordBtn");
    L16:
        UtilityKotlinExtentionsKt.z(r2, !r4);
        return;
    L11:
        if (this.f == true) goto L13;
    L17:
        View r5 = this.c;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("recordBtn");
    L20:
        UtilityKotlinExtentionsKt.t(r5);
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onActivityResult(r2, r3, r4);
        if (r4 == null) goto L8;
        com.bytedance.android.livesdk.chatroom.ui.record.presenter.b r0 = this.a;
        if (r0 == null) goto L9;
        r0.onActivityResult(r2, r3, r4);
        return;
    L9:
        return;
    }
}
