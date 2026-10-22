package com.ss.android.lark.keyboard.plugin.tool.face;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.face.sticker.FacePageNewFragment2;
import com.ss.android.lark.keyboard.plugin.tool.face.sticker.StickerPageFragment;
import com.ss.android.lark.reaction.widget.emojipanel.EmojiPageNewFragment2;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/face/FacePagerNewAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "fragmentList", "", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "mStickerDependency", "Lcom/ss/android/lark/keyboard/plugin/tool/face/sticker/IStickerDependency;", "mOperationListener", "Lcom/ss/android/lark/keyboard/plugin/tool/face/OnOperationListener;", "mEmojiOperationListener", "Lcom/ss/android/lark/reaction/widget/emojipanel/OnEmojiOperationListener;", "getCount", "", "getItem", "position", "getItemPosition", "object", "", "saveState", "Landroid/os/Parcelable;", "notifyDataSetChanged", "", "setStickerDependency", "stickerDependency", "setOnOperationListener", "onOperationListener", "setOnEmojiOperationListener", "onEmojiOperationListener", "keyboard-biz-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FacePagerNewAdapter extends FragmentStatePagerAdapter {
    public final List<Fragment> a;
    public com.ss.android.lark.reaction.widget.emojipanel.c b;

    public final int getItemPosition(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "object");
        return -2;
    }

    public final int getCount() {
        return this.a.size();
    }

    public final void notifyDataSetChanged() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        super/*androidx.viewpager.widget.PagerAdapter*/.notifyDataSetChanged();     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final Parcelable saveState() {
        Parcelable r0 = super.saveState();
        if (r0 != null) goto L5;
        return null;
    L5:
        Bundle r1 = (Bundle) r0;
        r1.putParcelableArray("states", null);
        return r1;
    }

    public final Fragment getItem(int r4) {
        if (r4 <= getCount()) goto L6;
        Intrinsics.checkNotNull(null);
        return null;
    L6:
        EmojiPageNewFragment2 r5 = (Fragment) ListProtector.get(this.a, r4);
        if ((r5 instanceof EmojiPageNewFragment2) == false) goto L12;
        EmojiPageNewFragment2 r0 = r5;
        com.ss.android.lark.reaction.widget.emojipanel.c r1 = this.b;
        r0.getClass();
        if (r1 == null) goto L24;
        r0.d = new WeakReference(r1);
    L24:
        return r5;
    L12:
        if ((r5 instanceof FacePageNewFragment2) == false) goto L15;
        FacePageNewFragment2 r2 = (FacePageNewFragment2) r5;
        r2.getClass();
        r2.d = new WeakReference(null);
        r2.V90();
        r2.e = new WeakReference(null);
        r2.X90();
        r2.W90();
        goto L24
    L15:
        if ((r5 instanceof StickerPageFragment) == false) goto L24;
        StickerPageFragment r3 = (StickerPageFragment) r5;
        r3.getClass();
        r3.f = new WeakReference(null);
        if (r3.e == null) goto L20;
        r3.T90();
    L20:
        r3.h = new WeakReference(null);
        if (r3.e == null) goto L24;
        r3.V90();
        r3.U90();
        goto L24
    }

    public FacePagerNewAdapter(FragmentManager r2, List<? extends Fragment> r3) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r3, "fragmentList");
        super(r2);
        this.a = r3;
    }
}
