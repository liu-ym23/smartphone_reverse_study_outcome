package com.bytedance.android.livesdk.chatroom.ui.behavior;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.api.login.ILoginGuideService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIHelper;
import com.bytedance.android.livesdk.castscreen.views.CastScreenViewModel;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.chatroom.room.p0;
import com.bytedance.android.livesdk.chatroom.ui.y6;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.utils.uhdLogin.UhdLoginManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.model.ListenLiveStatus;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/behavior/ToolbarVideoQualityBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarVideoQualityBehavior implements c0.b, Observer<KVData> {
    public static final /* synthetic */ int m = 0;
    public View a;
    public DataCenter b;
    public e c;
    public boolean d;
    public final CompositeDisposable e;
    public final Lazy f;
    public final ToolbarVideoQualityBehavior$observer$1 g;
    public boolean h;
    public final Context i;
    public final Room j;
    public final boolean k;
    public final View.OnClickListener l;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ToolbarVideoQualityBehavior a;
        public final /* synthetic */ IRoomEventHub b;
        public final /* synthetic */ LifecycleOwner c;

        public b(ToolbarVideoQualityBehavior r1, IRoomEventHub r2, LifecycleOwner r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            if (r3 == null) goto L5;
            int r4 = r3.intValue();
        L6:
            if (r4 <= 0) goto L9;
            ToolbarVideoQualityBehavior r5 = this.a;
            int r0 = ToolbarVideoQualityBehavior.m;
            r5.c();
            return;
        L9:
            return;
        L5:
            r4 = 0;
            goto L6
        }
    }

    public static final class c implements DialogInterface.OnDismissListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            xs2.b.a().post(new do1.b());
        }
    }

    public static final class d<T> implements androidx.lifecycle.Observer {
        public final /* synthetic */ ToolbarVideoQualityBehavior a;

        public d(ToolbarVideoQualityBehavior r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L6;
            ToolbarVideoQualityBehavior r3 = this.a;
            int r0 = ToolbarVideoQualityBehavior.m;
            r3.b();
            return;
        }
    }

    public static final class e<T> implements com.bytedance.android.livesdk.app.dataholder.Observer {
        public final /* synthetic */ ToolbarVideoQualityBehavior a;

        public e(ToolbarVideoQualityBehavior r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            if (r4 != null) goto L6;
            return;
        L6:
            if (r4.intValue() != 0) goto L11;
            ToolbarVideoQualityBehavior r5 = this.a;
            r5.d = false;
            View r6 = r5.a;
            if (r6 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("view");
        L10:
            r6.setAlpha(1.0f);
            return;
        L11:
            this.a.d = true;
            MiddlewareRoomContext r7 = o3.b();
            if (r7 == null) goto L23;
            m r8 = r7.getVsInChorusConcert();
            if (r8 != null) goto L16;
            return;
        L16:
            if (((Boolean) r8.getValue()).booleanValue() == true) goto L25;
            View r9 = this.a.a;
            if (r9 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("view");
        L20:
            r9.setAlpha(0.2f);
            return;
        L25:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ ToolbarVideoQualityBehavior a;
        public final /* synthetic */ DataCenter b;

        public f(ToolbarVideoQualityBehavior r1, DataCenter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            Lazy r0 = LiveByteCastUIHelper.a;
            if (LiveByteCastUIHelper.k(this.b) == false) goto L5;
            return;
        L5:
            if (r3.booleanValue() == false) goto L10;
            View r4 = this.a.a;
            if (r4 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("view");
        L9:
            r4.setVisibility(8);
            return;
        L10:
            View r5 = this.a.a;
            if (r5 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("view");
        L13:
            r5.setVisibility(0);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ ToolbarVideoQualityBehavior a;
        public final /* synthetic */ DataCenter b;

        public g(ToolbarVideoQualityBehavior r1, DataCenter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            ToolbarVideoQualityBehavior r5 = this.a;
            int r0 = ToolbarVideoQualityBehavior.m;
            r5.getClass();
            ILivePlayerClient r6 = LivePlatformPlayerManager.f();
            if (r6 == null) goto L9;
            IRoomEventHub r7 = r6.getEventHub();
            if (r7 == null) goto L9;
            MutableLiveData r8 = r7.getFirstFrame();
            if (r8 == null) goto L9;
            Boolean r9 = (Boolean) r8.getValue();
        L11:
            if (Intrinsics.areEqual(r9, Boolean.TRUE) == false) goto L13;
            this.a.c();
            return;
        L13:
            ILivePlayerClient r10 = LivePlatformPlayerManager.f();
            if (r10 == null) goto L22;
            IRoomEventHub r11 = r10.getEventHub();
            if (r11 == null) goto L23;
            MutableLiveData r12 = r11.getFirstFrame();
            if (r12 == null) goto L24;
            r12.observe(this.b.lifecycleOwner, this.a.g);
            return;
        L24:
            return;
        L23:
            return;
        L22:
            return;
        L9:
            r9 = null;
            goto L11
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void c() {
        int r0 = AudienceVideoResolutionManager.a;
        View r3 = null;
        if (AudienceVideoResolutionManager.o() == false) goto L5;
        String r1 = "自动";
    L63:
        if (r1 != null) goto L65;
    L68:
        boolean r4 = true;
    L69:
        if (r4 == true) goto L111;
        View r5 = this.a;
        if (r5 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L74:
        if (r5 == null) goto L110;
        CharSequence r6 = ((TextView) r5).getText();
        String r7 = "";
        if (r6 == null) goto L79;
        String r8 = r6.toString();
        if (r8 == null) goto L79;
    L81:
        if (Intrinsics.areEqual(r8, r1) == false) goto L83;
        return;
    L83:
        View r9 = this.a;
        if (r9 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L87:
        if ((r9 instanceof TextView) == false) goto L90;
        r3 = r9;
    L90:
        TextView r10 = (TextView) r3;
        if (r10 == null) goto L93;
        r10.setText(r1);
    L93:
        d(r1);
        View r2 = this.a;
        if (r2 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L96:
        View r11 = this.a;
        if (r11 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L99:
        if (r11 == null) goto L108;
        CharSequence r12 = ((TextView) r11).getText();
        if (r12 == null) goto L106;
        String r13 = r12.toString();
        if (r13 == null) goto L106;
        r7 = r13;
    L106:
        r3.c(r2, r7, true);
        return;
    L108:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L79:
        r8 = "";
        goto L81
    L110:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L111:
        return;
    L65:
        if (r1.length() == 0) goto L68;
        r4 = false;
        goto L69
    L5:
        nm1.m r14 = pm1.f.l();
        if (r14 != null) goto L8;
    L44:
        StreamUrl r15 = this.j.getStreamUrl();
        if (r15 == null) goto L62;
        List r16 = r15.getQualityList();
        if (r16 == null) goto L62;
        Iterator r17 = r16.iterator();
    L50:
        if (r17.hasNext() == false) goto L58;
        Object r18 = r17.next();
        String r19 = ((IQuality) r18).getSdkKey();
        ILivePlayerClient r20 = LivePlatformPlayerManager.f();
        if (r20 == null) goto L54;
        String r21 = r20.getCurrentResolution();
    L56:
        if (TextUtils.equals(r19, r21) == false) goto L50;
    L59:
        IQuality r22 = (IQuality) r18;
        if (r22 == null) goto L62;
        r1 = r22.getName();
        goto L63
    L54:
        r21 = null;
        goto L56
    L58:
        r18 = null;
    L62:
        r1 = null;
        goto L63
    L8:
        if (r14.a(this.b) != true) goto L44;
        nm1.m r23 = pm1.f.l();
        if (r23 == null) goto L12;
        IBaseStreamUrl r24 = r23.E(this.b);
    L13:
        if (r24 == null) goto L30;
        List r25 = r24.getQualityList();
        if (r25 == null) goto L30;
        Iterator r26 = r25.iterator();
    L18:
        if (r26.hasNext() == false) goto L26;
        Object r27 = r26.next();
        String r28 = ((IQuality) r27).getSdkKey();
        ILivePlayerClient r29 = LivePlatformPlayerManager.f();
        if (r29 == null) goto L22;
        String r30 = r29.getCurrentResolution();
    L24:
        if (TextUtils.equals(r28, r30) == false) goto L18;
    L27:
        IQuality r31 = (IQuality) r27;
        if (r31 == null) goto L30;
        String r32 = r31.getName();
    L31:
        if (r32 == null) goto L118;
        View r33 = this.a;
        if (r33 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L36:
        if ((r33 instanceof TextView) == false) goto L39;
        r3 = r33;
    L39:
        TextView r34 = (TextView) r3;
        if (r34 == null) goto L42;
        r34.setText(r32);
    L42:
        d(r32);
        return;
    L118:
        return;
    L22:
        r30 = null;
        goto L24
    L26:
        r27 = null;
    L30:
        r32 = null;
        goto L31
    L12:
        r24 = null;
        goto L13
    }

    public final void b() {
        ILivePlayerClient r0 = LivePlatformPlayerManager.f();
        LifecycleOwner r1 = null;
        if (r0 == null) goto L5;
        IRoomEventHub r2 = r0.getEventHub();
    L6:
        ILivePlayerClient r3 = LivePlatformPlayerManager.f();
        if (r3 == null) goto L9;
        r1 = r3.getLifecycleOwner();
    L9:
        if (r1 == null) goto L15;
        if (r2 == null) goto L16;
        MutableLiveData r4 = r2.getAbrSwitch();
        if (r4 == null) goto L17;
        r4.observe(r1, new b(this, r2, r1));
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final boolean a(Room r5) {
        Intrinsics.checkNotNullParameter(r5, "room");
        nm1.m r0 = pm1.f.l();
        if (r0 == null) goto L28;
        if (r0.a(this.b) != true) goto L28;
        nm1.m r6 = pm1.f.l();
        if (r6 == null) goto L9;
        IBaseStreamUrl r7 = r6.E(this.b);
    L10:
        if (r7 != null) goto L12;
    L19:
        if (r7 == null) goto L23;
        Set r8 = r7.getQualities();
        if (r8 == null) goto L23;
        int r9 = r8.size();
    L24:
        if (r9 <= 1) goto L47;
    L25:
        return true;
    L47:
        return false;
    L23:
        r9 = 0;
        goto L24
    L12:
        if (r7.isMultiPullDataValid() != true) goto L19;
        List r10 = r7.getQualityList();
        if (r10 == null) goto L16;
        int r11 = r10.size();
    L17:
        if (r11 > 1) goto L25;
        return false;
    L16:
        r11 = 0;
        goto L17
    L9:
        r7 = null;
    L28:
        if (r5.isMultiPullDataValid() == false) goto L37;
        StreamUrl r12 = r5.getStreamUrl();
        if (r12 == null) goto L34;
        List r13 = r12.getQualityList();
        if (r13 == null) goto L34;
        int r14 = r13.size();
    L35:
        if (r14 <= 1) goto L48;
    L44:
        return true;
    L48:
        return false;
    L34:
        r14 = 0;
        goto L35
    L37:
        StreamUrl r15 = r5.getStreamUrl();
        if (r15 == null) goto L42;
        Set r16 = r15.getQualities();
        if (r16 == null) goto L42;
        int r17 = r16.size();
    L43:
        if (r17 > 1) goto L44;
        return false;
    L42:
        r17 = 0;
        goto L43
    }

    public final void d(String r15) {
        View r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L6:
        if ((r0 instanceof TextView) == true) goto L8;
        r0 = null;
    L8:
        TextView r1 = (TextView) r0;
        if (r1 != null) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r15, "fhd") == true) goto L20;
        ILivePlayerClient r16 = LivePlatformPlayerManager.f();
        if (r16 == null) goto L15;
        String r17 = r16.getCurrentResolution();
    L17:
        if (Intrinsics.areEqual(r17, "fhd") == true) goto L20;
        r1.getPaint().setShader(null);
        return;
    L15:
        r17 = null;
    L20:
        r1.getPaint().setShader(new LinearGradient(0.0f, 0.0f, r1.getPaint().getTextSize() * r1.getText().length(), 0.0f, ArraysKt.toIntArray(new Integer[]{Integer.valueOf(ColorProtector.parseColor("#FFCA7E")), Integer.valueOf(ColorProtector.parseColor("#FFEECC")), Integer.valueOf(ColorProtector.parseColor("#FFCE95"))}), ArraysKt.toFloatArray(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.67f), Float.valueOf(1.0f)}), Shader.TileMode.CLAMP));
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        Intrinsics.checkNotNullParameter(r4, "kvData");
        if (TextUtils.isEmpty(r4.getKey()) == true) goto L27;
        String r5 = r4.getKey();
        int r0 = r5.hashCode();
        if (r0 == (-1477198303)) goto L19;
        if (r0 == 64125084) goto L16;
        if (r0 == 161190806) goto L13;
        return;
    L13:
        if (r5.equals("cmd_switch_resolution_success") == false) goto L22;
        c();
        return;
    L22:
        return;
    L16:
        if (r5.equals("data_video_resolution_degrade") == false) goto L24;
        c();
        return;
    L24:
        return;
    L19:
        if (r5.equals("data_switch_resolution_by_cast_screen") == false) goto L26;
        c();
        return;
    L26:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        ALogger.d("vsInChorusConcert", "onclick");
        HashMap<Integer, com.bytedance.android.livesdk.chatroom.utils.uhdLogin.a> r1 = UhdLoginManager.a;
        y6 r2 = null;
        RoomContext r3 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r3 == null) goto L43;
        m r4 = r3.getRoom();
        if (r4 == null) goto L43;
        Room r5 = (Room) r4.getValue();
        if (r5 == null) goto L43;
        if (r5.isMergeVSRoom() == true) goto L43;
        StreamUrl r8 = r5.getStreamUrl();
        if (r8 == null) goto L15;
        if (r8.getVPassDefault() == true) goto L43;
    L15:
        if (r5.isVrRoom() == true) goto L43;
        if (r5.isPaidRoom() == true) goto L43;
        StreamUrl r9 = r5.getStreamUrl();
        if (r9 == null) goto L43;
        if (r9.isMultiPullDataValid() != true) goto L43;
        StreamUrl r6 = r5.getStreamUrl();
        if (r6 == null) goto L39;
        List r7 = r6.getQualityList();
        if (r7 == null) goto L39;
        Iterator r10 = r7.iterator();
    L28:
        if (r10.hasNext() == false) goto L37;
        Object r11 = r10.next();
        IQuality r13 = (IQuality) r11;
        if (r13 != null) goto L32;
    L34:
        boolean r14 = false;
    L35:
        if (r14 == false) goto L28;
    L38:
        IQuality r15 = (IQuality) r11;
    L40:
        if (r15 == null) goto L43;
        boolean r16 = false;
    L44:
        RoomContext r17 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r17 == null) goto L60;
        i r18 = r17.isAnchor();
        if (r18 == null) goto L60;
        if (((Boolean) r18.getValue()).booleanValue() == true) goto L60;
        com.bytedance.android.livesdk.service.f r19 = TTLiveSDKContext.getHostService();
        if (r19 == null) goto L57;
        com.bytedance.android.livesdk.user.f r20 = r19.h();
        if (r20 == null) goto L57;
        if (r20.isLogin() != true) goto L57;
        boolean r21 = true;
    L58:
        if (r21 == false) goto L60;
        boolean r22 = true;
    L61:
        boolean r23 = !UhdLoginManager.c.a();
        ALogger.i("UhdLoginTimerManager", "Check result for uhd force login: roomFiltered: " + r16 + ", userFiltered: " + r22 + ", configFiltered: " + r23);
        if (r16 == true) goto L66;
        if (r22 == true) goto L66;
        if (r23 == true) goto L66;
        boolean r24 = true;
    L67:
        if (r24 == false) goto L74;
        k.n(ILoginGuideService.class).intercept(new q61.c(new q61.b.a(cz.c.d.c)));     // Catch: Exception -> L70
        return;
    L70:
        e = move-exception;
        ALogger.e("UhdLoginTimerManager", e.getMessage());
        return;
    L74:
        if (this.d == false) goto L82;
        MiddlewareRoomContext r25 = o3.b();
        if (r25 == null) goto L82;
        m r26 = r25.getVsInChorusConcert();
        if (r26 == null) goto L82;
        if (((Boolean) r26.getValue()).booleanValue() == true) goto L82;
        return;
    L82:
        DataCenter r27 = this.b;
        if (r27 == null) goto L90;
        ListenLiveStatus r28 = (ListenLiveStatus) r27.get("cmd_change_listen_live_status");
        if (r28 == null) goto L90;
        if (r28.isOpen() != true) goto L90;
        f2.b(2131918924, 0);
        return;
    L90:
        MiddlewareRoomContext r29 = o3.b();
        if (r29 == null) goto L98;
        m r30 = r29.getVsInChorusConcert();
        if (r30 == null) goto L98;
        if (((Boolean) r30.getValue()).booleanValue() != true) goto L98;
        ALogger.d("vsInChorusConcert", "onclick vsInChorusConcert true return");
        f2.c("连线状态下暂不支持切换清晰度", 0);
        return;
    L98:
        ALogger.d("vsInChorusConcert", "onclick continue");
        this.l.onClick(r12);
        y6 r110 = new y6(this.i, this.j, this.b);
        r110.setOnDismissListener(c.a);
        if (r110.isShowing() == true) goto L101;
        r2 = r110;
    L101:
        if (r2 != null) goto L103;
    L107:
        AudienceVideoResolutionManager.q();
        return;
    L103:
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L110;
        DialogLancet.handleBlockedDialogShow(r2);
        goto L107
    L110:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L109
    L106:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
    L66:
        r24 = false;
    L57:
        r21 = false;
    L60:
        r22 = false;
        goto L61
    L32:
        if (Intrinsics.areEqual(r13.getName(), "蓝光") == false) goto L34;
        r14 = true;
        goto L35
    L37:
        r11 = null;
    L39:
        r15 = null;
    L43:
        r16 = true;
        goto L44
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        DataCenter r4 = this.b;
        if (r4 == null) goto L5;
        r4.removeObserver(this);
    L5:
        this.b = null;
        e r5 = this.c;
        if (r5 == null) goto L8;
        hd0.c.f().e(r5);
    L8:
        this.e.clear();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r9, DataCenter r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        this.a = r9;
        this.b = r10;
        if (r9 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L6:
        if ((r9 instanceof TextView) == true) goto L8;
    L171:
        View r11 = this.a;
        if (r11 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L174:
        r11.setVisibility(8);
        return;
    L8:
        if (a(this.j) == false) goto L171;
        if (this.j.isMergeVSRoom() == false) goto L12;
    L30:
        View r12 = this.a;
        if (r12 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L34:
        if ((r12 instanceof TextView) == false) goto L42;
        View r13 = this.a;
        if (r13 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L38:
        if (r13 == null) goto L41;
        ((TextView) r13).setPadding(UtilityKotlinExtentionsKt.i(0), UtilityKotlinExtentionsKt.i(0), UtilityKotlinExtentionsKt.i(8), UtilityKotlinExtentionsKt.i(0));
        goto L42
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L42:
        r10.observe("cmd_switch_resolution_success", this);
        r10.observe("data_video_resolution_degrade", this);
        r10.observe("data_switch_resolution_by_cast_screen", this);
        View r14 = this.a;
        if (r14 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L45:
        if (r14 == null) goto L170;
        TextView r15 = (TextView) r14;
        r15.setVisibility(0);
        IQuality r5 = null;
        if (((Boolean) this.f.getValue()).booleanValue() == false) goto L60;
        StreamUrl r4 = this.j.getStreamUrl();
        if (r4 == null) goto L57;
        List r6 = r4.getQualityList();
        if (r6 == null) goto L57;
        IQuality r7 = AudienceVideoResolutionManager.d(r6);
        if (r7 == null) goto L55;
        String r8 = r7.getName();
    L56:
        if (r8 == null) goto L57;
    L68:
        if (r8 == null) goto L71;
        r15.setText(r8);
        d(r8);
    L71:
        if (this.k == false) goto L73;
    L76:
        Room r16 = this.j;
        int r17 = com.bytedance.android.livesdk.utils.landscape.d.a;
        if (r16 == null) goto L79;
        boolean r18 = r16.isMediaRoom();
    L80:
        if (r18 == false) goto L82;
    L81:
        r15.setBackgroundResource(0);
    L82:
        this.c = new e(this);
        hd0.c.f().c(this.c);
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r19 = CastScreenViewModel.a.b(r10);
        if (r19 == null) goto L92;
        m r20 = r19.getCastOrMirrorScreenMode();
        if (r20 == null) goto L92;
        Observable r21 = r20.a();
        if (r21 == null) goto L92;
        Disposable r22 = r21.subscribe(new f(this, r10));
        if (r22 == null) goto L92;
        RxUtilKt.c(r22, this.e);
    L92:
        if (LiveByteCastUIHelper.k(r10) == true) goto L103;
        CastScreenViewModel r23 = CastScreenViewModel.a.a();
        if (r23 == null) goto L103;
        m r24 = r23.getCastOrMirrorScreenMode();
        if (r24 == null) goto L103;
        if (((Boolean) r24.getValue()).booleanValue() != true) goto L103;
        View r25 = this.a;
        if (r25 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L102:
        r25.setVisibility(8);
    L103:
        RoomContext r26 = RoomContext.a.c(RoomContext.Companion, r10, 0, 2);
        if (r26 == null) goto L112;
        m r27 = r26.getCameraId();
        if (r27 == null) goto L112;
        Observable r28 = r27.a();
        if (r28 == null) goto L112;
        Disposable r29 = r28.subscribe(new g(this, r10));
        if (r29 == null) goto L112;
        RxUtilKt.c(r29, this.e);
    L112:
        LifecycleOwner r30 = r10.lifecycleOwner;
        if (r30 == null) goto L120;
        p0 r110 = (p0) r10.get("zygote_event_hub", null);
        if (r110 == null) goto L117;
        NextLiveData r111 = r110.getSwitchStreamDataEvent();
    L118:
        if (r111 == null) goto L120;
        r111.observe(r30, new d(this));
        goto L120
    L117:
        r111 = null;
    L120:
        b();
        if (this.h == true) goto L137;
        this.h = true;
        IVSPlayerService r31 = (IVSPlayerService) k.f(IVSPlayerService.class);
        if (r31 == null) goto L126;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r32 = r31.provideVSPlayerViewControlService(this.b);
    L127:
        if (r32 == null) goto L137;
        VSPlayerViewControlContext r33 = r32.provideContext();
        if (r33 == null) goto L137;
        m<Boolean> r34 = r33.getPlayerViewVisibleTriggeredByUser();
        if (r34 == null) goto L137;
        Observable r35 = r34.a();
        if (r35 == null) goto L137;
        Observable r36 = r35.filter(com.bytedance.android.livesdk.chatroom.ui.behavior.d.a);
        if (r36 == null) goto L137;
        r36.subscribe(new com.bytedance.android.livesdk.chatroom.ui.behavior.e(this));
        goto L137
    L126:
        r32 = null;
    L137:
        int r37 = AudienceVideoResolutionManager.a;
        if (((Boolean) this.f.getValue()).booleanValue() == false) goto L148;
        StreamUrl r38 = this.j.getStreamUrl();
        if (r38 == null) goto L145;
        List r39 = r38.getQualityList();
        if (r39 == null) goto L145;
        IQuality r40 = AudienceVideoResolutionManager.d(r39);
        if (r40 == null) goto L145;
    L150:
        r5 = r40;
    L154:
        AudienceVideoResolutionManager.r(r5, "icon");
        View r41 = this.a;
        if (r41 != null) goto L157;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L157:
        View r112 = this.a;
        if (r112 != null) goto L160;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L160:
        if (r112 == null) goto L168;
        CharSequence r113 = ((TextView) r112).getText();
        if (r113 == null) goto L165;
        String r114 = r113.toString();
        if (r114 == null) goto L165;
    L166:
        r3.c(r41, r114, true);
        return;
    L165:
        r114 = "";
        goto L166
    L168:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L145:
        StreamUrl r42 = this.j.getStreamUrl();
        if (r42 == null) goto L154;
        r5 = r42.getMultiDefaultQuality();
        goto L154
    L148:
        r40 = AudienceVideoResolutionManager.c();
        if (r40 != null) goto L150;
        StreamUrl r43 = this.j.getStreamUrl();
        if (r43 == null) goto L154;
        r5 = r43.getMultiDefaultQuality();
        goto L154
    L79:
        r18 = false;
        goto L80
    L73:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(r10) == true) goto L81;
        if (VSMediaUIConfigHelper.b(r10) == true) goto L81;
    L55:
        r8 = null;
    L57:
        StreamUrl r44 = this.j.getStreamUrl();
        if (r44 == null) goto L67;
        r8 = r44.getDefaultQuality();
    L67:
        r8 = null;
        goto L68
    L60:
        LiveCoreSDKData.Quality r45 = AudienceVideoResolutionManager.c();
        if (r45 == null) goto L64;
        r8 = r45.getName();
        if (r8 != null) goto L68;
    L64:
        StreamUrl r46 = this.j.getStreamUrl();
        if (r46 == null) goto L67;
        r8 = r46.getDefaultQuality();
        goto L68
    L170:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L12:
        if (VSMediaUIConfigHelper.b(r10) == true) goto L30;
        if (m50.a.getValue().a() == false) goto L42;
        if (this.j.isMediaRoom() == true) goto L42;
        View r47 = this.a;
        if (r47 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L22:
        if ((r47 instanceof TextView) == false) goto L42;
        View r48 = this.a;
        if (r48 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L26:
        if (r48 == null) goto L29;
        ((TextView) r48).setPadding(UtilityKotlinExtentionsKt.i(0), UtilityKotlinExtentionsKt.i(0), UtilityKotlinExtentionsKt.i(0), UtilityKotlinExtentionsKt.i(0));
        goto L42
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.livesdk.chatroom.ui.behavior.ToolbarVideoQualityBehavior$observer$1] */
    public ToolbarVideoQualityBehavior(Context r2, Room r3, boolean r4, View.OnClickListener r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "mRoom");
        Intrinsics.checkNotNullParameter(r5, "onClickListener");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.e = new CompositeDisposable();
        this.f = LazyKt.lazy(ToolbarVideoQualityBehavior$landscapeQualityToolbarFixEnable$2.INSTANCE);
        this.g = new ToolbarVideoQualityBehavior$observer$1(this);
    }
}
