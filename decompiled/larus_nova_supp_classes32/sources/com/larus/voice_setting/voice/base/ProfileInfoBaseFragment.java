package com.larus.voice_setting.voice.base;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\u0006\u0010\u0018\u001a\u00020\u0013J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0013H\u0002J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0013J\u0006\u0010!\u001a\u00020\u0013J\u0006\u0010\"\u001a\u00020\u0005J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0005H\u0004J\b\u0010%\u001a\u00020\u0013H\u0016J\b\u0010&\u001a\u00020\u0013H\u0016J\b\u0010'\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020\u0013H\u0016J\b\u0010*\u001a\u00020\u0013H\u0016J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-H\u0016J\u0014\u0010.\u001a\u00020\u00132\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0017H\u0016J\u0014\u00100\u001a\u00020\u00132\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\r\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u00061"}, d2 = {"Lcom/larus/voice_setting/voice/base/ProfileInfoBaseFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "isCreate", NameKeys.UnloadStrategy_No_Strategy, "itemCount", NameKeys.UnloadStrategy_No_Strategy, "listener", "Landroid/view/View$OnLayoutChangeListener;", "resumeFromCreate", "handler", "Landroid/os/Handler;", "markEnterForeground", "getMarkEnterForeground", "()Z", "setMarkEnterForeground", "(Z)V", "setupLayoutChangeListener", NameKeys.UnloadStrategy_No_Strategy, "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "tag", NameKeys.UnloadStrategy_No_Strategy, "refreshAppbarLayoutScrollStatus", "scrollStatusChanged", "()Ljava/lang/Boolean;", "resetScrollStatusChanged", "scrollStatus", "enableScroll", "enable", "reset", "scrollToTop", "scrollToNormal", "isAppBarExpand", "setTabPagerSwipeEnabled", "enabled", "onPause", "onStop", "onResume", "onDestroyView", "onDestroy", "onLeaveMineTab", "onStateChange", "state", "Lcom/larus/voice_setting/voice/base/AppBarLayoutStateListener$State;", "onEnterMineTab", "previousPage", "updatePreviousPage", "flow-voice-setting-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ProfileInfoBaseFragment extends Fragment {
    public boolean d;
    public int e;
    public a f;
    public boolean g;
    public final Handler h;
    public boolean i;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ ProfileInfoBaseFragment a;

        public a(ProfileInfoBaseFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            ProfileInfoBaseFragment r10 = this.a;
            if (r10.d == false) goto L10;
            FLogger.a.i(r10.tag(), "[onLayoutChange][CREATE]");
            RecyclerView r11 = this.a.getRecyclerView();
            if (r11 == null) goto L9;
            RecyclerView.Adapter r12 = r11.getAdapter();
            if (r12 == null) goto L9;
            this.a.e = r12.getItemCount();
        L9:
            final ProfileInfoBaseFragment r13 = this.a;
            r13.h.post(new j0(r13));
            this.a.d = false;
            return;
        L10:
            com.larus.voice_setting.voice.base.a r14 = r10.getParentFragment();
            com.larus.voice_setting.voice.base.a r15 = null;
            if ((r14 instanceof com.larus.voice_setting.voice.base.a) == false) goto L13;
            com.larus.voice_setting.voice.base.a r16 = r14;
        L14:
            if (r16 == null) goto L16;
            Boolean r17 = Boolean.valueOf(r16.kt());
        L17:
            Boolean r18 = Boolean.TRUE;
            if (Intrinsics.areEqual(r17, r18) == false) goto L27;
            Lifecycle.State r19 = this.a.getViewLifecycleOwner().getLifecycle().getCurrentState();
            FLogger.a.i(this.a.tag(), "[onLayoutChange][RESET] state:" + r19);
            if (r19 != Lifecycle.State.RESUMED) goto L22;
            this.a.h.removeCallbacksAndMessages(null);
            final ProfileInfoBaseFragment r20 = this.a;
            r20.h.post(new j0(r20));
        L22:
            Fragment r21 = this.a.getParentFragment();
            if ((r21 instanceof com.larus.voice_setting.voice.base.a) == false) goto L25;
            r15 = (com.larus.voice_setting.voice.base.a) r21;
        L25:
            if (r15 == null) goto L47;
            r15.UM();
            return;
        L47:
            return;
        L27:
            RecyclerView r22 = this.a.getRecyclerView();
            if (r22 == null) goto L32;
            RecyclerView.Adapter r23 = r22.getAdapter();
            if (r23 == null) goto L32;
            int r24 = r23.getItemCount();
        L33:
            ProfileInfoBaseFragment r25 = this.a;
            if (r24 > r25.e) goto L36;
        L37:
            ProfileInfoBaseFragment r26 = this.a;
            if (r24 < r26.e) goto L40;
            return;
        L40:
            if (Intrinsics.areEqual(r26.W90(), r18) == false) goto L50;
        L41:
            FLogger.a.i(this.a.tag(), "[onLayoutChange][COUNT] item: " + this.a.e + ", total: " + r24);
            if (Intrinsics.areEqual(this.a.W90(), r18) == false) goto L44;
            this.a.Ol(false, true);
            return;
        L44:
            this.a.V90();
            return;
        L50:
            return;
        L36:
            if (Intrinsics.areEqual(r25.W90(), Boolean.FALSE) == true) goto L41;
        L32:
            r24 = 0;
            goto L33
        L16:
            r17 = null;
            goto L17
        L13:
            r16 = null;
            goto L14
        }
    }

    public void S90(String r1) {
    }

    public void T90() {
    }

    public void U90(AppBarLayoutStateListener.State r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public void Y90(String r1) {
    }

    public abstract RecyclerView getRecyclerView();

    public abstract String tag();

    public final void X90() {
        this.f = new a(this);
        RecyclerView r0 = getRecyclerView();
        if (r0 == null) goto L6;
        r0.addOnLayoutChangeListener(this.f);
        return;
    }

    public void onDestroy() {
        FLogger.a.i(tag(), "[onDestroy]");
        super.onDestroy();
    }

    public void onDestroyView() {
        FLogger.a.i(tag(), "[onDestroyView]");
        RecyclerView r0 = getRecyclerView();
        if (r0 == null) goto L5;
        r0.removeOnLayoutChangeListener(this.f);
    L5:
        this.d = true;
        this.e = 0;
        this.g = true;
        super.onDestroyView();
    }

    public void onPause() {
        FLogger.a.i(tag(), "[onPause]");
        Ol(false, true);
        super.onPause();
    }

    public void onResume() {
        FLogger.a.i(tag(), "[onResume]");
        super.onResume();
        if (this.g == true) goto L5;
        V90();
        return;
    L5:
        if (Intrinsics.areEqual(W90(), Boolean.FALSE) == false) goto L7;
        V90();
    L7:
        this.g = false;
    }

    public final void onStop() {
        FLogger.a.i(tag(), "[onStop]");
        super.onStop();
    }

    public ProfileInfoBaseFragment() {
        this.d = true;
        this.g = true;
        this.h = new Handler(Looper.getMainLooper());
    }

    public final void V90() {
        RecyclerView r0 = getRecyclerView();
        if (r0 == null) goto L7;
        RecyclerView.Adapter r1 = r0.getAdapter();
        if (r1 == null) goto L7;
        this.e = r1.getItemCount();
    L7:
        RecyclerView r2 = getRecyclerView();
        if (r2 == null) goto L55;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        RecyclerView.Adapter r3 = r2.getAdapter();
        if (r3 == null) goto L12;
        int r4 = r3.getItemCount();
    L13:
        boolean r5 = true;
        Boolean r8 = null;
        if ((r2.getLayoutManager() instanceof LinearLayoutManager) == false) goto L33;
        LinearLayoutManager r6 = r2.getLayoutManager();
        if ((r6 instanceof LinearLayoutManager) == false) goto L18;
        LinearLayoutManager r7 = r6;
    L19:
        if (r7 == null) goto L52;
        int r9 = r7.findLastCompletelyVisibleItemPosition();
        FLogger.a.i("checkEnableScroll", "[refreshAppbarLayoutScrollStatus]LinearLayoutManager last: " + r9 + ", total: " + r4);
        if (r9 != (-1)) goto L27;
        if (r4 > 0) goto L25;
        r5 = false;
    L25:
        Boolean r10 = Boolean.valueOf(r5);
    L31:
        r8 = r10;
        goto L52
    L27:
        if (r9 < (r4 - 1)) goto L30;
        r5 = false;
    L30:
        r10 = Boolean.valueOf(r5);
    L52:
        if (r8 == null) goto L56;
        Ol(r8.booleanValue(), false);
        return;
    L56:
        return;
    L18:
        r7 = null;
        goto L19
    L33:
        if ((r2.getLayoutManager() instanceof StaggeredGridLayoutManager) == false) goto L52;
        StaggeredGridLayoutManager r11 = r2.getLayoutManager();
        if ((r11 instanceof StaggeredGridLayoutManager) == false) goto L37;
        StaggeredGridLayoutManager r12 = r11;
    L38:
        if (r12 == null) goto L52;
        int[] r13 = r12.findLastCompletelyVisibleItemPositions(null);
        if (r13 == null) goto L52;
        int r14 = ArraysKt.last(r13);
        FLogger.a.i("checkEnableScroll", "[refreshAppbarLayoutScrollStatus]StaggeredGridLayoutManager last: " + r14 + ", total: " + r4);
        if (r14 != (-1)) goto L48;
        if (r4 > 0) goto L46;
        r5 = false;
    L46:
        r10 = Boolean.valueOf(r5);
        goto L31
    L48:
        if (r14 < (r4 - 1)) goto L51;
        r5 = false;
    L51:
        r10 = Boolean.valueOf(r5);
        goto L31
    L37:
        r12 = null;
        goto L38
    L12:
        r4 = 0;
        goto L13
    }

    public final Boolean W90() {
        com.larus.voice_setting.voice.base.a r0 = getParentFragment();
        if ((r0 instanceof com.larus.voice_setting.voice.base.a) == false) goto L5;
        com.larus.voice_setting.voice.base.a r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return Boolean.valueOf(r1.tz());
    L5:
        r1 = null;
        goto L6
    }

    public final void Ol(boolean r3, boolean r4) {
        com.larus.voice_setting.voice.base.a r0 = getParentFragment();
        if ((r0 instanceof com.larus.voice_setting.voice.base.a) == false) goto L5;
        com.larus.voice_setting.voice.base.a r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.Ol(r3, r4);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
