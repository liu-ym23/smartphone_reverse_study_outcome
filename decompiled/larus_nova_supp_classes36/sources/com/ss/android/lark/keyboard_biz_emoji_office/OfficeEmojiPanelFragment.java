package com.ss.android.lark.keyboard_biz_emoji_office;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.tabs.TabLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard_biz_emoji_office.databinding.FragmentOfficeEmojiPanelBinding;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0012J\u000e\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0010J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/ss/android/lark/keyboard_biz_emoji_office/OfficeEmojiPanelFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewBinding", "Lcom/ss/android/lark/keyboard_biz_emoji_office/databinding/FragmentOfficeEmojiPanelBinding;", "tabList", "", "Lcom/ss/android/lark/keyboard_biz_emoji_office/OfficeEmojiTabItem;", "tabAdapter", "Lcom/ss/android/lark/keyboard_biz_emoji_office/OfficeEmojiTabAdapter;", "getTabAdapter", "()Lcom/ss/android/lark/keyboard_biz_emoji_office/OfficeEmojiTabAdapter;", "tabAdapter$delegate", "Lkotlin/Lazy;", "enableCustomSticker", "", "emojiPanelListener", "Lcom/ss/android/lark/keyboard_biz_emoji_office/IOfficeEmojiPanelListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onPause", "setEmojiPanelListener", "listener", "setEnableCustomSticker", "enable", "buildTabList", "loadTabIcon", "imageView", "Landroid/widget/ImageView;", "position", "", "Companion", "keyboard-biz-emoji-office_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OfficeEmojiPanelFragment extends Fragment {
    public static final /* synthetic */ int i = 0;
    public FragmentOfficeEmojiPanelBinding d;
    public List<? extends c> e;
    public final Lazy f;
    public boolean g;
    public com.ss.android.lark.keyboard_biz_emoji_office.b h;

    public static final class a {
    }

    public static final class b implements u2c.a.b {
        public final /* synthetic */ OfficeEmojiPanelFragment a;

        public b(OfficeEmojiPanelFragment r1) {
            this.a = r1;
        }

        public final void a(TabLayout.Tab r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "tab");
            FragmentOfficeEmojiPanelBinding r1 = this.a.d;
            FragmentOfficeEmojiPanelBinding r3 = null;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            r1 = null;
        L5:
            AppCompatImageView r0 = new AppCompatImageView(r1.b.getContext());
            OfficeEmojiPanelFragment r2 = this.a;
            int r4 = UIHelper.dp2px(40.0f);
            ViewGroup.MarginLayoutParams r5 = new ViewGroup.MarginLayoutParams(r4, r4);
            int r6 = UIHelper.dp2px(10.0f);
            if (r10 != 0) goto L8;
            int r7 = r6;
        L9:
            r5.setMarginStart(r7);
            List<? extends c> r8 = r2.e;
            if (r8 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("tabList");
            r8 = null;
        L13:
            if (r10 == (r8.size() - 1)) goto L16;
            r6 = 0;
        L16:
            r5.setMarginEnd(r6);
            r0.setLayoutParams(r5);
            r0.setScaleType(ImageView.ScaleType.CENTER_CROP);
            int r11 = UIHelper.dp2px(6.0f);
            r0.setPadding(r11, r11, r11, r11);
            r0.setBackgroundResource(2131232168);
            List<? extends c> r12 = this.a.e;
            if (r12 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("tabList");
            r12 = null;
        L19:
            c r13 = (c) ListProtector.get(r12, r10);
            if ((r13 instanceof c.b) == false) goto L23;
            r0.setImageResource(2131237623);
        L25:
            FragmentOfficeEmojiPanelBinding r14 = this.a.d;
            if (r14 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        L29:
            FrameLayout r15 = new FrameLayout(r3.b.getContext());
            r15.addView(r0);
            r9.setCustomView(r15);
            return;
        L28:
            r3 = r14;
            goto L29
        L23:
            if ((r13 instanceof c.a) == false) goto L32;
            r0.setImageResource(2131237620);
            goto L25
        L32:
            throw new NoWhenBranchMatchedException();
        L8:
            r7 = 0;
            goto L9
        }
    }

    static {
    }

    public OfficeEmojiPanelFragment() {
        this.f = LazyKt.lazy(new OfficeEmojiPanelFragment$tabAdapter$2(this));
        this.g = true;
    }

    public final void onPause() {
        super.onPause();
        Log.i("OfficeEmojiPanelFrag", "onPause");
    }

    public final void onResume() {
        super.onResume();
        Log.i("OfficeEmojiPanelFrag", "onResume");
        k2c.a.a().md(true);
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L6;
        this.g = r4.getBoolean("key_enable_custom_sticker", true);
        return;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        List<? extends c> r6 = CollectionsKt.mutableListOf(new c[]{c.b.b});
        if (this.g == false) goto L5;
        r6.add(c.a.b);
    L5:
        this.e = r6;
        OfficeEmojiTabAdapter r7 = (OfficeEmojiTabAdapter) this.f.getValue();
        List<? extends c> r8 = this.e;
        FragmentOfficeEmojiPanelBinding r1 = null;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tabList");
        r8 = null;
    L8:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "tabList");
        ((ArrayList) r7.b).clear();
        ((ArrayList) r7.b).addAll(r8);
        r7.notifyDataSetChanged();
        FragmentOfficeEmojiPanelBinding r9 = this.d;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r9 = null;
    L11:
        r9.c.setAdapter((OfficeEmojiTabAdapter) this.f.getValue());
        FragmentOfficeEmojiPanelBinding r0 = this.d;
        if (r0 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L14:
        TabLayout r2 = r0.b;
        FragmentOfficeEmojiPanelBinding r3 = this.d;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L18:
        new u2c.a(r2, r1.c, new b(this)).a();
        return;
    L17:
        r1 = r3;
        goto L18
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131561225, r3, false);
        int r6 = 2131387992;
        TabLayout r7 = ViewBindings.findChildViewById(r5, 2131387992);
        if (r7 == null) goto L9;
        r6 = 2131392444;
        ViewPager2 r0 = ViewBindings.findChildViewById(r5, 2131392444);
        if (r0 == null) goto L9;
        FragmentOfficeEmojiPanelBinding r8 = new FragmentOfficeEmojiPanelBinding((LinearLayout) r5, r7, r0);
        this.d = r8;
        return r8.a;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
