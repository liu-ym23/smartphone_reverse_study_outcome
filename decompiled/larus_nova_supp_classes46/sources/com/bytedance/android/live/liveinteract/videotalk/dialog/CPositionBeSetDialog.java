package com.bytedance.android.live.liveinteract.videotalk.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerEnlargeUpdateContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerEnlargeUpdateContentKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/dialog/CPositionBeSetDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "RoomType", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CPositionBeSetDialog extends LiveDialogFragment {
    public static final /* synthetic */ int j = 0;
    public Map<Integer, View> d;
    public final CompositeDisposable e;
    public h1 f;
    public final int g;
    public RoomType h;
    public DataCenter i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/dialog/CPositionBeSetDialog$RoomType;", "", "Video", "Audio", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum RoomType extends Enum<RoomType> {
        public static final RoomType Audio = null;
        public static final RoomType Video = null;
        public static final /* synthetic */ RoomType[] a = null;

        static {
            RoomType r1 = new RoomType("Video", 0);
            Video = r1;
            RoomType r2 = new RoomType("Audio", 1);
            Audio = r2;
            a = new RoomType[]{r1, r2};
        }

        public static RoomType valueOf(String r1) {
            return (RoomType) r27.a.a(RoomType.class, r1);
        }

        public static RoomType[] values() {
            return (RoomType[]) a.clone();
        }

        public RoomType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }

        public static CPositionBeSetDialog a(RoomType r1, h1 r2) {
            int r0 = CPositionBeSetDialog.j;
            Intrinsics.checkNotNullParameter(r1, "roomType");
            Intrinsics.checkNotNullParameter(r2, "msg");
            CPositionBeSetDialog r3 = new CPositionBeSetDialog();
            r3.h = r1;
            r3.f = r2;
            r3.i = null;
            return r3;
        }
    }

    public static final class b implements DialogInterface.OnCancelListener {
        public final /* synthetic */ CPositionBeSetDialog a;

        public b(CPositionBeSetDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            CPositionBeSetDialog r4 = this.a;
            int r0 = CPositionBeSetDialog.j;
            Dialog r1 = r4.getDialog();
            Context r2 = r4.getContext();
            if (r1 == null) goto L17;
            if (r2 == null) goto L21;
            Dialog r5 = r4.getDialog();
            if (r5 == null) goto L18;
            View r6 = r5.getCurrentFocus();
            if (r6 == null) goto L22;
            InputMethodManager r7 = (InputMethodManager) r2.getSystemService("input_method");
            if (r7 != null) goto L14;
            return;
        L14:
            if (r7.isActive() == false) goto L20;
            r7.hideSoftInputFromWindow(r6.getWindowToken(), 0);
            return;
        L20:
            return;
        L22:
            return;
        L18:
            return;
        L21:
            return;
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ CPositionBeSetDialog a;

        public c(CPositionBeSetDialog r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            Long r6 = (Long) r5;
            Intrinsics.checkNotNullParameter(r6, "sec");
            return Long.valueOf(((long) this.a.g) - r6.longValue());
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ CPositionBeSetDialog a;

        public d(CPositionBeSetDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            ((TextView) this.a.S90(2131367650)).setText(s1.C(2131922711, new Object[]{Integer.valueOf((int) r6.longValue())}));
            if (r6.longValue() == 0) goto L12;
            return;
        L12:
            this.a.dismiss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r7 = DialogFragmentLancet.sLastShowStack;
            if (r7 == null) goto L15;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
        new a();
    }

    public CPositionBeSetDialog() {
        this.d = new LinkedHashMap();
        this.e = new CompositeDisposable();
        this.g = 10;
        this.h = RoomType.Video;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.e.dispose();
        ((LinkedHashMap) this.d).clear();
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
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        WindowManager.LayoutParams r0 = r5.getAttributes();
        r0.width = -1;
        r0.height = -1;
        r5.setAttributes(r0);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.setGravity(80);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954719);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new b(this));
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super.onViewCreated(r12, r13);
        h1 r14 = this.f;
        boolean r15 = true;
        Integer r0 = null;
        if (r14 == null) goto L19;
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L9;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L9;
        String r3 = r2.getOwnerUserIdString();
    L10:
        LinkerEnlargeUpdateContent r16 = r14.getLinkerEnlargeUpdateContent();
        if (r16 == null) goto L13;
        String r17 = LinkerEnlargeUpdateContentKt.getFromUserId(r16);
    L15:
        if ((!Intrinsics.areEqual(r3, r17)) == false) goto L17;
        ((TextView) S90(2131375600)).setText(2131922712);
        goto L19
    L17:
        ((TextView) S90(2131375600)).setText(2131922713);
        goto L19
    L13:
        r17 = null;
    L9:
        r3 = null;
    L19:
        if (this.h != RoomType.Video) goto L35;
        S90(2131374807).setVisibility(0);
        S90(2131374807).setVisibility(0);
        h1 r4 = this.f;
        if (r4 == null) goto L25;
        LinkerEnlargeUpdateContent r5 = r4.getLinkerEnlargeUpdateContent();
        if (r5 == null) goto L25;
        py.k r6 = r5.getUiImage();
    L26:
        if (r6 == null) goto L34;
        ImageView r7 = (ImageView) S90(2131374807);
        h1 r18 = this.f;
        if (r18 == null) goto L32;
        LinkerEnlargeUpdateContent r19 = r18.getLinkerEnlargeUpdateContent();
        if (r19 == null) goto L32;
        py.k r8 = r19.getUiImage();
    L33:
        ImageUtil.loadImage(r7, r8, -1, -1, false, 0, ImageView.ScaleType.FIT_CENTER, null);
    L50:
        S90(2131367647).setOnClickListener(x0.a(new AnonymousClass2(this)));
        ((TextView) S90(2131367650)).setText(s1.C(2131922711, new Object[]{Integer.valueOf(this.g)}));
        this.e.add(du2.a.d(1, TimeUnit.SECONDS).take(this.g + 1).map(new c(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this)));
        h1 r110 = this.f;
        if (r110 == null) goto L55;
        LinkerEnlargeUpdateContent r111 = r110.getLinkerEnlargeUpdateContent();
        if (r111 == null) goto L55;
        r0 = r111.getTargetEnlargeGuestType();
    L55:
        int r112 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal();
        if (r0 != null) goto L59;
    L61:
        r15 = false;
    L62:
        TalkRoomLogUtils.B.T(r15, this.i);
        return;
    L59:
        if (r0.intValue() != r112) goto L61;
    L32:
        r8 = null;
        goto L33
    L34:
        S90(2131374807).setImageURI("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_ic_c_position_audio_be_invite.png");
    L25:
        r6 = null;
        goto L26
    L35:
        S90(2131374730).setVisibility(0);
        h1 r9 = this.f;
        if (r9 == null) goto L40;
        LinkerEnlargeUpdateContent r10 = r9.getLinkerEnlargeUpdateContent();
        if (r10 == null) goto L40;
        py.k r11 = r10.getUiImage();
    L41:
        if (r11 == null) goto L49;
        ImageView r20 = (ImageView) S90(2131374730);
        h1 r113 = this.f;
        if (r113 == null) goto L47;
        LinkerEnlargeUpdateContent r114 = r113.getLinkerEnlargeUpdateContent();
        if (r114 == null) goto L47;
        py.k r21 = r114.getUiImage();
    L48:
        ImageUtil.loadImage(r20, r21, -1, -1, false, 0, ImageView.ScaleType.FIT_CENTER, null);
    L47:
        r21 = null;
        goto L48
    L49:
        S90(2131374730).setImageURI("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_ic_c_position_audio_be_invite.png");
    L40:
        r11 = null;
        goto L41
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131565412, r2);
    }
}
