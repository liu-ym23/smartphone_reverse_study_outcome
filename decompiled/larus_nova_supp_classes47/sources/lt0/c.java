package lt0;

import am2.x;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfilePoiInfo;
import com.bytedance.android.live.base.model.user.ProfileTagContent;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.standard.tag.view.PoiTagView;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.business.depend.IShowPoiSearchCallback;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import st0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class c implements jt0.b {

    public static final class a implements IShowPoiSearchCallback {
        public final /* synthetic */ c a;
        public final /* synthetic */ long b;
        public final /* synthetic */ NewProfileUser c;
        public final /* synthetic */ Fragment d;
        public final /* synthetic */ View e;

        /* JADX INFO: renamed from: lt0.c$a$a, reason: collision with other inner class name */
        public static final class C0270a<T> implements Consumer {
            public final /* synthetic */ a a;
            public final /* synthetic */ gz.b b;

            public C0270a(a r1, gz.b r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r9) {
                qs0.d.a r10 = (qs0.d.a) r9;
                boolean r0 = false;
                f2.b(2131915320, 0);
                a r12 = this.a;
                c r1 = r12.a;
                gz.b r2 = this.b;
                View r3 = r12.e;
                NewProfileUser r13 = r12.c;
                r1.getClass();
                Intrinsics.checkNotNullParameter(r2, "poiInfo");
                Intrinsics.checkNotNullParameter(r3, "view");
                Intrinsics.checkNotNullParameter(r13, "user");
                if (r2.a == true) goto L5;
            L33:
                ProfilePoiInfo r14 = r13.baseProfileInfo.poiInfo;
                if (r14 == null) goto L36;
                r14.setPoiId(0);
                r14.setPoiIdStr("");
                r14.setContent("");
            L36:
                r3.setVisibility(8);
                return;
            L5:
                if (r2.c.length() <= 0) goto L7;
                r0 = true;
            L7:
                if (r0 == false) goto L33;
                boolean r4 = r3 instanceof PoiTagView;
                if (r4 == true) goto L11;
                View r5 = null;
            L12:
                PoiTagView r6 = (PoiTagView) r5;
                if (r6 == null) goto L15;
                f r7 = r6.getDataModel();
            L16:
                String r8 = s1.B(2131915342);
                if (r7 == null) goto L19;
                r7.b = r8 + r13.baseProfileInfo.poiInfo.getCity() + " | " + r2.b;
            L19:
                ProfilePoiInfo r15 = r13.baseProfileInfo.poiInfo;
                if (r15 == null) goto L26;
                r15.setPoiId(CastLongProtector.parseLong(r2.c));
                r15.setPoiIdStr(r2.c);
                if (r7 == null) goto L24;
                String r16 = r7.b;
            L25:
                r15.setContent(r16);
                goto L26
            L24:
                r16 = null;
            L26:
                if (r7 == null) goto L40;
                if (r4 == true) goto L30;
                r3 = null;
            L30:
                PoiTagView r17 = (PoiTagView) r3;
                if (r17 == null) goto L38;
                r17.a(r7, r13);
                return;
            L38:
                return;
            L40:
                return;
            L15:
                r7 = null;
                goto L16
            L11:
                r5 = r3;
                goto L12
            }
        }

        public static final class b<T> implements Consumer {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Throwable r2 = (Throwable) r1;
            }
        }

        public final void onSearchFinish(gz.b r7) {
            Intrinsics.checkNotNullParameter(r7, "poiInfo");
            boolean r1 = false;
            if (r7.a == true) goto L5;
        L8:
            o r0 = os0.b.a();
            Observable<qs0.d.a> r2 = null;
            if (r0 == null) goto L15;
            m r3 = r0.getRoom();
            if (r3 == null) goto L15;
            IRoom r4 = (IRoom) r3.getValue();
            if (r4 == null) goto L15;
            Long r5 = Long.valueOf(r4.getRoomId());
        L16:
            qs0.d r6 = os0.b.c().getIBroadcastService();
            if (r6 == null) goto L28;
            if (r5 == null) goto L20;
            long r8 = r5.longValue();
        L22:
            if (r7.c.length() <= 0) goto L24;
            r1 = true;
        L24:
            if (r1 == false) goto L26;
            long r9 = CastLongProtector.parseLong(r7.c);
        L27:
            r2 = r6.f(r8, r9);
            goto L28
        L26:
            r9 = -1;
            goto L27
        L20:
            r8 = this.c.getLiveRoomId();
        L28:
            if (r2 == null) goto L35;
            Observable r10 = r2.compose(RxUtil.rxSchedulerHelper());
            if (r10 == null) goto L36;
            ObservableSubscribeProxy r12 = (ObservableSubscribeProxy) r10.as(AutoDispose.bind(this.d));
            if (r12 == null) goto L37;
            r12.subscribe(new C0270a(this, r7), b.a);
            return;
        L37:
            return;
        L36:
            return;
        L35:
            return;
        L15:
            r5 = null;
            goto L16
        L5:
            if (TextUtils.equals(String.valueOf(this.b), r7.c) == false) goto L8;
            f2.b(2131915319, 0);
        }

        public a(c r1, long r2, NewProfileUser r4, Fragment r5, View r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public c() {
    }

    @Override // jt0.b
    public final boolean b(ProfileTagContent r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "tagContent");
        Intrinsics.checkNotNullParameter(r3, "profileContext");
        return false;
    }

    @Override // jt0.b
    public boolean e(ProfileTagContent r2, NewProfileUser r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "tagContent");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        return true;
    }

    @Override // jt0.b
    public final ViewGroup.LayoutParams a() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    @Override // jt0.b
    public long getType() {
        return ProfileTagContent.TAG_TYPE_POI;
    }

    @Override // jt0.b
    public final View d(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new PoiTagView(r5, null, 6, 0);
    }

    @Override // jt0.b
    public final void f(NewProfileUser r4, h r5) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Intrinsics.checkNotNullParameter(r5, "profileContext");
        Intrinsics.checkNotNullParameter(r4, "user");
        Intrinsics.checkNotNullParameter(r5, "profileContext");
        HashMap r6 = new HashMap();
        r6.put("tag_type", "poi");
        r6.put("tag_order", DataType.TRUE);
        j0.l().sendLog("livesdk_tag_show", r6, new Object[]{x.class, IRoom.class});
    }

    @Override // jt0.b
    public final void g(ProfileTagContent r2, NewProfileUser r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "tagContent");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        jt0.b.a.a(r2, r3, r4);
    }

    @Override // jt0.b
    public final void h(ProfileTagContent r2, NewProfileUser r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "tagContent");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        jt0.b.a.b(r2, r3, r4);
    }

    @Override // jt0.b
    public final void c(Fragment r9, View r10, ProfileTagContent r12, h r13, NewProfileUser r14) {
        Intrinsics.checkNotNullParameter(r9, "fragment");
        Intrinsics.checkNotNullParameter(r12, "tagContent");
        Intrinsics.checkNotNullParameter(r13, "profileContext");
        Intrinsics.checkNotNullParameter(r14, "user");
        if (r10 != null) goto L5;
        return;
    L5:
        Context r15 = r9.getContext();
        if (r15 != null) goto L8;
        return;
    L8:
        o r16 = os0.b.a();
        if (r16 == null) goto L11;
        Boolean r17 = r16.isAnchor();
    L13:
        if (Intrinsics.areEqual(r17, Boolean.TRUE) == false) goto L58;
        BaseProfileInfo r18 = r14.baseProfileInfo;
        if (r18 == null) goto L57;
        ProfilePoiInfo r19 = r18.poiInfo;
        if (r19 == null) goto L67;
        long r3 = r19.getPoiId();
        if (r3 > 0) goto L21;
        return;
    L21:
        a r110 = new a(this, r3, r14, r9, r10);
        gz.a r20 = new gz.a();
        s1.w();
        Intrinsics.checkNotNullParameter(String.valueOf(r14.baseProfileInfo.poiInfo.getPoiId()), "<set-?>");
        o r111 = os0.b.a();
        if (r111 == null) goto L26;
        m r112 = r111.getRoom();
        if (r112 == null) goto L26;
        IRoom r113 = (IRoom) r112.getValue();
    L27:
        Map r114 = r20.a;
        String r1 = "";
        if (r113 == null) goto L33;
        IBaseUser r2 = r113.getOwner();
        if (r2 == null) goto L33;
        String r4 = r2.getIdString();
        if (r4 == null) goto L33;
    L34:
        r114.put("anchor_id", r4);
        r20.a.put("live_status", "living");
        Map r115 = r20.a;
        if (r113 == null) goto L40;
        String r116 = String.valueOf(r113.getId());
        if (r116 == null) goto L40;
        r1 = r116;
    L40:
        r115.put("room_id", r1);
        IMiddlewareHostBusiness r117 = k.f(IMiddlewareHostBusiness.class);
        if (r117 == null) goto L43;
        DialogFragment r22 = r117.getPoiSearchModalDialog(r15, r20, r110);
    L45:
        if ((r15 instanceof FragmentActivity) == true) goto L47;
        r15 = null;
    L47:
        FragmentActivity r118 = (FragmentActivity) r15;
        if (r118 == null) goto L68;
        FragmentManager r119 = r118.getSupportFragmentManager();
        if (r119 == null) goto L69;
        if (r22 == null) goto L70;
        LandscapeRestrictionOperation r120 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r22, "ProfileTag", r120);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r119, r22, r120) == true) goto L74;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L64
    L56:
        r22.showNow(r119, "ProfileTag");
        return;
    L74:
        return;
    L70:
        return;
    L69:
        return;
    L68:
        return;
    L43:
        r22 = null;
    L33:
        r4 = "";
    L26:
        r113 = null;
        goto L27
    L67:
        return;
    L57:
        return;
    L58:
        ProfilePoiInfo r121 = r14.baseProfileInfo.poiInfo;
        if (r121 != null) goto L61;
        return;
    L61:
        if (r121.getJumpSchema() == null) goto L73;
        k.n(IBaseLiveActionHandler.class).handle(r9.getContext(), r14.baseProfileInfo.poiInfo.getJumpSchema());
        Intrinsics.checkNotNullParameter(new HashMap(), "ext");
        HashMap r5 = new HashMap();
        r5.put("enter_method", "material_card");
        j0.l().g("enter_poi_detail", false, true, r5, new Object[]{x.class, IRoom.class});
        return;
    L73:
        return;
    L11:
        r17 = null;
        goto L13
    }
}
