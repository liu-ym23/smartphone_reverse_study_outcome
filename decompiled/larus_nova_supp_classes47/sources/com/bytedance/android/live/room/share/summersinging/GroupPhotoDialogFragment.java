package com.bytedance.android.live.room.share.summersinging;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/share/summersinging/GroupPhotoDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/live/room/share/summersinging/a;", "<init>", "()V", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupPhotoDialogFragment extends LiveDialogFragment implements com.bytedance.android.live.room.share.summersinging.a {
    public static final com.bytedance.android.live.base.model.data.f.a q = null;
    public View d;
    public ConstraintLayout e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public TextView j;
    public ImageView k;
    public ValueAnimator l;
    public final l m;
    public final com.bytedance.android.live.base.model.data.f n;
    public final DataCenter o;
    public final p p;

    public static final class a {
    }

    public static final class b implements LiveBottomSheetDialog.m {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    static {
        com.bytedance.android.live.base.model.data.f.a r0 = new com.bytedance.android.live.base.model.data.f.a();
        r0.locationX = 56;
        r0.locationY = 101;
        q = r0;
    }

    public GroupPhotoDialogFragment() {
        this(new com.bytedance.android.live.base.model.data.f(), null, new p(null, null, null));
        ALogger.e("GroupPhotoDialogFragment", "call default constructor");
    }

    @Override // com.bytedance.android.live.room.share.summersinging.a
    public final String SD() {
        DataCenter r0 = this.o;
        if (r0 == null) goto L9;
        Room r1 = z.o(r0);
        if (r1 == null) goto L9;
        User r2 = r1.getOwner();
        if (r2 == null) goto L9;
        return r2.getRemarkNameOrNickname();
    L9:
        return null;
    }

    @Override // com.bytedance.android.live.room.share.summersinging.a
    public final Room k2() {
        DataCenter r0 = this.o;
        if (r0 != null) goto L7;
        return null;
    L7:
        return z.o(r0);
    }

    @Override // com.bytedance.android.live.room.share.summersinging.a
    public final void uy() {
        dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L11;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.live.room.share.summersinging.a
    public final ConstraintLayout fD() {
        return this.e;
    }

    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        Dialog r3 = getDialog();
        if (r3 == null) goto L8;
        ViewGroup r4 = (ViewGroup) r3.findViewById(2131389519);
        if (r4 == null) goto L9;
        a1.k(r4, -1);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954600);
        setBottomSheetSlideProcessor(b.a);
    }

    public final void onDismiss(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");     // Catch: Throwable -> L11
        ValueAnimator r0 = this.l;     // Catch: Throwable -> L11
        if (r0 == null) goto L5;
        r0.cancel();     // Catch: Throwable -> L11
    L5:
        l r1 = this.m;     // Catch: Throwable -> L11
        Disposable r2 = r1.c;     // Catch: Throwable -> L11
        if (r2 == null) goto L8;
        r2.dispose();     // Catch: Throwable -> L11
    L8:
        r1.b = false;     // Catch: Throwable -> L11
        super.onDismiss(r3);     // Catch: Throwable -> L11
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L11:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public GroupPhotoDialogFragment(com.bytedance.android.live.base.model.data.f r2, DataCenter r3, p r4) {
        Intrinsics.checkNotNullParameter(r2, "groupPhotoDetail");
        Intrinsics.checkNotNullParameter(r4, "imageBitmapStore");
        this.n = r2;
        this.o = r3;
        this.p = r4;
        this.m = new l(this);
    }

    public static void S90(View r1, int r2, int r3) {
        if (r1 == null) goto L5;
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        r0.width = UtilityKotlinExtentionsKt.i(r2);
        r0.height = UtilityKotlinExtentionsKt.i(r3);
        r1.setLayoutParams(r0);
        return;
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r19) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        View r1 = r17.inflate(2131565477, r18, false);
        this.d = r1;
        this.e = r1.findViewById(2131382216);
        if (o.a() == false) goto L7;
        ConstraintLayout r2 = this.e;
        if (r2 == null) goto L7;
        a1.l(r2, UtilityKotlinExtentionsKt.i(29));
    L7:
        this.f = (ImageView) r1.findViewById(2131367794);
        this.g = (ImageView) r1.findViewById(2131363623);
        this.h = (ImageView) r1.findViewById(2131386943);
        this.i = (ImageView) r1.findViewById(2131383505);
        this.j = (TextView) r1.findViewById(2131383507);
        py.k r3 = this.n.groupPhoto;
        if (r3 != null) goto L11;
    L14:
        ImageView r4 = this.h;
        if (r4 == null) goto L17;
        r4.post(new c(this));
    L17:
        l r5 = this.m;
        View r6 = this.d;
        ImageView r7 = null;
        if (r6 == null) goto L20;
        ConstraintLayout r8 = (ConstraintLayout) r6.findViewById(2131386095);
    L21:
        r5.a = r8;
        if (r8 == null) goto L26;
        HSImageView r9 = r8.findViewById(2131386079);
        if (r9 == null) goto L26;
        i2.h(r9, "/share/groupphoto/share_friend.png");
    L26:
        if (r8 == null) goto L30;
        HSImageView r10 = r8.findViewById(2131386149);
        if (r10 == null) goto L30;
        i2.h(r10, "/share/groupphoto/share_weixin.png");
    L30:
        if (r8 == null) goto L34;
        HSImageView r12 = r8.findViewById(2131386125);
        if (r12 == null) goto L34;
        i2.h(r12, "/share/groupphoto/share_qq.png");
    L34:
        if (r8 == null) goto L38;
        HSImageView r13 = r8.findViewById(2131386076);
        if (r13 == null) goto L38;
        i2.h(r13, "/share/groupphoto/share_download.png");
    L38:
        if (r8 == null) goto L42;
        LinearLayout r14 = (LinearLayout) r8.findViewById(2131386078);
        if (r14 == null) goto L42;
        r14.setOnClickListener(new m(new GroupPhotoShareLayoutViewHolder$initView$1(r5)));
    L42:
        if (r8 == null) goto L46;
        LinearLayout r15 = (LinearLayout) r8.findViewById(2131386148);
        if (r15 == null) goto L46;
        r15.setOnClickListener(new m(new GroupPhotoShareLayoutViewHolder$initView$2(r5)));
    L46:
        if (r8 == null) goto L50;
        LinearLayout r16 = (LinearLayout) r8.findViewById(2131386124);
        if (r16 == null) goto L50;
        r16.setOnClickListener(new m(new GroupPhotoShareLayoutViewHolder$initView$3(r5)));
    L50:
        if (r8 == null) goto L54;
        LinearLayout r20 = (LinearLayout) r8.findViewById(2131386075);
        if (r20 == null) goto L54;
        r20.setOnClickListener(new m(new GroupPhotoShareLayoutViewHolder$initView$4(r5)));
    L54:
        View r22 = this.d;
        if (r22 == null) goto L57;
        r7 = (ImageView) r22.findViewById(2131365126);
    L57:
        this.k = r7;
        if (r7 == null) goto L60;
        r7.setOnClickListener(new com.bytedance.android.live.room.share.summersinging.b(this));
    L60:
        ImageView r23 = this.f;
        if (r23 == null) goto L63;
        r23.setImageBitmap(this.p.a);
    L63:
        View r24 = this.d;
        if (r24 == null) goto L75;
        Context r25 = r24.getContext();
        if (r25 == null) goto L75;
        Resources r26 = r25.getResources();
        if (r26 == null) goto L75;
        Drawable r27 = RoundedBitmapDrawableFactory.create(r26, this.p.b);
        r27.setCornerRadius(UtilityKotlinExtentionsKt.h(200));
        ImageView r28 = this.g;
        if (r28 == null) goto L72;
        r28.setImageDrawable(r27);
    L72:
        ImageView r29 = this.g;
        if (r29 == null) goto L75;
        r29.setColorFilter(s1.h(2131107583));
    L75:
        ImageView r30 = this.h;
        if (r30 == null) goto L78;
        r30.setImageBitmap(this.p.b);
    L78:
        ImageView r32 = this.h;
        if (r32 == null) goto L82;
        r32.setColorFilter(s1.h(2131107583));
    L82:
        if (this.p.c == null) goto L99;
        double r33 = 62;
        py.k r34 = this.n.groupPhoto;
        if (r34 == null) goto L86;
        int r35 = r34.getWidth();
    L87:
        double r36 = r33 * (((double) r35) / 308.0d);
        ALogger.i("GroupPhotoDialogFragment", "qrCode size " + r36);
        ImageView r37 = this.i;
        if (r37 == null) goto L90;
        a1.p(r37, (int) UtilityKotlinExtentionsKt.h((float) r36));
    L90:
        ImageView r38 = this.i;
        if (r38 == null) goto L93;
        a1.k(r38, (int) UtilityKotlinExtentionsKt.h((float) r36));
    L93:
        ImageView r39 = this.i;
        if (r39 == null) goto L96;
        r39.setImageBitmap(this.p.c);
    L96:
        TextView r40 = this.j;
        if (r40 == null) goto L105;
        r40.setText(this.n.shareContent);
    L105:
        ConstraintLayout r42 = this.m.a;
        if (r42 == null) goto L108;
        UtilityKotlinExtentionsKt.d(r42, 150);
    L108:
        ImageView r43 = this.k;
        if (r43 == null) goto L111;
        UtilityKotlinExtentionsKt.d(r43, 150);
    L111:
        ConstraintLayout r44 = this.e;
        if (r44 == null) goto L114;
        r44.setVisibility(0);
    L114:
        Keyframe r45 = Keyframe.ofFloat(0.34305316f, UtilityKotlinExtentionsKt.h(-1));
        r45.setInterpolator(PathInterpolatorCompat.create(0.16f, 0.66f, 0.48f, 1.0f));
        Unit r110 = Unit.INSTANCE;
        float r46 = 0;
        Keyframe r111 = Keyframe.ofFloat(1.0f, UtilityKotlinExtentionsKt.h(r46));
        r111.setInterpolator(PathInterpolatorCompat.create(0.16f, 0.66f, 0.48f, 1.0f));
        Keyframe[] r47 = {Keyframe.ofFloat(0.0f, UtilityKotlinExtentionsKt.h(2)), r45, r111};
        Keyframe r48 = Keyframe.ofFloat(1.0f, UtilityKotlinExtentionsKt.h(r46));
        r48.setInterpolator(PathInterpolatorCompat.create(0.14f, 0.68f, 0.58f, 1.0f));
        Keyframe[] r49 = {Keyframe.ofFloat(0.0f, UtilityKotlinExtentionsKt.h(50)), r48};
        Keyframe r50 = Keyframe.ofFloat(0.57118356f, 0.99f);
        r50.setInterpolator(PathInterpolatorCompat.create(0.16f, 0.66f, 0.48f, 1.0f));
        Keyframe r52 = Keyframe.ofFloat(1.0f, 1.0f);
        r52.setInterpolator(PathInterpolatorCompat.create(0.16f, 0.66f, 0.48f, 1.0f));
        Keyframe[] r53 = {Keyframe.ofFloat(0.0f, 1.2f), r50, r52};
        Keyframe r54 = Keyframe.ofFloat(0.85763294f, 0.0f);
        r54.setInterpolator(PathInterpolatorCompat.create(0.21f, 0.7f, 0.25f, 1.0f));
        Keyframe[] r55 = {Keyframe.ofFloat(0.0f, -10.0f), r54, Keyframe.ofFloat(1.0f, 0.0f)};
        Keyframe r56 = Keyframe.ofFloat(0.2572899f, 1.0f);
        r56.setInterpolator(new LinearInterpolator());
        ValueAnimator r57 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("xOffset", r47), PropertyValuesHolder.ofKeyframe("yOffset", r49), PropertyValuesHolder.ofKeyframe("scale", r53), PropertyValuesHolder.ofKeyframe("rotation", r55), PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), r56, Keyframe.ofFloat(1.0f, 1.0f)})});
        r57.setDuration(583);
        r57.addUpdateListener(new d(this));
        r57.start();
        this.l = r57;
        return r1;
    L86:
        r35 = 308;
        goto L87
    L99:
        ImageView r58 = this.i;
        if (r58 == null) goto L102;
        r58.setVisibility(8);
    L102:
        TextView r59 = this.j;
        if (r59 == null) goto L105;
        r59.setVisibility(8);
        goto L105
    L20:
        r8 = null;
        goto L21
    L11:
        if (o.a() == false) goto L13;
        S90(this.f, 260, 400);
        goto L14
    L13:
        S90(this.f, r3.getWidth(), r3.getHeight());
        goto L14
    }
}
