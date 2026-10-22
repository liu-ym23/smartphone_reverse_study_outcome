package com.ss.android.lark.filedetail.impl.folder.manage.page;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.framework.utils.FileUtils;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.chat.entity.favorite.FavoriteMessageInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.filedetail.dto.FileDetailLaunchParams;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.filedetail.impl.detail.FileDetailController;
import com.ss.android.lark.filedetail.impl.folder.manage.entity.FileType;
import com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package.ExtractPackageFragment;
import com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.FileListFragment;
import com.ss.android.lark.filedetail.impl.folder.manage.page.title.FolderTitleFragment;
import com.ss.android.lark.filedetail.impl.folder.manage.page.title.e;
import com.ss.android.lark.filedetail.impl.folder.manage.service.ExtractConfig;
import com.ss.android.lark.filedetail.impl.folder.manage.service.FileConfigValue;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\bH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\bH\u0002J\b\u0010$\u001a\u00020\tH\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\tH\u0002J\b\u0010)\u001a\u00020\u0018H\u0014J\u001a\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR-\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/page/FolderManageActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "<init>", "()V", "titleFragment", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/title/FolderTitleFragment;", "contentMap", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/BaseFolderContentFragment;", "launchParams", "Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;", "getLaunchParams", "()Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;", "launchParams$delegate", "Lkotlin/Lazy;", "displayParams", "Lkotlin/Triple;", BuildConfig.FLAVOR, "getDisplayParams", "()Lkotlin/Triple;", "displayParams$delegate", "curType", "onCreate", BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "initContentFragments", "switchContentFragment", "initLaunchParams", "onBackPressed", "getFilePreviewType", Keys.API_RETURN_KEY_DATA, "Lcom/ss/android/lark/filedetail/impl/folder/manage/entity/FilePreviewInfo;", "getContentFragment", "contentType", "createFileListFragment", "getFileDetailLaunchPrams", "Lcom/ss/android/lark/filedetail/dto/FileDetailLaunchParams;", "params", "createExtractPackagesFragment", "onDestroy", "initDisplayParam", "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderManageActivity extends BaseFragmentActivity {
    public static final /* synthetic */ int f = 0;
    public FolderTitleFragment a;
    public final Map<Integer, BaseFolderContentFragment> b;
    public final Lazy c;
    public final Lazy d;
    public int e;

    public static final class a {
    }

    public static final class b implements e {
        public final /* synthetic */ FolderManageActivity a;

        public b(FolderManageActivity r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.title.e
        public final void a(nfb.a r3) {
            Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
            FolderManageActivity r0 = this.a;
            FolderManageActivity.B1(r0, FolderManageActivity.A1(r0, r3));
            FolderManageActivity r1 = this.a;
            r1.C1(r1.e).S90(r3);
        }

        @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.title.e
        public final void b(nfb.a r3) {
            Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
            Set<String> r0 = FileDetailController.a;
            FolderManageActivity r1 = this.a;
            int r2 = FolderManageActivity.f;
            FolderManageLaunchParams r4 = r1.D1();
            if (r4 == null) goto L7;
            FileDetailController.c(FolderManageActivity.z1(r1, r3, r4));
            return;
        L7:
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    static {
    }

    public final FolderManageLaunchParams D1() {
        return (FolderManageLaunchParams) this.c.getValue();
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(FolderManageActivity.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
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
        r1.addFlags(Bridge.TRANSFER_MAX_SIZE);     // Catch: Throwable -> L42
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

    public final void onBackPressed() {
        FolderTitleFragment r0 = this.a;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        return;
    L10:
        if (C1(this.e).onBackPressed() == false) goto L12;
        return;
    L12:
        finish();
        return;
    L5:
        if (r0.onBackPressed() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(FolderManageActivity.class.getName()));
    L5:
        super.onDestroy();
        ((LinkedHashMap) this.b).clear();
        this.a = null;
    }

    public FolderManageActivity() {
        this.b = new LinkedHashMap();
        this.c = LazyKt.lazy(new FolderManageActivity$launchParams$2(this));
        this.d = LazyKt.lazy(new FolderManageActivity$displayParams$2(this));
        this.e = -1;
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

    public final BaseFolderContentFragment C1(int r4) {
        Map<Integer, BaseFolderContentFragment> r0 = this.b;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        BaseFolderContentFragment r2 = (BaseFolderContentFragment) r1.get(Integer.valueOf(r4));
        if (r2 == null) goto L5;
    L17:
        Integer r5 = Integer.valueOf(r4);
        this.b.put(r5, r2);
        return r2;
    L5:
        if (r4 != 0) goto L11;
        FolderManageLaunchParams r3 = D1();
        if (r3 == null) goto L10;
        BaseFolderContentFragment r6 = new ExtractPackageFragment(r3, new com.ss.android.lark.filedetail.impl.folder.manage.page.a(this));
    L14:
        r2 = r6;
        goto L17
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    L11:
        FolderManageLaunchParams r7 = D1();
        if (r7 == null) goto L16;
        r6 = new FileListFragment(r7, new com.ss.android.lark.filedetail.impl.folder.manage.page.b(this));
        goto L14
    L16:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r7) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r7);
        setContentView(2131558481);
        if (D1() != null) goto L13;
        Log.i("FolderManageActivityV2", "launch params is null");
        finish();
        return;
    L13:
        FolderManageLaunchParams r8 = D1();
        int r0 = 1;
        if (r8 == null) goto L16;
        int r9 = r8.r;
    L17:
        this.e = r9;
        if (r9 == 0) goto L21;
        r0 = 0;
    L21:
        BaseFolderContentFragment r1 = C1(r0);
        BaseFolderContentFragment r10 = C1(r9);
        FragmentTransaction r2 = getSupportFragmentManager().beginTransaction();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r10, r3, null, 2131367833) == true) goto L26;
        r2 = r2.add(2131367833, r10);
    L26:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r1, r3, null, 2131367833) == true) goto L29;
        r2 = r2.add(2131367833, r1);
    L29:
        r2.hide(r1).show(r10).commit();
        if (findViewById(2131388881) == null) goto L43;
        FolderManageLaunchParams r4 = D1();
        if (r4 == null) goto L39;
        FolderTitleFragment r5 = new FolderTitleFragment(r4, new b(this));
        FragmentTransaction r6 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r5, r3, null, 2131388881) == true) goto L37;
        r6 = r6.add(2131388881, r5);
    L37:
        r6.commit();
        this.a = r5;
        return;
    L39:
        throw new IllegalArgumentException("Required value was null.".toString());
    L43:
        return;
    L16:
        r9 = 1;
        goto L17
    }

    public static final int A1(FolderManageActivity r2, nfb.a r3) {
        Iterator r4 = ((LinkedHashMap) r2.b).entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) r4.next();
        if (((BaseFolderContentFragment) r0.getValue()).T90(r3) == false) goto L4;
        return ((Number) r0.getKey()).intValue();
    L9:
        if (r3.getType() != FileType.FOLDER) goto L11;
        return 1;
    L11:
        FileConfigValue r5 = ExtractConfig.a;
        if (ExtractConfig.a(r3.d, r3.c) == false) goto L14;
        return 0;
    L14:
        return 2;
    }

    public static final void B1(FolderManageActivity r1, int r2) {
        int r0 = r1.e;
        if (r0 == r2) goto L7;
        r1.e = r2;
        BaseFolderContentFragment r3 = r1.C1(r0);
        BaseFolderContentFragment r4 = r1.C1(r2);
        r1.getSupportFragmentManager().beginTransaction().hide(r3).show(r4).commit();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final FileDetailLaunchParams z1(FolderManageActivity r7, nfb.a r8, FolderManageLaunchParams r9) {
        r7.getClass();
        FileContent r0 = new FileContent();
        r0.setName(r8.c);
        r0.setKey(r8.a);
        r0.setFilePath(r8.h);
        boolean r2 = false;
        if (r8.h.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        FileState r3 = FileState.DOWNLOAD;
    L9:
        r0.setFileState(r3);
        r0.setMime(FileUtils.p(r8.c));
        r0.setSize(r8.d);
        r0.setFilePreviewStage(r8.j);
        r9.s = r8.k;
        r9.t = r8.l;
        String r10 = r9.i;
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r0, "fileContent");
        int r4 = r9.e;
        switch(r4) {
            case 0: goto L16;
            case 1: goto L16;
            case 2: goto L16;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L17;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L16;
            default: goto L17;
        };
    L12:
        int r5 = 4;
    L19:
        if (r9.f != 3) goto L22;
        r5 = 7;
    L22:
        if (r4 != 8) goto L24;
        boolean r6 = true;
    L25:
        FileDetailLaunchParams.a r11 = new FileDetailLaunchParams.a(r7, r0, r9.a);
        String r12 = r9.b;
        Intrinsics.checkNotNullParameter(r12, "chatId");
        r11.d = r12;
        r11.j = r5;
        r11.h = r9.c;
        String r13 = r9.i;
        String r14 = BuildConfig.FLAVOR;
        if (r13 != null) goto L28;
        r13 = BuildConfig.FLAVOR;
    L28:
        Intrinsics.checkNotNullParameter(r13, "id");
        r11.n = r13;
        String r15 = r9.j;
        if (r15 == null) goto L32;
        r14 = r15;
    L32:
        Intrinsics.checkNotNullParameter(r14, "chatId");
        r11.o = r14;
        r11.k = r6;
        r11.l = r9.d;
        r11.s = r9.f;
        r11.m = (r11.m | 4) ^ 4;
        r11.c(r9.p);
        r11.b(r9.q);
        r11.y = r9.s;
        r11.z = r9.u;
        r11.A = r9.t;
        r11.u = true;
        r11.B = r9.w;
        Message r16 = r9.m;
        if (r16 == null) goto L35;
        Intrinsics.checkNotNullParameter(r16, "message");
        r11.b = r16;
    L38:
        FavoriteMessageInfo r17 = r9.o;
        if (r17 == null) goto L41;
        Intrinsics.checkNotNullParameter(r17, "message");
        r11.c = r17;
    L41:
        if (r10 != null) goto L43;
    L44:
        r2 = true;
    L45:
        if (r2 == true) goto L49;
        if (r10 == null) goto L49;
        Intrinsics.checkNotNullParameter(r10, "originMergeForwardId");
        r11.w = r10;
    L49:
        return r11.a();
    L43:
        if (r10.length() != 0) goto L45;
    L35:
        FavoriteMessageInfo r18 = r9.o;
        if (r18 == null) goto L38;
        Message r19 = r18.getSourceMessage();
        Intrinsics.checkNotNullParameter(r19, "message");
        r11.b = r19;
        goto L38
    L24:
        r6 = false;
        goto L25
    L13:
        r5 = 3;
        goto L19
    L14:
        r5 = 5;
        goto L19
    L15:
        r5 = 6;
        goto L19
    L16:
        r5 = 1;
        goto L19
    L17:
        r5 = 0;
        goto L19
    L8:
        r3 = FileState.DONE;
        goto L9
    L5:
        r1 = false;
        goto L6
    }
}
