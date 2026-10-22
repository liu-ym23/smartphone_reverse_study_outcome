package com.ss.android.lark.chat.chatwindow.biz.component.customwallpaper;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.framework.larkwidget.Widget;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import rkb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00029:B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\r\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ\u001e\u0010$\u001a\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020'0&\u0012\u0004\u0012\u00020'\u0018\u00010%H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bH\u0002J\u0010\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u001eH\u0002J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u00020)H\u0002J\u0010\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020 H\u0002J\u001c\u0010*\u001a\u00020)2\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000104H\u0016J\u0010\u0010*\u001a\u00020)2\u0006\u00106\u001a\u00020\bH\u0016J\u001c\u00107\u001a\u00020)2\b\u00102\u001a\u0004\u0018\u00010 2\b\u00108\u001a\u0004\u0018\u00010\"H\u0016R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/customwallpaper/CustomWallpaperComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/ChatBaseComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/customwallpaper/ICustomWallpaperComponent;", "<init>", "()V", "hasView", BuildConfig.FLAVOR, "getLayoutResId", BuildConfig.FLAVOR, "()Ljava/lang/Integer;", "mIVCustomWallpaper", "Landroidx/appcompat/widget/AppCompatImageView;", "getMIVCustomWallpaper", "()Landroidx/appcompat/widget/AppCompatImageView;", "setMIVCustomWallpaper", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "mIVMaskCustomWallpaper", "getMIVMaskCustomWallpaper", "setMIVMaskCustomWallpaper", "mWallpaperWrapper", "Lcom/ss/android/lark/chat/chatwindow/biz/component/customwallpaper/DetectSizeChangeFrameLayout;", "getMWallpaperWrapper", "()Lcom/ss/android/lark/chat/chatwindow/biz/component/customwallpaper/DetectSizeChangeFrameLayout;", "setMWallpaperWrapper", "(Lcom/ss/android/lark/chat/chatwindow/biz/component/customwallpaper/DetectSizeChangeFrameLayout;)V", "wallpaperViewModel", "Lcom/ss/android/lark/chat/chatwindow/biz/component/customwallpaper/WallpaperViewModel;", "mWallPaperHeight", "mWallPaperWidth", "bitmapDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "mContext", "Landroid/content/Context;", "mImageEntity", "Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity;", "oldOrientation", "provideWidgetExport", BuildConfig.FLAVOR, "Ljava/lang/Class;", "Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "onCreate", BuildConfig.FLAVOR, "updateCustomWallpaper", "viewWidth", "viewHeight", "loadWallpaper", "drawable", "showMaskInDarkMode", "hideMaskInLightMode", "showMaskIfNeed", "context", "localPath", BuildConfig.FLAVOR, "fsUnit", "coloRes", "updateCustomWallpaperByEntity", "imageEntity", "Companion", "Orientation", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CustomWallpaperComponent extends ChatBaseComponent implements ICustomWallpaperComponent {
    public int l;
    public int m;

    @BindView(9813)
    public AppCompatImageView mIVCustomWallpaper;

    @BindView(10600)
    public AppCompatImageView mIVMaskCustomWallpaper;

    @BindView(9814)
    public DetectSizeChangeFrameLayout mWallpaperWrapper;
    public BitmapDrawable n;
    public int o;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/customwallpaper/CustomWallpaperComponent$Orientation;", BuildConfig.FLAVOR, "orientationValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getOrientationValue", "()I", "PORTRAIT", "LANDSCAPE", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Orientation extends Enum<Orientation> {
        public static final a Companion = null;
        public static final Orientation LANDSCAPE = null;
        public static final Orientation PORTRAIT = null;
        public static final /* synthetic */ Orientation[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int orientationValue;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Orientation> getEntries() {
            return b;
        }

        static {
            Orientation r0 = new Orientation("PORTRAIT", 0, 1);
            PORTRAIT = r0;
            Orientation r1 = new Orientation("LANDSCAPE", 1, 2);
            LANDSCAPE = r1;
            Orientation[] r4 = {r0, r1};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
            Companion = new a();
        }

        public static Orientation[] values() {
            return (Orientation[]) a.clone();
        }

        public final int getOrientationValue() {
            return this.orientationValue;
        }

        @JvmStatic
        public static final Orientation fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L11;
            return PORTRAIT;
        L11:
            return LANDSCAPE;
        L9:
            return PORTRAIT;
        }

        public static Orientation valueOf(String r1) {
            return (Orientation) r27.a.a(Orientation.class, r1);
        }

        public Orientation(String r1, int r2, int r3) {
            super(r1, r2);
            this.orientationValue = r3;
        }
    }

    public static final class a {
    }

    public static final class b implements g<Object, Object> {
        public b() {
        }

        public final boolean onLoadFailed(Exception r1, Object r2, Target<Object> r3, boolean r4) {
            Log.e("CustomWallpaperComponent", "image load failed", r1);
            return false;
        }

        public final boolean onResourceReady(Object r1, Object r2, Target<Object> r3, DataSource r4, boolean r5) {
            Log.i("CustomWallpaperComponent", "load image success");
            return false;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ CustomWallpaperComponent a;

        public c(CustomWallpaperComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            BitmapDrawable r3 = (BitmapDrawable) r2;
            CustomWallpaperComponent r0 = this.a;
            r0.n = r3;
            Intrinsics.checkNotNull(r3);
            r0.E0(r3);
        }
    }

    public static final class d implements View.OnLayoutChangeListener {
        public final /* synthetic */ CustomWallpaperComponent a;

        public d(CustomWallpaperComponent r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            int r10 = r4 - r2;
            int r11 = r5 - r3;
            int r12 = r9 - r7;
            if (r10 != (r8 - r6)) goto L5;
            if (r11 != r12) goto L5;
            return;
        L5:
            CustomWallpaperComponent r13 = this.a;
            r13.m = r10;
            r13.l = r11;
            FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(r13.m, r13.l);
            FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(r13.m, r13.l);
            ImageView r16 = r13.mIVCustomWallpaper;
            ImageView r17 = null;
            if (r16 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("mIVCustomWallpaper");
            r16 = null;
        L9:
            r16.setLayoutParams(r14);
            ImageView r18 = r13.mIVMaskCustomWallpaper;
            if (r18 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mIVMaskCustomWallpaper");
            r18 = null;
        L13:
            r18.setLayoutParams(r15);
            ImageView r19 = r13.mIVCustomWallpaper;
            if (r19 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("mIVCustomWallpaper");
            r19 = null;
        L17:
            r19.requestLayout();
            ImageView r20 = r13.mIVMaskCustomWallpaper;
            if (r20 == null) goto L20;
            r17 = r20;
        L21:
            r17.requestLayout();
            BitmapDrawable r21 = r13.n;
            if (r21 == null) goto L26;
            r13.E0(r21);
            return;
        L26:
            return;
        L20:
            Intrinsics.throwUninitializedPropertyAccessException("mIVMaskCustomWallpaper");
            goto L21
        }
    }

    static {
    }

    public final boolean v0() {
        return true;
    }

    public final Map<Class<? extends com.ss.android.lark.framework.larkwidget.c>, com.ss.android.lark.framework.larkwidget.c> z0() {
        return MapsKt.mapOf(TuplesKt.to(ICustomWallpaperComponent.class, this));
    }

    public CustomWallpaperComponent() {
        this.o = 1;
    }

    public final void onCreate() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onCreate();
        View r0 = ((Widget) this).e;
        if (r0 == null) goto L5;
        ButterKnife.bind(this, r0);
    L5:
        this.o = LarkContext.getApplication().getResources().getConfiguration().orientation;
        StringBuilder r1 = new StringBuilder("onCreate: current orientation is: ");
        Orientation.a r2 = Orientation.Companion;
        int r3 = this.o;
        r2.getClass();
        if (r3 != 1) goto L8;
        Orientation r4 = Orientation.PORTRAIT;
    L12:
        r1.append(r4);
        Log.i("CustomWallpaperComponent", r1.toString());
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(new WallpaperViewModel().getOriginImageLiveData(), this, new c(this));
        Fragment r5 = getFragment();
        if (r5 == null) goto L18;
        View r6 = r5.getView();
        if (r6 == null) goto L19;
        r6.addOnLayoutChangeListener(new d(this));
        return;
    L19:
        return;
    L18:
        return;
    L8:
        if (r3 == 2) goto L10;
        r4 = Orientation.PORTRAIT;
        goto L12
    L10:
        r4 = Orientation.LANDSCAPE;
        goto L12
    }

    public final Integer r0() {
        return 2131559313;
    }

    public final void E0(BitmapDrawable r4) {
        b r0 = new b();
        com.ss.android.lark.framework.larkwidget.b r1 = ((Widget) this).a;
        ImageView r2 = null;
        if (r1 == null) goto L5;
        Context r3 = r1.getContext();
    L6:
        IRequestCreator r5 = ImageLoader.with(r3).load(r4).listener(r0).centerCrop().override(this.m, this.l);
        ImageView r6 = this.mIVCustomWallpaper;
        if (r6 == null) goto L9;
        r2 = r6;
    L10:
        r5.into(r2);
        return;
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("mIVCustomWallpaper");
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
