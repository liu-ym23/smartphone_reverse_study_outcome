package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.browser.GsonMap;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profile.model.EnterExitStateType;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profit.player.profilepreview.ProfilePreviewEvent;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.gson.JsonObject;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i extends com.bytedance.android.live.profile.ui.base.k {
    public final CompositeDisposable b;
    public uu0.a c;
    public final com.bytedance.android.live.profile.ui.base.h d;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ com.bytedance.android.live.profile.ui.base.d a;
        public final /* synthetic */ ConstraintLayout b;

        public a(com.bytedance.android.live.profile.ui.base.e r1, ConstraintLayout r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            ALogger.w("DressProfilePreview", "layout changed");
            this.a.d((int) ((this.b.getHeight() / 2) - j.b));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ com.bytedance.android.live.profit.player.d a;
        public final /* synthetic */ uu0.b b;

        public b(com.bytedance.android.live.profit.player.d r1, uu0.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.profile.model.a r5 = (com.bytedance.android.live.profile.model.a) r4;
            PublishSubject r0 = this.a.x1();
            if (r0 == null) goto L22;
            EnterExitStateType r6 = r5.a;
            int r7 = g.a[r6.ordinal()];
            if (r7 != 1) goto L7;
            r0.onNext(new ProfilePreviewEvent(ProfilePreviewEvent.EventType.EnterStart, this.b));
            return;
        L7:
            if (r7 != 2) goto L9;
            r0.onNext(new ProfilePreviewEvent(ProfilePreviewEvent.EventType.EnterEnd, this.b));
            return;
        L9:
            if (r7 != 3) goto L11;
            r0.onNext(new ProfilePreviewEvent(ProfilePreviewEvent.EventType.ExitStart, this.b));
            return;
        L11:
            if (r7 != 4) goto L13;
            r0.onNext(new ProfilePreviewEvent(ProfilePreviewEvent.EventType.ExitEnd, this.b));
            return;
        L13:
            if (r7 != 5) goto L27;
            r0.onNext(new ProfilePreviewEvent(ProfilePreviewEvent.EventType.ExitStart, this.b));
            r0.onNext(new ProfilePreviewEvent(ProfilePreviewEvent.EventType.ExitEnd, this.b));
            return;
        L27:
            return;
        L22:
            throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<com.bytedance.android.live.profit.player.profilepreview.ProfilePreviewEvent>");
        }
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        ALogger.i("DressProfilePreview", "ProfileDressPreviewComponent.onComponentDestroy");
        uu0.a r0 = this.c;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        this.b.dispose();
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.DressPreview.INSTANCE;
    }

    public i(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.d = r2;
        this.b = new CompositeDisposable();
    }

    public static Map j(uu0.b r5) {
        boolean r0 = true;
        Pair[] r1 = new Pair[1];
        if ((r5 instanceof uu0.b.a) == false) goto L6;
        String r2 = "enter_effect";
    L9:
        r1[0] = TuplesKt.to("request_page", r2);
        Map r3 = MapsKt.mutableMapOf(r1);
        String r4 = r5.b.getLogExtra();
        if (r4 != null) goto L12;
    L15:
        if (r0 == false) goto L33;
        Map r6 = MapsKt.emptyMap();
    L31:
        r3.putAll(r6);
        r3.putAll(r5.a);
        return r3;
    L33:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L23
        GsonMap r8 = UtilsKt.i((JsonObject) GsonHelper.get().fromJson(r4, JsonObject.class));     // Catch: Throwable -> L23
        LinkedHashMap r9 = new LinkedHashMap(MapsKt.mapCapacity(r8.size()));     // Catch: Throwable -> L23
        Iterator r10 = r8.entrySet().iterator();     // Catch: Throwable -> L23
    L19:
        if (r10.hasNext() == false) goto L21;
        Object r12 = r10.next();     // Catch: Throwable -> L23
        r9.put(((Map.Entry) r12).getKey(), String.valueOf(((Map.Entry) r12).getValue()));     // Catch: Throwable -> L23
        goto L19
    L21:
        Object r13 = Result.constructor-impl(r9);     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r13) == false) goto L28;
        r13 = null;
    L28:
        r6 = (Map) r13;
        if (r6 != null) goto L31;
        r6 = MapsKt.emptyMap();
    L23:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L12:
        if (StringsKt.isBlank(r4) == true) goto L15;
        r0 = false;
        goto L15
    L6:
        if ((r5 instanceof uu0.b.C0330b) == false) goto L8;
        r2 = "gift_tray";
        goto L9
    L8:
        r2 = "";
        goto L9
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r18) {
        ALogger.i("DressProfilePreview", "ProfileDressPreviewComponent.initView");
        Context r3 = r18.getContext();
        if (r3 != null) goto L6;
        return;
    L6:
        if (ProfilePreInflateUtil.a() == true) goto L69;
        ConstraintLayout r0 = ((com.bytedance.android.live.profile.ui.base.e) r18).f(2131567200, false);
        if (r0 == null) goto L68;
        ConstraintLayout r1 = r0;
    L26:
        com.bytedance.android.live.profit.player.d r6 = yt0.c.h();
        if (r6 != null) goto L29;
        return;
    L29:
        uu0.a r4 = r6.hd(r3);
        if (r4 != null) goto L33;
        ALogger.w("DressProfilePreview", "profile preview view create failed");
        return;
    L33:
        uu0.b r7 = r4.getPreviewData();
        if (r7 != null) goto L37;
        ALogger.w("DressProfilePreview", "no preview data");
        return;
    L37:
        com.bytedance.android.live.profile.ui.base.e r9 = (com.bytedance.android.live.profile.ui.base.e) r18;
        r1.addOnLayoutChangeListener(new a(r9, r1));
        ((FrameLayout) r1.findViewById(2131389703)).addView(r4.a(), -2, -2);
        com.bytedance.android.live.profit.dress.config.h r8 = r7.b;
        View r10 = r1.findViewById(2131389561);
        com.bytedance.android.live.profit.dress.config.d r12 = r8.getButtonConfig();
        if (r12 != null) goto L40;
    L58:
        r10.setVisibility(4);
    L59:
        r9.g(r1);
        RxUtilKt.c(this.d.getEnterExitState().forEach(new b(r6, r7)), this.b);
        r4.c();
        this.d.sendLog("livesdk_profile_card_float_show", j(r7), new Object[]{am2.x.class, IRoom.class});
        if ((r7 instanceof uu0.b.a) == false) goto L63;
        this.d.recordBusinessShow(TrackArea.TopWhiteArea, "enter_effect_float_show");
    L65:
        ALogger.w("DressProfilePreview", "preview view created");
        this.c = r4;
        return;
    L63:
        if ((r7 instanceof uu0.b.C0330b) == false) goto L65;
        this.d.recordBusinessShow(TrackArea.TopWhiteArea, "gift_tray_float_show");
        goto L65
    L40:
        if (r12.getEnable() == false) goto L58;
        if (StringsKt.isBlank(r12.getText()) == true) goto L58;
        ShapeDrawable r13 = new ShapeDrawable();
        float[] r14 = new float[8];
        int r15 = 0;
    L45:
        if (r15 >= 8) goto L47;
        r14[r15] = j.a;
        r15 = r15 + 1;
        goto L45
    L47:
        r13.setShape(new RoundRectShape(r14, null, null));
        Paint r5 = r13.getPaint();
        com.bytedance.android.live.profit.dress.config.d r16 = r8.getButtonConfig();
        if (r16 == null) goto L51;
        String r17 = r16.getBgColor();
        if (r17 == null) goto L51;
    L52:
        r5.setColor(ColorProtector.parseColor(r17));
        Unit r19 = Unit.INSTANCE;
        r10.setBackground(r13);
        TextView r20 = (TextView) r10.findViewById(2131389562);
        r20.setText(r12.getText());
        com.bytedance.android.live.profit.dress.config.d r22 = r8.getButtonConfig();
        if (r22 == null) goto L56;
        String r23 = r22.getColor();
        if (r23 == null) goto L56;
    L57:
        r20.setTextColor(ColorProtector.parseColor(r23));
        r10.setOnClickListener(new h(this, r12, r1, r7));
        k("livesdk_package_center_get_same_show", r7);
        this.d.recordBusinessShow(TrackArea.TopWhiteArea, "get_same_dress_button");
    L56:
        r23 = "#FFFFFF";
    L51:
        r17 = "#7F209B79";
        goto L52
    L68:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L69:
        View r2 = ((com.bytedance.android.live.profile.ui.base.e) r18).b(ProfilePreInflateViewInfo.TTLIVE_PROFILE_DRESS_PREVIEW, false);     // Catch: Exception -> L11
        if (r2 == null) goto L13;
        r1 = r2.findViewById(2131384813);     // Catch: Exception -> L11
    L14:
        if (r1 != null) goto L26;
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");     // Catch: Exception -> L11
    L13:
        r1 = null;
    L11:
        e = move-exception;
        ALogger.e("NewUserProfile_PreLayout", "get dress preview preInflate layout error: " + e.getMessage());
        ConstraintLayout r24 = ((com.bytedance.android.live.profile.ui.base.e) r18).f(2131567200, false);
        if (r24 == null) goto L22;
        r1 = r24;
        goto L26
    L22:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileDressPreviewComponent update");
    }

    public final void k(String r5, uu0.b r6) {
        com.bytedance.android.live.profile.ui.base.h r0 = this.d;
        Map<String, String> r7 = j(r6);
        r7.put("show_from", "profile_card");
        UserProfileEvent r1 = this.d.getUserProfileEvent();
        if (r1 == null) goto L6;
        String r2 = r1.getClickUserPosition();
        if (r2 == null) goto L6;
    L7:
        r7.put("request_page", r2);
        Unit r3 = Unit.INSTANCE;
        r0.sendLog(r5, r7, new Object[]{am2.x.class, IRoom.class});
        return;
    L6:
        r2 = "";
        goto L7
    }
}
