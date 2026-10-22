package com.ss.android.lark.inline.ai.ui.imageviewer;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.inline.ai.ui.f0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import nlb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 8*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u000389:B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\r2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010+\u001a\u00020)2\u0006\u0010*\u001a\u00020\"H\u0002J\u0010\u0010,\u001a\u00020)2\u0006\u0010*\u001a\u00020\"H\u0003J\b\u0010-\u001a\u00020)H\u0002J\b\u0010.\u001a\u00020)H\u0002J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u00020)H\u0002J\b\u00101\u001a\u00020)H\u0002J\u000e\u00102\u001a\u000203H\u0082@¢\u0006\u0002\u00104J\b\u00105\u001a\u00020)H\u0017J\u0010\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020'H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0018\u00010\u0014R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/imageviewer/ImageViewerFragment;", "ITEM_TYPE", "Landroidx/fragment/app/DialogFragment;", "config", "Lcom/ss/android/lark/inline/ai/imageviewer/ImageViewConfig;", "<init>", "(Lcom/ss/android/lark/inline/ai/imageviewer/ImageViewConfig;)V", "mViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "mCancelText", "Landroid/widget/TextView;", "mImageIndex", "mCheckedRegion", "Landroid/view/ViewGroup;", "mChecked", "Landroidx/appcompat/widget/AppCompatCheckBox;", "mSaveWrapper", "mConfirmButton", "Lcom/larksuite/component/universe_design/button/UDButton;", "mAdapter", "Lcom/ss/android/lark/inline/ai/ui/imageviewer/ImageViewerFragment$ImageAdapter;", "mItems", "", "mCheckedItems", "", "mCurrentIndex", "", "mCallback", "Lcom/ss/android/lark/inline/ai/imageviewer/IImageCallback;", "mCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/ss/android/lark/vfs/VFSPath;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "findViews", "initViews", "initListeners", "updateChecked", "updateImageIndex", "updateConfirmButton", "updateSaveButton", "doSave", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStart", "onSaveInstanceState", "outState", "Companion", "ImageAdapter", "ImageViewHolder", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImageViewerFragment<ITEM_TYPE> extends DialogFragment {
    public static final /* synthetic */ int r = 0;
    public final ylb.c<ITEM_TYPE> d;
    public ViewPager2 e;
    public TextView f;
    public TextView g;
    public ViewGroup h;
    public AppCompatCheckBox i;
    public ViewGroup j;
    public UDButton k;
    public ImageViewerFragment<ITEM_TYPE>.ImageAdapter l;
    public final List<? extends ITEM_TYPE> m;
    public final List<ITEM_TYPE> n;
    public int o;
    public final ylb.a<ITEM_TYPE> p;
    public final ConcurrentHashMap<String, VFSPath> q;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/imageviewer/ImageViewerFragment$ImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/inline/ai/ui/imageviewer/ImageViewerFragment$ImageViewHolder;", "<init>", "(Lcom/ss/android/lark/inline/ai/ui/imageviewer/ImageViewerFragment;)V", "mGlide", "Lcom/bumptech/glide/RequestManager;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public final class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {
        public final RequestManager a;
        public final /* synthetic */ ImageViewerFragment<ITEM_TYPE> b;

        public final int getItemCount() {
            return this.b.m.size();
        }

        public ImageAdapter(ImageViewerFragment r1) {
            this.b = r1;
            this.a = Glide.with(r1);
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r12, int r13) {
            ImageViewHolder r14 = (ImageViewHolder) r12;
            Intrinsics.checkNotNullParameter(r14, "holder");
            Object r0 = CollectionsKt.getOrNull(this.b.m, r13);
            if (r0 == null) goto L12;
            String r1 = (String) this.b.d.b.invoke(r0);
            if (r1 == null) goto L12;
            r14.a.setTag(r1);
            VFSPath r15 = this.b.q.get(r1);
            if (r15 == null) goto L10;
            LargeImageView r2 = r14.a;
            g r3 = new g();
            r3.a = r15;
            r2.o(r3);
        L11:
            r14.a.setOnClickListener(new com.ss.android.lark.inline.ai.ui.imageviewer.a(this.b));
            return;
        L10:
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new ImageViewerFragment$ImageAdapter$onBindViewHolder$2$1(r1, r14, this, this.b, null), 2, null);
        L12:
            Log.e("ImageViewerFragment", "imageItem is null! position = " + r13 + ", data size = " + this.b.m.size());
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            return new ImageViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131561546, r4, false));
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/imageviewer/ImageViewerFragment$ImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "imageView", "Lcom/ss/android/lark/imagewidget/largeimage/LargeImageView;", "getImageView", "()Lcom/ss/android/lark/imagewidget/largeimage/LargeImageView;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ImageViewHolder extends RecyclerView.ViewHolder {
        public final LargeImageView a;

        public ImageViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (LargeImageView) r2.findViewById(2131375091);
        }
    }

    public static final class a {
    }

    static {
    }

    public final void S90() {
        Object r0 = CollectionsKt.getOrNull(this.m, this.o);
        if (r0 != null) goto L6;
        Log.e("ImageViewerFragment", "updateChecked with wrong data! mItems.size = " + this.m.size() + ", mCurrentIndex = " + this.o);
        return;
    L6:
        int r1 = this.n.indexOf(r0);
        if (r1 < 0) goto L14;
        AppCompatCheckBox r2 = this.i;
        if (r2 == null) goto L11;
        r2.setChecked(true);
    L11:
        AppCompatCheckBox r3 = this.i;
        if (r3 == null) goto L21;
        r3.setText(String.valueOf(r1 + 1));
        return;
    L21:
        return;
    L14:
        AppCompatCheckBox r4 = this.i;
        if (r4 == null) goto L17;
        r4.setChecked(false);
    L17:
        AppCompatCheckBox r5 = this.i;
        if (r5 == null) goto L23;
        r5.setText(null);
        return;
    }

    public final void T90() {
        if (this.n.size() != 0) goto L5;
        this.d.getClass();
        this.d.getClass();
    L6:
        UDButton r0 = this.k;
        if (r0 != null) goto L9;
    L13:
        UDButton r1 = this.k;
        if (r1 != null) goto L16;
        return;
    L16:
        if (this.n.size() <= 0) goto L18;
        boolean r2 = true;
    L19:
        r1.setEnabled(r2);
        return;
    L18:
        r2 = false;
        goto L19
    L9:
        if (this.n.size() != 0) goto L11;
        int r3 = 2131889021;
    L12:
        r0.setText(UIHelper.mustacheFormat(r3, "number", String.valueOf(this.n.size())));
        goto L13
    L11:
        r3 = 2131889022;
        goto L12
    L5:
        this.d.getClass();
        goto L6
    }

    public final void U90() {
        TextView r0 = this.g;
        if (r0 == null) goto L6;
        StringBuilder r1 = new StringBuilder();
        r1.append(this.o + 1);
        r1.append('/');
        r1.append(this.m.size());
        r0.setText(r1.toString());
        return;
    }

    public final void V90() {
        Object r0 = CollectionsKt.getOrNull(this.m, this.o);
        int r1 = 8;
        if (r0 != null) goto L8;
        Log.e("ImageViewerFragment", "updateSaveButton with wrong data! mItems.size = " + this.m.size() + ", mCurrentIndex = " + this.o);
        ViewGroup r2 = this.j;
        if (r2 == null) goto L22;
        r2.setVisibility(8);
        return;
    L22:
        return;
    L8:
        ViewGroup r3 = this.j;
        if (r3 == null) goto L23;
        ylb.c<ITEM_TYPE> r4 = this.d;
        ylb.c.a r5 = r4.e;
        if (r5 == null) goto L15;
        boolean r6 = true;
        if (r5.a != true) goto L15;
    L16:
        if (r6 == true) goto L18;
    L20:
        r3.setVisibility(r1);
        return;
    L18:
        if (this.q.get(r4.b.invoke(r0)) == null) goto L20;
        r1 = 0;
    L15:
        r6 = false;
        goto L16
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L15;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L16;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.height = -1;
        r1.setAttributes(r2);
        r1.setWindowAnimations(2131952400);
        r1.setBackgroundDrawable(new ColorDrawable(0));
        WindowCompat.setDecorFitsSystemWindows(r1, false);
        View r3 = r1.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");
    L11:
        WindowInsetsControllerCompat r5 = ViewCompat.getWindowInsetsController(r3);
        if (r5 == null) goto L17;
        r5.hide(WindowInsetsCompat.Type.systemBars());
        r5.setSystemBarsBehavior(2);
        return;
    L17:
        return;
    L16:
        return;
    }

    public ImageViewerFragment(ylb.c<ITEM_TYPE> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        this.d = r4;
        List<? extends ITEM_TYPE> r0 = r4.a;
        this.m = r0;
        this.n = r4.c;
        this.o = Math.min(Math.max(0, r4.d), CollectionsKt.getLastIndex(r0));
        this.p = r4.f;
        this.q = new ConcurrentHashMap();
    }

    public final void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        Log.i("ImageViewerFragment", "onSaveInstanceState");
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        this.e = r9.findViewById(2131392567);
        this.f = (TextView) r9.findViewById(2131365134);
        this.g = (TextView) r9.findViewById(2131375007);
        this.h = (ViewGroup) r9.findViewById(2131392178);
        this.i = r9.findViewById(2131392177);
        this.j = (ViewGroup) r9.findViewById(2131385119);
        this.k = r9.findViewById(2131367655);
        Context r11 = r9.getContext();
        this.l = new ImageAdapter(this);
        ViewPager2 r12 = this.e;
        if (r12 == null) goto L5;
        r12.setPageTransformer(new MarginPageTransformer(f0.a(15)));
    L5:
        ViewPager2 r13 = this.e;
        if (r13 == null) goto L8;
        r13.setAdapter(this.l);
    L8:
        ViewPager2 r14 = this.e;
        if (r14 == null) goto L11;
        r14.setCurrentItem(this.o, false);
    L11:
        ViewGroup r15 = this.j;
        if (r15 == null) goto L23;
        ylb.c.a r2 = this.d.e;
        if (r2 != null) goto L16;
    L18:
        boolean r3 = false;
    L19:
        if (r3 == false) goto L21;
        int r4 = 0;
    L22:
        r15.setVisibility(r4);
        goto L23
    L21:
        r4 = 8;
        goto L22
    L16:
        if (r2.a != true) goto L18;
        r3 = true;
    L23:
        UDButton r16 = this.k;
        if (r16 == null) goto L26;
        this.d.getClass();
        StateListDrawable r5 = new StateListDrawable();
        int[] r6 = {R.attr.state_pressed};
        Drawable r7 = AppCompatResources.getDrawable(r11, 2131231232);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable r8 = (GradientDrawable) r7;
        r8.setCornerRadius(f0.a(6));
        Unit r17 = Unit.INSTANCE;
        r5.addState(r6, r8);
        GradientDrawable r18 = new GradientDrawable();
        r18.setColor(AppCompatResources.getColorStateList(r11, 2131101948));
        r18.setCornerRadius(f0.a(6));
        r5.addState(new int[]{-16842910}, r18);
        Drawable r19 = AppCompatResources.getDrawable(r11, 2131231229);
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable r20 = (GradientDrawable) r19;
        r20.setCornerRadius(f0.a(6));
        r5.addState(new int[0], r20);
        r16.setBackground(r5);
    L26:
        S90();
        U90();
        T90();
        V90();
        ViewPager2 r21 = this.e;
        if (r21 == null) goto L29;
        r21.registerOnPageChangeCallback(new ImageViewerFragment$initListeners$1(this));
    L29:
        ViewGroup r22 = this.j;
        if (r22 == null) goto L32;
        r22.setOnClickListener(new ImageViewerFragment$initListeners$2(this));
    L32:
        ViewGroup r23 = this.h;
        if (r23 == null) goto L35;
        r23.setOnClickListener(new b(this));
    L35:
        AppCompatCheckBox r24 = this.i;
        if (r24 == null) goto L38;
        r24.setOnClickListener(new c(this));
    L38:
        UDButton r25 = this.k;
        if (r25 == null) goto L41;
        r25.setOnClickListener(new d(this));
    L41:
        TextView r26 = this.f;
        if (r26 == null) goto L45;
        r26.setOnClickListener(new e(this));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561545, r3, false);
    }
}
