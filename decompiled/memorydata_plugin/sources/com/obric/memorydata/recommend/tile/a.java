package com.obric.memorydata.recommend.tile;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.settings.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.k;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0017J\b\u0010\u000e\u001a\u00020\tH\u0003J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J \u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0016H\u0002J \u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0016H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/recommend/tile/InternalScreenObservationTileService;", "Lcom/obric/memorydata/recommend/tile/IScreenObservationTileDelegate;", "<init>", "()V", "service", "Landroid/service/quicksettings/TileService;", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "onCreate", "", "onStartListening", "onStopListening", "onDestroy", "onClick", "showDisableDialog", "onTileAdded", "onTileRemoved", "updateTileAppearance", "isEnabled", "", "isSecure", "getTileTitleSafe", "", "svc", "getTileSubtitleSafe", "enabled", "resIdByName", "", "type", ActivityLifecycle.NAME, "safeGetStringByName", "fallback", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements IScreenObservationTileDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0680a f12637a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TileService f12638b;
    private al c;

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.tile.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/recommend/tile/InternalScreenObservationTileService$Companion;", "", "<init>", "()V", "TAG", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0680a {
        private C0680a() {
        }

        public /* synthetic */ C0680a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12637a = new C0680a(null);
    }

    public a() {
    }

    private final int a(TileService r3, String r4, String r5) {
        TileService r6 = (TileService) ZeusTransformUtils.wrapperContextForParams(r3, TileService.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r7 = Result.m1421constructorimpl(Integer.valueOf(ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin"), r5, r4, r6.getPackageName(), "com.obric.memorydata.plugin")));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r7) == false) goto L11;
        r7 = 0;
    L11:
        return ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue();
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final String a(TileService r5) {
        TileService r6 = (TileService) ZeusTransformUtils.wrapperContextForParams(r5, TileService.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        a r1 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r2 = Result.m1421constructorimpl(r6.getString(ZeusTransformUtils.mapRes(R.string.host_screen_observation_tile_title, TypedValues.Custom.S_STRING, "host_screen_observation_tile_title")));     // Catch: Throwable -> L5
    L8:
        if (Result.m1424exceptionOrNullimpl(r2) == null) goto L12;
        r2 = b(r6, "screen_observation_tile_title", "屏幕内容");
    L12:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final String a(TileService r5, boolean r6, boolean r7) {
        TileService r8 = (TileService) ZeusTransformUtils.wrapperContextForParams(r5, TileService.class, "com.obric.memorydata.plugin");
        if (r6 == false) goto L15;
        if (r7 == false) goto L30;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L7
        a r10 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        Object r11 = Result.m1421constructorimpl(r8.getString(ZeusTransformUtils.mapRes(R.string.host_screen_observation_tile_secure, TypedValues.Custom.S_STRING, "host_screen_observation_tile_secure")));     // Catch: Throwable -> L7
    L10:
        if (Result.m1424exceptionOrNullimpl(r11) == null) goto L31;
        r11 = b(r8, "screen_observation_tile_secure", "");
    L31:
        return (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin");
    L7:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L30:
        return "";
    L15:
        if (com.obric.memorydata.recommend.feature.a.f12505a.e() == false) goto L32;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L18
        a r14 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        Object r15 = Result.m1421constructorimpl(r8.getString(ZeusTransformUtils.mapRes(R.string.host_screen_observation_tile_restore_open, TypedValues.Custom.S_STRING, "host_screen_observation_tile_restore_open")));     // Catch: Throwable -> L18
    L21:
        if (Result.m1424exceptionOrNullimpl(r15) == null) goto L24;
        r15 = b(r8, "screen_observation_tile_restore_open", "");
    L24:
        Intrinsics.checkNotNullExpressionValue(r15, "getOrElse(...)");
        return com.obric.memorydata.recommend.feature.a.f12505a.f() + ((String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin"));
    L18:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L21
    L32:
        return "";
    }

    private final void a() {
        TileService r1 = this.f12638b;
        if (r1 != null) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationTileService", "showDisableDialog", false, 4, null);
        Intent r2 = new Intent("com.obric.memorydata.action.DISABLE_SCREEN_OBSERVATION");
        r2.setPackage(r1.getPackageName());
        r2.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationTileService", "Build.VERSION.SDK_INT: " + Build.VERSION.SDK_INT, false, 4, null);
        if (Build.VERSION.SDK_INT < 34) goto L19;
        PendingIntent r3 = PendingIntent.getActivity((Context) ZeusTransformUtils.preCheckCast(r1, Context.class, "com.obric.memorydata.plugin"), 0, r2, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L10
        a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Object r6 = Result.m1421constructorimpl(TileService.class.getMethod("startActivityAndCollapse", new Class[]{PendingIntent.class}).invoke(r1, new Object[]{r3}));     // Catch: Throwable -> L10
    L13:
        if (Result.m1424exceptionOrNullimpl(r6) != null) goto L23;
    L18:
        Result.m1420boximpl(r6);
        return;
    L23:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L16
        a r11 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        r3.send();     // Catch: Throwable -> L16
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L10:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    L19:
        r1.startActivityAndCollapse(r2);
    }

    public static final /* synthetic */ void a(a r0, boolean r1, boolean r2) {
        r0.a(r1, r2);
    }

    private final void a(boolean r14, boolean r15) {
        TileService r2 = this.f12638b;
        if (r2 != null) goto L5;
        return;
    L5:
        Tile r3 = r2.getQsTile();
        if (r3 != null) goto L8;
        return;
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationTileService", "updateTileAppearance: " + r14 + ' ' + r15, false, 4, null);
        if (r14 == false) goto L11;
        int r4 = 2;
    L12:
        r3.setState(r4);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L20
        a r6 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r15 == false) goto L17;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        int r8 = ZeusTransformUtils.mapRes(R.drawable.host_ic_recommend_memory_tile_eye_silent, "drawable", "host_ic_recommend_memory_tile_eye_silent");     // Catch: Throwable -> L20
    L18:
        r3.setIcon(Icon.createWithResource(r7, r8));     // Catch: Throwable -> L20
        Object r9 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
        if (r10 == null) goto L37;
        RunLog.INSTANCE.error("ScreenObservationTileService", "set icon via R failed, fallback by name", r10);
        if (r15 == false) goto L27;
        String r11 = "ic_recommend_memory_tile_eye_silent";
    L28:
        int r0 = a(r2, "drawable", r11);
        if (r0 == 0) goto L37;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L32
        a r13 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        r3.setIcon(Icon.createWithResource((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin"), r0));     // Catch: Throwable -> L32
        Object r1 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L34:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r1);
        if (r16 == null) goto L37;
        RunLog.INSTANCE.error("ScreenObservationTileService", "set icon fallback failed", r16);
    L32:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L34
    L27:
        r11 = "ic_recommend_memory_tile_eye";
    L37:
        r3.setLabel((CharSequence) ZeusTransformUtils.preCheckCast(a(r2), CharSequence.class, "com.obric.memorydata.plugin"));
        String r18 = a(r2, r14, r15);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationTileService", "subtitle: " + r18, false, 4, null);
        if (Build.VERSION.SDK_INT < 29) goto L48;
        r3.setSubtitle((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"));
    L48:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L42
        a r110 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        r3.updateTile();     // Catch: Throwable -> L42
        Object r111 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L42
    L44:
        Throwable r112 = Result.m1424exceptionOrNullimpl(r111);
        if (r112 == null) goto L54;
        RunLog.INSTANCE.error("ScreenObservationTileService", "updateTile failed", r112);
        return;
    L54:
        return;
    L42:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L44
    L17:
        r7 = (Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        r8 = ZeusTransformUtils.mapRes(R.drawable.host_ic_recommend_memory_tile_eye, "drawable", "host_ic_recommend_memory_tile_eye");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    L11:
        r4 = 1;
        goto L12
    }

    private final String b(TileService r3, String r4, String r5) {
        TileService r6 = (TileService) ZeusTransformUtils.wrapperContextForParams(r3, TileService.class, "com.obric.memorydata.plugin");
        int r7 = a(r6, TypedValues.Custom.S_STRING, r4);
        if (r7 != 0) goto L14;
        return r5;
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        Object r8 = Result.m1421constructorimpl(r6.getString(r7));     // Catch: Throwable -> L7
    L9:
        Object r9 = r5;
        if (Result.m1424exceptionOrNullimpl(r8) != null) goto L13;
        r9 = r8;
    L13:
        return (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin");
    L7:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public void onClick() {
        TileService r1 = this.f12638b;
        if (r1 != null) goto L5;
        return;
    L5:
        boolean r2 = ((Boolean) ZeusTransformUtils.preCheckCast(t.f12630a.e().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationTileService", "delegate onClick: " + r2, false, 4, null);
        if (r2 == false) goto L9;
        a();
        return;
    L9:
        if (t.f12630a.p() == false) goto L11;
        com.obric.memorydata.recommend.feature.a.f12505a.c();
        return;
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationTileService", "Build.VERSION.SDK_INT: " + Build.VERSION.SDK_INT, false, 4, null);
        Intent r3 = new Intent("com.obric.memorydata.action.SCREEN_OBSERVATION_MEMORY_SETTINGS");
        r3.setPackage(r1.getPackageName());
        r3.addCategory("android.intent.category.DEFAULT");
        r3.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (Build.VERSION.SDK_INT < 34) goto L25;
        PendingIntent r4 = PendingIntent.getActivity((Context) ZeusTransformUtils.preCheckCast(r1, Context.class, "com.obric.memorydata.plugin"), 0, r3, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L16
        a r6 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Object r7 = Result.m1421constructorimpl(TileService.class.getMethod("startActivityAndCollapse", new Class[]{PendingIntent.class}).invoke(r1, new Object[]{r4}));     // Catch: Throwable -> L16
    L19:
        if (Result.m1424exceptionOrNullimpl(r7) != null) goto L29;
    L24:
        Result.m1420boximpl(r7);
        return;
    L29:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L22
        a r11 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        r4.send();     // Catch: Throwable -> L22
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L16:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    L25:
        r1.startActivityAndCollapse(r3);
    }

    public void onCreate(TileService r7) {
        TileService r8 = (TileService) ZeusTransformUtils.wrapperContextForParams(r7, TileService.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "service");
        this.f12638b = r8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationTileService", "delegate onCreate", false, 4, null);
    }

    public void onDestroy() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationTileService", "delegate onDestroy", false, 4, null);
        al r0 = this.c;
        if (r0 == null) goto L5;
        am.a(r0, null, 1, null);
    L5:
        this.c = null;
        this.f12638b = null;
    }

    public void onStartListening() {
        if (this.f12638b != null) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationTileService", "delegate onStartListening", false, 4, null);
        al r0 = this.c;
        if (r0 == null) goto L8;
        am.a(r0, null, 1, null);
    L8:
        al r1 = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        k.b(k.f((i) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.feature.a.f12505a.a(), i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new InternalScreenObservationTileService$onStartListening$1(this, null), Function2.class, "com.obric.memorydata.plugin")), r1);
        k.b(k.f((i) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.feature.a.f12505a.b(), i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new InternalScreenObservationTileService$onStartListening$2(this, null), Function2.class, "com.obric.memorydata.plugin")), r1);
        this.c = r1;
        a(((Boolean) ZeusTransformUtils.preCheckCast(t.f12630a.e().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), ((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.feature.a.f12505a.b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
    }

    public void onStopListening() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationTileService", "delegate onStopListening", false, 4, null);
        al r0 = this.c;
        if (r0 == null) goto L5;
        am.a(r0, null, 1, null);
    L5:
        this.c = null;
    }

    public void onTileAdded() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationTileService", "delegate onTileAdded", false, 4, null);
        a(((Boolean) ZeusTransformUtils.preCheckCast(t.f12630a.e().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), ((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.feature.a.f12505a.b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
    }

    public void onTileRemoved() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationTileService", "delegate onTileRemoved", false, 4, null);
    }
}
