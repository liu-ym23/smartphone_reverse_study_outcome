package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.face.FaceEmptyView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 K2\u00020\u0001:\u0002JKB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0006\u0010(\u001a\u00020&J\u0010\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0002J\b\u0010.\u001a\u00020&H\u0002J\b\u0010/\u001a\u00020&H\u0002J\b\u00100\u001a\u00020&H\u0002J\b\u00101\u001a\u00020&H\u0002J\b\u00102\u001a\u00020&H\u0002J\u0016\u00103\u001a\u00020&2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001105H\u0002J\b\u00106\u001a\u00020&H\u0016J\"\u00107\u001a\u00020&2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u001e\u0010=\u001a\u00020&2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?052\u0006\u0010@\u001a\u00020\u0019H\u0002J\u0010\u0010A\u001a\u00020&2\b\u0010B\u001a\u0004\u0018\u00010\u0006J\u0010\u0010C\u001a\u00020&2\b\u0010D\u001a\u0004\u0018\u00010\bJ\b\u0010E\u001a\u00020&H\u0002J\b\u0010F\u001a\u00020&H\u0002J\b\u0010G\u001a\u00020&H\u0002J\n\u0010H\u001a\u0004\u0018\u00010\bH\u0002J\n\u0010I\u001a\u0004\u0018\u00010\u0006H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/face/sticker/FacePageNewFragment2;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "mRefOnOperationListener", "Ljava/lang/ref/WeakReference;", "Lcom/ss/android/lark/keyboard/plugin/tool/face/OnOperationListener;", "mRefStickerDependency", "Lcom/ss/android/lark/keyboard/plugin/tool/face/sticker/IStickerDependency;", "mRootView", "Landroid/view/View;", "mEmptyView", "Lcom/ss/android/lark/keyboard/plugin/tool/face/FaceEmptyView;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mDatas", "", "Lcom/ss/android/lark/chat/entity/sticker/Sticker;", "mAdapter", "Lcom/ss/android/lark/keyboard/plugin/tool/face/sticker/FaceNewAdapter;", "getMAdapter", "()Lcom/ss/android/lark/keyboard/plugin/tool/face/sticker/FaceNewAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "isNeedLoadSticker", "", "mPushStickerListener", "Lcom/ss/android/lark/keyboard/plugin/tool/face/IPushStickerListener;", "mPushStickerListenerWrapper", "Lcom/ss/android/lark/keyboard/plugin/tool/face/sticker/FacePageNewFragment2$PushStickerListenerWrapper;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onPanelShow", "createRootView", "context", "Landroid/content/Context;", "initWidget", "initListener", "initData", "initPush", "updateContentView", "loadStickers", "forceLoadStickers", "initStickerList", "stickers", "", "onDestroyView", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "uploadStickers", "photos", "", "keepOriginal", "setOnOperationListener", "onOperationListener", "setStickerDependency", "stickerDependency", "setFaceSelectedListener", "setLocalStickerFileInfoProvider", "setGlideStickerLoader", "getStickerDependency", "getOnOperationListener", "PushStickerListenerWrapper", "Companion", "keyboard-biz-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FacePageNewFragment2 extends BaseFragment {
    public static final /* synthetic */ int n = 0;
    public WeakReference<com.ss.android.lark.keyboard.plugin.tool.face.b> d;
    public WeakReference<k> e;
    public View f;
    public FaceEmptyView g;
    public RecyclerView h;
    public final List<Sticker> i;
    public final Lazy j;
    public volatile boolean k;
    public final c l;
    public b m;

    public static final class a {
    }

    public static final class b {
        public b(c r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            new WeakReference(r2);
        }
    }

    public static final class c {
        public c() {
        }
    }

    static {
    }

    public final FaceNewAdapter T90() {
        return (FaceNewAdapter) this.j.getValue();
    }

    public final k U90() {
        WeakReference<k> r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public final void Y90() {
        ViewGroup r6 = null;
        if (((ArrayList) this.i).size() != 1) goto L12;
        FaceEmptyView r0 = this.g;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
        r0 = null;
    L7:
        r0.setVisibility(0);
        ViewGroup r1 = this.h;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L11:
        r6.setVisibility(8);
        return;
    L10:
        r6 = r1;
        goto L11
    L12:
        FaceEmptyView r2 = this.g;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
        r2 = null;
    L15:
        r2.setVisibility(8);
        ViewGroup r3 = this.h;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L19:
        r6.setVisibility(0);
        return;
    L18:
        r6 = r3;
        goto L19
    }

    public final void onDestroyView() {
        Log.i("FacePageNewFragment2", "onDestroyView");
        k r0 = U90();
        if (r0 == null) goto L5;
        r0.e();
    L5:
        FaceNewAdapter r1 = T90();
        r1.g = null;
        r1.h = null;
        r1.f = null;
        super.onDestroyView();
    }

    public FacePageNewFragment2() {
        this.i = new ArrayList();
        this.j = LazyKt.lazy(new FacePageNewFragment2$mAdapter$2(this));
        this.l = new c();
    }

    public final void V90() {
        if (isAdded() == false) goto L9;
        FaceNewAdapter r0 = T90();
        h r1 = new h(this);
        if (r0.g != null) goto L10;
        r0.g = r1;
        return;
    L10:
        return;
    }

    public final void W90() {
        if (isAdded() == false) goto L9;
        FaceNewAdapter r0 = T90();
        i r1 = new i(this);
        if (r0.h != null) goto L10;
        r0.h = r1;
        return;
    L10:
        return;
    }

    public final void X90() {
        if (isAdded() == false) goto L9;
        FaceNewAdapter r0 = T90();
        j r1 = new j(this);
        if (r0.f != null) goto L10;
        r0.f = r1;
        return;
    L10:
        return;
    }

    public static final void S90(FacePageNewFragment2 r2, List r3) {
        ((ArrayList) r2.i).clear();
        Sticker r0 = new Sticker();
        ((ArrayList) r2.i).add(r0);
        ArrayList r1 = (ArrayList) r2.i;
        r1.addAll(r3);
        r2.T90().setData(r2.i);
        r2.Y90();
    }

    public final void Z90(final List<String> r5, final boolean r6) {
        k r0 = U90();
        if (r0 != null) goto L7;
        Log.i("FacePageNewFragment2", "uploadStickers called. stickerDependency is null.");
        return;
    L7:
        if (r5.isEmpty() == false) goto L9;
        return;
    L9:
        ((BaseFragment) this).mCallbackManager.wrapAndAddGetDataCallback(new FacePageNewFragment2$uploadStickers$uiGetDataCallback$1(r5, this, r6));
        int r7 = r5.size();
        int r1 = 0;
    L10:
        if (r1 >= r7) goto L15;
        Sticker r2 = new Sticker();
        r2.setStickerId("-1");
        ((ArrayList) this.i).add(r2);
        String r3 = (String) ListProtector.get(r5, r1);
        if (TextUtils.isEmpty(r3) == true) goto L14;
        VFSFile r4 = VFSFiles.b.i(r3);
        String[] r8 = FileUtils.a;
        r4.length();
    L14:
        r1 = r1 + 1;
        goto L10
    L15:
        T90().setData(this.i);
        r0.a();
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Log.i("FacePageNewFragment2", "onViewCreated");
        if (this.k == false) goto L9;
        k r6 = U90();
        if (r6 == null) goto L10;
        Log.i("FacePageNewFragment2", "loadStickers");
        this.k = false;
        final Ref.BooleanRef r7 = new Ref.BooleanRef();
        final long r0 = SystemClock.elapsedRealtime();
        new FacePageNewFragment2$loadStickers$1(r0, r7, this);
        r6.g();
        final long r1 = SystemClock.elapsedRealtime();
        new FacePageNewFragment2$loadStickers$2(r1, r7, this);
        r6.g();
        return;
    L10:
        return;
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r3, r4, r5);
        if (r4 == (-1)) goto L5;
        return;
    L5:
        boolean r6 = true;
        if (r5 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == true) goto L14;
        return;
    L14:
        if (r3 != 1024) goto L24;
        ArrayList<String> r7 = r5.getStringArrayListExtra("SELECTED_PHOTOS");
        if (r7 != null) goto L18;
    L20:
        r6 = false;
    L21:
        if (r6 == false) goto L25;
        Z90(r7, r5.getBooleanExtra("KEEP_ORIGIN_PHOTO", false));
        return;
    L25:
        return;
    L18:
        if ((!r7.isEmpty()) != true) goto L20;
    L24:
        return;
    L8:
        if (r5.getBooleanExtra("KEY_FOR_SEND", false) != true) goto L10;
        r1 = true;
        goto L11
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        Log.i("FacePageNewFragment2", "onCreateView");
        if (this.f != null) goto L17;
        Context r10 = r7.getContext();
        LinearLayout r11 = new LinearLayout(r10);
        r11.setId(2131384813);
        ViewGroup.LayoutParams r0 = new ViewGroup.LayoutParams(-1, -1);
        r11.setOrientation(1);
        r11.setLayoutParams(r0);
        FaceEmptyView r1 = new FaceEmptyView(r10);
        r1.setId(2131372047);
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-2, -2);
        r3.gravity = 17;
        r3.topMargin = UIUtils.dp2px(r10, 48.0f);
        r1.setGravity(17);
        r11.addView(r1, r3);
        this.h = new RecyclerView(r10);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, -1);
        ViewGroup r4 = this.h;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r4 = null;
    L7:
        r4.setVisibility(8);
        FrameLayout r5 = new FrameLayout(r10);
        View r12 = this.h;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r12 = null;
    L10:
        r5.addView(r12, r2);
        r11.addView(r5, new LinearLayout.LayoutParams(-1, -1));
        this.f = r11;
        this.g = (FaceEmptyView) r11.findViewById(2131372047);
        final Context r13 = getContext();
        GridLayoutManager r14 = new FacePageNewFragment2$initWidget$layoutManager$1(r13);
        RecyclerView r15 = this.h;
        if (r15 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r15 = null;
    L13:
        r15.setLayoutManager(r14);
        RecyclerView r16 = this.h;
        if (r16 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r16 = null;
    L16:
        r16.setAdapter(T90());
    L17:
        FaceEmptyView r17 = this.g;
        if (r17 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
        r17 = null;
    L20:
        r17.setOnClickListener(new g(this));
        V90();
        X90();
        W90();
        T90().setData(this.i);
        Y90();
        if (this.m != null) goto L23;
        this.m = new b(this.l);
    L23:
        k r18 = U90();
        if (r18 == null) goto L26;
        r18.e();
        r18.f();
    L26:
        View r19 = this.f;
        if (r19 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    L30:
        return r19;
    }
}
