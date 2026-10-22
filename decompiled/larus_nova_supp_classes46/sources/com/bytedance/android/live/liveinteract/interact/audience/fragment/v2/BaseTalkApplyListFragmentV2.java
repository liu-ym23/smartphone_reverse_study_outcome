package com.bytedance.android.live.liveinteract.interact.audience.fragment.v2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.viewholder.LinkApplyUserViewBinder;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.list.BaseTalkApplyListContract$View;
import com.bytedance.android.live.liveinteract.common.ui.CustomOnlineFriendsCircleContainer;
import com.bytedance.android.live.liveinteract.linkpanel.model.ActiveUser;
import com.bytedance.android.live.liveinteract.plantform.core.l0;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.utils.g1;
import com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/fragment/v2/BaseTalkApplyListFragmentV2;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/list/BaseTalkApplyListContract$View;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class BaseTalkApplyListFragmentV2 extends BaseTalkApplyListContract$View {
    public static final /* synthetic */ int M = 0;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public String E;
    public boolean F;
    public boolean G;
    public boolean H;
    public int I;
    public final CompositeDisposable J;
    public final b K;
    public final c L;
    public RecyclerView f;
    public RelativeLayout g;
    public TextView h;
    public LinearLayout i;
    public com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.h j;
    public LinearLayout k;
    public LinearLayout l;
    public TextView m;
    public CustomOnlineFriendsCircleContainer n;
    public TextView o;
    public ImageView p;
    public ViewGroup q;
    public TextView r;
    public View s;
    public IRoom t;
    public MultiTypeAdapter u;
    public final long v;
    public final int w;
    public int x;
    public final LinkedList<ILinkPlayerInfoBridge> y;
    public final LinkedList<Object> z;

    public static final class a {
    }

    public static final class b extends l0 {
        public final /* synthetic */ BaseTalkApplyListFragmentV2 a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ String b;

            public a(b r1, String r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.ca0(String.valueOf(this.b));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(BaseTalkApplyListFragmentV2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.core.l0, uf0.a
        public final void onPermitSuccess(String r3) {
            new Handler(Looper.getMainLooper()).post(new a(this, r3));
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.core.l0, uf0.a
        public final void l(String r2, Throwable r3) {
            if ((r3 instanceof ApiServerException) == false) goto L6;
            f2.c(((ApiServerException) r3).getPrompt(), 0);
            return;
        L6:
            f2.b(2131922698, 0);
        }
    }

    public static final class c implements yr0.e {
        public final /* synthetic */ BaseTalkApplyListFragmentV2 a;

        public static final class a implements Runnable {
            public final /* synthetic */ c a;
            public final /* synthetic */ String b;

            public a(c r1, String r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                BaseTalkApplyListFragmentV2 r0 = this.a.a;     // Catch: Throwable -> L7
                String r1 = this.b;     // Catch: Throwable -> L7
                if (r1 != null) goto L5;
                r1 = "";
            L5:
                r0.ca0(r1);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L11;
                return;
            L11:
                throw th;
            }
        }

        public c(BaseTalkApplyListFragmentV2 r1) {
            this.a = r1;
        }

        @Override // yr0.e
        public final void a(Throwable r3) {
            if ((r3 instanceof ApiServerException) == false) goto L6;
            f2.c(((ApiServerException) r3).getPrompt(), 0);
            return;
        L6:
            f2.b(2131922698, 0);
        }

        @Override // yr0.e
        public final void onPermitSuccess(String r3) {
            new Handler(Looper.getMainLooper()).post(new a(this, r3));
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ BaseTalkApplyListFragmentV2 a;

        public d(BaseTalkApplyListFragmentV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            BaseTalkApplyListFragmentV2 r3 = this.a;
            if (r3.A == true) goto L6;
            f2.b(2131922700, 1);
            return;
        L6:
            r3.e.h();
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ BaseTalkApplyListFragmentV2 a;

        public e(BaseTalkApplyListFragmentV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.aa0();
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ BaseTalkApplyListFragmentV2 a;

        public f(BaseTalkApplyListFragmentV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.ba0();
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ BaseTalkApplyListFragmentV2 a;

        public g(BaseTalkApplyListFragmentV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            BaseTalkApplyListFragmentV2 r5 = this.a;
            ViewGroup r0 = r5.q;
            if (r0 == null) goto L5;
            r0.setVisibility(8);
        L5:
            IRoom r1 = r5.t;
            if (r1 == null) goto L12;
            yj0.f r6 = r5.e;
            if (r6 == null) goto L10;
            r6.d(r1.getRoomId());
        L10:
            long r2 = r1.getRoomId();
            int r7 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            LinkedHashMap r8 = new LinkedHashMap();
            r8.put("room_id", Long.valueOf(r2));
            com.bytedance.android.live.liveinteract.plantform.utils.x.t0("apply_panel_close_paid_link_guide", r8);
            return;
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ BaseTalkApplyListFragmentV2 a;

        public h(BaseTalkApplyListFragmentV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r11) {
            BaseTalkApplyListFragmentV2 r12 = this.a;
            int r0 = BaseTalkApplyListFragmentV2.M;
            if (r12.D == false) goto L5;
        L8:
            boolean r13 = true;
        L9:
            if (r13 == false) goto L33;
            BaseTalkApplyListFragmentV2 r14 = this.a;
            if (r14.F == false) goto L14;
        L17:
            HashMap r15 = new HashMap();
            com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
            if (r1 != null) goto L20;
            int r2 = 0;
        L21:
            r15.put("apply_list_num", String.valueOf(r2));
            r15.put("refresh_type", "draw");
            if (g1.a() == false) goto L32;
            MultiRevenueDataContext.Companion.getClass();
            com.bytedance.android.live.liveinteract.revenuebase.c r3 = MultiRevenueDataContext.a.c();
            if (r3 == null) goto L32;
            if (r3.isPaidLinkOn() == true) goto L32;
            if (this.a.I != WaitingListType.PAID.ordinal()) goto L30;
            String r4 = "priority";
        L31:
            r15.put("show_tab", r4);
            goto L32
        L30:
            r4 = "normal";
        L32:
            TalkRoomLogUtils.B0(r15, null, null, 6);
            TalkRoomLogUtils.J0(r15);
            j0.l().sendLog("livesdk_anchor_audience_apply_panel_show", r15, new Object[]{am2.x.class, IRoom.class});
            return;
        L20:
            r2 = r1.a().size();
            goto L21
        L14:
            if (r14.D == false) goto L16;
            r14.F = true;
            com.bytedance.android.live.liveinteract.chatroom.chatroom.list.a.f(r14.e, false, "loadMoreApplyList", r14.v, r14.E, r14.I);
            goto L17
        L16:
            r14.ea0(r14.y);
            r14.fa0();
            goto L17
        L33:
            BaseTalkApplyListFragmentV2 r16 = this.a;
            int r5 = r16.y.size();
            int r6 = r16.w;
            if (r5 >= r6) goto L36;
            r6 = r16.y.size();
        L36:
            r16.ea0(r16.y.subList(0, r6));
            return;
        L5:
            if (r12.x < r12.y.size()) goto L8;
            r13 = false;
            goto L9
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ BaseTalkApplyListFragmentV2 a;
        public final /* synthetic */ Ref.IntRef b;

        public i(BaseTalkApplyListFragmentV2 r1, Ref.IntRef r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (((Boolean) vm2.d.g3.getValue(null, vm2.d.a[212(0xd4, float:2.97E-43)])).booleanValue() == false) goto L7;
            MultiTypeAdapter r0 = this.a.u;
            if (r0 == null) goto L11;
            r0.notifyDataSetChanged();
            return;
        L11:
            return;
        L7:
            MultiTypeAdapter r1 = this.a.u;
            if (r1 == null) goto L13;
            r1.notifyItemChanged(this.b.element);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.BaseTalkApplyListFragmentV2$onViewCreated$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass4(BaseTalkApplyListFragmentV2 r8) {
            super(1, r8, BaseTalkApplyListFragmentV2.class, "paidQueueTabChanged", "paidQueueTabChanged(I)V", 0);
        }

        public final void invoke(int r11) {
            BaseTalkApplyListFragmentV2 r0 = (BaseTalkApplyListFragmentV2) ((CallableReference) this).receiver;
            int r1 = r0.I;
            r0.y.clear();
            r0.I = r11;
            yj0.f r3 = r0.e;
            if (r3 == null) goto L5;
            com.bytedance.android.live.liveinteract.chatroom.chatroom.list.a.f(r3, true, "audienceIncreasePriceApplySuccess", 50, "", r11);
        L5:
            ALogger.d("BaseTalkApplyListFragmentV2", "paidQueueTabChanged, tabIndex: " + r11);
            if (r1 == r0.I) goto L9;
            r0.Z90();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Number) r1).intValue());
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.list.BaseTalkApplyListContract$View
    public final void S90(boolean r1) {
    }

    public final void aa0() {
        this.x = 0;
        this.y.clear();
        this.D = true;
        this.E = "";
        this.F = true;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.list.a.f(this.e, true, "loadNewApplyList", this.v, "", this.I);
    }

    public final boolean Y90() {
        if (jc1.k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().getPkState() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void Z90() {
        HashMap r0 = new HashMap();
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        r0.put("apply_list_num", String.valueOf(r2));
        r0.put("refresh_type", "click_icon");
        if (g1.a() == false) goto L17;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.c r3 = MultiRevenueDataContext.a.c();
        if (r3 == null) goto L17;
        if (r3.isPaidLinkOn() == true) goto L17;
        if (this.I != WaitingListType.PAID.ordinal()) goto L15;
        String r4 = "priority";
    L16:
        r0.put("show_tab", r4);
        goto L17
    L15:
        r4 = "normal";
    L17:
        TalkRoomLogUtils.B0(r0, null, null, 6);
        TalkRoomLogUtils.J0(r0);
        j0.l().sendLog("livesdk_anchor_audience_apply_panel_show", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L5:
        r2 = r1.a().size();
        goto L6
    }

    public void ba0() {
        yf0.g r0 = this.d;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void fa0() {
        if (this.D == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        TextView r1 = this.o;
        if (r1 == null) goto L29;
        r1.setText(s1.B(2131922706));
    L29:
        ImageView r2 = this.p;
        if (r2 == null) goto L32;
        r2.setImageResource(2131251343);
    L32:
        int r3 = 3;
        int r4 = this.x + 3;
        if (r4 <= this.y.size()) goto L35;
        r4 = this.y.size();
    L35:
        List<ILinkPlayerInfoBridge> r5 = this.y.subList(this.x, r4);
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L37:
        if (r7.hasNext() == false) goto L40;
        ILinkPlayerInfoBridge r8 = (ILinkPlayerInfoBridge) r7.next();
        ActiveUser r9 = new ActiveUser();
        r9.user = r8.getUser();
        r6.add(r9);
        goto L37
    L40:
        if (r5.size() <= 0) goto L60;
        CustomOnlineFriendsCircleContainer r10 = this.n;
        if (r10 == null) goto L57;
        r10.removeAllViews();
        int r11 = r6.size();
        if (r11 >= 3) goto L47;
        r3 = r11;
    L47:
        int r12 = 0;
    L48:
        if (r12 >= r3) goto L53;
        ActiveUser r13 = (ActiveUser) ListProtector.get(r6, r12);
        RelativeLayout r14 = new RelativeLayout(r10.getContext());
        int r15 = r10.b;
        RelativeLayout.LayoutParams r16 = new RelativeLayout.LayoutParams(r15, r15);
        r16.leftMargin = (r10.c * r12) + 0;
        r10.addView(r14, r16);
        HSImageView r17 = new HSImageView(r10.getContext());
        int r18 = r10.b;
        r14.addView(r17, new RelativeLayout.LayoutParams(r18, r18));
        a1.y(r17, r13.user.getAvatarThumbKt(), 2131251677, ContextCompat.getColor(r10.getContext(), 2131109391), t6.a(r10.getContext(), 1.0f));
        if (r13.isActive == false) goto L52;
        View r19 = new HSImageView(r10.getContext());
        int r20 = r10.a;
        RelativeLayout.LayoutParams r21 = new RelativeLayout.LayoutParams(r20, r20);
        r21.addRule(12);
        r21.addRule(11);
        r21.rightMargin = r10.d;
        r19.setImageResource(2131249665);
        r14.addView(r19, r21);
    L52:
        r12 = r12 + 1;
        goto L48
    L53:
        int r22 = r10.getChildCount();
    L54:
        r22 = r22 - 1;
        if (r22 < 0) goto L57;
        r10.getChildAt(r22).bringToFront();
    L57:
        CustomOnlineFriendsCircleContainer r23 = this.n;
        if (r23 == null) goto L60;
        r23.setVisibility(0);
    L60:
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.c r24 = MultiRevenueDataContext.a.c();
        if (r24 != null) goto L63;
        return;
    L63:
        if (r24.isIncreasePriceOn() == true) goto L76;
        LinearLayout r25 = this.l;
        if (r25 == null) goto L77;
        r25.setVisibility(0);
        return;
    L77:
        return;
    L76:
        return;
    L11:
        if (this.x > this.w) goto L16;
        LinearLayout r26 = this.l;
        if (r26 == null) goto L73;
        r26.setVisibility(8);
        return;
    L73:
        return;
    L16:
        CustomOnlineFriendsCircleContainer r27 = this.n;
        if (r27 == null) goto L19;
        r27.setVisibility(8);
    L19:
        TextView r28 = this.o;
        if (r28 == null) goto L22;
        r28.setText(s1.B(2131922702));
    L22:
        ImageView r29 = this.p;
        if (r29 == null) goto L74;
        r29.setImageResource(2131251342);
        return;
    L74:
        return;
    L5:
        if (this.x < this.y.size()) goto L8;
        r0 = false;
        goto L9
    }

    public BaseTalkApplyListFragmentV2() {
        this.v = 10;
        this.w = 2;
        this.y = new LinkedList();
        this.z = new LinkedList();
        this.C = true;
        this.D = true;
        this.E = "";
        this.I = WaitingListType.UNKNOWN.ordinal();
        this.J = new CompositeDisposable();
        this.K = new b(this);
        this.L = new c(this);
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.list.BaseTalkApplyListContract$View
    public final void X90() {
        if (getView() != null) goto L5;
        return;
    L5:
        f2.b(2131922701, 1);
        HashMap r0 = new HashMap();
        if (this.C == false) goto L8;
        String r2 = "video_live";
    L9:
        r0.put("live_type", r2);
        r0.put("function_type", "audience");
        if (jc1.k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().getPkState() != 1) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        String r4 = String.valueOf(jc1.k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getPkId());
    L16:
        r0.put("pk_id", r4);
        if (r3 == false) goto L19;
        String r5 = "1";
    L20:
        r0.put("is_in_pk", r5);
        j0.l().sendLog("livesdk_anchor_call_up", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L19:
        r5 = "0";
        goto L20
    L15:
        r4 = "";
        goto L16
    L12:
        r3 = false;
        goto L13
    L8:
        r2 = "voice_live";
        goto L9
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.A == false) goto L12;
        if (Y90() == true) goto L21;
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.d r0 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (r0 == null) goto L21;
        com.bytedance.android.live.liveinteract.plantform.core.f r1 = r0.X4();
        if (r1 == null) goto L21;
        r1.g(this.K);
    L21:
        if (this.J.isDisposed() == true) goto L23;
        this.J.dispose();
    L23:
        this.H = false;
        return;
    L12:
        if (this.B == false) goto L21;
        if (Y90() == true) goto L21;
        com.bytedance.android.live.liveinteract.plantform.base.c.i0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.c r2 = com.bytedance.android.live.liveinteract.plantform.base.c.a.a();
        if (r2 == null) goto L21;
        com.bytedance.android.live.liveinteract.plantform.core.e r3 = r2.A0();
        if (r3 == null) goto L21;
        r3.g(this.K);
        goto L21
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.list.BaseTalkApplyListContract$View
    public final void T90(boolean r1) {
        this.D = r1;
        this.F = false;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.list.BaseTalkApplyListContract$View
    public final void U90(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        this.F = false;
        MultiTypeAdapter r1 = this.u;
        if (r1 == null) goto L5;
        List r2 = r1.a;
    L6:
        List r4 = r2;
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L18;
        com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.h r6 = this.j;
        if (r6 == null) goto L18;
        r6.Wo();
    L18:
        if (getView() != null) goto L20;
        return;
    L20:
        r3.printStackTrace();
        RecyclerView r7 = this.f;
        if (r7 == null) goto L23;
        r7.setVisibility(8);
    L23:
        RelativeLayout r8 = this.g;
        if (r8 == null) goto L26;
        r8.setVisibility(8);
    L26:
        LinearLayout r9 = this.i;
        if (r9 == null) goto L30;
        r9.setVisibility(0);
        return;
    L30:
        return;
    L9:
        if (r4.isEmpty() == true) goto L12;
        r5 = false;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.list.BaseTalkApplyListContract$View
    public final void W90(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "throwable");
        if (getView() != null) goto L6;
        return;
    L6:
        if ((r5 instanceof ApiServerException) == false) goto L19;
        ApiServerException r0 = (ApiServerException) r5;
        if (r0.getErrorCode() != 4004108) goto L19;
        if (StringUtils.isEmpty(r0.getPrompt()) == false) goto L12;
        f2.b(2131922699, 1);
    L13:
        HashMap r6 = new HashMap();
        if (this.C == false) goto L16;
        String r1 = "video_live";
    L17:
        r6.put("live_type", r1);
        r6.put("function_type", "audience");
        j0.l().sendLog("livesdk_anchor_call_up_failure", r6, new Object[]{IRoom.class});
        return;
    L16:
        r1 = "voice_live";
        goto L17
    L12:
        f2.c(r0.getPrompt(), 0);
    L19:
        r5.printStackTrace();
        ExceptionUtils.handleException(getContext(), r5, 2131922698);
    }

    public final void ca0(String r8) {
        Intrinsics.checkNotNullParameter(r8, "uid");
        Ref.IntRef r0 = new Ref.IntRef();
        r0.element = -1;
        int r2 = 0;
        Object r4 = null;
        if (fj0.e.g(this.t) == true) goto L5;
    L36:
        int r1 = this.y.size();
    L37:
        if (r2 >= r1) goto L46;
        IBaseUser r5 = this.y.get(r2).getUser();
        if (r5 == null) goto L41;
        String r6 = r5.getIdString();
    L43:
        if (Intrinsics.areEqual(r6, r8) == true) goto L44;
        r2 = r2 + 1;
        goto L37
    L44:
        r0.element = r2;
        goto L46
    L41:
        r6 = null;
    L46:
        int r9 = r0.element;
        if (r9 >= 0) goto L49;
        return;
    L49:
        if (r9 >= this.y.size()) goto L65;
        this.y.get(r0.element).setHasApplied(true);
    L52:
        RecyclerView r10 = this.f;
        if (r10 == null) goto L64;
        r10.post(new i(this, r0));
        return;
    L64:
        return;
    L65:
        return;
    L5:
        if (fj0.e.f() == false) goto L36;
        int r3 = this.z.size();
    L7:
        if (r2 >= r3) goto L23;
        if ((this.z.get(r2) instanceof ILinkPlayerInfoBridge) == false) goto L22;
        Object r7 = this.z.get(r2);
        if ((r7 instanceof ILinkPlayerInfoBridge) == true) goto L13;
        r7 = null;
    L13:
        ILinkPlayerInfoBridge r11 = (ILinkPlayerInfoBridge) r7;
        if (r11 == null) goto L18;
        IBaseUser r12 = r11.getUser();
        if (r12 == null) goto L18;
        String r13 = r12.getIdString();
    L20:
        if (Intrinsics.areEqual(r13, r8) == false) goto L22;
        r0.element = r2;
    L18:
        r13 = null;
    L22:
        r2 = r2 + 1;
    L23:
        int r14 = r0.element;
        if (r14 >= 0) goto L26;
        return;
    L26:
        if (r14 >= this.z.size()) goto L62;
        Object r15 = this.z.get(r0.element);
        if ((r15 instanceof ILinkPlayerInfoBridge) == false) goto L32;
        r4 = r15;
    L32:
        ILinkPlayerInfoBridge r16 = (ILinkPlayerInfoBridge) r4;
        if (r16 == null) goto L52;
        r16.setHasApplied(true);
        goto L52
    }

    public final void da0(List<? extends ILinkPlayerInfoBridge> r4) {
        this.y.addAll(r4);
        int r5 = this.x;
        if (r5 != 0) goto L10;
        int r6 = this.y.size();
        int r1 = this.w;
        if (r6 > r1) goto L8;
        r1 = this.y.size();
    L8:
        ea0(this.y.subList(0, r1));
        return;
    L10:
        int r7 = r5 + ((int) this.v);
        if (r7 <= this.y.size()) goto L13;
        r7 = this.y.size();
    L13:
        ea0(this.y.subList(0, r7));
    }

    public final void ea0(List<? extends ILinkPlayerInfoBridge> r6) {
        this.x = r6.size();
        if (fj0.e.g(this.t) == true) goto L5;
    L9:
        MultiTypeAdapter r0 = this.u;
        if (r0 != null) goto L12;
    L29:
        if (this.x > 0) goto L31;
        boolean r7 = true;
    L33:
        if (r7 == true) goto L35;
    L43:
        MultiTypeAdapter r8 = this.u;
        if (r8 == null) goto L46;
        r8.notifyDataSetChanged();
    L46:
        RelativeLayout r9 = this.g;
        if (r9 == null) goto L49;
        r9.setVisibility(8);
    L49:
        LinearLayout r10 = this.k;
        if (r10 == null) goto L54;
        r10.setVisibility(0);
        return;
    L54:
        return;
    L35:
        if (this.G == true) goto L43;
        RelativeLayout r11 = this.g;
        if (r11 == null) goto L39;
        r11.setVisibility(0);
    L39:
        LinearLayout r12 = this.k;
        if (r12 == null) goto L53;
        r12.setVisibility(8);
        return;
    L53:
        return;
    L31:
        r7 = false;
        goto L33
    L12:
        if (this.G == false) goto L27;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.c r2 = MultiRevenueDataContext.a.c();
        if (r2 == null) goto L27;
        if (r2.isPaidLinkOn() == true) goto L27;
        LinkedList r3 = new LinkedList();
        if (r6.isEmpty() == false) goto L25;
        r3.add(new zf0.f.a(this.I, this.e.g()));
        if (this.I != WaitingListType.PAID.ordinal()) goto L23;
        r3.add(new zf0.d(4));
    L26:
        r6 = r3;
        goto L27
    L23:
        if (this.I != WaitingListType.NORMAL.ordinal()) goto L26;
        r3.add(new zf0.d(6));
        goto L26
    L25:
        r3.addAll(r6);
        r3.add(0, new zf0.f.a(this.I, this.e.g()));
    L27:
        r0.a = r6;
        goto L29
    L5:
        if (fj0.e.f() == false) goto L9;
        MultiTypeAdapter r13 = this.u;
        if (r13 == null) goto L29;
        r13.a = this.z;
        goto L29
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        Room r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        this.t = r3;
        if (r3 == null) goto L5;
        String r4 = r3.getOwnerUserIdString();
    L6:
        this.A = Intrinsics.areEqual(r4, jc1.k.n(IMiddlewareUserService.class).user().n());
        this.B = jc1.k.n(IMiddlewareUserService.class).user().c();
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        this.i = (LinearLayout) r6.findViewById(2131371744);
        this.g = (RelativeLayout) r6.findViewById(2131377976);
        this.h = (TextView) r6.findViewById(2131384133);
        LinearLayout r8 = (LinearLayout) r6.findViewById(2131377975);
        if (r8 == null) goto L5;
        r8.setOnClickListener(new d(this));
    L5:
        TextView r9 = this.h;
        if (r9 == null) goto L8;
        r9.setOnClickListener(new e(this));
    L8:
        this.f = r6.findViewById(2131384731);
        MultiTypeAdapter r10 = new MultiTypeAdapter();
        this.u = r10;
        RecyclerView r0 = this.f;
        if (r0 == null) goto L11;
        r0.setAdapter(r10);
    L11:
        RecyclerView r11 = this.f;
        if (r11 == null) goto L14;
        r11.setLayoutManager(new LinearLayoutManager(getContext()));
    L14:
        MultiTypeAdapter r12 = this.u;
        if (r12 == null) goto L17;
        r12.a = new ArrayList();
    L17:
        MultiTypeAdapter r13 = this.u;
        if (r13 == null) goto L20;
        r13.z2(ILinkPlayerInfoBridge.class, new LinkApplyUserViewBinder(this.A, new AnonymousClass3(this)));
    L20:
        MultiTypeAdapter r14 = this.u;
        if (r14 == null) goto L26;
        com.bytedance.android.livesdk.common.c r3 = this.e;
        if ((r3 instanceof com.bytedance.android.live.liveinteract.linkpanel.list.a) == true) goto L25;
        r3 = null;
    L25:
        r14.z2(zf0.m.a.class, new zf0.m((com.bytedance.android.live.liveinteract.linkpanel.list.a) r3, this.z));
    L26:
        MultiTypeAdapter r15 = this.u;
        if (r15 == null) goto L29;
        r15.z2(zf0.f.a.class, new zf0.f(new AnonymousClass4(this), null, 6));
    L29:
        MultiTypeAdapter r16 = this.u;
        if (r16 == null) goto L32;
        r16.z2(zf0.d.class, new zf0.k());
    L32:
        this.k = (LinearLayout) r6.findViewById(2131377971);
        this.l = (LinearLayout) r6.findViewById(2131377968);
        this.n = (CustomOnlineFriendsCircleContainer) r6.findViewById(2131380332);
        this.o = (TextView) r6.findViewById(2131377969);
        this.p = (ImageView) r6.findViewById(2131377970);
        this.m = (TextView) r6.findViewById(2131377967);
        this.q = (ViewGroup) r6.findViewById(2131381824);
        this.r = (TextView) r6.findViewById(2131381823);
        this.s = r6.findViewById(2131381822);
        TextView r17 = this.r;
        if (r17 == null) goto L35;
        r17.setOnClickListener(new f(this));
    L35:
        View r18 = this.s;
        if (r18 == null) goto L38;
        r18.setOnClickListener(new g(this));
    L38:
        LinearLayout r19 = this.l;
        if (r19 == null) goto L42;
        r19.setOnClickListener(new h(this));
    L42:
        if (fj0.e.g(this.t) == true) goto L44;
    L54:
        LinearLayout r20 = this.k;
        if (r20 == null) goto L57;
        r20.setVisibility(8);
    L57:
        LinearLayout r21 = this.l;
        if (r21 == null) goto L60;
        r21.setVisibility(0);
    L60:
        LinearLayout r22 = this.l;
        if (r22 == null) goto L64;
        r22.setClickable(true);
    L64:
        if (this.A == false) goto L74;
        if (Y90() == false) goto L68;
        ((IMultiPkAudienceLinkOutService) jc1.k.n(IMultiPkAudienceLinkOutService.class)).addPkGuestListener(this.L);
    L83:
        PaidLinkMicContext r23 = PaidLinkMicContext.Companion.getContext();
        if (r23 == null) goto L93;
        com.bytedance.live.datacontext.m<Boolean> r24 = r23.getRefreshWaitingUserList();
        if (r24 == null) goto L94;
        Observable r25 = r24.a();
        if (r25 == null) goto L95;
        Disposable r26 = r25.subscribe(new com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.a(this));
        if (r26 == null) goto L96;
        RxUtilKt.c(r26, this.J);
        return;
    L96:
        return;
    L95:
        return;
    L94:
        return;
    L93:
        return;
    L68:
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.d r27 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (r27 == null) goto L83;
        com.bytedance.android.live.liveinteract.plantform.core.f r28 = r27.X4();
        if (r28 == null) goto L83;
        r28.a(this.K);
        goto L83
    L74:
        if (this.B == false) goto L83;
        if (Y90() == false) goto L78;
        ((IMultiPkAudienceLinkOutService) jc1.k.n(IMultiPkAudienceLinkOutService.class)).addPkGuestListener(this.L);
        goto L83
    L78:
        com.bytedance.android.live.liveinteract.plantform.base.c.i0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.c r29 = com.bytedance.android.live.liveinteract.plantform.base.c.a.a();
        if (r29 == null) goto L83;
        com.bytedance.android.live.liveinteract.plantform.core.e r30 = r29.A0();
        if (r30 == null) goto L83;
        r30.a(this.K);
        goto L83
    L44:
        if (fj0.e.f() == false) goto L54;
        LinearLayout r31 = this.k;
        if (r31 == null) goto L48;
        r31.setVisibility(0);
    L48:
        LinearLayout r32 = this.l;
        if (r32 == null) goto L51;
        r32.setVisibility(8);
    L51:
        LinearLayout r33 = this.l;
        if (r33 == null) goto L64;
        r33.setClickable(false);
        goto L64
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565512, r3, false);
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.list.BaseTalkApplyListContract$View
    public final void V90(List<? extends ILinkPlayerInfoBridge> r2, long r3, boolean r5, String r6, String r7, boolean r8, int r9, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "linkPlayerInfos");
        Intrinsics.checkNotNullParameter(r6, "nextCursor");
        Intrinsics.checkNotNullParameter(r7, "reqSource");
        if (getView() != null) goto L6;
        return;
    L6:
        if (this.I != WaitingListType.UNKNOWN.ordinal()) goto L8;
        this.I = r9;
    L8:
        this.G = r10;
        if (r10 == false) goto L13;
        TextView r12 = this.m;
        if (r12 == null) goto L20;
        UtilityKotlinExtentionsKt.t(r12);
    L20:
        if (this.x != 0) goto L24;
        com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.h r13 = this.j;
        if (r13 == null) goto L24;
        r13.zs();
    L24:
        this.D = r5;
        this.E = r6;
        LinearLayout r14 = this.i;
        if (r14 == null) goto L28;
        r14.setVisibility(8);
    L28:
        if (fj0.e.g(this.t) == true) goto L30;
    L60:
        da0(r2);
        fa0();
        this.F = false;
    L61:
        if (r8 == false) goto L69;
        ViewGroup r4 = this.q;
        if (r4 == null) goto L65;
        r4.setVisibility(0);
    L65:
        IRoom r15 = this.t;
        if (r15 == null) goto L69;
        long r16 = r15.getRoomId();
        int r17 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        LinkedHashMap r18 = new LinkedHashMap();
        r18.put("room_id", Long.valueOf(r16));
        r18.put("total_count", Long.valueOf(r3));
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("apply_panel_show_paid_link_guide", r18);
    L69:
        if (this.H == true) goto L79;
        this.H = true;
        Z90();
        return;
    L79:
        return;
    L30:
        if (fj0.e.f() == false) goto L60;
        this.z.clear();
        this.z.addAll(r2);
        Iterator<T> r19 = this.z.iterator();
        int r20 = 0;
    L33:
        if (r19.hasNext() == false) goto L40;
        Object r110 = r19.next();
        if ((r110 instanceof ILinkPlayerInfoBridge) == false) goto L33;
        if (((ILinkPlayerInfoBridge) r110).isAddPrice() == false) goto L33;
        r20 = r20 + 1;
        goto L33
    L40:
        if (r20 <= 0) goto L45;
        SimpleDateFormat r111 = com.bytedance.android.live.liveinteract.linkpanel.util.o.a;
        this.z.add(0, new zf0.m.a(true, 1));
        int r21 = r20 + 1;
        if (this.z.size() <= r21) goto L59;
        this.z.add(r21, new zf0.m.a(true, 2));
    L59:
        da0(r2);
        goto L61
    L45:
        if (g1.d() == false) goto L51;
        cj0.c r22 = PaidLinkMicContext.Companion.a();
        if (r22 == null) goto L51;
        if (r22.isPaidLinkOn() != true) goto L51;
        boolean r23 = true;
    L52:
        if (r23 == false) goto L57;
        if ((!this.z.isEmpty()) == false) goto L59;
        this.z.add(0, new zf0.m.a(false, 3));
        goto L59
    L57:
        if (this.z.size() <= 0) goto L59;
        this.z.add(0, new zf0.m.a(false, 2));
    L51:
        r23 = false;
        goto L52
    L13:
        TextView r112 = this.m;
        if (r112 == null) goto L16;
        UtilityKotlinExtentionsKt.w(r112);
    L16:
        TextView r113 = this.m;
        if (r113 == null) goto L20;
        r113.setText(s1.C(2131922719, new Object[]{Long.valueOf(r3)}));
        goto L20
    }
}
