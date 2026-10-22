package com.bytedance.android.livesdk.interactivity.roomintro.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcast.api.BroadcastSecurityApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.config.gr0;
import com.bytedance.android.livesdk.interactivity.api.roomintro.api.RoomIntroApi;
import com.bytedance.android.livesdk.utils.b1;
import com.bytedance.android.livesdk.widget.TextCorrectionEditText;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/roomintro/view/RoomIntroDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomIntroDialog extends LiveDialogFragment {
    public static final /* synthetic */ int l = 0;
    public Map<Integer, View> d;
    public com.bytedance.android.livesdk.interactivity.api.roomintro.api.b e;
    public b0 f;
    public View g;
    public List<RoomIntroLabel> h;
    public List<RoomIntroLabel> i;
    public String j;
    public boolean k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ RoomIntroDialog a;

        public b(RoomIntroDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v7, types: [android.text.SpannableString] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            RoomIntroDialog r11 = this.a;
            int r0 = RoomIntroDialog.l;
            r11.getClass();
            mm3.a r1 = new mm3.a();
            r1.a = "添加标签";
            r1.b = "取消";
            r1.c = "展示";
            ArrayList r2 = new ArrayList();
            Iterator r3 = r11.i.iterator();
        L4:
            if (r3.hasNext() == false) goto L33;
            RoomIntroLabel r4 = (RoomIntroLabel) r3.next();
            String r5 = r4.getTypeName();
            String r6 = BuildConfig.FLAVOR;
            if (r5 != null) goto L8;
            r5 = BuildConfig.FLAVOR;
        L8:
            String r7 = r4.getLabelText();
            if (r7 == null) goto L12;
            r6 = r7;
        L12:
            String r8 = r4.getLabelIconForAnchorPickerDialog();
            Bitmap r9 = null;
            if (r8 != null) goto L16;
        L29:
            if (r9 == null) goto L31;
            ?? r13 = new SpannableString(r5 + "： $ " + r6);
            int r14 = r5.length() + 2;
            BitmapDrawable r15 = new BitmapDrawable(r9);
            r15.setBounds(0, 0, s1.f(14.0f), s1.f(14.0f));
            Unit r16 = Unit.INSTANCE;
            r13.setSpan(new com.bytedance.android.livesdk.widget.a(r15), r14, r14 + 1, 33);
        L32:
            r2.add(r13);
            goto L4
        L31:
            r13 = r5 + 65306 + r6;
            goto L32
        L16:
            if (TextUtils.isEmpty(r8) == true) goto L29;
            IHostFrescoHelper r17 = jc1.k.f(IHostFrescoHelper.class);
            if (r17 == null) goto L21;
            String r18 = r17.getImageFilePath(r8);
        L23:
            if (TextUtils.isEmpty(r18) == true) goto L29;
            r9 = BitmapFactory.decodeFile(r18);     // Catch: Exception -> L27
        L27:
            e = move-exception;
            ALogger.i("com.bytedance.android.livesdk.interactivity.roomintro.view.RoomIntroDialog", "getIconBitmap error, msg is " + e.getMessage());
            goto L29
        L21:
            r18 = null;
            goto L23
        L33:
            r1.e = CollectionsKt.listOf(r2);
            r1.d = new com.bytedance.android.livesdk.interactivity.roomintro.view.g(r11);
            Context r19 = r11.getContext();
            Intrinsics.checkNotNull(r19);
            new mm3.b(r19, r1).d();
            this.a.V90("click");
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ RoomIntroDialog a;
        public final /* synthetic */ View b;
        public final /* synthetic */ RoomIntroLabel c;

        public c(RoomIntroDialog r1, View r2, RoomIntroLabel r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            this.a.S90(2131388161).removeView(this.b);
            this.a.h.remove(this.c);
            Iterator<T> r6 = this.a.i.iterator();
        L3:
            String r1 = null;
            if (r6.hasNext() == false) goto L8;
            Object r0 = r6.next();
            if (Intrinsics.areEqual(((RoomIntroLabel) r0).getLabelName(), this.c.getLabelName()) == false) goto L3;
        L9:
            if (r0 != null) goto L11;
            this.a.i.add(this.c);
        L11:
            this.a.U90();
            RoomIntroDialog r7 = this.a;
            r7.getClass();
            LinkedHashMap r2 = new LinkedHashMap();
            b0 r3 = r7.f;
            if (r3 == null) goto L14;
            r1 = r3.a();
        L14:
            r2.put("anchor_id", String.valueOf(r1));
            b0 r8 = r7.f;
            if (r8 != null) goto L17;
            String r9 = BuildConfig.FLAVOR;
        L21:
            r2.put("request_page", r9);
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_room_detail_tag_delete", r2, new Object[0]);
            return;
        L17:
            if (r8.a != null) goto L19;
            r9 = "live_start";
            goto L21
        L19:
            r9 = "live_room";
            goto L21
        L8:
            r0 = null;
            goto L9
        }
    }

    public static final class d implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ RoomIntroDialog a;

        public d(RoomIntroDialog r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r5, boolean r6) {
            RoomIntroDialog r7 = this.a;
            int r0 = RoomIntroDialog.l;
            r7.X90(r6);
            String r1 = null;
            if (r6 == true) goto L5;
            RoomIntroDialog r2 = this.a;
            RoomIntroDialog.T90(r2, false, r2.h, null);
        L5:
            RoomIntroDialog r3 = this.a;
            r3.getClass();
            LinkedHashMap r4 = new LinkedHashMap();
            if (r6 == false) goto L8;
            String r8 = "open";
        L9:
            r4.put("status", r8);
            b0 r9 = r3.f;
            if (r9 == null) goto L12;
            r1 = r9.a();
        L12:
            r4.put("anchor_id", String.valueOf(r1));
            b0 r10 = r3.f;
            if (r10 != null) goto L15;
            String r11 = BuildConfig.FLAVOR;
        L19:
            r4.put("request_page", r11);
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_room_detail_setting_status", r4, new Object[0]);
            return;
        L15:
            if (r10.a != null) goto L17;
            r11 = "live_start";
            goto L19
        L17:
            r11 = "live_room";
            goto L19
        L8:
            r8 = "close";
            goto L9
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ RoomIntroDialog a;
        public final /* synthetic */ l b;

        public e(RoomIntroDialog r1, l r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            FrescoLoader r6 = FrescoLoader.with(this.a.getContext());
            int r0 = RoomIntroDialog.l;
            r6.load("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_broadcast_image_room_intro_demo.png").actualScaleType(ImageView.ScaleType.FIT_CENTER).controllerListener(new ImageLoader.e(null, this.b, false)).placeholder(2131250137).into((ImageView) this.a.S90(2131375091));
        }
    }

    public static final class f implements TextCorrectionEditText.b {
        public final /* synthetic */ RoomIntroDialog a;

        public f(RoomIntroDialog r1) {
            this.a = r1;
        }

        public final void ignoreCorrection(String r4) {
            Intrinsics.checkNotNullParameter(r4, "errorWord");
            RoomIntroDialog r0 = this.a;
            int r1 = RoomIntroDialog.l;
            r0.getClass();
            if (r4 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == true) goto L13;
            ((BroadcastSecurityApi) com.bytedance.android.live.network.c.b().e(BroadcastSecurityApi.class)).ignoreCorrection(r4).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(com.bytedance.android.livesdk.interactivity.roomintro.view.d.a, com.bytedance.android.livesdk.interactivity.roomintro.view.e.a, com.bytedance.android.livesdk.interactivity.roomintro.view.f.a);
            return;
        L13:
            return;
        L5:
            if (r4.length() == 0) goto L8;
            r2 = false;
            goto L9
        }
    }

    public static final class g implements TextWatcher {
        public final /* synthetic */ RoomIntroDialog a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public g(RoomIntroDialog r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r4) {
            boolean r1 = false;
            if (this.a.S90(2131371469).getAutomaticChanged() == false) goto L6;
            this.a.S90(2131371469).setAutomaticChanged(false);
            return;
        L6:
            RoomIntroDialog r5 = this.a;
            EditText r0 = (EditText) r5.S90(2131371469);
            r5.getClass();
            Editable r2 = r0.getText();
            if (r2 != null) goto L9;
        L10:
            r1 = true;
        L11:
            if (r1 == true) goto L15;
            ((BroadcastSecurityApi) com.bytedance.android.live.network.c.b().e(BroadcastSecurityApi.class)).textCorrection(r0.getText().toString()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.interactivity.roomintro.view.h(r5), com.bytedance.android.livesdk.interactivity.roomintro.view.i.a, com.bytedance.android.livesdk.interactivity.roomintro.view.j.a);
            return;
        L15:
            return;
        L9:
            if (r2.length() != 0) goto L11;
            goto L10
        }
    }

    public static final class h implements TextWatcher {
        public final /* synthetic */ RoomIntroDialog a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public h(RoomIntroDialog r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            RoomIntroDialog r5 = this.a;
            int r6 = RoomIntroDialog.l;
            r5.getClass();
            if (r1 != null) goto L5;
        L8:
            boolean r7 = true;
        L9:
            if (r7 == false) goto L11;
            return;
        L11:
            if (r1.length() <= 69) goto L19;
            ((Editable) r1).delete(69, r1.length());
            Context r8 = this.a.getContext();
            if (r8 != null) goto L15;
            return;
        L15:
            if (r8.getResources() == null) goto L21;
            String r9 = rm3.c.a;
            rm3.c.f(this.a.getContext(), 2131919923, false, 28);
            return;
        L21:
            return;
        L19:
            return;
        L5:
            if (r1.length() == 0) goto L8;
            r7 = false;
            goto L9
        }
    }

    public static final class i implements TextView.OnEditorActionListener {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
            if (r3 != null) goto L4;
        L6:
            return false;
        L4:
            if (r3.getKeyCode() != 66) goto L6;
            return true;
        }
    }

    public static final class j implements View.OnClickListener {
        public final /* synthetic */ RoomIntroDialog a;

        public j(RoomIntroDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            UtilityKotlinExtentionsKt.t(this.a.S90(2131388525));
            UtilityKotlinExtentionsKt.w(this.a.S90(2131371469));
            RoomIntroDialog r5 = this.a;
            if (r5.k == true) goto L7;
            r5.S90(2131371469).setText(this.a.j);
            this.a.getClass();
            String r6 = this.a.j;
            if (r6 == null) goto L7;
            int r7 = r6.length();
            this.a.S90(2131371469).setSelection(RangesKt.coerceAtMost(r7, 69));
        L7:
            x0.b((EditText) this.a.S90(2131371469));
        }
    }

    public static final class k implements View.OnClickListener {
        public final /* synthetic */ RoomIntroDialog a;

        public k(RoomIntroDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            RoomIntroDialog r5 = this.a;
            List<RoomIntroLabel> r0 = r5.h;
            if (UIUtils.isViewVisible(r5.S90(2131371469)) == false) goto L5;
            String r1 = String.valueOf(this.a.S90(2131371469).getText());
        L6:
            RoomIntroDialog.T90(r5, true, r0, r1);
            return;
        L5:
            r1 = this.a.j;
            goto L6
        }
    }

    public static final class l extends q0 {
        public final /* synthetic */ RoomIntroDialog a;

        public l(RoomIntroDialog r1) {
            this.a = r1;
        }

        public final void h(py.k r2, int r3, int r4) {
            int r5 = (r4 * (s1.y() - (s1.f(16.0f) * 2))) / r3;
            this.a.S90(2131375091).setMinimumHeight(r5);
            this.a.S90(2131375091).setClickable(false);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.roomintro.view.RoomIntroDialog$onViewCreated$10, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass10 extends MutablePropertyReference0Impl {
        public AnonymousClass10(RoomIntroDialog r7) {
            super(r7, RoomIntroDialog.class, "data", "getData()Lcom/bytedance/android/livesdk/interactivity/api/roomintro/api/RoomIntroResponse;", 0);
        }

        public Object get() {
            com.bytedance.android.livesdk.interactivity.api.roomintro.api.b r0 = ((RoomIntroDialog) ((CallableReference) this).receiver).e;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("data");
        L5:
            return r0;
        }

        public void set(Object r2) {
            com.bytedance.android.livesdk.interactivity.api.roomintro.api.b r3 = (com.bytedance.android.livesdk.interactivity.api.roomintro.api.b) r2;
            ((RoomIntroDialog) ((CallableReference) this).receiver).e = r3;
        }
    }

    static {
    }

    public final void U90() {
        if (this.g != null) goto L7;
        View r0 = LayoutInflater.from(getContext()).inflate(2131567491, (ViewGroup) S90(2131388161), false);
        this.g = r0;
        if (r0 == null) goto L7;
        r0.setOnClickListener(new b(this));
    L7:
        View r1 = this.g;
        if (r1 == null) goto L10;
        ViewParent r2 = r1.getParent();
    L11:
        if (r2 != null) goto L14;
        S90(2131388161).addView(this.g);
        V90("show");
        return;
    L14:
        return;
    L10:
        r2 = null;
        goto L11
    }

    public RoomIntroDialog() {
        this.d = new LinkedHashMap();
        setNoTitleAndCancelOutside(true);
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.k = true;
    }

    public final void onDestroyView() {
        super.onDestroyView();
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

    public final void V90(String r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("action_type", r4);
        b0 r5 = this.f;
        if (r5 == null) goto L5;
        String r6 = r5.a();
    L6:
        r0.put("anchor_id", String.valueOf(r6));
        b0 r7 = this.f;
        if (r7 != null) goto L9;
        String r8 = BuildConfig.FLAVOR;
    L13:
        r0.put("request_page", r8);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_room_detail_tag_add", r0, new Object[0]);
        return;
    L9:
        if (r7.a != null) goto L11;
        r8 = "live_start";
        goto L13
    L11:
        r8 = "live_room";
        goto L13
    L5:
        r6 = null;
        goto L6
    }

    public final View W90(RoomIntroLabel r8) {
        View r0 = LayoutInflater.from(getContext()).inflate(2131567490, (ViewGroup) S90(2131388161), false);
        HSImageView r1 = r0.findViewById(2131374718);
        TextView r2 = (TextView) r0.findViewById(2131388367);
        ImageView r4 = (ImageView) r0.findViewById(2131366972);
        String r5 = r8.getLabelText();
        if (r5 == null) goto L5;
        r2.setText(r5);
    L5:
        String r3 = r8.getLabelIconForAnchorSettingDialog();
        if (TextUtils.isEmpty(r3) == true) goto L8;
        UtilityKotlinExtentionsKt.w(r1);
        ImageModel r6 = new ImageModel();
        Intrinsics.checkNotNull(r3);
        r6.setUrls(CollectionsKt.mutableListOf(new String[]{r3}));
        Unit r7 = Unit.INSTANCE;
        ImageUtil.loadImage(r1, r6, 0);
    L9:
        r4.setOnClickListener(new c(this, r0, r8));
        return r0;
    L8:
        UtilityKotlinExtentionsKt.t(r1);
        goto L9
    }

    public final void X90(boolean r3) {
        if (r3 == false) goto L10;
        LinearLayout r4 = (LinearLayout) S90(2131377527);
        if (r4 == null) goto L7;
        UtilityKotlinExtentionsKt.t(r4);
    L7:
        LinearLayout r5 = (LinearLayout) S90(2131377484);
        if (r5 == null) goto L17;
        UtilityKotlinExtentionsKt.w(r5);
        return;
    L17:
        return;
    L10:
        LinearLayout r6 = (LinearLayout) S90(2131377527);
        if (r6 == null) goto L13;
        UtilityKotlinExtentionsKt.w(r6);
    L13:
        LinearLayout r7 = (LinearLayout) S90(2131377484);
        if (r7 == null) goto L19;
        UtilityKotlinExtentionsKt.t(r7);
        return;
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        r5.setGravity(80);
        r5.setLayout(-1, -2);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954638);
        setShouldUseNewPanel(true);
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        x0.a((EditText) S90(2131371469));     // Catch: Throwable -> L5
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

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        final TextView r10 = (TextView) r8.findViewById(2131388924);
        if (r10 == null) goto L5;
        int r0 = b1.a;
        b1.b(true, new RoomIntroDialog$onViewCreated$1$1(r10));
    L5:
        S90(2131387878).setOnCheckedChangeListener(new d(this));
        ImageUtil.loadRoundImage((ImageView) S90(2131389468), jc1.k.n(IUserService.class).user().b().getAvatarThumb());
        l r1 = new l(this);
        S90(2131375091).setOnClickListener(new e(this, r1));
        FrescoLoader.with(getContext()).load("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_broadcast_image_room_intro_demo.png").actualScaleType(ImageView.ScaleType.FIT_CENTER).controllerListener(new ImageLoader.e(null, r1, false)).placeholder(2131250137).into((ImageView) S90(2131375091));
        if (((Boolean) gr0.a.getValue()).booleanValue() == false) goto L16;
        S90(2131371469).setListener(new f(this));
        S90(2131371469).setPopDown(false);
        S90(2131371469).setAdjustSize(true);
        TextCorrectionEditText r2 = S90(2131371469);
        b0 r3 = this.f;
        if (r3 == null) goto L10;
        String r4 = r3.c();
    L11:
        r2.setLiveType(r4);
        TextCorrectionEditText r5 = S90(2131371469);
        b0 r6 = this.f;
        if (r6 == null) goto L14;
        String r7 = r6.a();
    L15:
        r5.setCurrentUserId(r7);
        S90(2131371469).addTextChangedListener(new g(this));
        goto L16
    L14:
        r7 = null;
        goto L15
    L10:
        r4 = null;
    L16:
        S90(2131371469).addTextChangedListener(new h(this));
        S90(2131371469).setOnEditorActionListener(i.a);
        ((TextView) S90(2131388525)).setOnClickListener(new j(this));
        S90(2131364848).setOnClickListener(new k(this));
        com.bytedance.android.livesdk.interactivity.api.roomintro.api.b r11 = this.e;
        if (r11 == null) goto L80;
        int r13 = p52.b.a;
        Intrinsics.checkNotNullParameter(r11, "data");
        List<RoomIntroLabel> r14 = r11.i();
        if (r14 == null) goto L23;
        List<RoomIntroLabel> r15 = r14;
        if ((!r15.isEmpty()) == false) goto L23;
        List<RoomIntroLabel> r16 = CollectionsKt.toMutableList(r15);
    L24:
        if (r16 != null) goto L26;
        r16 = new ArrayList();
    L26:
        this.h = r16;
        Intrinsics.checkNotNullParameter(r11, "data");
        List<RoomIntroLabel> r17 = r11.h();
        if (r17 == null) goto L31;
        List<RoomIntroLabel> r18 = r17;
        if ((!r18.isEmpty()) == false) goto L31;
        List<RoomIntroLabel> r19 = CollectionsKt.toMutableList(r18);
    L32:
        if (r19 != null) goto L34;
        r19 = new ArrayList();
    L34:
        this.i = r19;
        String r20 = r11.e();
        if (r20 != null) goto L37;
        r20 = BuildConfig.FLAVOR;
    L37:
        this.j = r20;
        Boolean r21 = r11.l();
        if (r21 == null) goto L40;
        boolean r23 = r21.booleanValue();
    L41:
        this.k = r23;
        if (r11.k() != S90(2131387878).isChecked()) goto L44;
        X90(r11.k());
    L45:
        Iterator<T> r24 = this.h.iterator();
    L47:
        if (r24.hasNext() == false) goto L50;
        S90(2131388161).addView(W90((RoomIntroLabel) r24.next()));
        goto L47
    L50:
        if ((!this.i.isEmpty()) == false) goto L52;
        U90();
    L52:
        StringCompanionObject r25 = StringCompanionObject.INSTANCE;
        ((TextView) S90(2131388525)).setText(Html.fromHtml(String.format("%s <img src=place_holder>", Arrays.copyOf(new Object[]{this.j}, 1)), new com.bytedance.android.livesdk.interactivity.roomintro.view.c(this), null));
        ArrayList r26 = new ArrayList();
        Iterator<T> r27 = this.i.iterator();
    L54:
        if (r27.hasNext() == false) goto L60;
        String r28 = ((RoomIntroLabel) r27.next()).getLabelIconForAnchorPickerDialog();
        if (r28 == null) goto L54;
        if (TextUtils.isEmpty(r28) == true) goto L54;
        r26.add(r28);
        goto L54
    L60:
        Iterator<T> r29 = this.h.iterator();
    L62:
        if (r29.hasNext() == false) goto L68;
        String r30 = ((RoomIntroLabel) r29.next()).getLabelIconForAnchorPickerDialog();
        if (r30 == null) goto L62;
        if (TextUtils.isEmpty(r30) == true) goto L62;
        r26.add(r30);
        goto L62
    L68:
        Iterator r31 = r26.iterator();
    L70:
        if (r31.hasNext() == false) goto L103;
        String r33 = (String) r31.next();
        IHostFrescoHelper r34 = jc1.k.f(IHostFrescoHelper.class);
        if (r34 == null) goto L74;
        String r35 = r34.getImageFilePath(r33);
    L76:
        if (TextUtils.isEmpty(r35) == false) goto L70;
        IHostFrescoHelper r36 = jc1.k.f(IHostFrescoHelper.class);
        if (r36 == null) goto L70;
        r36.tryDownloadImage(r33);
        goto L70
    L74:
        r35 = null;
        goto L76
    L103:
        return;
    L44:
        S90(2131387878).setChecked(r11.k());
        goto L45
    L40:
        r23 = true;
    L31:
        r19 = null;
    L23:
        r16 = null;
        goto L24
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565754, r3, false);
    }

    public static final void T90(RoomIntroDialog r13, boolean r14, List r15, String r16) {
        r13.getClass();
        if (r14 == true) goto L5;
    L7:
        IInteractService r1 = jc1.k.f(IInteractService.class);
        if (r1 == null) goto L18;
        kj0.b r2 = r1.getSelfDisciplineService();
        if (r2 == null) goto L18;
        if (r2.isSelfDisciplineOn() != true) goto L18;
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L18;
        kj0.b r3 = r0.getSelfDisciplineService();
        if (r3 == null) goto L18;
        r3.logUpdateRoomIntro(r16);
    L18:
        x0.a((EditText) r13.S90(2131371469));
        Long r4 = null;
        String r8 = GsonHelper.get().toJson(r15);     // Catch: Exception -> L21
    L22:
        RoomIntroApi r5 = (RoomIntroApi) com.bytedance.android.live.network.c.b().e(RoomIntroApi.class);
        b0 r17 = r13.f;
        if (r17 == null) goto L29;
        Room r18 = r17.a;
        if (r18 == null) goto L27;
        Long r19 = Long.valueOf(r18.id);
    L28:
        Long r6 = r19;
    L30:
        b0 r110 = r13.f;
        if (r110 == null) goto L33;
        String r7 = r110.c();
    L34:
        b0 r111 = r13.f;
        if (r111 == null) goto L37;
        r4 = r111.b();
    L37:
        Observable r112 = r5.updateRoomIntro(r6, r14, BuildConfig.FLAVOR, r16, r7, r4, r8, null, null, null).compose(RxUtil.rxSchedulerHelper());
        if (r112 == null) goto L46;
        ObservableSubscribeProxy r113 = (ObservableSubscribeProxy) r112.as(AutoDispose.bind(r13));
        if (r113 == null) goto L47;
        r113.subscribe(new com.bytedance.android.livesdk.interactivity.roomintro.view.k(r13, r14), new com.bytedance.android.livesdk.interactivity.roomintro.view.l(r13));
        return;
    L47:
        return;
    L46:
        return;
    L33:
        r7 = null;
        goto L34
    L27:
        r19 = null;
        goto L28
    L29:
        r6 = null;
    L21:
        r8 = null;
        goto L22
    L5:
        if (StringUtils.isEmpty(r16) == false) goto L7;
        String r114 = rm3.c.a;
        rm3.c.f(r13.getActivity(), 2131919922, true, 16);
    }
}
