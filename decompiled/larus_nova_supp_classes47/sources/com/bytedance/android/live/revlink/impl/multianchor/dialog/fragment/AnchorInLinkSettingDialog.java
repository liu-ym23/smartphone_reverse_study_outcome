package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPKTimeDialogFragment;
import com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/AnchorInLinkSettingDialog;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/LinkCommonDialogFragment;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/InteractPKTimeDialogFragment$b;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorInLinkSettingDialog extends LinkCommonDialogFragment implements InteractPKTimeDialogFragment.b {
    public static final /* synthetic */ int G = 0;
    public View A;
    public ImageView B;
    public View C;
    public Switch D;
    public boolean E;
    public final boolean F;
    public Map<Integer, View> e;
    public IRoom f;
    public long g;
    public boolean h;
    public final CompositeDisposable i;
    public View j;
    public Switch k;
    public View l;
    public TextView m;
    public ViewGroup n;
    public ViewGroup o;
    public TextView p;
    public FrameLayout q;
    public ViewGroup r;
    public Switch s;
    public Switch t;
    public Switch u;
    public Switch v;
    public Switch w;
    public Switch x;
    public View y;
    public View z;

    public static final class a {
        public a() {
        }

        public static AnchorInLinkSettingDialog a(IRoom r4, boolean r5, int r6) {
            int r0 = AnchorInLinkSettingDialog.G;
            boolean r1 = false;
            if ((r6 & 2) == 0) goto L6;
            r5 = false;
        L6:
            if ((r6 & 4) == 0) goto L8;
            r1 = com.bytedance.android.live.revlink.impl.multianchor.utils.y.e();
        L8:
            Intrinsics.checkNotNullParameter(r4, "room");
            AnchorInLinkSettingDialog r7 = new AnchorInLinkSettingDialog();
            r7.f = r4;
            com.bytedance.android.livesdk.revenue.service.room.c r8 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
            if (r8 == null) goto L13;
            com.bytedance.android.livesdk.revenue.room.a r9 = r8.getRoomContext();
            if (r9 == null) goto L13;
            r9.getCommonIsAnchor();
        L13:
            LinkCrossRoomDataHolder r10 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r10 == null) goto L16;
            long r2 = r10.c();
        L17:
            r7.g = r2;
            r7.h = r5;
            r7.E = r1;
            return r7;
        L16:
            r2 = 0;
            goto L17
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AnchorInLinkSettingDialog a;

        public b(AnchorInLinkSettingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            zg1.d r4 = (zg1.d) sh6.c.b((sh6.b) r3);
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.b == false) goto L7;
        L9:
            boolean r5 = false;
        L10:
            if (r5 == true) goto L19;
            return;
        L19:
            this.a.dismiss();     // Catch: Exception -> L14
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r6 = DialogFragmentLancet.sLastShowStack;
            if (r6 == null) goto L23;
            com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L23:
            return;
        L7:
            if (r4.c == true) goto L9;
            r5 = true;
            goto L10
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AnchorInLinkSettingDialog a;

        public c(AnchorInLinkSettingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            boolean r4 = com.bytedance.android.live.revlink.impl.multianchor.profit.c.a(((Integer) r3).intValue());
            Switch r0 = this.a.k;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("switchShowExtScore");
        L5:
            r0.setChecked(r4);
            ViewGroup r1 = this.a.n;
            if (r1 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("clearExtScoreLayout");
        L8:
            UtilityKotlinExtentionsKt.z(r1, r4);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ AnchorInLinkSettingDialog a;

        public d(AnchorInLinkSettingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            Switch r0 = this.a.t;
            if (r0 == null) goto L6;
            r0.setChecked(!Intrinsics.areEqual(r4, Boolean.TRUE));
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ AnchorInLinkSettingDialog a;

        public e(AnchorInLinkSettingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            Switch r0 = this.a.v;
            if (r0 == null) goto L6;
            r0.setChecked(!Intrinsics.areEqual(r4, Boolean.TRUE));
            return;
        }
    }

    public static final class f implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ AnchorInLinkSettingDialog a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ boolean a;

            public a(boolean r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                ExtraResponse r4 = (ExtraResponse) r3;
                l51.a.K(this.a);
                com.bytedance.android.live.revlink.impl.global.c r5 = com.bytedance.android.live.revlink.impl.global.b.k();
                if (r5 == null) goto L12;
                com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r6 = r5.Ig();
                if (r6 == null) goto L12;
                LiveData<PkBaseStateMachine.c> r7 = r6.getPkBaseState();
                if (r7 == null) goto L12;
                PkBaseStateMachine.c r8 = (PkBaseStateMachine.c) r7.getValue();
                if (r8 == null) goto L12;
                RevPkState r9 = r8.c();
                if (r9 == null) goto L12;
            L14:
                if (r9 == RevPkState.FINISHED) goto L23;
                if (r9 == RevPkState.DISABLE) goto L23;
                if (this.a == true) goto L21;
                ToastUtil.a(2131914757, 0);
                return;
            L21:
                ToastUtil.a(2131914760, 0);
                return;
            L23:
                if (this.a == true) goto L28;
                ToastUtil.a(2131916224, 0);
                return;
            L28:
                return;
            L12:
                r9 = RevPkState.DISABLE;
                goto L14
            }
        }

        public f(AnchorInLinkSettingDialog r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r7, boolean r8) {
            if (this.a.F == false) goto L8;
            ToastUtil.a(2131920567, 0);
            Switch r9 = this.a.u;
            if (r9 == null) goto L31;
            r9.setChecked(!r8);
            return;
        L31:
            return;
        L8:
            HashMap r5 = new HashMap();
            r5.put("auto_start_prop_card", Boolean.valueOf(r8));
            if (AnchorInLinkSettingDialog.T90(this.a) == null) goto L21;
            r31.a r0 = r31.b.a(r31.a.a);
            long r1 = AnchorInLinkSettingDialog.T90(this.a).getId();
            if (AnchorInLinkSettingDialog.T90(this.a).getOwner() == null) goto L13;
            IBaseUser r10 = AnchorInLinkSettingDialog.T90(this.a).getOwner();
            Intrinsics.checkNotNull(r10);
            String r12 = com.bytedance.android.live.base.model.user.o.a(r10);
        L14:
            Observable<ExtraResponse<Object, Extra>> r13 = r0.updateAnchorLinkSetting(r1, r12, 9, r5);
            if (r13 == null) goto L21;
            Observable r14 = r13.compose(RxUtil.rxSchedulerHelper());
            if (r14 == null) goto L21;
            Disposable r15 = r14.subscribe(new a(r8));
            if (r15 == null) goto L21;
            this.a.i.add(r15);
            goto L21
        L13:
            r12 = null;
        L21:
            HashMap r16 = new HashMap();
            w31.c r2 = com.bytedance.android.live.revlink.impl.global.b.T();
            if (r2 == null) goto L24;
            Map<String, String> r3 = r2.f();
        L25:
            r16.putAll(r3);
            if (r8 == false) goto L28;
            String r17 = "on";
        L29:
            r16.put("switch", r17);
            mz0.n r18 = new mz0.n();
            Map<String, String> r4 = r18.a;
            Intrinsics.checkNotNullParameter(r4, "map");
            Intrinsics.checkNotNullParameter(r16, "map");
            r4.putAll(r16);
            mz0.m r19 = new mz0.m();
            r19.b(LogCommon.PAGE_SOURCE_LOG);
            r19.b(LogCommon.ROOM);
            ((ArrayList) r18.b).addAll(r19.a);
            cy0.e.a.getClass();
            cy0.j r20 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r22 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r22);
            ((mz0.i) ((f80.a) r22)).w3("livesdk_connection_buffer_card_use_setting_click", r18.a, r18.b);
            return;
        L28:
            r17 = "off";
            goto L29
        L24:
            r3 = MapsKt.emptyMap();
            goto L25
        }
    }

    public static final class g implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ AnchorInLinkSettingDialog a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ boolean a;

            public a(boolean r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                ExtraResponse r4 = (ExtraResponse) r3;
                l51.a.L(this.a);
                com.bytedance.android.live.revlink.impl.global.c r5 = com.bytedance.android.live.revlink.impl.global.b.k();
                if (r5 == null) goto L12;
                com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r6 = r5.Ig();
                if (r6 == null) goto L12;
                LiveData<PkBaseStateMachine.c> r7 = r6.getPkBaseState();
                if (r7 == null) goto L12;
                PkBaseStateMachine.c r8 = (PkBaseStateMachine.c) r7.getValue();
                if (r8 == null) goto L12;
                RevPkState r9 = r8.c();
                if (r9 == null) goto L12;
            L14:
                if (r9 == RevPkState.FINISHED) goto L23;
                if (r9 == RevPkState.DISABLE) goto L23;
                if (this.a == true) goto L21;
                ToastUtil.a(2131914758, 0);
                return;
            L21:
                ToastUtil.a(2131914761, 0);
                return;
            L23:
                if (this.a == true) goto L28;
                ToastUtil.a(2131916226, 0);
                return;
            L28:
                return;
            L12:
                r9 = RevPkState.DISABLE;
                goto L14
            }
        }

        public g(AnchorInLinkSettingDialog r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r7, boolean r8) {
            HashMap r5 = new HashMap();
            r5.put("auto_start_steal_dragon", Boolean.valueOf(r8));
            if (AnchorInLinkSettingDialog.T90(this.a) == null) goto L15;
            r31.a r0 = r31.b.a(r31.a.a);
            long r1 = AnchorInLinkSettingDialog.T90(this.a).getId();
            if (AnchorInLinkSettingDialog.T90(this.a).getOwner() == null) goto L7;
            IBaseUser r9 = AnchorInLinkSettingDialog.T90(this.a).getOwner();
            Intrinsics.checkNotNull(r9);
            String r10 = com.bytedance.android.live.base.model.user.o.a(r9);
        L8:
            Observable<ExtraResponse<Object, Extra>> r12 = r0.updateAnchorLinkSetting(r1, r10, 10, r5);
            if (r12 == null) goto L15;
            Observable r13 = r12.compose(RxUtil.rxSchedulerHelper());
            if (r13 == null) goto L15;
            Disposable r14 = r13.subscribe(new a(r8));
            if (r14 == null) goto L15;
            this.a.i.add(r14);
            goto L15
        L7:
            r10 = null;
        L15:
            HashMap r15 = new HashMap();
            w31.c r2 = com.bytedance.android.live.revlink.impl.global.b.T();
            if (r2 == null) goto L18;
            Map<String, String> r3 = r2.f();
        L19:
            r15.putAll(r3);
            if (r8 == false) goto L22;
            String r16 = "on";
        L23:
            r15.put("switch", r16);
            r15.put("setting_partition", "pk");
            r15.put("setting_sub_partition", "pk_dragon");
            mz0.n r17 = new mz0.n();
            Map<String, String> r4 = r17.a;
            Intrinsics.checkNotNullParameter(r4, "map");
            Intrinsics.checkNotNullParameter(r15, "map");
            r4.putAll(r15);
            mz0.m r18 = new mz0.m();
            r18.b(LogCommon.PAGE_SOURCE_LOG);
            r18.b(LogCommon.ROOM);
            List<Object> r6 = r17.b;
            ArrayList r19 = (ArrayList) r6;
            r19.addAll(r18.a);
            cy0.e.a.getClass();
            cy0.j r20 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r22 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r22);
            ((mz0.i) ((f80.a) r22)).w3("livesdk_anchor_interation_invitation_setting_switch", r17.a, r17.b);
            return;
        L22:
            r16 = "off";
            goto L23
        L18:
            r3 = MapsKt.emptyMap();
            goto L19
        }
    }

    public static final class h implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ AnchorInLinkSettingDialog a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ boolean a;

            public a(boolean r1) {
                this.a = r1;
            }

            public final void accept(Object r4) {
                ExtraResponse r5 = (ExtraResponse) r4;
                l51.a.O(this.a);
                if (this.a == true) goto L5;
                ToastUtil.a(2131914759, 0);
            L5:
                HashMap r6 = new HashMap();
                w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
                if (r0 == null) goto L8;
                Map<String, String> r1 = r0.f();
            L9:
                r6.putAll(r1);
                if (this.a == false) goto L12;
                String r2 = "on";
            L13:
                r6.put("switch", r2);
                r6.put("setting_partition", "pk");
                r6.put("setting_sub_partition", "egg");
                mz0.n r3 = new mz0.n();
                Map<String, String> r7 = r3.a;
                Intrinsics.checkNotNullParameter(r7, "map");
                Intrinsics.checkNotNullParameter(r6, "map");
                r7.putAll(r6);
                mz0.m r8 = new mz0.m();
                r8.b(LogCommon.PAGE_SOURCE_LOG);
                r8.b(LogCommon.ROOM);
                List<Object> r9 = r3.b;
                ArrayList r10 = (ArrayList) r9;
                r10.addAll(r8.a);
                cy0.e.a.getClass();
                cy0.j r12 = cy0.e.a.a;
                com.bytedance.android.scope.m.e.getClass();
                Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
                Intrinsics.checkNotNull(r13);
                ((mz0.i) ((f80.a) r13)).w3("livesdk_anchor_interation_invitation_setting_switch", r3.a, r3.b);
                return;
            L12:
                r2 = "off";
                goto L13
            L8:
                r1 = MapsKt.emptyMap();
                goto L9
            }
        }

        public h(AnchorInLinkSettingDialog r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r7, boolean r8) {
            HashMap r5 = new HashMap();
            r5.put("accept_team_task", Boolean.valueOf(r8));
            if (AnchorInLinkSettingDialog.T90(this.a) == null) goto L16;
            r31.a r0 = r31.b.a(r31.a.a);
            long r1 = AnchorInLinkSettingDialog.T90(this.a).getId();
            if (AnchorInLinkSettingDialog.T90(this.a).getOwner() == null) goto L7;
            IBaseUser r9 = AnchorInLinkSettingDialog.T90(this.a).getOwner();
            Intrinsics.checkNotNull(r9);
            String r10 = com.bytedance.android.live.base.model.user.o.a(r9);
        L8:
            Observable<ExtraResponse<Object, Extra>> r12 = r0.N(r1, r10, 22, r5);
            if (r12 == null) goto L17;
            Observable r13 = r12.compose(RxUtil.rxSchedulerHelper());
            if (r13 == null) goto L18;
            Disposable r14 = r13.subscribe(new a(r8));
            if (r14 == null) goto L19;
            this.a.i.add(r14);
            return;
        L19:
            return;
        L18:
            return;
        L17:
            return;
        L7:
            r10 = null;
            goto L8
        }
    }

    public static final class i implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ AnchorInLinkSettingDialog a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ boolean a;

            public a(boolean r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                ExtraResponse r3 = (ExtraResponse) r2;
                l51.a.F(this.a);
                if (this.a == false) goto L6;
                ToastUtil.a(2131918717, 0);
                return;
            }
        }

        public i(AnchorInLinkSettingDialog r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r7, boolean r8) {
            if (this.a.F == true) goto L5;
        L10:
            HashMap r5 = new HashMap();
            r5.put("accept_big_small_layout", Boolean.valueOf(r8));
            r31.a r0 = r31.b.a(r31.a.a);
            long r1 = AnchorInLinkSettingDialog.T90(this.a).getId();
            IBaseUser r9 = AnchorInLinkSettingDialog.T90(this.a).getOwner();
            if (r9 == null) goto L13;
            Intrinsics.checkNotNullParameter(r9, "$this$secUidExt");
            String r10 = r9.getCastSecUid();
        L14:
            Observable<ExtraResponse<Object, Extra>> r12 = r0.updateAnchorLinkSetting(r1, r10, 8, r5);
            if (r12 == null) goto L21;
            Observable r13 = r12.compose(RxUtil.rxSchedulerHelper());
            if (r13 == null) goto L21;
            Disposable r14 = r13.subscribe(new a(r8));
            if (r14 == null) goto L21;
            this.a.i.add(r14);
        L21:
            HashMap r15 = new HashMap();
            w31.c r2 = com.bytedance.android.live.revlink.impl.global.b.T();
            if (r2 == null) goto L24;
            Map<String, String> r3 = r2.f();
        L25:
            r15.putAll(r3);
            if (r8 == false) goto L28;
            String r16 = "open";
        L29:
            r15.put("click_type", r16);
            mz0.n r17 = new mz0.n();
            Map<String, String> r4 = r17.a;
            Intrinsics.checkNotNullParameter(r4, "map");
            Intrinsics.checkNotNullParameter(r15, "map");
            r4.putAll(r15);
            mz0.m r18 = new mz0.m();
            r18.b(LogCommon.PAGE_SOURCE_LOG);
            r18.b(LogCommon.ROOM);
            ((ArrayList) r17.b).addAll(r18.a);
            cy0.e.a.getClass();
            cy0.j r19 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r20 = com.bytedance.android.scope.m.b(r19).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r20);
            ((mz0.i) ((f80.a) r20)).w3("livesdk_connection_default_enlarge_item_click", r17.a, r17.b);
            return;
        L28:
            r16 = "close";
            goto L29
        L24:
            r3 = MapsKt.emptyMap();
            goto L25
        L13:
            r10 = null;
            goto L14
        L5:
            if (r41.f.c == true) goto L10;
            ToastUtil.a(2131920567, 0);
            Switch r22 = this.a.D;
            if (r22 == null) goto L31;
            r22.setChecked(!r8);
            return;
        }
    }

    public static final class j implements View.OnClickListener {
        public final /* synthetic */ AnchorInLinkSettingDialog a;

        public j(AnchorInLinkSettingDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
        new a();
    }

    public AnchorInLinkSettingDialog() {
        this.e = new LinkedHashMap();
        this.i = new CompositeDisposable();
        boolean r0 = true;
        this.E = true;
        if (r41.f.a == false) goto L12;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r1 = com.bytedance.android.live.revlink.impl.global.b.D();
        if (r1 == null) goto L12;
        if (r1.i() <= 4) goto L9;
        boolean r2 = true;
    L10:
        if (r2 != true) goto L12;
    L13:
        this.F = r0;
        return;
    L9:
        r2 = false;
    L12:
        r0 = false;
        goto L13
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.i.dispose();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.e.clear();
    }

    public static final /* synthetic */ IRoom T90(AnchorInLinkSettingDialog r1) {
        IRoom r2 = r1.f;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L5:
        return r2;
    }

    public final View S90(int r3) {
        if (this.e != null) goto L5;
        this.e = new LinkedHashMap();
    L5:
        View r0 = this.e.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.e.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final String V90(int r4) {
        if (r4 >= 60) goto L7;
        return s1.C(2131917856, new Object[]{Integer.valueOf(r4)});
    L7:
        return s1.C(2131917855, new Object[]{Integer.valueOf(r4 / 60)});
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        ld.a r3 = ld.d.a();
        if (r3 == null) goto L11;
        NextLiveData r4 = r3.so();
        if (r4 == null) goto L11;
        Observable r5 = ld.c.a(r4);
        if (r5 == null) goto L11;
        Disposable r6 = r5.subscribe(new b(this));
        if (r6 == null) goto L11;
        this.i.add(r6);
    L11:
        ProfitInteractionDataContext r7 = com.bytedance.android.live.revlink.impl.global.b.X();
        if (r7 == null) goto L20;
        com.bytedance.live.datacontext.m<Integer> r8 = r7.getScoreShowStatus();
        if (r8 == null) goto L20;
        Observable r9 = r8.a();
        if (r9 == null) goto L20;
        Disposable r10 = r9.subscribe(new c(this));
        if (r10 == null) goto L20;
        this.i.add(r10);
    L20:
        MultiLinkAnchorControlContext r12 = com.bytedance.android.live.revlink.impl.global.b.B();
        if (r12 == null) goto L29;
        com.bytedance.live.datacontext.m<Boolean> r13 = r12.getForbidApply();
        if (r13 == null) goto L29;
        Observable r14 = r13.a();
        if (r14 == null) goto L29;
        Disposable r15 = r14.subscribe(new d(this));
        if (r15 == null) goto L29;
        RxUtilKt.c(r15, this.i);
    L29:
        MultiLinkAnchorControlContext r16 = com.bytedance.android.live.revlink.impl.global.b.B();
        if (r16 == null) goto L39;
        com.bytedance.live.datacontext.m<Boolean> r17 = r16.getForbidInvite();
        if (r17 == null) goto L40;
        Observable r18 = r17.a();
        if (r18 == null) goto L41;
        Disposable r19 = r18.subscribe(new e(this));
        if (r19 == null) goto L42;
        RxUtilKt.c(r19, this.i);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    }

    public static final void U90(AnchorInLinkSettingDialog r5, String r6) {
        if (r5.h == false) goto L5;
        String r0 = "rule_panel";
    L6:
        ProfitInteractionDataContext r1 = com.bytedance.android.live.revlink.impl.global.b.X();
        com.bytedance.android.live.revlink.impl.multianchor.profit.d r2 = null;
        if (r1 == null) goto L12;
        IRoom r7 = r5.f;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L11:
        String r8 = r1.getScoreByUserId(iz.a.a(r7.getOwner()));
    L13:
        com.bytedance.android.live.revlink.impl.global.c r3 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r3 == null) goto L16;
        r2 = r3.Bg();
    L16:
        if (r2 == null) goto L32;
        ProfitInteractionDataContext r4 = com.bytedance.android.live.revlink.impl.global.b.X();
        if (r4 == null) goto L22;
        boolean r9 = true;
        if (r4.canShowScore() != true) goto L22;
    L23:
        Intrinsics.checkNotNullParameter(r0, "requestPage");
        Intrinsics.checkNotNullParameter(r6, "buttonType");
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("request_page", r0);
        if (r9 == false) goto L26;
        String r12 = DataType.TRUE;
    L27:
        r10.put("value_show_switch", r12);
        if (r8 != null) goto L30;
        r8 = "";
    L30:
        r10.put("value", r8);
        r10.put("invitee_value", r2.a());
        r10.put("button_type", r6);
        r2.b(r10);
        mz0.n r13 = new mz0.n();
        Map<String, String> r14 = r13.a;
        Intrinsics.checkNotNullParameter(r14, "map");
        Intrinsics.checkNotNullParameter(r10, "map");
        r14.putAll(r10);
        mz0.m r15 = new mz0.m();
        r15.b(LogCommon.ROOM);
        ((ArrayList) r13.b).addAll(r15.a);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r17);
        ((mz0.i) ((f80.a) r17)).w3("livesdk_connection_setting_panel_click", r13.a, r13.b);
        return;
    L26:
        r12 = DataType.FALSE;
    L22:
        r9 = false;
        goto L23
    L32:
        return;
    L12:
        r8 = null;
        goto L13
    L5:
        r0 = "connection_panel";
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPKTimeDialogFragment.b
    public final void cS(int r2, int r3) {
        l51.a.I(r2);
        l51.a.J(r3);
        if (isViewValid() == true) goto L5;
        return;
    L5:
        TextView r4 = this.p;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tvPkTime");
    L8:
        if (r4 == null) goto L11;
        r4.setText(V90(r2));
        return;
    }

    public final void onViewCreated(View r18, Bundle r19) {
        Intrinsics.checkNotNullParameter(r18, "view");
        super.onViewCreated(r18, r19);
        this.j = r18.findViewById(2131385972);
        this.k = (Switch) r18.findViewById(2131387939);
        this.l = r18.findViewById(2131387940);
        this.m = (TextView) r18.findViewById(2131364677);
        this.n = (ViewGroup) r18.findViewById(2131366940);
        this.t = (Switch) r18.findViewById(2131387864);
        this.D = (Switch) r18.findViewById(2131387862);
        this.u = (Switch) r18.findViewById(2131387860);
        this.w = (Switch) r18.findViewById(2131387861);
        this.x = (Switch) r18.findViewById(2131387932);
        this.v = (Switch) r18.findViewById(2131387866);
        this.q = (FrameLayout) r18.findViewById(2131386385);
        this.y = r18.findViewById(2131387865);
        this.z = r18.findViewById(2131387867);
        this.A = r18.findViewById(2131372813);
        this.B = (ImageView) r18.findViewById(2131376471);
        this.C = r18.findViewById(2131372667);
        this.o = (ViewGroup) r18.findViewById(2131373998);
        this.p = (TextView) r18.findViewById(2131391589);
        this.r = (ViewGroup) r18.findViewById(2131372665);
        this.s = (Switch) r18.findViewById(2131387858);
        TextView r5 = this.p;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvPkTime");
    L5:
        if (r5 == null) goto L7;
        r5.setText(V90(l51.a.j()));
    L7:
        b51.b r6 = b51.b.c0;
        boolean r8 = false;
        if (r6.f().getShow() == false) goto L25;
        boolean r7 = l51.a.q();
        HashMap r12 = new HashMap();
        yz0.k r13 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r13 == null) goto L12;
        IRoom r14 = r13.getRoom();
    L13:
        if (r14 == null) goto L15;
        r12.put("anchor_id", String.valueOf(r14.getAnchorId()));
        r12.put("room_id", String.valueOf(r14.getId()));
    L15:
        r12.put("setting_partition", "pk");
        r12.put("setting_sub_partition", "egg");
        if (r7 == false) goto L18;
        String r9 = "on";
    L19:
        r12.put("switch", r9);
        mz0.n r10 = new mz0.n();
        Map<String, String> r15 = r10.a;
        Intrinsics.checkNotNullParameter(r15, "map");
        Intrinsics.checkNotNullParameter(r12, "map");
        r15.putAll(r12);
        mz0.m r16 = new mz0.m();
        r16.b(LogCommon.PAGE_SOURCE_LOG);
        r16.b(LogCommon.ROOM);
        ((ArrayList) r10.b).addAll(r16.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r110 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r110);
        ((mz0.i) ((f80.a) r110)).w3("livesdk_anchor_interation_invitation_setting_show", r10.a, r10.b);
        View r20 = this.A;
        if (r20 == null) goto L22;
        r20.setVisibility(0);
    L22:
        View r22 = this.C;
        if (r22 == null) goto L31;
        r22.setVisibility(8);
    L31:
        Switch r23 = this.k;
        if (r23 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("switchShowExtScore");
    L34:
        ProfitInteractionDataContext r111 = com.bytedance.android.live.revlink.impl.global.b.X();
        if (r111 != null) goto L37;
    L39:
        boolean r112 = false;
    L40:
        r23.setChecked(r112);
        Switch r24 = this.k;
        if (r24 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("switchShowExtScore");
    L43:
        r24.setClickable(false);
        View r25 = this.l;
        if (r25 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("switchShowExtScoreContainer");
    L46:
        r25.setOnClickListener(x0.a(new AnonymousClass1(this)));
        ld.a r26 = ld.d.a();
        if (r26 == null) goto L57;
        NextLiveData r27 = r26.lj();
        if (r27 == null) goto L57;
        List r28 = (List) r27.getValue();
        if (r28 == null) goto L57;
        if ((!r28.isEmpty()) != true) goto L57;
        ViewGroup r29 = this.r;
        if (r29 == null) goto L60;
        r29.setVisibility(0);
    L60:
        View r113 = r18.findViewById(2131372666);
        if (r113 != null) goto L63;
    L67:
        ReadOnlyProperty r114 = b51.b.Z;
        KProperty[] r115 = b51.b.a;
        if (((Boolean) r114.getValue(r6, r115[50])).booleanValue() == true) goto L73;
        View r30 = r18.findViewById(2131372666);
        if (r30 == null) goto L73;
        r30.setVisibility(8);
    L73:
        if (((Boolean) b51.b.a0.getValue(r6, r115[51])).booleanValue() == true) goto L77;
        View r4 = r18.findViewById(2131372667);
        if (r4 == null) goto L77;
        r4.setVisibility(8);
    L77:
        Switch r32 = this.D;
        if (r32 != null) goto L80;
    L86:
        Switch r33 = this.D;
        if (r33 == null) goto L90;
        r33.setOnCheckedChangeListener(new i(this));
        Unit r34 = Unit.INSTANCE;
    L90:
        if (this.E == true) goto L103;
        View r35 = r18.findViewById(2131362526);
        if (r35 == null) goto L94;
        r35.setVisibility(8);
    L94:
        View r36 = r18.findViewById(2131362525);
        if (r36 == null) goto L97;
        r36.setVisibility(8);
    L97:
        View r3 = r18.findViewById(2131386385);
        if (r3 == null) goto L100;
        r3.setVisibility(8);
    L100:
        View r37 = r18.findViewById(2131366940);
        if (r37 == null) goto L103;
        r37.setVisibility(8);
    L103:
        y41.d r38 = y41.d.j;
        IRoom r39 = this.f;
        if (r39 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L106:
        IRoomSpecificSceneTypeInfo r40 = r39.getSceneTypeInfo();
        if (r40 != null) goto L109;
    L111:
        boolean r42 = false;
    L113:
        if (r38.a(r42) == false) goto L131;
        View r43 = r18.findViewById(2131372668);
        if (r43 == null) goto L117;
        r43.setVisibility(0);
    L117:
        View r1 = r18.findViewById(2131372668);
        if (r1 != null) goto L120;
    L126:
        HashMap r2 = new HashMap();
        w31.c r44 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r44 == null) goto L129;
        Map<String, String> r45 = r44.f();
    L130:
        r2.putAll(r45);
        r2.put("channel_id", String.valueOf(this.g));
        mz0.n r46 = new mz0.n();
        Map<String, String> r47 = r46.a;
        Intrinsics.checkNotNullParameter(r47, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r47.putAll(r2);
        mz0.m r48 = new mz0.m();
        r48.b(LogCommon.PAGE_SOURCE_LOG);
        r48.b(LogCommon.ROOM);
        ((ArrayList) r46.b).addAll(r48.a);
        cy0.e.a.getClass();
        cy0.j r49 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r50 = com.bytedance.android.scope.m.b(r49).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r50);
        ((mz0.i) ((f80.a) r50)).w3("livesdk_connection_default_enlarge_item_show", r46.a, r46.b);
    L134:
        TextView r52 = this.m;
        if (r52 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("btnClearExtScore");
    L137:
        r52.setOnClickListener(x0.a(new AnonymousClass4(this)));
        ViewGroup r53 = this.o;
        if (r53 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("groupPkTime");
    L140:
        r53.setOnClickListener(x0.a(new AnonymousClass5(this)));
        View r54 = this.j;
        if (r54 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("btnBack");
    L143:
        r54.setOnClickListener(x0.a(new AnonymousClass6(this)));
        S90(2131381758).setOnClickListener(new j(this));
        if (v41.b.f.a() == true) goto L151;
        FrameLayout r55 = this.q;
        if (r55 == null) goto L148;
        UtilityKotlinExtentionsKt.z(r55, false);
        Unit r56 = Unit.INSTANCE;
    L148:
        FrameLayout r57 = (FrameLayout) S90(2131366940);
        if (r57 == null) goto L151;
        UtilityKotlinExtentionsKt.z(r57, false);
        Unit r58 = Unit.INSTANCE;
    L151:
        ProfitInteractionDataContext r59 = com.bytedance.android.live.revlink.impl.global.b.X();
        if (r59 != null) goto L154;
    L156:
        boolean r60 = false;
    L157:
        if (r60 == true) goto L162;
        ViewGroup r62 = this.n;
        if (r62 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("clearExtScoreLayout");
    L161:
        r62.setVisibility(8);
    L162:
        Switch r63 = this.v;
        if (r63 == null) goto L174;
        MultiLinkAnchorControlContext r64 = com.bytedance.android.live.revlink.impl.global.b.B();
        if (r64 == null) goto L172;
        com.bytedance.live.datacontext.m<Boolean> r65 = r64.getForbidInvite();
        if (r65 == null) goto L172;
        if (((Boolean) r65.getValue()).booleanValue() != true) goto L172;
        boolean r66 = false;
    L173:
        r63.setChecked(r66);
    L172:
        r66 = true;
    L174:
        Switch r67 = this.v;
        if (r67 == null) goto L177;
        r67.setClickable(false);
    L177:
        View r68 = this.z;
        if (r68 == null) goto L180;
        r68.setOnClickListener(x0.a(new AnonymousClass8(this)));
        Unit r69 = Unit.INSTANCE;
    L180:
        Switch r70 = this.t;
        if (r70 == null) goto L192;
        MultiLinkAnchorControlContext r72 = com.bytedance.android.live.revlink.impl.global.b.B();
        if (r72 == null) goto L190;
        com.bytedance.live.datacontext.m<Boolean> r73 = r72.getForbidApply();
        if (r73 == null) goto L190;
        if (((Boolean) r73.getValue()).booleanValue() != true) goto L190;
        boolean r74 = false;
    L191:
        r70.setChecked(r74);
    L190:
        r74 = true;
    L192:
        Switch r75 = this.t;
        if (r75 == null) goto L195;
        r75.setClickable(false);
    L195:
        View r76 = this.y;
        if (r76 == null) goto L198;
        r76.setOnClickListener(x0.a(new AnonymousClass9(this)));
        Unit r77 = Unit.INSTANCE;
    L198:
        HashMap<String, HashMap<String, Integer>> r78 = l51.a.a();
        IRoom r79 = this.f;
        if (r79 != null) goto L201;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L201:
        final HashMap<String, Integer> r80 = r78.get(r79.getAnchorId());
        if (r80 != null) goto L204;
        r80 = new HashMap();
    L204:
        Switch r82 = this.s;
        if (r82 == null) goto L214;
        Integer r83 = r80.get("cellular_open");
        if (r83 != null) goto L210;
    L212:
        boolean r84 = false;
    L213:
        r82.setChecked(r84);
        goto L214
    L210:
        if (r83.intValue() != 1) goto L212;
        r84 = true;
    L214:
        Switch r85 = this.s;
        if (r85 == null) goto L218;
        r85.setOnClickListener(x0.a(new AnonymousClass10(this, r80)));
        Unit r86 = Unit.INSTANCE;
    L218:
        if (this.h == false) goto L220;
        String r87 = "rule_panel";
    L221:
        ProfitInteractionDataContext r88 = com.bytedance.android.live.revlink.impl.global.b.X();
        if (r88 != null) goto L224;
    L226:
        boolean r89 = false;
    L227:
        ProfitInteractionDataContext r90 = com.bytedance.android.live.revlink.impl.global.b.X();
        if (r90 == null) goto L233;
        IRoom r92 = this.f;
        if (r92 != null) goto L232;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L232:
        String r93 = r90.getScoreByUserId(iz.a.a(r92.getOwner()));
    L234:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r94 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r94 == null) goto L282;
        Switch r95 = this.v;
        String r116 = "open";
        if (r95 != null) goto L239;
    L241:
        String r96 = "shut";
    L242:
        Switch r117 = this.t;
        if (r117 != null) goto L245;
    L247:
        r116 = "shut";
    L248:
        Intrinsics.checkNotNullParameter(r96, "inviteStatus");
        Intrinsics.checkNotNullParameter(r116, "applyStatus");
        Intrinsics.checkNotNullParameter(r87, "requestPage");
        LinkedHashMap r118 = new LinkedHashMap();
        d31.d r119 = r94.m();
        if (r119 == null) goto L251;
        Map<String, String> r120 = r119.i();
    L252:
        r118.putAll(r120);
        LinkCrossRoomDataHolder r121 = r94.f();
        if (r121 == null) goto L255;
        Long r122 = Long.valueOf(r121.c());
    L256:
        r118.put("channel_id", String.valueOf(r122));
        w31.c r97 = r94.k();
        if (r97 == null) goto L259;
        Long r98 = Long.valueOf(r97.i());
    L260:
        r118.put("pk_id", String.valueOf(r98));
        d31.d r99 = r94.m();
        if (r99 == null) goto L263;
        r99.r(r118);
    L263:
        r118.put("connection_anchor_cnt", r94.b());
        r118.put("invite_right_status", r96);
        r118.put("apply_right_status", r116);
        r118.put("request_page", r87);
        if (r89 == false) goto L266;
        String r100 = DataType.TRUE;
    L267:
        r118.put("value_show_switch", r100);
        String r101 = "";
        if (r93 != null) goto L270;
        r93 = "";
    L270:
        r118.put("value", r93);
        com.bytedance.android.live.revlink.impl.global.c r102 = r94.d;
        if (r102 == null) goto L273;
        com.bytedance.android.live.revlink.impl.multianchor.profit.d r103 = r102.Bg();
    L274:
        if (r103 == null) goto L277;
        String r104 = r103.a();
        if (r104 == null) goto L277;
    L278:
        r118.put("invitee_value", r104);
        LinkCrossRoomDataHolder r105 = r94.f();
        if (r105 == null) goto L281;
        r101 = r105.h();
    L281:
        r118.put("invitee_list", r101);
        mz0.n r106 = new mz0.n();
        Map<String, String> r107 = r106.a;
        Intrinsics.checkNotNullParameter(r107, "map");
        Intrinsics.checkNotNullParameter(r118, "map");
        r107.putAll(r118);
        mz0.m r108 = new mz0.m();
        r108.b(LogCommon.ROOM);
        ((ArrayList) r106.b).addAll(r108.a);
        cy0.e.a.getClass();
        cy0.j r109 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r123 = com.bytedance.android.scope.m.b(r109).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r123);
        ((mz0.i) ((f80.a) r123)).w3("livesdk_connection_setting_panel_show", r106.a, r106.b);
        Unit r124 = Unit.INSTANCE;
    L277:
        r104 = "";
        goto L278
    L273:
        r103 = null;
        goto L274
    L266:
        r100 = DataType.FALSE;
        goto L267
    L259:
        r98 = null;
        goto L260
    L255:
        r122 = null;
        goto L256
    L251:
        r120 = MapsKt.emptyMap();
        goto L252
    L245:
        if (r117.isChecked() != true) goto L247;
    L239:
        if (r95.isChecked() != true) goto L241;
        r96 = "open";
    L282:
        Switch r125 = this.u;
        if (r125 != null) goto L285;
    L289:
        Switch r126 = this.u;
        if (r126 == null) goto L292;
        r126.setOnCheckedChangeListener(new f(this));
        Unit r127 = Unit.INSTANCE;
    L292:
        Switch r128 = this.w;
        if (r128 == null) goto L295;
        r128.setChecked(((Boolean) l51.a.u.getValue(null, l51.a.a[20])).booleanValue());
    L295:
        Switch r129 = this.w;
        if (r129 == null) goto L298;
        r129.setOnCheckedChangeListener(new g(this));
        Unit r130 = Unit.INSTANCE;
    L298:
        Switch r131 = this.x;
        if (r131 == null) goto L301;
        r131.setChecked(l51.a.q());
    L301:
        Switch r132 = this.x;
        if (r132 == null) goto L304;
        r132.setOnCheckedChangeListener(new h(this));
        Unit r133 = Unit.INSTANCE;
    L304:
        ImageView r134 = this.B;
        if (r134 == null) goto L308;
        r134.setOnClickListener(new AnonymousClass14(this));
        Unit r135 = Unit.INSTANCE;
        return;
    L308:
        return;
    L285:
        if (this.F == true) goto L288;
        r8 = ((Boolean) l51.a.t.getValue(null, l51.a.a[19])).booleanValue();
    L288:
        r125.setChecked(r8);
        goto L289
    L233:
        r93 = null;
        goto L234
    L224:
        if (r88.canShowScore() != true) goto L226;
        r89 = true;
        goto L227
    L220:
        r87 = "connection_panel";
        goto L221
    L154:
        if (r59.canShowScore() != true) goto L156;
        r60 = true;
        goto L157
    L129:
        r45 = MapsKt.emptyMap();
        goto L130
    L120:
        if (this.F == true) goto L122;
    L124:
        float r136 = 1.0f;
    L125:
        r1.setAlpha(r136);
        goto L126
    L122:
        if (r41.f.c == true) goto L124;
        r136 = 0.4f;
        goto L125
    L131:
        View r137 = r18.findViewById(2131372668);
        if (r137 == null) goto L134;
        r137.setVisibility(8);
        goto L134
    L109:
        if (r40.isLandscapeVerticalRoom() != 1) goto L111;
        r42 = true;
        goto L113
    L80:
        if (this.F == true) goto L82;
    L84:
        boolean r138 = ((Boolean) l51.a.j.getValue(null, l51.a.a[9])).booleanValue();
    L85:
        r32.setChecked(r138);
        goto L86
    L82:
        if (r41.f.c == true) goto L84;
        r138 = false;
        goto L85
    L63:
        if (this.F == false) goto L65;
        float r139 = 0.4f;
    L66:
        r113.setAlpha(r139);
        goto L67
    L65:
        r139 = 1.0f;
    L57:
        ViewGroup r140 = this.r;
        if (r140 == null) goto L60;
        r140.setVisibility(8);
        goto L60
    L37:
        if (r111.canShowScore() != true) goto L39;
        r112 = true;
        goto L40
    L18:
        r9 = "off";
        goto L19
    L12:
        r14 = null;
        goto L13
    L25:
        View r141 = this.A;
        if (r141 == null) goto L28;
        r141.setVisibility(8);
    L28:
        View r142 = this.C;
        if (r142 == null) goto L31;
        r142.setVisibility(0);
        goto L31
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565375, r3, false);
    }
}
