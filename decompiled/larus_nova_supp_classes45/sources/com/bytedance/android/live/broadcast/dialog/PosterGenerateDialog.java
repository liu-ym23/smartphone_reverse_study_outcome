package com.bytedance.android.live.broadcast.dialog;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdkapi.model.AnchorColumnPosterInfo;
import com.bytedance.crash.d;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcast/dialog/PosterGenerateDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "a", "livebroadcast-shared-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PosterGenerateDialog extends DialogFragment {
    public static final /* synthetic */ int h = 0;
    public Map<Integer, View> d;
    public AnchorColumnPosterInfo e;
    public final CompositeDisposable f;
    public boolean g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PosterGenerateDialog a;

        public b(PosterGenerateDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public PosterGenerateDialog() {
        this.d = new LinkedHashMap();
        this.f = new CompositeDisposable();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public static final void T90(PosterGenerateDialog r24) {
        AnchorColumnPosterInfo r1 = r24.e;
        if (r1 == null) goto L8;
        String r2 = jc1.a.b().getFilesDir().getAbsolutePath() + File.separator + "liveAnchorColumn";
        if (new PolarisFileWrapper(r2).exists() == true) goto L7;
        new PolarisFileWrapper(r2).mkdir();
    L7:
        r1.getAnchorUserID();
        System.currentTimeMillis();
    L8:
        CardView r3 = r24.S90(2131366884);
        if (r3 == null) goto L11;
        r3.buildDrawingCache();
    L11:
        CardView r4 = r24.S90(2131366884);
        if (r4 == null) goto L55;
        Bitmap r5 = r4.getDrawingCache();
        if (r5 == null) goto L56;
        Context r6 = r24.getContext();
        boolean r7 = false;
        OutputStream r8 = null;
        if (r6 == null) goto L37;
        ContentResolver r9 = r6.getContentResolver();
        if (r9 == null) goto L37;
        Uri r13 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentValues r14 = new ContentValues();
        ArrayList r15 = new ArrayList();
        Object[] r12 = {r13, r14};
        f06.b r16 = new f06.b();
        g06.a r11 = (g06.a) ApiHookConfig.b.get(240017);
        if (r11 == null) goto L22;
        f06.a[] r17 = r11.i;
    L23:
        f06.a[] r18 = r17;
        int r19 = r18.length;
        int r21 = 0;
    L25:
        if (r21 >= r19) goto L32;
        f06.a r22 = r18[r21];
        int r23 = r21;
        int r25 = r19;
        f06.a[] r26 = r18;
        Object[] r27 = r12;
        f06.d r28 = r22.preInvoke(240017, "android/content/ContentResolver", "insert", r9, r12, "android.net.Uri", r16);     // Catch: Exception -> L49
        if (r28.a == true) goto L29;
        r15.add(r22);     // Catch: Exception -> L49
        goto L31
    L29:
        r7 = false;
    L34:
        if (r28.a == false) goto L36;
        Uri r29 = (Uri) r28.b;
    L38:
        if (r29 == null) goto L47;
        Context r31 = r24.getContext();
        if (r31 == null) goto L44;
        ContentResolver r32 = r31.getContentResolver();
        if (r32 == null) goto L44;
        r8 = ContentResolverWrapper.openOutputStream(r32, r29);
    L44:
        if (r8 == null) goto L47;
        r7 = r5.compress(Bitmap.CompressFormat.JPEG, 90, r8);
    L47:
        RxUtilKt.c(Observable.just(Boolean.valueOf(r7)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.broadcast.dialog.b(r24), new c(r24)), r24.f);
        return;
    L36:
        r29 = r9.insert(r13, r14);
    L31:
        r21 = r23 + 1;
        r19 = r25;
        r18 = r26;
        r12 = r27;
        goto L25
    L32:
        r7 = false;
        r28 = new f06.d(false, null);
        goto L34
    L22:
        r17 = ApiHookConfig.d;
    L37:
        r29 = null;
        goto L38
    L56:
        return;
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        r4.setCanceledOnTouchOutside(true);
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        r5.setLayout(-1, -2);
        r5.setGravity(17);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954762);
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        this.f.clear();     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        r7.setOnClickListener(new b(this));
        LiveDoubleColorBallAnimationView r0 = S90(2131378977);
        if (r0 == null) goto L5;
        r0.setVisibility(0);
        r0.b();
    L5:
        AnchorColumnPosterInfo r1 = this.e;
        if (r1 == null) goto L43;
        SimpleDraweeView r3 = S90(2131385267);
        if (r3 == null) goto L10;
        r3.setImageURI(r1.getColumnBackgroundUrl());
    L10:
        SimpleDraweeView r2 = S90(2131385267);
        if (r2 == null) goto L15;
        GenericDraweeHierarchy r4 = r2.getHierarchy();
        if (r4 == null) goto L15;
        r4.setActualImageFocusPoint(new PointF(0.0f, 0.0f));
    L15:
        SimpleDraweeView r5 = S90(2131385266);
        if (r5 == null) goto L18;
        r5.setImageURI(r1.getAvatarUrl());
    L18:
        TextView r6 = (TextView) S90(2131391677);
        if (r6 == null) goto L21;
        r6.setText(r1.getAnchorNickname());
    L21:
        TextView r9 = (TextView) S90(2131391606);
        if (r9 == null) goto L24;
        r9.setText(r1.getColumnTitle());
    L24:
        TextView r11 = (TextView) S90(2131390487);
        if (r11 == null) goto L27;
        r11.setText(r1.getColumnIntroduction());
    L27:
        k.n(IHostShare.class).getQrCodeInfo(4, r1.getAnchorUserID(), new PosterGenerateDialog$initView$$inlined$let$lambda$1(this));
        int r12 = Color.parseColor(r1.getColumnBackgroundColor());     // Catch: Throwable -> L30
    L32:
        View r13 = S90(2131392516);
        if (r13 == null) goto L47;
        r13.setBackground(new ColorDrawable(r12));
    L47:
        Integer r14 = Integer.valueOf(ColorUtils.setAlphaComponent(r12, 0));     // Catch: Throwable -> L37
    L39:
        if (r14 == null) goto L43;
        View r15 = S90(2131392469);
        if (r15 == null) goto L43;
        GradientDrawable r16 = new GradientDrawable();
        r16.setGradientType(0);
        r16.setColors(new int[]{r12, r14.intValue()});
        r16.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        Unit r17 = Unit.INSTANCE;
        r15.setBackground(r16);
    L37:
        th = move-exception;
        ALogger.e("PosterGenerateDialog", "background color parse fail", th);
        r14 = null;
    L30:
        th = move-exception;
        ALogger.e("PosterGenerateDialog", "background color parse fail", th);
        r12 = -1;
    L43:
        FrameLayout r18 = (FrameLayout) S90(2131372832);
        if (r18 == null) goto L51;
        r18.setOnClickListener(new com.bytedance.android.live.broadcast.dialog.a(this));
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131565707, r2);
    }
}
