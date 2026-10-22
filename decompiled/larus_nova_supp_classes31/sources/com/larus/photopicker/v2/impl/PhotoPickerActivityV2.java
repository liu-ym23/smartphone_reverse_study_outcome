package com.larus.photopicker.v2.impl;

import android.R;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.photopicker.v2.impl.data.model.LazyLoadConfig;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.model.MediaNonUISettings;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.larus.platform.model.album.AlbumInputState;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.InputDraftSnapshot;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0019B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0014J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\"\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014¨\u0006\u001a"}, d2 = {"Lcom/larus/photopicker/v2/impl/PhotoPickerActivityV2;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Lcom/larus/photopicker/v2/api/IPhotoPickerPage;", "Lcom/larus/common_ui/floatwindow/manager/FloatWindowHostForwardActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "bindInjectInputContext", "getBackgroundResource", "", "needAdaptStatusBarPadding", "", "onAttachedToWindow", "finish", "closePageAfterSend", "onDestroy", "showAlbumV2", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PhotoPickerActivityV2 extends FlowCommonAppCompatActivity implements lp9.c, e19.a {

    public static final class a {
    }

    static {
    }

    public final int C1() {
        return R.color.transparent;
    }

    public final boolean K1() {
        return false;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(PhotoPickerActivityV2.class.getName()));
    L5:
        super.onDestroy();
        ((LinkedHashMap) ((gx8.a) pp9.i.a()).a.b).clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zK() {
        Intent r0 = new Intent();
        r0.putExtra("RESULT_REASON_SEND", 1);
        Unit r1 = Unit.INSTANCE;
        setResult(-1, r0);
        tx9.d2 r2 = tx9.d2.a;
        JSONObject r3 = lp9.d.a();
        r2.getClass();
        tx9.d2.e(true, true, "close_after_send", r3);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 2130772402);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(PhotoPickerActivityV2.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.app.Activity*/.onAttachedToWindow();
        getWindow().setNavigationBarColor(getResources().getColor(v19.c.b(2130970532, this, 2131102539)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public PhotoPickerActivityV2() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r23) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        int r1 = getIntent().getIntExtra("extra.force.theme", 0);
        if (r1 == 1) goto L16;
        if (r1 != 2) goto L17;
        v19.f.b(getTheme());
    L17:
        super.onCreate(r23);
        setContentView(2131561787);
        t1a.c r2 = getIntent().getParcelableExtra("inject_input_context_vdata");
        if ((r2 instanceof t1a.c) == false) goto L20;
        t1a.c r3 = r2;
    L21:
        if (r3 == null) goto L24;
        s1a.a.h(this).i(r3, Reflection.getOrCreateKotlinClass(r3.getClass()));
        FLogger.a.i("PhotoPickerActivityV2", "bindInjectInputContext data=" + Reflection.getOrCreateKotlinClass(r3.getClass()).getSimpleName());
    L24:
        Bundle r4 = getIntent().getExtras();
        if (r4 != null) goto L27;
        r4 = new Bundle();
    L27:
        Serializable r5 = r4.getSerializable("extra.album.config");
        if ((r5 instanceof AlbumSettingConfig) == false) goto L30;
        AlbumSettingConfig r6 = (AlbumSettingConfig) r5;
    L31:
        if (r6 != null) goto L33;
        AlbumSettingConfig.Companion.getClass();
        r6 = AlbumSettingConfig.b.a();
    L33:
        boolean r7 = r6.isMultiPick();
        int r8 = r6.getMaxSelectCount();
        int r9 = r6.getSpanCount();
        boolean r10 = r6.getSupportVideo();
        boolean r11 = r6.getEnableSeparateMediaSelection();
        int r12 = r6.getMaxSelectVideoCount();
        AlbumInputState r13 = r6.getInitialInputState();
        dr9.g r14 = dr9.g.a;
        if (r13 == null) goto L36;
        String r15 = r13.getInputSnapshotId();
    L37:
        InputDraftSnapshot r16 = dr9.g.d(r15);
        if (r13 == null) goto L40;
        String r17 = r13.getInputSnapshotId();
    L41:
        if (r17 != null) goto L43;
    L46:
        boolean r18 = true;
    L47:
        if (r18 == true) goto L50;
        if (r16 != null) goto L50;
        boolean r19 = true;
    L52:
        if (r6.getEnableInjectInput() == false) goto L55;
        if (r19 == true) goto L55;
        boolean r110 = true;
    L56:
        boolean r20 = r6.getOnlyDisplayVideo();
        boolean r21 = r6.getSupportOriginalImage();
        Integer r111 = r6.getLandingTabIndex();
        if (r111 == null) goto L59;
        int r112 = r111.intValue();
    L60:
        Long r113 = r6.getMaxVideoDuration();
        if (r113 == null) goto L63;
        long r114 = r113.longValue();
    L64:
        if (r10 == false) goto L66;
        List<? extends MediaTab> r22 = CollectionsKt.listOf(new MediaTab[]{MediaTab.ALL, MediaTab.VIDEO, MediaTab.IMAGE});
    L67:
        if (r16 == null) goto L73;
        List<AttachmentSnapshot> r115 = r16.getAttachments();
        if (r115 == null) goto L73;
        if ((!r115.isEmpty()) != true) goto L73;
        boolean r24 = true;
    L74:
        if (r24 == true) goto L85;
        if (r13 == null) goto L81;
        List<String> r25 = r13.getAttachmentUris();
        if (r25 == null) goto L81;
        if ((!r25.isEmpty()) != true) goto L81;
        boolean r26 = true;
    L82:
        if (r26 == true) goto L85;
        boolean r27 = false;
    L87:
        if (uy8.b.c() == true) goto L89;
    L91:
        boolean r116 = false;
    L92:
        if (r116 == true) goto L95;
        if (r8 != 0) goto L100;
    L94:
        r8 = 1;
    L100:
        MediaGalleryUIConfig.a r28 = MediaGalleryUIConfig.G;
        r28.getClass();
        MediaGalleryUIConfig.a r117 = new MediaGalleryUIConfig.a();
        r117.a = r28.a;
        r117.b = r28.b;
        r117.c = r28.c;
        r117.d = r28.d;
        r117.e = r28.e;
        r117.f = r28.f;
        r117.g = r28.g;
        r117.h = r28.h;
        r117.i = r28.i;
        r117.j = r28.j;
        r117.l = r28.l;
        r117.m = r28.m;
        r117.k = r28.k;
        r117.n = r28.n;
        r117.o = r28.o;
        r117.p = r28.p;
        r117.q = r28.q;
        r117.r = r28.r;
        r117.s = r28.s;
        r117.t = r28.t;
        r117.u = r28.u;
        r117.v = r28.v;
        r117.w = r28.w;
        r117.x = r28.x;
        r117.y = r28.y;
        r117.z = r28.z;
        r117.A = r28.A;
        r117.B = r28.B;
        r117.C = r28.C;
        r117.D = r28.D;
        r117.E = r28.E;
        r117.F = r28.F;
        Intrinsics.checkNotNullParameter(r22, "tabs");
        r117.a = r22;
        r117.b = r9;
        r117.c = !r7;
        r117.d = r8;
        r117.g = r10;
        r117.p = r110;
        r117.q = r6.getSuggestedActionProvider();
        if (r13 == null) goto L103;
        String r0 = r13.getText();
    L104:
        r117.r = r0;
        if (r13 == null) goto L110;
        String r29 = r13.getInputSnapshotId();
        if (r29 == null) goto L110;
        if (r19 == true) goto L110;
    L111:
        r117.s = r29;
        if (r13 == null) goto L114;
        String r30 = r13.getSourceNodeId();
    L115:
        if (r30 != null) goto L117;
        r30 = "";
    L117:
        r117.t = r30;
        if (r13 == null) goto L120;
        List<String> r31 = r13.getAttachmentUris();
    L121:
        if (r31 != null) goto L123;
        r31 = CollectionsKt.emptyList();
    L123:
        Intrinsics.checkNotNullParameter(r31, "value");
        r117.u = r31;
        String r32 = r6.getAlbumNodeId();
        Intrinsics.checkNotNullParameter(r32, "value");
        r117.v = r32;
        String r33 = r6.getUpstreamAlbumNodeId();
        Intrinsics.checkNotNullParameter(r33, "value");
        r117.w = r33;
        if (r6.getAllowUnifiedPreview() == false) goto L127;
        if (r19 == true) goto L127;
        boolean r34 = true;
    L128:
        r117.x = r34;
        if (r6.getMobilePreviewHostEnabled() == false) goto L132;
        if (r19 == true) goto L132;
        boolean r35 = true;
    L133:
        r117.z = r35;
        r117.A = r6.getUnifiedPreviewEntry();
        r117.y = r6.getUseUnifiedMediaCanvas();
        r117.B = r6.getHideAlbumEntranceInInjectedInput();
        r117.C = r20;
        r117.E = r21;
        r117.F = r112;
        MediaNonUISettings r36 = new MediaNonUISettings(r11, r12, r6.getCreationReferenceConfig(), r114, r6.getClickFrom());
        int r37 = BottomPhotoPickerFragmentV2.C;
        BottomPhotoPickerFragmentV2.a.a(r117.a(), new LazyLoadConfig(15, 64, 32, 100), r36).Bs(getSupportFragmentManager(), "BottomPhotoPickerFragmentV2");
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        overridePendingTransition(2130772400, 2130772399);
        return;
    L132:
        r35 = false;
    L127:
        r34 = false;
        goto L128
    L120:
        r31 = null;
        goto L121
    L114:
        r30 = null;
    L110:
        r29 = null;
        goto L111
    L103:
        r0 = null;
        goto L104
    L95:
        if (r7 == true) goto L99;
        if (r27 == false) goto L99;
        if (r8 == 0) goto L94;
    L99:
        r8 = RangesKt.coerceAtLeast(r8, 0);
        goto L100
    L89:
        if (r6.getEnableInjectInput() == false) goto L91;
        r116 = true;
    L81:
        r26 = false;
    L85:
        r27 = true;
    L73:
        r24 = false;
        goto L74
    L66:
        r22 = CollectionsKt.listOf(MediaTab.IMAGE);
        goto L67
    L63:
        r114 = 0;
        goto L64
    L59:
        r112 = 0;
    L55:
        r110 = false;
    L50:
        r19 = false;
        goto L52
    L43:
        if (StringsKt.isBlank(r17) == true) goto L46;
        r18 = false;
        goto L47
    L40:
        r17 = null;
        goto L41
    L36:
        r15 = null;
        goto L37
    L30:
        r6 = null;
        goto L31
    L20:
        r3 = null;
        goto L21
    L16:
        v19.f.c(getTheme());
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onActivityResult(int r4, int r5, Intent r6) {
        super.onActivityResult(r4, r5, r6);
        FLogger.a.i("PhotoPickerActivityV2", "requestCode=" + r4 + " resultCode=" + r5);
        if (r5 == (-1)) goto L5;
        return;
    L5:
        if (r6 == null) goto L8;
        String r7 = r6.getStringExtra("result_from");
        if (r7 == null) goto L8;
    L10:
        if (Intrinsics.areEqual(r7, "creation") == false) goto L19;
        setResult(r5, r6);
        tx9.d2 r8 = tx9.d2.a;
        if (r6 != null) goto L14;
    L16:
        boolean r9 = false;
    L17:
        JSONObject r1 = lp9.d.a();
        r8.getClass();
        tx9.d2.e(true, !r9, "creation", r1);
        finish();
        return;
    L14:
        if (r6.hasExtra("result.uri.list") != true) goto L16;
        r9 = true;
        goto L17
    L19:
        return;
    L8:
        r7 = "";
        goto L10
    }
}
