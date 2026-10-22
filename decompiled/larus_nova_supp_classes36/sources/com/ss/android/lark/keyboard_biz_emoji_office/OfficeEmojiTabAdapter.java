package com.ss.android.lark.keyboard_biz_emoji_office;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard_biz_emoji_office.dependency.IKeyboardEmojiOfficeDependency;
import com.ss.android.lark.reaction.widget.emojipanel.EmojiPageNewFragment2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000b\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/keyboard_biz_emoji_office/OfficeEmojiTabAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "listener", "Lcom/ss/android/lark/keyboard_biz_emoji_office/IOfficeEmojiPanelListener;", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/ss/android/lark/keyboard_biz_emoji_office/IOfficeEmojiPanelListener;)V", "tabList", "", "Lcom/ss/android/lark/keyboard_biz_emoji_office/OfficeEmojiTabItem;", "setTabList", "", "", "getItemCount", "", "getItemId", "", "position", "createFragment", "keyboard-biz-emoji-office_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OfficeEmojiTabAdapter extends FragmentStateAdapter {
    public final b a;
    public final List<c> b;

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public final Fragment createFragment(int r3) {
        c r4 = (c) ListProtector.get(this.b, r3);
        if ((r4 instanceof c.b) == false) goto L9;
        OfficeDefaultEmojiFragment r5 = new OfficeDefaultEmojiFragment();
        b r0 = this.a;
        if (r0 == null) goto L7;
        ((EmojiPageNewFragment2) r5).d = new WeakReference(r0);
    L7:
        r5.u = this.a;
    L13:
        return r5;
    L9:
        if ((r4 instanceof c.a) == false) goto L15;
        IKeyboardEmojiOfficeDependency.a.getClass();
        r5 = ((IKeyboardEmojiOfficeDependency) IKeyboardEmojiOfficeDependency.Companion.b.getValue()).newCustomStickerFragment();
        if ((r5 instanceof g6c.a) == false) goto L13;
        ((g6c.a) r5).RP(this.a);
        goto L13
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public final long getItemId(int r3) {
        return ((c) ListProtector.get(this.b, r3)).hashCode();
    }

    public OfficeEmojiTabAdapter(OfficeEmojiPanelFragment r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.a = r3;
        this.b = new ArrayList();
    }
}
